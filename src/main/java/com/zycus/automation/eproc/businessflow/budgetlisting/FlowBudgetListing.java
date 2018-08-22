
package com.zycus.automation.eproc.businessflow.budgetlisting;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.Budget;
import com.zycus.automation.bo.CustomDate;
import com.zycus.automation.eproc.pageobjects.modals.budgetlistingactions.ModalBudgetListingActions;
import com.zycus.automation.eproc.pageobjects.modals.updatebudgetvalidity.ModalUpdateBudgetValidity;
import com.zycus.automation.eproc.pageobjects.pages.budgetlisting.IPageBudgetListing;
import com.zycus.automation.eproc.pageobjects.pages.budgetlisting.PageBudgetListing;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class FlowBudgetListing
{
	static Logger logger = Logger.getLogger(FlowBudgetListing.class);

	public static boolean searchBudget(WebDriver driver, String testCaseName, String searchBy, Budget budget) throws ActionBotException
	{
		boolean flag = false;
		ActionBot.waitForPageLoad(driver);
		MainPageHeaderLevelTab.clickOnBudgetTab(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		ActionBot.refreshPage(driver, testCaseName);
		if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME))
		{
			PageBudgetListing.fillBudgetName(driver, testCaseName, budget.getBudgetName());
		}
		else if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BUDGET_BY_COMPANY))
		{
			PageBudgetListing.fillCompanyName(driver, testCaseName, budget.getCompanyName());
		}
		else if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BUDGET_BY_OWNER))
		{
			PageBudgetListing.fillOwnerName(driver, testCaseName, budget.getOwnerName());
		}
		else
		{
			logger.info("Wrong search by option");
		}
		ActionBot.waitForPageLoad(driver);
		flag = checkIfBudgetSearched(driver, testCaseName, budget);
		return flag;

	}

	public static boolean checkIfBudgetSearched(WebDriver driver, String testCaseName, Budget budget) throws ActionBotException
	{
		boolean flag = false;
		logger.info("Searched budget details : ");
		flag = ((budget.getBudgetName().equalsIgnoreCase(PageBudgetListing.getBudgetNameOfFirstBudget(driver, testCaseName)))
			&& (budget.getCompanyName().equalsIgnoreCase(PageBudgetListing.getCompanyOfFirstBudget(driver, testCaseName))))/*
																															 * && (budget.getOwnerName().equalsIgnoreCase(
																															 * PageBudgetListing
																															 * .getOwnerOfFirstBudget(driver,
																															 * testCaseName))))
																															 */;
		return flag;
	}

	public static void viewFirstClosedBudget(WebDriver driver, String testCaseName, Budget budget) throws ActionBotException
	{
		//apply filter
		ActionBot.findElement(driver, IPageBudgetListing.BUTTON_STATUS_FILTER).click();
		//select closed
		ActionBot.findElement(driver, IPageBudgetListing.CHECKBOX_CLOSED_BUDGET).click();
		//click on filer
		ActionBot.findElement(driver, IPageBudgetListing.BUTTON_FILTER_BUDGET).click();
		//select budget
		PageBudgetListing.clickOnFirstBudget(driver, testCaseName);
	}

	public static boolean deactivateBudget(WebDriver driver, String testCaseName, Budget budget) throws ActionBotException
	{
		boolean flag = false;
		PageBudgetListing.clickOnActions(driver, testCaseName);
		if (!ModalBudgetListingActions.isDeactivateBudgetActionPresent(driver, testCaseName))
		{
			PageBudgetListing.clickOnActions(driver, testCaseName);
		}
		ModalBudgetListingActions.clickOnDeactivateBudgetAction(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		PageBudgetListing.waitTillSuccessMsgIsPresent(driver, testCaseName);
		//ActionBot.waitForPageLoad(driver);
		//ActionBot.defaultSleep();

		searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);

		flag = PageBudgetListing.getStatusOfFirstBudget(driver, testCaseName).equalsIgnoreCase(IConstantsData.DEACTIVATED);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To view budget <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static void viewBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		PageBudgetListing.clickOnFirstBudget(driver, testCaseName);
	}

	public static void updateBudgetValidity(WebDriver driver, String testCaseName, CustomDate endDate) throws ActionBotException
	{
		PageBudgetListing.clickOnActions(driver, testCaseName);
		if (!ModalBudgetListingActions.isUpdateBudgetActionPresent(driver, testCaseName))
		{
			PageBudgetListing.clickOnActions(driver, testCaseName);
		}
		ModalBudgetListingActions.clickOnUpdateBudgetAction(driver, testCaseName);
		endDate.setDate(ModalUpdateBudgetValidity.selectEndDate(driver, testCaseName, endDate.getDay(), endDate.getMonth(), endDate.getYear()));
		logger.info("End date: day:" + endDate.getDay() + " month:" + endDate.getMonth() + " year:" + endDate.getYear());
		ModalUpdateBudgetValidity.clickOnUpdateBudgetValidityButton(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Activate Budget <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param budget </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean activateBudget(WebDriver driver, String testCaseName, Budget budget) throws ActionBotException
	{
		boolean flag = false;
		PageBudgetListing.clickOnActions(driver, testCaseName);
		if (!ModalBudgetListingActions.isActivateBudgetActionPresent(driver, testCaseName))
		{
			PageBudgetListing.clickOnActions(driver, testCaseName);
		}

		ModalBudgetListingActions.clickOnActivateBudgetAction(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		PageBudgetListing.waitTillSuccessMsgIsPresent(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();

		flag = PageBudgetListing.getStatusOfFirstBudget(driver, testCaseName).equalsIgnoreCase(IConstantsData.IN_USE);
		return flag;
	}

	public static boolean searchBudgetLine(WebDriver driver, String testCaseName, String searchBy, String budgetBU) throws ActionBotException
	{
		boolean flag = false;
		ActionBot.waitForPageLoad(driver);
		if (searchBy.equalsIgnoreCase(IConstantsData.SEARCH_BUDGET_LINE_BY_BU))
		{
			PageBudgetListing.fillBudgetBU(driver, testCaseName, budgetBU);
		}
		else
		{
			logger.info("Wrong search by option");
		}

		flag = checkIfBudgetLineSearched(driver, testCaseName, budgetBU);
		return flag;

	}

	private static boolean checkIfBudgetLineSearched(WebDriver driver, String testCaseName, String budgetBU) throws ActionBotException
	{
		boolean flag = false;
		logger.info("Searched budget BU : ");
		flag = budgetBU.equalsIgnoreCase(PageBudgetListing.getBudgetBUOfFirstBudget(driver, testCaseName));
		return flag;
	}
}
