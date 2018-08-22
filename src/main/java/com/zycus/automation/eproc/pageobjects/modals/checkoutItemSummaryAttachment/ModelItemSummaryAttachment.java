package com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryAttachment;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.defaultattachfilemodal.IModalDefaultAttachFile;
import com.zycus.automation.eproc.pageobjects.modals.defaultattachfilemodal.IModalDefaultAttachFileImpl;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class ModelItemSummaryAttachment
{

	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static String fillAttachmentInternalComment(WebDriver driver, String testCaseName, String internalComment) throws ActionBotException
	{

		String internalComm = null;
		try
		{
			IModelItemSummaryAttachment itemSummary = FactoryModal.getInstanceOfIModelItemSummaryAttachment();
			internalComm = itemSummary.fillAttachmentInternalComment(driver, testCaseName, internalComment);
			if (internalComm.equalsIgnoreCase(internalComment))
			{
				return internalComm;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAttachmentInternalComment " + e, e);
		}
		return null;
	}

	public static String fillAttachmentSupplierlComment(WebDriver driver, String testCaseName, String supplierComment) throws ActionBotException
	{

		String supplierComm = null;
		try
		{
			IModelItemSummaryAttachment itemSummary = FactoryModal.getInstanceOfIModelItemSummaryAttachment();
			supplierComm = itemSummary.fillAttachmentSupplierlComment(driver, testCaseName, supplierComment);
			if (supplierComm.equalsIgnoreCase(supplierComment))
			{
				return supplierComm;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAttachmentSupplierlComment " + e, e);
		}
		return null;
	}

	public static void fillAttachmentFileName(WebDriver driver, String testCaseName, String fileName) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			defaultAttachFile.fillAttachmentFileName(driver, testCaseName, fileName, IModelItemSummaryAttachment.INPUT_SELECT_ITEM_LEVEL_ATTACHMENT_ON_CHECKOUT_PAGE);
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
			UI_Elements elements = UIFactory.getUIElement(By.xpath(".//*[@id='itemSummary']//tr[" + index + "]//div[contains(@class,'attachmentName')]"));
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
			UI_Elements elements = UIFactory.getUIElement(By.xpath(".//*[@id='itemSummary']//*[.//*[text()='" + attachmentName + "']]/td[contains(@class,'status')]"));
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
			UI_Elements elements = UIFactory.getUIElement(By.xpath(".//*[@id='itemSummary']//*[.//*[text()='" + attachmentName + "']]/td[contains(@class,'attachmentSize')]"));
			return defaultAttachFile.getAttachmentSize(driver, testCaseName, elements);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAttachmentSize " + e, e);
		}
		return null;
	}

	/*
	 * method to select visibility
	 */
	public static String selectVisibility(WebDriver driver, String testCaseName, String visibilityValue, String attachmentName) throws ActionBotException
	{
		try
		{
			IModalDefaultAttachFile defaultAttachFile = FactoryPage.getInstanceOf(IModalDefaultAttachFileImpl.class);
			UI_Elements elements = UIFactory.getUIElement(By.xpath(".//*[@id='itemSummary']//tr[.//*[text()='" + attachmentName + "']]//select[@name='attachmentVisibility']"));
			return defaultAttachFile.selectItemVisibility(driver, testCaseName, elements, visibilityValue);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectVisibility " + e, e);
		}
		return null;
	}

}
