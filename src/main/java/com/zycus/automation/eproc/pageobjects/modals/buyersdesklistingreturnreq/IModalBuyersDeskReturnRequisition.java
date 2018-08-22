/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingreturnreq;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalBuyersDeskReturnRequisition
{
	static UI_Elements	TEXT_BOX_RETURN_COMMENT						= UIFactory.getElements("TEXT_BOX_RETURN_COMMENT");
	static UI_Elements	CHECKBOX_CAN_RESUBMIT						= UIFactory.getElements("CHECKBOX_CAN_RESUBMIT");
	static UI_Elements	BUTTON_RETURN_REQUISITION					= UIFactory.getElements("BUTTON_RETURN_REQUISITION");
	static UI_Elements	BUTTON_CANCEL_REQUISITION					= UIFactory.getElements("BUTTON_CANCEL_REQUISITION");
	static UI_Elements	RETURN_REQUISITION_PROCESSING_DIV			= UIFactory.getElements("RETURN_REQUISITION_PROCESSING_DIV");
	static UI_Elements	BUTTON_RETURN_REQ_FROM_MODAL_BUYERS_DESK	= UIFactory.getElements("BUTTON_RETURN_REQ_FROM_MODAL_BUYERS_DESK");

	public String fillReturnRequisitionComment(WebDriver driver, String testCaseName, String returnComment) throws ActionBotException;

	public void clickOnReqResubmit(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReturnReqButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelReqButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReturnReqFromBuyersDesk(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isReturnReqComentPresent(WebDriver driver, String testCaseName) throws ActionBotException;
}
