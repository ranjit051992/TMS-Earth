package com.zycus.automation.eproc.pageobjects.modals.forkingCommentsForSupplier;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModelCommentsForSupplier
{
	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public void clickCancleCommentsForSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelCommentsForSupplier comSupplier = FactoryModal.getInstanceOfIModelCommentsForSupplier();
			comSupplier.clickCancleCommentsForSupplier(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCancleCommentsForSupplier " + e, e);
		}

	}

	public void clickSaveCommentsForSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IModelCommentsForSupplier comSupplier = FactoryModal.getInstanceOfIModelCommentsForSupplier();
			comSupplier.clickSaveCommentsForSupplier(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSaveCommentsForSupplier " + e, e);
		}

	}

	public String provideCommentsForSupplier(WebDriver driver, String testCaseName, String supplierComment) throws ActionBotException
	{
		String comments = null;
		try
		{
			IModelCommentsForSupplier comSupplier = FactoryModal.getInstanceOfIModelCommentsForSupplier();
			comments = comSupplier.provideCommentsForSupplier(driver, testCaseName, supplierComment);
			if (comments.equalsIgnoreCase(supplierComment))
			{
				return comments;
			}
			else
			{
				return null;
			}
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method provideCommentsForSupplier " + e, e);
		}
		return null;
	}

}
