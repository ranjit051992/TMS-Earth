package com.zycus.automation.iConsole.pageObjects.pages.apiConsole;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author kunal.ashar
 */
public class PageApiConsole
{
	static Logger logger = Logger.getLogger(PageApiConsole.class);

	public static void clickOnLinkAuthenticate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			apiConsole.clickOnLinkAuthenticate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnLinkAuthenticate " + e, e);
		}
	}

	public static void clickOnButtonGoAuthenticationMechanismPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			apiConsole.clickOnButtonGoAuthenticationMechanismPopup(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnButtonGoAuthenticationMechanismPopup " + e, e);
		}
	}

	public static void fillTextMpin(WebDriver driver, String testCaseName, String mPin) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			apiConsole.fillTextMpin(driver, testCaseName, mPin);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillTextMpin " + e, e);
		}
	}

	public static void clickOnButtonGoAuthenticationPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			apiConsole.clickOnButtonGoAuthenticationPopup(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnButtonGoAuthenticationPopup " + e, e);
		}
	}

	public static boolean verifyAuthenticationSuccessMessage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			return apiConsole.verifyAuthenticationSuccessMessage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method verifyAuthenticationSuccessMessage " + e, e);
		}
		return false;
	}

	public static void clickOnButtonOkSuccessMessage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			apiConsole.clickOnButtonOkSuccessMessage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnButtonOkSuccessMessage " + e, e);
		}
	}

	public static void clickOnLinkEprocHeaderMenu(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			apiConsole.clickOnLinkEprocHeaderMenu(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnLinkEprocHeaderMenu " + e, e);
		}
	}

	public static boolean clickOnLinkSearchUnderEprocMenu(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			return apiConsole.clickOnLinkSearchUnderEprocMenu(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnLinkSearchUnderEprocMenu " + e, e);
		}
		return false;
	}

	public static boolean clickOnLinkUpdateUnderEprocMenu(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			return apiConsole.clickOnLinkUpdateUnderEprocMenu(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnLinkUpdateUnderEprocMenu " + e, e);
		}
		return false;
	}

	public static void clickOnApiEprocApprovals(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			apiConsole.clickOnApiEprocApprovals(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApiEprocApprovals " + e, e);
		}
	}

	public static boolean clickOnApiEprocRequisitonApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			return apiConsole.clickOnApiEprocRequisitonApproval(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApiEprocRequisitonApproval " + e, e);
		}
		return false;
	}

	public static String fillRequisitonId(WebDriver driver, String testCaseName, String reqId) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			return apiConsole.fillRequisitonId(driver, testCaseName, reqId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillRequisitonId " + e, e);
		}
		return null;
	}

	public static String fillRequisitionApprovalAction(WebDriver driver, String testCaseName, String reqAction) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			return apiConsole.fillRequisitionApprovalAction(driver, testCaseName, reqAction);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillRequisitionApprovalAction " + e, e);
		}
		return null;
	}

	public static void clickOnButtonTryItReqApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			apiConsole.clickOnButtonTryItReqApproval(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnButtonTryItReqApproval " + e, e);
		}
	}

	public static void clickOnTabResponseBodyReqApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			apiConsole.clickOnTabResponseBodyReqApproval(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnTabResponseBodyReqApproval " + e, e);
		}
	}

	public static String getApiResponseBodyReqApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			return apiConsole.getApiResponseBodyReqApproval(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getApiResponseBodyReqApproval " + e, e);
		}
		return null;
	}

	public static boolean clickOnApiEprocPOApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			return apiConsole.clickOnApiEprocPOApproval(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApiEprocPOApproval " + e, e);
		}
		return false;
	}

	public static String fillPurchaseOrderId(WebDriver driver, String testCaseName, String poId) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			return apiConsole.fillPurchaseOrderId(driver, testCaseName, poId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPurchaseOrderId " + e, e);
		}
		return null;
	}

	public static String fillPOApprovalAction(WebDriver driver, String testCaseName, String purchaseOrderAction) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			return apiConsole.fillPOApprovalAction(driver, testCaseName, purchaseOrderAction);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPOApprovalAction " + e, e);
		}
		return null;
	}

	public static void clickOnButtonTryItPOApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			apiConsole.clickOnButtonTryItPOApproval(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnButtonTryItPOApproval " + e, e);
		}
	}

	public static void clickOnTabResponseBodyPOApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			apiConsole.clickOnTabResponseBodyPOApproval(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnTabResponseBodyPOApproval " + e, e);
		}
	}

	public static String getApiResponseBodyPOApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageApiConsole apiConsole = FactoryPage.getInstanceOfIPageApiConsole();
			return apiConsole.getApiResponseBodyPOApproval(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getApiResponseBodyPOApproval " + e, e);
		}
		return null;
	}
}
