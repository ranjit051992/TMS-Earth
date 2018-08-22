/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentdelegate;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalAllRequestsApprovalDocumentDelegate
{
	static Logger logger = Logger.getLogger(ModalAllRequestsApprovalDocumentDelegate.class);

	public static String fillDelegateComments(WebDriver driver, String testCaseName, String delegateComment) throws ActionBotException
	{
		String result = null;
		try
		{
			IModalAllRequestsApprovalDocumentDelegate approvalDocumentDelegate = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentDelegate();
			result = approvalDocumentDelegate.fillDelegateComments(driver, testCaseName, delegateComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDelegateComments " + e, e);
		}

		return result;

	}

	public static String getDelegateComments(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IModalAllRequestsApprovalDocumentDelegate approvalDocumentDelegate = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentDelegate();
			result = approvalDocumentDelegate.getDelegateComments(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDelegateComments " + e, e);
		}

		return result;
	}

	public static String fillDelegateToName(WebDriver driver, String testCaseName, String delegateTo) throws ActionBotException
	{
		String result = null;
		try
		{
			IModalAllRequestsApprovalDocumentDelegate approvalDocumentDelegate = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentDelegate();
			result = approvalDocumentDelegate.fillDelegateToName(driver, testCaseName, delegateTo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillDelegateToName " + e, e);
		}

		return result;
	}

	public static String getDelegateToName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IModalAllRequestsApprovalDocumentDelegate approvalDocumentDelegate = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentDelegate();
			result = approvalDocumentDelegate.getDelegateToName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDelegateToName " + e, e);
		}

		return result;
	}

	public static void clickOnDelegateSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalDocumentDelegate approvalDocumentDelegate = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentDelegate();
			approvalDocumentDelegate.clickOnDelegateSaveButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDelegateSaveButton " + e, e);
		}
	}

	public static void clickOnDelegateCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalDocumentDelegate approvalDocumentDelegate = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentDelegate();
			approvalDocumentDelegate.clickOnDelegateCancelButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDelegateCancelButton " + e, e);
		}

	}

	public static boolean delegateMultipleItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalDocumentDelegate approvalDocumentDelegate = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentDelegate();
			return approvalDocumentDelegate.delegateMultipleItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method delegateMultipleItems " + e, e);
		}
		return false;
	}

}
