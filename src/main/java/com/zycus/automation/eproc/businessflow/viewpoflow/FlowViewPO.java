/**
 * 
 */
package com.zycus.automation.eproc.businessflow.viewpoflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.BillingRequisitionSummary;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.eproc.pageobjects.modals.closepo.ModalClosePO;
import com.zycus.automation.eproc.pageobjects.modals.emailpo.ModalEmailPODocument;
import com.zycus.automation.eproc.pageobjects.modals.remindsupplierforpo.ModalRemindSupplier;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.IPageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class FlowViewPO
{
	static Logger logger = Logger.getLogger(FlowViewPO.class);

	public static void closePO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ModalClosePO.fillCloseComment(driver, testCaseName, IConstantsData.CLOSE_PO_COMMENT);
		ModalClosePO.clickOnCheckBoxAllowCreatingInvoice(driver, testCaseName);
		ModalClosePO.clickOnClosePO(driver, testCaseName);
	}

	public static Map<String, String> emailPO(WebDriver driver, String testCaseName) throws Exception

	{
		Map<String, String> emailPODetails = new HashMap<String, String>();
		emailPODetails.put(IConstantsData.EMAIL_PO_TO,
			ModalEmailPODocument.fillEmailToField(driver, testCaseName, CommonServices.getTestData(IConstantsData.TO_FIELD_VALUE_FOR_SENDING_PO_EMAIL)));
		emailPODetails.put(IConstantsData.EMAIL_MESSAGE, ModalEmailPODocument.fillEmailMessageField(driver, testCaseName, IConstantsData.EMAIL_PO_MESSAGE));
		emailPODetails.put(IConstantsData.EMAIL_PO_ATTACHMENT_NAME, ModalEmailPODocument.getAttachmentLinkText(driver, testCaseName));
		ModalEmailPODocument.clickOnSendEmailButton(driver, testCaseName);
		return emailPODetails;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To remind supplier <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param poNo </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static boolean remindSupplier(WebDriver driver, String testCaseName, String poNo) throws Exception
	{
		if (!ModalRemindSupplier.getNameOfAttachment(driver, testCaseName).contains(poNo))
		{
			logger.info("Attachment name on remind supplier model was wrong");
			ModalRemindSupplier.clickOnCancelButton(driver, testCaseName);
			return false;
		}
		else
		{
			ModalRemindSupplier.fillRemindSupplierTo(driver, testCaseName, CommonServices.getTestData(IConstantsData.TO_FIELD_VALUE_FOR_SENDING_PO_EMAIL));
			ModalRemindSupplier.clickOnSendCopyCheckbox(driver, testCaseName);
			ModalRemindSupplier.fillMessageForRemindSupplier(driver, testCaseName, IConstantsData.EMAIL_PO_MESSAGE);
			ModalRemindSupplier.clickOnSendButton(driver, testCaseName);
		}
		ModalRemindSupplier.isSuccessMessagePresent(driver, testCaseName);
		return true;
	}

	public static void cancelPo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
		PageViewPurchaseOrder.clickOnCancelPoLink(driver, testCaseName);
		PageViewPurchaseOrder.fillCancelPoCommentField(driver, testCaseName, IConstantsData.CANCEL_PO_COMMENT);
		PageViewPurchaseOrder.clickOnCancelPoSubmitButtom(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Amend PO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static void amendPo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
		PageViewPurchaseOrder.clickOnAmendPo(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Copy PO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static void copyPo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
		PageViewPurchaseOrder.clickOnCopyPO(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To change approver <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param replaceWithActor </font><b><br>
	 * @param index </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static boolean changeApprover(WebDriver driver, String testCaseName, String replaceWithActor, int index) throws Exception
	{
		boolean flag = false;
		PageViewPurchaseOrder.clickOnChangeApprover(driver, testCaseName, index);
		PageViewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, replaceWithActor);
		// CommonServices.getTestData(IConstantsData.DIFFERENT_USER));
		PageViewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);

		String actorName = PageViewPurchaseOrder.getWorkflowActorName(driver, testCaseName, index);
		flag = actorName.equalsIgnoreCase(replaceWithActor);
		return flag;
	}

	/**
	 * <b>Author: prateek.khandelwal </b> <b><br>
	 * <font color="blue">Method :</b>Get All PO details from View PO page and returns respective PO object. Prerequisite: Is already in view PO page.
	 * @throws FactoryMethodException
	 */
	public static PurchaseOrder getPODetails(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setBillingRequisitionSummary(PageViewPurchaseOrder.getOrganisationUnit(driver, testCaseName));
		return purchaseOrder;
	}

	/**
	 * <b>Author: priyanka.jadhav </b> <b><br>
	 * <font color="blue">Method : To Print PO</b>Copy PO <br>
	 */
	public static void printPo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageViewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
		if (PageViewPurchaseOrder.isPrintPOOptionPresent(driver, testCaseName))
		{
			PageViewPurchaseOrder.clickOnPrintPO(driver, testCaseName);
		}

		//add code to close printPO popup window?		
	}

	/*
	 * author : bhakti.sawant
	 */
	public static boolean verifyPODetails(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException, FactoryMethodException
	{

		//Purchase Order Details 
		BillingRequisitionSummary PObillingRequisitionSummary = PageViewPurchaseOrder.getOrganisationUnit(driver, testCaseName);

		if (requisition.getBillingRequisitionSummary() != null)
		{
			if (requisition.getBillingRequisitionSummary().getCompany() != null)
			{
				if (!PObillingRequisitionSummary.getCompany().equalsIgnoreCase(requisition.getBillingRequisitionSummary().getCompany()))
					return false;
			}
			if (requisition.getBillingRequisitionSummary().getBusinessUnit() != null)
			{
				if (!PObillingRequisitionSummary.getBusinessUnit().equalsIgnoreCase(requisition.getBillingRequisitionSummary().getBusinessUnit()))
					return false;
			}
			if (requisition.getBillingRequisitionSummary().getLocation() != null)
			{
				if (!PObillingRequisitionSummary.getLocation().equalsIgnoreCase(requisition.getBillingRequisitionSummary().getLocation()))
					return false;
			}
			if (requisition.getBillingRequisitionSummary().getBillToAddress() != null)
			{
				if (!PObillingRequisitionSummary.getBillToAddress().contains(requisition.getBillingRequisitionSummary().getBillToAddress()))
					return false;
			}
			if (requisition.getBillingRequisitionSummary().getCurrency() != null)
			{
				if (!PObillingRequisitionSummary.getCurrency().equalsIgnoreCase(requisition.getBillingRequisitionSummary().getCurrency()))
					return false;
			}
		}
		return true;
	}

	/*
	 * author : bhakti.sawant
	 */
	public static boolean verifySupplierAndCorresponding_ItemDetails_CorrespondingAccountingDetails(WebDriver driver, String testCaseName, Requisition requisition)
		throws ActionBotException, FactoryMethodException
	{
		String supplierName = PageViewPurchaseOrder.getSupplierName(driver, testCaseName);
		List<CatelogItem> catelogItems = new ArrayList<>();
		List<GuidedItem> guidedItems = new ArrayList<>();
		double totalPrice = 0;
		if (requisition.getItems().getCatelogItems() != null)
		{
			for (int i = 0; i < requisition.getItems().getCatelogItems().size(); i++)
			{
				if (requisition.getItems().getCatelogItems().get(i).getSupplier().equalsIgnoreCase(supplierName))
				{
					catelogItems.add(requisition.getItems().getCatelogItems().get(i));
					//totalPrice = totalPrice+Double.parseDouble(requisition.getItems().getCatelogItems().get(i).getTotalItemPrice());
				}
			}
		}
		if (requisition.getItems().getGuidedItems() != null)
		{
			for (int i = 0; i < requisition.getItems().getGuidedItems().size(); i++)
			{
				if (requisition.getItems().getGuidedItems().get(i).getSupplierNameInSuppInfo().equalsIgnoreCase(supplierName))
				{
					guidedItems.add(requisition.getItems().getGuidedItems().get(i));
					//totalPrice += Double.parseDouble(requisition.getItems().getCatelogItems().get(i).getTotalItemPrice());
				}
			}
		}

		if ((guidedItems.isEmpty()) && (catelogItems.isEmpty()))
			return false;

		//VERIFY ITEM DETAILS
		Requisition newRequisition = requisition;
		Item item = new Item();
		item.setCatelogItems(catelogItems);
		item.setGuidedItems(guidedItems);

		requisition.setItems(item);
		verifyAccountingInfo(driver, testCaseName, newRequisition);
		//requisition.setTotalPrice(String.valueOf(totalPrice));

		/*
		 * if (!verifyItemDetails(driver, testCaseName, newRequisition))
		 * return false;
		 */ return true;
	}

	/*
	 * author : bhakti.sawant
	 */
	public static boolean verifyItemDetails(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException, FactoryMethodException
	{
		int index = 0;
		int indexAfterCatelog = 0;
		if (requisition.getItems().getCatelogItems() != null)
		{
			index = requisition.getItems().getCatelogItems().size();
			for (int i = 0; i < index; i++)
			{
				String itemName = PageViewPurchaseOrder.getItemNames(driver, testCaseName, i + 1);
				if (!itemName.equalsIgnoreCase(requisition.getItems().getCatelogItems().get(i).getItemName()))
					return false;
				indexAfterCatelog = i;
			}
		}
		if (requisition.getItems().getGuidedItems() != null)
		{
			index = index + requisition.getItems().getGuidedItems().size();
			for (int i = ++indexAfterCatelog; i < index; i++)
			{
				String itemName = PageViewPurchaseOrder.getItemNames(driver, testCaseName, i + 1);
				if (!itemName.equalsIgnoreCase(requisition.getItems().getGuidedItems().get(i).getItemName()))
					return false;
			}
		}

		/*
		 * if (requisition.getTotalPrice() != null)
		 * {
		 * System.out.println("PO total gross : " + PageViewPurchaseOrder.getGrossTotal(driver, testCaseName));
		 * System.out.println("Req gross" + requisition.getTotalPrice());
		 * if (!requisition.getTotalPrice().equalsIgnoreCase(PageViewPurchaseOrder.getGrossTotal(driver, testCaseName)))
		 * return false;
		 * }
		 */
		return true;
	}

	/*
	 * author : bhakti.sawant
	 */
	public static boolean verifyDeliveryInformation(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException, FactoryMethodException
	{
		ActionBot.scroll(driver, ActionBot.findElement(driver, IPageViewPurchaseOrder.DELIVERY_INFO_SPAN));
		ActionBot.click(driver, ActionBot.findElement(driver, IPageViewPurchaseOrder.DELIVERY_INFO_SPAN));

		//for Delivery Requisition Summary
		System.out.println("PO Date : " + PageViewPurchaseOrder.getDeliveryDateUnderDeliverySection(driver, testCaseName));
		if (requisition.getDeliveryRequisitionSummary() != null)
			if (requisition.getDeliveryRequisitionSummary().getCustomDate() != null)
				if (!requisition.getDeliveryRequisitionSummary().getCustomDate().getDate().equals(PageViewPurchaseOrder.getDeliveryDateUnderDeliverySection(driver, testCaseName)))
					return false;
		//to be handled for Delivery Item Summary
		return true;
	}

	/*
	 * author : bhakti.sawant
	 */
	public static boolean verifyPaymentsAndCreditInfo(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException, FactoryMethodException
	{
		if (requisition.getTotalPrice() != null)
		{
			System.out.println("total price at Requisition Page : " + requisition.getTotalPrice() + " :");
			if (!requisition.getTotalPrice().equals(ActionBot.findElement(driver, IPageViewPurchaseOrder.ITEM_SUB_TOTAL_PRICE).getText()))
			{
				System.out.println("Total price at PO Page : " + ActionBot.findElement(driver, IPageViewPurchaseOrder.ITEM_SUB_TOTAL_PRICE).getText() + " :");
				return false;
			}
		}
		return true;
	}

	/*
	 * author : bhakti.sawant
	 */
	public static boolean verifyCostBookingInfo(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException, FactoryMethodException
	{
		//ActionBot.waitForElementToBeDisplayed(driver, IPageViewPurchaseOrder.COSTBOOKING_LINK, 5000);
		ActionBot.scroll(driver, ActionBot.findElement(driver, IPageViewPurchaseOrder.COST_BOOKING_HEADER));
		ActionBot.scroll(driver, "900");
		PageViewPurchaseOrder.clickOnCostBookingInfoHeader(driver, testCaseName);

		//for CostBooking Requisition Summary
		if (requisition.getCostBookingRequisitionSummary() != null)
		{
			if (requisition.getCostBookingRequisitionSummary().getCostCenter() != null)
			{
				if (PageViewPurchaseOrder.checkIfCCPresentUnderCostBookingInfo(driver, testCaseName))
					if (!requisition.getCostBookingRequisitionSummary().getCostCenter().replaceAll("\\s+", "")
						.equalsIgnoreCase(PageViewPurchaseOrder.getCostCenterUnderCostBooking(driver, testCaseName).replaceAll("\\s+", "")))
						return false;
			}

			if (requisition.getCostBookingRequisitionSummary().getProject() != null)
			{
				if (PageViewPurchaseOrder.checkIProjectPresentUnderCostBookingInfo(driver, testCaseName))
					if (!requisition.getCostBookingRequisitionSummary().getProject().replaceAll("\\s+", "")
						.equalsIgnoreCase(PageViewPurchaseOrder.getProjectUnderCostBooking(driver, testCaseName).replaceAll("\\s+", "")))
						return false;
			}
			if (requisition.getCostBookingRequisitionSummary().getBudget() != null)
			{
				if (PageViewPurchaseOrder.checkIfCCPresentUnderCostBookingInfo(driver, testCaseName))
					if (!requisition.getCostBookingRequisitionSummary().getBudget().replaceAll("\\s+", "")
						.contains(PageViewPurchaseOrder.getBudgetUnderCostBooking(driver, testCaseName).replaceAll("\\s+", "")))
						return false;
			}
		}
		//to be handled for CostBooking Item Summary

		PageViewPurchaseOrder.clickOnCostBookingInfoHeader(driver, testCaseName);

		return true;
	}

	/*
	 * author : bhakti.sawant
	 */
	public static boolean verifyAccountingInfo(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException, FactoryMethodException
	{
		int index = 0;
		int indexAfterCatelog = 0;
		String reqGLAccount = null;
		ActionBot.scroll(driver, ActionBot.findElement(driver, IPageViewPurchaseOrder.ACCOUNTING_LINK));
		ActionBot.waitForPageLoad(driver);
		PageViewPurchaseOrder.clickOnAccountingLink(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		//for requisition Accounting Item Summary
		if (requisition.getAccountingItemSummary() != null)
		{
			if (requisition.getAccountingItemSummary().getGlAccountType() != null)
			{
				reqGLAccount = requisition.getAccountingItemSummary().getGlAccountType();
				if (requisition.getItems().getCatelogItems() != null)
				{
					index = requisition.getItems().getCatelogItems().size();
					for (int i = 0; i < index; i++)
					{
						String GLAccount = PageViewPurchaseOrder.getGLAccountInAccountingSection(driver, testCaseName, i + 1);
						if (!GLAccount.equalsIgnoreCase(reqGLAccount))
							return false;
						indexAfterCatelog = i;
					}
				}
				if (requisition.getItems().getGuidedItems() != null)
				{
					index = index + requisition.getItems().getGuidedItems().size();
					for (int i = ++indexAfterCatelog; i < index; i++)
					{
						String GLAccount = PageViewPurchaseOrder.getGLAccountInAccountingSection(driver, testCaseName, i + 1);
						if (!GLAccount.equalsIgnoreCase(reqGLAccount))
							return false;
					}
				}
			}
		}
		PageViewPurchaseOrder.clickOnAccountingLink(driver, testCaseName);
		return true;
	}

	/*
	 * client specific - QTS : to check audit trail
	 * author : bhakti.sawant
	 */
	public static boolean verifyAuditTrailInfoQTS(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException, FactoryMethodException
	{
		ActionBot.scroll(driver, ActionBot.findElement(driver, IPageViewPurchaseOrder.LABEL_AUDIT_TRIAL));
		PageViewPurchaseOrder.clickOnAuditTrail(driver, testCaseName);
		int number = PageViewPurchaseOrder.getNoOfRowsUnderAuditTrail(driver, testCaseName);
		boolean flag1 = false, flag2 = false, flag3 = false;
		for (int i = 0; i < number; i++)
		{
			if (PageViewPurchaseOrder.getAuditTrailAction(driver, testCaseName, i + 1) == null)
				return false;
			else
			{
				if (PageViewPurchaseOrder.getAuditTrailAction(driver, testCaseName, i + 1).equalsIgnoreCase(IConstantsData.ORDER_RELEASED))
					if (PageViewPurchaseOrder.getAuditTrailRole(driver, testCaseName, i + 1).equalsIgnoreCase(IConstantsData.SYSTEM))
						flag1 = true;
					else
						return false;

				else if (PageViewPurchaseOrder.getAuditTrailAction(driver, testCaseName, i + 1).equalsIgnoreCase(IConstantsData.ORDER_APPROVED))
					if (PageViewPurchaseOrder.getAuditTrailRole(driver, testCaseName, i + 1).equalsIgnoreCase(IConstantsData.SYSTEM))
						flag2 = true;

					else
						return false;

				else if (PageViewPurchaseOrder.getAuditTrailAction(driver, testCaseName, i + 1).equalsIgnoreCase(IConstantsData.ORDER_SUBMITTED))
					if (PageViewPurchaseOrder.getAuditTrailRole(driver, testCaseName, i + 1).equalsIgnoreCase(IConstantsData.BUYER))
						flag3 = true;
					else
						return false;

				if (!PageViewPurchaseOrder.getAuditTrailVersion(driver, testCaseName, i + 1).equalsIgnoreCase(IConstantsData.VERSION_V1))
					return false;
			}
		}
		PageViewPurchaseOrder.clickOnAuditTrail(driver, testCaseName);
		return flag1 && flag2 && flag3;
	}
}
