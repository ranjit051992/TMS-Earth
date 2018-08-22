package com.zycus.automation.eproc.pageobjects.pages.requisitionForking;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageRequisitionForking
{
	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static void clickBackReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			forking.clickBackReq(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickBackReq " + e, e);
		}

	}

	public static void clickCancleReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			forking.clickCancleReq(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCancleReq " + e, e);
		}

	}

	public static void clickCommentsForSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			forking.clickCommentsForSupplier(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCommentsForSupplier " + e, e);
		}

	}

	public static void clickConfirmReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			forking.clickConfirmReq(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickConfirmReq " + e, e);
		}

	}

	public static void clickDraft(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			forking.clickDraft(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickDraft " + e, e);
		}

	}

	public static void clickForkedItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			forking.clickForkedItemName(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickForkedItemName " + e, e);
		}

	}

	public static void clickforkingLearn(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			forking.clickforkingLearn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickforkingLearn " + e, e);
		}

	}

	public static void clickOkWorkflow(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			forking.clickOkWorkflow(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOkWorkflow " + e, e);
		}

	}

	public static void clickReasonForOrdering(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			forking.clickReasonForOrdering(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickReasonForOrdering " + e, e);
		}

	}

	public static void clickSubmit(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			forking.clickSubmit(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSubmit " + e, e);
		}

	}

	public static void clickViewWorkflow(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			forking.clickViewWorkflow(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickViewWorkflow " + e, e);
		}

	}

	public static String getForkedItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String itemName = null;
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			itemName = forking.getForkedItemName(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getForkedItemName " + e, e);
		}
		return itemName;
	}

	public static String getForkedItemSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String itemSupplier = null;
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			itemSupplier = forking.getForkedItemSupplier(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getForkedItemSupplier " + e, e);
		}
		return itemSupplier;
	}

	public static String getForkedReqName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String reqName = null;
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			reqName = forking.getForkedReqName(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getForkedReqName " + e, e);
		}
		return reqName;
	}

	public static String getForkedReqNumber(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String reqNumber = null;
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			reqNumber = forking.getForkedReqNumber(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getForkedReqNumber " + e, e);
		}
		return reqNumber;
	}

	public static String getForkedReqTotalPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String totalprice = null;
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			totalprice = forking.getForkedReqTotalPrice(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getForkedReqTotalPrice " + e, e);
		}
		return totalprice;
	}

	public static String getForkedItemUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			return forking.getForkedItemUnitPrice(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getForkedItemUnitPrice " + e, e);
		}
		return null;
	}

	public static String getForkedItemQuantity(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			return forking.getForkedItemQuantity(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getForkedItemQuantity " + e, e);
		}
		return null;
	}

	public static List<WebElement> getListOfItemNamesOnForkingScreen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			return forking.getListOfItemNamesOnForkingScreen(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfItemNamesOnForkingScreen " + e, e);
		}
		return null;
	}

	public static List<String> getListOfPRNumbersOnForkingScreen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			return forking.getListOfPRNumbersOnForkingScreen(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfPRNumbersOnForkingScreen " + e, e);
		}
		return null;
	}

	public static String getAlertMessageForSubmittingForkedReqs(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			return forking.getAlertMessageForSubmittingForkedReqs(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAlertMessageForSubmittingForkedReqs " + e, e);
		}
		return null;
	}

	public static boolean isModifyWorkflowSettingsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			return forking.isModifyWorkflowSettingsPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isModifyWorkflowSettingsPresent " + e, e);
		}
		return false;
	}

	public static void clickOnSaveApprovalWorflow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			forking.clickOnSaveApprovalWorflow(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveApprovalWorflow " + e, e);
		}

	}

	public static void clickOnCheckboxModifyWorkflowSettings(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			forking.clickOnCheckboxModifyWorkflowSettings(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCheckboxModifyWorkflowSettings " + e, e);
		}
	}

	public static void clickOnCancelApprovalWorkflow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			forking.clickOnCancelApprovalWorkflow(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelApprovalWorkflow " + e, e);
		}
	}

	public static List<String> getListOfItemNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageRequisitionForking forking = FactoryPage.getInstanceOfIPageRequisitionForking();
			return forking.getListOfItemNames(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfItemNames " + e, e);
		}
		return null;
	}

}
