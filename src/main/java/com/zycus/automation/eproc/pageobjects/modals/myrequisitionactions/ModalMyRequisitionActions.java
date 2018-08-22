package com.zycus.automation.eproc.pageobjects.modals.myrequisitionactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalMyRequisitionActions
{

	static Logger logger = Logger.getLogger(ModalMyRequisitionActions.class);

	public static void clickOnEditLink(WebDriver driver, String testcaseName) throws ActionBotException
	{

		try
		{
			IModalMyRequisitionActions actions = FactoryModal.getInstanceOfIModalMyRequisitionActions();
			actions.clickOnEditLink(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEditLink " + e, e);
		}
	}

	public static void clickOnDeleteLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalMyRequisitionActions actions = FactoryModal.getInstanceOfIModalMyRequisitionActions();
			actions.clickOnDeleteLink(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeleteLink " + e, e);
		}
	}

	public static void clickOnRecallApproveRequestLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalMyRequisitionActions actions = FactoryModal.getInstanceOfIModalMyRequisitionActions();
			actions.clickOnRecallApproveRequestLink(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRecallApproveRequestLink " + e, e);
		}

	}

	public static void clickOnRemindApproverLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalMyRequisitionActions actions = FactoryModal.getInstanceOfIModalMyRequisitionActions();
			actions.clickOnRemindApproverLink(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRemindApproverLink " + e, e);
		}

	}

	public static void clickOnCopyLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalMyRequisitionActions actions = FactoryModal.getInstanceOfIModalMyRequisitionActions();
			actions.clickOnCopyLink(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCopyLink " + e, e);
		}

	}

	public static void clickOnCancelLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalMyRequisitionActions actions = FactoryModal.getInstanceOfIModalMyRequisitionActions();
			actions.clickOnCancelLink(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelLink " + e, e);
		}

	}

	public static void clickOnCreateReceiptLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalMyRequisitionActions actions = FactoryModal.getInstanceOfIModalMyRequisitionActions();
			actions.clickOnCreateReceiptLink(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCreateReceiptLink " + e, e);
		}
	}

	public static void clickOnCloseLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalMyRequisitionActions actions = FactoryModal.getInstanceOfIModalMyRequisitionActions();
			actions.clickOnCloseLink(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseLink " + e, e);
		}
	}

	public static boolean isCloseLinkPresent(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IModalMyRequisitionActions actions = FactoryModal.getInstanceOfIModalMyRequisitionActions();
			return actions.isCloseLinkPresent(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCloseLinkPresent " + e, e);
		}
		return false;
	}

	public static void performRecallActions(WebDriver driver, String testcaseName, String recallActions) throws ActionBotException
	{
		try
		{
			IModalMyRequisitionActions actions = FactoryModal.getInstanceOfIModalMyRequisitionActions();
			actions.performRecallActions(driver, testcaseName, recallActions);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCloseLinkPresent " + e, e);
		}
	}
}
