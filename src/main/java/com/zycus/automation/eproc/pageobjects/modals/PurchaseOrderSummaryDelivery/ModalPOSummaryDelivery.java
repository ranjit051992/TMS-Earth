package com.zycus.automation.eproc.pageobjects.modals.PurchaseOrderSummaryDelivery;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalPOSummaryDelivery
{
	static Logger logger = Logger.getLogger(IModalPOSummaryDelivery.class);

	public static void clickOnClearReqByLink(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPoSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		iModalPoSummaryDelivery.clickOnClearReqByLink(driver);

	}

	public static String fillRequiredByDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		String reqDate = null;
		try
		{
			IModalPOSummaryDelivery checkout = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
			reqDate = checkout.fillRequiredByDate(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectRequiredByDate " + e, e);
		}
		return reqDate;
	}

	public static String isEditableDeliveryField(WebDriver driver, String testCaseName, String DeliverTo) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPoSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		iModalPoSummaryDelivery.isEditableDeliveryField(driver, testCaseName, DeliverTo);
		return DeliverTo;

	}

	public static void clickOnOtherAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		iModalPOSummaryDelivery.clickOnOtherAddress(driver, testCaseName);
	}

	public static void clickOnOtherAddressTextBox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		iModalPOSummaryDelivery.clickOnOtherAddressTextBox(driver, testCaseName);
	}

	public static String fillOtherAddress(WebDriver driver, String testCaseName, String address) throws ActionBotException, FactoryMethodException, InterruptedException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		return iModalPOSummaryDelivery.fillOtherAddress(driver, testCaseName, address);
	}

	public static boolean isHeaderAddressSameAsAddressSelected(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		return iModalPOSummaryDelivery.isHeaderAddressSameAsAddressSelected(driver, testCaseName);
	}

	public static boolean isTaxexChangeConfirmationPopUpDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		return iModalPOSummaryDelivery.isTaxexChangeConfirmationPopUpDisplayed(driver, testCaseName);
	}

	public static void clickOnMyAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		iModalPOSummaryDelivery.clickOnMyAddress(driver, testCaseName);
	}

	public static String enterCityName(WebDriver driver, String testCaseName, String cityName) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		return iModalPOSummaryDelivery.enterCityName(driver, testCaseName, cityName);
	}

	public static String enterCountyName(WebDriver driver, String testCaseName, String countyName) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		return iModalPOSummaryDelivery.enterCountyName(driver, testCaseName, countyName);
	}

	public static String enterFreeTextCountyName(WebDriver driver, String testCaseName, String freeTextCountyName) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		return iModalPOSummaryDelivery.enterFreeTextCountyName(driver, testCaseName, freeTextCountyName);
	}

	public static void clickOnCreateNewAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		iModalPOSummaryDelivery.clickOnCreateNewAddress(driver, testCaseName);
	}

	public static void clickOnCreateNewAddressLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		iModalPOSummaryDelivery.clickOnCreateNewAddressLink(driver, testCaseName);
	}

	public static void clickONTaxCahneConfirmationYesBtn(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		iModalPOSummaryDelivery.clickONTaxChangeConfirmationYesBtn(driver, testCaseName);
	}

	public static String getChangedAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		return iModalPOSummaryDelivery.getChangedAddress(driver, testCaseName);
	}

	public static String getOUAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		return iModalPOSummaryDelivery.getOUAddress(driver, testCaseName);
	}

	public static void clickOnOUAdressCheckbox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		iModalPOSummaryDelivery.clickOnOUAdressCheckbox(driver, testCaseName);
	}

	public static String fillMyAddress(WebDriver driver, String testCaseName, String address) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		return iModalPOSummaryDelivery.fillMyAddress(driver, testCaseName, address);
	}

	public static String fillNewAddressName(WebDriver driver, String testCaseName, String addressName) throws ActionBotException, FactoryMethodException, InterruptedException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		return iModalPOSummaryDelivery.fillNewAddressName(driver, testCaseName, addressName);
	}

	public static String fillNewAddressStreetName(WebDriver driver, String testCaseName, String addressStreetName)
		throws ActionBotException, FactoryMethodException, InterruptedException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		return iModalPOSummaryDelivery.fillNewAddressStreetName(driver, testCaseName, addressStreetName);
	}

	public static int selectCountryName(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		return iModalPOSummaryDelivery.selectCountryName(driver, testCaseName, index);
	}

	public static int fillNewAddressPostalCode(WebDriver driver, String testCaseName, int zipcode) throws ActionBotException, FactoryMethodException, InterruptedException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		return iModalPOSummaryDelivery.fillNewAddressPostalCode(driver, testCaseName, zipcode);

	}

	public static String getDeliverTo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		return iModalPOSummaryDelivery.getDeliverTo(driver, testCaseName);
	}

	public static String fillDeliverTo(WebDriver driver, String testCaseName, String deliverTo) throws ActionBotException, FactoryMethodException
	{
		IModalPOSummaryDelivery iModalPOSummaryDelivery = FactoryPage.getInstanceOf(IModalPOSummaryDeliveryImpl.class);
		return iModalPOSummaryDelivery.fillDeliverTo(driver, testCaseName, deliverTo);
	}

}
