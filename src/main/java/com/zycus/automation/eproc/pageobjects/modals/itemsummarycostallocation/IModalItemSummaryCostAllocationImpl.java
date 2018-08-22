package com.zycus.automation.eproc.pageobjects.modals.itemsummarycostallocation;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IModalItemSummaryCostAllocationImpl implements IModalItemSummaryCostAllocation
{

	Logger logger = Logger.getLogger(IModalItemSummaryCostAllocationImpl.class);

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
		WebElement element = ActionBot.getElement(driver, IModalItemSummaryCostAllocation.LABEL_PROJECT_ITEM_SUMMARY);
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
		String itemcostingDetails = ActionBot.getTextWithInElement(driver, ITEM_LEVEL_COSTING_DETAILS);
		return itemcostingDetails;
	}

	@Override
	public String getItemlevelProjectdetails(WebDriver driver) throws ActionBotException
	{
		String itemProjectDetails = ActionBot.getTextWithInElement(driver, ITEM_LEVEL_PROJECT_DETAILS);
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
		String str = ActionBot.fillAutoCompleteField(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_CC, CC);
		logger.info("Cost center is : " + str);
		return str;

	}

	@Override
	public String fillProject(WebDriver driver, String testCaseName, String project) throws ActionBotException
	{
		String str = ActionBot.fillAutoCompleteField(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_PROJECT, project);
		logger.info("Project is :" + str);
		return str;
	}

	@Override
	public String fillBudget(WebDriver driver, String testCaseName, String budget) throws ActionBotException
	{
		String str = ActionBot.fillAutoCompleteField(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_BUDGET, budget);
		logger.info("Budget is :" + str);
		return str;
	}

	@Override
	public void clickOnCancel(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_ITEM_SUMMARY);

	}

	@Override
	public void clickOnSave(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_ITEM_SUMMARY);
		ActionBot.defaultSleep();

	}

	@Override
	public String fillGLAccount(WebDriver driver, String glAccount) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY);
		if (glAccount != null)
		{
			ele.clear();
			ele.sendKeys(glAccount);
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);
		}
		else
		{
			if (ele.getAttribute("value").equals(""))
			{
				ele.click();
				ele.sendKeys(Keys.ARROW_DOWN);
				ele.sendKeys(Keys.RETURN);
			}
		}

		ActionBot.defaultSleep();
		if (ele.getAttribute("value") != null)
		{
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getaccuntTypeErrorMsg(WebDriver driver, String accountTypeErrorMsg) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ACCOUNTING_ERROR_MSG))
		{
			String Errormsg = ActionBot.findElement(driver, ACCOUNTING_ERROR_MSG).getText();
			return Errormsg;
		}
		return null;
	}

	@Override
	public boolean isGLAccountFieldFilled(WebDriver driver) throws ActionBotException
	{
		String str = ActionBot.findElement(driver, TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY).getText();
		if (str.equals("1: Expense"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isGLAccountFieldEnabled(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.isElementEnabled(driver, TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY);
	}
}
