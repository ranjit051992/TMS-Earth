package com.zycus.automation.eproc.pageobjects.pages.requisitionForking;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageRequisitionForking
{
	final static UI_Elements	REQUISITION_CANCLE							= UIFactory.getElements("REQUISITION_CANCLE");
	final static UI_Elements	REQUISITION_CONFIRM							= UIFactory.getElements("REQUISITION_CONFIRM");
	final static UI_Elements	REQUISITION_BACK							= UIFactory.getElements("REQUISITION_BACK");
	final static UI_Elements	FORKING_SAVE_WORKFLOW_OK					= UIFactory.getElements("FORKING_SAVE_WORKFLOW_OK");
	final static UI_Elements	FORKING_LEARN								= UIFactory.getElements("FORKING_LEARN");
	static UI_Elements			LINK_LIST_OF_ITEM_NAMES_ON_FORKING_SCREEN	= UIFactory.getElements("LINK_LIST_OF_ITEM_NAMES_ON_FORKING_SCREEN");
	static UI_Elements			LINK_LIST_OF_PR_NUMBERS_ON_FORKING_SCREEN	= UIFactory.getElements("LINK_LIST_OF_PR_NUMBERS_ON_FORKING_SCREEN");
	static UI_Elements			LINK_VIEW_WORKFLOW_FORKING_PAGE				= UIFactory.getElements("LINK_VIEW_WORKFLOW_FORKING_PAGE");
	static UI_Elements			ALERT_MESSAGE_FOR_SUBMITTING_FORKED_REQS	= UIFactory.getElements("ALERT_MESSAGE_FOR_SUBMITTING_FORKED_REQS");
	static UI_Elements			BUTTON_SAVE_REQ_APPROVAL_WORKFLOW			= UIFactory.getElements("BUTTON_SAVE_REQ_APPROVAL_WORKFLOW");
	static UI_Elements			BUTTON_CANCEL_REQ_APPROVAL_WORKFLOW			= UIFactory.getElements("BUTTON_CANCEL_REQ_APPROVAL_WORKFLOW");
	static UI_Elements			LABEL_MODIFY_WORKFLOW_SETTINGS				= UIFactory.getElements("LABEL_MODIFY_WORKFLOW_SETTINGS");
	static UI_Elements			CHECKBOX_MODIFY_WORKFLOW_SETTINGS			= UIFactory.getElements("CHECKBOX_MODIFY_WORKFLOW_SETTINGS");

	String						xpath1_Link_View_Workflow					= ".//*[@id='dev_forkedRequisitionsTable']//*[@data-index='";
	String						xpath2_Link_View_Workflow					= "']//a[contains(@class,'dev_workflowTrailLnk')]";

	void clickBackReq(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickCancleReq(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickCommentsForSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickConfirmReq(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickDraft(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickForkedItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickforkingLearn(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOkWorkflow(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickReasonForOrdering(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickSubmit(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickViewWorkflow(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getForkedItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getForkedItemSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getForkedReqName(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getForkedReqNumber(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getForkedReqTotalPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getForkedItemUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getForkedItemQuantity(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	List<WebElement> getListOfItemNamesOnForkingScreen(WebDriver driver, String testCaseName) throws ActionBotException;

	List<String> getListOfPRNumbersOnForkingScreen(WebDriver driver, String testCaseName) throws ActionBotException;

	String getAlertMessageForSubmittingForkedReqs(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isModifyWorkflowSettingsPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnSaveApprovalWorflow(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnCheckboxModifyWorkflowSettings(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnCancelApprovalWorkflow(WebDriver driver, String testCaseName) throws ActionBotException;

	List<String> getListOfItemNames(WebDriver driver, String testCaseName) throws ActionBotException;

}
