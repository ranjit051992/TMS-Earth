package com.zycus.automation.eproc.pageobjects.modals.itemDetailsPO;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalItemDetails
{
	static Logger logger = Logger.getLogger(ModalItemDetails.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static boolean checkIsCatalogItemSameAsSelected(WebDriver driver, int index) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.checkIsCatalogItemSameAsSelected(driver, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in checkIsCatalogItemSameAsSelected " + e, e);
		}
		return false;

	}

	public static boolean isAddPresentInItemDetail(WebDriver driver, int index) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.isAddPresentInItemDetail(driver, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in isAddPresentInItemDetail " + e, e);
		}
		return false;
	}

	public static boolean isMaxCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.isMaxCharItemNameDisplayedProperly(driver, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in isMaxCharItemNameDisplayedProperly " + e, e);
		}
		return false;
	}

	public static boolean isSpecialCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.isSpecialCharItemNameDisplayedProperly(driver, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in isMaxCharItemNameDisplayedProperly " + e, e);
		}
		return false;
	}

	public static boolean isScriptingCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException
	{

		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.isScriptingCharItemNameDisplayedProperly(driver, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in isScriptingCharItemNameDisplayedProperly " + e, e);
		}
		return false;
	}

	public static boolean isMultiLingualCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.isMultiLingualCharItemNameDisplayedProperly(driver, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in isMultiLingualCharItemNameDisplayedProperly " + e, e);
		}
		return false;
	}

	public static boolean isItemNamePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.isItemNamePresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in isItemNamePresent " + e, e);
		}
		return false;
	}

	public static boolean isAddToCartPresentInItemDetail(WebDriver driver) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.isAddToCartPresentInItemDetail(driver);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in isAddToCartPresentInItemDetail " + e, e);
		}
		return false;
	}

	public static boolean isAddToFavoritesPresentInItemDetail(WebDriver driver) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.isAddToFavoritesPresentInItemDetail(driver);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in isAddToFavoritesPresentInItemDetail" + e, e);
		}
		return false;
	}

	public static boolean isAddToBasketPresentInItemDetail(WebDriver driver) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			return iModalItemDetails.isAddToBasketPresentInItemDetail(driver);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in isAddToBasketPresentInItemDetail" + e, e);
		}
		return false;
	}

	public static void clickOnCloseButton(WebDriver driver) throws ActionBotException
	{
		try
		{
			IModalItemDetails iModalItemDetails = FactoryPage.getInstanceOf(IModalItemDetailsImpl.class);
			iModalItemDetails.clickOnCloseButton(driver);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory method exception in clickOnCloseButton" + e, e);
		}
	}
}
