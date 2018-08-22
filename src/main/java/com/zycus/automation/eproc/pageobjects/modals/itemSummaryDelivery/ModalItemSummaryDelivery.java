package com.zycus.automation.eproc.pageobjects.modals.itemSummaryDelivery;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalItemSummaryDelivery
{
	public static String fillRequiredByDateAtItemLevel(WebDriver driver, String testCaseName, String day, int month, int year) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryDelivery iModalItemSummaryDelivery = FactoryPage.getInstanceOf(IModalItemSummaryDeliveryImpl.class);
		return iModalItemSummaryDelivery.fillRequiredByDateAtItemLevel(driver, testCaseName, day, "" + month, "" + year);
	}

	public static void clickOnItemSummaryDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryDelivery iModalItemSummaryDelivery = FactoryPage.getInstanceOf(IModalItemSummaryDeliveryImpl.class);
		iModalItemSummaryDelivery.clickOnItemSummaryDeliveryTab(driver, testCaseName);
	}

	public static boolean isCreateAssetTagForThisItemCheckboxSelected(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryDelivery iModalItemSummaryDelivery = FactoryPage.getInstanceOf(IModalItemSummaryDeliveryImpl.class);
		return iModalItemSummaryDelivery.isCreateAssetTagForThisItemCheckboxSelected(driver, testCaseName);
	}

	public static boolean isCreateAssetTagForThisItemCheckboxEnabled(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryDelivery iModalItemSummaryDelivery = FactoryPage.getInstanceOf(IModalItemSummaryDeliveryImpl.class);
		return iModalItemSummaryDelivery.isCreateAssetTagForThisItemCheckboxEnabled(driver, testCaseName);
	}

	public static String getValueOFCreateAssetTagForThisItemCheckboxLabel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryDelivery iModalItemSummaryDelivery = FactoryPage.getInstanceOf(IModalItemSummaryDeliveryImpl.class);
		return iModalItemSummaryDelivery.getValueOFCreateAssetTagForThisItemCheckboxLabel(driver, testCaseName);
	}

	public static void clickOnTagAssetsLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryDelivery iModalItemSummaryDelivery = FactoryPage.getInstanceOf(IModalItemSummaryDeliveryImpl.class);
		iModalItemSummaryDelivery.clickOnTagAssetsLink(driver, testCaseName);
	}

	public static String fillFirstAssetNo(WebDriver driver, String testCaseName, String assetNo) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryDelivery iModalItemSummaryDelivery = FactoryPage.getInstanceOf(IModalItemSummaryDeliveryImpl.class);
		return iModalItemSummaryDelivery.fillFirstAssetNo(driver, testCaseName, assetNo);
	}

	public static String fillManufacturerSrNo(WebDriver driver, String testCaseName, String manuSrNo) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryDelivery iModalItemSummaryDelivery = FactoryPage.getInstanceOf(IModalItemSummaryDeliveryImpl.class);
		return iModalItemSummaryDelivery.fillManufacturerSrNo(driver, testCaseName, manuSrNo);
	}

	public static String fillNotes(WebDriver driver, String testCaseName, String notes) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryDelivery iModalItemSummaryDelivery = FactoryPage.getInstanceOf(IModalItemSummaryDeliveryImpl.class);
		return iModalItemSummaryDelivery.fillNotes(driver, testCaseName, notes);
	}

	public static String getAssetNoError(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryDelivery iModalItemSummaryDelivery = FactoryPage.getInstanceOf(IModalItemSummaryDeliveryImpl.class);
		return iModalItemSummaryDelivery.getAssetNoError(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to change the delivery address
	 */
	public static String changeDeliveryOtherAddress(WebDriver driver, String testCaseName, String address) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryDelivery iModalItemSummaryDelivery = FactoryPage.getInstanceOf(IModalItemSummaryDeliveryImpl.class);
		return iModalItemSummaryDelivery.changeDeliveryOtherAddress(driver, testCaseName, address);
	}
}
