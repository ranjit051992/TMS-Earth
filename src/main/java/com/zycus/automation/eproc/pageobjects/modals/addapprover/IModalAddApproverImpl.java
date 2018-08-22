/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.addapprover;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalAddApproverImpl implements IModalAddApprover
{
	static Logger logger = Logger.getLogger(IModalAddApproverImpl.class);

	@Override
	public String fillApproverName(WebDriver driver, String testCaseName, String approverName) throws ActionBotException
	{
		String addedApproverName = null;
		addedApproverName = ActionBot.fillAutoCompleteField(driver, INPUT_APPROVER_NAME, approverName);
		logger.info("Added Approver Name : " + addedApproverName);
		return addedApproverName;
	}

	@Override
	public String selectRequireApprovalAfter(WebDriver driver, String testCaseName, int optionIndex) throws ActionBotException
	{
		String selectedOption = ActionBot.selectElement(driver, SELECT_REQUIRE_APPROVAL_AFTER, IConstantsData.SELECT_BY_INDEX, Integer.toString(optionIndex));
		logger.info("Add approver after " + selectedOption);
		return selectedOption;
	}

	@Override
	public String getAddedApproverName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String addedApproverName = ActionBot.getTextWithInElement(driver, LABEL_ADDED_APPROVER_NAME);
		logger.info("Added Approver Name as On workflow : " + addedApproverName);
		return addedApproverName;
	}

	@Override
	public String getAddedApproverExtraInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String addedApproverInfo = ActionBot.getTextWithInElement(driver, LABEL_ADDED_APPROVER_EXTRA_INFO);
		logger.info("Added Approver extra information as On workflow : " + addedApproverInfo);
		return addedApproverInfo;
	}

	@Override
	public void clickOnSaveAddApprover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on add approver save button");
		ActionBot.click(driver, BUTTON_SAVE_ADDED_APPROVER);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add approver save button");
	}

	@Override
	public void clickOnCancelAddApprover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on add approver cancel button");
		ActionBot.click(driver, BUTTON_CANCEL_ADDED_APPROVER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add approver cancel button");
	}

	@Override
	public boolean isSelectNodesNamesErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_SELECT_NODES_NAME_IN_WORKFLOW))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isDuplicateWorkflowActorNameErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_DUPLICATE_ADD_APPROVER_IN_WORKFLOW))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getAddedApproverName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String approverName = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@class='dev_predictedWorkflowContainer']//li[" + index + "]//div[contains(@class,'dev_nodeDisplayName')]"));
		logger.info("Added Approver Name : " + approverName);
		return approverName;
	}

	@Override
	public String getAddedApproverExtraInfo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String approverInfo = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@class='dev_predictedWorkflowContainer']//li[" + index + "]//div[contains(@class,'dev_extraInfo ellipsis')]"));
		logger.info("Added Approver Info : " + approverInfo);
		return approverInfo;
	}

	@Override
	public String selectRequireApprovalAfter(WebDriver driver, String testCaseName, String option) throws ActionBotException
	{
		String selectedOption = ActionBot.selectElement(driver, SELECT_REQUIRE_APPROVAL_AFTER, IConstantsData.SELECT_BY_PARTIAL_VISIBLE_TEXT, option);
		logger.info("Add approver after " + selectedOption);
		return selectedOption;
	}

}
