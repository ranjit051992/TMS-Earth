package com.zycus.automation.eproc.uielements;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;

import com.zycus.automation.exception.UIElementException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class ReadExcelFile
{
	static Logger			logger		= Logger.getLogger(ReadExcelFile.class);

	static Map<String, By>	elements	= new HashMap<String, By>();

	public ReadExcelFile()
	{

	}

	public Map<String, UI_Elements> readExcelFileForObject(String fileName) throws UIElementException
	{
		try
		{
			FileInputStream file = new FileInputStream(new File(fileName));

			Map<String, UI_Elements> map = new HashMap<String, UI_Elements>();

			// to create workbook instance
			// Workbook workbook = null;
			// Create Workbook instance holding reference to .xls file
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			// XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);
			// XSSFSheet sheet = workbook.getSheetAt(0);

			UI_Elements ui;

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Cell keyCell = row.getCell(0);
				Cell locatorCell = row.getCell(1);
				Cell valueCell = row.getCell(2);

				/*
				 * if (keyCell.getCellType() == 0) {
				 * keyCell.setCellType(Cell.CELL_TYPE_STRING); } if
				 * (locatorCell.getCellType() == 0) {
				 * locatorCell.setCellType(Cell.CELL_TYPE_STRING); } if
				 * (valueCell.getCellType() == 0) {
				 * valueCell.setCellType(Cell.CELL_TYPE_STRING); }
				 */

				String key = (keyCell != null) ? keyCell.getStringCellValue() : "null";
				String locator = (locatorCell != null) ? locatorCell.getStringCellValue() : "null";
				String value = (valueCell != null) ? valueCell.getStringCellValue() : "null";

				/*
				 * Cell curCell = cellIterator.next(); String status =
				 * curCell.getStringCellValue();
				 */
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
			if (file != null)
			{
				file.close();
			}
			return map;
		}
		catch (IOException e)
		{
			throw new UIElementException("\nUNABLE TO FIND THE FILE : " + fileName + " \n" + e, e);
		}
		catch (Exception e)
		{
			throw new UIElementException("\nEXCEPTION IN GETTING UI ELEMENTS FROM EXECL FOR FILE : " + fileName + " \n" + fileName + "\n" + e, e);
		}

	}

	public Map<String, By> readExcelFile(String fileName) throws UIElementException
	{
		try
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
				// For each row, iterate through all the columns

				Cell keyCell = row.getCell(0);
				Cell locatorCell = row.getCell(1);
				Cell valueCell = row.getCell(2);

				String key = (keyCell != null) ? keyCell.getStringCellValue() : "null";
				String locator = (locatorCell != null) ? locatorCell.getStringCellValue() : "null";
				String value = (valueCell != null) ? valueCell.getStringCellValue() : "null";

				/*
				 * Cell curCell = cellIterator.next(); String status =
				 * curCell.getStringCellValue();
				 */

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
		catch (IOException e)
		{
			throw new UIElementException("UNABLE TO FIND THE FILE", e);
		}
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
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext())
			{
				Cell cell = cellIterator.next();
				String key = cell.getStringCellValue();
				String locator = cellIterator.next().getStringCellValue();
				String value = cellIterator.next().getStringCellValue();

				/*
				 * Cell curCell = cellIterator.next(); String status =
				 * curCell.getStringCellValue();
				 */
				if (locator.equals("id"))
				{
					map.put(key, By.id(value).toString());
				}
				else if (locator.equals("className"))
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
		}

		return map;
	}

}
