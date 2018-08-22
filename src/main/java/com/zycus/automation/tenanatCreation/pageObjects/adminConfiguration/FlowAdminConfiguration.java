package com.zycus.automation.tenanatCreation.pageObjects.adminConfiguration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class FlowAdminConfiguration
{

	static Logger logger = Logger.getLogger(FlowAdminConfiguration.class);

	public static void selectCompany(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectCompany(driver, testCaseName, companyName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCompany " + e, e);
		}
	}

	public static void goToSystemLevelTenantConfigurationPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.goToSystemLevelTenantConfigurationPage(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method goToSystemLevelTenantConfigurationPage " + e, e);
		}
	}

	public static void fillSystemTenantAdminUser(WebDriver driver, String testCaseName, String adminUser) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillSystemTenantAdminUser(driver, testCaseName, adminUser);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}
	}

	public static void fillSystemTenantAdminUserEmailId(WebDriver driver, String testCaseName, String adminEmailId) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillSystemTenantAdminUserEmailId(driver, testCaseName, adminEmailId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSystemTenantAdminUserEmailId " + e, e);
		}
	}

	public static void fillSystemTenantInvoiceAdminUser(WebDriver driver, String testCaseName, String user) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillSystemTenantInvoiceAdminUser(driver, testCaseName, user);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSystemTenantInvoiceAdminUser " + e, e);
		}
	}

	public static void fillSystemTenantAPIEmail(WebDriver driver, String testCaseName, String apiUrl) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillSystemTenantAPIEmail(driver, testCaseName, apiUrl);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSystemTenantAPIEmail " + e, e);
		}
	}

	public static void fillSystemTenantInvoiceEventUrl(WebDriver driver, String testCaseName, String eInvoiceEventUrl) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillSystemTenantInvoiceEventUrl(driver, testCaseName, eInvoiceEventUrl);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSystemTenantInvoiceEventUrl " + e, e);
		}
	}

	public static void fillSystemTenantISourceEventUrl(WebDriver driver, String testCaseName, String iSourceEventUrl) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillSystemTenantISourceEventUrl(driver, testCaseName, iSourceEventUrl);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSystemTenantISourceEventUrl " + e, e);
		}
	}

	public static void fillSystemTenantBaseUrl(WebDriver driver, String testCaseName, String baseUrl) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillSystemTenantBaseUrl(driver, testCaseName, baseUrl);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSystemTenantBaseUrl " + e, e);
		}
	}

	public static void selectRegionForScoping_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectRegionForScoping_Yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectRegionForScoping_Yes " + e, e);
		}
	}

	public static void selectRegionForScoping_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectRegionForScoping_No(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectRegionForScoping_No " + e, e);
		}
	}

	public static void selectInvoiceIntegrated_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectInvoiceIntegrated_Yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectInvoiceIntegrated_Yes " + e, e);
		}
	}

	public static void selectInvoiceIntegrated_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectInvoiceIntegrated_No(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectInvoiceIntegrated_No " + e, e);
		}
	}

	public static void selectAnalyticsCRMSIntegration_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectAnalyticsCRMSIntegration_Yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAnalyticsCRMSIntegration_Yes " + e, e);
		}
	}

	public static void selectAnalyticsCRMSIntegration_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectAnalyticsCRMSIntegration_No(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAnalyticsCRMSIntegration_No " + e, e);
		}
	}

	public static void fillSystemTenantAutoClassUrl(WebDriver driver, String testCaseName, String autoClassUrl) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillSystemTenantAutoClassUrl(driver, testCaseName, autoClassUrl);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSystemTenantAutoClassUrl " + e, e);
		}
	}

	public static void fillSystemTenantAutoClassSchema(WebDriver driver, String testCaseName, String autoClassSchema) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillSystemTenantAutoClassSchema(driver, testCaseName, autoClassSchema);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSystemTenantAutoClassSchema " + e, e);
		}
	}

	public static void fillSystemTenantProject(WebDriver driver, String testCaseName, String project) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillSystemTenantProject(driver, testCaseName, project);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSystemTenantProject " + e, e);
		}
	}

	public static void fillSystemTenantAutoClassModel(WebDriver driver, String testCaseName, String autoClassModel) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillSystemTenantAutoClassModel(driver, testCaseName, autoClassModel);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSystemTenantAutoClassModel " + e, e);
		}
	}

	public static void fillSystemTenantAutoclassModelVersion(WebDriver driver, String testCaseName, String autoClassVersion) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillSystemTenantAutoclassModelVersion(driver, testCaseName, autoClassVersion);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSystemTenantAutoclassModelVersion " + e, e);
		}
	}

	public static void selectRetriggerFailedDocument_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectRetriggerFailedDocument_Yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectRetriggerFailedDocument_Yes " + e, e);
		}
	}

	public static void selectRetriggerFailedDocument_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectRetriggerFailedDocument_No(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectRetriggerFailedDocument_No " + e, e);
		}
	}

	public static void fillAnalyticsCRMSIntegrationUrl(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillAnalyticsCRMSIntegrationUrl(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method  fillAnalyticsCRMSIntegrationUrl" + e, e);
		}
	}

	public static void fillAttempRetriggerUrlInMins(WebDriver driver, String testCaseName, int mins) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillAttempRetriggerUrlInMins(driver, testCaseName, mins);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAttempRetriggerUrlInMins " + e, e);
		}
	}

	public static void fillMaximumNoOfAttempts(WebDriver driver, String testCaseName, int attempts) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillMaximumNoOfAttempts(driver, testCaseName, attempts);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMaximumNoOfAttempts " + e, e);
		}
	}

	public static void selectPreDefinedFields(WebDriver driver, String testCaseName, String predefinedFields) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectPreDefinedFields(driver, testCaseName, predefinedFields);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectPreDefinedFields " + e, e);
		}
	}

	public static void clickButtonUpdate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.clickButtonUpdate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickButtonUpdate " + e, e);
		}
	}

	public static void selectAllowSupplierForAdditionOfStockItem_NO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectAllowSupplierForAdditionOfStockItem_NO(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAllowSupplierForAdditionOfStockItem_NO " + e, e);
		}
	}

	public static void selectAllowSupplierForAdditionOfStockItem_YES(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectAllowSupplierForAdditionOfStockItem_YES(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAllowSupplierForAdditionOfStockItem_YES " + e, e);
		}
	}

	public static void addIntegation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.addIntegation(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method addIntegation " + e, e);
		}
	}

	public static void selectEntity(WebDriver driver, String testCaseName, String entity, int index) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectEntity(driver, testCaseName, entity, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectEntity " + e, e);
		}
	}

	public static void fillToSystem(WebDriver driver, String testCaseName, String toSystem, int index) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillToSystem(driver, testCaseName, toSystem, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillToSystem " + e, e);
		}
	}

	public static void fillToUrl(WebDriver driver, String testCaseName, String toUrl, int index) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillToUrl(driver, testCaseName, toUrl, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillToUrl " + e, e);
		}
	}

	public static void fillTmsProductName(WebDriver driver, String testCaseName, String tmsProductName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillTmsProductName(driver, testCaseName, tmsProductName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillTmsProductName " + e, e);
		}
	}

	public static void fillSmtpHost(WebDriver driver, String testCaseName, String smtpHost) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillSmtpHost(driver, testCaseName, smtpHost);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSmtpHost " + e, e);
		}
	}

	public static void fillDefaultEmailSender(WebDriver driver, String testCaseName, String defaultEmailSender) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillDefaultEmailSender(driver, testCaseName, defaultEmailSender);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDefaultEmailSender " + e, e);
		}
	}

	public static void fillApiEmailId(WebDriver driver, String testCaseName, String apiEmaidId) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillApiEmailId(driver, testCaseName, apiEmaidId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillApiEmailId " + e, e);
		}
	}

	public static void fillFileServerUrl(WebDriver driver, String testCaseName, String fileServerUrl) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillFileServerUrl(driver, testCaseName, fileServerUrl);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFileServerUrl " + e, e);
		}
	}

	public static void fillZsnIntegrationUrl(WebDriver driver, String testCaseName, String zsnIntegrationUrl) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillZsnIntegrationUrl(driver, testCaseName, zsnIntegrationUrl);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillZsnIntegrationUrl " + e, e);
		}
	}

	public static void selectCatalogEnableSearch_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectCatalogEnableSearch_Yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCatalogEnableSearch_Yes " + e, e);
		}
	}

	public static void selectCatalogEnableSearch_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectCatalogEnableSearch_No(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCatalogEnableSearch_No " + e, e);
		}
	}

	public static void selectUsageTracking_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectUsageTracking_Yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectUsageTracking_Yes " + e, e);
		}
	}

	public static void selectUsageTracking_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectUsageTracking_No(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectUsageTracking_No " + e, e);
		}
	}

	public static void fillCmdProductUrl(WebDriver driver, String testCaseName, String cmdProductUrl) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.fillCmdProductUrl(driver, testCaseName, cmdProductUrl);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCmdProductUrl " + e, e);
		}
	}

	public static void UploadFileForExchangeRates(WebDriver driver, String testCaseName, String filePath) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.UploadFileForExchangeRates(driver, testCaseName, filePath);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method UploadFileForExchangeRates " + e, e);
		}
	}

	public static void clickOnUpload(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.clickOnUpload(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnUpload " + e, e);
		}
	}

	public static void clickOnUpdateEinvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.clickOnUpdateEinvoice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnUpdateEinvoice " + e, e);
		}
	}

	public static void enterSimClientId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.enterSimClientId(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method enterSimClientId " + e, e);
		}
	}

	public static void enterSimUrl(WebDriver driver, String testCaseName, String simUrl) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.enterSimUrl(driver, testCaseName, simUrl);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method enterSimUrl " + e, e);
		}
	}

	public static void enterSimSupplierAddUrl(WebDriver driver, String testCaseName, String simSupplierAddUrl) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.enterSimSupplierAddUrl(driver, testCaseName, simSupplierAddUrl);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method enterSimSupplierAddUrl " + e, e);
		}
	}

	public static void selectBUInGL_YES(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectBUInGL_YES(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectBUInGL_YES " + e, e);
		}
	}

	public static void selectBUInGL_NO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectBUInGL_NO(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectBUInGL_NO " + e, e);
		}
	}

	public static void selectDeptToOU_YES(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectDeptToOU_YES(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDeptToOU_YES " + e, e);
		}
	}

	public static void selectDeptToOU_NO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectDeptToOU_NO(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDeptToOU_NO " + e, e);
		}
	}

	public static void matchPTWithUnicode_YES(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.matchPTWithUnicode_YES(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method matchPTWithUnicode_YES " + e, e);
		}
	}

	public static void matchPTWithUnicode_NO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.matchPTWithUnicode_NO(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method matchPTWithUnicode_NO " + e, e);
		}
	}

	public static void selectLanguageForTranslation(WebDriver driver, String testCaseName, String language) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.selectLanguageForTranslation(driver, testCaseName, language);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectLanguageForTranslation " + e, e);
		}
	}

	public static void clickOnLinkSelectLanguageForTranslation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.clickOnLinkSelectLanguageForTranslation(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnLinkSelectLanguageForTranslation " + e, e);
		}
	}

	public static void clickOnSaveLanguagesForTransaltion(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.clickOnSaveLanguagesForTransaltion(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveLanguagesForTransaltion " + e, e);
		}
	}

	public static void clickOnConfirmation_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			AdminConfigurationImpl adminConfig = FactoryPage.getInstanceOf(AdminConfigurationImpl.class);
			adminConfig.clickOnConfirmation_Yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveLanguagesForTransaltion " + e, e);
		}
	}

}
