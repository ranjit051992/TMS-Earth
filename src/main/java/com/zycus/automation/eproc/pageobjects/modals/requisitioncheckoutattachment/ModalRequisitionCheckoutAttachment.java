/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.requisitioncheckoutattachment;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.eproc.pageobjects.modals.defaultattachfilemodal.IModalDefaultAttachFile;
import com.zycus.automation.eproc.pageobjects.modals.defaultattachfilemodal.IModalDefaultAttachFileImpl;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalRequisitionCheckoutAttachment
{
	static Logger logger = Logger.getLogger(ModalRequisitionCheckoutAttachment.class);

	public static void fillAttachmentFileName(WebDriver driver, String testCaseName, String fileName) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			defaultAttachFile.fillAttachmentFileName(driver, testCaseName, fileName, IModalRequisitionCheckoutAttachment.INPUT_SELECT_ATTACHMENT_ON_CHECKOUT_PAGE);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAttachmentFileName " + e, e);
		}
	}

	public static String getAttachmentName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			return defaultAttachFile.getAttachmentName(driver, testCaseName, IModalRequisitionCheckoutAttachment.LABEL_ATTACHMENT_NAME_ON_CHECKOUT_PAGE);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAttachmentName " + e, e);
		}
		return null;
	}

	public static String getAttachmentStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			return defaultAttachFile.getAttachmentStatus(driver, testCaseName, IModalRequisitionCheckoutAttachment.LABEL_ATTACHMENT_STATUS_ON_CHECKOUT_PAGE);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAttachmentStatus " + e, e);
		}
		return null;
	}

	public static String getAttachmentSize(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			return defaultAttachFile.getAttachmentSize(driver, testCaseName, IModalRequisitionCheckoutAttachment.LABEL_ATTACHMENT_SIZE_ON_CHECKOUT_PAGE);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAttachmentSize " + e, e);
		}
		return null;
	}

	public static void clickOnDoneButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			defaultAttachFile.clickOnDoneButton(driver, testCaseName, IModalRequisitionCheckoutAttachment.BUTTON_DONE_ATTACHMENT_ON_CHECKOUT_PAGE);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDoneButton " + e, e);
		}
	}

}
