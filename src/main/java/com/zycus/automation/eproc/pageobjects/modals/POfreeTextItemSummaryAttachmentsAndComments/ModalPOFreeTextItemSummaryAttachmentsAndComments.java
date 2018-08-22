package com.zycus.automation.eproc.pageobjects.modals.POfreeTextItemSummaryAttachmentsAndComments;

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

public class ModalPOFreeTextItemSummaryAttachmentsAndComments
{
	static Logger logger = Logger.getLogger(ModalPOFreeTextItemSummaryAttachmentsAndComments.class);

	public static void clickOnAttachmentsAndComments(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryAttachmentsAndComments iModalPOFreeTextItemSummaryAttachmentsAndComments = FactoryPage
			.getInstanceOf(IModalPOFreeTextItemSummaryAttachmentsAndCommentsImpl.class);
		iModalPOFreeTextItemSummaryAttachmentsAndComments.clickOnAttachmentsAndComments(driver, testCaseName);
	}

	public static String enterInternalComments(WebDriver driver, String testCaseName, String inetrnalComments) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryAttachmentsAndComments iModalPOFreeTextItemSummaryAttachmentsAndComments = FactoryPage
			.getInstanceOf(IModalPOFreeTextItemSummaryAttachmentsAndCommentsImpl.class);
		return iModalPOFreeTextItemSummaryAttachmentsAndComments.enterInternalComments(driver, testCaseName, inetrnalComments);
	}

	public static String enterCommentsForSupplier(WebDriver driver, String testCaseName, String commentsForSupplier) throws ActionBotException, FactoryMethodException
	{

		IModalPOFreeTextItemSummaryAttachmentsAndComments iModalPOFreeTextItemSummaryAttachmentsAndComments = FactoryPage
			.getInstanceOf(IModalPOFreeTextItemSummaryAttachmentsAndCommentsImpl.class);
		return iModalPOFreeTextItemSummaryAttachmentsAndComments.enterCommentsForSupplier(driver, testCaseName, commentsForSupplier);
	}

	public static void fillAttachmentFileName(WebDriver driver, String testCaseName, String fileName) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			defaultAttachFile.fillAttachmentFileName(driver, testCaseName, fileName, IModalPOFreeTextItemSummaryAttachmentsAndComments.INPUT_PO_ITEM_LEVEL_ATTACHMENT);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAttachmentFileName " + e, e);
		}
	}

	public static String getAttachmentName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			UI_Elements elements = UIFactory.getUIElement(By.xpath(".//*[@id='poItemAttachments']//tr[" + index + "]//div[contains(@class,'attachmentName')]"));
			return defaultAttachFile.getAttachmentName(driver, testCaseName, elements);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAttachmentName " + e, e);
		}
		return null;
	}

	public static String getAttachmentStatus(WebDriver driver, String testCaseName, String attachmentName) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			UI_Elements elements = UIFactory.getUIElement(By.xpath(".//*[@id='poItemAttachments']//*[.//*[text()='" + attachmentName + "']]/td[contains(@class,'status')]"));
			return defaultAttachFile.getAttachmentStatus(driver, testCaseName, elements);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAttachmentStatus " + e, e);
		}
		return null;
	}

	public static String getAttachmentSize(WebDriver driver, String testCaseName, String attachmentName) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			UI_Elements elements = UIFactory
				.getUIElement(By.xpath(".//*[@id='poItemAttachments']//*[.//*[text()='" + attachmentName + "']]/td[contains(@class,'attachmentSize')]"));
			return defaultAttachFile.getAttachmentSize(driver, testCaseName, elements);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAttachmentSize " + e, e);
		}
		return null;
	}

	public static String selectVisibility(WebDriver driver, String testCaseName, String visibilityValue, String attachmentName) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			UI_Elements elements = UIFactory
				.getUIElement(By.xpath(".//*[@id='poItemAttachments']//tr[.//div[@title='" + attachmentName + "']]//select[@name='attachmentVisibility']"));
			return defaultAttachFile.selectItemVisibility(driver, testCaseName, elements, visibilityValue);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectVisibility " + e, e);
		}
		return null;
	}

}
