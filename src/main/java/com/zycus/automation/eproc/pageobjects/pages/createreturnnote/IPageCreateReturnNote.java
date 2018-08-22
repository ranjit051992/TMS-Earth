/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createreturnnote;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author sameer.zilpilwar
 *
 */
public interface IPageCreateReturnNote
{
	static UI_Elements	RETURN_NOTE_NUMBER							= UIFactory.getElements("RETURN_NOTE_NUMBER");
	static UI_Elements	TEXTBOX_RETURN_NOTE_DESCRIPTION				= UIFactory.getElements("TEXTBOX_RETURN_NOTE_DESCRIPTION");
	static UI_Elements	TEXTAREA_NOTES								= UIFactory.getElements("TEXTAREA_NOTES");
	static UI_Elements	TEXTBOX_RETURN_MATERIAL_AUTHORIZATION		= UIFactory.getElements("TEXTBOX_RETURN_MATERIAL_AUTHORIZATION");
	static UI_Elements	TEXTBOX_SUPPLIER_CONTACT_RETURN_NOTE		= UIFactory.getElements("TEXTBOX_SUPPLIER_CONTACT_RETURN_NOTE");
	static UI_Elements	TEXTBOX_SUPPLIER_EMAIL						= UIFactory.getElements("TEXTBOX_SUPPLIER_EMAIL");
	static UI_Elements	TEXTBOX_SUPPLIER_ADDRESS_RETURN_NOTE		= UIFactory.getElements("TEXTBOX_SUPPLIER_ADDRESS_RETURN_NOTE");
	static UI_Elements	TEXTAREA_SUPPLIER_COMMENTS					= UIFactory.getElements("TEXTAREA_SUPPLIER_COMMENTS");
	static UI_Elements	BUTTON_SUBMIT_RETURN_NOTE					= UIFactory.getElements("BUTTON_SUBMIT_RETURN_NOTE");
	static UI_Elements	SAVE_AS_DRAFT_RETURN_NOTE					= UIFactory.getElements("SAVE_AS_DRAFT_RETURN_NOTE");
	static UI_Elements	CANCLE_RETURN_NOTE							= UIFactory.getElements("CANCLE_RETURN_NOTE");
	static UI_Elements	CREATE_RETURN_NOTE							= UIFactory.getElements("CREATE_RETURN_NOTE");
	static UI_Elements	CREATE_TAB									= UIFactory.getElements("CREATE_TAB");
	static UI_Elements	RETURN_NOTE_CANNOT_CREATE_ALERT				= UIFactory.getElements("RETURN_NOTE_CANNOT_CREATE_ALERT");
	static UI_Elements	CHECKBOX_SELECT_ALL_RETURN_NOTE_ITEMS		= UIFactory.getElements("CHECKBOX_SELECT_ALL_RETURN_NOTE_ITEMS");
	static UI_Elements	NOTIFY_SUPPLIER_RETURN_NOTE					= UIFactory.getElements("NOTIFY_SUPPLIER_RETURN_NOTE");
	static UI_Elements	LINK_ITEM_NAME_IN_RETURN_NOTE				= UIFactory.getElements("LINK_ITEM_NAME_IN_RETURN_NOTE");
	static UI_Elements	LINK_RETURN_NOTE_RETURNED_QUANTITY			= UIFactory.getElements("LINK_RETURN_NOTE_RETURNED_QUANTITY");
	static UI_Elements	LINK_RETURN_NOTE_REASON_FOR_RETURN			= UIFactory.getElements("LINK_RETURN_NOTE_REASON_FOR_RETURN");
	static UI_Elements	LINK_RETURN_NOTE_RETURN_METHOD				= UIFactory.getElements("LINK_RETURN_NOTE_RETURN_METHOD");
	static UI_Elements	NOTIFY_SUPPLIER_LABLE						= UIFactory.getElements("NOTIFY_SUPPLIER_LABLE");
	static UI_Elements	HEADER_ERROR_MESSAGE_RETURN_NOTE			= UIFactory.getElements("HEADER_ERROR_MESSAGE_RETURN_NOTE");
	static UI_Elements	LABLE_RETURN_NOTE_DESCRIPTION				= UIFactory.getElements("LABLE_RETURN_NOTE_DESCRIPTION");
	static UI_Elements	LABLE_SUPPLIER_EMAIL_RETURN_NOTE			= UIFactory.getElements("LABLE_SUPPLIER_EMAIL_RETURN_NOTE");
	static UI_Elements	LABLE_SUPPLIER_CONTACT_RETURN_NOTE			= UIFactory.getElements("LABLE_SUPPLIER_CONTACT_RETURN_NOTE");
	static UI_Elements	LABLE_RETURN_MATERIAL_AUTHORIZATION			= UIFactory.getElements("LABLE_RETURN_MATERIAL_AUTHORIZATION");
	static UI_Elements	SUPPLIER_NAME_LABLE_RETURN_NOTE				= UIFactory.getElements("SUPPLIER_NAME_LABLE_RETURN_NOTE");
	static UI_Elements	SUPPLIER_NAME_DETAIL_RETURN_NOTE			= UIFactory.getElements("SUPPLIER_NAME_DETAIL_RETURN_NOTE");
	static UI_Elements	LABLE_RETURN_QUANTITY						= UIFactory.getElements("LABLE_RETURN_QUANTITY");
	static UI_Elements	LABLE_REASON_FOR_RETURN						= UIFactory.getElements("LABLE_REASON_FOR_RETURN");
	static UI_Elements	LABLE_RETURN_METHOD							= UIFactory.getElements("LABLE_RETURN_METHOD");
	static UI_Elements	RQ_CANNOT_BE_LEFT_BLANK						= UIFactory.getElements("RQ_CANNOT_BE_LEFT_BLANK");
	static UI_Elements	SELECT_REASON_FOR_RETURNING					= UIFactory.getElements("SELECT_REASON_FOR_RETURNING");
	static UI_Elements	SELECT_RETURN_METHOD						= UIFactory.getElements("SELECT_RETURN_METHOD");
	static UI_Elements	ITEM_RECEIVED_SECTION_RN					= UIFactory.getElements("ITEM_RECEIVED_SECTION_RN");
	static UI_Elements	ITEM_RECEIVED_SECTION_RETURN_NOTE			= UIFactory.getElements("ITEM_RECEIVED_SECTION_RETURN_NOTE");
	static UI_Elements	LABLE_RETURN_NOTE_NUMBER					= UIFactory.getElements("LABLE_RETURN_NOTE_NUMBER");
	static UI_Elements	RETURN_NOTE_NUMBER_ERROR_MESSAGE			= UIFactory.getElements("RETURN_NOTE_NUMBER_ERROR_MESSAGE");
	static UI_Elements	RQ_CANNOT_BE_GREATER_THAN_APPROVED_QUANTITY	= UIFactory.getElements("RQ_CANNOT_BE_GREATER_THAN_APPROVED_QUANTITY");
	static UI_Elements	LINK_APPROVED_QUANTITY_RETURN_NOTE			= UIFactory.getElements("LINK_APPROVED_QUANTITY_RETURN_NOTE");
	static UI_Elements	LINK_ORDER_QUANTITY_IN_RETURN_NOTE			= UIFactory.getElements("LINK_ORDER_QUANTITY_IN_RETURN_NOTE");
	static UI_Elements	LINK_UNIT_PRICE_IN_RETURN_NOTE				= UIFactory.getElements("LINK_UNIT_PRICE_IN_RETURN_NOTE");
	static UI_Elements	AUTO_DELETE_COMMENT_POPUP_ALERT_RN			= UIFactory.getElements("AUTO_DELETE_COMMENT_POPUP_ALERT_RN");
	static UI_Elements	LINK_BACK_RETURN_NOTE						= UIFactory.getElements("LINK_BACK_RETURN_NOTE");
	static UI_Elements	LABLE_SUPPLIER_ADDRESS_RETURN_NOTE			= UIFactory.getElements("LABLE_SUPPLIER_ADDRESS_RETURN_NOTE");
	static UI_Elements	ADD_ATTACHMENT_AT_HEADER_LEVEL_RN			= UIFactory.getElements("ADD_ATTACHMENT_AT_HEADER_LEVEL_RN");

	public void clickOnAddAttachmentAtHeaderLevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBackReturnNoteLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnContinueAutoDeleteCommentPopUp(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkReturnNoteNumberMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkReturnNotenumberErrorMessage(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkReturnNotenumberFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearReturnNoteNumberField(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkSupplerNameLableFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkSupplierNameDetailFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkReturnNoteDescriptionMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkSupplierEmailMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkSupplierConatactMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkSupplierAddressMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkReturnMaterialAuthorizationMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkNotifySupplierFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkReturnMethodAuthorizationfieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkSupplierEmailFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkReturnNoteDescriptionFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkSupplierAddressFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkSupplierContactFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkReturnQuantityFieldMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkReasonForReturnFieldMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkReturnMethodFieldMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkSelectReturnQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkSelectReasonForReturnErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkSelectReturnMehthodErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkItemReceivedSectionPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkHeaderErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkReturnQuantityGreaterErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getItemNameInReturnNote(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getWebElementForOrderQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getWebElementForUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getWebElementForReturnedQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getWebElementForReasonForReturn(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getWebElementForReturnMethod(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getwebElementForApprovedQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getNameOfItemInReturnNote(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException;

	public String getOrderQuantityForItem(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException;

	public String getUnitPriceForItem(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException;

	public String getApprovedQuantity(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException;

	public String getReturnNoteNumber(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillReturnNoteNumber(WebDriver driver, String testCaseName, String retunrNoteNumber) throws ActionBotException;

	public String fillReturnNoteDescription(WebDriver driver, String testCaseName, String returnNoteDescription) throws ActionBotException;

	public String fillNotes(WebDriver driver, String testCaseName, String notes) throws ActionBotException;

	public String fillReturnMaterialAuthorization(WebDriver driver, String testCaseName, String returnMaterialAuthorization) throws ActionBotException;

	public String fillSupplierContact(WebDriver driver, String testCaseName, String supplierContact) throws ActionBotException;

	public String fillSupplierEmail(WebDriver driver, String testCaseName, String supplierEmail) throws ActionBotException;

	public String fillSupplierAddress(WebDriver driver, String testCaseName, String supplierAddress) throws ActionBotException;

	public String fillSupplierComment(WebDriver driver, String testCaseName, String supplierComment) throws ActionBotException;

	public boolean checkSupplierCommentFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectNotifySupplierCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCreateReturnNote(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSubmitReturnNoteButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveReturnNoteAsDraftButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void HoverOnCreateTabInReceipt(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelReturnNoteButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectAllItemInReturnNote(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getApprovedQuantityForItem(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public void fillReturnedQuantityforItem(WebDriver driver, String testCaseName, WebElement element, String returnQuantity) throws ActionBotException;

	public void fillReasonForReturnforItem(WebDriver driver, String testCaseName, WebElement element, String reasonForReturn) throws ActionBotException;

	public void fillReturnMethodforItem(WebDriver driver, String testCaseName, WebElement element, String returnMethod) throws ActionBotException;
}
