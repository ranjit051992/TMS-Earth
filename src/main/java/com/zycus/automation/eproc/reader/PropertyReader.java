package com.zycus.automation.eproc.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

public class PropertyReader
{
	static Logger				logger				= Logger.getLogger(PropertyReader.class);

	private static String		baseFilePath		= "input/testdata_properties/";
	private static String		datafileName		= "resources/properties/data.properties";
	private static String		messagefileName		= "resources/properties/message.properties";
	private static String		emailFileName		= "resources/properties/email.properties";
	private static String		monitoringFileName	= "resources/properties/adminMonitoring.properties";

	// private static String configfileName = "input/config.properties";
	public static Properties	dataProperty		= new Properties();
	public static Properties	messageProperty		= new Properties();
	public static Properties	emailProperty		= loadProperties(emailFileName);
	public static Properties	monitoringProperty	= loadProperties(monitoringFileName);

	// public static Properties configProperty = new Properties();

	// changes made by ankita
	public static void loadProperties() throws TestCaseException
	{
		try
		{
			logger.info("Loading all properties ....");
			FileInputStream fileInputStream = null;
			// data property
			fileInputStream = new FileInputStream(new File(datafileName));
			dataProperty.load(fileInputStream);

			// message property
			fileInputStream = new FileInputStream(new File(messagefileName));
			messageProperty.load(fileInputStream);

			// admin property
			fileInputStream = new FileInputStream(new File(monitoringFileName));
			monitoringProperty.load(fileInputStream);

			/*
			 * //config property fileInputStream = new FileInputStream(new
			 * File(configfileName)); configProperty.load(fileInputStream);
			 */
		}
		catch (IOException e)
		{
			throw new TestCaseException("Error loading Data Property and Message Property", e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To load property from specific file <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param fileName </font><b><br>
	 * @param propertyName </font><b><br>
	 * @return </font><b><br>
	 * @throws TestCaseException </b> <br>
	 * 
	 * @throws IOException
	 */
	public static String getPropertyFrom(String fileName, String propertyName) throws IOException
	{
		Properties properties = null;
		FileInputStream fileInputStream = null;
		try
		{
			logger.info("Loading peroperties of " + fileName + " ....");
			fileInputStream = new FileInputStream(new File(baseFilePath + fileName + ".properties"));
			properties = new Properties();
			if (fileInputStream != null)
			{
				properties.load(fileInputStream);
			}
			return properties.getProperty(propertyName);
		}
		catch (IOException e)
		{
			logger.error("Error loading properties from " + fileName, e);
			throw new IOException("Error loading properties from " + fileName, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To load property from specific file <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param fileName </font><b><br>
	 * @param propertyName </font><b><br>
	 * @return </font><b><br>
	 * @throws TestCaseException </b> <br>
	 * 
	 * @throws IOException
	 */
	public static Properties getProperties(String fileName) throws IOException
	{
		Properties properties = null;
		FileInputStream fileInputStream = null;
		try
		{
			logger.info("Loading peroperties of " + fileName + " ....");
			fileInputStream = new FileInputStream(new File(baseFilePath + fileName + ".properties"));
			properties = new Properties();
			if (fileInputStream != null)
			{
				properties.load(fileInputStream);
			}
			return properties;
		}
		catch (IOException e)
		{
			logger.error("Error loading properties from " + fileName, e);
			throw new IOException("Error loading properties from " + fileName, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To load properties from given file <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param name </font><b><br>
	 * @return </b> <br>
	 * 
	 * @throws IOException
	 */
	public static Properties loadProperties(String fileName)
	{
		Properties properties = new Properties();
		try
		{
			FileInputStream fileInputStream = new FileInputStream(new File(fileName));
			properties.load(fileInputStream);
		}
		catch (FileNotFoundException e)
		{
			logger.error("Error loading properties from " + fileName, e);
			// throw new FileNotFoundException("File not found : " + fileName);
		}
		catch (IOException e)
		{
			logger.error("Error loading properties from " + fileName, e);
			// throw new IOException("Error loading properties from " +
			// fileName, e);
		}
		return properties;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To set property in property file <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param fileName </font><b><br>
	 * @param propertyName </font><b><br>
	 * @param propertyValue </font><b><br>
	 * @return </font><b><br>
	 * @throws IOException </b> <br>
	 */
	public static Properties addProperty(Properties properties, String propertyName, String propertyValue) throws IOException
	{
		if (properties.getProperty(propertyName) != null)
		{
			if (!properties.getProperty(propertyName).equalsIgnoreCase(propertyValue) || properties.getProperty(propertyName) != null)
			{
				properties.setProperty(propertyName, propertyValue);
			}
		}
		else
		{
			properties.setProperty(propertyName, propertyValue);
		}
		return properties;
	}
}
