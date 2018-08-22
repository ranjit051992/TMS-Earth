/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentdelegate;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalAllRequestsApprovalDocumentDelegate
{
	final static UI_Elements	DELEGATE_APPROVAL_TO_NAME		= UIFactory.getElements("DELEGATE_APPROVAL_TO_NAME");
	final static UI_Elements	DELEGATE_COMMENTS				= UIFactory.getElements("DELEGATE_COMMENTS");
	final static UI_Elements	DELEAGTE_SAVE_BUTTON			= UIFactory.getElements("DELEAGTE_SAVE_BUTTON");
	final static UI_Elements	DELEGATE_CANCEL_BUTTON			= UIFactory.getElements("DELEGATE_CANCEL_BUTTON");
	final static UI_Elements	LINK_DELEGATE_MULTIPLE_ITEMS	= UIFactory.getElements("LINK_DELEGATE_MULTIPLE_ITEMS");

	public String fillDelegateComments(WebDriver driver, String testCaseName, String delegateComment) throws ActionBotException;

	public String getDelegateComments(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillDelegateToName(WebDriver driver, String testCaseName, String delegateTo) throws ActionBotException;

	public String getDelegateToName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDelegateSaveButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDelegateCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean delegateMultipleItems(WebDriver driver, String testCaseName) throws ActionBotException;
}
