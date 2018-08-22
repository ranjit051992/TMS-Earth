/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.addapprover;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalAddApprover
{
	static UI_Elements	INPUT_APPROVER_NAME							= UIFactory.getElements("INPUT_APPROVER_NAME");
	static UI_Elements	SELECT_REQUIRE_APPROVAL_AFTER				= UIFactory.getElements("SELECT_REQUIRE_APPROVAL_AFTER");
	static UI_Elements	LABEL_ADDED_APPROVER_NAME					= UIFactory.getElements("LABEL_ADDED_APPROVER_NAME");
	static UI_Elements	LABEL_ADDED_APPROVER_EXTRA_INFO				= UIFactory.getElements("LABEL_ADDED_APPROVER_EXTRA_INFO");
	static UI_Elements	BUTTON_SAVE_ADDED_APPROVER					= UIFactory.getElements("BUTTON_SAVE_ADDED_APPROVER");
	static UI_Elements	BUTTON_CANCEL_ADDED_APPROVER				= UIFactory.getElements("BUTTON_CANCEL_ADDED_APPROVER");
	static UI_Elements	ERROR_SELECT_NODES_NAME_IN_WORKFLOW			= UIFactory.getElements("ERROR_SELECT_NODES_NAME_IN_WORKFLOW");
	static UI_Elements	ERROR_DUPLICATE_ADD_APPROVER_IN_WORKFLOW	= UIFactory.getElements("ERROR_DUPLICATE_ADD_APPROVER_IN_WORKFLOW");
	UI_Elements			LOADER_UPDATING_WORKFLOW_PO_VIEW_PAGE		= UIFactory.getElements("LOADER_UPDATING_WORKFLOW_PO_VIEW_PAGE");

	public String fillApproverName(WebDriver driver, String testCaseName, String approverName) throws ActionBotException;

	public String selectRequireApprovalAfter(WebDriver driver, String testCaseName, int optionIndex) throws ActionBotException;

	public String selectRequireApprovalAfter(WebDriver driver, String testCaseName, String option) throws ActionBotException;

	public String getAddedApproverName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAddedApproverExtraInfo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAddedApproverName(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getAddedApproverExtraInfo(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnSaveAddApprover(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelAddApprover(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSelectNodesNamesErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDuplicateWorkflowActorNameErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

}
