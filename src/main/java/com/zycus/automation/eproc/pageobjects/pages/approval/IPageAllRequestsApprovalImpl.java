/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.approval;

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

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 */
public class IPageAllRequestsApprovalImpl implements IPageAllRequestsApproval, IConstants
{

	Logger logger = Logger.getLogger(IPageAllRequestsApprovalImpl.class);

	@Override
	public void clickOnActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ACTIONS_LINK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on actions link");

	}

	@Override
	public void clickOnAmountActivatedSortLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AMOUNT_ACTIVATED_SORT_LINK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Amount activated sort link");

	}

	@Override
	public void clickOnAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AMOUNT_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Amount On filter");

	}

	@Override
	public void clickOnAmountSortLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AMOUNT_SORT_LINK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Amount sort link");

	}

	@Override
	public void clickOnApproveLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ACTIONS_APPROVE_OPTION);

	}

	@Override
	public void clickOnApproveLinkIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[@id='workflowApproval']//a[text()='Approve'])[" + index + "]"));

	}

	@Override
	public void clickOnCheckAll(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AUTO_CHECK_ALL);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Auto check all");

	}

	@Override
	public void clickOnClearAllFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLEAR_ALL_FILTERS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Clear all filters");

	}

	@Override
	public void clickOnClearApprovalStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_CLEAR_APPROVAL_STATUS_FILTER))
		{
			ActionBot.focusAndclick(driver, BUTTON_CLEAR_APPROVAL_STATUS_FILTER);
			ActionBot.waitTillPopUpIsPresent(driver, APPROVAL_PROCESSING);
			ActionBot.waitForPageLoad(driver);
		}
	}

	@Override
	public void clickOnDocumentNoActivatedSortLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DOCUMENT_NO_ACTIVATED_SORT_LINK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Document No activated sort link");

	}

	@Override
	public void clickOnDocumentNoSortLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DOCUMENT_NO_SORT_LINK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Document No sort link");

	}

	@Override
	public void clickOnDocumentTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DOCUMENT_TYPE_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on document type filter");
	}

	@Override
	public void clickOnReceivedOnFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RECEIVED_ON_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Received On filter");

	}

	@Override
	public void clickOnRecivedOnActivatedSortLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RECEIVED_ON_ACTIVATED_SORT_LINK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Recived On activated sort link");

	}

	@Override
	public void clickOnRecivedOnSortLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RECEIVED_ON_SORT_LINK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Recived On sort link");

	}

	@Override
	public void clickOnStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, 10, STATUS_FILTER);
		ActionBot.waitForElementToBeDisplayed(driver, STATUS_FILTER, 10);
		ActionBot.click(driver, STATUS_FILTER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on status filter");
	}

	@Override
	public String fillDocumentName(WebDriver driver, String testCaseName, String documentName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, DOCUMENT_NAME);
		element.clear();
		element.sendKeys(documentName);
		element.sendKeys(Keys.ENTER);
		// ScreenShot.screenshot(driver, testCaseName, "After filling document
		// name");
		String document_Name = ActionBot.findElement(driver, DOCUMENT_NAME).getAttribute("value");
		logger.info("Document Name : " + document_Name);
		ActionBot.defaultMediumSleep();
		return document_Name;
	}

	@Override
	public String fillDocumentNo(WebDriver driver, String testCaseName, String documentNo) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, DOCUMENT_NO);
		element.sendKeys(documentNo);
		ActionBot.defaultMediumSleep();
		element.sendKeys(Keys.ENTER);
		// ScreenShot.screenshot(driver, testCaseName, "After filling document
		// no");
		String document_No = ActionBot.findElement(driver, DOCUMENT_NO).getAttribute("value");
		logger.info("Document No : " + document_No);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		return document_No;
	}

	@Override
	public String fillInitiatorName(WebDriver driver, String testCaseName, String initiatorName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, INITIATOR);
		element.clear();
		element.sendKeys(initiatorName);
		ActionBot.defaultSleep();
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.ENTER);
		ScreenShot.screenshot(driver, testCaseName, "After filling Initiator name");
		String initiator_Name = ActionBot.findElement(driver, INITIATOR).getAttribute("value");
		logger.info("Initiator Name : " + initiator_Name);
		ActionBot.defaultSleep();
		return initiator_Name;
	}

	@Override
	public List<WebElement> getAllDocumentAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> allDocumentAmount = ActionBot.findElements(driver, ALL_APPROVAL_DOCUMENT_AMOUNT);
		return allDocumentAmount;
	}

	@Override
	public List<WebElement> getAllDocumentAmountAfterSorting(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> allDocumentAmountAfterSorting = ActionBot.findElements(driver, ALL_APPROVAL_DOCUMENT_AMOUNT_AFTER_SORTING);
		return allDocumentAmountAfterSorting;
	}

	@Override
	public List<WebElement> getAllDocumentNos(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> allDocumentNos = ActionBot.findElements(driver, ALL_APPROVAL_DOCUMENT_NOS);
		return allDocumentNos;
	}

	@Override
	public List<WebElement> getAllDocumentNosAfterSorting(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> allDocumentNosAfterSorting = ActionBot.findElements(driver, ALL_APPROVAL_DOCUMENT_NOS_AFTER_SORTING);
		return allDocumentNosAfterSorting;
	}

	@Override
	public List<WebElement> getAllDocumentReceivedOn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> allDocumentReceivedOn = ActionBot.findElements(driver, ALL_APPROVAL_DOCUMENT_RECEIVED_ON);
		return allDocumentReceivedOn;
	}

	@Override
	public List<WebElement> getAllDocumentRecivedOnAfterSorting(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> allDocumentReceivedOnAfterSorting = ActionBot.findElements(driver, ALL_APPROVAL_DOCUEMNT_RECEIVED_ON_AFTER_SORTING);
		return allDocumentReceivedOnAfterSorting;
	}

	@Override
	public int getApprovalEmptyTableSize(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, APPROVAL_TABLE_EMPTY).size();
	}

	@Override
	public String getDocumentName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Document name");
		String document_Name = ActionBot.findElement(driver, DOCUMENT_NAME).getAttribute("value");
		logger.info("Document Name : " + document_Name);
		return document_Name;
	}

	@Override
	public String getDocumentNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Document no");
		String document_No = ActionBot.findElement(driver, DOCUMENT_NO).getAttribute("value");
		logger.info("Document No : " + document_No);
		return document_No;
	}

	@Override
	public String getDocumentStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String docStatus = null;

		docStatus = ActionBot.getTextWithInElement(driver, APPROVAL_STATUS);

		ScreenShot.screenshot(driver, testCaseName, "Document Status");
		logger.info("Document status : " + docStatus);
		return docStatus;
	}

	@Override
	public String getFirstRowAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String documentAmount = ActionBot.getTextWithInElement(driver, FIRST_ROW_APPROVAL_DOCUMENT_AMOUNT);
		ScreenShot.screenshot(driver, testCaseName, "First Row Document Amount");
		logger.info("First Row Document Amount : " + documentAmount);
		return documentAmount;
	}

	@Override
	public String getFirstRowDocumentName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		/*
		 * String documentName = ActionBot.findElement(driver,
		 * FIRST_ROW_APPROVAL_DOCUMENT_NAME).getAttribute("title") .trim();
		 */
		String documentName = ActionBot.getTextWithInElement(driver, FIRST_ROW_APPROVAL_DOCUMENT_NAME);
		logger.info("First Row Document Name : " + documentName);
		if (documentName.contains("."))
		{
			String[] temp = StringUtils.split(documentName, ".");
			documentName = temp[0].trim();
		}
		return documentName;
	}

	@Override
	public String getFirstRowDocumentNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String documentNo = ActionBot.getTextWithInElement(driver, FIRST_ROW_APPROVAL_DOCUMENT_NO);
		ScreenShot.screenshot(driver, testCaseName, "First Row Document No");
		logger.info("First Row Document No : " + documentNo);
		return documentNo;
	}

	@Override
	public String getFirstRowDocumentType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String documentType = ActionBot.getTextWithInElement(driver, FIRST_ROW_APPROVAL_DOCUMENT_TYPE);
		ScreenShot.screenshot(driver, testCaseName, "First Row Document Type");
		logger.info("First Row Document Type : " + documentType);
		return documentType;
	}

	@Override
	public String getFirstRowInitiatorName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String documentInitiatorName = ActionBot.getTextWithInElement(driver, FIRST_ROW_APPROVAL_DOCUMENT_INITIATOR);
		ScreenShot.screenshot(driver, testCaseName, "First Row Document Initiator Name");
		logger.info("First Row Document Initiator Name : " + documentInitiatorName);
		return documentInitiatorName;
	}

	@Override
	public String getFirstRowReceivedOn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String documentRecivedOn = ActionBot.getTextWithInElement(driver, FIRST_ROW_APPROVAL_DOCUEMNT_RECEIVED_ON);
		ScreenShot.screenshot(driver, testCaseName, "First Row Document Recived On");
		logger.info("First Row Document Recived On : " + documentRecivedOn);
		return documentRecivedOn;
	}

	@Override
	public String getInitiatorName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "After filling Initiator name");
		String initiator_Name = ActionBot.findElement(driver, INITIATOR).getAttribute("value");
		logger.info("Initiator Name : " + initiator_Name);
		return initiator_Name;
	}

	@Override
	public List<String> getListOfApprovalStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> listOfStatus = new ArrayList<String>();
		List<WebElement> statusList = ActionBot.findElements(driver, APPROVAL_STATUS);
		for (WebElement element : statusList)
		{
			listOfStatus.add(element.getText().trim());
		}
		return listOfStatus;
	}

	@Override
	public boolean isSuccessMessage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		//		WebElement element=ActionBot.waitForElementToBeDisplayed(driver, ALL_REQUESTS_APPROVAL_SUCCESS_MESSAGE, ActionBot.timeOut);
		//		if(element!=null)
		//			return true;
		//		else
		//			return false;
		if (ActionBot.isElementPresent(driver, ALL_REQUESTS_APPROVAL_SUCCESS_MESSAGE))
		{
			//ActionBot.findElement(driver, ALL_REQUESTS_APPROVAL_SUCCESS_MESSAGE);
			return true;
		}
		return ActionBot.isElementPresent(driver, ALL_REQUESTS_APPROVAL_SUCCESS_MESSAGE);
	}

	@Override
	public void waitTillAllRequestsGridLoads(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, APPROVAL_PROCESSING);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void waitTillApprovalActionProcessingDivPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, APPROVAL_ACTION_PROCESSING_DIV);
		//		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnApproveRequestOnToolTip(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(ActionBot.findElements(driver, LINK_LIST_OF_ALL_DOCUMENT_NOS).get(index));
		actions.build().perform();
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_APPROVE_REQUEST_ON_TOOL_TIP);
	}

	@Override
	public void clickOnFirstRowApprovalDocumentNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FIRST_ROW_APPROVAL_DOCUMENT_NO);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "Document view mode");
	}

	@Override
	public List<WebElement> getListOfDocumentNos(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> listOfDocNos = ActionBot.findElements(driver, LINK_LIST_OF_ALL_DOCUMENT_NOS);
		ScreenShot.screenshot(driver, testCaseName, "List of document nos");
		return listOfDocNos;
	}

	@Override
	public void clickOnPurchaseOrderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_PURCHASE_ORDER_TAB);
		ActionBot.defaultLowSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on purchase order tab");
	}

	@Override
	public boolean isNoDataRecordsMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, NO_RECORDS_FOUND_TEXT))
		{
			return true;
		}
		return false;
	}

	@Override
	public String getMessageOnEmptyTable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String msg = ActionBot.getTextWithInElement(driver, APPROVAL_TABLE_EMPTY);
		logger.info("Empty table message : " + msg);
		return msg;
	}

	@Override
	public void clickOnInvoiceApprovalLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EXTERNAL_PRODUCTS);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnBPOTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_BPO_TAB);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on BPO tab");
	}

	@Override
	public void clickOnInvoiceNoFilterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_FILTER_SEARCH_INVOICE_NUMBER_ALL_APPROVAL_PAGE);
	}

	@Override
	public String fillInvoiceNo(WebDriver driver, String testCaseName, String invoiceNo) throws ActionBotException
	{
		/*
		 * String enteredInvoiceNo = ActionBot .sendKeys(driver,
		 * TEXTBOX_SEARCH_INVOICE_NUMBER_ALL_APPROVAL_PAGE, invoiceNo);
		 */
		String enteredInvoiceNo = null;
		try
		{
			// ActionBot.click(driver,
			// By.xpath(".//*[@id='invoicesAgainstStandardPo']/span/label/input"));
			/*
			 * ActionBot.click(driver, By.xpath(
			 * "(.//*[contains(@id,'statusFilterContent')]//label[contains(@class,'focusLbl')])[1]"
			 * )); ((JavascriptExecutor) driver).executeScript(
			 * "$('#txtFltrInvoiceNum:visible').css('display', 'block');");
			 * //ActionBot.waitForElementToBeVisible(driver, 6,
			 * TEXTBOX_SEARCH_INVOICE_NUMBER_ALL_APPROVAL_PAGE);
			 * driver.findElement(
			 * TEXTBOX_SEARCH_INVOICE_NUMBER_ALL_APPROVAL_PAGE.getBy()).sendKeys
			 * (invoiceNo);
			 */

			((JavascriptExecutor) driver).executeScript("document.getElementById('txtFltrInvoiceNum').value='" + invoiceNo + "'");
			enteredInvoiceNo = driver.findElement(TEXTBOX_SEARCH_INVOICE_NUMBER_ALL_APPROVAL_PAGE.getBy()).getAttribute("value");
		}
		catch (Exception e)
		{
			logger.info("############ Error : " + e, e);
		}
		logger.info("Entered Invoice No :" + enteredInvoiceNo);
		return enteredInvoiceNo;
	}

	@Override
	public void clickOnInvoiceNoFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on filter button");
		// ActionBot.click(driver,
		// BUTTON_FILTER_SEARCH_INVOICE_ALL_APPROVAL_PAGE);
		WebElement element = driver.findElement(BUTTON_FILTER_SEARCH_INVOICE_ALL_APPROVAL_PAGE.getBy());
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on filter button");
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnClearApprovalNumberFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_CLEAR_APPROVAL_NUMBER_FILTER))
		{
			ActionBot.focusAndclick(driver, BUTTON_CLEAR_APPROVAL_NUMBER_FILTER);
			ActionBot.waitTillPopUpIsPresent(driver, APPROVAL_PROCESSING);
		}
	}

	@Override
	public void clickOnClearApprovalNameFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_CLEAR_APPROVAL_NAME_FILTER))
		{
			ActionBot.focusAndclick(driver, BUTTON_CLEAR_APPROVAL_NAME_FILTER);
			ActionBot.waitTillPopUpIsPresent(driver, APPROVAL_PROCESSING);
		}
	}

	@Override
	public boolean isInvoiceNoFilterLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LINK_FILTER_SEARCH_INVOICE_NUMBER_ALL_APPROVAL_PAGE);
	}

	@Override
	public void clickOnCatalogTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CATALOG_TAB);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Catalog Tab");
	}

	@Override
	public String enterReqNoFilter(WebDriver driver, String testCaseName, String reqNumber) throws ActionBotException
	{
		ActionBot.defaultSleep();
		WebElement ele = ActionBot.findElement(driver, TEXT_REQ_NO_FILTER);
		ele.click();
		ActionBot.defaultMediumSleep();
		ele.clear();
		ele.sendKeys(reqNumber);
		ActionBot.defaultLowSleep();
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultHighSleep();
		ScreenShot.screenshot(driver, testCaseName, "After filling req number");
		return reqNumber;
	}

	@Override
	public void clickActionButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		if (ActionBot.isElementDisplayed(driver, BUTTON_ACTION))
		{
			WebElement ele = ActionBot.findElement(driver, BUTTON_ACTION);
			Actions act = new Actions(driver);
			act.moveToElement(ele).click().build().perform();
		}
	}

	@Override
	public boolean approveRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_APPROVE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking link approve");
		ActionBot.sendKeys(driver, TEXTAREA_APPROVAL_COMMENTS, "test approve via Automation");
		ActionBot.click(driver, BUTTON_APPROVE);

		//ActionBot.defaultLowSleep();

		ScreenShot.screenshot(driver, testCaseName, "After approving req");
		//ActionBot.defaultMediumSleep();

		return true;
	}

	@Override
	public boolean rejectRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REJECT_LINK);
		ActionBot.defaultSleep();
		ActionBot.sendKeys(driver, REJECT_COMMENT, "test approve via Automation");
		ActionBot.click(driver, REJECT_BUTTON);
		return true;
	}

	@Override
	public void fillApprovalComment(WebDriver driver, String testCaseName, String comment) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultHighSleep();
		ActionBot.waitForElementToBePresent(driver, 60, APPROVAL_COMMENT);
		ActionBot.waitForElementToBeDisplayed(driver, APPROVAL_COMMENT, 60);
		ActionBot.sendKeys(driver, APPROVAL_COMMENT, comment);
	}

	@Override
	public void fillRejectComment(WebDriver driver, String testCaseName, String comment) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		ActionBot.waitForElementToBePresent(driver, 60, REJECT_COMMENT);
		ActionBot.waitForElementToBeDisplayed(driver, REJECT_COMMENT, 60);
		ActionBot.sendKeys(driver, REJECT_COMMENT, comment);
	}

	@Override
	public void clickApproveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, 60, APPROVE_BUTTON);
		ActionBot.waitForElementToBeDisplayed(driver, APPROVE_BUTTON, 60);
		ActionBot.click(driver, APPROVE_BUTTON);
	}

	@Override
	public void clickRejectButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REJECT_BUTTON);
	}

	@Override
	public void clickRejectLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REJECT_LINK);
	}

	@Override
	public boolean isActionPerformedSuccessful(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, SUCCESSFUL_ACTION, 60);
		return ActionBot.isElementDisplayed(driver, SUCCESSFUL_ACTION);
	}

	@Override
	public boolean isPendingStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForOperations(5000);
		try
		{
			ActionBot.waitForElementToBePresent(driver, 30, PENDING_STATUS_FILTER);
			ActionBot.waitForElementToBeDisplayed(driver, PENDING_STATUS_FILTER, 30);
			return ActionBot.findElement(driver, PENDING_STATUS_FILTER).isSelected();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void clickOnActionsLinkIindexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[@id='workflowApproval']//a[text()='Actions'])[" + index + "]"));
	}

	@Override
	public void clickPendingStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PENDING_STATUS_FILTER);
	}

	@Override
	public void clickApprovedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, APPROVED_STATUS_FILTER);
	}

	@Override
	public void clickRejectedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REJECTED_STATUS_FILTER);
	}

	@Override
	public void clickDelegatedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DELEGATED_STATUS_FILTER);
	}

	@Override
	public String searchRequition(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, TEXTBOX_SEARCH_REQ_NUMBER, 5);
		WebElement element = ActionBot.findElement(driver, TEXTBOX_SEARCH_REQ_NUMBER);
		element.clear();
		element.sendKeys(reqNo);
		element.sendKeys(Keys.ENTER);
		ActionBot.waitForPageLoad(driver);
		return element.getText();
	}

	public static void clickOnViewItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, MY_APPROVAL_VIEW_ITEM_COMMENTS, 6);
		ActionBot.click(driver, MY_APPROVAL_VIEW_ITEM_COMMENTS);
	}

	@Override
	public boolean delegateFirstRequsition(WebDriver driver, String testCaseName, String DelegateTo) throws Exception
	{
		clickOnActionsLinkIindexwise(driver, testCaseName, 1);
		ActionBot.click(driver, DELEGATE_REQUSITION);
		WebElement webelement = ActionBot.findElement(driver, DELEGATE_REQUSITION_APPROVAL_TO);
		ActionBot.fillAutoCompleteField(driver, webelement, DelegateTo);
		ActionBot.sendKeys(driver, DELEGATE_REQUSITION_COMMENT, "This is autogenerated text comment");
		ActionBot.click(driver, DELEGATE_REQUSITION_POPUP_SUBMIT);
		return true;
	}

	@Override
	public List<String> getDocumentAllStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> docStatus = new ArrayList<>();
		List<WebElement> elements = ActionBot.findElements(driver, APPROVAL_STATUS);

		for (WebElement element : elements)
		{
			docStatus.add(ActionBot.getTextWithInElement(driver, element).trim());
		}

		ScreenShot.screenshot(driver, testCaseName, "Document Status");
		logger.info("Document status : " + docStatus);
		return docStatus;
	}

	@Override
	public boolean verifyUrgentRequestSymbol(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, URGENT_ITEM_SYMBOL))
		{
			return ActionBot.getAttributeOfElement(driver, URGENT_ITEM_SYMBOL, "title").toLowerCase().contains(IConstantsData.URGENT_REQUEST_TITLE.toLowerCase());
		}
		return false;
	}

	@Override
	public void searchRequisitionByName(WebDriver driver, String testCaseName, String requisitionName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, REQUISITION_NAME_ALL_REQUESTS_APPROVAL);
		ActionBot.sendKeys(driver, REQUISITION_NAME_ALL_REQUESTS_APPROVAL, requisitionName);
		WebElement element = ActionBot.findElement(driver, REQUISITION_NAME_ALL_REQUESTS_APPROVAL);
		element.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
	}
}
