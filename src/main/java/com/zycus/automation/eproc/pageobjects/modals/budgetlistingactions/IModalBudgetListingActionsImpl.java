/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.budgetlistingactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalBudgetListingActionsImpl implements IModalBudgetListingActions
{

	@Override
	public void clickOnViewBudgetAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_VIEW_BUDGET_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on view budget");
	}

	@Override
	public void clickOnDeactivateBudgetAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DEACTIVE_BUDGET_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on deactivate budget");
	}

	@Override
	public void clickOnUpdateBudgetAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_UPDATE_BUDGET_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on update budget");

	}

	@Override
	public void clickOnAnalyzeBudgetAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ANALYZE_BUDGET_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on analyze budget");
	}

	@Override
	public void clickOnActivateBudgetAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ACTIVATE_BUDGET_ACTIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on activate budget");
	}

	@Override
	public boolean isUpdateBudgetActionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LINK_UPDATE_BUDGET_ACTIONS);
	}

	@Override
	public boolean isDeactivateBudgetActionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LINK_DEACTIVE_BUDGET_ACTIONS);
	}

	@Override
	public boolean isViewBudgetActionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LINK_VIEW_BUDGET_ACTIONS);
	}

	@Override
	public boolean isActivateBudgetActionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LINK_ACTIVATE_BUDGET_ACTIONS);
	}

}
