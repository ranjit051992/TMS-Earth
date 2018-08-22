package com.zycus.automation.eproc.pageobjects.pages.replaceItem;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageReplaceItem
{
	public static void clickOnRadioItem(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickOnRadioItem(driver, testCaseName);
	}

	public static void clickOnRadioItemGrid(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickOnRadioItemGrid(driver, testCaseName);
	}

	public static void clickOnReplaceItemButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickOnReplaceItemButton(driver, testCaseName);
	}

	public static String fillChangeComment(WebDriver driver, String testCaseName, String changeComment) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.fillChangeComment(driver, testCaseName, changeComment);
	}

	public static void clickOnConfirm(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickOnConfirm(driver, testCaseName);
	}

	public static String getReplaceItemPageHeaderText(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.getReplaceItemPageHeaderText(driver, testCaseName);
	}

	public static boolean verifyReplaceButtonDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.verifyReplaceButtonDisplayed(driver, testCaseName);
	}

	public static boolean verifyCancelAndGoBackButtonDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.verifyCancelAndGoBackButtonDisplayed(driver, testCaseName);
	}

	public static void clickCancelAndGoBackButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickCancelAndGoBackButton(driver, testCaseName);
	}

	public static String enterproductDescription(WebDriver driver, String testCaseName, String productDescription) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.enterproductDescription(driver, testCaseName, productDescription);
	}

	public static boolean isSearchResultDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isSearchResultDisplayed(driver, testCaseName);
	}

	public static void clearProductDescription(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clearProductDescription(driver, testCaseName);
	}

	public static boolean isItemImageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isItemImageDisplayed(driver, testCaseName);
	}

	public static boolean isItemNameDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isItemNameDisplayed(driver, testCaseName);
	}

	public static boolean isItemDescriptionDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isItemDescriptionDisplayed(driver, testCaseName);
	}

	public static boolean isSupplierNameDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isSupplierNameDisplayed(driver, testCaseName);
	}

	public static boolean isItemLeadTimeDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isItemLeadTimeDisplayed(driver, testCaseName);
	}

	public static boolean isIconIsGreenDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isIconIsGreenDisplayed(driver, testCaseName);
	}

	public static boolean isIconIsPreferredDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isIconIsPreferredDisplayed(driver, testCaseName);
	}

	public static boolean isItemPriceDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isItemPriceDisplayed(driver, testCaseName);
	}

	public static void clickItemName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickItemName(driver, testCaseName);
	}

	public static boolean isItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isItemDetailsPopupDisplayed(driver, testCaseName);
	}

	public static boolean isItemNameInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isItemNameInItemDetailsPopupDisplayed(driver, testCaseName);
	}

	public static boolean isItemPartIdInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isItemPartIdInItemDetailsPopupDisplayed(driver, testCaseName);
	}

	public static boolean isItemPriceInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isItemPriceInItemDetailsPopupDisplayed(driver, testCaseName);
	}

	public static boolean isIconIsGreenInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isIconIsGreenInItemDetailsPopupDisplayed(driver, testCaseName);
	}

	public static boolean isIconIsPreferredInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isIconIsPreferredInItemDetailsPopupDisplayed(driver, testCaseName);
	}

	public static boolean isTabDetailsInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isTabDetailsInItemDetailsPopupDisplayed(driver, testCaseName);
	}

	public static boolean isTabSpecificationInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isTabSpecificationInItemDetailsPopupDisplayed(driver, testCaseName);
	}

	public static boolean isTabAttachmentInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.isTabAttachmentInItemDetailsPopupDisplayed(driver, testCaseName);
	}

	public static void clickCloseOnItemPopUp(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickCloseOnItemPopUp(driver, testCaseName);
	}

	public static boolean verifyFieldsOnDetailsTabItemPopup(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickDetailsTabOnItemPopup(driver, testCaseName);
		return iPageReplaceItem.verifyFieldsOnDetailsTabItemPopup(driver, testCaseName);
	}

	public static void clickDetailsTabOnItemPopup(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickDetailsTabOnItemPopup(driver, testCaseName);
	}

	public static void clickSpecificationTabOnItemPopup(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickSpecificationTabOnItemPopup(driver, testCaseName);
	}

	public static void clickAttachmentsTabOnItemPopup(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickAttachmentsTabOnItemPopup(driver, testCaseName);
	}

	public static boolean verifyFieldsOnSpecificationTabItemPopup(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickSpecificationTabOnItemPopup(driver, testCaseName);
		return iPageReplaceItem.verifyFieldsOnSpecificationTabItemPopup(driver, testCaseName);
	}

	public static boolean verifyFieldsOnAttachmentsTabItemPopup(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickAttachmentsTabOnItemPopup(driver, testCaseName);
		return iPageReplaceItem.verifyFieldsOnAttachmentsTabItemPopup(driver, testCaseName);
	}

	public static void clickButtonAlertOk(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickButtonAlertOk(driver, testCaseName);
	}

	public static void fillReplaceItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.fillReplaceItemQuantity(driver, testCaseName);
	}

	public static boolean verifyButtonConfirmDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.verifyButtonConfirmDisplayed(driver, testCaseName);
	}

	public static boolean verifyLinkCancelDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		return iPageReplaceItem.verifyLinkCancelDisplayed(driver, testCaseName);
	}

	public static void clickCloseOnItemPopUpByXpath(WebDriver driver, String testCaseName, String xpath) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickCloseOnItemPopUpByXpath(driver, testCaseName, xpath);
	}

	public static void clickReplaceFreeTextItemButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageReplaceItem iPageReplaceItem = FactoryPage.getInstanceOf(IPageReplaceItemImpl.class);
		iPageReplaceItem.clickReplaceFreeTextItemButton(driver, testCaseName);
	}

}
