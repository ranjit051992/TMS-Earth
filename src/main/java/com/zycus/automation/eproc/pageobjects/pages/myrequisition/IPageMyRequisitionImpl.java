package com.zycus.automation.eproc.pageobjects.pages.myrequisition;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageMyRequisitionImpl extends IPageMyRequisitionUtil implements IPageMyRequisition
{

	static Logger logger = Logger.getLogger(IPageMyRequisitionImpl.class);

	@Override
	public void toClickOnAddBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, ADD_BUTTON);
	}

	@Override
	public String fillReqNumberOnMyReq(WebDriver driver, String testcaseName, String reqNo) throws ActionBotException
	{
		// ActionBot.defaultSleep();
		ActionBot.defaultSleep();
		ActionBot.waitForElementToBePresent(driver, 60, REQUISITION_NUMBER_ON_MY_REQ);
		ActionBot.click(driver, REQUISITION_NUMBER_ON_MY_REQ);

		// remove this after bug is resolved(4 lines)?
		ActionBot.defaultLowSleep();
		clearRequisitionNameFilter(driver, testcaseName);
		ActionBot.waitForPageLoad(driver);
		ActionBot.click(driver, REQUISITION_NUMBER_ON_MY_REQ);

		ActionBot.defaultHighSleep();
		// ActionBot.waitForElementToBeDisplayed(driver,
		// REQUISITION_NUMBER_ON_MY_REQ, 60);
		ActionBot.click(driver, REQUISITION_NUMBER_ON_MY_REQ);
		ActionBot.sendKeys(driver, REQUISITION_NUMBER_ON_MY_REQ, reqNo);
		ActionBot.findElement(driver, REQUISITION_NUMBER_ON_MY_REQ).sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		ActionBot.waitTillPopUpIsPresent(driver, REQ_LIST_PROCESSING);
		String reqNumber = ActionBot.findElement(driver, REQUISITION_NUMBER_ON_MY_REQ).getAttribute("value");
		logger.info("Req Number entered is : " + reqNumber);
		ScreenShot.screenshot(driver, testcaseName, "after searching reqNumber");
		return reqNumber;
	}

	@Override
	public String fillReqName(WebDriver driver, String testcaseName, String reqName) throws ActionBotException
	{
		// ActionBot.sendKeys(driver, REQUISITION_SEARCH_NAME_ON_MY_REQ, reqName
		// + Keys.ENTER + Keys.ENTER);
		ActionBot.defaultSleep();
		ActionBot.waitForElementToBePresent(driver, 60, REQUISITION_SEARCH_NAME_ON_MY_REQ);
		ActionBot.click(driver, REQUISITION_SEARCH_NAME_ON_MY_REQ);

		// remove this after bug is resolved(4 lines)?
		ActionBot.defaultLowSleep();
		clearRequisitionNumberFilter(driver, testcaseName);
		ActionBot.waitForPageLoad(driver);
		ActionBot.click(driver, REQUISITION_SEARCH_NAME_ON_MY_REQ);

		ActionBot.defaultMediumSleep();
		ActionBot.sendKeys(driver, REQUISITION_SEARCH_NAME_ON_MY_REQ, reqName);
		ActionBot.findElement(driver, REQUISITION_SEARCH_NAME_ON_MY_REQ).sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		ActionBot.waitTillPopUpIsPresent(driver, REQ_LIST_PROCESSING);

		String requisitionName = ActionBot.findElement(driver, REQUISITION_SEARCH_NAME_ON_MY_REQ).getAttribute("value");
		logger.info("Req Name entered is: " + requisitionName);
		ScreenShot.screenshot(driver, testcaseName, "after searching reqName");
		return requisitionName;
	}

	@Override
	public String fillRequester(WebDriver driver, String testcaseName, String requesterName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.waitForElementToBePresent(driver, 60, REQUESTER_ON_MYREQ);
		ActionBot.waitForElementToBeDisplayed(driver, REQUESTER_ON_MYREQ, 60);
		ActionBot.sendKeys(driver, REQUESTER_ON_MYREQ, requesterName + Keys.ENTER);
		ActionBot.defaultSleep();
		String requesterNameOnMyReq = ActionBot.findElement(driver, REQUESTER_ON_MYREQ).getText();
		logger.info("Requester Name entered is: " + requesterNameOnMyReq);
		return requesterNameOnMyReq;
	}

	@Override
	public void clearStatusFilter(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, 60, CLEAR_STATUS_FILTER);
		ActionBot.waitForElementToBeDisplayed(driver, CLEAR_STATUS_FILTER, 60);
		ActionBot.click(driver, CLEAR_STATUS_FILTER);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clearAllStatusFilter(WebDriver driver, String testcaseName) throws ActionBotException
	{
		// PageMyRequisition.clickOnStatusFilterBtn(driver, testcaseName);
		// ActionBot.waitForElementToBePresent(driver, 60, CLEAR_FILTER_STATUS);
		ActionBot.waitForElementToBeDisplayed(driver, CLEAR_FILTER_STATUS, 60);
		ActionBot.click(driver, CLEAR_FILTER_STATUS);
	}

	@Override
	public void clearSubmittedOnFilter(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLEAR_SUBMITTED_ON_FILTER);

	}

	@Override
	public void clearAmountFilter(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLEAR_SUBMITTED_ON_FILTER);

	}

	@Override
	public void clickOnReqNoLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, REQ_NUMBER_LINK_ON_MYREQ);
		ActionBot.defaultSleep();
	}

	@Override
	public List<String> getReqNoList(WebDriver driver, String testcaseName) throws ActionBotException
	{
		List<String> reqNoList = new ArrayList<String>();
		List<WebElement> element = ActionBot.findElements(driver, REQ_NUMBER_LIST_ON_MYREQ);
		for (int i = 0; i < element.size(); i++)
		{
			String reqNumber = element.get(i).getText();
			logger.info("Req Number at Position" + i + "in the List is " + reqNumber);
			reqNoList.add(reqNumber);
		}
		return reqNoList;
	}

	@Override
	public List<String> getRequesterList(WebDriver driver, String testcaseName) throws ActionBotException
	{
		List<String> requesterList = new ArrayList<String>();
		List<WebElement> element = ActionBot.findElements(driver, REQUESTER_LIST_ON_MYREQ);
		for (int i = 0; i < element.size(); i++)
		{
			String requesterName = element.get(i).getText();
			logger.info("Requester at Position" + i + "in the List is " + requesterName);
			requesterList.add(requesterName);
		}
		return requesterList;
	}

	@Override
	public void clickOnActionBtnOfFirstReq(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, ACTION_BUTTON);
	}

	@Override
	public void clickOnReqNumberOnHeader(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, REQ_NUMBER_LABEL_ON_HEADER);

	}

	@Override
	public void clickOnSubmittedOnHeader(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, SUBMITTED_ON_LABEL_ON_HEADER);

	}

	@Override
	public void clickOnAmountOnHeader(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, AMOUNT_LABEL_ON_HEADER);

	}

	@Override
	public void clickOnStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.waitForElementToBeEnable(driver, By.xpath("(.//*[@id='reqList']//div[@class='thPad']//div[contains(@class,'fltrWrapIco')])[1]"), 6000);
		ActionBot.click(driver, By.xpath("(.//*[@id='reqList']//div[@class='thPad']//div[contains(@class,'fltrWrapIco')])[1]"));
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnSubmittedOnFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, SUBMITTED_ON_FILTER_BTN);

	}

	@Override
	public void clickOnAmountFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, AMOUNT_FILTER_BTN);

	}

	@Override
	public String getReqNoFromMyReq(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String reqNumber = ActionBot.findElement(driver, REQ_NUMBER_LINK_ON_MYREQ).getText();
		logger.info("Req Number entered is: " + reqNumber);
		return reqNumber;
	}

	@Override
	public String getReqNameFromMyReq(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String requisitionName = ActionBot.findElement(driver, REQUISITION_SEARCH_NAME_ON_MY_REQ).getAttribute("value");
		logger.info("Req Name entered is: " + requisitionName);
		return requisitionName;
	}

	@Override
	public String getReqRequester(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String requesterName = ActionBot.findElement(driver, REQUESTER_ON_MYREQ).getAttribute("value");
		logger.info("Requester Name : " + requesterName);
		return requesterName;
	}

	@Override
	public List<String> getRequisitionStatusList(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> reqStatusList = new ArrayList<String>();
		ScreenShot.screenshot(driver, testCaseName, "My requisition status");
		List<WebElement> statusList = ActionBot.findElements(driver, MY_REQUISITION_STATUS);
		for (WebElement ele : statusList)
		{
			reqStatusList.add(ele.getText().trim());
		}
		return reqStatusList;
	}

	@Override
	public int getRequisitionStatusListSize(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return getRequisitionStatusList(driver, testCaseName).size();
	}

	@Override
	public boolean isAddReqButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, ADD_REQ_BUTTON);
	}

	@Override
	public String getFirstReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqNo = ActionBot.getTextWithInElement(driver, FIRST_REQ_NO_LINK);
		logger.info("First Row Requisition No : " + reqNo);
		return reqNo;
	}

	@Override
	public void clickOnFirstReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		ActionBot.click(driver, FIRST_REQ_NO_LINK);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on first requisition");
	}

	@Override
	public String getFirstReqName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqName = ActionBot.getTextWithInElement(driver, FIRST_REQ_NAME);
		if (reqName.charAt(reqName.length() - 1) == '*')
		{
			String newName = reqName.substring(0, reqName.length() - 1);
			logger.info("First Row Requisition Name : " + newName);
			return newName;
		}
		else
		{
			logger.info("First Row Requisition Name : " + reqName);
			return reqName;
		}

	}

	@Override
	public String getFirstRequester(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String requester = ActionBot.getTextWithInElement(driver, FIRST_REQ_REQUESTER);
		logger.info("First Row Requisition Requester : " + requester);
		return requester;
	}

	@Override
	public String getFirstSubmittedOn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String submittedOn = ActionBot.getTextWithInElement(driver, FIRST_REQ_SUBMITTED_ON);
		logger.info("First Row Requisition Submitted On : " + submittedOn);
		return submittedOn;
	}

	@Override
	public String getFirstTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String totalAmount = ActionBot.getTextWithInElement(driver, FIRST_REQ_TOTAL_AMOUNT);
		logger.info("First Row Requisition Total Amount : " + totalAmount);
		return totalAmount;
	}

	@Override
	public String getStatusOfFirstReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String status = ActionBot.getTextWithInElement(driver, MY_REQUISITION_STATUS);
		logger.info("Requisition status : " + status);
		ScreenShot.screenshot(driver, testCaseName, "Requisition status");
		return status;
	}

	@Override
	public void clickOnRecallApprocalRequestLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, RECALL_APPROVAL_REQUEST_LINK);

	}

	@Override
	public String fillRecallApprovalComment(WebDriver driver, String testcaseName, String recallcommnet) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_COMMENT_MYREQUITION, recallcommnet);
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_RECALL);
		return recallcommnet;

	}

	@Override
	public String fillCancelComment(WebDriver driver, String testcaseName, String cancelcommnet) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_CANCEL_COMMENT, cancelcommnet);
		ActionBot.defaultSleep();
		ActionBot.click(driver, TEXT_CANCEL_COMMENT);
		return cancelcommnet;

	}

	@Override
	public void clickOnReqAction(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, By.xpath("(.//*[@id='reqList']//*[@class='actBx'])[" + index + "]"));
	}

	@Override
	public void clickOnDeleteReq(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[@id='reqList']//a[text()='Delete'])[" + index + "]"));
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After Deleting Requisition");
	}

	@Override
	public boolean isRecallReqActionPresentInApprovalReq(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath("(.//*[@id='reqList']//a[contains(text(),'Recall approval')])[" + index + "]"));
	}

	@Override
	public boolean isDeleteReqActionPresentInApprovalReq(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath("(.//*[@id='reqList']//a[contains(text(),'Delete')])[" + index + "]"));
	}

	@Override
	public void clickToNaviagteToNextPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, NAVIGATE_TO_NEXT_ACTIVE_PAGE);
	}

	@Override
	public boolean isCreateRecieptActionPresentInApprovalReq(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath("(.//*[@id='reqList']//a[contains(@class,'createreceipt')])[" + index + "]"));
	}

	@Override
	public void clickOnReq(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[@id='reqList']//a[@class='scLnk'])[" + index + "]"), 20);
		ActionBot.click(driver, By.xpath("(.//*[@id='reqList']//a[@class='scLnk'])[" + index + "]"));
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnReturnedForAmendInStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_RETURNED_FOR_AMENDMENT_STATUS_FILTER);

	}

	@Override
	public boolean isEditPresentInActionReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, SELECT_EDIT_IN_REQ_ACTION);
	}

	@Override
	public boolean isCancelPresentInActionReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, SELECT_CANCEL_IN_REQ_ACTION);
	}

	@Override
	public void clickOnPerformFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{

		WebElement element = ActionBot.findElement(driver, BUTTON_FILTER_MY_REQUISITION);

		// ActionBot.focusAndclick(driver, CLICK_FILTER_GENERIC);
		if (ActionBot.isElementDisplayed(driver, BUTTON_FILTER_MY_REQUISITION) && ActionBot.isElementPresent(driver, BUTTON_FILTER_MY_REQUISITION))
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		}
		else
		{
			ActionBot.waitForElementToBeEnable(driver, BUTTON_FILTER_MY_REQUISITION, 6000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		}

		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnInApprovalInStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_IN_APPROVAL_STATUS_FILTER);
	}

	@Override
	public void clickOnBuyersDeskInStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_IN_BUYERS_DESK_STATUS_FILTER);
	}

	@Override
	public void clickOnRejectedInStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_IN_REJECTED_STATUS_FILTER);
	}

	@Override
	public void clickOnReleasedInStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_IN_RELEASED_STATUS_FILTER);
	}

	@Override
	public void clickOnOrderingInStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, SELECT_ORDERING_STATUS_FILTER);
	}

	@Override
	public void clickOnCopyActionReq(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[@id='reqList']//a[text()='Copy'])[" + index + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[@id='reqList']//a[text()='Copy'])[" + index + "]"), 10);
		ActionBot.click(driver, By.xpath("(.//*[@id='reqList']//a[text()='Copy'])[" + index + "]"));
	}

	@Override
	public void clickOnCancelActionReq(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[@id='reqList']//a[text()='Cancel'])[" + index + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[@id='reqList']//a[text()='Cancel'])[" + index + "]"), 10);
		ActionBot.click(driver, By.xpath("(.//*[@id='reqList']//a[text()='Cancel'])[" + index + "]"));
	}

	@Override
	public void clickOnDraftInStatusFilterBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		// ActionBot.click(driver, SELECT_DRAFT_STATUS_FILTER);
		WebElement element = driver.findElement(By.xpath("(.//*[@id='draft']//input[contains(@class,'inptChk')])[3]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);

	}

	@Override
	public boolean isCopyActionReqAvailable(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath("(.//*[@id='reqList']//a[text()='Copy'])[" + index + "]"));
	}

	@Override
	public boolean isDeletedReqPresent(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException
	{
		searchRequisitionByReqNo(driver, testCaseName, reqNo);
		return ActionBot.isElementPresent(driver, By.xpath("(.//*[@id='reqList']//td[contains(@class,'requisitionNo')])[1]"));
	}

	@Override
	public void searchRequisitionByReqNo(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, searchReqByNo);
		element.sendKeys(reqNo);
		element.sendKeys(Keys.ENTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public boolean isReqPresentInCart(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath("(.//*[contains(@id,'dev-item')])[" + (index) + "]"));
	}

	@Override
	public void clickOnProceedWithReqItemsOnlyButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, PROCEED_WITH_ONLY_REQ_ITEMS, 6);
		ActionBot.click(driver, PROCEED_WITH_ONLY_REQ_ITEMS);
	}

	@Override
	public String getReqNumberRowise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[@id='reqList']//a[@class='scLnk'])[" + index + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[@id='reqList']//a[@class='scLnk'])[" + index + "]"), 10);
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='reqList']//a[@class='scLnk'])[" + index + "]"));
	}

	@Override
	public void clickOnReqItemIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		//ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'dev-item_')])[" + index + "]//a"));
		//ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'dev-item_')])[" + index + "]//a"), 10);
		//ActionBot.click(driver, By.xpath("(.//*[contains(@id,'dev-item_')])[" + index + "]//a"));

		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'item_')])[" + index + "]//div/a"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'item_')])[" + index + "]//div/a"), 10);
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'item_')])[" + index + "]//div/a"));
	}

	@Override
	public boolean clickOnReqAuditVerIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			ActionBot.waitForPageLoad(driver);
			ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'audit_')]//a)[" + index + "]"));
			ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'audit_')]//a)[" + index + "]"), 10);
			ActionBot.click(driver, By.xpath("(.//*[contains(@id,'audit_')]//a)[" + index + "]"));
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public void clickCancelActionReqButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, CANCEL_REQUISITION_BUTTON, 60);
		ActionBot.click(driver, CANCEL_REQUISITION_BUTTON);
	}

	@Override
	public boolean isReqSuccessfullySubmitted(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, SUCCESS_MESSAGE);
	}

	@Override
	public void clickApprovalReqButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RECALL_APPROVAL_REQUEST);
	}

	@Override
	public boolean toHoverUponRequistionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, By.xpath("(.//*[@id='reqList']//a[@class='scLnk'])[" + index + "]"));
		ActionBot.moveToElement(driver, element);
		try
		{
			ActionBot.hover(driver, By.xpath("(.//*[@id='reqList']//a[@class='scLnk'])[" + index + "]"));
			return true;
		}
		catch (Exception ee)
		{
			return false;
		}
	}

	@Override
	public String fetchRequisitionBillingAddress(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'content')]//div[@class='frmInpt deliveryAdd'])[" + index + "]"));
	}

	@Override
	public void clickAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AMOUNT_FILTER_MYREQ);
	}

	@Override
	public void enterMinAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		ActionBot.sendKeys(driver, MINIMUM_AMOUNT_RANGE, amount);
	}

	@Override
	public void enterMaxAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		ActionBot.sendKeys(driver, MAX_AMOUNT_RANGE, amount);
	}

	@Override
	public void clickApplyAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AMOUNT_FILTER_Button);
	}

	@Override
	public boolean isReqPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@id='reqList']//a[@class='scLnk'])[" + index + "]"));
	}

	@Override
	public String fetchRequisitionAmountIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String amountString = ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='reqList']//td[contains(@class,'totalAmountReq')])[" + index + "]"));
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
	public boolean isReqStatusPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@id='reqList']//div[contains(@class,'statusTxt')])[" + index + "]"));
	}

	@Override
	public boolean isReqNamePresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='reqList']//a[@class='scLnk'])[" + index + "]"));
		if (str.equals("-"))
			return false;
		else
			return true;
	}

	@Override
	public boolean isReqRequesterPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='reqList']//td[contains(@class,'behalfUser')])[" + index + "]"));
		if (str.equals("-"))
			return false;
		else
			return true;
	}

	@Override
	public boolean isReqSubmittedonPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='reqList']//td[contains(@class,'submittedOn')])[" + index + "]"));
		if (str.equals("-"))
			return false;
		else
			return true;
	}

	@Override
	public boolean isReqAmountPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='reqList']//td[contains(@class,'totalAmountReq')])[" + index + "]"));
		if (str.equals("-"))
			return false;
		else
			return true;
	}

	@Override
	public void clickToApplyAscendingSort(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'requisitionNo')]//span[contains(@class,'n-s')]")))
			ActionBot.click(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'requisitionNo')]//span[contains(@class,'n-s')]"));
		else if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'requisitionNo')]//span[contains(@class,'-s')]")))
			ActionBot.click(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'requisitionNo')]//span[contains(@class,'-s')]"));
	}

	@Override
	public void clickToApplyDescendingSort(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'requisitionNo')]//span[contains(@class,'n-s')]")))
		{
			ActionBot.click(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'requisitionNo')]//span[contains(@class,'n-s')]"));
			ActionBot.defaultMediumSleep();
			ActionBot.click(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'requisitionNo')]//span[contains(@class,'-n')]"));
		}
		else if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'requisitionNo')]//span[contains(@class,'-n')]")))
			ActionBot.click(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'requisitionNo')]//span[contains(@class,'-n')]"));
	}

	@Override
	public void clickToApplyAscendingSortOnDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'submittedOn')]//span[contains(@class,'n-s')]")))
			ActionBot.click(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'submittedOn')]//span[contains(@class,'n-s')]"));
		else if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'submittedOn')]//span[contains(@class,'-s')]")))
			ActionBot.click(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'submittedOn')]//span[contains(@class,'-s')]"));
	}

	@Override
	public void clickToApplyDescendingSortOnDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'submittedOn')]//span[contains(@class,'n-s')]")))
		{
			ActionBot.click(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'submittedOn')]//span[contains(@class,'n-s')]"));
			ActionBot.defaultMediumSleep();
			ActionBot.click(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'submittedOn')]//span[contains(@class,'-n')]"));
		}
		else if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'submittedOn')]//span[contains(@class,'-n')]")))
			ActionBot.click(driver, By.xpath(".//*[@id='reqList']//th[contains(@class,'submittedOn')]//span[contains(@class,'-n')]"));
	}

	@Override
	public String fetchRequisitionSubumitionDateIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='reqList']//td[contains(@class,'submittedOn')])[" + index + "]"));
	}

	@Override
	public boolean isReqStatusPresentInStatusFilter(WebDriver driver, String testCaseName, String id) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		if (id.equalsIgnoreCase(IConstantsData.REJECTED_FILTER_LABEL) || id.equalsIgnoreCase(IConstantsData.CLOSED_FILTER_LABEL)
			|| id.equalsIgnoreCase(IConstantsData.CANCELLED_FILTER_LABEL))
		{
			return ActionBot.isElementPresent(driver, By.xpath("(//*[text()='" + id + "'])[4]"));
		}
		if (id.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL))
		{
			return ActionBot.isElementPresent(driver, IPageMyRequisition.DRAFT_STATUS_IN_PROCESS);
		}

		if (id.equalsIgnoreCase(IConstantsData.RELEASED))
		{
			return ActionBot.isElementPresent(driver, IPageMyRequisition.EXPAND_RELEASED_IN_PROCESS_FILTER);
		}
		if (id.equalsIgnoreCase(IConstantsData.PARTIALLY_ORDERED_FILTER_LABEL) || id.equalsIgnoreCase(IConstantsData.NOT_RECEIVED_FILTER_LABEL)
			|| id.equalsIgnoreCase(IConstantsData.PARTIALLY_RECEIVED_FILTER_LABEL) || id.equalsIgnoreCase(IConstantsData.FULLY_RECEIVED_FILTER_LABEL))
		{
			return ActionBot.isElementPresent(driver, By.xpath("(//*[text()='" + id + "'])[4]"));
		}
		if (!ActionBot.isElementPresent(driver, By.xpath("(//*[text()='" + id + "'])[2]")))
		{
			PageMyRequisition.clickOnExpandReleasedInProcessInStatusFilterBtn(driver, testCaseName);
			ActionBot.defaultLowSleep();
		}
		return ActionBot.isElementPresent(driver, By.xpath("(//*[text()='" + id + "'])[2]"));

	}

	@Override
	public void clickOnExpandReleasedInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		ActionBot.click(driver, EXPAND_RELEASED_ORDER_STATUS);
	}

	@Override
	public List<WebElement> fetchRequisitionNumbers(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, REQ_LIST_PAGE_MY_REQUISTION);
	}

	@Override
	public boolean clickOnLinkRemindApprover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_REMIND_APPROVER_MY_REQ))
		{
			ActionBot.click(driver, LINK_REMIND_APPROVER_MY_REQ);
			ScreenShot.screenshot(driver, testCaseName, "After clicking remind approver");
			ActionBot.waitTillPopUpIsPresent(driver, POPUP_CONFIRMATION_REMIND_APPROVER);
			return true;
		}
		return false;
	}

	@Override
	public boolean clickOnSubmitButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SUBMIT_MY_REQ);
		ActionBot.waitTillPopUpIsPresent(driver, POPUP_SUBMIT_GROUP_MY_REQ);
		if (ActionBot.isElementDisplayed(driver, BUTTON_SUBMIT_MY_REQ))
		{
			return false;
		}
		else
			return true;
	}

	@Override
	public boolean isStatusFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.findElement(driver, STATUS_FILTER_BTN) != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isRequisitionNumberFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.findElement(driver, REQ_NUMBER_LABEL_ON_HEADER) != null)
		{
			return true;
		}
		return false;

	}

	@Override
	public boolean isRequisitionNameFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{

		if (ActionBot.findElement(driver, REQUISITION_SEARCH_NAME_ON_MY_REQ) != null)
		{
			return true;
		}

		return false;
	}

	@Override
	public boolean isRequesterFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.findElement(driver, REQUESTER_LIST_ON_MYREQ) != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isSubmittedOnFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.findElement(driver, SUBMITTED_ON_LABEL_ON_HEADER) != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isAmountFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.findElement(driver, AMOUNT_LABEL_ON_HEADER) != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isActionsFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.findElement(driver, ACTION_BUTTON) != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public String getRequisitionExternalId(WebDriver driver, String testCaseName, String requisitonId) throws ActionBotException
	{
		String externalId = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// logger.info("Appended String:
		// requisitionMap[\""+requisitonId+"\"].externalId");
		externalId = js.executeScript("return requisitionMap[\"" + requisitonId + "\"].externalId").toString();
		return externalId;
	}

	@Override
	public String getRequisitionId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqId = null;
		String id[] = ActionBot.getAttributeOfElement(driver, FIRST_REQ_NO_LINK, "href").split("requisitionId=");
		reqId = id[1];
		return reqId;
	}

	@Override
	public void clickOnRecallLink_ReqHover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, FIRST_REQ_NO_LINK);
		ActionBot.defaultSleep();
		List<WebElement> eleList = ActionBot.findElements(driver, LINK_RECALL_APPROVAL_REQUEST_ON_REQ_HOVER);

		for (WebElement ele : eleList)
		{
			if (ele.isDisplayed())
			{
				ele.click();
				logger.info("After clicking on Recall approval request link");
			}
		}
	}

	@Override
	public void clearRequisitionNameFilter(WebDriver driver, String testcaseName) throws ActionBotException
	{

		if (ActionBot.isElementDisplayed(driver, CLEAR_REQUISITION_NAME_FILTER) || ActionBot.isElementPresent(driver, CLEAR_REQUISITION_NAME_FILTER))
		{
			ActionBot.focusAndclick(driver, CLEAR_REQUISITION_NAME_FILTER);
			ActionBot.waitTillPopUpIsPresent(driver, REQ_LIST_PROCESSING);
		}

	}

	@Override
	public void clearRequisitionNumberFilter(WebDriver driver, String testcaseName) throws ActionBotException
	{

		if (ActionBot.isElementDisplayed(driver, CLEAR_REQUISITION_NUMBER_FILTER) || ActionBot.isElementPresent(driver, CLEAR_REQUISITION_NUMBER_FILTER))
		{
			ActionBot.focusAndclick(driver, CLEAR_REQUISITION_NUMBER_FILTER);
			ActionBot.waitTillPopUpIsPresent(driver, REQ_LIST_PROCESSING);
		}

	}

	@Override
	public void clickOnExpandInProcessInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, EXPAND_IN_PROCESS_FILTER))
		{
			ActionBot.focusAndclick(driver, EXPAND_IN_PROCESS_FILTER);
			ActionBot.defaultSleep();
		}

	}

	@Override
	public void clickOnExpandReleasedInProcessInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, EXPAND_RELEASED_IN_PROCESS_FILTER))
		{
			ActionBot.focusAndclick(driver, EXPAND_RELEASED_IN_PROCESS_FILTER);
		}
		else
		{
			clickOnExpandInProcessInStatusFilterBtn(driver, testCaseName);
			if (ActionBot.isElementDisplayed(driver, EXPAND_RELEASED_IN_PROCESS_FILTER))
			{
				ActionBot.focusAndclick(driver, EXPAND_RELEASED_IN_PROCESS_FILTER);
			}
		}
	}

	public boolean isPopUpProceedWithReqAndExistingCartItemsPreset(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_YES_CONFIRM_PROCEED_WITH_REQ_AND_EXISTING_CART_ITEMS);
	}

	@Override
	public void clickProceedWithReqAndExistingCartItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_YES_CONFIRM_PROCEED_WITH_REQ_AND_EXISTING_CART_ITEMS);

	}

	@Override
	public boolean isPopUpProceedOnlyWithReqItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_NO_CONFIRM_PROCEED_ONLY_WITH_REQ_ITEMS);
	}

	@Override
	public void clickProceedOnlyWithReqItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_NO_CONFIRM_PROCEED_ONLY_WITH_REQ_ITEMS);

	}
}
