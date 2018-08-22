/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.approvaldocumentviewmode;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageApprovalDocumentViewModeImpl implements IPageApprovalDocumentViewMode
{
	static Logger logger = Logger.getLogger(IPageApprovalDocumentViewModeImpl.class);

	@Override
	public String fillApprovalComment(WebDriver driver, String testCaseName, String approvalComment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_APPROVAL_COMMENT_ON_DOCUMENT_VIEW_PAGE, approvalComment);
		String approval_comment = ActionBot.getTextWithInElement(driver, TEXTBOX_APPROVAL_COMMENT_ON_DOCUMENT_VIEW_PAGE);
		logger.info("Entered Approval Comment : " + approval_comment);
		return approval_comment;
	}

	@Override
	public void clickOnApproveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on approve button");
		ActionBot.click(driver, BUTTON_APPROVE_ON_DOCUMENT_VIEW_PAGE);
		ActionBot.waitTillPopUpIsPresent(driver, APPROVAL_PROCESSING_DIV_ON_DOCUMENT_VIEW_PAGE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on approve button");
	}

	@Override
	public void clickOnRejectButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on reject button");
		ActionBot.click(driver, BUTTON_REJECT_ON_DOCUMENT_VIEW_PAGE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on reject button");
	}

	@Override
	public void clickOnDelegateButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on delegate button");
		ActionBot.click(driver, BUTTON_DELEGATE_ON_DOCUMENT_VIEW_PAGE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on delegate button");

	}

	@Override
	public boolean isMandatoryCommentsErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_MANDATORY_COMMENTS))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public void clickOnAddApproverButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_ADD_APPROVER_IN_ALL_APPROVAL_PAGE);

	}

	@Override
	public String getWorkflowActorName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='workFlowTrails']//li[" + index + "]//div[contains(@class,'dev_nodeDisplayName')]"));
	}

	@Override
	public boolean checkAddedApproverByName(WebDriver driver, String testCaseName, String approverName) throws ActionBotException
	{
		boolean flag = false;
		List<String> approverList = ActionBot.getListOfText(driver, WORKFLOW_APPROVER_LIST);
		for (String approver : approverList)
		{
			flag = approver.equalsIgnoreCase(approverName);
			if (flag)
				return flag;
		}
		return flag;
	}

	@Override
	public String fillDelegateToName(WebDriver driver, String testCaseName, String delegateTo) throws ActionBotException
	{
		return ActionBot.fillAutoCompleteField(driver, DELEGATE_APPROVAL_TO, delegateTo);
	}

	@Override
	public void clickDelegateButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, DELEGATE_BUTTON))
		{
			ActionBot.click(driver, DELEGATE_BUTTON);
		}

	}

	@Override
	public void clickOnChangeApproverLinkByName(WebDriver driver, String testCaseName, String approverName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver,
			By.xpath(".//*[contains(@id,'dev_workflowTrail')]//*[contains(text(),'" + approverName + "')]/../..//*[contains(@class,'changeApproverLnk')]")))
		{
			ActionBot.click(driver, By.xpath(".//*[contains(@id,'dev_workflowTrail')]//*[contains(text(),'" + approverName + "')]/../..//*[contains(@class,'changeApproverLnk')]"));
			ActionBot.waitForPageLoad(driver);
		}
	}

	@Override
	public void clickOnRemoveApproverLinkByName(WebDriver driver, String testCaseName, String approverName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver,
			By.xpath(".//*[contains(@id,'dev_workflowTrail')]//*[contains(text(),'" + approverName + "')]/../..//*[contains(@class,'removeApproverLnk')]")))
		{
			ActionBot.click(driver, By.xpath(".//*[contains(@id,'dev_workflowTrail')]//*[contains(text(),'" + approverName + "')]/../..//*[contains(@class,'removeApproverLnk')]"));
			ActionBot.waitForPageLoad(driver);
		}

	}

}
