package com.zycus.automation.eproc.pageobjects.modals.returnNoteItemAttachment;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModelReturnNoteItemAttachment
{
	static Logger logger = Logger.getLogger(ModelReturnNoteItemAttachment.class);

	public static List<WebElement> getWebElementCommentsAndAttachment(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			return returnNote.getWebElementCommentsAndAttachment(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getWebElementCommentAndAttachment" + e, e);
		}
		return null;
	}

	public static void clickOnCommentAndAttachment(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			returnNote.clickOnCommentAndAttachment(driver, testCaseName, element);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCommentAndAttachment" + e, e);
		}
	}

	public static String fillTextItemInternalComment(WebDriver driver, String testCaseName, String internalComment) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			return returnNote.fillTextItemInternalComment(driver, testCaseName, internalComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillTextInternalComment" + e, e);
		}
		return null;
	}

	public static String fillTextItemSupplierComment(WebDriver driver, String testCaseName, String supplierComment) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			return returnNote.fillTextItemSupplierComment(driver, testCaseName, supplierComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillTextSupplierComment" + e, e);
		}
		return null;
	}

	public static boolean selectFileForAttachmentInItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			return returnNote.selectFileForAttachmentInItem(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectFileForAttachmentInItem" + e, e);
		}
		return false;

	}

	public static boolean selectFileForAttachmentHeaderLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			return returnNote.selectFileForAttachmentHeaderLevel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectFileForAttachmentHeaderLevel" + e, e);
		}
		return false;
	}

	public static void selectSupplierInAttachmentVisibility(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			returnNote.selectSupplierInAttachmentVisibility(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectSupplierInAttachmentVisibility" + e, e);
		}
	}

	public static void selectSupplierInAttachmentVisibilityAtItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			returnNote.selectSupplierInAttachmentVisibilityAtItemLevel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectSupplierInAttachmentVisibilityAtItemLevel" + e, e);
		}
	}

	public static void clickOnSaveAttachmentButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			returnNote.clickOnSaveAttachmentButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveAttachmentButton" + e, e);
		}
	}

	public static void clickOnSaveAttachmentOkButtonItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			returnNote.clickOnSaveAttachmentOkButtonItemLevel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveAttachmentOkButtonItemLevel" + e, e);
		}
	}

	public static void clickOnCloseAttachmentbutton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			returnNote.clickOnCloseAttachmentbutton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseAttachmentButton" + e, e);
		}
	}

	public static String getValueOfAttachmentVisibility(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			return returnNote.getValueOfAttachmentVisibility(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getValueOfAttachmentVisibility" + e, e);
		}
		return null;
	}

	public static boolean checkSupplierCommentTextFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			return returnNote.checkSupplierCommentTextFieldPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkSupplierCommentTextFieldPresent" + e, e);
		}
		return false;
	}

	public static boolean checkSupplierFieldInAttachmentVisibility(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			return returnNote.checkSupplierFieldInAttachmentVisibility(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkSupplierFieldInAttachmentVisibility" + e, e);
		}
		return false;
	}

	public static boolean checkSupplierFieldInAttachmentVisibilityItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			return returnNote.checkSupplierFieldInAttachmentVisibilityItemLevel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkSupplierFieldInAttachmentVisibilityItemLevel" + e, e);
		}
		return false;
	}

	public static String getAttachmentVisibilityWhenNotifySupplierUncheck(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			return returnNote.getAttachmentVisibilityWhenNotifySupplierUncheck(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAttachmentVisibilityWhenNotifySupplierUncheck" + e, e);
		}
		return null;
	}

	public static String getAttachmentVisibilityWhenNotifySupplierUncheckItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReturnNoteItemAttachment returnNote = FactoryPage.getInstanceOf(IModelReturnNoteItemAttachmentImpl.class);
			return returnNote.getAttachmentVisibilityWhenNotifySupplierUncheckItemLevel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAttachmentVisibilityWhenNotifySupplierUncheckItemLevel" + e, e);
		}
		return null;
	}
}
