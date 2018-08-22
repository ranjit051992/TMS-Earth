/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentreject;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalAllRequestsApprovalDocumentReject
{
	final static UI_Elements	REJECT_COMMENTS				= UIFactory.getElements("REJECT_COMMENTS");
	final static UI_Elements	REJECT_BUTTON				= UIFactory.getElements("REJECT_BUTTON");
	final static UI_Elements	REJECT_CLOSE_BUTTON			= UIFactory.getElements("REJECT_CLOSE_BUTTON");
	final static UI_Elements	LINK_REJECT_MULTIPLE_ITEMS	= UIFactory.getElements("LINK_REJECT_MULTIPLE_ITEMS");

	public String fillRejectComment(WebDriver driver, String testCaseName, String rejectComment) throws ActionBotException;

	public String getRejectComment(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRejectButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean rejectMultipleItems(WebDriver driver, String testCaseName) throws ActionBotException;

}
