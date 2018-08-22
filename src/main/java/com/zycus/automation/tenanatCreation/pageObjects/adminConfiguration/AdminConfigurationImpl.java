package com.zycus.automation.tenanatCreation.pageObjects.adminConfiguration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class AdminConfigurationImpl implements AdminConfiguration
{

	static Logger logger = Logger.getLogger(AdminConfigurationImpl.class);

	public void selectCompany(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		Select drpDownOption = new Select(ActionBot.findElement(driver, DROPDOWN_TENANT_NAME));
		drpDownOption.selectByVisibleText(companyName);
		ScreenShot.screenshot(driver, testCaseName, "selecting CompanyName from dropdown");
	}

	public void goToSystemLevelTenantConfigurationPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeEnable(driver, HEADER_TAB_SETTING, ActionBot.timeOut);
		ActionBot.click(driver, HEADER_TAB_SETTING);
		ActionBot.waitForElementToBeDisplayed(driver, DROPDOWN_CONFIGURATIONS, Integer.parseInt(ActionBot.defaultSleep));
		ActionBot.click(driver, DROPDOWN_CONFIGURATIONS);
		//		ActionBot.waitForElementToBeEnable(driver, DROPDOWN_TENANT_NAME, Integer.parseInt(ActionBot.defaultMediumSleep));

	}

	public void fillSystemTenantAdminUser(WebDriver driver, String testCaseName, String adminUser) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SYSTEM_TENANT_ADMIN_USER))
		{
			//			ActionBot.sendKeys(driver, TEXTBOX_SYSTEM_TENANT_ADMIN_USER, adminUser);
			ActionBot.fillAutoCompleteField(driver, TEXTBOX_SYSTEM_TENANT_ADMIN_USER, adminUser);
			logger.info("admin User: " + adminUser);
			ScreenShot.screenshot(driver, testCaseName, "filling admin user");
		}
		else
			logger.info("admin User: " + adminUser + " not displayed");

	}

	public void fillSystemTenantAdminUserEmailId(WebDriver driver, String testCaseName, String adminEmailId) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SYSTEM_TENANT_ADMIN_EMAIL))
		{
			ActionBot.sendKeys(driver, TEXTBOX_SYSTEM_TENANT_ADMIN_EMAIL, adminEmailId);
			logger.info("admin email : " + adminEmailId);
			ScreenShot.screenshot(driver, testCaseName, "filling admin email");
		}
		else
		{
			logger.info("admin email : " + adminEmailId + " not displayed");
		}
	}

	public void fillSystemTenantInvoiceAdminUser(WebDriver driver, String testCaseName, String user) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SYSTEM_TENANT_INVOICE_ADMIN_USER))
		{
			//			ActionBot.sendKeys(driver, TEXTBOX_SYSTEM_TENANT_INVOICE_ADMIN_USER, user);
			ActionBot.fillAutoCompleteField(driver, TEXTBOX_SYSTEM_TENANT_INVOICE_ADMIN_USER, user);
			logger.info("Invice admin email : " + user);
			ScreenShot.screenshot(driver, testCaseName, "filling invoice admin email");
		}
		else
		{
			logger.info("Invice admin email : " + user + " not displayed");
		}

	}

	public void fillSystemTenantAPIEmail(WebDriver driver, String testCaseName, String apiUrl) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SYSTEM_TENANT_API_EMAIL))
		{
			ActionBot.sendKeys(driver, TEXTBOX_SYSTEM_TENANT_API_EMAIL, apiUrl);
			logger.info("API email: l : " + apiUrl);
			ScreenShot.screenshot(driver, testCaseName, "filling api url");
		}
		else
		{
			logger.info("API email: l : " + apiUrl + " not displayed");
		}
	}

	public void fillSystemTenantInvoiceEventUrl(WebDriver driver, String testCaseName, String eInvoiceEventUrl) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SYSTEM_TENANT_INVOICE_EVENT_URL))
		{
			ActionBot.sendKeys(driver, TEXTBOX_SYSTEM_TENANT_INVOICE_EVENT_URL, eInvoiceEventUrl);
			logger.info("Einvoice event url : " + eInvoiceEventUrl);
			ScreenShot.screenshot(driver, testCaseName, "filling einvoice event url");
		}
		else
		{

			logger.info("Einvoice event url : " + eInvoiceEventUrl + " not displayed");
		}
	}

	public void fillSystemTenantISourceEventUrl(WebDriver driver, String testCaseName, String iSourceEventUrl) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SYSTEM_TENANT_ISOURCE_EVENT_URL))
		{
			ActionBot.sendKeys(driver, TEXTBOX_SYSTEM_TENANT_ISOURCE_EVENT_URL, iSourceEventUrl);
			logger.info("isource event url : " + iSourceEventUrl);
			ScreenShot.screenshot(driver, testCaseName, "filling isource event url");
		}
		else
		{
			logger.info("isource event url : " + iSourceEventUrl + " not displayed");
		}

	}

	public void fillSystemTenantBaseUrl(WebDriver driver, String testCaseName, String baseUrl) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SYSTEM_TENANT_BASE_URL))
		{
			ActionBot.sendKeys(driver, TEXTBOX_SYSTEM_TENANT_BASE_URL, baseUrl);
			logger.info("Base url : " + baseUrl);
			ScreenShot.screenshot(driver, testCaseName, "base url");
		}
		else
		{
			logger.info("Base url : " + baseUrl + " not displayed");
		}

	}

	public void selectRegionForScoping_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_REGIONS_FOR_SCOPING_YES))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_REGIONS_FOR_SCOPING_YES))
			{
				ActionBot.click(driver, RADIOBUTTON_REGIONS_FOR_SCOPING_YES);
				ScreenShot.screenshot(driver, testCaseName, " Selecting region for Scope_YES");
			}
		}
		else
		{
			logger.info("Selecting region for Scope_YES " + "not displayed");
		}

	}

	public void selectRegionForScoping_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_REGIONS_FOR_SCOPING_NO))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_REGIONS_FOR_SCOPING_NO))
			{
				ActionBot.click(driver, RADIOBUTTON_REGIONS_FOR_SCOPING_NO);
				ScreenShot.screenshot(driver, testCaseName, " Selecting region for Scope_NO");
			}
		}
		else
		{
			logger.info("Selecting region for Scope_NO " + "not displayed");
		}

	}

	public void selectInvoiceIntegrated_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_INVOICE_INTRGATED_YES))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_INVOICE_INTRGATED_YES))
			{
				ActionBot.click(driver, RADIOBUTTON_INVOICE_INTRGATED_YES);
				ScreenShot.screenshot(driver, testCaseName, " Selecting Invoice integration_YES");
			}
		}
		else
		{
			logger.info("Selecting Invoice Integration YES " + "not displayed");
		}

	}

	public void selectInvoiceIntegrated_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_INVOICE_INTRGATED_NO))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_INVOICE_INTRGATED_NO))
			{
				ActionBot.click(driver, RADIOBUTTON_INVOICE_INTRGATED_NO);
				ScreenShot.screenshot(driver, testCaseName, " Selecting Invoice integration_NO");
			}
		}
		else
		{
			logger.info("Selecting Invoice Integration NO " + "not displayed");
		}

	}

	public void selectAnalyticsCRMSIntegration_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_ANALYTICS_CRMS_INTEGRATION_YES))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_ANALYTICS_CRMS_INTEGRATION_YES))
			{
				ActionBot.click(driver, RADIOBUTTON_ANALYTICS_CRMS_INTEGRATION_YES);
				ScreenShot.screenshot(driver, testCaseName, " Selecting analytics/CRMS integration_YES");
			}
		}
		else
		{
			logger.info("Selecting analytics/CRMS integration_YES " + "not displayed");
		}

	}

	public void selectAnalyticsCRMSIntegration_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_ANALYTICS_CRMS_INTEGRATION_NO))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_ANALYTICS_CRMS_INTEGRATION_NO))
			{
				ActionBot.click(driver, RADIOBUTTON_ANALYTICS_CRMS_INTEGRATION_NO);
				ScreenShot.screenshot(driver, testCaseName, " Selecting analytics/CRMS integration_NO");
			}
		}
		else
		{
			logger.info("Selecting analytics/CRMS integration_NO " + "not displayed");
		}

	}

	public void selectAllowSupplierForAdditionOfStockItem_NO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_ALLOW_SUPPLIER_ADDITION_FOR_STOCK_ITEM_NO))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_ALLOW_SUPPLIER_ADDITION_FOR_STOCK_ITEM_NO))
			{
				ActionBot.click(driver, RADIOBUTTON_ALLOW_SUPPLIER_ADDITION_FOR_STOCK_ITEM_NO);
				ScreenShot.screenshot(driver, testCaseName, " Selecting allow Suppplier For Addition Of Stock Item_NO");
			}
		}
		else
		{
			logger.info("Selecting allow Suppplier For Addition Of Stock Item_NO " + "not displayed");
		}
	}

	public void selectAllowSupplierForAdditionOfStockItem_YES(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_ALLOW_SUPPLIER_ADDITION_FOR_STOCK_ITEM_YES))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_ALLOW_SUPPLIER_ADDITION_FOR_STOCK_ITEM_YES))
			{
				ActionBot.click(driver, RADIOBUTTON_ALLOW_SUPPLIER_ADDITION_FOR_STOCK_ITEM_YES);
				ScreenShot.screenshot(driver, testCaseName, " Selecting allow Suppplier For Addition Of Stock Item_YES");
			}
		}
		else
		{
			logger.info("Selecting allow Suppplier For Addition Of Stock Item_YES " + "not displayed");
		}
	}

	public void fillSystemTenantAutoClassUrl(WebDriver driver, String testCaseName, String autoClassUrl) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SYSTEM_TENANT_AUTOCLASS_URL))
		{
			ActionBot.sendKeys(driver, TEXTBOX_SYSTEM_TENANT_AUTOCLASS_URL, autoClassUrl);
			logger.info("AutoClass url : " + autoClassUrl);
			ScreenShot.screenshot(driver, testCaseName, "AutoClass url");
		}
		else
		{
			logger.info("Selecting AutoClass url " + "not displayed");
		}

	}

	public void fillSystemTenantAutoClassSchema(WebDriver driver, String testCaseName, String autoClassSchema) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SYSTEM_TENANT_AUTOCLASS_SCHEMA))
		{
			ActionBot.sendKeys(driver, TEXTBOX_SYSTEM_TENANT_AUTOCLASS_SCHEMA, autoClassSchema);
			logger.info("AutoClass Schema : " + autoClassSchema);
			ScreenShot.screenshot(driver, testCaseName, "AutoClass Schema");
		}
		else
		{
			logger.info("Selecting AutoClass Schema " + "not displayed");
		}

	}

	public void fillSystemTenantProject(WebDriver driver, String testCaseName, String project) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SYSTEM_TENANT_AUTOCLASS_PROJECT))
		{
			ActionBot.sendKeys(driver, TEXTBOX_SYSTEM_TENANT_AUTOCLASS_PROJECT, project);
			logger.info("Project : " + project);
			ScreenShot.screenshot(driver, testCaseName, "Project");
		}
		else
		{
			logger.info("Selecting Project " + "not displayed");
		}

	}

	public void fillSystemTenantAutoClassModel(WebDriver driver, String testCaseName, String autoClassModel) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SYSTEM_TENANT_AUTOCLASS_MODEL))
		{
			ActionBot.sendKeys(driver, TEXTBOX_SYSTEM_TENANT_AUTOCLASS_MODEL, autoClassModel);
			logger.info("Autoclass Model : " + autoClassModel);
			ScreenShot.screenshot(driver, testCaseName, "AutoClass Model");
		}
		else
		{
			logger.info("Selecting Autoclass Model " + "not displayed");
		}

	}

	public void fillSystemTenantAutoclassModelVersion(WebDriver driver, String testCaseName, String autoClassVersion) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SYSTEM_TENANT_AUTOCLASS_MODEL_VERSION))
		{
			ActionBot.sendKeys(driver, TEXTBOX_SYSTEM_TENANT_AUTOCLASS_MODEL_VERSION, autoClassVersion);
			logger.info("AutoClass version : " + autoClassVersion);
			ScreenShot.screenshot(driver, testCaseName, "AutoClass version");
		}
		else
		{
			logger.info("Selecting AutoClass version " + "not displayed");
		}

	}

	public void selectRetriggerFailedDocument_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_RETRIGGER_FAILED_DOCUMENTS_YES))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_RETRIGGER_FAILED_DOCUMENTS_YES))
			{
				ActionBot.click(driver, RADIOBUTTON_RETRIGGER_FAILED_DOCUMENTS_YES);
				ScreenShot.screenshot(driver, testCaseName, "Retrigger Filed Document_YES");
			}
		}
		else
		{
			logger.info("Selecting Retrigger Filed Document_YES " + "not displayed");
		}

	}

	public void selectRetriggerFailedDocument_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_RETRIGGER_FAILED_DOCUMENTS_NO))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_RETRIGGER_FAILED_DOCUMENTS_NO))
			{
				ActionBot.click(driver, RADIOBUTTON_RETRIGGER_FAILED_DOCUMENTS_NO);
				ScreenShot.screenshot(driver, testCaseName, "Retrigger Filed Document_NO");
			}
		}
		else
		{
			logger.info("Selecting Retrigger Filed Document_NO " + "not displayed");
		}

	}

	public void fillAnalyticsCRMSIntegrationUrl(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_ANALYTICS_CRMS_INTEGRATION_URL))
		{
			ActionBot.sendKeys(driver, TEXTBOX_ANALYTICS_CRMS_INTEGRATION_URL, url);
			logger.info("Analytics CRMS URL : " + url);
			ScreenShot.screenshot(driver, testCaseName, "Analytics_CRMS integration url");
		}
		else
		{
			logger.info("Selecting Analytics CRMS URL  " + "not displayed");
		}

	}

	public void fillAttempRetriggerUrlInMins(WebDriver driver, String testCaseName, int mins) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_ATTEMPT_RETRIGGER_IN_MINS))
		{
			if (ActionBot.isElementEnabled(driver, TEXTBOX_ATTEMPT_RETRIGGER_IN_MINS))
			{
				ActionBot.sendKeys(driver, TEXTBOX_ATTEMPT_RETRIGGER_IN_MINS, String.valueOf(mins));
				logger.info("Retrigger Attempt Url in Mins : " + mins);
				ScreenShot.screenshot(driver, testCaseName, "Attemp retriggerUrl in mins");
			}
		}
		else
		{
			logger.info("Selecting Retrigger Attempt Url in Mins  " + "not displayed");
		}

	}

	public void fillMaximumNoOfAttempts(WebDriver driver, String testCaseName, int attempts) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_MAXIMUN_NO_OF_ATTEMPTS))
		{
			if (ActionBot.isElementEnabled(driver, TEXTBOX_MAXIMUN_NO_OF_ATTEMPTS))
			{
				ActionBot.sendKeys(driver, TEXTBOX_MAXIMUN_NO_OF_ATTEMPTS, String.valueOf(attempts));
				logger.info("Maximum no of attempts : " + attempts);
				ScreenShot.screenshot(driver, testCaseName, "Maximum no of attempts");
			}
		}
		else
		{
			logger.info("Maximum no of attempts : " + "not displayed");
		}
	}

	public void selectPreDefinedFields(WebDriver driver, String testCaseName, String predefinedFields) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, DROPDOWN_DIPLAYNAME_OF_PREDEFINED_FIELDS))
		{
			Select drpDownOption = new Select(ActionBot.findElement(driver, DROPDOWN_DIPLAYNAME_OF_PREDEFINED_FIELDS));
			drpDownOption.selectByVisibleText(predefinedFields);
			ScreenShot.screenshot(driver, testCaseName, "selecting Display name of predefined fields drom dropdown");
		}
		else
		{
			logger.info("selecting Display name of predefined fields drom dropdown " + "not displayed");
		}
	}

	public void clickButtonUpdate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_UPDATE))
		{
			ScreenShot.screenshot(driver, testCaseName, "Before updating system level configuration");

			ActionBot.click(driver, BUTTON_UPDATE);
		}
		ScreenShot.screenshot(driver, testCaseName, "After updating system level configuration");
		ActionBot.defaultMediumSleep();

	}

	public void addIntegation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before adding Integration entity");
		ActionBot.click(driver, BUTTON_ADD_INTEGRATION);
		ScreenShot.screenshot(driver, testCaseName, "After adding Integration entity");

	}

	@Override
	public void selectEntity(WebDriver driver, String testCaseName, String entity, int index) throws ActionBotException
	{
		//		List<WebElement> dropdownElements=ActionBot.findElements(driver, DROPDOWN_ENTITY);
		Select drpDownOption = new Select(ActionBot.findElements(driver, DROPDOWN_ENTITY).get(index));
		drpDownOption.selectByVisibleText(entity);
		ScreenShot.screenshot(driver, testCaseName, "selecting entity for system tenent configuration");

	}

	@Override
	public void fillToSystem(WebDriver driver, String testCaseName, String toSystem, int index) throws ActionBotException
	{
		ActionBot.findElements(driver, TEXTBOX_TO_SYSTEM).get(index).sendKeys(toSystem);
		//		ActionBot.sendKeys(driver, ActionBot.findElements(driver, TEXTBOX_TO_SYSTEM).get(index), toSystem);

	}

	@Override
	public void fillToUrl(WebDriver driver, String testCaseName, String toUrl, int index) throws ActionBotException
	{
		ActionBot.findElements(driver, TEXTBOX_TO_URL).get(index).sendKeys(toUrl);
		//		ActionBot.sendKeys(driver, TEXTBOX_TO_URL, toUrl);

	}

	@Override
	public void fillTmsProductName(WebDriver driver, String testCaseName, String tmsProductName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_TMS_PRODUCTS_NAME))
		{
			ActionBot.sendKeys(driver, TEXTBOX_TMS_PRODUCTS_NAME, tmsProductName);
			logger.info("tmsProductNameL : " + tmsProductName);
			ScreenShot.screenshot(driver, testCaseName, "tms Product Name");
		}
		else
		{
			logger.info("Selecting tmsProductName  " + "not displayed");
		}

	}

	@Override
	public void fillSmtpHost(WebDriver driver, String testCaseName, String smtpHost) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SMTP_PRODUCTS_HOST))
		{
			ActionBot.sendKeys(driver, TEXTBOX_SMTP_PRODUCTS_HOST, smtpHost);
			logger.info("fill Smtp Host : " + smtpHost);
			ScreenShot.screenshot(driver, testCaseName, "fillSmtpHost");
		}
		else
		{
			logger.info("Selecting fill Smtp Host  " + "not displayed");
		}

	}

	@Override
	public void fillDefaultEmailSender(WebDriver driver, String testCaseName, String defaultEmailSender) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_DEFAULT_EMAIL_SENDER))
		{
			ActionBot.sendKeys(driver, TEXTBOX_DEFAULT_EMAIL_SENDER, defaultEmailSender);
			logger.info("fillDefaultEmailSender : " + defaultEmailSender);
			ScreenShot.screenshot(driver, testCaseName, "fillDefaultEmailSender");
		}
		else
		{
			logger.info("Selecting fillDefaultEmailSender  " + "not displayed");
		}

	}

	@Override
	public void fillApiEmailId(WebDriver driver, String testCaseName, String apiEmaidId) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_API_EMAIL_ID))
		{
			ActionBot.sendKeys(driver, TEXTBOX_API_EMAIL_ID, apiEmaidId);
			logger.info("fillApiEmailId : " + apiEmaidId);
			ScreenShot.screenshot(driver, testCaseName, "fillApiEmailId");
		}
		else
		{
			logger.info("Selecting fillApiEmailId " + "not displayed");
		}

	}

	@Override
	public void fillFileServerUrl(WebDriver driver, String testCaseName, String fileServerUrl) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_FILE_SERVER_URL))
		{
			ActionBot.sendKeys(driver, TEXTBOX_FILE_SERVER_URL, fileServerUrl);
			logger.info("fillFileServerUrl : " + fileServerUrl);
			ScreenShot.screenshot(driver, testCaseName, "fillFileServerUrl");
		}
		else
		{
			logger.info("Selecting fillFileServerUrl  " + "not displayed");
		}

	}

	@Override
	public void fillZsnIntegrationUrl(WebDriver driver, String testCaseName, String zsnIntegrationUrl) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_ZSN_INTEGRATION_URL))
		{
			ActionBot.sendKeys(driver, TEXTBOX_ZSN_INTEGRATION_URL, zsnIntegrationUrl);
			logger.info("fillZsnIntegrationUrl : " + zsnIntegrationUrl);
			ScreenShot.screenshot(driver, testCaseName, "fillZsnIntegrationUrl");
		}
		else
		{
			logger.info("fillZsnIntegrationUrl  " + "not displayed");
		}

	}

	@Override
	public void selectCatalogEnableSearch_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_CATALOG_ENABLE_SEARCH_YES))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_CATALOG_ENABLE_SEARCH_YES))
			{
				ActionBot.click(driver, RADIOBUTTON_CATALOG_ENABLE_SEARCH_YES);
				logger.info("fill Smtp Host : YES");
				ScreenShot.screenshot(driver, testCaseName, "selectCatalogEnableSearch_Yes");
			}
		}
		else
		{
			logger.info("selectCatalogEnableSearch_Yes  " + "not displayed");
		}

	}

	@Override
	public void selectCatalogEnableSearch_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_CATALOG_ENABLE_SEARCH_NO))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_CATALOG_ENABLE_SEARCH_NO))
			{
				ActionBot.click(driver, RADIOBUTTON_CATALOG_ENABLE_SEARCH_NO);
				logger.info("selectCatalogEnableSearch_No  ");
				ScreenShot.screenshot(driver, testCaseName, "selectCatalogEnableSearch_No");
			}
		}
		else
		{
			logger.info("selectCatalogEnableSearch_No  " + "not displayed");
		}

	}

	@Override
	public void selectUsageTracking_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_USAGE_TRACKING_YES))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_USAGE_TRACKING_YES))
			{
				ActionBot.click(driver, RADIOBUTTON_USAGE_TRACKING_YES);
				logger.info("selectUsageTracking_Yes  ");
				ScreenShot.screenshot(driver, testCaseName, "selectUsageTracking_Yes");
			}
		}
		else
		{
			logger.info("selectUsageTracking_Yes  " + "not displayed");
		}
	}

	@Override
	public void selectUsageTracking_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_USAGE_TRACKING_NO))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_USAGE_TRACKING_NO))
			{
				ActionBot.click(driver, RADIOBUTTON_USAGE_TRACKING_NO);
				logger.info("selectUsageTracking_No  ");
				ScreenShot.screenshot(driver, testCaseName, "selectUsageTracking_No");
			}
		}
		else
		{
			logger.info("selectUsageTracking_No  " + "not displayed");
		}
	}

	@Override
	public void fillCmdProductUrl(WebDriver driver, String testCaseName, String cmdProductUrl) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_CMD_PRODUCTS_URL))
		{
			ActionBot.sendKeys(driver, TEXTBOX_CMD_PRODUCTS_URL, cmdProductUrl);
			logger.info("fillCmdProductUrl : " + cmdProductUrl);
			ScreenShot.screenshot(driver, testCaseName, "fillCmdProductUrl");
		}
		else
		{
			logger.info("fillCmdProductUrl  " + "not displayed");
		}

	}

	@Override
	public void UploadFileForExchangeRates(WebDriver driver, String testCaseName, String filePath) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, SELECT_FILE_UPLOAD))
		{
			ActionBot.sendKeys(driver, SELECT_FILE_UPLOAD, filePath);
			logger.info("UploadFileForExchangeRates : " + filePath);
			ScreenShot.screenshot(driver, testCaseName, "After UploadFileForExchangeRates");
		}

	}

	@Override
	public void clickOnUpload(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_UPLOAD_FILE))
		{
			ScreenShot.screenshot(driver, testCaseName, "Before clickOnUpload");
			ActionBot.click(driver, BUTTON_UPLOAD_FILE);
			ScreenShot.screenshot(driver, testCaseName, "After clickOnUpload");
		}
	}

	@Override
	public void clickOnUpdateEinvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_UPDATE_EINVOICE))
		{
			ScreenShot.screenshot(driver, testCaseName, "Before clickOnUpdateEinvoice");
			ActionBot.click(driver, BUTTON_UPDATE_EINVOICE);
		}
		ScreenShot.screenshot(driver, testCaseName, "After clickOnUpdateEinvoice");
		ActionBot.defaultMediumSleep();
	}

	@Override
	public void enterSimClientId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SIM_CLIENT_ID))
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String tenantId = (String) js.executeScript("g.tenantId");

			if (tenantId != null)
				ActionBot.sendKeys(driver, TEXTBOX_SIM_CLIENT_ID, tenantId);
			ScreenShot.screenshot(driver, testCaseName, "After enterSimClientId");
		}

	}

	@Override
	public void enterSimUrl(WebDriver driver, String testCaseName, String simUrl) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SIM_URL))
		{
			ActionBot.sendKeys(driver, TEXTBOX_SIM_URL, simUrl);
			ScreenShot.screenshot(driver, testCaseName, "After enterSimUrl");
		}

	}

	@Override
	public void enterSimSupplierAddUrl(WebDriver driver, String testCaseName, String simSupplierAddUrl) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SYSTEM_TENANT_SIM_SUPPLIER_ADD_URL))
		{
			ActionBot.sendKeys(driver, TEXTBOX_SYSTEM_TENANT_SIM_SUPPLIER_ADD_URL, simSupplierAddUrl);
			ScreenShot.screenshot(driver, testCaseName, "After enterSimSupplierAddUrl");
		}

	}

	@Override
	public void selectBUInGL_YES(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_BU_IN_GL_YES))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_BU_IN_GL_YES))
			{
				ActionBot.click(driver, RADIOBUTTON_BU_IN_GL_YES);
				ScreenShot.screenshot(driver, testCaseName, "After selectBUInGL_YES");
			}
		}
	}

	@Override
	public void selectBUInGL_NO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_BU_IN_GL_NO))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_BU_IN_GL_NO))
			{
				ActionBot.click(driver, RADIOBUTTON_BU_IN_GL_NO);
				ScreenShot.screenshot(driver, testCaseName, "After selectBUInGL_NO");
			}
		}
	}

	@Override
	public void selectDeptToOU_YES(WebDriver driver, String testCaseName) throws ActionBotException
	{

		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_DEPT_TO_OU_YES))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_DEPT_TO_OU_YES))
			{
				ActionBot.click(driver, RADIOBUTTON_DEPT_TO_OU_YES);
				ScreenShot.screenshot(driver, testCaseName, "After selectDeptToOU_YES");
			}
		}
	}

	@Override
	public void selectDeptToOU_NO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_DEPT_TO_OU_NO))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_DEPT_TO_OU_NO))
			{
				ActionBot.click(driver, RADIOBUTTON_DEPT_TO_OU_NO);
				ScreenShot.screenshot(driver, testCaseName, "After selectDeptToOU_NO");
			}
		}
	}

	@Override
	public void matchPTWithUnicode_YES(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_MATCH_PT_WITH_UNICODE_YES))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_MATCH_PT_WITH_UNICODE_YES))
			{
				ActionBot.click(driver, RADIOBUTTON_MATCH_PT_WITH_UNICODE_YES);
				ScreenShot.screenshot(driver, testCaseName, "After matchPTWithUnicode_YES");
			}
		}
	}

	@Override
	public void matchPTWithUnicode_NO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIOBUTTON_MATCH_PT_WITH_UNICODE_NO))
		{
			if (ActionBot.isElementEnabled(driver, RADIOBUTTON_MATCH_PT_WITH_UNICODE_NO))
			{
				ActionBot.click(driver, RADIOBUTTON_MATCH_PT_WITH_UNICODE_NO);
				ScreenShot.screenshot(driver, testCaseName, "After matchPTWithUnicode_NO");
			}
		}

	}

	@Override
	public void selectLanguageForTranslation(WebDriver driver, String testCaseName, String language) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, By.xpath(xpath1_checkbox_add_language + language + xpath2_checkbox_add_language)))
		{
			ActionBot.click(driver, By.xpath(xpath1_checkbox_add_language + language + xpath2_checkbox_add_language));
		}

	}

	@Override
	public void clickOnLinkSelectLanguageForTranslation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_SELECT_LANGUAGE_FOR_TRANSLATION))
		{
			if (ActionBot.isElementEnabled(driver, LINK_SELECT_LANGUAGE_FOR_TRANSLATION))
			{
				ActionBot.click(driver, LINK_SELECT_LANGUAGE_FOR_TRANSLATION);
				ScreenShot.screenshot(driver, testCaseName, "After clickOnLinkSelectLanguageForTranslation");
			}
		}
	}

	@Override
	public void clickOnSaveLanguagesForTransaltion(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_SAVE_LANGUAGE))
		{
			if (ActionBot.isElementEnabled(driver, BUTTON_SAVE_LANGUAGE))
			{
				ActionBot.click(driver, BUTTON_SAVE_LANGUAGE);
				ScreenShot.screenshot(driver, testCaseName, "After clickOnSaveLanguagesForTransaltion");
			}
		}

	}

	@Override
	public void clickOnConfirmation_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_CONFIRMATION_YES))
		{
			if (ActionBot.isElementEnabled(driver, BUTTON_CONFIRMATION_YES))
			{
				ActionBot.click(driver, BUTTON_CONFIRMATION_YES);
				ScreenShot.screenshot(driver, testCaseName, "After clickOnConfirmation_Yes");
			}
		}
		ActionBot.defaultSleep();

	}

}
