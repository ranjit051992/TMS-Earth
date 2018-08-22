/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentreject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalAllRequestsApprovalDocumentReject
{

	static Logger logger = Logger.getLogger(ModalAllRequestsApprovalDocumentReject.class);

	public static String fillRejectComment(WebDriver driver, String testCaseName, String rejectComment) throws ActionBotException
	{
		String result = null;
		try
		{
			IModalAllRequestsApprovalDocumentReject documentReject = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentReject();
			result = documentReject.fillRejectComment(driver, testCaseName, rejectComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillRejectComment " + e, e);
		}
		return result;
	}

	public static String getRejectComment(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IModalAllRequestsApprovalDocumentReject documentReject = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentReject();
			result = documentReject.getRejectComment(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRejectComment " + e, e);
		}
		return result;
	}

	public static void clickOnRejectButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalDocumentReject documentReject = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentReject();
			documentReject.clickOnRejectButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRejectButton " + e, e);
		}
	}

	public static void clickOnCloseButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalDocumentReject documentReject = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentReject();
			documentReject.clickOnCloseButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseButton " + e, e);
		}
	}

	public static boolean rejectMultipleItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalAllRequestsApprovalDocumentReject documentReject;
		try
		{
			documentReject = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentReject();
			return documentReject.rejectMultipleItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method rejectMultipleItems " + e, e);
		}
		return false;

	}
}
