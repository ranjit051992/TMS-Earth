package com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder;

import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.BillingRequisitionSummary;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.IPageMyRequisition;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageViewPurchaseOrderImpl implements IPageViewPurchaseOrder
{
	static Logger logger = Logger.getLogger(IPageViewPurchaseOrderImpl.class);

	@Override
	public void clickOnAccountingLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ACCOUNTING_LINK);
	}

	@Override
	public void clickOnAmendAlertContinuePopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AMEND_ALERT_POP_UP_CONTINUE);
		ActionBot.waitForPageLoad(driver);

	}

	@Override
	public void clickOnAmendPo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_AMEND_PO);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnCancelPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_PO_LINK);

	}

	@Override
	public void clickOnCancelPoSubmitButtom(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_PO_SUBMIT_BUTTOM);
		ActionBot.waitForPageLoad(driver);

	}

	@Override
	public void clickOnCostingLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, COSTBOOKING_LINK_VIEW_PO);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnCreateInvoiceLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CREATE_INVOICE);

	}

	@Override
	public void clickOnDropDownActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DROP_DOWN_ACTIONS);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnLinkCreateReceipt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CREATE_RECEIPT);

	}

	@Override
	public void clickOnLinkCreateReceiptUnderActionOnViewPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CREATE_RECEIPT_ACTION_DROPDOWN_ON_VIEW_PO);

	}

	@Override
	public void clickOnLinkEmailPo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EMAIL_PO);

	}

	@Override
	public void clickOnPreviewPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PREVIEW_PO);

	}

	@Override
	public void clickOnTermsAndNotesLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TERMS_NOTES_LINK);

	}

	@Override
	public void clickOnViewPageReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, VIEW_PAGE_REQ_NO);

	}

	@Override
	public void clickOnViewPageTabInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_INVOICE);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public String fillCancelPoCommentField(WebDriver driver, String testCaseName, String cancelPocomments) throws ActionBotException
	{
		ActionBot.sendKeys(driver, CANCEL_PO_COMMENT_TEXTBOX, cancelPocomments);
		String cancelpo = ActionBot.getTextWithInElement(driver, CANCEL_PO_COMMENT_TEXTBOX);
		ActionBot.defaultMediumSleep();
		logger.info("Entered comments : " + cancelpo);
		return cancelpo;
	}

	@Override
	public String getCreateReceiptReqNo(WebDriver driver, String testCaseName)
	{
		String reqNo = null;
		try
		{
			reqNo = ActionBot.getElement(driver, CREATE_RECEIPT_REQ_NO).getText();
		}
		catch (ActionBotException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Req No on PO Create Receipt page : " + reqNo);
		ScreenShot.screenshot(driver, testCaseName, "PO view page");
		return reqNo;

	}

	@Override
	public String getGrossTotal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String grossTotalAmount = ActionBot.findElement(driver, GROSS_TOTAL_VIEW_PAGE).getText();
		logger.info("Gross Total Amount : " + grossTotalAmount);
		ScreenShot.screenshot(driver, testCaseName, "Total Amount");
		return grossTotalAmount;
	}

	@Override
	public List<WebElement> getListOfItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, ITEM_NAMES_VIEW_PO);
	}

	@Override
	public String getNewWindowReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String newWindowReqNo = ActionBot.findElement(driver, NEW_WINDOW_REQ_NO).getText();
		logger.info("Req No on New Window page : " + newWindowReqNo);
		ScreenShot.screenshot(driver, testCaseName, "PO view page");
		return newWindowReqNo;
	}

	@Override
	public String getNewWindowViewPONo(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String PoNo = ActionBot.findElement(driver, NEW_WINDOW_PO_NO).getText();
		return PoNo;
	}

	@Override
	public String getViewPageReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String ReqNo = ActionBot.getTextWithInElement(driver, VIEW_PAGE_REQ_NO);
		logger.info("Req No on PO view page : " + ReqNo);
		ScreenShot.screenshot(driver, testCaseName, "PO view page");
		return ReqNo;
	}

	@Override
	public String getViewPONo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String poNo = ActionBot.findElement(driver, VIEW_PO_NO).getText();
		logger.info("PO No on PO view page : " + poNo);
		ScreenShot.screenshot(driver, testCaseName, "PO view page");
		return poNo;
	}

	@Override
	public String getViewPONotes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String getPoNotes = ActionBot.findElement(driver, PO_NOTES_DETAILS).getText();
		return getPoNotes;
	}

	@Override
	public boolean isAccountingDetailsDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ACCOUNTING_DETAILS_VIEW_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isCostingDetailsDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, COSTING_DETAILS_VIEW_PO))
		{
			return true;
		}
		return false;

	}

	@Override
	public boolean isPrintPOOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_PRINT_PO))
		{

			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnAuditTrail(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, LABEL_AUDIT_TRIAL))
		{
			ActionBot.click(driver, LABEL_AUDIT_TRIAL);
		}
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Audit Trail");
		ActionBot.defaultSleep();

	}

	@Override
	public boolean isAmmendmentStatusPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='auditTrailList_PURCHASE_ORDER_AMEND']//tr[";
		String xpathPart2 = "]/td[contains(@class,'action')]";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		if (ActionBot.isElementPresent(driver, xpath))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getAmmendedmentStatus(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='auditTrailList_PURCHASE_ORDER_AMEND']//tr[";
		String xpathPart2 = "]/td[contains(@class,'action')]";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		String str = ActionBot.findElement(driver, xpath).getText();
		return str;
	}

	@Override
	public boolean isStatusAmmendmentReleased(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='auditTrailList_PURCHASE_ORDER_AMEND']//tr[";
		String xpathPart2 = "]/td[contains(@class,'action')]";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		String str = ActionBot.findElement(driver, xpath).getText();
		if (str.equalsIgnoreCase("Amendment Released"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isStatusOrderAmmended(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='auditTrailList_PURCHASE_ORDER_AMEND']//tr[";
		String xpathPart2 = "]/td[contains(@class,'action')]";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		String str = ActionBot.findElement(driver, xpath).getText();
		if (str.equalsIgnoreCase("Order Amended"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnPrintPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PRINT_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on print PO");

	}

	@Override
	public String getTaxName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String taxName = ActionBot.getTextWithInElement(driver, TAX_NAME);
		return taxName;
	}

	@Override
	public String getPoEformName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, PO_NOTES_DETAILS);
	}

	@Override
	public String getSupplierCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, SUPPLIER_DETAILS_CURRENCY);
	}

	@Override
	public String getTaxRate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, PO_VIEW_TAX_RATE);
	}

	@Override
	public String getSupplierContractNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, SUPPLIER_CONTRACT_NO);
	}

	@Override
	public boolean isDateNotAppliedSpecified(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, NOT_APPLIED_DATE);
		String str = ActionBot.getTextWithInElement(driver, NOT_APPLIED_DATE);
		if (str.equalsIgnoreCase("N/A"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isReceiptPagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, TAB_RECEIPT);
		if (ActionBot.isElementDisplayed(driver, TAB_RECEIPT))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isInvoicePagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, TAB_INVOICE);
		if (ActionBot.isElementDisplayed(driver, TAB_INVOICE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getItemContratNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String specialCharacter = ActionBot.getTextWithInElement(driver, MODAL_ITEM_DETAILS_CONTRACT_NO);
		return specialCharacter;
	}

	@Override
	public boolean isPlannedDeliveryDatePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PLANNED_DELIVERY_DATE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, LINK_ITEM_NAME);
		return str;
	}

	@Override
	public void clickOnItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_ITEM_NAME);

	}

	@Override
	public String getItemTitle(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, ITEM_TITLE_IN_POPUP);
		return str;

	}

	@Override
	public void clickOnEditItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, EDIT_ITEM_IN_INVOICE_VIEW_PO);
		ActionBot.defaultSleep();
	}

	@Override
	public String changeQuantityOfItem(WebDriver driver, String testCaseName, String quantity) throws ActionBotException
	{
		ActionBot.findElements(driver, TEXTBOX_QUANTITY_VIEW_PO);
		ActionBot.clear(driver, TEXTBOX_QUANTITY_VIEW_PO);
		ActionBot.sendKeys(driver, TEXTBOX_QUANTITY_VIEW_PO, quantity);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_QUANTITY_VIEW_PO);
		return str;
	}

	@Override
	public boolean isSpecificationNamePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LABEL_SPECIFICATION_NAME_VIEW_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnSaveItemDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_ITEM_MODAL_VIEW_PO);

	}

	@Override
	public void clickOnOrderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_ORDER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on tab Order");

	}

	@Override
	public boolean isPOCancelledMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, PO_CANCEL_MESSAGE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isCancelPOOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CANCEL_PO_LINK))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnClosePO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLOSE_PO_LINK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on close PO");

	}

	@Override
	public void clickOnCopyPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, COPY_PO_LINK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on close PO");

	}

	@Override
	public Double getFreightTaxValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, FREIGHT_TAX);
		str = str.substring(4);
		Double frieght = Double.parseDouble(str);
		return frieght;
	}

	@Override
	public void clickOnDeliverySectionSubTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PO_VIEW_DELIVERY_SECTION_SUB_TAB);

	}

	@Override
	public String getDeliveryDateUnderDeliverySection(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String deliveryDateDetails = ActionBot.getTextWithInElement(driver, DELIVERY_DATE_DETAILS);
		return deliveryDateDetails;

	}

	@Override
	public boolean isWarningForClosePODisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, WARNING_MESSAGE_CLOSE_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isPlannedDeliveryDateBlank(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, PLANNED_DELIVERY_DATE);
		String date = ActionBot.getTextWithInElement(driver, PLANNED_DELIVERY_DATE);
		if (date.equals("-"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean arePredefinedTaxesPresentOnViewPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LABEL_TAXES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnFirstItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_FIRST_ITEM_NAME_VIEW_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on item name");

	}

	@Override
	public boolean isAddToCartOptionPresentOnItemDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ADDTOCART))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isAddToFavoritesOptionPresentOnItemDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ADDTOFAVORITES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isAddToBasketOptionPresentOnItemDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// WebElement ele = null;
		if (ActionBot.isElementPresent(driver, ADDTOBASKET))
		{
			// ele.sendKeys(Keys.ESCAPE);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnFirstItemNameOnInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_INVOICE_FIRST_ITEM_NAME);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on item name at invoice");

	}

	@Override
	public void clickOnLinkDownloadAsPDF(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DOWNLOAD_AS_PDF_PO);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on download as pdf");

	}

	@Override
	public boolean isPOContactEmailIDPresentInViewPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PO_CONTACT_EMAIL_ID_VIEW_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isProjectPresentInCostBookingSection(WebDriver driver, String testCaseName) throws ActionBotException
	{

		if (ActionBot.isElementPresent(driver, PROJECT_COST_BOOKING_SECTION))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isGLAccountTypePresentProperly(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ACCOUNTING_DETAILS_VIEW_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getSupplierContact(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String poContact = ActionBot.findElement(driver, SUPPLIER_CONTACT).getText();
		return poContact;
	}

	@Override
	public String getPONo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String poNo = ActionBot.getTextWithInElement(driver, LABEL_PO_NO_ON_VIEW_PAGE_AFTER_CREATING);
		logger.info("PO Number as on view page : " + poNo);
		return poNo;
	}

	@Override
	public void clickOnRemoveApprover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, WORKFLOW_REMOVE_APPROVER_LINK);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnAddApprover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_ADD_APPROVER_IN_WORKFLOW);

	}

	@Override
	public void clickonLinkWorkflow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_WORKFLOW);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on link workflow");

	}

	@Override
	public void clickOnItemCheckboxInInvoiceViewPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_ITEM_IN_INVOICE_VIEW_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on checkbox of item in invoice");

	}

	@Override
	public String getRemindSupplierTitle(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement element = ActionBot.findElements(driver, REMIND_SUPPLIER_TITLE).get(1);
		return element.getText();

	}

	@Override
	public String fillRemindSupplierToField(WebDriver driver, String testCaseName, String to) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, REMIND_SUPPLIER_TO_FIELD);
		ele.sendKeys("to");
		ele.sendKeys(Keys.DOWN);
		ele.sendKeys(Keys.ENTER);
		return to;
	}

	@Override
	public String getRemindSupplierAddedField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_REMIND_SUPPLIER_ADDED_FIELD);
	}

	@Override
	public void clickOnTabReceipt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_RECEIPT);
		ActionBot.waitForPageLoad(driver);

	}

	@Override
	public void clickOnChangeApprover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, WORKFLOW_CHANGE_APPROVER_LINK);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on changed approver link");
	}

	@Override
	public String fillReplaceWithActor(WebDriver driver, String testCaseName, String actor) throws ActionBotException
	{
		return ActionBot.fillAutoCompleteField(driver, TEXTBOX_REPLACE_ACTOR_WITH_IN_WORKFLOW, actor);
	}

	@Override
	public void clickOnSaveChangedApprover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on save changed approver");
		ActionBot.click(driver, BUTTON_SAVE_CHANGE_APPROVER_IN_WORKFLOW);
		ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save changed approver");
	}

	@Override
	public boolean isChangeApproverLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, WORKFLOW_CHANGE_APPROVER_LINK))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isStatusOfWorkflowPending(WebDriver driver, String testCaseName, int id) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='workFlowTrails']//li[" + id + "]//div[@class='bld sts statusTxt']"));
		if (str.equals("Pending"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isAddApproverLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_ADD_APPROVER_IN_WORKFLOW))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnLinkEnclosure(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ENCLOSURES_LINK);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on enclosure link");

	}

	@Override
	public boolean isDownloadPOAttachmentLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_DOWNLOAD_PO_ATTACHMENT))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getRequisitionNumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, LINK_REQUISITION_NUMBER);
		return str;
	}

	@Override
	public boolean isDownloadLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_DOWNLOAD_AS_PDF_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getFirstApproversNameInWorkflow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, FIRST_APPROVERS_NAME_IN_WORKFLOW);
	}

	@Override
	public String getTotalItemLevelDiscount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, ITEM_LEAVEL_DISCOUT);
	}

	@Override
	public String getBuyerName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_BUYER_NAME);
	}

	@Override
	public boolean isPOCreatedOnDatePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LABEL_PO_CREATED_ON_DATE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getConsumedOrderValueOfBPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_CONSUMED_VALUE_BPO);
	}

	@Override
	public String getInvoicedAmountOfBPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_INVOICED_AMOUNT_BPO);
	}

	@Override
	public String getItemNames(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]//a[@class='scLnk poItemLink']"));
		ActionBot.defaultSleep();
		return str;
	}

	@Override
	public String getAuditTrailAction(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		String action = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_audit_trail + rowNo + xpath2_audit_trail_action));
		logger.info("Action : " + action);
		return action;
	}

	@Override
	public String getAuditTrailUser(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		String user = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_audit_trail + rowNo + xpath2_audit_trail_user));
		logger.info("User : " + user);
		return user;
	}

	@Override
	public String getAuditTrailSharedWith(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		String sharedWith = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_audit_trail + rowNo + xpath2_audit_trail_sharedWith));
		logger.info("Shared With : " + sharedWith);
		return sharedWith;
	}

	@Override
	public String getAuditTrailRole(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		String role = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_audit_trail + rowNo + xpath2_audit_trail_role));
		logger.info("Role : " + role);
		return role;
	}

	@Override
	public String getAuditTrailDateNTime(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		String dateOrTime = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_audit_trail + rowNo + xpath2_audit_trail_dateOrTime));
		logger.info("Date or Time : " + dateOrTime);
		return dateOrTime;
	}

	@Override
	public String getAuditTrailVersion(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		String version = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_audit_trail + rowNo + xpath2_audit_trail_version));
		logger.info("Version : " + version);
		return version;
	}

	@Override
	public String getAuditTrailMessage(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		String msg = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_audit_trail + rowNo + xpath2_audit_trail_comments));
		logger.info("Message : " + msg);
		return msg;
	}

	@Override
	public void clickOnAuditTrailVersion(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(xpath1_audit_trail + rowNo + xpath2_audit_trail_version_link));
	}

	@Override
	public boolean isChangeApproverModalErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_CHANGE_APPOVER_IN_WORKFLOW))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public void clickOnCancelChangeApprover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_CHANGE_APPROVER_WORKFLOW);
		ActionBot.defaultSleep();

	}

	@Override
	public boolean isWorkflowConfirnModalPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CONFIRM_WORKFLOW_MODAL))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getWorkflowActorName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String actorName = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_workflow_actorName + index + xpath2_workflow_actorName));
		logger.info("Actor Name : " + actorName);
		return actorName;
	}

	@Override
	public String getItemNameInAccountingSection(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String itemName = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_accounting_data + index + xpath2_accounting_item_name));
		logger.info("Item Name in Accouting Section : " + itemName);
		return itemName;
	}

	@Override
	public String getGLAccountInAccountingSection(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		//String glAccount = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_accounting_data + index + xpath2_accounting_gl_account));
		String glAccount = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_accounting_data + "[" + index + "]"));
		logger.info("GL Account in Accouting Section : " + glAccount);
		return glAccount;
	}

	@Override
	public String getSettlementViaOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String settlementViaOption = ActionBot.getTextWithInElement(driver, LABEL_SETTLEMENT_VIA_PO_VIEW_PAGE);
		logger.info("Settlement Via Option : " + settlementViaOption);
		return settlementViaOption;
	}

	@Override
	public String getPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_PAYMENT_TERMS_PO_VIEW_PAGE);
	}

	@Override
	public void clickOnSubmitPOForApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on submit PO for approval");
		ActionBot.click(driver, BUTTON_SUBMIT_FOR_APPROVAL_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on submit PO for approval");
	}

	@Override
	public void clickOnModifyPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Modify PO");
		ActionBot.waitForPageLoad(driver);
		ActionBot.click(driver, BUTTON_MODIFY_PO);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Modify PO");
	}

	@Override
	public String getLabelValueOfProject(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String labelValue = ActionBot.getTextWithInElement(driver, LABEL_PROJECT_VIEW_PO);
		logger.info("Label Value of Proejct : " + labelValue);
		return labelValue;
	}

	@Override
	public String getPOName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String poName = ActionBot.getTextWithInElement(driver, LABEL_PO_NAME_ON_VIEW_PAGE);
		logger.info("PO Name : " + poName);
		return poName;
	}

	@Override
	public String getPOComment(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String comment = ActionBot.getTextWithInElement(driver, LABEL_COMMENT_VIEW_PO);
		logger.info("Comment : " + comment);
		return comment;
	}

	@Override
	public String getWorkflowNodeDisplayName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String displayName = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='workFlowTrails']//li[" + index + "]//div[contains(@class,'dev_nodeDisplayName')]"));
		logger.info("Display Name : " + displayName);
		return displayName;
	}

	@Override
	public String getWorkflowNodeExtraInfo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String extraInfo = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='workFlowTrails']//li[" + index + "]//div[contains(@class,'dev_extraInfo')]"));
		logger.info("Extra Information : " + extraInfo);
		return extraInfo;
	}

	@Override
	public void clickOnChangeApprover(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='workFlowTrails']//li[" + index + "]//a[contains(@class,'dev_changeApproverLnk')]"));
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on changed approver link");
	}

	@Override
	public String getWorkflowNodeStatus(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String status = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='workFlowTrails']//li[" + index + "]//div[contains(@class,'statusTxt')]"));
		logger.info("Status : " + status);
		return status;
	}

	@Override
	public void closeItemPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ITEM_POPUP_CLOSE);

	}

	@Override
	public String getFirstApproverNameOnWorkflow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String approverName = ActionBot.getTextWithInElement(driver, LABEL_FIRST_APPROVER_NAME_AS_ON_PO_VIEW_PAGE);
		return approverName;
	}

	@Override
	public boolean clickRemindApprover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_REMIND_APPROVER_VIEW_PO))
		{
			ActionBot.click(driver, LINK_REMIND_APPROVER_VIEW_PO);
			ScreenShot.screenshot(driver, testCaseName, "After clicking remind approver");
			ActionBot.waitTillPopUpIsPresent(driver, IPageMyRequisition.POPUP_CONFIRMATION_REMIND_APPROVER);
			return true;
		}
		return false;
	}

	@Override
	public String getCompanyName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_COMPANY_NAME);
	}

	@Override
	public String getBUName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_BU_NAME);
	}

	@Override
	public String getLocationName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_LOCATION_NAME);
	}

	@Override
	public String getBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_BILL_TO_ADDRESS);
	}

	@Override
	public String getDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_SHIPPING_ADDRESS);
	}

	@Override
	public String getCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_CURRENCY);
	}

	@Override
	public String getExpectedDeliveryDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_EXPECTED_DELIVERY_DATE);
	}

	@Override
	public String getReference(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_REFERENCE);
	}

	@Override
	public String getRequester(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_REQUESTER);
	}

	@Override
	public String getRequesterEmailId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_REQUESTER_EMAIL_ID);
	}

	@Override
	public String getApprovedOn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_APPROVED_ON);
	}

	@Override
	public String getCreatedOn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_PO_CREATED_ON_DATE);
	}

	@Override
	public String getReleasedOn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_RELEASED_ON);
	}

	@Override
	public String getRetrospectivePurchase(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_RETROSPECTIVE_PURCHASE);
	}

	@Override
	public String getPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_PURCHASE_TYPE);
	}

	@Override
	public String getSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_SUPPLIER_NAME);
	}

	@Override
	public String getSupplierEmailId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_SUPPLIER_EMAIL_ID);
	}

	@Override
	public String getCustomerReferenceNumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_CUSTOMER_REFERENCE_NUMBER);
	}

	@Override
	public String getDeliveryTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_DELIVERY_TERMS);
	}

	@Override
	public String getConfirmedOn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_CONFIRMED_ON);
	}

	@Override
	public String getAddressOfSupplierDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_SUPPLIER_DETAILS_ADDRESS);
	}

	@Override
	public BillingRequisitionSummary getOrganisationUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		BillingRequisitionSummary billingRequisitionSummary = new BillingRequisitionSummary();
		billingRequisitionSummary.setCompany(getCompanyName(driver, testCaseName));
		billingRequisitionSummary.setBusinessUnit(getBUName(driver, testCaseName));
		billingRequisitionSummary.setLocation(getLocationName(driver, testCaseName));
		billingRequisitionSummary.setBillToAddress(getBillToAddress(driver, testCaseName));
		billingRequisitionSummary.setDeliveryAddress(getDeliveryAddress(driver, testCaseName));
		billingRequisitionSummary.setCurrency(getCurrency(driver, testCaseName));
		return billingRequisitionSummary;
	}

	@Override
	public List<WebElement> getAllInvoicesAgainstPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> listOfAllInvoicesAgainstPo = ActionBot.findElements(driver, GET_INVOICES_AGAINST_PO);
		return listOfAllInvoicesAgainstPo;
	}

	@Override
	public String getNetPayableAmountUnderPaymentsAndCredits(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, NET_PAYABLE_AMOUNT);

	}

	@Override
	public void clickOnCostBookingInfoHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, COST_BOOKING_HEADER).click();
		//ActionBot.click(driver, COST_BOOKING_HEADER);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public boolean checkIfCCPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, IS_CC_PRESENT_UNDER_COST_BOOKING);
	}

	@Override
	public String getCostCenterUnderCostBooking(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, COST_BOOKING_COST_CENTER).getText();

	}

	@Override
	public boolean checkIfProjectPresentUnderCostBookingInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, IS_PROJECT_PRESENT_UNDER_COST_BOOKING);
	}

	@Override
	public boolean checkIfBudgetPresentUnderCostBookingInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, IS_BUDGET_PRESENT_UNDER_COST_BOOKING);
	}

	@Override
	public String getProjectUnderCostBooking(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.findElement(driver, COST_BOOKING_PROJECT).getText();
	}

	@Override
	public String getBudgetUnderCostBooking(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, COST_BOOKING_BUDGET).getText();
	}

	@Override
	public int getNoOfRowsUnderAuditTrail(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, NO_OF_ROWS_IN_AUDIT_TRAIL_INFO, 5000);
		List<WebElement> webElements = ActionBot.findElements(driver, NO_OF_ROWS_IN_AUDIT_TRAIL_INFO);
		return webElements.size();

	}

	/*
	 * author : bhakti.sawant : check payment status of PO
	 */
	@Override
	public String checkPaymentStatus(WebDriver driver, String testCaseName, String paymentVoucherNo) throws ActionBotException
	{
		//ActionBot.click(driver, PageViewInvoice.VIEV_INVOICE_PAYMENT_SPAN);
		ActionBot.waitForPageLoad(driver);

		System.out.println("Payment Batch voucher No...." + paymentVoucherNo + "...");

		int i = 0;
		WebElement element = null;
		do
		{
			element = ActionBot.findElement(driver, By.xpath("(.//*[contains(@id,'dev-poVoucherList_')]/td[@class='voucherNumber'])[" + (++i) + "]"));
			if (element != null)
				if (element.getText().equals(paymentVoucherNo))
				{
					String status = ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'dev-poVoucherList_')]/td[@class='status']/div)[" + i + "]"));
					return status.trim();
				}
		} while (element != null);

		return null;
	}

	@Override
	public String getTaxNameByIndex(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		List<WebElement> taxNameElements = ActionBot.findElements(driver, VIEW_PO_PAGE_TAX_RATE_GENERIC);
		String taxName = ActionBot.getTextWithInElement(driver, taxNameElements.get(index));
		return taxName;
	}

	@Override
	public String getTaxRateByIndex(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		List<WebElement> taxRateElements = ActionBot.findElements(driver, IPageViewPurchaseOrderImpl.GENERIC_PO_VIEW_TAX_RATE);

		return ActionBot.getTextWithInElement(driver, taxRateElements.get(index));
	}

	@Override
	public int getQuantity(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String xpath = LABEL_QUANTITY.getValue();
		xpath = xpath.replace("itemId", itemId);
		WebElement WebElement = ActionBot.findElement(driver, By.xpath(xpath));
		String text = ActionBot.getTextWithInElement(driver, WebElement);
		String quantity[] = StringUtils.split(text, " ");
		return Integer.parseInt(quantity[0]);
	}

	@Override
	public String getContractNumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, ITEM_CONTRACT_NUMBER_MODAL_ITEM_DETAILS);
	}

	@Override
	public String getGlAccount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, ACCOUNTING_DETAILS_VIEW_PO);
		return elements.get(0).getText();
	}

	@Override
	public String getOrderValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, LABEL_ORDER_VALUE);
		return elements.get(0).getText();
	}

	@Override
	public String getTaxType(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		String taxType = null;
		taxType = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='headerTaxDetail']//*[contains(@class,'taxTableView')]//tr[" + index + "]//td[1]"));
		logger.info("Tax Type is :" + taxType);
		return taxType;
	}

	@Override
	public String getFilledTextOfPeform(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		String filledText = null;
		filledText = ActionBot.getTextWithInElement(driver, PO_PEFORM_FILLED_TEXT);
		logger.info("The filled text is :" + filledText);
		return filledText;
	}

	@Override
	public String getItemSubTotal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		String itemSubTotal = null;
		itemSubTotal = ActionBot.getTextWithInElement(driver, ITEM_SUB_TOTAL);
		logger.info("Item sub total" + itemSubTotal);
		// TODO Auto-generated method stub
		return itemSubTotal;
	}

}
