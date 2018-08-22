/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.checkoutGuidedItemDetails;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm.IPageFreeTextForm;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalGuidedItemDetailsImpl implements IModalGuidedItemDetails
{
	static Logger logger = Logger.getLogger(IModalGuidedItemDetailsImpl.class);

	@Override
	public String fillProductCategory(WebDriver driver, String testCaseName, String category) throws ActionBotException
	{

		String selectedCategory = ActionBot.fillAutoCompleteField(driver, TEXTBOX_PRODUCT_CATEGORY_CHECKOUT_ITEM_DETAILS, category);
		logger.info("Selected Product Category : " + selectedCategory);
		return selectedCategory;
	}

	@Override
	public void clickOnOkButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Save Guided Item Button");

		ActionBot.waitForPageLoad(driver);
		ActionBot.click(driver, BUTTON_SAVE_GUIDED_ITEM);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Save Guided Item Button");

	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel Guided Item Button");
		ActionBot.click(driver, BUTTON_CANCEL_GUIDED_ITEM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel Guided Item Button");
	}

	@Override
	public float fillprice(WebDriver driver, String testCaseName, float price) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.sendKeys(driver, TEXTBOX_PRICE_CHECKOUT_ITEM_DETAILS, "" + price);
		String temp = ActionBot.getTextWithInElement(driver, TEXTBOX_PRICE_CHECKOUT_ITEM_DETAILS).trim();
		if (temp != null)
		{
			float no = Float.parseFloat(temp);
			return no;
		}
		else
		{
			return 0;
		}

	}

	@Override
	public String getItemPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, TEXT_PRICE_CHECKOUT_ITEM_DETAILS);
	}

	@Override
	public String fillSupplierContract(WebDriver driver, String testCaseName, String contract) throws ActionBotException
	{
		ActionBot.sendKeys(driver, MODAL_GUIDEDITEMDETAILS_CONTRACT_NO, contract);
		return contract;
	}

	@Override
	public void clickOnSupplierDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, TAB_SUPPLIERS_DETAILS_CHECKOUT_ITEM_DETAILS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Supplier Tab");
	}

	@Override
	public String fillSuplierName(WebDriver driver, String testCaseName, String searchtext) throws ActionBotException
	{
		WebElement ele = ActionBot.findElements(driver, MODAL_GUIDEDITEMDETAILS_SUPPLER_NAME).get(0);
		ele.clear();
		ActionBot.defaultSleep();
		ele.sendKeys(searchtext);
		String supplier_Name = ele.getAttribute("value");
		logger.info("Entered Supplier Name : " + supplier_Name);
		return supplier_Name;
	}

	@Override
	public String fillItemName(WebDriver driver, String testCaseName, String category) throws ActionBotException
	{

		return null;
	}

	@Override
	public void clickOnSourcingStatusEstimatedPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on sourcing status Estimated price");
		ActionBot.click(driver, RADIO_BUTTON_SOURCING_STATUS_BUDGETARY_CHECKOUT_ITEM_DETAILS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on sourcing status Estimated price");

	}

	@Override
	public float fillPrice(WebDriver driver, String testCaseName, float price) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_PRICE_CHECKOUT_ITEM_DETAILS))
		{
			String editedPrice = ActionBot.sendKeys(driver, TEXTBOX_PRICE_CHECKOUT_ITEM_DETAILS, Float.toString(price));
			logger.info("Edited Price : " + editedPrice);
			return Float.parseFloat(editedPrice);
		}
		else
			return price;
	}

	@Override
	public void clickOnTabSupplierDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_SUPPLIERS_DETAILS_CHECKOUT_ITEM_DETAILS);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Supplier details tab");
	}

	@Override
	public String getSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierName = ActionBot.getAttributeOfElement(driver, TEXTBOX_SUPPLIER_NAME_CHECKOUT_ITEM_DETAILS, "value");
		logger.info("Supplier Name : " + supplierName);
		return supplierName;
	}

	@Override
	public boolean isSuggestedSupplierLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_SYSTEM_SUGGESTED_SUPPLIER_GUITEM_ITEM))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnSuggestedSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SYSTEM_SUGGESTED_SUPPLIER_GUITEM_ITEM);

	}

	@Override
	public void clickOnSourcingStatusBuyerNegotiatedPriceOnBuyersDesk(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, RADIO_BUTTON_SOURCING_STATUS_BUYER_NEGOTIATED_PRICE_BUYERS_DESK_ITEM_DETAILS);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnSourcingStatusNeedAQuoteOnBuyersDesk(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_SOURCING_STATUS_NEED_A_QUOTE_BUYERS_DESK_ITEM_DETAILS);
		ActionBot.defaultSleep();

	}

	@Override
	public String fillCurrency(WebDriver driver, String testCaseName, String currency) throws ActionBotException
	{
		String selectedCurrency = ActionBot.fillAutoCompleteField(driver, TEXTBOX_CURRENCY_CHECKOUT_ITEM_DETAILS, currency);
		logger.info("Selected Currency : " + selectedCurrency);
		return selectedCurrency;
	}

	@Override
	public boolean isProductCategoryErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABEL_ERROR_PRODUCT_CATEGORY);
	}

	@Override
	public void clickOnShowAllContractsButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SHOW_ALL_BPO_CHECKOUT_ITEM_DETAILS);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on show all contract button");
	}

	@Override
	public String getCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String currency = ActionBot.getAttributeOfElement(driver, TEXTBOX_CURRENCY_CHECKOUT_ITEM_DETAILS, "value");
		logger.info("Currency : " + currency);
		return currency;
	}

	@Override
	public String selectFirstSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, MODAL_GUIDEDITEMSDETAILS_SUPPLIER_ADDRESS);
		ActionBot.defaultSleep();

		/*
		 * Actions action = new Actions(driver);
		 * action.moveToElement(ActionBot.findElement(driver,
		 * IPageCreateCatalog.SUPPLIER_ADDRESS_SUGGESTION_LIST))
		 * .build().perform();
		 */
		ActionBot.click(driver, IPageFreeTextForm.FIRST_SUPPLIER__ADDRESS);

		String selectedSupplierAddress = ActionBot.findElement(driver, MODAL_GUIDEDITEMSDETAILS_SUPPLIER_ADDRESS).getAttribute("value").trim();
		logger.info("Selected Supplier Address : " + selectedSupplierAddress);
		return selectedSupplierAddress;
	}

	@Override
	public void selectBpoRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_SELECT_BPO);
	}

	@Override
	public void clickOnHeaderBpoNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, HEADER_BPO_TYPE_SHOW_ALL_BPOS);
		ActionBot.defaultSleep();
	}

	@Override
	public String fillBpoNo(WebDriver driver, String testCaseName, String BpoNo) throws ActionBotException
	{
		String bpoNo = null;
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_BPO_NO))
		{
			ActionBot.clear(driver, TEXTBOX_BPO_NO);
			ActionBot.defaultSleep();
			ActionBot.sendKeys(driver, TEXTBOX_BPO_NO, BpoNo);
			ActionBot.defaultSleep();
			bpoNo = ActionBot.getAttributeOfElement(driver, TEXTBOX_BPO_NO, "value");
		}
		return bpoNo;
	}

	@Override
	public String getItemPriceInGuidedModel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_ITEM_PRICE_GUIDED_MODEL);
	}

	@Override
	public void clickOnClickHereToModifyInItemDetail(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CLICK_HERE_TO_MODIFY_IN_ITEM_MODAL);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on click here link in item modal");

	}

	@Override
	public String getSourcingStatusFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_SOURCING_STATUS_IN_ITEM_MODAL);

	}

	@Override
	public void clickOnItemTypeServices(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_ITEM_TYPE_SERVICES_CHECKOUT_ITEM_DETAILS);
	}

	@Override
	public void clickOnItemTypeGoods(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_ITEM_TYPE_GOODS_CHECKOUT_ITEM_DETAILS);
	}

	@Override
	public boolean isBpoNumberLinkedPresentInItemDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_BPO_NUMBER_IN_ITEM_DETAILS))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnSelectExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SELECT_EXISTING_SUPPLIER_ITEM_DETAIL_MODAL);
	}

	@Override
	public boolean isRequesterSelectedSuppliersEmptyTablePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABEL_SUGGESTED_SUPPLIER_BLOCK_EMPTY);
	}

	@Override
	public String getTextOfRequesterSelectedSuppliersEmptyTable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String msg = ActionBot.getTextWithInElement(driver, LABEL_SUGGESTED_SUPPLIER_BLOCK_EMPTY);
		logger.info("Message on Suggested Supplier Empty Block : " + msg);
		return msg;
	}

	@Override
	public void clickOnExpandSystemSuggestedSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SYSTEM_SUGGESTED_SUPPLIER_EXPAND);
	}

	@Override
	public String getTextOfTypeColumnOfSystemSuggestedSupplierTable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String columnName = ActionBot.getTextWithInElement(driver, LABEL_SYSTEM_SUGGESTED_SUPPLIER_TYPE);
		logger.info("Label Name of Type column : " + columnName);
		return columnName;
	}

	@Override
	public String getTextOfNameColumnOfSystemSuggestedSupplierTable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String columnName = ActionBot.getTextWithInElement(driver, LABEL_SYSTEM_SUGGESTED_SUPPLIER_NAME);
		logger.info("Label Name of Name column : " + columnName);
		return columnName;
	}

	@Override
	public String getTextOfAddressColumnOfSystemSuggestedSupplierTable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String columnName = ActionBot.getTextWithInElement(driver, LABEL_SYSTEM_SUGGESTED_SUPPLIER_ADDRESS);
		logger.info("Label Name of Address column : " + columnName);
		return columnName;
	}

	@Override
	public String getTextOfViewContractsColumnOfSystemSuggestedSupplierTable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String columnName = ActionBot.getTextWithInElement(driver, LABEL_SYSTEM_SUGGESTED_SUPPLIER_VIEW_CONTRACTS);
		logger.info("Label Name of View Contracts column : " + columnName);
		return columnName;
	}

	@Override
	public String getTextOfActionsColumnOfSystemSuggestedSupplierTable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String columnName = ActionBot.getTextWithInElement(driver, LABEL_SYSTEM_SUGGESTED_SUPPLIER_ACTIONS);
		logger.info("Label Name of Actions column : " + columnName);
		return columnName;
	}

	@Override
	public String getTextOfActionForSpecifiedSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		String action = ActionBot.getTextWithInElement(driver, By.xpath(xpath1_action_system_suggested_supplier + supplierName + xpath2_action_system_suggested_supplier));
		logger.info("Label of Action for : " + supplierName + " is : " + action);
		return action;
	}

	@Override
	public boolean isSupplierPresentInSystemSuggestedSuppliersTable(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath(xpath1_action_system_suggested_supplier + supplierName + xpath2_supplierName_system_suggested_supplier));
	}

	@Override
	public String getSupplierAddressInSystemSuggestedSuppliersTable(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		String address = ActionBot.getTextWithInElement(driver,
			By.xpath(xpath1_action_system_suggested_supplier + supplierName + xpath2_supplierAddress_system_suggested_supplier));
		logger.info("Supplier Address for : " + supplierName + " is : " + address);
		return address;
	}

	@Override
	public boolean isViewContractsLinkPresentInSystemSuggestedSuppliersTable(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath(xpath1_action_system_suggested_supplier + supplierName + xpath2_viewContractsLink_system_suggested_supplier));
	}

	@Override
	public String getTextOfViewContractsLinkPresentInSystemSuggestedSuppliersTable(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		String labelOfViewContracts = ActionBot.getTextWithInElement(driver,
			By.xpath(xpath1_action_system_suggested_supplier + supplierName + xpath2_viewContractsLink_system_suggested_supplier));
		logger.info("Label value of View Supplier for : " + supplierName + " is : " + labelOfViewContracts);
		return labelOfViewContracts;
	}

	@Override
	public boolean isPreviouslyUsedIconPresentInSystemSuggestedSuppliersTable(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath(xpath1_action_system_suggested_supplier + supplierName + xpath2_previouslyUsedIcon_system_suggested_supplier));
	}

	@Override
	public void clickOnViewContractLink(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(xpath1_action_system_suggested_supplier + supplierName + xpath2_viewContractsLink_system_suggested_supplier));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on View Contracts");
	}

	@Override
	public void clickOnActionForSpecifiedSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(xpath1_action_system_suggested_supplier + supplierName + xpath2_action_system_suggested_supplier));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Actions of Supplier");
	}

	@Override
	public boolean isSelectExistingSuggestedSupplierLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_SELECT_EXISTING_SUPPLIER_ITEM_DETAIL_MODAL);
	}

	@Override
	public boolean isAddNewSuggestedSupplierLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LINK_ADD_NEW_SUGGEST_SUPPLIER_IN_ITEM_DETAILS_MODAL);
	}

	@Override
	public String getMandatoryErrorMsgForSupplierDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String errorMsg = ActionBot.getAttributeOfElement(driver, ERROR_MSG_SUPPLIER_DETAILS_MANDATORY_ON_ITEM_DETAIL_MODAL, "title");
		logger.info("Mandatory Error Msg : " + errorMsg);
		return errorMsg;
	}

	@Override
	public void clickOnSuggestSupplierRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_SUGGEST_SUPPLIER_CHECKOUT_ITEM_DETAILS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on suggest supplier radio button");
	}

	@Override
	public boolean isSupplierNameTextBoxPresentForSuggestExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, IPageFreeTextForm.TEXTBOX_EXISTING_SUGGEST_SUPPLIER_NAME);
	}

	@Override
	public boolean isSupplierAddressTextBoxPresentForSuggestExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, IPageFreeTextForm.SELECT_EXISTING_SUGGEST_SUPPLIER_ADDRESS);
	}

	@Override
	public boolean isSupplierContactTextBoxPresentForSuggestExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_EXISTING_SUGGEST_SUPPLIER_CONTACT);
	}

	@Override
	public boolean isSupplierEmailIdTextBoxPresentForSuggestExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_EXISTING_SUGGEST_SUPPLIER_EMAIL_ID);
	}

	@Override
	public boolean isSupplierPhoneTextBoxPresentForSuggestExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_EXISTING_SUGGEST_SUPPLIER_PHONE);
	}

	@Override
	public boolean isContractNoTextBoxPresentForSuggestExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, IPageFreeTextForm.TEXTBOX_EXISTING_SUGGEST_SUPPLIER_CONTRACT_NO);
	}

	@Override
	public boolean isOtherDetailsTextBoxPresentForSuggestExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_EXISTING_SUGGEST_OTHER_DETAILS);
	}

	@Override
	public boolean isMandatoryIconPresentForSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, ICON_MANDATORY_SUPPLIER_NAME_ON_ITEM_DETAIL_MODAL);
	}

	@Override
	public boolean isMandatoryIconPresentForSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, ICON_MANDATORY_SUPPLIER_ADDRESS_ON_ITEM_DETAIL_MODAL);
	}

	@Override
	public String fillExistingSuggestSupplierName(WebDriver driver, String testcaseName, String supplierName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, IPageFreeTextForm.TEXTBOX_EXISTING_SUGGEST_SUPPLIER_NAME);
		String selectedSupplierName = ActionBot.fillAutoCompleteField(driver, IPageFreeTextForm.TEXTBOX_EXISTING_SUGGEST_SUPPLIER_NAME, supplierName);
		logger.info("Selected existing suggested Supplier Name : " + selectedSupplierName);
		return selectedSupplierName;
	}

	@Override
	public String selectExistingSuggestSupplierAddress(WebDriver driver, String testcaseName, String supplierAddress) throws ActionBotException
	{
		String selectedSupplierAddress = null;
		if (supplierAddress == null)
		{
			ActionBot.moveToElement(driver, IPageFreeTextForm.SELECT_EXISTING_SUGGEST_SUPPLIER_ADDRESS);
			selectedSupplierAddress = ActionBot.selectValueFromAutoCompleteList(driver, IPageFreeTextForm.SELECT_EXISTING_SUGGEST_SUPPLIER_ADDRESS,
				IPageFreeTextForm.AUTO_POPULATED_LIST_FOR_SUGGEST_EXISTING_SUPPLIER_ADDRESS, null);
			logger.info("Selected existing suggested Supplier Address :" + selectedSupplierAddress);
		}
		return selectedSupplierAddress;
	}

	@Override
	public String getAttributeOFExistingSupplierContactField(WebDriver driver, String testCaseName, String attributeName) throws ActionBotException
	{
		String attributeValue = ActionBot.getAttributeOfElement(driver, TEXTBOX_EXISTING_SUGGEST_SUPPLIER_CONTACT, attributeName);
		logger.info("Attribute value : " + attributeValue);
		return attributeValue;
	}

	@Override
	public boolean isShowAllBPOButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_SHOW_ALL_BPO_ON_ITEM_DETAIL_MODAL);
	}

	@Override
	public void clickOnShowAllBPOButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SHOW_ALL_BPO_ON_ITEM_DETAIL_MODAL);
	}

	@Override
	public String fillExistingSupplierContact(WebDriver driver, String testCaseName, String supplierContact) throws ActionBotException
	{
		String enteredSupplierContact = ActionBot.sendKeys(driver, TEXTBOX_EXISTING_SUGGEST_SUPPLIER_CONTACT, supplierContact);
		logger.info("Entered Supplier Contact : " + enteredSupplierContact);
		return enteredSupplierContact;
	}

	@Override
	public String getTagOfEmailId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String tagName = ActionBot.findElement(driver, TEXTBOX_EXISTING_SUGGEST_SUPPLIER_EMAIL_ID).getTagName();
		logger.info("Tag Name of Email Id Field : " + tagName);
		return tagName;
	}

	@Override
	public String getTagOfContractNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String tagName = ActionBot.findElement(driver, TEXTBOX_CONTRACT_NO_FOR_EXISTING_SUPPLIER_ON_CHECKOUT_ITEM_DETAILS).getTagName();
		logger.info("Tag Name of Contract No Field : " + tagName);
		return tagName;
	}

	@Override
	public String getTagOfPhoneForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String tagName = ActionBot.findElement(driver, TEXTBOX_EXISTING_SUGGEST_SUPPLIER_PHONE).getTagName();
		logger.info("Tag Name of Phone Field : " + tagName);
		return tagName;
	}

	@Override
	public String getTagOfOtherDetailsForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String tagName = ActionBot.findElement(driver, TEXTBOX_EXISTING_SUGGEST_OTHER_DETAILS).getTagName();
		logger.info("Tag Name of Other Details Field : " + tagName);
		return tagName;
	}

	@Override
	public boolean isSupplierNameTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, IPageFreeTextForm.TEXTBOX_SUGGEST_NEW_SUPPLIER_NAME);
	}

	@Override
	public boolean isSupplierAddressTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, IPageFreeTextForm.SELECT_SUGGEST_NEW_SUPPLIER_ADDRESS);
	}

	@Override
	public boolean isSupplierContactTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, IPageFreeTextForm.TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTACT);
	}

	@Override
	public boolean isSupplierEmailIdTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, IPageFreeTextForm.TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTACT_EMAIL_ID);
	}

	@Override
	public boolean isSupplierPhoneTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, IPageFreeTextForm.TEXTBOX_SUGGEST_NEW_SUPPLIER_PHONE);
	}

	@Override
	public boolean isContractNoTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, IPageFreeTextForm.TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTRACT_NO);
	}

	@Override
	public boolean isOtherDetailsTextBoxPresentForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, IPageFreeTextForm.TEXTBOX_SUGGEST_NEW_SUPPLIER_OTHER_DETAILS);
	}

	@Override
	public String getTagOfSupplierNameForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String tagName = ActionBot.findElement(driver, IPageFreeTextForm.TEXTBOX_SUGGEST_NEW_SUPPLIER_NAME).getTagName();
		logger.info("TagName of Supplier Name : " + tagName);
		return tagName;
	}

	@Override
	public void clickOnAddNewSuggestSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_NEW_SUGGEST_SUPPLIER_IN_ITEM_DETAILS_MODAL);
		ScreenShot.screenshot(driver, testCaseName, "Add New Suggest Supplier");

	}

	@Override
	public String fillSuggestNewSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		String supplier_Name = ActionBot.sendKeys(driver, IPageFreeTextForm.TEXTBOX_SUGGEST_NEW_SUPPLIER_NAME, supplierName);
		logger.info("Entered Suggest New Supplier Name : " + supplier_Name);
		return supplier_Name;
	}

	@Override
	public boolean isSuggestNewSupplierNameIsMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, ICON_MANDATORY_SUGGEST_NEW_SUPPLIER_NAME_ON_ITEM_DETAIL_MODAL);
	}

	@Override
	public void clickOnAddSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, IPageFreeTextForm.BUTTON_ADD_NEW_SUGGEST_SUPPLIER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Add Suggest New Supplier Button");
	}

	@Override
	public String getFirstSuggestNewSupplierFromRequestedSelectedSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierName = ActionBot.getTextWithInElement(driver, LABEL_FIRST_SUGGESTED_NEW_SUPPLIER);
		logger.info("First Suggested Supplier Name in Requested Selected Supplier Table : " + supplierName);
		return supplierName;
	}

	@Override
	public String getTagOfSupplierAddressForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String tagName = ActionBot.findElement(driver, IPageFreeTextForm.SELECT_SUGGEST_NEW_SUPPLIER_ADDRESS).getTagName();
		logger.info("TagName of Supplier Address : " + tagName);
		return tagName;
	}

	@Override
	public String getTagOfSupplierContactForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String tagName = ActionBot.findElement(driver, IPageFreeTextForm.TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTACT).getTagName();
		logger.info("TagName of Supplier Contact : " + tagName);
		return tagName;
	}

	@Override
	public String getTagOfContractNoForSuggestNewSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String tagName = ActionBot.findElement(driver, IPageFreeTextForm.TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTRACT_NO).getTagName();
		logger.info("TagName of Contract No : " + tagName);
		return tagName;
	}

	@Override
	public String getFirstSuggestNewSupplierAddressFromRequestedSelectedSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierAddress = null;
		WebElement element = ActionBot.findElement(driver, LABEL_FIRST_SUGGESTED_NEW_SUPPLIER_ADDRESS);
		if (element.getAttribute("data-qtipmsg") != null)
			supplierAddress = element.getAttribute("data-qtipmsg");
		else if (ActionBot.getTextWithInElement(driver, element) != null)
			supplierAddress = ActionBot.getTextWithInElement(driver, element);
		//		if(ActionBot.findElement(driver, LABEL_FIRST_SUGGESTED_NEW_SUPPLIER_ADDRESS).getAttribute("data-qtipmsg")!=null)
		//		String supplierAddress=ActionBot.findElement(driver, LABEL_FIRST_SUGGESTED_NEW_SUPPLIER_ADDRESS).getAttribute("data-qtipmsg").trim();
		//String supplierAddress = ActionBot.getTextWithInElement(driver, LABEL_FIRST_SUGGESTED_NEW_SUPPLIER_ADDRESS);
		logger.info("First Suggested Supplier Address in Requested Selected Supplier Table : " + supplierAddress);
		return supplierAddress;
	}

	@Override
	public String getFirstSuggestNewSupplierContactFromRequestedSelectedSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierContact = ActionBot.getTextWithInElement(driver, LABEL_FIRST_SUGGESTED_NEW_SUPPLIER_CONTACT);
		logger.info("First Suggested Supplier Contact in Requested Selected Supplier Table : " + supplierContact);
		return supplierContact;
	}

	@Override
	public String getFirstSuggestNewContractNoFromRequestedSelectedSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String contractNo = ActionBot.getTextWithInElement(driver, LABEL_FIRST_SUGGESTED_NEW_SUPPLIER_CONTRACT_NO);
		logger.info("First Suggested Contract No in Requested Selected Supplier Table : " + contractNo);
		return contractNo;
	}

	@Override
	public void clickOnItemDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_ITEM_DETAILS_IN_ITEM_DETAILS_MODAL_CHECKOUT_PAGE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Item Details Tab");
	}

	@Override
	public boolean isSupplierDetailsErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, ERROR_MSG_SUPPLIER_DETAILS_MANDATORY_ON_ITEM_DETAIL_MODAL);
	}

	@Override
	public void clickOnSourcingStatusQuotedBySupplierRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, RADIO_BUTTON_SOURCING_STATUS_REQUESTER_CHECKOUT_ITEM_DETAILS))
		{
			ActionBot.click(driver, RADIO_BUTTON_SOURCING_STATUS_REQUESTER_CHECKOUT_ITEM_DETAILS);
		}
		//handle click by script
		if (!ActionBot.isElementSelected(driver, RADIO_BUTTON_SOURCING_STATUS_REQUESTER_CHECKOUT_ITEM_DETAILS))
		{
			WebElement element = ActionBot.findElement(driver, RADIO_BUTTON_SOURCING_STATUS_REQUESTER_CHECKOUT_ITEM_DETAILS);
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			javascriptExecutor.executeScript("arguments[0].click();", element);
		}
	}

	@Override
	public void clickOnSourcingStatusNeedAQuoteRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_SOURCING_STATUS_QUOTE_CHECKOUT_ITEM_DETAILS);
	}

	@Override
	public void clearExistingSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_SUPPLIER_NAME_CHECKOUT_ITEM_DETAILS);
	}

	@Override
	public boolean isSupplierNameTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_SUPPLIER_NAME_CHECKOUT_ITEM_DETAILS);
	}

	@Override
	public boolean isSupplierAddressTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_SUPPLIER_ADDRESS_CHECKOUT_ITEM_DETAILS);
	}

	@Override
	public boolean isSupplierContactTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_SUPPLIER_CONTACT_CHECKOUT_ITEM_DETAILS);
	}

	@Override
	public boolean isSupplierEmailIdTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_SUPPLIER_EMAIL_ID_CHECKOUT_ITEM_DETAILS);
	}

	@Override
	public boolean isSupplierPhoneTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_SUPPLIER_PHONE_CHECKOUT_ITEM_DETAILS);
	}

	@Override
	public boolean isContractNoTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, MODAL_GUIDEDITEMDETAILS_CONTRACT_NO);
	}

	@Override
	public boolean isOtherDetailsTextBoxPresentForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_SUPPLIER_OTHER_DETAILS_CHECKOUT_ITEM_DETAILS);
	}

	@Override
	public String selectSupplierAddressForExistingSupplier(WebDriver driver, String testCaseName, String address) throws ActionBotException
	{
		ActionBot.click(driver, TEXTBOX_SUPPLIER_ADDRESS_CHECKOUT_ITEM_DETAILS);
		ActionBot.defaultSleep();

		if (address != null)
		{

		}
		else
		{
			ActionBot.click(driver, IPageFreeTextForm.FIRST_SUPPLIER__ADDRESS);
		}

		String selectedSupplierAddress = ActionBot.findElement(driver, TEXTBOX_SUPPLIER_ADDRESS_CHECKOUT_ITEM_DETAILS).getAttribute("value").trim();
		logger.info("Selected Supplier Address : " + selectedSupplierAddress);
		return selectedSupplierAddress;

	}

	@Override
	public String fillSupplierContactForExistingSupplier(WebDriver driver, String testCaseName, String supplierContact) throws ActionBotException
	{
		String contact = ActionBot.sendKeys(driver, TEXTBOX_SUPPLIER_CONTACT_CHECKOUT_ITEM_DETAILS, supplierContact);
		logger.info("Entered Supplier Contact : " + contact);
		return contact;
	}

	@Override
	public String fillSupplierEmailIdForExistingSupplier(WebDriver driver, String testCaseName, String emailId) throws ActionBotException
	{
		String email_id = ActionBot.sendKeys(driver, TEXTBOX_SUPPLIER_EMAIL_ID_CHECKOUT_ITEM_DETAILS, emailId);
		logger.info("Entered Email Id : " + email_id);
		return email_id;
	}

	@Override
	public String fillSupplierPhoneForExistingSupplier(WebDriver driver, String testCaseName, String phone) throws ActionBotException
	{
		String phone_no = ActionBot.sendKeys(driver, TEXTBOX_SUPPLIER_PHONE_CHECKOUT_ITEM_DETAILS, phone);
		logger.info("Entered Phone No : " + phone_no);
		return phone_no;
	}

	@Override
	public String fillContractNoForExistingSupplier(WebDriver driver, String testCaseName, String contractNo) throws ActionBotException
	{
		String contract_no = ActionBot.sendKeys(driver, MODAL_GUIDEDITEMDETAILS_CONTRACT_NO, contractNo);
		logger.info("Entered Contract No : " + contract_no);
		return contract_no;
	}

	@Override
	public String fillOtherDetailsForExistingSupplier(WebDriver driver, String testCaseName, String otherDetails) throws ActionBotException
	{
		String other_details = ActionBot.sendKeys(driver, TEXTBOX_SUPPLIER_OTHER_DETAILS_CHECKOUT_ITEM_DETAILS, otherDetails);
		logger.info("Entered Other Details : " + other_details);
		return other_details;
	}

	@Override
	public String getSupplierContactForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierContact = ActionBot.getAttributeOfElement(driver, TEXTBOX_SUPPLIER_NAME_CHECKOUT_ITEM_DETAILS, "value");
		logger.info("Supplier Contact : " + supplierContact);
		return supplierContact;
	}

	@Override
	public String getSupplierEmailIdForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String emailId = ActionBot.getAttributeOfElement(driver, TEXTBOX_SUPPLIER_EMAIL_ID_CHECKOUT_ITEM_DETAILS, "value");
		logger.info("Email ID : " + emailId);
		return emailId;
	}

	@Override
	public String getSupplierPhoneForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String phone = ActionBot.getAttributeOfElement(driver, TEXTBOX_SUPPLIER_PHONE_CHECKOUT_ITEM_DETAILS, "value");
		logger.info("Phone : " + phone);
		return phone;
	}

	@Override
	public String getContractNoForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String contractNo = ActionBot.getAttributeOfElement(driver, MODAL_GUIDEDITEMDETAILS_CONTRACT_NO, "value");
		logger.info("Contract No : " + contractNo);
		return contractNo;
	}

	@Override
	public String getOtherDetailsForExistingSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String otherDetails = ActionBot.getAttributeOfElement(driver, TEXTBOX_SUPPLIER_OTHER_DETAILS_CHECKOUT_ITEM_DETAILS, "value");
		logger.info("Other Details : " + otherDetails);
		return otherDetails;
	}

	@Override
	public String fillExistingSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		String enteredSupplierName = ActionBot.fillAutoCompleteField(driver, TEXTBOX_SUPPLIER_NAME_CHECKOUT_ITEM_DETAILS, supplierName);
		logger.info("Entered Supplier Name : " + enteredSupplierName);
		return enteredSupplierName;
	}

	@Override
	public boolean isQuotedBySupplierSourcingStatusPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		/*
		 * boolean flag = ActionBot.getAttributeOfElement(driver,
		 * LABEL_QUOTED_BY_SUPPLIER_SOURCING_STATUS_ITEM_DETAILS_MODAL,
		 * "style").equalsIgnoreCase( "display: inline-block;");
		 */
		return ActionBot.isElementPresent(driver, RADIO_BUTTON_SOURCING_STATUS_REQUESTER_CHECKOUT_ITEM_DETAILS);
	}

	@Override
	public boolean isEstimatedPriceSourcingStatusPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		/*
		 * boolean flag = ActionBot.getAttributeOfElement(driver,
		 * LABEL_ESTIMATED_PRICE_SOURCING_STATUS_ITEM_DETAILS_MODAL,
		 * "style").equalsIgnoreCase( "display: inline-block;");
		 */
		return ActionBot.isElementPresent(driver, RADIO_BUTTON_SOURCING_STATUS_BUDGETARY_CHECKOUT_ITEM_DETAILS);
	}

	@Override
	public boolean isNeedAQuoteSourcingStatusPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		/*
		 * boolean flag = ActionBot.getAttributeOfElement(driver,
		 * LABEL_NEED_A_QUOTE_SOURCING_STATUS_ITEM_DETAILS_MODAL,
		 * "style").equalsIgnoreCase("display: inline-block;");
		 */
		return ActionBot.isElementPresent(driver, RADIO_BUTTON_SOURCING_STATUS_QUOTE_CHECKOUT_ITEM_DETAILS);

	}

	@Override
	public String fillQuantity(WebDriver driver, String testCaseName, String quantity, String itemId) throws ActionBotException
	{
		String enteredQuantity = ActionBot.sendKeys(driver, By.xpath(".//*[@id='guidedItemDetailsForm_" + itemId + "']//input[@name='quantity']"), quantity);
		logger.info("Entered Quantity : " + enteredQuantity);
		return enteredQuantity;
	}

	@Override
	public boolean isQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ERROR_INVALID_QUANTITY_GUIDED_ITEM_DETAILS);
	}

	@Override
	public String fillUOM(WebDriver driver, String testCaseName, String uom, String itemId) throws ActionBotException
	{
		String enteredUOM = ActionBot.fillAutoCompleteField(driver, ActionBot.findElement(driver, By.xpath(".//*[@id='guidedItemDetailsForm_" + itemId + "']//input[@name='uom']")),
			uom);
		//String enteredUOM = ActionBot.sendKeys(driver, By.xpath(".//*[@id='guidedItemDetailsForm_" + itemId + "']//input[@name='uom']"), uom);
		logger.info("Entered UOM : " + enteredUOM);
		return enteredUOM;
	}

	@Override
	public String getUOM(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String UOM = ActionBot.getAttributeOfElement(driver, TEXTBOX_UOM_CHECKOUT_ITEM_DETAILS, "value");
		logger.info("UOM : " + UOM);
		return UOM;
	}

	@Override
	public float getQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String quantity = ActionBot.getAttributeOfElement(driver, TEXTBOX_QUANTITY_CHECKOUT_ITEM_DETAILS, "value");
		logger.info("Quantity : " + quantity);
		return Float.parseFloat(quantity);
	}

	@Override
	public void clickButtonYesOnConfirmPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_YES_CONFIRM_POPUP);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickEditForRequestedSuggestedSuppliers(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String editXpath = "(.//*[@id='reqSelectedSupp']//a[contains(@class,'editSelectedSupplier')])[" + index + "]";

		ActionBot.findElement(driver, By.xpath(editXpath)).click();
		ActionBot.defaultSleep();
	}

	@Override
	public String fillSupplierContractForNewSupplier(WebDriver driver, String testCaseName, String contract) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_ITEM_SUMMARY_SUGGESTED_NEW_SUPPLIER_CONTRACT, contract);
		return contract;
	}

	@Override
	public void clickOnSelectOnSupplierDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, CLICK_ON_SELECT_ON_SUPPLIER_TAB))
		{
			ActionBot.click(driver, CLICK_ON_SELECT_ON_SUPPLIER_TAB);
		}
	}

	@Override
	public void clickOnSystemSuggestedSupplierOnSupplierDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{

		if (ActionBot.isElementDisplayed(driver, CLICK_ON_SUGGESTED_SUPPLIER_ON_SUPPLIER_TAB))
			if (ActionBot.isElementDisplayed(driver, CLICK_ON_SUGGESTED_SUPPLIER_ON_SUPPLIER_TAB))
			{
				ActionBot.click(driver, CLICK_ON_SUGGESTED_SUPPLIER_ON_SUPPLIER_TAB);
			}

	}

	@Override
	public String getSupplierEmailIdFromSupplierTabInRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.getTextWithInElement(driver, LABEL_SUPPLIER_EMAIL_ID_IN_REQUISITION_PAGE);
	}

	@Override
	public String getSupplierContractNoTabInRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, LABEL_SUPPLIER_EMAIL_ID_IN_REQUISITION_PAGE);

	}

	@Override
	public String getReceiveOrBillByFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, TEXT_RECEIVE_BY_IN_ITEM_MODAL);

	}

	@Override
	public String getProductCategoryFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, TEXT_PRODUCT_CATEGORY_IN_ITEM_MODAL);

	}

	@Override
	public String getShortDescriptionFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, TEXT_SHORT_DESCRIPTION_IN_ITEM_MODAL);

	}

	@Override
	public String getLongDescriptionFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, TEXT_LONG_DESCRIPTION_IN_ITEM_MODAL);

	}

	@Override
	public String getItemTypeFromItemModal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, TEXT_ITEM_TYPE_IN_ITEM_MODAL);

	}

	@Override
	public String getItemNumberItemModal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, TEXT_ITEM_NUMBER_ITEM_MODAL);

	}

	@Override
	public void clickOnShowAllBPOForSuggestSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SHOW_ALL_BPO_NEW_SUPPLIER_BUTTON);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on show all bpo button");
	}

	@Override
	public boolean clickOnEditActionItemDetailsModal(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		int rowNumber = 1;

		while (ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@id='reqSelectedSupp']//span[@class='guidedSelectedSuppName']/span)[" + rowNumber + "]")))
		{
			if (ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='reqSelectedSupp']//span[@class='guidedSelectedSuppName']/span)[" + rowNumber + "]")).trim()
				.equalsIgnoreCase(supplierName))
			{
				ActionBot.click(driver, By.xpath("(.//*[@id='reqSelectedSupp']//a[@class='icon edit editSelectedSupplier scLnk'])[" + rowNumber + "]"));
				return true;
			}
			rowNumber++;
		}
		return false;
	}

	@Override
	public boolean clickOnActionForRequesterSuggestedSpecifiedSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		int tableRow = 1;
		By by = By.xpath(".//*[@id='reqSelectedSupp']//tr[" + tableRow + "]//span[@class='guidedSelectedSuppName']/span");
		if (ActionBot.isElementDisplayed(driver, by))
		{
			if (ActionBot.getTextWithInElement(driver, by).equalsIgnoreCase(supplierName))
			{
				ActionBot.click(driver, By.xpath(".//*[@id='reqSelectedSupp']//tr[" + tableRow + "]//td//a[contains(@class,'editSelectedSupplier scLnk')]"));
				ActionBot.defaultSleep();
				if (ActionBot.isElementDisplayed(driver, IPageFreeTextForm.TEXTBOX_SUGGEST_NEW_SUPPLIER_NAME))
					if (ActionBot.getTextWithInElement(driver, IPageFreeTextForm.TEXTBOX_SUGGEST_NEW_SUPPLIER_NAME).trim().equalsIgnoreCase(supplierName))
						return true;
			}
		}
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Actions of Requester Suggested Supplierr");
		return false;
	}
}
