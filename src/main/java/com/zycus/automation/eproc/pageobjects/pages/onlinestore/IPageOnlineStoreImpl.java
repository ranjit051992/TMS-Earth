package com.zycus.automation.eproc.pageobjects.pages.onlinestore;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.zycus.automation.bo.User;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.pages.cdwpunchout.IPageCDWPunchout;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.IPageSearchListing;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.LoginLogoutException;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;

public class IPageOnlineStoreImpl implements IPageOnlineStore
{

	static Logger logger = Logger.getLogger(IPageOnlineStoreImpl.class);

	@Override
	public String fillSearchText(WebDriver driver, String testCaseName, String searchText) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "before typing for search text");
		ActionBot.clear(driver, TEXTBOX_ENTER_SEARCH_NAME);
		searchText = ActionBot.sendKeys(driver, TEXTBOX_ENTER_SEARCH_NAME, searchText);
		ScreenShot.screenshot(driver, testCaseName, "after typing for search text ");
		// searchText = ActionBot.getTextWithInElement(driver,
		// TEXTBOX_ENTER_SEARCH_NAME).trim();
		return searchText;
	}

	@Override
	public void clickSearchButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SEARCH_BUTTON);
		ActionBot.defaultLowSleep();
		// ActionBot.defaultMediumSleep();
		ActionBot.waitTillPopUpIsPresent(driver, LOADER_SEARCH_ITEM_LIST);
		ScreenShot.screenshot(driver, testCaseName, "after clicking search button ");
	}

	@Override
	public void clickOnViewCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// ScreenShot.screenshot(driver, testCaseName,
		// "before clicking item label");
		ActionBot.click(driver, LABEL_ITEM_IN_CART);
		ActionBot.waitTillPopUpIsPresent(driver, LOADER_ITEMS_IN_CART);
		// ActionBot.defaultHighSleep();		
		ScreenShot.screenshot(driver, testCaseName, "after clicking item label");
	}

	@Override
	public void clickOnCheckOut(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CHECKOUT_BUTTON);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "after clicking on checkout");
	}

	@Override
	public String getCheckOutPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "checkout price");
		String cartPrice = ActionBot.getTextWithInElement(driver, LABEL_CART_TOTAL_AMOUNT).trim();
		return cartPrice;
	}

	@Override
	public void clickOnLogOutButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "before logout");
		ActionBot.click(driver, BUTTON_LOGOUT);
		ScreenShot.screenshot(driver, testCaseName, "after logout");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zycus.automation.eproc.pageobjects.pages.onlinestore.IPageOnlineStore
	 * #getTotalItemsInCart(org.openqa.selenium.WebDriver, java.lang.String)
	 */
	@Override
	public String getTotalItemsInCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "total items in cart");
		String itemInCart = ActionBot.getTextWithInElement(driver, LABEL_ITEM_IN_CART_VALUE).trim();
		logger.info("Total items in cart : " + itemInCart);
		return itemInCart;
	}

	@Override
	public void hoverOverFirstCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, LINK_FIRST_CATEGORY);
		/*
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(ActionBot.findElement(driver,
		 * LINK_FIRST_CATEGORY)).moveToElement(ActionBot.findElement(driver,
		 * LINK_FIRST_SUB_CATEGORY)).build().perform();
		 * ActionBot.defaultSleep();
		 */
		// ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testCaseName, "After selecting first category");
	}

	@Override
	public String getTextOfFirstCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String firstCategory = ActionBot.getTextWithInElement(driver, LINK_FIRST_CATEGORY);
		logger.info("First Category : " + firstCategory);
		return firstCategory;
	}

	@Override
	public String getTextOfFistSubCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(ActionBot.findElement(driver, LINK_FIRST_CATEGORY)).moveToElement(ActionBot.findElement(driver, LINK_FIRST_SUB_CATEGORY)).build().perform();
		String firstSubCategory = ActionBot.getTextWithInElement(driver, LINK_FIRST_SUB_CATEGORY);
		logger.info("First Sub Category : " + firstSubCategory);
		return firstSubCategory;
	}

	@Override
	public void clickOnFirstSubCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(ActionBot.findElement(driver, LINK_FIRST_CATEGORY)).moveToElement(ActionBot.findElement(driver, LINK_FIRST_SUB_CATEGORY)).click().build().perform();
		ActionBot.defaultMediumSleep();
		ActionBot.waitTillPopUpIsPresent(driver, LOADER_SEARCH_ITEM_LIST);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on first sub category");
	}

	@Override
	public void clickOnCDWPunchoutLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CDW_PUNCHOUT);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking punchout link");
		ActionBot.findElement(driver, IPageCDWPunchout.TEXTBOX_SEARCH_PUNCHOUT_ITEM);
	}

	@Override
	public void clickOnConfigurationLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, LINK_NEW_MAIN_NAVIGATION);
		ActionBot.click(driver, LINK_CONFIGURATION_IN_NEW_MAIN_NAV);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Configuration Link");
	}

	@Override
	public void clickOnGotItButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_GOT_IT))
		{
			ActionBot.click(driver, BUTTON_GOT_IT);
			logger.info("Clicked on Button Got_IT");
		}
	}

	@Override
	public String fetchTotalItemsInCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, TOTAL_ITEMS_IN_CART);
	}

	@Override
	public void clickOnEmptyCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, EMPTY_THE_CART))
		{
			ActionBot.click(driver, EMPTY_THE_CART);
		}
	}

	@Override
	public void clickOnNoCartContinueShopping(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, IPageOnlineStore.NO_CART_CONTINUE_BUTTON, 60);
		ActionBot.click(driver, NO_CART_CONTINUE_BUTTON);
	}

	@Override
	public void clickOnContinueShopping(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CART_CONTINUE_BUTTON))
		{
			ActionBot.click(driver, CART_CONTINUE_BUTTON);
		}
	}

	@Override
	public void clickOnGuidedProcurementLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, GUIDED_PROCUREMENT))
		{
			ActionBot.click(driver, GUIDED_PROCUREMENT);
		}
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void updateItemQtyInCart(WebDriver driver, String testCaseName, int index, int qty) throws ActionBotException
	{
		ActionBot.sendKeys(driver, By.xpath("(.//*[contains(@id,'cart_item_quantity')])[" + index + "]"), ("" + qty));
	}

	@Override
	public void clickUpdateItemQtyInCart(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'cart_item_update')])[" + index + "]"));
	}

	@Override
	public void clickOnYesdeleteCartContinueShopping(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, IPageOnlineStore.Yes_DELETE, 30);
		ActionBot.click(driver, Yes_DELETE);
		ActionBot.defaultSleep();
	}

	@Override
	public String getSelectedCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Displayed Category");
		String category = ActionBot.findElement(driver, TEXT_DISPLAYED_CATEGORY).getText();
		String[] categoryDisplayed = category.split("\\'");
		String category_final = categoryDisplayed[1];
		return category_final;
	}

	@Override
	public boolean isGuidedProcurementLinkVisible(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, IPageSearchListing.NO_CATLOGUE_FOUND);
	}

	@Override
	public void clickItemInCartindexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'grid_item')]//a[contains(@class,'showItemDetails ')])[" + index + "]"));
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickRequirementDetailsTabInItemDetailsPopupInViewCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[contains(@id,'ui-id')][contains(text(),'Requirement Details')]"));
		ActionBot.defaultLowSleep();
	}

	@Override
	public boolean verifyEformFieldInItemDetailsPopupInViewCart(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath(".//*[contains(@id,'df')]//label[contains(text(),'" + fieldName + "')]"));
	}

	@Override
	public void clickOnOkButtonForBandwidthCheck(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_OK_BANDWIDTH_CHECK))
		{
			ScreenShot.screenshot(driver, testCaseName, "Popup for bandwidth");
			ActionBot.click(driver, BUTTON_OK_BANDWIDTH_CHECK);
			logger.info("Clicked on button Ok for bandwidth check");
		}

	}

	@Override
	public void clickOnCancelCNSNotification(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_CANCEL_CNS_NOTIFICATION))
		{
			ScreenShot.screenshot(driver, testCaseName, "CNS Notification");
			ActionBot.click(driver, BUTTON_CANCEL_CNS_NOTIFICATION);
			logger.info("Clicked on Cancel for CNS Notification");
		}

	}

	@Override
	public void switchToClassicView(WebDriver driver, TestCase testCase, User user) throws ActionBotException
	{

		if (ActionBot.isElementDisplayed(driver, LOGO_ZYCUS_RAINBOW))
		{
			logger.info("\n RainBow setting is enabled on Page");

			ActionBot.click(driver, LOGO_ZYCUS_RAINBOW);
			ActionBot.waitForPageLoad(driver);

			// to verify if link switch to classic view displayed
			if (ActionBot.isElementDisplayed(driver, LINK_SWITCH_TO_CLASSIC_VIEW))
			{
				ActionBot.click(driver, LINK_SWITCH_TO_CLASSIC_VIEW);
				logger.info("After clicking on link Switch to Classic View");

				ActionBot.click(driver, BUTTON_CONTINUE_TO_CLASSIC_VIEW);
				ActionBot.click(driver, BUTTON_LOGOUT_FROM_RAINBOW);
				ActionBot.waitForPageLoad(driver);
				ScreenShot.screenshot(driver, testCase.getTestMethodName(), "After logging out from rainbow view");
			}
			// try to relogin
			try
			{
				LoginLogoutServices.login(driver, testCase, user, IConstants.eProc);
			}
			catch (LoginLogoutException e)
			{

				logger.error("Login Logout Exception in method switchToClassicView " + e, e);
			}
		}

	}

	@Override
	public boolean isRelatedCategoryDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, LINK_RELATED_CATEGORIES);
		List<WebElement> ele = ActionBot.findElements(driver, LIST_RELATED_CATEGORIES);

		if (ele.size() > 0)
		{
			ScreenShot.screenshot(driver, testCaseName, "Related categories displayed");
			return true;

		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, "Related categories not displayed");
			return false;
		}
	}

	@Override
	public boolean clickOnGuidedProcurementViewAllButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_GUIDED_PROCUREMENT_VIEW_ALL))
		{
			ActionBot.click(driver, BUTTON_GUIDED_PROCUREMENT_VIEW_ALL);
			logger.info("Clicked on Guided Procurement View All Button");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, "Guided Procurement View All Button Not Visible");
			return false;
		}
	}

	@Override
	public boolean clickOnFirstEformUnderGuidedProcurementPopupViaViewAllButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, ALL_EFORMS_POPUP);

		//check if any eForm is present or not.
		if (ActionBot.findElements(driver, LINK_ALL_EFORMS).size() > 0)
		{
			//click on 1st eForm
			ActionBot.click(driver, By.xpath("(.//*[@id='selectEform']//ol[contains(@class,'allEforms')]//a)[1]"));
			logger.info("Clicked on 1st eform Under Guided Procurement");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, "No eForms found under Guided Procurement");
			return false;
		}
	}
}
