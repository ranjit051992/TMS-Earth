/**
 * 
 */
package com.zycus.automation.eproc.businessflow.returnnoteflow;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.ReturnNote;
import com.zycus.automation.bo.StandardPO;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.pageobjects.pages.createreturnnote.PageCreateReturnNote;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.receiptlisting.IPageReceiptListing;
import com.zycus.automation.eproc.pageobjects.pages.receiptlisting.IPageReceiptListingImpl;
import com.zycus.automation.eproc.pageobjects.pages.receiptlisting.PageReceiptListing;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.popups.defaultalert.PopUpDefalutAlert;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author sameer.zilpilwar
 *
 */
public class FlowReturnNote
{
	static Logger logger = Logger.getLogger(FlowReturnNote.class);

	public static void openReturnNoteFrom(WebDriver driver, String testCaseName, ReturnNote returnNote) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;

		// Click On PO tab on mainpage
		MainPageHeaderLevelTab.clickOnPOTab(driver);

		String poNumber;
		if (returnNote.getPurchaseOrder() != null)
		{
			PurchaseOrder purchaseOrder = returnNote.getPurchaseOrder();
			poNumber = purchaseOrder.getPoNo();
		}
		else
		{
			StandardPO standardPO = returnNote.getStandardPO();
			poNumber = standardPO.getPoNumber();
		}

		// Search For PO

		flag = FlowPoListing.searchPo(driver, testCaseName, poNumber, IConstantsData.SEARCH_BY_PO_NO);
		assertTrue("Error while searching PO", flag);

		// Click on First PO
		PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);

		// Click On Receipt Tab
		PageViewPurchaseOrder.clickOnTabReceipt(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);

		// Click on Create Return Note
		PageCreateReturnNote.HoverOnCreateTabInReceipt(driver, testCaseName);
		PageCreateReturnNote.clickOnCreateReturnNote(driver, testCaseName);

	}

	public static ReturnNote createReturnNote(WebDriver driver, String testCaseName, ReturnNote returnNote) throws ActionBotException, FactoryMethodException
	{
		// will Open the PAge of Return Note form
		openReturnNoteFrom(driver, testCaseName, returnNote);

		if (PopUpDefalutAlert.isAlertAndErrorPopUpPresent(driver, testCaseName))
		{
			PopUpDefalutAlert.clickOnAlertOkButton(driver, testCaseName);
			return returnNote;
		}
		else
		{
			// Fill Return Note form
			returnNote = fillReturnNoteForm(driver, testCaseName, returnNote);
		}

		// Fill Item Requried to replace
		returnNote = fillItemDetails(driver, testCaseName, returnNote);

		// Action to be performed on Return Note
		if (returnNote.getNextAction().equalsIgnoreCase(IConstantsData.SUBMIT))
		{
			returnNote = submitReturnNote(driver, testCaseName, returnNote);
		}
		else if (returnNote.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_AS_DRAFT))
		{
			returnNote = submitSaveAsDraft(driver, testCaseName, returnNote);
		}
		else if (returnNote.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			returnNote = cancleReturnNote(driver, testCaseName, returnNote);
		}
		else if (returnNote.getNextAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			logger.info("No Action to be performed for Return Note");
		}
		else
		{
			logger.info("Invalid next action is specified for Return Note = " + returnNote.getNextAction());
		}

		return returnNote;

	}

	public static ReturnNote fillReturnNoteForm(WebDriver driver, String testCaseName, ReturnNote returnNote) throws ActionBotException
	{

		if (PopUpDefalutAlert.isAlertAndErrorPopUpPresent(driver, testCaseName))
		{
			PopUpDefalutAlert.clickOnAlertOkButton(driver, testCaseName);
			return returnNote;
		}
		// get return note number and storing it to Return note Object
		returnNote.setReturnNoteNo(PageCreateReturnNote.getReturnNoteNumber(driver, testCaseName));

		// fill the value for Return note Description
		if (returnNote.getReturnNoteDescription() != null)
		{
			returnNote.setReturnNoteDescription(PageCreateReturnNote.fillReturnNoteDescription(driver, testCaseName, returnNote.getReturnNoteDescription()));
		}

		// fill the value for Return note note
		if (returnNote.getReturnNoteNotes() != null)
		{
			returnNote.setReturnNoteNotes(PageCreateReturnNote.fillNotes(driver, testCaseName, returnNote.getReturnNoteNotes()));
		}

		// Select option weateher to notify supplier or not
		if (returnNote.isNotifySupplier())
		{
			PageCreateReturnNote.selectNotifySupplierCheckBox(driver, testCaseName);
			returnNote.setReturnNoteRMA(PageCreateReturnNote.fillReturnMaterialAuthorization(driver, testCaseName, returnNote.getReturnNoteRMA()));
		}

		// fill return note Supplier Contact
		if (returnNote.getReturnNoteSupplierContact() != null)
		{
			returnNote.setReturnNoteSupplierContact(PageCreateReturnNote.fillSupplierContact(driver, testCaseName, returnNote.getReturnNoteSupplierContact()));
		}

		// fill return note Supplier Email
		if (returnNote.getReturnNoteSupplierEmail() != null)
		{
			returnNote.setReturnNoteSupplierEmail(PageCreateReturnNote.fillSupplierEmail(driver, testCaseName, returnNote.getReturnNoteSupplierEmail()));

		}

		return returnNote;
	}

	public static ReturnNote fillItemDetails(WebDriver driver, String testCaseName, ReturnNote returnNote) throws ActionBotException
	{
		// Will select all the item in table of item in Return note
		PageCreateReturnNote.selectAllItemInReturnNote(driver, testCaseName);

		// this list will give the count of items present in table
		List<WebElement> itemListWebElements = PageCreateReturnNote.getItemNameInReturnNote(driver, testCaseName);
		List<WebElement> returnedQuantityWebElements = PageCreateReturnNote.getWebElementForReturnedQuantity(driver, testCaseName);
		List<WebElement> reasonForReturnWebElements = PageCreateReturnNote.getWebElementForReasonForReturn(driver, testCaseName);
		List<WebElement> returnMethodWebElements = PageCreateReturnNote.getWebElementForReturnMethod(driver, testCaseName);
		int j = 1;
		for (int i = 0; i < itemListWebElements.size(); i++)
		{

			String approvedQuan = PageCreateReturnNote.getApprovedQuantityForItem(driver, testCaseName, j);
			String approvedQuantity[] = approvedQuan.split(" ");

			PageCreateReturnNote.fillReturnedQuantityforItem(driver, testCaseName, returnedQuantityWebElements.get(i), approvedQuantity[0]);
			PageCreateReturnNote.fillReasonForReturnforItem(driver, testCaseName, reasonForReturnWebElements.get(i), "Damaged Item");
			PageCreateReturnNote.fillReturnMethodforItem(driver, testCaseName, returnMethodWebElements.get(i), "Replacement");
			j = j + 3;
		}
		return returnNote;
	}

	public static ReturnNote cancleReturnNote(WebDriver driver, String testCaseName, ReturnNote returnNote) throws ActionBotException
	{
		PageCreateReturnNote.clickOnCancelReturnNoteButton(driver, testCaseName);
		return returnNote;
	}

	public static ReturnNote submitReturnNote(WebDriver driver, String testCaseName, ReturnNote returnNote) throws ActionBotException
	{
		PageCreateReturnNote.clickOnSubmitReturnNoteButton(driver, testCaseName);
		String alertBoxMessage = PopUpDefalutAlert.getAlertMsg(driver, testCaseName);
		//Check for Select Item Alert PopUp
		if (alertBoxMessage.equals(IConstantsData.SELECT_AN_ITEM_ALERT_MESSAGE))
		{
			PopUpDefalutAlert.clickOnAlertOkButton(driver, testCaseName);
		}
		else
		{
			//Check final submission of return note
			if (alertBoxMessage.equals(IConstantsData.RTURN_NOTE_FINALIZE_ALERT_MESSAGE) || alertBoxMessage.equals(IConstantsData.RN_FINALIZE_WITH_NOTIFY_SUPPLIER))
			{
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			}
			//Check For duplicate return note number message PopUp
			if (PopUpDefalutAlert.isAlertAndErrorPopUpPresent(driver, testCaseName))
			{
				alertBoxMessage = PopUpDefalutAlert.getAlertMsg(driver, testCaseName);
				if (alertBoxMessage.equals(IConstantsData.RETURN_NOTE_NUMBER_ALREADY_IN_USE))//|| alertBoxMessage.endsWith(IConstantsData.RN_FINALIZE_WITH_NOTIFY_SUPPLIER))
				{
					PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
					ActionBot.waitTillPopUpIsPresent(driver, IPageReceiptListing.RECEIPT_LISTING_PROCESSING_DIV);

					//to filter out only return notes (as receipt No are also displayed)
					IPageReceiptListingImpl receiptListingObject = new IPageReceiptListingImpl();
					receiptListingObject.selectReturnNoteStatusFilter(driver, testCaseName);

					// Retrieve new return Note number updated return note number
					String newRNnumber = PageReceiptListing.getFirstReturnNoteNumber(driver, testCaseName);
					if (!returnNote.getReturnNoteNo().equals(newRNnumber))
					{
						returnNote.setReturnNoteNo(newRNnumber);
					}
				}
			}

		}
		ActionBot.waitTillPopUpIsPresent(driver, IPageReceiptListing.RECEIPT_LISTING_PROCESSING_DIV);
		return returnNote;
	}

	public static ReturnNote submitSaveAsDraft(WebDriver driver, String testCaseName, ReturnNote returnNote) throws ActionBotException
	{
		PageCreateReturnNote.clickOnSaveReturnNoteAsDraftButton(driver, testCaseName);
		if (PopUpDefalutAlert.isAlertAndErrorPopUpPresent(driver, testCaseName))
		{
			String alertMessage = PopUpDefalutAlert.getAlertMsg(driver, testCaseName);
			//Check For duplicate return note number message PopUp
			if (alertMessage.equals(IConstantsData.RETURN_NOTE_NUMBER_ALREADY_IN_USE))
			{
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
				ActionBot.waitTillPopUpIsPresent(driver, IPageReceiptListing.RECEIPT_LISTING_PROCESSING_DIV);

				// Retrieve new return Note number updated return note number
				String newRNnumber = PageReceiptListing.getFirstReceiptNo(driver, testCaseName);
				if (!returnNote.getReturnNoteNo().equals(newRNnumber))
				{
					returnNote.setReturnNoteNo(newRNnumber);
				}
			}
		}
		ActionBot.waitTillPopUpIsPresent(driver, IPageReceiptListing.RECEIPT_LISTING_PROCESSING_DIV);
		return returnNote;
	}

	public static boolean deleteDraftedReturnNote(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag;
		List<WebElement> deleteRNWebElement = PageReceiptListing.getWebElementOfDeleteReturnNote(driver, testCaseName);
		PageReceiptListing.clickOnDeleteReturnNote(driver, testCaseName, deleteRNWebElement.get(0));
		flag = PopUpDefalutAlert.isAlertAndErrorPopUpPresent(driver, testCaseName);
		if (flag)
		{
			PageReceiptListing.clickOnYesButtonReturnNotePopUp(driver, testCaseName);
			ActionBot.waitTillPopUpIsPresent(driver, IPageReceiptListing.RECEIPT_LISTING_PROCESSING_DIV);
		}
		ActionBot.defaultSleep();
		int initialSize = deleteRNWebElement.size();
		deleteRNWebElement = PageReceiptListing.getWebElementOfDeleteReturnNote(driver, testCaseName);
		int afterDelete = deleteRNWebElement.size();
		if (afterDelete == initialSize - 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean checkTotalDetailOfItemPresentInReturnNote(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> itemNameWebElement = PageCreateReturnNote.getItemNameInReturnNote(driver, testCaseName);
		List<WebElement> orderQuantityWebElement = PageCreateReturnNote.getWebElementForOrderQuantity(driver, testCaseName);
		List<WebElement> unitPriceWebElement = PageCreateReturnNote.getWebElementForUnitPrice(driver, testCaseName);
		List<WebElement> approvedQuantityWebElement = PageCreateReturnNote.getwebElementForApprovedQuantity(driver, testCaseName);

		String tmp;
		// loop to see all the values are their of item
		for (int i = 0; i < itemNameWebElement.size(); i++)
		{
			tmp = PageCreateReturnNote.getNameOfItemInReturnNote(driver, testCaseName, itemNameWebElement.get(i));
			if (tmp == null)
			{
				logger.info("Item name not Present in Table");
				return false;
			}
			tmp = PageCreateReturnNote.getOrderQuantityForItem(driver, testCaseName, orderQuantityWebElement.get(i));
			if (tmp == null)
			{
				logger.info("Order Quantity not Present in Table ");
				return false;
			}
			tmp = PageCreateReturnNote.getUnitPriceForItem(driver, testCaseName, unitPriceWebElement.get(i));
			if (tmp == null)
			{
				logger.info("Unit Price not Present in Table");
				return false;
			}
			tmp = PageCreateReturnNote.getApprovedQuantity(driver, testCaseName, approvedQuantityWebElement.get(i));
			if (tmp == null)
			{
				logger.info("Approved Qantity not Present in Table");
				return false;
			}
		}
		logger.info("All the Details of item Present in Table");
		return true;
	}
}
