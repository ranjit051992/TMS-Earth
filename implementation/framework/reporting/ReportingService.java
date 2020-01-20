package framework.reporting;

import framework.frameworkUtilies.GlobalVariable;
import framework.startup.Startup;
import framework.utilities.helper_package.FileOperations;
import org.apache.log4j.Logger;
import product.constants.iConstants;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReportingService
{
	static List<TestReportingBO>	testCaseList	= new ArrayList<TestReportingBO>();
	static Logger					logger			= Logger.getLogger(ReportingService.class);

	/**
	 * @author nitin.chourey;
	 * @description reportGenration Method inserts testcase data in
	 *              Automation_Report table in DB or write in txt file;
	 * @param Nil;
	 * @return Nil;
	 * @throws Exception
	 */
	public static void reportGenration() throws Exception
	{
		TestReportingBO testReportingBo = new TestReportingBO();
		int suitId = getUniqueSequence();
		Set<String> keysSet = iConstants.testCaseMapping.keySet();

		for (String jiraid : keysSet)
		{
			testReportingBo = Startup.testMethodTestCaseMap.get(jiraid);
			if (testReportingBo != null)
			{
		//	if (GlobalVariable.RUN_ON.equalsIgnoreCase("Grid"))
			//	{
					updatAutomationReportData(testReportingBo, suitId);
					logger.info(suitId + ",'" + testReportingBo.getJiraId() + "::::" + testReportingBo.getTestCaseName() + "::::" + testReportingBo.getTestcaseDescription() + "::::" + testReportingBo.getModule() + "::::" + testReportingBo.getUserStory() + "::::TempSuite::::" + testReportingBo.getAuthor() + "::::" + testReportingBo.getMessage() + "::::" + GlobalVariable.BROWSER + "::::eProc::::" + testReportingBo.getExecutionResult());
		//		}
		//	else
		//	{

					FileOperations.writeInFile("/output/report.txt", suitId + ",'" + testReportingBo.getJiraId() + "::::" + testReportingBo.getTestCaseName() + "::::" + testReportingBo.getTestcaseDescription() + "::::" + testReportingBo.getModule() + "::::" + testReportingBo.getUserStory() + "::::TempSuite::::" + testReportingBo.getAuthor() + "::::" + testReportingBo.getMessage() + "::::" + GlobalVariable.BROWSER + "::::eProc::::" + testReportingBo.getExecutionResult());

			//	}
			}
			else
			{
				logger.info("WARNING : No Object found for : " + jiraid);
			}
		}
	}

	/**
	 * @author nitin.chourey;
	 * @description collectTestCaseData collects all the data from
	 *              testCase_eproc and creates reporting bo objects;
	 * @param Nil;
	 * @return Nil;
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void collectTestCaseData() throws SQLException, IOException
	{

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(GlobalVariable.DB_URL, GlobalVariable.DB_USER_NAME, GlobalVariable.DB_PASSWORD);
			stmt = conn.createStatement();
			query = queryCreation();
			if (query != null)
			{
				rs = stmt.executeQuery(query);
				while (rs.next())
				{
					TestReportingBO testReportingBo = new TestReportingBO();

					String testcaseName = rs.getString("TESTCASE_NAME").trim();
					testReportingBo.setTestCaseName(testcaseName);
					testReportingBo.setTestcaseType(rs.getString("TESTCASE_TYPE").trim());
					testReportingBo.setTestcaseDescription(rs.getString("TESTCASE_DESCRIPTION").trim());
					testReportingBo.setAuthor(rs.getString("AUTHOR").trim());
					testReportingBo.setModule(rs.getString("TESTCASE_MODULE").trim());
					testReportingBo.setJiraId(rs.getString("JIRA_ID").trim());
					testReportingBo.setUserStory(rs.getString("USER_STORY").trim());
					testReportingBo.setExecutionResult("SKIPPED");
					testReportingBo.setMappedWith(rs.getString("MAPPED_WITH").trim());
					Startup.testMethodTestCaseMap.put(testcaseName, testReportingBo);
					if (!rs.getString("TESTCASE_TYPE").trim().equals("Mapped"))
					{
						Startup.executionMethods.put(testcaseName, testReportingBo);
						Startup.remainingMethods.add(testcaseName);
					}
					testReportingBo = null;
				}
				logger.info("\n\nTotal testcases(Including mapped) which will execute  : " + Startup.testMethodTestCaseMap.size());
				logger.info("\n\ntotal TestCases(@Test) Marked for Execution are       : " + Startup.executionMethods.size());
			}
			else
			{
				throw new Exception("Getting null query");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (!conn.isClosed())
			{
				conn.close();
			}
			stmt.close();
		}
	}

	/**
	 * @author nitin.chourey;
	 * @description updateResultInDB updates test case status in testcases_eproc
	 *              table ;
	 * @param String
	 *            testcase jiraId, String testcase status; @returnNil;
	 */
	public static void updateResultInDB(String Jiraid, String status)
	{

		Connection conn = null;
		Statement stmt = null;
		String query = null;
		ResultSet rs = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(GlobalVariable.DB_URL, GlobalVariable.DB_USER_NAME, GlobalVariable.DB_PASSWORD);
			stmt = conn.createStatement();
			query = "UPDATE `TestCases_eProc` SET EXECUTION_RESULT='" + status + "' WHERE JIRA_ID='" + Jiraid + "';";
			stmt.executeUpdate(query);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (!conn.isClosed())
				{
					conn.close();
				}
				stmt.close();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @author nitin.chourey;
	 * @description collectTestcaseMapping creates Map with parent testcase and
	 *              mapped cases;
	 * @param String
	 *            List of testcases in string format;
	 * @return Nil;
	 */
	public static void collectTestcaseMapping(String testCaseList)
	{

		Connection conn = null;
		Statement stmt = null;
		String query = null;
		ResultSet rs = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(GlobalVariable.DB_URL, GlobalVariable.DB_USER_NAME, GlobalVariable.DB_PASSWORD);
			stmt = conn.createStatement();
			query = "SELECT TESTCASE_NAME,MAPPED_WITH FROM `TestCases_eProc` WHERE  MAPPED_WITH IN(" + testCaseList + ");";
			logger.info("collectTestcaseMapping query : " + query);
			rs = stmt.executeQuery(query);
			while (rs.next())
			{
				iConstants.testCaseMapping.put(rs.getString("TESTCASE_NAME"), rs.getString("MAPPED_WITH"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (!conn.isClosed())
				{
					conn.close();
				}
				stmt.close();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @author nitin.chourey;
	 * @description updatAutomationReportData inserts REporting data in
	 *              Automation_Report table ;
	 * @param TestReportingBO
	 *            Reporting BO , Int suit id;
	 * @return Nil;
	 * @throws Exception
	 */
	public static void updatAutomationReportData(TestReportingBO testReportingBo, int suitId) throws Exception
	{

		Connection conn = null;
		Statement stmt = null;
		String query = null;
		ResultSet rs = null;
		String error_Message = testReportingBo.getMessage().replaceAll("'", "\"");
		String description = testReportingBo.getTestcaseDescription().replaceAll("'", "");
		String testCaseName = testReportingBo.getTestCaseName().replaceAll("'", "");
		String Setup_Name = GlobalVariable.SETUP;
		String Tenant_Name = GlobalVariable.TENANT;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(GlobalVariable.DB_URL, GlobalVariable.DB_USER_NAME, GlobalVariable.DB_PASSWORD);
			stmt = conn.createStatement();
			testReportingBo.getMessage();

			query = "INSERT INTO `Automation_Report` (SUITE_ID,JIRA_ID,TESTCASE_NAME,DESCRIPTION,MODULE_NAME,USER_STORY,SUITE_NAME,AUTHOR,ERROR_MESSAGE,BROWSER,PRODUCT_NAME,EXECUTION_RESULT,EXECUTION_DATE,SETUP,TENANT) VALUES(" + suitId + ",'" + testReportingBo.getJiraId() + "','" + testCaseName + "','" + description + "','" + testReportingBo.getModule() + "','" + testReportingBo.getUserStory() + "','TempSuite','" + testReportingBo.getAuthor() + "','" + error_Message + "','"
				+ GlobalVariable.BROWSER + "','eProc','" + testReportingBo.getExecutionResult() + "','" + GlobalVariable.EXECUTION_DATE_STAMP + "','" + GlobalVariable.SETUP + "','" + GlobalVariable.TENANT + "');";
			logger.info(query);
			stmt.executeUpdate(query);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (!conn.isClosed())
			{
				conn.close();
			}
			stmt.close();
		}
	}

	/**
	 * 
	 * @author nitin.chourey;
	 * @description getUniqueSequence generates unique sequence;
	 * @param Nil;
	 * @return int sequence;
	 * @throws SQLException
	 */
	public static int getUniqueSequence() throws SQLException
	{

		Connection conn = null;
		Statement stmt = null;
		String insertQuery = null;
		String seectQuery = null;
		int seq = 0;
		ResultSet rs = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(GlobalVariable.DB_URL, GlobalVariable.DB_USER_NAME, GlobalVariable.DB_PASSWORD);
			stmt = conn.createStatement();
			insertQuery = "INSERT INTO `CreateSequence` (DATA) VALUES('eProc');";
			seectQuery = "SELECT SEQUENCE FROM `CreateSequence` ORDER BY SEQUENCE DESC;";
			stmt.executeUpdate(insertQuery);
			rs = stmt.executeQuery(seectQuery);
			while (rs.next())
			{
				seq = rs.getInt("SEQUENCE");
				break;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (!conn.isClosed())
			{
				stmt.close();
				conn.close();
			}
		}
		logger.info("seq   :  " + seq);
		return seq;
	}

	/**
	 * @author nitin.chourey;
	 * @description queryCreation creates mysql query as par configuration;
	 * @param Nil;
	 * @return String query;
	 * @throws SQLException
	 */
	public static String queryCreation() throws Exception
	{
		List<String> testcasesList = framework.frameworkUtilies.FileOperations.getTestCaseList();
		String testcases = "";
		String query = null;
		if (testcasesList.size() > 0)
		{
			for (String tc : testcasesList)
			{
				tc = "'" + tc + "'";
				testcases = testcases + "," + tc;
			}
			logger.info("Testcases added in excel are : " + testcasesList.toString());
			testcases = testcases.substring(1, testcases.length());

			if (!testcases.isEmpty())
			{
				query = "SELECT TESTCASE_TYPE,TESTCASE_NAME,TESTCASE_DESCRIPTION,TESTCASE_MODULE,JIRA_ID,USER_STORY,MAPPED_WITH,AUTHOR,EXECUTION_RESULT FROM `TestCases_eProc`  WHERE MAPPED_WITH IN (SELECT TESTCASE_NAME FROM `TestCases_eProc` WHERE TESTCASE_NAME IN (" + testcases + ")) OR TESTCASE_NAME IN (" + testcases + ");";
			}
			else
			{
				throw new Exception("Empty Query");
			}
		}
		else if ("Sanity".equalsIgnoreCase(GlobalVariable.SUITE_TYPE))
		{
			query = "SELECT TESTCASE_TYPE,TESTCASE_NAME,TESTCASE_DESCRIPTION,TESTCASE_MODULE,JIRA_ID,USER_STORY,MAPPED_WITH,AUTHOR,EXECUTION_RESULT FROM `TestCases_eProc` WHERE USER_STORY='Sanity';";
		}
		else if ("Regression".equalsIgnoreCase(GlobalVariable.SUITE_TYPE))
		{
			if (!"All".equalsIgnoreCase(GlobalVariable.AUTHOR) && !"All".equalsIgnoreCase(GlobalVariable.MODULE))
			{
				query = "SELECT TESTCASE_TYPE,TESTCASE_NAME,TESTCASE_DESCRIPTION,TESTCASE_MODULE,JIRA_ID,USER_STORY,MAPPED_WITH,AUTHOR,EXECUTION_RESULT FROM `TestCases_eProc` WHERE TESTCASE_TYPE IN ('Regression','Mapped') AND TESTCASE_MODULE='" + GlobalVariable.MODULE + "' AND AUTHOR='" + GlobalVariable.AUTHOR + "';";
			}
			else if (!"All".equalsIgnoreCase(GlobalVariable.AUTHOR))
			{
				query = "SELECT TESTCASE_TYPE,TESTCASE_NAME,TESTCASE_DESCRIPTION,TESTCASE_MODULE,JIRA_ID,USER_STORY,MAPPED_WITH,AUTHOR,EXECUTION_RESULT FROM `TestCases_eProc` WHERE TESTCASE_TYPE IN ('Regression','Mapped') AND AUTHOR='" + GlobalVariable.AUTHOR + "';";
			}
			else if (!"All".equalsIgnoreCase(GlobalVariable.MODULE))
			{
				query = "SELECT TESTCASE_TYPE,TESTCASE_NAME,TESTCASE_DESCRIPTION,TESTCASE_MODULE,JIRA_ID,USER_STORY,MAPPED_WITH,AUTHOR,EXECUTION_RESULT FROM `TestCases_eProc` WHERE TESTCASE_TYPE IN ('Regression','Mapped') AND TESTCASE_MODULE='" + GlobalVariable.MODULE + "';";
			}
			else
			{
				query = "SELECT TESTCASE_TYPE,TESTCASE_NAME,TESTCASE_DESCRIPTION,TESTCASE_MODULE,JIRA_ID,USER_STORY,MAPPED_WITH,AUTHOR,EXECUTION_RESULT FROM `TestCases_eProc` WHERE TESTCASE_TYPE IN ('Regression','Mapped');";
			}
		}

		logger.info("query  : " + query);
		return query;
	}

	public static void testCaseMapping()
	{
		String tcname = "";
		String testcases = "";

		if (Startup.testMethodTestCaseMap.size() > 0)
		{
			for (String testcaseName : Startup.testMethodTestCaseMap.keySet())
			{
				tcname = tcname + "'" + testcaseName + "',";
			}
			testcases = tcname.substring(0, tcname.length() - 1);
			collectTestcaseMapping(testcases);
		}
		for (String parent : Startup.testMethodTestCaseMap.keySet())
		{
			iConstants.testCaseMapping.put(parent, "parentTestCase");
		}
		logger.info("iConstants.testCaseMapping............. " + iConstants.testCaseMapping.size());
	}

	public static void WriteCurrentStatus(String suitname)
	{

	}

	public static void beforeCase(String testCaseName)
	{
		for (String tcName : iConstants.testCaseMapping.keySet())
		{
			if (iConstants.testCaseMapping.get(tcName).equals(testCaseName))
			{
				iConstants.testCaseStatus.put(tcName, "Skipped");
			}

		}
		iConstants.testCaseStatus.put(testCaseName, "Skipped");

	}

	public static void afterCase()
	{
		for (String tcName : iConstants.testCaseStatus.keySet())
		{
			if (iConstants.testCaseStatus.get(tcName).equals("Skipped"))
			{
				iConstants.skippedCases.add(tcName);
			}

		}

	}
}
