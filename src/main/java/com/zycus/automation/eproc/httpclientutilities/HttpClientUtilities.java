/**
 * 
 */
package com.zycus.automation.eproc.httpclientutilities;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.log4j.Logger;

/**
 * @author ankita.sawant
 *
 */
public class HttpClientUtilities
{

	static Logger logger = Logger.getLogger(HttpClientUtilities.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get HTTPClient <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @return </b> <br>
	 */
	public static HttpClient getClient()
	{
		HttpClient client = null;
		try
		{
			SSLContext context = SSLContext.getInstance("SSL");
			context.init(null, new TrustManager[] { new X509TrustManager() {

				@Override
				public X509Certificate[] getAcceptedIssuers()
				{
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException
				{
					// TODO Auto-generated method stub

				}

				@Override
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException
				{
					// TODO Auto-generated method stub

				}
			} }, new SecureRandom());

			org.apache.http.conn.ssl.SSLSocketFactory sf = new org.apache.http.conn.ssl.SSLSocketFactory(context);
			Scheme scheme = new Scheme("https", 443, sf);
			SchemeRegistry schemeRegistry = new SchemeRegistry();
			schemeRegistry.register(scheme);

			ClientConnectionManager connectionManager = new SingleClientConnManager(schemeRegistry);
			client = new DefaultHttpClient(connectionManager);
		}
		catch (NoSuchAlgorithmException e)
		{
			logger.error("NoSuchAlgorithmException While creating HTTPClient : " + e, e);
		}
		catch (KeyManagementException e)
		{
			logger.error("KeyManagementException While creating HTTPClient : " + e, e);
		}
		catch (Exception e)
		{
			logger.error("Exception While creating HTTPClient : " + e, e);
		}

		return client;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Print request/response messages and
	 * headers <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param url </b> <br>
	 */
	public static void printRequestResponse(String url)
	{
		try
		{
			HttpClient client = getClient();

			HttpGet request = new HttpGet(url);

			logger.info("###############################################################");
			logger.info("URL : " + url);
			logger.info("REQUEST : " + request.toString());
			request.setHeader("pragma",
				"akamai-x-cache-on, akamai-x-cache-remote-on, akamai-x-check-cacheable, akamai-x-get-cache-key, akamai-x-get-extracted-values, akamai-x-get-nonces, akamai-x-get-ssl-client-session-id, akamai-x-get-true-cache-key, akamai-x-serial-no, akamai-x-get-request-id");
			logger.info("REQUEST Method : " + request.getMethod());
			logger.info("----------- REQUEST HEADERS ----------");
			Header[] headers = request.getAllHeaders();
			String log = "";
			for (Header header : headers)
			{
				log += header.getName() + " : " + header.getValue() + "\n";
			}
			logger.info("\n" + log);
			logger.info("---------------------------------------");

			// response
			HttpResponse response = client.execute(request);
			logger.info("RESPONSE CODE : " + response.getStatusLine().getStatusCode());
			ResponseHandler<String> handler = new BasicResponseHandler();
			logger.info("RESPONSE : " + handler.handleResponse(response));
			logger.info("----------- RESPONSE HEADERS ----------");
			log = "";
			Header[] headers1 = response.getAllHeaders();
			for (Header header : headers1)
			{
				log += header.getName() + " : " + header.getValue() + "\n";
			}
			logger.info("\n" + log);
			logger.info("---------------------------------------");
			logger.info("###############################################################");

		}
		catch (ClientProtocolException e)
		{
			logger.error("ClientProtocolException While printing request/response : " + e, e);
		}
		catch (IOException e)
		{
			logger.error("IOException While printing request/response : " + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Print request/response messages and
	 * headers <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param url </b> <br>
	 */
	public static String getResponse(String url, Map<String, String> requestHeaders)
	{
		HttpClient client = null;
		HttpGet request = null;
		HttpResponse response = null;
		String responseInString = null;
		try
		{
			client = getClient();
			request = new HttpGet(url);

			logger.info("###############################################################");
			logger.info("URL : " + url);
			logger.info("REQUEST : " + request.toString());
			for (Map.Entry<String, String> map : requestHeaders.entrySet())
			{
				request.setHeader(map.getKey(), map.getValue());
			}

			// response
			response = client.execute(request);
			logger.info("RESPONSE CODE : " + response.getStatusLine().getStatusCode());
			ResponseHandler<String> handler = new BasicResponseHandler();
			responseInString = handler.handleResponse(response);
			logger.info("RESPONSE : " + responseInString);
			logger.info("###############################################################");
		}
		catch (ClientProtocolException e)
		{
			logger.error("ClientProtocolException While printing request/response : " + e, e);
		}
		catch (IOException e)
		{
			logger.error("IOException While printing request/response : " + e, e);
		}
		return responseInString;
	}
}
