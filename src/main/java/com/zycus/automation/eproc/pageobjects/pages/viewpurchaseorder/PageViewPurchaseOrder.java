/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.BillingRequisitionSummary;
import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageViewPurchaseOrder
{

	static Logger logger = Logger.getLogger(PageViewPurchaseOrder.class);

	public static void clickOnAccountingLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPurchaseOrder.clickOnAccountingLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAccountingLink " + e, e);
		}
	}

	public static void clickOnAmendAlertContinuePopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPurchaseOrder.clickOnAmendAlertContinuePopup(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAlertContinuePopup " + e, e);
		}
	}

	public static void clickOnAmendPo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPurchaseOrder.clickOnAmendPo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAmendPo " + e, e);
		}
	}

	public static void clickOnCancelPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPurchaseOrder.clickOnCancelPoLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelPoLink " + e, e);
		}
	}

	public static void clickOnCancelPoSubmitButtom(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPurchaseOrder.clickOnCancelPoSubmitButtom(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCancelPoSubmitButtom " + e, e);
		}
	}

	public static void clickOnCostingLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPurchaseOrder.clickOnCostingLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCostingLink " + e, e);
		}
	}

	public static void clickOnCreateInvoiceButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPurchaseOrder.clickOnCreateInvoiceLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCreateInvoiceLink " + e, e);
		}
	}

	public static void clickOnDropDownActions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPurchaseOrder.clickOnDropDownActions(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDropDownActions " + e, e);
		}
	}

	public static void clickOnLinkCreateReceipt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPurchaseOrder.clickOnLinkCreateReceipt(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnLinkCreateReceipt " + e, e);
		}
	}

	public static void clickOnLinkCreateReceiptUnderActionOnViewPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPurchaseOrder.clickOnLinkCreateReceiptUnderActionOnViewPO(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnLinkCreateReceipt " + e, e);
		}
	}

	public static void clickOnLinkEmailPo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPurchaseOrder.clickOnLinkEmailPo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnLinkEmailPo " + e, e);
		}
	}

	public static void clickOnPreviewPoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPurchaseOrder.clickOnPreviewPoLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPreviewPoLink " + e, e);
		}
	}

	public static void clickOnTermsAndNotesLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPurchaseOrder.clickOnTermsAndNotesLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnTermsAndNotesLink " + e, e);
		}
	}

	public static void clickOnViewPageReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPurchaseOrder.clickOnViewPageReqNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnViewPageReqNo " + e, e);
		}
	}

	public static void clickOnViewPageTabInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPurchaseOrder.clickOnViewPageTabInvoice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnViewPageTabInvoice " + e, e);
		}
	}

	public static String fillCancelPoCommentField(WebDriver driver, String testCaseName, String comments) throws ActionBotException
	{
		String cancelPocomments = null;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			cancelPocomments = viewPurchaseOrder.fillCancelPoCommentField(driver, testCaseName, comments);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCancelPoCommentField " + e, e);
		}
		return cancelPocomments;
	}

	public static String getCreateReceiptReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String CreateReceiptReqNo = null;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			CreateReceiptReqNo = viewPurchaseOrder.getCreateReceiptReqNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCreateReceiptReqNo " + e, e);
		}
		return CreateReceiptReqNo;
	}

	public static String getTotalItemLevelDiscount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String TotalItemLevelDiscount = null;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			TotalItemLevelDiscount = viewPurchaseOrder.getTotalItemLevelDiscount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTotalItemLevelDiscount " + e, e);
		}
		return TotalItemLevelDiscount;
	}

	public static String getGrossTotal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String GrossTotal = null;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			GrossTotal = viewPurchaseOrder.getGrossTotal(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getGrossTotal " + e, e);
		}
		return GrossTotal;
	}

	public static List<WebElement> getListOfItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			return viewPurchaseOrder.getListOfItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfItems " + e, e);
		}
		return null;
	}

	public static String getNewWindowReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String NewWindowViewPONo = null;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			NewWindowViewPONo = viewPurchaseOrder.getNewWindowReqNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getNewWindowReqNo " + e, e);
		}
		return NewWindowViewPONo;
	}

	public static Double getFreightTaxValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Double Freight = 0.0;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			Freight = viewPurchaseOrder.getFreightTaxValue(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFreightTaxValue " + e, e);
		}
		return Freight;
	}

	public static String getNewWindowViewPONo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String NewWindowViewPONo = null;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			NewWindowViewPONo = viewPurchaseOrder.getNewWindowViewPONo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getNewWindowViewPONo " + e, e);
		}
		return NewWindowViewPONo;
	}

	public static String getViewPageReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqNo = null;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			reqNo = viewPurchaseOrder.getViewPageReqNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getViePageReqNo " + e, e);
		}
		return reqNo;
	}

	public static String getTaxName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String taxName = null;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			taxName = viewPurchaseOrder.getTaxName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTaxName " + e, e);
		}
		return taxName;
	}

	public static String getTaxNameByIndex(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String taxName = null;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			taxName = viewPurchaseOrder.getTaxNameByIndex(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTaxName " + e, e);
		}
		return taxName;
	}

	public static String getPoEformName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String poEform = null;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			return poEform = viewPurchaseOrder.getPoEformName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPoEformName " + e, e);
		}
		return poEform;
	}

	public static String getSupplierCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String currency = null;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			currency = viewPurchaseOrder.getSupplierCurrency(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSupplierCurrency " + e, e);
		}
		return currency;
	}

	public static String getViewPONo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String viewPoNo = null;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			viewPoNo = viewPurchaseOrder.getViewPONo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getViewPONo " + e, e);
		}
		return viewPoNo;
	}

	public static String getViewPONotes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String getPoNotes = null;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			getPoNotes = viewPurchaseOrder.getViewPONotes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getViewPONotes " + e, e);
		}
		return getPoNotes;
	}

	public static String getTaxRate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String taxRate = null;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			taxRate = viewPurchaseOrder.getTaxRate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTaxRate " + e, e);
		}
		return taxRate;
	}

	public static String getTaxRateByIndex(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String taxRate = null;
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			taxRate = viewPurchaseOrder.getTaxRateByIndex(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTaxRate " + e, e);
		}
		return taxRate;
	}

	public static boolean isAccountingDetailsDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			return viewPurchaseOrder.isAccountingDetailsDisplayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAccountingDetailsDisplayed " + e, e);
		}
		return false;
	}

	public static boolean isCostingDetailsDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
			return viewPurchaseOrder.isCostingDetailsDisplayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCostingDetailsDisplayed " + e, e);
		}
		return false;
	}

	public static boolean isPrintPOOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isPrintPOOptionPresent(driver, testCaseName);
	}

	public static void clickOnAuditTrail(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnAuditTrail(driver, testCaseName);
	}

	public static boolean isAmmendmentStatusPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isAmmendmentStatusPresent(driver, testCaseName, index);
	}

	public static String getAmmendedmentStatus(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getAmmendedmentStatus(driver, testCaseName, index);
	}

	public static String getSupplierContractNo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getSupplierContractNo(driver, testCaseName);
	}

	public static String getRemindSupplierTitle(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getRemindSupplierTitle(driver, testCaseName);
	}

	public static String getSupplierContact(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getSupplierContact(driver, testCaseName);
	}

	public static String getItemContratNo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getItemContratNo(driver, testCaseName);
	}

	public static boolean isStatusAmmendmentReleased(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isStatusAmmendmentReleased(driver, testCaseName, index);
	}

	public static boolean isStatusOrderAmmended(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isStatusOrderAmmended(driver, testCaseName, index);
	}

	public static void clickOnPrintPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnPrintPO(driver, testCaseName);
	}

	public static boolean isDateNotAppliedSpecified(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isDateNotAppliedSpecified(driver, testCaseName);
	}

	public static boolean isReceiptPagePresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isReceiptPagePresent(driver, testCaseName);
	}

	public static boolean isInvoicePagePresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isInvoicePagePresent(driver, testCaseName);
	}

	public static boolean isPlannedDeliveryDatePresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isPlannedDeliveryDatePresent(driver, testCaseName);
	}

	public static String getItemName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getItemName(driver, testCaseName);
	}

	public static String getDeliveryDateUnderDeliverySection(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getDeliveryDateUnderDeliverySection(driver, testCaseName);
	}

	public static void clickOnItemName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnItemName(driver, testCaseName);
	}

	public static void clickOnDeliverySectionSubTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnDeliverySectionSubTab(driver, testCaseName);
	}

	public static String getItemTitle(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getItemTitle(driver, testCaseName);
	}

	public static void closeItemPopup(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.closeItemPopup(driver, testCaseName);
	}

	public static void clickOnEditItem(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnEditItem(driver, testCaseName);
	}

	public static String changeQuantityOfItem(WebDriver driver, String testCaseName, String quantity) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.changeQuantityOfItem(driver, testCaseName, quantity);
	}

	public static boolean isSpecificationNamePresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isSpecificationNamePresent(driver, testCaseName);
	}

	public static void clickOnSaveItemDetails(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnSaveItemDetails(driver, testCaseName);
	}

	public static void clickOnOrderTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnOrderTab(driver, testCaseName);
	}

	public static boolean isPOCancelledMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isPOCancelledMessagePresent(driver, testCaseName);
	}

	public static boolean isCancelPOOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isCancelPOOptionPresent(driver, testCaseName);
	}

	public static void clickOnClosePO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnClosePO(driver, testCaseName);
	}

	public static void clickOnCopyPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnCopyPO(driver, testCaseName);
	}

	public static boolean isWarningForClosePODisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isWarningForClosePODisplayed(driver, testCaseName);
	}

	public static boolean isPlannedDeliveryDateBlank(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isPlannedDeliveryDateBlank(driver, testCaseName);
	}

	public static boolean arePredefinedTaxesPresentOnViewPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.arePredefinedTaxesPresentOnViewPO(driver, testCaseName);
	}

	public static void clickOnFirstItemName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnFirstItemName(driver, testCaseName);
	}

	public static boolean isAddToCartOptionPresentOnItemDetails(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isAddToCartOptionPresentOnItemDetails(driver, testCaseName);
	}

	public static boolean isAddToFavoritesOptionPresentOnItemDetails(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isAddToFavoritesOptionPresentOnItemDetails(driver, testCaseName);
	}

	public static boolean isAddToBasketOptionPresentOnItemDetails(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isAddToBasketOptionPresentOnItemDetails(driver, testCaseName);
	}

	public static void clickOnFirstItemNameOnInvoice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnFirstItemNameOnInvoice(driver, testCaseName);
	}

	public static void clickOnLinkDownloadAsPDF(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnLinkDownloadAsPDF(driver, testCaseName);
	}

	public static boolean isPOContactEmailIDPresentInViewPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isPOContactEmailIDPresentInViewPO(driver, testCaseName);
	}

	public static boolean isProjectPresentInCostBookingSection(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isProjectPresentInCostBookingSection(driver, testCaseName);
	}

	public static boolean isGLAccountTypePresentProperly(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isGLAccountTypePresentProperly(driver, testCaseName);
	}

	public static String getPONo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getPONo(driver, testCaseName);
	}

	public static void clickOnRemoveApprover(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnRemoveApprover(driver, testCaseName);
	}

	public static void clickOnAddApprover(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnAddApprover(driver, testCaseName);
	}

	public static void clickOnTabReceipt(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnTabReceipt(driver, testCaseName);
	}

	public static void clickonLinkWorkflow(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickonLinkWorkflow(driver, testCaseName);
	}

	public static void clickOnItemCheckboxInInvoiceViewPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnItemCheckboxInInvoiceViewPO(driver, testCaseName);
	}

	public static String fillRemindSupplierToField(WebDriver driver, String testCaseName, String to) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.fillRemindSupplierToField(driver, testCaseName, to);
	}

	public static String getRemindSupplierAddedField(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getRemindSupplierAddedField(driver, testCaseName);
	}

	public static void clickOnChangeApprover(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnChangeApprover(driver, testCaseName);
	}

	public static String fillReplaceWithActor(WebDriver driver, String testCaseName, String actor) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.fillReplaceWithActor(driver, testCaseName, actor);
	}

	public static void clickOnSaveChangedApprover(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnSaveChangedApprover(driver, testCaseName);
	}

	public static boolean isChangeApproverLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isChangeApproverLinkPresent(driver, testCaseName);
	}

	public static boolean isStatusOfWorkflowPending(WebDriver driver, String testCaseName, int id) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isStatusOfWorkflowPending(driver, testCaseName, id);
	}

	public static boolean isAddApproverLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isAddApproverLinkPresent(driver, testCaseName);
	}

	public static void clickOnLinkEnclosure(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnLinkEnclosure(driver, testCaseName);
	}

	public static boolean isDownloadPOAttachmentLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isDownloadPOAttachmentLinkPresent(driver, testCaseName);
	}

	public static String getRequisitionNumber(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getRequisitionNumber(driver, testCaseName);
	}

	public static boolean isDownloadLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isDownloadLinkPresent(driver, testCaseName);
	}

	public static String getFirstApproversNameInWorkflow(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getFirstApproversNameInWorkflow(driver, testCaseName);
	}

	public static String getBuyerName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getBuyerName(driver, testCaseName);
	}

	public static boolean isPOCreatedOnDatePresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isPOCreatedOnDatePresent(driver, testCaseName);
	}

	public static String getConsumedOrderValueOfBPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getConsumedOrderValueOfBPO(driver, testCaseName);
	}

	public static String getInvoicedAmountOfBPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getInvoicedAmountOfBPO(driver, testCaseName);
	}

	public static String getItemNames(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getItemNames(driver, testCaseName, index);
	}

	public static String getAuditTrailAction(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getAuditTrailAction(driver, testCaseName, rowNo);
	}

	public static String getAuditTrailUser(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getAuditTrailUser(driver, testCaseName, rowNo);
	}

	public static String getAuditTrailSharedWith(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getAuditTrailSharedWith(driver, testCaseName, rowNo);
	}

	public static String getAuditTrailRole(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getAuditTrailRole(driver, testCaseName, rowNo);
	}

	public static String getAuditTrailDateNTime(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getAuditTrailDateNTime(driver, testCaseName, rowNo);
	}

	public static String getAuditTrailVersion(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getAuditTrailVersion(driver, testCaseName, rowNo);
	}

	public static String getAuditTrailMessage(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getAuditTrailMessage(driver, testCaseName, rowNo);
	}

	public static void clickOnAuditTrailVersion(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnAuditTrailVersion(driver, testCaseName, rowNo);
	}

	public static boolean isChangeApproverModalErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isChangeApproverModalErrorPresent(driver, testCaseName);
	}

	public static void clickOnCancelChangeApprover(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnCancelChangeApprover(driver, testCaseName);
	}

	public static boolean isWorkflowConfirnModalPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.isWorkflowConfirnModalPresent(driver, testCaseName);
	}

	public static String getWorkflowActorName(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getWorkflowActorName(driver, testCaseName, index);
	}

	public static String getItemNameInAccountingSection(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getItemNameInAccountingSection(driver, testCaseName, index);
	}

	public static String getGLAccountInAccountingSection(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getGLAccountInAccountingSection(driver, testCaseName, index);
	}

	public static String getSettlementViaOption(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getSettlementViaOption(driver, testCaseName);
	}

	public static String getPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getPaymentTerms(driver, testCaseName);
	}

	public static void clickOnSubmitPOForApproval(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnSubmitPOForApproval(driver, testCaseName);
	}

	public static void clickOnModifyPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnModifyPO(driver, testCaseName);
	}

	public static String getLabelValueOfProject(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getLabelValueOfProject(driver, testCaseName);
	}

	public static String getPOName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getPOName(driver, testCaseName);
	}

	public static String getPOComment(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getPOComment(driver, testCaseName);
	}

	public static String getWorkflowNodeDisplayName(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getWorkflowNodeDisplayName(driver, testCaseName, index);
	}

	public static String getWorkflowNodeExtraInfo(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getWorkflowNodeExtraInfo(driver, testCaseName, index);
	}

	public static void clickOnChangeApprover(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnChangeApprover(driver, testCaseName, index);
	}

	public static String getWorkflowNodeStatus(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getWorkflowNodeExtraInfo(driver, testCaseName, index);
	}

	public static String getFirstApproverNameOnWorkflow(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getFirstApproverNameOnWorkflow(driver, testCaseName);
	}

	public static boolean clickRemindApprover(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.clickRemindApprover(driver, testCaseName);

	}

	public static String getCompanyName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getCompanyName(driver, testCaseName);

	}

	//client specific- QTS
	public static List<WebElement> getAllInvoicesAgainstPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getAllInvoicesAgainstPO(driver, testCaseName);
	}

	public static String getBUName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getBUName(driver, testCaseName);

	}

	public static String getLocationName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getLocationName(driver, testCaseName);

	}

	public static String getBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getBillToAddress(driver, testCaseName);

	}

	public static String getDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getDeliveryAddress(driver, testCaseName);

	}

	public static String getCurrency(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getCurrency(driver, testCaseName);

	}

	public static String getExpectedDeliveryDate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getExpectedDeliveryDate(driver, testCaseName);

	}

	public static String getReference(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getReference(driver, testCaseName);

	}

	public static String getRequester(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getRequester(driver, testCaseName);

	}

	public static String getRequesterEmailId(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getRequesterEmailId(driver, testCaseName);

	}

	public static String getApprovedOn(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getApprovedOn(driver, testCaseName);

	}

	public static String getCreatedOn(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getCreatedOn(driver, testCaseName);

	}

	public static String getReleasedOn(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getReleasedOn(driver, testCaseName);

	}

	public static String getRetrospectivePurchase(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getRetrospectivePurchase(driver, testCaseName);

	}

	public static String getPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getPurchaseType(driver, testCaseName);

	}

	public static String getSupplierName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getSupplierName(driver, testCaseName);

	}

	public static String getSupplierEmailId(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getSupplierEmailId(driver, testCaseName);

	}

	public static String getCustomerReferenceNumber(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getCustomerReferenceNumber(driver, testCaseName);

	}

	public static String getDeliveryTerms(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getDeliveryTerms(driver, testCaseName);

	}

	public static String getConfirmedOn(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getConfirmedOn(driver, testCaseName);

	}

	public static String getAddressOfSupplierDetails(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getAddressOfSupplierDetails(driver, testCaseName);

	}

	public static BillingRequisitionSummary getOrganisationUnit(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getOrganisationUnit(driver, testCaseName);

	}

	public static void clickOnCostBookingInfoHeader(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		viewPurchaseOrder.clickOnCostBookingInfoHeader(driver, testCaseName);
	}

	public static String getNetPayableAmountUnderPaymentsAndCredits(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getNetPayableAmountUnderPaymentsAndCredits(driver, testCaseName);

	}

	public static boolean checkIfCCPresentUnderCostBookingInfo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.checkIfCCPresent(driver, testCaseName);
	}

	public static String getCostCenterUnderCostBooking(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getCostCenterUnderCostBooking(driver, testCaseName);
	}

	public static boolean checkIProjectPresentUnderCostBookingInfo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.checkIfProjectPresentUnderCostBookingInfo(driver, testCaseName);
	}

	public static String getProjectUnderCostBooking(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getProjectUnderCostBooking(driver, testCaseName);
	}

	public static String getBudgetUnderCostBooking(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getBudgetUnderCostBooking(driver, testCaseName);
	}

	public static int getNoOfRowsUnderAuditTrail(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getNoOfRowsUnderAuditTrail(driver, testCaseName);

	}

	/*
	 * author : bhakti.sawant : check payment status paid or not
	 */
	public static String checkPaymentStatus(WebDriver driver, String testCaseName, String paymentVoucherNo) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.checkPaymentStatus(driver, testCaseName, paymentVoucherNo);
	}

	/**
	 * @author priyanka.jadhav
	 *         method to get PO quantity
	 */
	public static int getQuantity(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getQuantity(driver, testCaseName, itemId);

	}

	/**
	 * @author t.amarnath
	 *         Method to get the contract number of the item or BPO
	 */
	public static String getContractNumber(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getContractNumber(driver, testCaseName);

	}

	public static String getGlAccount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getGlAccount(driver, testCaseName);
	}

	public static String getOrderValue(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getOrderValue(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to get tax type by index
	 */
	public static String getTaxType(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getTaxType(driver, testCaseName, index);
	}

	/**
	 * @author omkar.jagdale
	 *         method to get filled text in PO pEform
	 */
	public static String getFilledTextOfPeform(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getFilledTextOfPeform(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to get item sub total
	 */
	public static String getItemSubTotal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageViewPurchaseOrder viewPurchaseOrder = FactoryPage.getInstanceOf(IPageViewPurchaseOrderImpl.class);
		return viewPurchaseOrder.getItemSubTotal(driver, testCaseName);
	}
}
