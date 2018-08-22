package com.zycus.automation.tenanatCreation.utilities.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.tenantCreation.bo.ElementBO;

public class UIElementUtility
{

	static Logger logger = Logger.getLogger(UIElementUtility.class);

	public static List<ElementBO> getElementList()
	{
		List<ElementBO> elementList = new LinkedList<ElementBO>();
		
		try
		{

			String dataFile;
			dataFile = ConfigProperty.getConfig("locatorFile");
			String fileName = ConfigProperty.getConfig("Input_Files_Location") + dataFile;
			FileInputStream fileInputStream = new FileInputStream(new File(fileName));
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			Row row = rowIterator.next();
			while (rowIterator.hasNext())
			{
				ElementBO elementBo = new ElementBO();
				row = rowIterator.next();
				if (row != null)
				{
					elementBo.setProductName(row.getCell(0).getStringCellValue());
					elementBo.setKey(row.getCell(2).getStringCellValue());
					elementBo.setLocatorType(row.getCell(3).getStringCellValue());
					elementBo.setValue(row.getCell(4).getStringCellValue());

				}
				// row = rowIterator.next();
				elementList.add(elementBo);
			}
			return elementList;
		}
		catch (Exception e)
		{
			System.out.println("Exception while reading locator file !!!" + e.getMessage());
		}
		return elementList;
	}

	public static void loadUiElements()
	{
		UIFactory.UI_MAP.clear();
		List<ElementBO> elementBoList = getElementList();

		for (ElementBO element : elementBoList)
		{
			UI_Elements ui = new UI_Elements();
			String key = element.getKey().trim();
			String locator = element.getLocatorType().trim();
			String value = element.getValue().trim();

			ui.setProduct(element.getProductName().trim());
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
			UIFactory.UI_MAP.put(key, ui);
		}
	}
}
