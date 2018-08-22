package com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.pages.purchaseordertobegenerated.PagePurchaseOrderToBeGenerated;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageBuyersDeskListingImpl implements IPageBuyersDeskListing
{
	static Logger logger = Logger.getLogger(IPageBuyersDeskListingImpl.class);

	@Override
	public String fillRequisitionNo(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException
	{
		WebElement element;
		element = ActionBot.findElement(driver, TEXTBOX_BUYERS_DESK_LISTING_REQUISITION_NO);
		ActionBot.waitForElementToBeEnable(driver, TEXTBOX_BUYERS_DESK_LISTING_REQUISITION_NO, ActionBot.timeOut);
//		element.click();
		element.clear();
		element.sendKeys(reqNo);
		element.sendKeys(Keys.ENTER);
		ActionBot.waitTillPopUpIsPresent(driver, BUYERS_DESK_LISTING_PROCESSING_DIV);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After filling req no");
		ActionBot.waitForPageLoad(driver);
		// ActionBot.defaultSleep();

		String req_No = element.getAttribute("value");
		logger.info("Requisition Number : " + req_No);

		return req_No;
	}

	@Override
	public String fillRequisitionName(WebDriver driver, String testCaseName, String reqName) throws ActionBotException
	{
		WebElement element;
		element = ActionBot.findElement(driver, TEXTBOX_BUYERS_DESK_LISTING_REQUISITION_NAME);
		element.clear();
		element.sendKeys(reqName);
		element.sendKeys(Keys.RETURN);
		ActionBot.waitTillPopUpIsPresent(driver, BUYERS_DESK_LISTING_PROCESSING_DIV);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After filling req name");
		ActionBot.waitForPageLoad(driver);
		// ActionBot.defaultSleep();

		String req_Name = element.getAttribute("value");
		logger.info("Requisition Name : " + req_Name);

		return req_Name;
	}

	@Override
	public String fillRequester(WebDriver driver, String testCaseName, String requester) throws ActionBotException
	{
		WebElement element;
		ActionBot.defaultSleep();
		element = ActionBot.findElement(driver, TEXTBOX_BUYERS_DESK_LISTING_REQUISITION_REQUESTER);
		// element.clear();
		element.sendKeys(requester);
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.ENTER);
		ActionBot.waitTillPopUpIsPresent(driver, BUYERS_DESK_LISTING_PROCESSING_DIV);
		// ActionBot.defaultSleep();

		ScreenShot.screenshot(driver, testCaseName, "After filling requester name");

		String requester_name = element.getAttribute("value");
		logger.info("Requester Name : " + requester_name);
		return requester_name;
	}

	@Override
	public void clickOnClearStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, BUTTON_BUYERS_DESK_LISTING_CLEAR_STATUS_FILTER))
		{
			ActionBot.click(driver, BUTTON_BUYERS_DESK_LISTING_CLEAR_STATUS_FILTER);
		}
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on clear status filter");
	}

	@Override
	public boolean isClearStatusFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag = ActionBot.isElementPresent(driver, BUTTON_BUYERS_DESK_LISTING_CLEAR_STATUS_FILTER) ? true : false;
		ScreenShot.screenshot(driver, testCaseName, "Check is Status filter applied");
		return flag;
	}

	@Override
	public void clickOnFirstReqNoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_BUYERS_DESK_LISTING_FIRST_ROW_REQ_NO);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on first req no link");
	}

	@Override
	public String getFirstRowReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Buyers Desk Listing First Req No");
		String reqNo = ActionBot.getTextWithInElement(driver, LINK_BUYERS_DESK_LISTING_FIRST_ROW_REQ_NO);
		logger.info("First Requisition No : " + reqNo);
		return reqNo;
	}

	@Override
	public String getFirstRowReqName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Buyers Desk Listing First Req Name");
		String reqName = ActionBot.getTextWithInElement(driver, BUYERS_DESK_LISTING_FIRST_ROW_REQ_NAME);
		if (reqName.contains("*"))
		{
			String[] temp = StringUtils.split(reqName, "*");
			reqName = "";
			reqName = temp[0].trim();
		}
		logger.info("First Requisition Name : " + reqName);
		return reqName;
	}

	@Override
	public String getFirstRowRequester(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Buyers Desk Listing First Requester Name");
		String requesterName = ActionBot.getTextWithInElement(driver, BUYERS_DESK_LISTING_FIRST_ROW_REQUESTER);
		logger.info("First Requester Name : " + requesterName);
		return requesterName;
	}

	@Override
	public String getFirstRowReqStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Buyers Desk Listing First Requisition Status");
		String status = ActionBot.getTextWithInElement(driver, BUYERS_DESK_LISTING_FIRST_STATUS);
		logger.info("First Requisition Status : " + status);
		return status;
	}

	@Override
	public List<String> getStatusOfAllReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "List of Status");
		List<String> listOfStatus = ActionBot.getListOfText(driver, BUYERS_DESK_LISTING_FIRST_STATUS);
		return listOfStatus;
	}

	@Override
	public void clickOnFirstActionButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUYERS_DESK_LISTING_ACTION_LINK);
		ActionBot.defaultSleep();
	}

	@Override
	public List<WebElement> getAllReqNos(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LINK_BUYERS_DESK_LISTING_FIRST_ROW_REQ_NO);
	}

	@Override
	public void clickOnConvertToPoButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		ActionBot.click(driver, BUTTON_CONVERT_TO_PO_BUYERS_DESK_LISTING);
		waitTillConvertToPoProcessingDiv(driver, testCaseName);
		ActionBot.defaultSleep();
		if (!PagePurchaseOrderToBeGenerated.isSubmitPOForProcessingPresent(driver, testCaseName))
		{
			ActionBot.defaultSleep();
		}
		ScreenShot.screenshot(driver, testCaseName, "After clicking on convert to po button");
	}

	@Override
	public void waitTillConvertToPoProcessingDiv(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, CONVERT_TO_PO_REQUISITION_PROCESSING_DIV);
	}

	@Override
	public String getFirstRowAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String assignedBuyerName = ActionBot.getTextWithInElement(driver, LABEL_ASSIGNED_BUYER_ON_LISTING_PAGE);
		logger.info("Assigned buyer name as on buyers desk listing : " + assignedBuyerName);
		return assignedBuyerName;
	}

	@Override
	public void clickOnLinkStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		ActionBot.waitForPageLoad(driver);
		ActionBot.click(driver, LINK_STATUS_FILTER_BUYERS_DESK_LISTING);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on status filter");

	}

	@Override
	public void clickOnProcessedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_PROCESSED_FILTER);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on processed filter checkbox");
	}

	@Override
	public void clickOnApplyStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_APPLY_STATUS_FILTER_BUYERS_DESK_LISTING);
		ScreenShot.screenshot(driver, testCaseName, "After applying status filter");

	}

	@Override
	public void clickOnPendingOrderStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, IN_PROCESS_EXPAND);
		ActionBot.defaultSleep();
		ActionBot.click(driver, CHECKBOX_PENDING_ORDER_FILTER);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on pending order status filter");

	}

	@Override
	public void clickOnConvertToPOFromAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CONVERT_TO_PO_ACTION);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on convert to PO from actions");

	}

	@Override
	public void clickOnExpandPendingOrderFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, EXPAND_PENDING_ORDER_FILTER);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on expand pending order filter");

	}

	@Override
	public void clickOnPartiallyOrderedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_PARTIALLY_ORDERED_FILTER);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on partially ordered filter");

	}

	@Override
	public void clickOnAwaitingQueueFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_AWAITING_QUEUE_FILTER);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on awaiting queue filter");
	}

	@Override
	public void clickOnNextPageIcon(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_NEXT_PAGE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on next page icon");

	}

	@Override
	public boolean isValidationGlobalErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, VALIDATION_GLOBAL_ERROR_MESSAGE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnExpandProcessedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, EXPAND_PROCESSED_FILTER);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnReturnedWithQuoteFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_RETURNED_WITH_QUOTE_FILTER);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnReturnedForModificationFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_RETURNED_FOR_MODIFICATION_FILTER);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnLinkAssignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ASSIGNED_BUYER_FILTER);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnUnassignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_UNASSIGNED_FILTER);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnApplyAssignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ASSIGNED_BUYER_FILTER);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnCheckboxOfReqToBeSelected(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[@id='chkbx'])[" + index + "]"));
		ScreenShot.screenshot(driver, testCaseName, "After selecting the req");

	}

	@Override
	public void hoverOnFirstReqNoToGetReqInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, INFO_OF_FIRST_REQ_ON_TOOLTIP);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnClearReqNoFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_BUYERS_DESK_LISTING_CLEAR_REQ_NO_FILTER);
		ActionBot.defaultMediumSleep();

	}

	@Override
	public void clickOnMeAssignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_ME_ASSIGNED_BUYER_FILTER);

	}

	@Override
	public void clickOnBuyerInAssignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_WITH_ASSIGNED_BUYER);

	}

	@Override
	public void clickOnClearIconOfAssignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ICON_CLEAR_ASSIGNED_BUYER_FILTER);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnClearIconOfRequisitionNameFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ICON_CLEAR_REQ_NAME_FILTER);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnClearIconOfRequesterFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ICON_CLEAR_REQUESTOR_FILTER);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnLinkAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PURCHASE_AMOUNT_FILTER);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnINRcheckboxOfAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_INR_AMOUNT_FILTER);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnCheckboxOfAmountFilter(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		List<WebElement> allCheckBoxes = ActionBot.findElements(driver, CHECKBOX_AMOUNT_FILTER);
		if (allCheckBoxes.size() >= index)
		{

			allCheckBoxes.get(index - 1).click();
		}
		else
		{
			logger.info("No Checkbox for index +" + index);
		}
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnApplyAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_PURCHASE_AMOUNT_FILTER);
		ActionBot.defaultSleep();

	}

	@Override
	public boolean isAssignedBuyerFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, ICON_CLEAR_ASSIGNED_BUYER_FILTER);
	}

	@Override
	public void clickOnStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, BUTTON_STATUS_FILTER_AT_BUYERS_DESK_LISTING);
		ActionBot.defaultSleep();
	}

	@Override
	public String getSuccessErrorMessage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String msg = ActionBot.getTextWithInElement(driver, SUCCESS_ERROR_BOX_BUYERS_DESK_LISTING);
		logger.info("Success/Error Message : " + msg);
		return msg;
	}

	@Override
	public void clickOnEditAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_ACTION);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Edit from actions");

	}

	@Override
	public boolean verifyAvailablityOfEditAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag = ActionBot.isElementDisplayed(driver, LINK_EDIT_ACTION);
		ScreenShot.screenshot(driver, testCaseName, "visible Edit from actions");
		return flag;

	}

	@Override
	public boolean verifyEditAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, LINK_EDIT_ACTION))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public String searchRequisitionNameInFilter(WebDriver driver, String testCaseName, String reqName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, SEARCH_REQUISITION_NAME))
		{
			WebElement ele = ActionBot.findElement(driver, SEARCH_REQUISITION_NAME);
			ele.clear();
			ele.sendKeys(reqName);
			ActionBot.defaultSleep();
			ele.sendKeys(Keys.ENTER);
			ActionBot.defaultLowSleep();
		}
		return reqName;
	}

	@Override
	public String searchRequisitionNumberInFilter(WebDriver driver, String testCaseName, String reqNumber) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, SEARCH_REQUISITION_NUMBER))
		{
			WebElement ele = ActionBot.findElement(driver, SEARCH_REQUISITION_NUMBER);
			ele.clear();
			ele.sendKeys(reqNumber);
			ActionBot.defaultSleep();
			ele.sendKeys(Keys.ENTER);
			ActionBot.defaultLowSleep();
		}
		return reqNumber;
	}

	@Override
	public boolean isReqSaveMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		if (ActionBot.isElementPresent(driver, INFO_REQ_SAVE_MESSAGE))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean verifyLinkConvertToPoDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_CONVERT_TO_PO_ACTION))
		{
			return true;
		}
		return false;
	}

	@Override
	public String fetchRequisitionNumberinBuyerList(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='buyerlisting']//td[contains(@class,'requisitionNo')])[" + index + "]"));
	}

	@Override
	public void clickOnReturnLinkIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		ActionBot.click(driver, By.xpath("(.//*[@id='buyerlisting']//a[text()='Return'])[" + index + "]"));
		ActionBot.sendKeys(driver, By.id("returnComments"), CommonServices.getTestData(IConstantsData.COMMENT_FOR_RETURN_REQUISITION));
		ActionBot.click(driver, By.id("returnRequisition"));
	}

	@Override
	public void clickReturActionOnReqInBuyerList(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[@id='buyerlisting']//a[text()='Return'])[" + index + "]"));
	}

	@Override
	public boolean verifyReturnActionOnReqInBuyerList(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@id='buyerlisting']//a[text()='Return'])[" + index + "]"));
	}

	@Override
	public void clickOnCheckNoResubmitInBuyerList(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		if ((ActionBot.isElementSelected(driver, CHECKBOX_CAN_RESUBMIT)))
			ActionBot.click(driver, CHECKBOX_CAN_RESUBMIT);
	}

	@Override
	public void clickOnCheckResubmitInBuyerList(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		if (!(ActionBot.isElementSelected(driver, CHECKBOX_CAN_RESUBMIT)))
			ActionBot.click(driver, CHECKBOX_CAN_RESUBMIT);
	}

	@Override
	public void fillCommentForReturningByBuyer(WebDriver driver, String testCaseName, String comment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_BOX_RETURN_COMMENT_BUYER_DESK, comment);

		// ActionBot.sendKeys(driver, TEXT_BOX_RETURN_COMMENT, comment);
	}

	@Override
	public void fillCommentForReturningUnderActionTabByBuyer(WebDriver driver, String testCaseName, String comment) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_BOX_RETURN_COMMENT_UNDER_ACTION_TAB_BUYERS_DESK, comment);

	}

	@Override
	public void clickReturnSubmitFromBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, BUTTON_RETURN_REQUISITION, 30);
		ActionBot.click(driver, BUTTON_RETURN_REQUISITION);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clearFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUYERS_DESK_CLEAR_FILTER))
			ActionBot.click(driver, BUYERS_DESK_CLEAR_FILTER);
		ActionBot.defaultSleep();
	}

	@Override
	public boolean isReqPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@id='buyerlisting']//td[contains(@class,'requisitionNo')])[" + index + "]"));
	}

	@Override
	public void clickAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUYER_AMOUNT_FILTER);
	}

	@Override
	public void enterMinAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		ActionBot.sendKeys(driver, BUYER_MINIMUM_AMOUNT_RANGE, amount);
	}

	@Override
	public void enterMaxAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		ActionBot.sendKeys(driver, BUYER_MAX_AMOUNT_RANGE, amount);
	}

	@Override
	public void clickApplyAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUYER_AMOUNT_FILTER_Button);
	}

	@Override
	public String fetchRequisitionAmountIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String amountString = ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='buyerlisting']//td[contains(@class,'buyerAmount')])[" + index + "]"));
		String amountString2 = "";
		for (int i = 0; i < amountString.length(); i++)
		{
			if (amountString.charAt(i) != ',')
			{
				amountString2 += amountString.charAt(i);
			}
		}
		String amount = amountString2.substring(4, amountString2.length() - 1);
		return amount;
	}

	@Override
	public void clickOnReqIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[@id='buyerlisting']//a[@class='scLnk'])[" + index + "]"));
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnAwaitingQuoteStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AWAITING_QUOTE_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnAwaitingReviewStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AWAITING_REVIEW_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnPendingOrderStatusFilter_1(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PENDING_ORDER_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnUnorderedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (!ActionBot.isElementDisplayed(driver, UNORDERED_BUYERS_DESK_STATUS_FILTER))
		{
			clickOnExpandPendingOrderFilter(driver, testCaseName);
		}
		ActionBot.click(driver, UNORDERED_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnPartiallyOrderedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (!ActionBot.isElementDisplayed(driver, PARTIALLY_ORDERED_BUYERS_DESK_STATUS_FILTER))
		{
			clickOnExpandPendingOrderFilter(driver, testCaseName);
		}
		ActionBot.click(driver, PARTIALLY_ORDERED_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnProcessedStatusFilter_1(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PROCESSED_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnReturnedWithQuoteStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (!ActionBot.isElementDisplayed(driver, RETURNED_WITH_QUOTE_BUYERS_DESK_STATUS_FILTER))
		{
			clickOnProcessedStatusFilter_1(driver, testCaseName);
		}
		ActionBot.click(driver, RETURNED_WITH_QUOTE_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnReturnedWithModificationStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (!ActionBot.isElementDisplayed(driver, RETURNED_FOR_MODIFICATION_BUYERS_DESK_STATUS_FILTER))
		{
			clickOnProcessedStatusFilter_1(driver, testCaseName);
		}
		ActionBot.click(driver, RETURNED_FOR_MODIFICATION_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnOrderingStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (!ActionBot.isElementDisplayed(driver, ORDERING_BUYERS_DESK_STATUS_FILTER))
		{
			clickOnProcessedStatusFilter_1(driver, testCaseName);
		}
		ActionBot.click(driver, ORDERING_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnReleasedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (!ActionBot.isElementDisplayed(driver, RELEASED_BUYERS_DESK_STATUS_FILTER))
		{
			clickOnProcessedStatusFilter_1(driver, testCaseName);
		}
		ActionBot.click(driver, RELEASED_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnRejectedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (!ActionBot.isElementDisplayed(driver, REJECTED_BUYERS_DESK_STATUS_FILTER))
		{
			clickOnProcessedStatusFilter_1(driver, testCaseName);
		}
		ActionBot.click(driver, REJECTED_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnSourcingStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SOURCING_STATUS_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnBuyerNegotiatedPriceStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (!ActionBot.isElementDisplayed(driver, BUYER_NEGOTIATED_PRICE_BUYERS_DESK_STATUS_FILTER))
		{
			clickOnSourcingStatusFilter(driver, testCaseName);
		}
		ActionBot.click(driver, BUYER_NEGOTIATED_PRICE_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnQuotedBySupplierStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (!ActionBot.isElementDisplayed(driver, QUOTED_BY_SUPPLIER_BUYERS_DESK_STATUS_FILTER))
		{
			clickOnSourcingStatusFilter(driver, testCaseName);
		}
		ActionBot.click(driver, QUOTED_BY_SUPPLIER_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnEstimatedPriceStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (!ActionBot.isElementDisplayed(driver, ESTIMATED_PRICE_BUYERS_DESK_STATUS_FILTER))
		{
			clickOnSourcingStatusFilter(driver, testCaseName);
		}
		ActionBot.click(driver, ESTIMATED_PRICE_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnNeedAQuoteStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (!ActionBot.isElementDisplayed(driver, NEED_A_QUOTE_BUYERS_DESK_STATUS_FILTER))
		{
			clickOnSourcingStatusFilter(driver, testCaseName);
		}
		ActionBot.click(driver, NEED_A_QUOTE_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnCancelledStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCELLED_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnClosedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLOSED_BUYERS_DESK_STATUS_FILTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public String getFilterCount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		String count = ActionBot.getTextWithInElement(driver, FOUND_RECORDS);
		return count;
	}

	@Override
	public String getPageItemCount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String quantity = "";
		ActionBot.defaultLowSleep();
		WebElement selectBox = ActionBot.findElement(driver, RECORDS_PER_PAGE);
		Select select = new Select(selectBox);
		quantity = select.getFirstSelectedOption().getText();
		return quantity;
	}

	@Override
	public void naviagteToLastPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, LAST_PAGE);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void naviagteToFirstPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, FIRST_PAGE);
		ActionBot.defaultLowSleep();
	}

	@Override
	public String getShowingPageNumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		return ActionBot.getTextWithInElement(driver, SHOWING_PAGE_NO);
	}

	@Override
	public int getNumberOfReqOnPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		return (ActionBot.findElements(driver, REQ_LIST_PER_PAGE).size());
	}

	@Override
	public boolean isDeliverByDateEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, DELIVER_BY_DATE);
		ActionBot.defaultLowSleep();
		return ActionBot.isElementDisplayed(driver, UI_DATE_PICKER);
	}

	@Override
	public void clickConvertToPo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CONVERT_TO_PO_BUYERS_DESK_LISTING);
	}

	@Override
	public String getReqStatusIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		List<WebElement> listOfStatus = ActionBot.findElements(driver, REQUISITIONS_STATUS);
		return listOfStatus.get(index - 1).getText();
	}

	@Override
	public void clickOnClearIconOfAssignedBuyerFilterUpcomingRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ICON_CLEAR_ASSIGNED_BUYER_FILTER_UPCOMING_REQUISITION);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public boolean isAssignedBuyerFilterUpcomingRequisitionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, ICON_CLEAR_ASSIGNED_BUYER_FILTER_UPCOMING_REQUISITION);
	}

	@Override
	public void selectFirstReqInBuyersDeskListing(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_FIRST_REQ_ON_BUYERS_DESK);
		ActionBot.defaultSleep();
	}

	@Override
	public List<String> getBuyersDeskListingTableColumnNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, COLUMN_NAMES_BUYERS_DESK_TABLE);
		List<String> columns = new ArrayList<>();
		for (WebElement element : elements)
		{
			columns.add(element.getText());
		}
		return columns;
	}

	@Override
	public String getRecievedOnSortingStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getAttributeOfElement(driver, RECEIVED_ON_SORTING_BUTTON, "aria-sort");
	}

}
