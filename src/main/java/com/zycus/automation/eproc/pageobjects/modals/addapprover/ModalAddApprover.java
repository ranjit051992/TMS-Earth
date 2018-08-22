/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.addapprover;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalAddApprover
{
	static Logger logger = Logger.getLogger(ModalAddApprover.class);

	public static String fillApproverName(WebDriver driver, String testCaseName, String approverName) throws ActionBotException
	{
		try
		{
			IModalAddApprover modalAddApprover = FactoryPage.getInstanceOf(IModalAddApproverImpl.class);
			return modalAddApprover.fillApproverName(driver, testCaseName, approverName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in fillApproverName method" + e, e);
		}
		return null;
	}

	public static String selectRequireApprovalAfter(WebDriver driver, String testCaseName, int optionIndex) throws ActionBotException
	{
		try
		{
			IModalAddApprover modalAddApprover = FactoryPage.getInstanceOf(IModalAddApproverImpl.class);
			return modalAddApprover.selectRequireApprovalAfter(driver, testCaseName, optionIndex);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in selectRequireApprovalAfter method" + e, e);
		}
		return null;
	}

	public static String getAddedApproverName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddApprover modalAddApprover = FactoryPage.getInstanceOf(IModalAddApproverImpl.class);
			return modalAddApprover.getAddedApproverName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in getAddedApproverName method" + e, e);
		}
		return null;
	}

	public static String getAddedApproverExtraInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddApprover modalAddApprover = FactoryPage.getInstanceOf(IModalAddApproverImpl.class);
			return modalAddApprover.getAddedApproverExtraInfo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in getAddedApproverExtraInfo method" + e, e);
		}
		return null;
	}

	public static void clickOnSaveAddApprover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddApprover modalAddApprover = FactoryPage.getInstanceOf(IModalAddApproverImpl.class);
			modalAddApprover.clickOnSaveAddApprover(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnSaveAddApprover method" + e, e);
		}
	}

	public static void clickOnCancelAddApprover(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddApprover modalAddApprover = FactoryPage.getInstanceOf(IModalAddApproverImpl.class);
			modalAddApprover.clickOnCancelAddApprover(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnCancelAddApprover method" + e, e);
		}
	}

	public static boolean isSelectNodesNamesErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddApprover modalAddApprover = FactoryPage.getInstanceOf(IModalAddApproverImpl.class);
			return modalAddApprover.isSelectNodesNamesErrorPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in isSelectNodesNamesErrorPresent method" + e, e);
		}
		return false;
	}

	public static boolean isDuplicateWorkflowActorNameErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalAddApprover modalAddApprover = FactoryPage.getInstanceOf(IModalAddApproverImpl.class);
			return modalAddApprover.isDuplicateWorkflowActorNameErrorPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in isDuplicateWorkflowActorNameErrorPresent method" + e, e);
		}
		return false;
	}

	public static String getAddedApproverName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IModalAddApprover modalAddApprover = FactoryPage.getInstanceOf(IModalAddApproverImpl.class);
			return modalAddApprover.getAddedApproverName(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in getAddedApproverName method" + e, e);
		}
		return null;
	}

	public static String getAddedApproverExtraInfo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IModalAddApprover modalAddApprover = FactoryPage.getInstanceOf(IModalAddApproverImpl.class);
			return modalAddApprover.getAddedApproverExtraInfo(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in getAddedApproverExtraInfo method" + e, e);
		}
		return null;
	}

	public static String selectRequireApprovalAfter(WebDriver driver, String testCaseName, String option) throws ActionBotException
	{
		try
		{
			IModalAddApprover modalAddApprover = FactoryPage.getInstanceOf(IModalAddApproverImpl.class);
			return modalAddApprover.selectRequireApprovalAfter(driver, testCaseName, option);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in selectRequireApprovalAfter method" + e, e);
		}
		return null;
	}

}
