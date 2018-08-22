/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.mybasket;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.pages.myfavorites.IPageMyFavorites;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 */
public class IPageMyBasketImpl implements IPageMyBasket
{

	static Logger logger = Logger.getLogger(IPageMyBasketImpl.class);

	@Override
	public String fillBasketSearchTextBox(WebDriver driver, String testCaseName, String basketName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_BASKET_SEARCH, basketName);
		String basket_name = ActionBot.findElement(driver, TEXT_BASKET_SEARCH).getAttribute("value");
		logger.info("Entered basket name : " + basket_name);
		ScreenShot.screenshot(driver, testCaseName, "After entering basket name");
		return basket_name;
	}

	@Override
	public String selectBasketSearchBy(WebDriver driver, String testCaseName, String basketName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_BASKET_SEARCH_BY));
		ActionBot.defaultSleep();
		select.selectByVisibleText(basketName);
		String selectedSearchBy = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected search by option : " + selectedSearchBy);
		return selectedSearchBy;
	}

	@Override
	public void clickOnSearchGoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_BASKET_SEARCH_GO);
		ActionBot.waitTillPopUpIsPresent(driver, BASKET_LIST_PROCESSING);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After searching basket");
	}

	@Override
	public void clickOnViewBasketLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, VIEW_BASKET);
		ActionBot.waitForPageLoad(driver);
		ActionBot.findElement(driver, BUTTON_DELETE_FROM_BASKET);
		ScreenShot.screenshot(driver, testCaseName, "After viewing basket");
	}

	@Override
	public void clickOnDeleteFromBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_DELETE_FROM_BASKET);
		ActionBot.waitForElementToBePresent(driver, By.xpath(".//button[contains(@class,'pri')]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(".//button[contains(@class,'pri')]"), 5);
		ActionBot.click(driver, By.xpath(".//button[contains(@class,'pri')]"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on delete from basket");
	}

	@Override
	public void clickOnAddItemsToFavorite(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_ITEMS_TO_FAVORITE);
		ActionBot.waitTillPopUpIsPresent(driver, SUCCESS_MSG_ADD_ITEMS_TO_FAVORITE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add item to favorite");
	}

	@Override
	public void clickOnAddToCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_TO_CART);
		ActionBot.waitTillPopUpIsPresent(driver, SUCCESS_MSG_ADD_ITEMS_TO_CART);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add item to cart");
	}

	@Override
	public void clickOnAddToCartLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ADD_TO_CART_LINK);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add item to cart");
	}

	@Override
	public void waitTillAddToBasketSuccessMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, ADD_TO_BASKET_SUCCESS_MSG);
	}

	@Override
	public void clickOnCheckBoxForItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.click(driver, By.id("chkItem_" + itemId));
	}

	@Override
	public void waitTillItemDeletedSuccessMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, SUCCESS_MSG_DELETE_ITEMS_FROM_BASKET);
		ActionBot.defaultSleep();
	}

	@Override
	public List<WebElement> getListOfItemsInBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, ITEMS_IN_BASKET);
	}

	@Override
	public String getSearchedBasketName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String searchedBasketName = ActionBot.getTextWithInElement(driver, VIEW_BASKET);
		logger.info("Searched Basket Name : " + searchedBasketName);
		return searchedBasketName;
	}

	@Override
	public void clickActionButon(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ACTION_MY_BASKET);

	}

	//	@Override
	//	public void clickDeleteBasket(WebDriver driver, String testCaseName, int index) throws ActionBotException
	//	{
	//		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[@name='basket_delete_'])[" + index + "]"));
	//		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[@name='basket_delete_'])[" + index + "]"), 60);
	//		ActionBot.click(driver, By.xpath("(.//*[@name='basket_delete_'])[" + index + "]"));
	//		ActionBot.defaultMediumSleep();
	//		ActionBot.waitForElementToBePresent(driver, 60, IPageMyFavorites.YES_CONFIRMATION);
	//		ActionBot.waitForElementToBeDisplayed(driver, IPageMyFavorites.YES_CONFIRMATION, 60);
	//		ActionBot.click(driver, IPageMyFavorites.YES_CONFIRMATION);
	//	}
	@Override
	public void clickDeleteBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, DELETE_BASKET, 60);
		ActionBot.click(driver, DELETE_BASKET);
		ActionBot.defaultMediumSleep();
		ActionBot.waitForElementToBePresent(driver, 60, IPageMyFavorites.YES_CONFIRMATION);
		ActionBot.waitForElementToBeDisplayed(driver, IPageMyFavorites.YES_CONFIRMATION, 60);
		ActionBot.click(driver, IPageMyFavorites.YES_CONFIRMATION);
	}

	@Override
	public void clickFirstBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FIRST_BASKET_IN_LIST);
	}

	@Override
	public void clickToViewCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, VIEW_CART);
	}

	@Override
	public void clickToContinueShopping(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLICK_TO_CONTINUE_SHOPPING);
	}

	@Override
	public boolean checkMentionedItemNumberDetailInMyBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LABLE_ITEM_NO))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean checkMentionedItemNameSupplierNameDetailInMyBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LABLE_ITEM_NO_SUPPLIER_NAME))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean checkMentionedItemPriceDetailInMyBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LABLE_ITEM_PRICE))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean checkMentionedItemQtyDetailInMyBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LABLE_ITEM_QTY))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickFirstItemCheckBoxInBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FIRST_ITEM_CHECK_BOX_IN_BASKET);

	}

	@Override
	public void clickFirstItemInBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FIRST_ITEM_IN_BASKET);

	}

	@Override
	public void clickToAddBasketToCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ADD_BASKET_TO_CART);

	}

	@Override
	public String toFetchQtyOfFirstItemInCurrentBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, FIRST_ITEM_QTY);
	}

	public void clickToSortBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeVisible(driver, 5, SORT_BASKET_PRICE);
		if (ActionBot.isElementPresent(driver, SORT_BASKET_PRICE))
		{
			ActionBot.click(driver, SORT_BASKET_PRICE);
		}
		else
		{
			throw new ActionBotException();
		}
	}

	public boolean isBasketcapacityAvailable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeVisible(driver, 5, BASKET_ITEM_CAPACITY);
		return ActionBot.isElementDisplayed(driver, BASKET_ITEM_CAPACITY);
	}

	public String fetchBasketcapacity(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='basList']//td[contains(@class,'iNum')])[" + index + "]"));
	}

	public boolean isFirstItemInBasketPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeVisible(driver, 5, BASKET_ITEM_CAPACITY);
		return ActionBot.isElementPresent(driver, FIRST_ITEM_IN_BASKET);
	}

	@Override
	public boolean isDeletBasketButtonPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[@name='basket_delete_'])[" + index + "]"));
		ActionBot.waitForOperations(5000);
		return ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@name='basket_delete_'])[" + index + "]"));
	}

	@Override
	public void addItemToCartIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'add_to_cart')])[" + index + "]"));
	}

	@Override
	public int addAllBasketItemsToCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int index = 1;
		do
		{
			ActionBot.click(driver, By.xpath("(.//*[contains(@id,'add_to_cart')])[" + index + "]"));
			index++;
			ActionBot.defaultLowSleep();
		} while (ActionBot.isElementDisplayed(driver, By.xpath("(.//*[contains(@id,'add_to_cart')])[" + index + "]")));
		return index - 1;
	}

	@Override
	public void clickToCancelCreationBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		if (ActionBot.isElementDisplayed(driver, BUTTON_CANCEL_ADD_TO_BASKET))
			ActionBot.click(driver, BUTTON_CANCEL_ADD_TO_BASKET);
	}

	@Override
	public void clickBasketActionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[@id='basList']//a[@class='scLnk icon actLnk'])[" + index + "]"));
	}

	/**
	 * <b>Author: prateek.khandelwal </b> <b><br>
	 * <font color="blue">Method :</b>Clicks Share option under Actions dropdown menu assuming it is already clicked..
	 */
	@Override
	public void clickBasketShareAction(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ACTION_SHARE_BASKET);
	}

	//	@Override
	//	public void clickBasketShareScopeChoicewise(WebDriver driver, String testCaseName, int choice)
	//		throws ActionBotException
	//	{
	//		ActionBot.click(driver, SELECT_BASKET_SHARING_SCOPE);
	//		ActionBot.defaultLowSleep();
	//		WebElement element = ActionBot.findElement(driver, SELECT_BASKET_SHARING_SCOPE);
	//		while (choice-- > 0)
	//		{
	//			element.sendKeys(Keys.ARROW_DOWN);
	//		}
	//		element.sendKeys(Keys.ENTER);
	//		ActionBot.defaultLowSleep();
	//	}

	/**
	 * <b>Author: prateek.khandelwal </b> <b><br>
	 * <font color="blue">Method :</b>Select basket sharing scope from drop down menu when share action is clicked for a particular basket.
	 */
	@Override
	public void selectBasketSharingScope(WebDriver driver, String testCaseName, String sharingScope) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_BASKET_SHARING_SCOPE));
		select.selectByVisibleText(sharingScope);
	}

	@Override
	public void searchAndSelectCompanyInOrganizationUnitsSharingScope(WebDriver driver, String testCaseName, String companyCode) throws ActionBotException
	{
		try
		{
			ActionBot.sendKeys(driver, COMPANY_SEARCH_BOX, companyCode);
			ActionBot.click(driver, SEARCH_GO);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, CHECKBOX_BASKET_SHARING);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * <b>Author: prateek.khandelwal </b> <b><br>
	 * <font color="blue">Method :</b>Searches a department by department code and selects the checkbox of the
	 * resultant department in the department sharing scope when share action is performed for a basket.
	 */
	@Override
	public void searchAndSelectDepartmentInDepartmentSharingScope(WebDriver driver, String testCaseName, String departmentCode) throws ActionBotException
	{
		ActionBot.sendKeys(driver, DEPARTMENT_SEARCH_BOX, departmentCode);
		ActionBot.defaultLowSleep();
		//	ActionBot.click(driver, SEARCH_GO);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element2 = (WebElement) js.executeScript("return document.getElementById('frmShareBasket').getElementsByClassName('b-button b-primary b-small btn')[0]");
		element2.click();
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, CHECKBOX_BASKET_SHARING);
	}

	@Override
	public void selectAllBusinessUnits(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SELECT_ALL_BUSINESS_UNITS);
	}

	@Override
	public void selectAllLocations(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SELECT_ALL_LOCATIONS);
	}

	@Override
	public void clickBusinessUnitInBasketShareScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[contains(@id,'Tab')][text()='Business Units']"));
	}

	@Override
	public void selectOUUnderBusinessUnitInBasketShareScope(WebDriver driver, String testCaseName, int chioce) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'row_')]//a)[" + chioce + "]"));
		ActionBot.click(driver, By.xpath("(.//*[@id='orgUnitListTable']//input[contains(@class,'chkboxCode')])[" + chioce + "]"));
		ActionBot.click(driver, SAVE_SELECTED_Ous);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickLocationsInBasketShareScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[contains(@id,'Tab')][text()='Locations']"));
	}

	@Override
	public void selectOUUnderLocationsInBasketShareScope(WebDriver driver, String testCaseName, int chioce) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'row_')]//a[text()='Select Organization Unit'])[" + chioce + "]"));
		ActionBot.click(driver, By.xpath("(.//*[@id='orgUnitListTable']//input[contains(@class,'chkboxCode')])[" + chioce + "]"));
		ActionBot.click(driver, SAVE_SELECTED_Ous);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickToShareBasket(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SHARE_BASKET_BUTTON);
	}

	@Override
	public boolean isShareBasketActionPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@id='basList']//a[text()='Share'])[" + index + "]"));
	}

	@Override
	public boolean isUnShareBasketActionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ACTION_UNSHARE_BASKET);
	}

	@Override
	public boolean isAddBasketToCartActionPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@id='basList']//a[text()='Add Basket to Cart'])[" + index + "]"));
	}

	@Override
	public boolean isBasketVisible(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@id='basList']//*[@class='viewBasket'])[" + index + "]"));
	}
}
