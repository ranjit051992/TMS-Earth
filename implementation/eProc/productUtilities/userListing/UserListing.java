package eProc.productUtilities.userListing;

import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import framework.utilities.GlobalVariable;
import framework.reporting.TestReportingBO;
import framework.startup.Startup;
import framework.utilities.FileOperations;
import eProc.productUtilities.CommonUtilities;
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
	public static UserBO beforeLogin(WebDriver driver, TestReportingBO testcase) throws Exception
	{
		UserBO userBO = new UserBO();
		try
		{

			userBO = UserListing.reserveUser(driver, testcase);
		}
		catch (Exception e)
		{
			throw e;
		}
		return userBO;
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

	public static synchronized UserBO setUserInActive(WebDriver driver, TestReportingBO testcase) throws SQLException
	{

		UserBO userBO = new UserBO();

		try
		{
			if (Startup.usersList.size() != 0)
			{
//				user = Startup.usersList.get(0);
				Startup.usersList.remove(userBO);
				logger.info("setting isActive flag false for :: " + userBO.getUsername());
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

		return userBO;
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

	public static synchronized void setUserActive(UserBO userBO) throws Exception
	{

		try
		{
			if (userBO != null)
			{
				Startup.usersList.add(userBO);
				logger.info("setting isActive flag true for :: " + userBO.getUsername());
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
		UserBO userBO = null;

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
					userBO = new UserBO();
					userBO.setUsername(rs.getString("USERNAME"));
					userBO.setPassword(rs.getString("PASSWORD"));
					userBO.setTenant(rs.getString("TENANT_NAME"));
					userBO.setSetUpName(rs.getString("SETUP_NAME"));
					userBO.setRole(rs.getString("ROLE"));
					Startup.usersList.add(userBO);
					DataStore store = DataStoreFactory.getScenarioDataStore();
					store.put("UserBO", userBO);

				}
				logger.info("\nSetting values in user  :  " + userBO.getUsername() + "    " + userBO.getPassword() + "    " + userBO.getTenant() + "   " + userBO.getSetUpName() + "   " + userBO.getRole());
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

	public static UserBO reserveUser(WebDriver driver, TestReportingBO testcase) throws Exception
	{
		UserBO userBO = new UserBO();
		try
		{

			userBO = UserListing.setUserInActive(driver, testcase);
			FileOperations.writeInFile("./output/UserActivities.txt", userBO.getUsername() + " :: Reserved for :: " + testcase.getTestCaseName() + "  :: At " + CommonUtilities.currentdateTime("dd/MM/yyyy::HH:mm"));

		}
		catch (Exception e)
		{
			throw e;
		}
		return userBO;
	}

	public static void releaseUser(WebDriver driver, TestReportingBO testcase, UserBO userBO) throws Exception
	{
		try
		{
			if (userBO != null)
			{
				if (userBO.getUsername() != null)
				{
					UserListing.setUserActive(userBO);
					FileOperations.writeInFile("./output/UserActivities.txt", userBO.getUsername() + " :: Released By :: " + testcase.getTestCaseName() + "  :: At " + CommonUtilities.currentdateTime("dd/MM/yyyy::HH:mm"));
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
