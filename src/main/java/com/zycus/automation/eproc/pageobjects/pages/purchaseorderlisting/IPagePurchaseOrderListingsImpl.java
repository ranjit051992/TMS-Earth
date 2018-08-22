package com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.pages.ammendedPOorders.IPageAmmendedPO;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPagePurchaseOrderListingsImpl implements IPagePurchaseOrderListing
{

	static Logger logger = Logger.getLogger(IPagePurchaseOrderListingsImpl.class);

	@Override
	public void clickOnActionsDropdownLink(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Actions Dropdown Link");

		ActionBot.click(driver, By.xpath(".//*[@id='polisting']//tr[" + index + "]//a[contains(@class,'actLnk')]"));
	}

	@Override
	public boolean clickOnCancel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "cancel";
		if (IPagePurchaseOrderStatusFiltersUtil.isFilterSelected(driver, PURCHASE_ORDER_STATUS_CANCEL))
		{
			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnClosed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "closed";
		if (IPagePurchaseOrderStatusFiltersUtil.isFilterSelected(driver, PURCHASE_ORDER_STATUS_CLOSED))
		{
			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public void clickOnDateFilterStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, PO_DATE_FILTER_STATUS);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnDraftPOLink(WebDriver driver, String testCaseName, int index) throws Exception
	{
		ScreenShot.screenshot(driver, testCaseName, "Click on DraftPO link");
		ActionBot.click(driver, By.xpath(".//*[@id='polisting']/tbody/tr[" + index + "]/td[2]/a"));

	}

	@Override
	public boolean clickOnDraftStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "draft";
		if (IPagePurchaseOrderStatusFiltersUtil.isFilterSelected(driver, PURCHASE_ORDER_STATUS_DRAFT))
		{
			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}

	}

	@Override
	public boolean clickOnExpired(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "expired";
		if (IPagePurchaseOrderStatusFiltersUtil.isFilterSelected(driver, PURCHASE_ORDER_STATUS_EXPIRED))
		{
			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public void clickOnFilterDateButtom(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.click(driver, PO_DATE_FILTER_BUTTON);

	}

	@Override
	public void clickOnFilterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Status Filter Link");
		// index schould be mention otherwise 2 filter present at the same time
		ActionBot.defaultSleep();
		ActionBot.findElement(driver, PURCHASE_ORDER_STATUS_FILTER_LINK).click();
		ActionBot.waitTillPopUpIsPresent(driver, PO_LISTING_PROCESSING);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnFilterStatusCancelButtom(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, STATUS_FILTER_CANCEL_BUTTOM);
	}

	@Override
	public void clickOnFilterStatusLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, PURCHASE_ORDER_FILTER_STATUS_LINK);
	}

	@Override
	public void clickOnHeaderPoNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, HEADER_PO_NO);

	}

	@Override
	public void clickOnHeaderPoDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, HEADER_PO_DATE);

	}

	@Override
	public void clickOnHeaderPoAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, HEADER_PO_AMOUNT);

	}

	@Override
	public boolean clickOnInProgressStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String screenshotName = "in progress";
		if (IPagePurchaseOrderStatusFiltersUtil.isFilterSelected(driver, PURCHASE_ORDER_STATUS_INPROGRESS))
		{
			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnPayements(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "Payements";
		if (IPagePurchaseOrderStatusFiltersUtil.isFilterSelected(driver, PURCHASE_ORDER_STATUS_PAYMENTSTATUS))
		{
			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public void clickOnPoActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PO_ACTIONS);
	}

	@Override
	public void clickOnPoLink(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='polisting']/tbody/tr[" + index + "]/*[contains(@class,'purchaseOrderNumber')]/a"));

	}

	@Override
	public boolean clickOnRejected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "rejected";
		if (IPagePurchaseOrderStatusFiltersUtil.isFilterSelected(driver, PURCHASE_ORDER_STATUS_REJECTED))
		{
			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnReleasedStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "released";
		// ActionBot.click(driver, PURCHASE_ORDER_STATUS_RELEASED);
		// ActionBot.defaultSleep();
		if (IPagePurchaseOrderStatusFiltersUtil.isFilterSelected(driver, PURCHASE_ORDER_STATUS_RELEASED))
		{
			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnReturned(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "returned";
		if (IPagePurchaseOrderStatusFiltersUtil.isFilterSelected(driver, PURCHASE_ORDER_STATUS_RETURNED))
		{
			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnSchdule(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "schdule";
		if (IPagePurchaseOrderStatusFiltersUtil.isFilterSelected(driver, PURCHASE_ORDER_STATUS_SCHEDULE))
		{
			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public String fillBuyer(WebDriver driver, String testCaseName, String buyer) throws ActionBotException
	{
		/*
		 * ActionBot.sendKeys(driver, TEXT_BOX_BUYER, buyer);
		 * ActionBot.findElement(driver, TEXT_BOX_BUYER).sendKeys(Keys.ENTER);
		 */
		ActionBot.fillAutoCompleteField(driver, TEXT_BOX_BUYER, buyer);
		String Buyer = ActionBot.findElement(driver, TEXT_BOX_BUYER).getAttribute("value");
		logger.info("Entered PO No : " + Buyer);
		return Buyer;
	}

	@Override
	public String fillSupplier(WebDriver driver, String testCaseName, String supplier) throws ActionBotException
	{
		/*
		 * ActionBot.sendKeys(driver, TEXT_BOX_BUYER, buyer);
		 * ActionBot.findElement(driver, TEXT_BOX_BUYER).sendKeys(Keys.ENTER);
		 */
		ActionBot.fillAutoCompleteField(driver, TEXT_BOX_SUPPLIER, supplier);
		String Supplier = ActionBot.findElement(driver, TEXT_BOX_SUPPLIER).getAttribute("value");
		logger.info("Entered PO No : " + Supplier);
		return Supplier;
	}

	@Override
	public String fillPoDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.click(driver, REQUIRED_BY_DATE_PICKER);

		// month
		Select select = new Select(ActionBot.findElement(driver, SELECT_MONTH));
		select.selectByValue(month);

		// year
		select = new Select(ActionBot.findElement(driver, SELECT_YEAR));
		select.selectByValue(year);

		// day
		ActionBot.click(driver, By.linkText(day));

		String requiredByDate = ActionBot.findElement(driver, REQUIRED_BY_DATE).getAttribute("value").trim();
		logger.info("Selected Required By Date : " + requiredByDate);
		ScreenShot.screenshot(driver, testCaseName, "After changing required by date");
		return requiredByDate;
	}

	@Override
	public String fillPoNo(WebDriver driver, String testCaseName, String poNo) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, PO_LISTING_PROCESSING);
		// ActionBot.wait
		// ActionBot.waitForElementToBeEnable(driver,By.xpath("(.//*[@id='polisting']//td[contains(@class,'purchaseOrderNumber')]/a[contains(@href,'viewPurchaseOrder')])[1]"),6);
		ActionBot.waitForElementToBeEnable(driver, TEXT_BOX_PO_NO, 5);
		ActionBot.sendKeys(driver, TEXT_BOX_PO_NO, poNo);
		// ActionBot.defaultSleep();
		ActionBot.findElement(driver, TEXT_BOX_PO_NO).sendKeys(Keys.RETURN);
		ActionBot.waitTillPopUpIsPresent(driver, PO_LISTING_PROCESSING);
		String po_No = ActionBot.findElement(driver, TEXT_BOX_PO_NO).getAttribute("value");
		ActionBot.defaultSleep();
		logger.info("Entered PO No : " + po_No);
		return po_No;
	}

	@Override
	public String getFirstPoNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String poNo = ActionBot.getTextWithInElement(driver, FIRST_PO_LINK);
		logger.info("Po No : " + poNo);
		ScreenShot.screenshot(driver, testCaseName, "Po No");
		return poNo;
	}

	@Override
	public void clickOnFirstPoNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElements(driver, FIRST_PO_LINK).get(0).click();
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on first PO No");
	}

	@Override
	public String getFirstPoStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String status = ActionBot.getTextWithInElement(driver, STATUS_OF_FIRST_PO);
		logger.info("Status of PO : " + status);
		ScreenShot.screenshot(driver, testCaseName, "Status of PO");
		return status;
	}

	@Override
	public String getFirstRowBuyerName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String buyerName = ActionBot.getTextWithInElement(driver, FIRST_BUYER_NAME);
		logger.info("Buyer Name : " + buyerName);
		ScreenShot.screenshot(driver, testCaseName, "buyer Name");
		return buyerName;
	}

	@Override
	public String getFirstRowPoDate(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String podate = ActionBot.findElement(driver, By.xpath(".//*[@id='polisting']/tbody/tr[" + index + "]/td[7]")).getText();
		return podate;
	}

	@Override
	public String getFirstRowSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierName = ActionBot.getTextWithInElement(driver, FIRST_ROW_SUPPLIER_NAME_PO_LISTING);
		logger.info("Supplier Name : " + supplierName);
		ScreenShot.screenshot(driver, testCaseName, "Supplier Name");
		return supplierName;
	}

	@Override
	public String getFirstRowTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String totalAmount = ActionBot.getTextWithInElement(driver, FIRST_ROW_TOTAL_AMOUNT_PO_LISTING);
		logger.info("Total Amount : " + totalAmount);
		ScreenShot.screenshot(driver, testCaseName, "Total Amount");
		return totalAmount;
	}

	@Override
	public boolean isDeleteOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_DELETE_ACTIONS))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isDraftStatusBasedFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, PURCHASE_ORDER_STATUS_DRAFT))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isMaxAndMinDateRangeFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PO_DATE_FIELD))
		{
			return true;
		}
		if (ActionBot.isElementPresent(driver, PO_DATE_FIELD_MAX))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isNoOfRecordsLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PO_LISTING_NO_OF_RECORDS_LABEL))
		{
			return true;
		}
		return false;
	}

	@Override
	public List<WebElement> getListOfPONos(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, FIRST_PO_LINK);
	}

	@Override
	public void clickOnTypeFilterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_TYPE_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on type filter link");

	}

	@Override
	public void clickOnStandardFilterOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_TYPE_FILTER_STANDARD);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on type standard filter");

	}

	@Override
	public void clickOnReleaseFilterOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_TYPE_FILTER_RELEASE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on type release filter");

	}

	@Override
	public void clickOnBlanketFilterOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_TYPE_FILTER_BLANKET);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on type blanket filter");

	}

	@Override
	public void clickOnApplyTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_TYPE_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on type apply filter button");
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnAmountFilterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_AMOUNT_FILTER);

	}

	@Override
	public void clickOnINRCurrencyFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_AMOUNT_FILTER_INR_CURRENCY);

	}

	@Override
	public void clickOnUSDCurrencyFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_AMOUNT_FILTER_USD_CURRENCY);

	}

	@Override
	public void clickOnApplyAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_AMOUNT_FILTER);
		ActionBot.defaultSleep();

	}

	@Override
	public boolean isCommentBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TEXTBOX_CLOSE_COMMENT_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isAllowCreatingInvoiceOptionPrsent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CHECKBOX_ALLOW_CREATING_INVOICE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnCancelClosePOBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_CLOSE_PO_BOX);

	}

	@Override
	public void hoverOnPONumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, LINK_PO_NUMBER);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnDownloadPOLinkFromTooltip(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath(".//*[@id='polisting']//a[@class='scLnk']"))).build().perform();
		ActionBot.defaultSleep();
		driver.findElement(By.xpath(".//*[contains(@id,'qtip-')]//a[contains(@class,'icon scLnk download')]")).click();
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnAmmendPOLinkFromTooltip(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath(".//*[@id='polisting']//a[@class='scLnk']"))).build().perform();
		ActionBot.defaultSleep();
		driver.findElement(By.xpath(".//*[contains(@id,'qtip-')]//a[contains(@class,'icon scLnk amendpo')]")).click();
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Amend PO");
	}

	@Override
	public boolean isPOParkedMessageDisplayedCorrectly(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, STATUS_OF_FIRST_PO);
		ActionBot.defaultHighSleep();
		ActionBot.findElement(driver, HOVER_MESSAGE_PARKED_PO);
		if (ActionBot.isElementDisplayed(driver, HOVER_MESSAGE_PARKED_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isNoOfRecordsBeforeFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, RECORDS_INFO_BEFORE_FILTER))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isNoOfRecordsAfterFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, RECORDS_INFO_AFTER_FILTER))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnExpandInProgressStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, EXPAND_IN_PROGRESS_STATUS_FILTER);

	}

	@Override
	public void clickOnInApprovalStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, CHECKBOX_STATUS_FILTER_IN_APPROVAL);
		ScreenShot.screenshot(driver, testCaseName, "After clearing inApproval filter");

	}

	@Override
	public void clickOnClearFilter(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='polisting']//th[" + index + "]//span[@class='icon fltr-clear']"));
		ActionBot.waitTillPopUpIsPresent(driver, PO_LISTING_PROCESSING);
		ScreenShot.screenshot(driver, testCaseName, "After clearing filter");

	}

	@Override
	public boolean isSuccessfulAmendedMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, SUCCESSFULL_AMENDED_PO_MESSAGE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnViewAmmendedPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_VIEW_AMMENDED_PO_ON_PO_LISTING);
		ActionBot.defaultSleep();
		ActionBot.waitTillPopUpIsPresent(driver, IPageAmmendedPO.PROCESSING_DIV_AMENDED_PO_LISTING);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on view amended PO Link");
	}

	@Override
	public boolean isFilterDateButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PO_DATE_FILTER_BUTTON))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getFirstPOType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String type = ActionBot.getTextWithInElement(driver, LABEL_FIRST_PO_TYPE);
		logger.info("First PO Type : " + type);
		return type;
	}

	@Override
	public void clickOnExpandReleaseFilterNode(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, EXPAND_RELEASE_NODE);

	}

	@Override
	public int enterMinAmountInSelectAmountRangeFilter(WebDriver driver, String testCaseName, int minAmount) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXTBOX_MIN_AMOUNT_FILTER);
		ActionBot.sendKeys(driver, TEXTBOX_MIN_AMOUNT_FILTER, "" + minAmount);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_MIN_AMOUNT_FILTER);
		if (str != null)
		{
			int min = Integer.parseInt(str);
			return min;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public int enterMaxAmountInSelectAmountRangeFilter(WebDriver driver, String testCaseName, int maxAmount) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXYBOX_MAX_AMOUNT_FILTER);
		ActionBot.sendKeys(driver, TEXYBOX_MAX_AMOUNT_FILTER, "" + maxAmount);
		String str = ActionBot.getTextWithInElement(driver, TEXYBOX_MAX_AMOUNT_FILTER);
		if (str != null)
		{
			int max = Integer.parseInt(str);
			return max;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public boolean isPoNOExceedErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, PO_NO_EXCEED_ERROR_MSG))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickOnExpandConfirmationStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_EXPAND_FOR_CONFIRMATION_FILER);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on expand confirmed status in filter");
	}

	@Override
	public void clickOnUnConfirmedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PURCHASE_ORDER_STATUS_UNCONFIRMED);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on unconfirmed status filter");
	}

	@Override
	public void hoverAndClickOnIconInvoicedPOStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ICON_INVOICED_PO_STATUS);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnExpiredStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PURCHASE_ORDER_STATUS_EXPIRED);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Expired filter");
	}

	@Override
	public boolean isAlertOfPOWaitingForApprovalPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PO_WAITING_FOR_APPROVAL_ALERT))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getSupplierName(WebDriver driver, String testCaseName, String poNo) throws ActionBotException
	{
		String supplierName = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_polisting_row + poNo + xpath2_supplierName));
		logger.info("For " + poNo + " Supplier Name : " + supplierName);
		return supplierName;
	}

	@Override
	public String getTotalAmount(WebDriver driver, String testCaseName, String poNo) throws ActionBotException
	{
		String totalAmount = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_polisting_row + poNo + xpath2_totalAmount));
		logger.info("For " + poNo + " Total Amount : " + totalAmount);
		return totalAmount;
	}

	@Override
	public String fillCloseCommentBox(WebDriver driver, String testCaseName, String closeComment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_CLOSE_COMMENT_PO, closeComment);
		ActionBot.defaultSleep();
		return ActionBot.getTextWithInElement(driver, TEXTBOX_CLOSE_COMMENT_PO);
	}

	@Override
	public void clickOnClosePOButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CLOSE_PO);

	}

	@Override
	public boolean isNotSentToSupplierIconPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, ICON_NOT_SENT_TO_SUPPLIER);
	}

	@Override
	public String getStatusDetailsOfNotSentToSupplierIcon(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String statusDetails = null;
		ActionBot.hover(driver, ICON_NOT_SENT_TO_SUPPLIER);
		statusDetails = ActionBot.getTextWithInElement(driver, LABEL_STATUS_DETAILS_ON_MOUSE_HOVER);
		logger.info("Status Details : " + statusDetails);
		return statusDetails;
	}

	@Override
	public void clickOnNotSentToSupplierFilterCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_NOT_SENT_TO_SUPPLIER_FILTER);
	}

	@Override
	public List<String> getListOfStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> status = new ArrayList<>();
		List<WebElement> elements = ActionBot.findElements(driver, STATUS_OF_FIRST_PO);
		for (WebElement element : elements)
		{
			status.add(element.getText().trim());
		}
		return status;
	}

	@Override
	public List<WebElement> getListOfIconsOfNotSentToSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, ICON_NOT_SENT_TO_SUPPLIER);
	}

	@Override
	public boolean clickOnNotPaidPaymentStatusFilterCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_NOT_PAID_STATUS_FILTER);
		return ActionBot.isElementSelected(driver, CHECKBOX_NOT_PAID_STATUS_FILTER);
	}

	@Override
	public boolean clickOnPartiallyPaidPaymentStatusFilterCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_PARTIALLY_PAID_STATUS_FILTER);
		return ActionBot.isElementSelected(driver, CHECKBOX_PARTIALLY_PAID_STATUS_FILTER);
	}

	@Override
	public boolean clickOnFullyPaidPaymentStatusFilterCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_FULLY_PAID_STATUS_FILTER);
		return ActionBot.isElementSelected(driver, CHECKBOX_FULLY_PAID_STATUS_FILTER);
	}

	@Override
	public boolean clickOnPayementNotApplicablePaymentStatusFilterCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_PAYMENT_NOT_APPLICABLE_STATUS_FILTER);
		return ActionBot.isElementSelected(driver, CHECKBOX_PAYMENT_NOT_APPLICABLE_STATUS_FILTER);
	}

	@Override
	public void clickOnExpandPaymentStatusFilterOptions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EXPAND_PAYMENT_STATUS_FILTER);
	}

	@Override
	public boolean isPOWithGivenAmountPresentInListing(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath(".//*[@id='polisting']//tr[.//*[text()='" + amount + "']]"));
	}

	@Override
	public String getPOWithGivenAmount(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		String poNo = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='polisting']//tr[.//*[text()='" + amount + "']]/td[contains(@class,'purchaseOrderNumber')]/a"));
		logger.info("PO No : " + poNo);
		return poNo;
	}

	@Override
	public boolean clickonReleaseActionLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RELEASE_PO_LINK);
		return true;
	}

	@Override
	public boolean clickonCancelActionLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_PO_LINK);
		return true;
	}

	@Override
	public boolean clickOnAlertContinueButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, POPUP_ALERT_CONTINUE))
		{
			ActionBot.click(driver, POPUP_ALERT_CONTINUE);
			return true;
		} /*
			 * else
			 * if(driver.findElement(By.xpath(".//*[text()='OK']")).isDisplayed(
			 * )){ driver.findElement(By.xpath(".//*[text()='OK']")).click(); }
			 */
		return false;
	}

	@Override
	public String fillOrderDescription(WebDriver driver, String testCaseName, String orderDesc) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, By.xpath(".//*[@id='polisting_processing']"));
		ActionBot.sendKeys(driver, TEXTBOX_ORDER_DESCRIPTION_PO_LISTING_PAGE, orderDesc);
		// ActionBot.defaultSleep();
		ActionBot.findElement(driver, TEXTBOX_ORDER_DESCRIPTION_PO_LISTING_PAGE).sendKeys(Keys.RETURN);
		ActionBot.waitTillPopUpIsPresent(driver, By.xpath(".//*[@id='polisting_processing']"));
		String order_Desc = ActionBot.findElement(driver, TEXTBOX_ORDER_DESCRIPTION_PO_LISTING_PAGE).getAttribute("value");
		ActionBot.defaultSleep();
		logger.info("Entered PO No : " + order_Desc);
		return order_Desc;
	}

	@Override
	public String getFirstPoOrderDescription(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String orderDesc = ActionBot.getTextWithInElement(driver, FIRST_PO_ORDER_DESCRIPTION);
		logger.info("Po Order Description : " + orderDesc);
		ScreenShot.screenshot(driver, testCaseName, "Po Order Description");
		return orderDesc;
	}

	@Override

	public boolean clickOnPONumberSorting(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.defaultSleep();
		ActionBot.click(driver, PO_NUMBER_SORTING);
		ActionBot.defaultSleep();

		ScreenShot.screenshot(driver, testCaseName, "PONumberSorting");
		return true;
	}

	@Override
	public boolean clickOnPoDateSorting(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, PO_DATE_SORTING);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "PoDateSorting");
		return true;
	}

	@Override
	public boolean clickOnPOAmountSorting(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, PO_AMOUNT_SORITNG);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "POAmountSorting");
		return true;
	}

	@Override
	public boolean clickOnApplyStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, PURCHASE_ORDER_STATUS_APPLY);
		ScreenShot.screenshot(driver, testCaseName, "PurchaseOrderStatusApply");
		return true;
	}

	public String getPurchaseOrderExternalId(WebDriver driver, String testCaseName, String purchaseOrderId) throws ActionBotException
	{
		String externalId = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// logger.info("Appended String:
		// requisitionMap[\""+requisitonId+"\"].externalId");
		externalId = js.executeScript("return purchaseOrderMap[\"" + purchaseOrderId + "\"].externalId").toString();
		return externalId;
	}

	@Override
	public void clickOnExpandDeliveryStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, EXPAND_DELIVERY_STATUS_FILTER);

	}

	@Override
	public boolean clickOnNotDeliveredStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String screenshotName = "in progress";
		if (IPagePurchaseOrderStatusFiltersUtil.isFilterSelected(driver, CHECKBOX_NOT_DELIVERED_STATUS_FILTER))
		{
			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnPartiallyReceivedStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String screenshotName = "in progress";
		if (IPagePurchaseOrderStatusFiltersUtil.isFilterSelected(driver, CHECKBOX_PARTIALLY_RECEIVED_STATUS_FILTER))
		{
			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnFullyReceivedStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String screenshotName = "in progress";
		if (IPagePurchaseOrderStatusFiltersUtil.isFilterSelected(driver, CHECKBOX_FULLY_RECEIVED_STATUS_FILTER))
		{
			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public String getPOId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String POId = null;
		POId = ActionBot.getAttributeOfElement(driver, FIRST_PO_LINK, "data-purchase-order-id");
		return POId;
	}

	@Override
	public List<WebElement> getPoActionsLinks(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LINK_PO_ACTIONS);
	}

	@Override
	public void clickOnCancelledStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		clickOnStatusFilterTab(driver, testCaseName);
		//ActionBot.waitForElementToBeDisplayed(driver, CLEAR_STATUS_FILTER_PO_LISTING, 10);
		//ActionBot.click(driver, CLEAR_STATUS_FILTER_PO_LISTING);
		//ActionBot.waitForPageLoad(driver);
		ActionBot.click(driver, STATUS_CANCELLED_PO);
		clickOnApplyStatusFilter(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnStatusFilterTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, STATUS_FILTER_TAB_PO);
	}

}
