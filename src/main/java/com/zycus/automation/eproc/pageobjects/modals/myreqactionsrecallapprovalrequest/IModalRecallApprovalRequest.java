/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.myreqactionsrecallapprovalrequest;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalRecallApprovalRequest
{

	static UI_Elements	TEXTBOX_RECALL_REQ_COMMENT		= UIFactory.getElements("TEXTBOX_RECALL_REQ_COMMENT");
	static UI_Elements	BUTTON_RECALL					= UIFactory.getElements("BUTTON_RECALL");
	static UI_Elements	BUTTON_CANCEL					= UIFactory.getElements("BUTTON_CANCEL");
	static UI_Elements	SAVING_COMMENT_PROCESSING_DIV	= UIFactory.getElements("SAVING_COMMENT_PROCESSING_DIV");

	public String fillRecallComment(WebDriver driver, String testCaseName, String recallComment) throws ActionBotException;

	public void clickOnRecallButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void waitTillSaveCommentProcessingDivPresent(WebDriver driver, String testCaseName) throws ActionBotException;
}
