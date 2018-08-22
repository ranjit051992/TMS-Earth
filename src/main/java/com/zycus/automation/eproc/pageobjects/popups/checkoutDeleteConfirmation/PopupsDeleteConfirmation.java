package com.zycus.automation.eproc.pageobjects.popups.checkoutDeleteConfirmation;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PopupsDeleteConfirmation
{
	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public void clickDeleteConfirmationNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopupsDeleteConfirmation deleteItem = FactoryPage.getInstanceOf(IPopupsDeleteConfirmationImpl.class);
			deleteItem.clickDeleteConfirmationNo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickDeleteConfirmationNo " + e, e);
		}

	}

	public void clickDeleteConfirmationYes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopupsDeleteConfirmation deleteItem = FactoryPage.getInstanceOf(IPopupsDeleteConfirmationImpl.class);
			deleteItem.clickDeleteConfirmationYes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickDeleteConfirmationYes " + e, e);
		}

	}

	public String getDeleteItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String itemName = null;
		try
		{
			IPopupsDeleteConfirmation deleteItem = FactoryPage.getInstanceOf(IPopupsDeleteConfirmationImpl.class);
			itemName = deleteItem.getDeleteItemName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeleteItemName " + e, e);
		}
		return itemName;
	}

}
