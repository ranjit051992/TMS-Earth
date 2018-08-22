/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.approvalworkflowcustomizesetting;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public class PageApprovalWorkflowCustomizeSetting
{
	static Logger				logger							= Logger.getLogger(PageApprovalWorkflowCustomizeSetting.class);
	public static UI_Elements	LINK_REQUEST_SUBMITTED			= UIFactory.getElements("LINK_REQUEST_SUBMITTED");
	public static UI_Elements	LINK_AWAITING_APPROVAL			= UIFactory.getElements("LINK_AWAITING_APPROVAL");
	public static UI_Elements	LINK_REQUEST_APPROVED			= UIFactory.getElements("LINK_REQUEST_APPROVED");
	public static UI_Elements	LINK_REQUEST_REJECTED			= UIFactory.getElements("LINK_REQUEST_REJECTED");
	public static UI_Elements	LINK_REQUEST_DELEGATED			= UIFactory.getElements("LINK_REQUEST_DELEGATED");
	public static UI_Elements	LINK_REQUEST_RETURNED			= UIFactory.getElements("LINK_REQUEST_RETURNED");
	public static UI_Elements	LINK_REQUEST_RECALLED			= UIFactory.getElements("LINK_REQUEST_RECALLED");
	public static UI_Elements	LINK_REQUEST_CANCELLED			= UIFactory.getElements("LINK_REQUEST_CANCELLED");
	public static UI_Elements	LINK_OBSERVER_ADDED				= UIFactory.getElements("LINK_OBSERVER_ADDED");
	public static UI_Elements	LINK_APPROVER_REPLACED_OLD		= UIFactory.getElements("LINK_APPROVER_REPLACED_OLD");
	public static UI_Elements	LINK_APPROVER_REPLACED_NEW		= UIFactory.getElements("LINK_APPROVER_REPLACED_NEW");
	public static UI_Elements	LINK_APPROVER_ADDED				= UIFactory.getElements("LINK_APPROVER_ADDED");
	public static UI_Elements	LINK_APPROVER_REMOVED			= UIFactory.getElements("LINK_APPROVER_REMOVED");
	public static UI_Elements	TEXTBOX_EMAIL_SUBJECT_TEMPLATE	= UIFactory.getElements("TEXTBOX_EMAIL_SUBJECT_TEMPLATE");
	public static UI_Elements	TEXTBOX_EMAIL_BODY_TEMPLATE		= UIFactory.getElements("TEXTBOX_EMAIL_BODY_TEMPLATE");
	public static UI_Elements	BUTTON_SAVE_EMAIL_TEMPLATE		= UIFactory.getElements("BUTTON_SAVE_EMAIL_TEMPLATE");
	public static UI_Elements	BUTTON_CANCEL_EMAIL_TEMPLATE	= UIFactory.getElements("BUTTON_CANCEL_EMAIL_TEMPLATE");

	public static void clickOnRequestSubmittedLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REQUEST_SUBMITTED);
		ScreenShot.screenshot(driver, testCaseName, "Request Submitted");
	}

	public static void clickOnAwaitingApprovalLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_AWAITING_APPROVAL);
		ScreenShot.screenshot(driver, testCaseName, "Awaiting Approval");
	}

	public static void clickOnRequestApprovedLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REQUEST_APPROVED);
		ScreenShot.screenshot(driver, testCaseName, "Request Approved");
	}

	public static void clickOnRequestRejectedLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REQUEST_REJECTED);
		ScreenShot.screenshot(driver, testCaseName, "Reques Rejected");
	}

	public static void clickOnRequestDelegatedLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REQUEST_DELEGATED);
		ScreenShot.screenshot(driver, testCaseName, "Request Delegated");
	}

	public static void clickOnRequestReturnedLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REQUEST_RETURNED);
		ScreenShot.screenshot(driver, testCaseName, "Request Returned");
	}

	public static void clickOnRequestRecalledLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REQUEST_RECALLED);
		ScreenShot.screenshot(driver, testCaseName, "Request Recalled");
	}

	public static void clickOnRequestCancelledLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REQUEST_CANCELLED);
		ScreenShot.screenshot(driver, testCaseName, "Request Cancelled");
	}

	public static void clickOnObserverAddedLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_OBSERVER_ADDED);
		ScreenShot.screenshot(driver, testCaseName, "Observer Added");
	}

	public static void clickOnApproverReplacedOldLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_APPROVER_REPLACED_OLD);
		ScreenShot.screenshot(driver, testCaseName, "Approver Replace Old");
	}

	public static void clickOnApproverReplacedNewLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_APPROVER_REPLACED_NEW);
		ScreenShot.screenshot(driver, testCaseName, "Approver Replace New");
	}

	public static void clickOnApproverAddedLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_APPROVER_ADDED);
		ScreenShot.screenshot(driver, testCaseName, "Approver Added");
	}

	public static void clickOnApproverRemovedLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_APPROVER_REMOVED);
		ScreenShot.screenshot(driver, testCaseName, "Approver Removed");
	}

	public static String getSubject(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String subject = ActionBot.getAttributeOfElement(driver, TEXTBOX_EMAIL_SUBJECT_TEMPLATE, "value");
		logger.info("Subject : " + subject);
		return subject;
	}

	public static String getBody(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String body = ActionBot.getAttributeOfElement(driver, TEXTBOX_EMAIL_BODY_TEMPLATE, "value");
		logger.info("Body : " + body);
		return body;
	}

	public static void clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_EMAIL_TEMPLATE);
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_EMAIL_TEMPLATE);
	}
}
