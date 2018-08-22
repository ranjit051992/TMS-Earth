package com.zycus.automation.eproc.pageobjects.modals.UpdateAllLinesPO;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalUpdateAllLinesPO
{
	public static void clickOnDropdownTaxType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		iModalUpdateAllLinesPO.clickOnDropdownTaxType(driver, testCaseName);
	}

	public static void clickOnCloseUpdateAllLines(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		iModalUpdateAllLinesPO.clickOnCloseUpdateAllLines(driver, testCaseName);
	}

	public static String selectTaxType(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		return iModalUpdateAllLinesPO.selectTaxType(driver, testCaseName, taxType, index);
	}

	public static String fillTaxName(WebDriver driver, String testCaseName, String taxName, int index) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		return iModalUpdateAllLinesPO.fillTaxName(driver, testCaseName, taxName, index);
	}

	public static void clickOnApplyTax(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		iModalUpdateAllLinesPO.clickOnApplyTax(driver, testCaseName);
	}

	public static void clickOnRadioButtonTaxNotApplicable(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		iModalUpdateAllLinesPO.clickOnRadioButtonTaxNotApplicable(driver, testCaseName);
	}

	public static float fillTaxRate(WebDriver driver, String testCaseName, float taxRate) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		return iModalUpdateAllLinesPO.fillTaxRate(driver, testCaseName, taxRate);
	}

	public static void clickOnApplyWhereApplicableAndNotDefined(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		iModalUpdateAllLinesPO.clickOnApplyWhereApplicableAndNotDefined(driver, testCaseName);
	}

	public static void clickOnOverrrideWhereDefined(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		iModalUpdateAllLinesPO.clickOnOverrrideWhereDefined(driver, testCaseName);
	}

	public static void clickOnRemoveAllMultipleTaxes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		iModalUpdateAllLinesPO.clickOnRemoveAllMultipleTaxes(driver, testCaseName);
	}

	public static boolean isRemoveAllMultipleTaxesPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		return iModalUpdateAllLinesPO.isRemoveAllMultipleTaxesPresent(driver, testCaseName);
	}

	public static boolean isErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		return iModalUpdateAllLinesPO.isErrorPresent(driver, testCaseName);
	}

	public static boolean isErrorTooltipiconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		return iModalUpdateAllLinesPO.isErrorTooltipiconDisplayed(driver, testCaseName);
	}

	public static void hoverOnErrorIcon(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		iModalUpdateAllLinesPO.hoverOnErrorIcon(driver, testCaseName);
	}

	public static void clickOnAddTax(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		iModalUpdateAllLinesPO.clickOnAddTax(driver, testCaseName);
	}

	public static void clickOnRemoveTax(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		iModalUpdateAllLinesPO.clickOnRemoveTax(driver, testCaseName);
	}

	public static boolean isAddTaxButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		return iModalUpdateAllLinesPO.isAddTaxButtonPresent(driver, testCaseName);
	}

	public static boolean isRemoveTaxButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		return iModalUpdateAllLinesPO.isRemoveTaxButtonPresent(driver, testCaseName);
	}

	public static boolean isTooltipForTaxesPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		return iModalUpdateAllLinesPO.isTooltipForTaxesPresent(driver, testCaseName);
	}

	public static void hoverOnTooltipTaxes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		iModalUpdateAllLinesPO.hoverOnTooltipTaxes(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to fill tax type
	 */
	public static String fillTaxType(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException, FactoryMethodException
	{
		IModalUpdateAllLinesPO iModalUpdateAllLinesPO = FactoryPage.getInstanceOf(IModalUpdateAllLinesPOImpl.class);
		return iModalUpdateAllLinesPO.fillTaxType(driver, testCaseName, taxType, index);
	}
}
