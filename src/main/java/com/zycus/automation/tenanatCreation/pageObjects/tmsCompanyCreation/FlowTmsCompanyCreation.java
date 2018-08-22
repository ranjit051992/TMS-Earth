package com.zycus.automation.tenanatCreation.pageObjects.tmsCompanyCreation;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class FlowTmsCompanyCreation
{

	static Logger logger = Logger.getLogger(FlowTmsCompanyCreation.class);

	public static void fillCompanyName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.fillCompanyName(driver, testCaseName, companyName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCompanyName " + e, e);
		}
	}

	public static void clickOnCreateNewCompanyButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.clickOnCreateNewCompanyButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCreateNewCompanyButton " + e, e);
		}
	}

	public static boolean selectCheckBoxSaasCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.selectCheckBoxSaasCompany(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCheckBoxSaasCompany " + e, e);
			return false;
		}

	}

	public static boolean selectCheckBoxdelegateCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.selectCheckBoxdelegateCompany(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCheckBoxdelegateCompany " + e, e);
			return false;
		}

	}

	public static String fillBridgeURL(WebDriver driver, String testCaseName, String bridgeUrl) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillBridgeURL(driver, testCaseName, bridgeUrl);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBridgeURL " + e, e);
			return null;
		}
	}

	public static String fillDomailURL(WebDriver driver, String testCaseName, String domailUrl) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillDomailURL(driver, testCaseName, domailUrl);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDomailURL " + e, e);
			return null;
		}
	}

	public static boolean selectCheckBoxLoginThroughUniqueId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.selectCheckBoxLoginThroughUniqueId(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCheckBoxLoginThroughUniqueId " + e, e);
			return false;
		}
	}

	public static boolean selectCheckBoxEnableScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.selectCheckBoxEnableScope(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCheckBoxEnableScope " + e, e);
			return false;
		}
	}

	public static String fillLocationName(WebDriver driver, String testCaseName, String locationName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillLocationName(driver, testCaseName, locationName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillLocationName " + e, e);
			return null;
		}
	}

	public static String fillAddress1(WebDriver driver, String testCaseName, String address1) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillAddress1(driver, testCaseName, address1);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAddress1 " + e, e);
			return null;
		}
	}

	public static String fillAddress2(WebDriver driver, String testCaseName, String address2) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillAddress2(driver, testCaseName, address2);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAddress2 " + e, e);
			return null;
		}
	}

	public static String fillCity(WebDriver driver, String testCaseName, String city) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillCity(driver, testCaseName, city);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCity " + e, e);
			return null;
		}
	}

	public static String fillState(WebDriver driver, String testCaseName, String state) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillState(driver, testCaseName, state);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillState " + e, e);
			return null;
		}
	}

	public static String fillZipCode(WebDriver driver, String testCaseName, int zipCode) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillZipCode(driver, testCaseName, zipCode);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillZipCode " + e, e);
			return null;
		}
	}

	public static String fillCountry(WebDriver driver, String testCaseName, String country) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillCountry(driver, testCaseName, country);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCountry " + e, e);
			return null;
		}
	}

	public static void selectComponentRainbow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.selectComponentRainbow(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectComponentRainbow " + e, e);
		}
	}

	public static void selectComponentCRMS(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.selectComponentCRMS(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectComponentCRMS " + e, e);
		}
	}

	public static void selectComponentOneView(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.selectComponentOneView(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectComponentOneView " + e, e);
		}
	}

	public static String fillProductUrlCivil(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlCivil(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlCivil " + e, e);
			return null;
		}
	}

	public static String fillProductUrlCRMS(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlCRMS(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlCRMS " + e, e);
			return null;
		}
	}

	public static String fillProductUrlCentralRms(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlCentralRms(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlCentralRms " + e, e);
			return null;
		}
	}

	public static String fillProductUrlDashBoard(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlDashBoard(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlDashBoard " + e, e);
			return null;
		}
	}

	public static String fillProductUrlFieldLibrary(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlFieldLibrary(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlFieldLibrary " + e, e);
			return null;
		}
	}

	public static String fillProductUrlFlexiForm(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlFlexiForm(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlFlexiForm " + e, e);
			return null;
		}
	}

	public static String fillProductUrlMAS(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlMAS(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlMAS " + e, e);
			return null;
		}
	}

	public static String fillProductUrlNotification(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlNotification(driver, testCaseName, url);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlNotification " + e, e);
			return null;
		}
	}

	public static String fillProductUrlOneView(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlOneView(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlOneView " + e, e);
			return null;
		}
	}

	public static String fillProductUrlSIM(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlSIM(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlSIM " + e, e);
			return null;
		}
	}

	public static String fillProductUrlSPM(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlSPM(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlSPM " + e, e);
			return null;
		}
	}

	public static String fillProductUrlSupplierPortal(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlSupplierPortal(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlSupplierPortal " + e, e);
			return null;
		}
	}

	public static String fillProductUrlTMS(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlTMS(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlTMS " + e, e);
			return null;
		}
	}

	public static String fillProductUrlWorkFlow(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlWorkFlow(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlWorkFlow " + e, e);
			return null;
		}
	}

	public static String fillProductUrlEInvoice(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlEInvoice(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlEInvoice " + e, e);
			return null;
		}
	}

	public static String fillProductUrlEPROC(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlEPROC(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlEPROC " + e, e);
			return null;
		}
	}

	public static String fillProductUrlIAnalyze(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlIAnalyze(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlIAnalyze " + e, e);
			return null;
		}
	}

	public static String fillProductUrlIContract(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlIContract(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlIContract " + e, e);
			return null;
		}
	}

	public static String fillProductUrlICost(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlICost(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlICost " + e, e);
			return null;
		}
	}

	public static String fillProductUrlIManage(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlIManage(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlIManage " + e, e);
			return null;
		}
	}

	public static String fillProductUrlISave(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlISave(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlISave " + e, e);
			return null;
		}
	}

	public static String fillProductUrlIRequest(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlIRequest(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlIRequest " + e, e);
			return null;
		}
	}

	public static String fillProductUrlISource(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillProductUrlISource(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlISource " + e, e);
			return null;
		}
	}

	public static String fillAdminFirstName(WebDriver driver, String testCaseName, String firstName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillAdminFirstName(driver, testCaseName, firstName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAdminFirstName " + e, e);
			return null;
		}
	}

	public static String fillAdminLastName(WebDriver driver, String testCaseName, String lastName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillAdminLastName(driver, testCaseName, lastName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAdminLastName " + e, e);
			return null;
		}
	}

	public static String fillAdminDisplayName(WebDriver driver, String testCaseName, String fillAdminDisplayName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillAdminDisplayName(driver, testCaseName, fillAdminDisplayName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAdminDisplayName " + e, e);
			return null;
		}
	}

	public static String fillAdminEmaidId(WebDriver driver, String testCaseName, String adminEmailId) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillAdminEmaidId(driver, testCaseName, adminEmailId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAdminEmaidId " + e, e);
			return null;
		}
	}

	public static String selectUniqueKeyType(WebDriver driver, String testCaseName, String uniqueKeyType) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.selectUniqueKeyType(driver, testCaseName, uniqueKeyType);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectUniqueKeyType " + e, e);
			return null;
		}
	}

	public static String fillUniqueKeyValue(WebDriver driver, String testCaseName, String uniqueKeyValue) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillUniqueKeyValue(driver, testCaseName, uniqueKeyValue);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillUniqueKeyValue " + e, e);
			return null;
		}
	}

	public static void clickOnAddUniqueKeyButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.clickOnAddUniqueKeyButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddUniqueKeyButton " + e, e);
		}
	}

	public static String fillTimeZone(WebDriver driver, String testCaseName, String timeZone) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillTimeZone(driver, testCaseName, timeZone);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillTimeZone " + e, e);
			return null;
		}
	}

	public static void selectNumberFormat(WebDriver driver, String testCaseName, String numberFormat) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.selectNumberFormat(driver, testCaseName, numberFormat);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectNumberFormat " + e, e);
		}
	}

	public static void selectDateFormat(WebDriver driver, String testCaseName, String dateFormat) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.selectDateFormat(driver, testCaseName, dateFormat);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDateFormat " + e, e);
		}
	}

	public static void selectCurrency(WebDriver driver, String testCaseName, String currency) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.selectCurrency(driver, testCaseName, currency);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCurrency " + e, e);
		}
	}

	public static void selectLocale(WebDriver driver, String testCaseName, String locale) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.selectLocale(driver, testCaseName, locale);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectLocale " + e, e);
		}
	}

	public static String fillSMTPServerId(WebDriver driver, String testCaseName, String smtpServerId) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillSMTPServerId(driver, testCaseName, smtpServerId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSMTPServerId " + e, e);
			return null;
		}
	}

	public static String fillPortNumber(WebDriver driver, String testCaseName, String portNumber) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillPortNumber(driver, testCaseName, portNumber);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPortNumber " + e, e);
			return null;
		}
	}

	public static String fillDecimalPrecision(WebDriver driver, String testCaseName, String decimalPrecision) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.fillDecimalPrecision(driver, testCaseName, decimalPrecision);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDecimalPrecision " + e, e);
			return null;
		}
	}

	public static void clickOnContinueCompanyFormPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.clickOnContinueCompanyFormPage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnContinueCompanyFormPage " + e, e);
		}
	}

	public static void clickOnContinueProductAllocationPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.clickOnContinueProductAllocationPage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnContinueProductAllocationPage " + e, e);
		}
	}

	public static void clickOnContinueOnCompanyAdminPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.clickOnContinueOnCompanyAdminPage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnContinueOnCompanyAdminPage " + e, e);
		}
	}

	public static void clickOnContinueOnCompanyPreferencePage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.clickOnContinueOnCompanyPreferencePage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnContinueOnCompanyPreferencePage " + e, e);
		}
	}

	public static void clickOnDefineCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.clickOnDefineCompany(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDefineCompany " + e, e);
		}
	}

	public static void selectTimeFormat(WebDriver driver, String testCaseName, String timeFormat) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.selectTimeFormat(driver, testCaseName, timeFormat);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectTimeFormat " + e, e);
		}
	}

	public static String searchCompany(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			return tmsCompany.searchCompany(driver, testCaseName, companyName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method searchCompany " + e, e);
			return null;
		}
	}

	public static void addRegistryKeyValue(WebDriver driver, String testCaseName, Map<String, String> keyValue) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.addRegistryKeyValue(driver, testCaseName, keyValue);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method addRegistryKeyValue " + e, e);
		}
	}

	public static void clickOnBackToSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.clickOnBackToSummary(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnBackToSummary " + e, e);
		}
	}

	public static void selectSearchBy(WebDriver driver, String testCaseName, String searchBy) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.selectSearchBy(driver, testCaseName, searchBy);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnBackToSummary " + e, e);
		}
	}

	public static void clickOnOk(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.clickOnOk(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnOk " + e, e);
		}
	}

	public static void clickOnHeaderMasterTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			TmsCompanyCreationPageImpl tmsCompany = FactoryPage.getInstanceOf(TmsCompanyCreationPageImpl.class);
			tmsCompany.clickOnHeaderMasterTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnHeaderMasterTab " + e, e);
		}
	}

}
