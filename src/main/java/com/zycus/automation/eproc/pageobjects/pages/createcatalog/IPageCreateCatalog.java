/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createcatalog;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 * 
 */
public interface IPageCreateCatalog
{
	static UI_Elements			TEXTBOX_CATALOG_NAME					= UIFactory.getElements("TEXTBOX_CATALOG_NAME");
	static UI_Elements			TEXTBOX_SUPPLIER_NAME_CATALOG_CREATION	= UIFactory.getElements("TEXTBOX_SUPPLIER_NAME_CATALOG_CREATION");
	static UI_Elements			TEXTBOX_SELECT_SUPPLIER_ADDRESS			= UIFactory.getElements("TEXTBOX_SELECT_SUPPLIER_ADDRESS");
	static UI_Elements			BUTTON_NEXT_CREATE_CATALOG				= UIFactory.getElements("BUTTON_NEXT_CREATE_CATALOG");
	static UI_Elements			BUTTON_ADD_ITEM_TO_CATALOG				= UIFactory.getElements("BUTTON_ADD_ITEM_TO_CATALOG");
	static UI_Elements			TEXTBOX_SUPPLIER_PART_ID				= UIFactory.getElements("TEXTBOX_SUPPLIER_PART_ID");
	static UI_Elements			TEXTBOX_SHORT_DESCRIPTION				= UIFactory.getElements("TEXTBOX_SHORT_DESCRIPTION");
	static UI_Elements			TEXTBOX_PRODUCT_CATEGORY				= UIFactory.getElements("TEXTBOX_PRODUCT_CATEGORY");
	static UI_Elements			TEXTBOX_PRICE							= UIFactory.getElements("TEXTBOX_PRICE");
	static UI_Elements			BUTTON_ADD_AND_CONTINUE					= UIFactory.getElements("BUTTON_ADD_AND_CONTINUE");
	static UI_Elements			BUTTON_CLOSE_ADD_ITEM					= UIFactory.getElements("BUTTON_CLOSE_ADD_ITEM");
	static UI_Elements			BUTTON_NEXT_LNK_SCOPE_VALIDITY			= UIFactory.getElements("BUTTON_NEXT_LNK_SCOPE_VALIDITY");
	static UI_Elements			LINK_SELECT_ORGANIZATION_UNIT			= UIFactory.getElements("LINK_SELECT_ORGANIZATION_UNIT");
	static UI_Elements			CHECK_BOX_SELECT_OU						= UIFactory.getElements("CHECK_BOX_SELECT_OU");
	static UI_Elements			BUTTON_SAVE_OU							= UIFactory.getElements("BUTTON_SAVE_OU");
	static UI_Elements			BUTTON_CANCEL_OU						= UIFactory.getElements("BUTTON_CANCEL_OU");
	static UI_Elements			BUTTON_SUBMIT_CATALOG					= UIFactory.getElements("BUTTON_SUBMIT_CATALOG");
	static UI_Elements			SUPPLIER_ADDRESS_SUGGESTION_LIST		= UIFactory.getElements("SUPPLIER_ADDRESS_SUGGESTION_LIST");
	static UI_Elements			BUTTON_DISCARD_CATALOG					= UIFactory.getElements("BUTTON_DISCARD_CATALOG");
	static UI_Elements			BUTTON_CLOSE_CATALOG					= UIFactory.getElements("BUTTON_CLOSE_CATALOG");
	static UI_Elements			LINK_EDIT_FIRST_CATALOG_ITEM			= UIFactory.getElements("LINK_EDIT_FIRST_CATALOG_ITEM");
	static UI_Elements			BUTTON_UPLOAD_ITEMS_VIA_FILE			= UIFactory.getElements("BUTTON_UPLOAD_ITEMS_VIA_FILE");
	static UI_Elements			CSV_SAMPLE_TEMPLATE_FILE				= UIFactory.getElements("CSV_SAMPLE_TEMPLATE_FILE");
	static UI_Elements			PROCESSING_DIV_PUBLISH_CATALOG			= UIFactory.getElements("PROCESSING_DIV_PUBLISH_CATALOG");
	static UI_Elements			LINK_SCOPE_SELECTED_CATALOG_CREATION	= UIFactory.getElements("LINK_SCOPE_SELECTED_CATALOG_CREATION");
	UI_Elements					DATE_PICKER_FROM_SCOPE_VALIDITY_DATE	= UIFactory.getElements("DATE_PICKER_FROM_SCOPE_VALIDITY_DATE");
	UI_Elements					DATE_PICKER_TO_SCOPE_VALIDITY_DATE		= UIFactory.getElements("DATE_PICKER_TO_SCOPE_VALIDITY_DATE");

	UI_Elements					TEXTBOX_FROM_SCOPE_VALIDITY_DATE		= UIFactory.getElements("TEXTBOX_FROM_SCOPE_VALIDITY_DATE");

	UI_Elements					TEXTBOX_TO_SCOPE_VALIDITY_DATE			= UIFactory.getElements("TEXTBOX_TO_SCOPE_VALIDITY_DATE");
	static UI_Elements			TEXTBOX_CONTRACT_NUMBER					= UIFactory.getElements("TEXTBOX_CONTRACT_NUMBER");
	static UI_Elements			SCOPE_MANDATORY_TAG						= UIFactory.getElements("SCOPE_MANDATORY_TAG");
	static UI_Elements			LABEL_NO_RECORDS_FOUND					= UIFactory.getElements("LABEL_NO_RECORDS_FOUND");
	final static UI_Elements	DUPLICATE_CATALOG_NAME_ERROR			= UIFactory.getElements("DUPLICATE_CATALOG_NAME_ERROR");

	public String fillCatalogName(WebDriver driver, String testCaseName, String catalogName) throws ActionBotException;

	public String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public String selectFirstSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnNextButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddItemButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnNextLinkScopeValidityButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectOrganizationUnitLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSubmitCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDiscardCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditFirstCatalogItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfItemsInCatalog(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getItemCatagory(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public String getItemSupplier(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public String getItemCurrency(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public double getItemUnitPrice(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public String getItemSupplierPartId(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public void clickOnUploadItemsViaFileButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectCatalogScopeLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSelectCatalogScopeLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectFromValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String selectToValidityDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String fillContractNumber(WebDriver driver, String testCaseName, String contractNumber) throws ActionBotException;

	public boolean isScopeEditable(WebDriver webDriver, String testCaseName) throws ActionBotException;

	public boolean isFromValidityDateEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isToValidityDateEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isScopePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isScopeMandatory(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isFromValidityPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isToValidityPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCatalogPresentAfterSearch(WebDriver driver, String testCaseName) throws ActionBotException;
}
