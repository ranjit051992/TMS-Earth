package com.zycus.automation.eproc.pageobjects.modals.itemSummaryAccounting;

import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IModalItemSummaryAccountingImpl implements IModalItemSummaryAccounting
{

	@Override
	public void clickOnAccounting(WebDriver driver) throws ActionBotException
	{

		ActionBot.click(driver, BUTTON_ACCOUNTING_ITEM_SUMMARY);

	}

	@Override
	public void clickOnCancel(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_ITEM_SUMMARY);

	}

	@Override
	public void clickOnDelivery(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, MODAL_ITEM_SUMMARY_DELIVERY);

	}

	@Override
	public void clickOnSave(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_ITEM_SUMMARY);

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
	public String fillGLType(WebDriver driver, String glType) throws ActionBotException
	{
		int i = 0;
		String temp[] = StringUtils.split(glType, ":");
		String gl_Type = temp[1].trim();

		WebElement ele = ActionBot.findElement(driver, TEXTBOX_GL_TYPE_ITEM_SUMMARY);
		Select sel = new Select(ele);

		List<WebElement> gl_account_type_list = sel.getOptions();
		for (WebElement element : gl_account_type_list)
		{
			if (element.getText().trim().contains(gl_Type))
			{
				break;
			}
			i++;
		}
		sel.selectByIndex(i);

		return sel.getFirstSelectedOption().getText().trim();
	}

	@Override
	public String fillReqByDateAtItemLevel(WebDriver driver, String day, String month, String year) throws ActionBotException
	{
		ActionBot.click(driver, REQ_BY_DATE_ITEM_LEVEL);

		// month
		Select select = new Select(ActionBot.findElement(driver, SELECT_MONTH));
		select.selectByValue(month);

		// year
		select = new Select(ActionBot.findElement(driver, SELECT_YEAR));
		select.selectByValue(year);

		// day
		ActionBot.click(driver, By.linkText(day));

		String requiredByDate = ActionBot.findElement(driver, REQ_BY_DATE_ITEM_LEVEL).getAttribute("value").trim();

		return requiredByDate;
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
	public boolean isGLTypeFieldFilled(WebDriver driver) throws ActionBotException
	{
		String str = ActionBot.findElement(driver, TEXTBOX_GL_TYPE_ITEM_SUMMARY).getText();
		if (str.equals("GLTYPE002: Expense"))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean isGLTypeFieldFilledEditable(WebDriver driver, String glType) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_GL_TYPE_ITEM_SUMMARY_LABEL))
		{
			return true;
		}
		return false;
	}

}
