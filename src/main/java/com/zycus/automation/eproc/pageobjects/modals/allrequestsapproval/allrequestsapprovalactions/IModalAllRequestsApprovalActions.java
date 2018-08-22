/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsapprovalactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalAllRequestsApprovalActions
{

	final static UI_Elements	ACTIONS_VIEW_OPTION						= UIFactory.getElements("ACTIONS_VIEW_OPTION");
	final static UI_Elements	ACTIONS_APPROVE_OPTION					= UIFactory.getElements("ACTIONS_APPROVE_OPTION");
	final static UI_Elements	ACTIONS_REJECT_OPTION					= UIFactory.getElements("ACTIONS_REJECT_OPTION");
	final static UI_Elements	ACTIONS_DELEGATE_OPTION					= UIFactory.getElements("ACTIONS_DELEGATE_OPTION");
	final static UI_Elements	ACTIONS_MORE_INFO_OPTION				= UIFactory.getElements("ACTIONS_MORE_INFO_OPTION");
	static UI_Elements			LINK_APPROVE_ACTION_FOR_MULTIPLE_DOC	= UIFactory.getElements("LINK_APPROVE_ACTION_FOR_MULTIPLE_DOC");
	static UI_Elements			LINK_REJECT_ACTION_FOR_MULTIPLE_DOC		= UIFactory.getElements("LINK_REJECT_ACTION_FOR_MULTIPLE_DOC");
	static UI_Elements			LINK_DELEGATE_ACTION_FOR_MULTIPLE_DOC	= UIFactory.getElements("LINK_DELEGATE_ACTION_FOR_MULTIPLE_DOC");

	public void clickOnViewOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApproveOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRejectOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDelegateOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnMoreInfoOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApproveOptionForMultipleDoc(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRejectOptionForMultipleDoc(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDelegateOptionForMultipleDoc(WebDriver driver, String testCaseName) throws ActionBotException;

}
