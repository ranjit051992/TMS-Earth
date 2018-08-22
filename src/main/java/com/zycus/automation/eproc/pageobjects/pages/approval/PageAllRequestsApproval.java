package com.zycus.automation.eproc.pageobjects.pages.approval;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageAllRequestsApproval
{

	static Logger logger = Logger.getLogger(PageAllRequestsApproval.class);

	public static void clickOnActionsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnActionsLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnActionsLink " + e, e);
		}

	}

	public static void clickOnActionsLinkIindexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnActionsLinkIindexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnActionsLinkIindexwise " + e, e);
		}

	}

	public static void clickOnAmountActivatedSortLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnAmountActivatedSortLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAmountActivatedSortLink " + e, e);
		}

	}

	public static void clickOnAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnAmountFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAmountFilter " + e, e);
		}

	}

	public static void clickOnAmountSortLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnAmountSortLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAmountSortLink " + e, e);
		}

	}

	public static void clickOnApproveLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnApproveLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApproveLink " + e, e);
		}
	}

	public static void clickOnApproveLinkIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnApproveLinkIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApproveLinkIndexwise " + e, e);
		}
	}

	public static void clickOnCheckAll(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnCheckAll(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCheckAll " + e, e);
		}

	}

	public static void clickOnClearAllFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnClearAllFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnClearAllFilter " + e, e);
		}
	}

	public static void clickOnClearApprovalStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnClearApprovalStatusFilterButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnClearApprovalStatusFilterButton " + e, e);
		}
	}

	public static void clickOnDocumentNoActivatedSortLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnDocumentNoActivatedSortLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDocumentNoActivatedSortLink " + e, e);
		}

	}

	public static void clickOnDocumentNoSortLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnDocumentNoSortLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDocumentNoSortLink " + e, e);
		}

	}

	public static void clickOnDocumentTypeFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnDocumentTypeFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDocumentTypeFilter " + e, e);
		}

	}

	public static void clickOnReceivedOnFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnReceivedOnFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReceivedOnFilter " + e, e);
		}

	}

	public static void clickOnRecivedOnActivatedSortLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnRecivedOnActivatedSortLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRecivedOnActivatedSortLink " + e, e);
		}

	}

	public static void clickOnRecivedOnSortLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnRecivedOnSortLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRecivedOnSortLink " + e, e);
		}

	}

	public static void clickOnStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnStatusFilter " + e, e);
		}
	}

	public static String fillDocumentName(WebDriver driver, String testCaseName, String documentName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.fillDocumentName(driver, testCaseName, documentName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDocumentName " + e, e);
		}
		return result;
	}

	public static String fillDocumentNo(WebDriver driver, String testCaseName, String documentNo) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.fillDocumentNo(driver, testCaseName, documentNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDocumentNo " + e, e);
		}
		return result;
	}

	public static String fillInitiatorName(WebDriver driver, String testCaseName, String initiatorName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.fillInitiatorName(driver, testCaseName, initiatorName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillInitiatorName " + e, e);
		}
		return result;
	}

	public static List<WebElement> getAllDocumentAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getAllDocumentAmount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllDocumentAmount " + e, e);
		}
		return result;
	}

	public static List<WebElement> getAllDocumentAmountAfterSorting(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getAllDocumentAmountAfterSorting(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllDocumentAmountAfterSorting " + e, e);
		}
		return result;
	}

	public static List<WebElement> getAllDocumentNos(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getAllDocumentNos(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllDocumentNos " + e, e);
		}
		return result;
	}

	public static List<WebElement> getAllDocumentNosAfterSorting(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getAllDocumentNosAfterSorting(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllDocumentNosAfterSorting " + e, e);
		}
		return result;
	}

	public static List<WebElement> getAllDocumentReceivedOn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getAllDocumentReceivedOn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllDocumentReceivedOn " + e, e);
		}
		return result;
	}

	public static List<WebElement> getAllDocumentRecivedOnAfterSorting(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getAllDocumentRecivedOnAfterSorting(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllDocumentRecivedOnAfterSorting " + e, e);
		}
		return result;
	}

	public static int getApprovalEmptyTableSize(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getApprovalEmptyTableSize(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getApprovalEmptyTableSize " + e, e);
		}
		return result;
	}

	public static String getDocumentName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getDocumentName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDocumentName " + e, e);
		}
		return result;
	}

	public static String getDocumentNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getDocumentNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDocumentNo " + e, e);
		}
		return result;
	}

	public static String getDocumentStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			return allRequestsApproval.getDocumentStatus(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDocumentStatus " + e, e);
		}
		return null;
	}

	public static String getFirstRowAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getFirstRowAmount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRowAmount " + e, e);
		}
		return result;
	}

	public static String getFirstRowDocumentName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getFirstRowDocumentName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRowDocumentName " + e, e);
		}
		return result;
	}

	public static String getFirstRowDocumentNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getFirstRowDocumentNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRowDocumentNo " + e, e);
		}
		return result;
	}

	public static String getFirstRowDocumentType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getFirstRowDocumentType(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRowDocumentType " + e, e);
		}
		return result;
	}

	public static String getFirstRowInitiatorName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getFirstRowInitiatorName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRowInitiatorName " + e, e);
		}
		return result;
	}

	public static String getFirstRowReceivedOn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getFirstRowReceivedOn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRowReceivedOn " + e, e);
		}
		return result;
	}

	public static String getInitiatorName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.getInitiatorName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getInitiatorName " + e, e);
		}
		return result;
	}

	public static List<String> getListOfApprovalStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			return allRequestsApproval.getListOfApprovalStatus(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfApprovalStatus " + e, e);
		}
		return null;
	}

	public static boolean isSuccessMessage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.isSuccessMessage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSuccessMessage " + e, e);
		}
		return result;
	}

	public static boolean isNoDataRecordsMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			result = allRequestsApproval.isNoDataRecordsMessageDisplayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isNoDataRecordsMessageDisplayed " + e, e);
		}
		return result;
	}

	public static void waitTillAllRequestsGridLoads(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.waitTillAllRequestsGridLoads(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitTillAllRequestsGridLoads " + e, e);
		}

	}

	public static void waitTillApprovalActionProcessingDivPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.waitTillApprovalActionProcessingDivPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitTillApprovalActionProcessingDivPresent " + e, e);
		}
	}

	public static void clickOnApproveRequestOnToolTip(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnApproveRequestOnToolTip(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApproveRequestOnToolTip " + e, e);
		}
	}

	public static void clickOnFirstRowApprovalDocumentNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnFirstRowApprovalDocumentNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFirstRowApprovalDocumentNo " + e, e);
		}
	}

	public static List<WebElement> getListOfDocumentNos(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			return allRequestsApproval.getListOfDocumentNos(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfDocumentNos " + e, e);
		}
		return null;
	}

	public static void clickOnPurchaseOrderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnPurchaseOrderTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPurchaseOrderTab " + e, e);
		}
	}

	public static String getMessageOnEmptyTable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			return allRequestsApproval.getMessageOnEmptyTable(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getMessageOnEmptyTable " + e, e);
		}
		return null;
	}

	public static void clickOnInvoiceApprovalLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnInvoiceApprovalLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnInvoiceApprovalLink " + e, e);
		}
	}

	public static void clickOnBPOTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnBPOTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnBPOTab " + e, e);
		}
	}

	public static void clickOnInvoiceNoFilterLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnInvoiceNoFilterLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnInvoiceNoFilterLink " + e, e);
		}
	}

	public static String fillInvoiceNo(WebDriver driver, String testCaseName, String invoiceNo) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			return allRequestsApproval.fillInvoiceNo(driver, testCaseName, invoiceNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillInvoiceNo " + e, e);
		}
		return invoiceNo;
	}

	public static void clickOnInvoiceNoFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnInvoiceNoFilterButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnInvoiceNoFilterButton " + e, e);
		}
	}

	public static void clickOnClearApprovalNumberFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnClearApprovalNumberFilterButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnClearApprovalNumberFilterButton " + e, e);
		}
	}

	public static void clickOnClearApprovalNameFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnClearApprovalNameFilterButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnClearApprovalNameFilterButton " + e, e);
		}
	}

	public static boolean isInvoiceNoFilterLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			return allRequestsApproval.isInvoiceNoFilterLinkPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isInvoiceNoFilterLinkPresent " + e, e);
		}
		return false;
	}

	public static void clickOnCatalogTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickOnCatalogTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCatalogTab " + e, e);
		}
	}

	public static String enterReqNoFilter(WebDriver driver, String testCaseName, String reqNumber) throws ActionBotException, FactoryMethodException
	{
		IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
		return allRequestsApproval.enterReqNoFilter(driver, testCaseName, reqNumber);
	}

	public static void clickActionButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
		allRequestsApproval.clickActionButton(driver, testCaseName);
	}

	public static boolean approveRequisition(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
		return allRequestsApproval.approveRequisition(driver, testCaseName);
	}

	public static boolean rejectRequisition(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
		return allRequestsApproval.rejectRequisition(driver, testCaseName);
	}

	public static void fillApprovalComment(WebDriver driver, String testCaseName, String comment) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.fillApprovalComment(driver, testCaseName, comment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillApprovalComment " + e, e);
		}

	}

	public static void fillRejectComment(WebDriver driver, String testCaseName, String comment) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.fillRejectComment(driver, testCaseName, comment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillRejectComment " + e, e);
		}

	}

	public static void clickRejectButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickRejectButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickRejectButton " + e, e);
		}

	}

	public static void clickApproveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickApproveButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickApproveButton " + e, e);
		}

	}

	public static void clickRejectLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickRejectLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickRejectLink " + e, e);
		}

	}

	public static boolean isActionPerformedSuccessful(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			return allRequestsApproval.isActionPerformedSuccessful(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isActionPerformedSuccessful " + e, e);
		}
		return false;
	}

	public static boolean isPendingStatusFilterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			return allRequestsApproval.isPendingStatusFilterSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPendingStatusFilterSelected " + e, e);
		}
		return false;
	}

	public static void clickPendingStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickPendingStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickPendingStatusFilter " + e, e);
		}

	}

	public static void clickApprovedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickApprovedStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickApprovedStatusFilter " + e, e);
		}

	}

	public static void clickRejectedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickRejectedStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickRejectedStatusFilter " + e, e);
		}

	}

	public static void clickDelegatedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.clickDelegatedStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickDelegatedStatusFilter " + e, e);
		}

	}

	public static String searchRequition(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			return allRequestsApproval.searchRequition(driver, testCaseName, reqNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickDelegatedStatusFilter " + e, e);
		}
		return null;
	}

	public static boolean delegateFirstRequsition(WebDriver driver, String testCaseName, String DelegateTo) throws Exception
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			return allRequestsApproval.delegateFirstRequsition(driver, testCaseName, DelegateTo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method delegateFirstRequsition " + e, e);
		}
		return false;
	}

	public static List<String> getDocumentAllStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			return allRequestsApproval.getDocumentAllStatus(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDocumentStatus " + e, e);
		}
		return null;
	}

	/**
	 * @author omkar.jagdale
	 */

	public static boolean verifyUrgentRequestSymbol(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			return allRequestsApproval.verifyUrgentRequestSymbol(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method verifyUrgentRequestSymbol " + e, e);
		}
		return false;
	}

	/**
	 * @author t.amarnath
	 */
	public static void searchRequisitionByName(WebDriver driver, String testCaseName, String requisitionName) throws ActionBotException
	{
		try
		{
			IPageAllRequestsApproval allRequestsApproval = FactoryPage.getInstanceOfIPageAllRequestsApproval();
			allRequestsApproval.searchRequisitionByName(driver, testCaseName, requisitionName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method verifyUrgentRequestSymbol " + e, e);
		}
	}
}
