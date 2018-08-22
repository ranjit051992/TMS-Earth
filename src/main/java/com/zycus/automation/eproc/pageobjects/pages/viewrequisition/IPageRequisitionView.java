/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.viewrequisition;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 */
public interface IPageRequisitionView
{

	public final static UI_Elements	GET_PURCHASE_TYPE											= UIFactory.getElements("GET_PURCHASE_TYPE");
	public final static UI_Elements	GET_ATTACHMENTS												= UIFactory.getElements("GET_ATTACHMENTS");
	public final static UI_Elements	GET_COMMENTS												= UIFactory.getElements("GET_COMMENTS");
	public final static UI_Elements	GET_DELIVERY_LOCATION										= UIFactory.getElements("GET_DELIVERY_LOCATION");
	public final static UI_Elements	GET_DELIVERY_NAME											= UIFactory.getElements("GET_DELIVERY_NAME");
	public final static UI_Elements	GET_COST_CENTER												= UIFactory.getElements("COST_CENTER");
	public final static UI_Elements	GET_GL_ACCOUNT												= UIFactory.getElements("GL_ACCOUNT");

	public final static UI_Elements	AUDIT_TRAIL_MORE_INFO										= UIFactory.getElements("AUDIT_TRAIL_MORE_INFO");

	public final static UI_Elements	REMIND_APPROVER												= UIFactory.getElements("REMIND_APPROVER");

	public final static UI_Elements	GO_BACK														= UIFactory.getElements("GO_BACK");

	public final static UI_Elements	ITEMS_BLOCK_OPEN											= UIFactory.getElements("ITEMS_BLOCK_OPEN");
	public final static UI_Elements	WORKFLOW_BLOCK_OPEN											= UIFactory.getElements("WORKFLOW_BLOCK_OPEN");
	public final static UI_Elements	DELIVERY_AND_ASSET_BLOCK_OPEN								= UIFactory.getElements("DELIVERY AND ASSET_BLOCK_OPEN");
	public final static UI_Elements	COST_BOOKING_BLOCK_OPEN										= UIFactory.getElements("COST BOOKING_BLOCK_OPEN");
	public final static UI_Elements	COST_ACCOUNTING_BLOCK_OPEN									= UIFactory.getElements("ACCOUNTING_BLOCK_OPEN");
	public final static UI_Elements	MESSAGE_HEADER_AUDIT_TRAIL									= UIFactory.getElements("MESSAGE_HEADER_AUDIT_TRAIL");
	public final static UI_Elements	DATETIME_HEADER_AUDIT_TRAIL									= UIFactory.getElements("DATE_TIME_HEADER_AUDIT_TRAIL");
	public final static UI_Elements	LEADTIME_ITEM_DETAILS_POPUP									= UIFactory.getElements("LEADTIME_ITEM_DETAILS_POPUP");
	public final static UI_Elements	BUYER_RETURN_COMMENT										= UIFactory.getElements("BUYER_RETURN_COMMENT");
	static UI_Elements				LABEL_PEFORM_SECTION_NAME_ON_REQ_VIEW_PAGE					= UIFactory.getElements("LABEL_PEFORM_SECTION_NAME_ON_REQ_VIEW_PAGE");
	static UI_Elements				LABEL_PEFORM_FIELD_NAME_ON_REQ_VIEW_PAGE					= UIFactory.getElements("LABEL_PEFORM_FIELD_NAME_ON_REQ_VIEW_PAGE");
	static UI_Elements				LABEL_PEFORM_FIELD_VALUE_ON_REQ_VIEW_PAGE					= UIFactory.getElements("LABEL_PEFORM_FIELD_VALUE_ON_REQ_VIEW_PAGE");
	static UI_Elements				BUTTON_EXPAND_DELIVERY_ON_REQ_VIEW_PAGE						= UIFactory.getElements("BUTTON_EXPAND_DELIVERY_ON_REQ_VIEW_PAGE");
	static UI_Elements				TOOL_TIP_CONTENT											= UIFactory.getElements("TOOL_TIP_CONTENT");
	static UI_Elements				BUTTON_EXPAND_COST_BOOKING_ON_REQ_VIEW_PAGE					= UIFactory.getElements("BUTTON_EXPAND_COST_BOOKING_ON_REQ_VIEW_PAGE");
	static UI_Elements				LABEL_REQUISITION_NO_ON_REQ_VIEW_PAGE						= UIFactory.getElements("LABEL_REQUISITION_NO_ON_REQ_VIEW_PAGE");
	static UI_Elements				LABEL_REQUISITION_NAME_ON_REQ_VIEW_PAGE						= UIFactory.getElements("LABEL_REQUISITION_NAME_ON_REQ_VIEW_PAGE");
	static UI_Elements				LABEL_URG_REQUIREMENT_ON_REQ_VIEW_PAGE						= UIFactory.getElements("LABEL_URG_REQUIREMENT_ON_REQ_VIEW_PAGE");
	static UI_Elements				LABEL_CREATED_BY_ON_REQ_VIEW_PAGE							= UIFactory.getElements("LABEL_CREATED_BY_ON_REQ_VIEW_PAGE");
	static UI_Elements				LABEL_SETTLEMENT_VIA_ON_REQ_VIEW_PAGE						= UIFactory.getElements("LABEL_SETTLEMENT_VIA_ON_REQ_VIEW_PAGE");
	static UI_Elements				LABEL_REASON_FOR_ORDERING_ON_REQ_VIEW_PAGE					= UIFactory.getElements("LABEL_REASON_FOR_ORDERING_ON_REQ_VIEW_PAGE");
	static UI_Elements				LABEL_COMMENTS_FOR_SUPPLIER_ON_REQ_VIEW_PAGE				= UIFactory.getElements("LABEL_COMMENTS_FOR_SUPPLIER_ON_REQ_VIEW_PAGE");
	static UI_Elements				LABEL_PURCHASE_TYPE_ON_REQ_VIEW_PAGE						= UIFactory.getElements("LABEL_PURCHASE_TYPE_ON_REQ_VIEW_PAGE");
	static UI_Elements				LABEL_STATUS_ON_REQ_VIEW_PAGE								= UIFactory.getElements("LABEL_STATUS_ON_REQ_VIEW_PAGE");
	static UI_Elements				LABEL_RETROSPECTIVE_PURCHASE_ON_REQ_VIEW_PAGE				= UIFactory.getElements("LABEL_RETROSPECTIVE_PURCHASE_ON_REQ_VIEW_PAGE");
	static UI_Elements				BUTTON_ADD_APPROVER											= UIFactory.getElements("BUTTON_ADD_APPROVER");
	static UI_Elements				BUTTON_SUBMIT_FOR_APPROVAL									= UIFactory.getElements("BUTTON_SUBMIT_FOR_APPROVAL");
	static UI_Elements				PROCESSING_DIV_UPDATE_REQUISITION							= UIFactory.getElements("PROCESSING_DIV_UPDATE_REQUISITION");
	static UI_Elements				LABEL_ADDED_APPROVER_NAME_AS_ON_REQ_VIEW					= UIFactory.getElements("LABEL_ADDED_APPROVER_NAME_AS_ON_REQ_VIEW");
	static UI_Elements				LABEL_ADDED_APPROVER_EXTRA_INFO_AS_ON_REQ_VIEW				= UIFactory.getElements("LABEL_ADDED_APPROVER_EXTRA_INFO_AS_ON_REQ_VIEW");
	static UI_Elements				BUTTON_EXPAND_WORKFLOW_ON_REQ_VIEW_PAGE						= UIFactory.getElements("BUTTON_EXPAND_WORKFLOW_ON_REQ_VIEW_PAGE");
	static UI_Elements				LABEL_ADDED_ADHOC_APPROVER_EXTRA_INFO_AS_ON_REQ_VIEW		= UIFactory.getElements("LABEL_ADDED_ADHOC_APPROVER_EXTRA_INFO_AS_ON_REQ_VIEW");
	static UI_Elements				AUDIT_TRAIL_LINK											= UIFactory.getElements("AUDIT_TRAIL_LINK");
	static String					xpath1_audit_trail											= ".//*[@id='auditTrailList_REQUISITION']//tr[";
	static String					xpath2_audit_trail_action									= "]/td[contains(@class,'action')]";
	static String					xpath2_audit_trail_actor									= "]/td[contains(@class,'actor')]";
	static String					xpath2_audit_trail_shared_with								= "]/td[contains(@class,'sharedWith')]";
	static String					xpath2_audit_trail_role										= "]/td[contains(@class,'role')]";
	static String					xpath2_audit_trail_date_time								= "]/td[contains(@class,'dateOrTime')]";
	static String					xpath2_audit_trail_version									= "]/td[contains(@class,'version')]";
	static String					xpath2_audit_trail_version_link								= "]/td[contains(@class,'version')]/a";
	static String					xpath2_audit_trail_message									= "]/td[contains(@class,'comments')]";
	static String					xpath_audit_trail_header									= "//*[@id='auditTrailList_REQUISITION']";
	static UI_Elements				LINK_REMOVE_FIRST_ADDED_APPROVER							= UIFactory.getElements("LINK_REMOVE_FIRST_ADDED_APPROVER");
	static UI_Elements				PROGRESSING_DIV_UPDATING_WORKFLOW							= UIFactory.getElements("PROGRESSING_DIV_UPDATING_WORKFLOW");
	static UI_Elements				LINK_MODIFY_REQUISITION										= UIFactory.getElements("LINK_MODIFY_REQUISITION");
	static UI_Elements				BUDGET_FIELD_REQ_VIEW										= UIFactory.getElements("BUDGET_FIELD_REQ_VIEW");
	static UI_Elements				ASSIGN_BUYER_LINK											= UIFactory.getElements("ASSIGN_BUYER_LINK");
	static UI_Elements				ASSIGNED_BUYER_REQ											= UIFactory.getElements("ASSIGNED_BUYER_REQ");
	static UI_Elements				MODAL_ASSIGN_BUYER_CANCEL_LINK								= UIFactory.getElements("MODAL_ASSIGN_BUYER_CANCEL_LINK");
	static UI_Elements				MODAL_ASSIGN_BUYER_SAVE_LINK								= UIFactory.getElements("MODAL_ASSIGN_BUYER_SAVE_LINK");
	static UI_Elements				FILL_ASSIGN_BUYER_MODAL										= UIFactory.getElements("FILL_ASSIGN_BUYER_MODAL");
	static UI_Elements				MODAL_REMOVE_ASSIGN_BUYER_BTN								= UIFactory.getElements("MODAL_REMOVE_ASSIGN_BUYER_BTN");
	static UI_Elements				ASSGN_BUYER_FIELD											= UIFactory.getElements("ASSGN_BUYER_FIELD");
	static UI_Elements				ITEM_LINK													= UIFactory.getElements("ITEM_LINK");
	static UI_Elements				BUTTON_EXPAND_ACCOUNTING_ON_REQ_VIEW_PAGE					= UIFactory.getElements("BUTTON_EXPAND_ACCOUNTING_ON_REQ_VIEW_PAGE");
	UI_Elements						LINK_ACTIONS_REQ_VIEW_ORDER_TAB								= UIFactory.getElements("LINK_ACTIONS_REQ_VIEW_ORDER_TAB");
	UI_Elements						LINK_REQUEST_ADDITIONAL_ITEMS_ACTIONS_REQ_VIEW_ORDER_TAB	= UIFactory.getElements("LINK_REQUEST_ADDITIONAL_ITEMS_ACTIONS_REQ_VIEW_ORDER_TAB");
	UI_Elements						LABEL_SINGLE_COST_CENTER_REQ_VIEW_PAGE						= UIFactory.getElements("LABEL_SINGLE_COST_CENTER_REQ_VIEW_PAGE");
	UI_Elements						LINK_CHANGE_APPROVER_FIRST_NODE								= UIFactory.getElements("LINK_CHANGE_APPROVER_FIRST_NODE");
	UI_Elements						REPLACE_APPROVER											= UIFactory.getElements("REPLACE_APPROVER");

	static UI_Elements				TAB_ORDER_VIEW_REQUISITION									= UIFactory.getElements("TAB_ORDER_VIEW_REQUISITION");
	static UI_Elements				LABEL_PO_STATUS_REQ_VIEW_ORDER_TAB							= UIFactory.getElements("LABEL_PO_STATUS_REQ_VIEW_ORDER_TAB");

	UI_Elements						LINK_DROP_DOWN_ASSIGN_BUYER									= UIFactory.getElements("LINK_DROP_DOWN_ASSIGN_BUYER");

	UI_Elements						LINK_SINGLE_ASSIGN_BUYER									= UIFactory.getElements("LINK_SINGLE_ASSIGN_BUYER");
	UI_Elements						LINK_GROUP_ASSIGN_BUYER										= UIFactory.getElements("LINK_GROUP_ASSIGN_BUYER");

	UI_Elements						TEXTBOX_ASSIGNED_BUYER_GROUP_NAME							= UIFactory.getElements("TEXTBOX_ASSIGNED_BUYER_GROUP_NAME");
	UI_Elements						TAB_REQUISITION_ON_REQ_VIEW_PAGE							= UIFactory.getElements("TAB_REQUISITION_ON_REQ_VIEW_PAGE");
	UI_Elements						LINK_PARENT_REQUISITION										= UIFactory.getElements("LINK_PARENT_REQUISITION");
	UI_Elements						LABEL_REQUESTER_NODE_IN_WORKFLOW_TRAIL_ON_REQ_VIEW_PAGE		= UIFactory.getElements("LABEL_REQUESTER_NODE_IN_WORKFLOW_TRAIL_ON_REQ_VIEW_PAGE");
	UI_Elements						LINK_FILTER_DROP_DOWN										= UIFactory.getElements("LINK_FILTER_DROP_DOWN");
	UI_Elements						LINK_CLEAR_FILTER_REQ_VIEW_PAGE								= UIFactory.getElements("LINK_CLEAR_FILTER_REQ_VIEW_PAGE");
	UI_Elements						PREVIEW_REQ_CHANGE_BUYER_LINK								= UIFactory.getElements("PREVIEW_REQ_CHANGE_BUYER_LINK");
	UI_Elements						PREVIEW_REQ_ASSIGN_BUYER_SAVE_BTN							= UIFactory.getElements("PREVIEW_REQ_ASSIGN_BUYER_SAVE_BTN");
	UI_Elements						PREVIEW_REQ_ASSIGN_BUYER									= UIFactory.getElements("PREVIEW_REQ_ASSIGN_BUYER");
	UI_Elements						TAB_SUPPLIERS_ITEM_DETAILS									= UIFactory.getElements("TAB_SUPPLIERS_ITEM_DETAILS");
	UI_Elements						LABEL_SUGGESTED_SUPPLIER_NAME								= UIFactory.getElements("LABEL_SUGGESTED_SUPPLIER_NAME");
	UI_Elements						BUTTON_CANCEL_ITEM_DETAILS_MODAL							= UIFactory.getElements("BUTTON_CANCEL_ITEM_DETAILS_MODAL");
	UI_Elements						LABEL_ASSET_CODE											= UIFactory.getElements("LABEL_ASSET_CODE");

	UI_Elements						LINK_ACTIONS_REQ_VIEW_PAGE									= UIFactory.getElements("LINK_ACTIONS_REQ_VIEW_PAGE");
	UI_Elements						LINK_COPY_ACTIONS_REQ_VIEW_PAGE								= UIFactory.getElements("LINK_COPY_ACTIONS_REQ_VIEW_PAGE");
	UI_Elements						LABEL_MULTIPLE_BUYER_NAMES_ON_HOVER							= UIFactory.getElements("LABEL_MULTIPLE_BUYER_NAMES_ON_HOVER");
	UI_Elements						LABEL_MULTIPLE_ASSIGNED_BUYER								= UIFactory.getElements("LABEL_MULTIPLE_ASSIGNED_BUYER");
	UI_Elements						LABEL_COST_CENTER_REQ_VIEW_PAGE								= UIFactory.getElements("LABEL_COST_CENTER_REQ_VIEW_PAGE");
	UI_Elements						LABEL_GL_ACCOUNT_REQ_VIEW_PAGE								= UIFactory.getElements("LABEL_GL_ACCOUNT_REQ_VIEW_PAGE");
	UI_Elements						LABEL_GL_ACCOUNT_TYPE_REQ_VIEW_PAGE							= UIFactory.getElements("LABEL_GL_ACCOUNT_TYPE_REQ_VIEW_PAGE");
	//Refrenced Excel id RequisitionViewPage.xls

	public final static UI_Elements	BOOK_COST_TO												= UIFactory.getElements("BOOK_COST_TO");
	public final static UI_Elements	MATTER														= UIFactory.getElements("MATTER");
	public final static UI_Elements	CLIENT														= UIFactory.getElements("CLIENT");
	public final static UI_Elements	GL_ACCOUNT_ITEM_SUMMARY_MAYER_BROWN							= UIFactory.getElements("GL_ACCOUNT_ITEM_SUMMARY_MAYER_BROWN");
	public final static UI_Elements	EMPLOYEE_TIMEKEEPER											= UIFactory.getElements("EMPLOYEE_TIMEKEEPER");
	public final static UI_Elements	OFFICE														= UIFactory.getElements("OFFICE");
	public final static UI_Elements	COST_DISBURSEMENT_CODE_MAYER								= UIFactory.getElements("COST_DISBURSEMENT_CODE_MAYER");
	public final static UI_Elements	DEPARTMENT													= UIFactory.getElements("DEPARTMENT");
	public final static UI_Elements	PROFIT_CENTER												= UIFactory.getElements("PROFIT_CENTER");
	public final static UI_Elements	TRANSACTION_DATE											= UIFactory.getElements("TRANSACTION_DATE");
	public final static UI_Elements	DESCRIPTION_ITEM_SUMMARY_MAYER								= UIFactory.getElements("DESCRIPTION_ITEM_SUMMARY_MAYER");
	public final static UI_Elements	PERCENTAGE_ITEM_SUMMARY_MAYER								= UIFactory.getElements("PERCENTAGE_ITEM_SUMMARY_MAYER");
	public final static UI_Elements	QUANTITY_ITEM_SUMMARY_MAYER									= UIFactory.getElements("QUANTITY_ITEM_SUMMARY_MAYER");
	public final static UI_Elements	AMOUNT_ITEM_SUMMARY_MAYER									= UIFactory.getElements("AMOUNT_ITEM_SUMMARY_MAYER");
	public final static UI_Elements	TOTAL_AMOUNT_ITEM_SUMMARY_MAYER								= UIFactory.getElements("TOTAL_AMOUNT_ITEM_SUMMARY_MAYER");
	public final static UI_Elements	LABEL_ITEM_QUANTITY											= UIFactory.getElements("LABEL_ITEM_QUANTITY");

	public final static UI_Elements	ITEM_SUMMARY_BLOCK											= UIFactory.getElements("ITEM_SUMMARY_BLOCK");
	public final static UI_Elements	WORKFLOW_OPEN_BLOCK											= UIFactory.getElements("WORKFLOW_OPEN_BLOCK");
	final static UI_Elements		AUDIT_TRAIL_MESSAGE_ADHOC_APPROVER							= UIFactory.getElements("AUDIT_TRAIL_MESSAGE_ADHOC_APPROVER");
	final static UI_Elements		LINK_CHANGE_APPROVER_VIEW_REQ								= UIFactory.getElements("LINK_CHANGE_APPROVER_VIEW_REQ");
	final static UI_Elements		CHANGE_APPROVER_FILL_NAME									= UIFactory.getElements("CHANGE_APPROVER_FILL_NAME");
	final static UI_Elements		CLOSE_ITEM_SUMMARY_MODAL									= UIFactory.getElements("CLOSE_ITEM_SUMMARY_MODAL");
	final static UI_Elements		REQUIRED_BY_DATE_REQUISITION_VEIW							= UIFactory.getElements("REQUIRED_BY_DATE_REQUISITION_VEIW");
	final static UI_Elements		DELIVERY_ADDRESS											= UIFactory.getElements("DELIVERY_ADDRESS");

	String							xpath1_item_status											= ".//*[@id='item_";																//".//tr[@id='dev-item_";
	String							xpath2_item_status											= "']/td[@class='itmStatus']/span";													//"']//*[@id='rfq_']";
	String							xpath1_item_name											= ".//*[@id='itemName_";															//".//*[@id='dev-item_";//eProc version R17.11.1.0
	String							xpath2_item_name											= "']//a[contains(@class,'showItemDetails')]";

	public boolean isPeformSectionLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPeformFieldLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getNameOfPeformSectionLabel(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getNameOfPeformFieldLabel(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getNameOfPeformFieldValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExpandDelivery(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExpandAccounting(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAuditTrail(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnChangeBuyerLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getDeliverTo(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getDeliveryDate(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public int getDeliveryQuantity(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getShipToAddress(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	public void clickOnExpandCostBooking(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExpandWorkFlow(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAssignBuyerlink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnModalAssignBuyerSaveBtn(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelAssignBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveAssignBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemDetailsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRemoveAssignBuyerbtn(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCostCenterForItemLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getAssignBuyerField(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillAssignBuyerField(WebDriver driver, String testCaseName, String assignbuyer) throws ActionBotException;

	public String getBudgetForItemLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getProjectForItemLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getRequisitionNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getRequisitionName(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean getUrgRequirement(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCreatedBy(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSettlementVia(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getReasonForOrdering(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCommentsForSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean getRetrospectivePurchase(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getItemUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public int getItemQuantity(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getItemTotalPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getCostCenterForHeaderLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getBudgetForHeaderLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getProjectForHeaderLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnAddApproverButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSubmitForApproval(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAddedApproverNameFromWorkflow(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAddedApproverExtraInfoFromWorkflow(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAddedAdhocApproverExtraInfoFromWorkflow(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillModalAssignBuyerField(WebDriver driver, String testCaseName, String assignBuyer) throws ActionBotException;

	public boolean isSubmitForApprovalButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isBudgetDisplayedInsideCostBooking(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRemoveFirstAddedApprover(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAuditTrailAction(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public String getAuditTrailActor(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public String getAuditTrailSharedWith(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public String getAuditTrailRole(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public String getAuditTrailDateTime(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public String getAuditTrailVersion(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public String getAuditTrailMessage(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public void clickOnModifyRequisitionLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnActionsReqViewOrderTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRequestAdditionalItemActionsReqViewOrderTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSingleCostCenter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAuditTrailVersion(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public boolean isChangeApproverPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOrderTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPOStatusOnOrderTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getLabelValueOfAssignBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAssignSingleBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAssignGroupOfBuyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillAssignedBuyerGroupName(WebDriver driver, String testCaseName, String assignedBuyerGroupName) throws ActionBotException;

	public void clickOnRequisitionTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemStatus(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public void clickOnParentRequisitionLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getRequesterInWorkflowNode(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearFilterLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSuppliersTabInItemDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSuggestedSupplierNameInItemDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSuggestedSupplierNamePresentInItemDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelItemDetailsModal(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAssetCodePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAssetCode(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnActionsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCopyActionsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public List<String> getMultipleBuyerNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCostCenterLabel(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getGLAccountLabel(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getGLAccountTypeLabel(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRequisitionNoLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String get_BU_Indexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String get_BusinessLocation_Indexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean clickOnRemindApproverLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnGoBackLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemBlockOpen(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDeliveryAssetTagBlockOpen(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCostBookingBlockOpen(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAccountingBlockOpen(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isWorkflowBlockOpen(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickItemDescriptionLinkIndexwise(WebDriver driver, String testCaseName, int index) throws Exception;

	void clickCloseItemDescriptionLinkIndexwise(WebDriver driver, String testCaseName) throws Exception;

	void clickOnItemDetailsLinkIndewise(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	boolean isBuyerReturnCommentPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	int getItemQuantity(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public void clickOnItemSummaryViewItemWise(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItem_Name(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException;

}
