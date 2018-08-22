/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.mybasket;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 */
/**
 * @author prateek.khandelwal
 *
 */
public class PageMyBasket
{

	static Logger logger = Logger.getLogger(PageMyBasket.class);

	public static String fillBasketSearchTextBox(WebDriver driver, String testCaseName, String basketName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			return pageMyBasket.fillBasketSearchTextBox(driver, testCaseName, basketName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillBasketSearchTextBox " + e, e);
		}
		return null;
	}

	public static String selectBasketSearchBy(WebDriver driver, String testCaseName, String basketName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			return pageMyBasket.selectBasketSearchBy(driver, testCaseName, basketName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectBasketSearchBy " + e, e);
		}
		return null;
	}

	public static void clickOnSearchGoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.clickOnSearchGoButton(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSearchGoButton " + e, e);
		}
	}

	public static void clickOnViewBasketLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.clickOnViewBasketLink(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnViewBasketLink " + e, e);
		}
	}

	public static void clickOnDeleteFromBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.clickOnDeleteFromBasket(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnDeleteFromBasket " + e, e);
		}
	}

	public static void clickOnAddItemsToFavorite(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.clickOnAddItemsToFavorite(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddItemsToFavorite " + e, e);
		}
	}

	public static void clickOnAddToCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.clickOnAddToCart(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddToCart " + e, e);
		}
	}

	public static void clickOnAddToCartLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.clickOnAddToCartLink(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddToCartLink " + e, e);
		}
	}

	public static void waitTillAddToBasketSuccessMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.waitTillAddToBasketSuccessMsg(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitTillAddToBasketSuccessMsg " + e, e);
		}
	}

	public static void clickOnCheckBoxForItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.clickOnCheckBoxForItem(driver, testCaseName, itemId);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCheckBoxForItem " + e, e);
		}
	}

	public static void waitTillItemDeletedSuccessMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.waitTillItemDeletedSuccessMsg(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitTillItemDeletedSuccessMsg " + e, e);
		}
	}

	public static List<WebElement> getListOfItemsInBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			return pageMyBasket.getListOfItemsInBasket(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfItemsInBasket " + e, e);
		}
		return null;
	}

	public static String getSearchedBasketName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			return pageMyBasket.getSearchedBasketName(driver, testCaseName);
		}

		catch (Exception e)
		{
			logger.error("Factory Method Exception in method getSearchedBasketName " + e, e);
		}
		return null;
	}

	public static void clickActionButon(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
		pageMyBasket.clickActionButon(driver, testCaseName);
	}

	public static void clickDeleteBasket(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
		pageMyBasket.clickDeleteBasket(driver, testCaseName);
	}

	public static void clickFirstBasket(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
		pageMyBasket.clickFirstBasket(driver, testCaseName);
	}

	public static void clickToViewCart(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
		pageMyBasket.clickToViewCart(driver, testCaseName);
	}

	public static void clickToContinueShopping(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
		pageMyBasket.clickToContinueShopping(driver, testCaseName);
	}

	public static boolean checkMentionedItemNumberDetailInMyBasket(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
		return pageMyBasket.checkMentionedItemNumberDetailInMyBasket(driver, testCaseName);
	}

	public static boolean checkMentionedItemNameSupplierNameDetailInMyBasket(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
		return pageMyBasket.checkMentionedItemNameSupplierNameDetailInMyBasket(driver, testCaseName);
	}

	public static boolean checkMentionedItemPriceDetailInMyBasket(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
		return pageMyBasket.checkMentionedItemPriceDetailInMyBasket(driver, testCaseName);
	}

	public static boolean checkMentionedItemQtyDetailInMyBasket(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
		return pageMyBasket.checkMentionedItemQtyDetailInMyBasket(driver, testCaseName);
	}

	public static void clickFirstItemCheckBoxInBasket(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
		pageMyBasket.clickFirstItemCheckBoxInBasket(driver, testCaseName);
	}

	public static void clickFirstItemInBasket(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
		pageMyBasket.clickFirstItemInBasket(driver, testCaseName);
	}

	public static void clickToAddBasketToCart(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
		pageMyBasket.clickToAddBasketToCart(driver, testCaseName);
	}

	public static String toFetchQtyOfFirstItemInCurrentBasket(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
		return pageMyBasket.toFetchQtyOfFirstItemInCurrentBasket(driver, testCaseName);
	}

	public static void clickToSortBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.clickToSortBasket(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToSortBasket " + e, e);
		}
	}

	public static void clickToCancelCreationBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.clickToCancelCreationBasket(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToCancelCreationBasket " + e, e);
		}
	}

	public static boolean isBasketcapacityAvailable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			return pageMyBasket.isBasketcapacityAvailable(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isBasketcapacityAvailable " + e, e);
		}
		return false;
	}

	public static String fetchBasketcapacity(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			return pageMyBasket.fetchBasketcapacity(driver, testCaseName, index);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchBasketcapacity " + e, e);
		}
		return null;
	}

	public static boolean isFirstItemInBasketPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			return pageMyBasket.isFirstItemInBasketPresent(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isFirstItemInBasketPresent " + e, e);
		}
		return false;
	}

	public static boolean isDeletBasketButtonPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			return pageMyBasket.isDeletBasketButtonPresent(driver, testCaseName, index);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchBasketcapacity " + e, e);
			return false;
		}
	}

	public static void addItemToCartIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.addItemToCartIndexwise(driver, testCaseName, index);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method addItemToCartIndexwise " + e, e);
		}
	}

	public static void clickBasketActionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.clickBasketActionIndexwise(driver, testCaseName, index);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickBasketActionIndexwise " + e, e);
		}
	}

	/**
	 * <b>Author: prateek.khandelwal </b> <b><br>
	 * <font color="blue">Method :</b>Clicks Share option under Actions dropdown menu assuming it is already clicked..
	 */
	public static void clickBasketShareAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.clickBasketShareAction(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickBasketShareActionIndexwise " + e, e);
		}
	}

	/**
	 * <b>Author: prateek.khandelwal </b> <b><br>
	 * <font color="blue">Method :</b>Select basket sharing scope from drop down menu when share action is clicked for a particular basket.
	 */
	public static void selectBasketSharingScope(WebDriver driver, String testCaseName, String sharingScope) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.selectBasketSharingScope(driver, testCaseName, sharingScope);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickBasketShareScopeChoicewise " + e, e);
		}
	}

	public static int addAllBasketItemsToCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			return pageMyBasket.addAllBasketItemsToCart(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method addAllBasketItemsToCart " + e, e);
		}
		return 0;
	}

	/**
	 * <b>Author: prateek.khandelwal </b> <b><br>
	 * <font color="blue">Method :</b>Searches a company by company code and selects the checkbox of the
	 * resultant company in the sharing scope when share action is performed for a basket.
	 */
	public static void searchAndSelectCompanyInOrganizationUnitsSharingScope(WebDriver driver, String testCaseName, String companyCode) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.searchAndSelectCompanyInOrganizationUnitsSharingScope(driver, testCaseName, companyCode);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCompanyInBasketShareIndexwise " + e, e);
		}
	}

	/**
	 * <b>Author: prateek.khandelwal </b> <b><br>
	 * <font color="blue">Method :</b>Searches a department by department code and selects the checkbox of the
	 * resultant department in the department sharing scope when share action is performed for a basket.
	 */
	public static void searchAndSelectDepartmentInDepartmentSharingScope(WebDriver driver, String testCaseName, String departmentCode) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.searchAndSelectDepartmentInDepartmentSharingScope(driver, testCaseName, departmentCode);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDepartmentInDepartmentScopeInBasketSharing " + e, e);
		}

	}

	/**
	 * <b>Author: prateek.khandelwal </b> <b><br>
	 * <font color="blue">Method :</b>Clicks
	 */
	public static void selectAllBusinessUnits(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.selectAllBusinessUnits(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCompanyInBasketShareIndexwise " + e, e);
		}
	}

	public static void selectAllLocations(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.selectAllLocations(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCompanyInBasketShareIndexwise " + e, e);
		}
	}

	public static void clickBusinessUnitInBasketShareScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.clickBusinessUnitInBasketShareScope(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickBusinessUnitInBasketShareScope " + e, e);
		}
	}

	public static void selectOUUnderBusinessUnitInBasketShareScope(WebDriver driver, String testCaseName, int choice) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.selectOUUnderBusinessUnitInBasketShareScope(driver, testCaseName, choice);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectOUUnderBusinessUnitInBasketShareScope " + e, e);
		}
	}

	public static void clickLocationsInBasketShareScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.clickLocationsInBasketShareScope(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickLocationsInBasketShareScope " + e, e);
		}
	}

	public static void selectOUUnderLocationsInBasketShareScope(WebDriver driver, String testCaseName, int choice) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.selectOUUnderLocationsInBasketShareScope(driver, testCaseName, choice);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectOUUnderLocationsInBasketShareScope " + e, e);
		}
	}

	public static void clickToShareBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.clickToShareBasket(driver, testCaseName);
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickToShareBasket " + e, e);
		}
	}

	public static boolean isShareBasketActionPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.isShareBasketActionPresent(driver, testCaseName, index);
			return true;
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isShareBasketActionPresent " + e, e);
			return false;
		}
	}

	public static boolean isUnShareBasketActionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.isUnShareBasketActionPresent(driver, testCaseName);
			return true;
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isUnShareBasketActionPresent " + e, e);
			return false;
		}
	}

	public static boolean isAddBasketToCartActionPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.isAddBasketToCartActionPresent(driver, testCaseName, index);
			return true;
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAddBasketToCartActionPresent " + e, e);
			return false;
		}
	}

	public static boolean isBasketVisible(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageMyBasket pageMyBasket = FactoryPage.getInstanceOf(IPageMyBasketImpl.class);
			pageMyBasket.isBasketVisible(driver, testCaseName, index);
			return true;
		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isBasketVisible " + e, e);
			return false;
		}
	}

}
