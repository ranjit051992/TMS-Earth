/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.mysettings;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageMySettingsImpl implements IPageMySettings
{
	static Logger logger = Logger.getLogger(IPageMySettingsImpl.class);

	@Override
	public String fillDelegateApprovalFrom(WebDriver driver, String testCaseName, String delegateFromUserName) throws ActionBotException
	{
		String delegateFrom = ActionBot.fillAutoCompleteField(driver, TEXTBOX_DELEGATE_FROM, delegateFromUserName);
		logger.info("Entered Delegate From : " + delegateFrom);
		return delegateFrom;
	}

	@Override
	public String fillDelegateApprovalTo(WebDriver driver, String testCaseName, String delegateToUserName) throws ActionBotException
	{
		String delegateTo = ActionBot.fillAutoCompleteField(driver, TEXTBOX_DELEGATE_TO, delegateToUserName);
		logger.info("Entered Delegate To : " + delegateTo);
		return delegateTo;
	}

	@Override
	public String getFromDelegateDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String delegateFromDate = ActionBot.getAttributeOfElement(driver, TEXTBOX_DELEGATE_FROM_DATE, "value");
		logger.info("Delegate From Date : " + delegateFromDate);
		return delegateFromDate;
	}

	@Override
	public String getToDelegateDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String delegateToDate = ActionBot.getAttributeOfElement(driver, TEXTBOX_DELEGATE_TO_DATE, "value");
		logger.info("Delegate To Date : " + delegateToDate);
		return delegateToDate;
	}

	@Override
	public void clickOnEnableButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Enable Button");
		ActionBot.click(driver, BUTTON_ENABLE_DELEGATION);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Enable Button");
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel Button");
		ActionBot.click(driver, BUTTON_CANCEL_DELEGATION);
	}

	@Override
	public String fillRevokeDelegateApprovalFrom(WebDriver driver, String testCaseName, String delegateFromUserName) throws ActionBotException
	{
		String revokeFrom = ActionBot.fillAutoCompleteField(driver, TEXTBOX_DELEGATE_FROM, delegateFromUserName);
		logger.info("Entered Revoke To : " + revokeFrom);
		return revokeFrom;
	}

	@Override
	public void clickOnRevokeButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Revoke Button");
		ActionBot.click(driver, BUTTON_REVOKE_DELEGATE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Revoke Button");
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
	}

}
