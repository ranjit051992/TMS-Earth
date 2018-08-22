/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.additemfromreq;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
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
public class ModalAddItemFromRequisition
{
	static Logger		logger												= Logger.getLogger(ModalAddItemFromRequisition.class);

	static UI_Elements	TAB_PENDING_REQUISITIONS_IN_REQUISITION_ITEMS_MODAL	= UIFactory.getElements("TAB_PENDING_REQUISITIONS_IN_REQUISITION_ITEMS_MODAL");
	static UI_Elements	TEXTBOX_SEARCH_REQ_NO_REQUISITION_ITEMS				= UIFactory.getElements("TEXTBOX_SEARCH_REQ_NO_REQUISITION_ITEMS");
	static UI_Elements	TEXTBOX_SEARCH_ITEM_NAME_REQUISITION_ITEMS			= UIFactory.getElements("TEXTBOX_SEARCH_ITEM_NAME_REQUISITION_ITEMS");
	static UI_Elements	TEXTBOX_SEARCH_REQUESTER_REQUISITION_ITEMS			= UIFactory.getElements("TEXTBOX_SEARCH_REQUESTER_REQUISITION_ITEMS");
	static UI_Elements	TEXTBOX_SEARCH_SUPPLIER_NAME_REQUISITION_ITEMS		= UIFactory.getElements("TEXTBOX_SEARCH_SUPPLIER_NAME_REQUISITION_ITEMS");
	static UI_Elements	CHECKBOX_SELECT_REQUISITION_IN_REQUISITION_ITEMS	= UIFactory.getElements("CHECKBOX_SELECT_REQUISITION_IN_REQUISITION_ITEMS");
	static UI_Elements	BUTTON_SELECT_REQ_ITEM								= UIFactory.getElements("BUTTON_SELECT_REQ_ITEM");
	static UI_Elements	BUTTON_CLOSE_REQ_ITEM								= UIFactory.getElements("BUTTON_CLOSE_REQ_ITEM");
	static UI_Elements	LABEL_ERROR_MISMATCH_SETTLEMENT_VIA_IN_REQ_ITEMS	= UIFactory.getElements("LABEL_ERROR_MISMATCH_SETTLEMENT_VIA_IN_REQ_ITEMS");

	public static void clickOnPendingRequisitionTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_PENDING_REQUISITIONS_IN_REQUISITION_ITEMS_MODAL);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Pending Requisition Tab");
	}

	public static String fillReqNo(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_SEARCH_REQ_NO_REQUISITION_ITEMS);
		element.clear();
		element.sendKeys(reqNo);
		element.sendKeys(Keys.RETURN);

		String req_no = element.getAttribute("value");
		logger.info("Entered Req No : " + req_no);
		return req_no;
	}

	public static void clickOnFirstRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_REQUISITION_IN_REQUISITION_ITEMS);
	}

	public static void clickOnSelectReqItemButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Select Req Item Button");
		ActionBot.click(driver, BUTTON_SELECT_REQ_ITEM);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Select Req Item Button");
	}

	public static void clickOnCloseReqItemButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Close Req Item Button");
		ActionBot.click(driver, BUTTON_CLOSE_REQ_ITEM);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Close Req Item Button");
	}

	public static String getMisMatchSettlementViaErrorMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String errorMsg = ActionBot.getTextWithInElement(driver, LABEL_ERROR_MISMATCH_SETTLEMENT_VIA_IN_REQ_ITEMS);
		logger.info("Mismatch Settlement via error message : " + errorMsg);
		return errorMsg;
	}
}
