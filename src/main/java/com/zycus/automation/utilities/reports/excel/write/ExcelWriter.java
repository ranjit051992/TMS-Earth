package com.zycus.automation.utilities.reports.excel.write;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.zycus.automation.bo.TestResult;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.utilities.reports.excel.ExcelConstants;
import com.zycus.framework.framework_version_2_4.bo.TestCase;

public class ExcelWriter implements IConstants, ExcelConstants
{

	static Logger logger = Logger.getLogger(ExcelWriter.class);

	static
	{
		PropertyConfigurator.configure("log4j.properties");
	}
	private static List<String>	sheets			= null;
	private static boolean		isFileCreated	= false;
	private static String		fileName		= null;

	public static boolean isFileCreated()
	{
		return isFileCreated;
	}

	public static boolean createExcel()
	{
		FileOutputStream outputStream = null;
		try
		{
			if (fileName == null)
			{
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
				fileName = "Reports_Date-" + dateFormat.format(date) + ".xls";
			}
			File file = new File(REPORTS_PATH);
			if (!file.isDirectory())
			{
				file.mkdir();
			}
			outputStream = new FileOutputStream(REPORTS_PATH + File.separator + fileName);
			HSSFWorkbook workbook = new HSSFWorkbook();
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
			isFileCreated = true;
		}
		catch (FileNotFoundException e)
		{
			logger.error("\nException While Creating Excel Reporting File" + e, e);
			return false;
		}
		catch (IOException e)
		{
			logger.error("\nException While Creating Excel Reporting File" + e, e);
			return false;
		}
		finally
		{
			try
			{
				if (outputStream != null)
				{
					outputStream.flush();
					outputStream.close();
					outputStream = null;
				}
			}
			catch (IOException e)
			{
				logger.error("\nException While Closing Excel Reporting File" + e, e);
			}
		}
		return true;
	}

	public static String getSheetName(TestResult result)
	{
		if (sheets == null)
		{
			sheets = new ArrayList<String>();
			return null;
		}
		for (String sheet : sheets)
		{
			if (sheet.trim().equalsIgnoreCase(result.getSheetName()))
			{
				return sheet;
			}
		}
		return null;
	}

	public static String createSheetName(TestCase testCase)
	{
		return testCase.getBrowser().trim() + "-" + testCase.getVersion().trim();
	}

	public static void writeData(TestResult testResult)
	{
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try
		{
			fileInputStream = new FileInputStream(new File(REPORTS_PATH + File.separator + fileName));
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			String sheetName = getSheetName(testResult);
			HSSFSheet sheet = null;
			if (sheetName == null)
			{
				sheet = workbook.createSheet(testResult.getSheetName());
				sheets.add(testResult.getSheetName());
			}
			else
			{
				sheet = workbook.getSheet(sheetName);
			}
			int rowNum = findRow(sheet, testResult.getName());

			if (rowNum == -1)
			{
				rowNum = sheet.getPhysicalNumberOfRows();
			}
			Row row = sheet.createRow(rowNum);
			Cell name = row.createCell(NAME);
			name.setCellValue(testResult.getName());
			Cell description = row.createCell(DESCRIPTION);
			description.setCellValue(testResult.getDescription());
			Cell result = row.createCell(RESULT);
			result.setCellValue(testResult.isResult());
			Cell module = row.createCell(MODULE);
			module.setCellValue(testResult.getModule());
			Cell nodeAddress = row.createCell(NODE_ADDRESS);
			nodeAddress.setCellValue(testResult.getNodeAddress());
			Cell browser = row.createCell(BROWSER);
			browser.setCellValue(testResult.getBrowser());
			Cell version = row.createCell(VERSION);
			version.setCellValue(testResult.getVersion());
			Cell testCaseStatus = row.createCell(TESTCASE_STATUS);
			testCaseStatus.setCellValue(testResult.getExecutionStatus());
			Cell startTime = row.createCell(START_TIME);
			startTime.setCellValue(testResult.getStartTime());
			Cell endTime = row.createCell(END_TIME);
			endTime.setCellValue(testResult.getEndTime());
			Cell executionTime = row.createCell(EXECUTION_TIME);
			executionTime.setCellValue(testResult.getTimeTakenByTestCase());
			fileInputStream.close();
			fileOutputStream = new FileOutputStream(new File(REPORTS_PATH + File.separator + fileName));
			workbook.write(fileOutputStream);
			fileOutputStream.close();
		}
		catch (FileNotFoundException e)
		{
			logger.error("\nException While Writing on Excel Reporting File" + e, e);
		}
		catch (IOException e)
		{
			logger.error("\nException While Writing on Excel Reporting File" + e, e);
		}
		finally
		{
			try
			{
				if (fileInputStream != null)
				{

					fileInputStream.close();
					fileInputStream = null;
				}
				if (fileOutputStream != null)
				{

					fileOutputStream.close();
					fileOutputStream = null;
				}

			}
			catch (IOException e)
			{
				logger.error("\nException While Writing on Excel Reporting File" + e, e);
			}
		}
	}

	private static int findRow(HSSFSheet sheet, String cellContent)
	{
		for (Row row : sheet)
		{
			for (Cell cell : row)
			{
				if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				{
					if (cell.getRichStringCellValue().getString().trim().equals(cellContent))
					{
						return row.getRowNum();
					}
				}
			}
		}
		return -1;
	}

}