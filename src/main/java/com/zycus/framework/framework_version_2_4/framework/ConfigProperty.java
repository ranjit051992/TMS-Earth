package com.zycus.framework.framework_version_2_4.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

/**
 * 
 * @author aryasindhu.sahu
 *
 */
public class ConfigProperty
{

	private static String					filePath	= "input/TenantCreation/config.properties";
	private static HashMap<String, String>	configMap	= null;
	static Logger							logger		= Logger.getLogger(ConfigProperty.class);

	static
	{
		PropertyConfigurator.configure("log4j.properties");
		try
		{
			loadConfig();
		}
		catch (TestCaseException e)
		{
			logger.error("Error loading configuration", e);
		}
	}

	public static void configure(String filePath)
	{
		ConfigProperty.filePath = filePath;
	}

	public static String getConfig(String key)
	{
		return configMap.get(key);
	}

	public static void addConfig(String key, String value)
	{
		configMap.put(key, value);
	}

	public static HashMap<String, String> getConfigMap()
	{
		return configMap;
	}

	private static void loadConfig() throws TestCaseException
	{
		Properties properties = new Properties();
		configMap = new HashMap<String, String>();
		try
		{
			properties.load(new FileInputStream(filePath));
			Set<Object> keys = properties.keySet();
			for (Object key : keys)
			{
				String keyString = (String) key;
				configMap.put(keyString, properties.getProperty(keyString).trim());
			}
			loadFromSystem();
		}
		catch (IOException e)
		{
			throw new TestCaseException("Error loading configuration", e);
		}
	}

	public static void clearConfig()
	{
		if (configMap != null)
		{
			configMap.clear();
		}
	}

	private static void loadFromSystem()
	{
		Map<String, String> envParams = System.getenv();
		logger.info("Adding Environment Params :" + envParams);
		if (envParams != null)
		{
			for (String key : envParams.keySet())
			{
				if (!"".equalsIgnoreCase(envParams.get(key).trim()))
				{
					configMap.put(key, envParams.get(key).trim());
				}
			}
		}
	}
}
