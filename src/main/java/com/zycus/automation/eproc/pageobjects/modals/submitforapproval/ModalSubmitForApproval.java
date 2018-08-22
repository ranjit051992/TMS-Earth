/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.submitforapproval;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public class ModalSubmitForApproval
{
	public static UI_Elements	BUTTON_APPROVAL_SUBMIT_SUBMIT_FOR_APPROVAL_MODAL			= UIFactory.getElements("BUTTON_APPROVAL_SUBMIT_SUBMIT_FOR_APPROVAL_MODAL");
	public static UI_Elements	BUTTON_APPROVAL_CANCEL_SUBMIT_FOR_APPROVAL_MODAL			= UIFactory.getElements("BUTTON_APPROVAL_CANCEL_SUBMIT_FOR_APPROVAL_MODAL");
	public static UI_Elements	CHECKBOX_MODIFY_WORFLOW_SETTING_SUBMIT_FOR_APPROVAL_MODAL	= UIFactory.getElements("CHECKBOX_MODIFY_WORFLOW_SETTING_SUBMIT_FOR_APPROVAL_MODAL");
	public static UI_Elements	WORKFLOW_FOR_APPROVAL_LIST_ITEMS							= UIFactory.getElements("WORKFLOW_FOR_APPROVAL_LIST_ITEMS");

	public static void clickOnSubmitForApprovalButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on submit for approval");
		ActionBot.click(driver, BUTTON_APPROVAL_SUBMIT_SUBMIT_FOR_APPROVAL_MODAL);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on submit for approval");
	}

	public static void clickOnCancelSubmitForApprovalButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_APPROVAL_CANCEL_SUBMIT_FOR_APPROVAL_MODAL);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel submit for approval");
	}

	public static void clickOnModifyWorkflowSettingCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_MODIFY_WORFLOW_SETTING_SUBMIT_FOR_APPROVAL_MODAL);
	}

	public static boolean isSubmitForApprovalButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_APPROVAL_SUBMIT_SUBMIT_FOR_APPROVAL_MODAL);
	}

	public static boolean isWorkflowForApprovalPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, WORKFLOW_FOR_APPROVAL_LIST_ITEMS);
		if (elements.get(0) != null)
		{
			return true;
		}
		return false;
	}
}
