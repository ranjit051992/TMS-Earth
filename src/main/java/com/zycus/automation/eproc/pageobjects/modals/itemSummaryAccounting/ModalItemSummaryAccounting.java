package com.zycus.automation.eproc.pageobjects.modals.itemSummaryAccounting;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalItemSummaryAccounting
{
	static Logger logger = Logger.getLogger(IModalItemSummaryAccountingImpl.class);

	public static void clickOnAccounting(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryAccounting iModalItemSummaryAccounting = FactoryPage.getInstanceOf(IModalItemSummaryAccountingImpl.class);
		iModalItemSummaryAccounting.clickOnAccounting(driver);
	}

	public static void clickOnCancel(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryAccounting iModalItemSummaryAccounting = FactoryPage.getInstanceOf(IModalItemSummaryAccountingImpl.class);
		iModalItemSummaryAccounting.clickOnCancel(driver);
	}

	public static void clickOnDelivery(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryAccounting iModalItemSummaryAccounting = FactoryPage.getInstanceOf(IModalItemSummaryAccountingImpl.class);
		iModalItemSummaryAccounting.clickOnDelivery(driver);
	}

	public static void clickOnSave(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryAccounting iModalItemSummaryAccounting = FactoryPage.getInstanceOf(IModalItemSummaryAccountingImpl.class);
		iModalItemSummaryAccounting.clickOnSave(driver);
	}

	public static String fillGLAccount(WebDriver driver, String glAccount) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryAccounting iModalItemSummaryAccounting = FactoryPage.getInstanceOf(IModalItemSummaryAccountingImpl.class);
		return iModalItemSummaryAccounting.fillGLAccount(driver, glAccount);
	}

	public static String fillGLType(WebDriver driver, String glType) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryAccounting iModalItemSummaryAccounting = FactoryPage.getInstanceOf(IModalItemSummaryAccountingImpl.class);
		return iModalItemSummaryAccounting.fillGLType(driver, glType);
	}

	public static String fillRequiredByDateAtItemLevel(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		String reqDate = null;
		try
		{
			IModalItemSummaryAccounting iModalItemSummaryAccounting = FactoryPage.getInstanceOf(IModalItemSummaryAccountingImpl.class);
			reqDate = iModalItemSummaryAccounting.fillReqByDateAtItemLevel(driver, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectRequiredByDate " + e, e);
		}
		return reqDate;
	}

	public static String getaccuntTypeErrorMsg(WebDriver driver, String accountTypeErrorMsg) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryAccounting iModalItemSummaryAccounting = FactoryPage.getInstanceOf(IModalItemSummaryAccountingImpl.class);
		return iModalItemSummaryAccounting.getaccuntTypeErrorMsg(driver, accountTypeErrorMsg);
	}

	public static boolean isGLAccountFieldFilled(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryAccounting iModalItemSummaryAccounting = FactoryPage.getInstanceOf(IModalItemSummaryAccountingImpl.class);
		return iModalItemSummaryAccounting.isGLAccountFieldFilled(driver);
	}

	public static boolean isGLTypeFieldFilled(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryAccounting iModalItemSummaryAccounting = FactoryPage.getInstanceOf(IModalItemSummaryAccountingImpl.class);
		return iModalItemSummaryAccounting.isGLTypeFieldFilled(driver);
	}

	public static boolean isGLTypeFieldFilledDisplayedAslabel(WebDriver driver, String glType) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryAccounting iModalItemSummaryAccounting = FactoryPage.getInstanceOf(IModalItemSummaryAccountingImpl.class);
		return iModalItemSummaryAccounting.isGLTypeFieldFilledEditable(driver, glType);
	}
}
