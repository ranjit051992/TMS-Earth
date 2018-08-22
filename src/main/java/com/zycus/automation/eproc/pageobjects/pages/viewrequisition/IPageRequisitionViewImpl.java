/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.viewrequisition;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 */
public class IPageRequisitionViewImpl implements IPageRequisitionView
{
	static Logger logger = Logger.getLogger(IPageRequisitionViewImpl.class);

	@Override
	public boolean isPeformSectionLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABEL_PEFORM_SECTION_NAME_ON_REQ_VIEW_PAGE);
	}

	@Override
	public boolean isPeformFieldLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABEL_PEFORM_FIELD_NAME_ON_REQ_VIEW_PAGE);
	}

	@Override
	public String getNameOfPeformSectionLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String sectionName = ActionBot.getTextWithInElement(driver, LABEL_PEFORM_SECTION_NAME_ON_REQ_VIEW_PAGE);
		logger.info("Label Name of Section of PEform : " + sectionName);
		return sectionName;
	}

	@Override
	public String getNameOfPeformFieldLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String fieldName = ActionBot.getTextWithInElement(driver, LABEL_PEFORM_FIELD_NAME_ON_REQ_VIEW_PAGE);
		logger.info("Label Name of Field of PEform : " + fieldName);
		return fieldName;
	}

	@Override
	public String getNameOfPeformFieldValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String fieldValue = ActionBot.getTextWithInElement(driver, LABEL_PEFORM_FIELD_VALUE_ON_REQ_VIEW_PAGE);
		logger.info("Field Value of PEform : " + fieldValue);
		return fieldValue;
	}

	@Override
	public void clickOnExpandDelivery(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_EXPAND_DELIVERY_ON_REQ_VIEW_PAGE);
		ScreenShot.screenshot(driver, testCaseName, "Delivery Info");
	}

	@Override
	public String getDeliverTo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		// String deliverTo = ActionBot.getTextWithInElement(driver,
		// By.xpath(".//*[@id='deliveryInfoTable']//tr[" + index + "]/td[5]"));
		String deliverTo = ActionBot.getTextWithInElement(driver, By.xpath(".//*[contains(@class,'itemSummaryDeliveries')]//tr[" + index + "]//*[contains(@class,'deliverTo')]"));
		logger.info("Deliver To : " + deliverTo);
		return deliverTo;
	}

	@Override
	public String getDeliveryDate(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		// String deliveryDate = ActionBot.getTextWithInElement(driver,
		// By.xpath(".//*[@id='deliveryInfoTable']//tr[" + index + "]/td[6]"));
		String deliveryDate = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[contains(@class,'itemSummaryDeliveries')]//tr[" + index + "]//*[contains(@class,'deliveryOn')]"));
		logger.info("Delivery Date : " + deliveryDate);
		return deliveryDate;
	}

	@Override
	public int getDeliveryQuantity(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		// String quantity = ActionBot.getTextWithInElement(driver,
		// By.xpath(".//*[@id='deliveryInfoTable']//tr[" + index + "]/td[7]"));
		String quantity = ActionBot.getTextWithInElement(driver, By.xpath(".//*[contains(@class,'itemSummaryDeliveries')]//tr[" + index + "]//*[contains(@class,'splitQty')]"));
		logger.info("Delivery Quantity : " + quantity);
		ScreenShot.screenshot(driver, testCaseName, "Requisition view page");
		String[] temp = StringUtils.split(quantity, " ");
		quantity = "";
		quantity = temp[0].trim();
		return Integer.parseInt(quantity);
	}

	@Override
	public String getShipToAddress(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// WebElement element = ActionBot.findElement(driver, By.id("ship_To_" +
		// itemId + "__ADD00" + index));
		/*
		 * List<WebElement> elements = ActionBot.findElements(driver,
		 * By.xpath(".//*[contains(@id,'ship_To_" + itemId + "')]")); WebElement
		 * element = elements.get(index); // ActionBot.moveToElement(driver,
		 * element); ActionBot.hover(driver, element); //
		 * ActionBot.defaultSleep(); String shipToAddress =
		 * ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='qtip-" +
		 * element.getAttribute("data-hasqtip") + "-content']/b[2]"));
		 */

		String shipToAddress = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[contains(@class,'itemSummaryDeliveries')]//tr[" + index + "]//*[contains(@class,'location')]"));
		logger.info("Ship to address : " + shipToAddress);
		return shipToAddress;
	}

	@Override
	public void clickOnExpandCostBooking(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_EXPAND_COST_BOOKING_ON_REQ_VIEW_PAGE);
		ScreenShot.screenshot(driver, testCaseName, "Cost Booking ");
	}

	@Override
	public String getCostCenterForItemLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String costCenter = null;
		//		if (ActionBot.isElementPresent(driver,
		//			By.xpath(".//*[@id='costingInfoTable']//tr[" + index + "]/td[@id='dev-lblCostCenterDescription']")))
		//		{
		//			costCenter = ActionBot.getTextWithInElement(driver,
		//				By.xpath(".//*[@id='costingInfoTable']//tr[" + index + "]/td[@id='dev-lblCostCenterDescription']"));
		//		}		

		if (ActionBot.isElementPresent(driver, By.xpath("(.//*[@class='tblSplitData itemSummaryCostings']//div[contains(@class,'costing')])[" + (index + 1) + "]")))
		{
			costCenter = ActionBot.getTextWithInElement(driver,
				By.xpath("(.//*[@class='tblSplitData itemSummaryCostings']//div[contains(@class,'costing')])[" + (index + 1) + "]"));
		}

		logger.info("Cost Center  : " + costCenter);
		return costCenter;
	}

	@Override
	public String getBudgetForItemLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String budget = null;
		//		if (ActionBot.isElementPresent(driver,
		//			By.xpath(".//*[@id='costingInfoTable']//tr[" + index + "]/td[@id='dev-lblBudgetLineName']")))
		//		{
		//			budget = ActionBot.getTextWithInElement(driver,
		//				By.xpath(".//*[@id='costingInfoTable']//tr[" + index + "]/td[@id='dev-lblBudgetLineName']"));
		//		}

		if (ActionBot.isElementPresent(driver, By.xpath("(.//*[@class='tblSplitData itemSummaryCostings']//div[contains(@class,'budget')])[" + (index + 1) + "]")))
		{
			budget = ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@class='tblSplitData itemSummaryCostings']//div[contains(@class,'budget')])[" + (index + 1) + "]"));
		}
		logger.info("Budget  : " + budget);
		return budget;
	}

	@Override
	public String getProjectForItemLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String project = null;
		//		if (ActionBot.isElementPresent(driver,
		//			By.xpath(".//*[@id='costingInfoTable']//tr[" + index + "]/td[@id='dev-lblProjectType']")))
		//		{
		//			project = ActionBot.getTextWithInElement(driver,
		//				By.xpath(".//*[@id='costingInfoTable']//tr[" + index + "]/td[@id='dev-lblProjectType']"));
		//		}

		if (ActionBot.isElementPresent(driver, By.xpath("(.//*[@class='tblSplitData itemSummaryCostings']//div[contains(@class,'dev_project')])[" + (index + 1) + "]")))
		{
			project = ActionBot.getTextWithInElement(driver,
				By.xpath("(.//*[@class='tblSplitData itemSummaryCostings']//div[contains(@class,'dev_project')])[" + (index + 1) + "]"));
		}
		logger.info("Project  : " + project);
		return project;
	}

	@Override
	public String getPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		//		String price = ActionBot.getTextWithInElement(driver,
		//			By.xpath(".//*[@id='costingInfoTable']//tr[" + index + "]/td[@id='dev-lblGLAmount']"));
		String price = ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@class='tblSplitData itemSummaryCostings']//td[contains(@class,'value')])[" + (index + 1) + "]"));
		logger.info("Price  : " + price);
		return price;
	}

	@Override
	public String getRequisitionNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqNo = ActionBot.getTextWithInElement(driver, LABEL_REQUISITION_NO_ON_REQ_VIEW_PAGE);
		logger.info("Requisition No : " + reqNo);
		return reqNo;
	}

	@Override
	public String getRequisitionName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqName = ActionBot.getTextWithInElement(driver, LABEL_REQUISITION_NAME_ON_REQ_VIEW_PAGE);
		logger.info("Requisition Name : " + reqName);
		return reqName;
	}

	@Override
	public boolean getUrgRequirement(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String urgReq = ActionBot.getTextWithInElement(driver, LABEL_URG_REQUIREMENT_ON_REQ_VIEW_PAGE);
		logger.info("Urg requirement : " + urgReq);
		if (urgReq.equalsIgnoreCase(IConstants.YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getCreatedBy(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String requester = ActionBot.getTextWithInElement(driver, LABEL_CREATED_BY_ON_REQ_VIEW_PAGE);
		logger.info("Created By : " + requester);
		return requester;
	}

	@Override
	public String getSettlementVia(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String settlementVia = ActionBot.getTextWithInElement(driver, LABEL_SETTLEMENT_VIA_ON_REQ_VIEW_PAGE);
		logger.info("Settlement Via : " + settlementVia);
		return settlementVia;
	}

	@Override
	public String getReasonForOrdering(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reasonForOrdering = ActionBot.getTextWithInElement(driver, LABEL_REASON_FOR_ORDERING_ON_REQ_VIEW_PAGE);
		logger.info("Reason for ordering : " + reasonForOrdering);
		return reasonForOrdering;
	}

	@Override
	public String getCommentsForSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String commentsForSupplier = ActionBot.getTextWithInElement(driver, LABEL_COMMENTS_FOR_SUPPLIER_ON_REQ_VIEW_PAGE);
		logger.info("Comments For Supplier : " + commentsForSupplier);
		return commentsForSupplier;
	}

	@Override
	public String getPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String purchaseType = ActionBot.getTextWithInElement(driver, LABEL_PURCHASE_TYPE_ON_REQ_VIEW_PAGE);
		logger.info("Purchase Type : " + purchaseType);
		return purchaseType;
	}

	@Override
	public String getStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String status = ActionBot.getTextWithInElement(driver, LABEL_STATUS_ON_REQ_VIEW_PAGE);
		logger.info("Status : " + status);
		return status;
	}

	@Override
	public boolean getRetrospectivePurchase(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String retrospectivePurchase = ActionBot.getTextWithInElement(driver, LABEL_RETROSPECTIVE_PURCHASE_ON_REQ_VIEW_PAGE);
		logger.info("Retrospective Purchase : " + retrospectivePurchase);
		if (retrospectivePurchase.equalsIgnoreCase(IConstants.YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		// String itemName = ActionBot.getTextWithInElement(driver,
		// By.xpath(".//*[@id='dev_itemGrid']//tr[" + index +
		// "]//a[contains(@class,'showItemDetails')]"));
		String itemName = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@class='requisitionItems']//tr[" + index + "]//*[contains(@class,'itemnamelnk')]"));
		logger.info("Item Name : " + itemName);
		return itemName;
	}

	@Override
	public String getItemUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		// String unitPrice = ActionBot.getTextWithInElement(driver,
		// By.xpath(".//*[@id='dev_itemGrid']//tr[" + index +
		// "]/td[contains(@class,'itemPrice')]"));
		String unitPrice = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@class='requisitionItems']//tr[" + index + "]//*[contains(@class,'unitprice')]"));
		logger.info("Item Unit price : " + unitPrice);
		return unitPrice;
	}

	@Override
	public int getItemQuantity(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		// String quant = ActionBot.getTextWithInElement(driver,
		// By.xpath(".//*[@id='dev_itemGrid']//tr[" + index +
		// "]/td[contains(@class,'approvedQuantity')]"));

		String quant = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@class='requisitionItems']//tr[" + index + "]//*[contains(@class,'lblQuantity')]"));

		//		String xpath = LABEL_ITEM_QUANTITY.getValue();
		//		//xpath = xpath.replace("itemId", itemId);
		//		String quant = ActionBot.getTextWithInElement(driver, By.xpath(xpath));

		logger.info("Quantity : " + quant);
		String[] temp = StringUtils.split(quant, " ");
		return Integer.parseInt(temp[0].trim());
	}

	@Override
	public String getItemTotalPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		//String totalPrice = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='dev_itemGrid']//tr[" + index + "]/td[contains(@class,'itemTotalPrice')]"));
		String totalPrice = ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'item_subTotalPrice_')])[" + index + "]"));
		//String totalPrice = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@class='requisitionItems']//tr[@id='item_ITEMID']//*[contains(@class,'subTotalPrice')]"));
		String temp[] = totalPrice.split(" ");
		logger.info("Total Price : " + totalPrice);
		return temp[1].trim();
	}

	@Override
	public String getCostCenterForHeaderLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String costCenter = null;
		//		if (ActionBot.isElementPresent(driver,
		//			By.xpath(".//*[@id='costingInfoTable']//tr[" + index + "]/td[@id='dev-lblCostCenterDescription']")))
		//		{
		//			costCenter = ActionBot.getTextWithInElement(driver,
		//				By.xpath(".//*[@id='costingInfoTable']//tr[" + index + "]/td[@id='dev-lblCostCenterDescription']"));
		//
		//		}

		if (ActionBot.isElementPresent(driver, By.xpath("(.//*[@class='tblSplitData itemSummaryCostings']//div[contains(@class,'costing')])[" + (index + 1) + "]")))
		{
			costCenter = ActionBot.getTextWithInElement(driver,
				By.xpath("(.//*[@class='tblSplitData itemSummaryCostings']//div[contains(@class,'costing')])[" + (index + 1) + "]"));
		}
		logger.info("Cost Center  : " + costCenter);
		return costCenter;
	}

	@Override
	public String getBudgetForHeaderLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String budget = null;
		//		if (ActionBot.isElementPresent(driver,
		//			By.xpath(".//*[@id='costingInfoTable']//tr[" + index + "]/td[@id='dev-lblBudgetLineName']")))
		//		{
		//			budget = ActionBot.getTextWithInElement(driver,
		//				By.xpath(".//*[@id='costingInfoTable']//tr[" + index + "]/td[@id='dev-lblBudgetLineName']"));
		//
		//		}

		if (ActionBot.isElementPresent(driver, By.xpath("(.//*[@class='tblSplitData itemSummaryCostings']//div[contains(@class,'budget')])[" + (index + 1) + "]")))
		{
			budget = ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@class='tblSplitData itemSummaryCostings']//div[contains(@class,'budget')])[" + (index + 1) + "]"));
		}
		logger.info("Budget  : " + budget);
		return budget;
	}

	@Override
	public String getProjectForHeaderLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String project = null;
		//		if (ActionBot.isElementPresent(driver,
		//			By.xpath(".//*[@id='costingInfoTable']//tr[" + index + "]/td[@id='dev-lblProjectType']")))
		//		{
		//			project = ActionBot.getTextWithInElement(driver,
		//				By.xpath(".//*[@id='costingInfoTable']//tr[" + index + "]/td[@id='dev-lblProjectType']"));
		//		}

		if (ActionBot.isElementPresent(driver, By.xpath("(.//*[@class='tblSplitData itemSummaryCostings']//div[contains(@class,'dev_project')])[" + (index + 1) + "]")))
		{
			project = ActionBot.getTextWithInElement(driver,
				By.xpath("(.//*[@class='tblSplitData itemSummaryCostings']//div[contains(@class,'dev_project')])[" + (index + 1) + "]"));
		}
		logger.info("Project  : " + project);
		return project;
	}

	@Override
	public void clickOnAddApproverButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_APPROVER);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "Before adding approver");
	}

	@Override
	public void clickOnSubmitForApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SUBMIT_FOR_APPROVAL);
		ActionBot.waitTillPopUpIsPresent(driver, PROCESSING_DIV_UPDATE_REQUISITION);
		//ActionBot.waitForPageLoad(driver);
	}

	@Override
	public String getAddedApproverNameFromWorkflow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String approverName = ActionBot.getTextWithInElement(driver, LABEL_ADDED_APPROVER_NAME_AS_ON_REQ_VIEW);
		logger.info("Added approver name : " + approverName);
		return approverName;
	}

	@Override
	public String getAddedApproverExtraInfoFromWorkflow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String approverExtraInfo = ActionBot.getTextWithInElement(driver, LABEL_ADDED_APPROVER_EXTRA_INFO_AS_ON_REQ_VIEW);
		logger.info("Added approver's extra information : " + approverExtraInfo);
		return approverExtraInfo;
	}

	@Override
	public boolean isSubmitForApprovalButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_SUBMIT_FOR_APPROVAL);
	}

	@Override
	public void clickOnRemoveFirstAddedApprover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REMOVE_FIRST_ADDED_APPROVER);
		ActionBot.waitTillPopUpIsPresent(driver, PROGRESSING_DIV_UPDATING_WORKFLOW);
	}

	@Override
	public String getAuditTrailAction(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		String action = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_audit_trail + rowNo + xpath2_audit_trail_action));
		logger.info("Action : " + action);
		return action;
	}

	@Override
	public String getAuditTrailActor(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		String actor = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_audit_trail + rowNo + xpath2_audit_trail_actor));
		logger.info("Actor : " + actor);
		return actor;
	}

	@Override
	public String getAuditTrailSharedWith(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		String sharedWith = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_audit_trail + rowNo + xpath2_audit_trail_shared_with));
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
	public String getAuditTrailDateTime(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		String dateOrTime = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_audit_trail + rowNo + xpath2_audit_trail_date_time));
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
		String message = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_audit_trail + rowNo + xpath2_audit_trail_message));
		logger.info("Message : " + message);
		return message;
	}

	@Override
	public void clickOnModifyRequisitionLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on modify link");
		ActionBot.click(driver, LINK_MODIFY_REQUISITION);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on modify link");
	}

	@Override
	public void clickOnAuditTrail(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, AUDIT_TRAIL_LINK);

	}

	@Override
	public boolean isBudgetDisplayedInsideCostBooking(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUDGET_FIELD_REQ_VIEW))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickOnAssignBuyerlink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ASSIGN_BUYER_LINK);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnCancelAssignBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, MODAL_ASSIGN_BUYER_CANCEL_LINK);

	}

	@Override
	public void clickOnSaveAssignBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "Before Assigning Buyer");
		ActionBot.click(driver, MODAL_ASSIGN_BUYER_SAVE_LINK);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After Assigning Buyer");
	}

	@Override
	public void clickOnRemoveAssignBuyerbtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, MODAL_REMOVE_ASSIGN_BUYER_BTN);

	}

	@Override
	public String fillAssignBuyerField(WebDriver driver, String testCaseName, String assignbuyer) throws ActionBotException
	{
		ActionBot.defaultSleep();
		WebElement element = ActionBot.findElement(driver, FILL_ASSIGN_BUYER_MODAL);
		element.sendKeys(assignbuyer);
		ActionBot.defaultSleep();
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.ENTER);
		return assignbuyer;

	}

	@Override
	public String getAssignBuyerField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		String assignedBuyerName = ActionBot.getTextWithInElement(driver, ASSGN_BUYER_FIELD);
		logger.info("Assigned Buyer Name on Requisition View Page : " + assignedBuyerName);
		return assignedBuyerName;
	}

	@Override
	public void clickOnItemDetailsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		ActionBot.click(driver, ITEM_LINK);
	}

	@Override
	public void clickOnItemDetailsLinkIndewise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		//ActionBot.click(driver, By.xpath("(.//*[contains(@id,'dev-item_')]//a[contains(@class,'showItemDetails')])[" + index + "]"));
		//xpath-(.//*[contains(@id,'itemName_')])[index]
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'itemName_')])[" + index + "]"));

	}

	@Override
	public void clickOnExpandAccounting(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_EXPAND_ACCOUNTING_ON_REQ_VIEW_PAGE);

	}

	@Override
	public void clickOnExpandWorkFlow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_EXPAND_WORKFLOW_ON_REQ_VIEW_PAGE);

	}

	@Override
	public void clickOnActionsReqViewOrderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ACTIONS_REQ_VIEW_ORDER_TAB);
	}

	@Override
	public void clickOnRequestAdditionalItemActionsReqViewOrderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REQUEST_ADDITIONAL_ITEMS_ACTIONS_REQ_VIEW_ORDER_TAB);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on request additional item actions");
	}

	@Override
	public String getSingleCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String costCenter = ActionBot.getTextWithInElement(driver, LABEL_SINGLE_COST_CENTER_REQ_VIEW_PAGE);
		logger.info("Cost Center : " + costCenter);
		return costCenter;
	}

	@Override
	public void clickOnAuditTrailVersion(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(xpath1_audit_trail + rowNo + xpath2_audit_trail_version_link));
	}

	@Override
	public boolean isChangeApproverPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LINK_CHANGE_APPROVER_FIRST_NODE);
	}

	@Override
	public void clickOnOrderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_ORDER_VIEW_REQUISITION);
		ActionBot.defaultSleep();

	}

	@Override
	public String getPOStatusOnOrderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_PO_STATUS_REQ_VIEW_ORDER_TAB);
	}

	@Override
	public String getLabelValueOfAssignBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String labelValue = ActionBot.getTextWithInElement(driver, ASSIGNED_BUYER_REQ);
		logger.info("Label value of Assign Buyer Link : " + labelValue);
		return labelValue;
	}

	@Override
	public void clickOnAssignSingleBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, LINK_DROP_DOWN_ASSIGN_BUYER);
		ActionBot.click(driver, LINK_SINGLE_ASSIGN_BUYER);
	}

	@Override
	public void clickOnAssignGroupOfBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, LINK_DROP_DOWN_ASSIGN_BUYER);
		ActionBot.click(driver, LINK_GROUP_ASSIGN_BUYER);
		ActionBot.defaultSleep();
	}

	@Override
	public String fillAssignedBuyerGroupName(WebDriver driver, String testCaseName, String assignedBuyerGroupName) throws ActionBotException
	{
		String assignedBuyerGroup = ActionBot.fillAutoCompleteField(driver, TEXTBOX_ASSIGNED_BUYER_GROUP_NAME, assignedBuyerGroupName);
		logger.info("Entered Assigned Buyer Group Name : " + assignedBuyerGroup);
		return assignedBuyerGroup;
	}

	@Override
	public void clickOnRequisitionTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_REQUISITION_ON_REQ_VIEW_PAGE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Requisition Tab");
	}

	@Override
	public String getItemStatus(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = (String) js.executeScript(
			"return document.getElementById('item_" + itemId + "').getElementsByClassName('itmStatus')[0].getElementsByTagName('span')[0].getAttribute('data-qtipmsg')");
		//String status=ActionBot.getAttributeOfElement(driver, By.xpath(xpath1_item_status + itemId + xpath2_item_status), "data-qtipmsg");
		logger.info("getItemStatus - item status :" + status + ":");
		return status;
	}

	@Override
	public void clickOnParentRequisitionLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PARENT_REQUISITION);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnClearFilterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LINK_FILTER_DROP_DOWN);
		ActionBot.moveToElementAndClick(driver, LINK_CLEAR_FILTER_REQ_VIEW_PAGE);
		ActionBot.defaultSleep();
	}

	@Override
	public String getRequesterInWorkflowNode(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String requester = ActionBot.getTextWithInElement(driver, LABEL_REQUESTER_NODE_IN_WORKFLOW_TRAIL_ON_REQ_VIEW_PAGE);
		logger.info("Requester in Workflow Tail : " + requester);
		return requester;
	}

	@Override
	public void clickOnChangeBuyerLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.scroll(driver, "1000");
		ActionBot.defaultSleep();
		ActionBot.click(driver, PREVIEW_REQ_CHANGE_BUYER_LINK);

	}

	@Override
	public String fillModalAssignBuyerField(WebDriver driver, String testCaseName, String assignBuyer) throws ActionBotException
	{
		return ActionBot.fillAutoCompleteField(driver, PREVIEW_REQ_ASSIGN_BUYER, assignBuyer);
		// return ActionBot.sendKeys(driver, PREVIEW_REQ_ASSIGN_BUYER,
		// assignBuyer);
	}

	@Override
	public void clickOnModalAssignBuyerSaveBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PREVIEW_REQ_ASSIGN_BUYER_SAVE_BTN);

	}

	@Override
	public void clickOnSuppliersTabInItemDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, TAB_SUPPLIERS_ITEM_DETAILS);
		ActionBot.defaultSleep();

	}

	@Override
	public String getSuggestedSupplierNameInItemDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_SUGGESTED_SUPPLIER_NAME);
	}

	@Override
	public boolean isSuggestedSupplierNamePresentInItemDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LABEL_SUGGESTED_SUPPLIER_NAME))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnCancelItemDetailsModal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_ITEM_DETAILS_MODAL);
		ActionBot.defaultSleep();
	}

	@Override
	public boolean isAssetCodePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, LABEL_ASSET_CODE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getAssetCode(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_ASSET_CODE);
	}

	@Override
	public void clickOnActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ACTIONS_REQ_VIEW_PAGE);
	}

	@Override
	public void clickOnCopyActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		clickOnActionsLink(driver, testCaseName);
		ActionBot.click(driver, LINK_COPY_ACTIONS_REQ_VIEW_PAGE);
	}

	@Override
	public void clickOnItemName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.defaultSleep();
		//eProc version R17.11.1.0
		//ActionBot.click(driver, By.xpath(xpath1_item_name + itemId + xpath2_item_name));
		ActionBot.click(driver, By.xpath(xpath1_item_name + itemId + "']"));
	}

	@Override
	public List<String> getMultipleBuyerNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> buyerNames = new ArrayList<>();
		ActionBot.hover(driver, LABEL_MULTIPLE_ASSIGNED_BUYER);
		String multipleBuyerNames = ActionBot.getTextWithInElement(driver, LABEL_MULTIPLE_BUYER_NAMES_ON_HOVER);
		String[] temp = StringUtils.split(multipleBuyerNames, "\n");
		for (String str : temp)
		{
			buyerNames.add(str);
		}
		return buyerNames;
	}

	@Override
	public String getCostCenterLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String costCenter = ActionBot.getTextWithInElement(driver, LABEL_COST_CENTER_REQ_VIEW_PAGE);
		logger.info("Cost Center Label Name : " + costCenter);
		return costCenter;
	}

	@Override
	public String getGLAccountLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String glAccount = ActionBot.getTextWithInElement(driver, LABEL_GL_ACCOUNT_REQ_VIEW_PAGE);
		logger.info("GL Account Label Name : " + glAccount);
		return glAccount;
	}

	@Override
	public String getGLAccountTypeLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String glAccountType = ActionBot.getTextWithInElement(driver, LABEL_GL_ACCOUNT_TYPE_REQ_VIEW_PAGE);
		logger.info("GL Account Type Label Name : " + glAccountType);
		return glAccountType;
	}

	@Override
	public boolean isRequisitionNoLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABEL_REQUISITION_NO_ON_REQ_VIEW_PAGE);
	}

	@Override
	public String get_BU_Indexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'dev-dlv')]/td[2])[" + index + "]"));
	}

	@Override
	public String get_BusinessLocation_Indexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'dev-dlv')]/td[3])[" + index + "]"));
	}

	@Override
	public boolean clickOnRemindApproverLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{

			ActionBot.click(driver, IPageRequisitionView.REMIND_APPROVER);
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void clickOnGoBackLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, GO_BACK);
	}

	@Override
	public boolean isItemBlockOpen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ITEMS_BLOCK_OPEN);
	}

	@Override
	public boolean isDeliveryAssetTagBlockOpen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, DELIVERY_AND_ASSET_BLOCK_OPEN);
	}

	@Override
	public boolean isCostBookingBlockOpen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, COST_BOOKING_BLOCK_OPEN);
	}

	@Override
	public boolean isAccountingBlockOpen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, COST_ACCOUNTING_BLOCK_OPEN);
	}

	@Override
	public boolean isWorkflowBlockOpen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, WORKFLOW_BLOCK_OPEN);
	}

	@Override
	public void clickItemDescriptionLinkIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'item_')]//a[contains(@title,'Click to view more details')])[" + index + "]"));

	}

	@Override
	public void clickCloseItemDescriptionLinkIndexwise(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.click(driver, By.xpath("(.//button[@title='Close'])[18]"));
	}

	@Override
	public boolean isBuyerReturnCommentPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, BUYER_RETURN_COMMENT);
	}

	@Override
	public String getAddedAdhocApproverExtraInfoFromWorkflow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String approverExtraInfo = ActionBot.getTextWithInElement(driver, LABEL_ADDED_ADHOC_APPROVER_EXTRA_INFO_AS_ON_REQ_VIEW);
		logger.info("Added approver's extra information : " + approverExtraInfo);
		return approverExtraInfo;
	}

	@Override
	public int getItemQuantity(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{

		String xpath = LABEL_ITEM_QUANTITY.getValue();
		xpath = xpath.replace("itemId", itemId);
		String quant = ActionBot.getTextWithInElement(driver, By.xpath(xpath));

		logger.info("Quantity : " + quant);
		String[] temp = StringUtils.split(quant, " ");
		return Integer.parseInt(temp[0].trim());
	}

	@Override
	public void clickOnItemSummaryViewItemWise(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='item_" + itemId + "']//a[@title='View']"));
	}

	public String getRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, REQUIRED_BY_DATE_REQUISITION_VEIW);
	}

	@Override
	public String getItem_Name(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String itemName = null;
		itemName = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='itemName_" + itemId + "']"));
		return itemName;
	}

	@Override
	public String getDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String deliveryAddress = ActionBot.getTextWithInElement(driver, DELIVERY_ADDRESS);
		logger.info("Delivery address is :" + deliveryAddress);
		return deliveryAddress;
	}
}
