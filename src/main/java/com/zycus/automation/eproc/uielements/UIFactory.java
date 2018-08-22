package com.zycus.automation.eproc.uielements;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.openqa.selenium.By;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.exception.UIElementException;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class UIFactory
{
	static Logger logger = Logger.getLogger(UIFactory.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	// final public static Map<String, UI_Elements> UI_MAP = loadMap();

	public static Map<String, UI_Elements> UI_MAP = new HashMap<String, UI_Elements>();

	public static Map<String, UI_Elements> loadMap()
	{
		try
		{
			logger.info("Loading UI Elements Excels for eProc ....");
			ReadExcelFile excelFile = new ReadExcelFile();
			Map<String, UI_Elements> map = new LinkedHashMap<String, UI_Elements>();
			/*
			 * File folder = new File(IConstants.UI); File[] listOfFiles =
			 * folder.listFiles(); List<String> uiFileNames = new
			 * ArrayList<String>(); for (File fileName : listOfFiles) { if
			 * (fileName.isFile()) { uiFileNames.add(fileName.toString()); } }
			 * 
			 * for (String uiFile : uiFileNames) {
			 * map.putAll(excelFile.readExcelFileForObject(uiFile)); }
			 */

			File folder = new File(IConstants.UI);
			File[] listOfFiles = folder.listFiles();
			List<String> uiFileNames = new ArrayList<String>();
			for (File file : listOfFiles)
			{
				if (file.isDirectory())
				{
					if (!file.getName().contains(".svn"))
					{
						File[] files = file.listFiles();
						for (File fileName : files)
						{
							if (fileName.isFile())
							{
								uiFileNames.add(fileName.toString());
							}
						}
					}
				}
				if (file.isFile())
				{
					uiFileNames.add(file.toString());
				}
			}

			for (String uiFile : uiFileNames)
			{
				map.putAll(excelFile.readExcelFileForObject(uiFile));
			}
			return map;
		}
		catch (UIElementException e)
		{
			logger.error(e.toString(), e);
		}
		return null;
	}

	public static Map<String, UI_Elements> loadMap(String path)
	{
		try
		{

			//UI_Elements ui = new UI_Elements();
			Map<String, UI_Elements> map = new LinkedHashMap<String, UI_Elements>();

			//Connection variables load values from DB			
			String query = "select * from UI_Elements";

			//to load jdbc class
			Class.forName("com.mysql.jdbc.Driver");

			//to obtain db connection
			Connection con = DriverManager.getConnection(ConfigProperty.getConfig("DB_URL"), ConfigProperty.getConfig("DB_Username"), ConfigProperty.getConfig("DB_Password"));

			logger.info("Loading all UI Elements from DB");

			//to execute statement on db
			Statement stmt = con.createStatement();

			//storing result of executed query
			ResultSet rs = stmt.executeQuery(query);

			//iteratiing entire result and storing it in a UI_Element map
			while (rs.next())
			{
				UI_Elements ui = new UI_Elements();

				String key = rs.getString(3);
				String locator = rs.getString(4).trim();
				String value = rs.getString(5).trim();

				ui.setProduct(rs.getString(1).trim());
				ui.setFileName(rs.getString(2).trim());
				ui.setKey(key);
				ui.setValue(value);

				if (locator.equalsIgnoreCase("id"))
				{
					ui.setBy(By.id(value));
				}
				else if (locator.toLowerCase().contains("className".toLowerCase()))
				{
					ui.setBy(By.className(value));
				}
				else if (locator.toLowerCase().contains("cssSelector".toLowerCase()))
				{
					ui.setBy(By.cssSelector(value));
				}
				else if (locator.toLowerCase().contains("xpath".toLowerCase()))
				{
					ui.setBy(By.xpath(value));
				}
				else if (locator.toLowerCase().contains("name".toLowerCase()))
				{
					ui.setBy(By.name(value));
				}
				else if (locator.toLowerCase().contains("linkText".toLowerCase()))
				{
					ui.setBy(By.linkText(value));
				}
				else
				{
					logger.error("Incorrect option provided to locate element. Key:" + key + " By: " + locator);

				}
				map.put(key, ui);
			}

			con.close();

			return map;
		}
		catch (ClassNotFoundException e)
		{
			logger.error("ClassNotFoundException while loading MySql driver" + e.toString(), e);
		}
		catch (SQLException e)
		{
			logger.error("SQLException cought while obtaining DB connection" + e.toString(), e);
		}
		catch (Exception e)
		{
			logger.error(e.toString(), e);
		}
		return null;
	}

	public static UI_Elements getElements(String element)
	{
		return UI_MAP.get(element);
	}

	/**
	 *
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get UI elements object from By value
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param by </font><b><br>
	 * @return </b> <br>
	 */
	public static UI_Elements getUIElement(By by)
	{
		UI_Elements elements = new UI_Elements();
		elements.setBy(by);
		return elements;
	}

	/**************************************************************************************************************************************************/
	/**************************************************************************************************************************************************/
	/**************************************************************************************************************************************************/
	/**************************************************************************************************************************************************/
	/**************************************************************************************************************************************************/
	/**************************************************************************************************************************************************/
	/**************************************************************
	 * JUNIT TESTCASE FOR METHODS
	 **********************************************************/

	@Test
	public void testLoadMapFunction()
	{
		File folder = new File(IConstants.UI);
		File[] listOfFiles = folder.listFiles();
		List<String> uiFileNames = new ArrayList<String>();
		int counter = 0;
		for (File fileName : listOfFiles)
		{
			if (fileName.isFile())
			{
				System.out.println(++counter + " )" + fileName.toString());
				uiFileNames.add(fileName.toString());
			}

		}
	}
}
