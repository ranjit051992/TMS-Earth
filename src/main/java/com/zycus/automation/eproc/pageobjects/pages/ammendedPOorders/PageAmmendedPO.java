package com.zycus.automation.eproc.pageobjects.pages.ammendedPOorders;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageAmmendedPO
{
	public static void clickOnActions(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		IPageAmmendedPO.clickOnActions(driver, testCaseName, index);
	}

	public static void clickOnEdit(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		IPageAmmendedPO.clickOnEdit(driver, testCaseName);
	}

	public static boolean isRollBackPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		return IPageAmmendedPO.isRollBackPresent(driver, testCaseName);
	}

	public static void clickOnRollBack(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		IPageAmmendedPO.clickOnRollBack(driver, testCaseName);
	}

	public static boolean isViewAllPOPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		return IPageAmmendedPO.isViewAllPOPresent(driver, testCaseName);
	}

	public static void clickOnAmmendPONumberOfSameBuyer(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		IPageAmmendedPO.clickOnAmmendPONumberOfSameBuyer(driver, testCaseName);
	}

	public static String getFirstAmendedPONo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		return IPageAmmendedPO.getFirstAmendedPONo(driver, testCaseName);
	}

	public static List<WebElement> getAllAmendedPONos(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		return IPageAmmendedPO.getAllAmendedPONos(driver, testCaseName);
	}

	public static void clickOnAmmendPONumberOfDifferentBuyer(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		IPageAmmendedPO.clickOnAmmendPONumberOfDifferentBuyer(driver, testCaseName);
	}

	public static String getStatusOfAmendedPO(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		return IPageAmmendedPO.getStatusOfAmendedPO(driver, testCaseName, index);
	}

	public static void clickOnActionsOfSingleApprovalPO(WebDriver driver, String testCaseName, String poNo) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		IPageAmmendedPO.clickOnActionsOfSingleApprovalPO(driver, testCaseName, poNo);
	}

	public static void clickOnRecallApprovalRequestOfApprovalPO(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		IPageAmmendedPO.clickOnRecallApprovalRequestOfApprovalPO(driver, testCaseName, index);
	}

	public static void clickOnActions(WebDriver driver, String testCaseName, String poNo) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		IPageAmmendedPO.clickOnActions(driver, testCaseName, poNo);
	}

	public static String getStatusOfAmendedPO(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		return IPageAmmendedPO.getStatusOfAmendedPO(driver, testCaseName, poNumber);
	}

	public static void clickOnAmendedPONumber(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		IPageAmmendedPO.clickOnAmendedPONumber(driver, testCaseName, poNumber);
	}

	public static void clickOnFirstAmendPONo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		IPageAmmendedPO.clickOnFirstAmendAmendPoNumber(driver, testCaseName);
	}

	public static boolean isPoNoAlreadyAmendedAlertDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		return IPageAmmendedPO.isPoNoAlreadyAmendedAlertDisplayed(driver, testCaseName);
	}

	public static boolean isAmendedPOPresentInListing(WebDriver driver, String testCaseName, String poNo) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		return IPageAmmendedPO.isAmendedPOPresentInListing(driver, testCaseName, poNo);
	}

	public static int getNoOfAmendedPOPresentInListing(WebDriver driver, String testCaseName, String poNo) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		return IPageAmmendedPO.getNoOfAmendedPOPresentInListing(driver, testCaseName, poNo);
	}

	public static void waitTillRollBackPopupPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		IPageAmmendedPO.waitTillRollBackPopupPresent(driver, testCaseName);
	}

	public static boolean isRollBackButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		return IPageAmmendedPO.isRollBackButtonPresent(driver, testCaseName);
	}

	public static String getSuccessMsg(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		return IPageAmmendedPO.getSuccessMsg(driver, testCaseName);
	}

	public static void clickOnViewAllPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageAmmendedPO IPageAmmendedPO = FactoryPage.getInstanceOf(IPageAmmendedPOImpl.class);
		IPageAmmendedPO.clickOnViewAllPO(driver, testCaseName);
	}
}
