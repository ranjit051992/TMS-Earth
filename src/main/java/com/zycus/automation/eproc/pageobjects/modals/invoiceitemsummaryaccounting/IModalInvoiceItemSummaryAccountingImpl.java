/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.invoiceitemsummaryaccounting;

import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class IModalInvoiceItemSummaryAccountingImpl implements IModalInvoiceItemSummaryAccounting
{

	static Logger logger = Logger.getLogger(IModalInvoiceItemSummaryAccountingImpl.class);

	@Override
	public String fillAccountingGLType(WebDriver driver, String testCaseName, String accountingGLType) throws ActionBotException
	{
		int i = 0;
		String temp[] = StringUtils.split(accountingGLType, ":");
		String gl_Type = temp[1].trim();

		WebElement ele = ActionBot.findElement(driver, SELECT_GL_TYPE_INVOICE);
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

		String selectedGLType = sel.getFirstSelectedOption().getText().trim();
		logger.info("Selected GL Type : " + selectedGLType);
		return selectedGLType;
	}

	@Override
	public String fillAccountingGLAccount(WebDriver driver, String testCaseName, String accountingGLAccountCode) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_GL_ACCOUNT_INVOICE);
		if (accountingGLAccountCode != null)
		{
			/*
			 * ele.clear(); ele.sendKeys(accountingGLAccountCode);
			 * ele.sendKeys(Keys.ARROW_DOWN); ele.sendKeys(Keys.ENTER);
			 */
			ActionBot.fillAutoCompleteField(driver, ele, accountingGLAccountCode);
		}
		else
		{
			if (ele.getAttribute("value").equals(""))
			{
				ele.click();
				ele.sendKeys(Keys.ARROW_DOWN);
				ActionBot.defaultSleep();
				ele.sendKeys(Keys.RETURN);
			}
		}

		ActionBot.defaultSleep();
		String selectedGLAccount = ele.getAttribute("value");
		logger.info("Selected GL Acoount : " + selectedGLAccount);
		return selectedGLAccount;

	}

	@Override
	public String getGlAccountType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, SELECT_GL_TYPE_INVOICE);
		Select sel = new Select(ele);
		String selectedGLType = sel.getFirstSelectedOption().getText().trim();
		logger.info("Selected GL Type : " + selectedGLType);
		return selectedGLType;
	}

	@Override
	public String getGlAccount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_GL_ACCOUNT_INVOICE);
		String selectedGLAccount = ele.getAttribute("value");
		logger.info("Selected GL Acoount : " + selectedGLAccount);
		return selectedGLAccount;
	}

}
