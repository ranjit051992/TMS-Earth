
/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.BillingRequisitionSummary;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageViewPurchaseOrder
{

	static UI_Elements			DROP_DOWN_ACTIONS								= UIFactory.getElements("DROP_DOWN_ACTIONS");
	static UI_Elements			DELIVERY_DATE_DETAILS							= UIFactory.getElements("DELIVERY_DATE_DETAILS");
	static UI_Elements			PO_VIEW_DELIVERY_SECTION_SUB_TAB				= UIFactory.getElements("PO_VIEW_DELIVERY_SECTION_SUB_TAB");
	static UI_Elements			FREIGHT_TAX										= UIFactory.getElements("FREIGHT_TAX");
	static UI_Elements			SUPPLIER_CONTRACT_NO							= UIFactory.getElements("SUPPLIER_CONTRACT_NO");
	static UI_Elements			PO_VIEW_TAX_RATE								= UIFactory.getElements("PO_VIEW_TAX_RATE");
	static UI_Elements			PO_EFORM_FIELD_PO_VIEW							= UIFactory.getElements("PO_EFORM_FIELD_PO_VIEW");
	static UI_Elements			SUPPLIER_DETAILS_CURRENCY						= UIFactory.getElements("SUPPLIER_DETAILS_CURRENCY");
	static UI_Elements			VIEW_PO_NO										= UIFactory.getElements("VIEW_PO_NO");
	static UI_Elements			LINK_EMAIL_PO									= UIFactory.getElements("LINK_EMAIL_PO");
	static UI_Elements			ITEM_NAMES_VIEW_PO								= UIFactory.getElements("ITEM_NAMES_VIEW_PO");
	static UI_Elements			LINK_PREVIEW_PO									= UIFactory.getElements("LINK_PREVIEW_PO");
	static UI_Elements			NEW_WINDOW_PO_NO								= UIFactory.getElements("NEW_WINDOW_PO_NO");
	static UI_Elements			LINK_CREATE_RECEIPT								= UIFactory.getElements("LINK_CREATE_RECEIPT");
	static UI_Elements			LINK_CREATE_RECEIPT_ACTION_DROPDOWN_ON_VIEW_PO	= UIFactory.getElements("LINK_CREATE_RECEIPT_ACTION_DROPDOWN_ON_VIEW_PO");
	static UI_Elements			VIEW_PAGE_REQ_NO								= UIFactory.getElements("VIEW_PAGE_REQ_NO");
	static UI_Elements			CREATE_RECEIPT_REQ_NO							= UIFactory.getElements("CREATE_RECEIPT_REQ_NO");
	static UI_Elements			NEW_WINDOW_REQ_NO								= UIFactory.getElements("NEW_WINDOW_REQ_NO");
	final static UI_Elements	GROSS_TOTAL_VIEW_PAGE							= UIFactory.getElements("GROSS_TOTAL_VIEW_PAGE");
	final static UI_Elements	LINK_AMEND_PO									= UIFactory.getElements("LINK_AMEND_PO");
	final static UI_Elements	TAB_INVOICE										= UIFactory.getElements("TAB_INVOICE");
	final static UI_Elements	LINK_CREATE_INVOICE								= UIFactory.getElements("LINK_CREATE_INVOICE");
	final static UI_Elements	AMEND_ALERT_POP_UP_CONTINUE						= UIFactory.getElements("AMEND_ALERT_POP_UP_CONTINUE");
	final static UI_Elements	CANCEL_PO_LINK									= UIFactory.getElements("CANCEL_PO_LINK");
	final static UI_Elements	CANCEL_PO_COMMENT_TEXTBOX						= UIFactory.getElements("CANCEL_PO_COMMENT_TEXTBOX");
	final static UI_Elements	CANCEL_PO_SUBMIT_BUTTOM							= UIFactory.getElements("CANCEL_PO_SUBMIT_BUTTOM");
	final static UI_Elements	TERMS_NOTES_LINK								= UIFactory.getElements("TERMS_NOTES_LINK");
	final static UI_Elements	PO_NOTES_DETAILS								= UIFactory.getElements("PO_NOTES_DETAILS");
	final static UI_Elements	COSTBOOKING_LINK_VIEW_PO						= UIFactory.getElements("COSTBOOKING_LINK_VIEW_PO");
	final static UI_Elements	ACCOUNTING_DETAILS								= UIFactory.getElements("ACCOUNTING_DETAILS");
	final static UI_Elements	ACCOUNTING_LINK									= UIFactory.getElements("ACCOUNTING_LINK");
	final static UI_Elements	COSTING_DETAILS_VIEW_PO							= UIFactory.getElements("COSTING_DETAILS_VIEW_PO");
	final static UI_Elements	LINK_PRINT_PO									= UIFactory.getElements("LINK_PRINT_PO");
	final static UI_Elements	LABEL_AUDIT_TRIAL								= UIFactory.getElements("LABEL_AUDIT_TRAIL");
	final static UI_Elements	EXPECTED_DELIVERY_DATE							= UIFactory.getElements("EXPECTED_DELIVERY_DATE");
	final static UI_Elements	TAX_NAME										= UIFactory.getElements("TAX_NAME");
	final static UI_Elements	TAB_RECEIPT										= UIFactory.getElements("TAB_RECEIPT");
	final static UI_Elements	MODAL_ITEM_DETAILS_CONTRACT_NO					= UIFactory.getElements("MODAL_ITEM_DETAILS_CONTRACT_NO");
	final static UI_Elements	COSTBOOKING_LINK								= UIFactory.getElements("COSTBOOKING_LINK");

	final static UI_Elements	PLANNED_DELIVERY_DATE							= UIFactory.getElements("PLANNED_DELIVERY_DATE");
	final static UI_Elements	LINK_ITEM_NAME									= UIFactory.getElements("LINK_ITEM_NAME");
	final static UI_Elements	ITEM_TITLE_IN_POPUP								= UIFactory.getElements("ITEM_TITLE_IN_POPUP");
	final static UI_Elements	ITEM_POPUP_CLOSE								= UIFactory.getElements("ITEM_POPUP_CLOSE");
	final static UI_Elements	EDIT_ITEM_IN_INVOICE_VIEW_PO					= UIFactory.getElements("EDIT_ITEM_IN_INVOICE_VIEW_PO");
	final static UI_Elements	TEXTBOX_QUANTITY_VIEW_PO						= UIFactory.getElements("TEXTBOX_QUANTITY_VIEW_PO");
	final static UI_Elements	BUTTON_SAVE_ITEM_MODAL_VIEW_PO					= UIFactory.getElements("BUTTON_SAVE_ITEM_MODAL_VIEW_PO");
	final static UI_Elements	LABEL_SPECIFICATION_NAME_VIEW_PO				= UIFactory.getElements("LABEL_SPECIFICATION_NAME_VIEW_PO");
	final static UI_Elements	TAB_ORDER										= UIFactory.getElements("TAB_ORDER");
	final static UI_Elements	PO_CANCEL_MESSAGE								= UIFactory.getElements("PO_CANCEL_MESSAGE");
	final static UI_Elements	CLOSE_PO_LINK									= UIFactory.getElements("CLOSE_PO_LINK");
	final static UI_Elements	COPY_PO_LINK									= UIFactory.getElements("COPY_PO_LINK");
	final static UI_Elements	WARNING_MESSAGE_CLOSE_PO						= UIFactory.getElements("WARNING_MESSAGE_CLOSE_PO");
	final static UI_Elements	LABEL_TAXES										= UIFactory.getElements("LABEL_TAXES");
	final static UI_Elements	LINK_FIRST_ITEM_NAME_VIEW_PO					= UIFactory.getElements("LINK_FIRST_ITEM_NAME_VIEW_PO");
	final static UI_Elements	ADDTOCART										= UIFactory.getElements("ADDTOCART");
	final static UI_Elements	ADDTOFAVORITES									= UIFactory.getElements("ADDTOFAVORITES");
	final static UI_Elements	ADDTOBASKET										= UIFactory.getElements("ADDTOBASKET");
	final static UI_Elements	LINK_INVOICE_FIRST_ITEM_NAME					= UIFactory.getElements("LINK_INVOICE_FIRST_ITEM_NAME");
	final static UI_Elements	LINK_DOWNLOAD_AS_PDF_PO							= UIFactory.getElements("LINK_DOWNLOAD_AS_PDF_PO");
	final static UI_Elements	PO_CONTACT_EMAIL_ID_VIEW_PO						= UIFactory.getElements("PO_CONTACT_EMAIL_ID_VIEW_PO");
	final static UI_Elements	PROJECT_COST_BOOKING_SECTION					= UIFactory.getElements("PROJECT_COST_BOOKING_SECTION");
	final static UI_Elements	ACCOUNTING_DETAILS_VIEW_PO						= UIFactory.getElements("ACCOUNTING_DETAILS_VIEW_PO");
	final static UI_Elements	SUPPLIER_CONTACT								= UIFactory.getElements("SUPPLIER_CONTACT");
	final static UI_Elements	LABEL_PO_NO_ON_VIEW_PAGE_AFTER_CREATING			= UIFactory.getElements("LABEL_PO_NO_ON_VIEW_PAGE_AFTER_CREATING");
	final static UI_Elements	NOT_APPLIED_DATE								= UIFactory.getElements("NOT_APPLIED_DATE");
	final static UI_Elements	WORKFLOW_REMOVE_APPROVER_LINK					= UIFactory.getElements("WORKFLOW_REMOVE_APPROVER_LINK");
	final static UI_Elements	BUTTON_ADD_APPROVER_IN_WORKFLOW					= UIFactory.getElements("BUTTON_ADD_APPROVER_IN_WORKFLOW");
	final static UI_Elements	LINK_WORKFLOW									= UIFactory.getElements("LINK_WORKFLOW");
	static UI_Elements			LINK_INVOICE_ACTIONS_PO_VIEW					= UIFactory.getElements("LINK_INVOICE_ACTIONS_PO_VIEW");
	static UI_Elements			LINK_VIEW_INVOICE_ACTION_PO_VIEW				= UIFactory.getElements("LINK_VIEW_INVOICE_ACTION_PO_VIEW");

	static UI_Elements			LINK_VOID_INVOICE_ACTION_PO_VIEW				= UIFactory.getElements("LINK_VOID_INVOICE_ACTION_PO_VIEW");

	static UI_Elements			LINK_CLOSE_INVOICE_ACTION_PO_VIEW				= UIFactory.getElements("LINK_CLOSE_INVOICE_ACTION_PO_VIEW");

	static UI_Elements			LINK_RETURN_INVOICE_ACTION_PO_VIEW				= UIFactory.getElements("LINK_RETURN_INVOICE_ACTION_PO_VIEW");

	static UI_Elements			BUTTON_CREATE_INVOICE_PO_VIEW					= UIFactory.getElements("BUTTON_CREATE_INVOICE_PO_VIEW");

	static UI_Elements			LABEL_STATUS_OF_FIRST_INVOICE_PO_VIEW			= UIFactory.getElements("LABEL_STATUS_OF_FIRST_INVOICE_PO_VIEW");
	static UI_Elements			LINK_VIEW_ALL_INVOICE_PO_VIEW					= UIFactory.getElements("LINK_VIEW_ALL_INVOICE_PO_VIEW");
	static UI_Elements			CHECKBOX_ITEM_IN_INVOICE_VIEW_PO				= UIFactory.getElements("CHECKBOX_ITEM_IN_INVOICE_VIEW_PO");
	static UI_Elements			REMIND_SUPPLIER_TITLE							= UIFactory.getElements("REMIND_SUPPLIER_TITLE");
	static UI_Elements			REMIND_SUPPLIER_TO_FIELD						= UIFactory.getElements("REMIND_SUPPLIER_TO_FIELD");
	static UI_Elements			LABEL_REMIND_SUPPLIER_ADDED_FIELD				= UIFactory.getElements("LABEL_REMIND_SUPPLIER_ADDED_FIELD");
	static UI_Elements			WORKFLOW_CHANGE_APPROVER_LINK					= UIFactory.getElements("WORKFLOW_CHANGE_APPROVER_LINK");
	static UI_Elements			TEXTBOX_REPLACE_ACTOR_WITH_IN_WORKFLOW			= UIFactory.getElements("TEXTBOX_REPLACE_ACTOR_WITH_IN_WORKFLOW");
	static UI_Elements			BUTTON_SAVE_CHANGE_APPROVER_IN_WORKFLOW			= UIFactory.getElements("BUTTON_SAVE_CHANGE_APPROVER_IN_WORKFLOW");
	static UI_Elements			ENCLOSURES_LINK									= UIFactory.getElements("ENCLOSURES_LINK");
	static UI_Elements			LINK_DOWNLOAD_PO_ATTACHMENT						= UIFactory.getElements("LINK_DOWNLOAD_PO_ATTACHMENT");
	static UI_Elements			LINK_REQUISITION_NUMBER							= UIFactory.getElements("LINK_REQUISITION_NUMBER");
	static UI_Elements			FIRST_APPROVERS_NAME_IN_WORKFLOW				= UIFactory.getElements("FIRST_APPROVERS_NAME_IN_WORKFLOW");
	static UI_Elements			ITEM_LEAVEL_DISCOUT								= UIFactory.getElements("ITEM_LEAVEL_DISCOUT");
	static UI_Elements			LABEL_BUYER_NAME								= UIFactory.getElements("LABEL_BUYER_NAME");
	static UI_Elements			LABEL_PO_CREATED_ON_DATE						= UIFactory.getElements("LABEL_PO_CREATED_ON_DATE");
	static UI_Elements			LABEL_CONSUMED_VALUE_BPO						= UIFactory.getElements("LABEL_CONSUMED_VALUE_BPO");
	static UI_Elements			LABEL_INVOICED_AMOUNT_BPO						= UIFactory.getElements("LABEL_INVOICED_AMOUNT_BPO");
	static UI_Elements			ERROR_CHANGE_APPOVER_IN_WORKFLOW				= UIFactory.getElements("ERROR_CHANGE_APPOVER_IN_WORKFLOW");
	static UI_Elements			BUTTON_CANCEL_CHANGE_APPROVER_WORKFLOW			= UIFactory.getElements("BUTTON_CANCEL_CHANGE_APPROVER_WORKFLOW");
	static UI_Elements			CONFIRM_WORKFLOW_MODAL							= UIFactory.getElements("CONFIRM_WORKFLOW_MODAL");
	UI_Elements					LABEL_SETTLEMENT_VIA_PO_VIEW_PAGE				= UIFactory.getElements("LABEL_SETTLEMENT_VIA_PO_VIEW_PAGE");
	UI_Elements					LABEL_PAYMENT_TERMS_PO_VIEW_PAGE				= UIFactory.getElements("LABEL_PAYMENT_TERMS_PO_VIEW_PAGE");
	UI_Elements					BUTTON_SUBMIT_FOR_APPROVAL_PO					= UIFactory.getElements("BUTTON_SUBMIT_FOR_APPROVAL_PO");
	UI_Elements					BUTTON_MODIFY_PO								= UIFactory.getElements("BUTTON_MODIFY_PO");
	UI_Elements					LABEL_PROJECT_VIEW_PO							= UIFactory.getElements("LABEL_PROJECT_VIEW_PO");
	UI_Elements					LABEL_PO_NAME_ON_VIEW_PAGE						= UIFactory.getElements("LABEL_PO_NAME_ON_VIEW_PAGE");
	static UI_Elements			LABEL_COMMENT_VIEW_PO							= UIFactory.getElements("LABEL_COMMENT_VIEW_PO");

	final static UI_Elements	EDIT_ITEM_DETAILS_VIEW_PO						= UIFactory.getElements("EDIT_ITEM_DETAILS_VIEW_PO");
	final static UI_Elements	TEXT_GET_MARKET_PRICE_AMEND_PO					= UIFactory.getElements("TEXT_GET_MARKET_PRICE_AMEND_PO");
	UI_Elements					LINK_REMIND_APPROVER_VIEW_PO					= UIFactory.getElements("LINK_REMIND_APPROVER_VIEW_PO");
	static UI_Elements			LABEL_COMPANY_NAME								= UIFactory.getElements("LABEL_COMPANY_NAME");
	static UI_Elements			LABEL_BU_NAME									= UIFactory.getElements("LABEL_BU_NAME");
	static UI_Elements			LABEL_LOCATION_NAME								= UIFactory.getElements("LABEL_LOCATION_NAME");
	static UI_Elements			LABEL_BILL_TO_ADDRESS							= UIFactory.getElements("LABEL_BILL_TO_ADDRESS");
	static UI_Elements			LABEL_SHIPPING_ADDRESS							= UIFactory.getElements("LABEL_SHIPPING_ADDRESS");
	static UI_Elements			LABEL_CURRENCY									= UIFactory.getElements("LABEL_CURRENCY");
	static UI_Elements			LABEL_EXPECTED_DELIVERY_DATE					= UIFactory.getElements("LABEL_EXPECTED_DELIVERY_DATE");
	static UI_Elements			LABEL_REFERENCE									= UIFactory.getElements("LABEL_REFERENCE");
	static UI_Elements			LABEL_REQUESTER									= UIFactory.getElements("LABEL_REQUESTER");
	static UI_Elements			LABEL_REQUESTER_EMAIL_ID						= UIFactory.getElements("LABEL_REQUESTER_EMAIL_ID");
	static UI_Elements			LABEL_APPROVED_ON								= UIFactory.getElements("LABEL_APPROVED_ON");
	static UI_Elements			LABEL_RELEASED_ON								= UIFactory.getElements("LABEL_RELEASED_ON");
	static UI_Elements			LABEL_RETROSPECTIVE_PURCHASE					= UIFactory.getElements("LABEL_RETROSPECTIVE_PURCHASE");
	static UI_Elements			LABEL_PURCHASE_TYPE								= UIFactory.getElements("LABEL_PURCHASE_TYPE");
	static UI_Elements			LABEL_SUPPLIER_NAME								= UIFactory.getElements("LABEL_SUPPLIER_NAME");
	static UI_Elements			LABEL_SUPPLIER_EMAIL_ID							= UIFactory.getElements("LABEL_SUPPLIER_EMAIL_ID");
	static UI_Elements			LABEL_CUSTOMER_REFERENCE_NUMBER					= UIFactory.getElements("LABEL_CUSTOMER_REFERENCE_NUMBER");
	static UI_Elements			LABEL_DELIVERY_TERMS							= UIFactory.getElements("LABEL_DELIVERY_TERMS");
	static UI_Elements			LABEL_CONFIRMED_ON								= UIFactory.getElements("LABEL_CONFIRMED_ON");
	static UI_Elements			LABEL_SUPPLIER_DETAILS_ADDRESS					= UIFactory.getElements("LABEL_SUPPLIER_DETAILS_ADDRESS");

	static UI_Elements			DELIVERY_INFO_SPAN								= UIFactory.getElements("DELIVERY_INFO_SPAN");
	static UI_Elements			COST_BOOKING_HEADER								= UIFactory.getElements("COST_BOOKING_HEADER");
	static UI_Elements			IS_CC_PRESENT_UNDER_COST_BOOKING				= UIFactory.getElements("IS_CC_PRESENT_UNDER_COST_BOOKING");
	static UI_Elements			COST_BOOKING_COST_CENTER						= UIFactory.getElements("COST_BOOKING_COST_CENTER");
	static UI_Elements			IS_PROJECT_PRESENT_UNDER_COST_BOOKING			= UIFactory.getElements("IS_PROJECT_PRESENT_UNDER_COST_BOOKING");
	static UI_Elements			IS_BUDGET_PRESENT_UNDER_COST_BOOKING			= UIFactory.getElements("IS_BUDGET_PRESENT_UNDER_COST_BOOKING");
	static UI_Elements			COST_BOOKING_PROJECT							= UIFactory.getElements("COST_BOOKING_PROJECT");
	static UI_Elements			COST_BOOKING_BUDGET								= UIFactory.getElements("COST_BOOKING_BUDGET");
	static UI_Elements			NO_OF_ROWS_IN_AUDIT_TRAIL_INFO					= UIFactory.getElements("NO_OF_ROWS_IN_AUDIT_TRAIL_INFO");

	static UI_Elements			ITEM_SUB_TOTAL_PRICE							= UIFactory.getElements("ITEM_SUB_TOTAL_PRICE");

	static UI_Elements			NET_PAYABLE_AMOUNT								= UIFactory.getElements("NET_PAYABLE_AMOUNT");

	static UI_Elements			BUTTON_SUBMIT_PO_FOR_PROCESSING_VIEW_PO			= UIFactory.getElements("BUTTON_SUBMIT_PO_FOR_PROCESSING_VIEW_PO");

	String						xpath1_audit_trail								= ".//*[@id='auditTrailList_PURCHASE_ORDER']//tr[";
	String						xpath2_audit_trail_action						= "]/td[contains(@class,'action')]";
	String						xpath2_audit_trail_user							= "]/td[contains(@class,'actor')]";
	String						xpath2_audit_trail_sharedWith					= "]/td[contains(@class,'sharedWith')]";
	String						xpath2_audit_trail_role							= "]/td[contains(@class,'role')]";
	String						xpath2_audit_trail_dateOrTime					= "]/td[contains(@class,'dateOrTime')]";
	String						xpath2_audit_trail_version						= "]/td[contains(@class,'version')]";
	String						xpath2_audit_trail_comments						= "]/td[contains(@class,'comments')]";
	String						xpath2_audit_trail_version_link					= "]/td[contains(@class,'version')]/a";
	String						xpath1_workflow_actorName						= ".//*[@id='workFlowTrails']//li[";
	String						xpath2_workflow_actorName						= "]//div[contains(@class,'dev_nodeDisplayName')]";
	String						xpath1_accounting_data							= "(.//*[contains(@id,'dev-accounting')]/td[@class='glAcc'])";
	String						xpath2_accounting_item_name						= "']/td[contains(@class,'itmNm')]";
	String						xpath2_accounting_gl_account					= "']/td[contains(@class,'glAcc')]";

	UI_Elements					GET_INVOICES_AGAINST_PO							= UIFactory.getElements("GET_INVOICES_AGAINST_PO");
	static UI_Elements			VIEV_INVOICE_PAYMENT_SPAN						= UIFactory.getElements("VIEV_INVOICE_PAYMENT_SPAN");

	static UI_Elements			GENERIC_PO_VIEW_TAX_RATE						= UIFactory.getElements("PO_VIEW_TAX_RATE");
	UI_Elements					LABEL_FIRST_APPROVER_NAME_AS_ON_PO_VIEW_PAGE	= UIFactory.getElements("LABEL_FIRST_APPROVER_NAME_AS_ON_PO_VIEW_PAGE");

	static UI_Elements			LABEL_QUANTITY									= UIFactory.getElements("LABEL_QUANTITY");

	UI_Elements					LINK_REMIND_APPROVER							= UIFactory.getElements("LINK_REMIND_APPROVER");
	final static UI_Elements	VIEW_PO_PAGE_TAX_RATE_GENERIC					= UIFactory.getElements("VIEW_PO_PAGE_TAX_RATE_GENERIC");
	final static UI_Elements	ITEM_CONTRACT_NUMBER_MODAL_ITEM_DETAILS			= UIFactory.getElements("ITEM_CONTRACT_NUMBER_MODAL_ITEM_DETAILS");

	final static UI_Elements	LABEL_ORDER_VALUE								= UIFactory.getElements("LABEL_ORDER_VALUE");

	final static UI_Elements	PO_PEFORM_FILLED_TEXT							= UIFactory.getElements("PO_PEFORM_FILLED_TEXT");
	final static UI_Elements	ITEM_SUB_TOTAL									= UIFactory.getElements("ITEM_SUB_TOTAL");

	public void clickOnAccountingLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAmendAlertContinuePopup(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAmendPo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelPoLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelPoSubmitButtom(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCostingLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCreateInvoiceLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDropDownActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLinkCreateReceipt(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLinkCreateReceiptUnderActionOnViewPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLinkEmailPo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPreviewPoLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTermsAndNotesLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTotalItemLevelDiscount(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnViewPageReqNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeliverySectionSubTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getDeliveryDateUnderDeliverySection(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnViewPageTabInvoice(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillCancelPoCommentField(WebDriver driver, String testCaseName, String cancelPocomments) throws ActionBotException;

	public String getCreateReceiptReqNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getGrossTotal(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPoEformName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTaxName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTaxRate(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfItems(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getNewWindowReqNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getNewWindowViewPONo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getViewPageReqNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierContractNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getViewPONo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getRemindSupplierTitle(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getViewPONotes(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemContratNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public Double getFreightTaxValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAccountingDetailsDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCostingDetailsDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPrintPOOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAuditTrail(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAmmendmentStatusPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getAmmendedmentStatus(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isStatusAmmendmentReleased(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean isStatusOrderAmmended(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnPrintPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDateNotAppliedSpecified(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isReceiptPagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isInvoicePagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPlannedDeliveryDatePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemTitle(WebDriver driver, String testCaseName) throws ActionBotException;

	public void closeItemPopup(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierContact(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public String changeQuantityOfItem(WebDriver driver, String testCaseName, String quantity) throws ActionBotException;

	public boolean isSpecificationNamePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveItemDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOrderTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPOCancelledMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCancelPOOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClosePO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCopyPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isWarningForClosePODisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPlannedDeliveryDateBlank(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean arePredefinedTaxesPresentOnViewPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstItemName(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAddToCartOptionPresentOnItemDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAddToFavoritesOptionPresentOnItemDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAddToBasketOptionPresentOnItemDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstItemNameOnInvoice(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLinkDownloadAsPDF(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPOContactEmailIDPresentInViewPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProjectPresentInCostBookingSection(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isGLAccountTypePresentProperly(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPONo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRemoveApprover(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddApprover(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickonLinkWorkflow(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemCheckboxInInvoiceViewPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTabReceipt(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillRemindSupplierToField(WebDriver driver, String testCaseName, String to) throws ActionBotException;

	public String getRemindSupplierAddedField(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnChangeApprover(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillReplaceWithActor(WebDriver driver, String testCaseName, String actor) throws ActionBotException;

	public void clickOnSaveChangedApprover(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isChangeApproverLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isStatusOfWorkflowPending(WebDriver driver, String testCaseName, int id) throws ActionBotException;

	public boolean isAddApproverLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLinkEnclosure(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDownloadPOAttachmentLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getRequisitionNumber(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDownloadLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstApproversNameInWorkflow(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getBuyerName(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPOCreatedOnDatePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getConsumedOrderValueOfBPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getInvoicedAmountOfBPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemNames(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getAuditTrailAction(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public String getAuditTrailUser(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public String getAuditTrailSharedWith(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public String getAuditTrailRole(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public String getAuditTrailDateNTime(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public String getAuditTrailVersion(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public String getAuditTrailMessage(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public void clickOnAuditTrailVersion(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException;

	public boolean isChangeApproverModalErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelChangeApprover(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isWorkflowConfirnModalPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getWorkflowActorName(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getItemNameInAccountingSection(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getGLAccountInAccountingSection(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getSettlementViaOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSubmitPOForApproval(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnModifyPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getLabelValueOfProject(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPOName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPOComment(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getWorkflowNodeDisplayName(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getWorkflowNodeExtraInfo(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getWorkflowNodeStatus(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnChangeApprover(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getFirstApproverNameOnWorkflow(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickRemindApprover(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCompanyName(WebDriver driver, String testCaseName) throws ActionBotException;

	String getBUName(WebDriver driver, String testCaseName) throws ActionBotException;

	String getLocationName(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCurrency(WebDriver driver, String testCaseName) throws ActionBotException;

	String getExpectedDeliveryDate(WebDriver driver, String testCaseName) throws ActionBotException;

	String getReference(WebDriver driver, String testCaseName) throws ActionBotException;

	String getRequester(WebDriver driver, String testCaseName) throws ActionBotException;

	String getBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	String getRequesterEmailId(WebDriver driver, String testCaseName) throws ActionBotException;

	String getApprovedOn(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCreatedOn(WebDriver driver, String testCaseName) throws ActionBotException;

	String getReleasedOn(WebDriver driver, String testCaseName) throws ActionBotException;

	String getRetrospectivePurchase(WebDriver driver, String testCaseName) throws ActionBotException;

	String getPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException;

	String getSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	String getSupplierEmailId(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCustomerReferenceNumber(WebDriver driver, String testCaseName) throws ActionBotException;

	String getConfirmedOn(WebDriver driver, String testCaseName) throws ActionBotException;

	String getAddressOfSupplierDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	BillingRequisitionSummary getOrganisationUnit(WebDriver driver, String testCaseName) throws ActionBotException;

	String getDeliveryTerms(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getAllInvoicesAgainstPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getNetPayableAmountUnderPaymentsAndCredits(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnCostBookingInfoHeader(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkIfCCPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCostCenterUnderCostBooking(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkIfProjectPresentUnderCostBookingInfo(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkIfBudgetPresentUnderCostBookingInfo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProjectUnderCostBooking(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getBudgetUnderCostBooking(WebDriver driver, String testCaseName) throws ActionBotException;

	public int getNoOfRowsUnderAuditTrail(WebDriver driver, String testCaseName) throws ActionBotException;

	public String checkPaymentStatus(WebDriver driver, String testCaseName, String paymentVoucherNo) throws ActionBotException;

	public String getTaxRateByIndex(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String getTaxNameByIndex(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public int getQuantity(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;

	public String getContractNumber(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getGlAccount(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getOrderValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTaxType(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException;

	public String getFilledTextOfPeform(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	public String getItemSubTotal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

}
