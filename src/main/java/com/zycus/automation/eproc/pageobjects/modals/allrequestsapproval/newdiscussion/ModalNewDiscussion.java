/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.allrequestsapproval.newdiscussion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalNewDiscussion
{
	static Logger logger = Logger.getLogger(ModalNewDiscussion.class);

	public static String fillToFieldForNewDiscussion(WebDriver driver, String testCaseName, String to) throws ActionBotException
	{
		try
		{
			IModalNewDiscussion newDiscussionImpl = FactoryPage.getInstanceOf(IModalNewDiscussionImpl.class);
			return newDiscussionImpl.fillToFieldForNewDiscussion(driver, testCaseName, to);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillToFieldForNewDiscussion " + e, e);
		}
		return null;
	}

	public static String fillMessageForNewDiscussion(WebDriver driver, String testCaseName, String message) throws ActionBotException
	{
		try
		{
			IModalNewDiscussion newDiscussionImpl = FactoryPage.getInstanceOf(IModalNewDiscussionImpl.class);
			return newDiscussionImpl.fillMessageForNewDiscussion(driver, testCaseName, message);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMessageForNewDiscussion " + e, e);
		}
		return null;
	}

	public static void fillAttachmentFileName(WebDriver driver, String testCaseName, String fileName) throws ActionBotException
	{
		try
		{
			IModalNewDiscussion newDiscussionImpl = FactoryPage.getInstanceOf(IModalNewDiscussionImpl.class);
			newDiscussionImpl.fillAttachmentFileName(driver, testCaseName, fileName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAttachmentFileName " + e, e);
		}
	}

	public static void selectAllOptionForSharedWith(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalNewDiscussion newDiscussionImpl = FactoryPage.getInstanceOf(IModalNewDiscussionImpl.class);
			newDiscussionImpl.selectAllOptionForSharedWith(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAllOptionForSharedWith " + e, e);
		}
	}

	public static void selectRequesterOptionForSharedWith(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalNewDiscussion newDiscussionImpl = FactoryPage.getInstanceOf(IModalNewDiscussionImpl.class);
			newDiscussionImpl.selectRequesterOptionForSharedWith(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectRequesterOptionForSharedWith " + e, e);
		}
	}

	public static void selectApproverOptionForSharedWith(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalNewDiscussion newDiscussionImpl = FactoryPage.getInstanceOf(IModalNewDiscussionImpl.class);
			newDiscussionImpl.selectApproverOptionForSharedWith(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectApproverOptionForSharedWith " + e, e);
		}
	}

	public static void selectBuyerOptionForSharedWith(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalNewDiscussion newDiscussionImpl = FactoryPage.getInstanceOf(IModalNewDiscussionImpl.class);
			newDiscussionImpl.selectBuyerOptionForSharedWith(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectBuyerOptionForSharedWith " + e, e);
		}
	}

	public static void clickOnSubmitButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalNewDiscussion newDiscussionImpl = FactoryPage.getInstanceOf(IModalNewDiscussionImpl.class);
			newDiscussionImpl.clickOnSubmitButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSubmitButton " + e, e);
		}
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalNewDiscussion newDiscussionImpl = FactoryPage.getInstanceOf(IModalNewDiscussionImpl.class);
			newDiscussionImpl.clickOnCancelButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelButton " + e, e);
		}
	}

}
