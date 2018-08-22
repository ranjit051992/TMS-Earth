/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.closepo;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalClosePO
{
	static UI_Elements	TEXT_BOX_CLOSE_COMMENT			= UIFactory.getElements("TEXT_BOX_CLOSE_COMMENT");
	static UI_Elements	BUTTON_CLOSE_PO					= UIFactory.getElements("BUTTON_CLOSE_PO");
	static UI_Elements	BUTTON_CANCEL_CLOSE_PO			= UIFactory.getElements("BUTTON_CANCEL_CLOSE_PO");
	static UI_Elements	CHECKBOX_ALLOW_CREATING_INVOICE	= UIFactory.getElements("CHECKBOX_ALLOW_CREATING_INVOICE");
	static UI_Elements	CLOSE_PO_PROCESSING_DIV			= UIFactory.getElements("CLOSE_PO_PROCESSING_DIV");

	public String fillCloseComment(WebDriver driver, String testCaseName, String closeComment) throws ActionBotException;

	public void clickOnClosePO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelClosePO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCheckBoxAllowCreatingInvoice(WebDriver driver, String testCaseName) throws ActionBotException;
}
