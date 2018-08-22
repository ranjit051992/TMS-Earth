package com.zycus.automation.eproc.pageobjects.tabs.freeTextFrom_ItemDetails_Tab;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.tabs.FactoryTabs;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class TabsItemDetailsTab
{

	static Logger logger = Logger.getLogger(TabsItemDetailsTab.class);

	public void toClickItemTab(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		try
		{
			ITabsItemDetailsTab itemdetailsTab = FactoryTabs.getInstanceOfITabsItemDetailsTab();
			itemdetailsTab.toClickItemTab(driver, testcaseName, itemID);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickItemTab " + e, e);
		}

	}

	public void toClickRequirementDetailsTab(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		try
		{
			ITabsItemDetailsTab itemdetailsTab = FactoryTabs.getInstanceOfITabsItemDetailsTab();
			itemdetailsTab.toClickRequirementDetailsTab(driver, testcaseName, itemID);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickRequirementDetailsTab " + e, e);
		}

	}

	public void toClickSuppliersTab(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		try
		{
			ITabsItemDetailsTab itemdetailsTab = FactoryTabs.getInstanceOfITabsItemDetailsTab();
			itemdetailsTab.toClickSuppliersTab(driver, testcaseName, itemID);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickSuppliersTab " + e, e);
		}

	}

}
