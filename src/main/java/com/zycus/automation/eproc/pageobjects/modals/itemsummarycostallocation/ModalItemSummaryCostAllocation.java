package com.zycus.automation.eproc.pageobjects.modals.itemsummarycostallocation;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalItemSummaryCostAllocation
{
	public static void clickOnCostBooking(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IModalItemSummaryCostAllocation iModalItemSummary = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		iModalItemSummary.clickOnCostBooking(driver);
	}

	public static String getTagNameOfProjectFieldLabel(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		return iModalItemSummaryCostAllocation.getTagNameOfProjectFieldLabel(driver);

	}

	public static String getItemlevelCostingdetails(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		return iModalItemSummaryCostAllocation.getItemlevelCostingdetails(driver);

	}

	public static String getItemlevelProjectdetails(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		return iModalItemSummaryCostAllocation.getItemlevelProjectdetails(driver);

	}

	public static boolean isProjectFieldALabel(WebDriver driver) throws Exception
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		return iModalItemSummaryCostAllocation.isProjectFieldALabel(driver);
	}

	public static boolean isProjectOrTaskIconPresent(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		return iModalItemSummaryCostAllocation.isProjectOrTaskIconPresent(driver);
	}

	public static boolean isProjectInfoIconPresent(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		return iModalItemSummaryCostAllocation.isProjectInfoIconPresent(driver);
	}

	public static String getAmountAssigned(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		return iModalItemSummaryCostAllocation.getAmountAssigned(driver);
	}

	public static String fillCostCenter(WebDriver driver, String testCaseName, String CC) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		return iModalItemSummaryCostAllocation.fillCostCenter(driver, testCaseName, CC);
	}

	public static String fillProject(WebDriver driver, String testCaseName, String project) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		return iModalItemSummaryCostAllocation.fillProject(driver, testCaseName, project);
	}

	public static String fillBudget(WebDriver driver, String testCaseName, String budget) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		return iModalItemSummaryCostAllocation.fillBudget(driver, testCaseName, budget);
	}

	public static void clickOnCancel(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		iModalItemSummaryCostAllocation.clickOnCancel(driver);
	}

	public static void clickOnSave(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		iModalItemSummaryCostAllocation.clickOnSave(driver);
	}

	public static String fillGLAccount(WebDriver driver, String glAccount) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		return iModalItemSummaryCostAllocation.fillGLAccount(driver, glAccount);
	}

	public static String getaccuntTypeErrorMsg(WebDriver driver, String accountTypeErrorMsg) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		return iModalItemSummaryCostAllocation.getaccuntTypeErrorMsg(driver, accountTypeErrorMsg);
	}

	public static boolean isGLAccountFieldFilled(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		return iModalItemSummaryCostAllocation.isGLAccountFieldFilled(driver);
	}

	/**
	 * @author omkar.jagdale
	 *         method to check gl account field is editable or not
	 */
	public static boolean isGLAccountFieldEnabled(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryCostAllocation iModalItemSummaryCostAllocation = FactoryPage.getInstanceOf(IModalItemSummaryCostAllocationImpl.class);
		return iModalItemSummaryCostAllocation.isGLAccountFieldEnabled(driver, testCaseName);
	}
}
