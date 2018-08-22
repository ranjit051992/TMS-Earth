package com.zycus.automation.eproc.excelDatabaseReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

import com.google.common.collect.Iterables;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class SettingMapReader
{
	static Logger	logger		= Logger.getLogger(SettingMapReader.class);

	static String	filePath	= ConfigProperty.getConfig("Input_Files_Location");
	static String	fileName	= ConfigProperty.getConfig("settingMapFileName");

	static String	finalPath	= filePath + fileName;
	
	public static Map<String, Map<String, String>>	settingMap			= new HashMap<String, Map<String, String>>();

	public static Map<String, Map<String, String>> getSettingMap()
	{
		//to store all setting values
		Map<String, Map<String, String>> settingMap = new HashMap<String, Map<String, String>>();

		try
		{
			logger.info("Setting map final path: " + finalPath);

			FileInputStream fileInputStream = new FileInputStream(new File(finalPath));
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			Row row = rowIterator.next();

			//to find total settings combinations
			int settingCombo = row.getPhysicalNumberOfCells();

			//starting counter from 4 as DefaultSetting index will start from 4
			for (int i = 3; i <= (settingCombo - 1); i++)
			{
				String settingName = row.getCell(i).toString();
				logger.info("Reading settings for Group: " + settingName + " from column: " + (i + 1));

				Map<String, String> singleSettingMap = new HashMap<String, String>();

				while (rowIterator.hasNext())
				{
					row = rowIterator.next();

					try
					{
						singleSettingMap.put(row.getCell(1).toString(), row.getCell(i).toString());
					}
					catch (NullPointerException e)
					{
						singleSettingMap.put(row.getCell(1).toString(), null);
					}
					catch (Exception e)
					{
						logger.info("Exception occured at Key: " + row.getCell(1).toString() + " Exception Details: " + e);
					}
				}

				settingMap.put(settingName, singleSettingMap);
				rowIterator = sheet.iterator();
				row = rowIterator.next();
			}

			logger.info("Setting Map Details:\n" + settingMap);

		}
		catch (Exception e)
		{
			logger.info("Exception occured while fetching setting map values: " + e);
		}

		return settingMap;

	}
}
