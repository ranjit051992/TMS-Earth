package com.zycus.framework.framework_version_2_4.testcaseMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.zycus.automation.constants.IConstants;
import com.zycus.framework.framework_version_2_4.constants.FrameworkConstants;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class SanityRegressionMapping implements FrameworkConstants
{

	public static final String						executionStatus		= "y";
	static Logger									logger				= Logger.getLogger(SanityRegressionMapping.class);

	private static Map<String, String>				sanityTC			= null;
	private static Map<String, Map<String, String>>	regTC				= null;
	private static Map<String, Map<String, String>>	userMappedTC		= null;
	private static HSSFWorkbook						workbook			= null;
	private static FileInputStream					fileInputStream		= null;
	private static String							fileName			= ConfigProperty.getConfig("Test_Case_File");
	private static String							inputFileLocation	= ConfigProperty.getConfig("Input_Files_Location");

	private static FileInputStream createIOStream() throws FileNotFoundException
	{
		return new FileInputStream(new File(inputFileLocation + fileName));
	}

	private static void closeIOStream(FileInputStream IOSTREAM)
	{
		try
		{
			IOSTREAM.close();
		}
		catch (IOException e)
		{
			logger.error("IOEXCEPTION OCCURCED " + e, e);
		}

	}

	public static Map<String, String> getSanityTC()
	{
		sanityTC = new LinkedHashMap<String, String>();

		//DB connection
		try
		{
			//Connection variables load values from DB			
			//String query = "select * from TestCase_eProc where Product_Name='eProc' and TestCase_Type='" + suiteType + "'";

			String query = "select * from TestCase_eProc where Product_Name='eProc' and TestCase_Type='" + IConstants.SANITY + "'";

			logger.info("Obtaining DB Connection for TestCases");

			//to load jdbc class
			Class.forName("com.mysql.jdbc.Driver");

			//to obtain db connection
			Connection con = DriverManager.getConnection(ConfigProperty.getConfig("DB_URL"), ConfigProperty.getConfig("DB_Username"), ConfigProperty.getConfig("DB_Password"));

			logger.info("Successfully connected to DB for TestCases");

			//to execute statement on db
			Statement stmt = con.createStatement();

			//storing result of executed query
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next())
			{
				String testCase_Name = rs.getString(3);
				String testCase_Desc = rs.getString(4);
				sanityTC.put(testCase_Name, testCase_Desc);
			}

			//closing connection
			con.close();
		}
		catch (ClassNotFoundException e1)
		{
			logger.info("Exception received while registering jdbc driver. Exception: " + e1);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return sanityTC;
	}

	private static Map<String, Map<String, String>> getRegTC()
	{
		regTC = new LinkedHashMap<String, Map<String, String>>();
		try
		{
			fileInputStream = createIOStream();
			workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet regSheet = workbook.getSheetAt(1);
			Iterator<Row> rowIterator = regSheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				Map<String, String> tempMap = new LinkedHashMap<String, String>();
				Cell regSheetTC_ID = row.getCell(0);
				// Cell regSheet_Mapping_ID = row.getCell(1);
				Cell regDescription_ID = row.getCell(1);
				Cell excution_ID = row.getCell(3);
				tempMap.put(description, regDescription_ID.getStringCellValue());

				/*
				 * switch (regSheet_Mapping_ID.getCellType()) { case
				 * Cell.CELL_TYPE_NUMERIC: { String value =
				 * Double.toString(regSheet_Mapping_ID.getNumericCellValue());
				 * tempMap.put(mappingID, value.trim()); break; } case
				 * Cell.CELL_TYPE_STRING: { tempMap.put(mappingID,
				 * regSheet_Mapping_ID.getStringCellValue()); break; } }
				 */
				tempMap.put(executionStatus, excution_ID.getStringCellValue());
				regTC.put(regSheetTC_ID.getStringCellValue(), tempMap);
			}
			closeIOStream(fileInputStream);
		}
		catch (IOException e)
		{
			logger.error("IOEXCEPTION OCCURCED " + e, e);
		}
		return regTC;
	}

	public static Map<String, LinkedList<String>> getMappingDone()
	{
		Map<String, LinkedList<String>> SanityToRegTC = new LinkedHashMap<String, LinkedList<String>>();
		regTC = getRegTC();
		sanityTC = getSanityTC();
		LinkedList<String> regTCMapping = new LinkedList<String>();
		for (Map.Entry<String, String> iterateSanityTC : sanityTC.entrySet())
		{
			for (Map.Entry<String, Map<String, String>> regTCKey : regTC.entrySet())
			{
				if (regTCKey.getValue().get(mappingID) == iterateSanityTC.getValue() || regTCKey.getValue().get(mappingID).equalsIgnoreCase(iterateSanityTC.getValue()))
				{
					regTCMapping.add(regTCKey.getKey());
				}
			}
			SanityToRegTC.put(iterateSanityTC.getKey(), regTCMapping);
		}
		return SanityToRegTC;
	}

	public static Map<String, LinkedList<String>> getMappedWithItSelf()
	{
		Map<String, LinkedList<String>> getRegTCMappedWithItSelf = new LinkedHashMap<String, LinkedList<String>>();
		regTC = getRegTC();
		LinkedList<String> regTCMapping = new LinkedList<String>();
		for (Map.Entry<String, Map<String, String>> regTCKey : regTC.entrySet())
		{
			regTCMapping.add(regTCKey.getKey());
			getRegTCMappedWithItSelf.put(regTCKey.getKey(), regTCMapping);
		}
		return getRegTCMappedWithItSelf;
	}

	public static String getReqMappingID(String ID)
	{
		if (regTC.containsKey(ID))
		{
			return regTC.get(ID).get(mappingID);
		}
		else
		{
			logger.error("Mapping ID Not Found");
			return null;
		}
	}

	public static Map<String, Map<String, String>> regTC()
	{
		// return regTC;
		return getRegTC();
	}

	public static Map<String, String> sanityTC()
	{
		return getSanityTC();
	}

	@SuppressWarnings("unused")
	public static Map<String, Map<String, String>> getUserMappedTC()
	{
		userMappedTC = new LinkedHashMap<String, Map<String, String>>();
		try
		{
			fileInputStream = createIOStream();
			workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet regSheet = workbook.getSheetAt(3);
			Iterator<Row> rowIterator = regSheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				Map<String, String> tempMap = new LinkedHashMap<String, String>();
				Cell regSheetTC_ID = row.getCell(0);
				Cell regSheet_Mapping_ID = row.getCell(1);
				Cell regDescription_ID = row.getCell(2);
				row.getCell(3);
				Cell reqSKippedOrExecute = row.getCell(4);
				String desc = null;
				final String SKIPPED = "SKIPPED";
				final String EXECUTE = "EXECUTE";
				final String RUN = "Y";
				final String NO_RUN = "N";

				String doRun = null;
				if (reqSKippedOrExecute == null)
				{
					desc = regDescription_ID.getStringCellValue();
				}
				else
				{
					if (reqSKippedOrExecute.getStringCellValue().trim().equals(""))
					{
						desc = regDescription_ID.getStringCellValue();
					}
					else
					{
						doRun = reqSKippedOrExecute.getStringCellValue();
					}
				}
				if (doRun != null)
				{
					if (doRun.equalsIgnoreCase(EXECUTE) || doRun.equalsIgnoreCase(RUN))
					{
						desc = regDescription_ID.getStringCellValue();
					}
					else if (doRun.equalsIgnoreCase(SKIPPED) || doRun.equalsIgnoreCase(NO_RUN))
					{
						desc = "NO";
					}
				}
				tempMap.put(description, desc);

				switch (regSheet_Mapping_ID.getCellType())
				{
					case Cell.CELL_TYPE_NUMERIC: {
						String value = Double.toString(regSheet_Mapping_ID.getNumericCellValue());
						tempMap.put(mappingID, value.trim());
						break;
					}
					case Cell.CELL_TYPE_STRING: {
						tempMap.put(mappingID, regSheet_Mapping_ID.getStringCellValue());
						break;
					}
				}
				userMappedTC.put(regSheetTC_ID.getStringCellValue(), tempMap);
			}
			closeIOStream(fileInputStream);
		}
		catch (IOException e)
		{
			logger.error("IOEXCEPTION OCCURCED " + e, e);
		}
		return userMappedTC;
	}
}
