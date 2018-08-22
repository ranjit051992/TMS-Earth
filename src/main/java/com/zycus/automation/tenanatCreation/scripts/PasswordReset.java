package com.zycus.automation.tenanatCreation.scripts;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.zycus.automation.eproc.excelDatabaseReader.ExcelReader;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.tenanatCreation.bo.Tenant;
import com.zycus.automation.tenanatCreation.businessFlows.TenantCreationFlows;
import com.zycus.automation.tenanatCreation.utilities.excelReader.UIElementUtility;
import com.zycus.automation.tenanatCreation.utilities.loginLogout.LoginLogout;
import com.zycus.automation.tenanatCreation.utilities.resetPassword.ResetPassword;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class PasswordReset
{

	public static void main(String[] args)
	{
		try
		{
			WebDriver driver = null;
			TestCase testcase = new TestCase();
			testcase.setTestMethodName("Password Reset Process");
			String pathFordriver = ConfigProperty.getConfig("PATH_FOR_DRIVER");
			System.out.println("path for driver: " + pathFordriver);
			UIElementUtility.loadUiElements();

			//			//Chrome
			//			System.setProperty("webdriver.chrome.driver", "D:\\tenant\\tenantCreation\\exec\\chromedriver.exe");
			//			driver = new ChromeDriver();
			//Firefox
			System.setProperty("webdriver.firefox.marionette", pathFordriver);
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigProperty.getConfig("implicitWait")), TimeUnit.SECONDS);

			String testCaseName = "Tenant Creation";
			CommonServices.startTestCase(driver, testcase);
			driver.manage().window().maximize();

			driver.get(ConfigProperty.getConfig("URL"));
			ActionBot.defaultSleep();

			//			List<UserDetail> allUsers=new ArrayList<UserDetail>();

			//AMDIN LOGIN
			LoginLogout.login(driver, testcase, ConfigProperty.getConfig("AdminUsername"), ConfigProperty.getConfig("AdminPassword"));
			ActionBot.waitForPageLoad(driver);
			driver.get(ConfigProperty.getConfig("TMS_URL_COMPANY_LISTING"));
			ActionBot.waitForPageLoad(driver);

			Map<String, String> allUsers = ExcelReader.getTestDataComboFromFile("userList");
			Set<String> keys = allUsers.keySet();
			driver.get(ConfigProperty.getConfig("RESET_PASSWORD_LINK"));
			ActionBot.waitForElementToBeEnable(driver, ResetPassword.TEXTBOX_EMAILID_RESETPASSWORD, ActionBot.timeOut);

			Map<String, String> resultMap = new HashMap<>();

			for (String currentkey : keys)
			{
				driver.get(ConfigProperty.getConfig("RESET_PASSWORD_LINK"));
				ActionBot.waitForElementToBeEnable(driver, ResetPassword.TEXTBOX_EMAILID_RESETPASSWORD, ActionBot.timeOut);
				String password = ResetPassword.resetPassword(driver, testCaseName, currentkey.trim());
				if (!(password.trim().equals("")))
				{
					System.out.println("\tEmail id:" + currentkey + "\tPassword after reset: " + password);
					resultMap.put(currentkey.trim(), password.trim());
				}
			}
			ActionBot.click(driver, ResetPassword.LINK_BACK_TO_TMS);
			ActionBot.defaultSleep();

			driver.get(ConfigProperty.getConfig("TMS_URL_COMPANY_LISTING"));
			LoginLogout.logout(driver, testcase);
			ActionBot.waitForPageLoad(driver);
			Tenant tenant = new Tenant();
			tenant.setPasswordToSetForAdminUser("Kaas@43210");
			ActionBot.defaultSleep();
			FileWriter fw=new FileWriter("D:\\PasswordChangedUsers.txt");    
	           fw.write("->>>>>>>>>>\n");    
	           
			for (String currentUser : resultMap.keySet())
			{
				driver.get(ConfigProperty.getConfig("URL"));
				ActionBot.defaultSleep();
				//Login
				LoginLogout.login(driver, testcase, currentUser.trim(), resultMap.get(currentUser));
				ActionBot.waitForPageLoad(driver);
				ActionBot.defaultSleep();
				tenant.setEmailIdAdmin(currentUser.trim());
				TenantCreationFlows.changePassword(driver, testCaseName, tenant, resultMap.get(currentUser.trim()));
				System.out.println("Password changed for : "+currentUser);
				fw.write(currentUser+"\nOld Password: "+resultMap.get(currentUser.trim())+"\n\n");
				LoginLogout.logout(driver, testcase);
				ActionBot.waitForPageLoad(driver);
			}
			fw.close();    
			System.out.println("Done with changing passwords");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}

class UserDetail
{
	String	emailId;
	String	password;

	public String getEmailId()
	{
		return emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}
