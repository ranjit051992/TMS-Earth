/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.cataloglistingactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 * 
 */
public class IModalCatalogListingActionsImpl implements IModalCatalogListingActions
{

	@Override
	public void clickOnUpdateScopeAndValidity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_UPDATE_SCOPE_AND_VALIDITY);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Update Scope and Validity");
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnUpdateCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_UPDATE_CATALOG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Update Catalog");

	}

	@Override
	public void clickOnDeactivateCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DEACTIVE_CATALOG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on deactivate catalog");

	}

	@Override
	public void clickOnExportCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EXPORT_CATALOG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on export catalog");
	}

	@Override
	public void clickOnViewCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_VIEW_CATALOG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on View Catalog");

	}

	@Override
	public void clickOnDeletCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DELETE_CATALOG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on delete catalog");
	}

	@Override
	public void clickOnRecallCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_RECALL_CATALOG);
	}

	@Override
	public void clickOnCancelCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CANCEL_CATALOG);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After cancelling catalog");
	}

	@Override
	public boolean isUpdateCatalogPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_UPDATE_CATALOG))
			return true;
		return false;

	}

	@Override
	public boolean isViewCatalogPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_VIEW_CATALOG))
			return true;
		return false;

	}

	@Override
	public boolean isDeactivateCatalogPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_DEACTIVE_CATALOG))
			return true;
		return false;

	}

}
