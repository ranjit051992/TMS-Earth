package com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.primitives.Booleans;
import com.zycus.automation.bo.CostBookingAndAccountingItemSummaryCOA;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCostBooking.IModelItemSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCostBooking.ModelItemSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.pages.myfavorites.IPageMyFavorites;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.IPageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ASyncRequestNotCompletedInSpecifiedTimeException;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.exception.PageloadNotCompletedInSpecifiedTimeException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.Helper;

public class IPageRequisitionCheckOutImpl implements IPageRequisitionCheckOut
{

	static Logger logger = Logger.getLogger(IPageRequisitionCheckOutImpl.class);

	@Override
	public boolean checkRetrospectivePurchase(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String retrospectivePurchaseCheck = "Retrospective Purchase Check";
		ActionBot.click(driver, RETROSPECTIVE_PURCHASE);
		if (ActionBot.findElement(driver, RETROSPECTIVE_PURCHASE).isSelected())
		{
			ScreenShot.screenshot(driver, testCaseName, retrospectivePurchaseCheck + " Done");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, retrospectivePurchaseCheck + " Failed");
			return false;
		}

	}

	@Override
	public boolean checkUrgentRequirement(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String urgentRequirementCheck = "Urgent Requirement Check";
		ActionBot.click(driver, URGENT_REQUIREMENT);
		if (ActionBot.findElement(driver, URGENT_REQUIREMENT).isSelected())
		{
			ScreenShot.screenshot(driver, testCaseName, urgentRequirementCheck + " Done");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, urgentRequirementCheck + " Failed");
			return false;
		}

	}

	@Override
	public void clickAddAttachment(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{

		ActionBot.click(driver, By.xpath(".//*[@id='item_" + itemID + "']/td[@class='col-actions']/a[@class='icon uploadicon itemAttachments']"));
		ScreenShot.screenshot(driver, testCaseName, "Add Attachment Window");
	}

	@Override
	public void clickAddComments(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{

		ActionBot.click(driver, By.xpath(".//*[@id='item_" + itemID + "']/td[@class='col-actions']/a[@class='icon comments itemComments']"));
		ScreenShot.screenshot(driver, testCaseName, "Add Comments Window");
	}

	@Override
	public void clickAddItemOnCheckout(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ActionBot.click(driver, ADD_ITEM_ON_CHECKOUT);
		WebElement element = ActionBot.findElement(driver, ADD_ITEM_ON_CHECKOUT);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0," + element.getLocation().y + ")");
		element.click();
		ScreenShot.screenshot(driver, testCaseName, "Add Item From Checkout Page");
	}

	@Override
	public void clickCancleRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCLE_REQUISITION);
		ScreenShot.screenshot(driver, testCaseName, "Cancle Requisition");
	}

	@Override
	public void clickChangeMultiple(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, CHANGE_MULTIPLE);
		ScreenShot.screenshot(driver, testCaseName, "Change Multiple Window");
	}

	@Override
	public void clickClearRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, CLEAR_REQUIRED_BY_DATE);
		ScreenShot.screenshot(driver, testCaseName, "Cleared Required By Date");
	}

	@Override
	public void clickContinueRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, CONTINUE_REQUISITION);
		ScreenShot.screenshot(driver, testCaseName, "Continue Requisition");

	}

	@Override
	public void clickCurrencyWiseTotal(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, CURRENCY_WISE_TOTAL);
		ScreenShot.screenshot(driver, testCaseName, "Currency Wise Total Window");

	}

	@Override
	public void clickDeleteItem(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{

		ActionBot.click(driver, By.xpath(".//*[@id='item_" + itemID + "']//*[contains(@class,'icon delete deleteItem')]"));
		ScreenShot.screenshot(driver, testCaseName, "Delete Item Window");
	}

	@Override
	public void clickEditHeaderInfo(WebDriver driver, String testCaseName)
		throws ActionBotException, ASyncRequestNotCompletedInSpecifiedTimeException, PageloadNotCompletedInSpecifiedTimeException
	{
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ActionBot.waitForElementToBePresent(driver, 5, EDIT_BILLING_DELIVERY_COSTBOOKING_INFO);
		ActionBot.waitForElementToBeDisplayed(driver, EDIT_BILLING_DELIVERY_COSTBOOKING_INFO, 5);
		ActionBot.click(driver, EDIT_BILLING_DELIVERY_COSTBOOKING_INFO);
		waitTillProgressingDivPresent(driver, testCaseName);
		// ActionBot.defaultHighSleep();
		ScreenShot.screenshot(driver, testCaseName, "EDIT_BILLING_DELIVERY_COSTBOOKING_INFO Window");
	}

	@Override
	public void clickEditItemSummary(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{

		ActionBot.defaultSleep();

		// ActionBot.moveToElementAndClick(driver, By.xpath(".//*[@id='item_" + itemID + "']//a[contains(@class,'edit')]"));

		ActionBot.scroll(driver, ActionBot.findElement(driver, By.xpath(".//*[@id='item_" + itemID + "']//a[contains(@class,'edit')]")));
		ActionBot.click(driver, By.xpath(".//*[@id='item_" + itemID + "']//a[contains(@class,'edit')]"));

		// ActionBot.waitTillPopUpIsPresent(driver, By.xpath(".//div[contains(@class,'status process')]"));
		// waitTillProgressingDivPresent(driver, testCaseName);

		ScreenShot.screenshot(driver, testCaseName, "Edit Item Summary Window");
	}

	@Override
	public void clickExpandAll(WebDriver driver, String testCaseName) throws Exception
	{

		ActionBot.defaultSleep();
		ActionBot.click(driver, EXPAND_ALL);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After Expand All Window");
	}

	@Override
	public void clickIAmDone(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		// ActionBot.defaultHighSleep();
		// ActionBot.waitForPageLoad(driver);
		// ActionBot.waitForElementToBePresent(driver, 5, I_AM_DONE);
		ActionBot.waitForElementToBeDisplayed(driver, I_AM_DONE, 5);
		ActionBot.click(driver, I_AM_DONE);
		// ActionBot.defaultMediumSleep();
		// ActionBot.waitForElementToBeDisplayed(driver,
		// By.xpath(".//button[contains(@class,'pri')]"), 5);
		if (ActionBot.isElementDisplayed(driver, By.xpath(".//button[contains(@class,'pri')]")))
		{
			ActionBot.click(driver, By.xpath(".//button[contains(@class,'pri')]"));
			// ActionBot.waitForPageLoad(driver);
		}
		ScreenShot.screenshot(driver, testCaseName, "After I Am Done");
	}

	@Override
	public String clickSaveAsDraft(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.click(driver, SAVE_AS_DRAFT);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After Save As Draft");
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='reqList']//td[contains(@class,'requisitionNo')])[1]"));
	}

	@Override
	public void clickOnItemNameToViewItemDetails(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		if (itemID != null)
		{
			//eProc version R17.11.1.0
			//ActionBot.click(driver, By.xpath(xpath1_item_details + itemID + xpath2_item_name));
			ActionBot.click(driver, By.xpath(xpath1_item_details + itemID + "']"));
		}
		else
		{
			ActionBot.click(driver, By.xpath(".//*[contains(@id,'item_')]//a[contains(@class,'itemName')]"));
		}
		ActionBot.defaultHighSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on item name");
	}

	@Override
	public String fillAssignedBuyer(WebDriver driver, String testCaseName, String assignedBuyer) throws ActionBotException
	{
		// ActionBot.defaultHighSleep();
		String str = ActionBot.fillAutoCompleteField(driver, TEXTBOX_ASSIGNED_BUYER, assignedBuyer);
		// String str = ActionBot.getTextWithInElement(driver,
		// LABEL_ASSIGNED_BUYER_ON_CHECKOUT_PAGE);
		logger.info("Assigned Buyer Name : " + str);
		// ScreenShot.screenshot(driver, testCaseName, "filled Assigned Buyer");
		return str;
	}

	@Override
	public String fillCheckoutReqName(WebDriver driver, String testCaseName, String checkoutReqName) throws ActionBotException
	{
		// ActionBot.defaultHighSleep();
		ActionBot.sendKeys(driver, TEXTBOX_REQUISITION_NAME, checkoutReqName);
		String str = ActionBot.findElement(driver, TEXTBOX_REQUISITION_NAME).getAttribute("value");
		logger.info("Requisition Name : " + str);
		ActionBot.defaultLowSleep();
		if (str != null)
		{
			ScreenShot.screenshot(driver, testCaseName, "filled Requisition Name");
			return str;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillCommentsForSupplier(WebDriver driver, String testCaseName, String commentsForSupplier) throws ActionBotException
	{

		String str = ActionBot.sendKeys(driver, TEXTBOX_COMMENTS_FOR_SUPPLIER_CHECKOUT_PAGE, commentsForSupplier);
		// String str = ActionBot.findElement(driver,
		// TEXTBOX_COMMENTS_FOR_SUPPLIER_CHECKOUT_PAGE).getAttribute("value");
		logger.info("Entered supplier comments : " + str);
		if (str != null)
		{
			// ScreenShot.screenshot(driver, testCaseName,
			// "filled comments for supplier");
			return str;
		}
		else
		{
			return null;
		}
	}

	@Override
	public Integer fillItemQuantity(WebDriver driver, String testCaseName, Integer itemQty, String itemID) throws ActionBotException
	{

		ActionBot.sendKeys(driver, By.xpath(".//*[@id='item_quantity_" + itemID + "']"), itemQty.toString());
		String str = ActionBot.findElement(driver, By.xpath(".//*[@id='item_quantity_" + itemID + "']")).getAttribute("value");
		if (str != null)
		{
			ScreenShot.screenshot(driver, testCaseName, "filled Item Quantity");
			return Integer.parseInt(str);
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillOnBehalfOf(WebDriver driver, String testCaseName, String onBehalfOf) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, ON_BEHALF_OF);
		ActionBot.fillAutoCompleteField(driver, ele, onBehalfOf);

		ActionBot.sendKeys(driver, TEXTBOX_COMMENTS_FOR_SUPPLIER_CHECKOUT_PAGE, "Auto Generated Comments for Supplier");
		String str = ActionBot.findElement(driver, ON_BEHALF_OF).getAttribute("value");
		logger.info("On Behalf of : " + str);
		ScreenShot.screenshot(driver, testCaseName, "filled On Behalf Of");
		return str;
	}

	@Override
	public String getOnBehalfOf(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, VIEW_ON_BEHALF_OF).getText();
	}

	@Override
	public String selectPurchaseType(WebDriver driver, String testCaseName, String purchaseType) throws ActionBotException
	{
		String str = null;
		if (ActionBot.isElementPresent(driver, PURCHASE_TYPE))
		{
			if (ActionBot.isElementDisplayed(driver, PURCHASE_TYPE))
			{
				Select sel = new Select(ActionBot.findElement(driver, PURCHASE_TYPE));
				if (purchaseType != null)
				{
					sel.selectByVisibleText(purchaseType);

				}
				else
				{
					sel.selectByIndex(1);
					ActionBot.defaultSleep();
				}
				str = sel.getFirstSelectedOption().getAttribute("title").trim();
				if (ActionBot.isElementDisplayed(driver, IPageMyFavorites.YES_CONFIRMATION))
					ActionBot.findElement(driver, IPageMyFavorites.YES_CONFIRMATION).click();
				// script to handle click
				if (ActionBot.isElementDisplayed(driver, IPageMyFavorites.YES_CONFIRMATION))
				{
					WebElement element = ActionBot.findElement(driver, IPageMyFavorites.YES_CONFIRMATION);
					JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
					javascriptExecutor.executeScript("arguments[0].click();", element);
				}
				logger.info("Selected Purchase Type : " + str);

			}
			return str;
		}
		else
			return null;
	}

	@Override
	public String fillReasonForOrdering(WebDriver driver, String testCaseName, String reasonForOrdering) throws ActionBotException
	{

		ActionBot.sendKeys(driver, REASON_FOR_ORDERING, reasonForOrdering);
		String str = ActionBot.findElement(driver, REASON_FOR_ORDERING).getAttribute("value");
		if (str != null)
		{
			ScreenShot.screenshot(driver, testCaseName, "filled Reason for Ordering");
			return str;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getAccountingInExpandAll(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{

		String accountingInExpandAll = ActionBot.findElement(driver, By.xpath(xpath1_item_summary + itemID + xpath2_accountingData_expandAll)).getText();
		logger.info("GL Account : " + accountingInExpandAll);
		return accountingInExpandAll;
	}

	@Override
	public String getBillToAddressHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String billToAddress = ActionBot.findElement(driver, BILL_TO_ADDRESS).getText();
		if (billToAddress != null)
		{
			return billToAddress;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getBudgetHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String budgetHeader = ActionBot.findElement(driver, BUDGET_HEADER).getText();
		if (budgetHeader != null)
		{
			return budgetHeader;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getBudgetInExpandAll(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{

		String budgetInExpandAll = ActionBot.findElement(driver, By.xpath(".//*[@id='item_summary_" + itemID + "']//*[@class='budget'][string-length(text()) > 0]")).getText();
		if (budgetInExpandAll != null)
		{
			return budgetInExpandAll;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getCostBookingInExpandAll(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{

		String costBookinginExpandAll = ActionBot.findElement(driver, By.xpath(".//*[@id='item_summary_" + itemID + "']//*[@class='costing'][string-length(text()) > 0]"))
			.getText();
		if (costBookinginExpandAll != null)
		{
			return costBookinginExpandAll;
		}
		else
		{
			return null;
		}

	}

	@Override
	public String getCostCenterHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String costCenterHeader = ActionBot.findElement(driver, COST_CENTER_HEADER).getText();
		if (costCenterHeader != null)
		{
			return costCenterHeader;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getDeliverToHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String deliverToHeader = ActionBot.findElement(driver, DELIVER_TO_HEADER).getText();
		if (deliverToHeader != null)
		{
			return deliverToHeader;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getDeliveryAddressHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String deliveryAddressHeader = ActionBot.findElement(driver, DELIVERY_ADDRESS).getText();
		if (deliveryAddressHeader != null)
		{
			return deliveryAddressHeader;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getItemSupplier(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{

		String itemSupplier = ActionBot.findElement(driver, By.xpath(".//*[@id='item_supplier_" + itemID + "']")).getText();
		if (itemSupplier != null)
		{
			return itemSupplier;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getOrganizationUnitHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String organizationUnitHeader = ActionBot.findElement(driver, ORGANIZATION_UNIT).getText();
		if (organizationUnitHeader != null)
		{
			return organizationUnitHeader;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String requiredByDate = ActionBot.findElement(driver, REQUIRED_BY_DATE).getAttribute("value").trim();
		logger.info("Selected Required By Date : " + requiredByDate);
		ScreenShot.screenshot(driver, testCaseName, "After changing required by date");
		if (requiredByDate.equals("-"))
			requiredByDate = "";
		return requiredByDate;
	}

	@Override
	public String selectRequiredByDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.click(driver, REQUIRED_BY_DATE_PICKER);
		// year
		Select select = new Select(ActionBot.findElement(driver, SELECT_YEAR));
		select.selectByValue(year);

		// month
		select = new Select(ActionBot.findElement(driver, SELECT_MONTH));
		select.selectByValue(month);

		// day
		ActionBot.click(driver, By.linkText(day));

		String requiredByDate = ActionBot.findElement(driver, REQUIRED_BY_DATE).getAttribute("value").trim();
		logger.info("Selected Required By Date : " + requiredByDate);
		// ScreenShot.screenshot(driver, testCaseName,
		// "After changing required by date");

		return requiredByDate;
	}

	@Override
	public boolean isApproverListPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.isElementPresent(driver, SELECT_APPROVER_LIST);
	}

	@Override
	public List<WebElement> getListOfApprovers(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, SELECT_APPROVER_LIST);
	}

	@Override
	public boolean isMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, MSGBOX);
	}

	@Override
	public List<WebElement> getListOfMessages(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, MSGBOX);
	}

	@Override
	public void clickOnSelectApprovalButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_APPROVAL_BUTTON);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Select Approval Button");
	}

	@Override
	public boolean isConfirmReqPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, CONFIRM_REQ);
	}

	@Override
	public void clickOnConfirmReqButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CONFIRM_REQ);
		// ActionBot.defaultHighSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Confirm Requisition Button");
	}

	@Override
	public boolean isSubmitReqYesPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, SUBMIT_REQ_YES);
	}

	@Override
	public void clickOnConfirmContinueButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		// ActionBot.click(driver, SUBMIT_REQ_YES);
		// ActionBot.defaultHighSleep();
		PageRequisitionCheckOut.waitTillReqSubmitProcessingDivPresent(driver, testCaseName);
		// ActionBot.waitTillPopUpIsPresent(driver,
		// IPageMyRequisition.REQ_LIST_PROCESSING);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Submit Requisition Button");
	}

	@Override
	public String selectSettlementVia(WebDriver driver, String testCaseName, String settlementVia) throws ActionBotException
	{
		String selectedSettlementVia = null;
		if (ActionBot.isElementPresent(driver, SETTLEMENT_VIA))
		{
			Select select = new Select(ActionBot.findElement(driver, SETTLEMENT_VIA));
			if (settlementVia.equalsIgnoreCase(IConstantsData.SETTLEMENT_VIA_OPTION_INVOICE))
			{
				// select.selectByIndex(0);
				select.selectByVisibleText(IConstantsData.INVOICE_SETTLEMENT_VIA_OPTION);
			}
			else if (settlementVia.equalsIgnoreCase(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD))
			{
				// select.selectByIndex(1);
				select.selectByVisibleText(IConstantsData.PCARD_SETTLEMENT_VIA_OPTION);
			}
			else if (settlementVia.equalsIgnoreCase(IConstantsData.SETTLEMENT_VIA_OPTION_DISBURSEMENT))
			{
				// select.selectByIndex(2);
				select.selectByVisibleText(IConstantsData.DISBURSEMENT_SETTLEMENT_VIA_OPTION);
			}
			selectedSettlementVia = select.getFirstSelectedOption().getText().trim();
		}
		else
		{
			selectedSettlementVia = ActionBot.getTextWithInElement(driver, LABEL_PAYMENT_METHOD_ON_CHECKOUT_PAGE);
		}
		logger.info("Selected Settlement Via : " + selectedSettlementVia);
		// ScreenShot.screenshot(driver, testCaseName,
		// "After selecting settlement via");
		return selectedSettlementVia;
	}

	@Override
	public String getCommentsForSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierComment = ActionBot.findElement(driver, TEXTBOX_COMMENTS_FOR_SUPPLIER_CHECKOUT_PAGE).getAttribute("value").trim();
		logger.info("Entered supplier comment : " + supplierComment);
		ScreenShot.screenshot(driver, testCaseName, "filled comments for supplier");
		return supplierComment;
	}

	@Override
	public void waitTillReqSubmitProcessingDivPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, REQUISITION_SUBMIT_PROCESSING_DIV);
	}

	@Override
	public String selectPCard(WebDriver driver, String testCaseName, String pcard) throws ActionBotException
	{
		String selectedValue = null;
		Select select = new Select(ActionBot.findElement(driver, SELECT_PCARD));
		List<WebElement> options = select.getOptions();
		for (WebElement element : options)
		{
			String var = element.getText().trim();
			if (var.equalsIgnoreCase(pcard.trim()))
			{
				element.click();
				selectedValue = element.getText().trim();
				break;
			}
		}
		// selectedValue = ActionBot.selectElement(driver, SELECT_PCARD,
		// IConstantsData.SELECT_BY_VISIBLE_TEXT, pcard);
		logger.info("Selected PCard Value : " + selectedValue);
		return selectedValue;
	}

	@Override
	public String getSelectedPCard(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.selectElement(driver, SELECT_PCARD, null, null);
	}

	@Override
	public String getSectionNameOfPEForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String sectionName = ActionBot.getTextWithInElement(driver, LABEL_PEFORM_SECTION_ON_CHECKOUT_PAGE);
		logger.info("Section Name of PEform  : " + sectionName);
		return sectionName;
	}

	@Override
	public String getFieldNameOfPEForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String fieldName = ActionBot.getTextWithInElement(driver, LABEL_PEFORM_FIELD_ON_CHECKOUT_PAGE);
		logger.info("Field Name of PEform  : " + fieldName);
		return fieldName;
	}

	@Override
	public String fillFieldValueOfPEForm(WebDriver driver, String testCaseName, String fieldValue) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PEFORM_FIELD_ON_CHECKOUT_PAGE, fieldValue);
		String enteredFieldValue = ActionBot.findElement(driver, TEXTBOX_PEFORM_FIELD_ON_CHECKOUT_PAGE).getAttribute("value").trim();
		logger.info("Entered Field Value of PEForm  : " + enteredFieldValue);
		return enteredFieldValue;
	}

	@Override
	public String getFieldValueOfPEForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String enteredFieldValue = ActionBot.findElement(driver, TEXTBOX_PEFORM_FIELD_ON_CHECKOUT_PAGE).getAttribute("value").trim();
		logger.info("Field Value of PEForm  : " + enteredFieldValue);
		return enteredFieldValue;
	}

	@Override
	public void clickOnAddRequisitionAttachmentLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_ATTACHMENT_ON_CHECKOUT_PAGE);
		ActionBot.defaultHighSleep();
		// ScreenShot.screenshot(driver, testCaseName,
		// "After clicking on add attachment link");
	}

	@Override
	public String getLabelValueOfAddRequisitionAttachmentLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String value = ActionBot.getTextWithInElement(driver, LINK_ADD_ATTACHMENT_ON_CHECKOUT_PAGE);
		logger.info("Label value of attachment link : " + value);
		return value;
	}

	@Override
	public String getDeliveryMultiSplitDeliverTo(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String deliverTo = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='item_summary_" + itemId + "']//td[contains(@class,'itemsdeliverysplit ')]//tr[" + index + "]//*[contains(@class,'deliverTo')]"));
		logger.info("Item Level Delivery Split, Deliver To : " + deliverTo);
		return deliverTo;
	}

	@Override
	public String getDeliveryMultiSplitDeliveryAddress(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String deliveryAddress = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='item_summary_" + itemId + "']//td[contains(@class,'itemsdeliverysplit ')]//tr[" + index + "]//*[contains(@class,'location')]"));
		logger.info("Item Level Delivery Split, Delivery Address : " + deliveryAddress);
		return deliveryAddress;
	}

	@Override
	public String getDeliveryMultiSplitRequiredDate(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String requiredByDate = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='item_summary_" + itemId + "']//td[contains(@class,'itemsdeliverysplit ')]//tr[" + index + "]//*[contains(@class,'deliveryOn')]"));
		logger.info("Item Level Delivery Split, Delivery Date: " + requiredByDate);
		return requiredByDate;
	}

	@Override
	public int getDeliveryMultiSplitQuantity(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String quantity = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='item_summary_" + itemId + "']//td[contains(@class,'itemsdeliverysplit ')]//tr[" + index + "]//*[contains(@class,'splitQty')]"));
		logger.info("Item Level Delivery Split, Quantity : " + quantity);
		String[] temp = StringUtils.split(quantity, " ");
		quantity = "";
		quantity = temp[0].trim();
		return Integer.parseInt(quantity);
	}

	@Override
	public String getCostBookingMultiSplitAtItemLevelCostCenter(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String costCenter = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='item_summary_" + itemId + "']//tr[" + index + "]//div[contains(@class,'costing')]"));
		logger.info("Cost Center : " + costCenter);
		return costCenter;
	}

	@Override
	public String getCostBookingMultiSplitAtItemLevelBudget(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String budget = null;
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='item_summary_" + itemId + "']//tr[" + index + "]//div[contains(@class,'budget')]")))
		{
			budget = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='item_summary_" + itemId + "']//tr[" + index + "]//div[contains(@class,'budget')]"));
			logger.info(" Budget : " + budget);
		}
		else
		{
			logger.info("Budget is not present");
		}
		return budget;
	}

	@Override
	public String getCostBookingMultiSplitAtItemLevelProject(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String project = null;
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='item_summary_" + itemId + "']//tr[" + index + "]//div[contains(@class,'dev_project')]")))
		{
			project = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='item_summary_" + itemId + "']//tr[" + index + "]//div[contains(@class,'dev_project')]"));
			logger.info("Project : " + project);
		}
		else
		{
			logger.info("Project is not present");
		}
		return project;
	}

	@Override
	public String getCostBookingMultiSplitAtItemLevelPrice(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String price = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='item_summary_" + itemId + "']//tr[" + index + "]/td[contains(@class,'iNum value vMiddle')]"));
		logger.info("Price : " + price);
		return price;
	}

	@Override
	public String getWorkflowMessageForForking(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String message = ActionBot.getTextWithInElement(driver, LABEL_WORKFLOW_FOR_FORKING);
		logger.info("Workflow message for forking on checkout screen : " + message);
		return message;
	}

	@Override
	public void clickOnModifyWorkFlowSettings(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (!ActionBot.isElementSelected(driver, CHECKBOX_MODIFY_WORKFLOW_SETTING))
		{
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, CHECKBOX_MODIFY_WORKFLOW_SETTING);
			ScreenShot.screenshot(driver, testCaseName, "After selecting modify workflow setting checkbox");
		}
	}

	@Override
	public void waitTillProgressingDivPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, PROGRESSING_DIV_STATUS_OVERLAY_PLEASE_WAIT);
		// ActionBot.defaultHighSleep();
		// ActionBot.waitForPageLoad(driver);
	}

	@Override
	public String getTotalPriceAtCheckoutHead(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String totalPrice = ActionBot.getTextWithInElement(driver, LABEL_TOAL_PRICE_CHECKOUT_HEAD);
		logger.info("Total Price at checkout head : " + totalPrice);
		return totalPrice;
	}

	@Override
	public String getItemLevelTotalPriceAtCheckoutPage(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String totalPrice = ActionBot.getTextWithInElement(driver, By.id("item_subTotalPrice_" + itemId));
		logger.info("Item level Total Price at checkout page : " + totalPrice);
		return totalPrice;
	}

	@Override
	public String getFirstApproverNameFromWorkflow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String approverName = ActionBot.getTextWithInElement(driver, LABEL_FIRST_APPROVER_NAME_AS_ON_CHECKOUT_PAGE);
		logger.info("First Approver Name : " + approverName);
		return approverName;
	}

	@Override
	public boolean isModifyWorkFlowSettingPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, CHECKBOX_MODIFY_WORKFLOW_SETTING);
	}

	@Override
	public boolean isModifyWorkFlowSettingSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementSelected(driver, CHECKBOX_MODIFY_WORKFLOW_SETTING);
	}

	@Override
	public String getSelectedPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select sel = new Select(ActionBot.findElement(driver, PURCHASE_TYPE));
		String selectedPurchaseType = sel.getFirstSelectedOption().getAttribute("value").trim();
		if (selectedPurchaseType.trim().length() == 0)
		{
			selectedPurchaseType = sel.getFirstSelectedOption().getAttribute("title").trim();
		}
		logger.info("Selected Purchase Type : " + selectedPurchaseType);
		return selectedPurchaseType;
	}

	@Override
	public void clickOnShowAllPosBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SHOW_ALL_PO_BTN);

	}

	@Override
	public boolean isReqCanNotBeLinkedErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, REQ_CAN_NOT_BE_LINKED_ERROR_MSG))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isHeaderLevelProjectDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, HEADER_LEVEL_PROJECT_DETAILS);
		if (ActionBot.isElementPresent(driver, HEADER_LEVEL_PROJECT_DETAILS))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickOnDeliveryItemEdit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DELIVERY_ITEM_EDIT);

	}

	@Override
	public void clickOnCloseCurrencyWiseTotalLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLOSE_MODAL_CURRENCY_WISE_TOTAL_LINK);

	}

	@Override
	public boolean isHeaderCheckoutIconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, HEADER_CHECKOUT_ICON))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickOnClickHereLinkToShowErrors(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLICK_HERE_LINK_TO_SHOW_ERRORS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on click here link to show errors");

	}

	@Override
	public void clickOnAssignedBuyerDropdown(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, DROPDOWN_ASSIGNED_BUYER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on assigned buyer dropdown");

	}

	@Override
	public void clickOnSingleAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_ASSIGNED_BUYER_SINGLE_ICON);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on single assigned buyer icon");

	}

	@Override
	public void clickOnGroupAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_ASSIGNED_BUYER_GROUP_ICON);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on group assigned buyer icon");

	}

	@Override
	public boolean isValidationAlertPopupPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ALERT_AND_ERROR_VALIDATION_CHECKOUT))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnOKForAlertPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultHighSleep();
		ActionBot.click(driver, BUTTON_OK_FOR_VALIDATION_POPUP_CHECKOUT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on OK");

	}

	@Override
	public void clickOnSendItBackToMe(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SEND_FOR_APPROVAL_NO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on No, send it back to me");

	}

	@Override
	public String getGLAccountInfoInExpandAll(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String glAccount = ActionBot.getTextWithInElement(driver, LABEL_ITEM_LEVEL_ACCOUNTING_INFO_GL_ACCOUNT);
		logger.info("Gl Account : " + glAccount);
		return glAccount;
	}

	@Override
	public String getItemId(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		String itemId = ActionBot.getAttributeOfElement(driver, By.xpath(xpath1_itemId + itemName + xpath2_itemId), "id");
		itemId = itemId.substring(5, itemId.length());
		logger.info("Item Id : " + itemId);
		return itemId;
	}

	@Override
	public String getTextOfSubmitButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, I_AM_DONE);
	}

	@Override
	public void clickOnRemoveAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ICON_REMOVE_ASSIGNED_BUYER_CHECKOUT_PAGE))
		{
			List<WebElement> ele = ActionBot.findElements(driver, ICON_REMOVE_ASSIGNED_BUYER_CHECKOUT_PAGE);

			for (WebElement a : ele)
			{
				ActionBot.defaultSleep();
				a.click();
			}
		}
		// ActionBot.click(driver, ICON_REMOVE_ASSIGNED_BUYER_CHECKOUT_PAGE);
	}

	@Override
	public boolean isRequisitionNameTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_REQUISITION_NAME);
	}

	@Override
	public String getItemLevelCurrency(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String currency = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_itemLevelCurrency + itemId + xpath2_itemLevelCurrency));
		logger.info("Item Level Currency : " + currency);
		return currency;
	}

	@Override
	public String getRequesterInWorkflowTrail(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String requetser = ActionBot.getTextWithInElement(driver, LABEL_REQUESTER_NODE_WORKFLOW_EDIT_REQ);
		logger.info("Requester in Workflow Trail : " + requetser);
		return requetser;
	}

	@Override
	public String getCostCenterLabelInHeaderSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String costCenter = ActionBot.getTextWithInElement(driver, LABEL_COST_CENTER_AT_HEADER_SUMMARY);
		logger.info("Cost Center Label in Header Summary : " + costCenter);
		return costCenter;
	}

	@Override
	public void clickEditItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElementAndClick(driver, BUTTON_EDIT_ITEM_SUMMARY);
		waitTillProgressingDivPresent(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "Edit Item Summary Window");
	}

	@Override
	public boolean isSourcingStatusErrorIconPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_ICON_SOURCING_STATUS))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isAssignedBuyerLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABEL_ASSIGNED_BUYER_ON_CHECKOUT_PAGE);
	}

	@Override
	public String getQuantityAmountCurrency(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath(xpath1_qtyAmtCurrency + itemId + xpath2_qtyAmtCurrency));
	}

	@Override
	public String getAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, LABEL_ASSIGNED_BUYER_ON_CHECKOUT_PAGE);
		logger.info("Assigned Buyer Name : " + str);
		return str;
	}

	@Override
	public boolean isPurchaseTypePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PURCHASE_TYPE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String fillAssignedBuyerGroup(WebDriver driver, String testCaseName, String buyer) throws ActionBotException
	{
		ActionBot.defaultHighSleep();
		return ActionBot.fillAutoCompleteField(driver, TEXTBOX_ASSIGNED_BUYER_GROUP, buyer);
	}

	@Override
	public boolean isMisMatchSettlementViaErrorIconPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, ICON_MISMATCH_IN_SETTLEMENT_VIA_ERROR_MSG);
	}

	@Override
	public String getMisMatchSettlementViaErrorMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String errorMsg = ActionBot.getAttributeOfElement(driver, ICON_MISMATCH_IN_SETTLEMENT_VIA_ERROR_MSG, "title");
		logger.info("MisMatch Settlement Via ErrorMsg : " + errorMsg);
		return errorMsg;
	}

	@Override
	public boolean isGivenSettlementViaOptionPresent(WebDriver driver, String testCaseName, String settlementVia) throws ActionBotException
	{
		boolean flag = true;
		Select select = new Select(ActionBot.findElement(driver, SETTLEMENT_VIA));
		List<WebElement> options = select.getOptions();
		for (WebElement element : options)
		{
			if (element.getText().trim().equalsIgnoreCase(settlementVia))
			{
				String attr = element.getAttribute("style");
				if (attr != null)
				{
					if (attr.equalsIgnoreCase("display: none;"))
					{
						flag = false;
					}
				}
				break;
			}
		}
		return flag;
	}

	@Override
	public String getEformTitleSectionLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_EFORM_TITLE_SECTION);
	}

	@Override
	public String getEformSubSectionLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_EFORM_SUB_SECTION);
	}

	@Override
	public String enterEformDetail(WebDriver driver, String testCaseName, String eForm) throws ActionBotException
	{
		return ActionBot.sendKeys(driver, TEXTBOX_EFORM_FIELD_CHECKOUT_ITEM_DETAILS, eForm);
	}

	@Override
	public boolean isPONoErrorOnAttachmentPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultHighSleep();
		ActionBot.hover(driver, ERROR_PO_NO_ATTACHMENT);
		ActionBot.defaultHighSleep();
		return ActionBot.isElementPresent(driver, ERROR_PO_NO_ATTACHMENT);

	}

	@Override
	public void clickOnEformAddAttachmentLink(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, LINK_EFORM_ADD_ATTACHMENT_CHECKOUT);
		ScreenShot.screenshot(driver, testCaseName, "After clciking on eform add attachment link");

	}

	@Override
	public boolean isEformAddAttachmentLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_EFORM_ADD_ATTACHMENT_CHECKOUT))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getSourcingStatusError(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String error = null;
		if (itemId != null)
		{
			if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='item_" + itemId + "']/td[contains(@class,'itemsupp')]/span[contains(@class,'inlineError')]")))
			{
				WebElement element = ActionBot.findElement(driver,
					By.xpath(".//*[@id='item_" + itemId + "']/td[contains(@class,'itemsupp')]/span[contains(@class,'inlineError')]"));
				ActionBot.moveToElement(driver, element);
				error = ActionBot.getAttributeOfElement(driver, By.xpath(".//*[@id='item_" + itemId + "']/td[contains(@class,'itemsupp')]/span[contains(@class,'inlineError')]"),
					"title");
			}
		}
		else
		{
			if (ActionBot.isElementPresent(driver, By.xpath(".//*[contains(@id,'item_')]/td[contains(@class,'itemsupp')]/span[contains(@class,'inlineError')]")))
			{
				WebElement element = ActionBot.findElement(driver, By.xpath(".//*[contains(@id,'item_')]/td[contains(@class,'itemsupp')]/span[contains(@class,'inlineError')]"));
				ActionBot.moveToElement(driver, element);
				error = ActionBot.getAttributeOfElement(driver, By.xpath(".//*[contains(@id,'item_')]/td[contains(@class,'itemsupp')]/span[contains(@class,'inlineError')]"),
					"title");
			}
		}
		logger.info("Sourcing Status Error : " + error);
		return error;
	}

	@Override
	public boolean isItemPresentOnCheckoutPage(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath(xpath1_item_details + itemID + xpath2_item_name));
	}

	@Override
	public void waitForUpdateRequisitionProcessingDiv(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, PROGRESSING_DIV_UPDATE_REQUISITION);
	}

	@Override
	public void waitForLoadingDivOfWorkFlowTrail(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_VIEW_WORKFLOW))
		{
			ActionBot.waitTillPopUpIsPresent(driver, LOADING_DIV_WORKFLOW_TRAIL);

			if (ActionBot.isElementDisplayed(driver, IPageRequisitionCheckOut.LABEL_FIRST_APPROVER_NAME_AS_ON_CHECKOUT_PAGE))
			{
				// do nothing if workflow is open by default
				ScreenShot.screenshot(driver, testCaseName, "Workflow trail automatically displayed");
			}
			else
			{
				// ActionBot.defaultSleep();
				WebElement ele = ActionBot.findElement(driver, LINK_VIEW_WORKFLOW);
				Actions act = new Actions(driver);
				act.moveToElement(ele).click().build().perform();
				ActionBot.defaultSleep();
				ActionBot.scroll(driver, "500");
				ScreenShot.screenshot(driver, testCaseName, "after clicking on view workflow link");
			}
		}
	}

	@Override
	public void clickContinueButtonForConfirmPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultHighSleep();
		if (ActionBot.isElementDisplayed(driver, BUTTON_CONTINUE_CONFIRM_POPUP))
		{
			ActionBot.click(driver, BUTTON_CONTINUE_CONFIRM_POPUP);
			ActionBot.defaultHighSleep();
			ActionBot.waitForPageLoad(driver);
		}
		ScreenShot.screenshot(driver, testCaseName, "After clicking Continue Button");
	}

	@Override
	public String getAssetNoError(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String error = null;
		ActionBot.scroll(driver, "500");
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='item_summary_" + itemId + "']//td[contains(@class,'itemsdeliverysplit')]//a[contains(@class,'inlineError')]")))
		{

			error = ActionBot.getAttributeOfElement(driver,
				By.xpath(".//*[@id='item_summary_" + itemId + "']//td[contains(@class,'itemsdeliverysplit')]//a[contains(@class,'inlineError')]"), "title");
		}
		logger.info("Error message : " + error);
		return error;
	}

	@Override
	public String fillDeliveryRecipientName(WebDriver driver, String testCaseName, String deliveryName) throws ActionBotException
	{

		String str = ActionBot.sendKeys(driver, DELIVERY_DELIVER_TO, deliveryName);
		logger.info("Entered supplier comments : " + str);
		if (str != null)
		{
			return str;
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean isDeliveryRecipientNameEdited(WebDriver driver, String testCaseName, String deliveryName) throws ActionBotException
	{
		String name = ActionBot.getTextWithInElement(driver, DELIVERY_DELIVER_TO);
		if (name.equals(deliveryName))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String fetchDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String address = null;
		if (ActionBot.isElementPresent(driver, DELIVERY_OU_ADDRESS))
		{
			address = ActionBot.getTextWithInElement(driver, DELIVERY_OU_ADDRESS);
		}
		return address;
	}

	@Override
	public String fetchFetchBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String name = null;
		if (ActionBot.isElementPresent(driver, BUSINESS_UNIT))
		{
			name = ActionBot.getTextWithInElement(driver, BUSINESS_UNIT);
		}
		return name;
	}

	@Override
	public String fetchDeliveryRecipientName(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String name = null;
		if (ActionBot.isElementPresent(driver, DELIVERY_DELIVER_TO))
		{
			name = ActionBot.getTextWithInElement(driver, DELIVERY_DELIVER_TO);
		}
		return name;
	}

	@Override
	public String fetchCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String cost_center = null;
		ActionBot.waitForPageLoad(driver);
		ActionBot.waitForElementToBeDisplayed(driver, HEADER_LEVEL_COST_CENTER_SUMMARY, 15);
		if (ActionBot.isElementPresent(driver, HEADER_LEVEL_COST_CENTER_SUMMARY))
		{
			cost_center = ActionBot.getTextWithInElement(driver, HEADER_LEVEL_COST_CENTER_SUMMARY);
		}
		return cost_center;
	}

	@Override
	public void clickCostAllocation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, 5, COST_ALLOCATION);
		ActionBot.click(driver, COST_ALLOCATION);

	}

	@Override
	public boolean isCommentForItemAvailable(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath("(.//*[contains(@class,'comments ')])[" + (index + 1) + "]"));

	}

	@Override
	public String fetchRequisitionCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.getTextWithInElement(driver, BILLING_CURRENCY);
	}

	@Override
	public String fetchRequisitionAmountWithCurrencyForItems(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'item_subTotalPrice')])[" + index + "]"));

	}

	@Override
	public String fetchPurchaseAmountWithCurrencyForItems(WebDriver driver, String testCaseName) throws ActionBotException
	{

		//return ActionBot.getTextWithInElement(driver, By.id("purchaseAmount"));
		return ActionBot.getTextWithInElement(driver, By.xpath("//*[contains(@id,\"totalPrice_\")]"));
		//*[contains(@id,"totalPrice_")]

	}

	@Override
	public void clickCloseRequisitionSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, CLOSE_REQUISTION_SUMMARY);

	}

	@Override
	public String[] getApprovalWorkFlow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.scroll(driver, "500");
		ActionBot.defaultSleep();
		int index = 0;
		List<WebElement> list = ActionBot.findElements(driver, By.xpath("(.//*[@class='dev_displayNameQtip'])/div[1]"));
		list.remove(0);
		int listSize = list.size();
		String workflow[] = new String[listSize];

		if (listSize > 0)

		{

			for (WebElement a : list)

			{
				String displayName = a.getText();
				workflow[index] = displayName;
				index++;
			}
		}

		return workflow;
	}

	@Override
	public boolean isAssignedBuyerTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag = ActionBot.isElementPresent(driver, TEXTBOX_ASSIGNED_BUYER) ? true : false;
		ScreenShot.screenshot(driver, testCaseName, "Check Assigned buyer present");
		return flag;
	}

	public void fillCostbookingSingleProject(WebDriver driver, String testCaseName, String projectName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		if (ActionBot.isElementDisplayed(driver, IPageRequisitionCheckOut.COSTBOOKING_SINGLE_PROJECT))
		{
			ActionBot.fillAutoCompleteField(driver, IPageRequisitionCheckOut.COSTBOOKING_SINGLE_PROJECT, projectName);
		}
		ActionBot.defaultLowSleep();
	}

	public void fillCostbookingSingleBudget(WebDriver driver, String testCaseName, String budgetName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		if (ActionBot.isElementDisplayed(driver, IPageRequisitionCheckOut.COSTBOOKING_SINGLE_BUDGET))
		{
			ActionBot.fillAutoCompleteField(driver, IPageRequisitionCheckOut.COSTBOOKING_SINGLE_BUDGET, budgetName);
		}
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickSaveRequisitionSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SAVEREQSUMMARY);

	}

	@Override
	public boolean isEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.isElementPresent(driver, I_AM_DONE);
	}

	@Override
	public boolean isRowPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath("(.//*[contains(@id,'item_')]//td[@class='col-itemno'])[" + index + "]"));

	}

	public boolean clickEditItemRequisitionindexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException, InterruptedException
	{
		try
		{
			/*
			 * ActionBot.waitForElementToBeDisplayed(driver, By.xpath(
			 * "(.//*[contains(@id,'item_')]//td[contains(@class,'col-actions')]//a[contains(@class,'edit splitItem')])["
			 * + index + "]"), 5); ActionBot.click(driver, By.xpath(
			 * "(.//*[contains(@id,'item_')]//td[contains(@class,'col-actions')]//a[contains(@class,'edit splitItem')])["
			 * + index + "]"));
			 */
			ActionBot.waitForElementToBeDisplayed(driver,
				By.xpath("(.//*[contains(@id,'item_')]//td[contains(@class,'col-actions')]//a[contains(@class,'edit splitItem')])[" + index + "]"), 10);
			WebElement element = driver
				.findElement(By.xpath("(.//*[contains(@id,'item_')]//td[contains(@class,'col-actions')]//a[contains(@class,'edit splitItem')])[" + index + "]"));
			/*
			 * Actions actions = new Actions(driver);
			 * actions.moveToElement(element).click().perform();
			 */
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0," + element.getLocation().y + ")");
			element.click();
			ActionBot.defaultLowSleep();
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void clickDeliveryMultiOptionSplit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, 5, DELIVERY_OPTION_MULTI_SPLIT);

		ActionBot.waitForElementToBeDisplayed(driver, DELIVERY_OPTION_MULTI_SPLIT, 5);
		ActionBot.click(driver, DELIVERY_OPTION_MULTI_SPLIT);
	}

	public boolean isRequisitionSummaryButtonVisible(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, IPageRequisitionCheckOut.SAVEREQSUMMARY);
	}

	public void searchCategoryinGuidedItemPopup(WebDriver driver, String testCaseName, String category) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, IPageRequisitionCheckOut.CATEGORY_GUIDED_FREE_TEXT, category);
	}

	@Override
	public void enterDeliverToNameInDeliverySplitIndexwise(WebDriver driver, String testCaseName, int index, String name) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'deliverTo_')])[" + index + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'deliverTo_')])[" + index + "]"), 5);
		WebElement element = ActionBot.findElement(driver, By.xpath("(.//*[contains(@id,'deliverTo_')])[" + index + "]"));

		if (element.getText() != null)
		{
			element.clear();
		}

		//	element.sendKeys(name);
		ActionBot.fillAutoCompleteField(driver, element, name);
		//WebElement element1 = ActionBot.findElement(driver, By.id("ui-id-5"));
		//element1.sendKeys(Keys.ARROW_DOWN);
		//element1.sendKeys(Keys.ENTER);
	}

	public void increaseDeliverQunatityInDeliverySplitIndexwise(WebDriver driver, String testCaseName, int index, int qty) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'quantity_')])[" + (index + 1) + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'quantity_')])[" + (index + 1) + "]"), 5);
		ActionBot.sendKeys(driver, By.xpath("(.//*[contains(@id,'quantity_')])[" + (index + 1) + "]"),
			Integer.toString(Integer.parseInt(ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'quantity_')])[" + (index + 1) + "]"))) + 10));

	}

	public void decreaseDeliverQunatityInDeliverySplitIndexwise(WebDriver driver, String testCaseName, int index, int qty) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'quantity_')])[" + (index + 1) + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'quantity_')])[" + (index + 1) + "]"), 5);
		ActionBot.sendKeys(driver, By.xpath("(.//*[contains(@id,'quantity_')])[" + (index + 1) + "]"),
			Integer.toString(Integer.parseInt(ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'quantity_')])[" + (index + 1) + "]"))) - qty));
	}

	public void clickToExpandItemDetailsIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		try
		{
			ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'item_')]//span[contains(@class,'expandLnk')])[" + index + "]"), 10);
			ActionBot.click(driver, By.xpath("(.//*[contains(@id,'item_')]//span[contains(@class,'expandLnk')])[" + index + "]"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public boolean isRequiredByDateEmpty(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String va = ActionBot.getTextWithInElement(driver, REQUIRED_BY_DELIVERY_DATE);
		if (va == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String fetchRequisitionName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, TEXTBOX_REQUISITION_NAME);
	}

	@Override
	public void clickDeliveryEditRequisitionSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, 5, EDIT_DELIVERY_REQUISITION_SUMMARY);
		ActionBot.waitForElementToBeDisplayed(driver, EDIT_DELIVERY_REQUISITION_SUMMARY, 5);
		ActionBot.click(driver, EDIT_DELIVERY_REQUISITION_SUMMARY);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickMyAddressRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, 5, MY_ADDRESS);
		ActionBot.waitForElementToBeDisplayed(driver, MY_ADDRESS, 5);
		ActionBot.click(driver, MY_ADDRESS);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickToEnterNewAddressLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, 5, ENTER_NEW_ADDRESS);
		ActionBot.waitForElementToBeDisplayed(driver, ENTER_NEW_ADDRESS, 5);
		ActionBot.click(driver, ENTER_NEW_ADDRESS);
	}

	@Override
	public void fillMyCustomDeliveryAddressName(WebDriver driver, String testCaseName, String name) throws Exception
	{
		ActionBot.waitForElementToBePresent(driver, 5, DELIVERY_MY_ADDRESS_NAME);
		ActionBot.waitForElementToBeDisplayed(driver, DELIVERY_MY_ADDRESS_NAME, 5);
		ActionBot.sendKeys(driver, DELIVERY_MY_ADDRESS_NAME, name);
	}

	@Override
	public void fillMyCustomDeliveryStreetAddress(WebDriver driver, String testCaseName, String address) throws Exception
	{
		ActionBot.waitForElementToBePresent(driver, 5, DELIVERY_MY_ADDRESS_STREET1);
		ActionBot.waitForElementToBeDisplayed(driver, DELIVERY_MY_ADDRESS_STREET1, 5);
		ActionBot.sendKeys(driver, DELIVERY_MY_ADDRESS_STREET1, address);
	}

	@Override
	public void fillMyCustomDeliveryCountry(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForElementToBePresent(driver, 5, DELIVERY_MY_ADDRESS_COUNTRY);
		ActionBot.waitForElementToBeDisplayed(driver, DELIVERY_MY_ADDRESS_COUNTRY, 5);
		WebElement element = ActionBot.findElement(driver, DELIVERY_MY_ADDRESS_COUNTRY);
		for (int i = 0; i <= 3; i++)
		{
			element.sendKeys(Keys.ARROW_DOWN);
		}
		element.sendKeys(Keys.ENTER);
	}

	@Override
	public boolean deleteReqItemInCart(WebDriver driver, String testCaseName, int index)
	{
		try
		{
			ActionBot.scroll(driver, "200");
			ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'item_')]//a[contains(@class,'delete')])[" + index + "]"));
			ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'item_')]//a[contains(@class,'delete')])[" + index + "]"), 5);
			ActionBot.click(driver, By.xpath("(.//*[contains(@id,'item_')]//a[contains(@class,'delete')])[" + index + "]"));
			ActionBot.waitForElementToBePresent(driver, 5, YES_CONFIRMATION);
			ActionBot.waitForElementToBeDisplayed(driver, YES_CONFIRMATION, 5);
			ActionBot.click(driver, YES_CONFIRMATION);
			return true;
		}
		catch (ActionBotException e)
		{
			return false;
		}
	}

	@Override
	public void toAddNewReqItemInCart(WebDriver driver, String testCaseName, int index) throws Exception
	{
		ActionBot.waitForElementToBePresent(driver, 5, ADD_ITEM_ON_CHECKOUT);
		ActionBot.waitForElementToBeDisplayed(driver, ADD_ITEM_ON_CHECKOUT, 5);
		ActionBot.click(driver, ADD_ITEM_ON_CHECKOUT);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickToAddADeliverySplitIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'delivery_')]//a[@class='icon add'])[" + index + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'delivery_')]//a[@class='icon add'])[" + index + "]"), 5);
		//ActionBot.click(driver, By.xpath("(.//*[contains(@id,'delivery_dbaed')]//a[@class='icon add'])[" + index + "]"));
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'delivery_')]//a[@class='icon add'])[" + index + "]"));

	}

	@Override
	public void toSplitIntoMultipleCostCenter(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForElementToBePresent(driver, 5, COSTBOOKING_OPTION_MULTIPLE_CC);
		ActionBot.waitForElementToBeDisplayed(driver, COSTBOOKING_OPTION_MULTIPLE_CC, 5);
		ActionBot.click(driver, COSTBOOKING_OPTION_MULTIPLE_CC);
	}

	@Override
	public void clicktoAddCostSplitIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[@id='entity_costing_0']//a)[" + (index + 2) + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[@id='entity_costing_0']//a)[" + (index + 2) + "]"), 5);
		ActionBot.click(driver, By.xpath("(.//*[@id='entity_costing_0']//a)[" + (index + 2) + "]"));
	}

	@Override
	public void clicktoAddItemLevelCostSplitIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'delivery_')]//a[@class='icon add'])[" + index + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'delivery_')]//a[@class='icon add'])[" + index + "]"), 5);
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'delivery_')]//a[@class='icon add'])[" + index + "]"));
	}

	@Override
	public void selectCostCenter(WebDriver driver, String testCaseName, int index) throws Exception
	{
		ActionBot.defaultSleep();
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'entity_costing_costCenter_')])[" + index + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'entity_costing_costCenter_')])[" + index + "]"), 5);
		WebElement element = ActionBot.findElement(driver, By.xpath("(.//*[contains(@id,'entity_costing_costCenter_')])[" + index + "]"));
		ActionBot.fillAutoCompleteField(driver, element, "cc3");
	}

	@Override
	public void toIncreaseCostPercentageIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		ActionBot.defaultHighSleep();
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'entity_costing_percentage_')])[" + index + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'entity_costing_percentage_')])[" + index + "]"), 5);
		int qty = Integer.parseInt(ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'entity_costing_percentage_')])[" + index + "]")));
		qty = qty + 5;
		ActionBot.sendKeys(driver, By.xpath("(.//*[contains(@id,'entity_costing_percentage_')])[" + index + "]"), Integer.toString(qty));
	}

	@Override
	public void toDecreaseCostPercentageIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'entity_costing_percentage_')])[" + index + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'entity_costing_percentage_')])[" + index + "]"), 5);
		int qty = Integer.parseInt(ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'entity_costing_percentage_')])[" + index + "]")));
		qty = qty - 5;
		ActionBot.sendKeys(driver, By.xpath("(.//*[contains(@id,'entity_costing_percentage_')])[" + index + "]"), Integer.toString(qty));
	}

	@Override
	public boolean toSelectBillingCurrencyChoiceWise(WebDriver driver, String testCaseName, int choice, String currency) throws Exception
	{
		try
		{
			ActionBot.waitForElementToBePresent(driver, 5, BILLING_CURRENCY);
			ActionBot.waitForElementToBeDisplayed(driver, BILLING_CURRENCY, 5);
			WebElement element = ActionBot.findElement(driver, BILLING_CURRENCY);
			ActionBot.fillAutoCompleteField(driver, element, currency);
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isCurrencyWiseTotalLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		//ActionBot.waitForElementToBePresent(driver, 5, CURRENCY_WISE_TOTAL);
		return ActionBot.isElementPresent(driver, CURRENCY_WISE_TOTAL);
	}

	@Override
	public boolean isItemNumberPresentInEachGrid(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		boolean status = true;
		int i = 1;
		do
		{
			if (status != false && (!(ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'item_')]//a[contains(@class,'itemNo')])[" + i + "]"))).equals("-")))
			{
				status = true;
			}
			else
			{
				status = false;
			}
			i++;
		} while (ActionBot.isElementDisplayed(driver, By.xpath(".//*[contains(@id,'item_')]//td[contains(@class,'itemno')])[" + i + "]")));
		return status;
	}

	@Override
	public boolean isItemNameSupplierNamePresentInEachGrid(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		boolean status = true;
		int i = 1;
		do
		{
			if (status != false
				&& (!((ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'item_')]//a[contains(@class,'itemnamelnk')])[" + i + "]"))).equals("-")))
				&& (ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'item_supplier_')])[" + i + "]")) != ""))
			{
				status = true;
			}
			else
			{
				status = false;
			}
			i++;
		} while (ActionBot.isElementDisplayed(driver, By.xpath("(.//*[contains(@id,'item_')]//td[contains(@class,'itemsupp')])[" + i + "]")));
		return status;
	}

	@Override
	public boolean isItemUnitPricePresentInEachGrid(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		boolean status = true;
		int i = 1;
		do
		{
			if (status != false && !((ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'item_lblPrice_')])[" + i + "]"))).equals("")))
			{
				status = true;
			}
			else
			{
				status = false;
			}
			i++;
		} while (ActionBot.isElementDisplayed(driver, By.xpath("(.//*[contains(@id,'item_')]//td[contains(@class,'unitprice')])[" + i + "]")));
		return status;
	}

	@Override
	public boolean isItemQtyPresentInEachGrid(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		boolean status = true;
		int i = 1;
		do
		{
			if (status != false && (Integer.parseInt(ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'item_quantity_')])[" + i + "]"))) >= 1))
			{
				if (ActionBot.isElementEnabled(driver, By.xpath("(.//*[contains(@id,'item_quantity_')])[" + i + "]")))
					status = true;
			}
			else
			{
				status = false;
			}
			i++;
		} while (ActionBot.isElementDisplayed(driver, By.xpath("(.//*[contains(@id,'item_')]//td[contains(@class,'qty')])[" + i + "]")));
		return status;
	}

	@Override
	public boolean isMyAddressPresentInDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		boolean status = false;
		ActionBot.waitForElementToBeDisplayed(driver, MY_ADDRESS_OPTION, 5);
		if (ActionBot.isElementDisplayed(driver, MY_ADDRESS_OPTION))
		{
			if (ActionBot.isElementEnabled(driver, MY_ADDRESS_OPTION))
				status = true;
		}
		return status;
	}

	@Override
	public boolean isCurrencyWiseAmmountPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		boolean status = false;
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[@id='tblCurrencyWiseTotal']//td[contains(@class,'amount')])[" + (index + 1) + "]"), 5);
		if (ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@id='tblCurrencyWiseTotal']//td[contains(@class,'amount')])[" + (index + 1) + "]")))
		{
			status = true;
		}
		return status;
	}

	@Override
	public void clickOnCurrencyWiseTotalLink(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForElementToBePresent(driver, 5, CURRENCY_WISE_TOTAL);
		ActionBot.waitForElementToBeDisplayed(driver, CURRENCY_WISE_TOTAL, 5);
		ActionBot.click(driver, CURRENCY_WISE_TOTAL);
	}

	@Override
	public boolean isTotalAmmountPresent(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath(".//*[@id='tblCurrencyWiseTotal']//span[contains(@class,'totalPrice')]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(".//*[@id='tblCurrencyWiseTotal']//span[contains(@class,'totalPrice')]"), 5);
		return ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='tblCurrencyWiseTotal']//span[contains(@class,'totalPrice')]"));
	}

	@Override
	public boolean deleteItemInCartIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'cart_item_delete_')])[" + index + "]"), 5);
			ActionBot.click(driver, By.xpath("(.//*[contains(@id,'cart_item_delete_')])[" + index + "]"));
			ActionBot.waitForElementToBeDisplayed(driver, YES_CONFIRMATION, 5);
			ActionBot.click(driver, YES_CONFIRMATION);
			ActionBot.defaultLowSleep();
			if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.NO_CART_CONTINUE_BUTTON))
				PageOnlineStore.clickOnNoCartContinueShopping(driver, testCaseName);
			else
				PageOnlineStore.clickOnContinueShopping(driver, testCaseName);
			return true;
		}
		catch (ActionBotException e)
		{
			// e.printStackTrace();
			return false;
		}
	}

	@Override
	public void toSelectProjectIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'entity_costing_project_')])[" + index + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'entity_costing_project_')])[" + index + "]"), 5);
		WebElement element = ActionBot.findElement(driver, By.xpath("(.//*[contains(@id,'entity_costing_project_')])[" + index + "]"));
		ActionBot.fillAutoCompleteField(driver, element, "p");
	}

	@Override
	public void toSelectBudgetIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'entity_costing_budget_')])[" + index + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'entity_costing_budget_')])[" + index + "]"), 5);
		WebElement element = ActionBot.findElement(driver, By.xpath("(.//*[contains(@id,'entity_costing_budget_')])[" + index + "]"));
		ActionBot.fillAutoCompleteField(driver, element, "t");
	}

	@Override
	public boolean isCatLogItemDetailsPresent(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForElementToBeDisplayed(driver, CAT_ITEM_POP_DETAILS, 5);
		return ActionBot.isElementDisplayed(driver, CAT_ITEM_POP_DETAILS);
	}

	@Override
	public void clickOnYesConfirmationLink(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForElementToBeDisplayed(driver, YES_CONFIRMATION, 5);
		ActionBot.click(driver, YES_CONFIRMATION);
	}

	@Override
	public boolean isGuidedItemDetailsPresent(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForElementToBeDisplayed(driver, GUIDED_ITEM_POPUP, 5);
		return ActionBot.isElementDisplayed(driver, GUIDED_ITEM_POPUP);
	}

	@Override
	public boolean isRequiredByDateMissingValueErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, REQUIRED_BY_DATE_ERROR_MESSAGE, 5);
		boolean status = ActionBot.isElementDisplayed(driver, REQUIRED_BY_DATE_ERROR_MESSAGE);
		PageRequisitionCheckOut.clickCloseRequisitionSummary(driver, testCaseName);
		return status;
	}

	@Override
	public String getBillingCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, BILLING_CURRENCY, 5);
		return ActionBot.getTextWithInElement(driver, BILLING_CURRENCY);
	}

	@Override
	public String getItemSubTotalrowise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'item_subTotalPrice_')])[" + index + "]"));
	}

	@Override
	public String getPurchaseTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, PURCHASE_AMOUNT);
	}

	@Override
	public String getItemUnitCurrencyIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'item_')]//span[contains(@class,'lblCurrency')])[" + index + "]"));
	}

	@Override
	public void clickEditItemRequisition(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, EDIT_ITEM_REQUISTION_COST_ALLOCATION);
	}

	@Override
	public boolean isOptionCopyCostCenterInfoPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.id("lnkSplitCostingLevelItem"));
	}

	@Override
	public boolean isCostBookingOptionPercentageSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementSelected(driver, COSTBOOKING_ITEM_SPLIT_OPTION_PERCENT);
	}

	@Override
	public boolean isCostBookingOptionQuantityPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, COSTBOOKING_ITEM_SPLIT_OPTION_QUANTITY);
	}

	@Override
	public void clickCopyCostBookingAtItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, By.id("lnkSplitCostingLevelItem")))
		{
			ActionBot.click(driver, By.id("lnkSplitCostingLevelItem"));
			ActionBot.waitForElementToBeDisplayed(driver, YES_CONFIRMATION, 5);
			ActionBot.click(driver, YES_CONFIRMATION);
		}
	}

	@Override
	public void autoFillCostBookingAtItemLevel(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		if (index != 1)
		{
			WebElement element1 = ActionBot.findElement(driver, By.xpath("(.//*[contains(@id,'costing_item_costCenter_')])[" + index + "]"));
			ActionBot.fillAutoCompleteField(driver, element1, " ");
		}
		WebElement element1 = ActionBot.findElement(driver, By.xpath("(.//*[contains(@id,'costing_item_project_')])[" + index + "]"));
		ActionBot.fillAutoCompleteField(driver, element1, "P");
		WebElement element2 = ActionBot.findElement(driver, By.xpath("(.//*[contains(@id,'costing_item_budget_')])[" + index + "]"));
		ActionBot.fillAutoCompleteField(driver, element2, "Auto");
		PageRequisitionCheckOut.increaseCostAllocationPercentageInCostAllocSplitIndexwise(driver, testCaseName, index, 1);
		PageRequisitionCheckOut.decreaseCostAllocationPercentageInCostAllocSplitIndexwise(driver, testCaseName, 1, 1);
	}

	@Override
	public void clickItemLevelCostCenterSplitIndexWise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'costing_item_')]//a[@class='icon add'])[" + index + "]"));
	}

	@Override
	public void clickToSaveItemSummaryRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ITEMSUMMARY_SAVE);
	}

	@Override
	public String getItemLevelCostCenterIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'item_summary_')]//div[contains(@class,'costing')])[" + index + "]"));
	}

	@Override
	public String getItemLevelProjectIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'item_summary_')]//div[contains(@class,'dev_project')])[" + index + "]"));
	}

	@Override
	public String getItemLevelBudgetIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'item_summary_')]//div[contains(@class,'budget')])[" + index + "]"));
	}

	@Override
	public String getHeaderLevelBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, HEADER_LEVEL_BUDGET_SUMMARY);
	}

	@Override
	public String getHeaderLevelProject(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, HEADER_LEVEL_PROJECT_SUMMARY);
	}

	@Override
	public String getHeaderLevelCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, HEADER_LEVEL_COST_CENTER_SUMMARY);
	}

	@Override
	public boolean isDeliveryInformationFromRequisitionSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, DELIVERY_OPTION_SINGLE_SPLIT);
	}

	@Override
	public String fetchCostCenterHeaderIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'entity_costing_costCenter_')])[" + index + "]"));
	}

	@Override
	public String fetchCheckoutItemQuantity(WebDriver driver, String testCaseName) throws Exception
	{
		return ActionBot.getTextWithInElement(driver, CHECKOUT_CART_ITEM_QUANTITY);
	}

	@Override
	public void clickItemDescriptionLinkIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'item_')]//a[contains(@class,'itemnamelnk')])[" + index + "]"));
	}

	@Override
	public void clickCloseItemDescriptionLinkIndexwise(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.click(driver, By.xpath("(.//button[@title='Close'])[9]"));
	}

	@Override
	public void increaseCostAllocationPercentageInCostAllocSplitIndexwise(WebDriver driver, String testCaseName, int index, int qty) throws ActionBotException
	{
		ActionBot.defaultHighSleep();
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'costing_item_percentage_')])[" + index + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'costing_item_percentage_')])[" + index + "]"), 5);
		int percentage = Integer.parseInt(ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'costing_item_percentage_')])[" + index + "]")));
		percentage = percentage + qty;
		ActionBot.sendKeys(driver, By.xpath("(.//*[contains(@id,'costing_item_percentage_')])[" + index + "]"), Integer.toString(percentage));
	}

	@Override
	public void decreaseCostAllocationPercentageInCostAllocSplitIndexwise(WebDriver driver, String testCaseName, int index, int qty) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'costing_item_percentage_')])[" + index + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'costing_item_percentage_')])[" + index + "]"), 5);
		int percentage = Integer.parseInt(ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'costing_item_percentage_')])[" + index + "]")));
		percentage = percentage - qty;
		ActionBot.sendKeys(driver, By.xpath("(.//*[contains(@id,'costing_item_percentage_')])[" + index + "]"), Integer.toString(percentage));
	}

	@Override
	public String fetchBillingAddressFromHeader(WebDriver driver, String testCaseName) throws Exception
	{
		return ActionBot.getTextWithInElement(driver, BILL_TO_ADDRESS);
	}

	@Override
	public void fillBillingCompanyName(WebDriver driver, String testCaseName, String ComapnyName) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, BILLING_COMPANY, ComapnyName);
	}

	@Override
	public void fillBillingBusinessUnitName(WebDriver driver, String testCaseName, String bu) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, BILLING_BU, bu);
	}

	@Override
	public void fillBillingLocationName(WebDriver driver, String testCaseName, String loc) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, BILLING_LOCATION, loc);
	}

	@Override
	public void fillScriptedBillingLocationName(WebDriver driver, String testCaseName, String loc) throws ActionBotException
	{
		ActionBot.sendKeys(driver, BILLING_LOCATION, loc);
	}

	@Override
	public boolean isValidState(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			WebElement elementCountry = ActionBot.findElement(driver, DELIVERY_MY_ADDRESS_COUNTRY);
			elementCountry.click();
			elementCountry.sendKeys("India");
			elementCountry.sendKeys(Keys.ENTER);
			WebElement elementState = ActionBot.findElement(driver, DELIVERY_MY_ADDRESS_STATE);
			elementState.click();
			elementState.sendKeys(CommonServices.getTestData(IConstantsData.NEW_ADDRESS_STATE));
			elementState.sendKeys(Keys.ENTER);
			ActionBot.defaultLowSleep();
			if (ActionBot.getTextWithInElement(driver, DELIVERY_MY_ADDRESS_STATE).contains(CommonServices.getTestData(IConstantsData.NEW_ADDRESS_STATE)))
				return true;
			else
				return false;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean isContractNumberPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		String number = ActionBot.getTextWithInElement(driver, By.xpath(".//*[contains(@id,'item_detail_popup_')]//span[contains(@class,'contractNo')]"));
		if (number.equals("-"))
			return true;
		else
			return false;
	}

	@Override
	public void clickSaveFreeTextButton(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForElementToBeDisplayed(driver, BUTTON_SAVE_GUIDED_ITEM, 30);
		ActionBot.click(driver, BUTTON_SAVE_GUIDED_ITEM);
	}

	@Override
	public void clickCancelFreeTextButton(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForElementToBeDisplayed(driver, BUTTON_CANCEL_GUIDED_ITEM, 30);
		ActionBot.click(driver, BUTTON_CANCEL_GUIDED_ITEM);
	}

	@Override
	public String getQuantityFreeTextItemValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, QUANTITY_GUIDED_FREE_TEXT);
	}

	@Override
	public String getDescriptionFreeTextItemValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, DESCRIPTION_GUIDED_FREE_TEXT);
	}

	@Override
	public String getPriceFreeTextItemValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, PRICE_GUIDED_FREE_TEXT);
	}

	@Override
	public void fillCurrencyForItemDetailPopup(WebDriver driver, String testCaseName, String currency) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.fillAutoCompleteField(driver, CURRENCY_ITEM_DETAIL_POPUP, currency);
	}

	@Override
	public boolean isItemWithQuotedBySupplierSourcingStatusPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath(".//*[contains(@id,'item')]//span[@title='Quoted by supplier']"));
	}

	@Override
	public boolean isCostAllocationTabVisible(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, IPageRequisitionCheckOut.COST_ALLOCATION);
	}

	@Override
	public boolean isDeliveryTabVisible(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, IPageRequisitionCheckOut.EDIT_DELIVERY_REQUISITION_SUMMARY);
	}

	@Override
	public boolean isBillingTabVisible(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, IPageRequisitionCheckOut.BILLING_ALLOCATION);
	}

	@Override
	public boolean isEditRequistionSummaryVisible(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath(".//div[contains(@class,'ui-dialog-titlebar')]//span[contains(@id,'ui')][contains(text(),'Requisition ')]"));
	}

	@Override
	public boolean isSubmitionSuccessfullyDone(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='hedaerSuccessBox']//li"));
	}

	@Override
	public void fillMyCustomDeliveryCity(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForElementToBePresent(driver, 5, DELIVERY_MY_ADDRESS_CITY);
		ActionBot.waitForElementToBeDisplayed(driver, DELIVERY_MY_ADDRESS_CITY, 5);
		ActionBot.sendKeys(driver, DELIVERY_MY_ADDRESS_CITY, Helper.getRandomString(4));
	}

	@Override
	public boolean verifyFinalAmountGenerated_COA(WebDriver driver, String testCaseName, CostBookingAndAccountingItemSummaryCOA costbookigitemsummary)
		throws ActionBotException, NumberFormatException
	{
		int i = 1;
		boolean status[] = new boolean[costbookigitemsummary.getSplit()];

		double totalGeneratedAmount = 0;
		try
		{
			double amount = ModelItemSummaryCostBooking.getTotalAmountFromItemSummary(driver, testCaseName);

			if (costbookigitemsummary.getSplitBy().equalsIgnoreCase(IConstantsData.PERCENTAGE))
			{
				// to scroll till percentage field
				WebElement element = ActionBot.findElement(driver, IModelItemSummaryCostBooking.COA_FORM_TEXT_PERCENTAGE);
				ActionBot.scroll(driver, element);

				while (i <= costbookigitemsummary.getSplit())
				{
					int enteredPercentage = Integer.parseInt(
						ActionBot.findElement(driver, By.xpath("(.//*[contains(@class,'eformDataTable ')]//*[contains(@class,'Percentage')])[" + (i + 1) + "]")).getText());

					double finalAmount = (amount * enteredPercentage) / 100;
					WebElement ele = ActionBot.findElement(driver, By.xpath("(.//*[contains(@class,'eformDataTable ')]//*[contains(@class,'FinalAmount')])[" + i + "]"));
					ActionBot.scroll(driver, ele);

					double uiFinalAmount = Double
						.parseDouble(ActionBot.findElement(driver, By.xpath("(.//*[contains(@class,'eformDataTable ')]//*[contains(@class,'FinalAmount')])[" + i + "]")).getText());
					totalGeneratedAmount = totalGeneratedAmount + uiFinalAmount;
					status[i - 1] = finalAmount == uiFinalAmount;
					i++;
				}
			}
			else if (costbookigitemsummary.getSplitBy().equalsIgnoreCase(IConstantsData.Quantity))
			{
				double quantity = ModelItemSummaryCostBooking.getQuantityFromItemSummary(driver, testCaseName);

				while (i <= costbookigitemsummary.getSplit())
				{
					int enteredQuantity = Integer
						.parseInt(ActionBot.findElement(driver, By.xpath("(.//*[contains(@class,'eformDataTable ')]//*[contains(@class,'Quantity')])[" + (i + 1) + "]")).getText());
					// int finalAmount = (amount * enteredQuantity) / quantity;
					double finalAmount = (amount * enteredQuantity) / quantity;

					if (Double.isNaN(finalAmount))
					{
						finalAmount = 0.0;
					}

					WebElement ele = ActionBot.findElement(driver, By.xpath("(.//*[contains(@class,'eformDataTable ')]//*[contains(@class,'FinalAmount')])[" + i + "]"));
					ActionBot.scroll(driver, ele);

					/*
					 * int uiFinalAmount = (int)Double
					 * .parseDouble(ActionBot.findElement(driver, By.
					 * xpath("(.//*[contains(@class,'eformDataTable ')]//*[contains(@class,'FinalAmount')])["
					 * + i + "]")).getText());
					 */
					double uiFinalAmount = Double
						.parseDouble(ActionBot.findElement(driver, By.xpath("(.//*[contains(@class,'eformDataTable ')]//*[contains(@class,'FinalAmount')])[" + i + "]")).getText());

					totalGeneratedAmount = totalGeneratedAmount + uiFinalAmount;
					status[i - 1] = finalAmount == uiFinalAmount;
					i++;
				}
			}
			else if (costbookigitemsummary.getSplitBy().equalsIgnoreCase(IConstantsData.AMOUNT))
			{
				while (i <= costbookigitemsummary.getSplit())
				{
					int enteredAmount = (int) Double.parseDouble(
						ActionBot.findElement(driver, By.xpath("(.//*[contains(@class,'eformDataTable ')]//*[contains(@class,'Amount')][1])[" + (i + 1) + "]")).getText());
					int finalAmount = enteredAmount;
					WebElement ele = ActionBot.findElement(driver, By.xpath("(.//*[contains(@class,'eformDataTable ')]//*[contains(@class,'FinalAmount')])[" + i + "]"));
					ActionBot.scroll(driver, ele);

					int uiFinalAmount = (int) Double
						.parseDouble(ActionBot.findElement(driver, By.xpath("(.//*[contains(@class,'eformDataTable ')]//*[contains(@class,'FinalAmount')])[" + i + "]")).getText());
					totalGeneratedAmount = totalGeneratedAmount + uiFinalAmount;
					status[i - 1] = finalAmount == uiFinalAmount;
					i++;
				}
			}

			costbookigitemsummary.setFinalUIAmount(totalGeneratedAmount);
		}
		catch (NumberFormatException e)
		{
			logger.error("NumberFormatException in method verifyFinalAmountGenerated_COA " + e, e);
		}

		// returns false if final amount is not calculated properly
		if (Booleans.asList(status).contains(false))
		{
			return false;
		}
		else
			return true;
	}

	@Override
	public void clickOnCostBookingItemEdit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, COST_BOOKING_ITEM_EDIT);

	}

	@Override
	public void clickButtonKeepAllItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_KEEP_ALL_ITEMS);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Keep All Items");
	}

	@Override
	public void clickLinkDeleteAllItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DELETE_ALL_ITEMS);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Delete All Items");
	}

	public boolean isHeaderErrorMsgPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, HEADER_ERROR_MSG_CHECKOUT_PAGE))
		{
			return true;
		}
		return false;
	}

	@Override
	public String fillSharePointURL_EForm(WebDriver driver, String testCaseName, String sharePointURL) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, INPUT_SHARE_POINT_URL_EFORM))
		{
			ActionBot.clear(driver, INPUT_SHARE_POINT_URL_EFORM);
			sharePointURL = ActionBot.sendKeys(driver, INPUT_SHARE_POINT_URL_EFORM, sharePointURL);
			return sharePointURL;
		}
		return null;

	}

	@Override
	public String fillInternalDeliveryLocation_EForm(WebDriver driver, String testCaseName, String internalDeliveryLocation) throws ActionBotException
	{

		ActionBot.defaultHighSleep();
		if (ActionBot.isElementDisplayed(driver, SELECT_INTERNAL_DELIVERY_LOCATION_EFORM))
		{

			Select select = new Select(ActionBot.findElement(driver, SELECT_INTERNAL_DELIVERY_LOCATION_EFORM));

			select.selectByVisibleText(internalDeliveryLocation);

			return select.getFirstSelectedOption().getText().trim();
		}

		return null;

	}

	@Override
	public String fillDeliveryInstructions_EForm(WebDriver driver, String testCaseName, String deliveryInstructions) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTAREA_DELIVERY_INSTRUCTION_EFORM))
		{
			ActionBot.clear(driver, TEXTAREA_DELIVERY_INSTRUCTION_EFORM);
			deliveryInstructions = ActionBot.sendKeys(driver, TEXTAREA_DELIVERY_INSTRUCTION_EFORM, deliveryInstructions);
			return deliveryInstructions;

		}
		return null;

	}

	@Override
	public String fillEstimatedFreight_EForm(WebDriver driver, String testCaseName, String estimatedFreight) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, INPUT_ESTIMATED_FREIGHT_EFORM))
		{
			ActionBot.clear(driver, INPUT_ESTIMATED_FREIGHT_EFORM);
			estimatedFreight = ActionBot.sendKeys(driver, INPUT_ESTIMATED_FREIGHT_EFORM, estimatedFreight);
			return estimatedFreight;
		}
		return null;

	}

	@Override
	public String fillPurchasingInstructions_EForm(WebDriver driver, String testCaseName, String purchasingInstructions) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTAREA_PURCHASING_INSTRUCTIONS_EFORM))
		{
			ActionBot.clear(driver, TEXTAREA_PURCHASING_INSTRUCTIONS_EFORM);
			purchasingInstructions = ActionBot.sendKeys(driver, TEXTAREA_PURCHASING_INSTRUCTIONS_EFORM, purchasingInstructions);
			ScreenShot.screenshot(driver, testCaseName, "After Filling SAWater E-Form Data");
			return purchasingInstructions;
		}
		return null;

	}

	@Override
	public boolean checkForExternalAgent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> text = ActionBot.getListOfText(driver, WORKFLOW_EXTERNAL_AGENT_TEXT);

		for (String s : text)
		{
			if (s.contains(IConstantsData.External_Agent))
			{
				return true;
			}
		}

		// if (ActionBot.getTextWithInElement(driver,
		// WORKFLOW_EXTERNAL_AGENT_TEXT).contains(IConstantsData.External_Agent))
		// return true;
		return false;

	}

	public String fillIsPurchaseBudgeted(WebDriver driver, String testCaseName, String isThePurchaseBudgeted) throws ActionBotException
	{
		String str = null;
		Select select = new Select(ActionBot.findElement(driver, IS_PURCHASE_BUDGETED));
		select.selectByVisibleText(isThePurchaseBudgeted);

		str = select.getFirstSelectedOption().getText();
		if (str != null)
		{
			logger.info("fill Is Purchase Budgeted : " + str);
			return str;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillWhatIsPurchasedAndWhy(WebDriver driver, String testCaseName, String whatIsPurchasedandWHY) throws ActionBotException
	{
		String str = ActionBot.sendKeys(driver, WHAT_IS_PURCHASED_AND_WHY, whatIsPurchasedandWHY);

		if (str != null)
		{
			logger.info("fill What Is Purchased And Why : " + str);
			return str;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillIsPurchasedBefore(WebDriver driver, String testCaseName, String isPurchasedBefore) throws ActionBotException
	{
		String str = ActionBot.sendKeys(driver, IS_PURCHASED_BEFORE, isPurchasedBefore);
		if (str != null)
		{
			logger.info("fill Is Purchased Before : " + str);
			return str;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillIsPriceIncrease(WebDriver driver, String testCaseName, String isPriceIncrease) throws ActionBotException
	{
		String str = ActionBot.sendKeys(driver, IS_PRICE_INCREASE, isPriceIncrease);
		if (str != null)
		{
			logger.info("fill Is Price Increase : " + str);
			return str;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillIsAdditionalSavings(WebDriver driver, String testCaseName, String isAdditionalSavings) throws ActionBotException
	{
		String str = ActionBot.sendKeys(driver, IS_ADDITIONAL_SAVINGS, isAdditionalSavings);
		if (str != null)
		{
			logger.info("fill is Additional Savings : " + str);
			return str;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillSavingsAchieved(WebDriver driver, String testCaseName, String SavingsAchieved) throws ActionBotException
	{
		String str = ActionBot.sendKeys(driver, SAVINGS_ACHIEVED, SavingsAchieved);

		if (str != null)
		{
			logger.info("fill Savings Achieved : " + str);
			return str;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getGlobelErrorMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, ERROR_GLOBAL_MSG_CHECKOUT).getText();
	}

	@Override
	public String getPcardErrorMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, PCARD_ERROR_CONTAINER).getText();
	}

	@Override
	public String getPcardTransactionCount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, PCARD_TRANSACTION_COUNT).getText();
	}

	/*
	 * @author: bhakti.sawant : to add requisition attachment
	 */
	@Override
	public String addAttachment(WebDriver driver, String testCaseName, String attactmentFile) throws ActionBotException
	{
		// add attachment
		WebElement element = ActionBot.findElement(driver, LINK_ADD_ATTACHMENT_ON_CHECKOUT_PAGE);
		element.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element2 = (WebElement) js.executeScript("return document.getElementById('attachmentInput_requisitionAttachment');");
		js.executeScript("document.getElementById('attachmentInput_requisitionAttachment').style.visibility='visible';");

		// element=ActionBot.findElement(driver,
		// By.id("attachmentInput_requisitionAttachment"));
		element2.sendKeys(IConstants.ATTACHMENT_FILES_PATH + ConfigProperty.getConfig(attactmentFile));
		ActionBot.waitForPageLoad(driver);
		ActionBot.findElement(driver, LINK_DELETE_ATTACHMENT_ON_CHECKOUT_PAGE).click();
		ActionBot.waitForPageLoad(driver);

		return attactmentFile;
	}

	/*
	 * @author: bhakti.sawant : to delete requisition attachment
	 */
	@Override
	public String deleteAttachment(WebDriver driver, String testCaseName, String attactmentFile) throws ActionBotException
	{
		// click on attachment link
		WebElement element = ActionBot.findElement(driver, LINK_ADD_ATTACHMENT_ON_CHECKOUT_PAGE);
		element.click();

		System.out.println("is ele present " + ActionBot.isElementPresent(driver, ATTACHED_FILE_NAME_REQ));
		List<WebElement> elements = ActionBot.findElements(driver, ATTACHED_FILE_NAME_REQ);
		System.out.println("file name  input " + ConfigProperty.getConfig(attactmentFile));
		System.out.println("elements size   " + elements.size());
		for (int i = 0; i < elements.size(); i++)
		{
			System.out.println("file names " + elements.get(i).getAttribute("title"));
			if (elements.get(i).getAttribute("title").equalsIgnoreCase(ConfigProperty.getConfig(attactmentFile)))
			{
				i++;
				ActionBot.findElement(driver, By.xpath("(.//tr[contains(@id,'attachment_requisitionAttachment')]//*[@class='icon itmDelete deleteAttachment'])[" + i + "]"))
					.click();
				ActionBot.waitForPageLoad(driver);

				if (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
				{
					PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
				}
				ActionBot.waitForPageLoad(driver);

				ActionBot.findElement(driver, LINK_DELETE_ATTACHMENT_ON_CHECKOUT_PAGE).click();
				ActionBot.waitForPageLoad(driver);
				return attactmentFile;
			}

		}

		return null;
	}

	/*
	 * @author: bhakti.sawant : to delete item level attachment
	 */
	public String deleteItemSummaryAttachment(WebDriver driver, String testCaseName, String attactmentFile) throws ActionBotException
	{

		System.out.println("is ele present " + ActionBot.isElementPresent(driver, ATTACHMENT_ITEM_LEVEL_FILE_NAME));
		List<WebElement> elements = ActionBot.findElements(driver, ATTACHMENT_ITEM_LEVEL_FILE_NAME);
		System.out.println("file name  input  " + ConfigProperty.getConfig(attactmentFile));
		System.out.println("elements size   " + elements.size());
		for (int i = 0; i < elements.size(); i++)
		{
			System.out.println("file names " + elements.get(i).getAttribute("title"));
			if (elements.get(i).getAttribute("title").equalsIgnoreCase(ConfigProperty.getConfig(attactmentFile)))
			{
				i++;
				ActionBot.findElement(driver, By.xpath("(.//tr[contains(@id,'attachment_requisitionItemAttachments_')]//*[@class='icon itmDelete deleteAttachment'])[" + i + "]"))
					.click();
				ActionBot.waitForPageLoad(driver);

				if (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
				{
					PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
				}
				ActionBot.waitForPageLoad(driver);
				return attactmentFile;
			}

		}

		return null;
	}

	@Override
	public String getOULocation(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String name = null;
		if (ActionBot.isElementPresent(driver, OU_LOCATION))
		{
			name = ActionBot.getTextWithInElement(driver, OU_LOCATION);
		}
		return name;
	}

	@Override
	public String getOUCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String name = null;
		if (ActionBot.isElementPresent(driver, OU_COMPANY))
		{
			name = ActionBot.getTextWithInElement(driver, OU_COMPANY);
		}
		return name;
	}

	@Override
	public boolean isErrorMessagePresentInRequisitionSummaryPopUp(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		boolean flag = false;
		if (fieldName.equalsIgnoreCase(IConstantsData.COMPANY))
		{
			flag = ActionBot.isElementDisplayed(driver, ERROR_PLEASE_SELECT_A_COMPANY);
		}
		else if (fieldName.equalsIgnoreCase(IConstantsData.BUSINESS_UNIT))
		{
			flag = ActionBot.isElementDisplayed(driver, ERROR_PLEASE_SELECT_A_BUSINESS_UNIT);
		}
		else if (fieldName.equalsIgnoreCase(IConstantsData.LOCATION))
		{
			flag = ActionBot.isElementDisplayed(driver, ERROR_PLEASE_SELECT_A_LOCATION);
		}
		else if (fieldName.equalsIgnoreCase(IConstantsData.COST_CENTER))
		{
			flag = ActionBot.isElementDisplayed(driver, ERROR_PLEASE_SELECT_A_COST_CENTER);
		}
		else if (fieldName.equalsIgnoreCase(IConstantsData.project))
		{
			flag = ActionBot.isElementDisplayed(driver, ERROR_PLEASE_SELECT_A_PROJRCT);
		}
		else if (fieldName.equalsIgnoreCase(IConstantsData.budget))
		{
			flag = ActionBot.isElementDisplayed(driver, ERROR_PLEASE_SELECT_A_BUDGET_LINE);
		}
		return flag;
	}

	@Override
	public void clickCheckboxAllItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_ALL_ITEMS);
	}

	@Override
	public List<String> getListOfItemIdsOfCheckoutPageItem(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		List<String> itemIds = new ArrayList<String>();
		List<WebElement> itemNames = PageStandardPO.getListOfItems(driver, testCaseName);
		for (WebElement element : itemNames)
		{

			itemIds.add(element.getAttribute("id").split("\\_")[1].trim());
		}
		return itemIds;
	}

	@Override
	public String getItemIdByNameAtRequisitionCheckout(WebDriver driver, String testCaseName, String itemName) throws ActionBotException, FactoryMethodException
	{
		String itemId = null;
		String tempId = null;
		List<WebElement> itemNames = PageStandardPO.getListOfItems(driver, testCaseName);
		for (WebElement element : itemNames)
		{
			String itemNameFromUI = element.getText().trim();
			if (itemNameFromUI.equalsIgnoreCase(itemName))
			{
				tempId = element.getAttribute("id").trim();
				break;
			}
		}
		itemId = tempId.split("\\_")[1].trim();
		return itemId;
	}

	@Override
	public void selectItemIDwise(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		ActionBot.findElement(driver, By.xpath(".//*[contains(@id,'item_chk_" + itemID + "')]")).click();
	}
}