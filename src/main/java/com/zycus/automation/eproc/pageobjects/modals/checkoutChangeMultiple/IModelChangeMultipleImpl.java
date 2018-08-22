package com.zycus.automation.eproc.pageobjects.modals.checkoutChangeMultiple;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.IPageRequisitionCheckOut;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModelChangeMultipleImpl implements IModelChangeMultiple
{
	static Logger logger = Logger.getLogger(IModelChangeMultipleImpl.class);

	@Override
	public void clickChangeMultipleApply(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, CHANGE_MULTIPLE_APPLY);
		ScreenShot.screenshot(driver, testCaseName, "after change multiple apply");

	}

	@Override
	public void clickChangeMultipleClose(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, CHANGE_MULTIPLE_CLOSE);
		ScreenShot.screenshot(driver, testCaseName, "after change multiple close");
	}

	@Override
	public void clickClearChangeMultipleDate(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, CHANGE_MULTIPLE_CLEAR_DATE);
		ScreenShot.screenshot(driver, testCaseName, "after clear change multiple date");
	}

	@Override
	public String fillChangeMultipleBudget(WebDriver driver, String testCaseName, String changeMultipleBudget) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, CHANGE_MULTIPLE_BUDGET);
		ele.clear();
		ele.sendKeys(changeMultipleBudget);
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		String value = ele.getAttribute("value").trim();
		ScreenShot.screenshot(driver, testCaseName, "after change multiple budget");
		if (value != null)
		{
			return value;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillChangeMultipleCostCenter(WebDriver driver, String testCaseName, String changeMultipleCostCenter) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, CHANGE_MULTIPLE_COST_CENTER);
		ele.clear();
		ele.sendKeys(changeMultipleCostCenter);
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		String value = ele.getAttribute("value").trim();
		ScreenShot.screenshot(driver, testCaseName, "after change multiple cost center");
		if (value != null)
		{
			return value;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getChangeMultipleDate(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String date = ActionBot.findElement(driver, CHANGE_MULTIPLE_DATE).getAttribute("value");
		if (date != null)
		{
			return date;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<WebElement> getListOfAvailableGLAccounts(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LIST_OF_GL_ACCOUNTS_AVAILABLE_FOR_SELECTION_UPDATE_ALL_LINES);
	}

	@Override
	public List<String> getListOfNamesAvailableGLAccounts(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> glAccountsNames = new ArrayList<String>();

		for (WebElement element : getListOfAvailableGLAccounts(driver, testCaseName))
		{
			glAccountsNames.add(element.getText().trim());
		}

		return glAccountsNames;
	}

	@Override
	public String fillChangeMultipleGLAccount(WebDriver driver, String testCaseName, String changeMultipleGLAccount) throws ActionBotException
	{
		String glAccount = ActionBot.fillAutoCompleteField(driver, CHANGE_MULTIPLE_GL_ACCOUNT, changeMultipleGLAccount);
		logger.info("Changed Multiple GL Account : " + glAccount);
		ScreenShot.screenshot(driver, testCaseName, "after changing multiple GL account");
		return glAccount;
	}

	@Override
	public void clearChangeMultipleGLAccount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, CHANGE_MULTIPLE_GL_ACCOUNT);
		ActionBot.defaultSleep();
	}

	@Override
	public String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		return ActionBot.fillAutoCompleteField(driver, TEXTBOX_SUPPLIER_UPDATE_ALL_LINES_BUYERS_DESK, supplierName);
	}

	@Override
	public String fillChangeMultipleProject(WebDriver driver, String testCaseName, String project) throws ActionBotException
	{
		String enteredProject = ActionBot.fillAutoCompleteField(driver, TEXTBOX_PROJECT_CHANGE_MULTIPLE, project);
		logger.info("Changed Multiple Project : " + enteredProject);
		ScreenShot.screenshot(driver, testCaseName, "after change multiple project");
		return enteredProject;
	}

	@Override
	public String selectRequiredByDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.click(driver, DATE_PICKER_REQUIRED_BY_DATE_CHANGE_MULTIPLE);
		// year
		Select select = new Select(ActionBot.findElement(driver, IPageRequisitionCheckOut.SELECT_YEAR));
		select.selectByValue(year);

		// month
		select = new Select(ActionBot.findElement(driver, IPageRequisitionCheckOut.SELECT_MONTH));
		select.selectByValue(month);

		// day
		ActionBot.click(driver, By.linkText(day));

		String requiredByDate = ActionBot.findElement(driver, CHANGE_MULTIPLE_DATE).getAttribute("value").trim();
		logger.info("Selected Delivery Date : " + requiredByDate);
		return requiredByDate;
	}

	@Override
	public void clickDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHANGE_MULTIPLE_DELIVERY_TAB);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickSupplierTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHANGE_MULTIPLE_SUPPLIER_TAB);
		ActionBot.defaultSleep();
	}
}
