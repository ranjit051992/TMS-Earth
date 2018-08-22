package com.zycus.automation.eproc.pageobjects.pages.purchaseordertobegenerated;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPurchaseOrderToBeGenerated
{

	static UI_Elements	ITEM_NAME_ON_SUGGESTED_PO_PAGE							= UIFactory.getElements("ITEM_NAME_ON_SUGGESTED_PO_PAGE");
	static UI_Elements	CHECKBOX_SUBMIT_PO_FOR_PROCESSING						= UIFactory.getElements("CHECKBOX_SUBMIT_PO_FOR_PROCESSING");
	static UI_Elements	STATUS_PROCESS											= UIFactory.getElements("STATUS_PROCESS");
	static UI_Elements	BUTTON_NOTES_ON_SUGGEESTED_PO							= UIFactory.getElements("BUTTON_NOTES_ON_SUGGEESTED_PO");
	static UI_Elements	TEXTBOX_NOTES_ON_SUGGESTED_PO							= UIFactory.getElements("TEXTBOX_NOTES_ON_SUGGESTED_PO");
	static UI_Elements	BUTTON_SAVE_NOTES_ON_SUGGESTED_PO						= UIFactory.getElements("BUTTON_SAVE_NOTES_ON_SUGGESTED_PO");
	static UI_Elements	LINK_ADD_ATTACHMENTS_ON_SUGGESTED_PO					= UIFactory.getElements("LINK_ADD_ATTACHMENTS_ON_SUGGESTED_PO");
	static UI_Elements	LABEL_PO_INFO_AT_PREVIEW_PO_FROM_PO_TO_BE_GENERATED		= UIFactory.getElements("LABEL_PO_INFO_AT_PREVIEW_PO_FROM_PO_TO_BE_GENERATED");
	static UI_Elements	LABEL_PO_NO_FORMAT_CONFIG_ON_PO_TO_BE_GENERATED_PAGE	= UIFactory.getElements("LABEL_PO_NO_FORMAT_CONFIG_ON_PO_TO_BE_GENERATED_PAGE");
	static UI_Elements	ICON_COLLAPSE_AND_EXPAND								= UIFactory.getElements("ICON_COLLAPSE_AND_EXPAND");
	static UI_Elements	BUTTON_SUBMIT_PO_FOR_PROCESSING_SAWATER					= UIFactory.getElements("BUTTON_SUBMIT_PO_FOR_PROCESSING_SAWATER");

	static UI_Elements	BUTTON_SUBMIT_PO_FOR_PROCESSING							= UIFactory.getElements("BUTTON_SUBMIT_PO_FOR_PROCESSING");
	UI_Elements			PROGRESSING_DIV_CONVERT_PO_BUYERS_DESK					= UIFactory.getElements("PROGRESSING_DIV_CONVERT_PO_BUYERS_DESK");

	//SA Water
	UI_Elements			BUTTON_SAVE_PO_AND_CONTINUE								= UIFactory.getElements("BUTTON_SAVE_PO_AND_CONTINUE");

	UI_Elements			RADIO_YES_RECOMMDATION_PROVIDED_FURTHER_DETAILS			= UIFactory.getElements("RADIO_YES_RECOMMDATION_PROVIDED_FURTHER_DETAILS");
	UI_Elements			RADIO_NO_RECOMMDATION_PROVIDED_FURTHER_DETAILS			= UIFactory.getElements("RADIO_NO_RECOMMDATION_PROVIDED_FURTHER_DETAILS");
	UI_Elements			RADIO_NA_RECOMMDATION_PROVIDED_FURTHER_DETAILS			= UIFactory.getElements("RADIO_NA_RECOMMDATION_PROVIDED_FURTHER_DETAILS");
	UI_Elements			RADIO_OBTAINED_BY_AO_QUOTE_FURTHER_DETAILS				= UIFactory.getElements("RADIO_OBTAINED_BY_AO_QUOTE_FURTHER_DETAILS");
	UI_Elements			RADIO_OBTAINED_BUT_TC_QUOTE_FURTHER_DETAILS				= UIFactory.getElements("RADIO_OBTAINED_BUT_T&C_QUOTE_FURTHER_DETAILS");
	UI_Elements			RADIO_NA_QUOTE_FURTHER_DETAILS							= UIFactory.getElements("RADIO_NA_QUOTE_FURTHER_DETAILS");
	UI_Elements			RADIO_YES_CMS_REGISTERED_FURTHER_DETAILS				= UIFactory.getElements("RADIO_YES_CMS_REGISTERED_FURTHER_DETAILS");
	UI_Elements			RADIO_NO_CMS_REGISTERED_FURTHER_DETAILS					= UIFactory.getElements("RADIO_NO_CMS_REGISTERED_FURTHER_DETAILS");
	UI_Elements			RADIO_NA_NOT_ON_SITE_CMS_REGISTERED_FURTHER_DETAILS		= UIFactory.getElements("RADIO_NA_NOT_ON_SITE_CMS_REGISTERED_FURTHER_DETAILS");
	UI_Elements			RADIO_NA_SUPPLIER_EXEMPT_CMS_REGISTERED_FURTHER_DETAILS	= UIFactory.getElements("RADIO_NA_SUPPLIER_EXEMPT_CMS_REGISTERED_FURTHER_DETAILS");
	UI_Elements			RADIO_YES_PURCHASE_WITHOUT_PROCCUREMENT_FURTHER_DETAILS	= UIFactory.getElements("RADIO_YES_PURCHASE_WITHOUT_PROCCUREMENT_FURTHER_DETAILS");
	UI_Elements			RADIO_NO_PURCHASE_WITHOUT_PROCCUREMENT_FURTHER_DETAILS	= UIFactory.getElements("RADIO_NO_PURCHASE_WITHOUT_PROCCUREMENT_FURTHER_DETAILS");
	UI_Elements			RADIO_EMAIL_PO_MEDIUM_FURTHER_DETAILS					= UIFactory.getElements("RADIO_EMAIL_PO_MEDIUM_FURTHER_DETAILS");
	UI_Elements			RADIO_PRINT_PO_MEDIUM_FURTHER_DETAILS					= UIFactory.getElements("RADIO_PRINT_PO_MEDIUM_FURTHER_DETAILS");
	UI_Elements			RADIO_FAX_PO_MEDIUM_FURTHER_DETAILS						= UIFactory.getElements("RADIO_FAX_PO_MEDIUM_FURTHER_DETAILS");
	UI_Elements			RADIO_YES_PANEL_APPLY_FURTHER_DETAILS					= UIFactory.getElements("RADIO_YES_PANEL_APPLY_FURTHER_DETAILS");
	UI_Elements			RADIO_NO_PANEL_APPLY_FURTHER_DETAILS					= UIFactory.getElements("RADIO_NO_PANEL_APPLY_FURTHER_DETAILS");
	UI_Elements			DROPDOWN_IS_PO_VALUE_PO_COMPLETED						= UIFactory.getElements("DROPDOWN_IS_PO_VALUE_PO_COMPLETED");
	UI_Elements			DROPDOWN_IS_PO_VALUE_PO_COMPLETED_YES					= UIFactory.getElements("DROPDOWN_IS_PO_VALUE_PO_COMPLETED_YES");
	UI_Elements			DROPDOWN_IS_PO_VALUE_PO_COMPLETED_NO					= UIFactory.getElements("DROPDOWN_IS_PO_VALUE_PO_COMPLETED_NO");

	void clickOnCancelLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnPreviewPoLink(WebDriver driver, String testcaseName, int index) throws ActionBotException;

	void clickOnReqNoLink(WebDriver driver, String testcaseName, int index) throws ActionBotException;

	void clickOnSavePosAsDraft(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnSubmitPoForProcessing(WebDriver driver, String testcaseName) throws ActionBotException;

	void ClikOnPurchaseOrderToBeGeneratedCheckBox(WebDriver driver, String testcaseName, int index) throws ActionBotException;

	public List<WebElement> getListOfAllSuggestedPOCheckboxes(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getListOfItems(WebDriver driver, String testCaseName) throws ActionBotException;

	String getPurchaseOrderToBeGeneratedAction(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderToBeGeneratedBu(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderToBeGeneratedDeliverTo(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderToBeGeneratedDeliverydate(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderToBeGeneratedExchangeRate(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderToBeGeneratedItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderToBeGeneratedPoTotal(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderToBeGeneratedQty(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderToBeGeneratedReqNo(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderToBeGeneratedSuggestedPOs(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderToBeGeneratedSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderToBeGeneratedUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getPurchaseOrderTotalPrices(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void clickOnNotes(WebDriver driver, String testcaseName) throws ActionBotException;

	public String enterNotes(WebDriver driver, String testcaseName, String notes) throws ActionBotException;

	public void clickOnSaveNotes(WebDriver driver, String testcaseName) throws ActionBotException;

	public void clickOnAddAttachments(WebDriver driver, String testcaseName) throws ActionBotException;

	public boolean isPOInfoAtPreviewPOPresent(WebDriver driver, String testcaseName) throws ActionBotException;

	public boolean isPONOFormatConfigPresentCorrectly(WebDriver driver, String testcaseName) throws ActionBotException;

	public void clickOnCollapseAndExpandIcon(WebDriver driver, String testcaseName) throws ActionBotException;

	public boolean isSubmitPOForProcessingPresent(WebDriver driver, String testcaseName) throws ActionBotException;

	void clickOnSavePoAndContinue(WebDriver driver, String testcaseName) throws ActionBotException;

	String clickOnRecomendationMemoProvided(WebDriver driver, String testcaseName, String recommendationMemoProvided) throws ActionBotException;

	String clickOnquote(WebDriver driver, String testcaseName, String quote) throws ActionBotException;

	String clickOncmsRegistered(WebDriver driver, String testcaseName, String cmsRegistered) throws ActionBotException;

	String clickOnpoMedium(WebDriver driver, String testcaseName, String poMedium) throws ActionBotException;

	String clickOnpanelApply(WebDriver driver, String testcaseName, String panelApply) throws ActionBotException;

	String setIsPOValue(WebDriver driver, String testcaseName, String isPOValue) throws ActionBotException;

	String clickOnPurchaseProcurement(WebDriver driver, String testcaseName, String proccurementInvolvement) throws ActionBotException;

}
