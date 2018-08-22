package com.zycus.automation.eproc.pageobjects.pages.settings.workflowsettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.settings.buyersdesksettings.IPageBuyersDeskSettingsImpl;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageWorkflowSettingsImpl implements IPageWorkflowSettings
{

	@Override
	public void clickOnAutoApproveDocumentWhenApprovalIsRoutedToWorkflowYES(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AUTO_APPROVE_DOCUMENT_WHEN_APPROVAL_IS_ROUTED_TO_WORKFLOW_ADMIN_YES);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on yes button of auto approval workflow");

	}

	@Override
	public void clickOnAutoApproveDocumentWhenApprovalIsRoutedToWorkflowNO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AUTO_APPROVE_DOCUMENT_WHEN_APPROVAL_IS_ROUTED_TO_WORKFLOW_ADMIN_NO);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on no button of auto approval workflow");
	}

	@Override
	public boolean clickOnSaveWorkflowSettings(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, WORKFLOW_SETTINGS_SAVE_BUTTON);
		ActionBot.waitForElementToBeDisplayed(driver,  IPageBuyersDeskSettingsImpl.BUYERS_DESK_SETTING_SUCCESS_MSG, ActionBot.timeOut);
		if (ActionBot.isElementPresent(driver, IPageBuyersDeskSettingsImpl.BUYERS_DESK_SETTING_SUCCESS_MSG))
		{
			ActionBot.defaultSleep();
			ScreenShot.screenshot(driver, testCaseName, "After clicking on save workflow settings");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, "After clicking on save workflow settings");
			return false;
		}

	}

	@Override
	public boolean clickOnReplacingAnApproverWithNonOverlappingScopeBLOCK(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REPLACING_AN_APPROVER_WITH_NON_OVERLAPPING_SCOPE_BLOCK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on BLOCK non overlapping scope approvers");
		return ActionBot.isElementSelected(driver, REPLACING_AN_APPROVER_WITH_NON_OVERLAPPING_SCOPE_BLOCK);

	}

	@Override
	public boolean clickOnReplacingAnApproverWithNonOverLappingScopeDISPLAY_WARNING(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REPLACING_AN_APPROVER_WITH_NON_OVERLAPPING_SCOPE_DISPLAY_WARNING);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on DISPLAY_WARNING non overlapping scope approvers");
		return ActionBot.isElementSelected(driver, REPLACING_AN_APPROVER_WITH_NON_OVERLAPPING_SCOPE_DISPLAY_WARNING);

	}

	@Override
	public boolean clickOnReplacingAnApproverWithHigherApprovalLimitThanNewApprover_WARNING(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REPLACING_AN_APPROVER_WITH_HIGHER_APPROVAL_LIMIT_THAN_NEW_APPROVER_WARNING);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on DISPLAY_WARNING replacing an approver with higher approval limit");
		return ActionBot.isElementSelected(driver, REPLACING_AN_APPROVER_WITH_HIGHER_APPROVAL_LIMIT_THAN_NEW_APPROVER_WARNING);
	}

	@Override
	public boolean clickOnReplacingAnApproverWithHigherApprovalLimitThanNewApprover_BLOCK(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REPLACING_AN_APPROVER_WITH_HIGHER_APPROVAL_LIMIT_THAN_NEW_APPROVER_BLOCK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on BLOCK replacing an approver with higher approval limit");
		return ActionBot.isElementSelected(driver, REPLACING_AN_APPROVER_WITH_HIGHER_APPROVAL_LIMIT_THAN_NEW_APPROVER_BLOCK);
	}

	@Override
	public boolean clickOnReplacingAnApproverWithDifferentDesignation_WARNING(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REPLACING_AN_APPROVER_WITH_DIFFERENT_DESIGNATION_WARNING);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on DISPLAY_WARNING replacing an approver with different designation");
		return ActionBot.isElementSelected(driver, REPLACING_AN_APPROVER_WITH_DIFFERENT_DESIGNATION_WARNING);
	}

	@Override
	public boolean clickOnReplacingAnApproverWithDifferentDesignation_BLOCK(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REPLACING_AN_APPROVER_WITH_DIFFERENT_DESIGNATION_BLOCK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on BLOCK replacing an approver with different designation");
		return ActionBot.isElementSelected(driver, REPLACING_AN_APPROVER_WITH_DIFFERENT_DESIGNATION_BLOCK);
	}

	@Override
	public boolean clickOnReplacingAnApproverWithHigherDesignationThanNewApprover_WARNING(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REPLACING_AN_APPROVER_WITH_HIGHER_DESIGNATION_THAN_NEW_APPROVER_WARNING);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on DISPLAY_WARNING replacing an approver with higher designation than new approver");
		return ActionBot.isElementSelected(driver, REPLACING_AN_APPROVER_WITH_HIGHER_DESIGNATION_THAN_NEW_APPROVER_WARNING);
	}

	@Override
	public boolean clickOnReplacingAnApproverWithHigherDesignationThanNewApprover_BLOCK(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REPLACING_AN_APPROVER_WITH_HIGHER_DESIGNATION_THAN_NEW_APPROVER_BLOCK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on BLOCK  replacing an approver with higher designation than new approver");
		return ActionBot.isElementSelected(driver, REPLACING_AN_APPROVER_WITH_HIGHER_DESIGNATION_THAN_NEW_APPROVER_BLOCK);
	}

}
