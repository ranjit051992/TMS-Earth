package com.zycus.automation.tenanatCreation.businessFlows;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.tenanatCreation.bo.Master;
import com.zycus.automation.tenanatCreation.bo.MasterDataCmd;
import com.zycus.automation.tenanatCreation.bo.Roles;
import com.zycus.automation.tenanatCreation.bo.SimConfiguration;
import com.zycus.automation.tenanatCreation.bo.SystemLevelConfiguration;
import com.zycus.automation.tenanatCreation.bo.Tenant;
import com.zycus.automation.tenanatCreation.pageObjects.adminConfiguration.FlowAdminConfiguration;
import com.zycus.automation.tenanatCreation.pageObjects.masterData.MasterDataImpl;
import com.zycus.automation.tenanatCreation.pageObjects.simConfiguration.FlowSimConfiguration;
import com.zycus.automation.tenanatCreation.pageObjects.simConfiguration.SimConfigurations;
import com.zycus.automation.tenanatCreation.pageObjects.tmsCompanyCreation.FlowTmsCompanyCreation;
import com.zycus.automation.tenanatCreation.pageObjects.tmsCompanyCreation.TmsCompanyCreationPage;
import com.zycus.automation.tenanatCreation.scripts.TenantCreation;
import com.zycus.automation.tenanatCreation.utilities.ChangePassword;
import com.zycus.automation.tenanatCreation.utilities.IConstants.IConstantData;
import com.zycus.automation.tenanatCreation.utilities.excelReader.ExcelReader;
import com.zycus.automation.tenanatCreation.utilities.objectCreation.DefaultObjectCreation;
import com.zycus.automation.tenanatCreation.utilities.resetPassword.ResetPassword;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class TenantCreationFlows
{
	static Logger logger = Logger.getLogger(TenantCreationFlows.class);

	public static void addRegistry(WebDriver driver, String testCaseName, Tenant tenant) throws ActionBotException
	{
		// edit company
		logger.info("================EDIT COMPANY==================");
		CreateTenantFlow.editCompany(driver, testCaseName, tenant.getCompanyName());

		// Fill all registry values
		logger.info("================FILLING ALL REGISTRY VALUES FOR COMPANY==================");
		CreateTenantFlow.flowAddAllRegistryValues(driver, testCaseName, tenant);
	}

	public static void selectRoles(WebDriver driver, String testCaseName, Tenant tenant) throws ActionBotException
	{
		// flow to give roles and assign role to specific user
		driver.get(ConfigProperty.getConfig("TMS_URL_COMPANY_LISTING"));
		ActionBot.waitForPageLoad(driver);

		// manage users
		logger.info("================MANAGE USERS-> TO SELECT ROLES==================");
		CreateTenantFlow.manageUsersAndRolesForCompany(driver, testCaseName, tenant.getCompanyName());

		// search admin user
		CreateTenantFlow.searchUser(driver, testCaseName, tenant.getEmailIdAdmin(), IConstantData.searchByEmailId);

		// edit user
		ActionBot.click(driver, TmsCompanyCreationPage.EDIT_COMPANY_ICON);

		// flow to add roles
		List<Roles> allRoles = ExcelReader.getAllRoles(driver, testCaseName);
		UserSummary.addRoles(driver, testCaseName, allRoles);
	}

	public static void fillSystemTenantConfigForCMD(WebDriver driver, String testCaseName, Tenant tenant) throws Exception
	{

		SystemLevelConfiguration systemLevelConfiguration_cmd = DefaultObjectCreation.getSystemTenantConfigurationObject(IConstantData.sheetName_cmd);

		logger.info("================FILLING SYSTEM TENANT CONFIGURATION FOR CMD==================");

		driver.get(ConfigProperty.getConfig("TMS_URL_COMPANY_LISTING"));
		ActionBot.waitForPageLoad(driver);

		CreateTenantFlow.manageUsersAndRolesForCompany(driver, testCaseName, tenant.getCompanyName());
		ActionBot.waitForPageLoad(driver);

		FlowTmsCompanyCreation.clickOnHeaderMasterTab(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);

		FlowAdminConfiguration.goToSystemLevelTenantConfigurationPage(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);

		CreateSystemTenantConfiguration.fillSystemTenantConfiguration(driver, testCaseName, systemLevelConfiguration_cmd, tenant, IConstantData.sheetName_cmd);
	}

	public static String resetPassword(WebDriver driver, String testCaseName, Tenant tenant) throws Exception
	{

		driver.get(ConfigProperty.getConfig("TMS_URL_COMPANY_LISTING"));
		ActionBot.waitForPageLoad(driver);

		logger.info("================RESETING PASSWORD FOR ADMIN USER==================");
		String passwordForAdminUser = ResetPassword.resetPassword(driver, testCaseName, tenant.getEmailIdAdmin());
		System.out.println("Password after reset: " + passwordForAdminUser);
		ActionBot.click(driver, ResetPassword.LINK_BACK_TO_TMS);
		ActionBot.defaultSleep();
		return passwordForAdminUser;
	}

	public static void configureClientInSIM(WebDriver driver, String testCaseName, Tenant tenant) throws Exception
	{
		// To Configure Client in SIM
		logger.info("================CONFIGURING CLIENT IN SIM==================");
		driver.get(ConfigProperty.getConfig("SIM_URL_ADMIN"));
		ActionBot.waitForPageLoad(driver);

		// flow to configure client in sim
		SimConfigurationFlow.configureClientInSIM(driver, testCaseName, tenant.getClientDetails());
	}

	public static void changePassword(WebDriver driver, String testCaseName, Tenant tenant, String passwordForAdminUser) throws Exception
	{

		// method to change password
		logger.info("================SETTING USER GIVEN PASSWORD FOR ADMIN USER==================");
		ChangePassword.changePassword(driver, testCaseName, tenant.getEmailIdAdmin(), passwordForAdminUser, tenant.getPasswordToSetForAdminUser());
		ActionBot.waitForPageLoad(driver);

	}

	public static void fillSystemTenantConfigurationForEprocEcatalogEinvoice(WebDriver driver, String testCaseName, Tenant tenant, String passwordForAdminUser) throws Exception
	{

		driver.get(ConfigProperty.getConfig("URL"));
		ActionBot.waitForPageLoad(driver);

		SystemLevelConfiguration systemLevelConfiguration_Eproc = DefaultObjectCreation.getSystemTenantConfigurationObject(IConstantData.sheetName_eproc);
		SystemLevelConfiguration systemLevelConfiguration_Ecatalog = DefaultObjectCreation.getSystemTenantConfigurationObject(IConstantData.sheetName_ecatalog);
		SystemLevelConfiguration systemLevelConfiguration_eInvoice = DefaultObjectCreation.getSystemTenantConfigurationObject(IConstantData.sheetName_einvoice);

		logger.info("================FILLING SYSTEM TENANT CONFIGURATION FOR EPROC==================");
		CreateSystemTenantConfiguration.fillSystemTenantConfiguration(driver, testCaseName, systemLevelConfiguration_Eproc, tenant, IConstantData.sheetName_eproc);

		// click on catalog tab
		MainPageHeaderLevelTab.clickOnCatalogTopTab(driver, testCaseName);

		logger.info("================FILLING SYSTEM TENANT CONFIGURATION FOR ECATALOG==================");
		CreateSystemTenantConfiguration.fillSystemTenantConfiguration(driver, testCaseName, systemLevelConfiguration_Ecatalog, tenant, IConstantData.sheetName_ecatalog);
		ActionBot.defaultSleep();

		driver.get(ConfigProperty.getConfig("EINVOICE_URL"));
		ActionBot.waitForPageLoad(driver);

		logger.info("================FILLING SYSTEM TENANT CONFIGURATION FOR EINVOICE==================");
		CreateSystemTenantConfiguration.fillSystemTenantConfiguration(driver, testCaseName, systemLevelConfiguration_eInvoice, tenant, IConstantData.sheetName_einvoice);

		logger.info("================FILLING SYSTEM TENANT CONFIGURATIONS COMPLETED!!!==================");

	}

	public static void completeSimConfigurations(WebDriver driver, String testCaseName, Tenant tenant) throws Exception
	{

		// SIM CONFIGURATION STARTS
		driver.get(ConfigProperty.getConfig("SIM_URL"));
		ActionBot.waitForPageLoad(driver);

		logger.info("================STARTING SIM CONFIGURATION==================");

		List<Master> masterList = ExcelReader.readMasterValues(driver, testCaseName);
		SimConfiguration simConfg = DefaultObjectCreation.getSIMObject();

		logger.info("================FILLING SIM MASTER VALUES==================");
		SimConfigurationFlow.fillMasterValues(driver, testCaseName, simConfg, masterList, tenant.getCompanyName(), tenant.getClientDetails().getClientIdentifier());

		TenantCreation.loadFilesForSimConfiguration();
		SimConfigurationFlow.remaneFilesForSIMMasterData(driver, testCaseName, simConfg.getSimMasterDataFilesLocation(), tenant.getClientDetails().getClientIdentifier(),
			TenantCreation.fileNamesForSimCMasterData);

		logger.info("================STARTING TO UPLOAD FILES==================");
		SimConfigurationFlow.uploadMasterDataFiles(driver, testCaseName, tenant.getClientDetails().getClientIdentifier(), simConfg.getSimMasterDataFilesLocation());

		logger.info("================CHANGES MADE IN GLOBAL PAYMENT TERM==================");
		SimConfigurationFlow.configureManageViewsForPurchaseDetails(driver, testCaseName, tenant.getClientDetails());
		ActionBot.defaultSleep();

		FlowSimConfiguration.clickOnLinkBackToManageViews(driver, testCaseName);
		ActionBot.waitForElementToBeEnable(driver, SimConfigurations.BUTTON_CREATE_VIEW, ActionBot.timeOut);

		logger.info("================CHANGES FOR MANDATORY TO FILL_NO FOR PAYMENT TERM==================");
		FlowSimConfiguration.clickOnExpandViewPurchasing(driver, testCaseName);
		FlowSimConfiguration.clickOnEditPaymentTerms(driver, testCaseName);
		FlowSimConfiguration.selectMandatoryField_No(driver, testCaseName);
		FlowSimConfiguration.clickOnSaveView(driver, testCaseName);
		ActionBot.waitForElementToBeDisplayed(driver, SimConfigurations.BUTTON_CREATE_VIEW, ActionBot.timeOut);

		// Activate/Deactivate fields
		logger.info("================Activate/Deactivate fields==================");
		FlowSimConfiguration.clickOnExpandViewPurchasing(driver, testCaseName);
		FlowSimConfiguration.clickManageFieldsPurchasingDetails(driver, testCaseName);
		ActionBot.waitForElementToBeEnable(driver, SimConfigurations.BUTTON_CREATE_NEW_FIELD, ActionBot.timeOut);

		logger.info("================DEACTIVATE FIELDS==================");
		SimConfigurationFlow.deactivateFields(driver, testCaseName);

		logger.info("================ACTIVATE AND DEPLOY==================");
		FlowSimConfiguration.clickOnActivateAndDeploy(driver, testCaseName);

		logger.info("================ADDING FACILITY AND SAVING==================");
		SimConfigurationFlow.addFacilities(driver, testCaseName);

		SimConfigurationFlow.fillViewAccessForPurchasing(driver, testCaseName);
		ActionBot.defaultMediumSleep();
		ActionBot.waitForPageLoad(driver);
		driver.get(ConfigProperty.getConfig("URL"));
		ActionBot.waitForPageLoad(driver);
	}
	

	public static void fillCMDMasterData(WebDriver driver, String testCaseName) throws Exception
	{
		driver.get(ConfigProperty.getConfig("TMS_URL"));
		ActionBot.waitForPageLoad(driver);
		
//		ActionBot.click(driver, MasterDataImpl.TAB_MASTER_DATA);
//		ActionBot.waitForElementToBePresent(driver, ActionBot.timeOut, MasterDataImpl.LINK_CURRENCY);

		MasterDataFlow.fillMasterDataCMD(driver, testCaseName);
		
		
		
		
		driver.get(ConfigProperty.getConfig("URL"));
		ActionBot.waitForPageLoad(driver);
	}
}