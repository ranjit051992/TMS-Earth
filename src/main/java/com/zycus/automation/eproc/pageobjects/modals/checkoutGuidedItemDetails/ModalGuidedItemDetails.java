/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.checkoutGuidedItemDetails;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalGuidedItemDetails
{

	public static String fillProductCategory(WebDriver driver, String testCaseName, String category) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillProductCategory(driver, testCaseName, category);
	}

	public static String fillSupplierContract(WebDriver driver, String testCaseName, String contract) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillSupplierContract(driver, testCaseName, contract);
	}

	public static String fillSuplierName(WebDriver driver, String testCaseName, String searchtext) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillSuplierName(driver, testCaseName, searchtext);
	}

	public static String fillBpoNo(WebDriver driver, String testCaseName, String fillBpoNo) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillBpoNo(driver, testCaseName, fillBpoNo);
	}

	public static String selectFirstSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.selectFirstSupplierAddress(driver, testCaseName);
	}

	public static String getItemPrice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getItemPrice(driver, testCaseName);
	}

	public static void clickOnOkButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnOkButton(driver, testCaseName);
	}

	public static void selectBpoRadioButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.selectBpoRadioButton(driver, testCaseName);
	}

	public static void clickOnHeaderBpoNo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnHeaderBpoNo(driver, testCaseName);
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnCancelButton(driver, testCaseName);
	}

	public static void clickOnSupplierDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);
	}

	public static void clickOnSourcingStatusEstimatedPrice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnSourcingStatusEstimatedPrice(driver, testCaseName);
	}

	public static float fillPrice(WebDriver driver, String testCaseName, float price) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillPrice(driver, testCaseName, price);
	}

	public static void clickOnTabSupplierDetails(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnTabSupplierDetails(driver, testCaseName);
	}

	public static String getSupplierName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getSupplierName(driver, testCaseName);
	}

	public static boolean isSuggestedSupplierLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSuggestedSupplierLinkPresent(driver, testCaseName);
	}

	public static void clickOnSuggestedSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnSuggestedSupplierLink(driver, testCaseName);
	}

	public static void clickOnSourcingStatusBuyerNegotiatedPriceOnBuyersDesk(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnSourcingStatusBuyerNegotiatedPriceOnBuyersDesk(driver, testCaseName);
	}

	public static void clickOnSourcingStatusNeedAQuoteOnBuyersDesk(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnSourcingStatusNeedAQuoteOnBuyersDesk(driver, testCaseName);

	}

	public static String fillCurrency(WebDriver driver, String testCaseName, String currency) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillCurrency(driver, testCaseName, currency);
	}

	public static boolean isProductCategoryErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isProductCategoryErrorPresent(driver, testCaseName);
	}

	public static void clickOnShowAllContractsButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnShowAllContractsButton(driver, testCaseName);
	}

	public static String getCurrency(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getCurrency(driver, testCaseName);
	}

	public static String getItemPriceInGuidedModel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getItemPriceInGuidedModel(driver, testCaseName);
	}

	public static void clickOnClickHereToModifyInItemDetail(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnClickHereToModifyInItemDetail(driver, testCaseName);
	}

	public static String getSourcingStatusFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getSourcingStatusFromItemModal(driver, testCaseName);
	}

	public static void clickOnItemTypeServices(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnItemTypeServices(driver, testCaseName);
	}

	public static void clickOnItemTypeGoods(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnItemTypeGoods(driver, testCaseName);
	}

	public static boolean isBpoNumberLinkedPresentInItemDetails(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isBpoNumberLinkedPresentInItemDetails(driver, testCaseName);
	}

	public static void clickOnSelectExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnSelectExistingSupplier(driver, testCaseName);
	}

	public static boolean isRequesterSelectedSuppliersEmptyTablePresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isRequesterSelectedSuppliersEmptyTablePresent(driver, testCaseName);
	}

	public static String getTextOfRequesterSelectedSuppliersEmptyTable(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTextOfRequesterSelectedSuppliersEmptyTable(driver, testCaseName);
	}

	public static void clickOnExpandSystemSuggestedSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnExpandSystemSuggestedSupplier(driver, testCaseName);
	}

	public static String getTextOfTypeColumnOfSystemSuggestedSupplierTable(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTextOfTypeColumnOfSystemSuggestedSupplierTable(driver, testCaseName);
	}

	public static String getTextOfNameColumnOfSystemSuggestedSupplierTable(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTextOfNameColumnOfSystemSuggestedSupplierTable(driver, testCaseName);
	}

	public static String getTextOfAddressColumnOfSystemSuggestedSupplierTable(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTextOfAddressColumnOfSystemSuggestedSupplierTable(driver, testCaseName);
	}

	public static String getTextOfViewContractsColumnOfSystemSuggestedSupplierTable(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTextOfViewContractsColumnOfSystemSuggestedSupplierTable(driver, testCaseName);
	}

	public static String getTextOfActionsColumnOfSystemSuggestedSupplierTable(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTextOfActionsColumnOfSystemSuggestedSupplierTable(driver, testCaseName);
	}

	public static String getTextOfActionForSpecifiedSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTextOfActionForSpecifiedSupplier(driver, testCaseName, supplierName);
	}

	public static boolean isSupplierPresentInSystemSuggestedSuppliersTable(WebDriver driver, String testCaseName, String supplierName)
		throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierPresentInSystemSuggestedSuppliersTable(driver, testCaseName, supplierName);
	}

	public static String getSupplierAddressInSystemSuggestedSuppliersTable(WebDriver driver, String testCaseName, String supplierName)
		throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getSupplierAddressInSystemSuggestedSuppliersTable(driver, testCaseName, supplierName);
	}

	public static boolean isViewContractsLinkPresentInSystemSuggestedSuppliersTable(WebDriver driver, String testCaseName, String supplierName)
		throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isViewContractsLinkPresentInSystemSuggestedSuppliersTable(driver, testCaseName, supplierName);
	}

	public static String getTextOfViewContractsLinkPresentInSystemSuggestedSuppliersTable(WebDriver driver, String testCaseName, String supplierName)
		throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTextOfViewContractsLinkPresentInSystemSuggestedSuppliersTable(driver, testCaseName, supplierName);
	}

	public static boolean isPreviouslyUsedIconPresentInSystemSuggestedSuppliersTable(WebDriver driver, String testCaseName, String supplierName)
		throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isPreviouslyUsedIconPresentInSystemSuggestedSuppliersTable(driver, testCaseName, supplierName);
	}

	public static void clickOnViewContractLink(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnViewContractLink(driver, testCaseName, supplierName);
	}

	public static void clickOnActionForSpecifiedSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnActionForSpecifiedSupplier(driver, testCaseName, supplierName);
	}

	public static boolean isSelectExistingSuggestedSupplierLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSelectExistingSuggestedSupplierLinkPresent(driver, testCaseName);
	}

	public static boolean isAddNewSuggestedSupplierLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isAddNewSuggestedSupplierLinkPresent(driver, testCaseName);
	}

	public static String getMandatoryErrorMsgForSupplierDetails(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getMandatoryErrorMsgForSupplierDetails(driver, testCaseName);
	}

	public static void clickOnSuggestSupplierRadioButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnSuggestSupplierRadioButton(driver, testCaseName);
	}

	public static boolean isSupplierNameTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierNameTextBoxPresentForSuggestExistingSupplier(driver, testCaseName);
	}

	public static boolean isSupplierAddressTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierAddressTextBoxPresentForSuggestExistingSupplier(driver, testCaseName);
	}

	public static boolean isSupplierContactTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierContactTextBoxPresentForSuggestExistingSupplier(driver, testCaseName);
	}

	public static boolean isSupplierEmailIdTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierEmailIdTextBoxPresentForSuggestExistingSupplier(driver, testCaseName);
	}

	public static boolean isSupplierPhoneTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierPhoneTextBoxPresentForSuggestExistingSupplier(driver, testCaseName);
	}

	public static boolean isContractNoTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isContractNoTextBoxPresentForSuggestExistingSupplier(driver, testCaseName);
	}

	public static boolean isOtherDetailsTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isOtherDetailsTextBoxPresentForSuggestExistingSupplier(driver, testCaseName);
	}

	public static boolean isMandatoryIconPresentForSupplierName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isMandatoryIconPresentForSupplierName(driver, testCaseName);
	}

	public static boolean isMandatoryIconPresentForSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isMandatoryIconPresentForSupplierAddress(driver, testCaseName);
	}

	public static String fillExistingSuggestSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillExistingSuggestSupplierName(driver, testCaseName, supplierName);
	}

	public static String selectExistingSuggestSupplierAddress(WebDriver driver, String testCaseName, String supplierAddress) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.selectExistingSuggestSupplierAddress(driver, testCaseName, supplierAddress);
	}

	public static String getAttributeOFExistingSupplierContactField(WebDriver driver, String testCaseName, String attributeName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getAttributeOFExistingSupplierContactField(driver, testCaseName, attributeName);
	}

	public static boolean isShowAllBPOButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isShowAllBPOButtonPresent(driver, testCaseName);
	}

	public static void clickOnShowAllBPOButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnShowAllBPOButton(driver, testCaseName);
	}

	public static String fillExistingSupplierContact(WebDriver driver, String testCaseName, String supplierContact) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillExistingSupplierContact(driver, testCaseName, supplierContact);
	}

	public static String getTagOfEmailId(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTagOfEmailId(driver, testCaseName);
	}

	public static String getTagOfContractNo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTagOfContractNo(driver, testCaseName);
	}

	public static String getTagOfPhoneForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTagOfEmailId(driver, testCaseName);
	}

	public static String getTagOfOtherDetailsForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTagOfOtherDetailsForExistingSupplier(driver, testCaseName);
	}

	public static boolean isSupplierNameTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierNameTextBoxPresentForSuggestNewSupplier(driver, testCaseName);
	}

	public static boolean isSupplierAddressTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierAddressTextBoxPresentForSuggestNewSupplier(driver, testCaseName);
	}

	public static boolean isSupplierContactTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierContactTextBoxPresentForSuggestNewSupplier(driver, testCaseName);
	}

	public static boolean isSupplierEmailIdTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierEmailIdTextBoxPresentForSuggestNewSupplier(driver, testCaseName);
	}

	public static boolean isSupplierPhoneTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierPhoneTextBoxPresentForSuggestNewSupplier(driver, testCaseName);
	}

	public static boolean isContractNoTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isContractNoTextBoxPresentForSuggestNewSupplier(driver, testCaseName);
	}

	public static boolean isOtherDetailsTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isOtherDetailsTextBoxPresentForSuggestNewSupplier(driver, testCaseName);
	}

	public static String getTagOfSupplierNameForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTagOfSupplierNameForSuggestNewSupplier(driver, testCaseName);
	}

	public static void clickOnAddNewSuggestSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnAddNewSuggestSupplier(driver, testCaseName);
	}

	public static String fillSuggestNewSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillSuggestNewSupplierName(driver, testCaseName, supplierName);
	}

	public static boolean isSuggestNewSupplierNameIsMandatory(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSuggestNewSupplierNameIsMandatory(driver, testCaseName);
	}

	public static void clickOnAddSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnAddSupplierButton(driver, testCaseName);
	}

	public static String getFirstSuggestNewSupplierFromRequestedSelectedSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getFirstSuggestNewSupplierFromRequestedSelectedSupplier(driver, testCaseName);
	}

	public static String getTagOfSupplierAddressForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTagOfSupplierAddressForSuggestNewSupplier(driver, testCaseName);
	}

	public static String getTagOfSupplierContactForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTagOfSupplierContactForSuggestNewSupplier(driver, testCaseName);
	}

	public static String getTagOfContractNoForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getTagOfContractNoForSuggestNewSupplier(driver, testCaseName);
	}

	public static String getFirstSuggestNewSupplierAddressFromRequestedSelectedSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getFirstSuggestNewSupplierAddressFromRequestedSelectedSupplier(driver, testCaseName);
	}

	public static String getFirstSuggestNewSupplierContactFromRequestedSelectedSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getFirstSuggestNewSupplierContactFromRequestedSelectedSupplier(driver, testCaseName);
	}

	public static String getFirstSuggestNewContractNoFromRequestedSelectedSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getFirstSuggestNewContractNoFromRequestedSelectedSupplier(driver, testCaseName);
	}

	public static void clickOnItemDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnItemDetailsTab(driver, testCaseName);
	}

	public static boolean isSupplierDetailsErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierDetailsErrorPresent(driver, testCaseName);
	}

	public static void clickOnSourcingStatusQuotedBySupplierRadioButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnSourcingStatusQuotedBySupplierRadioButton(driver, testCaseName);
	}

	public static void clickOnSourcingStatusNeedAQuoteRadioButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnSourcingStatusNeedAQuoteRadioButton(driver, testCaseName);
	}

	public static void clearExistingSupplierName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clearExistingSupplierName(driver, testCaseName);
	}

	public static boolean isSupplierNameTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierNameTextBoxPresentForExistingSupplier(driver, testCaseName);
	}

	public static boolean isSupplierAddressTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierAddressTextBoxPresentForExistingSupplier(driver, testCaseName);
	}

	public static boolean isSupplierContactTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierContactTextBoxPresentForExistingSupplier(driver, testCaseName);
	}

	public static boolean isSupplierEmailIdTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierEmailIdTextBoxPresentForExistingSupplier(driver, testCaseName);
	}

	public static boolean isSupplierPhoneTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isSupplierPhoneTextBoxPresentForExistingSupplier(driver, testCaseName);
	}

	public static boolean isContractNoTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isContractNoTextBoxPresentForExistingSupplier(driver, testCaseName);
	}

	public static boolean isOtherDetailsTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isOtherDetailsTextBoxPresentForExistingSupplier(driver, testCaseName);
	}

	public static String selectSupplierAddressForExistingSupplier(WebDriver driver, String testCaseName, String address) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.selectSupplierAddressForExistingSupplier(driver, testCaseName, address);
	}

	public static String fillSupplierContactForExistingSupplier(WebDriver driver, String testCaseName, String supplierContact) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillSupplierContactForExistingSupplier(driver, testCaseName, supplierContact);
	}

	public static String fillSupplierEmailIdForExistingSupplier(WebDriver driver, String testCaseName, String emailId) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillSupplierEmailIdForExistingSupplier(driver, testCaseName, emailId);
	}

	public static String fillSupplierPhoneForExistingSupplier(WebDriver driver, String testCaseName, String phone) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillSupplierPhoneForExistingSupplier(driver, testCaseName, phone);
	}

	public static String fillContractNoForExistingSupplier(WebDriver driver, String testCaseName, String contractNo) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillContractNoForExistingSupplier(driver, testCaseName, contractNo);
	}

	public static String fillContractNoForNewSupplier(WebDriver driver, String testCaseName, String contractNo) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillSupplierContractForNewSupplier(driver, testCaseName, contractNo);
	}

	public static String fillOtherDetailsForExistingSupplier(WebDriver driver, String testCaseName, String otherDetails) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillOtherDetailsForExistingSupplier(driver, testCaseName, otherDetails);
	}

	public static String getSupplierContactForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getSupplierContactForExistingSupplier(driver, testCaseName);
	}

	public static String getSupplierEmailIdForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getSupplierEmailIdForExistingSupplier(driver, testCaseName);
	}

	public static String getSupplierPhoneForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getSupplierPhoneForExistingSupplier(driver, testCaseName);
	}

	public static String getContractNoForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getContractNoForExistingSupplier(driver, testCaseName);
	}

	public static String getOtherDetailsForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getOtherDetailsForExistingSupplier(driver, testCaseName);
	}

	public static String fillExistingSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillExistingSupplierName(driver, testCaseName, supplierName);
	}

	public static boolean isQuotedBySupplierSourcingStatusPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isQuotedBySupplierSourcingStatusPresent(driver, testCaseName);
	}

	public static boolean isEstimatedPriceSourcingStatusPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isEstimatedPriceSourcingStatusPresent(driver, testCaseName);
	}

	public static boolean isNeedAQuoteSourcingStatusPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isNeedAQuoteSourcingStatusPresent(driver, testCaseName);
	}

	public static String fillQuantity(WebDriver driver, String testCaseName, String quantity, String itemId) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillQuantity(driver, testCaseName, quantity, itemId);
	}

	public static boolean isQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.isQuantityErrorPresent(driver, testCaseName);
	}

	public static String fillUOM(WebDriver driver, String testCaseName, String uom, String itemId) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.fillUOM(driver, testCaseName, uom, itemId);
	}

	public static String getUOM(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getUOM(driver, testCaseName);
	}

	public static float getQuantity(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getQuantity(driver, testCaseName);
	}

	public static void clickButtonYesOnConfirmPopup(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickButtonYesOnConfirmPopup(driver, testCaseName);
	}

	public static void clickEditForRequestedSuggestedSuppliers(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickEditForRequestedSuggestedSuppliers(driver, testCaseName, index);
	}

	public static void clickOnSelectOnSupplierDetailsTab(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnSelectOnSupplierDetailsTab(driver, testCaseName);
	}

	public static void clickOnSystemSuggestedSupplierOnSupplierDetailsTab(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnSystemSuggestedSupplierOnSupplierDetailsTab(driver, testCaseName);

	}

	public static String getSupplierEmailIdFromSupplierTabInRequisition(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getSupplierEmailIdFromSupplierTabInRequisition(driver, testCaseName);

	}

	public static String getSupplierContractNoTabInRequisition(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getSupplierContractNoTabInRequisition(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 */
	public static String getReceiveOrBillByFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getReceiveOrBillByFromItemModal(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 */
	public static String getProductCategoryFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getProductCategoryFromItemModal(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 */
	public static String getShortDescriptionFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getShortDescriptionFromItemModal(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 */
	public static String getLongDescriptionFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getLongDescriptionFromItemModal(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 */
	public static String getItemTypeFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getItemTypeFromItemModal(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 */
	public static String getItemNumberItemModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.getItemNumberItemModal(driver, testCaseName);
	}
	
	/**
	 * @author bhakti.sawant
	 */
	public static void clickOnShowAllBPOForSuggestSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		guidedItemDetails.clickOnShowAllBPOForSuggestSupplierButton(driver, testCaseName);
	}
	
	/**
	 * @author bhakti.sawant
	 * @throws FactoryMethodException 
	 */
	public static boolean clickOnEditActionItemDetailsModal(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.clickOnEditActionItemDetailsModal(driver, testCaseName, supplierName);
	}
	
	/**
	 * @author bhakti.sawant
	 * @throws FactoryMethodException
	 */
	public static boolean clickOnActionForRequesterSuggestedSpecifiedSupplier(WebDriver driver, String testCaseName, String supplierName)throws ActionBotException, FactoryMethodException
	{
		IModalGuidedItemDetails guidedItemDetails = FactoryPage.getInstanceOf(IModalGuidedItemDetailsImpl.class);
		return guidedItemDetails.clickOnActionForRequesterSuggestedSpecifiedSupplier(driver, testCaseName, supplierName);
	}
}
