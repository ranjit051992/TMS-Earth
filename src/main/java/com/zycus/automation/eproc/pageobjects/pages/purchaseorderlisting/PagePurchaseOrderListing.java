/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author amitkumar.dash
 */
public class PagePurchaseOrderListing
{

	static Logger logger = Logger.getLogger(PagePurchaseOrderListing.class);

	public static void clickOnActionsDropdownLink(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnActionsDropdownLink(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnActionsDropdownLink " + e, e);
		}
	}

	public static boolean clickOnCancel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnCancel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancel " + e, e);
		}
		return false;
	}

	public static boolean clickOnClosed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnClosed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnClosed " + e, e);
		}
		return false;
	}

	public static void clickOnDateFilterStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnDateFilterStatus(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDateFilterStatus " + e, e);
		}
	}

	public static void clickOnDraftPOLink(WebDriver driver, String testCaseName, int index) throws Exception
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnDraftPOLink(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDraftPOLink " + e, e);
		}
	}

	public static boolean clickOnDraftStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnDraftStatusCheckbox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDraftStatusCheckbox " + e, e);
		}
		return false;
	}

	public static boolean clickOnExpired(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.clickOnExpired(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnExpired " + e, e);
		}
		return false;
	}

	public static void clickOnFilterDateButtom(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnFilterDateButtom(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFilterDateButtom " + e, e);
		}
	}

	public static void clickOnFilterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnFilterLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFilterLink " + e, e);
		}
	}

	public static void clickOnFilterStatusCancelButtom(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnFilterStatusCancelButtom(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFilterStatusCancelButtom " + e, e);
		}
	}

	public static void clickOnFilterStatusLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnFilterStatusLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFilterStatusLink " + e, e);
		}
	}

	public static void clickOnFirstPoNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnFirstPoNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFirstPoNo " + e, e);
		}

	}

	public static void clickOnHeaderPoNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnHeaderPoNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnHeaderPoNo " + e, e);
		}
	}

	public static void clickOnHeaderPoDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnHeaderPoDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnHeaderPoNo " + e, e);
		}
	}

	public static void clickOnHeaderPoAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnHeaderPoAmount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnHeaderPoNo " + e, e);
		}
	}

	public static boolean clickOnInProgressStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnInProgressStatusCheckbox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnInProgressStatusCheckbox " + e, e);
		}
		return false;
	}

	public static boolean clickOnPayements(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnPayements(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSchdule " + e, e);
		}
		return false;
	}

	public static void clickOnPoActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnPoActionsLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPoActionsLink " + e, e);
		}
	}

	public static void clickOnPoLink(WebDriver driver, String testCaseName, int index) throws Exception
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnPoLink(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPoLink " + e, e);
		}
	}

	public static boolean clickOnRejected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.clickOnRejected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRejected " + e, e);
		}
		return false;
	}

	public static boolean clickOnReleasedStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnReleasedStatusCheckbox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReleasedStatusCheckbox " + e, e);
		}
		return false;
	}

	public static boolean clickOnReturned(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnReturned(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReturned " + e, e);
		}
		return false;
	}

	public static boolean clickOnSchdule(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnSchdule(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSchdule " + e, e);
		}
		return false;
	}

	public static String fillBuyer(WebDriver driver, String testCaseName, String buyer) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.fillBuyer(driver, testCaseName, buyer);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBuyer " + e, e);
		}
		return null;
	}

	public static String fillSupplier(WebDriver driver, String testCaseName, String buyer) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.fillSupplier(driver, testCaseName, buyer);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBuyer " + e, e);
		}
		return null;
	}

	public static String fillPoDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		String Podate = null;
		try
		{
			IPagePurchaseOrderListing purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return Podate = purchaseOrderListings.fillPoDate(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPoDate " + e, e);
		}
		return Podate;
	}

	public static String fillPoNo(WebDriver driver, String testCaseName, String poNo) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.fillPoNo(driver, testCaseName, poNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPoNo " + e, e);
		}
		return null;
	}

	public static String fillOrderDescription(WebDriver driver, String testCaseName, String orderDesc) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.fillOrderDescription(driver, testCaseName, orderDesc);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillOrderDescription " + e, e);
		}
		return null;
	}

	public static String getFirstPoNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.getFirstPoNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstPoNo " + e, e);
		}
		return null;
	}

	public static String getFirstPoOrderDescription(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.getFirstPoOrderDescription(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstPoOrderDescription " + e, e);
		}
		return null;
	}

	public static String getFirstPoStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.getFirstPoStatus(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstPoStatus " + e, e);
		}
		return null;
	}

	public static String getFirstRowBuyerName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.getFirstRowBuyerName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRowBuyerName " + e, e);
		}
		return null;
	}

	public static String getFirstRowPoDate(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.getFirstRowPoDate(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstPoNo " + e, e);
		}
		return null;
	}

	public static String getFirstRowSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.getFirstRowSupplierName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRowSupplierName " + e, e);
		}
		return null;
	}

	public static String getFirstRowTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.getFirstRowTotalAmount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRowTotalAmount " + e, e);
		}
		return null;
	}

	public static boolean isDeleteOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.isDeleteOptionPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDeleteOptionPresent " + e, e);
		}
		return false;
	}

	public static boolean isDraftStatusBasedFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.isDraftStatusBasedFilterPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDraftStatusBasedFilterPresent " + e, e);
		}
		return false;
	}

	public static boolean isMaxAndMinDateRangeFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.isMaxAndMinDateRangeFilterPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isMaxAndMinDateRangeFilterPresent " + e, e);
		}
		return false;
	}

	public static boolean isNoOfRecordsLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.isNoOfRecordsLabelPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isNoOfRecordsLabelPresent " + e, e);
		}
		return false;
	}

	public static List<WebElement> getListOfPONos(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.getListOfPONos(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfPONos " + e, e);
		}
		return null;
	}

	public static void clickOnTypeFilterLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnTypeFilterLink(driver, testCaseName);
	}

	public static void clickOnStandardFilterOption(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnStandardFilterOption(driver, testCaseName);
	}

	public static void clickOnReleaseFilterOption(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnReleaseFilterOption(driver, testCaseName);
	}

	public static void clickOnBlanketFilterOption(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnBlanketFilterOption(driver, testCaseName);
	}

	public static void clickOnApplyTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnApplyTypeFilter(driver, testCaseName);
	}

	public static void clickOnAmountFilterLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnAmountFilterLink(driver, testCaseName);
	}

	public static void clickOnINRCurrencyFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnINRCurrencyFilter(driver, testCaseName);
	}

	public static void clickOnUSDCurrencyFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnUSDCurrencyFilter(driver, testCaseName);
	}

	public static void clickOnApplyAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnApplyAmountFilter(driver, testCaseName);
	}

	public static boolean isCommentBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.isCommentBoxPresent(driver, testCaseName);
	}

	public static boolean isAllowCreatingInvoiceOptionPrsent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.isAllowCreatingInvoiceOptionPrsent(driver, testCaseName);
	}

	public static void clickOnCancelClosePOBox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnCancelClosePOBox(driver, testCaseName);
	}

	public static void clickOnAmmendPOLinkFromTooltip(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnAmmendPOLinkFromTooltip(driver, testCaseName);
	}

	public static void hoverOnPONumber(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.hoverOnPONumber(driver, testCaseName);
	}

	public static void clickOnDownloadPOLinkFromTooltip(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnDownloadPOLinkFromTooltip(driver, testCaseName);
	}

	public static boolean isPOParkedMessageDisplayedCorrectly(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.isPOParkedMessageDisplayedCorrectly(driver, testCaseName);
	}

	public static boolean isNoOfRecordsBeforeFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.isNoOfRecordsBeforeFilterPresent(driver, testCaseName);
	}

	public static boolean isNoOfRecordsAfterFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.isNoOfRecordsAfterFilterPresent(driver, testCaseName);
	}

	public static void clickOnExpandInProgressStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnExpandInProgressStatusFilter(driver, testCaseName);
	}

	public static void clickOnInApprovalStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnInApprovalStatusFilter(driver, testCaseName);
	}

	public static void clickOnExpandReleaseFilterNode(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnExpandReleaseFilterNode(driver, testCaseName);
	}

	public static void clickOnClearFilter(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnClearFilter(driver, testCaseName, index);
	}

	public static boolean isSuccessfulAmendedMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.isSuccessfulAmendedMessageDisplayed(driver, testCaseName);
	}

	public static void clickOnViewAmmendedPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnViewAmmendedPO(driver, testCaseName);
	}

	public static boolean isFilterDateButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.isFilterDateButtonPresent(driver, testCaseName);
	}

	public static boolean isPoNOExceedErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.isPoNOExceedErrorMsgDisplayed(driver, testCaseName);
	}

	public static String getFirstPOType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.getFirstPOType(driver, testCaseName);
	}

	public static int enterMinAmountInSelectAmountRangeFilter(WebDriver driver, String testCaseName, int minAmount) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.enterMinAmountInSelectAmountRangeFilter(driver, testCaseName, minAmount);
	}

	public static int enterMaxAmountInSelectAmountRangeFilter(WebDriver driver, String testCaseName, int maxAmount) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.enterMaxAmountInSelectAmountRangeFilter(driver, testCaseName, maxAmount);
	}

	public static void clickOnExpandConfirmationStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnExpandConfirmationStatusFilter(driver, testCaseName);
	}

	public static void clickOnUnConfirmedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnUnConfirmedStatusFilter(driver, testCaseName);
	}

	public static void hoverAndClickOnIconInvoicedPOStatus(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.hoverAndClickOnIconInvoicedPOStatus(driver, testCaseName);
	}

	public static void clickOnExpiredStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnExpiredStatusFilter(driver, testCaseName);
	}

	public static boolean isAlertOfPOWaitingForApprovalPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.isAlertOfPOWaitingForApprovalPresent(driver, testCaseName);
	}

	public static String getSupplierName(WebDriver driver, String testCaseName, String poNo) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.getSupplierName(driver, testCaseName, poNo);
	}

	public static String getTotalAmount(WebDriver driver, String testCaseName, String poNo) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.getTotalAmount(driver, testCaseName, poNo);
	}

	public static String fillCloseCommentBox(WebDriver driver, String testCaseName, String closeComment) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.fillCloseCommentBox(driver, testCaseName, closeComment);
	}

	public static void clickOnClosePOButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnClosePOButton(driver, testCaseName);
	}

	public static boolean isNotSentToSupplierIconPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.isNotSentToSupplierIconPresent(driver, testCaseName);
	}

	public static String getStatusDetailsOfNotSentToSupplierIcon(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.getStatusDetailsOfNotSentToSupplierIcon(driver, testCaseName);
	}

	public static void clickOnNotSentToSupplierFilterCheckbox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnNotSentToSupplierFilterCheckbox(driver, testCaseName);
	}

	public static List<String> getListOfStatus(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.getListOfStatus(driver, testCaseName);
	}

	public static List<WebElement> getListOfIconsOfNotSentToSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.getListOfIconsOfNotSentToSupplier(driver, testCaseName);
	}

	public static boolean clickOnNotPaidPaymentStatusFilterCheckbox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.clickOnNotPaidPaymentStatusFilterCheckbox(driver, testCaseName);
	}

	public static boolean clickOnPartiallyPaidPaymentStatusFilterCheckbox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.clickOnPartiallyPaidPaymentStatusFilterCheckbox(driver, testCaseName);
	}

	public static boolean clickOnFullyPaidPaymentStatusFilterCheckbox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.clickOnFullyPaidPaymentStatusFilterCheckbox(driver, testCaseName);
	}

	public static boolean clickOnPayementNotApplicablePaymentStatusFilterCheckbox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.clickOnPayementNotApplicablePaymentStatusFilterCheckbox(driver, testCaseName);
	}

	public static void clickOnExpandPaymentStatusFilterOptions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnExpandPaymentStatusFilterOptions(driver, testCaseName);
	}

	public static boolean isPOWithGivenAmountPresentInListing(WebDriver driver, String testCaseName, String amount) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.isPOWithGivenAmountPresentInListing(driver, testCaseName, amount);
	}

	public static String getPOWithGivenAmount(WebDriver driver, String testCaseName, String amount) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.getPOWithGivenAmount(driver, testCaseName, amount);
	}

	public static boolean clickonReleaseActionLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.clickonReleaseActionLink(driver, testCaseName);
	}

	public static boolean clickonCancelActionLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.clickonCancelActionLink(driver, testCaseName);
	}

	public static boolean clickOnAlertContinueButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.clickOnAlertContinueButton(driver, testCaseName);
	}

	public static boolean clickOnPONumberSorting(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl pagePurchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);

		return pagePurchaseOrderListings.clickOnPONumberSorting(driver, testCaseName);
	}

	public static boolean clickOnPoDateSorting(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl pagePurchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return pagePurchaseOrderListings.clickOnPoDateSorting(driver, testCaseName);
	}

	public static boolean clickOnPOAmountSorting(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl pagePurchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);

		return pagePurchaseOrderListings.clickOnPOAmountSorting(driver, testCaseName);
	}

	public static boolean clickOnApplyStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl pagePurchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return pagePurchaseOrderListings.clickOnApplyStatusFilter(driver, testCaseName);
	}

	public static String getPurchaseOrderExternalId(WebDriver driver, String testCaseName, String purchaseOrderId) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		return purchaseOrderListings.getPurchaseOrderExternalId(driver, testCaseName, purchaseOrderId);
	}

	/**
	 * @author omkar.jagdale
	 *         method to click on expand delivery status
	 */
	public static void clickOnExpandDeliveryStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListing purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnExpandDeliveryStatusFilter(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to click on not delivered status
	 */
	public static boolean clickOnNotDeliveredStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListing purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnNotDeliveredStatusCheckbox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnNotDeliveredStatusCheckbox " + e, e);
		}
		return false;
	}

	/**
	 * @author omkar.jagdale
	 *         method to click on partially received status check box
	 */
	public static boolean clickOnPartiallyReceivedStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListing purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnPartiallyReceivedStatusCheckbox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPartiallyReceivedStatusCheckbox " + e, e);
		}
		return false;
	}

	/**
	 * @author omkar.jagdale
	 *         method to click on fully received status check box
	 */
	public static boolean clickOnFullyReceivedStatusCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			purchaseOrderListings.clickOnFullyReceivedStatusCheckbox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFullyReceivedStatusCheckbox " + e, e);
		}
		return false;
	}

	public static String getPOId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String POId = null;
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			POId = purchaseOrderListings.getPOId(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequisitionExternalId " + e, e);
		}
		return POId;
	}

	public static List<WebElement> getPoActionsLinks(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
			return purchaseOrderListings.getPoActionsLinks(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPoActionsLink " + e, e);
		}
		return null;
	}

	public static void clickOnStatusFilterTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnStatusFilterTab(driver, testCaseName);
	}

	public static void clickOnCancelledStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPagePurchaseOrderListingsImpl purchaseOrderListings = FactoryPage.getInstanceOf(IPagePurchaseOrderListingsImpl.class);
		purchaseOrderListings.clickOnCancelledStatusFilter(driver, testCaseName);
	}
}
