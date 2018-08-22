/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingreturnreq;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalBuyersDeskReturnRequisition
{
	static Logger logger = Logger.getLogger(ModalBuyersDeskReturnRequisition.class);

	public static String fillReturnRequisitionComment(WebDriver driver, String testCaseName, String returnComment) throws ActionBotException
	{
		try
		{
			IModalBuyersDeskReturnRequisition buyersDeskReturnRequisition = FactoryPage.getInstanceOf(IModalBuyersDeskReturnRequisitionImpl.class);
			return buyersDeskReturnRequisition.fillReturnRequisitionComment(driver, testCaseName, returnComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReturnRequisitionComment " + e, e);
		}
		return null;
	}

	public static void clickOnReqResubmit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBuyersDeskReturnRequisition buyersDeskReturnRequisition = FactoryPage.getInstanceOf(IModalBuyersDeskReturnRequisitionImpl.class);
			buyersDeskReturnRequisition.clickOnReqResubmit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReqResubmit " + e, e);
		}
	}

	public static void clickOnReturnReqButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBuyersDeskReturnRequisition buyersDeskReturnRequisition = FactoryPage.getInstanceOf(IModalBuyersDeskReturnRequisitionImpl.class);
			buyersDeskReturnRequisition.clickOnReturnReqButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReturnReqButton " + e, e);
		}
	}

	public static void clickOnCancelReqButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalBuyersDeskReturnRequisition buyersDeskReturnRequisition = FactoryPage.getInstanceOf(IModalBuyersDeskReturnRequisitionImpl.class);
			buyersDeskReturnRequisition.clickOnCancelReqButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelReqButton " + e, e);
		}
	}

	public static void clickOnReturnReqFromBuyersDesk(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBuyersDeskReturnRequisition buyersDeskReturnRequisition = FactoryPage.getInstanceOf(IModalBuyersDeskReturnRequisitionImpl.class);
		buyersDeskReturnRequisition.clickOnReturnReqFromBuyersDesk(driver, testCaseName);
	}

	public static boolean isReturnReqComentPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBuyersDeskReturnRequisition buyersDeskReturnRequisition = FactoryPage.getInstanceOf(IModalBuyersDeskReturnRequisitionImpl.class);
		return buyersDeskReturnRequisition.isReturnReqComentPresent(driver, testCaseName);
	}

}
