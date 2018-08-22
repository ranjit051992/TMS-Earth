/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.othernotification;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class IPageOtherNotificationSettingImpl implements IPageOtherNotificationSetting
{
	static Logger logger = Logger.getLogger(IPageOtherNotificationSettingImpl.class);

	@Override
	public void clickOnBuyersDeskInfoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_BUYERS_DESK_INFO);
	}

	@Override
	public void clickOnPOReleasedInfoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PO_RELEASED_INFO);
	}

	@Override
	public String getSubjectTemplate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String subjectTemplate = ActionBot.getAttributeOfElement(driver, TEXTBOX_SUBJECT_TEMPLATE, "value");
		logger.info("Subject Template : " + subjectTemplate);
		return subjectTemplate;
	}

	@Override
	public String getBodyTemplate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String bodyTemplate = ActionBot.getTextWithInElement(driver, TEXTBOX_BODY_TEMPLATE);
		logger.info("Body Template : " + bodyTemplate);
		return bodyTemplate;
	}
}
