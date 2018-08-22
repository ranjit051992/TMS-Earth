package com.zycus.automation.eproc.excelDatabaseReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.zycus.framework.framework_version_2_4.bo.TestCase;

public class ExcelDatabaseReader
{

	static Logger logger = Logger.getLogger(ExcelDatabaseReader.class);
	static
	{
		PropertyConfigurator.configure("log4j.properties");
	}

	private static String							reportingfileName		= "reportDatabase.xls";
	private static File								destinationDir			= new File("output/reports/Sanity-Regression/");
	private static File								sourceDir				= new File("reporting/" + reportingfileName);
	private FileInputStream							fileInputStream			= null;
	private final File								fileName				= null;
	private static String							error					= null;
	private final Map<String, Map<String, String>>	testResults				= new LinkedHashMap<String, Map<String, String>>();

	/**********************
	 * Excel Column Initialization
	 ******************************/

	final private static int						REGRESSION_TESTCASE_ID	= 0;
	final private static int						SUMMARY					= 2;
	final private static int						IE_08					= 3;
	final private static int						IE_09					= 4;
	final private static int						IE_10					= 5;
	final private static int						IE_UNSUPPORTED			= 6;
	final private static int						FF_16					= 7;
	final private static int						FF_17					= 8;
	final private static int						FF_18					= 9;
	final private static int						FF_19					= 10;
	final private static int						FF_20					= 11;
	final private static int						FF_21					= 12;
	final private static int						FF_22					= 13;
	final private static int						FF_23					= 14;
	final private static int						FF_24					= 15;
	final private static int						FF_25					= 16;
	final private static int						FF_26					= 17;
	final private static int						FF_27					= 18;
	final private static int						CR_1					= 19;
	final private static int						FF_UNSUPPORTED			= 20;
	final private static int						UNSUPPORTED_BROWSER		= 21;
	final private static String						IE						= "Internet Explorer";
	final private static String						FF						= "Firefox";
	final private static String						CR						= "Chrome";

	final private static String						Mapping_ID				= "Mapping_ID";
	final private static String						Summary_ID				= "Summary_ID";

	final private static String						IE_08_ID				= "IE_08_ID";
	final private static String						IE_09_ID				= "IE_09_ID";
	final private static String						IE_10_ID				= "IE_10_ID";
	final private static String						IE_UNSUPPORTED_ID		= "IE_UNSUPPORTED_ID";
	final private static String						FF_16_ID				= "FF_16_ID";
	final private static String						FF_17_ID				= "FF_17_ID";
	final private static String						FF_18_ID				= "FF_18_ID";
	final private static String						FF_19_ID				= "FF_19_ID";
	final private static String						FF_20_ID				= "FF_20_ID";
	final private static String						FF_21_ID				= "FF_21_ID";
	final private static String						FF_22_ID				= "FF_22_ID";
	final private static String						FF_23_ID				= "FF_23_ID";
	final private static String						FF_24_ID				= "FF_24_ID";
	final private static String						FF_25_ID				= "FF_25_ID";
	final private static String						FF_26_ID				= "FF_26_ID";
	final private static String						FF_27_ID				= "FF_27_ID";
	final private static String						FF_UNSUPPORTED_ID		= "FF_UNSUPPORTED_ID";
	final private static String						UNSUPPORTED_BROWSER_ID	= "UNSUPPORTED_BROWSER_ID";
	final private static String						NULL_VALUE				= "NULL_VALUE";

	/*
	 * private static Workbook workbook = null; private static Sheet sheet =
	 * null; private static WritableWorkbook workbookForOutput = null; private
	 * static WritableSheet sheetForOutput = null;
	 */

	public static void copyReportingFileToDir()
	{
		try
		{
			logger.info("Copying File To Report Dir");
			FileUtils.copyFileToDirectory(sourceDir, destinationDir);
		}
		catch (FileNotFoundException e)
		{
			error = "File Not Found Exception";
			printError(error + e, false);
		}
		catch (IOException e)
		{
			error = "IOException Exception";
			printError(error + e, false);
		}
	}

	public void readExcel()
	{
		Map<String, String> testData = new LinkedHashMap<String, String>();
		try
		{
			fileInputStream = new FileInputStream(fileName);
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.rowIterator();
			rowIterator.next();
			while (rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				Cell TC_ID_Cell = row.getCell(0);
				Cell Mapping_ID_Cell = row.getCell(1);
				Cell Summary_cell = row.getCell(2);
				Cell IE_08_Cell = row.getCell(3);
				Cell IE_09_Cell = row.getCell(4);
				Cell IE_10_Cell = row.getCell(5);
				Cell IE_UNSUPPORTED_Cell = row.getCell(6);
				Cell FF_16_Cell = row.getCell(7);
				Cell FF_17_Cell = row.getCell(8);
				Cell FF_18_Cell = row.getCell(9);
				Cell FF_19_Cell = row.getCell(10);
				Cell FF_20_Cell = row.getCell(11);
				Cell FF_21_Cell = row.getCell(12);
				Cell FF_22_Cell = row.getCell(13);
				Cell FF_23_Cell = row.getCell(14);
				Cell FF_24_Cell = row.getCell(15);
				Cell FF_25_Cell = row.getCell(16);
				Cell FF_26_Cell = row.getCell(17);
				Cell FF_27_Cell = row.getCell(18);
				Cell FF_UNSUPPORTED_Cell = row.getCell(19);
				Cell UNSUPPORTED_BROWSER_Cell = row.getCell(20);

				// testData.put(TC_ID, TC_ID_Cell.getStringCellValue().trim());
				testData.put(Mapping_ID, verifyNullValue(Mapping_ID_Cell, Mapping_ID_Cell.getStringCellValue()));
				testData.put(Summary_ID, verifyNullValue(Summary_cell, Summary_cell.getStringCellValue()));
				testData.put(IE_08_ID, verifyNullValue(IE_08_Cell, IE_08_Cell.getStringCellValue()));
				testData.put(IE_09_ID, verifyNullValue(IE_09_Cell, IE_09_Cell.getStringCellValue()));
				testData.put(IE_10_ID, verifyNullValue(IE_10_Cell, IE_10_Cell.getStringCellValue()));
				testData.put(IE_UNSUPPORTED_ID, verifyNullValue(IE_UNSUPPORTED_Cell, IE_UNSUPPORTED_Cell.getStringCellValue()));
				testData.put(FF_16_ID, verifyNullValue(FF_16_Cell, FF_16_Cell.getStringCellValue()));
				testData.put(FF_17_ID, verifyNullValue(FF_17_Cell, FF_17_Cell.getStringCellValue()));
				testData.put(FF_18_ID, verifyNullValue(FF_18_Cell, FF_18_Cell.getStringCellValue()));
				testData.put(FF_19_ID, verifyNullValue(FF_19_Cell, FF_19_Cell.getStringCellValue()));
				testData.put(FF_20_ID, verifyNullValue(FF_20_Cell, FF_20_Cell.getStringCellValue()));
				testData.put(FF_21_ID, verifyNullValue(FF_21_Cell, FF_21_Cell.getStringCellValue()));
				testData.put(FF_22_ID, verifyNullValue(FF_22_Cell, FF_22_Cell.getStringCellValue()));
				testData.put(FF_23_ID, verifyNullValue(FF_23_Cell, FF_23_Cell.getStringCellValue()));
				testData.put(FF_24_ID, verifyNullValue(FF_24_Cell, FF_24_Cell.getStringCellValue()));
				testData.put(FF_25_ID, verifyNullValue(FF_25_Cell, FF_25_Cell.getStringCellValue()));
				testData.put(FF_26_ID, verifyNullValue(FF_26_Cell, FF_26_Cell.getStringCellValue()));
				testData.put(FF_27_ID, verifyNullValue(FF_27_Cell, FF_27_Cell.getStringCellValue()));
				testData.put(FF_UNSUPPORTED_ID, verifyNullValue(FF_UNSUPPORTED_Cell, FF_UNSUPPORTED_Cell.getStringCellValue()));
				testData.put(UNSUPPORTED_BROWSER_ID, verifyNullValue(UNSUPPORTED_BROWSER_Cell, UNSUPPORTED_BROWSER_Cell.getStringCellValue()));
				testResults.put(TC_ID_Cell.getStringCellValue(), testData);
			}
			fileInputStream.close();
			// System.out.println("testResults" + testResults);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	private String verifyNullValue(Cell cell, String str)
	{
		String returnStatus = null;
		try
		{
			if (cell != null && (str != null))
			{
				returnStatus = str;
			}
			else
			{
				returnStatus = NULL_VALUE;
			}
		}
		catch (NullPointerException e)
		{
			error = "Cell Contain Null Value";
			printError(error, e, false);
			returnStatus = NULL_VALUE;
		}
		return returnStatus;
	}

	public static void insertResult(TestCase testCase, String testCaseName, String desc, boolean result, String status)
	{

		try
		{
			String fileName = "output/reports/Sanity-Regression/reportDatabase.xls";
			if (!(new File("output/reports/Sanity-Regression/reportDatabase.xls")).exists())
			{
				logger.info("File Does Not Exist Hence Copying It From Default Folder");
				FileUtils.copyFileToDirectory(new File("reporting/reportDatabase.xls"), new File("output/reports/Sanity-Regression/"));
			}

			FileInputStream file = new FileInputStream(new File(fileName));
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Cell cell;

			int locationOfTestCaseID = findRow(sheet, testCase.getTestMethodName());

			if (testCaseName == null)
			{
				testCaseName = testCase.getTestMethodName();
			}
			if (desc == null)
			{
				desc = testCase.getDescription();
			}
			if (locationOfTestCaseID <= 0)
			{

				int rows = sheet.getPhysicalNumberOfRows();

				Row row = sheet.createRow(rows);
				cell = row.createCell(REGRESSION_TESTCASE_ID);
				cell.setCellValue(testCaseName);

				/*
				 * cell = row.createCell(MAPPING_ID);
				 * cell.setCellValue(testCase.getTestCaseMappingID());
				 */

				cell = row.createCell(SUMMARY);
				cell.setCellValue(desc);

				String Browser = null;
				if (testCase.getBrowser().contains("Internet"))
				{
					Browser = IE;
				}
				else if (testCase.getBrowser().contains("Firefox"))
				{
					Browser = FF;
				}
				else if (testCase.getBrowser().contains("Chrome"))
				{
					Browser = CR;
				}
				if (result == false && status != null)
				{
					cell = row.createCell(setBrowser(Browser, testCase.getVersion()));
					cell.setCellValue(status);
				}
				else
				{
					cell = row.createCell(setBrowser(Browser, testCase.getVersion()));
					cell.setCellValue(convertResultToString(result));
				}
			}
			else
			{
				int rows = locationOfTestCaseID;
				Row row = sheet.createRow(rows);
				cell = row.createCell(REGRESSION_TESTCASE_ID);
				cell.setCellValue(testCaseName);

				/*
				 * cell = row.createCell(MAPPING_ID);
				 * cell.setCellValue(testCase.getTestCaseMappingID());
				 */

				cell = row.createCell(SUMMARY);
				cell.setCellValue(desc);

				String Browser = null;
				if (testCase.getBrowser().contains("Internet") || testCase.getBrowser().contains("internet") || testCase.getBrowser().equalsIgnoreCase("ie"))
				{
					Browser = IE;
				}
				else if (testCase.getBrowser().contains("firefox") || testCase.getBrowser().contains("Firefox") || testCase.getBrowser().equalsIgnoreCase("ff"))
				{
					Browser = FF;
				}
				else if (testCase.getBrowser().contains("Chrome") || testCase.getBrowser().contains("chrome") || testCase.getBrowser().equalsIgnoreCase("cr"))
				{
					Browser = CR;
				}

				if (result == false && status != null)
				{
					cell = row.createCell(setBrowser(Browser, testCase.getVersion()));
					cell.setCellValue(status);
				}
				else
				{
					cell = row.createCell(setBrowser(Browser, testCase.getVersion()));
					cell.setCellValue(convertResultToString(result));
				}
			}
			file.close();
			FileOutputStream outFile = new FileOutputStream(new File(fileName));
			workbook.write(outFile);
			outFile.close();
		}
		catch (IOException e)
		{
			logger.error("IOException Exception Occured " + e, e);
		}
	}

	/************************************
	 * Supporting Functions
	 ***************************************************/

	private static void printError(String error, Exception e, boolean result)
	{
		if (result == false)
		{
			logger.error("\n" + "!!!!!!*********" + error.toUpperCase() + e, e);
		}
	}

	private static void printError(String error, boolean result)
	{
		if (result == false)
		{
			logger.error("\n" + "!!!!!!*********" + error.toUpperCase());
		}
	}

	public static String convertResultToString(boolean result)
	{
		String booleanToString = null;
		if (result == true)
		{
			booleanToString = "PASS";
		}
		else if (result == false)
		{
			booleanToString = "FAIL";
		}
		return booleanToString;
	}

	public static int setBrowser(String browserId, String version)
	{
		int browserVersionID = -1;
		try
		{
			int versionID = -1;
			if (version.contains("."))
			{
				String[] versionIDs = StringUtils.split(version, ".");
				versionID = Integer.parseInt(versionIDs[0]);
			}
			else
			{
				versionID = Integer.parseInt(version);
			}

			if (browserId.equalsIgnoreCase(IE))
			{
				// System.out.println("Enter in IE");
				switch (versionID)
				{
					case 8: {
						browserVersionID = IE_08;
						break;
					}
					case 9: {
						browserVersionID = IE_09;
						break;
					}
					case 10: {
						browserVersionID = IE_10;
						break;
					}
					default: {
						browserVersionID = IE_UNSUPPORTED;
						break;
					}
				}
			}
			else if (browserId.equalsIgnoreCase(FF))
			{
				switch (versionID)
				{
					case 16: {
						browserVersionID = FF_16;
						break;
					}
					case 17: {
						browserVersionID = FF_17;
						break;
					}
					case 18: {
						browserVersionID = FF_18;
						break;
					}
					case 19: {
						browserVersionID = FF_19;
						break;
					}
					case 20: {
						browserVersionID = FF_20;
						break;
					}
					case 21: {
						browserVersionID = FF_21;
						break;
					}
					case 22: {
						browserVersionID = FF_22;
						break;
					}
					case 23: {
						browserVersionID = FF_23;
						break;
					}
					case 24: {
						browserVersionID = FF_24;
						break;
					}
					case 25: {
						browserVersionID = FF_25;
						break;
					}
					case 26: {
						browserVersionID = FF_26;
						break;
					}
					case 27: {
						browserVersionID = FF_27;
						break;
					}
					default: {
						browserVersionID = FF_UNSUPPORTED;
						break;
					}
				}
			}
			else if (browserId.equalsIgnoreCase(CR))
			{

				browserVersionID = CR_1;

			}
			else
			{
				browserVersionID = UNSUPPORTED_BROWSER;
			}
		}
		catch (Exception e)
		{
			logger.info("Error ==> Browser : " + browserId + " || version : " + version);
		}
		return browserVersionID;
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
		return 0;
	}
}
