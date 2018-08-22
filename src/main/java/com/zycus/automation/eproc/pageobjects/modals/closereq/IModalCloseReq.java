/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.closereq;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalCloseReq
{
	static UI_Elements	TEXTBOX_CLOSE_COMMENT		= UIFactory.getElements("TEXTBOX_CLOSE_COMMENT");
	static UI_Elements	BUTTON_CLOSE_REQUISITION	= UIFactory.getElements("BUTTON_CLOSE_REQUISITION");
	static UI_Elements	BUTTON_CANCEL_CLOSE_BOX		= UIFactory.getElements("BUTTON_CANCEL_CLOSE_BOX");
	UI_Elements			PROGRESSING_DIV_CLOSING_REQ	= UIFactory.getElements("PROGRESSING_DIV_CLOSING_REQ");

	public String fillCloseComment(WebDriver driver, String testCaseName, String closeComment) throws ActionBotException;

	public void clickOnCloseReqButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelCloseReqButton(WebDriver driver, String testCaseName) throws ActionBotException;

}
