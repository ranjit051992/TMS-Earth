/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.invoicesubmitforapproval;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPopUpInvoiceSubmitForApproval
{
	static UI_Elements	BUTTON_SEND_FOR_CONFIRMATION	= UIFactory.getElements("BUTTON_SEND_FOR_CONFIRMATION");
	static UI_Elements	BUTTON_CANCEL_AND_EDIT			= UIFactory.getElements("BUTTON_CANCEL_AND_EDIT");

	public void clickOnSendForComfirmation(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelAndEdit(WebDriver driver, String testCaseName) throws ActionBotException;
}
