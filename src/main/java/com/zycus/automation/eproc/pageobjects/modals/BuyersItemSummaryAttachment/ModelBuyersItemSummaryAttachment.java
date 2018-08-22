package com.zycus.automation.eproc.pageobjects.modals.BuyersItemSummaryAttachment;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryAttachment.IModelItemSummaryAttachment;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModelBuyersItemSummaryAttachment
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

}
