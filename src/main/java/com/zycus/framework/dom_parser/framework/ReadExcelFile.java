package com.zycus.framework.dom_parser.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;

public class ReadExcelFile
{
	static Logger			logger		= Logger.getLogger(ReadExcelFile.class);

	static Map<String, By>	elements	= new HashMap<String, By>();

	public ReadExcelFile()
	{

	}

	public Map<String, UI_Elements> readExcelFileForObject(String fileName) throws IOException
	{
		FileInputStream file = new FileInputStream(new File(fileName));

		Map<String, UI_Elements> map = new HashMap<String, UI_Elements>();
		// Create Workbook instance holding reference to .xls file
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		HSSFSheet sheet = workbook.getSheetAt(0);

		UI_Elements ui;

		// Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext())
		{
			Row row = rowIterator.next();

			String key = row.getCell(0).getStringCellValue();
			String locator = row.getCell(1).getStringCellValue();
			String value = row.getCell(2).getStringCellValue();

			ui = new UI_Elements();
			if (locator.equals("id"))
			{
				ui.setBy(By.id(value));
				ui.setFileName(fileName);
				ui.setKey(key);
				map.put(key, ui);
			}
			else if (locator.equals("className"))
			{
				ui.setBy(By.className(value));
				ui.setFileName(fileName);
				ui.setKey(key);
				map.put(key, ui);
			}
			else if (locator.equals("cssSelector"))
			{
				ui.setBy(By.cssSelector(value));
				ui.setFileName(fileName);
				ui.setKey(key);
				map.put(key, ui);
			}
			else if (locator.equals("xpath"))
			{
				ui.setBy(By.xpath(value));
				ui.setFileName(fileName);
				ui.setKey(key);
				map.put(key, ui);
			}
			else if (locator.equals("name"))
			{
				ui.setBy(By.name(value));
				ui.setFileName(fileName);
				ui.setKey(key);
				map.put(key, ui);
			}
			else if (locator.equals("linkText"))
			{
				ui.setBy(By.linkText(value));
				ui.setFileName(fileName);
				ui.setKey(key);
				map.put(key, ui);
			}
		}
		file.close();
		return map;

	}

	public Map<String, By> readExcelFile(String fileName) throws IOException
	{
		FileInputStream file = new FileInputStream(new File(fileName));

		// Create Workbook instance holding reference to .xls file
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		HSSFSheet sheet = workbook.getSheetAt(0);

		// Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext())
		{
			Row row = rowIterator.next();

			String key = row.getCell(0).getStringCellValue();
			String locator = row.getCell(1).getStringCellValue();
			String value = row.getCell(2).getStringCellValue();

			if (locator.equals("id"))
			{
				elements.put(key, By.id(value));
			}
			else if (locator.equals("className"))
			{
				elements.put(key, By.className(value));
			}
			else if (locator.equals("cssSelector"))
			{
				elements.put(key, By.cssSelector(value));
			}
			else if (locator.equals("xpath"))
			{
				elements.put(key, By.xpath(value));
			}
			else if (locator.equals("name"))
			{
				elements.put(key, By.name(value));
			}
			else if (locator.equals("linkText"))
			{
				elements.put(key, By.linkText(value));
			}

		}
		file.close();
		return elements;

	}

	public By getBy(Map<String, By> map, String key)
	{

		return map.get(key);

	}

	public Map<String, String> loadElements(String fileName) throws IOException
	{
		FileInputStream file = new FileInputStream(new File(fileName));

		Map<String, String> map = new HashMap<String, String>();
		// Create Workbook instance holding reference to .xls file
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		HSSFSheet sheet = workbook.getSheetAt(0);

		// Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext())
		{
			Row row = rowIterator.next();

			String key = row.getCell(0).getStringCellValue();
			String locator = row.getCell(1).getStringCellValue();
			String value = row.getCell(2).getStringCellValue();

			if (locator.equals("id"))
			{
				map.put(key, By.id(value).toString());
			}
			else if (locator.trim().equals("className"))
			{
				map.put(key, By.className(value).toString());
			}
			else if (locator.equals("cssSelector"))
			{
				map.put(key, By.cssSelector(value).toString());
			}
			else if (locator.equals("xpath"))
			{
				map.put(key, By.xpath(value).toString());
			}
			else if (locator.equals("name"))
			{
				map.put(key, By.name(value).toString());
			}
			else if (locator.equals("linkText"))
			{
				map.put(key, By.linkText(value).toString());
			}

		}
		file.close();
		return map;
	}
}
