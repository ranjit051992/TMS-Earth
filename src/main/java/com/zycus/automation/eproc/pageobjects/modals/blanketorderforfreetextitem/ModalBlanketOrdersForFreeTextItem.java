/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.blanketorderforfreetextitem;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalBlanketOrdersForFreeTextItem
{
	static Logger logger = Logger.getLogger(ModalBlanketOrdersForFreeTextItem.class);

	public static String fillBPONumber(WebDriver driver, String testCaseName, String BPONumber) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		return blanketOrdersForFreeTextItem.fillBPONumber(driver, testCaseName, BPONumber);
	}

	public static String fillBPOName(WebDriver driver, String testCaseName, String BPOName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		return blanketOrdersForFreeTextItem.fillBPOName(driver, testCaseName, BPOName);
	}

	public static String fillCreatedByForBPO(WebDriver driver, String testCaseName, String createdBy) throws Exception
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		return blanketOrdersForFreeTextItem.fillCreatedByForBPO(driver, testCaseName, createdBy);
	}

	public static void selectFirstBPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		blanketOrdersForFreeTextItem.selectFirstBPO(driver, testCaseName);
	}

	public static void clickOnFirstBPOLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		blanketOrdersForFreeTextItem.selectFirstBPO(driver, testCaseName);
	}

	public static void clickOnSelectBPOButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		blanketOrdersForFreeTextItem.clickOnSelectBPOButton(driver, testCaseName);
	}

	public static void clickOnCloseBPOButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		blanketOrdersForFreeTextItem.clickOnCloseBPOButton(driver, testCaseName);
	}

	public static String getFirstBPONo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		return blanketOrdersForFreeTextItem.getFirstBPONo(driver, testCaseName);
	}

	public static String getFirstBPOName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		return blanketOrdersForFreeTextItem.getFirstBPOName(driver, testCaseName);
	}

	public static String getFirstBPOCreatedBy(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		return blanketOrdersForFreeTextItem.getFirstBPOCreatedBy(driver, testCaseName);
	}

	public static int fillBPOPaginateValue(WebDriver driver, String testCaseName, int value) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		return blanketOrdersForFreeTextItem.fillBPOPaginateValue(driver, testCaseName, value);
	}

	public static int getNoOfRecordsCount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		return blanketOrdersForFreeTextItem.getNoOfRecordsCount(driver, testCaseName);
	}

	public static void clickOnNextPageOnBPOListing(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		blanketOrdersForFreeTextItem.clickOnNextPageOnBPOListing(driver, testCaseName);
	}

	public static boolean isBalanceAmountColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		return blanketOrdersForFreeTextItem.isBalanceAmountColumnPresent(driver, testCaseName);
	}

	public static boolean isTextboxBPONoPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		return blanketOrdersForFreeTextItem.isTextboxBPONoPresent(driver, testCaseName);
	}

	public static int getNoOfBPOCount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		return blanketOrdersForFreeTextItem.getNoOfBPOCount(driver, testCaseName);
	}

	public static boolean isValidUntilSortingPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		return blanketOrdersForFreeTextItem.isValidUntilSortingPresent(driver, testCaseName);
	}

	//check for blank table
	public static boolean isNoResultsTablePresent(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		return blanketOrdersForFreeTextItem.isNoResultsTablePresent(driver, testCaseName);
	}

	public static boolean isFromDateAndToDateFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		return blanketOrdersForFreeTextItem.isFromDateAndToDateFilterPresent(driver, testCaseName);
	}

	public static String getContractNumber(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBlanketOrdersForFreeTextItem blanketOrdersForFreeTextItem = FactoryPage.getInstanceOf(IModalBlanketOrdersForFreeTextItemImpl.class);
		return blanketOrdersForFreeTextItem.getContractNumber(driver, testCaseName);
	}

}
