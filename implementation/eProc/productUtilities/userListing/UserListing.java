package eProc.productUtilities.userListing;

import framework.frameworkUtilies.GlobalVariable;
import framework.frameworkUtilies.testResult.TestReportingBO;
import framework.startup.Startup;
import framework.utilities.helper_package.FileOperations;
import framework.utilities.helper_package.commonUtilities;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.sql.*;

public class UserListing
{

	public static Logger logger = Logger.getLogger(UserListing.class);

	/**
	 * ;
	 * 
	 * @author nitin.chourey;
	 * @description: beforeLogin gets the available user from database and set
	 *               that user inactive for others ;
	 * @param: User
	 *             object;
	 * @return: User object;
	 * @throws Exception
	 */
	public static User beforeLogin(WebDriver driver, TestReportingBO testcase) throws Exception
	{
		User user = new User();
		try
		{

			user = UserListing.reserveUser(driver, testcase);
		}
		catch (Exception e)
		{
			throw e;
		}
		return user;
	}

	/**
	 * ;
	 * 
	 * @author nitin.chourey;
	 * @description: setUserInActive sets given user reserved till test case
	 *               execution;
	 * @param: User
	 *             name;
	 * @return: nil;
	 * @throws SQLException
	 */

	public static synchronized User setUserInActive(WebDriver driver, TestReportingBO testcase) throws SQLException
	{

		User user = new User();

		try
		{
			if (Startup.usersList.size() != 0)
			{
				user = Startup.usersList.get(0);
				Startup.usersList.remove(user);
				logger.info("setting isActive flag false for :: " + user.getUsername());
				logger.info("after reserving available users  :  " + Startup.usersList.size());

			}
			else
			{
				logger.error("No user available");
			}
		}
		catch (Exception e)
		{
			logger.error("Exception in setUserInActive method", e);
		}

		return user;
	}

	/**
	 * ;
	 * 
	 * @author nitin.chourey;
	 * @description: setUserActive releases given user after test case
	 *               execution;
	 * @param: User
	 *             name;
	 * @return: nil;
	 * @throws SQLException
	 */

	public static synchronized void setUserActive(User user) throws Exception
	{

		try
		{
			if (user != null)
			{
				Startup.usersList.add(user);
				logger.info("setting isActive flag true for :: " + user.getUsername());
				logger.info("after releasing available users  :  " + Startup.usersList.size());

			}
			else
			{
				logger.error("Getting null user can't add in user list");
			}
		}
		catch (Exception e)
		{
			logger.error("Exception in setUserActive method", e);
			throw e;
		}

	}

	/**
	 * ;
	 * 
	 * @author nitin.chourey;
	 * @description: getUserCerdential returns user object with given role;
	 * @param: user
	 *             role;
	 * @return: user object;
	 * @throws SQLException
	 */
	public static void collectUserData() throws SQLException
	{
		Connection con = null;
		String query = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = null;

		logger.info("\nGetting data for Setup: " + GlobalVariable.SETUP + "  and Tenant :" + GlobalVariable.TENANT);

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(GlobalVariable.DB_URL, GlobalVariable.DB_USER_NAME, GlobalVariable.DB_PASSWORD);
			query = "select * from eProc_credentials where TENANT_NAME='" + GlobalVariable.TENANT + "' and SETUP_NAME='" + GlobalVariable.SETUP + "'";
			logger.info("Executing  : " + query);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if (rs != null)
			{
				while (rs.next())
				{
					user = new User();
					user.setUsername(rs.getString("USERNAME"));
					user.setPassword(rs.getString("PASSWORD"));
					user.setTenant(rs.getString("TENANT_NAME"));
					user.setSetUpName(rs.getString("SETUP_NAME"));
					user.setRole(rs.getString("ROLE"));
					Startup.usersList.add(user);

				}
				logger.info("\nSetting values in user  :  " + user.getUsername() + "    " + user.getPassword() + "    " + user.getTenant() + "   " + user.getSetUpName() + "   " + user.getRole());
			}
			else
			{
				logger.info("Sorry!!! No active user available");
			}

		}
		catch (

		Exception e)
		{
			logger.error("Exception in getTestData method", e);
		}
		finally
		{
			con.close();
			logger.info("  connection closed   ");
		}

	}

	public static User reserveUser(WebDriver driver, TestReportingBO testcase) throws Exception
	{
		User user = new User();
		try
		{

			user = UserListing.setUserInActive(driver, testcase);
			FileOperations.writeInFile("./output/UserActivities.txt", user.getUsername() + " :: Reserved for :: " + testcase.getTestCaseName() + "  :: At " + commonUtilities.currentdateTime("dd/MM/yyyy::HH:mm"));

		}
		catch (Exception e)
		{
			throw e;
		}
		return user;
	}

	public static void releaseUser(WebDriver driver, TestReportingBO testcase, User user) throws Exception
	{
		try
		{
			if (user != null)
			{
				if (user.getUsername() != null)
				{
					UserListing.setUserActive(user);
					FileOperations.writeInFile("./output/UserActivities.txt", user.getUsername() + " :: Released By :: " + testcase.getTestCaseName() + "  :: At " + commonUtilities.currentdateTime("dd/MM/yyyy::HH:mm"));
				}
			}
			else
			{
				logger.error("Getting null value for user");
			}
		}
		catch (Exception e)
		{
			throw e;
		}
	}
}
