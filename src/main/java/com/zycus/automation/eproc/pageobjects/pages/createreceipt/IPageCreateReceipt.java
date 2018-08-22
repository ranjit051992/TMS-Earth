/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createreceipt;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageCreateReceipt
{
	static UI_Elements	TEXTBOX_RECEIPT_DATE								= UIFactory.getElements("TEXTBOX_RECEIPT_DATE");
	static UI_Elements	DATE_PICKER_RECEIPT_DATE							= UIFactory.getElements("DATE_PICKER_RECEIPT_DATE");
	static UI_Elements	SELECT_MONTH_RECEIPT_DATE							= UIFactory.getElements("SELECT_MONTH_RECEIPT_DATE");
	static UI_Elements	SELECT_YEAR_RECEIPT_DATE							= UIFactory.getElements("SELECT_YEAR_RECEIPT_DATE");
	static UI_Elements	LINK_ITEM_NAMES_IN_RECEIPT							= UIFactory.getElements("LINK_ITEM_NAMES_IN_RECEIPT");
	static UI_Elements	TEXTBOX_RECEIPT_COMMENT								= UIFactory.getElements("TEXTBOX_RECEIPT_COMMENT");
	static UI_Elements	BUTTON_SUBMIT_RECEIPT								= UIFactory.getElements("BUTTON_SUBMIT_RECEIPT");
	static UI_Elements	BUTTON_SAVE_RECEIPT_AS_DRAFT						= UIFactory.getElements("BUTTON_SAVE_RECEIPT_AS_DRAFT");
	static UI_Elements	BUTTON_CANCEL_RECEIPT								= UIFactory.getElements("BUTTON_CANCEL_RECEIPT");
	static UI_Elements	CHECKBOX_SELECT_ALL_RECEIPT_ITEMS					= UIFactory.getElements("CHECKBOX_SELECT_ALL_RECEIPT_ITEMS");
	static UI_Elements	CHECKBOX_LAST_RECEIPT								= UIFactory.getElements("CHECKBOX_LAST_RECEIPT");
	static UI_Elements	DISABLED_LABEL_ALLOW_CREATING_INVOICES_FOR_RECEIPT	= UIFactory.getElements("DISABLED_LABEL_ALLOW_CREATING_INVOICES_FOR_RECEIPT");
	static UI_Elements	ENABLED_LABEL_ALLOW_CREATING_INVOICES_FOR_RECEIPT	= UIFactory.getElements("ENABLED_LABEL_ALLOW_CREATING_INVOICES_FOR_RECEIPT");
	static UI_Elements	CHECKBOX_ALLOW_CREATING_INVOICE_FOR_RECEIPT			= UIFactory.getElements("CHECKBOX_ALLOW_CREATING_INVOICE_FOR_RECEIPT");
	static UI_Elements	TEXTBOX_SHIPPED_VIA									= UIFactory.getElements("TEXTBOX_SHIPPED_VIA");

	static UI_Elements	FIRST_ITEM_OF_PO									= UIFactory.getElements("FIRST_ITEM_OF_PO");

	static UI_Elements	TEXTBOX_CONSIGNMENT_OR_PACKING_SLIP_NO				= UIFactory.getElements("TEXTBOX_CONSIGNMENT_OR_PACKING_SLIP_NO");
	static UI_Elements	TEXTBOX_AIR_WAY_BILL_NO								= UIFactory.getElements("TEXTBOX_AIR_WAY_BILL_NO");
	static UI_Elements	LINK_ATTACHMENTS									= UIFactory.getElements("LINK_ATTACHMENTS");
	static UI_Elements	LABEL_VALUES_OF_ACCEPTED_GOODS						= UIFactory.getElements("LABEL_VALUES_OF_ACCEPTED_GOODS");
	static UI_Elements	TEXTBOX_INTERNAL_COMMENTS							= UIFactory.getElements("TEXTBOX_INTERNAL_COMMENTS");
	static UI_Elements	TEXTBOX_COMMENTS_FOR_SUPPLIER						= UIFactory.getElements("TEXTBOX_COMMENTS_FOR_SUPPLIER");
	static UI_Elements	LINK_COMMENTS_AND_ATTACHMENTS						= UIFactory.getElements("LINK_COMMENTS_AND_ATTACHMENTS");
	static UI_Elements	BUTTON_OK_COMMENTS_AND_ATTACHMENTS					= UIFactory.getElements("BUTTON_OK_COMMENTS_AND_ATTACHMENTS");
	static UI_Elements	RETURN_NOTE_INFORMATION_IN_RECEIPT					= UIFactory.getElements("RETURN_NOTE_INFORMATION_IN_RECEIPT");
	static UI_Elements	COMMENTS_AND_ATTACHMENT_RECEIPT_OF_RN				= UIFactory.getElements("COMMENTS_AND_ATTACHMENT_RECEIPT_OF_RN");
	static UI_Elements	SELECT_REASON_FOR_RETURN_IN_RECEIPT					= UIFactory.getElements("SELECT_REASON_FOR_RETURN_IN_RECEIPT");
	static UI_Elements	SELECT_RETURN_METHOD_IN_RECEIPT						= UIFactory.getElements("SELECT_RETURN_METHOD_IN_RECEIPT");

	public void selectReasonForReturnUsingWebElement(WebDriver driver, String testCaseName, String reasonForReturn) throws ActionBotException;

	public void selectReturnMethodUsingWebElement(WebDriver driver, String testCaseName, String returnMethod) throws ActionBotException;

	public boolean checkReturnNoteInformationFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkCommentAndAttachmentInRNFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getReceiptDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getItemNamesInReceipt(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierNameOfItem(WebDriver driver, String testCaseName, String index) throws ActionBotException;

	public String selectRatingForItem(WebDriver driver, String testCaseName, String index, String ratingName) throws ActionBotException;

	public String getSelectedRatingForItem(WebDriver driver, String testCaseName, String index) throws ActionBotException;

	public String getRequisitionNoForItem(WebDriver driver, String testCaseName, String index) throws ActionBotException;

	public String getUnitPriceForItem(WebDriver driver, String testCaseName, String index) throws ActionBotException;

	public String getOrderedItem(WebDriver driver, String testCaseName, String index) throws ActionBotException;

	public String getPendingItem(WebDriver driver, String testCaseName, String index) throws ActionBotException;

	public int fillReceivedQuantityForItem(WebDriver driver, String testCaseName, String index, int recivedQuantity) throws ActionBotException;

	public int getReceivedQuantityForItem(WebDriver driver, String testCaseName, String index) throws ActionBotException;

	public int fillApprovedQuantityForItem(WebDriver driver, String testCaseName, String index, int approvedQuantity) throws ActionBotException;

	public int getApprovedQuantityForItem(WebDriver driver, String testCaseName, String index) throws ActionBotException;

	public String fillReceiptComments(WebDriver driver, String testCaseName, String receiptComment) throws ActionBotException;

	public void clickOnSubmitReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveReceiptAsDraftButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectAllReceiptItems(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnIsThisTheLastGoodsReceiptForOrder(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAllowCreatingInvoicesForOrderDisabled(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAllowCreatingInvoicesForOrderEnabled(WebDriver driver, String testCaseName) throws ActionBotException;

	public String enterShippedVia(WebDriver driver, String testCaseName, String shippedVia) throws ActionBotException;

	public String selectReasonForReturn(WebDriver driver, String testCaseName, String POId, String reasonForReturn) throws ActionBotException;

	public String selectReturnMethod(WebDriver driver, String testCaseName, String POId, String returnMethod) throws ActionBotException;

	public String checkInLineErrorIcon(WebDriver driver, String testCaseName, String itemId) throws ActionBotException;
}
