/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageMasterDataSettingsImpl implements IPageMasterDataSettings
{

	@Override
	public void clickOnUsersLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, USERS_LINK))
		{
			ActionBot.click(driver, USERS_LINK);
		}
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on users link");

	}

	@Override
	public void clickOnGLAccountTypesLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, GL_ACCOUNT_TYPES_LINK);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on GL Account Types link");

	}

	@Override
	public void clickOnGLAccountsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, GL_ACCOUNTS_LINK);
		ActionBot.defaultSleep();
		// ScreenShot.screenshot(driver, testCaseName, "After clicking on GL
		// Accounts link");

	}

	@Override
	public void clickOnCategoryPurchaseType_GL_Maps_Link(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CATEGORY_PURCHASE_TYPE_GL_MAPS_LINK);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Category Purhcase Type GL Maps link");

	}

	@Override
	public void clickOnReturnToSetUpModule(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, RETURN_TO_SET_UP_MODULE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Return To Set Up Module");

	}

	@Override
	public void clickOnProjectsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PROJECTS_LINK))
		{
			ActionBot.click(driver, PROJECTS_LINK);
		}
		else if (ActionBot.isElementPresent(driver, LINK_STATISTICAL_PROJECTS))
		{
			ActionBot.click(driver, LINK_STATISTICAL_PROJECTS);
		}
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on projects link");

	}

	@Override
	public void clickOnLocationLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LOCATION_LINK);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on location link");
	}

	@Override
	public void clickOnTaxRatesLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAX_RATES_LINK);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on tax rate link");

	}

	@Override
	public void clickOnAddressLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ADDRESSES_LINK);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on address link");

	}

	@Override
	public void clickOnCompanyActivateAndDeactivelink(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='companyList']//tr[" + index + "]//a[@class='icon active status scLnk']"));

	}

	@Override
	public void clickOnCompaniesLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, COMPANIES_LINK);

	}

	@Override
	public void clickOnBackToSummaryLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BACK_TO_SUMMARY_LINK);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnDeactivelink(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='companyList']//tr[" + index + "]//a[@class='icon deactive status scLnk']"));

	}

	@Override
	public void clickOnCostCenterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, COSTCENTER_LINK);

	}

	@Override
	public void clickOnBusinessUnitLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUSINESS_UNIT_LINK);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on business unit link");

	}

	@Override
	public void clickOnEntityOwnershiplink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ENTITY_OWNERSHIP);
	}

	@Override
	public void clickOnAssetCodesLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ASSET_CODES_LINK);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Asset Codes link");

	}

	@Override
	public void clickOnSupplierCodesMapLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SUPPLIER_CODES_MAP_LINK);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Supplier codes map link");

	}

	@Override
	public void clickOnProceedWithWizardButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_PROCEED_WITH_WIZARD))
		{
			ActionBot.click(driver, BUTTON_PROCEED_WITH_WIZARD);
		}
	}

	@Override
	public void clickOnUsersLinkInUserManagementTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, USERS_LINK_IN_USER_MANAGEMENT))
		{
			ActionBot.click(driver, USERS_LINK_IN_USER_MANAGEMENT);
		}
	}

	@Override
	public void clickOnUserManagementTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TAB_USER_MANAGEMENT))
		{
			ActionBot.click(driver, TAB_USER_MANAGEMENT);
		}
	}

}
