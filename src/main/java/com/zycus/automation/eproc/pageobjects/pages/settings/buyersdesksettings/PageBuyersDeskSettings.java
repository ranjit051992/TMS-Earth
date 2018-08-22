/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.buyersdesksettings;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageBuyersDeskSettings
{
	static Logger logger = Logger.getLogger(PageBuyersDeskSettings.class);

	public static boolean clickOnNotifyRequesterOnChangeToReq_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.clickOnNotifyRequesterOnChangeToReq_Yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnNotifyRequesterOnChangeToReq_Yes " + e, e);
		}

		return result;

	}

	public static boolean clickOnNotifyRequesterOnChangeToReq_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.clickOnNotifyRequesterOnChangeToReq_No(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnNotifyRequesterOnChangeToReq_No " + e, e);
		}

		return result;
	}

	public static String getNotifyRequesterOnChangeToReqSelectedOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.getNotifyRequesterOnChangeToReqSelectedOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getNotifyRequesterOnChangeToReqSelectedOption " + e, e);
		}

		return result;
	}

	public static boolean clickOnAllowBuyerToReplaceItemsInReq_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowBuyerToReplaceItemsInReq_Yes " + e, e);
		}

		return result;
	}

	public static boolean clickOnAllowBuyerToReplaceItemsInReq_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowBuyerToReplaceItemsInReq_No " + e, e);
		}

		return result;
	}

	public static String getAllowBuyerToReplaceItemsInReqSelectedOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.getAllowBuyerToReplaceItemsInReqSelectedOption(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAllowBuyerToReplaceItemsInReqSelectedOption " + e, e);
		}

		return result;
	}

	public static Integer fillReceivedByQuantity_Minimum(WebDriver driver, String testCaseName, int receivedByQuantityMin) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.fillReceivedByQuantity_Minimum(driver, testCaseName, receivedByQuantityMin);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReceivedByQuantity_Minimum " + e, e);
		}

		return result;
	}

	public static Integer fillAllowBuyerItemRcvByQuantityTextBox(WebDriver driver, String testCaseName, int receivedByQuantity) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.fillAllowBuyerItemRcvByQuantityTextBox(driver, testCaseName, receivedByQuantity);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAllowBuyerItemRcvByQuantityTextBox " + e, e);
		}

		return result;
	}

	public static Integer fillReceivedByQuantity_Maximum(WebDriver driver, String testCaseName, int receivedByQuantityMax) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.fillReceivedByQuantity_Maximum(driver, testCaseName, receivedByQuantityMax);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReceivedByQuantity_Maximum " + e, e);
		}

		return result;
	}

	public static Integer getReceivedByQuantity_Minimum(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.getReceivedByQuantity_Minimum(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReceivedByQuantity_Minimum " + e, e);
		}

		return result;
	}

	public static Integer getReceivedByQuantity_Maximum(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.getReceivedByQuantity_Maximum(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReceivedByQuantity_Maximum " + e, e);
		}

		return result;
	}

	public static Integer fillReceivedByAmount_Minimum(WebDriver driver, String testCaseName, int receivedByAmountMin) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.fillReceivedByAmount_Minimum(driver, testCaseName, receivedByAmountMin);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReceivedByAmount_Minimum " + e, e);
		}

		return result;
	}

	public static Integer fillReceivedByAmount_Maximum(WebDriver driver, String testCaseName, int receivedByAmountMax) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.fillReceivedByAmount_Maximum(driver, testCaseName, receivedByAmountMax);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReceivedByAmount_Maximum " + e, e);
		}

		return result;
	}

	public static Integer getReceivedByAmount_Minimum(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.getReceivedByAmount_Minimum(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReceivedByAmount_Minimum " + e, e);
		}

		return result;
	}

	public static Integer getReceivedByAmount_Maximum(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.getReceivedByAmount_Maximum(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReceivedByAmount_Maximum " + e, e);
		}

		return result;
	}

	public static Integer fillPriceSubTotalOfNonCatalogItems_Minimum(WebDriver driver, String testCaseName, int minPriceSubTotalOfNonCatalogItems) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.fillPriceSubTotalOfNonCatalogItems_Minimum(driver, testCaseName, minPriceSubTotalOfNonCatalogItems);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPriceSubTotalOfNonCatalogItems_Minimum " + e, e);
		}

		return result;
	}

	public static Integer fillPriceSubTotalOfNonCatalogItems_Maximum(WebDriver driver, String testCaseName, int maxPriceSubTotalOfNonCatalogItems) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.fillPriceSubTotalOfNonCatalogItems_Maximum(driver, testCaseName, maxPriceSubTotalOfNonCatalogItems);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPriceSubTotalOfNonCatalogItems_Maximum " + e, e);
		}

		return result;
	}

	public static Integer getPriceSubTotalOfNonCatalogItems_Minimum(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.getPriceSubTotalOfNonCatalogItems_Minimum(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPriceSubTotalOfNonCatalogItems_Minimum " + e, e);
		}

		return result;
	}

	public static Integer getPriceSubTotalOfNonCatalogItems_Maximum(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.getPriceSubTotalOfNonCatalogItems_Maximum(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPriceSubTotalOfNonCatalogItems_Maximum " + e, e);
		}

		return result;
	}

	public static boolean clickSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.clickSaveButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSaveButton " + e, e);
		}

		return result;
	}

	public static boolean clickCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.clickCancelButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCancelButton " + e, e);
		}

		return result;
	}

	public static Integer fillPriceSubTotalOfCatalogItems(WebDriver driver, String testCaseName, int PriceSubTotalOfCatalogItems) throws ActionBotException
	{
		int price = 0;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			price = buyersDeskSettings.fillPriceSubTotalOfCatalogItems(driver, testCaseName, PriceSubTotalOfCatalogItems);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPriceSubTotalOfCatalogItems " + e, e);
		}

		return price;
	}

	public static void clearPriceSubTotalOfCatalogItems(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
		buyersDeskSettings.clearPriceSubTotalOfCatalogItems(driver, testCaseName);
	}

	public static void clearQuantitySubTotalReceivedByQuantity(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
		buyersDeskSettings.clearQuantitySubTotalReceivedByQuantity(driver, testCaseName);
	}

	public static boolean clickOnAllowBuyerToAddItemsInReq_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowBuyerToReplaceItemsInReq_Yes " + e, e);
		}

		return result;
	}

	public static boolean clickOnAllowBuyerToAddItemsInReq_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean result = false;
		try
		{
			IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
			result = buyersDeskSettings.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAllowBuyerToReplaceItemsInReq_Yes " + e, e);
		}

		return result;
	}

	public static boolean clickOnAllowPR_Smaller(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
		return buyersDeskSettings.clickOnAllowPR_Smaller(driver, testCaseName);
	}

	public static boolean clickOnAllowPR_Larger(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
		return buyersDeskSettings.clickOnAllowPR_Larger(driver, testCaseName);
	}

	public static String enterAllowPr_TotalAmount(WebDriver driver, String testCaseName, String prTotalAmount) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
		return buyersDeskSettings.enterAllowPr_TotalAmount(driver, testCaseName, prTotalAmount);
	}

	public static String enterAllowPr_CurrencyUnits(WebDriver driver, String testCaseName, String prCurrencyUnits) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
		return buyersDeskSettings.enterAllowPr_CurrencyUnits(driver, testCaseName, prCurrencyUnits);
	}

	public static void clearAllowPr_TotalAmount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
		buyersDeskSettings.clearAllowPr_TotalAmount(driver, testCaseName);
	}

	public static void clearAllowPr_CurrencyUnits(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
		buyersDeskSettings.clearAllowPr_CurrencyUnits(driver, testCaseName);
	}

	public static void clearItemReceivedByAmount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
		buyersDeskSettings.clearItemReceivedByAmount(driver, testCaseName);
	}

	public static String enterItemReceivedByAmount(WebDriver driver, String testCaseName, String itemAmount) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
		return buyersDeskSettings.enterItemReceivedByAmount(driver, testCaseName, itemAmount);
	}

	public static String enterPriceControlVirtualItem(WebDriver driver, String testCaseName, String priceControlValue) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
		return buyersDeskSettings.enterPriceControlVirtualItem(driver, testCaseName, priceControlValue);
	}

	public static void clearPriceControlVirtualItem(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
		buyersDeskSettings.clearPriceControlVirtualItem(driver, testCaseName);
	}

	public static boolean clickAllowBuyerToSubmitRequisitionWithoutSavingAsDraft_Yes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
		return buyersDeskSettings.clickAllowBuyerToSubmitRequisitionWithoutSavingAsDraft_Yes(driver, testCaseName);
	}

	public static boolean clickAllowBuyerToSubmitRequisitionWithoutSavingAsDraft_No(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDeskSettings buyersDeskSettings = FactoryPage.getInstanceOfIPageBuyersDeskSettings();
		return buyersDeskSettings.clickAllowBuyerToSubmitRequisitionWithoutSavingAsDraft_No(driver, testCaseName);
	}

}
