package com.zycus.automation.eproc.pageobjects.modals.itemsummarycostbooking;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalItemSummaryCostBooking
{
	public static void clickOnCostBooking(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IModalItemSummaryCostBooking iModalItemSummary = FactoryPage.getInstanceOf(IModalItemSummaryCostBookingImpl.class);
		iModalItemSummary.clickOnCostBooking(driver);
	}

	public static String getTagNameOfProjectFieldLabel(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostBooking iModalItemSummaryCostBooking = FactoryPage.getInstanceOf(IModalItemSummaryCostBookingImpl.class);
		return iModalItemSummaryCostBooking.getTagNameOfProjectFieldLabel(driver);

	}

	public static String getItemlevelCostingdetails(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostBooking iModalItemSummaryCostBooking = FactoryPage.getInstanceOf(IModalItemSummaryCostBookingImpl.class);
		return iModalItemSummaryCostBooking.getItemlevelCostingdetails(driver);

	}

	public static String getItemlevelProjectdetails(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostBooking iModalItemSummaryCostBooking = FactoryPage.getInstanceOf(IModalItemSummaryCostBookingImpl.class);
		return iModalItemSummaryCostBooking.getItemlevelProjectdetails(driver);

	}

	public static boolean isProjectFieldALabel(WebDriver driver) throws Exception
	{
		IModalItemSummaryCostBooking iModalItemSummaryCostBooking = FactoryPage.getInstanceOf(IModalItemSummaryCostBookingImpl.class);
		return iModalItemSummaryCostBooking.isProjectFieldALabel(driver);
	}

	public static boolean isProjectOrTaskIconPresent(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostBooking iModalItemSummaryCostBooking = FactoryPage.getInstanceOf(IModalItemSummaryCostBookingImpl.class);
		return iModalItemSummaryCostBooking.isProjectOrTaskIconPresent(driver);
	}

	public static boolean isProjectInfoIconPresent(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostBooking iModalItemSummaryCostBooking = FactoryPage.getInstanceOf(IModalItemSummaryCostBookingImpl.class);
		return iModalItemSummaryCostBooking.isProjectInfoIconPresent(driver);
	}

	public static String getAmountAssigned(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostBooking iModalItemSummaryCostBooking = FactoryPage.getInstanceOf(IModalItemSummaryCostBookingImpl.class);
		return iModalItemSummaryCostBooking.getAmountAssigned(driver);
	}

	public static String fillCostCenter(WebDriver driver, String testCaseName, String CC) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostBooking iModalItemSummaryCostBooking = FactoryPage.getInstanceOf(IModalItemSummaryCostBookingImpl.class);
		return iModalItemSummaryCostBooking.fillCostCenter(driver, testCaseName, CC);
	}

	public static String fillProject(WebDriver driver, String testCaseName, String project) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostBooking iModalItemSummaryCostBooking = FactoryPage.getInstanceOf(IModalItemSummaryCostBookingImpl.class);
		return iModalItemSummaryCostBooking.fillProject(driver, testCaseName, project);
	}

	public static String fillBudget(WebDriver driver, String testCaseName, String budget) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostBooking iModalItemSummaryCostBooking = FactoryPage.getInstanceOf(IModalItemSummaryCostBookingImpl.class);
		return iModalItemSummaryCostBooking.fillBudget(driver, testCaseName, budget);
	}

	/**
	 * @author omkar.jagdale
	 *         method to get item level budget details
	 */
	public static String getItemlevelBudgetdetails(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostBooking iModalItemSummaryCostBooking = FactoryPage.getInstanceOf(IModalItemSummaryCostBookingImpl.class);
		return iModalItemSummaryCostBooking.getItemlevelBudgetdetails(driver);

	}
}
