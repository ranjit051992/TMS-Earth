package com.zycus.framework.framework_version_2_4.framework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.json.JSONObject;

/**
 * Contains some static utilities to act on the Grid i.e. HUB <-> NODE
 * configuration.
 * 
 * @author aryasindhu.sahu
 *
 */
@SuppressWarnings("deprecation")
public class GridUtil
{

	/**
	 * Returns the Node IP and PORT which is bound to this sessionId.
	 * 
	 * @param sessionId
	 * @return String[]
	 */
	public static String[] getNodeIPAndPort(String sessionId)
	{
		String hubURL = ConfigProperty.getConfig("Hub_URL");
		String hostName = hubURL.substring(2 + hubURL.indexOf("//"), hubURL.lastIndexOf(":"));
		int port = Integer.parseInt(hubURL.substring(1 + hubURL.lastIndexOf(":"), hubURL.indexOf("/wd")));

		String[] nodeIPAndPort = new String[2];
		String errorMsg = "Failed to acquire remote webdriver node and port info. Root cause: ";
		String endPointURL = "http://" + hostName + ":" + port + "/grid/api/testsession?session=" + sessionId;

		try
		{
			JSONObject object = new JSONObject(getResponseFromNode(endPointURL));
			URL myURL = new URL(object.getString("proxyId"));
			if ((myURL.getHost() != null) && (myURL.getPort() != -1))
			{
				nodeIPAndPort[0] = myURL.getHost();
				nodeIPAndPort[1] = Integer.toString(myURL.getPort());
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException(errorMsg, e);
		}
		return nodeIPAndPort;
	}

	private static String getResponseFromNode(String url)
	{
		DefaultHttpClient client = null;
		try
		{
			URL sessionURL = new URL(url);
			HttpHost host = new HttpHost(sessionURL.getHost(), sessionURL.getPort());
			client = new DefaultHttpClient();

			BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest("POST", sessionURL.toExternalForm());
			HttpResponse response = client.execute(host, r);
			return fetchStringFromResponse(response);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			client.close();
		}
	}

	private static String fetchStringFromResponse(HttpResponse resp)
	{
		try
		{
			BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
			StringBuffer s = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null)
			{
				s.append(line).append("\n");
			}
			rd.close();
			return s.toString();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

}
