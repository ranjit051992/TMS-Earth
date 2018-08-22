/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.poItemView;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author amitkumar.dash
 *
 */
public class ModalItemPoview
{

	public static boolean checkIsCatalogItemSame(WebDriver driver, int index) throws ActionBotException, FactoryMethodException
	{
		IModalPoItemView iModalPoView = FactoryPage.getInstanceOf(IModalPoItemViewImpl.class);
		return iModalPoView.checkIsCatalogItemSame(driver, index);
	}

	public static void clickOnCatalogItem(WebDriver driver, int index) throws ActionBotException, FactoryMethodException
	{
		IModalPoItemView iModalPoView = FactoryPage.getInstanceOf(IModalPoItemViewImpl.class);
		iModalPoView.clickOnCatalogItem(driver, index);
	}

	public static boolean isAddtoBasket(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalPoItemView iModalPoView = FactoryPage.getInstanceOf(IModalPoItemViewImpl.class);
		return iModalPoView.isAddtoBasket(driver);
	}

	public static boolean isAddtoCart(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalPoItemView iModalPoView = FactoryPage.getInstanceOf(IModalPoItemViewImpl.class);
		return iModalPoView.isAddtoCart(driver);
	}

	public static boolean isMarketPriceValuePresents(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalPoItemView iModalPoView = FactoryPage.getInstanceOf(IModalPoItemViewImpl.class);
		return iModalPoView.isMarketPriceValuePresents(driver);
	}

	public static boolean isAddtoFavorites(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IModalPoItemView iModalPoView = FactoryPage.getInstanceOf(IModalPoItemViewImpl.class);
		return iModalPoView.isAddtoFavorites(driver);
	}

	public static boolean isMaxCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException, FactoryMethodException
	{
		IModalPoItemView iModalPoView = FactoryPage.getInstanceOf(IModalPoItemViewImpl.class);
		return iModalPoView.isMaxCharItemNameDisplayedProperly(driver, index);
	}

	public static boolean isMultiLingualCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException, FactoryMethodException
	{
		IModalPoItemView iModalPoView = FactoryPage.getInstanceOf(IModalPoItemViewImpl.class);
		return iModalPoView.isMultiLingualCharItemNameDisplayedProperly(driver, index);
	}

	public static boolean isScriptingCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException, FactoryMethodException
	{
		IModalPoItemView iModalPoView = FactoryPage.getInstanceOf(IModalPoItemViewImpl.class);
		return iModalPoView.isScriptingCharItemNameDisplayedProperly(driver, index);
	}

	public static boolean isSpecialCharItemNameDisplayedProperly(WebDriver driver, int index) throws ActionBotException, FactoryMethodException
	{
		IModalPoItemView iModalPoView = FactoryPage.getInstanceOf(IModalPoItemViewImpl.class);
		return iModalPoView.isSpecialCharItemNameDisplayedProperly(driver, index);
	}

}
