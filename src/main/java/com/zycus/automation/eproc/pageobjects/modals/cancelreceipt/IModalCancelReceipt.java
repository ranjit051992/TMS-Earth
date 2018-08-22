/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.cancelreceipt;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalCancelReceipt
{
	static UI_Elements	TEXTBOX_CANCEL_RECEIPT_COMMENT	= UIFactory.getElements("TEXTBOX_CANCEL_RECEIPT_COMMENT");
	static UI_Elements	BUTTON_CANCEL_RECEIPT			= UIFactory.getElements("BUTTON_CANCEL_RECEIPT");
	static UI_Elements	BUTTON_CANCEL_RECEIPT_CLOSE		= UIFactory.getElements("BUTTON_CANCEL_RECEIPT_CLOSE");

	public String fillCancelReceiptComment(WebDriver driver, String testCaseName, String receiptComment) throws ActionBotException;

	public void clickOnCancelReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseCancelReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
