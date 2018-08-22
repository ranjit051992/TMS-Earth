package com.zycus.automation.iConsole.pageObjects.pages.apiConsole;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageApiConsoleImpl implements IPageApiConsole
{
	static Logger logger = Logger.getLogger(IPageApiConsoleImpl.class);

	@Override
	public void clickOnLinkAuthenticate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CLICK_HERE_TO_AUTHENTICATE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on link Authenticate");
	}

	@Override
	public void clickOnButtonGoAuthenticationMechanismPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_GO_AUTHENTICATION_MECHANISM_POPUP);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Button Go Authentication Mechanism");
	}

	@Override
	public void fillTextMpin(WebDriver driver, String testCaseName, String mPin) throws ActionBotException
	{
		ActionBot.clear(driver, TEXT_MPIN_AUTHENTICATION_POPUP);
		ActionBot.sendKeys(driver, TEXT_MPIN_AUTHENTICATION_POPUP, mPin);
		ScreenShot.screenshot(driver, testCaseName, "After filling mPin");
		logger.info("After filling mPin: " + mPin);
	}

	@Override
	public void clickOnButtonGoAuthenticationPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_GO_AUTHENTICATION_POPUP);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Button Go Authentication Popup");
	}

	@Override
	public boolean verifyAuthenticationSuccessMessage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String message = ActionBot.findElement(driver, LABEL_ACCESS_TOKEN_SUCCESS_MESSAGE).getText();
		if (message != null)
		{
			clickOnButtonOkSuccessMessage(driver, testCaseName);
			return true;
		}
		else
			return false;
	}

	@Override
	public void clickOnButtonOkSuccessMessage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_OK_SUCCESS_MESSAGE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Button Ok Success Message");
	}

	@Override
	public void clickOnLinkEprocHeaderMenu(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.getAttributeOfElement(driver, HEADER_EPROC_SIDE_PANEL, "aria-selected").equalsIgnoreCase("false"))
		{
			ActionBot.defaultMediumSleep();
			ActionBot.click(driver, HEADER_EPROC_SIDE_PANEL);
		}
	}

	@Override
	public boolean clickOnLinkSearchUnderEprocMenu(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_SEARCH_EPROC))
		{
			ActionBot.click(driver, LINK_SEARCH_EPROC);
			ScreenShot.screenshot(driver, testCaseName, "After clicking on link Search Eproc");
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean clickOnLinkUpdateUnderEprocMenu(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, LINK_UPDATE_EPROC);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on link update Eproc");
		return true;

	}

	@Override
	public void clickOnApiEprocApprovals(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, HEADER_API_EPROC_APPROVALS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on api header eProc-approvals");

	}

	@Override
	public boolean clickOnApiEprocRequisitonApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.scroll(driver, "1000");
		ActionBot.defaultSleep();

		ActionBot.click(driver, HEADER_API_EPROC_REQUISITIONS_REQUISITION_ID_APPROVAL);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on api header eProc-req-id-approval");
		if (ActionBot.isElementDisplayed(driver, TEXT_REQUISITON_ID_REQUISITION_APPROVAL))
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public String fillRequisitonId(WebDriver driver, String testCaseName, String reqId) throws ActionBotException
	{
		ActionBot.clear(driver, TEXT_REQUISITON_ID_REQUISITION_APPROVAL);
		ActionBot.sendKeys(driver, TEXT_REQUISITON_ID_REQUISITION_APPROVAL, reqId);
		ScreenShot.screenshot(driver, testCaseName, "After filling requisiton id");
		logger.info("After filling requisition Id: " + reqId);
		return reqId;
	}

	@Override
	public String fillRequisitionApprovalAction(WebDriver driver, String testCaseName, String reqAction) throws ActionBotException
	{
		ActionBot.clear(driver, TEXT_APPROVAL_ACTION_REQUISITION_APPROVAL);
		ActionBot.sendKeys(driver, TEXT_APPROVAL_ACTION_REQUISITION_APPROVAL, reqAction);
		ScreenShot.screenshot(driver, testCaseName, "After filling requisiton Action");
		logger.info("After filling requisition Id: " + reqAction);
		return reqAction;
	}

	@Override
	public void clickOnButtonTryItReqApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_TRY_IT_REQUISITION_APPROVAL);
		ActionBot.defaultSleep();
		ActionBot.waitForElementToBeDisplayed(driver, TAB_RESPONSE_BODY, 10);
	}

	@Override
	public void clickOnTabResponseBodyReqApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_RESPONSE_BODY);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Tab Response Body");
	}

	@Override
	public String getApiResponseBodyReqApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String response = ActionBot.findElement(driver, AREA_RESPONSE_BODY).getText();
		if (response != null)
		{
			return response;
		}
		else
			return null;
	}

	@Override
	public boolean clickOnApiEprocPOApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.scroll(driver, "1000");
		ActionBot.defaultSleep();

		ActionBot.click(driver, HEADER_API_EPROC_PO_PO_ID_APPROVAL);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on api header eProc-req-id-approval");
		if (ActionBot.isElementDisplayed(driver, TEXT_PO_ID_PO_APPROVAL))
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public String fillPurchaseOrderId(WebDriver driver, String testCaseName, String poId) throws ActionBotException
	{
		ActionBot.clear(driver, TEXT_PO_ID_PO_APPROVAL);
		ActionBot.sendKeys(driver, TEXT_PO_ID_PO_APPROVAL, poId);
		ScreenShot.screenshot(driver, testCaseName, "After filling requisiton id");
		logger.info("After filling requisition Id: " + poId);
		return poId;
	}

	@Override
	public String fillPOApprovalAction(WebDriver driver, String testCaseName, String purchaseOrderAction) throws ActionBotException
	{
		ActionBot.clear(driver, TEXT_APPROVAL_ACTION_PO_APPROVAL);
		ActionBot.sendKeys(driver, TEXT_APPROVAL_ACTION_PO_APPROVAL, purchaseOrderAction);
		ScreenShot.screenshot(driver, testCaseName, "After filling requisiton Action");
		logger.info("After filling requisition Id: " + purchaseOrderAction);
		return purchaseOrderAction;
	}

	@Override
	public void clickOnButtonTryItPOApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_TRY_IT_PO_APPROVAL);
		ActionBot.defaultSleep();
		ActionBot.waitForElementToBeDisplayed(driver, TAB_RESPONSE_BODY_PO, 10);

	}

	@Override
	public void clickOnTabResponseBodyPOApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_RESPONSE_BODY_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Tab Response Body");
	}

	@Override
	public String getApiResponseBodyPOApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String response = ActionBot.findElement(driver, AREA_RESPONSE_BODY_PO).getText();
		if (response != null)
		{
			return response;
		}
		else
			return null;
	}
}
