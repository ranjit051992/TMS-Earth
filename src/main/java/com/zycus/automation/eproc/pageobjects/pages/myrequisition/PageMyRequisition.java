package com.zycus.automation.eproc.pageobjects.pages.myrequisition;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.eInvoice.automation.utilities.actionbot.ActionBot;

public class PageMyRequisition
{

	static Logger logger = Logger.getLogger(PageMyRequisition.class);

	public static void clickOnAddBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.toClickOnAddBtn(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddBtn " + e, e);
		}

	}

	public static String fillReqNumberOnMyReq(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException
	{
		String reqNumber = null;

		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			reqNumber = myRequisition.fillReqNumberOnMyReq(driver, testCaseName, reqNo);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReqNumberOnMyReq " + e, e);
		}

		return reqNumber;
	}

	public static String fillRecallApprovalComment(WebDriver driver, String testCaseName, String recallcommnet) throws ActionBotException
	{
		String reqNumber = null;

		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			reqNumber = myRequisition.fillRecallApprovalComment(driver, testCaseName, recallcommnet);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillRecallApprovalComment " + e, e);
		}

		return reqNumber;
	}

	public static String getReqNoFromMyReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqNumber = null;

		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			reqNumber = myRequisition.getReqNoFromMyReq(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReqNoFromMyReq " + e, e);
		}

		return reqNumber;
	}

	public static String fillReqName(WebDriver driver, String testCaseName, String reqName) throws ActionBotException
	{

		String requisitionName = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			requisitionName = myRequisition.fillReqName(driver, testCaseName, reqName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReqName " + e, e);
		}

		return requisitionName;
	}

	public static String getReqNameFromMyReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String requisitionName = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			requisitionName = myRequisition.getReqNameFromMyReq(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReqNameFromMyReq " + e, e);
		}

		return requisitionName;
	}

	public static String fillRequester(WebDriver driver, String testCaseName, String requesterName) throws ActionBotException
	{
		String requester = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			requester = myRequisition.fillRequester(driver, testCaseName, requesterName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillRequester " + e, e);
		}

		return requester;
	}

	public static void clearStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clearStatusFilter(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearStatusFilter " + e, e);
		}

	}

	public static void clearAllStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clearAllStatusFilter(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearAllStatusFilter " + e, e);
		}

	}

	public static void clearSubmittedOnFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clearSubmittedOnFilter(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearSubmittedOnFilter " + e, e);
		}

	}

	public static void clearAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clearAmountFilter(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearAmountFilter " + e, e);
		}

	}

	public static void clickOnReqNoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnReqNoLink(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReqNoLink " + e, e);
		}

	}

	public static List<String> getReqNoList(WebDriver driver, String testCaseName) throws ActionBotException
	{

		List<String> requisitionNoList = new ArrayList<String>();
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			requisitionNoList = myRequisition.getReqNoList(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReqNoList " + e, e);
		}
		return requisitionNoList;
	}

	public static List<String> getRequesterList(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> requesterList = new ArrayList<String>();
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			requesterList = myRequisition.getRequesterList(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequesterList " + e, e);
		}
		return requesterList;
	}

	public static void clickOnActionBtnOfFirstReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnActionBtnOfFirstReq " + e, e);
		}

	}

	public static void clickOnReqNumberOnHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnReqNumberOnHeader(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReqNumberOnHeader " + e, e);
		}

	}

	public static void clickOnSubmittedOnHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnSubmittedOnHeader(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSubmittedOnHeader " + e, e);
		}

	}

	public static void clickOnAmountOnHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnAmountOnHeader(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAmountOnHeader " + e, e);
		}

	}

	public static void clickOnStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnStatusFilterBtn " + e, e);
		}

	}

	public static void clickOnSubmittedOnFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnSubmittedOnFilterBtn(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSubmittedOnFilterBtn " + e, e);
		}

	}

	public static void clickOnAmountFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnAmountFilterBtn(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAmountFilterBtn " + e, e);
		}

	}

	public static void clickOnRecallApprocalRequestLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnRecallApprocalRequestLink(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRecallApprocalRequestLink " + e, e);
		}

	}

	public static String getReqRequester(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			result = myRequisition.getReqRequester(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReqRequester " + e, e);
		}
		return result;
	}

	public static List<String> getRequisitionStatusList(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> result = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			result = myRequisition.getRequisitionStatusList(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequisitionStatusList " + e, e);
		}
		return result;
	}

	public static int getRequisitionStatusListSize(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			result = myRequisition.getRequisitionStatusListSize(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequisitionStatusList " + e, e);
		}
		return result;
	}

	public static boolean isAddReqButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			result = myRequisition.isAddReqButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAddReqButtonPresent " + e, e);
		}
		return result;
	}

	public static String getFirstReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			result = myRequisition.getFirstReqNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstReqNo " + e, e);
		}
		return result;
	}

	public static void clickOnFirstReqNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnFirstReqNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnFirstReqNo " + e, e);
		}
	}

	public static String getFirstReqName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			result = myRequisition.getFirstReqName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstReqName " + e, e);
		}
		return result;
	}

	public static String getFirstRequester(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			result = myRequisition.getFirstRequester(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstRequester " + e, e);
		}
		return result;
	}

	public static String getFirstSubmittedOn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			result = myRequisition.getFirstSubmittedOn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstSubmittedOn " + e, e);
		}
		return result;
	}

	public static String getFirstTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			result = myRequisition.getFirstTotalAmount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFirstTotalAmount " + e, e);
		}
		return result;
	}

	public static String getStatusOfFirstReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.getStatusOfFirstReq(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getStatusOfFirstReq " + e, e);
		}
		return null;
	}

	public static void clickOnReqAction(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnReqAction(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReqAction " + e, e);
		}
	}

	public static void clickOnDeleteReq(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnDeleteReq(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeleteReq " + e, e);
		}
	}

	public static boolean isRecallReqActionPresentInApprovalReq(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isRecallReqActionPresentInApprovalReq(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isRecallReqActionPresentInApprovalReq " + e, e);
		}
		return false;
	}

	public static boolean isDeleteReqActionPresentInApprovalReq(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isDeleteReqActionPresentInApprovalReq(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isRecallReqActionPresentInApprovalReq " + e, e);
		}
		return false;
	}

	public static void clickToNaviagteToNextPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickToNaviagteToNextPage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToNaviagteToNextPage " + e, e);
		}
	}

	public static boolean isCreateRecieptActionPresentInApprovalReq(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isCreateRecieptActionPresentInApprovalReq(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCreateRecieptActionPresentInApprovalReq " + e, e);
		}
		return false;
	}

	public static void clickOnReturnedForAmendInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnReturnedForAmendInStatusFilterBtn(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReturnedForAmendInStatusFilterBtn " + e, e);
		}

	}

	public static boolean toHoverUponRequistionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.toHoverUponRequistionIndexwise(driver, testCaseName, index);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toHoverUponRequistionIndexwise " + e, e);
		}
		return false;
	}

	public static boolean isCancelPresentInActionReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isCancelPresentInActionReq(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCancelPresentInActionReq " + e, e);
		}
		return false;
	}

	public static boolean isEditPresentInActionReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isEditPresentInActionReq(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isEditPresentInActionReq " + e, e);
		}
		return false;
	}

	public static void clickOnPerformFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPerformFilterBtn " + e, e);
		}

	}

	public static void clickOnInApprovalInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnInApprovalInStatusFilterBtn(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnInApprovalInStatusFilterBtn " + e, e);
		}

	}

	public static void clickOnBuyersDeskInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnBuyersDeskInStatusFilterBtn(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnBuyersDeskInStatusFilterBtn " + e, e);
		}

	}

	public static void clickOnRejectedInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnRejectedInStatusFilterBtn(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRejectedInStatusFilterBtn " + e, e);
		}

	}

	public static void clickOnReleasedInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnReleasedInStatusFilterBtn(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReleasedInStatusFilterBtn " + e, e);
		}

	}

	public static void clickOnExpandReleasedInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnExpandReleasedInStatusFilterBtn(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReleasedInStatusFilterBtn " + e, e);
		}

	}

	public static void clickOnOrderingInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnOrderingInStatusFilterBtn(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnOrderingInStatusFilterBtn " + e, e);
		}

	}

	public static void clickOnCopyActionReq(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnCopyActionReq(driver, testCaseName, index);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCopyActionReq " + e, e);
		}

	}

	public static void clickOnCancelActionReq(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnCancelActionReq(driver, testCaseName, index);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCopyActionReq " + e, e);
		}

	}

	public static void clickOnDraftInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnDraftInStatusFilterBtn(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDraftInStatusFilterBtn " + e, e);
		}

	}

	public static boolean isCopyActionReqAvailable(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isCopyActionReqAvailable(driver, testCaseName, index);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDraftInStatusFilterBtn " + e, e);
		}
		return false;
	}

	public static boolean isDeletedReqPresent(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isDeletedReqPresent(driver, testCaseName, reqNo);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isDeletedReqPresent " + e, e);
		}
		return false;
	}

	public static void searchRequisitionByReqNo(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.searchRequisitionByReqNo(driver, testCaseName, reqNo);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method searchRequisitionByReqNo " + e, e);
		}
	}

	public static boolean isItemReqPresentInCart(WebDriver driver, String testCaseName, int index) throws ActionBotException, InterruptedException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isReqPresentInCart(driver, testCaseName, Integer.toString(index));
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isReqPresentInCart " + e, e);
			return false;
		}
	}

	public static void clickOnProceedWithReqItemsOnlyButton(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnProceedWithReqItemsOnlyButton(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnProceedWithReqItemsOnlyButton " + e, e);
		}
	}

	public static String getReqNumberRowise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String number = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			number = myRequisition.getReqNumberRowise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReqNumberRowise " + e, e);
		}
		return number;
	}

	public static String fetchRequisitionBillingAddress(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String number = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			number = myRequisition.fetchRequisitionBillingAddress(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchRequisitionBillingAddress " + e, e);
		}
		return number;
	}

	public static void clickOnReqItemIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnReqItemIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReqItemIndexwise " + e, e);
		}
	}

	public static boolean clickOnReqAuditVerIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.clickOnReqAuditVerIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReqItemIndexwise " + e, e);
		}
		return false;
	}

	public static void clickCancelActionReqButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickCancelActionReqButton(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCancelActionReqButton " + e, e);
		}

	}

	public static boolean isReqSuccessfullySubmitted(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isReqSuccessfullySubmitted(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isReqSuccessfullySubmitted " + e, e);
		}
		return false;
	}

	public static void clickApprovalReqButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickApprovalReqButton(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickApprovalReqButton " + e, e);
		}

	}

	public static void clickAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickAmountFilterButton(driver, testCaseName);
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
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.enterMinAmountFilter(driver, testCaseName, amount);
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
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.enterMaxAmountFilter(driver, testCaseName, amount);
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
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickApplyAmountFilter(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickApplyAmountFilter " + e, e);
		}

	}

	public static boolean isReqPresentIndexwise(WebDriver driver, String testCaseName, int indexwise) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isReqPresentIndexwise(driver, testCaseName, indexwise);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isReqPresentIndexwise " + e, e);
		}
		return false;
	}

	public static String fetchRequisitionAmountIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String number = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			number = myRequisition.fetchRequisitionAmountIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchRequisitionAmountIndexwise " + e, e);
		}
		return number;
	}

	public static boolean isReqStatusPresentIndexwise(WebDriver driver, String testCaseName, int indexwise) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isReqStatusPresentIndexwise(driver, testCaseName, indexwise);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isReqStatusPresentIndexwise " + e, e);
		}
		return false;
	}

	public static boolean isReqNamePresentIndexwise(WebDriver driver, String testCaseName, int indexwise) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isReqNamePresentIndexwise(driver, testCaseName, indexwise);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isReqNamePresentIndexwise " + e, e);
		}
		return false;
	}

	public static boolean isReqRequesterPresentIndexwise(WebDriver driver, String testCaseName, int indexwise) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isReqRequesterPresentIndexwise(driver, testCaseName, indexwise);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isReqRequesterPresentIndexwise " + e, e);
		}
		return false;
	}

	public static boolean isReqSubmittedonPresentIndexwise(WebDriver driver, String testCaseName, int indexwise) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isReqSubmittedonPresentIndexwise(driver, testCaseName, indexwise);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isReqSubmittedonPresentIndexwise " + e, e);
		}
		return false;
	}

	public static boolean isReqAmountPresentIndexwise(WebDriver driver, String testCaseName, int indexwise) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isReqAmountPresentIndexwise(driver, testCaseName, indexwise);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isReqAmountPresentIndexwise " + e, e);
		}
		return false;
	}

	public static void clickToApplyAscendingSort(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickToApplyAscendingSort(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyAscendingSort " + e, e);
		}

	}

	public static void clickToApplyDescendingSort(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickToApplyDescendingSort(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyDescendingSort " + e, e);
		}

	}

	public static void clickToApplyAscendingSortOnDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickToApplyAscendingSortOnDate(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyAscendingSortOnDate " + e, e);
		}

	}

	public static void clickToApplyDescendingSortOnDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickToApplyDescendingSortOnDate(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToApplyDescendingSortOnDate " + e, e);
		}

	}

	public static String fetchRequisitionSubumitionDateIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String number = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			number = myRequisition.fetchRequisitionSubumitionDateIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchRequisitionSubumitionDateIndexwise " + e, e);
		}
		return number;
	}

	public static boolean isReqStatusPresentInStatusFilter(WebDriver driver, String testCaseName, String id) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, id);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isReqStatusPresentInStatusFilter " + e, e);
		}
		return false;
	}

	public static List<WebElement> fetchRequisitionNumbers(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.fetchRequisitionNumbers(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchRequisitionSubumitionDateIndexwise " + e, e);
		}
		return null;
	}

	public static boolean clickOnLinkRemindApprover(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
		return myRequisition.clickOnLinkRemindApprover(driver, testCaseName);
	}

	public static boolean clickOnSubmitButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.clickOnSubmitButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSubmitButton " + e, e);
		}
		return false;
	}

	public static String getRequisitionExternalId(WebDriver driver, String testCaseName, String requisitonId) throws ActionBotException
	{
		String externalId = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			externalId = myRequisition.getRequisitionExternalId(driver, testCaseName, requisitonId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequisitionExternalId " + e, e);
		}
		return externalId;
	}

	public static String getRequisitionId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqId = null;
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			reqId = myRequisition.getRequisitionId(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequisitionExternalId " + e, e);
		}
		return reqId;
	}

	public static void clickOnRecallLink_ReqHover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnRecallLink_ReqHover(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRecallLink_ReqHover " + e, e);
		}

	}

	public static void clearRequisitionNameFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();

			myRequisition.clearRequisitionNameFilter(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clear requisition name in filter " + e, e);
		}

	}

	public static void clearRequisitionNumberFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();

			myRequisition.clearRequisitionNumberFilter(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clear requisition name in filter " + e, e);
		}

	}

	public static void clickOnExpandInProcessInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnExpandInProcessInStatusFilterBtn(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnExpandInProcessInStatusFilterBtn " + e, e);
		}

	}

	public static void clickOnExpandReleasedInProcessInStatusFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickOnExpandReleasedInProcessInStatusFilterBtn(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnExpandReleasedInProcessInStatusFilterBtn " + e, e);
		}

	}

	/*
	 * author - bhakti sawant
	 * client specific- sawater
	 */
	public static boolean isPopUpProceedWithReqAndExistingCartItemsPreset(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isPopUpProceedWithReqAndExistingCartItemsPreset(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPopUpProceedWithReqAndExistingCartItemsPreset " + e, e);
		}
		return false;
	}

	/*
	 * author - bhakti sawant
	 * client specific- sawater
	 */
	public static void clickProceedWithReqAndExistingCartItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickProceedWithReqAndExistingCartItems(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickProceedWithReqAndExistingCartItems " + e, e);
		}

	}

	/*
	 * author - bhakti sawant
	 * client specific- sawater
	 */
	public static boolean isPopUpProceedOnlyWithReqItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			return myRequisition.isPopUpProceedOnlyWithReqItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPopUpProceedOnlyWithReqItems " + e, e);
		}
		return false;
	}

	/*
	 * author - bhakti sawant
	 * client specific- sawater
	 */
	public static void clickProceedOnlyWithReqItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			myRequisition.clickProceedOnlyWithReqItems(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickProceedOnlyWithReqItems " + e, e);
		}

	}

	public static String fillCancelComment(WebDriver driver, String testCaseName, String cancelcommnet) throws ActionBotException
	{
		try
		{
			IPageMyRequisition myRequisition = FactoryPage.getInstanceOfIPageMyRequisition();
			cancelcommnet = myRequisition.fillCancelComment(driver, testCaseName, cancelcommnet);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCancelComment " + e, e);
		}
		return cancelcommnet;
	}
}
