package framework.frameworkUtilies;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import framework.startup.Startup;

public class PropertiesConfigurator
{

	static Properties		prop	= null;
	public static Logger	logger	= Logger.getLogger(PropertiesConfigurator.class);

	public static Properties loadProperties() throws Exception
	{

		InputStream input = new FileInputStream("./Resources/config.properties");
		prop = new Properties();
		prop.load(input);
		for (Object key : prop.keySet())
		{
			Startup.configMap.put(key.toString(), prop.get(key).toString());
		}
		logger.info("loadProperties  :  " + Startup.configMap);

		return prop;
	}

	public static Properties loadSystemEnvVariable() throws Exception
	{
		for (String key : System.getenv().keySet())
		{
			Startup.configMap.put(key, System.getenv(key));
		}
		logger.info("loadSystemEnvVariable  :  " + Startup.configMap);
		return null;
	}

}
