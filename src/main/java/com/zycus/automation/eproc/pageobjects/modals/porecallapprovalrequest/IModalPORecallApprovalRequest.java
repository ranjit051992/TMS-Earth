package com.zycus.automation.eproc.pageobjects.modals.porecallapprovalrequest;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalPORecallApprovalRequest
{
	static UI_Elements	TEXTBOX_RECALL_COMMENTS_PO	= UIFactory.getElements("TEXTBOX_RECALL_COMMENTS_PO");
	static UI_Elements	BUTTON_RECALL_PO			= UIFactory.getElements("BUTTON_RECALL_PO");
	static UI_Elements	BUTTON_CANCEL_PO			= UIFactory.getElements("BUTTON_CANCEL_PO");

	public String fillRecallComments(WebDriver driver, String testCaseName, String recallComment) throws ActionBotException;

	public void clickOnRecallButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

}
