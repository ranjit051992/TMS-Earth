/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageMasterDataSettings
{

	static Logger logger = Logger.getLogger(PageMasterDataSettings.class);

	public static void clickOnUsersLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
			masterDataSettings.clickOnUsersLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnUsersLink " + e, e);
		}

	}

	public static void clickOnGLAccountTypesLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
			masterDataSettings.clickOnGLAccountTypesLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnGLAccountTypesLink " + e, e);
		}

	}

	public static void clickOnCostCenterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
			masterDataSettings.clickOnCostCenterLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCostCenterLink " + e, e);
		}

	}

	public static void clickOnGLAccountsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
			masterDataSettings.clickOnGLAccountsLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnGLAccountsLink " + e, e);
		}

	}

	public static void clickOnCategoryPurchaseType_GL_Maps_Link(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
			masterDataSettings.clickOnCategoryPurchaseType_GL_Maps_Link(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCategoryPurchaseType_GL_Maps_Link " + e, e);
		}

	}

	public static void clickOnReturnToSetUpModule(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
			masterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReturnToSetUpModule " + e, e);
		}

	}

	public static void clickOnProjectsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageMasterDataSettings masterDataSettings;
		try
		{
			masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
			masterDataSettings.clickOnProjectsLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnProjectsLink " + e, e);
		}

	}

	public static void clickOnLocationLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
		masterDataSettings.clickOnLocationLink(driver, testCaseName);
	}

	public static void clickOnTaxRatesLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
		masterDataSettings.clickOnTaxRatesLink(driver, testCaseName);
	}

	public static void clickOnCompaniesLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
		masterDataSettings.clickOnCompaniesLink(driver, testCaseName);
	}

	public static void clickOnAddressLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
		masterDataSettings.clickOnAddressLink(driver, testCaseName);
	}

	public static void clickOnCompanyActivateAndDeactivelink(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
		masterDataSettings.clickOnCompanyActivateAndDeactivelink(driver, testCaseName, index);
	}

	public static void clickOnBackToSummaryLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
		masterDataSettings.clickOnBackToSummaryLink(driver, testCaseName);
	}

	public static void clickOnDeactivelink(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
		masterDataSettings.clickOnDeactivelink(driver, testCaseName, index);
	}

	public static void clickOnBusinessUnitLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
		masterDataSettings.clickOnBusinessUnitLink(driver, testCaseName);
	}

	public static void clickOnEntityOwnershiplink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
		masterDataSettings.clickOnEntityOwnershiplink(driver, testCaseName);
	}

	public static void clickOnAssetCodesLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
		masterDataSettings.clickOnAssetCodesLink(driver, testCaseName);
	}

	public static void clickOnSupplierCodesMapLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
		masterDataSettings.clickOnSupplierCodesMapLink(driver, testCaseName);
	}

	public static void clickOnProceedWithWizardButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
		masterDataSettings.clickOnProceedWithWizardButton(driver, testCaseName);
	}

	public static void clickOnUsersLinkInUserManagementTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
		masterDataSettings.clickOnUsersLinkInUserManagementTab(driver, testCaseName);
	}

	public static void clickOnUserManagementTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMasterDataSettings masterDataSettings = FactoryPage.getInstanceOfIPageMasterDataSettings();
		masterDataSettings.clickOnUserManagementTab(driver, testCaseName);
	}

}
