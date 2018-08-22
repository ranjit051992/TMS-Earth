package com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageCustomizeSettings
{
	final static UI_Elements	REQUISITION_LINK							= UIFactory.getElements("REQUISITION_LINK");
	final static UI_Elements	REPLY_TO_ADDRESS_FIELDS						= UIFactory.getElements("REPLY_TO_ADDRESS_FIELDS");
	final static UI_Elements	EPROC_PURCHASE_ORDER_NUMBER_FORMAT_LEVEL	= UIFactory.getElements("EPROC_PURCHASE_ORDER_NUMBER_FORMAT_LEVEL");
	final static UI_Elements	EPROC_PURCHASE_ORDER_SEQUENCE_NO_ENDS_AT	= UIFactory.getElements("EPROC_PURCHASE_ORDER_SEQUENCE_NO_ENDS_AT");
	final static UI_Elements	EPROC_PURCHASE_ORDER_SEQUENCE_NO_STARTS_AT	= UIFactory.getElements("EPROC_PURCHASE_ORDER_SEQUENCE_NO_STARTS_AT");
	final static UI_Elements	EPROC_PURCHASE_ORDER_FORMAT					= UIFactory.getElements("EPROC_PURCHASE_ORDER_FORMAT");
	final static UI_Elements	PO_SETTINGS_SAVE_BUTTON						= UIFactory.getElements("PO_SETTINGS_SAVE_BUTTON");
	final static UI_Elements	BUYERS_DESK_LINK							= UIFactory.getElements("BUYERS_DESK_LINK");
	final static UI_Elements	PURCHASE_ORDER_LINK							= UIFactory.getElements("PURCHASE_ORDER_LINK");
	final static UI_Elements	RECEIPTS_LINK								= UIFactory.getElements("RECEIPTS_LINK");
	final static UI_Elements	INVOICES_LINK								= UIFactory.getElements("INVOICES_LINK");
	final static UI_Elements	SUPPLIER_NETWORK_LINK						= UIFactory.getElements("SUPPLIER_NETWORK_LINK");
	final static UI_Elements	CATALOG_LINK								= UIFactory.getElements("CATALOG_LINK");
	final static UI_Elements	WORKFLOW_LINK								= UIFactory.getElements("WORKFLOW_LINK");
	final static UI_Elements	MASTER_DATA_LINK							= UIFactory.getElements("MASTER_DATA_LINK");
	final static UI_Elements	P_CARD_LINK									= UIFactory.getElements("P_CARD_LINK");
	final static UI_Elements	COST_BOOKING_LINK							= UIFactory.getElements("COST_BOOKING_LINK");
	final static UI_Elements	EFORM_LINK									= UIFactory.getElements("EFORM_LINK");
	final static UI_Elements	INTEGRATION_LINK							= UIFactory.getElements("INTEGRATION_LINK");
	final static UI_Elements	GENERAL_SETTINGS_LINK						= UIFactory.getElements("GENERAL_SETTINGS_LINK");
	final static UI_Elements	DELIVERY_SETTINGS_LINK						= UIFactory.getElements("DELIVERY_SETTINGS_LINK");
	final static UI_Elements	SUPPLIER_ON_BOARDING_LINK					= UIFactory.getElements("SUPPLIER_ON_BOARDING_LINK");
	final static UI_Elements	APPROVAL_WORKFLOW_LINK						= UIFactory.getElements("APPROVAL_WORKFLOW_LINK");
	final static UI_Elements	OTHER_NOTIFICATIONS_LINK					= UIFactory.getElements("OTHER_NOTIFICATIONS_LINK");
	final static UI_Elements	DOCUMENT_INFORMATION_LINK					= UIFactory.getElements("DOCUMENT_INFORMATION_LINK");
	final static UI_Elements	RECEIVING_GENERAL_SETTINGS_LINK				= UIFactory.getElements("RECEIVING_GENERAL_SETTINGS_LINK");
	final static UI_Elements	DESKTOP_RECEIVING_LINK						= UIFactory.getElements("DESKTOP_RECEIVING_LINK");
	final static UI_Elements	CENTRAL_RECEIVING_LINK						= UIFactory.getElements("CENTRAL_RECEIVING_LINK");
	final static UI_Elements	TOLERANCE_LINK								= UIFactory.getElements("TOLERANCE_LINK");
	final static UI_Elements	MATCHING_LINK								= UIFactory.getElements("MATCHING_LINK");
	final static UI_Elements	PAYMENTS_LINK								= UIFactory.getElements("PAYMENTS_LINK");
	final static UI_Elements	ALLOW_EDITING_AUTO_GENERATED_PO_NUMBER_NO	= UIFactory.getElements("ALLOW_EDITING_AUTO_GENERATED_PO_NUMBER_NO");
	final static UI_Elements	PROJECT_CUSTOMIZE_LINK						= UIFactory.getElements("PROJECT_CUSTOMIZE_LINK");
	final static UI_Elements	ALLOW_EDITING_AUTO_GENERATED_PO_NUMBER_YES	= UIFactory.getElements("ALLOW_EDITING_AUTO_GENERATED_PO_NUMBER_YES");
	final static UI_Elements	LINK_BACK_TO_CUSTOMIZE_MAIN_PAGE			= UIFactory.getElements("LINK_BACK_TO_CUSTOMIZE_MAIN_PAGE");

	final static UI_Elements	REQUIRED_BY_DATE_YES						= UIFactory.getElements("REQUIRED_BY_DATE_YES");

	final static UI_Elements	REQUIRED_BY_DATE_NO							= UIFactory.getElements("REQUIRED_BY_DATE_NO");

	final static UI_Elements	LINK_CUSTOMIZE_MASTER_DATA					= UIFactory.getElements("LINK_CUSTOMIZE_MASTER_DATA");
	final static UI_Elements	LINK_GL_RULES_MAP_MASTERS_PAGE				= UIFactory.getElements("LINK_GL_RULES_MAP_MASTERS_PAGE");
	final static UI_Elements	CONTROL_LINK								= UIFactory.getElements("CONTROL_LINK");

	public void clickOnAllowEditAutogeneratedSettingsNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAllowEditAutogeneratedSettingsYes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApprovalWorkflowLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBuyersDeskLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCatalogLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCentralReceivingLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCostBookingLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeliverySettingsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDesktopReceivingLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDocumentInformationLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEformLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnGeneralSettingsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnIntegrationLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnInvoicesLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnMasterDataLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnMatchingLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOtherNotificationsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPaymentsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPCardLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnProjectCustomizeLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPurchaseOrderLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReceiptsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReceivingGeneralSettingsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRequisitionLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveButtom(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSupplierNetworkLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSupplierOnBoardingLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnToleranceLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnWorkflowLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAllowEditingAutogeneratedPoNoYes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAllowUserToChangeLevelToUsePoNoFormat(WebDriver driver, String testCaseName, String text) throws ActionBotException;

	public boolean isAllowUserToChangePoNoFormat(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isReplyToAddressFieldPresent(WebDriver driver, String testCaseName, String to) throws ActionBotException;

	public boolean isAllowUserToChangePoSeqEndAtFormat(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAllowUserToChangePoSeqStartAtFormat(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBackLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReqiuredByDateYes(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReqiuredByDateNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCustomizeLinkMasterData(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnGLRulesMap(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnControlLink(WebDriver driver, String testCaseName) throws ActionBotException;

}