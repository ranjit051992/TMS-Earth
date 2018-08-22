package com.zycus.automation.eproc.pageobjects.modals.POfreeTextItemSummaryCostAllocation;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalPOFreeTextItemSummaryCostAllocation
{
	public static void clickOnCostBooking(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryCostAllocation iModalPOFreeTextItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryCostAllocationImpl.class);
		iModalPOFreeTextItemSummaryCostAllocation.clickOnCostBooking(driver, testCaseName);
	}

	public static String getCostCenter(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IModalPOFreeTextItemSummaryCostAllocation iModalPOFreeTextItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryCostAllocationImpl.class);
		return iModalPOFreeTextItemSummaryCostAllocation.getCostCenter(driver, testCaseName);
	}

	public static boolean isCostingAmountErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryCostAllocation iModalPOFreeTextItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryCostAllocationImpl.class);
		return iModalPOFreeTextItemSummaryCostAllocation.isCostingAmountErrorPresent(driver, testCaseName);
	}

	public static boolean isGLAccountSameAsGLMap(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryCostAllocation iModalPOFreeTextItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryCostAllocationImpl.class);
		return iModalPOFreeTextItemSummaryCostAllocation.isGLAccountSameAsGLMap(driver, testCaseName);
	}

	public static String getGLAccount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryCostAllocation iModalPOFreeTextItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryCostAllocationImpl.class);
		return iModalPOFreeTextItemSummaryCostAllocation.getGLAccount(driver, testCaseName);
	}

	public static boolean isGLAccountFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryCostAllocation iModalPOFreeTextItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryCostAllocationImpl.class);
		return iModalPOFreeTextItemSummaryCostAllocation.isGLAccountFieldFilled(driver, testCaseName);
	}
}
