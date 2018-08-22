/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.itemSummaryTax;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author amitkumar.dash
 *
 */
public class ModalItemSummaryTax
{
	static Logger logger = Logger.getLogger(ModalItemSummaryTax.class);

	public static String selectTaxType(WebDriver driver, String testCaseName, String selectBy, String value, int index) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.selectTaxType(driver, testCaseName, selectBy, value, index);
	}

	public static String fillTaxName(WebDriver driver, String testCaseName, String TaxName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.fillTaxName(driver, testCaseName, TaxName);
	}

	public static String fillTaxAmount(WebDriver driver, String testCaseName, String taxAmount) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.fillTaxAmount(driver, testCaseName, taxAmount);
	}

	public static String getTaxrate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.getTaxrate(driver, testCaseName);
	}

	public static String getCurrencyType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.getCurrencyType(driver, testCaseName);
	}

	public static void clickOnTaxesTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		iModalItemSummarytax.clickOnTaxesTab(driver, testCaseName);
	}

	public static void clickOnAddNewTaxbtn(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		iModalItemSummarytax.clickOnAddNewTaxbtn(driver, testCaseName, index);
	}

	public static boolean isTaxSubTotalDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
			iModalItemSummarytax.isTaxSubTotalDisplayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isTaxSubTotalDisplayed " + e, e);
		}
		return false;
	}

	public static String fillTaxRate(WebDriver driver, String testCaseName, String taxRate) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.fillTaxRate(driver, testCaseName, taxRate);
	}

	public static String getTaxeName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.getTaxeName(driver, testCaseName);
	}

	public static void clickOnTaxAmount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		iModalItemSummarytax.clickOnTaxAmount(driver, testCaseName);
	}

	public static String selectTaxTypeOfItemLevelTax(WebDriver driver, String testCaseName, String taxType) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.selectTaxTypeOfItemLevelTax(driver, testCaseName, taxType);
	}

	public static boolean isErrorOnItemlevelTaxPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.isErrorOnItemlevelTaxPresent(driver, testCaseName);
	}

	public static boolean isRemovalAllTaxLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.isRemovalAllTaxLinkPresent(driver, testCaseName);
	}

	public static void clearTaxRate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		iModalItemSummarytax.clearTaxRate(driver, testCaseName);
	}

	public static void clearTaxAmount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		iModalItemSummarytax.clearTaxAmount(driver, testCaseName);
	}

	public static void clickOnTaxRate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		iModalItemSummarytax.clickOnTaxRate(driver, testCaseName);
	}

	public static void clickOnRemoveTaxItemLevel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		iModalItemSummarytax.clickOnRemoveTaxItemLevel(driver, testCaseName);
	}

	public static String selectNextRowTaxTye(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.selectNextRowTaxTye(driver, testCaseName, taxType, index);
	}

	public static String enterNextRowTaxName(WebDriver driver, String testCaseName, String TaxName, int index) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.enterNextRowTaxName(driver, testCaseName, TaxName, index);
	}

	public static String enterNextRowTaxRate(WebDriver driver, String testCaseName, String taxRate, int index) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.enterNextRowTaxRate(driver, testCaseName, taxRate, index);
	}

	public static void clickOnNextRowTaxAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		iModalItemSummarytax.clickOnNextRowTaxAmount(driver, testCaseName, index);
	}

	public static boolean isLabelPlusXTaxesFromTheHeaderDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.isLabelPlusXTaxesFromTheHeaderDisplayed(driver, testCaseName);
	}

	public static boolean isPlusXTaxesFromTheHeaderALabel(WebDriver driver, String testCaseName) throws Exception
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.isPlusXTaxesFromTheHeaderALabel(driver, testCaseName);
	}

	public static String getUnitItemPriceToApplyTaxOn(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.getUnitItemPriceToApplyTaxOn(driver, testCaseName);
	}

	public static boolean isNegationSignPresentInUnitItemPrice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.isNegationSignPresentInUnitItemPrice(driver, testCaseName);
	}

	public static boolean isTooltipPresentInTaxSection(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.isTooltipPresentInTaxSection(driver, testCaseName);
	}

	public static void hoverOnTooltipOfTaxSection(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		iModalItemSummarytax.hoverOnTooltipOfTaxSection(driver, testCaseName);
	}

	public static String getTaxSubTotal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.getTaxSubTotal(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to fill taxt type.
	 */
	public static String fillTaxType(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.fillTaxType(driver, testCaseName, taxType, index);
	}

	/**
	 * @author omkar.jagdale
	 *         method to fill name by index
	 */
	public static String fillTaxNameByIndex(WebDriver driver, String testCaseName, String taxName, int index) throws ActionBotException, FactoryMethodException
	{
		IModalItemSummaryTax iModalItemSummarytax = FactoryPage.getInstanceOf(IModalItemSummaryTaxImpl.class);
		return iModalItemSummarytax.fillTaxNameByIndex(driver, testCaseName, taxName, index);
	}

}
