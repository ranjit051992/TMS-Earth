/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.allrequestsapprovalactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalAllRequestsApprovalActions
{

	static Logger logger = Logger.getLogger(ModalAllRequestsApprovalActions.class);

	public static void clickOnViewOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalActions allRequestsApprovalActions = FactoryModal.getInstanceOfIModelAllRequestsApprovalActions();
			allRequestsApprovalActions.clickOnViewOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnViewOption " + e, e);
		}

	}

	public static void clickOnApproveOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalActions allRequestsApprovalActions = FactoryModal.getInstanceOfIModelAllRequestsApprovalActions();
			allRequestsApprovalActions.clickOnApproveOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApproveOption " + e, e);
		}

	}

	public static void clickOnRejectOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalActions allRequestsApprovalActions = FactoryModal.getInstanceOfIModelAllRequestsApprovalActions();
			allRequestsApprovalActions.clickOnRejectOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRejectOption " + e, e);
		}

	}

	public static void clickOnDelegateOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalActions allRequestsApprovalActions = FactoryModal.getInstanceOfIModelAllRequestsApprovalActions();
			allRequestsApprovalActions.clickOnDelegateOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDelegateOption " + e, e);
		}

	}

	public static void clickOnMoreInfoOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalActions allRequestsApprovalActions = FactoryModal.getInstanceOfIModelAllRequestsApprovalActions();
			allRequestsApprovalActions.clickOnMoreInfoOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnMoreInfoOption " + e, e);
		}

	}

	public static void clickOnApproveOptionForMultipleDoc(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalActions allRequestsApprovalActions = FactoryModal.getInstanceOfIModelAllRequestsApprovalActions();
			allRequestsApprovalActions.clickOnApproveOptionForMultipleDoc(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnApproveOptionForMultipleDoc " + e, e);
		}
	}

	public static void clickOnRejectOptionForMultipleDoc(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalActions allRequestsApprovalActions = FactoryModal.getInstanceOfIModelAllRequestsApprovalActions();
			allRequestsApprovalActions.clickOnRejectOptionForMultipleDoc(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRejectOptionForMultipleDoc " + e, e);
		}
	}

	public static void clickOnDelegateOptionForMultipleDoc(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAllRequestsApprovalActions allRequestsApprovalActions = FactoryModal.getInstanceOfIModelAllRequestsApprovalActions();
			allRequestsApprovalActions.clickOnDelegateOptionForMultipleDoc(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDelegateOptionForMultipleDoc " + e, e);
		}
	}

}
