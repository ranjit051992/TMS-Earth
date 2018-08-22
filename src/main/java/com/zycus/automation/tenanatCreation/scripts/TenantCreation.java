package com.zycus.automation.tenanatCreation.scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumhq.jetty9.util.PathWatcher.Config;

import com.zycus.automation.bo.User;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.tenanatCreation.bo.Master;
import com.zycus.automation.tenanatCreation.bo.Roles;
import com.zycus.automation.tenanatCreation.bo.SimConfiguration;
import com.zycus.automation.tenanatCreation.bo.SystemLevelConfiguration;
import com.zycus.automation.tenanatCreation.bo.Tenant;
import com.zycus.automation.tenanatCreation.businessFlows.CreateSystemTenantConfiguration;
import com.zycus.automation.tenanatCreation.businessFlows.CreateTenantFlow;
import com.zycus.automation.tenanatCreation.businessFlows.SimConfigurationFlow;
import com.zycus.automation.tenanatCreation.businessFlows.TenantCreationFlows;
import com.zycus.automation.tenanatCreation.businessFlows.UserSummary;
import com.zycus.automation.tenanatCreation.pageObjects.adminConfiguration.FlowAdminConfiguration;
import com.zycus.automation.tenanatCreation.pageObjects.simConfiguration.FlowSimConfiguration;
import com.zycus.automation.tenanatCreation.pageObjects.simConfiguration.SimConfigurations;
import com.zycus.automation.tenanatCreation.pageObjects.tmsCompanyCreation.FlowTmsCompanyCreation;
import com.zycus.automation.tenanatCreation.pageObjects.tmsCompanyCreation.TmsCompanyCreationPage;
import com.zycus.automation.tenanatCreation.utilities.ChangePassword;
import com.zycus.automation.tenanatCreation.utilities.IConstants.IConstantData;
import com.zycus.automation.tenanatCreation.utilities.excelReader.ExcelReader;
import com.zycus.automation.tenanatCreation.utilities.excelReader.UIElementUtility;
import com.zycus.automation.tenanatCreation.utilities.loginLogout.LoginLogout;
import com.zycus.automation.tenanatCreation.utilities.objectCreation.DefaultObjectCreation;
import com.zycus.automation.tenanatCreation.utilities.resetPassword.ResetPassword;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class TenantCreation
{
	public static List<String>	fileNamesForSimCMasterData	= new ArrayList<String>();

	static Logger				logger						= Logger.getLogger(TenantCreation.class);

	static Map<String, String>	filesForUploadOfMasterData	= new HashMap<String, String>();

	public static void createTenantinTMS(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		UIElementUtility.loadUiElements();
		try
		{
			String pathFordriver = ConfigProperty.getConfig("PATH_FOR_DRIVER");
			System.out.println("path for driver: " + pathFordriver);

//						//Chrome
//						System.setProperty("webdriver.chrome.driver",pathFordriver);
//						driver = new ChromeDriver();
			//Firefox
			System.setProperty("webdriver.firefox.marionette", pathFordriver);
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigProperty.getConfig("implicitWait")), TimeUnit.SECONDS);

			String testCaseName = "Tenant Creation";
			CommonServices.startTestCase(driver, testCase);
			driver.manage().window().maximize();

			Tenant tenant = DefaultObjectCreation.getNewTenantObject();

			driver.get(ConfigProperty.getConfig("URL"));
			ActionBot.defaultSleep();

			//AMDIN LOGIN
			LoginLogout.login(driver, testCase, ConfigProperty.getConfig("AdminUsername"), ConfigProperty.getConfig("AdminPassword"));

			//CREATE TENANT
			logger.info("================CREATING COMPANY==================");
			CreateTenantFlow.createCompany(driver, testCaseName, tenant);

			//FILL ALL REGISTRY VALUES
			TenantCreationFlows.addRegistry(driver, testCaseName, tenant);

			//ASSIGN ROLE
			TenantCreationFlows.selectRoles(driver, testCaseName, tenant);

			//FILLING SYSTEM TENANT CONFIGURATION FOR CMD
			TenantCreationFlows.fillSystemTenantConfigForCMD(driver, testCaseName, tenant);

			String passwordForAdminUser = TenantCreationFlows.resetPassword(driver, testCaseName, tenant);

			//CONFIGURE CLIENT IN SIM
			TenantCreationFlows.configureClientInSIM(driver, testCaseName, tenant);

			//ADMIN LOGOUT
			driver.get(ConfigProperty.getConfig("TMS_URL_COMPANY_LISTING"));
			LoginLogout.logout(driver, testCase);
			ActionBot.waitForPageLoad(driver);

			//SYSTEM TENANT CONFIGURATION-> GETTING DETAILS FOR ADMIN USER
			User companyAdminUser = new User();
			companyAdminUser.setUsername(tenant.getEmailIdAdmin());
			companyAdminUser.setDisplayName(tenant.getDisplayNameAdmin());
			companyAdminUser.setPassword(tenant.getPasswordToSetForAdminUser());

			//CLIENT ADMIN LOGIN
			LoginLogout.login(driver, testCase, companyAdminUser.getUsername(), passwordForAdminUser);
			ActionBot.waitForPageLoad(driver);

			//CHANGE CLIENT ADMIN PASSWORD
			TenantCreationFlows.changePassword(driver, testCaseName, tenant, passwordForAdminUser);

			TenantCreationFlows.fillSystemTenantConfigurationForEprocEcatalogEinvoice(driver, testCaseName, tenant, passwordForAdminUser);

			//SIM CONFIGURATION STARTS
			TenantCreationFlows.completeSimConfigurations(driver, testCaseName, tenant);

			//MASTER DATA CMD FILLING
			TenantCreationFlows.fillCMDMasterData(driver, testCaseName);
			
			//CLIENT ADMIN LOGOUT
			LoginLogout.logout(driver, testCase);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		/*
		 * catch (AssertionError e) { CommonServices.assertionMethod(driver,
		 * testCase, user, e); } catch (Exception e) {
		 * CommonServices.exceptionMethod(driver, testCase, user, e); }
		 */
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	public static void configureSIM(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		UIElementUtility.loadUiElements();
		String testCaseName = "Tenant Creation";
		try
		{

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	public static void main(String[] args)
	{
		TestCase testcase = new TestCase();
		testcase.setTestMethodName("Tenant Creation Process");
		try
		{
			createTenantinTMS(testcase);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void loadFilesForSimConfiguration()
	{
		fileNamesForSimCMasterData.add("Facility_Master.txt");
		fileNamesForSimCMasterData.add("INCO_Terms.txt");
		fileNamesForSimCMasterData.add("Legal_Structure.txt");
		fileNamesForSimCMasterData.add("Payment_Terms.txt");
		fileNamesForSimCMasterData.add("Payment_Type.txt");
		fileNamesForSimCMasterData.add("PO_Submission.txt");
		fileNamesForSimCMasterData.add("Supplier_Type.txt");
		fileNamesForSimCMasterData.add("System_Master.txt");
		fileNamesForSimCMasterData.add("System_Plant_Relation.txt");
		fileNamesForSimCMasterData.add("Transaction_Count.txt");

	}
}
