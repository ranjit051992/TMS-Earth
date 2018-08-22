/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingreturnreq;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalBuyersDeskReturnRequisitionImpl implements IModalBuyersDeskReturnRequisition
{
	static Logger logger = Logger.getLogger(IModalBuyersDeskReturnRequisitionImpl.class);

	@Override
	public String fillReturnRequisitionComment(WebDriver driver, String testCaseName, String returnComment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_BOX_RETURN_COMMENT, returnComment);
		String comment = ActionBot.getTextWithInElement(driver, TEXT_BOX_RETURN_COMMENT);
		logger.info("Return Comment : " + comment);
		ScreenShot.screenshot(driver, testCaseName, "After filling return comment");
		return comment;
	}

	@Override
	public void clickOnReqResubmit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_CAN_RESUBMIT);
	}

	@Override
	public void clickOnReturnReqButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_RETURN_REQUISITION);
		ActionBot.waitTillPopUpIsPresent(driver, RETURN_REQUISITION_PROCESSING_DIV);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on return button");
	}

	@Override
	public void clickOnCancelReqButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_REQUISITION);
	}

	@Override
	public void clickOnReturnReqFromBuyersDesk(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_RETURN_REQ_FROM_MODAL_BUYERS_DESK);

	}

	@Override
	public boolean isReturnReqComentPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TEXT_BOX_RETURN_COMMENT))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
