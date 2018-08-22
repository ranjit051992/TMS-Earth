package com.zycus.automation.eproc.pageobjects.popups.checkoutAddItem;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters.ModalRequisitionFilter;
import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PopupsAddItem
{
	static Logger logger = Logger.getLogger(ModalRequisitionFilter.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public void clickAddItemDontSave(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopupsAddItem addItem = FactoryPage.getInstanceOf(IPopupsAddItemImpl.class);
			addItem.clickAddItemDontSave(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickAddItemDontSave " + e, e);
		}

	}

	public void clickAddItemSave(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPopupsAddItem addItem = FactoryPage.getInstanceOf(IPopupsAddItemImpl.class);
			addItem.clickAddItemSave(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickAddItemSave " + e, e);
		}

	}

}
