/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.budgetlistingactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalBudgetListingActions
{
	static UI_Elements	LINK_VIEW_BUDGET_ACTIONS		= UIFactory.getElements("LINK_VIEW_BUDGET_ACTIONS");
	static UI_Elements	LINK_DEACTIVE_BUDGET_ACTIONS	= UIFactory.getElements("LINK_DEACTIVE_BUDGET_ACTIONS");
	static UI_Elements	LINK_UPDATE_BUDGET_ACTIONS		= UIFactory.getElements("LINK_UPDATE_BUDGET_ACTIONS");
	static UI_Elements	LINK_ANALYZE_BUDGET_ACTIONS		= UIFactory.getElements("LINK_ANALYZE_BUDGET_ACTIONS");
	static UI_Elements	LINK_ACTIVATE_BUDGET_ACTIONS	= UIFactory.getElements("LINK_ACTIVATE_BUDGET_ACTIONS");

	public void clickOnViewBudgetAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeactivateBudgetAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUpdateBudgetAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAnalyzeBudgetAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnActivateBudgetAction(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUpdateBudgetActionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDeactivateBudgetActionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isViewBudgetActionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isActivateBudgetActionPresent(WebDriver driver, String testCaseName) throws ActionBotException;
}
