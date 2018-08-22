package com.zycus.automation.eproc.pageobjects.modals.POFreeTextItemSummaryItem;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModalPOFreeTextItemSummaryItem
{
	public static int getLineNo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.getLineNo(driver, testCaseName);
	}

	public static String fillShortDescription(WebDriver driver, String testCaseName, String shortDesc) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.fillShortDescription(driver, testCaseName, shortDesc);
	}

	public static String clearAndfillShortDescription(WebDriver driver, String testCaseName, String shortDesc) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.clearAndfillShortDescription(driver, testCaseName, shortDesc);
	}

	public static String fillFreeTextItemNo(WebDriver driver, String testCaseName, String itemNo) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.fillFreeTextItemNo(driver, testCaseName, itemNo);
	}

	public static String fillProductCategory(WebDriver driver, String testCaseName, String productCategory) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.fillProductCategory(driver, testCaseName, productCategory);
	}

	public static float fillMarketPrice(WebDriver driver, String testCaseName, float marketPrice) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.fillMarketPrice(driver, testCaseName, marketPrice);
	}

	public static float clearAndfillMarketPrice(WebDriver driver, String testCaseName, float marketPrice) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.clearAndfillMarketPrice(driver, testCaseName, marketPrice);
	}

	public static boolean clickOnItemTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.clickOnItemTab(driver, testCaseName);
	}

	public static float fillQuantity(WebDriver driver, String testCaseName, float quantity) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, quantity);
	}

	public static int fillQuantity(WebDriver driver, String testCaseName, int quantity) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.fillQuantity(driver, testCaseName, quantity);
	}

	public static void clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clickOnSave(driver, testCaseName);
	}

	public static void clearQuantity(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clearQuantity(driver, testCaseName);
	}

	public static void clickOnItemTypeGoods(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clickOnItemTypeGoods(driver, testCaseName);
	}

	public static void clickOnItemTypeServices(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clickOnItemTypeServices(driver, testCaseName);
	}

	public static void clickOnReceiveBillByQuantity(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clickOnReceiveBillByQuantity(driver, testCaseName);
	}

	public static void clickOnReceiveBillByAmount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clickOnReceiveBillByAmount(driver, testCaseName);
	}

	public static void clickOnReceiveBillByNoReceipt(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clickOnReceiveBillByNoReceipt(driver, testCaseName);
	}

	public static String getUOM(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.getUOM(driver, testCaseName);
	}

	public static String getChangeCurrency(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.getChangeCurrency(driver, testCaseName);
	}

	public static String getSpecificationsName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.getSpecificationsName(driver, testCaseName);
	}

	public static Integer enterLineNo(WebDriver driver, String testCaseName, int lineNo) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.enterLineNo(driver, testCaseName, lineNo);
	}

	public static String enterlongDescription(WebDriver driver, String testCaseName, String longDesc) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.enterlongDescription(driver, testCaseName, longDesc);
	}

	public static String fillSpecificationsName(WebDriver driver, String testCaseName, String SpecificationName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.fillSpecificationsName(driver, testCaseName, SpecificationName);
	}

	public static String fillSpecificationsDataKey(WebDriver driver, String testCaseName, String SpecificationsDataKey) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.fillSpecificationsDataKey(driver, testCaseName, SpecificationsDataKey);
	}

	public static String fillModalItemImageUrl(WebDriver driver, String testCaseName, String url) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.fillModalItemImageUrl(driver, testCaseName, url);
	}

	public static String fillSpecificationsDataValue(WebDriver driver, String testCaseName, String SpecificationsDataValue) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.fillSpecificationsDataValue(driver, testCaseName, SpecificationsDataValue);
	}

	public static Integer enterItemNo(WebDriver driver, String testCaseName, int itemNo) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.enterItemNo(driver, testCaseName, itemNo);
	}

	public static boolean isErrorMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isErrorMessageDisplayed(driver, testCaseName);
	}

	public static void enterAndHoverOnProductCategory(WebDriver driver, String testCaseName, String productCategory) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.enterAndHoverOnProductCategory(driver, testCaseName, productCategory);
	}

	public static boolean isItemSummaryModalPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isItemSummaryModalPresent(driver, testCaseName);
	}

	public static boolean isTabErrorPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isTabErrorPresent(driver, testCaseName, index);
	}

	public static boolean isNullSpecificationKeyIcondisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isNullSpecificationKeyIcondisplayed(driver, testCaseName);
	}

	public static boolean isLineNoErrorPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isLineNoErrorPresent(driver, testCaseName, index);
	}

	public static boolean isLineNoErrorMessageCorrect(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isLineNoErrorMessageCorrect(driver, testCaseName, index);
	}

	public static void clickOnShortDescTextBox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clickOnShortDescTextBox(driver, testCaseName);
	}

	public static boolean isLineNoFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isLineNoFieldFilled(driver, testCaseName);
	}

	public static boolean isShortDescFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isShortDescFieldFilled(driver, testCaseName);
	}

	public static boolean isProductCategoryFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isProductCategoryFieldFilled(driver, testCaseName);
	}

	public static boolean isMarketPriceFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isMarketPriceFieldFilled(driver, testCaseName);
	}

	public static boolean isValidUrlMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isValidUrlMsgDisplayed(driver, testCaseName);
	}

	public static boolean isQuantityFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isQuantityFieldFilled(driver, testCaseName);
	}

	public static void clickOnProductCategory(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clickOnProductCategory(driver, testCaseName);
	}

	public static void clickOnItemDetail(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clickOnItemDetail(driver, testCaseName);
	}

	public static void clickOnIsGreenRadioButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clickOnIsGreenRadioButton(driver, testCaseName);
	}

	public static void clickOnIsPreferredRadioButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clickOnIsPreferredRadioButton(driver, testCaseName);
	}

	public static void clickOnCancelBtnItemSummary(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clickOnCancelBtnItemSummary(driver, testCaseName);
	}

	public static boolean isProductCategoryErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isProductCategoryErrorPresent(driver, testCaseName);
	}

	public static boolean isErrorPresentInProductCategoryValid(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isErrorPresentInProductCategoryValid(driver, testCaseName);
	}

	public static boolean isItemNameLenghtValidationErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isItemNameLenghtValidationErrorPresent(driver, testCaseName);
	}

	public static boolean isMarketPriceErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isMarketPriceErrorPresent(driver, testCaseName);
	}

	public static boolean isQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isQuantityErrorPresent(driver, testCaseName);
	}

	public static void clickOnZeroPriceItemCheckbox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clickOnZeroPriceItemCheckbox(driver, testCaseName);
	}

	public static void clearMaxTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clearMaxTotalPrice(driver, testCaseName);
	}

	public static float fillMaxTotalPrice(WebDriver driver, String testCaseName, float maxTotalPrice) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.fillMaxTotalPrice(driver, testCaseName, maxTotalPrice);
	}

	public static float fillMaxUnitPrice(WebDriver driver, String testCaseName, float maxUnitPrice) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.fillMaxUnitPrice(driver, testCaseName, maxUnitPrice);
	}

	public static String getLabelValueOfCategory(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.getLabelValueOfCategory(driver, testCaseName);
	}

	public static boolean isCategoryEditable(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.isCategoryEditable(driver, testCaseName);
	}

	public static float getUnitPriceOfItem(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.getUnitPriceOfItem(driver, testCaseName);
	}

	public static float getMarketPriceOfItem(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.getMarketPriceOfItem(driver, testCaseName);
	}

	public static String getCurrencyOfMarketPriceOfItem(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.getCurrencyOfMarketPriceOfItem(driver, testCaseName);
	}

	public static void clickOnCancel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		iModalPOFreeTextItemSummaryItem.clickOnCancel(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to get the product category
	 */
	public static String getProductCategory(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.getProductCategory(driver, testCaseName);

	}

	public static String fillContractNumber(WebDriver driver, String testCaseName, String contractNumber) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.fillContractNumber(driver, testCaseName, contractNumber);
	}

	/**
	 * @author omkar.jagdale
	 *         method to fill UOM
	 */
	public static String fillUOM(WebDriver driver, String testCaseName, String UOM) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.fillUOM(driver, testCaseName, UOM);

	}

	/**
	 * @author omkar.jagdale
	 *         method to fill line number
	 */
	public static String fillLineNo(WebDriver driver, String testCaseName, int lineNo) throws ActionBotException, FactoryMethodException
	{
		IModalPOFreeTextItemSummaryItem iModalPOFreeTextItemSummaryItem = FactoryPage.getInstanceOf(IModalPOFreeTextItemSummaryItemImpl.class);
		return iModalPOFreeTextItemSummaryItem.fillLineNo(driver, testCaseName, lineNo);
	}
}
