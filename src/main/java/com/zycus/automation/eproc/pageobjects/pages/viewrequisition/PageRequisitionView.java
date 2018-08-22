/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.viewrequisition;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.COAMayerBrownDataBO;
import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.IPageMyRequisition;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 */
public class PageRequisitionView
{
	static Logger logger = Logger.getLogger(PageRequisitionView.class);

	public static boolean isPeformSectionLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.isPeformSectionLabelPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPeformSectionLabelPresent " + e, e);
		}
		return false;
	}

	public static boolean isPeformFieldLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.isPeformFieldLabelPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPeformFieldLabelPresent " + e, e);
		}
		return false;
	}

	public static String getNameOfPeformSectionLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getNameOfPeformSectionLabel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getNameOfPeformSectionLabel " + e, e);
		}
		return null;
	}

	public static String fillModalAssignBuyerField(WebDriver driver, String testCaseName, String assignBuyer) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.fillModalAssignBuyerField(driver, testCaseName, assignBuyer);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillModalAssignBuyerField " + e, e);
		}
		return assignBuyer;

	}

	public static String getNameOfPeformFieldLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getNameOfPeformFieldLabel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getNameOfPeformFieldLabel " + e, e);
		}
		return null;
	}

	public static String getNameOfPeformFieldValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getNameOfPeformFieldValue(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getNameOfPeformFieldValue " + e, e);
		}
		return null;
	}

	public static void clickOnExpandDelivery(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnExpandDelivery(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnExpandDelivery " + e, e);
		}
	}

	public static void clickOnChangeBuyerLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnChangeBuyerLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnChangeBuyerLink " + e, e);
		}
	}

	public static void clickOnAuditTrail(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnAuditTrail(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAuditTrail " + e, e);
		}
	}

	public static void clickOnExpandAccounting(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnExpandAccounting(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnExpandAccounting " + e, e);
		}
	}

	public static void clickOnExpandWorkFlow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnExpandWorkFlow(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnExpandWorkFlow " + e, e);
		}
	}

	public static String getDeliverTo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getDeliverTo(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliverTo " + e, e);
		}
		return null;
	}

	public static String getDeliveryDate(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getDeliveryDate(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryDate " + e, e);
		}
		return null;
	}

	public static int getDeliveryQuantity(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getDeliveryQuantity(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryQuantity " + e, e);
		}
		return 0;
	}

	public static String getShipToAddress(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getShipToAddress(driver, testCaseName, itemId, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getShipToAddress " + e, e);
		}
		return null;
	}

	public static void clickOnExpandCostBooking(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnExpandCostBooking(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnExpandCostBooking " + e, e);
		}
	}

	public static void clickOnAssignBuyerlink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnAssignBuyerlink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAssignBuyerlink " + e, e);
		}
	}

	public static void clickOnModalAssignBuyerSaveBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnModalAssignBuyerSaveBtn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnModalAssignBuyerSaveBtn " + e, e);
		}
	}

	public static void clickOnCancelAssignBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnCancelAssignBuyer(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelAssignBuyer " + e, e);
		}
	}

	public static void clickOnSaveAssignBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnSaveAssignBuyer(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveAssignBuyer " + e, e);
		}
	}

	public static String getCostCenterForItemLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getCostCenterForItemLevelCCSplit(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostCenterForItemLevelCCSplit " + e, e);
		}
		return null;
	}

	public static String getBudgetForItemLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getBudgetForItemLevelCCSplit(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getBudgetForItemLevelCCSplit " + e, e);
		}
		return null;
	}

	public static String getProjectForItemLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getProjectForItemLevelCCSplit(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getProjectForItemLevelCCSplit " + e, e);
		}
		return null;
	}

	public static String getPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getPrice(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPrice " + e, e);
		}
		return null;
	}

	public static String getRequisitionNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getRequisitionNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequisitionNo " + e, e);
		}
		return null;
	}

	public static String getRequisitionName(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getRequisitionName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequisitionName " + e, e);
		}
		return null;
	}

	public static boolean getUrgRequirement(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getUrgRequirement(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getUrgRequirement " + e, e);
		}
		return false;
	}

	public static String getCreatedBy(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getCreatedBy(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCreatedBy " + e, e);
		}
		return null;
	}

	public static String getSettlementVia(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getSettlementVia(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSettlementVia " + e, e);
		}
		return null;
	}

	public static String getReasonForOrdering(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getReasonForOrdering(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReasonForOrdering " + e, e);
		}
		return null;
	}

	public static String getCommentsForSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getCommentsForSupplier(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCommentsForSupplier " + e, e);
		}
		return null;
	}

	public static String getPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getPurchaseType(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseType " + e, e);
		}
		return null;
	}

	public static String getStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getStatus(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getStatus " + e, e);
		}
		return null;
	}

	public static boolean getRetrospectivePurchase(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getRetrospectivePurchase(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPrice " + e, e);
		}
		return false;
	}

	public static boolean isBudgetDisplayedInsideCostBooking(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.isBudgetDisplayedInsideCostBooking(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isBudgetDisplayedInsideCostBooking " + e, e);
		}
		return false;
	}

	public static String getItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getItemName(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemName " + e, e);
		}
		return null;
	}

	public static String getItemUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getItemUnitPrice(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemUnitPrice " + e, e);
		}
		return null;
	}

	public static int getItemQuantity(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getItemQuantity(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemQuantity " + e, e);
		}
		return 0;
	}

	public static String getItemTotalPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getItemTotalPrice(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemTotalPrice " + e, e);
		}
		return null;
	}

	public static String getCostCenterForHeaderLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getCostCenterForHeaderLevelCCSplit(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostCenterForHeaderLevelCCSplit " + e, e);
		}
		return null;
	}

	public static String getBudgetForHeaderLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getBudgetForHeaderLevelCCSplit(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getBudgetForHeaderLevelCCSplit " + e, e);
		}
		return null;
	}

	public static String getProjectForHeaderLevelCCSplit(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getProjectForHeaderLevelCCSplit(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getProjectForHeaderLevelCCSplit " + e, e);
		}
		return null;
	}

	public static void clickOnAddApproverButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnAddApproverButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddApproverButton " + e, e);
		}
	}

	public static void clickOnSubmitForApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnSubmitForApproval(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSubmitForApproval " + e, e);
		}
	}

	public static String getAddedApproverNameFromWorkflow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getAddedApproverNameFromWorkflow(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAddedApproverNameFromWorkflow " + e, e);
		}
		return null;
	}

	public static String getAddedApproverExtraInfoFromWorkflow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getAddedApproverExtraInfoFromWorkflow(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAddedApproverExtraInfoFromWorkflow " + e, e);
		}
		return null;
	}

	public static boolean isSubmitForApprovalButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException

	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.isSubmitForApprovalButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSubmitForApprovalButtonPresent " + e, e);
		}
		return false;
	}

	public static void clickOnRemoveFirstAddedApprover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnRemoveFirstAddedApprover(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRemoveFirstAddedApprover " + e, e);
		}
	}

	public static String getAuditTrailAction(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getAuditTrailAction(driver, testCaseName, rowNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAuditTrailAction " + e, e);
		}
		return null;
	}

	public static String getAuditTrailActor(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getAuditTrailActor(driver, testCaseName, rowNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAuditTrailActor " + e, e);
		}
		return null;
	}

	public static String getAuditTrailSharedWith(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getAuditTrailSharedWith(driver, testCaseName, rowNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAuditTrailSharedWith " + e, e);
		}
		return null;
	}

	public static String getAuditTrailRole(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getAuditTrailRole(driver, testCaseName, rowNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAuditTrailRole " + e, e);
		}
		return null;
	}

	public static String getAuditTrailDateTime(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getAuditTrailDateTime(driver, testCaseName, rowNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAuditTrailDateTime " + e, e);
		}
		return null;
	}

	public static String getAuditTrailVersion(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getAuditTrailVersion(driver, testCaseName, rowNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAuditTrailVersion " + e, e);
		}
		return null;
	}

	public static String getAssignBuyerField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getAssignBuyerField(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAssignBuyerField " + e, e);
		}
		return null;
	}

	public static String getAuditTrailMessage(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getAuditTrailMessage(driver, testCaseName, rowNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAuditTrailMessage " + e, e);
		}
		return null;
	}

	public static String fillAssignBuyerField(WebDriver driver, String testCaseName, String assignbuyer) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.fillAssignBuyerField(driver, testCaseName, assignbuyer);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAssignBuyerField " + e, e);
		}
		return assignbuyer;

	}

	public static void clickOnModifyRequisitionLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnModifyRequisitionLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnModifyRequisitionLink " + e, e);
		}
	}

	public static void clickOnRemoveAssignBuyerbtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnRemoveAssignBuyerbtn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRemoveAssignBuyerbtn " + e, e);
		}
	}

	public static void clickOnItemDetailsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnItemDetailsLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemDetailsLink " + e, e);
		}
	}

	public static void clickOnItemDetailsLinkIndewise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnItemDetailsLinkIndewise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemDetailsLinkIndewise " + e, e);
		}
	}

	public static void clickOnActionsReqViewOrderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnActionsReqViewOrderTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnActionsReqViewOrderTab " + e, e);
		}

	}

	public static void clickOnRequestAdditionalItemActionsReqViewOrderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnRequestAdditionalItemActionsReqViewOrderTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRequestAdditionalItemActionsReqViewOrderTab " + e, e);
		}

	}

	public static String getSingleCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getSingleCostCenter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSingleCostCenter " + e, e);
		}
		return null;
	}

	public static void clickOnAuditTrailVersion(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnAuditTrailVersion(driver, testCaseName, rowNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAuditTrailVersion " + e, e);
		}
	}

	public static boolean isChangeApproverPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.isChangeApproverPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isChangeApproverPresent " + e, e);
		}
		return false;
	}

	public static void clickOnOrderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnOrderTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnOrderTab " + e, e);
		}

	}

	public static String getPOStatusOnOrderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getPOStatusOnOrderTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPOStatusOnOrderTab " + e, e);
		}
		return null;
	}

	public static String getLabelValueOfAssignBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getLabelValueOfAssignBuyer(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getLabelValueOfAssignBuyer " + e, e);
		}
		return null;
	}

	public static void clickOnAssignSingleBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnAssignSingleBuyer(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAssignSingleBuyer " + e, e);
		}
	}

	public static void clickOnAssignGroupOfBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnAssignGroupOfBuyer(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAssignGroupOfBuyer " + e, e);
		}
	}

	public static String fillAssignedBuyerGroupName(WebDriver driver, String testCaseName, String assignedBuyerGroupName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.fillAssignedBuyerGroupName(driver, testCaseName, assignedBuyerGroupName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAssignedBuyerGroupName " + e, e);
		}
		return null;
	}

	public static void clickOnRequisitionTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnRequisitionTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRequisitionTab " + e, e);
		}
	}

	public static String getItemStatus(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getItemStatus(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemStatus " + e, e);
		}
		return null;
	}

	public static void clickOnParentRequisitionLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnParentRequisitionLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnParentRequisitionLink " + e, e);
		}

	}

	public static void clickOnClearFilterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnClearFilterLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnClearFilterLink " + e, e);
		}
	}

	public static String getRequesterInWorkflowNode(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getRequesterInWorkflowNode(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequesterInWorkflowNode " + e, e);
		}
		return null;
	}

	public static void clickOnSuppliersTabInItemDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnSuppliersTabInItemDetails(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSuppliersTabInItemDetails " + e, e);
		}
	}

	public static String getSuggestedSupplierNameInItemDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getSuggestedSupplierNameInItemDetails(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSuggestedSupplierNameInItemDetails " + e, e);
		}
		return null;
	}

	public static boolean isSuggestedSupplierNamePresentInItemDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.isSuggestedSupplierNamePresentInItemDetails(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSuggestedSupplierNamePresentInItemDetails " + e, e);
		}
		return false;
	}

	public static void clickOnCancelItemDetailsModal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnCancelItemDetailsModal(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelItemDetailsModal " + e, e);
		}

	}

	public static boolean isAssetCodePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.isAssetCodePresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAssetCodePresent " + e, e);
		}
		return false;
	}

	public static String getAssetCode(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getAssetCode(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAssetCode " + e, e);
		}
		return null;
	}

	public static void clickOnActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnActionsLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnActionsLink " + e, e);
		}
	}

	public static void clickOnCopyActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnCopyActionsLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCopyActionsLink " + e, e);
		}
	}

	public static void clickOnItemName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnItemName(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemName " + e, e);
		}
	}

	public static List<String> getMultipleBuyerNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getMultipleBuyerNames(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getMultipleBuyerNames " + e, e);
		}
		return null;
	}

	public static String getCostCenterLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getCostCenterLabel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCostCenterLabel " + e, e);
		}
		return null;
	}

	public static String getGLAccountLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getGLAccountLabel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getGLAccountLabel " + e, e);
		}
		return null;
	}

	public static String getGLAccountTypeLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getGLAccountTypeLabel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getGLAccountTypeLabel " + e, e);
		}
		return null;
	}

	public static boolean isRequisitionNoLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.isRequisitionNoLabelPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isRequisitionNoLabelPresent " + e, e);
		}
		return false;

	}

	public static String get_BU_Indexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.get_BU_Indexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method get_BU_Indexwise " + e, e);
		}
		return null;
	}

	public static String get_BusinessLocation_Indexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.get_BusinessLocation_Indexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method get_BusinessLocation_Indexwise " + e, e);
		}
		return null;
	}

	public static boolean clickOnRemindApproverLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.clickOnRemindApproverLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRemindApproverLink " + e, e);
		}
		return false;
	}

	public static void clickOnGoBackLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnGoBackLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnGoBackLink " + e, e);
		}
	}

	public static boolean isItemBlockOpen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.isItemBlockOpen(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isItemBlockOpen " + e, e);
		}
		return false;
	}

	public static boolean isDeliveryAssetTagBlockOpen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.isDeliveryAssetTagBlockOpen(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDeliveryAssetTagBlockOpen " + e, e);
		}
		return false;
	}

	public static boolean isCostBookingBlockOpen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.isCostBookingBlockOpen(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCostBookingBlockOpen " + e, e);
		}
		return false;
	}

	public static boolean isAccountingBlockOpen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.isAccountingBlockOpen(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAccountingBlockOpen " + e, e);
		}
		return false;
	}

	public static boolean isWorkflowBlockOpen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.isWorkflowBlockOpen(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isWorkflowBlockOpen " + e, e);
		}
		return false;
	}

	public static void clickItemDescriptionLinkIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickItemDescriptionLinkIndexwise(driver, testCaseName, index);
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
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickCloseItemDescriptionLinkIndexwise(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCloseItemDescriptionLinkIndexwise " + e, e);
		}
	}

	public static boolean isBuyerReturnCommentPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.isBuyerReturnCommentPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isBuyerReturnCommentPresent " + e, e);
		}
		return false;
	}

	// ItemSummary Specific to MayerBrown Tenant
	public static List<COAMayerBrownDataBO> getCOAMayerBrownData(int split, WebDriver driver, String testCaseName)
	{
		List<COAMayerBrownDataBO> coaDataList = new ArrayList<COAMayerBrownDataBO>();
		try
		{
			for (int i = 0; i < split; i++)
			{
				COAMayerBrownDataBO coaData = new COAMayerBrownDataBO();

				coaData.setBookCostTo(ActionBot.getTextWithInElement(driver, ActionBot.findElements(driver, IPageRequisitionView.BOOK_COST_TO).get(i)));
				coaData.setMatter(ActionBot.getTextWithInElement(driver, ActionBot.findElements(driver, IPageRequisitionView.MATTER).get(i)));
				// coaData.setAmount(ActionBot.getTextWithInElement(driver,
				// ActionBot.findElements(driver,
				// IPageRequisitionView.AMOUNT_ITEM_SUMMARY_MAYER).get(i)));
				coaData.setClient(ActionBot.getTextWithInElement(driver, ActionBot.findElements(driver, IPageRequisitionView.CLIENT).get(i)));
				coaData.setGlAccount(ActionBot.getTextWithInElement(driver, ActionBot.findElements(driver, IPageRequisitionView.GL_ACCOUNT_ITEM_SUMMARY_MAYER_BROWN).get(i)));
				coaData.setEmpTimekeeper(ActionBot.getTextWithInElement(driver, ActionBot.findElements(driver, IPageRequisitionView.EMPLOYEE_TIMEKEEPER).get(i)));
				coaData.setOffice(ActionBot.getTextWithInElement(driver, ActionBot.findElements(driver, IPageRequisitionView.OFFICE).get(i)));
				coaData.setCostDisburseMentCode(ActionBot.getTextWithInElement(driver, ActionBot.findElements(driver, IPageRequisitionView.OFFICE).get(i)));
				coaData.setDepartment(ActionBot.getTextWithInElement(driver, ActionBot.findElements(driver, IPageRequisitionView.DEPARTMENT).get(i)));
				coaData.setProfitCenter(ActionBot.getTextWithInElement(driver, ActionBot.findElements(driver, IPageRequisitionView.PROFIT_CENTER).get(i)));
				coaData.setTransactionDate(ActionBot.getTextWithInElement(driver, ActionBot.findElements(driver, IPageRequisitionView.TRANSACTION_DATE).get(i)));
				coaData.setDescription(ActionBot.getTextWithInElement(driver, ActionBot.findElements(driver, IPageRequisitionView.DESCRIPTION_ITEM_SUMMARY_MAYER).get(i)));
				coaData.setPercentage(ActionBot.getTextWithInElement(driver, ActionBot.findElements(driver, IPageRequisitionView.PERCENTAGE_ITEM_SUMMARY_MAYER).get(i)));
				// coaData.setQuantity(ActionBot.getTextWithInElement(driver,
				// ActionBot.findElements(driver,
				// IPageRequisitionView.QUANTITY_ITEM_SUMMARY_MAYER).get(i)));
				// coaData.setAmount(ActionBot.getTextWithInElement(driver,
				// ActionBot.findElements(driver,
				// IPageRequisitionView.AMOUNT_ITEM_SUMMARY_MAYER).get(i)));
				coaData.setFinalAmount(ActionBot.getTextWithInElement(driver, ActionBot.findElements(driver, IPageRequisitionView.TOTAL_AMOUNT_ITEM_SUMMARY_MAYER).get(i)));

				coaDataList.add(coaData);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return coaDataList;
	}

	public static boolean clickOnViewCoaButton(WebDriver driver, String testCaseName)
	{
		boolean flag = false;
		try
		{
			ActionBot.click(driver, IPageMyRequisition.VIEW_COMMENTS);
			flag = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public static boolean checkPagination(WebDriver driver, String testCaseName, int noOfItem, boolean clickPagination, UI_Elements gridItemSummary) throws ActionBotException
	{
		boolean flag = false;
		try
		{
			List<WebElement> itemElements = ActionBot.findElements(driver, IPageMyRequisition.GRID_ITEM_SUMMARY_MAYER);
			int itemCount = itemElements.size();
			if (itemCount == noOfItem)
			{
				flag = true;
			}
			if (clickPagination)
			{
				if (ActionBot.findElements(driver, IPageMyRequisition.GRID_ITEM_SUMMARY_PAGINATION).size() > 0)
				{
					ActionBot.click(driver, IPageMyRequisition.GRID_ITEM_SUMMARY_PAGINATION);
				}
				else
				{
					flag = false;
				}
			}
		}
		catch (Exception e)

		{
			e.printStackTrace();
		}
		return flag;
	}

	public static void clickOnAuditTrailVersionOnReqView(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, IPageMyRequisition.AUDIT_TRAIL_VERSION_LINK);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void clickOnAuditTrailFirstVersionOnReqView(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, IPageMyRequisition.AUDIT_TRAIL_VERSION_ONE_LINK);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void clickOnAuditTrailSecondVersionOnReqView(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, IPageMyRequisition.AUDIT_TRAIL_VERSION_TWO_LINK);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void clickOnReqNumber(WebDriver driver, String testCaseName)
	{
		try
		{
			WebElement reqNo = driver.findElement(By.xpath("(//td[@class=' requisitionNo qtipFltrHdr preWraptxt']/a)[1]"));
			reqNo.click();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static int getItemQuantity(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getItemQuantity(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemQuantity " + e, e);
		}
		return 0;
	}
	
	/*
	 * author : bhakti sawant
	 */
	public static void clickOnItemSummaryViewItemWise(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			requisitionView.clickOnItemSummaryViewItemWise(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAuditTrailVersion " + e, e);
		}
	}

	/**
	 * @author omkar.jagdale
	 *         method to get required by date
	 */
	public static String getRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getRequiredByDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequiredByDate " + e, e);
		}
		return null;
	}

	/**
	 * @author omkar.jagdale
	 *         Method to get item name
	 */
	public static String getItem_Name(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getItem_Name(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItem_Name " + e, e);
		}
		return null;
	}

	/**
	 * @author omkar.jagdale
	 *         Method to get delivery address
	 */
	public static String getDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionView requisitionView = FactoryPage.getInstanceOf(IPageRequisitionViewImpl.class);
			return requisitionView.getDeliveryAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryAddress " + e, e);
		}
		return null;
	}

}
