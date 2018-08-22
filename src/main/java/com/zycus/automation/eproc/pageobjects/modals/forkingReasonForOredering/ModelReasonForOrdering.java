package com.zycus.automation.eproc.pageobjects.modals.forkingReasonForOredering;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModelReasonForOrdering
{
	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public void clickCancleReasonForOrdering(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReasonForOrdering comSupplier = FactoryModal.getInstanceOfIModelReasonForOrdering();
			comSupplier.clickCancleReasonForOrdering(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCancleReasonForOrdering " + e, e);
		}

	}

	public void clickSaveReasonForOrdering(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelReasonForOrdering comSupplier = FactoryModal.getInstanceOfIModelReasonForOrdering();
			comSupplier.clickSaveReasonForOrdering(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSaveReasonForOrdering " + e, e);
		}

	}

	public String provideReasonForOrdering(WebDriver driver, String testCaseName, String supplierComment) throws ActionBotException
	{
		String reason = null;
		try
		{
			IModelReasonForOrdering comSupplier = FactoryModal.getInstanceOfIModelReasonForOrdering();
			reason = comSupplier.provideReasonForOrdering(driver, testCaseName, supplierComment);
			if (reason.equalsIgnoreCase(supplierComment))
			{
				return reason;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method provideReasonForOrdering " + e, e);
		}
		return null;
	}
}
