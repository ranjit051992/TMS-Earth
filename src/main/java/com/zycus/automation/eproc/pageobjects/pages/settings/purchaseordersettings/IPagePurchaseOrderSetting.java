package com.zycus.automation.eproc.pageobjects.pages.settings.purchaseordersettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPagePurchaseOrderSetting
{
	final static String			ALL																		= "ALL";
	final static String			NONE																	= "NONE";
	final static String			SELECT																	= "SELECT";
	final static String			SMALLER																	= "SMALLER";
	final static String			LARGER																	= "LARGER";

	final static UI_Elements	EPROC_PURCHASE_ORDER_FORMAT												= UIFactory.getElements("EPROC_PURCHASE_ORDER_FORMAT");
	final static UI_Elements	EPROC_PURCHASE_ORDER_SEQUENCE_NO_STARTS_AT								= UIFactory.getElements("EPROC_PURCHASE_ORDER_SEQUENCE_NO_STARTS_AT");
	final static UI_Elements	EPROC_PURCHASE_ORDER_SEQUENCE_NO_ENDS_AT								= UIFactory.getElements("EPROC_PURCHASE_ORDER_SEQUENCE_NO_ENDS_AT");
	final static UI_Elements	EPROC_PURCHASE_ORDER_AUTO_NAME_FORMAT									= UIFactory.getElements("EPROC_PURCHASE_ORDER_AUTO_NAME_FORMAT");
	final static UI_Elements	DISPLAY_OF_PURCHASE_ORDER												= UIFactory.getElements("DISPLAY_OF_PURCHASE_ORDER");
	final static UI_Elements	EPROC_PURCHASE_ORDER_ITEM_PRICE_TOLERANCE_val							= UIFactory.getElements("EPROC_PURCHASE_ORDER_ITEM_PRICE_TOLERANCE_val");
	final static UI_Elements	EPROC_PURCHASE_ORDER_ITEM_QUANTITY_TOLERANCE_val						= UIFactory.getElements("EPROC_PURCHASE_ORDER_ITEM_QUANTITY_TOLERANCE_val");
	final static UI_Elements	AUTO_GENERATE_LINE_ITEM_NUMBERS_ON_PO_YES								= UIFactory.getElements("AUTO_GENERATE_LINE_ITEM_NUMBERS_ON_PO_YES");

	final static UI_Elements	AUTO_GENERATE_LINE_ITEM_NUMBERS_ON_PO_NO								= UIFactory.getElements("AUTO_GENERATE_LINE_ITEM_NUMBERS_ON_PO_NO");

	final static UI_Elements	ALLOW_MODIFICATION_OF_ITEM_CLASSIFICATION_CODE_YES						= UIFactory
		.getElements("ALLOW_MODIFICATION_OF_ITEM_CLASSIFICATION_CODE_YES");
	final static UI_Elements	ALLOW_MODIFICATION_OF_ITEM_CLASSIFICATION_CODE_NO						= UIFactory
		.getElements("ALLOW_MODIFICATION_OF_ITEM_CLASSIFICATION_CODE_NO");

	final static UI_Elements	ALLOW_MANUAL_ORDERS_RELEASED_WITHOUT_DELIVERY_DATE_YES					= UIFactory
		.getElements("ALLOW_MANUAL_ORDERS_RELEASED_WITHOUT_DELIVERY_DATE_YES");

	final static UI_Elements	ALLOW_MANUAL_ORDERS_RELEASED_WITHOUT_DELIVERY_DATE_NO					= UIFactory
		.getElements("ALLOW_MANUAL_ORDERS_RELEASED_WITHOUT_DELIVERY_DATE_NO");

	final static UI_Elements	RELEASE_ORDERS_IMMEADIATELY_YES											= UIFactory.getElements("RELEASE_ORDERS_IMMEADIATELY_YES");

	final static UI_Elements	RELEASE_ORDERS_IMMEADIATELY_NO											= UIFactory.getElements("RELEASE_ORDERS_IMMEADIATELY_NO");

	final static UI_Elements	EPROC_PURCHASE_ORDER_AUTOMATIC_PARK_TYPE								= UIFactory.getElements("EPROC_PURCHASE_ORDER_AUTOMATIC_PARK_TYPE");

	final static UI_Elements	EPROC_PURCHASE_ORDER_AUTOMATIC_PARK_VALUE_control_DAYS					= UIFactory
		.getElements("EPROC_PURCHASE_ORDER_AUTOMATIC_PARK_VALUE_control_DAYS");

	final static UI_Elements	ALLOW_EMAILING_PO_TO_OTHER_THAN_SUPPLIERS_PO_CONTACT_YES				= UIFactory
		.getElements("ALLOW_EMAILING_PO_TO_OTHER_THAN_SUPPLIERS_PO_CONTACT_YES");

	final static UI_Elements	ALLOW_EMAILING_PO_TO_OTHER_THAN_SUPPLIERS_PO_CONTACT_NO					= UIFactory
		.getElements("ALLOW_EMAILING_PO_TO_OTHER_THAN_SUPPLIERS_PO_CONTACT_NO");
	final static UI_Elements	ALLOW_EMAILING_PO_TO_USERS_OUTSIDE_COMPANY_YES							= UIFactory.getElements("ALLOW_EMAILING_PO_TO_USERS_OUTSIDE_COMPANY_YES");
	final static UI_Elements	ALLOW_EMAILING_PO_TO_USERS_OUTSIDE_COMPANY_NO							= UIFactory.getElements("ALLOW_EMAILING_PO_TO_USERS_OUTSIDE_COMPANY_NO");

	final static UI_Elements	ALLOW_TO_CHANGE_DEFAULT_SUPPLIER_CURRENCY_ON_PO_YES						= UIFactory
		.getElements("ALLOW_TO_CHANGE_DEFAULT_SUPPLIER_CURRENCY_ON_PO_YES");

	final static UI_Elements	ALLOW_TO_CHANGE_DEFAULT_SUPPLIER_CURRENCY_ON_PO_NO						= UIFactory
		.getElements("ALLOW_TO_CHANGE_DEFAULT_SUPPLIER_CURRENCY_ON_PO_NO");

	final static UI_Elements	ALLOW_TO_CHANGE_DEFAULT_SUPPLIER_PAYMENT_TERMS_ON_PO_YES				= UIFactory
		.getElements("ALLOW_TO_CHANGE_DEFAULT_SUPPLIER_PAYMENT_TERMS_ON_PO_YES");
	final static UI_Elements	ALLOW_TO_CHANGE_DEFAULT_SUPPLIER_PAYMENT_TERMS_ON_PO_NO					= UIFactory
		.getElements("ALLOW_TO_CHANGE_DEFAULT_SUPPLIER_PAYMENT_TERMS_ON_PO_NO");

	final static UI_Elements	ALLOW_TO_CHANGE_DEFAULT_SUPPLIER_DELIVERY_TERMS_ON_PO_YES				= UIFactory
		.getElements("ALLOW_TO_CHANGE_DEFAULT_SUPPLIER_DELIVERY_TERMS_ON_PO_YES");
	final static UI_Elements	ALLOW_TO_CHANGE_DEFAULT_SUPPLIER_DELIVERY_TERMS_ON_PO_NO				= UIFactory
		.getElements("ALLOW_TO_CHANGE_DEFAULT_SUPPLIER_DELIVERY_TERMS_ON_PO_NO");
	final static UI_Elements	ALLOW_EDITING_AUTO_GENERATED_PO_NUMBER_YES								= UIFactory.getElements("ALLOW_EDITING_AUTO_GENERATED_PO_NUMBER_YES");

	final static UI_Elements	ALLOW_EDITING_AUTO_GENERATED_PO_NUMBER_NO								= UIFactory.getElements("ALLOW_EDITING_AUTO_GENERATED_PO_NUMBER_NO");

	final static UI_Elements	EPROC_PURCHASE_ORDER_NUMBER_FORMAT_LEVEL								= UIFactory.getElements("EPROC_PURCHASE_ORDER_NUMBER_FORMAT_LEVEL");

	final static UI_Elements	SUPPLIER_FOR_PO_DELIVERY_VIA_EMAIL_ALL									= UIFactory.getElements("SUPPLIER_FOR_PO_DELIVERY_VIA_EMAIL_ALL");

	final static UI_Elements	SUPPLIER_FOR_PO_DELIVERY_VIA_EMAIL_NONE									= UIFactory.getElements("SUPPLIER_FOR_PO_DELIVERY_VIA_EMAIL_NONE");

	final static UI_Elements	SUPPLIER_FOR_PO_DELIVERY_VIA_EMAIL_SELECT								= UIFactory.getElements("SUPPLIER_FOR_PO_DELIVERY_VIA_EMAIL_SELECT");

	final static UI_Elements	SUPPLIER_FOR_PO_DELIVERY_VIA_EMAIL_SUPPLIER_EMAIL						= UIFactory
		.getElements("SUPPLIER_FOR_PO_DELIVERY_VIA_EMAIL_SUPPLIER_EMAIL");
	final static UI_Elements	SELECTED_SUPPLIER_EMAIL													= UIFactory.getElements("SELECTED_SUPPLIER_EMAIL");
	final static UI_Elements	REQUIRED_PO_APPROVAL_WHEN_PO_TOTAL_EXCEEDS_SMALLER						= UIFactory
		.getElements("REQUIRED_PO_APPROVAL_WHEN_PO_TOTAL_EXCEEDS_SMALLER");

	final static UI_Elements	REQUIRED_PO_APPROVAL_WHEN_PO_TOTAL_EXCEEDS_LARGER						= UIFactory
		.getElements("REQUIRED_PO_APPROVAL_WHEN_PO_TOTAL_EXCEEDS_LARGER");

	final static UI_Elements	REQUIRED_PO_APPROVAL_WHEN_PO_TOTAL_EXCEEDS_UNIT_PRICE_PER				= UIFactory
		.getElements("REQUIRED_PO_APPROVAL_WHEN_PO_TOTAL_EXCEEDS_UNIT_PRICE_PER");

	final static UI_Elements	REQUIRED_PO_APPROVAL_WHEN_PO_TOTAL_EXCEEDS_UNIT_PRICE_AMOUNT			= UIFactory
		.getElements("REQUIRED_PO_APPROVAL_WHEN_PO_TOTAL_EXCEEDS_UNIT_PRICE_AMOUNT");
	final static UI_Elements	AUTOMATICALLY_GENERATE_ORDER_YES										= UIFactory.getElements("AUTOMATICALLY_GENERATE_ORDER_YES");

	final static UI_Elements	AUTOMATICALLY_GENERATE_ORDER_NO											= UIFactory.getElements("AUTOMATICALLY_GENERATE_ORDER_NO");
	final static UI_Elements	EPROC_PURCHASE_ORDER_DELV_DATE_INTERVAL									= UIFactory.getElements("EPROC_PURCHASE_ORDER_DELV_DATE_INTERVAL");
	final static UI_Elements	EPROC_PURCHASE_ORDER_AUTO_MAILING_LIST									= UIFactory.getElements("EPROC_PURCHASE_ORDER_AUTO_MAILING_LIST");
	final static UI_Elements	PURCHASE_ORDER_DEFAULT_BUYER_FOR_AUTO_PO								= UIFactory.getElements("PURCHASE_ORDER_DEFAULT_BUYER_FOR_AUTO_PO");
	final static UI_Elements	EPROC_PURCHASE_ORDER_DEFAULT_DELIVERY_TERM								= UIFactory.getElements("EPROC_PURCHASE_ORDER_DEFAULT_DELIVERY_TERM");
	final static UI_Elements	EPROC_PURCHASE_ORDER_TERMS_AND_CONDITIONS								= UIFactory.getElements("EPROC_PURCHASE_ORDER_TERMS_AND_CONDITIONS");
	final static UI_Elements	ALLOW_CHANGING_PAYMENT_TERMS_ON_RELEASE_YES								= UIFactory.getElements("ALLOW_CHANGING_PAYMENT_TERMS_ON_RELEASE_YES");
	final static UI_Elements	ALLOW_CHANGING_PAYMENT_TERMS_ON_RELEASE_NO								= UIFactory.getElements("ALLOW_CHANGING_PAYMENT_TERMS_ON_RELEASE_NO");
	final static UI_Elements	EPROC_PURCHASE_ORDER_RELEASE_HOLD_INVOICE_DIFFERENT_PAYMENT_TERM_YES	= UIFactory
		.getElements("EPROC_PURCHASE_ORDER_RELEASE_HOLD_INVOICE_DIFFERENT_PAYMENT_TERM_YES");
	final static UI_Elements	EPROC_PURCHASE_ORDER_RELEASE_HOLD_INVOICE_DIFFERENT_PAYMENT_TERM_NO		= UIFactory
		.getElements("EPROC_PURCHASE_ORDER_RELEASE_HOLD_INVOICE_DIFFERENT_PAYMENT_TERM_NO");
	final static UI_Elements	ALLOW_TO_CHANGE_DELIVERY_TERMS_ON_RELEASE_OF_BPO_YES					= UIFactory
		.getElements("ALLOW_TO_CHANGE_DELIVERY_TERMS_ON_RELEASE_OF_BPO_YES");
	final static UI_Elements	ALLOW_TO_CHANGE_DELIVERY_TERMS_ON_RELEASE_OF_BPO_NO						= UIFactory
		.getElements("ALLOW_TO_CHANGE_DELIVERY_TERMS_ON_RELEASE_OF_BPO_NO");
	final static UI_Elements	BLANKET_ORDER_AMOUNT_INCREASED_UPTO_SMALLER								= UIFactory.getElements("BLANKET_ORDER_AMOUNT_INCREASED_UPTO_SMALLER");
	final static UI_Elements	BLANKET_ORDER_AMOUNT_INCREASED_UPTO_LARGER								= UIFactory.getElements("BLANKET_ORDER_AMOUNT_INCREASED_UPTO_LARGER");
	final static UI_Elements	BLANKET_PO_TOTAL_EXCEEDS_PER											= UIFactory.getElements("BLANKET_PO_TOTAL_EXCEEDS_PER");
	final static UI_Elements	BLANKET_PO_TOTAL_EXCEEDS_AMOUNT											= UIFactory.getElements("BLANKET_PO_TOTAL_EXCEEDS_AMOUNT");

	final static UI_Elements	EPROC_PURCHASE_ORDER_INCREASE_VALIDITY_WITHOUT_APPROVAL					= UIFactory
		.getElements("EPROC_PURCHASE_ORDER_INCREASE_VALIDITY_WITHOUT_APPROVAL");
	final static UI_Elements	PO_SETTINGS_SAVE_BUTTON													= UIFactory.getElements("PO_SETTINGS_SAVE_BUTTON");
	final static UI_Elements	PO_SETTINGS_CANCEL_BUTTON												= UIFactory.getElements("PO_SETTINGS_CANCEL_BUTTON");

	final static UI_Elements	PO_SETTINGS_SAVE_SUCCESSFUL_MSG											= UIFactory.getElements("PO_SETTINGS_SAVE_SUCCESSFUL_MSG");
	final static UI_Elements	SEND_PO_TO_SUPPLIER_FOR_RETROSPECTIVE_PURCHASE_ALWAYS					= UIFactory
		.getElements("SEND_PO_TO_SUPPLIER_FOR_RETROSPECTIVE_PURCHASE_ALWAYS");
	final static UI_Elements	SEND_PO_TO_SUPPLIER_FOR_RETROSPECTIVE_PURCHASE_NEVER					= UIFactory
		.getElements("SEND_PO_TO_SUPPLIER_FOR_RETROSPECTIVE_PURCHASE_NEVER");
	final static UI_Elements	SEND_PO_TO_SUPPLIER_FOR_RETROSPECTIVE_PURCHASE_USER_DECIDE				= UIFactory
		.getElements("SEND_PO_TO_SUPPLIER_FOR_RETROSPECTIVE_PURCHASE_USER_DECIDE");
	final static UI_Elements	RADIO_BUTTON_BPO_AUTH_TYPE_RELEASE_ORDER								= UIFactory.getElements("RADIO_BUTTON_BPO_AUTH_TYPE_RELEASE_ORDER");
	final static UI_Elements	RADIO_BUTTON_BPO_AUTH_TYPE_DIRECT_INVOICING								= UIFactory.getElements("RADIO_BUTTON_BPO_AUTH_TYPE_DIRECT_INVOICING");
	final static UI_Elements	RADIO_BUTTON_BPO_AUTH_TYPE_LET_USER_DECIDE								= UIFactory.getElements("RADIO_BUTTON_BPO_AUTH_TYPE_LET_USER_DECIDE");
	final static UI_Elements	RADIO_BUTTON_SEND_BPO_WITH_RELEASE_ORDER_YES							= UIFactory.getElements("RADIO_BUTTON_SEND_BPO_WITH_RELEASE_ORDER_YES");
	final static UI_Elements	RADIO_BUTTON_SEND_BPO_WITH_RELEASE_ORDER_NO								= UIFactory.getElements("RADIO_BUTTON_SEND_BPO_WITH_RELEASE_ORDER_NO");

	public boolean clickAllowchangingDeliveryTermsOnBPORelease_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickAllowchangingDeliveryTermsOnBPORelease_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowChangingPaymentTermsOnRelease_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowChangingPaymentTermsOnRelease_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowEditingAutoGeneratedPONumber_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowEditingAutoGeneratedPONumber_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowEmailingPOToOtherThanSupplierPOContact_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowEmailingPOToOtherThanSupplierPOContact_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowEmailingPOToUsersOutsideCompany_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowEmailingPOToUsersOutsideCompany_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowManualOrdersReleasedWithoutDeliveryDate_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowManualOrdersReleasedWithoutDeliveryDate_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPOAmmendingLimitationOnItemUnitPricePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowModificationOfItemClassificationCode_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowModificationOfItemClassificationCode_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPOAmmendingLimitationOnItemQuantityPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowToChangeDefaultSupplierCurrencyOnPO_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowToChangeDefaultSupplierCurrencyOnPO_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowToChangeDefaultSupplierDeliveryTermsOnPO_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowToChangeDefaultSupplierDeliveryTermsOnPO_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowToChangeDefaultSupplierPaymentTermsOnPO_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAllowToChangeDefaultSupplierPaymentTermsOnPO_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAutoGenerateLineItemNumbersOnPO_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAutoGenerateLineItemNumbersOnPO_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAutomaticallyGeneratePO_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnAutomaticallyGeneratePO_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnBPOAmountIncreasedUptoLarger(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnBPOAmountIncreasedUptoSmaller(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnHoldInvoiceDifferentPaymentTerm_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnHoldInvoiceDifferentPaymentTerm_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnReleaseOrdersImmediately_No(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnReleaseOrdersImmediately_Yes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnRequiredPOApprovalWhenPOTotalExceedsLarger(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnRequiredPOApprovalWhenPOTotalExceedsSmaller(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRequiredPOApprovalWhenPOTotalExceedsCertainAmountOrPercentagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnWeekdayForAutomaticReleasePO(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public boolean clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickOnSupplierForPODeliveryViaEmailAll(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickSupplierForPODeliveryViaEmailNone(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean clickSupplierForPODeliveryViaEmailSelect(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer fillBPOExceedsPerAmount(WebDriver driver, String testCaseName, int exceedPerAmount) throws ActionBotException;

	public Integer fillBPOIncreaseValidityWithoutApproval(WebDriver driver, String testCaseName, int increaseValidity) throws ActionBotException;

	public Integer fillBPOTotalExceedsPer(WebDriver driver, String testCaseName, int exceedsPer) throws ActionBotException;

	public String fillDefaultBuyerForAutoPO(WebDriver driver, String testCaseName, String buyerName) throws ActionBotException;

	public String fillDefaultPurchseTermsAndConditions(WebDriver driver, String testCaseName, String purchaseTermsAndConditions) throws ActionBotException;

	public Integer fillPOAmendingLimiationOnItemQuantity(WebDriver driver, String testCaseName, int limitedItemQuantity) throws ActionBotException;

	public Integer fillPOAmendingLimiationOnItemUnitPrice(WebDriver driver, String testCaseName, int limitedItemUnitPrice) throws ActionBotException;

	public String fillPOAutoMailingList(WebDriver driver, String testCaseName, String mailingName) throws ActionBotException;

	public Integer fillPODeliveryDateInterval(WebDriver driver, String testCaseName, int poDeliveryDateInterval) throws ActionBotException;

	public String fillPOName(WebDriver driver, String testCaseName, String poName) throws ActionBotException;

	public String fillPONumberFormat(WebDriver driver, String testCaseName, String poNumberFormat) throws ActionBotException;

	public Integer fillReleasePOAutomaticParkValue(WebDriver driver, String testCaseName, int parkValue) throws ActionBotException;

	public Integer fillRequiredPOApprovalWhenPOTotalExceedsUnitPricePer(WebDriver driver, String testCaseName, int exceedUnitPricePer) throws ActionBotException;

	public Integer fillRequiredPOApprovalWhenPOTotalExceedsUnitPricePerAmount(WebDriver driver, String testCaseName, int exceedUnitPricePerAmount) throws ActionBotException;

	public Integer fillSequenceNumberEndsAt(WebDriver driver, String testCaseName, int sequenceNoEndsAt) throws ActionBotException;

	public Integer fillSequenceNumberStartsAt(WebDriver driver, String testCaseName, int sequenceNoStartsAt) throws ActionBotException;

	public String fillSupplierEmail(WebDriver driver, String testCaseName, String supplierEmail) throws ActionBotException;

	public String getAllowchangingDeliveryTermsOnBPORelease_option(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowChangingPaymentTermsOnRelease_option(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowEditingAutoGeneratedPONumber_Option(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowEmailingPOToOtherThanSupplierPOContact_Option(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowEmailingPOToUsersOutsideCompany_Option(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowManualOrdersReleasedWithoutDeliveryDate_Option(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowModificationOfItemClassificationCode_Option(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowToChangeDefaultSupplierCurrencyOnPO_Option(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowToChangeDefaultSupplierDeliveryTermsOnPO_Option(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAllowToChangeDefaultSupplierPaymentTermsOnPO_Option(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAutoGenerateLineItemNumbersOnPO_Option(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAutomaticallyGeneratePO_option(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getBPOAmountIncreasedUpto_Option(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getBPOExceedsPer(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getBPOExceedsPerAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getBPOIncreaseValidityWithoutApproval(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getDefaultBuyerForAutoPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getDefaultPurchseTermsAndConditions(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getDisplayLimitationOfPurchaseOrder(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getHoldInvoiceDifferentPaymentTerm_option(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getPOAmendingLimiationOnItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getPOAmendingLimiationOnItemUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPOAutoMailingList(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getPODeliveryDateInterval(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPOName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPONumberFormat(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getReleaseOrdersImmediately_Option(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getReleasePOAutomaticParkValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getRequiredPOApprovalWhenPOTotalExceedsOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getRequiredPOApprovalWhenPOTotalExceedsUnitPricePer(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getRequiredPOApprovalWhenPOTotalExceedsUnitPricePerAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSelectedDefaultDeliveryTerms(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSelectedLevelToUsePONumberFormat(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSelectedReleasePOAutomaticParkTypeOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getSequenceNumberEndsAt(WebDriver driver, String testCaseName) throws ActionBotException;

	public Integer getSequenceNumberStartsAt(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierEmail(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierForPODeliveryViaOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEditableSupplierDeliveryTerms(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEditableSupplierPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectDefaultDeliveryTerms(WebDriver driver, String testCaseName, String deliveryTermToBeSelected) throws ActionBotException;

	public String selectDisplayLimitationOfPurchaseOrder(WebDriver driver, String testCaseName, String displayLimitation) throws ActionBotException;

	public String selectLevelToUsePONumberFormat(WebDriver driver, String testCaseName, String poNumberFormatLevel) throws ActionBotException;

	public String selectReleasePOAutomaticParkType(WebDriver driver, String testCaseName, String parkType) throws ActionBotException;

	public void clickOnSendPOToSupplierForRetrospectivePurchase_YES(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSendPOToSupplierForRetrospectivePurchase_NO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSendPOToSupplierForRetrospectivePurchase_USER_DECIDE(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBPOAuthTypeReleaseOrder(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBPOAuthTypeDirectInvoicicng(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBPOAuthTypeLetUserDecide(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSendBPOWithReleaseOrderYes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSendBPOWithReleaseOrderNo(WebDriver driver, String testCaseName) throws ActionBotException;

}
