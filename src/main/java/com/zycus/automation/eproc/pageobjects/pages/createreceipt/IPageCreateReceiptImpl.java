/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createreceipt;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageCreateReceiptImpl implements IPageCreateReceipt
{
	static Logger logger = Logger.getLogger(IPageCreateReceiptImpl.class);

	@Override
	public String getReceiptDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String receiptDate = ActionBot.findElement(driver, TEXTBOX_RECEIPT_DATE).getAttribute("value");
		logger.info("Receipt Date : " + receiptDate);
		return receiptDate;
	}

	@Override
	public List<WebElement> getItemNamesInReceipt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LINK_ITEM_NAMES_IN_RECEIPT);
	}

	@Override
	public String getSupplierNameOfItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		String supplierName = ActionBot.getTextWithInElement(driver, By.xpath(".//table[@id='receiptItems']//tr[" + index + "]/td[@class='iDesc']//*[@class='blckInChk']"));
		logger.info("Supplier Name : " + supplierName);
		return supplierName;
	}

	@Override
	public String selectRatingForItem(WebDriver driver, String testCaseName, String index, String ratingName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, By.xpath(".//table[@id='receiptItems']//tr[" + index + "]//select[@name='ddlRate']")));
		select.selectByValue(ratingName);
		String selectedRating = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Rating : " + selectedRating);
		return selectedRating;
	}

	@Override
	public String getSelectedRatingForItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, By.xpath(".//table[@id='receiptItems']//tr[" + index + "]//select[@name='ddlRate']")));
		String selectedRating = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Rating : " + selectedRating);
		return selectedRating;
	}

	@Override
	public String getRequisitionNoForItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		String reqNo = ActionBot.getTextWithInElement(driver, By.xpath(".//table[@id='receiptItems']//tr[" + index + "]/td[@class='loc cntr']"));
		logger.info("Requisition No : " + reqNo);
		return reqNo;
	}

	@Override
	public String getUnitPriceForItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		String unitPrice = ActionBot.getTextWithInElement(driver, By.xpath("(.//table[@id='receiptItems']//tr[" + index + "]/td[@class='iNum'])[2]"));
		logger.info("Unit Price : " + unitPrice);
		return unitPrice;
	}

	@Override
	public String getOrderedItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		String orderedItem = ActionBot.getTextWithInElement(driver, By.xpath("(.//table[@id='receiptItems']//tr[" + index + "]/td[@class='iNum'])[3]"));
		logger.info("Ordered Item : " + orderedItem);
		return orderedItem;
	}

	@Override
	public String getPendingItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		String pendingItem = ActionBot.getTextWithInElement(driver, By.xpath(".//table[@id='receiptItems']//tr[" + index + "]/td[@class='iNum pending']"));
		logger.info("Pending Item : " + pendingItem);
		return pendingItem;
	}

	@Override
	public int fillReceivedQuantityForItem(WebDriver driver, String testCaseName, String index, int recivedQuantity) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, By.xpath(".//table[@id='receiptItems']//tr[" + index + "]//input[contains(@id,'received_')]"));

		element.clear();
		element.sendKeys(Integer.toString(recivedQuantity));
		String received_quantity = element.getAttribute("value").trim();
		logger.info("Received Quantity : " + received_quantity);
		return Integer.parseInt(received_quantity);
	}

	@Override
	public int getReceivedQuantityForItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, By.xpath(".//table[@id='receiptItems']//tr[" + index + "]//input[contains(@id,'received_')]"));

		String received_quantity = element.getAttribute("value").trim();
		logger.info("Received Quantity : " + received_quantity);
		return Integer.parseInt(received_quantity);
	}

	@Override
	public int fillApprovedQuantityForItem(WebDriver driver, String testCaseName, String index, int approvedQuantity) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, By.xpath(".//table[@id='receiptItems']//tr[" + index + "]//input[contains(@id,'approved_')]"));

		element.clear();
		element.sendKeys(Integer.toString(approvedQuantity));
		String approved_quantity = element.getAttribute("value").trim();
		logger.info("Approved Quantity : " + approved_quantity);
		return Integer.parseInt(approved_quantity);
	}

	@Override
	public int getApprovedQuantityForItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, By.xpath(".//table[@id='receiptItems']//tr[" + index + "]//input[contains(@id,'approved_')]"));

		String approved_quantity = element.getAttribute("value").trim();
		logger.info("Approved Quantity : " + approved_quantity);
		return Integer.parseInt(approved_quantity);
	}

	@Override
	public String fillReceiptComments(WebDriver driver, String testCaseName, String receiptComment) throws ActionBotException
	{
		String receipt_comment = null;
		if (receiptComment != null)
		{
			receipt_comment = ActionBot.sendKeys(driver, TEXTBOX_RECEIPT_COMMENT, receiptComment);
		}
		else
		{
			receipt_comment = ActionBot.sendKeys(driver, TEXTBOX_RECEIPT_COMMENT, "Auto generated receipt comment");
		}
		logger.info("Entered Receipt Comments : " + receipt_comment);
		return receipt_comment;
	}

	@Override
	public void clickOnSubmitReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before Submiting receipt");
		ActionBot.click(driver, BUTTON_SUBMIT_RECEIPT);
		ActionBot.defaultSleep();
		//ActionBot.waitTillPopUpIsPresent(driver, IPageReceiptListing.RECEIPT_LISTING_PROCESSING_DIV);
		ScreenShot.screenshot(driver, testCaseName, "After Submiting receipt");
	}

	@Override
	public void clickOnSaveReceiptAsDraftButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before Saving receipt as draft");
		ActionBot.click(driver, BUTTON_SAVE_RECEIPT_AS_DRAFT);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After Saving receipt as draft");
	}

	@Override
	public void clickOnCancelReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before Clicking on Cancel Receipt");
		ActionBot.click(driver, BUTTON_CANCEL_RECEIPT);
		ScreenShot.screenshot(driver, testCaseName, "After Clicking on Cancel Receipt");

	}

	@Override
	public void clickOnSelectAllReceiptItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_ALL_RECEIPT_ITEMS);
		if (!ActionBot.findElement(driver, CHECKBOX_SELECT_ALL_RECEIPT_ITEMS).isSelected())
		{
			ActionBot.click(driver, CHECKBOX_SELECT_ALL_RECEIPT_ITEMS);
		}
	}

	@Override
	public void clickOnIsThisTheLastGoodsReceiptForOrder(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_LAST_RECEIPT);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on is this the last receipt for order");

	}

	@Override
	public boolean isAllowCreatingInvoicesForOrderDisabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.findElement(driver, DISABLED_LABEL_ALLOW_CREATING_INVOICES_FOR_RECEIPT).getAttribute("class");
		if (str.contains("disableMe"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isAllowCreatingInvoicesForOrderEnabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.findElement(driver, ENABLED_LABEL_ALLOW_CREATING_INVOICES_FOR_RECEIPT).getAttribute("class");
		if (!str.contains("disableMe"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String enterShippedVia(WebDriver driver, String testCaseName, String shippedVia) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_SHIPPED_VIA);
		/*
		 * ele.sendKeys(shippedVia); ActionBot.defaultSleep();
		 * ele.sendKeys(Keys.ARROW_DOWN); ele.sendKeys(Keys.ENTER);
		 */
		ActionBot.clear(driver, TEXTBOX_SHIPPED_VIA);
		ActionBot.sendKeys(driver, TEXTBOX_SHIPPED_VIA, shippedVia);
		String str = ele.getAttribute("value");
		return str;
	}

	@Override
	public String selectReasonForReturn(WebDriver driver, String testCaseName, String POId, String reasonForReturn) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, By.xpath(".//*[@id='reasonForReturn_" + POId + "']")));
		select.selectByValue(reasonForReturn);
		String selectedReasonForReturn = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Rating : " + selectedReasonForReturn);
		return selectedReasonForReturn;
	}

	@Override
	public String selectReturnMethod(WebDriver driver, String testCaseName, String POId, String returnMethod) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, By.xpath(".//*[@id='returnMethod_" + POId + "']")));
		select.selectByValue(returnMethod);
		String selectedReturnMethod = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Rating : " + selectedReturnMethod);
		return selectedReturnMethod;
	}

	@Override
	public void selectReasonForReturnUsingWebElement(WebDriver driver, String testCaseName, String reasonForReturn) throws ActionBotException
	{
		List<WebElement> rfrWebElement = ActionBot.findElements(driver, SELECT_REASON_FOR_RETURN_IN_RECEIPT);
		for (WebElement rfr : rfrWebElement)
		{

			Select select = new Select(rfr);
			select.selectByValue(reasonForReturn);
			String selectedReasonForReturn = select.getFirstSelectedOption().getText().trim();
			logger.info("Selected Rating : " + selectedReasonForReturn);
		}
	}

	@Override
	public void selectReturnMethodUsingWebElement(WebDriver driver, String testCaseName, String returnMethod) throws ActionBotException
	{
		List<WebElement> rmWebElement = ActionBot.findElements(driver, SELECT_RETURN_METHOD_IN_RECEIPT);
		for (WebElement rm : rmWebElement)
		{

			Select select = new Select(rm);
			select.selectByValue(returnMethod);
			String selectedreturnMethod = select.getFirstSelectedOption().getText().trim();
			logger.info("Selected Rating : " + selectedreturnMethod);
		}
	}

	@Override
	public String checkInLineErrorIcon(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String element = "(//*[contains(@class,'" + itemId + "')]//*[contains(@class,'inlineError')])[2]";
		if (ActionBot.isElementPresent(driver, By.xpath(element)))
		{
			String errorTitle = ActionBot.findElement(driver, By.xpath(element)).getAttribute("title");
			logger.info("Error Title : " + errorTitle);
			return errorTitle;
		}
		return null;
	}

	@Override
	public boolean checkReturnNoteInformationFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, RETURN_NOTE_INFORMATION_IN_RECEIPT);
	}

	@Override
	public boolean checkCommentAndAttachmentInRNFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, COMMENTS_AND_ATTACHMENT_RECEIPT_OF_RN);
	}

}
