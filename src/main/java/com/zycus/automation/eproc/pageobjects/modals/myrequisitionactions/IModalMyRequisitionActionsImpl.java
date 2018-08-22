package com.zycus.automation.eproc.pageobjects.modals.myrequisitionactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalMyRequisitionActionsImpl extends IModalMyRequisitionActionsutil implements IModalMyRequisitionActions
{

	@Override
	public void clickOnEditLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, EDIT_LINK);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testcaseName, "After clicking on edit link");
	}

	@Override
	public void clickOnDeleteLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, DELETE_LINK);

	}

	@Override
	public void clickOnRecallApproveRequestLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, RECALL_APPROVE_REQUEST_LINK);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testcaseName, "After clicking on recall approval request link");
	}

	@Override
	public void clickOnRemindApproverLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, REMIND_APPROVER_LINK);

	}

	@Override
	public void clickOnCopyLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, COPY_LINK);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testcaseName, "After clicking on copy request link");
	}

	@Override
	public void clickOnCancelLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_LINK);

	}

	@Override
	public void clickOnCreateReceiptLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CREATE_RECEIPT_LINK);

	}

	@Override
	public void clickOnCloseLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CLOSE_REQ);
	}

	@Override
	public boolean isCloseLinkPresent(WebDriver driver, String testcaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_CLOSE_REQ))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void performRecallActions(WebDriver driver, String testcaseName, String recallActions) throws ActionBotException
	{

		if (ActionBot.isElementDisplayed(driver, TEXTBOX_RECALL_COMMENTS_MY_REQ))
		{
			ActionBot.sendKeys(driver, TEXTBOX_RECALL_COMMENTS_MY_REQ, IConstantsData.RECALL_COMMENT);

			if (recallActions.equalsIgnoreCase(IConstantsData.RECALL))
			{
				ActionBot.click(driver, BUTTON_RECALL_MY_REQUISITION);
				ActionBot.waitForPageLoad(driver);
				ActionBot.waitTillPopUpIsPresent(driver, POPUP_RECALLING);
				ActionBot.defaultSleep();
				ScreenShot.screenshot(driver, testcaseName, "After clicking button recall");

				ActionBot.refreshPage(driver, testcaseName);

				ActionBot.waitForPageLoad(driver);

			}

			else

			if (recallActions.equalsIgnoreCase(IConstantsData.CANCEL))
			{
				ActionBot.click(driver, LINK_CANCEL_RECALL);
				ScreenShot.screenshot(driver, testcaseName, "After clicking link cancel");
			}
		}
	}
}
