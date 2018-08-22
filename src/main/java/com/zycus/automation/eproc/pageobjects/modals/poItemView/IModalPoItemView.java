/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.poItemView;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author amitkumar.dash
 *
 */
public interface IModalPoItemView
{

	final static UI_Elements	ITEM_DETAILS				= UIFactory.getElements("ITEM_DETAILS");
	final static UI_Elements	ADDTOCART					= UIFactory.getElements("ADDTOCART");
	final static UI_Elements	ADDTOBASKET					= UIFactory.getElements("ADDTOBASKET");
	final static UI_Elements	ADDTOFAVORITES				= UIFactory.getElements("ADDTOFAVORITES");
	final static UI_Elements	ITEM_DETAILS_MARKET_PRICE	= UIFactory.getElements("ITEM_DETAILS_MARKET_PRICE");

	public boolean checkIsCatalogItemSame(WebDriver driver, int index) throws ActionBotException;

	public void clickOnCatalogItem(WebDriver driver, int index) throws ActionBotException;

	public boolean isAddtoBasket(WebDriver driver) throws ActionBotException;

	public boolean isMarketPriceValuePresents(WebDriver driver) throws ActionBotException;

	public boolean isAddtoCart(WebDriver driver) throws ActionBotException;

	public boolean isAddtoFavorites(WebDriver driver) throws ActionBotException;

	public boolean isMaxCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException;

	public boolean isMultiLingualCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException;

	public boolean isScriptingCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException;

	public boolean isSpecialCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException;

}
