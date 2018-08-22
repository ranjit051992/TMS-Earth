package com.zycus.automation.eproc.pageobjects.pages.purchaseordertobegenerated;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PagePurchaseOrderToBeGenerated
{
	static Logger logger = Logger.getLogger(PagePurchaseOrderToBeGenerated.class);

	public static void clickOnCancelLink(WebDriver driver, String testcaseName) throws ActionBotException
	{

		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGenerated.clickOnCancelLink(driver, testcaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelLink " + e, e);
		}

	}

	public static void clickOnPreviewPoLink(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGenerated.clickOnPreviewPoLink(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPreviewPoLink " + e, e);
		}

	}

	public static void clickOnReqNoLink(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGenerated.clickOnReqNoLink(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReqNoLink " + e, e);
		}

	}

	public static void clickOnSavePosAsDraft(WebDriver driver, String testcaseName) throws ActionBotException
	{

		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGenerated.clickOnSavePosAsDraft(driver, testcaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSavePosAsDraft " + e, e);
		}

	}

	public static void clickOnSubmitPoForProcessing(WebDriver driver, String testcaseName) throws ActionBotException
	{

		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGenerated.clickOnSubmitPoForProcessing(driver, testcaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSubmitPoForProcessing " + e, e);
		}

	}

	public static void clickOnSavePoAndContinue(WebDriver driver, String testcaseName) throws ActionBotException
	{

		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGenerated.clickOnSavePoAndContinue(driver, testcaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSubmitPoForProcessing " + e, e);
		}

	}

	public static void ClikOnPurchaseOrderToBeGeneratedCheckBox(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{

		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGenerated.ClikOnPurchaseOrderToBeGeneratedCheckBox(driver, testcaseName, index);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method ClikOnPurchaseOrderToBeGeneratedCheckBox " + e, e);
		}

	}

	public static List<WebElement> getListOfAllSuggestedPOCheckboxes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPurchaseOrderToBeGenerated purchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			return purchaseOrderToBeGenerated.getListOfAllSuggestedPOCheckboxes(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfAllSuggestedPOCheckboxes " + e, e);
		}
		return null;
	}

	public static List<String> getListOfItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			return PurchaseOrderToBeGenerated.getListOfItems(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfItems " + e, e);
		}
		return null;
	}

	public static String getPurchaseOrderToBeGeneratedBu(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderToBeGeneratedBu = null;
		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGeneratedBu = PurchaseOrderToBeGenerated.getPurchaseOrderToBeGeneratedBu(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderToBeGeneratedBu " + e, e);
		}
		return PurchaseOrderToBeGeneratedBu;
	}

	public static String getPurchaseOrderToBeGeneratedDeliverTo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderToBeGeneratedDeliverTo = null;
		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGeneratedDeliverTo = PurchaseOrderToBeGenerated.getPurchaseOrderToBeGeneratedDeliverTo(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderToBeGeneratedDeliverTo " + e, e);
		}
		return PurchaseOrderToBeGeneratedDeliverTo;
	}

	public static String getPurchaseOrderToBeGeneratedDeliverydate(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderToBeGeneratedDeliverydate = null;
		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGeneratedDeliverydate = PurchaseOrderToBeGenerated.getPurchaseOrderToBeGeneratedBu(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderToBeGeneratedDeliverydate " + e, e);
		}
		return PurchaseOrderToBeGeneratedDeliverydate;
	}

	public static String getPurchaseOrderToBeGeneratedExchangeRate(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderToBeGeneratedExchangeRate = null;
		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGeneratedExchangeRate = PurchaseOrderToBeGenerated.getPurchaseOrderToBeGeneratedExchangeRate(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderToBeGeneratedPoTotal " + e, e);
		}
		return PurchaseOrderToBeGeneratedExchangeRate;
	}

	public static String getPurchaseOrderToBeGeneratedItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderToBeGeneratedItemName = null;
		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGeneratedItemName = PurchaseOrderToBeGenerated.getPurchaseOrderToBeGeneratedItemName(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderToBeGeneratedItemName " + e, e);
		}
		return PurchaseOrderToBeGeneratedItemName;
	}

	public static String getPurchaseOrderToBeGeneratedPoTotal(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderToBeGeneratedPoTotal = null;
		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGeneratedPoTotal = PurchaseOrderToBeGenerated.getPurchaseOrderToBeGeneratedPoTotal(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderToBeGeneratedPoTotal " + e, e);
		}
		return PurchaseOrderToBeGeneratedPoTotal;

	}

	public static String getPurchaseOrderToBeGeneratedQty(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderToBeGeneratedQty = null;
		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGeneratedQty = PurchaseOrderToBeGenerated.getPurchaseOrderToBeGeneratedQty(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderToBeGeneratedQty " + e, e);
		}
		return PurchaseOrderToBeGeneratedQty;
	}

	public static String getPurchaseOrderToBeGeneratedReqNo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderToBeGeneratedReqNo = null;
		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGeneratedReqNo = PurchaseOrderToBeGenerated.getPurchaseOrderToBeGeneratedReqNo(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderToBeGeneratedReqNo " + e, e);
		}
		return PurchaseOrderToBeGeneratedReqNo;
	}

	public static String getPurchaseOrderToBeGeneratedSuggestedPOs(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderToBeGeneratedSuggestedPOs = null;
		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGeneratedSuggestedPOs = PurchaseOrderToBeGenerated.getPurchaseOrderToBeGeneratedSuggestedPOs(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderToBeGeneratedSuggestedPOs " + e, e);
		}
		return PurchaseOrderToBeGeneratedSuggestedPOs;
	}

	public static String getPurchaseOrderToBeGeneratedSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderToBeGeneratedSupplier = null;
		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGeneratedSupplier = PurchaseOrderToBeGenerated.getPurchaseOrderToBeGeneratedSupplier(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderToBeGeneratedSupplier " + e, e);
		}
		return PurchaseOrderToBeGeneratedSupplier;
	}

	public static String getPurchaseOrderToBeGeneratedUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderToBeGeneratedUnitPrice = null;
		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderToBeGeneratedUnitPrice = PurchaseOrderToBeGenerated.getPurchaseOrderToBeGeneratedUnitPrice(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderToBeGeneratedUnitPrice " + e, e);
		}
		return PurchaseOrderToBeGeneratedUnitPrice;
	}

	public static String getPurchaseOrderTotalPrices(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String PurchaseOrderTotalPrices = null;
		try
		{
			IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
			PurchaseOrderTotalPrices = PurchaseOrderToBeGenerated.getPurchaseOrderTotalPrices(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurchaseOrderTotalPrices " + e, e);
		}
		return PurchaseOrderTotalPrices;
	}

	public static void clickOnNotes(WebDriver driver, String testcaseName) throws ActionBotException, FactoryMethodException
	{
		IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
		PurchaseOrderToBeGenerated.clickOnNotes(driver, testcaseName);
	}

	public static String enterNotes(WebDriver driver, String testcaseName, String notes) throws ActionBotException, FactoryMethodException
	{
		IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
		return PurchaseOrderToBeGenerated.enterNotes(driver, testcaseName, notes);
	}

	public static void clickOnSaveNotes(WebDriver driver, String testcaseName) throws ActionBotException, FactoryMethodException
	{
		IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
		PurchaseOrderToBeGenerated.clickOnSaveNotes(driver, testcaseName);
	}

	public static void clickOnAddAttachments(WebDriver driver, String testcaseName) throws ActionBotException, FactoryMethodException
	{
		IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
		PurchaseOrderToBeGenerated.clickOnAddAttachments(driver, testcaseName);
	}

	public static boolean isPOInfoAtPreviewPOPresent(WebDriver driver, String testcaseName) throws ActionBotException, FactoryMethodException
	{
		IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
		return PurchaseOrderToBeGenerated.isPOInfoAtPreviewPOPresent(driver, testcaseName);
	}

	public static boolean isPONOFormatConfigPresentCorrectly(WebDriver driver, String testcaseName) throws ActionBotException, FactoryMethodException
	{
		IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
		return PurchaseOrderToBeGenerated.isPONOFormatConfigPresentCorrectly(driver, testcaseName);
	}

	public static void clickOnCollapseAndExpandIcon(WebDriver driver, String testcaseName) throws ActionBotException, FactoryMethodException
	{
		IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
		PurchaseOrderToBeGenerated.clickOnCollapseAndExpandIcon(driver, testcaseName);
	}

	public static boolean isSubmitPOForProcessingPresent(WebDriver driver, String testcaseName) throws ActionBotException, FactoryMethodException
	{
		IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
		return PurchaseOrderToBeGenerated.isSubmitPOForProcessingPresent(driver, testcaseName);
	}

	public static String clickOncmsRegistered(WebDriver driver, String testcaseName, String cmsRegistered) throws ActionBotException, FactoryMethodException
	{
		IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
		return PurchaseOrderToBeGenerated.clickOncmsRegistered(driver, testcaseName, cmsRegistered);
	}

	public static String clickOnquote(WebDriver driver, String testcaseName, String quote) throws ActionBotException, FactoryMethodException
	{
		IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
		return PurchaseOrderToBeGenerated.clickOnquote(driver, testcaseName, quote);
	}

	public static String clickOnRecomendationMemoProvided(WebDriver driver, String testcaseName, String recommendationMemoProvided)
		throws ActionBotException, FactoryMethodException
	{
		IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
		return PurchaseOrderToBeGenerated.clickOnRecomendationMemoProvided(driver, testcaseName, recommendationMemoProvided);
	}

	public static String clickOnpoMedium(WebDriver driver, String testcaseName, String poMedium) throws ActionBotException, FactoryMethodException
	{
		IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
		return PurchaseOrderToBeGenerated.clickOnpoMedium(driver, testcaseName, poMedium);
	}

	public static String clickOnpanelApply(WebDriver driver, String testcaseName, String panelApply) throws ActionBotException, FactoryMethodException
	{
		IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
		return PurchaseOrderToBeGenerated.clickOnpanelApply(driver, testcaseName, panelApply);
	}

	public static String setIsPOValue(WebDriver driver, String testcaseName, String isPOValue) throws ActionBotException, FactoryMethodException
	{
		IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
		return PurchaseOrderToBeGenerated.setIsPOValue(driver, testcaseName, isPOValue);
	}

	public static String clickOnPurchaseProcurement(WebDriver driver, String testcaseName, String proccurementInvolvement) throws ActionBotException, FactoryMethodException
	{
		IPurchaseOrderToBeGenerated PurchaseOrderToBeGenerated = FactoryPage.getInstanceOf(IPageOrderToBeGeneratedImpl.class);
		return PurchaseOrderToBeGenerated.clickOnPurchaseProcurement(driver, testcaseName, proccurementInvolvement);
	}

}
