/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 */
public class PageBuyersDeskListing
{

	static Logger logger = Logger.getLogger(PageBuyersDeskListing.class);

	public static String fillRequisitionNo(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException
	{
		String req_No = null;
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			req_No = buyersDeskListing.fillRequisitionNo(driver, testCaseName, reqNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillRequisitionNo " + e, e);
		}

		return req_No;
	}

	public static String fillRequisitionName(WebDriver driver, String testCaseName, String reqName) throws ActionBotException
	{
		String req_Name = null;
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			req_Name = buyersDeskListing.fillRequisitionName(driver, testCaseName, reqName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillRequisitionName " + e, e);
		}

		return req_Name;
	}

	public static String fillRequester(WebDriver driver, String testCaseName, String requester) throws ActionBotException
	{
		String requester_Name = null;
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			requester_Name = buyersDeskListing.fillRequester(driver, testCaseName, requester_Name);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillRequester " + e, e);
		}

		return requester_Name;
	}

	public static void clickOnClearStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnClearStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnClearStatusFilter " + e, e);
		}

	}

	public static boolean isClearStatusFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag = false;
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			return buyersDeskListing.isClearStatusFilterPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isClearStatusFilterPresent " + e, e);
		}
		return flag;

	}

	public static void clickOnFirstReqNoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFirstReqNoLink " + e, e);
		}
	}

	public static String getFirstRowReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqNo = null;
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			reqNo = buyersDeskListing.getFirstRowReqNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRowReqNo " + e, e);
		}

		return reqNo;
	}

	public static String getFirstRowReqName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqName = null;
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			reqName = buyersDeskListing.getFirstRowReqName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRowReqName " + e, e);
		}

		return reqName;
	}

	public static String getFirstRowRequester(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String requesterName = null;
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			requesterName = buyersDeskListing.getFirstRowRequester(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRowRequester " + e, e);
		}

		return requesterName;
	}

	public static String getFirstRowReqStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String status = null;
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			status = buyersDeskListing.getFirstRowReqStatus(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRowReqStatus " + e, e);
		}

		return status;
	}

	public static List<String> getStatusOfAllReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> status = null;
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			status = buyersDeskListing.getStatusOfAllReq(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getStatusOfAllReq " + e, e);
		}

		return status;
	}

	public static void clickOnFirstActionButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFirstActionButton " + e, e);
		}
	}

	public static List<WebElement> getAllReqNos(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			return buyersDeskListing.getAllReqNos(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllReqNos " + e, e);
		}
		return null;
	}

	public static void clickOnConvertToPoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnConvertToPoButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnConvertToPoButton " + e, e);
		}
	}

	public static void waitTillConvertToPoProcessingDiv(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.waitTillConvertToPoProcessingDiv(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitTillConvertToPoProcessingDiv " + e, e);
		}
	}

	public static String getFirstRowAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			return buyersDeskListing.getFirstRowAssignedBuyer(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRowAssignedBuyer " + e, e);
		}
		return testCaseName;
	}

	public static void clickOnLinkStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnLinkStatusFilter(driver, testCaseName);
	}

	public static void clickOnProcessedStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnProcessedStatusFilter(driver, testCaseName);
	}

	public static void clickOnApplyStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
	}

	public static void clickOnPendingOrderStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnPendingOrderStatusFilter(driver, testCaseName);
	}

	public static void clickOnConvertToPOFromAction(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnConvertToPOFromAction(driver, testCaseName);
	}

	public static void clickOnExpandPendingOrderFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnExpandPendingOrderFilter(driver, testCaseName);
	}

	public static void clickOnPartiallyOrderedFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnPartiallyOrderedFilter(driver, testCaseName);
	}

	public static void clickOnAwaitingQueueFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnAwaitingQueueFilter(driver, testCaseName);
	}

	public static void clickOnNextPageIcon(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnNextPageIcon(driver, testCaseName);
	}

	public static boolean isValidationGlobalErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		return buyersDeskListing.isValidationGlobalErrorMessagePresent(driver, testCaseName);
	}

	public static void clickOnExpandProcessedFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnExpandProcessedFilter(driver, testCaseName);
	}

	public static void clickOnReturnedWithQuoteFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnReturnedWithQuoteFilter(driver, testCaseName);
	}

	public static void clickOnReturnedForModificationFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnReturnedForModificationFilter(driver, testCaseName);
	}

	public static void clickOnLinkAssignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnLinkAssignedBuyerFilter(driver, testCaseName);
	}

	public static void clickOnUnassignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnUnassignedBuyerFilter(driver, testCaseName);
	}

	public static void clickOnApplyAssignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnApplyAssignedBuyerFilter(driver, testCaseName);
	}

	public static void clickOnCheckboxOfReqToBeSelected(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnCheckboxOfReqToBeSelected(driver, testCaseName, index);
	}

	public static void hoverOnFirstReqNoToGetReqInfo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.hoverOnFirstReqNoToGetReqInfo(driver, testCaseName);
	}

	public static void clickOnClearReqNoFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnClearReqNoFilter(driver, testCaseName);
	}

	public static void clickOnMeAssignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnMeAssignedBuyerFilter(driver, testCaseName);
	}

	public static void clickOnBuyerInAssignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnBuyerInAssignedBuyerFilter(driver, testCaseName);
	}

	public static void clickOnClearIconOfAssignedBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnClearIconOfAssignedBuyerFilter(driver, testCaseName);
	}

	public static void clickOnClearIconOfRequisitionNameFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnClearIconOfRequisitionNameFilter(driver, testCaseName);
	}

	public static void clickOnClearIconOfRequesterFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnClearIconOfRequesterFilter(driver, testCaseName);
	}

	public static void clickOnLinkAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnLinkAmountFilter(driver, testCaseName);
	}

	public static void clickOnINRcheckboxOfAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnINRcheckboxOfAmountFilter(driver, testCaseName);
	}
	
	public static void clickOnCheckboxOfAmountFilter(WebDriver driver, String testCaseName,int index) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnCheckboxOfAmountFilter(driver, testCaseName,index);
	}

	public static void clickOnApplyAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnApplyAmountFilter(driver, testCaseName);
	}

	public static boolean isAssignedBuyerFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		return buyersDeskListing.isAssignedBuyerFilterPresent(driver, testCaseName);
	}

	public static void clickOnStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnStatusFilterButton(driver, testCaseName);
	}

	public static String getSuccessErrorMessage(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		return buyersDeskListing.getSuccessErrorMessage(driver, testCaseName);
	}

	public static void clickOnEditAction(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnEditAction(driver, testCaseName);
	}

	public static boolean verifyAvailablityOfEditAction(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		return buyersDeskListing.verifyAvailablityOfEditAction(driver, testCaseName);
	}

	public static boolean verifyEditAction(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		return buyersDeskListing.verifyEditAction(driver, testCaseName);
	}

	public static String searchRequisitionNameInFilter(WebDriver driver, String testCaseName, String reqName) throws FactoryMethodException, ActionBotException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		return buyersDeskListing.searchRequisitionNameInFilter(driver, testCaseName, reqName);
	}

	public static String searchRequisitionNumberInFilter(WebDriver driver, String testCaseName, String reqNumber) throws FactoryMethodException, ActionBotException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		return buyersDeskListing.searchRequisitionNumberInFilter(driver, testCaseName, reqNumber);
	}

	public static boolean isReqSaveMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		return buyersDeskListing.isReqSaveMessageDisplayed(driver, testCaseName);
	}

	public static boolean verifyLinkConvertToPoDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
		return buyersDeskListing.verifyLinkConvertToPoDisplayed(driver, testCaseName);
	}

	public static String fetchRequisitionNumberinBuyerList(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			return buyersDeskListing.fetchRequisitionNumberinBuyerList(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchRequisitionNumberinBuyerList " + e, e);
		}
		return null;
	}	

	public static void clickOnReturnLinkIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnReturnLinkIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReturnLinkIndexwise " + e, e);
		}
	}

	public static void clickReturActionOnReqInBuyerList(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickReturActionOnReqInBuyerList(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickReturActionOnReqInBuyerList " + e, e);
		}
	}

	public static boolean verifyReturnActionOnReqInBuyerList(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			return buyersDeskListing.verifyReturnActionOnReqInBuyerList(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method verifyReturnActionOnReqInBuyerList " + e, e);
		}
		return false;
	}

	public static void clickOnCheckResubmitInBuyerList(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnCheckResubmitInBuyerList(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCheckResubmitInBuyerList " + e, e);
		}
	}

	public static void clickOnCheckNoResubmitInBuyerList(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnCheckNoResubmitInBuyerList(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCheckNoResubmitInBuyerList " + e, e);
		}
	}

	public static void fillCommentForReturningByBuyer(WebDriver driver, String testCaseName, String comment) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.fillCommentForReturningByBuyer(driver, testCaseName, comment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCommentForReturningByBuyer " + e, e);
		}
	}

	public static void fillCommentForReturningUnderActionTabByBuyer(WebDriver driver, String testCaseName, String comment) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.fillCommentForReturningUnderActionTabByBuyer(driver, testCaseName, comment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCommentForReturningByBuyer " + e, e);
		}
	}

	public static void clickReturnSubmitFromBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickReturnSubmitFromBuyer(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickReturnSubmitFromBuyer " + e, e);
		}
	}

	public static void clearFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clearFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearFilter " + e, e);
		}
	}

	public static boolean isReqPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			return buyersDeskListing.isReqPresentIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearFilter " + e, e);
			return false;
		}
	}

	public static void clickAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickAmountFilterButton(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickAmountFilterButton " + e, e);
		}

	}

	public static void enterMinAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.enterMinAmountFilter(driver, testCaseName, amount);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method enterMinAmountFilter " + e, e);
		}

	}

	public static void enterMaxAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.enterMaxAmountFilter(driver, testCaseName, amount);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method enterMaxAmountFilterenterMaxAmountFilter " + e, e);
		}

	}

	public static void clickApplyAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickApplyAmountFilter(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickApplyAmountFilter " + e, e);
		}

	}

	public static String fetchRequisitionAmountIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String number = null;
		try
		{

			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			number = buyersDeskListing.fetchRequisitionAmountIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchRequisitionAmountIndexwise " + e, e);
		}
		return number;
	}

	public static void clickOnAwaitingQuoteStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnAwaitingQuoteStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAwaitingQuoteStatusFilter " + e, e);
		}
	}	

	public static void clickOnAwaitingReviewStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnAwaitingReviewStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAwaitingReviewStatusFilter " + e, e);
		}
	}

	public static void clickOnPendingOrderStatusFilter_1(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnPendingOrderStatusFilter_1(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPendingOrderStatusFilter_1 " + e, e);
		}
	}

	public static void clickOnUnorderedStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnUnorderedStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnUnorderedStatusFilter " + e, e);
		}
	}

	public static void clickOnPartiallyOrderedStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnPartiallyOrderedStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPartiallyOrderedStatusFilter " + e, e);
		}
	}

	public static void clickOnProcessedStatusFilter_1(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnProcessedStatusFilter_1(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnProcessedStatusFilter_1 " + e, e);
		}
	}

	public static void clickOnReturnedWithQuoteStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnReturnedWithQuoteStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReturnedWithQuoteStatusFilter " + e, e);
		}
	}

	public static void clickOnReturnedWithModificationStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnReturnedWithModificationStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReturnedWithModificationStatusFilter " + e, e);
		}
	}

	public static void clickOnOrderingStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnOrderingStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnOrderingStatusFilter " + e, e);
		}
	}

	public static void clickOnReleasedStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnReleasedStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReleasedStatusFilter " + e, e);
		}
	}

	public static void clickOnRejectedStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnRejectedStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRejectedStatusFilter " + e, e);
		}
	}

	public static void clickOnSourcingStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnSourcingStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSourcingStatusFilter " + e, e);
		}
	}

	public static void clickOnBuyerNegotiatedPriceStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnBuyerNegotiatedPriceStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnBuyerNegotiatedPriceStatusFilter " + e, e);
		}
	}

	public static void clickOnQuotedBySupplierStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnQuotedBySupplierStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnQuotedBySupplierStatusFilter " + e, e);
		}
	}

	public static void clickOnEstimatedPriceStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnEstimatedPriceStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEstimatedPriceStatusFilter " + e, e);
		}
	}

	public static void clickOnNeedAQuoteStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnNeedAQuoteStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnNeedAQuoteStatusFilter " + e, e);
		}
	}

	public static void clickOnCancelledStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnCancelledStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelledStatusFilter " + e, e);
		}
	}

	public static void clickOnClosedStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnClosedStatusFilter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnClosedStatusFilter " + e, e);
		}
	}	

	public static String getFilterCount(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			return buyersDeskListing.getFilterCount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFilterCount " + e, e);
		}
		return null;
	}

	public static String getPageItemCount(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			return buyersDeskListing.getPageItemCount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPageItemCount " + e, e);
		}
		return null;
	}

	public static void naviagteToLastPage(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.naviagteToLastPage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method naviagteToLastPage " + e, e);
		}
	}

	public static void naviagteToFirstPage(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.naviagteToFirstPage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method naviagteToFirstPage " + e, e);
		}

	}

	public static String getShowingPageNumber(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			return buyersDeskListing.getShowingPageNumber(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getShowingPageNumber " + e, e);
		}
		return null;
	}

	public static int getNumberOfReqOnPage(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			return buyersDeskListing.getNumberOfReqOnPage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getNumberOfReqOnPage " + e, e);
		}
		return 0;
	}	

	public static boolean isDeliverByDateEditable(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			return buyersDeskListing.isDeliverByDateEditable(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDeliverByDateEditable " + e, e);
		}
		return false;
	}

	public static void clickConvertToPo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickConvertToPo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickConvertToPo " + e, e);
		}
	}

	public static String getReqStatusIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			return buyersDeskListing.getReqStatusIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickConvertToPo " + e, e);
		}
		return null;
	}

	public static void clickOnClearIconOfAssignedBuyerFilterUpcomingRequisition(WebDriver driver, String testCaseName) throws Exception
	{
		try
		{
			IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
			buyersDeskListing.clickOnClearIconOfAssignedBuyerFilterUpcomingRequisition(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method naviagteToLastPage " + e, e);
		}

	}

	public static boolean isAssignedBuyerFilterUpcomingRequisitionPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		return buyersDeskListing.isAssignedBuyerFilterUpcomingRequisitionPresent(driver, testCaseName);
	}

	public static void selectFirstReqInBuyersDeskListing(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		buyersDeskListing.selectFirstReqInBuyersDeskListing(driver, testCaseName);
	}

	public static List<String> getBuyersDeskListingTableColumnNames(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		return buyersDeskListing.getBuyersDeskListingTableColumnNames(driver, testCaseName);
	}

	public static String getRecievedOnSortingStatus(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskListing buyersDeskListing = FactoryPage.getInstanceOf(IPageBuyersDeskListingImpl.class);
		return buyersDeskListing.getRecievedOnSortingStatus(driver, testCaseName);
	}
}
