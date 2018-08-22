package com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PageFreeTextForm
{

	static Logger logger = Logger.getLogger(PageFreeTextForm.class);

	public static String fillShortDescription(WebDriver driver, String testcaseName, String shortDescription) throws ActionBotException
	{
		String shortDesc = null;
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			shortDesc = guidedItem.fillShortDescription(driver, testcaseName, shortDescription);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillShortDescription " + e, e);
		}

		return shortDesc;
	}

	public static String getShortDescription(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String shortDesc = null;
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			shortDesc = guidedItem.getShortDescription(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getShortDescription " + e, e);
		}

		return shortDesc;
	}

	public static String fillPartNumber(WebDriver driver, String testcaseName, String partNumber) throws ActionBotException
	{

		String partNo = null;
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			partNo = guidedItem.fillPartNumber(driver, testcaseName, partNumber);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPartNumber " + e, e);
		}

		return partNo;
	}

	public static void clickOnSelectCategory(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnSelectCategory(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectCategory " + e, e);
		}

	}

	public static void clickOnSelectCategoryAtHeader(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnSelectCategoryAtHeader(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectCategoryAtHeader " + e, e);
		}

	}

	public static float fillQuantity(WebDriver driver, String testcaseName, float quantity) throws ActionBotException
	{

		float qty = 0;
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			qty = guidedItem.fillQuantity(driver, testcaseName, quantity);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillQuantity " + e, e);
		}

		return qty;
	}

	public static int fillQuantity(WebDriver driver, String testcaseName, int quantity) throws ActionBotException
	{
		int qty = 0;
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			qty = guidedItem.fillQuantity(driver, testcaseName, quantity);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillQuantity " + e, e);
		}

		return qty;
	}

	public static String fillLongDescription(WebDriver driver, String testcaseName, String longDescription) throws ActionBotException
	{
		String longDesc = null;
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			longDesc = guidedItem.fillLongDescription(driver, testcaseName, longDescription);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillLongDescription " + e, e);
		}

		return longDesc;
	}

	public static boolean isErrorMessageVisible(WebDriver driver, String testcaseName) throws ActionBotException
	{
		boolean flage = false;
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			flage = guidedItem.isErrorMessageVisible(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isErrorMessageVisible " + e, e);
		}

		return flage;
	}

	public static float fillPrice(WebDriver driver, String testcaseName, float price) throws ActionBotException
	{
		float guidedPrice = 0;
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedPrice = guidedItem.fillPrice(driver, testcaseName, price);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPrice " + e, e);
		}

		return guidedPrice;
	}

	public static String getPrice(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String guidedPrice = "";
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedPrice = guidedItem.getPrice(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPrice " + e, e);
		}

		return guidedPrice;
	}

	public static String getQuantity(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String guidedPrice = "";
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedPrice = guidedItem.getQuantity(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getQuantity " + e, e);
		}

		return guidedPrice;
	}

	public static boolean clickItemType(WebDriver driver, String testcaseName, String itemType) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickItemType(driver, testcaseName, itemType);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickItemType " + e, e);
		}

		return false;
	}

	public static boolean clickSourcingStatus(WebDriver driver, String testcaseName, String sourcingStatus) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickSourcingStatus(driver, testcaseName, sourcingStatus);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSourcingStatus " + e, e);
		}

		return false;
	}

	public static boolean isCreateFreeTextItemLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.isCreateFreeTextItemLabelPresent(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSourcingStatus " + e, e);
		}

		return false;
	}

	public static boolean clickReceive_BillBy(WebDriver driver, String testcaseName, String receiveBy) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickReceive_BillBy(driver, testcaseName, receiveBy);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method receive_BillBy " + e, e);
		}

		return false;
	}

	public static boolean clickCopyItem(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickCopyItem(driver, testcaseName);
			return true;
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCopyItem " + e, e);
			return false;
		}

	}

	public static boolean isEFormVisible(WebDriver driver, String testcaseName, String displayName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.isEFormVisible(driver, testcaseName, displayName);
			//return true;
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isEFormVisible " + e, e);
			return false;
		}

	}

	public static boolean isFreeTextItemVisible(WebDriver driver, String testcaseName, String searchName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.isFreeTextItemVisible(driver, testcaseName, searchName);
			return true;
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isFreeTextItemVisible " + e, e);
			return false;
		}

	}

	public static String fillCurrency(WebDriver driver, String testcaseName, String currency) throws ActionBotException
	{

		String curr = null;
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			curr = guidedItem.fillCurrency(driver, testcaseName, currency);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCurrency " + e, e);
		}

		return curr;
	}

	public static void fillNew_ExistingSupplierInfo(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.fillNew_ExistingSupplierInfo(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillNew_ExistingSupplierInfo " + e, e);
		}

	}

	public static boolean clickPlaceOrderWithExistingSupplier(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickPlaceOrderWithExistingSupplier(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickPlaceOrderWithExistingSupplier " + e, e);
		}

		return false;
	}

	public static void clickOnAddToCartButton(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnAddToCartButton(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddToCartButton " + e, e);
		}

	}

	public static void clickOnCancelButton(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnCancelButton(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelButton " + e, e);
		}

	}

	public static void clickOnRecentlyOrderedFreeTextItems(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnRecentlyOrderedFreeTextItems(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRecentlyOrderedFreeTextItems " + e, e);
		}

	}

	public static void clickOnItemLinkOnRecentlyOrderedFreeTextItems(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnItemLinkOnRecentlyOrderedFreeTextItems(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemLinkOnRecentlyOrderedFreeTextItems " + e, e);
		}

	}

	public static void clickOnActionsBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnActionsBtn(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnActionsBtn " + e, e);
		}
	}

	public static String fillUOM(WebDriver driver, String testcaseName, String UOM) throws ActionBotException
	{

		String getUOM = null;
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			getUOM = guidedItem.fillUOM(driver, testcaseName, UOM);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnActionsBtn " + e, e);
		}
		return getUOM;
	}

	public static String fillsupplierNameInSuppInfo(WebDriver driver, String testcaseName, String suppName) throws ActionBotException
	{

		String getSuppInSuppInfo = null;
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			getSuppInSuppInfo = guidedItem.fillsupplierNameInSuppInfo(driver, testcaseName, suppName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillsupplierNameInSuppInfo " + e, e);
		}

		return getSuppInSuppInfo;

	}

	public static String filladdressInSuppInfo(WebDriver driver, String testcaseName, String address) throws ActionBotException
	{

		String getAddressInSuppInfo = null;
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			getAddressInSuppInfo = guidedItem.filladdressInSuppInfo(driver, testcaseName, address);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method filladdressInSuppInfo " + e, e);
		}

		return getAddressInSuppInfo;
	}

	public static String fillcontractNoInSuppInfo(WebDriver driver, String testcaseName, String contractNo) throws ActionBotException
	{
		String contractInSuppInfo = null;
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			contractInSuppInfo = guidedItem.fillcontractNoInSuppInfo(driver, testcaseName, contractNo);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillcontractNoInSuppInfo " + e, e);
		}

		return contractInSuppInfo;
	}

	public static boolean isSelectCategoryLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.isSelectCategoryLinkPresent(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSelectCategoryLinkPresent " + e, e);
		}
		return false;
	}

	public static String getSelectedProductCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getSelectedProductCategory(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedProductCategory " + e, e);
		}
		return null;
	}

	public static int getSizeOfSelectedProductCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getSizeOfSelectedProductCategory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSizeOfSelectedProductCategory " + e, e);
		}
		return 0;
	}

	public static void clickOnSuggestSupplierRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnSuggestSupplierRadioButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSuggestSupplierRadioButton " + e, e);
		}
	}

	public static void clickOnAddNewOrExistingSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnAddNewOrExistingSupplierLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddNewOrExistingSupplierLink " + e, e);
		}

	}

	public static String getSuggestedSupplierNameOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getSuggestedSupplierNameOfFirstRow(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSuggestedSupplierNameOfFirstRow " + e, e);
		}
		return null;
	}

	public static String getSuggestedSupplierTypeOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getSuggestedSupplierTypeOfFirstRow(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSuggestedSupplierTypeOfFirstRow " + e, e);
		}
		return null;
	}

	public static String getSuggestedSupplierActionOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getSuggestedSupplierActionOfFirstRow(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSuggestedSupplierActionOfFirstRow " + e, e);
		}
		return null;
	}

	public static void clickOnShowAllContractOrBPOButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnShowAllContractOrBPOButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnShowAllContractOrBPOButton " + e, e);
		}
	}

	public static String getSelectedContractOrBPOName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getSelectedContractOrBPOName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedContractOrBPOName " + e, e);
		}
		return null;
	}

	public static void clickOnSelectExistingSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnSelectExistingSupplierLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectExistingSupplierLink " + e, e);
		}
	}

	public static void searchForSupplierName(WebDriver driver, String testCaseName, String suppName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.searchForSupplierName(driver, testCaseName, suppName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method searchForSupplierName " + e, e);
		}
	}

	public static void clickSuggestedSupplierRadioLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickSuggestedSupplierRadioLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSuggestedSupplierRadioLink " + e, e);
		}
	}

	public static void clickOnAddNewSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnAddNewSupplierLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddNewSupplierLink " + e, e);
		}
	}

	public static String fillExistingSuggestSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.fillExistingSuggestSupplierName(driver, testCaseName, supplierName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedContractOrBPOName " + e, e);
		}
		return null;
	}

	public static String selectExistingSuggestSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.selectExistingSuggestSupplierAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedContractOrBPOName " + e, e);
		}
		return null;
	}

	public static boolean checkEditingSupplierAddress(WebDriver driver, String testCaseName, int editCount) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.checkEditingSupplierAddress(driver, testCaseName, editCount);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkEditingSupplierAddress " + e, e);
		}
		return false;
	}

	public static String fillExistingSuggestSupplierContractNo(WebDriver driver, String testCaseName, String contractNo) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.fillExistingSuggestSupplierContractNo(driver, testCaseName, contractNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillExistingSuggestSupplierContractNo " + e, e);
		}
		return null;
	}

	public static void clickOnAddExistingSuggestSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnAddExistingSuggestSupplierButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddExistingSuggestSupplierButton " + e, e);
		}
	}

	public static void clickOnResetExistingSuggestSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnResetExistingSuggestSupplierButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnResetExistingSuggestSupplierButton " + e, e);
		}
	}

	public static String fillSuggestNewSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.fillSuggestNewSupplierName(driver, testCaseName, supplierName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSuggestNewSupplierName " + e, e);
		}
		return null;
	}

	public static String selectSuggestNewSupplierAddress(WebDriver driver, String testCaseName, String supplierAddress) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.fillSuggestNewSupplierAddress(driver, testCaseName, supplierAddress);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectSuggestNewSupplierAddress " + e, e);
		}
		return null;
	}

	public static String fillSuggestNewSupplierContractNo(WebDriver driver, String testCaseName, String contractNo) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.fillSuggestNewSupplierContractNo(driver, testCaseName, contractNo);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSuggestNewSupplierContractNo " + e, e);
		}
		return null;
	}

	public static String fillSuggestNewSupplierContact(WebDriver driver, String testCaseName, String contact) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.fillSuggestNewSupplierContact(driver, testCaseName, contact);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSuggestNewSupplierContact " + e, e);
		}
		return null;
	}

	public static String fillSuggestNewSupplierEmailId(WebDriver driver, String testCaseName, String emailID) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.fillSuggestNewSupplierEmailId(driver, testCaseName, emailID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSuggestNewSupplierEmailId " + e, e);
		}
		return null;
	}

	public static int fillSuggestNewSupplierPhone(WebDriver driver, String testCaseName, int phone) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.fillSuggestNewSupplierPhone(driver, testCaseName, phone);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSuggestNewSupplierPhone " + e, e);
		}
		return 0;
	}

	public static String fillSuggestNewSupplierOtherDetails(WebDriver driver, String testCaseName, String otherDetails) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.fillSuggestNewSupplierOtherDetails(driver, testCaseName, otherDetails);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSuggestNewSupplierOtherDetails " + e, e);
		}
		return null;
	}

	public static void clickOnAddSuggestNewSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnAddSuggestNewSupplierButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddSuggestNewSupplierButton " + e, e);
		}
	}

	public static void clickOnResetSuggestNewSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnResetSuggestNewSupplierButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnResetSuggestNewSupplierButton " + e, e);
		}
	}

	public static void clickOnZeroPriceItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnZeroPriceItem(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnZeroPriceItem " + e, e);
		}
	}

	public static void clickOnAddAttachmentLinkAndEscape(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnAddAttachmentLinkAndEscape(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddAttachmentLinkAndEscape " + e, e);
		}
	}

	public static String getSuggestNewExistingSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getSuggestNewExistingSupplierName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSuggestNewExistingSupplierName " + e, e);
		}
		return null;
	}

	public static String getSuggestNewExistingSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getSuggestNewExistingSupplierAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSuggestNewExistingSupplierAddress " + e, e);
		}
		return null;
	}

	public static String getSuggestNewSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getSuggestNewSupplierName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSuggestNewSupplierName " + e, e);
		}
		return null;
	}

	public static String getSuggestNewSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getSuggestNewSupplierAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSuggestNewSupplierAddress " + e, e);
		}
		return null;
	}

	public static String getSuggestNewSupplierContact(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getSuggestNewSupplierContact(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSuggestNewSupplierContact " + e, e);
		}
		return null;
	}

	public static String getSuggestNewSupplierEmailID(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getSuggestNewSupplierEmailID(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSuggestNewSupplierEmailID " + e, e);
		}
		return null;
	}

	public static String getSuggestNewSupplierPhone(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getSuggestNewSupplierOtherDetails(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSuggestNewSupplierOtherDetails " + e, e);
		}
		return null;
	}

	public static String getSuggestNewSupplierContractNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getSuggestNewSupplierOtherDetails(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSuggestNewSupplierOtherDetails " + e, e);
		}
		return null;
	}

	public static String getExistingSupplierContractNumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getExistingSupplierContractNumber(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getExistingSupplierContractNumber " + e, e);
		}
		return null;
	}

	public static String getSuggestNewSupplierOtherDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getSuggestNewSupplierOtherDetails(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSuggestNewSupplierOtherDetails " + e, e);
		}
		return null;
	}

	public static String fillSourcingStatus(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.fillSourcingStatus(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSourcingStatus " + e, e);
		}
		return null;
	}

	public static void clickToCheckout(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickToCheckout(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToCheckout " + e, e);
		}
	}

	public static void clickToAddFreeTextItemIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickToAddFreeTextItemIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToAddFreeTextItemIndexwise " + e, e);
		}
	}

	public static void clickSelectCategoryLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickSelectCategoryLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSelectCategoryLink " + e, e);
		}
	}

	public static void clickCloseItemModalPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickCloseItemModalPopup(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCloseItemModalPopup " + e, e);
		}
	}

	public static boolean selectCategoryFromTheSearchBox(WebDriver driver, String testCaseName, String category) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.selectCategoryFromTheSearchBox(driver, testCaseName, category);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCategoryFromTheSearchBox " + e, e);
			return false;
		}
	}

	public static boolean isEformFieldVisible(WebDriver driver, String testCaseName, String eFormFieldName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.isEformFieldVisible(driver, testCaseName, eFormFieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isEformFieldVisible " + e, e);
			return false;
		}
	}

	public static boolean isCatalogItemCountVisible(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.isCatalogItemCountVisible(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCatalogItemCountVisible " + e, e);
			return false;
		}
	}

	public static boolean isPunchoutCountLinkVisible(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.isPunchoutCountLinkVisible(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPunchoutCountLinkVisible " + e, e);
			return false;
		}
	}

	public static void selectEFormForCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.selectEFormForCategory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectEFormForCategory " + e, e);
		}
	}

	public static void clickSelectEFormLink(WebDriver driver, String testCaseName, String eformName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickSelectEFormLink(driver, testCaseName, eformName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSelectEFormLink " + e, e);
		}
	}

	public static boolean clickEFormInCategoryNameWise(WebDriver driver, String testCaseName, String eFormNAme) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickEFormInCategoryNameWise(driver, testCaseName, eFormNAme);
			return true;
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickEFormIndexwise " + e, e);
			return false;
		}
	}

	public static boolean clickEFormNamewise(WebDriver driver, String testCaseName, String eFormNAme) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickEFormNamewise(driver, testCaseName, eFormNAme);
			return true;
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickEFormNamewise " + e, e);
			return false;
		}
	}

	public static void continueWithoutCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.continueWithoutCategory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method continueWithoutCategory " + e, e);
		}
	}

	public static boolean isContinueWithoutCategoryPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.isContinueWithoutCategoryPresent(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isContinueWithoutCategoryPresent " + e, e);
			return false;
		}
	}

	public static void clickCloseCategoryDailogueButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickCloseCategoryDailogueButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method continueWithoutCategory " + e, e);
		}
	}

	public static boolean isCategoryListPresentInsideEForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.isCategoryListPresentInsideEForm(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCategoryListPresentInsideEForm " + e, e);
			return false;
		}
	}

	public static void clickCatalogItemLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickCatalogItemLink(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCatalogItemLink " + e, e);
		}

	}

	public static boolean isYellowBandPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.isYellowBandPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isYellowBandPresent " + e, e);
			return false;
		}
	}

	public static boolean isCatalogItemPunchoutsHyperlinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.isCatalogItemPunchoutsHyperlinkPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCatalogItemPunchoutsHyperlinkPresent " + e, e);
			return false;
		}
	}

	public static boolean isContractNoFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.isContractNoFieldPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isContractNoFieldPresent " + e, e);
			return false;
		}
	}

	public static void veiwRecentlyOrderedItemLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.veiwRecentlyOrderedItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method veiwRecentlyOrderedItems " + e, e);
		}
	}

	public static void clickRecentlyOrderedItemsIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickRecentlyOrderedItemsIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickRecentlyOrderedItemsIndexwise " + e, e);
		}
	}

	public static void clickSupplierSubTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickSupplierSubTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickSupplierSubTab " + e, e);
		}
	}

	public static void clickCategoryUnderEFormIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickCategoryUnderEFormIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCategoryUnderEFormIndexwise " + e, e);
		}
	}

	public static String getContractNumberFromItemDetailPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getContractNumberFromItemDetailPopup(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getContractNumberFromItemDetailPopup " + e, e);
		}
		return null;
	}

	public static String getItemCurrencyFromItemDetailPopup(WebDriver driver, String testCaseName, String currency) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getItemCurrencyFromItemDetailPopup(driver, testCaseName, currency);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemCurrencyFromItemDetailPopup " + e, e);
		}
		return null;
	}

	public static String getItemQuantityFromItemDetailPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getItemQuantityFromItemDetailPopup(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemQuantityFromItemDetailPopup " + e, e);
		}
		return null;
	}

	public static String getItemPriceFromItemDetailPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.getItemPriceFromItemDetailPopup(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemPriceFromItemDetailPopup " + e, e);
		}
		return null;
	}

	public static void clickShowMoreExtraFields(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickShowMoreExtraFields(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickShowMoreExtraFields " + e, e);
		}
	}

	public static int countSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.countSupplier(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method countSupplier " + e, e);
			return 0;
		}
	}

	public static int countEForms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.countEForms(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method countEForms " + e, e);
			return 0;
		}
	}

	public static boolean isEFormFieldsVisible(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.isEFormFieldsVisible(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isEFormFieldsVisible " + e, e);
			return false;
		}
	}

	public static void clickOnAddAnotherItemOnAddToCartPopup(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnAddAnotherItemOnAddToCartPopup(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddAnotherItemOnAddToCartPopup " + e, e);
		}

	}

	public static boolean isRequirementDetailsSectionVisible(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			return guidedItem.isRequirementDetailsSectionVisible(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillQuantity " + e, e);
			return false;
		}
	}

	public static void clickOnRequisitionAppliesTo_RequirementDetail(WebDriver driver, String testcaseName, String requisitionAppliesTo_RequirementDetail) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnRequisitionAppliesTo_RequirementDetail(driver, testcaseName, requisitionAppliesTo_RequirementDetail);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillQuantity " + e, e);
		}
	}

	public static void clickOnResponse_RequirementDetail(WebDriver driver, String testcaseName, String response_RequirementDetail) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnResponse_RequirementDetail(driver, testcaseName, response_RequirementDetail);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillQuantity " + e, e);
		}
	}

	public static void clickOnPOSentToSupplier_RequirementDetail(WebDriver driver, String testcaseName, String poSentToSupplier_RequirementDetail) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnPOSentToSupplier_RequirementDetail(driver, testcaseName, poSentToSupplier_RequirementDetail);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillQuantity " + e, e);
		}
	}

	public static void clickOnQuoteObtain_RequirementDetail(WebDriver driver, String testcaseName, String quoteObtained_RequirementDetail) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnQuoteObtain_RequirementDetail(driver, testcaseName, quoteObtained_RequirementDetail);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillQuantity " + e, e);
		}
	}

	public static void clickCancelGuideMePopup(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickCancelGuideMePopup(driver, testcaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillQuantity " + e, e);
		}
	}

	public static void clickOnLinkViewCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			guidedItem.clickOnLinkViewCart(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillQuantity " + e, e);
		}
	}
	
	public static boolean clickOnshortDescriptionLinkInRecentlyOrderedFreeTextItemsNameWise(WebDriver driver, String testCaseName, String shortDescription) throws ActionBotException
	{
		boolean flag=false;
		try
		{
			IPageFreeTextForm guidedItem = FactoryPage.getInstanceOfIPageFreeTextForm();
			flag= guidedItem.clickOnshortDescriptionLinkInRecentlyOrderedFreeTextItemsNameWise(driver, testCaseName,shortDescription);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnshortDescriptionLinkInRecentlyOrderedFreeTextItemsNameWise " + e, e);
		}
		return flag;
	}
	
}
