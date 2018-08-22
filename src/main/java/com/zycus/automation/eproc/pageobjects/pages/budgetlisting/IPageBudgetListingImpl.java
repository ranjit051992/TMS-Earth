/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.budgetlisting;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageBudgetListingImpl implements IPageBudgetListing
{
	static Logger logger = Logger.getLogger(IPageBudgetListingImpl.class);

	@Override
	public void clickOnAddBudgetButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_BUDGET);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add budget button");
	}

	@Override
	public String fillBudgetName(WebDriver driver, String testCaseName, String budgetName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, INPUT_SEARCH_BUDGET_NAME);
		ActionBot.waitForPageLoad(driver);
		element.sendKeys(budgetName);
		ActionBot.defaultSleep();
		element.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		String budget_name = element.getAttribute("value").trim();
		logger.info("Entered Budget Name : " + budget_name);
		ActionBot.waitTillPopUpIsPresent(driver, PROCESSING_DIV_BUDGET_LISTING);
		return budget_name;
	}

	@Override
	public String fillCompanyName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		String company_name = ActionBot.fillAutoCompleteField(driver, INPUT_SEARCH_BUDGET_COMPANY, companyName);
		logger.info("Entered Company Name : " + company_name);
		ActionBot.waitTillPopUpIsPresent(driver, PROCESSING_DIV_BUDGET_LISTING);
		return company_name;
	}

	@Override
	public String fillOwnerName(WebDriver driver, String testCaseName, String ownerName) throws ActionBotException
	{
		String owner_name = ActionBot.fillAutoCompleteField(driver, INPUT_SEARCH_BUDGET_OWNER, ownerName);
		logger.info("Entered Owner Name : " + owner_name);
		ActionBot.waitTillPopUpIsPresent(driver, PROCESSING_DIV_BUDGET_LISTING);
		return owner_name;
	}

	@Override
	public void clickOnActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ACTIONS_FOR_BUDGET);
	}

	@Override
	public String getStatusOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String status = ActionBot.getTextWithInElement(driver, LABEL_STATUS_OF_BUDGET);
		logger.info("Status : " + status);
		return status;
	}

	@Override
	public void clickOnAddPeriod(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_BUDGET_PERIOD);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on link add budget period");
	}

	@Override
	public String getBudgetNameOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String budgetName = ActionBot.getTextWithInElement(driver, LABEL_NAME_OF_BUDGET);
		ActionBot.waitForPageLoad(driver);
		logger.info("Budget Name : " + budgetName);
		return budgetName;
	}

	@Override
	public String getCompanyOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String companyName = ActionBot.getTextWithInElement(driver, LABEL_COMPANY_OF_BUDGET);
		logger.info("Company Name : " + companyName);
		return companyName;
	}

	@Override
	public String getOwnerOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String ownerName = ActionBot.getTextWithInElement(driver, LABEL_OWNER_OF_BUDGET);
		logger.info("Owner Name : " + ownerName);
		return ownerName;
	}

	@Override
	public String getPlannedAmountOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String plannedAmount = ActionBot.getTextWithInElement(driver, LABEL_PLANNED_AMOUNT_OF_BUDGET);
		logger.info("Planned Amount : " + plannedAmount);
		return plannedAmount;
	}

	@Override
	public void waitTillSuccessMsgIsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, SUCCESS_MSG_DIV);
	}

	@Override
	public void clickOnFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LABEL_NAME_OF_BUDGET);
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, BUTTON_ADD_BUDGET))
		{
			ActionBot.click(driver, LABEL_NAME_OF_BUDGET);
		}
	}

	@Override
	public String fillBudgetBU(WebDriver driver, String testCaseName, String budgetBUName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, BUDGET_BUSINESS_UNIT_SEARCH_TEXTBOX);
		element.sendKeys(budgetBUName);
		element.sendKeys(Keys.ENTER);
		String budget_BU_name = element.getAttribute("value").trim();
		logger.info("Entered Budget Name : " + budget_BU_name);
		//ActionBot.waitTillPopUpIsPresent(driver, PROCESSING_DIV_BUDGET_LISTING);
		ActionBot.waitForPageLoad(driver);
		return budget_BU_name;
	}

	@Override
	public String getBudgetBUOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, FISRT_BUDGET_BU))
		{
			String budgetBUName = ActionBot.getTextWithInElement(driver, FISRT_BUDGET_BU);
			logger.info("Budget Name : " + budgetBUName);
			return budgetBUName;
		}
		return null;
	}

	/*
	 * author: bhakti.sawant
	 */
	@Override
	public String getBudgetReservedAmountOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUDGET_BUNIT_RESERVED_AMOUNT))
		{
			String budgetBUReservedAmount = ActionBot.getTextWithInElement(driver, BUDGET_BUNIT_RESERVED_AMOUNT);
			ActionBot.waitForPageLoad(driver);
			logger.info("Budget Reserved Amount : " + budgetBUReservedAmount);
			return budgetBUReservedAmount;
		}
		return null;
	}

	/*
	 * author: bhakti.sawant
	 */
	@Override
	public String getBudgetBalanceAmountOfFirstBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, FIRST_BUDGET_LINE_BALANCE_AMOUNT))
		{
			String budgetBUBalanceAmount = ActionBot.getTextWithInElement(driver, FIRST_BUDGET_LINE_BALANCE_AMOUNT);
			logger.info("Budget Reserved Amount : " + budgetBUBalanceAmount);
			return budgetBUBalanceAmount;
		}
		return null;
	}
}
