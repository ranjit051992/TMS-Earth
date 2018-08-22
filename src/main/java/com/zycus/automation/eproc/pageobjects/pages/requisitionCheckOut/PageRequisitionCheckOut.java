package com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.CostBookingAndAccountingItemSummaryCOA;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ASyncRequestNotCompletedInSpecifiedTimeException;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.exception.PageloadNotCompletedInSpecifiedTimeException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.framework_version_2_4.framework.Helper;

public class PageRequisitionCheckOut
{

	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static boolean checkRetrospectivePurchase(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Boolean purchase = false;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOf(IPageRequisitionCheckOutImpl.class);
			new IPageRequisitionCheckOutImpl();
			purchase = checkout.checkRetrospectivePurchase(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkRetrospectivePurchase " + e, e);
		}
		return purchase;
	}

	public static boolean checkUrgentRequirement(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean requirement = false;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			requirement = checkout.checkUrgentRequirement(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkUrgentRequirement " + e, e);
		}
		return requirement;
	}

	public static void clickAddAttachment(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickAddAttachment(driver, testCaseName, itemID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickAddAttachment " + e, e);
		}
	}

	public static void clickOnCloseCurrencyWiseTotalLink(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickOnCloseCurrencyWiseTotalLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickAddAttachment " + e, e);
		}
	}

	public static void clickAddComments(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickAddComments(driver, testCaseName, itemID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickAddComments " + e, e);
		}
	}

	public static void clickOnShowAllPosBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickOnShowAllPosBtn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnShowAllPosBtn " + e, e);
		}
	}

	public static void clickAddItemOnCheckout(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickAddItemOnCheckout(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickAddItemOnCheckout " + e, e);
		}
	}

	public static void clickCancleRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickCancleRequisition(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCancleRequisition " + e, e);
		}
	}

	public static void clickToCancleRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickCancleRequisition(driver, testCaseName);
			ActionBot.waitForElementToBeDisplayed(driver, IPageRequisitionCheckOut.YES_CONFIRMATION, 60);
			ActionBot.click(driver, IPageRequisitionCheckOut.YES_CONFIRMATION);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCancleRequisition " + e, e);
		}
	}

	public static void clickChangeMultiple(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickChangeMultiple(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickChangeMultiple " + e, e);
		}
	}

	public static void clickClearRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickClearRequiredByDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickClearRequiredByDate " + e, e);
		}
	}

	public static void clickContinueRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickContinueRequisition(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickContinueRequisition " + e, e);
		}

	}

	public static void clickCurrencyWiseTotal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickCurrencyWiseTotal(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCurrencyWiseTotal " + e, e);
		}

	}

	public static void clickDeleteItem(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickDeleteItem(driver, testCaseName, itemID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickDeleteItem " + e, e);
		}

	}

	public static void clickEditHeaderInfo(WebDriver driver, String testCaseName)
		throws ActionBotException, ASyncRequestNotCompletedInSpecifiedTimeException, PageloadNotCompletedInSpecifiedTimeException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickEditHeaderInfo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickEditHeaderInfo " + e, e);
		}
	}

	public static void clickEditItemSummary(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickEditItemSummary(driver, testCaseName, itemID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickEditItemSummary " + e, e);
		}
	}

	public static void clickExpandAll(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickExpandAll(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickExpandAll " + e, e);
		}

	}

	public static void clickIAmDone(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickIAmDone(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickIAmDone " + e, e);
		}

	}

	public static String clickSaveAsDraft(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.clickSaveAsDraft(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSaveAsDraft " + e, e);
		}
		return null;
	}

	public static void clickOnDeliveryItemEdit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickOnDeliveryItemEdit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeliveryItemEdit " + e, e);
		}

	}

	public static String fillDeliveryRecipientName(WebDriver driver, String testCaseName, String name) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fillDeliveryRecipientName(driver, testCaseName, name);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeliveryItemEdit " + e, e);
		}
		return null;
	}

	public static boolean isDeliveryRecipientNameEdited(WebDriver driver, String testCaseName, String name) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isDeliveryRecipientNameEdited(driver, testCaseName, name);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDeliveryRecipientNameEdited " + e, e);
		}
		return false;
	}

	public static void clickOnItemNameToViewItemDetails(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickOnItemNameToViewItemDetails(driver, testCaseName, itemID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemNameToViewItemDetails " + e, e);
		}
	}

	public static String fillAssignedBuyer(WebDriver driver, String testCaseName, String assignedBuyer) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fillAssignedBuyer(driver, testCaseName, assignedBuyer);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAssignedBuyer " + e, e);
		}
		return null;
	}

	public static String fillCheckoutReqName(WebDriver driver, String testCaseName, String checkoutReqName) throws ActionBotException
	{

		String reqName = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			reqName = checkout.fillCheckoutReqName(driver, testCaseName, checkoutReqName);
			if (reqName.equalsIgnoreCase(checkoutReqName))
			{
				return reqName;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCheckoutReqName " + e, e);
		}
		return null;
	}

	public static String fillCommentsForSupplier(WebDriver driver, String testCaseName, String commentsForSupplier) throws ActionBotException
	{

		String commSupplier = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			commSupplier = checkout.fillCommentsForSupplier(driver, testCaseName, commentsForSupplier);
			if (commSupplier.equalsIgnoreCase(commentsForSupplier))
			{
				return commentsForSupplier;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCommentsForSupplier " + e, e);
		}
		return null;
	}

	public static Integer fillItemQuantity(WebDriver driver, String testCaseName, Integer itemQty, String itemID) throws ActionBotException
	{

		Integer qty = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			qty = checkout.fillItemQuantity(driver, testCaseName, itemQty, itemID);
			if (qty.equals(itemQty))
			{
				return qty;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillItemQuantity " + e, e);
		}
		return null;
	}

	public static String fillOnBehalfOf(WebDriver driver, String testCaseName, String onBehalfOf) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fillOnBehalfOf(driver, testCaseName, onBehalfOf);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillOnBehalfOf " + e, e);
		}
		return null;
	}

	public static String getOnBehalfOf(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getOnBehalfOf(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillOnBehalfOf " + e, e);
		}
		return null;
	}

	public static String selectPurchaseType(WebDriver driver, String testCaseName, String purchaseType) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.selectPurchaseType(driver, testCaseName, purchaseType);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectPurchaseType " + e, e);
		}
		return null;
	}

	public static String fillReasonForOrdering(WebDriver driver, String testCaseName, String reasonForOrdering) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.fillReasonForOrdering(driver, testCaseName, reasonForOrdering);
			if (reasonForOrdering.equalsIgnoreCase(reasonForOrdering))
			{
				return reasonForOrdering;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReasonForOrdering " + e, e);
		}
		return null;
	}

	public static String getAccountingInExpandAll(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{

		String accounting = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			accounting = checkout.getAccountingInExpandAll(driver, testCaseName, itemID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAccountingInExpandAll " + e, e);
		}
		return accounting;
	}

	public static String getBillToAddressHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String billToAdd = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			billToAdd = checkout.getBillToAddressHeader(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getBillToAddressHeader " + e, e);
		}
		return billToAdd;
	}

	public static String getBudgetHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String budget = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			budget = checkout.getBudgetHeader(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getBudgetHeader " + e, e);
		}
		return budget;
	}

	public static String getBudgetInExpandAll(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{

		String budget = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			budget = checkout.getBudgetInExpandAll(driver, testCaseName, itemID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getBudgetInExpandAll " + e, e);
		}
		return budget;
	}

	public static String getCostBookingInExpandAll(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{

		String ccExpandAll = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			ccExpandAll = checkout.getCostBookingInExpandAll(driver, testCaseName, itemID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingInExpandAll " + e, e);
		}
		return ccExpandAll;
	}

	public static String getCostCenterHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String ccHeader = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			ccHeader = checkout.getCostCenterHeader(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostCenterHeader " + e, e);
		}
		return ccHeader;
	}

	public static String getDeliverToHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String deliverToHeader = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			deliverToHeader = checkout.getDeliverToHeader(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliverToHeader " + e, e);
		}
		return deliverToHeader;
	}

	public static String getDeliveryAddressHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String deliveryAddHeader = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			deliveryAddHeader = checkout.getDeliveryAddressHeader(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryAddressHeader " + e, e);
		}
		return deliveryAddHeader;
	}

	public static String getItemSupplier(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{

		String itemSupplier = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			itemSupplier = checkout.getItemSupplier(driver, testCaseName, itemID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSupplier " + e, e);
		}
		return itemSupplier;
	}

	public static String getOrganizationUnitHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String OUHeader = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			OUHeader = checkout.getOrganizationUnitHeader(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getOrganizationUnitHeader " + e, e);
		}
		return OUHeader;
	}

	public static String getRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String reqDate = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			reqDate = checkout.getRequiredByDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequiredByDate " + e, e);
		}
		return reqDate;
	}

	public static String selectRequiredByDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		String reqDate = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			reqDate = checkout.selectRequiredByDate(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectRequiredByDate " + e, e);
		}
		return reqDate;
	}

	public static boolean isApproverListPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			result = checkout.isApproverListPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isApproverListPresent " + e, e);
		}
		return result;
	}

	public static List<WebElement> getListOfApprovers(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> listOfApprover = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			listOfApprover = checkout.getListOfApprovers(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfApprovers " + e, e);
		}
		return listOfApprover;
	}

	public static boolean isMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			result = checkout.isMessagePresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isMessagePresent " + e, e);
		}
		return result;
	}

	public static List<WebElement> getListOfMessages(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> listOfMessages = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			listOfMessages = checkout.getListOfMessages(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfMessages " + e, e);
		}
		return listOfMessages;
	}

	public static void clickOnSelectApprovalButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickOnSelectApprovalButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectApprovalButton " + e, e);
		}
	}

	public static boolean isConfirmReqPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			result = checkout.isConfirmReqPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isConfirmReqPresent " + e, e);
		}
		return result;
	}

	public static void clickOnConfirmReqButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickOnConfirmReqButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnConfirmReqButton " + e, e);
		}
	}

	public static boolean isSubmitReqYesPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			result = checkout.isSubmitReqYesPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSubmitReqYesPresent " + e, e);
		}
		return result;

	}

	public static boolean isHeaderLevelProjectDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			result = checkout.isHeaderLevelProjectDisplayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isHeaderLevelProjectDisplayed " + e, e);
		}
		return result;

	}

	public static void clickOnConfirmContinueButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickOnConfirmContinueButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnConfirmContinueButton " + e, e);
		}
	}

	public static String selectSettlementVia(WebDriver driver, String testCaseName, String settlementVia) throws ActionBotException
	{
		String selectedSettlementVia = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			selectedSettlementVia = checkout.selectSettlementVia(driver, testCaseName, settlementVia);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectSettlementVia " + e, e);
		}
		return selectedSettlementVia;
	}

	public static String getCommentsForSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierComment = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			supplierComment = checkout.getCommentsForSupplier(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCommentsForSupplier " + e, e);
		}
		return supplierComment;
	}

	public static void waitTillReqSubmitProcessingDivPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.waitTillReqSubmitProcessingDivPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitTillReqSubmitProcessingDivPresent " + e, e);
		}
	}

	public static String selectPCard(WebDriver driver, String testCaseName, String pcard) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.selectPCard(driver, testCaseName, pcard);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectPCard " + e, e);
		}
		return null;
	}

	public static String getSelectedPCard(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getSelectedPCard(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedPCard " + e, e);
		}
		return null;
	}

	public static void clickOnAddRequisitionAttachmentLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickOnAddRequisitionAttachmentLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddRequisitionAttachmentLink " + e, e);
		}
	}

	public static String getLabelValueOfAddRequisitionAttachmentLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getLabelValueOfAddRequisitionAttachmentLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getLabelValueOfAddRequisitionAttachmentLink " + e, e);
		}
		return null;
	}

	public static String getSectionNameOfPEForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getSectionNameOfPEForm(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSectionNameOfPEForm " + e, e);
		}
		return null;
	}

	public static String getFieldNameOfPEForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getFieldNameOfPEForm(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFieldNameOfPEForm " + e, e);
		}
		return null;
	}

	public static String fillFieldValueOfPEForm(WebDriver driver, String testCaseName, String fieldValue) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fillFieldValueOfPEForm(driver, testCaseName, fieldValue);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillFieldValueOfPEForm " + e, e);
		}
		return null;
	}

	public static String getFieldValueOfPEForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getFieldValueOfPEForm(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFieldValueOfPEForm " + e, e);
		}
		return null;
	}

	public static String getDeliveryMultiSplitDeliverTo(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getDeliveryMultiSplitDeliverTo(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryMultiSplitDeliverTo " + e, e);
		}
		return null;
	}

	public static String getDeliveryMultiSplitDeliveryAddress(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getDeliveryMultiSplitDeliveryAddress(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryMultiSplitDeliveryAddress " + e, e);
		}
		return null;
	}

	public static String getDeliveryMultiSplitRequiredDate(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getDeliveryMultiSplitRequiredDate(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryMultiSplitRequiredDate " + e, e);
		}
		return null;
	}

	public static int getDeliveryMultiSplitQuantity(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getDeliveryMultiSplitQuantity(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryMultiSplitQuantity " + e, e);
		}
		return 0;
	}

	public static String getCostBookingMultiSplitAtItemLevelCostCenter(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getCostBookingMultiSplitAtItemLevelCostCenter(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingMultiSplitAtItemLevelCostCenter " + e, e);
		}
		return null;
	}

	public static String getCostBookingMultiSplitAtItemLevelBudget(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getCostBookingMultiSplitAtItemLevelBudget(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingMultiSplitAtItemLevelBudget " + e, e);
		}
		return null;
	}

	public static String getCostBookingMultiSplitAtItemLevelProject(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getCostBookingMultiSplitAtItemLevelProject(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingMultiSplitAtItemLevelProject " + e, e);
		}
		return null;
	}

	public static String getCostBookingMultiSplitAtItemLevelPrice(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getCostBookingMultiSplitAtItemLevelPrice(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostBookingMultiSplitAtItemLevelPrice " + e, e);
		}
		return null;
	}

	public static String getWorkflowMessageForForking(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getWorkflowMessageForForking(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getWorkflowMessageForForking " + e, e);
		}
		return null;
	}

	public static void clickOnModifyWorkFlowSettings(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.waitForLoadingDivOfWorkFlowTrail(driver, testCaseName);
			checkout.clickOnModifyWorkFlowSettings(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnModifyWorkFlowSettings " + e, e);
		}
	}

	public static void waitTillProgressingDivPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.waitTillProgressingDivPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitTillProgressingDivPresent " + e, e);
		}
	}

	public static String getTotalPriceAtCheckoutHead(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getTotalPriceAtCheckoutHead(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTotalPriceAtCheckoutHead " + e, e);
		}
		return null;
	}

	public static String getItemLevelTotalPriceAtCheckoutPage(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getTotalPriceAtCheckoutHead(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTotalPriceAtCheckoutHead " + e, e);
		}
		return null;
	}

	public static String getFirstApproverNameFromWorkflow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getFirstApproverNameFromWorkflow(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstApproverNameFromWorkflow " + e, e);
		}
		return null;
	}

	public static boolean isModifyWorkFlowSettingPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isModifyWorkFlowSettingPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstApproverNameFromWorkflow " + e, e);
		}
		return false;
	}

	public static boolean isReqCanNotBeLinkedErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isReqCanNotBeLinkedErrorMsgDisplayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isReqCanNotBeLinkedErrorMsgDisplayed " + e, e);
		}
		return false;
	}

	public static boolean isModifyWorkFlowSettingSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isModifyWorkFlowSettingSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isModifyWorkFlowSettingSelected " + e, e);
		}
		return false;
	}

	public static boolean isHeaderCheckoutIconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isHeaderCheckoutIconDisplayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isHeaderCheckoutIconDisplayed " + e, e);
		}
		return false;
	}

	public static String getSelectedPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getSelectedPurchaseType(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedPurchaseType " + e, e);
		}
		return null;
	}

	public static void clickOnClickHereLinkToShowErrors(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickOnClickHereLinkToShowErrors(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnClickHereLinkToShowErrors " + e, e);
		}

	}

	public static void clickOnAssignedBuyerDropdown(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
		checkout.clickOnAssignedBuyerDropdown(driver, testCaseName);
	}

	public static void clickOnSingleAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
		checkout.clickOnSingleAssignedBuyer(driver, testCaseName);
	}

	public static void clickOnGroupAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
		checkout.clickOnGroupAssignedBuyer(driver, testCaseName);
	}

	public static boolean isValidationAlertPopupPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
		return checkout.isValidationAlertPopupPresent(driver, testCaseName);
	}

	public static void clickOnOKForAlertPopup(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
		checkout.clickOnOKForAlertPopup(driver, testCaseName);
	}

	public static void clickOnSendItBackToMe(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
		checkout.clickOnSendItBackToMe(driver, testCaseName);
	}

	public static String getGLAccountInfoInExpandAll(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getGLAccountInfoInExpandAll(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getGLAccountInfoInExpandAll " + e, e);
		}
		return null;
	}

	public static String getItemId(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getItemId(driver, testCaseName, itemName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemId " + e, e);
		}
		return null;
	}

	public static String getTextOfSubmitButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getTextOfSubmitButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTextOfSubmitButton " + e, e);
		}
		return null;
	}

	public static void clickOnRemoveAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickOnRemoveAssignedBuyer(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRemoveAssignedBuyer " + e, e);
		}
	}

	public static boolean isRequisitionNameTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isRequisitionNameTextBoxPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isRequisitionNameTextBoxPresent " + e, e);
		}
		return false;
	}

	public static String getItemLevelCurrency(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getItemLevelCurrency(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemLevelCurrency " + e, e);
		}
		return null;
	}

	public static String getRequesterInWorkflowTrail(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getRequesterInWorkflowTrail(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequesterInWorkflowTrail " + e, e);
		}
		return null;
	}

	public static String getCostCenterLabelInHeaderSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getCostCenterLabelInHeaderSummary(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostCenterLabelInHeaderSummary " + e, e);
		}
		return null;
	}

	public static void clickEditItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickEditItemSummary(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickEditItemSummary " + e, e);
		}
	}

	public static boolean isSourcingStatusErrorIconPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isSourcingStatusErrorIconPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSourcingStatusErrorIconPresent " + e, e);
		}
		return false;
	}

	public static boolean isAssignedBuyerLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isAssignedBuyerLabelPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAssignedBuyerLabelPresent " + e, e);
		}
		return false;
	}

	public static String getQuantityAmountCurrency(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getQuantityAmountCurrency(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getQuantityAmountCurrency " + e, e);
		}
		return null;
	}

	public static String getAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getAssignedBuyer(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAssignedBuyer " + e, e);
		}
		return null;
	}

	public static boolean isPurchaseTypePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isPurchaseTypePresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPurchaseTypePresent " + e, e);
		}
		return false;
	}

	public static String fillAssignedBuyerGroup(WebDriver driver, String testCaseName, String buyer) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fillAssignedBuyerGroup(driver, testCaseName, buyer);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAssignedBuyerGroup " + e, e);
		}
		return null;
	}

	public static boolean isMisMatchSettlementViaErrorIconPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isMisMatchSettlementViaErrorIconPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isMisMatchSettlementViaErrorIconPresent " + e, e);
		}
		return false;
	}

	public static String getMisMatchSettlementViaErrorMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getMisMatchSettlementViaErrorMsg(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getMisMatchSettlementViaErrorMsg " + e, e);
		}
		return null;
	}

	public static boolean isGivenSettlementViaOptionPresent(WebDriver driver, String testCaseName, String settlementVia) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isGivenSettlementViaOptionPresent(driver, testCaseName, settlementVia);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isGivenSettlementViaOptionPresent " + e, e);
		}
		return false;
	}

	public static String getEformTitleSectionLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getEformTitleSectionLabel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getEformTitleSectionLabel " + e, e);
		}
		return null;
	}

	public static String getEformSubSectionLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getEformSubSectionLabel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getEformSubSectionLabel " + e, e);
		}
		return null;
	}

	public static String enterEformDetail(WebDriver driver, String testCaseName, String eForm) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.enterEformDetail(driver, testCaseName, eForm);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method enterEformDetail " + e, e);
		}
		return null;
	}

	public static boolean isPONoErrorOnAttachmentPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isPONoErrorOnAttachmentPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPONoErrorOnAttachmentPresent " + e, e);
		}
		return false;
	}

	public static void clickOnEformAddAttachmentLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickOnEformAddAttachmentLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEformAddAttachmentLink " + e, e);
		}

	}

	public static boolean isEformAddAttachmentLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isEformAddAttachmentLinkPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isEformAddAttachmentLinkPresent " + e, e);
		}
		return false;
	}

	public static String getSourcingStatusError(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getSourcingStatusError(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSourcingStatusError " + e, e);
		}
		return null;
	}

	public static boolean isItemPresentOnCheckoutPage(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isItemPresentOnCheckoutPage(driver, testCaseName, itemID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemPresentOnCheckoutPage " + e, e);
		}
		return false;
	}

	public static void waitForUpdateRequisitionProcessingDiv(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.waitForUpdateRequisitionProcessingDiv(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitForUpdateRequisitionProcessingDiv " + e, e);
		}
	}

	public static void waitForLoadingDivOfWorkFlowTrail(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.waitForLoadingDivOfWorkFlowTrail(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitForLoadingDivOfWorkFlowTrail " + e, e);
		}
	}

	public static void clickContinueButtonForConfirmPopup(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
		checkout.clickContinueButtonForConfirmPopup(driver, testCaseName);
	}

	public static String getAssetNoError(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getAssetNoError(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAssetNoError " + e, e);
		}
		return null;
	}

	public static String fetchRequisitionCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fetchRequisitionCurrency(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchRequisitionCurrency " + e, e);
		}
		return null;
	}

	public static String fetchRequisitionAmountWithCurrencyForItems(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fetchRequisitionAmountWithCurrencyForItems(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchRequisitionAmountWithCurrencyForItems " + e, e);
		}
		return null;
	}

	public static String fetchPurchaseAmountWithCurrencyForItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fetchPurchaseAmountWithCurrencyForItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchPurchaseAmountWithCurrencyForItems " + e, e);
		}
		return null;
	}

	public static void clickCloseRequisitionSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickCloseRequisitionSummary(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCloseRequisitionSummary " + e, e);
		}

	}

	public static void clickCostAllocation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickCostAllocation(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCostAllocation " + e, e);
		}

	}

	public static String fetchCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fetchCostCenter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchCostCenter " + e, e);
		}
		return null;
	}

	public static String fetchCostCenterHeaderIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fetchCostCenterHeaderIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchCostCenterHeaderIndexwise " + e, e);
		}
		return null;
	}

	public static String fetchDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fetchDeliveryAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchDeliveryAddress " + e, e);
		}
		return null;
	}

	public static String fetchDeliveryRecipientName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fetchDeliveryRecipientName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchDeliveryRecipientName " + e, e);
		}
		return null;
	}

	public static String fetchFetchBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fetchFetchBusinessUnit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchFetchBusinessUnit " + e, e);
		}
		return null;
	}

	public static void fillCostbookingSingleProject(WebDriver driver, String testCaseName, String projectName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.fillCostbookingSingleProject(driver, testCaseName, projectName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostbookingSingleProject " + e, e);
		}

	}

	public static void fillCostbookingSingleBudget(WebDriver driver, String testCaseName, String budgetName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.fillCostbookingSingleBudget(driver, testCaseName, budgetName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCostbookingSingleBudget " + e, e);
		}

	}

	public static void clickSaveRequisitionSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickSaveRequisitionSummary(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSaveRequisitionSummary " + e, e);
		}

	}

	public static boolean isCommentForItemAvailable(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isCommentForItemAvailable(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCommentForItemAvailable " + e, e);
		}
		return false;
	}

	public static boolean isEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isEditable(driver, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method isEditable " + e, e);
			return false;
		}

	}

	public static boolean isRowPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isRowPresent(driver, testCaseName, index);
		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method isrowPresent " + e, e);
			return false;
		}

	}

	public static boolean clickEditItemRequisitionindexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.clickEditItemRequisitionindexwise(driver, testCaseName, index);
		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method clickEditItemRequisitionindexwise " + e, e);
			return false;
		}
	}

	public static void clickDeliveryMultiOptionSplit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickDeliveryMultiOptionSplit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickDeliveryMultiOptionSplit " + e, e);
		}

	}

	public static void enterDeliverToNameInDeliverySplitIndexwise(WebDriver driver, String testCaseName, int index, String name) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.enterDeliverToNameInDeliverySplitIndexwise(driver, testCaseName, index, name);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method enterDeliverToNameInDeliverySplitIndexwise " + e, e);
		}

	}

	public static void increaseDeliverQunatityInDeliverySplitIndexwise(WebDriver driver, String testCaseName, int index, int qty) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.increaseDeliverQunatityInDeliverySplitIndexwise(driver, testCaseName, index, qty);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method increaseDeliverQunatityInDeliverySplitIndexwise " + e, e);
		}

	}

	public static void decreaseDeliverQunatityInDeliverySplitIndexwise(WebDriver driver, String testCaseName, int index, int qty) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.decreaseDeliverQunatityInDeliverySplitIndexwise(driver, testCaseName, index, qty);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method decreaseDeliverQunatityInDeliverySplitIndexwise " + e, e);
		}

	}

	public static void clickToAddADeliverySplitIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickToAddADeliverySplitIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToAddADeliverySplitIndexwise " + e, e);
		}

	}

	public static void clickToExpandItemDetailsIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickToExpandItemDetailsIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToAddADeliverySplitIndexwise " + e, e);
		}

	}

	public static String[] getApprovalWorkFlow(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
		return checkout.getApprovalWorkFlow(driver, testCaseName);
	}

	public static boolean isAssignedBuyerTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
		return checkout.isAssignedBuyerTextBoxPresent(driver, testCaseName);
	}

	public static boolean isRequiredByDateEmpty(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean isRequiredByDateE = false;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			isRequiredByDateE = checkout.isRequiredByDateEmpty(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isRequiredByDateEmpty " + e, e);
		}
		return isRequiredByDateE;
	}

	public static String fetchRequisitionName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fetchRequisitionName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchRequisitionName " + e, e);
		}
		return null;
	}

	public static void clickDeliveryEditRequisitionSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickDeliveryEditRequisitionSummary(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickDeliveryEditRequisitionSummary " + e, e);
		}
	}

	public static void clickMyAddressRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickMyAddressRadioButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickMyAddressRadioButton " + e, e);
		}
	}

	public static void clickToEnterNewAddressLink(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickToEnterNewAddressLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToEnterNewAddressLink " + e, e);
		}
	}

	public static void fillMyCustomDeliveryStreetAddress(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.fillMyCustomDeliveryStreetAddress(driver, testCaseName, CommonServices.getTestData(IConstantsData.SPECIAL_CHAR));
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMyCustomDeliveryStreetAddress " + e, e);
		}
	}

	public static void fillMyCustomDeliveryScriptedStreetAddress(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.fillMyCustomDeliveryStreetAddress(driver, testCaseName, "<script>alert('Address')</script>");
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMyCustomDeliveryStreetAddress " + e, e);
		}
	}

	public static void fillMyCustomDeliveryCountry(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.fillMyCustomDeliveryCountry(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMyCustomDeliveryCountry " + e, e);
		}
	}

	public static void fillMyCustomDeliveryCity(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.fillMyCustomDeliveryCity(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMyCustomDeliveryCity " + e, e);
		}
	}

	public static void fillMyCustomDeliveryAddressName(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.fillMyCustomDeliveryAddressName(driver, testCaseName, CommonServices.getTestData(IConstantsData.DELIVERY_NAME));
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMyCustomDeliveryAddressName " + e, e);
		}
	}

	public static void fillMyCustomDeliveryScriptedAddressName(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.fillMyCustomDeliveryAddressName(driver, testCaseName, "<script>alert('Name" + Helper.getRandomString(3) + "')</script>");
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMyCustomDeliveryAddressName " + e, e);
		}
	}

	public static boolean deleteReqItemInCart(WebDriver driver, String testCaseName, int index) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.deleteReqItemInCart(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method deleteReqItemInCart " + e, e);
		}
		return false;
	}

	public static boolean isCostAllocationTabVisible(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isCostAllocationTabVisible(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCostAllocationTabVisible " + e, e);
		}
		return false;
	}

	public static boolean isDeliveryTabVisible(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isDeliveryTabVisible(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDeliveryTabVisible " + e, e);
		}
		return false;
	}

	public static boolean isBillingTabVisible(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isBillingTabVisible(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isBillingTabVisible " + e, e);
		}
		return false;
	}

	public static boolean isEditRequistionSummaryVisible(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isEditRequistionSummaryVisible(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isEditRequistionSummaryVisible " + e, e);
		}
		return false;
	}

	public static boolean isRequisitionSummaryButtonVisible(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isRequisitionSummaryButtonVisible(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isRequisitionSummaryButtonVisible " + e, e);
		}
		return false;
	}

	public static void searchCategoryinGuidedItemPopup(WebDriver driver, String testCaseName, String category) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.searchCategoryinGuidedItemPopup(driver, testCaseName, category);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method searchCategoryinGuidedItemPopup " + e, e);
		}
	}

	public static void toAddNewReqItemInCart(WebDriver driver, String testCaseName, int index) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.toAddNewReqItemInCart(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toAddNewReqItemInCart " + e, e);
		}
	}

	public static void toSplitIntoMultipleCostCenter(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.toSplitIntoMultipleCostCenter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toSplitIntoMultipleCostCenter " + e, e);
		}
	}

	public static void clicktoAddCostSplitIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clicktoAddCostSplitIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clicktoAddCostSplitIndexwise " + e, e);
		}
	}

	public static void clicktoAddItemLevelCostSplitIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clicktoAddItemLevelCostSplitIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clicktoAddCostSplitIndexwise " + e, e);
		}
	}

	public static void selectCostCenter(WebDriver driver, String testCaseName, int index) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.selectCostCenter(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCostCenter " + e, e);
		}
	}

	public static void toIncreaseCostPercentageIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.toIncreaseCostPercentageIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toIncreaseCostPercentageIndexwise " + e, e);
		}
	}

	public static void toDecreaseCostPercentageIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.toDecreaseCostPercentageIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toDecreaseCostPercentageIndexwise " + e, e);
		}
	}

	public static boolean toSelectBillingCurrencyChoiceWise(WebDriver driver, String testCaseName, int index, String currency) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.toSelectBillingCurrencyChoiceWise(driver, testCaseName, index, currency);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toSelectBillingCurrencyChoiceWise " + e, e);
		}
		return false;
	}

	public static boolean isCurrencyWiseTotalLinkPresent(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isCurrencyWiseTotalLinkPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCurrencyWiseTotalLinkPresent " + e, e);
		}
		return false;
	}

	public static boolean isItemNumberPresentInEachGrid(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isItemNumberPresentInEachGrid(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemNumberPresentInEachGrid " + e, e);
		}
		return false;
	}

	public static boolean isItemNameSupplierNamePresentInEachGrid(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isItemNameSupplierNamePresentInEachGrid(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemNameSupplierNamePresentInEachGrid " + e, e);
		}
		return false;
	}

	public static boolean isItemUnitPricePresentInEachGrid(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isItemUnitPricePresentInEachGrid(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemUnitPricePresentInEachGrid " + e, e);
		}
		return false;
	}

	public static boolean isItemQtyPresentInEachGrid(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isItemQtyPresentInEachGrid(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemQtyPresentInEachGrid " + e, e);
		}
		return false;
	}

	public static boolean isMyAddressPresentInDeliveryTab(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isMyAddressPresentInDeliveryTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isMyAddressPresentInDeliveryTab " + e, e);
		}
		return false;
	}

	public static boolean isCurrencyWiseAmmountPresent(WebDriver driver, String testCaseName, int index) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isCurrencyWiseAmmountPresent(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCurrencyWiseAmmountPresent " + e, e);
		}
		return false;
	}

	public static void clickOnCurrencyWiseTotalLink(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickOnCurrencyWiseTotalLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCurrencyWiseTotalLink " + e, e);
		}
	}

	public static boolean isTotalAmmountPresent(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isTotalAmmountPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isTotalAmmountPresent " + e, e);
		}
		return false;
	}

	public static boolean deleteItemInCartIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		Boolean requirement = false;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			requirement = checkout.deleteItemInCartIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method deleteItemInCartIndexwise " + e, e);
		}
		return requirement;
	}

	public static void toSelectProjectIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.toSelectProjectIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toSelectProjectIndexwise " + e, e);
		}
	}

	public static void toSelectBudgetIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.toSelectBudgetIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toSelectBudgetIndexwise " + e, e);
		}
	}

	public static boolean isCatLogItemDetailsPresent(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isCatLogItemDetailsPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCatLogItemDetailsPresent " + e, e);
		}
		return false;
	}

	public static void clickOnYesConfirmationLink(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickOnYesConfirmationLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnYesConfirmationLink " + e, e);
		}
	}

	public static boolean isGuidedItemDetailsPresent(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isGuidedItemDetailsPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isGuidedItemDetailsPresent " + e, e);
		}
		return false;
	}

	public static boolean isRequiredByDateMissingValueErrorPresent(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isRequiredByDateMissingValueErrorPresent(driver, testCaseName);
		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method isGuidedItemDetailsPresent " + e, e);
		}
		return false;
	}

	public static String getBillingCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getBillingCurrency(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getBillingCurrency " + e, e);
		}
		return null;
	}

	public static String getItemSubTotalrowise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getItemSubTotalrowise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemSubTotalrowise " + e, e);
		}
		return null;
	}

	public static String getPurchaseTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getPurchaseTotalPrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseTotalPrice " + e, e);
		}
		return null;
	}

	public static String getItemUnitCurrencyIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getItemUnitCurrencyIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemUnitCurrencyIndexwise " + e, e);
		}
		return null;
	}

	public static boolean isOptionCopyCostCenterInfoPresent(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isOptionCopyCostCenterInfoPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isOptionCopyCostCenterInfoPresent " + e, e);
		}
		return false;
	}

	public static boolean isCostBookingOptionPercentageSelected(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isCostBookingOptionPercentageSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCostBookingOptionPercentageSelected " + e, e);
		}
		return false;
	}

	public static boolean isCostBookingOptionQuantityPresent(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isCostBookingOptionQuantityPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCostBookingOptionQuantityPresent " + e, e);
		}
		return false;
	}

	public static void clickCopyCostBookingAtItemLevel(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickCopyCostBookingAtItemLevel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCopyCostBookingAtItemLevel " + e, e);
		}
	}

	public static void autoFillCostBookingAtItemLevel(WebDriver driver, String testCaseName, int index) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.autoFillCostBookingAtItemLevel(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method autoFillCostBookingAtItemLevel " + e, e);
		}
	}

	public static void clickItemLevelCostCenterSplitIndexWise(WebDriver driver, String testCaseName, int index) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickItemLevelCostCenterSplitIndexWise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickItemLevelCostCenterSplitIndexWise " + e, e);
		}
	}

	public static void clickToSaveItemSummaryRequisition(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickToSaveItemSummaryRequisition(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToSaveItemSummaryRequisition " + e, e);
		}
	}

	public static String getItemLevelCostCenterIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getItemLevelCostCenterIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemLevelCostCenterIndexwise " + e, e);
		}
		return null;
	}

	public static String getItemLevelProjectIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getItemLevelProjectIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemLevelProjectIndexwise " + e, e);
		}
		return null;
	}

	public static String getItemLevelBudgetIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getItemLevelBudgetIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemLevelBudgetIndexwise " + e, e);
		}
		return null;
	}

	public static String getHeaderLevelCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getHeaderLevelCostCenter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getHeaderLevelCostCenter " + e, e);
		}
		return null;
	}

	public static String getHeaderLevelBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getHeaderLevelBudget(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getHeaderLevelBudget " + e, e);
		}
		return null;
	}

	public static String getHeaderLevelProject(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getHeaderLevelProject(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getHeaderLevelProject " + e, e);
		}
		return null;
	}

	public static boolean compareItemLevelWithHeaderLevelDataWise(String item_level[], String header_level) throws ActionBotException
	{
		String data = item_level[0];
		int count = 0;
		boolean status = false;
		for (int i = 0; i < item_level.length; i++)
		{
			if (data.equals(item_level[i]))
				count++;
		}
		if (count < item_level.length)
		{
			if (header_level.equals("Multiple"))
				status = true;
		}
		else
		{
			if (count == item_level.length)
				if (header_level.equals(item_level[0]))
					status = true;
		}
		return status;
	}

	public static boolean isDeliveryInformationFromRequisitionSelected(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isDeliveryInformationFromRequisitionSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDeliveryInformationFromRequisitionSelected " + e, e);
		}
		return false;
	}

	public static boolean isDeliveryAddress_DeliverTo_RequiredByPresentInItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int count = 0;
		if (ActionBot.isElementDisplayed(driver, IPageRequisitionCheckOut.DELIVERY_SINGLE_SPLIT_DELIVER_TO))
			count++;
		if (ActionBot.isElementDisplayed(driver, IPageRequisitionCheckOut.DELIVERY_SINGLE_SPLIT_DELIVERY_ADDRESS))
			count++;
		if (ActionBot.isElementDisplayed(driver, IPageRequisitionCheckOut.DELIVERY_SINGLE_SPLIT_REQUIRED_DATE))
			count++;
		if (count == 3)
			return true;
		else
			return false;
	}

	public static String fetchCheckoutItemQuantity(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fetchCheckoutItemQuantity(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchCheckoutItemQuantity " + e, e);
		}
		return null;
	}

	public static String fetchBillingAddressFromHeader(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fetchBillingAddressFromHeader(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchBillingAddressFromHeader " + e, e);
		}
		return null;
	}

	public static void clickItemDescriptionLinkIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickItemDescriptionLinkIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickItemDescriptionLinkIndexwise " + e, e);
		}
	}

	public static void clickCloseItemDescriptionLinkIndexwise(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickCloseItemDescriptionLinkIndexwise(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCloseItemDescriptionLinkIndexwise " + e, e);
		}
	}

	public static void increaseCostAllocationPercentageInCostAllocSplitIndexwise(WebDriver driver, String testCaseName, int index, int qty) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.increaseCostAllocationPercentageInCostAllocSplitIndexwise(driver, testCaseName, index, qty);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method increaseCostAllocationPercentageInCostAllocSplitIndexwise " + e, e);
		}

	}

	public static void decreaseCostAllocationPercentageInCostAllocSplitIndexwise(WebDriver driver, String testCaseName, int index, int qty) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.decreaseCostAllocationPercentageInCostAllocSplitIndexwise(driver, testCaseName, index, qty);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method decreaseCostAllocationPercentageInCostAllocSplitIndexwise " + e, e);
		}

	}

	public static void fillBillingCompanyName(WebDriver driver, String testCaseName, String company) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.fillBillingCompanyName(driver, testCaseName, company);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBillingCompanyName " + e, e);
		}
	}

	public static void fillBillingBusinessUnitName(WebDriver driver, String testCaseName, String bu) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.fillBillingBusinessUnitName(driver, testCaseName, bu);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBillingBusinessUnitName " + e, e);
		}
	}

	public static void fillBillingLocationName(WebDriver driver, String testCaseName, String loc) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.fillBillingLocationName(driver, testCaseName, loc);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBillingLocationName " + e, e);
		}
	}

	public static void fillScriptedBillingLocationName(WebDriver driver, String testCaseName, String loc) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.fillScriptedBillingLocationName(driver, testCaseName, loc);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillScriptedBillingLocationName " + e, e);
		}
	}

	public static boolean isValidState(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isValidState(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isValidState " + e, e);
		}
		return false;
	}

	public static boolean isContractNumberPresent(WebDriver driver, String testCaseName) throws Exception
	{

		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isContractNumberPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isContractNumberPresent " + e, e);
		}
		return false;
	}

	public static boolean clickSaveFreeTextButton(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickSaveFreeTextButton(driver, testCaseName);
			return true;
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSaveFreeTextButton " + e, e);
			return false;
		}
	}

	public static boolean clickCancelFreeTextButton(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickCancelFreeTextButton(driver, testCaseName);
			return true;
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCancelFreeTextButton " + e, e);
			return false;
		}
	}

	public static String getQuantityFreeTextItemValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getQuantityFreeTextItemValue(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getQuantityFreeTextItemValue " + e, e);
		}
		return null;
	}

	public static String getDescriptionFreeTextItemValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getDescriptionFreeTextItemValue(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDescriptionFreeTextItemValue " + e, e);
		}
		return null;
	}

	public static String getPriceFreeTextItemValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getPriceFreeTextItemValue(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPriceFreeTextItemValue " + e, e);
		}
		return null;
	}

	public static void fillCurrencyForItemDetailPopup(WebDriver driver, String testCaseName, String currency) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.fillCurrencyForItemDetailPopup(driver, testCaseName, currency);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCurrencyForItemDetailPopup " + e, e);
		}
	}

	public static boolean isItemWithQuotedBySupplierSourcingStatusPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean requirement = false;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			requirement = checkout.isItemWithQuotedBySupplierSourcingStatusPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemWithQuotedBySupplierSourcingStatusPresent " + e, e);
		}
		return requirement;
	}

	public static boolean isSubmitionSuccessfullyDone(WebDriver driver, String testCaseName) throws ActionBotException
	{

		Boolean status = false;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			status = checkout.isSubmitionSuccessfullyDone(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSubmitionSuccessfullyDone " + e, e);
		}
		return status;
	}

	public static boolean verifyFinalAmountGenerated_COA(WebDriver driver, String testCaseName, CostBookingAndAccountingItemSummaryCOA costbookigitemsummary)
		throws ActionBotException, NumberFormatException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.verifyFinalAmountGenerated_COA(driver, testCaseName, costbookigitemsummary);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method verifyFinalAmountGenerated_COA " + e, e);
		}
		catch (Exception e)
		{
			logger.error("Exception in method verifyFinalAmountGenerated_COA " + e, e);
		}
		return false;
	}

	public static void clickOnCostBookingItemEdit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickOnCostBookingItemEdit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCostBookingItemEdit " + e, e);
		}
	}

	public static void clickButtonKeepAllItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickButtonKeepAllItems(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickButtonKeepAllItems " + e, e);
		}
	}

	public static void clickLinkDeleteAllItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickLinkDeleteAllItems(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickLinkDeleteAllItems " + e, e);
		}
	}

	public static boolean verifyErrorMessageOnHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.isHeaderErrorMsgPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCostBookingItemEdit " + e, e);
		}
		return false;
	}

	public static String fillSharePointURL_EForm(WebDriver driver, String testCaseName, String sharePointURL) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fillSharePointURL_EForm(driver, testCaseName, sharePointURL);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSharePointURL_EForm " + e, e);
		}
		return null;
	}

	public static String fillDeliveryInstructions_EForm(WebDriver driver, String testCaseName, String deliveryInstructions) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fillDeliveryInstructions_EForm(driver, testCaseName, deliveryInstructions);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDeliveryInstructions_EForm " + e, e);
		}
		return null;
	}

	public static String fillInternalDeliveryLocation_EForm(WebDriver driver, String testCaseName, String fillInternalDeliveryLocation) throws Exception
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fillInternalDeliveryLocation_EForm(driver, testCaseName, fillInternalDeliveryLocation);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillInternalDeliveryLocation_EForm " + e, e);
		}
		return null;
	}

	public static String fillEstimatedFreight_EForm(WebDriver driver, String testCaseName, String estimatedFreight) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fillEstimatedFreight_EForm(driver, testCaseName, estimatedFreight);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillEstimatedFreight_EForm " + e, e);
		}
		return null;
	}

	public static String fillPurchasingInstructions_EForm(WebDriver driver, String testCaseName, String purchasingInstructions) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.fillPurchasingInstructions_EForm(driver, testCaseName, purchasingInstructions);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPurchasingInstructions_EForm " + e, e);
		}
		return null;
	}

	public static boolean checkForExternalAgent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.checkForExternalAgent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkForExternalAgent " + e, e);
		}
		return false;
	}

	//client specific- QTS
	public static String fillIsPurchaseBudgeted(WebDriver driver, String testCaseName, String isThePurchaseBudgeted) throws ActionBotException
	{

		String reqName = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			reqName = checkout.fillIsPurchaseBudgeted(driver, testCaseName, isThePurchaseBudgeted);
			if (reqName.equalsIgnoreCase(isThePurchaseBudgeted))
			{
				return reqName;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method isThePurchaseBudgeted " + e, e);
		}
		return null;
	}

	//client specific- QTS
	public static String fillWhatIsPurchasedAndWhy(WebDriver driver, String testCaseName, String whatIsPurchasedandWHY) throws ActionBotException
	{

		String reqName = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			reqName = checkout.fillWhatIsPurchasedAndWhy(driver, testCaseName, whatIsPurchasedandWHY);
			if (reqName.equalsIgnoreCase(whatIsPurchasedandWHY))
			{
				return reqName;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method fillWhatIsPurchasedAndWhy " + e, e);
		}
		return null;
	}

	//client specific- QTS
	public static String fillIsPurchasedBefore(WebDriver driver, String testCaseName, String isPurchasedBefore) throws ActionBotException
	{

		String reqName = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			reqName = checkout.fillIsPurchasedBefore(driver, testCaseName, isPurchasedBefore);
			if (reqName.equalsIgnoreCase(isPurchasedBefore))
			{
				return reqName;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method fillIsPurchasedBefore " + e, e);
		}
		return null;
	}

	//client specific- QTS
	public static String fillIsPriceIncrease(WebDriver driver, String testCaseName, String isPriceIncrease) throws ActionBotException
	{

		String reqName = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			reqName = checkout.fillIsPriceIncrease(driver, testCaseName, isPriceIncrease);
			if (reqName.equalsIgnoreCase(isPriceIncrease))
			{
				return reqName;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method fillIsPriceIncrease " + e, e);
		}
		return null;
	}

	//client specific- QTS
	public static String fillIsAdditionalSavings(WebDriver driver, String testCaseName, String isAdditionalSavings) throws ActionBotException
	{

		String reqName = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			reqName = checkout.fillIsAdditionalSavings(driver, testCaseName, isAdditionalSavings);
			if (reqName.equalsIgnoreCase(isAdditionalSavings))
			{
				return reqName;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method fillIsAdditionalSavings " + e, e);
		}
		return null;
	}

	//client specific- QTS
	public static String fillSavingsAchieved(WebDriver driver, String testCaseName, String SavingsAchieved) throws ActionBotException
	{

		String reqName = null;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			reqName = checkout.fillSavingsAchieved(driver, testCaseName, SavingsAchieved);
			if (reqName.equalsIgnoreCase(SavingsAchieved))
			{
				return reqName;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method fillSavingsAchieved " + e, e);
		}
		return null;
	}

	/**
	 * @author omkar.jagdale
	 *         client specific method to select the Capital request asset
	 */

	public static int selectCapitalRequestAsset(WebDriver driver, String testCaseName)
	{

		try
		{
			List<WebElement> elements = ActionBot.findElements(driver, By.xpath("(.//*[contains(@class,'dfCFValue')])"));

			for (int index = 1; index <= elements.size(); index++)
			{
				if (!ActionBot.findElement(driver, By.xpath("(.//*[contains(@class,'dfCFValue')])[" + index + "]")).isSelected())
				{
					ActionBot.findElement(driver, By.xpath("(.//*[contains(@class,'dfCFValue')])[" + index + "]")).click();
					return index;
				}
			}
		}
		catch (Exception e)
		{
			logger.error("error while selecting capital request asset " + e, e);
		}

		return 0;
	}

	/**
	 * @author omkar.jagdale
	 *         client specific method to verify whether Capital request asset selected or not
	 */
	public static boolean verifyCapitalRequestAsset(WebDriver driver, String testCaseName, int index)
	{

		try
		{
			if (ActionBot.isElementPresent(driver, By.xpath("(.//*[contains(@class,'dfCFValue')])[" + index + "]")))
			{
				return ActionBot.isElementSelected(driver, By.xpath("(.//*[contains(@class,'dfCFValue')])[" + index + "]"));
			}
		}
		catch (Exception e)
		{
			logger.error("error while checking whether element is selected or not " + e, e);
		}

		return false;
	}

	/*
	 * globel error msg
	 */

	public static String getGlobelErrorMsg(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkOut = FactoryPage.getInstanceOf(IPageRequisitionCheckOutImpl.class);
		return checkOut.getGlobelErrorMsg(driver, testCaseName);
	}

	/*
	 * pcard error msg
	 */
	public static String getPcardErrorMsg(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkOut = FactoryPage.getInstanceOf(IPageRequisitionCheckOutImpl.class);
		return checkOut.getPcardErrorMsg(driver, testCaseName);
	}

	/*
	 * pcard transaction count
	 */
	public static String getPcardTransactionCount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkOut = FactoryPage.getInstanceOf(IPageRequisitionCheckOutImpl.class);
		return checkOut.getPcardTransactionCount(driver, testCaseName);
	}

	/*
	 * @author : bhakti.sawant
	 * method to add attachment to requisition
	 */
	public static String addAttachment(WebDriver driver, String testCaseName, String attactmentFile) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkOut = FactoryPage.getInstanceOf(IPageRequisitionCheckOutImpl.class);
		return checkOut.addAttachment(driver, testCaseName, attactmentFile);

	}

	/*
	 * @author : bhakti.sawant
	 * method to delete requisition level attachment
	 */
	public static String deleteAttachment(WebDriver driver, String testCaseName, String attactmentFile) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkOut = FactoryPage.getInstanceOf(IPageRequisitionCheckOutImpl.class);
		return checkOut.deleteAttachment(driver, testCaseName, attactmentFile);

	}

	/*
	 * @author : bhakti.sawant
	 * method to delete item level attachment
	 */
	public static String deleteItemSummaryAttachment(WebDriver driver, String testCaseName, String attactmentFile) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkOut = FactoryPage.getInstanceOf(IPageRequisitionCheckOutImpl.class);
		return checkOut.deleteItemSummaryAttachment(driver, testCaseName, attactmentFile);

	}

	/**
	 * @author omkar.jagdale
	 *         method to get location from Organization Unit
	 */
	public static String getOULocation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getOULocation(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getOULocation " + e, e);
		}
		return null;
	}

	/**
	 * @author omkar.jagdale
	 *         method to get company from Organization Unit
	 */
	public static String getOUCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			return checkout.getOUCompany(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getOUCompany " + e, e);
		}
		return null;
	}

	/*
	 * @author bhakti.sawant
	 * method to check error message present or not for following fields in Requisition Summary pop up:
	 * fields:
	 * 1. Company
	 * 2. Business Unit
	 * 3. Location
	 * 4. Cost Center
	 * 5. Project
	 * 6. Budget
	 */
	public static boolean isErrorMessagePresentInRequisitionSummaryPopUp(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		boolean flag = false;
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			flag = checkout.isErrorMessagePresentInRequisitionSummaryPopUp(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isErrorMessagePresentInRequisitionSummaryPopUp " + e, e);
		}
		return flag;
	}

	public static void clickCheckboxAllItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionCheckOut checkout = FactoryPage.getInstanceOfIPageRequisitionCheckOut();
			checkout.clickCheckboxAllItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCheckboxAllItems " + e, e);
		}

	}

	/**
	 * @author omkar.jagdale
	 *         method to get Id's of all the items present at requisition checkout page.
	 * 
	 */
	public static List<String> getListOfItemIdsOfCheckoutPageItem(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkOut = FactoryPage.getInstanceOf(IPageRequisitionCheckOutImpl.class);
		return checkOut.getListOfItemIdsOfCheckoutPageItem(driver, testCaseName);

	}

	/**
	 * @author omkar.jagdale
	 *         method to get item id by name at requisition checkout page.
	 * 
	 */
	public static String getItemIdByNameAtRequisitionCheckout(WebDriver driver, String testCaseName, String itemName) throws ActionBotException, FactoryMethodException
	{
		IPageRequisitionCheckOut checkOut = FactoryPage.getInstanceOf(IPageRequisitionCheckOutImpl.class);
		return checkOut.getItemIdByNameAtRequisitionCheckout(driver, testCaseName, itemName);

	}

	/**
	 * @author Rohini Shinge
	 * 
	 * 
	 */
	public static void selectItemIDwise(WebDriver driver, String testCaseName, String itemID) throws ActionBotException, FactoryMethodException
	{

		IPageRequisitionCheckOut checkOut = FactoryPage.getInstanceOf(IPageRequisitionCheckOutImpl.class);
		checkOut.selectItemIDwise(driver, testCaseName, itemID);

	}

}