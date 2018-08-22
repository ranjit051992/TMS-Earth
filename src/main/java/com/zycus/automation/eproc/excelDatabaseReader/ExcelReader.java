package com.zycus.automation.eproc.excelDatabaseReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zycus.automation.bo.CostBookingAndAccountingItemSummaryCOA;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.bo.TestSuiteResult;
import com.zycus.framework.framework_version_2_4.constants.FrameworkConstants;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.startup.Startup;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelReader implements FrameworkConstants
{
	static Logger											logger				= Logger.getLogger(ExcelReader.class);

	public static int										currentData			= 0;
	// map of thread id and map of key and set of used values
	public static Map<String, Map<String, Set<Integer>>>	threadDataMap		= new HashMap<String, Map<String, Set<Integer>>>();
	public static Map<String, Integer>						dataCurrentValueMap	= new HashMap<String, Integer>();

	public static Map<String, String>						testDataMap			= new HashMap<String, String>();

	// final method to get valid testdata
	public static Map<String, String> getTestDataCombo() throws Exception
	{
		String dataFile;
		String fieldData, error = "";
		String[] data;
		int len;
		dataFile = ConfigProperty.getConfig("defaultDataFile");
		Map<String, String> testDataMap = new HashMap<String, String>();
		String fileName = ConfigProperty.getConfig("Input_Files_Location") + dataFile;
		System.out.println("File Name : " + fileName);
		FileInputStream fileInputStream = new FileInputStream(new File(fileName));
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		Row row = rowIterator.next();
		Cell cell0 = null;
		Cell cell = null;
		while (rowIterator.hasNext())
		{
			try
			{
				row = rowIterator.next();
				if (row != null)
				{
					cell0 = row.getCell(0);
					if (cell0 != null)
					{
						cell0.setCellType(Cell.CELL_TYPE_STRING);
						if (row.getCell(1) != null && !(String.valueOf(row.getCell(1)).equals("")))
						{
							cell = row.getCell(1);
							cell.setCellType(Cell.CELL_TYPE_STRING);
							if (cell.getCellType() == 0)
							{
								cell.setCellType(Cell.CELL_TYPE_STRING);
							}
							fieldData = cell.getStringCellValue();
							// fieldData = row.getCell(1).getStringCellValue();
							data = StringUtils.split(fieldData, "||");

							len = data.length;
							String cellValue_Key = cell0.getStringCellValue();
							testDataMap.put(cell0.getStringCellValue(), data[getSequencialNumber(len, cellValue_Key)].trim());
						}
						else
						{
							testDataMap.put(cell0.getStringCellValue(), "null");
						}
					}
					else
					{
						error += "\n Kye was NULL for row no : " + row.getRowNum() + "\n";
					}
				}
				else
				{
					error += "\n Row was NULL \n";
				}
			}
			catch (Exception e)
			{
				logger.info("\n -------------- Error:> No such field exists in excel : " + error + " --------------------\n" + e, e);
				throw e;
			}

		}

		return testDataMap;
	}

	public static Map<String, String> getTestDataComboFromFile(String file, String sheetName) throws Exception
	{
		String dataFile;
		String fieldData, error = "";
		String[] data;
		int len;
		dataFile = ConfigProperty.getConfig(file);
		Map<String, String> testDataMap = new HashMap<String, String>();
		String fileName = ConfigProperty.getConfig("Input_Files_Location") + dataFile;
		System.out.println("File Name : " + fileName);
		FileInputStream fileInputStream = new FileInputStream(new File(fileName));
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet sheet = workbook.getSheet(sheetName);
		Iterator<Row> rowIterator = sheet.iterator();
		Row row = rowIterator.next();
		Cell cell0 = null;
		Cell cell = null;
		while (rowIterator.hasNext())
		{
			try
			{
				row = rowIterator.next();
				if (row != null && !row.equals(null))
				{
					cell0 = row.getCell(0);

					if (cell0 != null)
					{
						cell0.setCellType(Cell.CELL_TYPE_STRING);
						if (row.getCell(1) != null && !(String.valueOf(row.getCell(1)).equals("")))
						{
							cell = row.getCell(1);
							cell.setCellType(Cell.CELL_TYPE_STRING);
							if (cell.getCellType() == 0)
							{
								cell.setCellType(Cell.CELL_TYPE_STRING);
							}
							fieldData = cell.getStringCellValue();
							// fieldData = row.getCell(1).getStringCellValue();
							data = StringUtils.split(fieldData, "||");

							len = data.length;
							String cellValue_Key = cell0.getStringCellValue();
							testDataMap.put(cell0.getStringCellValue(), data[getSequencialNumber(len, cellValue_Key)].trim());
						}
						else
						{
							testDataMap.put(cell0.getStringCellValue(), "null");
						}
					}
					else
					{
						error += "\n Kye was NULL for row no : " + row.getRowNum() + "\n";
					}
				}
				else
				{
					error += "\n Row was NULL \n";
				}
			}
			catch (Exception e)
			{
				logger.info("\n -------------- Error:> No such field exists in excel : " + error + " --------------------\n" + e, e);
				throw e;
			}

		}

		return testDataMap;
	}

	public static Map<String, String> getTestDataComboFromFile(String file) throws Exception
	{
		String dataFile;
		String fieldData, error = "";
		String[] data;
		int len;
		dataFile = ConfigProperty.getConfig(file);
		Map<String, String> testDataMap = new HashMap<String, String>();
		String fileName = ConfigProperty.getConfig("Input_Files_Location") + dataFile;
		System.out.println("File Name : " + fileName);
		FileInputStream fileInputStream = new FileInputStream(new File(fileName));
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		Row row = rowIterator.next();
		Cell cell0 = null;
		Cell cell = null;
		while (rowIterator.hasNext())
		{
			try
			{
				row = rowIterator.next();
				if (row != null && !row.equals(null))
				{
					cell0 = row.getCell(0);

					if (cell0 != null)
					{
						cell0.setCellType(Cell.CELL_TYPE_STRING);
						if (row.getCell(1) != null && !(String.valueOf(row.getCell(1)).equals("")))
						{
							cell = row.getCell(1);
							cell.setCellType(Cell.CELL_TYPE_STRING);
							if (cell.getCellType() == 0)
							{
								cell.setCellType(Cell.CELL_TYPE_STRING);
							}
							fieldData = cell.getStringCellValue();
							// fieldData = row.getCell(1).getStringCellValue();
							data = StringUtils.split(fieldData, "||");

							len = data.length;
							String cellValue_Key = cell0.getStringCellValue();
							testDataMap.put(cell0.getStringCellValue(), data[getSequencialNumber(len, cellValue_Key)].trim());
						}
						else
						{
							testDataMap.put(cell0.getStringCellValue(), "null");
						}
					}
					else
					{
						error += "\n Kye was NULL for row no : " + row.getRowNum() + "\n";
					}
				}
				else
				{
					error += "\n Row was NULL \n";
				}
			}
			catch (Exception e)
			{
				logger.info("\n -------------- Error:> No such field exists in excel : " + error + " --------------------\n" + e, e);
				throw e;
			}

		}

		return testDataMap;
	}

	public static Map<String, String> getTestDataComboFromFileXlsx(String file, String sheetName) throws Exception
	{
		String dataFile;
		String fieldData, error = "";
		String[] data;
		int len;
		dataFile = ConfigProperty.getConfig(file);
		Map<String, String> testDataMap = new HashMap<String, String>();
		String fileName = ConfigProperty.getConfig("Input_Files_Location") + dataFile;
		System.out.println("File Name : " + fileName);
		FileInputStream fileInputStream = new FileInputStream(new File(fileName));
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Iterator<Row> rowIterator = sheet.iterator();
		Row row = rowIterator.next();
		Cell cell0 = null;
		Cell cell = null;
		while (rowIterator.hasNext())
		{
			try
			{
				row = rowIterator.next();
				if (row != null && !row.equals(null))
				{
					cell0 = row.getCell(0);

					if (cell0 != null)
					{
						cell0.setCellType(Cell.CELL_TYPE_STRING);
						if (row.getCell(1) != null && !(String.valueOf(row.getCell(1)).equals("")))
						{
							cell = row.getCell(1);
							cell.setCellType(Cell.CELL_TYPE_STRING);
							if (cell.getCellType() == 0)
							{
								cell.setCellType(Cell.CELL_TYPE_STRING);
							}
							fieldData = cell.getStringCellValue();
							// fieldData = row.getCell(1).getStringCellValue();
							data = StringUtils.split(fieldData, "||");

							len = data.length;
							String cellValue_Key = cell0.getStringCellValue();
							testDataMap.put(cell0.getStringCellValue(), data[getSequencialNumber(len, cellValue_Key)].trim());
						}
						else
						{
							testDataMap.put(cell0.getStringCellValue(), "null");
						}
					}
					else
					{
						error += "\n Kye was NULL for row no : " + row.getRowNum() + "\n";
					}
				}
				else
				{
					error += "\n Row was NULL \n";
				}
			}
			catch (Exception e)
			{
				logger.info("\n -------------- Error:> No such field exists in excel : " + error + " --------------------\n" + e, e);
				throw e;
			}

		}

		return testDataMap;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get sequential no <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param len
	 *        </font><b><br>
	 * @param cellValue_Key
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	/*
	 * private static int getSequencialNumber(int len, String cellValue_Key) {
	 * int number = 0; dataIndexValue = map.get(cellValue_Key); if
	 * (dataIndexValue != null) { currentData =
	 * dataIndexValue.get("CurrentData"); previousData =
	 * dataIndexValue.get("PreviousData"); } else { dataIndexValue = new
	 * HashMap<String, Integer>(); currentData = 0; previousData = 0; } if
	 * ((currentData != previousData) && (currentData < len)) { number =
	 * currentData; } else { currentData = 0; number = currentData; }
	 * previousData = currentData; currentData = previousData + 1;
	 * dataIndexValue.put("CurrentData", currentData);
	 * dataIndexValue.put("PreviousData", previousData); map.put(cellValue_Key,
	 * dataIndexValue); return number; }
	 */

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To write result in excel <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param result
	 *        </font><b><br>
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public synchronized static void writeResult(String result, TestCase testCase, String testName, String desc, String error, AssertionError assertionError)
	{
		String tcsName = null, browserVersion = null;
		String excel = "TestResult.xls";
		File srcFile = new File("reporting/" + excel);
		File destDir = new File("output/reports/");
		File destFile = new File("output/reports/" + excel);
		try
		{
			if (!destFile.exists())
			{
				FileUtils.copyFileToDirectory(srcFile, destDir);
			}
			String name = null;

			if (testName == null)
			{
				name = testCase.getTestMethodName();
			}
			else
			{
				name = testName;
			}

			if (name.contains("RTC"))
			{
				String[] temp = name.split("_");
				tcsName = temp[1];
			}
			else
			{
				tcsName = name;
			}

			browserVersion = testCase.getBrowserVersionID();
			FileInputStream fi = new FileInputStream(destFile);
			Workbook w = Workbook.getWorkbook(fi);
			Sheet s = w.getSheet(0);

			// to get blank row
			int rows = 0;
			rows = s.getRows();
			fi.close();

			FileOutputStream fout = new FileOutputStream(destFile);
			WritableWorkbook wout = Workbook.createWorkbook(fout, w);
			// WritableSheet wsheet = wout.getSheet(0);
			WritableSheet wsheet = null;
			WritableSheet[] wsheets = wout.getSheets();

			// to find sheet with proper browserversion name
			for (WritableSheet writableSheet : wsheets)
			{
				if (writableSheet.getName().equalsIgnoreCase(browserVersion))
				{
					wsheet = writableSheet;
				}
			}

			// if sheet not found with browserverion name
			// then to find empty sheet i.e sheet containing "Sheet" in name
			if (wsheet == null)
			{
				for (WritableSheet writableSheet : wsheets)
				{
					if (writableSheet.getName().contains("Sheet"))
					{
						wsheet = writableSheet;
						break;
					}
				}
			}
			rows = wsheet.getRows();

			wsheet.setName(browserVersion);

			// to add status
			Label testCaseName = new Label(0, rows, tcsName);
			wsheet.addCell(testCaseName);

			Label status = new Label(1, rows, result);
			wsheet.addCell(status);

			String description = null;
			if (desc == null)
			{
				description = testCase.getDescription();
			}
			else
			{
				description = desc;
			}
			Label summary = new Label(2, rows, description);
			wsheet.addCell(summary);

			Label moduleName = new Label(3, rows, testCase.getModuleName());
			wsheet.addCell(moduleName);

			if (error != null)
			{
				Label errorMsg = new Label(5, rows, error);
				wsheet.addCell(errorMsg);
			}
			if (assertionError != null)
			{
				Label assertionErrorMsg = new Label(6, rows, assertionError.getMessage());
				wsheet.addCell(assertionErrorMsg);
			}
			wout.write();
			wout.close();
		}
		catch (FileNotFoundException e)
		{
			logger.error("FileNotFoundException Exception Occured " + e, e);
		}
		catch (RowsExceededException e)
		{
			logger.error("RowsExceededException Exception Occured " + e, e);
		}
		catch (WriteException e)
		{
			logger.error("WriteException Exception Occured " + e, e);
		}
		catch (IOException e)
		{
			logger.error("IOException Exception Occured " + e, e);
		}
		catch (BiffException e)
		{
			logger.error("BiffException Exception Occured " + e, e);
		}
		catch (Exception e)
		{
			logger.error("Exception Occured " + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To write result in excel <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param result
	 *        </font><b><br>
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static void writeTestCaseData(String testData, TestCase testCase, String testName)
	{
		String excel = "TestResult.xls";
		File srcFile = new File("reporting/" + excel);
		File destDir = new File("output/reports/");
		File destFile = new File("output/reports/" + excel);
		try
		{
			if (!destFile.exists())
			{
				FileUtils.copyFileToDirectory(srcFile, destDir);
			}
			String name = null;

			if (testName == null)
			{
				name = testCase.getTestMethodName();
			}
			else
			{
				name = testName;
			}

			if (name.contains("RTC"))
			{
				name.split("_");
			}
			else
			{
			}
			FileInputStream fi = new FileInputStream(destFile);
			Workbook w = Workbook.getWorkbook(fi);
			Sheet sheet = w.getSheet(0);

			/*
			 * jxl.Cell cell = sheet.getCell(name); if (cell.getCellFormat() ==
			 * 0) { cell.setCellType(Cell.CELL_TYPE_STRING); } int rows =
			 * cell.getRow();
			 */

			int rowNo = sheet.getRows(), i = 0;
			System.out.println("No of rows : " + rowNo);
			for (i = 0; i < rowNo; i++)
			{
				if (sheet.getCell(0, i).getContents().equalsIgnoreCase(name))
				{
					break;
				}
			}
			int rows = i;
			fi.close();

			/*
			 * HSSFWorkbook workbook = new HSSFWorkbook(fi); HSSFSheet s =
			 * workbook.getSheetAt(0);
			 */
			FileOutputStream fout = new FileOutputStream(destFile);
			WritableWorkbook wout = Workbook.createWorkbook(fout, w);
			WritableSheet wsheet = wout.getSheet(0);

			/*
			 * Iterator<Row> rowIterator = s.iterator(); rowIterator.next(); int
			 * rows = 0; while (rowIterator.hasNext()) { Row row =
			 * rowIterator.next(); Cell testMethodNameCell = row.getCell(0); if
			 * (testMethodNameCell.getStringCellValue().equalsIgnoreCase(name))
			 * { break; } rows++; }
			 */
			// to add testData

			Label test_data = new Label(4, rows, testData);
			wsheet.addCell(test_data);

			wout.write();
			wout.close();
			fout.close();
		}
		catch (FileNotFoundException e)
		{
			logger.error("FileNotFoundException Exception Occured " + e, e);
		}
		catch (RowsExceededException e)
		{
			logger.error("RowsExceededException Exception Occured " + e, e);
		}
		catch (WriteException e)
		{
			logger.error("WriteException Exception Occured " + e, e);
		}
		catch (IOException e)
		{
			logger.error("IOException Exception Occured " + e, e);
		}
		catch (BiffException e)
		{
			logger.error("BiffException Exception Occured " + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get sequential no <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param len
	 *        </font><b><br>
	 * @param cellValue_Key
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	private synchronized static int getSequencialNumber(int len, String cellValue_Key)
	{
		// to get current thread id
		String tid = String.valueOf(Thread.currentThread().getId());

		// if current thread id is not in map add it
		if (threadDataMap.get(tid) == null)
		{
			threadDataMap.put(tid, new HashMap<String, Set<Integer>>());
		}
		// to get local thread map
		Map<String, Set<Integer>> localThreadMap = threadDataMap.get(tid);

		// to check value of key in localthreadMap, if null, add it
		if (localThreadMap.get(cellValue_Key) == null)
		{
			localThreadMap.put(cellValue_Key, new HashSet<Integer>());
		}
		// to get used values corresponding to key in localThreadMap
		Set<Integer> usedValues = localThreadMap.get(cellValue_Key);

		// check dataCurrentValueMap for key
		if (dataCurrentValueMap.get(cellValue_Key) == null)
		{
			dataCurrentValueMap.put(cellValue_Key, 0);
		}
		// to get index of current data
		int currentData = dataCurrentValueMap.get(cellValue_Key);

		// to check wheather current data is already used or not
		while (usedValues.contains(currentData) && len != usedValues.size())
		{
			currentData++;
			if (currentData >= len)
			{
				currentData = 0;
			}
		}
		// add current data in used values
		usedValues.add(currentData);

		// increment current data counter
		currentData++;
		if (currentData >= len)
		{
			currentData = 0;
		}
		dataCurrentValueMap.put(cellValue_Key, currentData);

		return currentData;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get testdata <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static Map<String, String> getTestData() throws Exception
	{
		String dataFile, error = "";
		String fieldData;
		dataFile = ConfigProperty.getConfig("defaultDataFile");
		Map<String, String> testDataMap = new HashMap<String, String>();
		String fileName = ConfigProperty.getConfig("Input_Files_Location") + dataFile;
		FileInputStream fileInputStream = new FileInputStream(new File(fileName));
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		Row row = rowIterator.next();
		Cell cell = null;
		Cell cell0 = null;
		while (rowIterator.hasNext())
		{
			try
			{
				if (row != null)
				{
					row = rowIterator.next();
					cell = row.getCell(1);
					cell0 = row.getCell(0);
					if (cell0 != null)
					{
						if (cell != null)
						{
							cell.setCellType(Cell.CELL_TYPE_STRING);
							fieldData = cell.getStringCellValue();

							testDataMap.put(cell0.getStringCellValue(), fieldData);
						}
						else
						{
							testDataMap.put(cell0.getStringCellValue(), "null");
						}
					}
					else
					{
						error += "\n Kye was NULL for row no : " + row.getRowNum() + "\n";
					}
				}
				else
				{
					error += "\n Row was NULL \n";
				}
			}
			catch (Exception e)
			{
				logger.info("\n -------------- Error:> No such field exists in excel : " + error + " --------------------\n" + e, e);
				throw e;
			}

		}

		return testDataMap;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param key
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static String getTestDataCombo(String key) throws Exception
	{
		String testData, dataValue = null;
		String[] data;
		int len = 0;
		try
		{
			testData = testDataMap.get(key);
			if (testData != null)
			{
				data = StringUtils.split(testData, "||");
				len = data.length;
				dataValue = data[getSequencialNumber(len, key)];
			}

		}
		catch (Exception e)
		{
			logger.info("\n -------------- Error:> No such field exists in excel --------------------\n" + e, e);
			throw e;
		}
		return dataValue;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param key
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static String getTestDataCombo(String key, int index) throws Exception
	{
		String testData, dataValue = null;
		String[] data;
		try
		{
			testData = testDataMap.get(key);
			if (testData != null)
			{
				data = StringUtils.split(testData, "||");
				dataValue = data[index];
			}

		}
		catch (Exception e)
		{
			logger.info("\n -------------- Error:> No such field exists in excel --------------------\n" + e, e);
			throw e;
		}
		return dataValue;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To write summary report in excel <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param result
	 *        </font><b><br>
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public synchronized static void writeSummaryReportResult()
	{
		String excel = "TestResult.xls";
		File srcFile = new File("reporting/" + excel);
		File destDir = new File("output/reports/");
		File destFile = new File("output/reports/" + excel);
		try
		{
			if (!destFile.exists())
			{
				FileUtils.copyFileToDirectory(srcFile, destDir);
			}
			FileInputStream fi = new FileInputStream(destFile);
			Workbook w = Workbook.getWorkbook(fi);
			Sheet s = w.getSheet(0);

			// to get blank row
			int rows = 0;
			rows = s.getRows();
			fi.close();

			FileOutputStream fout = new FileOutputStream(destFile);
			WritableWorkbook wout = Workbook.createWorkbook(fout, w);
			WritableSheet wsheet = wout.createSheet("SummaryReport", 0);

			rows = wsheet.getRows();
			// to add headers
			wsheet.addCell(new Label(0, rows, "Test Suite Name"));
			wsheet.addCell(new Label(1, rows, "TOTAL"));
			wsheet.addCell(new Label(2, rows, "PASSED"));
			wsheet.addCell(new Label(3, rows, "FAILED"));
			wsheet.addCell(new Label(4, rows, "SKIPPED"));

			for (TestSuiteResult testSuiteResult : Startup.result)
			{
				rows = wsheet.getRows();

				// to add suite name
				Label suiteName = new Label(0, rows, testSuiteResult.getBrowserVersion());
				wsheet.addCell(suiteName);

				// total tcs
				Label totalTcs = new Label(1, rows, Integer.toString(testSuiteResult.getTotal()));
				wsheet.addCell(totalTcs);

				// passed tcs
				Label passedTcs = new Label(2, rows, Integer.toString(testSuiteResult.getPassed()));
				wsheet.addCell(passedTcs);

				// failed tcs
				Label failedTcs = new Label(3, rows, Integer.toString(testSuiteResult.getFailed()));
				wsheet.addCell(failedTcs);

				// skipped tcs
				Label skippedTcs = new Label(4, rows, Integer.toString(testSuiteResult.getSkipped()));
				wsheet.addCell(skippedTcs);

			}

			wout.write();
			wout.close();
		}
		catch (FileNotFoundException e)
		{
			logger.error("FileNotFoundException Exception Occured " + e, e);
		}
		catch (RowsExceededException e)
		{
			logger.error("RowsExceededException Exception Occured " + e, e);
		}
		catch (WriteException e)
		{
			logger.error("WriteException Exception Occured " + e, e);
		}
		catch (IOException e)
		{
			logger.error("IOException Exception Occured " + e, e);
		}
		catch (BiffException e)
		{
			logger.error("BiffException Exception Occured " + e, e);
		}
		catch (Exception e)
		{
			logger.error("Exception Occured while writing summary rerport" + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To write summary report in excel <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param result
	 *        </font><b><br>
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public synchronized static List<TestSuiteResult> readSummaryReportResult()
	{
		List<TestSuiteResult> results = new ArrayList<>();
		String excel = "TestResult.xls";
		File srcFile = new File("reporting/" + excel);
		File destDir = new File("output/reports/");
		File destFile = new File("output/reports/" + excel);
		try
		{
			if (!destFile.exists())
			{
				FileUtils.copyFileToDirectory(srcFile, destDir);
			}

			FileInputStream fi = new FileInputStream(destFile);
			HSSFWorkbook w = new HSSFWorkbook(fi);
			HSSFSheet s = w.getSheet("SummaryReport");

			Iterator<Row> rowIterator = s.iterator();
			rowIterator.next();
			while (rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				Cell browserVersionCell = row.getCell(0);
				Cell totalCell = row.getCell(1);
				Cell passedCell = row.getCell(2);
				Cell failedCell = row.getCell(3);
				Cell skippedCell = row.getCell(4);

				TestSuiteResult testSuiteResult = new TestSuiteResult();
				testSuiteResult.setBrowserVersion(browserVersionCell.getStringCellValue());
				testSuiteResult.setTotal(Integer.parseInt(totalCell.getStringCellValue()));
				testSuiteResult.setPassed(Integer.parseInt(passedCell.getStringCellValue()));
				testSuiteResult.setFailed(Integer.parseInt(failedCell.getStringCellValue()));
				testSuiteResult.setSkipped(Integer.parseInt(skippedCell.getStringCellValue()));

				results.add(testSuiteResult);
			}

			fi.close();

		}
		catch (FileNotFoundException e)
		{
			logger.error("FileNotFoundException Exception Occured " + e, e);
		}
		catch (IOException e)
		{
			logger.error("IOException Exception Occured " + e, e);
		}
		return results;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To write report in
	 * AutomationBuildHealthStatus.xlsx file <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param result
	 *        </font><b><br>
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public synchronized static void createAutomationBuildHealthStatusReport()
	{
		FileOutputStream fout = null;
		FileInputStream fi = null;
		XSSFWorkbook workbook = null;
		try
		{
			logger.info("============= Updating Automation_Build_Health_Status.xlsx file ==============");
			File destFile = new File(IConstants.buildHealthStatusReportFilePath);
			fi = new FileInputStream(destFile);
			workbook = new XSSFWorkbook(fi);
			XSSFSheet sheet = workbook.getSheetAt(0);

			// to get blank row
			int rows = sheet.getLastRowNum();

			fout = new FileOutputStream(destFile);

			for (TestSuiteResult testSuiteResult : Startup.result)
			{
				rows = rows + 1;
				Row row = sheet.createRow(rows);

				// to add suite name
				Cell suiteNameCell = row.createCell(0);
				suiteNameCell.setCellValue(testSuiteResult.getBrowserVersion());

				// total tcs
				Cell totalTcsCell = row.createCell(1);
				totalTcsCell.setCellValue(Integer.toString(testSuiteResult.getTotal()));

				// passed tcs
				Cell passedTcsCell = row.createCell(2);
				passedTcsCell.setCellValue(Integer.toString(testSuiteResult.getPassed()));

				// failed tcs
				Cell failedTcsCell = row.createCell(3);
				failedTcsCell.setCellValue(Integer.toString(testSuiteResult.getFailed()));

				// skipped tcs
				Cell skippedTcsCell = row.createCell(4);
				skippedTcsCell.setCellValue(Integer.toString(testSuiteResult.getSkipped()));

				// current date
				Cell currentDateCell = row.createCell(5);
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
				currentDateCell.setCellValue(dateFormat.format(date).toString());

				// URL
				Cell urlCell = row.createCell(6);
				urlCell.setCellValue(IConstants.URL);

				// Suite Type
				Cell suiteTypeCell = row.createCell(7);
				suiteTypeCell.setCellValue(IConstants.SUITE_TYPE);
			}
			workbook.write(fout);
		}
		catch (FileNotFoundException e)
		{
			logger.error("FileNotFoundException Exception Occured " + e, e);
		}
		catch (IOException e)
		{
			logger.error("IOException Exception Occured " + e, e);
		}
		finally
		{
			if (fout != null)
			{
				try
				{
					fout.close();
				}
				catch (IOException e)
				{
					logger.error("IOException Exception Occured " + e, e);
				}
			}
			if (fi != null)
			{
				try
				{
					fi.close();
				}
				catch (IOException e)
				{
					logger.error("IOException Exception Occured " + e, e);
				}
			}
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> To read list of PO's to Amend from Excel
	 * for RSL Tenant <br>
	 */
	public static List<String> readPoList() throws IOException, FileNotFoundException
	{
		List<String> poNumber = new ArrayList<String>();
		String fileName = "D:\\Workspace\\AmendPoList.xlsx";
		FileInputStream fis = new FileInputStream(new File(fileName));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		Iterator<Row> rowIterator = sh.iterator();
		Row row = rowIterator.next();
		Cell cell = null;
		String cellValue = null;
		String error = "";
		while (rowIterator.hasNext())
		{
			try
			{
				row = rowIterator.next();
				if (row != null)
				{
					cell = row.getCell(0);
					if (cell != null)
					{
						if (cell.getCellType() == 0)
						{
							cell.setCellType(Cell.CELL_TYPE_STRING);
						}
						cellValue = cell.getStringCellValue();
						poNumber.add(cellValue);
					}
					else
					{
						poNumber.add("null");
					}
				}
				else
				{
					error += "Row is Null";
				}
			}
			catch (Exception e)
			{
				logger.info("\n -------------- Error:> No row exists in excel : " + error + " --------------------\n" + e, e);
				throw e;
			}
		}
		return poNumber;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> To read COA data from excel<br>
	 * 
	 * @throws IOException
	 */

	public static List<CostBookingAndAccountingItemSummaryCOA> readCoaExcelData(String sheetName) throws IOException
	{
		List<CostBookingAndAccountingItemSummaryCOA> listCoaBO = new LinkedList<CostBookingAndAccountingItemSummaryCOA>();
		String dataFile = ConfigProperty.getConfig("coaDataFile");
		String fileName = ConfigProperty.getConfig("Input_Files_Location") + dataFile;
		try
		{
			FileInputStream fileInputStream = new FileInputStream(new File(fileName));
			HSSFWorkbook wb = new HSSFWorkbook(fileInputStream);

			HSSFSheet sh = wb.getSheet(sheetName);

			int totalRows = sh.getLastRowNum() - sh.getFirstRowNum();

			for (int i = 1; i <= totalRows; i++)
			{
				HashMap<String, String> excelData = new HashMap<String, String>();
				CostBookingAndAccountingItemSummaryCOA coaBoData = new CostBookingAndAccountingItemSummaryCOA();
				Row r = sh.getRow(i);
				int cellCount = r.getLastCellNum();

				for (int j = 0; j <= cellCount - 1; j++)
				{
					if (r.getCell(j) == null)
					{

					}
					else
						excelData.put(sh.getRow(0).getCell(j).toString(), r.getCell(j).toString());

				}

				// to fetch count of all rows from excel
				coaBoData.setTotalRows(totalRows);

				if (fileName.toLowerCase().contains((IConstantsData.AMFAM).toLowerCase()))
				{
					// setting BO values for AmFam
					coaBoData.setBusinessUnit(excelData.get("Business_Unit"));
					coaBoData.setGlAccount(excelData.get("GL_Account"));
					coaBoData.setCostCenter(excelData.get("Cost_Center"));
					coaBoData.setProject(excelData.get("Project"));
					coaBoData.setSubAccount(excelData.get("Sub_Account"));
					coaBoData.setProduct(excelData.get("Product"));
					coaBoData.setGeoAccount(excelData.get("GEO_Account"));
					coaBoData.setOperationalUnit(excelData.get("Operational_Limit"));
					coaBoData.setErrorMessage(excelData.get("Error_Message"));
					listCoaBO.add(coaBoData);
				}
				else if (fileName.toLowerCase().contains((IConstantsData.MAYER_BROWN).toLowerCase()))
				{
					// setting BO values for MayorBrown
					coaBoData.setBookCostTo(excelData.get("Book_Cost_To"));
					coaBoData.setMatter(excelData.get("Matter"));
					coaBoData.setClient(excelData.get("Client"));
					coaBoData.setGlAccount(excelData.get("GL_Account"));
					coaBoData.setEmployee_Timekeeper(excelData.get("Employee_Timekeeper"));
					coaBoData.setOffice(excelData.get("Office"));
					coaBoData.setDisbursementCode(excelData.get("Disbursement_Code"));
					coaBoData.setDepartment(excelData.get("Department"));
					coaBoData.setCostCenter(excelData.get("Profit_Center"));
					coaBoData.setDescription(excelData.get("Description"));
					coaBoData.setErrorMessage(excelData.get("Error_Message"));
					listCoaBO.add(coaBoData);
				}
			}
		}
		catch (Exception e)
		{
			logger.info("\n -------------- Error while fetching COA data: \n" + e, e);
			throw e;
		}

		return listCoaBO;
	}

}