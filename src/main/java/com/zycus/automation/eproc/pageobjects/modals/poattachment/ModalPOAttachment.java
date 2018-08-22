/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.poattachment;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.eproc.pageobjects.modals.defaultattachfilemodal.IModalDefaultAttachFile;
import com.zycus.automation.eproc.pageobjects.modals.defaultattachfilemodal.IModalDefaultAttachFileImpl;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public class ModalPOAttachment
{
	static Logger logger = Logger.getLogger(ModalPOAttachment.class);

	public static void fillAttachmentFileName(WebDriver driver, String testCaseName, String fileName) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			defaultAttachFile.fillAttachmentFileName(driver, testCaseName, fileName, IModalPOAttachment.INPUT_PO_ATTACHMENT);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAttachmentFileName " + e, e);
		}
	}

	public static String selectVisibility(WebDriver driver, String testCaseName, String visibilityValue, String attachmentName) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			UI_Elements elements = UIFactory.getUIElement(By.xpath(".//tr[.//div[contains(text(),'" + attachmentName + "')]]//select[contains(@class,'attachmentVisibility')]"));
			return defaultAttachFile.selectItemVisibility(driver, testCaseName, elements, visibilityValue);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectVisibility " + e, e);
		}
		return null;
	}

	public static String getAttachmentName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			return defaultAttachFile.getAttachmentName(driver, testCaseName, IModalPOAttachment.LABEL_PO_ATTACHMENT_NAME);
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
			return defaultAttachFile.getAttachmentStatus(driver, testCaseName, IModalPOAttachment.LABEL_PO_ATTACHMENT_STATUS);
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
			return defaultAttachFile.getAttachmentSize(driver, testCaseName, IModalPOAttachment.LABEL_PO_ATTACHMENT_SIZE);
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
			defaultAttachFile.clickOnDoneButton(driver, testCaseName, IModalPOAttachment.BUTTON_DONE_PO_ATTACHMENT);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDoneButton " + e, e);
		}
	}

	public static void clickOnDownloadAttachment(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			defaultAttachFile.clickOnDownloadAttachment(driver, testCaseName, IModalPOAttachment.LINK_DOWNLOAD_PO_ATTACHMENT);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDownloadAttachment " + e, e);
		}
	}
}
