package com.zycus.automation.eproc.pageobjects.pages.settings.requisitionsettings;

/**
 * @author ankita.sawant
 *
 */

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageRequisitionSettings
{
	final static String			ALWAYS															= "Always";
	final static String			NEVER															= "Never";
	final static String			PERMISSION_BASED												= "PermissionBased";
	final static String			CATEGORIES														= "Categories";
	final static String			PRICE_TYPE														= "PriceType";

	/* numbering */
	final static UI_Elements	REQ_NO_FORMAT													= UIFactory.getElements("REQ_NO_FORMAT");
	final static UI_Elements	REQ_SEQUENCE_NO_STARTS_AT										= UIFactory.getElements("REQ_SEQUENCE_NO_STARTS_AT");
	final static UI_Elements	REQ_SEQUENCE_NO_ENDS_AT											= UIFactory.getElements("REQ_SEQUENCE_NO_ENDS_AT");
	final static UI_Elements	REQ_NAME_FORMAT													= UIFactory.getElements("REQ_NAME_FORMAT");

	/* Display */
	final static UI_Elements	FREQUENTLY_SEARCHED_ITEM										= UIFactory.getElements("FREQUENTLY_SEARCHED_ITEM");

	/* control */
	final static UI_Elements	REQ_ITEM_QUQNTITY_THRESHOLD										= UIFactory.getElements("REQ_ITEM_QUQNTITY_THRESHOLD");
	final static UI_Elements	FREE_TEXT_ITEMS_ALWAYS											= UIFactory.getElements("FREE_TEXT_ITEMS_ALWAYS");
	final static UI_Elements	FREE_TEXT_ITEMS_NEVER											= UIFactory.getElements("FREE_TEXT_ITEMS_NEVER");
	final static UI_Elements	FREE_TEXT_ITEMS_PERMISSION_BASED								= UIFactory.getElements("FREE_TEXT_ITEMS_PERMISSION_BASED");

	final static UI_Elements	FREE_TEXT_ITEM_WITHOUT_CATEGORY_YES								= UIFactory.getElements("FREE_TEXT_ITEM_WITHOUT_CATEGORY_YES");
	final static UI_Elements	FREE_TEXT_ITEM_WITHOUT_CATEGORY_NO								= UIFactory.getElements("FREE_TEXT_ITEM_WITHOUT_CATEGORY_NO");

	final static UI_Elements	WITHOUT_REQUIRED_BY_DATE_YES									= UIFactory.getElements("WITHOUT_REQUIRED_BY_DATE_YES");
	final static UI_Elements	WITHOUT_REQUIRED_BY_DATE_NO										= UIFactory.getElements("WITHOUT_REQUIRED_BY_DATE_NO");

	final static UI_Elements	ALLOW_BUYER_TO_MODIFY_REQUIRED_BY_DATE_YES						= UIFactory.getElements("ALLOW_BUYER_TO_MODIFY_REQUIRED_BY_DATE_YES");
	final static UI_Elements	ALLOW_BUYER_TO_MODIFY_REQUIRED_BY_DATE_NO						= UIFactory.getElements("ALLOW_BUYER_TO_MODIFY_REQUIRED_BY_DATE_NO");

	final static UI_Elements	COST_CENTER_INFO_YES											= UIFactory.getElements("COST_CENTER_INFO_YES");
	final static UI_Elements	COST_CENTER_INFO_NO												= UIFactory.getElements("COST_CENTER_INFO_NO");

	final static UI_Elements	ALLOW_BUYER_TO_MODIFY_COST_CENTER_INFO_YES						= UIFactory.getElements("ALLOW_BUYER_TO_MODIFY_COST_CENTER_INFO_YES");
	final static UI_Elements	ALLOW_BUYER_TO_MODIFY_COST_CENTER_INFO_NO						= UIFactory.getElements("ALLOW_BUYER_TO_MODIFY_COST_CENTER_INFO_NO");

	final static UI_Elements	DISPLAY_ACCOUNTING_INFO_YES										= UIFactory.getElements("DISPLAY_ACCOUNTING_INFO_YES");
	final static UI_Elements	DISPLAY_ACCOUNTING_INFO_NO										= UIFactory.getElements("DISPLAY_ACCOUNTING_INFO_NO");

	final static UI_Elements	REQUIRED_ACCOUNTING_INFO_YES									= UIFactory.getElements("REQUIRED_ACCOUNTING_INFO_YES");
	final static UI_Elements	REQUIRED_ACCOUNTING_INFO_NO										= UIFactory.getElements("REQUIRED_ACCOUNTING_INFO_NO");

	final static UI_Elements	REQ_PUNCHOUT_ITEM_CATEGORY_WARNING								= UIFactory.getElements("REQ_PUNCHOUT_ITEM_CATEGORY_WARNING");
	final static UI_Elements	REQ_PUNCHOUT_ITEM_CATEGORY_BLOCK								= UIFactory.getElements("REQ_PUNCHOUT_ITEM_CATEGORY_BLOCK");

	final static UI_Elements	REQ_PUNCHOUT_COPY_PREVENTION_WARNING							= UIFactory.getElements("REQ_PUNCHOUT_COPY_PREVENTION_WARNING");
	final static UI_Elements	REQ_PUNCHOUT_COPY_PREVENTION_BLOCK								= UIFactory.getElements("REQ_PUNCHOUT_COPY_PREVENTION_BLOCK");

	final static UI_Elements	ALLOW_OVERRIDE_GLACCOUNT_YES									= UIFactory.getElements("ALLOW_OVERRIDE_GLACCOUNT_YES");
	final static UI_Elements	ALLOW_OVERRIDE_GLACCOUNT_NO										= UIFactory.getElements("ALLOW_OVERRIDE_GLACCOUNT_NO");

	final static UI_Elements	ASSIGN_BUYER_REQUIRED											= UIFactory.getElements("ASSIGN_BUYER_REQUIRED");
	final static UI_Elements	ASSIGN_BUYER_OPTIONAL											= UIFactory.getElements("ASSIGN_BUYER_OPTIONAL");
	final static UI_Elements	ASSIGN_BUYER_HIDDEN												= UIFactory.getElements("ASSIGN_BUYER_HIDDEN");

	final static UI_Elements	BUYER_DEFAULT_BUYER												= UIFactory.getElements("BUYER_DEFAULT_BUYER");
	final static UI_Elements	BUYER_DEFAULT_BUYER_GROUP										= UIFactory.getElements("BUYER_DEFAULT_BUYER_GROUP");

	final static UI_Elements	PO_TO_REQ_TAGGING_YES											= UIFactory.getElements("PO_TO_REQ_TAGGING_YES");
	final static UI_Elements	PO_TO_REQ_TAGGING_NO											= UIFactory.getElements("PO_TO_REQ_TAGGING_NO");

	/* Auto fork req */
	final static UI_Elements	CATEGORY_BASED_WORKFLOW_YES										= UIFactory.getElements("CATEGORY_BASED_WORKFLOW_YES");
	final static UI_Elements	CATEGORY_BASED_WORKFLOW_NO										= UIFactory.getElements("CATEGORY_BASED_WORKFLOW_NO");

	final static UI_Elements	REQ_FORKING_YES													= UIFactory.getElements("REQ_FORKING_YES");
	final static UI_Elements	REQ_FORKING_NO													= UIFactory.getElements("REQ_FORKING_NO");

	final static UI_Elements	FORKING_CATERIA_PRICE_TYPE										= UIFactory.getElements("FORKING_CATERIA_PRICE_TYPE");

	final static UI_Elements	FORKING_CATERIA_CATEGORIES										= UIFactory.getElements("FORKING_CATERIA_CATEGORIES");
	final static UI_Elements	SOURCING_STATUS_QUOTED_BY_SUPPLIER								= UIFactory.getElements("SOURCING_STATUS_QUOTED_BY_SUPPLIER");
	final static UI_Elements	SOURCING_STATUS_ESTIMATED_PRICE									= UIFactory.getElements("SOURCING_STATUS_ESTIMATED_PRICE");
	final static UI_Elements	SOURCING_STATUS_NEED_A_QUOTE									= UIFactory.getElements("SOURCING_STATUS_NEED_A_QUOTE");

	final static UI_Elements	SAVE_BUTTON														= UIFactory.getElements("SAVE_BUTTON");
	final static UI_Elements	CANCEL_BUTTON_REQ_SETTING										= UIFactory.getElements("CANCEL_BUTTON_REQ_SETTING");
	final static UI_Elements	SUCCESS_MSG														= UIFactory.getElements("SUCCESS_MSG");

	UI_Elements					RADIO_BUTTON_ADD_DISBURSEMENT_AS_SETTLEMENT_VIA_OPTION_YES		= UIFactory
		.getElements("RADIO_BUTTON_ADD_DISBURSEMENT_AS_SETTLEMENT_VIA_OPTION_YES");
	UI_Elements					RADIO_BUTTON_ADD_DISBURSEMENT_AS_SETTLEMENT_VIA_OPTION_NO		= UIFactory
		.getElements("RADIO_BUTTON_ADD_DISBURSEMENT_AS_SETTLEMENT_VIA_OPTION_NO");
	UI_Elements					RADIO_BUTTON_SEND_PO_TO_SUPPLIER_YES							= UIFactory.getElements("RADIO_BUTTON_SEND_PO_TO_SUPPLIER_YES");
	UI_Elements					RADIO_BUTTON_SEND_PO_TO_SUPPLIER_NO								= UIFactory.getElements("RADIO_BUTTON_SEND_PO_TO_SUPPLIER_NO");

	UI_Elements					CHECKBOX_QUOTED_BY_SUPPLIER_SOURCING_STATUS_REQ_SETTING_PAGE	= UIFactory
		.getElements("CHECKBOX_QUOTED_BY_SUPPLIER_SOURCING_STATUS_REQ_SETTING_PAGE");
	UI_Elements					CHECKBOX_ESTIMATED_PRICE_SOURCING_STATUS_REQ_SETTING_PAGE		= UIFactory
		.getElements("CHECKBOX_ESTIMATED_PRICE_SOURCING_STATUS_REQ_SETTING_PAGE");

	UI_Elements					CHECKBOX_NEED_A_QUOTE_SOURCING_STATUS_REQ_SETTING_PAGE			= UIFactory.getElements("CHECKBOX_NEED_A_QUOTE_SOURCING_STATUS_REQ_SETTING_PAGE");

	final static UI_Elements	ALLOW_REQUESTER_TO_SUGGEST_SUPPLIER_FOR_BUYER_REVIEW_YES		= UIFactory.getElements("ALLOW_REQUESTER_TO_SUGGEST_SUPPLIER_FOR_BUYER_REVIEW_YES");
	final static UI_Elements	ALLOW_REQUESTER_TO_SUGGEST_SUPPLIER_FOR_BUYER_REVIEW_NO			= UIFactory.getElements("ALLOW_REQUESTER_TO_SUGGEST_SUPPLIER_FOR_BUYER_REVIEW_NO");
	final static UI_Elements	REQUIRED_BY_DATE_AUTO_CALCULATED_AS_LEAD_TIME_IN_CATALOG_YES	= UIFactory
		.getElements("REQUIRED_BY_DATE_AUTO_CALCULATED_AS_LEAD_TIME_IN_CATALOG_YES");

	final static UI_Elements	REQUIRED_BY_DATE_AUTO_CALCULATED_AS_LEAD_TIME_IN_CATALOG_NO		= UIFactory
		.getElements("REQUIRED_BY_DATE_AUTO_CALCULATED_AS_LEAD_TIME_IN_CATALOG_NO");
	final static UI_Elements	ALLOW_SPLIT_DELIVERY_LOCATION_AT_ITEM_LEVEL_YES					= UIFactory.getElements("ALLOW_SPLIT_DELIVERY_LOCATION_AT_ITEM_LEVEL_YES");
	final static UI_Elements	ALLOW_SPLIT_DELIVERY_LOCATION_AT_ITEM_LEVEL_NO					= UIFactory.getElements("ALLOW_SPLIT_DELIVERY_LOCATION_AT_ITEM_LEVEL_NO");
	final static UI_Elements	TEXTBOX_ALERT_USER_WHEN_SHOPPINGCART_BEYOND_QUANTITY			= UIFactory.getElements("TEXTBOX_ALERT_USER_WHEN_SHOPPINGCART_BEYOND_QUANTITY");

	public String fillRequisitionNumberFormat(WebDriver driver, String testCaseName, String reqNumberFormat) throws ActionBotException;

	public String getRequisitionNumberFormat(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer fillSequenceNumberStartsAt(WebDriver driver, String testCaseName, int seqNoStartsAt) throws ActionBotException;

	public Integer getSequenceNumberStartsAt(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer fillSequenceNumberEndsAt(WebDriver driver, String testCaseName, int seqNoEndsAt) throws ActionBotException;

	public Integer getSequenceNumberEndsAt(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillRequisitionNameFormat(WebDriver driver, String testCaseName, String reqNameFormat) throws ActionBotException;

	public String getRequisitionNameFormat(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillMostFreqentlySearchedItems(WebDriver driver, String testCaseName, String mostFrequentlySearchedItems) throws ActionBotException;

	public String getMostFreqentlySearchedItems(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer fillItemQuantityThreshold(WebDriver driver, String testCaseName, int itemQuantityThreshold) throws ActionBotException;

	public Integer getItemQuantityThreshold(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnOrderFreeTextItemsAlways(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowRequetserToOrderFreeTextItemsType(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnOrderFreeTextItemsNever(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnOrderFreeTextItemsPermissionBased(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnFreeTextItemsRequestedWithoutSelectingCategory_yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowFreeTextItemsRequestedWithoutSelectingCategoryOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnFreeTextItemsRequestedWithoutSelectingCategory_no(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnReqToBeSubmittedWithoutRequiredByDate_yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnReqToBeSubmittedWithoutRequiredByDate_no(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowReqToBeSubmittedWithoutRequiredByDateOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowBuyerToModifyRequiredByDate_yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowBuyerToModifyRequiredByDate_no(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowBuyerToModifyRequiredByDateOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowReqToBeSubmittedWithoutCostCenterInfo_yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowReqToBeSubmittedWithoutCostCenterInfo_no(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowReqToBeSubmittedWithoutCostCenterInfoOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowBuyerToModifyCostCenterInfo_yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowBuyerToModifyCostCenterInfo_no(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowBuyerToModifyCostCenterInfoOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnDisplayAccountingInfoToRequester_yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnDisplayAccountingInfoToRequester_no(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getDisplayAccountingInfoToRequesterOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnRequesterIsRequiredToProvideAccountingInfo_yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnRequesterIsRequiredToProvideAccountingInfo_no(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getRequesterIsRequiredToProvideAccountingInfoOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowRequesterToOverrideDefaultGLAccount_yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowRequesterToOverrideDefaultGLAccount_no(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowRequesterToOverrideDefaultGLAccountOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnRequesterRequiredToAssignBuyer_Required(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnRequesterRequiredToAssignBuyer_Optional(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnRequesterRequiredToAssignBuyer_Hidden(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getRequesterRequiredToAssignBuyerOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnApplyCategoryBasedWorkflow_yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnApplyCategoryBasedWorkflow_no(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getApplyCategoryBasedWorkflowOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnEnableRequisitionForking_yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnEnableRequisitionForking_no(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean getEnableRequisitionForkingOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnSplitReqAsPerCategories(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnSplitReqAsPerPriceType(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSplitReqTypeOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSourcingStatus_QuotedBySupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSourcingStatus_EstimatedPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSourcingStatus_NeedAQuote(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAddDisbursementAsSettlementViaOptionYes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAddDisbursementAsSettlementViaOptionNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnSendPOToSupplierOptionYes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnSendPOToSupplierOptionNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSendPOToSupplierOptionYesEnabled(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSendPOToSupplierOptionNoEnabled(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnQuotedBySupplierSourcingStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEstimatedPriceSourcingStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnNeedAQuoteSourcingStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isQuotedBySupplierSourcingStatusSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEstimatedPriceSourcingStatusSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNeedAQuoteSourcingStatusSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnBuyerDefaultOption_Buyer(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnBuyerDefaultOption_BuyerGroup(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnPoToReqTagging_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnPoToReqTagging_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowRequesterToSuggestSupplierForBuyersReview_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowRequesterToSuggestSupplierForBuyersReview_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnRequiredByDateAutoCalculatedAsPerLeadTimeInCatalog_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnRequiredByDateAutoCalculatedAsPerLeadTimeInCatalog_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean allowSplitDeliveryLocationAtItemLevel_Yes(WebDriver driver, String testCaseName) throws ActionBotException;


	public boolean allowSplitDeliveryLocationAtItemLevel_No(WebDriver driver, String testCaseName) throws ActionBotException;
	public Integer enterQuantityToAlertUserWhenShoppingCartIsBeyondQuantity(WebDriver driver, Integer quantity) throws ActionBotException;

}
