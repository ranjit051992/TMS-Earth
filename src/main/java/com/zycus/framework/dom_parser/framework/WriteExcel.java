package com.zycus.framework.dom_parser.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zycus.automation.services.CommonServices;

public class WriteExcel
{

	static Logger logger = Logger.getLogger(WriteExcel.class);

	public void updateStatus(String fileName, Map<String, String> map) throws IOException
	{
		FileInputStream fileInputStream = new FileInputStream(new File(fileName));
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);

		Boolean flag = true;
		short bgColorIndex;
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		CellStyle style;
		while (rowIterator.hasNext())
		{
			Row row = rowIterator.next();

			String key = row.getCell(0).getStringCellValue();
			if (map.get(key) != null)
			{
				flag = false;
			}
			bgColorIndex = flag ? HSSFColor.LIGHT_GREEN.index // 42
				: HSSFColor.RED.index; // 10
			Cell currCell = row.getCell(3);
			style = workbook.createCellStyle();
			style.setAlignment(CellStyle.ALIGN_CENTER);
			style.setFillForegroundColor(bgColorIndex);
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			if (flag == false)
			{
				currCell.setCellValue("Element not Found");
			}
			else
			{
				currCell.setCellValue("Element Found");
			}
			currCell.setCellStyle(style);
			flag = true;
		}
		// Write the workbook in file system
		FileOutputStream out = new FileOutputStream(new File(fileName));
		workbook.write(out);
		out.close();

	}

	public void updateStatusOfElementNotFoundOnSamePage(String fileName, Map<String, String> map) throws IOException
	{
		FileInputStream fileInputStream = new FileInputStream(new File(fileName));
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);

		Boolean flag = true;
		short bgColorIndex;
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		CellStyle style;
		while (rowIterator.hasNext())
		{
			Row row = rowIterator.next();

			String status = row.getCell(3).getStringCellValue();

			if (status.equals("Element not Found"))
			{
				style = workbook.createCellStyle();
				String key = row.getCell(0).getStringCellValue();
				if (map.get(key) != null)
				{
					flag = false;
				}
				bgColorIndex = flag ? HSSFColor.LIGHT_GREEN.index // 42
					: HSSFColor.RED.index; // 10
				Cell currCell = row.getCell(3);

				style.setAlignment(CellStyle.ALIGN_CENTER);
				style.setFillForegroundColor(bgColorIndex);
				style.setFillPattern(CellStyle.SOLID_FOREGROUND);
				if (flag == false)
				{
					currCell.setCellValue("Element not Found");
				}
				else
				{
					currCell.setCellValue("Element Found");
				}
				currCell.setCellStyle(style);

			}
			flag = true;

		}
		// Write the workbook in file system
		FileOutputStream out = new FileOutputStream(new File(fileName));
		workbook.write(out);
		out.close();

	}

	public void addAjaxGeneratedElementsInExcel(String fileName, Map<String, String> data) throws IOException
	{
		FileInputStream fileInputStream = new FileInputStream(new File(fileName));
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);

		Row header = sheet.getRow(1);
		int index = 1;
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();

		for (Map.Entry<String, String> entry : data.entrySet())
		{

			header = sheet.createRow(index++);
			header.createCell(0).setCellValue(entry.getKey());
			int i = entry.getValue().indexOf(':');
			if (entry.getValue().contains("By.id"))
			{

				header.createCell(1).setCellValue("id");
			}
			else if (entry.getValue().contains("By.selector"))
			{
				header.createCell(1).setCellValue("cssSelector");
			}
			else if (entry.getValue().contains("By.className"))
			{
				header.createCell(1).setCellValue("className");
			}
			else if (entry.getValue().contains("By.xpath"))
			{
				header.createCell(1).setCellValue("xpath");
			}
			else if (entry.getValue().contains("By.linkText"))
			{
				header.createCell(1).setCellValue("linkText");
			}
			else if (entry.getValue().contains("By.name"))
			{
				header.createCell(1).setCellValue("name");
			}

			header.createCell(2).setCellValue(entry.getValue().substring(i + 1).trim());
			header.createCell(3).setCellValue("Element Found");

		}

		// called last as it is time consuming task
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);

		// Write the workbook in file system
		FileOutputStream out = new FileOutputStream(new File(fileName));
		workbook.write(out);
		out.close();
	}

	public void addAjaxGeneratedElementsInSingleExcel(String fileName, Map<String, String> data) throws IOException
	{
		FileInputStream fileInputStream = new FileInputStream(new File(fileName));
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);

		Row header = sheet.getRow(1);
		int index = 1;
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();

		for (Map.Entry<String, String> entry : data.entrySet())
		{

			header = sheet.createRow(index++);
			header.createCell(0).setCellValue(entry.getKey());
			int i = entry.getValue().indexOf(':');
			if (entry.getValue().contains("By.id"))
			{
				header.createCell(1).setCellValue("id");
			}
			else if (entry.getValue().contains("By.selector"))
			{
				header.createCell(1).setCellValue("cssSelector");
			}
			else if (entry.getValue().contains("By.className"))
			{
				header.createCell(1).setCellValue("className");
			}
			else if (entry.getValue().contains("By.xpath"))
			{
				header.createCell(1).setCellValue("xpath");
			}
			else if (entry.getValue().contains("By.linkText"))
			{
				header.createCell(1).setCellValue("linkText");
			}
			else if (entry.getValue().contains("By.name"))
			{
				header.createCell(1).setCellValue("name");
			}

			header.createCell(2).setCellValue(entry.getValue().substring(i + 1).trim());
			header.createCell(3).setCellValue("Element Found");

		}

		// called last as it is time consuming task
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);

		// Write the workbook in file system
		FileOutputStream out = new FileOutputStream(new File(fileName));
		workbook.write(out);
		out.close();
	}

	public void generateKeyValuePairs(String fileName, Map<String, String> data) throws IOException, IllegalArgumentException, XPathExpressionException, IllegalAccessException
	{

		FileInputStream fileInputStream = new FileInputStream(new File(fileName));

		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);

		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Key");
		header.createCell(1).setCellValue("locator");
		header.createCell(2).setCellValue("Value");
		header.createCell(3).setCellValue("Status");
		int index = 1;

		for (Map.Entry<String, String> entry : data.entrySet())
		{

			header = sheet.createRow(index++);
			header.createCell(0).setCellValue(entry.getKey());
			int i = entry.getValue().indexOf(':');
			if (entry.getValue().contains("By.id"))
			{
				header.createCell(1).setCellValue("id");
			}
			else if (entry.getValue().contains("By.selector"))
			{
				header.createCell(1).setCellValue("cssSelector");
			}
			else if (entry.getValue().contains("By.className"))
			{
				header.createCell(1).setCellValue("className");
			}
			else if (entry.getValue().contains("By.xpath"))
			{
				header.createCell(1).setCellValue("xpath");
			}
			else if (entry.getValue().contains("By.linkText"))
			{
				header.createCell(1).setCellValue("linkText");
			}
			else if (entry.getValue().contains("By.name"))
			{
				header.createCell(1).setCellValue("name");
			}

			header.createCell(2).setCellValue(entry.getValue().substring(i + 1).trim());
			header.createCell(3).setCellValue("Element Found");

		}

		// called last as it is time consuming task
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);

		// Write the workbook in file system
		FileOutputStream out = new FileOutputStream(new File(fileName));
		workbook.write(out);
		out.close();
		fileInputStream.close();
		System.out.println(fileName + "file written successfully.");
	}

	/**
	 * @author kunal.ashar
	 * @description: to write external id in Excel file.
	 * @prerequisite: File path should ve provided in D:\GlobalData.xls
	 * 
	 */
	public static void writeExternalID_API_DataCreation(List<String> externalIDs)
	{
		FileInputStream fileInputStream;
		try
		{
			String filePath = CommonServices.getTestData("Dump_File_Path");
			String fileName = CommonServices.getTestData("External_ID_Dump_File_Name");

			//test
			String finalPath = filePath + fileName;

			fileInputStream = new FileInputStream(new File(finalPath));

			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet sheet = workbook.getSheetAt(0);

			int size = externalIDs.size();

			for (int i = 0; i < size; i++)
			{
				Row row = sheet.createRow(i + 1);
				row.createCell(0).setCellValue(CommonServices.getTestData("Dump_Key_Text") + (i + 1));
				row.createCell(2).setCellValue(externalIDs.get(i));
			}

			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File(fileName));
			workbook.write(out);
			out.close();
			fileInputStream.close();
			logger.info(fileName + "file written successfully.");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @author kunal.ashar
	 * @description: to dump any data in excel file for API validation
	 * @param: bo:accepts entire bo as a string
	 * @param: id:accepts unique id as a string
	 */
	public static void excelCreationForAPI_DataDumping(String boStringObject, String id) throws Exception
	{
		String filePath = "D:\\";
		String setupName = CommonServices.getTestData("SetupName");

		//test
		String finalPath = filePath + setupName + "\\" + id + ".xlsx";

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("DumpedData");

		//to set header row style
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.SEA_GREEN.index);

		XSSFRow row = sheet.createRow(0);
		
		XSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setFontName("Arial");
		font.setColor(IndexedColors.WHITE.getIndex());		
		font.setItalic(false);
		
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFont(font);
		//cellStyle.setFillForegroundColor(HSSFColor.AQUA.index);
		cellStyle.setFillBackgroundColor(HSSFColor.AQUA.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		XSSFCell cell_0 = row.createCell(0);
		cell_0.setCellStyle(style);
		cell_0.setCellValue("Key");		
		sheet.setColumnWidth(0, 8000);

		XSSFCell cell_1 = row.createCell(1);
		cell_1.setCellStyle(style);
		cell_1.setCellValue("Map");		
		sheet.setColumnWidth(1, 4000);

		XSSFCell cell_2 = row.createCell(2);
		cell_2.setCellStyle(style);
		cell_2.setCellValue("Value");		
		sheet.setColumnWidth(2, 8000);

		List<String> boList = boSplitForApiDataDump(boStringObject);
		int i = 1;
		for (String s : boList)
		{
			String[] tempSplit = s.split("=");

			XSSFRow rowData = sheet.createRow(i);
			rowData.createCell(0).setCellValue(tempSplit[0]);
			//rowData.createCell(1).setCellValue(CommonUtilities.getNonZeroRandomNumber(2));
			if (tempSplit.length > 1)
			{
				if (tempSplit[1] == null)
				{
					rowData.createCell(2).setCellValue("");
				}
				else
				{
					rowData.createCell(2).setCellValue(tempSplit[1]);
				}
			}
			i++; //to increment row index
		}

		FileOutputStream fOut = new FileOutputStream(finalPath);
		workbook.write(fOut);
		fOut.close();
		logger.info("Excel file generated at path: " + finalPath);
	}

	/**
	 * @author kunal.ashar
	 * @description: to split bo and send as list to print in excel 
	 * 
	 */
	public static List<String> boSplitForApiDataDump(String bo)
	{

		logger.info("Received BO: " + bo);

		List<String> boList = new LinkedList<String>();

		String[] initialSplit = bo.trim().split("\\[");

		for (int i = 0; i < initialSplit.length; i++)
		{

			String[] secondSplit = initialSplit[i].trim().split(",");

			for (int j = 0; j < secondSplit.length; j++)
			{

				if (secondSplit[j].contains("]"))
				{
					String[] thirdSplit = secondSplit[j].trim().split("\\]");
					if (thirdSplit.length == 1)
					{
						//System.out.println(thirdSplit[0]);
						boList.add(thirdSplit[0].trim());
					}
				}
				else
				{
					//System.out.println(secondSplit[j].trim());
					boList.add(secondSplit[j].trim());
				}
			}
		}

		return boList;
	}

}
