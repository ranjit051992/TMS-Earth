/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentapprove;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.documentreject.IModalAllRequestsApprovalDocumentReject;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalAllRequestsApprovalDocumentApprove
{

	static Logger logger = Logger.getLogger(ModalAllRequestsApprovalDocumentApprove.class);

	public static String fillApprovalComment(WebDriver driver, String testCaseName, String approvalComment) throws ActionBotException
	{
		String result = null;
		try
		{
			IModalAllRequestsApprovalDocumentApprove documentApprove = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentApprove();
			result = documentApprove.fillApprovalComment(driver, testCaseName, approvalComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillApprovalComment " + e, e);
		}
		return result;
	}

	public static String getApprovalComment(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IModalAllRequestsApprovalDocumentApprove documentApprove = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentApprove();
			result = documentApprove.getApprovalComment(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getApprovalComment " + e, e);
		}
		return result;
	}

	public static boolean clickOnApproveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalDocumentApprove documentApprove = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentApprove();
			return documentApprove.clickOnApproveButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApproveButton " + e, e);
			return false;
		}
	}

	public static void clickOnCloseButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalDocumentApprove documentApprove = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentApprove();
			documentApprove.clickOnCloseButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseButton " + e, e);
		}
	}

	public static String getApprovedAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalDocumentApprove documentApprove = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentApprove();
			return documentApprove.getApprovedAmount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getApprovedAmount " + e, e);
		}
		return null;
	}

	public static String fillApprovedAmount(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalDocumentApprove documentApprove = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentApprove();
			return documentApprove.fillApprovedAmount(driver, testCaseName, amount);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillApprovedAmount " + e, e);
		}
		return null;
	}

	public static boolean approveMultipleItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		System.out.println();
		IModalAllRequestsApprovalDocumentApprove documentApprove;
		try
		{
			documentApprove = FactoryModal.getInstanceOfIModalAllRequestsApprovalDocumentApprove();
			return documentApprove.approveMultipleItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method approveMultipleItems " + e, e);
			return false;
		}
	}

}
