/**
 * 
 */
package com.zycus.automation.boutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.constants.IConstants;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

/**
 * @author puneet.sharma
 *
 */
public class MappedTestCaseUtil
{

	static Logger logger = Logger.getLogger(MappedTestCaseUtil.class);

	public static MappedTestCase findMappedTestCase(String testCaseName)
	{
		try
		{
			//Connection variables load values from DB			
			String query = "select * from TestCase_eProc where Product_Name='eProc' and TestCase_Type='" + IConstants.MAPPED + "' and TestCase_Name='" + testCaseName + "'";

			//logger.info("Obtaining DB Connection for MappedTestCaseUtil:"+testCaseName);

			//to load jdbc class
			Class.forName("com.mysql.jdbc.Driver");

			//to obtain db connection
			Connection con = DriverManager.getConnection(ConfigProperty.getConfig("DB_URL"), ConfigProperty.getConfig("DB_Username"), ConfigProperty.getConfig("DB_Password"));

			//logger.info("Successfully connected to DB for MappedTestCaseUtil:"+testCaseName);

			//to execute statement on db
			Statement stmt = con.createStatement();

			//storing result of executed query
			ResultSet rs = stmt.executeQuery(query);
			MappedTestCase mappedTestCase = new MappedTestCase();
			while (rs.next())
			{
				String testMethodName = rs.getString(3);
				String testDescription = rs.getString(4);
				String moduleName = rs.getString(5);
				String executionStatus = rs.getString(6);
				String jiraId = rs.getString(8);

				mappedTestCase.setTestCaseName(testMethodName);
				mappedTestCase.setDescription(testDescription);
				mappedTestCase.setModuleName(moduleName);
				mappedTestCase.setExecution(executionStatus.contains("Y") || executionStatus.contains("y") ? true : false);
				mappedTestCase.setTestSkipped(true);

				// to verify jira id provided under mapping sheet
				if (jiraId == null)
				{
					mappedTestCase.setJiraId("NO JIRA ID");
				}
				else
				{
					mappedTestCase.setJiraId(jiraId);
				}
			}

			//closing connection
			con.close();

			return mappedTestCase;

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
		return null;
	}
}
