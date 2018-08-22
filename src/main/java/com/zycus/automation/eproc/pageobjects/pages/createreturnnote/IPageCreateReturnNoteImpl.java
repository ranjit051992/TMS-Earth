/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createreturnnote;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.pages.receiptlisting.IPageReceiptListing;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author sameer.zilpilwar
 *
 */
public class IPageCreateReturnNoteImpl implements IPageCreateReturnNote
{

	static Logger logger = Logger.getLogger(IPageCreateReturnNoteImpl.class);

	@Override
	public void clickOnBackReturnNoteLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.isElementPresent(driver, LINK_BACK_RETURN_NOTE);
		logger.info("Clicked on Back Link Return Note");
		ActionBot.defaultMediumSleep();

		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public boolean checkReturnNoteNumberMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABLE_RETURN_NOTE_NUMBER);
	}

	@Override
	public boolean checkReturnNotenumberErrorMessage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, RETURN_NOTE_NUMBER_ERROR_MESSAGE);
	}

	@Override
	public void clearReturnNoteNumberField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, RETURN_NOTE_NUMBER);
	}

	@Override
	public boolean checkSupplerNameLableFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, SUPPLIER_NAME_LABLE_RETURN_NOTE);
	}

	@Override
	public boolean checkSupplierNameDetailFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, SUPPLIER_NAME_DETAIL_RETURN_NOTE);
	}

	@Override
	public boolean checkReturnNoteDescriptionMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABLE_RETURN_NOTE_DESCRIPTION);
	}

	@Override
	public boolean checkSupplierEmailMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABLE_SUPPLIER_EMAIL_RETURN_NOTE);
	}

	@Override
	public boolean checkSupplierConatactMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABLE_SUPPLIER_CONTACT_RETURN_NOTE);
	}

	@Override
	public boolean checkSupplierAddressMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABLE_SUPPLIER_ADDRESS_RETURN_NOTE);
	}

	@Override
	public boolean checkReturnMaterialAuthorizationMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABLE_RETURN_MATERIAL_AUTHORIZATION);
	}

	@Override
	public boolean checkNotifySupplierFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.isElementPresent(driver, NOTIFY_SUPPLIER_LABLE);
	}

	@Override
	public boolean checkReturnMethodAuthorizationfieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_RETURN_MATERIAL_AUTHORIZATION);
	}

	@Override
	public boolean checkSupplierEmailFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, TEXTBOX_SUPPLIER_EMAIL);
	}

	@Override
	public boolean checkReturnNoteDescriptionFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_RETURN_NOTE_DESCRIPTION);
	}

	@Override
	public boolean checkReturnNotenumberFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, RETURN_NOTE_NUMBER);
	}

	@Override
	public boolean checkSupplierAddressFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_SUPPLIER_ADDRESS_RETURN_NOTE);
	}

	@Override
	public boolean checkSupplierContactFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_SUPPLIER_CONTACT_RETURN_NOTE);
	}

	@Override
	public boolean checkReturnQuantityFieldMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABLE_RETURN_QUANTITY);
	}

	@Override
	public boolean checkReasonForReturnFieldMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABLE_REASON_FOR_RETURN);
	}

	@Override
	public boolean checkReturnMethodFieldMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABLE_RETURN_METHOD);
	}

	@Override
	public boolean checkSelectReturnQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, RQ_CANNOT_BE_LEFT_BLANK);
	}

	@Override
	public boolean checkSelectReasonForReturnErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, SELECT_REASON_FOR_RETURNING);
	}

	@Override
	public boolean checkSelectReturnMehthodErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, SELECT_RETURN_METHOD);
	}

	@Override
	public boolean checkItemReceivedSectionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag;
		flag = ActionBot.isElementPresent(driver, ITEM_RECEIVED_SECTION_RN);
		if (!flag)
		{
			return ActionBot.isElementPresent(driver, ITEM_RECEIVED_SECTION_RETURN_NOTE);
		}
		else
		{
			return flag;
		}
	}

	@Override
	public boolean checkHeaderErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, HEADER_ERROR_MESSAGE_RETURN_NOTE);
	}

	@Override
	public boolean checkReturnQuantityGreaterErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag;
		flag = ActionBot.isElementPresent(driver, RQ_CANNOT_BE_GREATER_THAN_APPROVED_QUANTITY);
		if (flag)
		{
			logger.info("Return Quantiy is Greater than Approved Quantity is Present");
		}
		else
		{
			logger.info("Return Quantiy is Greater than Approved Quantity is not Present");
		}
		return flag;
	}

	@Override
	public List<WebElement> getItemNameInReturnNote(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LINK_ITEM_NAME_IN_RETURN_NOTE);
	}

	@Override
	public List<WebElement> getWebElementForOrderQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LINK_ORDER_QUANTITY_IN_RETURN_NOTE);
	}

	@Override
	public List<WebElement> getWebElementForUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LINK_UNIT_PRICE_IN_RETURN_NOTE);
	}

	@Override
	public List<WebElement> getwebElementForApprovedQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LINK_APPROVED_QUANTITY_RETURN_NOTE);
	}

	@Override
	public List<WebElement> getWebElementForReturnedQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LINK_RETURN_NOTE_RETURNED_QUANTITY);
	}

	@Override
	public List<WebElement> getWebElementForReasonForReturn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LINK_RETURN_NOTE_REASON_FOR_RETURN);
	}

	@Override
	public List<WebElement> getWebElementForReturnMethod(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LINK_RETURN_NOTE_RETURN_METHOD);
	}

	@Override
	public String getNameOfItemInReturnNote(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException
	{
		String itemName = ActionBot.getTextWithInElement(driver, element);
		logger.info("Item Name " + itemName);
		return itemName;
	}

	@Override
	public String getOrderQuantityForItem(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException
	{
		String orderQuantity = ActionBot.getTextWithInElement(driver, element);
		logger.info("Oreder Quantity" + orderQuantity);
		return orderQuantity;
	}

	@Override
	public String getUnitPriceForItem(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException
	{
		String unitPrice = ActionBot.getTextWithInElement(driver, element);
		logger.info("Unit Price " + unitPrice);
		return unitPrice;
	}

	@Override
	public String getApprovedQuantity(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException
	{
		String approvedQuantity = ActionBot.getTextWithInElement(driver, element);
		logger.info("Item Name " + approvedQuantity);
		return approvedQuantity;
	}

	@Override
	public String getReturnNoteNumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String returnNoteNumber = ActionBot.getTextWithInElement(driver, RETURN_NOTE_NUMBER);
		logger.info("Return note number is :" + returnNoteNumber);
		return returnNoteNumber;
	}

	@Override
	public String fillReturnNoteNumber(WebDriver driver, String testCaseName, String returnNoteNumber) throws ActionBotException
	{
		String return_note_number = null;
		if (returnNoteNumber != null)
		{
			return_note_number = ActionBot.sendKeys(driver, RETURN_NOTE_NUMBER, returnNoteNumber);
		}
		else
		{
			return_note_number = ActionBot.sendKeys(driver, RETURN_NOTE_NUMBER, "Auto generated return note number");
		}
		logger.info("Entered Return Note Description : " + return_note_number);
		return return_note_number;
	}

	@Override
	public String fillReturnNoteDescription(WebDriver driver, String testCaseName, String returnNoteDescription) throws ActionBotException
	{
		String return_note_description = null;
		if (returnNoteDescription != null)
		{
			return_note_description = ActionBot.sendKeys(driver, TEXTBOX_RETURN_NOTE_DESCRIPTION, returnNoteDescription);
		}
		else
		{
			return_note_description = ActionBot.sendKeys(driver, TEXTBOX_RETURN_NOTE_DESCRIPTION, "Auto generated return note description");
		}
		logger.info("Entered Return Note Description : " + return_note_description);
		return return_note_description;
	}

	@Override
	public String fillNotes(WebDriver driver, String testCaseName, String notes) throws ActionBotException
	{
		String return_notes = null;
		if (notes != null)
		{
			return_notes = ActionBot.sendKeys(driver, TEXTAREA_NOTES, notes);
		}
		else
		{
			return_notes = ActionBot.sendKeys(driver, TEXTAREA_NOTES, "Auto generated Notes for Return Note");
		}
		logger.info("Entered Return Note Description : " + return_notes);
		return return_notes;
	}

	@Override
	public void selectNotifySupplierCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, NOTIFY_SUPPLIER_RETURN_NOTE);
	}

	@Override
	public String fillReturnMaterialAuthorization(WebDriver driver, String testCaseName, String returnMaterialAuthorization) throws ActionBotException
	{
		String return_material_authorization = null;
		if (returnMaterialAuthorization != null)
		{
			return_material_authorization = ActionBot.sendKeys(driver, TEXTBOX_RETURN_MATERIAL_AUTHORIZATION, returnMaterialAuthorization);
		}
		else
		{
			return_material_authorization = ActionBot.sendKeys(driver, TEXTBOX_RETURN_MATERIAL_AUTHORIZATION, "Auto generated Return Material Authorization");
		}
		logger.info("Entered Return Material Authorization : " + return_material_authorization);
		return return_material_authorization;
	}

	@Override
	public String fillSupplierContact(WebDriver driver, String testCaseName, String supplierContact) throws ActionBotException
	{
		String supplier_contact = null;
		if (supplierContact != null)
		{
			supplier_contact = ActionBot.sendKeys(driver, TEXTBOX_SUPPLIER_CONTACT_RETURN_NOTE, supplierContact);
		}
		else
		{
			supplier_contact = ActionBot.sendKeys(driver, TEXTBOX_SUPPLIER_CONTACT_RETURN_NOTE, "Auto generated Return Note Supplier Contact");
		}
		logger.info("Entered Return Note Supplier Contact : " + supplier_contact);
		return supplier_contact;
	}

	@Override
	public String fillSupplierEmail(WebDriver driver, String testCaseName, String supplierEmail) throws ActionBotException
	{
		String supplier_email = null;
		if (supplierEmail != null)
		{
			supplier_email = ActionBot.sendKeys(driver, TEXTBOX_SUPPLIER_EMAIL, supplierEmail);
		}
		else
		{
			supplier_email = ActionBot.sendKeys(driver, TEXTBOX_SUPPLIER_EMAIL, "Auto generated Return Note Supplier Email");
		}
		logger.info("Entered Return Note Supplier Email : " + supplier_email);
		return supplier_email;
	}

	@Override
	public String fillSupplierAddress(WebDriver driver, String testCaseName, String supplierAddress) throws ActionBotException
	{
		String supplier_address = null;
		if (supplierAddress != null)
		{
			supplier_address = ActionBot.sendKeys(driver, TEXTBOX_SUPPLIER_ADDRESS_RETURN_NOTE, supplierAddress);
		}
		else
		{
			supplier_address = ActionBot.sendKeys(driver, TEXTBOX_SUPPLIER_ADDRESS_RETURN_NOTE, "Auto generated Return Note Supplier Address");
		}
		logger.info("Entered Return Note Supplier Address : " + supplier_address);
		return supplier_address;
	}

	@Override
	public String fillSupplierComment(WebDriver driver, String testCaseName, String supplierComment) throws ActionBotException
	{
		String supplier_comment = null;
		if (supplierComment != null)
		{
			supplier_comment = ActionBot.sendKeys(driver, TEXTAREA_SUPPLIER_COMMENTS, supplierComment);
		}
		else
		{
			supplier_comment = ActionBot.sendKeys(driver, TEXTAREA_SUPPLIER_COMMENTS, "Auto generated Return Note Supplier Comment");
		}
		return supplier_comment;
	}

	@Override
	public boolean checkSupplierCommentFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTAREA_SUPPLIER_COMMENTS);
	}

	@Override
	public void clickOnSubmitReturnNoteButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before Submiting Return Note");
		ActionBot.click(driver, BUTTON_SUBMIT_RETURN_NOTE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After Submiting Return Note");
	}

	@Override
	public void clickOnSaveReturnNoteAsDraftButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before Saving return note as draft");
		ActionBot.click(driver, SAVE_AS_DRAFT_RETURN_NOTE);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After Saving return note as draft");
	}

	@Override
	public void clickOnCancelReturnNoteButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before Clicking on Cancel return note");
		ActionBot.click(driver, CANCLE_RETURN_NOTE);
		ActionBot.waitTillPopUpIsPresent(driver, IPageReceiptListing.RECEIPT_LISTING_PROCESSING_DIV);
		ScreenShot.screenshot(driver, testCaseName, "After Clicking on Cancel return note");
	}

	@Override
	public void clickOnCreateReturnNote(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before Clicking on Create return note");
		ActionBot.click(driver, CREATE_RETURN_NOTE);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After Clicking on Create return note");
	}

	@Override
	public void HoverOnCreateTabInReceipt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		//ActionBot.click(driver, CREATE_TAB);
		System.out.println(CREATE_TAB);
		ActionBot.hover(driver, CREATE_TAB);
		logger.info("Hover On CreateTabInReceipt");
	}

	@Override
	public void selectAllItemInReturnNote(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_ALL_RETURN_NOTE_ITEMS);
		logger.info("Selected All the items in List");
	}

	@Override
	public String getApprovedQuantityForItem(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String approvedQuantity = ActionBot.getTextWithInElement(driver, By.xpath(".//table[@id='returnNoteItems']//tr[" + index + "]/td[@class='returnNoteborderRgt']"));
		logger.info("Approved Quantity for : " + index + " :" + approvedQuantity);
		return approvedQuantity;
	}

	@Override
	public void fillReturnedQuantityforItem(WebDriver driver, String testCaseName, WebElement element, String returnQuantity) throws ActionBotException
	{
		//".//table[@class='tblLytFixed']//tr[" + index + "]/td[@class='frmBlck frmBlck-nopad']//input[contains(@class,'frmEle returnQty')]"
		//WebElement element = ActionBot.findElement(driver, By.xpath(".//table[@class='returnNoteItems'" + "]//tr[" + index + "]//input[contains(@class,'frmEle.returnQty')]"));

		element.clear();
		element.sendKeys(returnQuantity);
		String returned_quantity = element.getAttribute("value").trim();
		logger.info("Returned Quantity : " + returned_quantity);
	}

	@Override
	public void fillReasonForReturnforItem(WebDriver driver, String testCaseName, WebElement element, String reasonForReturn) throws ActionBotException
	{
		//Select select = new Select(ActionBot.findElement(driver, By.xpath(".//table[@id='returnNoteItems']//tr[" + index + "]//select[@class='frmEle.reasonForReturn']")));
		Select select = new Select(element);
		select.selectByValue(reasonForReturn);
		String selectedReason = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Reason For Retunr : " + selectedReason);
	}

	@Override
	public void fillReturnMethodforItem(WebDriver driver, String testCaseName, WebElement element, String returnMethod) throws ActionBotException
	{
		//Select select = new Select(ActionBot.findElement(driver, By.xpath(".//table[@id='returnNoteItems']//tr[" + index + "]//select[@class='frmEle.returnMethod']")));
		Select select = new Select(element);
		select.selectByValue(returnMethod);
		String return_Method = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Return Method : " + return_Method);
	}

	@Override
	public void clickOnContinueAutoDeleteCommentPopUp(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Alert Continue button ");
		ActionBot.click(driver, AUTO_DELETE_COMMENT_POPUP_ALERT_RN);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Alert Continue button");
	}

	@Override
	public void clickOnAddAttachmentAtHeaderLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ADD_ATTACHMENT_AT_HEADER_LEVEL_RN);
		ScreenShot.screenshot(driver, testCaseName, "After Clicking On Add Attachment at Header Level");
	}

}
