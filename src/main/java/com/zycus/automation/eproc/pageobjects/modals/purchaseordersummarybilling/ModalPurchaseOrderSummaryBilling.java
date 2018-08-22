/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarybilling;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author amitkumar.dash
 *
 */
public class ModalPurchaseOrderSummaryBilling
{
	static Logger logger = Logger.getLogger(ModalPurchaseOrderSummaryBilling.class);

	public static String getLocationOfDeliveryAddress(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IModalPurchaseOrderSummaryBilling iModalPurchaseOrderSummaryBilling = FactoryPage.getInstanceOf(IModalPurchaseOrderSummaryBillingImpl.class);
		return iModalPurchaseOrderSummaryBilling.getLocationOfDeliveryAddress(driver, testCaseName);
	}

	public static String getLocationOfBillToAddress(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IModalPurchaseOrderSummaryBilling iModalPurchaseOrderSummaryBilling = FactoryPage.getInstanceOf(IModalPurchaseOrderSummaryBillingImpl.class);
		return iModalPurchaseOrderSummaryBilling.getLocationOfBillToAddress(driver, testCaseName);
	}

	public static String getCurrentLocation(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IModalPurchaseOrderSummaryBilling iModalPurchaseOrderSummaryBilling = FactoryPage.getInstanceOf(IModalPurchaseOrderSummaryBillingImpl.class);
		return iModalPurchaseOrderSummaryBilling.getCurrentLocation(driver, testCaseName);
	}

	public static String getOtherLocation(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IModalPurchaseOrderSummaryBilling iModalPurchaseOrderSummaryBilling = FactoryPage.getInstanceOf(IModalPurchaseOrderSummaryBillingImpl.class);
		return iModalPurchaseOrderSummaryBilling.getOtherLocation(driver, testCaseName);
	}

	public static void clickOnButtonOfOtherLocation(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPurchaseOrderSummaryBilling iModalPurchaseOrderSummaryBilling = FactoryPage.getInstanceOf(IModalPurchaseOrderSummaryBillingImpl.class);
		iModalPurchaseOrderSummaryBilling.clickOnButtonOfOtherLocation(driver, testCaseName);
	}

	public static boolean isCompanyInOUNonEditable(WebDriver driver, String testCaseName) throws Exception
	{
		IModalPurchaseOrderSummaryBilling iModalPurchaseOrderSummaryBilling = FactoryPage.getInstanceOf(IModalPurchaseOrderSummaryBillingImpl.class);
		return iModalPurchaseOrderSummaryBilling.isCompanyInOUNonEditable(driver, testCaseName);
	}

	public static boolean isBusinessUnitInOUNonEditable(WebDriver driver, String testCaseName) throws Exception
	{
		IModalPurchaseOrderSummaryBilling iModalPurchaseOrderSummaryBilling = FactoryPage.getInstanceOf(IModalPurchaseOrderSummaryBillingImpl.class);
		return iModalPurchaseOrderSummaryBilling.isBusinessUnitInOUNonEditable(driver, testCaseName);
	}

	public static boolean isLocationInOUNonEditable(WebDriver driver, String testCaseName) throws Exception
	{
		IModalPurchaseOrderSummaryBilling iModalPurchaseOrderSummaryBilling = FactoryPage.getInstanceOf(IModalPurchaseOrderSummaryBillingImpl.class);
		return iModalPurchaseOrderSummaryBilling.isLocationInOUNonEditable(driver, testCaseName);
	}

	public static String fillCompany(WebDriver driver, String testCaseName, String company) throws Exception
	{
		IModalPurchaseOrderSummaryBilling iModalPurchaseOrderSummaryBilling = FactoryPage.getInstanceOf(IModalPurchaseOrderSummaryBillingImpl.class);
		return iModalPurchaseOrderSummaryBilling.fillCompany(driver, testCaseName, company);
	}

	public static String fillBusinessUnit(WebDriver driver, String testCaseName, String bu) throws Exception
	{
		IModalPurchaseOrderSummaryBilling iModalPurchaseOrderSummaryBilling = FactoryPage.getInstanceOf(IModalPurchaseOrderSummaryBillingImpl.class);
		return iModalPurchaseOrderSummaryBilling.fillBusinessUnit(driver, testCaseName, bu);
	}

	public static String fillLocation(WebDriver driver, String testCaseName, String location) throws Exception
	{
		IModalPurchaseOrderSummaryBilling iModalPurchaseOrderSummaryBilling = FactoryPage.getInstanceOf(IModalPurchaseOrderSummaryBillingImpl.class);
		return iModalPurchaseOrderSummaryBilling.fillLocation(driver, testCaseName, location);
	}

	public static String getCompany(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPurchaseOrderSummaryBilling iModalPurchaseOrderSummaryBilling = FactoryPage.getInstanceOf(IModalPurchaseOrderSummaryBillingImpl.class);
		return iModalPurchaseOrderSummaryBilling.getCompany(driver, testCaseName);
	}

	public static String getBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPurchaseOrderSummaryBilling iModalPurchaseOrderSummaryBilling = FactoryPage.getInstanceOf(IModalPurchaseOrderSummaryBillingImpl.class);
		return iModalPurchaseOrderSummaryBilling.getBusinessUnit(driver, testCaseName);
	}

	public static String getLocation(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPurchaseOrderSummaryBilling iModalPurchaseOrderSummaryBilling = FactoryPage.getInstanceOf(IModalPurchaseOrderSummaryBillingImpl.class);
		return iModalPurchaseOrderSummaryBilling.getLocation(driver, testCaseName);
	}

}
