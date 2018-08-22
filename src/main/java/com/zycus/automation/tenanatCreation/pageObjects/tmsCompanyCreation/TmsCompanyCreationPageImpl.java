package com.zycus.automation.tenanatCreation.pageObjects.tmsCompanyCreation;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.reporters.EmailableReporter;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class TmsCompanyCreationPageImpl implements TmsCompanyCreationPage
{

	static Logger logger = Logger.getLogger(TmsCompanyCreationPageImpl.class);

	public String fillCompanyName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_COMPANY_NAME, companyName);
		logger.info("Company Name: " + companyName);
		ScreenShot.screenshot(driver, testCaseName, "filling company name");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_COMPANY_NAME);
	}

	public boolean selectCheckBoxSaasCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, CHECKBOX_IS_SAAS_COMPANY) && ActionBot.isElementEnabled(driver, CHECKBOX_IS_SAAS_COMPANY))
			ActionBot.click(driver, CHECKBOX_IS_SAAS_COMPANY);
		ScreenShot.screenshot(driver, testCaseName, "selecting saas company checkbox");
		return ActionBot.findElement(driver, CHECKBOX_IS_SAAS_COMPANY).isSelected();
	}

	public boolean selectCheckBoxdelegateCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, CHECKBOX_IS_DELEGATED_COMPANY) && ActionBot.isElementEnabled(driver, CHECKBOX_IS_DELEGATED_COMPANY))
			ActionBot.click(driver, CHECKBOX_IS_DELEGATED_COMPANY);
		ScreenShot.screenshot(driver, testCaseName, "selecting delegate company");
		return ActionBot.findElement(driver, CHECKBOX_IS_DELEGATED_COMPANY).isSelected();
	}

	public String fillBridgeURL(WebDriver driver, String testCaseName, String bridgeUrl) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_BRIDGE_URL, bridgeUrl);
		logger.info("Bridge URL: " + bridgeUrl);
		ScreenShot.screenshot(driver, testCaseName, "filling Bridge URL");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_BRIDGE_URL);
	}

	public String fillDomailURL(WebDriver driver, String testCaseName, String domailUrl) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_DOMAIN_URL, domailUrl);
		logger.info("Domain URL: " + domailUrl);
		ScreenShot.screenshot(driver, testCaseName, "filling domain URL");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_DOMAIN_URL);
	}

	public boolean selectCheckBoxLoginThroughUniqueId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, CHECKBOX_LOGIN_THROUGH_UNIQUE_ID) && ActionBot.isElementEnabled(driver, CHECKBOX_LOGIN_THROUGH_UNIQUE_ID))
		{
			ActionBot.click(driver, CHECKBOX_LOGIN_THROUGH_UNIQUE_ID);
		}
		ScreenShot.screenshot(driver, testCaseName, "selecting login through unique id checkbox");
		return ActionBot.findElement(driver, CHECKBOX_LOGIN_THROUGH_UNIQUE_ID).isSelected();
	}

	public boolean selectCheckBoxEnableScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, CHECKBOX_ENABLE_SCOPE) && ActionBot.isElementEnabled(driver, CHECKBOX_ENABLE_SCOPE))
			ActionBot.click(driver, CHECKBOX_ENABLE_SCOPE);
		ScreenShot.screenshot(driver, testCaseName, "selecting enable scope checkbox");
		return ActionBot.findElement(driver, CHECKBOX_ENABLE_SCOPE).isSelected();
	}

	public String fillLocationName(WebDriver driver, String testCaseName, String locationName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_LOCATION_NAME, locationName);
		logger.info("Location Name: " + locationName);
		ScreenShot.screenshot(driver, testCaseName, "filling location name");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_LOCATION_NAME);
	}

	public String fillAddress1(WebDriver driver, String testCaseName, String address1) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_ADDRESS1, address1);
		logger.info("Address 1: " + address1);
		ScreenShot.screenshot(driver, testCaseName, "filling address 1");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_ADDRESS1);
	}

	public String fillAddress2(WebDriver driver, String testCaseName, String address2) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_ADDRESS2, address2);
		logger.info("Address 2: " + address2);
		ScreenShot.screenshot(driver, testCaseName, "filling address 2");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_ADDRESS2);
	}

	public String fillCity(WebDriver driver, String testCaseName, String city) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_CITY, city);
		logger.info("City: " + city);
		ScreenShot.screenshot(driver, testCaseName, "filling city");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_CITY);
	}

	public String fillState(WebDriver driver, String testCaseName, String state) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_STATE, state);
		logger.info("State: " + state);
		ScreenShot.screenshot(driver, testCaseName, "filling state");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_STATE);
	}

	public String fillZipCode(WebDriver driver, String testCaseName, int zipCode) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_ZIP_CODE, zipCode + "");
		logger.info("ZipCode : " + zipCode);
		ScreenShot.screenshot(driver, testCaseName, "filling zip code");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_ZIP_CODE);
	}

	public String fillCountry(WebDriver driver, String testCaseName, String country) throws ActionBotException
	{
		Select drpDownOption = new Select(ActionBot.findElement(driver, DROPDOWN_COUNTRY));
		drpDownOption.selectByValue(country);
		ScreenShot.screenshot(driver, testCaseName, "selecting Country dropdown");
		return ActionBot.getTextWithInElement(driver, DROPDOWN_COUNTRY);
	}

	public void selectComponentRainbow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement element = driver.findElement(By.xpath(CHECKBOX_COMPONENT_RAINBOW.getValue()));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		ScreenShot.screenshot(driver, testCaseName, "selecting rainbow checkbox");

	}

	public void selectComponentCRMS(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement element = driver.findElement(By.xpath(CHECKBOX_COMPONENT_CRMS.getValue()));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		ScreenShot.screenshot(driver, testCaseName, "selecting crms checkbox");
	}

	public void selectComponentOneView(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement element = driver.findElement(By.xpath(CHECKBOX_COMPONENT_ONEVIEW.getValue()));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		ScreenShot.screenshot(driver, testCaseName, "selecting one view checkbox");

	}

	public String fillProductUrlCivil(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_CIVIL_URL, url);
		logger.info("CIVIL URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling civil url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_CIVIL_URL);
	}

	public String fillProductUrlCRMS(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_CRMS_URL, url);
		logger.info("CRMS URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling CRMS url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_COMPANY_NAME);
	}

	public String fillProductUrlCentralRms(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_CENTRAL_RMS_URL, url);
		logger.info("CENTRAL RM URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling CENTRAL RM url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_CENTRAL_RMS_URL);
	}

	public String fillProductUrlDashBoard(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_DASHBOARD_URL, url);
		logger.info("DASHBOARD URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling DASHBOARD url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_DASHBOARD_URL);
	}

	public String fillProductUrlFieldLibrary(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_FIELD_LIBRARY_URL, url);
		logger.info("FIELD LIBRARY URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling FIELD LIBRARY url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_FIELD_LIBRARY_URL);
	}

	public String fillProductUrlFlexiForm(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_FLEXIFORM_URL, url);
		logger.info("FLEXI FORM URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling FLEXI FORM url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_FLEXIFORM_URL);
	}

	public String fillProductUrlMAS(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_MAS_URL, url);
		logger.info("mas URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling mas url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_MAS_URL);
	}

	public String fillProductUrlNotification(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_NOTIFICATION_URL, url);
		logger.info("NOTIFICATION URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling NOTIFICATION url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_NOTIFICATION_URL);
	}

	public String fillProductUrlOneView(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_ONE_VIEW_URL, url);
		logger.info("ONE VIEW URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling ONE VIEW url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_ONE_VIEW_URL);
	}

	public String fillProductUrlSIM(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_SIM_URL, url);
		logger.info("SIM URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling SIM url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_SIM_URL);
	}

	public String fillProductUrlSPM(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_SPM_URL, url);
		logger.info("SPM URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling SPM url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_SPM_URL);
	}

	public String fillProductUrlSupplierPortal(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_SUPPLIER_PORTAL_URL, url);
		logger.info(" Supplier portal URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling Supplier portal url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_SUPPLIER_PORTAL_URL);
	}

	public String fillProductUrlTMS(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_TMS_URL, url);
		logger.info("TMS URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling TMS url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_TMS_URL);
	}

	public String fillProductUrlWorkFlow(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_WORKFLOW_URL, url);
		logger.info("Workflow URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling Workflow url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_WORKFLOW_URL);
	}

	public String fillProductUrlEInvoice(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_EINVOICE_URL, url);
		logger.info("Einvoice URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling Einvoice url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_EINVOICE_URL);
	}

	public String fillProductUrlEPROC(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_EPROC_URL, url);
		logger.info("EPROC URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling EPROC url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_EPROC_URL);
	}

	public String fillProductUrlIAnalyze(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_IANALYZE_URL, url);
		logger.info("URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_IANALYZE_URL);
	}

	public String fillProductUrlIContract(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_ICONTRACT_URL, url);
		logger.info("Icontract URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling Icontract url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_ICONTRACT_URL);
	}

	public String fillProductUrlICost(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_ICOST_URL, url);
		logger.info("Icost URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling Icost url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_ICOST_URL);
	}

	public String fillProductUrlIManage(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_IMANAGE_URL, url);
		logger.info("Imanage URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling Imanage url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_IMANAGE_URL);
	}

	public String fillProductUrlISave(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_ISAVE_URL, url);
		logger.info("Isave URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling Isave url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_ISAVE_URL);
	}

	public String fillProductUrlIRequest(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_IREQUEST_URL, url);
		logger.info("Irequest URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling Irequest url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_IREQUEST_URL);
	}

	public String fillProductUrlISource(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PRODUCT_ISOURCE_URL, url);
		logger.info("URL: " + url);
		ScreenShot.screenshot(driver, testCaseName, "filling url");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_ISOURCE_URL);
	}

	public String fillAdminFirstName(WebDriver driver, String testCaseName, String firstName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_COMPANY_ADMIN_FIRST_NAME, firstName);
		logger.info("admin first name: " + firstName);
		return ActionBot.getTextWithInElement(driver, TEXTBOX_COMPANY_ADMIN_FIRST_NAME);
	}

	public String fillAdminLastName(WebDriver driver, String testCaseName, String lastName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_COMPANY_ADMIN_LAST_NAME, lastName);
		logger.info("admin last name : " + lastName);
		return ActionBot.getTextWithInElement(driver, TEXTBOX_COMPANY_ADMIN_LAST_NAME);
	}

	public String fillAdminDisplayName(WebDriver driver, String testCaseName, String displayName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_COMPANY_ADMIN_DISPLAY_NAME, displayName);
		logger.info("admin display name: " + displayName);
		return ActionBot.getTextWithInElement(driver, TEXTBOX_COMPANY_ADMIN_DISPLAY_NAME);
	}

	public String fillAdminEmaidId(WebDriver driver, String testCaseName, String adminEmailId) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_COMPANY_ADMIN_EMAIL_ID, adminEmailId);
		logger.info("Admin email id : " + adminEmailId);
		ScreenShot.screenshot(driver, testCaseName, "filling admin email id");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_COMPANY_ADMIN_EMAIL_ID);
	}

	public String selectUniqueKeyType(WebDriver driver, String testCaseName, String uniqueKeyType) throws ActionBotException
	{
		Select drpDownOption = new Select(ActionBot.findElement(driver, DROPDOWN_UNIQUE_KEY_TYPE));
		drpDownOption.selectByVisibleText(uniqueKeyType);
		logger.info("Unique key type : " + uniqueKeyType);
		return ActionBot.getTextWithInElement(driver, DROPDOWN_UNIQUE_KEY_TYPE);
	}

	public String fillUniqueKeyValue(WebDriver driver, String testCaseName, String uniqueKeyValue) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_UNIQUE_KEY_VALUE, uniqueKeyValue);
		logger.info("unique value : " + uniqueKeyValue);
		return ActionBot.getTextWithInElement(driver, TEXTBOX_UNIQUE_KEY_VALUE);
	}

	public void clickOnAddUniqueKeyButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_UNIQUE_KEY_ADD);
		ScreenShot.screenshot(driver, testCaseName, "After adding unique key value");
	}

	public String fillTimeZone(WebDriver driver, String testCaseName, String timeZone) throws ActionBotException
	{
		ActionBot.click(driver, TEXTBOX_TIMEZONE);
		ActionBot.fillAutoCompleteField(driver, TEXTBOX_TIMEZONE, timeZone);
		logger.info("Time Zone : " + timeZone);
		return ActionBot.getTextWithInElement(driver, TEXTBOX_TIMEZONE);
	}

	public void selectNumberFormat(WebDriver driver, String testCaseName, String numberFormat) throws ActionBotException
	{
		Select drpDownOption = new Select(ActionBot.findElement(driver, DROPDOWN_NUMBERFORMAT));
		drpDownOption.selectByValue(numberFormat);
		logger.info("Number Format: " + numberFormat);
		ScreenShot.screenshot(driver, testCaseName, "filling Number Format");

	}

	public void selectDateFormat(WebDriver driver, String testCaseName, String dateFormat) throws ActionBotException
	{
		Select drpDownOption = new Select(ActionBot.findElement(driver, DROPDOWN_DATEFORMAT));
		drpDownOption.selectByValue(dateFormat);
		logger.info("Date Format: " + dateFormat);
		ScreenShot.screenshot(driver, testCaseName, "filling url");

	}

	public String selectTimeFormat(WebDriver driver, String testCaseName, String timeFormat) throws ActionBotException
	{
		Select drpDownOption = new Select(ActionBot.findElement(driver, DROPDOWN_TIMEFORMAT));
		drpDownOption.selectByVisibleText(timeFormat);
		logger.info("Time Format: " + timeFormat);
		return ActionBot.getTextWithInElement(driver, DROPDOWN_TIMEFORMAT);

	}

	public void selectCurrency(WebDriver driver, String testCaseName, String currency) throws ActionBotException
	{
		Select drpDownOption = new Select(ActionBot.findElement(driver, DROPDOWN_CURRENCY));
		drpDownOption.selectByValue(currency.trim());
		logger.info("Currency: " + currency);
		ScreenShot.screenshot(driver, testCaseName, "filling url");

	}

	public void selectLocale(WebDriver driver, String testCaseName, String locale) throws ActionBotException
	{
		Select drpDownOption = new Select(ActionBot.findElement(driver, DROPDOWN_LOCALE));
		drpDownOption.selectByVisibleText(locale);
		//		drpDownOption.selectByValue(locale);
		logger.info("Locale: " + locale);
		ScreenShot.screenshot(driver, testCaseName, "filling Locale");

	}

	public String fillSMTPServerId(WebDriver driver, String testCaseName, String smtpServerId) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_SMTP_SERVERID, smtpServerId);
		logger.info("SMTP server Id : " + smtpServerId);
		ScreenShot.screenshot(driver, testCaseName, "filling SMTP server id");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_SMTP_SERVERID);
	}

	public String fillPortNumber(WebDriver driver, String testCaseName, String portNumber) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PORTNUMBER, portNumber);
		logger.info("Port Number : " + portNumber);
		ScreenShot.screenshot(driver, testCaseName, "filling Port Number");
		return ActionBot.getTextWithInElement(driver, TEXTBOX_PORTNUMBER);
	}

	public String fillDecimalPrecision(WebDriver driver, String testCaseName, String decimalPrecision) throws ActionBotException
	{
		Select drpDownOption = new Select(ActionBot.findElement(driver, DROPDOWN_DECIMAL_PRECISION));
		drpDownOption.selectByValue(decimalPrecision);
		logger.info("Decimal precision: " + decimalPrecision);
		return ActionBot.getTextWithInElement(driver, DROPDOWN_DECIMAL_PRECISION);
	}

	public void clickOnContinueCompanyFormPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CONTINUE);

	}

	public void clickOnContinueProductAllocationPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_PRODUCT_ALLOCATION_PAGE_CONTINUE);

	}

	public void clickOnContinueOnCompanyAdminPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_COMPANYADMIN_PAGE_SAVE);

	}

	public void clickOnDefineCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_DEFINE_COMPANY);

	}

	public void clickOnContinueOnCompanyPreferencePage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_PREFERNCE_PAGE_CONTINUE);

	}

	public void clickOnCreateNewCompanyButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CREATE_NEW_COMPANY_BUTTON);

	}

	public String searchCompany(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		WebElement textboxCompanySearch = ActionBot.findElement(driver, TEXTBOX_COMPANY_SEARCH_COMPANYLISTINGPAGE);
		textboxCompanySearch.sendKeys(companyName);
		textboxCompanySearch.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		ActionBot.defaultSleep();
		try
		{
			try
			{
				if (driver.findElement(By.xpath(LABEL_FIRST_LISTED_USER_COMPANYLISTINGPAGE.getValue())).isDisplayed())
				{
					return driver.findElement(By.xpath(LABEL_FIRST_LISTED_USER_COMPANYLISTINGPAGE.getValue())).getText();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			try
			{
				if (driver.findElement(By.xpath(LABEL_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE.getValue())).isDisplayed())
				{
					String compName= driver.findElement(By.xpath(LABEL_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE.getValue())).getText().trim();
					if(compName.contains("...")){
						return 
							driver.findElement(By.xpath(LABEL_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE.getValue())).getAttribute("title").trim();
					}else{
						return compName;
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			try{
				if (driver.findElement(By.xpath(TD_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE.getValue())).isDisplayed())
				{
					return driver.findElement(By.xpath(TD_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE.getValue())).getText();
				}
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			//			//		return ActionBot.getTextWithInElement(driver, LABEL_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE);
			//			if (ActionBot.isElementDisplayed(driver, LABEL_FIRST_LISTED_USER_COMPANYLISTINGPAGE))
			//			{
			//				return ActionBot.getTextWithInElement(driver, LABEL_FIRST_LISTED_USER_COMPANYLISTINGPAGE);
			//			}
			//			if (ActionBot.isElementDisplayed(driver, LABEL_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE))
			//			{
			//				return ActionBot.findElement(driver, LABEL_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE).getAttribute("title").trim();
			//			}
			//			if (ActionBot.isElementDisplayed(driver, TD_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE))
			//			{
			//				return ActionBot.getTextWithInElement(driver, TD_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE);
			//			}
			//			return null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			//			return null;
		}
		return null;

	}

	public void addRegistryKeyValue(WebDriver driver, String testCaseName, Map<String, String> keyValue) throws ActionBotException
	{
		Set<String> keySet = keyValue.keySet();
		Iterator<String> key = keySet.iterator();
		WebElement textBoxKey = null;
		WebElement textBoxValue = null;
		while (key.hasNext())
		{
			String keyText = key.next();
			textBoxKey = ActionBot.findElement(driver, TEXTBOX_KEY_REGISTRY);
			textBoxValue = ActionBot.findElement(driver, TEXTBOX_VALUE_REGISTRY);
			textBoxKey.sendKeys(String.valueOf(keyText));
			textBoxValue.sendKeys(String.valueOf(keyValue.get(keyText)));
			ActionBot.click(driver, BUTTON_ADD_REGISTRY);
			ActionBot.defaultLowSleep();
			FlowTmsCompanyCreation.clickOnOk(driver, testCaseName);
		}

	}

	public void clickOnBackToSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_BACK_TO_SUMMARY_PAGE);
		ActionBot.defaultSleep();

	}

	public void selectSearchBy(WebDriver driver, String testCaseName, String searchBy) throws ActionBotException
	{
		Select drpDownOption = new Select(ActionBot.findElement(driver, DROPDOWN_SEARCH_BY));
		drpDownOption.selectByValue(searchBy);
		logger.info("Searching By : " + searchBy);
		ActionBot.defaultSleep();

	}

	public void clickOnOk(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_OK))
		{
			ActionBot.click(driver, BUTTON_OK);
			ActionBot.defaultSleep();
		}
	}

	@Override
	public void clickOnHeaderMasterTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
 		ActionBot.click(driver, TAB_MASTER_DATA);
		ActionBot.waitForPageLoad(driver);

	}

}
