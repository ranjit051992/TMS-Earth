package framework.utilities.helper_package;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import framework.frameworkUtilies.GlobalVariable;
import framework.startup.Startup;
import product.constants.iConstants;

public class GetData
{

	public static Logger logger = Logger.getLogger(GetData.class);

	/**
	 * ;
	 * 
	 * @description: getTestData reads data from Data Base and returns in the
	 *               form of hashmap;
	 * @param: Nil;
	 * @return: HashMap of DataBase data;
	 * @throws SQLException
	 */

	public static HashMap<String, String> getTestData() throws SQLException
	{
		HashMap<String, String> testDtaMap = new HashMap<String, String>();
		Connection con = null;
		String query = null;
		Statement stmt = null;
		ResultSet rs = null;

		// table is combination of TestData_ string and setup name;
		String columnName = GlobalVariable.SETUP + "_" + GlobalVariable.TENANT;
		logger.info("Selected Setup : " + GlobalVariable.SETUP);
		logger.info("Selected Tenant : " + GlobalVariable.TENANT);
		logger.info("Getting data from : " + columnName);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(GlobalVariable.DB_URL, GlobalVariable.DB_USER_NAME, GlobalVariable.DB_PASSWORD);
			query = "select FIELD_NAME," + columnName + " from TestData_eproc";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if (rs != null)
			{
				while (rs.next())
				{
					Startup.testDataMap.put(rs.getString("FIELD_NAME"), rs.getString(columnName));
				}
			}
			logger.info("testDtaMap size : " + Startup.testDataMap.size());
			logger.info("testDtaMap.toString() : " + Startup.testDataMap.toString());
			// setting local map data in global map;
		}
		catch (Exception e)
		{
			logger.error("Exception in getTestData method", e);
		}
		finally
		{
			con.close();
		}
		return testDtaMap;
	}

	/**
	 * ;
	 * 
	 * @description: getValueFromSpecificIndex returns value on specific "||"
	 *               separated index;
	 * @param: Field
	 *             name & Index;
	 * @return: value of given field & index;
	 */

	public static String getValueFromSpecificIndex(String field, int index)
	{

		HashMap<String, String> mapdata = new HashMap<String, String>();
		String data = null;
		try
		{

			String fieldData = Startup.testDataMap.get(field);

			if (fieldData != null)
			{
				String[] splitedData = fieldData.split("\\|\\|");
				if (index < splitedData.length)
				{
					data = splitedData[index].trim();

				}
				else
				{
					data = splitedData[0].trim();
					logger.error("index is greater then array size ");
				}
			}
			else
			{
				logger.error("We are getting null from testData for given field " + field);
			}
		}
		catch (Exception e)
		{
			logger.error("Exception in getValueFromSpecificIndex method", e);

		}
		return data;
	}

	/**
	 * ;
	 * 
	 * @description: getExcelData reads data from testdata excel file and
	 *               returns hashmap of those data;
	 * @param: Nil;
	 * @return: Map of excel data;
	 */

	public static void writeinExcel(String suiteName)
	{
		try
		{
			logger.info("suiteName   :  " + suiteName);
			String status = "";
			int count = 1;
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet hs = wb.createSheet(suiteName);
			logger.info(hs);
			hs.createRow(0).createCell(0).setCellValue("TestCaseName");
			hs.getRow(0).createCell(1).setCellValue("Status");
			Set<String> keysSet = iConstants.testCaseMapping.keySet();
			Iterator itr = keysSet.iterator();
			while (itr.hasNext())
			{
				hs.createRow(count).createCell(0).setCellValue(itr.next().toString());
				count++;
			}
			FileOutputStream fos = new FileOutputStream(new File( "./output/" + GlobalVariable.CURRENT_STATUS_FILE));
			wb.write(fos);

			fos.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
