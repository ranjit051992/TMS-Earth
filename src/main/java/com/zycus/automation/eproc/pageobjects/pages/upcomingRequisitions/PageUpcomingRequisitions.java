package com.zycus.automation.eproc.pageobjects.pages.upcomingRequisitions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.IPageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.IPageBuyersDeskListingImpl;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageUpcomingRequisitions
{
	public static String fillRequisitionNumber(WebDriver driver, String testCaseName, String reqNo) throws ActionBotException, FactoryMethodException
	{
		IPageUpcomingRequisitions iPageUpcomingRequisitions = FactoryPage.getInstanceOf(IPageUpcomingRequisitionsImpl.class);
		return iPageUpcomingRequisitions.fillRequisitionNumber(driver, testCaseName, reqNo);
	}

	public static String getFirstReqNo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageUpcomingRequisitions iPageUpcomingRequisitions = FactoryPage.getInstanceOf(IPageUpcomingRequisitionsImpl.class);
		return iPageUpcomingRequisitions.getFirstReqNo(driver, testCaseName);
	}

	public static String fillRequisitionName(WebDriver driver, String testCaseName, String reqName) throws ActionBotException, FactoryMethodException
	{
		IPageUpcomingRequisitions iPageUpcomingRequisitions = FactoryPage.getInstanceOf(IPageUpcomingRequisitionsImpl.class);
		return iPageUpcomingRequisitions.fillRequisitionName(driver, testCaseName, reqName);
	}

	public static void clickAmountFilterButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageUpcomingRequisitions iPageUpcomingRequisitions = FactoryPage.getInstanceOf(IPageUpcomingRequisitionsImpl.class);
		iPageUpcomingRequisitions.clickAmountFilterButton(driver, testCaseName);
	}

	public static void enterMinAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException, FactoryMethodException
	{
		IPageUpcomingRequisitions iPageUpcomingRequisitions = FactoryPage.getInstanceOf(IPageUpcomingRequisitionsImpl.class);
		iPageUpcomingRequisitions.enterMinAmountFilter(driver, testCaseName, amount);
	}

	public static void enterMaxAmountFilter(WebDriver driver, String testCaseName, String amount) throws ActionBotException, FactoryMethodException
	{
		IPageUpcomingRequisitions iPageUpcomingRequisitions = FactoryPage.getInstanceOf(IPageUpcomingRequisitionsImpl.class);
		iPageUpcomingRequisitions.enterMaxAmountFilter(driver, testCaseName, amount);
	}

	public static void clickApplyAmountFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageUpcomingRequisitions iPageUpcomingRequisitions = FactoryPage.getInstanceOf(IPageUpcomingRequisitionsImpl.class);
		iPageUpcomingRequisitions.clickApplyAmountFilter(driver, testCaseName);
	}

	public static String fetchRequisitionAmountIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{

		IPageUpcomingRequisitions iPageUpcomingRequisitions = FactoryPage.getInstanceOf(IPageUpcomingRequisitionsImpl.class);
		return iPageUpcomingRequisitions.fetchRequisitionAmountIndexwise(driver, testCaseName, index);
	}

	public static boolean isReqPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageUpcomingRequisitions iPageUpcomingRequisitions = FactoryPage.getInstanceOf(IPageUpcomingRequisitionsImpl.class);
		return iPageUpcomingRequisitions.isReqPresentIndexwise(driver, testCaseName, index);
	}
}
