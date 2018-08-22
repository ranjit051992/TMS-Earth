package com.zycus.automation.eproc.pageobjects.modals.itemsummarycostbooking;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IModalItemSummaryCostBookingImpl implements IModalItemSummaryCostBooking
{

	static Logger logger = Logger.getLogger(IModalItemSummaryCostBookingImpl.class);

	@Override
	public void clickOnCostBooking(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_COST_BOOKING_ITEM_SUMMARY);

	}

	@Override
	public String getTagNameOfProjectFieldLabel(WebDriver driver) throws ActionBotException
	{
		WebElement element;
		element = ActionBot.findElement(driver, LABEL_PROJECT_ITEM_SUMMARY);
		return element.getTagName();

	}

	@Override
	public boolean isProjectFieldALabel(WebDriver driver) throws Exception

	{
		WebElement element = ActionBot.getElement(driver, IModalItemSummaryCostBooking.LABEL_PROJECT_ITEM_SUMMARY);
		String ui_attri = element.getAttribute("class");
		boolean bl = ui_attri.contains("lbl") || ui_attri.contains("Lbl") ? true : false;
		return bl;
	}

	@Override
	public boolean isProjectOrTaskIconPresent(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PROJECT_OR_TASK_ICON_ITEM_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isProjectInfoIconPresent(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, PROJECT_INFO_ICON_ITEM_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getItemlevelCostingdetails(WebDriver driver) throws ActionBotException
	{
		String itemcostingDetails = ActionBot.findElement(driver, ITEM_LEVEL_COSTING_DETAILS).getAttribute("value");
		logger.info("Cost center is :" + itemcostingDetails);
		return itemcostingDetails;
	}

	@Override
	public String getItemlevelProjectdetails(WebDriver driver) throws ActionBotException
	{
		String itemProjectDetails = ActionBot.findElement(driver, ITEM_LEVEL_PROJECT_DETAILS).getAttribute("value");
		logger.info("Project is :" + itemProjectDetails);
		return itemProjectDetails;
	}

	@Override
	public String getAmountAssigned(WebDriver driver) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, LABEL_AMOUNT_ASSIGNED_COST_BOOKING_ITEM_SUMMARY);
		return str;
	}

	@Override
	public String fillCostCenter(WebDriver driver, String testCaseName, String CC) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_CC);
		ele.clear();
		ActionBot.defaultSleep();
		ele.sendKeys(CC);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		String str = ele.getAttribute("value").trim();
		return str;

	}

	@Override
	public String fillProject(WebDriver driver, String testCaseName, String project) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_PROJECT);
		ele.clear();
		ActionBot.defaultSleep();
		ele.sendKeys(project);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		String str = ele.getAttribute("value").trim();
		return str;
	}

	@Override
	public String fillBudget(WebDriver driver, String testCaseName, String budget) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_BUDGET);
		ele.clear();
		ActionBot.defaultSleep();
		ele.sendKeys(budget);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		String str = ele.getAttribute("value").trim();
		return str;
	}

	@Override
	public String getItemlevelBudgetdetails(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		String budget = null;
		budget = ActionBot.findElement(driver, ITEM_LEVEL_BUDGET_DETAILS).getAttribute("value");
		logger.info("Budget is :" + budget);
		return budget;
	}
}
