/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.cdwpunchout;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageCDWPunchout
{
	static UI_Elements	TEXTBOX_SEARCH_PUNCHOUT_ITEM				= UIFactory.getElements("TEXTBOX_SEARCH_PUNCHOUT_ITEM");
	static UI_Elements	BUTTON_SEARCH_PUNCHOUT_ITEM_GO				= UIFactory.getElements("BUTTON_SEARCH_PUNCHOUT_ITEM_GO");
	static UI_Elements	PROGRESSING_DIV_ADD_ITEM_TO_CART			= UIFactory.getElements("PROGRESSING_DIV_ADD_ITEM_TO_CART");
	static UI_Elements	TEXTBOX_QUANTITY_OF_ADDED_PUNCHOUT_ITEM		= UIFactory.getElements("TEXTBOX_QUANTITY_OF_ADDED_PUNCHOUT_ITEM");
	static UI_Elements	LABEL_UNIT_PRICE_OF_ADDED_PUNCHOUT_ITEM		= UIFactory.getElements("LABEL_UNIT_PRICE_OF_ADDED_PUNCHOUT_ITEM");
	static UI_Elements	LABEL_TOTAL_PRICE_OF_ADDED_PUNCHOUT_ITEM	= UIFactory.getElements("LABEL_TOTAL_PRICE_OF_ADDED_PUNCHOUT_ITEM");
	static UI_Elements	BUTTON_PUNCHOUT_CHECKOUT					= UIFactory.getElements("BUTTON_PUNCHOUT_CHECKOUT");
	static UI_Elements	BUTTON_TRANSFER_SUBMIT						= UIFactory.getElements("BUTTON_TRANSFER_SUBMIT");
	static UI_Elements	LIST_OF_PUNCHOUT_PRODUCTS					= UIFactory.getElements("LIST_OF_PUNCHOUT_PRODUCTS");
	// to fill item catagory if blank
	static UI_Elements	TEXT_INPUT_CATEGORY							= UIFactory.getElements("TEXT_INPUT_CATEGORY");
	static UI_Elements	LINK_SAVE									= UIFactory.getElements("LINK_SAVE");
	static UI_Elements	CONFIRMATION_ITEM_CLASSIFIED				= UIFactory.getElements("CONFIRMATION_ITEM_CLASSIFIED");
	static UI_Elements	PUNCHOUT_ITEM_NAME							= UIFactory.getElements("PUNCHOUT_ITEM_NAME");

	public String fillSearchPunchoutItem(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public void clickOnSearchButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfSearchedProducts(WebDriver driver, String testCaseName) throws ActionBotException;

	public int fillItemQuantity(WebDriver driver, String testCaseName, int quantity, String itemName) throws ActionBotException;

	public void clickOnAddToCartButton(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public void waitTillProgressiveDivAddItemToCartPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public int getQuantityOfAddedItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getUnitPriceOfAddedItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTotalPriceOfAddedItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCheckoutButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnTransferSubmitButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillItemCategory(WebDriver driver, String testCaseName, String itemCategory) throws ActionBotException;

	public String getAddedItemName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

}
