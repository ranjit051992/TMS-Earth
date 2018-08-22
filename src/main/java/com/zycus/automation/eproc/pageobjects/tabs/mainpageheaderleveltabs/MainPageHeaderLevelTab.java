package com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.approval.IPageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.IPageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.invoicelisting.IPageInvoiceListing;
import com.zycus.automation.eproc.pageobjects.pages.mybasket.IPageMyBasket;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.IPageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.IPageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.peformlisting.IPagePEformListing;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class MainPageHeaderLevelTab implements IMainPageHeaderLevelTabByValues
{
	static Logger logger = Logger.getLogger(MainPageHeaderLevelTab.class);

	public static void clickOnAllRequisitionsSubTab(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, REQUISITION_RAINBOW);
			ActionBot.click(driver, ALL_REQUISITION_RAINBOW);
		}
		else
		{
			clickOnRequisitionTab(driver);
			WebElement element = ActionBot.findElement(driver, ALL_REQUISITION);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			//			ActionBot.click(driver, ALL_REQUISITION);
		}
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, "", "After navigating to All Requisition Page");
	}

	public static void clickOnApprovalAllRequestsTab(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, APPROVAL_RAINBOW);
			ActionBot.waitForElementToBeDisplayed(driver, ALL_REQUESTS_RAINBOW, 60);
			ActionBot.click(driver, ALL_REQUESTS_RAINBOW);
		}
		else
		{
			clickOnApprovalTab(driver);
			ActionBot.waitForElementToBeDisplayed(driver, ALL_REQUESTS, 60);
			ActionBot.click(driver, ALL_REQUESTS);
		}
		ActionBot.waitForPageLoad(driver);
		ActionBot.waitTillPopUpIsPresent(driver, IPageAllRequestsApproval.APPROVAL_PROCESSING);
		ScreenShot.screenshot(driver, "", "After clicking on Approval All Request Tab");
	}

	public static void clickOnApprovalTab(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.moveToElement(driver, APPROVAL_RAINBOW);
			ActionBot.click(driver, APPROVAL_SUB_RAINBOW);
		}
		else
		{
			ActionBot.moveToElement(driver, APPROVAL);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, APPROVAL_SUB);
		}
		ActionBot.waitForPageLoad(driver);
	}

	public static void clickOnBuyersDeskSubTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, BUYER_DESK_RAINBOW);
			ActionBot.click(driver, BUYERS_DESK_SUB_RAINBOW);
		}
		else
		{
			clickOnBuyersDeskTopTab(driver);
			ActionBot.click(driver, BUYERS_DESK_SUB);
		}
		ActionBot.waitForPageLoad(driver);
		ActionBot.waitTillPopUpIsPresent(driver, IPageBuyersDeskListing.BUYERS_DESK_LISTING_PROCESSING_DIV);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Buyers desk tab");
	}

	public static void clickOnBuyersDeskTopTab(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			ActionBot.click(driver, BUYER_DESK_RAINBOW);
		}
		else
		{
			ActionBot.click(driver, BUYERS_DESK_TOP);
		}
		ActionBot.defaultSleep();
	}

	public static void clickOnCatalogSubTab(WebDriver driver, String testCaseName) throws ActionBotException
	{

		clickOnCatalogTopTab(driver, testCaseName);
		ActionBot.click(driver, CATALOG_SUB_TAB);
		ActionBot.waitForPageLoad(driver);
	}

	public static void clickOnCatalogTopTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CATALOG_TOP_TAB);
		ActionBot.waitForPageLoad(driver);
	}

	public static void clickOnCustomize(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, CUSTOMIZE_RAINBOW);
		}
		else
			ActionBot.click(driver, CUSTOMIZE);
	}

	public static void clickOnCustomizeSubTab(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, SETUP_RAINBOW);
			ActionBot.click(driver, CUSTOMIZE_RAINBOW);
		}
		else
		{
			clickOnSetUpTab(driver);
			ActionBot.click(driver, CUSTOMIZE);
		}
		ActionBot.waitForPageLoad(driver);
	}

	public static void clickOnEInvoiceMailBoxTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		clickOnInvoiceTopTab(driver, testCaseName);
		ActionBot.click(driver, E_INVOICE_MAILBOX);
		// ActionBot.defaultSleep();
	}

	public static void clickOnInvoiceSubTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		clickOnInvoiceTopTab(driver, testCaseName);
		ActionBot.click(driver, INVOICE_SUB);
		ActionBot.waitTillPopUpIsPresent(driver, IPageInvoiceListing.INVOICE_LISTING_PROCESSING);
		// ActionBot.defaultSleep();
	}

	public static void clickOnInvoiceTopTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, INVOICE_TOP);
	}

	public static void clickOnMyFavoritesSubTab(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, MY_FAVORITES_RAINBOW);
		}
		else
		{
			clickOnOnlineStoreSubTab(driver);
			ActionBot.focusAndclick(driver, MY_FAVORITES);
		}
		ActionBot.waitForPageLoad(driver);
	}

	public static void clickOnMyRequisitionSubTab(WebDriver driver) throws ActionBotException
	{

		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, MY_REQUISITION_RAINBOW);
		}
		else
		{
			clickOnRequisitionTab(driver);
			ActionBot.defaultSleep();
			ActionBot.waitForElementToBePresent(driver, By.id("my_favourites_sub"));
			ActionBot.click(driver, MY_REQUISITION);
			ActionBot.waitForPageLoad(driver);
		}
		ActionBot.waitTillPopUpIsPresent(driver, IPageMyRequisition.REQ_LIST_PROCESSING);
	}

	public static void clickOnOnlineStoreSubTab(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, ONLINE_STORES_RAINBOW);
		}
		else
		{
			clickOnRequisitionTab(driver);
			ActionBot.focusAndclick(driver, ONLINE_STORES);
		}
		ActionBot.waitForPageLoad(driver);
	}

	public static void clickOnPOTab(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, PO_RAINBOW);
		}
		else
		{
			ActionBot.click(driver, PO);
			ActionBot.defaultSleep();
		}
		ActionBot.waitForPageLoad(driver);
	}

	public static void clickOnRequisitionTab(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, REQUISITION_RAINBOW);
			ActionBot.click(driver, ONLINE_STORES_RAINBOW);
		}
		else
		{
			ActionBot.waitForPageLoad(driver);
			ActionBot.click(driver, REQUISITION);
			//			ActionBot.click(driver, ONLINE_STORES);
		}
		ActionBot.waitForPageLoad(driver);
	}

	public static void clickOnSetupAndCustomize(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, SETUP_RAINBOW);
			ActionBot.click(driver, CUSTOMIZE_RAINBOW);
		}
		else
		{
			ActionBot.click(driver, SETUP);
			ActionBot.click(driver, SETUP_SUB);
			ActionBot.click(driver, CUSTOMIZE);
		}
	}

	public static void clickOnSetUpSubTab(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			//removed from 17.08 release
		}
		else
		{
			clickOnSetUpTab(driver);
			ActionBot.waitForPageLoad(driver);
			ActionBot.click(driver, SETUP_SUB);
		}
		ActionBot.waitForPageLoad(driver);
	}

	public static void clickOnSetUpTab(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, SETUP_RAINBOW);
		}
		else
		{
			ActionBot.click(driver, SETUP);
			ActionBot.defaultSleep();
		}
	}

	public static void clickOnShoppingBasketSubTab(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, SHOPPING_BASKET_RAINBOW);
		}
		else
		{
			clickOnRequisitionTab(driver);
			ActionBot.click(driver, SHOPPING_BASKET);
		}
		ActionBot.waitForPageLoad(driver);
		ActionBot.findElement(driver, IPageMyBasket.TEXT_BASKET_SEARCH);
	}

	public static String getUserDisplayName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String displayName = ActionBot.getTextWithInElement(driver, DISPLAY_USER_NAME);
		logger.info("User Display Name : " + displayName);
		String name[] = displayName.split(",");
		displayName = name[1].trim();
		ScreenShot.screenshot(driver, testCaseName, "Display name of user");
		return displayName;
	}

	public static void clickOnEformTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, EFORM_RAINBOW);
		}
		else
		{
			ActionBot.click(driver, EFORM_TAB);
		}
	}

	public static void clickOnCategoryEformTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, EFORM_RAINBOW);
			ActionBot.click(driver, CATEGORY_EFORM_TAB_RAINBOW);
		}
		else
		{
			clickOnEformTab(driver, testCaseName);
			ActionBot.click(driver, CATEGORY_EFORM_TAB);
		}
	}

	public static void clickOnProcessEformTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, EFORM_RAINBOW);
			ActionBot.click(driver, PROCESS_EFORM_TAB_RAINBOW);
		}
		else
		{
			clickOnEformTab(driver, testCaseName);
			ActionBot.click(driver, PROCESS_EFORM_TAB);
		}
		ActionBot.waitTillPopUpIsPresent(driver, IPagePEformListing.PROCESSING_DIV_PEFORM_GRID_LISTING);
	}

	public static void clickOnProfileTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			ActionBot.click(driver, USER_ICON_HEADER_RAINBOW);
			ActionBot.click(driver, MY_PROFILE_RAINBOW);
		}
		else
		{
			ActionBot.click(driver, PROFILE_TAB);
			ActionBot.waitForElementToBeDisplayed(driver, MANAGE_PROFILE_TAB, 30);
		}
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, "", "After clicking on my profile");
	}

	public static void clickOnConfigurationTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{

		}
		else
		{
			clickOnProfileTab(driver, testCaseName);
			ActionBot.click(driver, CONFIGURATION_TAB);
		}
	}

	public static void clickOnUpcomingRequisitionTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, BUYER_DESK_RAINBOW);
			ActionBot.click(driver, UPCOMING_REQUISITION_TAB_RAINBOW);
		}
		else
		{
			clickOnBuyersDeskTopTab(driver);
			WebElement element = ActionBot.findElement(driver, UPCOMING_REQUISITION_TAB);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			//			ActionBot.click(driver, UPCOMING_REQUISITION_TAB);
		}
		ActionBot.waitTillPopUpIsPresent(driver, IPageBuyersDeskListing.PROCESSING_DIV_UPCOMING_REQUISITION);
	}

	public static void clickOnBudgetTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, BUDGET_RAINBOW);
		}
		else
		{
			ActionBot.click(driver, BUDGET_TAB);
		}
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After Navigating to Budget Tab");
		ActionBot.defaultSleep();
	}

	public static void clickOnPcardSubTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.focusAndclick(driver, PCARD_RAINBOW);
		}
		else
		{
			ActionBot.focusAndclick(driver, PCARD_TAB);
			if (ActionBot.isElementDisplayed(driver, PCARD_SUB_TAB))
			{
				ActionBot.focusAndclick(driver, PCARD_SUB_TAB);
			}

		}
	}

	public static void clickOnReportTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, REPORTS_RAINBOW);
		}
		else
		{
			ActionBot.click(driver, REPORT_TAB);
		}

	}

	public static void clickOnSuppliersSubTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SUPPLIERS_TOP_TAB);
		ActionBot.click(driver, SUPPLIERS_SUB_TAB);
	}

	public static void clickOnSupplierOnBoardingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SUPPLIERS_TOP_TAB);
		ActionBot.click(driver, SUPPLIERS_ONBOARDING_SUB_TAB);
	}

	public static void clickOnMySettingsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, APPROVAL_RAINBOW);
			ActionBot.click(driver, MY_SETTINGS_RAINBOW);
		}
		else
		{
			clickOnApprovalTab(driver);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, My_SETTINGS);
		}
	}

	public static void clickOnInvoiceProductSwitchTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_OPEN_PRODUCT_SELECTION);
		WebElement element = ActionBot.findElement(driver, EINVOICE_PRODUCT_SELECTION_TAB_ON_SWITCH_PRODUCT);

		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on eInvoice product selection tab");
	}

	public static void clickOnEprocProductSwitchTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_OPEN_PRODUCT_SELECTION);
		WebElement element = ActionBot.findElement(driver, EPROC_PRODUCT_SELECTION_TAB_ON_SWITCH_PRODUCT);

		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on eProc product selection tab");
	}

	public static void clickOnTmsProductSwitchTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_OPEN_PRODUCT_SELECTION);
		WebElement element = ActionBot.findElement(driver, TMS_PRODUCT_SELECTION_TAB_ON_SWITCH_PRODUCT);

		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on TMS product selection tab");
	}

	public static void clickOnIsourceProductSwitchTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_OPEN_PRODUCT_SELECTION);
		WebElement element = ActionBot.findElement(driver, ISOURCE_PRODUCT_SELECTION_TAB_ON_SWITCH_PRODUCT);

		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on ISource product selection tab");
	}

	public static void clickOnInventoryTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, INVENTORY_RAINBOW);
		}
		else
		{
			ActionBot.click(driver, INVENTORY_TOP_TAB);
		}
		ActionBot.waitForPageLoad(driver);
	}

	public static void clickOnItemMasterSubTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, INVENTORY_RAINBOW);
			ActionBot.click(driver, ITEM_MASTER_INVENTORY_TAB_RAINBOW);
		}
		else
		{
			clickOnInventoryTab(driver, testCaseName);
			ActionBot.click(driver, ITEM_MASTER_INVENTORY_TAB);
		}
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After navigating to Item Master Page");
	}

	public static void clickOnMasterSubTab(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPageOnlineStore.LOGO_ZYCUS_RAINBOW))
		{
			clickOnEprocProductFromRainbowMenu(driver, "");
			ActionBot.click(driver, SETUP_RAINBOW);
			ActionBot.click(driver, MASTER_DATA_RAINBOW);
		}
		else
		{
			clickOnSetUpSubTab(driver);
			ActionBot.click(driver, MASTER_DATA);
			ActionBot.defaultSleep();
		}
	}

	public static void clickOnExitMasterDataLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EXIT_MASTER_DATA);
		ActionBot.defaultSleep();
	}

	public static void clickOnUsersSubTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, USERS_TAB_USER_MANAGEMENT);
	}

	public static void clickOnManageProfileTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		clickOnProfileTab(driver, testCaseName);
		ActionBot.defaultSleep();
		ActionBot.click(driver, MANAGE_PROFILE_TAB);
		ActionBot.defaultMediumSleep();
	}

	public static String switchToUserProfileWindow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String parentWindow = driver.getWindowHandle();
		Set<String> win = driver.getWindowHandles();
		int count = win.size();
		if (count == 2)
		{
			win.remove(parentWindow);
			String window = win.iterator().next();

			if (window != parentWindow)
			{
				String childWindow = window;
				driver.switchTo().window(childWindow);
				// driver.close();
			}
		}
		// driver.switchTo().window(parentWindow);
		return parentWindow;
	}

	public static void closeUserProfileWindow(WebDriver driver, String testCaseName, String parentWindow) throws ActionBotException
	{
		driver.close();
		driver.switchTo().window(parentWindow);
	}

	public static String getUserCurrencyValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.scroll(driver, "500");
		ActionBot.defaultSleep();
		WebElement currency = ActionBot.findElement(driver, By.xpath(".//*[@id='defaultCurrency']//*[@selected='selected']"));
		String selectedCurrency = currency.getAttribute("value").toString();
		return selectedCurrency;
	}

	public static void clickOnEprocProductFromRainbowMenu(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, HEADER_MENU_RAINBOW);
		if (ActionBot.isElementDisplayed(driver, REQUISITION_RAINBOW))
		{

		}
		else
		{
			ActionBot.click(driver, EPROC_PRODUCT_RAINBOW);
			ScreenShot.screenshot(driver, testCaseName, "After clicking on eProc product from Rainbow");
		}
	}

	public static void clickOnTMSMasterDataTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking Master Data Tab");
		ActionBot.click(driver, TAB_MASTER_DATA_TMS);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking Master Data Tab");
	}

	public static void clickOnTMSCustomizeSubTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking customize sub tab");
		ActionBot.click(driver, CUSTOMIZE);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking customize sub tab");
	}

	public static void clickOnProcurementContractsSubTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		clickOnCatalogTopTab(driver, testCaseName);
		ActionBot.click(driver, PROCUREMENT_CONTRACTS_SUB_TAB_LINK);
		ActionBot.waitForPageLoad(driver);
	}
}
