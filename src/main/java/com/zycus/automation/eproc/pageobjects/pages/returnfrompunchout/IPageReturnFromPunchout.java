/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.returnfrompunchout;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageReturnFromPunchout
{
	static UI_Elements	LINK_ADDED_PUNCHOUT_ITEM_NAME			= UIFactory.getElements("LINK_ADDED_PUNCHOUT_ITEM_NAME");
	static UI_Elements	LABEL_ADDED_PUNCHOUT_ITEM_CATEGORY		= UIFactory.getElements("LABEL_ADDED_PUNCHOUT_ITEM_CATEGORY");
	static UI_Elements	LABEL_ADDED_PUNCHOUT_ITEM_UNIT_PRICE	= UIFactory.getElements("LABEL_ADDED_PUNCHOUT_ITEM_UNIT_PRICE");
	static UI_Elements	LABEL_ADDED_PUNCHOUT_ITEM_QUANTITY		= UIFactory.getElements("LABEL_ADDED_PUNCHOUT_ITEM_QUANTITY");
	static UI_Elements	LABEL_ADDED_PUNCHOUT_ITEM_TOTAL_PRICE	= UIFactory.getElements("LABEL_ADDED_PUNCHOUT_ITEM_TOTAL_PRICE");
	static UI_Elements	BUTTON_ADD_TO_CARTD_AND_CHECKOUT		= UIFactory.getElements("BUTTON_ADD_TO_CARTD_AND_CHECKOUT");
	static UI_Elements	LINK_ADD_TO_CARTD_AND_CONTINUE_SHOPPING	= UIFactory.getElements("LINK_ADD_TO_CARTD_AND_CONTINUE_SHOPPING");
	static UI_Elements	LINK_DISCARD_ALL_ITEMS					= UIFactory.getElements("LINK_DISCARD_ALL_ITEMS");
	static UI_Elements	LINK_IGNORE_AND_SUBMIT					= UIFactory.getElements("LINK_IGNORE_AND_SUBMIT");

	public String getAddedPunchoutItemName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAddedPunchoutItemCategory(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAddedPunchoutItemUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public int getAddedPunchoutItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAddedPunchoutItemTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddToCardAndCheckoutButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddToCardAndContinueShoppingButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDiscardAllItems(WebDriver driver, String testCaseName) throws ActionBotException;
}
