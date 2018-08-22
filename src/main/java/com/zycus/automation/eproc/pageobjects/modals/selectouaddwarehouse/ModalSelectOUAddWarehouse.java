package com.zycus.automation.eproc.pageobjects.modals.selectouaddwarehouse;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * 
 * @author t.amarnath
 *
 */
public class ModalSelectOUAddWarehouse
{
	public static void clickOnCompanyTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectOUAddWarehouse iModalSelectOUAddWarehouse = FactoryPage.getInstanceOf(IModalSelectOUAddWarehouseImpl.class);
			iModalSelectOUAddWarehouse.clickOnCompanyTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			e.printStackTrace();
		}

	}

	public static void clickOnBusinessUnitsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectOUAddWarehouse iModalSelectOUAddWarehouse = FactoryPage.getInstanceOf(IModalSelectOUAddWarehouseImpl.class);
			iModalSelectOUAddWarehouse.clickOnBusinessUnitsTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			e.printStackTrace();
		}

	}

	public static void clickOnFirstCompanyRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectOUAddWarehouse iModalSelectOUAddWarehouse = FactoryPage.getInstanceOf(IModalSelectOUAddWarehouseImpl.class);
			iModalSelectOUAddWarehouse.clickOnFirstCompanyRadioButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			e.printStackTrace();
		}

	}

	public static void clickOnSecondCompanyRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectOUAddWarehouse iModalSelectOUAddWarehouse = FactoryPage.getInstanceOf(IModalSelectOUAddWarehouseImpl.class);
			iModalSelectOUAddWarehouse.clickOnSecondCompanyRadioButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			e.printStackTrace();
		}

	}

	public static void clickOnSelectOUInBusinessUnitsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectOUAddWarehouse iModalSelectOUAddWarehouse = FactoryPage.getInstanceOf(IModalSelectOUAddWarehouseImpl.class);
			iModalSelectOUAddWarehouse.clickOnSelectOUInBusinessUnitsTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			e.printStackTrace();
		}
	}

	public static void clickOnFirstBURadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectOUAddWarehouse iModalSelectOUAddWarehouse = FactoryPage.getInstanceOf(IModalSelectOUAddWarehouseImpl.class);
			iModalSelectOUAddWarehouse.clickOnFirstBURadioButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			e.printStackTrace();
		}
	}

	public static void clickOnSecondBURadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectOUAddWarehouse iModalSelectOUAddWarehouse = FactoryPage.getInstanceOf(IModalSelectOUAddWarehouseImpl.class);
			iModalSelectOUAddWarehouse.clickOnSecondBURadioButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			e.printStackTrace();
		}
	}

	public static void clickOnThirdBURadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectOUAddWarehouse iModalSelectOUAddWarehouse = FactoryPage.getInstanceOf(IModalSelectOUAddWarehouseImpl.class);
			iModalSelectOUAddWarehouse.clickOnThirdBURadioButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			e.printStackTrace();
		}
	}

	public static void clickOnSaveSelectedUnitsButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectOUAddWarehouse iModalSelectOUAddWarehouse = FactoryPage.getInstanceOf(IModalSelectOUAddWarehouseImpl.class);
			iModalSelectOUAddWarehouse.clickOnSaveSelectedUnitsButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			e.printStackTrace();
		}
	}

	public static void clickOnSaveSelectedScopeButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectOUAddWarehouse iModalSelectOUAddWarehouse = FactoryPage.getInstanceOf(IModalSelectOUAddWarehouseImpl.class);
			iModalSelectOUAddWarehouse.clickOnSaveSelectedScopeButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			e.printStackTrace();
		}
	}

	public static void clickOnCancelSelectedScopeButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectOUAddWarehouse iModalSelectOUAddWarehouse = FactoryPage.getInstanceOf(IModalSelectOUAddWarehouseImpl.class);
			iModalSelectOUAddWarehouse.clickOnCancelSelectedScopeButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			e.printStackTrace();
		}
	}
}
