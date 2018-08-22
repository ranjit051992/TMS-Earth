package com.zycus.automation.iConsole.pageObjects.pages.apiConsole;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageApiConsole
{
	final static UI_Elements	LINK_CLICK_HERE_TO_AUTHENTICATE							= UIFactory.getElements("LINK_CLICK_HERE_TO_AUTHENTICATE");
	final static UI_Elements	BUTTON_GO_AUTHENTICATION_MECHANISM_POPUP				= UIFactory.getElements("BUTTON_GO_AUTHENTICATION_MECHANISM_POPUP");
	final static UI_Elements	TEXT_MPIN_AUTHENTICATION_POPUP							= UIFactory.getElements("TEXT_MPIN_AUTHENTICATION_POPUP");
	final static UI_Elements	BUTTON_GO_AUTHENTICATION_POPUP							= UIFactory.getElements("BUTTON_GO_AUTHENTICATION_POPUP");
	final static UI_Elements	BUTTON_OK_SUCCESS_MESSAGE								= UIFactory.getElements("BUTTON_OK_SUCCESS_MESSAGE");
	final static UI_Elements	LINK_SEARCH_EPROC										= UIFactory.getElements("LINK_SEARCH_EPROC");
	final static UI_Elements	LINK_UPDATE_EPROC										= UIFactory.getElements("LINK_UPDATE_EPROC");
	final static UI_Elements	HEADER_EPROC_SIDE_PANEL									= UIFactory.getElements("HEADER_EPROC_SIDE_PANEL");
	final static UI_Elements	HEADER_API_EPROC_APPROVALS								= UIFactory.getElements("HEADER_API_EPROC_APPROVALS");
	final static UI_Elements	HEADER_API_EPROC_REQUISITIONS_REQUISITION_ID_APPROVAL	= UIFactory.getElements("HEADER_API_EPROC_REQUISITIONS_REQUISITION_ID_APPROVAL");
	final static UI_Elements	TEXT_REQUISITON_ID_REQUISITION_APPROVAL					= UIFactory.getElements("TEXT_REQUISITON_ID_REQUISITION_APPROVAL");
	final static UI_Elements	TEXT_APPROVAL_ACTION_REQUISITION_APPROVAL				= UIFactory.getElements("TEXT_APPROVAL_ACTION_REQUISITION_APPROVAL");
	final static UI_Elements	BUTTON_TRY_IT_REQUISITION_APPROVAL						= UIFactory.getElements("BUTTON_TRY_IT_REQUISITION_APPROVAL");
	final static UI_Elements	TAB_RESPONSE_BODY										= UIFactory.getElements("TAB_RESPONSE_BODY");
	final static UI_Elements	AREA_RESPONSE_BODY										= UIFactory.getElements("AREA_RESPONSE_BODY");
	final static UI_Elements	LABEL_ACCESS_TOKEN_SUCCESS_MESSAGE						= UIFactory.getElements("LABEL_ACCESS_TOKEN_SUCCESS_MESSAGE");
	final static UI_Elements	HEADER_API_EPROC_PO_PO_ID_APPROVAL						= UIFactory.getElements("HEADER_API_EPROC_PO_PO_ID_APPROVAL");
	final static UI_Elements	TEXT_PO_ID_PO_APPROVAL									= UIFactory.getElements("TEXT_PO_ID_PO_APPROVAL");
	final static UI_Elements	TEXT_APPROVAL_ACTION_PO_APPROVAL						= UIFactory.getElements("TEXT_APPROVAL_ACTION_PO_APPROVAL");
	final static UI_Elements	BUTTON_TRY_IT_PO_APPROVAL								= UIFactory.getElements("BUTTON_TRY_IT_PO_APPROVAL");
	final static UI_Elements	TAB_RESPONSE_BODY_PO									= UIFactory.getElements("TAB_RESPONSE_BODY_PO");
	final static UI_Elements	AREA_RESPONSE_BODY_PO									= UIFactory.getElements("AREA_RESPONSE_BODY_PO");

	//methods
	public void clickOnLinkAuthenticate(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnButtonGoAuthenticationMechanismPopup(WebDriver driver, String testCaseName) throws ActionBotException;

	public void fillTextMpin(WebDriver driver, String testCaseName, String mPin) throws ActionBotException;

	public void clickOnButtonGoAuthenticationPopup(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifyAuthenticationSuccessMessage(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnButtonOkSuccessMessage(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLinkEprocHeaderMenu(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnLinkSearchUnderEprocMenu(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnLinkUpdateUnderEprocMenu(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApiEprocApprovals(WebDriver driver, String testCaseName) throws ActionBotException;

	//below code for api: /rest/v1/eProc/requisitions/{requisitionId}/approval
	public boolean clickOnApiEprocRequisitonApproval(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillRequisitonId(WebDriver driver, String testCaseName, String reqId) throws ActionBotException;

	public String fillRequisitionApprovalAction(WebDriver driver, String testCaseName, String reqAction) throws ActionBotException;

	public void clickOnButtonTryItReqApproval(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTabResponseBodyReqApproval(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getApiResponseBodyReqApproval(WebDriver driver, String testCaseName) throws ActionBotException;
	//till here

	//below code for api: /rest/v1/eProc/purchaseOrder/{purchaseOrderId}/approval
	boolean clickOnApiEprocPOApproval(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillPurchaseOrderId(WebDriver driver, String testCaseName, String poId) throws ActionBotException;

	public String fillPOApprovalAction(WebDriver driver, String testCaseName, String purchaseOrderAction) throws ActionBotException;

	public void clickOnButtonTryItPOApproval(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTabResponseBodyPOApproval(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getApiResponseBodyPOApproval(WebDriver driver, String testCaseName) throws ActionBotException;
	//till here
}
