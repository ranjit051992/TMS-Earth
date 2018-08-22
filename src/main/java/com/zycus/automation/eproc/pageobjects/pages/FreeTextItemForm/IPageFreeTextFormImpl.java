package com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.ScreenshotException;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.modals.freeTextForm_SelectCategory.IModalSelectCategory;
import com.zycus.automation.eproc.pageobjects.pages.myfavorites.IPageMyFavorites;
import com.zycus.automation.eproc.pageobjects.pages.myfavorites.PageMyFavorites;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageFreeTextFormImpl implements IPageFreeTextForm
{
	static Logger logger = Logger.getLogger(IPageFreeTextFormImpl.class);

	@Override
	public String fillShortDescription(WebDriver driver, String testcaseName, String shortDescription) throws ActionBotException
	{
		String enteredShortDesc = ActionBot.sendKeys(driver, SHORT_DESCRIPTION, shortDescription);
		logger.info("Entered Short Description is: " + enteredShortDesc);
		ActionBot.click(driver, PART_NUMBER);
		ActionBot.defaultMediumSleep();
		//to select first eform with auto-class on
		if (ActionBot.isElementDisplayed(driver, IModalSelectCategory.SELECT_EFORM))
		{
			ActionBot.click(driver, IModalSelectCategory.SELECT_EFORM);
		}
		else
		{
			logger.info("Auto Class Disabled");
			ScreenShot.screenshot(driver, testcaseName, "AutoClass is off for category");
		}
		return enteredShortDesc;
	}

	@Override
	public String getShortDescription(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String enteredShortDesc = ActionBot.getTextWithInElement(driver, SHORT_DESCRIPTION);
		logger.info("Entered Short Description is: " + enteredShortDesc);
		return enteredShortDesc;
	}

	@Override
	public String fillPartNumber(WebDriver driver, String testcaseName, String partNumber) throws ActionBotException
	{
		String enteredPartNumber = ActionBot.sendKeys(driver, PART_NUMBER, partNumber);
		logger.info("Part Number Entered is: " + enteredPartNumber);
		return enteredPartNumber;
	}

	@Override
	public void clickOnSelectCategory(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_CATEGORY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testcaseName, "After clicking on Select Category");
	}

	@Override
	public float fillQuantity(WebDriver driver, String testcaseName, float quantity) throws ActionBotException
	{
		float quantityEntered = 0;
		String freeTextQuantity = String.valueOf(quantity);
		String enteredQuantity = ActionBot.sendKeys(driver, QUANTITY, freeTextQuantity);
		logger.info("Quantity Entered is: " + enteredQuantity);
		if (enteredQuantity.length() != 0 || enteredQuantity != null)
		{
			quantityEntered = Float.parseFloat(enteredQuantity);
		}
		return quantityEntered;
	}

	@Override
	public int fillQuantity(WebDriver driver, String testcaseName, int quantity) throws ActionBotException
	{
		int quantityEntered = 0;
		String freeTextQuantity = String.valueOf(quantity);
		ActionBot.defaultMediumSleep();
		String enteredQuantity = ActionBot.sendKeys(driver, QUANTITY, freeTextQuantity);
		logger.info("Quantity Entered is: " + enteredQuantity);
		if (enteredQuantity.length() != 0 || enteredQuantity != null)
		{
			quantityEntered = Integer.parseInt(enteredQuantity);
		}
		return quantityEntered;
	}

	@Override
	public String fillLongDescription(WebDriver driver, String testcaseName, String longDescription) throws ActionBotException
	{
		String enteredLongDesc = ActionBot.sendKeys(driver, LONG_DESCRIPTION, longDescription);
		logger.info("Long description Entered is: " + enteredLongDesc);
		return enteredLongDesc;
	}

	@Override
	public float fillPrice(WebDriver driver, String testcaseName, float price) throws ActionBotException
	{
		String freeTextPrice = String.valueOf(price);
		String enteredPrice = ActionBot.sendKeys(driver, PRICE, freeTextPrice);
		float priceEntered = Float.parseFloat(enteredPrice);
		logger.info("Price Entered is: " + priceEntered);
		ActionBot.defaultSleep();
		if (ActionBot.getTextWithInElement(driver, PRICE) == null)
		{
			WebElement element = ActionBot.findElement(driver, PRICE);
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			javascriptExecutor.executeScript("arguments[0].value=" + price + "", element);
		}
		return Float.parseFloat(ActionBot.getTextWithInElement(driver, PRICE));
	}

	@Override
	public String getPrice(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		return ActionBot.getTextWithInElement(driver, PRICE);
	}

	@Override
	public String getQuantity(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		return ActionBot.getTextWithInElement(driver, QUANTITY);
	}

	@Override
	public boolean clickItemType(WebDriver driver, String testcaseName, String itemType) throws ActionBotException
	{
		if (itemType.equalsIgnoreCase("Goods"))
		{
			By ITEM_TYPE_GOODS = By.xpath("//input[@id='itemType_goods']");
			String str = driver.findElement(ITEM_TYPE_GOODS).getAttribute("checked");
			if (str.equalsIgnoreCase("true"))
			{
				logger.info("Checkbox selected");
			}
			else
			{
				ActionBot.click(driver, ITEM_TYPE_GOODS);
				ScreenShot.screenshot(driver, testcaseName, "After clicking on radio button Goods");
			}
			return true;
		}

		else if (itemType.equalsIgnoreCase("Services"))
		{
			ActionBot.click(driver, ITEM_TYPE_SERVICES);
			if (!ActionBot.isElementSelected(driver, ITEM_TYPE_SERVICES))
			{
				WebElement element = ActionBot.findElement(driver, ITEM_TYPE_SERVICES);
				JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
				javascriptExecutor.executeScript("arguments[0].checked = true;", element);
			}
			ScreenShot.screenshot(driver, testcaseName, "After clicking on radio button Services");
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickSourcingStatus(WebDriver driver, String testcaseName, String sourcingStatus) throws ActionBotException
	{
		if (sourcingStatus.equalsIgnoreCase("Quoted by supplier"))
		{
			ActionBot.click(driver, SOURCING_STATUS_QUOTEDBYSUPPLIER);
			return true;
		}

		if (sourcingStatus.equalsIgnoreCase("Estimated price"))
		{
			ActionBot.click(driver, SOURCING_STATUS_ESTIMATEDPRICE);
			return true;
		}

		if (sourcingStatus.equalsIgnoreCase("Need a Quote"))
		{
			System.out.println("sourcing status....." + sourcingStatus);
			ActionBot.waitForElementToBeDisplayed(driver, SOURCING_STATUS_NEEDQUOTE, 50);
			ActionBot.click(driver, SOURCING_STATUS_NEEDQUOTE);
			if (ActionBot.isElementSelected(driver, SOURCING_STATUS_NEEDQUOTE))
			{
				System.out.println("sourcing status : need a quote");
				return true;
			}
			else if (!ActionBot.isElementSelected(driver, SOURCING_STATUS_NEEDQUOTE))
			{
				if (ActionBot.isElementDisplayed(driver, SOURCING_STATUS_NEEDQUOTE))
				{
					ActionBot.click(driver, SOURCING_STATUS_NEEDQUOTE);
				}
				if (!ActionBot.isElementSelected(driver, SOURCING_STATUS_NEEDQUOTE))
				{
					JavascriptExecutor js = (JavascriptExecutor) driver;
					WebElement element = (WebElement) js.executeScript("return document.getElementById('sourcingStatus_quote');");
					js.executeScript("document.getElementById('sourcingStatus_quote').style.visibility='visible';");
					element.click();
					System.out.println("selecting sourcing status using javascript : need a Quote");
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickReceive_BillBy(WebDriver driver, String testcaseName, String receiveBy)

	{
		try
		{
			if (receiveBy.equalsIgnoreCase("Quantity"))
			{
				By RECEIVE_QUANTIY = By.xpath("//input[@id='receivedBy_quantity']");
				String str = driver.findElement(RECEIVE_QUANTIY).getAttribute("checked");
				if (str.equalsIgnoreCase("true"))
				{
					logger.info("Checkbox selected");
				}
				else
				{
					ActionBot.click(driver, RECEIVE_QUANTIY);
				}

				return true;
			}

			if (receiveBy.equalsIgnoreCase("Amount"))
			{
				ActionBot.click(driver, RECEIVE_AMOUNT);
				return true;
			}

			if (receiveBy.equalsIgnoreCase("No Receipt"))
			{
				ActionBot.click(driver, RECEIVE_NORECEIPT);
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String fillCurrency(WebDriver driver, String testcaseName, String currency) throws ActionBotException
	{
		ActionBot.findElement(driver, CURRENCY);
		String enteredCurrency = null;
		/*
		 * if (currency != null) { element.clear(); element.sendKeys(currency);
		 * ActionBot.defaultSleep(); //select from the loaded suggestions
		 * element.sendKeys(Keys.ARROW_DOWN); element.sendKeys(Keys.RETURN);
		 * ActionBot.defaultSleep(); } else { element.clear();
		 * element.sendKeys(Keys.SPACE); ActionBot.defaultSleep(); //select from
		 * the loaded suggestions element.sendKeys(Keys.ARROW_DOWN);
		 * element.sendKeys(Keys.ARROW_DOWN); element.sendKeys(Keys.ARROW_DOWN);
		 * element.sendKeys(Keys.RETURN); ActionBot.defaultSleep(); }
		 * enteredCurrency = ActionBot.findElement(driver,
		 * CURRENCY).getAttribute("value");
		 */
		/*
		 * enteredCurrency = ActionBot.fillAutoCompleteField(driver, CURRENCY,
		 * AUTO_POPULATED_LIST_FOR_FREE_TEXT_CURRENCY, currency);
		 */
		enteredCurrency = ActionBot.fillAutoCompleteField(driver, CURRENCY, currency);
		logger.info("Currency in Free Text Item is :" + enteredCurrency);

		return enteredCurrency;
	}

	@Override
	public void fillNew_ExistingSupplierInfo(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, ANOTHER_NEW_SUPPLIER_LINK);

	}

	@Override
	public boolean clickPlaceOrderWithExistingSupplier(WebDriver driver, String testcaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PLACE_ORDER_WITH_EXISTING_SUPPLIER))
		{
			if (ActionBot.findElement(driver, PLACE_ORDER_WITH_EXISTING_SUPPLIER).isEnabled())
			{
				ActionBot.click(driver, PLACE_ORDER_WITH_EXISTING_SUPPLIER);
				return true;
			}
			else
			{
				logger.info("'Place the order with Existing Supplier' Radio Button is not Enabled");
				return false;
			}

		}
		else
		{
			logger.info("'Place the order with Existing Supplier' Radio Button is not displayed");
			return false;
		}
	}

	@Override
	public void clickOnAddToCartButton(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testcaseName, "Before clicking on add to cart button");
		//ActionBot.waitForElementToBePresent(driver, 30, ADD_TO_CART_BUTTON);
		ActionBot.waitForElementToBeDisplayed(driver, ADD_TO_CART_BUTTON, 30);
		ActionBot.click(driver, ADD_TO_CART_BUTTON);
		ActionBot.waitForPageLoad(driver);
		ActionBot.waitTillPopUpIsPresent(driver, By.xpath(".//*[@id='status_overlay_save_guided_loading']"));
		// ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testcaseName, "After clicking on add to cart button");
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_BUTTON_FREE_TEXT_FORM);

	}

	@Override
	public void clickOnAddAnotherItemOnAddToCartPopup(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='checkoutDiag']//a[contains(@class,'addAnotherItem')]"));
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnRecentlyOrderedFreeTextItems(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		ActionBot.waitForElementToBePresent(driver, 10, RECENTLY_ORDERED_FREE_TEXT_ITEMS);
		ActionBot.waitForElementToBeDisplayed(driver, RECENTLY_ORDERED_FREE_TEXT_ITEMS, 10);
		ActionBot.scroll(driver, ActionBot.findElement(driver, RECENTLY_ORDERED_FREE_TEXT_ITEMS));
		ActionBot.click(driver, RECENTLY_ORDERED_FREE_TEXT_ITEMS);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnSelectCategoryAtHeader(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_CATEGORY_AT_HEADER);

	}

	@Override
	public void clickOnItemLinkOnRecentlyOrderedFreeTextItems(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, ITEM_RECENTLY_ORDERED_FREE_TEXT_ITEMS);

	}

	@Override
	public void clickOnActionsBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, ACTIONS_BTN);

	}

	@Override
	public String fillUOM(WebDriver driver, String testcaseName, String uom) throws ActionBotException
	{
		String enteredUOM = null;
		if (uom != null)
		{
			enteredUOM = ActionBot.fillAutoCompleteField(driver, UOM, uom);
		}
		else
		{
			enteredUOM = ActionBot.getAttributeOfElement(driver, UOM, "value");
		}
		logger.info("Entered UOM : " + enteredUOM);
		return enteredUOM;
	}

	@Override
	public String fillsupplierNameInSuppInfo(WebDriver driver, String testcaseName, String suppName) throws ActionBotException
	{
		/*
		 * ActionBot.sendKeys(driver, SUPPLIER_NAME_IN_SUPPLIER_INFO, suppName);
		 * ActionBot.defaultMediumSleep(); ActionBot.findElement(driver,
		 * SUPPLIER_NAME_IN_SUPPLIER_INFO).sendKeys(Keys.ARROW_DOWN);
		 * ActionBot.findElement(driver,
		 * SUPPLIER_NAME_IN_SUPPLIER_INFO).sendKeys(Keys.RETURN);
		 * //ActionBot.click(driver, By.partialLinkText(suppName));
		 * ActionBot.defaultSleep(); String suppNameInSuppInfo =
		 * ActionBot.findElement(driver,
		 * SUPPLIER_NAME_IN_SUPPLIER_INFO).getAttribute("value");
		 */
		String suppNameInSuppInfo = ActionBot.fillAutoCompleteField(driver, SUPPLIER_NAME_IN_SUPPLIER_INFO, suppName);
		logger.info("Supplier name in supplier info section is :" + suppNameInSuppInfo);
		return suppNameInSuppInfo;
	}

	@Override
	public String filladdressInSuppInfo(WebDriver driver, String testcaseName, String address) throws ActionBotException
	{

		ActionBot.click(driver, BUTTON_ADDRESS_DROPDOWN);
		ActionBot.click(driver, AUTO_POPULATED_LIST_FOR_EXISTING_SUPPLIER_ADDRESS);
		String addInSuppInfo = ActionBot.findElement(driver, ADDRESS_IN_SUPPLIER_INFO).getAttribute("value");
		/*
		 * String addInSuppInfo =
		 * ActionBot.selectValueFromAutoCompleteList(driver,
		 * ADDRESS_IN_SUPPLIER_INFO,
		 * AUTO_POPULATED_LIST_FOR_EXISTING_SUPPLIER_ADDRESS, address);
		 * ActionBot.click(driver, ADDRESS_IN_SUPPLIER_INFO);
		 */
		return addInSuppInfo;
	}

	@Override
	public String fillcontractNoInSuppInfo(WebDriver driver, String testcaseName, String contractNo) throws ActionBotException

	{
		ActionBot.waitForElementToBeVisible(driver, 10, CONTRACT_NO_IN_SUPPLIER_INFO);
		ActionBot.waitForElementToBeDisplayed(driver, CONTRACT_NO_IN_SUPPLIER_INFO, 5);
		ActionBot.sendKeys(driver, CONTRACT_NO_IN_SUPPLIER_INFO, contractNo);
		String contractInSuppInfo = ActionBot.findElement(driver, CONTRACT_NO_IN_SUPPLIER_INFO).getAttribute("value");
		logger.info("Contract No in supplier info section is :" + contractInSuppInfo);
		ActionBot.defaultLowSleep();
		return contractInSuppInfo;

	}

	@Override
	public boolean isSelectCategoryLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, IPageFreeTextForm.SELECT_CATEGORY);
	}

	@Override
	public String getSelectedProductCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if(ActionBot.isElementDisplayed(driver, LABEL_PRODUCT_CATEGORY))
		{
			String selectedProductCategory = ActionBot.getTextWithInElement(driver, LABEL_PRODUCT_CATEGORY);
			logger.info("Selected Product Category : " + selectedProductCategory);
			ScreenShot.screenshot(driver, testCaseName, "Selected Product Category");
			return selectedProductCategory;
		}
		return null;		
	}

	@Override
	public int getSizeOfSelectedProductCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int length = 0;
		if (ActionBot.isElementDisplayed(driver, LABEL_PRODUCT_CATEGORY))
		{
			String selectedProductCategory = ActionBot.getTextWithInElement(driver, LABEL_PRODUCT_CATEGORY);
			if (selectedProductCategory != null)
			{
				length = selectedProductCategory.length();
			}
		}
		logger.info("Length of Selected Product Category : " + length);
		return length;
	}

	@Override
	public void clickOnSuggestSupplierRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIO_BUTTON_SUGGEST_SUPPLIER))
		{
			ActionBot.click(driver, RADIO_BUTTON_SUGGEST_SUPPLIER);
		}
		ScreenShot.screenshot(driver, testCaseName, "after selecting suggest supplier radio button");
	}

	@Override
	public void clickOnAddNewOrExistingSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_NEW_OR_EXISTING_SUPPLIER);
		ScreenShot.screenshot(driver, testCaseName, "Suggest supplier");
	}

	@Override
	public String getSuggestedSupplierNameOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierName = ActionBot.getTextWithInElement(driver, LABEL_FIRST_ROW_SUGGESTED_SUPPLIER_NAME);
		logger.info("Suggested supplier name as on supplier listing : " + supplierName);
		return supplierName;
	}

	@Override
	public String getSuggestedSupplierTypeOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierType = ActionBot.getTextWithInElement(driver, LABEL_FIRST_ROW_SUGGESTED_SUPPLIER_TYPE);
		logger.info("Suggested supplier type as on supplier listing : " + supplierType);
		return supplierType;
	}

	@Override
	public String getSuggestedSupplierActionOfFirstRow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierAction = ActionBot.getTextWithInElement(driver, LABEL_FIRST_ROW_SUGGESTED_SUPPLIER_ACTIONS);
		logger.info("Suggested supplier action as on supplier listing : " + supplierAction);
		return supplierAction;
	}

	@Override
	public void clickOnShowAllContractOrBPOButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.focusAndclick(driver, BUTTON_SHOW_ALL_CONTRACT_OR_BPO_FOR_GUIDED_ITEM);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Show all Contract and BPO Button");
	}

	@Override
	public String getSelectedContractOrBPOName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String selectedContarctOrBPOName = ActionBot.getTextWithInElement(driver, LABEL_SELECTED_CONTARCT_OR_BPO_FOR_GUIDED_ITEM);
		logger.info("Selected contract or BPO Name : " + selectedContarctOrBPOName);
		return selectedContarctOrBPOName;
	}

	@Override
	public void clickOnSelectExistingSupplierLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.focusAndclick(driver, LINK_ADD_EXISTING_SUPPLIER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickSuggestedSupplierRadioLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.focusAndclick(driver, RADIO_BUTTON_SUGGEST_SUPPLIER);
	}

	@Override
	public void clickOnAddNewSupplierLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.focusAndclick(driver, LINK_ADD_NEW_SUPPLIER);
	}

	@Override
	public void searchForSupplierName(WebDriver driver, String testcaseName, String suppName) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, IPageFreeTextForm.SUPPLIER_NAME_TEXTBOX, suppName);
		ActionBot.defaultLowSleep();
	}

	@Override
	public String fillExistingSuggestSupplierName(WebDriver driver, String testcaseName, String supplierName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TEXTBOX_EXISTING_SUGGEST_SUPPLIER_NAME);
		String selectedSupplierName = ActionBot.fillAutoCompleteField(driver, TEXTBOX_EXISTING_SUGGEST_SUPPLIER_NAME, supplierName);
		/*
		 * String selectedSupplierName = ActionBot.fillAutoCompleteField(driver,
		 * TEXTBOX_EXISTING_SUGGEST_SUPPLIER_NAME,
		 * AUTO_POPULATED_LIST_FOR_SUGGEST_EXISTING_SUPPLIER_NAME,
		 * supplierName);
		 */
		logger.info("Selected existing suggested Supplier Name : " + selectedSupplierName);
		return selectedSupplierName;
	}

	@Override
	public String selectExistingSuggestSupplierAddress(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String selectedSupplierAddress = null;
		ActionBot.click(driver, IPageFreeTextForm.SELECT_EXISTING_SUGGEST_SUPPLIER_ADDRESS);
		ActionBot.defaultSleep();
		ActionBot.click(driver, By.xpath("(.//*[@class='add-loc']/parent::a)[1]"));
		ActionBot.defaultLowSleep();
		logger.info("Selected existing suggested Supplier Address :" + selectedSupplierAddress);
		selectedSupplierAddress = ActionBot.getTextWithInElement(driver, SELECT_EXISTING_SUGGEST_SUPPLIER_ADDRESS);
		return selectedSupplierAddress;
	}

	@Override
	public boolean checkEditingSupplierAddress(WebDriver driver, String testcaseName, int editCount) throws ActionBotException
	{
		boolean statusSupplierAddressEdit = false;
		int count = 0;
		for (int i = 1; i <= editCount; i++)
		{
			try
			{
				ActionBot.click(driver, IPageFreeTextForm.SELECT_EXISTING_SUGGEST_SUPPLIER_ADDRESS);
				ActionBot.defaultSleep();
				ActionBot.defaultSleep();
				WebElement element = ActionBot.findElement(driver, By.id("(.//*[@class='add-loc']/parent::a)[" + i + "]"));
				element.click();
				ActionBot.defaultLowSleep();
				logger.info("Supplier Address Edited " + i + " times");
				count++;
			}
			catch (Exception e)
			{
				break;
			}

			ActionBot.moveToElement(driver, SELECT_EXISTING_SUGGEST_SUPPLIER_ADDRESS);
			String selectedSupplierAddress = ActionBot.selectValueFromAutoCompleteList(driver, SELECT_EXISTING_SUGGEST_SUPPLIER_ADDRESS,
				AUTO_POPULATED_LIST_FOR_SUGGEST_EXISTING_SUPPLIER_ADDRESS, null);
			logger.info("Selected existing suggested Supplier Address :" + selectedSupplierAddress);

			ActionBot.click(driver, SELECT_EXISTING_SUGGEST_SUPPLIER_ADDRESS);
			selectedSupplierAddress = ActionBot.findElement(driver, By.xpath("(.//*[@class='add-loc']/parent::a)[1]")).getText();
			ActionBot.click(driver, By.xpath("(.//*[@class='add-loc']/parent::a)[1]"));
		}
		if (count == editCount)
			statusSupplierAddressEdit = true;
		return statusSupplierAddressEdit;
	}

	@Override
	public String fillExistingSuggestSupplierContractNo(WebDriver driver, String testcaseName, String contractNo) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_EXISTING_SUGGEST_SUPPLIER_CONTRACT_NO))
		{
			// displayed under existing supplier option
			String enteredContractNo = ActionBot.sendKeys(driver, TEXTBOX_EXISTING_SUGGEST_SUPPLIER_CONTRACT_NO, contractNo);
			logger.info("Entered Contract No : " + enteredContractNo);
			return enteredContractNo;
		}
		else if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='dev_existingContractNo']")))
		{
			// displayed under system suggested buyer review option
			String enteredContractNo = ActionBot.sendKeys(driver, By.xpath(".//*[@id='dev_existingContractNo']"), contractNo);
			logger.info("Entered Contract No : " + enteredContractNo);
			return enteredContractNo;
		}
		else
		{
			logger.info("Contract Number not displayed on page ");
			return null;
		}

		/*
		 * String enteredContractNo = ActionBot.sendKeys(driver,
		 * TEXTBOX_EXISTING_SUGGEST_SUPPLIER_CONTRACT_NO, contractNo);
		 * logger.info("Entered Contract No : " + enteredContractNo); return
		 * enteredContractNo;
		 */
	}

	@Override
	public void clickOnAddExistingSuggestSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on add existing suggest supplier");
		ActionBot.click(driver, BUTTON_ADD_EXISTING_SUGGEST_SUPPLIER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add existing suggest supplier");
	}

	@Override
	public void clickOnResetExistingSuggestSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on reset existing suggest supplier");
		ActionBot.click(driver, BUTTON_RESET_EXISTING_SUGGEST_SUPPLIER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on reset existing suggest supplier");
	}

	@Override
	public String fillSuggestNewSupplierName(WebDriver driver, String testcaseName, String supplierName) throws ActionBotException
	{
		String selectedSupplierName = ActionBot.sendKeys(driver, TEXTBOX_SUGGEST_NEW_SUPPLIER_NAME, supplierName);
		logger.info("Suggested New Supplier Name : " + selectedSupplierName);
		return selectedSupplierName;
	}

	@Override
	public String fillSuggestNewSupplierAddress(WebDriver driver, String testcaseName, String supplierAddress) throws ActionBotException
	{
		String selectedSupplierAddress = null;
		if (supplierAddress != null)
		{
			selectedSupplierAddress = ActionBot.sendKeys(driver, SELECT_SUGGEST_NEW_SUPPLIER_ADDRESS, supplierAddress);
			logger.info("Suggested New Supplier Address :" + selectedSupplierAddress);
		}
		return selectedSupplierAddress;
	}

	@Override
	public String fillSuggestNewSupplierContractNo(WebDriver driver, String testcaseName, String contractNo) throws ActionBotException
	{
		String enteredContractNo = ActionBot.sendKeys(driver, TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTRACT_NO, contractNo);
		logger.info("Entered Contract No : " + enteredContractNo);
		return enteredContractNo;
	}

	@Override
	public String fillSuggestNewSupplierContact(WebDriver driver, String testcaseName, String contact) throws ActionBotException
	{
		String enteredContact = ActionBot.sendKeys(driver, TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTACT, contact);
		logger.info("Entered Supplier Contact : " + enteredContact);
		return enteredContact;
	}

	@Override
	public String fillSuggestNewSupplierEmailId(WebDriver driver, String testcaseName, String emailID) throws ActionBotException
	{
		String enteredEmailID = ActionBot.sendKeys(driver, TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTACT_EMAIL_ID, emailID);
		logger.info("Entered Supplier Contact Email Id : " + enteredEmailID);
		return enteredEmailID;
	}

	@Override
	public int fillSuggestNewSupplierPhone(WebDriver driver, String testcaseName, int phone) throws ActionBotException
	{
		String enteredPhone = ActionBot.sendKeys(driver, TEXTBOX_SUGGEST_NEW_SUPPLIER_PHONE, Integer.toString(phone));
		logger.info("Entered Supplier Contact Email Id : " + enteredPhone);
		return Integer.parseInt(enteredPhone);
	}

	@Override
	public String fillSuggestNewSupplierOtherDetails(WebDriver driver, String testcaseName, String otherDetails) throws ActionBotException
	{
		String enteredOtherDetails = ActionBot.sendKeys(driver, TEXTBOX_SUGGEST_NEW_SUPPLIER_OTHER_DETAILS, otherDetails);
		logger.info("Entered Supplier Other Details : " + enteredOtherDetails);
		return enteredOtherDetails;
	}

	@Override
	public void clickOnAddSuggestNewSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on add suggest new supplier");
		ActionBot.click(driver, BUTTON_ADD_NEW_SUGGEST_SUPPLIER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add suggest new supplier");
	}

	@Override
	public void clickOnResetSuggestNewSupplierButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on reset existing new supplier");
		ActionBot.click(driver, BUTTON_RESET_NEW_SUGGEST_SUPPLIER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on reset existing new supplier");
	}

	@Override
	public boolean isCreateFreeTextItemLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LABEL_CREATE_FREE_TEXT_ITEM))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickOnZeroPriceItem(WebDriver driver, String testCaseName) throws ActionBotException
	{

		if (ActionBot.isElementDisplayed(driver, CHECKBOX_ZERO_PRICE_ITEM_GUIDED_ITEM_PAGE))
		{
			// ScreenShot.screenshot(driver, testCaseName, "Before clicking on
			// Zero price item checkbox");
			ActionBot.click(driver, CHECKBOX_ZERO_PRICE_ITEM_GUIDED_ITEM_PAGE);
		}
		else
		{
			ActionBot.click(driver, By.xpath(".//*[@id='zeroAmountCheckbox']"));
		}
		// ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Zero price item checkbox");

	}

	@Override
	public void clickOnAddAttachmentLinkAndEscape(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, LINK_ADD_ATTACHMENTS_GUIDED_ITEM);
		element.click();
		// element.sendKeys(Keys.ESCAPE);
		ActionBot.click(driver, BUTTON_DONE_ATTACHMENT_GUIDED_ITEM);

	}

	@Override
	public String getSuggestNewExistingSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierName = ActionBot.getTextWithInElement(driver, TEXTBOX_EXISTING_SUGGEST_SUPPLIER_NAME);
		logger.info("Existing suggested supplier name : " + supplierName);
		return supplierName;
	}

	@Override
	public String getSuggestNewExistingSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierAddress = ActionBot.getTextWithInElement(driver, SELECT_EXISTING_SUGGEST_SUPPLIER_ADDRESS);
		logger.info("Existing suggested supplier address : " + supplierAddress);
		return supplierAddress;
	}

	@Override
	public String getSuggestNewSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierName = ActionBot.getTextWithInElement(driver, TEXTBOX_SUGGEST_NEW_SUPPLIER_NAME);
		logger.info("New suggested supplier name : " + supplierName);
		return supplierName;
	}

	@Override
	public String getSuggestNewSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierAddress = ActionBot.getTextWithInElement(driver, SELECT_SUGGEST_NEW_SUPPLIER_ADDRESS);
		logger.info("New suggested supplier address : " + supplierAddress);
		return supplierAddress;
	}

	@Override
	public String getSuggestNewSupplierContact(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierContact = ActionBot.getTextWithInElement(driver, TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTACT);
		logger.info("New suggested supplier contact : " + supplierContact);
		return supplierContact;
	}

	@Override
	public String getSuggestNewSupplierEmailID(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierEmailID = ActionBot.getTextWithInElement(driver, TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTACT_EMAIL_ID);
		logger.info("New suggested supplier email id : " + supplierEmailID);
		return supplierEmailID;
	}

	@Override
	public String getSuggestNewSupplierPhone(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierPhone = ActionBot.getTextWithInElement(driver, TEXTBOX_SUGGEST_NEW_SUPPLIER_PHONE);
		logger.info("New suggested supplier phone : " + supplierPhone);
		return supplierPhone;
	}

	@Override
	public String getSuggestNewSupplierContractNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String contractNo = ActionBot.getTextWithInElement(driver, TEXTBOX_SUGGEST_NEW_SUPPLIER_CONTRACT_NO);
		logger.info("New suggested supplier contract no : " + contractNo);
		return contractNo;
	}

	@Override
	public String getSuggestNewSupplierOtherDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String otherDetails = ActionBot.getTextWithInElement(driver, TEXTBOX_SUGGEST_NEW_SUPPLIER_OTHER_DETAILS);
		logger.info("New suggested supplier other details : " + otherDetails);
		return otherDetails;
	}

	@Override
	public String fillSourcingStatus(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[contains(@id,'sourcingStatus_')])[" + (index * 2) + "]"));
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'sourcingStatus_')])[" + (index * 2) + "]"), 10);
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'sourcingStatus_')])[" + (index * 2) + "]"));
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'sourcingStatus_')])[" + (index) + "]"));
	}

	@Override
	public void clickToCheckout(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBePresent(driver, 10, CHECKOUT_BUTTON);
		ActionBot.waitForElementToBeDisplayed(driver, CHECKOUT_BUTTON, 10);
		ActionBot.click(driver, CHECKOUT_BUTTON);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickToAddFreeTextItemIndexwise(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, RECENTLY_ORDERED_FREE_TEXT_ITEMS, 10);
		ActionBot.click(driver, RECENTLY_ORDERED_FREE_TEXT_ITEMS);
		ActionBot.defaultMediumSleep();
		if (ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@id='guidedItemList']//a[contains(@href,'#')])[" + index + "]")))
		{
			// ActionBot.waitForElementToBeDisplayed(driver,
			// By.xpath("(.//*[@id='guidedItemList']//a[contains(@href,'#')])["
			// + index + "]"), 10);
			ActionBot.click(driver, By.xpath("(.//*[@id='guidedItemList']//a[contains(@href,'#')])[" + index + "]"));
		}
		ActionBot.defaultSleep();
	}

	@Override
	public void clickSelectCategoryLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			ActionBot.defaultLowSleep();
			ActionBot.waitForElementToBeDisplayed(driver, SELECT_CATEGORY, 15);
			ActionBot.click(driver, SELECT_CATEGORY);
			ActionBot.defaultSleep();
			if (ActionBot.isElementDisplayed(driver, SELECT_CATEGORY))
				ActionBot.click(driver, SELECT_CATEGORY);
			ActionBot.defaultSleep();
		}
		catch (Exception e)
		{
		}
		ActionBot.defaultSleep();
	}

	@Override
	public boolean selectCategoryFromTheSearchBox(WebDriver driver, String testcaseName, String category) throws ActionBotException
	{
		try
		{
			ActionBot.fillAutoCompleteField(driver, IPageFreeTextForm.SEARCH_TEXT_BOX_CATEGRORY_SELECTION, category);
			ActionBot.defaultSleep();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public void selectEFormForCategory(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[@id='selectCategory']//div[@title='MyAnotherEForm'])[1]"));
	}

	@Override
	public void clickSelectEFormLink(WebDriver driver, String testcaseName, String eFormName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.waitForElementToBeDisplayed(driver, SELECT_EFORM_LINK, 60);
		ActionBot.click(driver, SELECT_EFORM_LINK);
		ActionBot.defaultLowSleep();
		WebElement element = ActionBot.findElement(driver, SEARCH_TEXT_BOX_EFORM_SELECTION);
		element.sendKeys(eFormName);
		element.sendKeys(Keys.ENTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickEFormInCategoryNameWise(WebDriver driver, String testcaseName, String name) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(".//*[@id='selectCategory']//div[contains(@title,'" + name + "')]"), 30);
		ActionBot.click(driver, By.xpath(".//*[@id='selectCategory']//div[contains(@title,'" + name + "')]"));
		ActionBot.defaultLowSleep();
		if (ActionBot.isElementDisplayed(driver, IPageMyFavorites.YES_CONFIRMATION))
			ActionBot.click(driver, IPageMyFavorites.YES_CONFIRMATION);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickEFormNamewise(WebDriver driver, String testcaseName, String eFormNAme) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(".//*[@id='selectEform']//a[contains(@class,'efrmLnk')]//div[contains(@title,'" + eFormNAme + "')]"), 30);
		ActionBot.click(driver, By.xpath(".//*[@id='selectEform']//a[contains(@class,'efrmLnk')]//div[contains(@title,'" + eFormNAme + "')]"));
		ActionBot.defaultLowSleep();
		if (ActionBot.isElementDisplayed(driver, IPageMyFavorites.YES_CONFIRMATION))
			ActionBot.click(driver, IPageMyFavorites.YES_CONFIRMATION);
	}

	@Override
	public void continueWithoutCategory(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		int index = 1;
		while (index <= 3)
		{
			try
			{
				ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//a[contains(@class,'noCategory')])[" + index + "]"), 10);
				ActionBot.click(driver, By.xpath("(.//a[contains(@class,'noCategory')])[" + index + "]"));
				break;
			}
			catch (Exception e)
			{
			}
			index++;
		}
	}

	@Override
	public void clickCloseCategoryDailogueButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, CLOSE_CATEGORY_DAILOGUE_BUTTON, 30);
		ActionBot.click(driver, CLOSE_CATEGORY_DAILOGUE_BUTTON);
	}

	@Override
	public boolean isCategoryListPresentInsideEForm(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		return ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@id='selectedEform']//a[contains(@class,'categoryEformItem')])[1]"));
	}

	@Override
	public boolean isYellowBandPresent(WebDriver driver, String testcaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, YELLOW_BAND_CONTAINER);
	}

	@Override
	public boolean isCatalogItemPunchoutsHyperlinkPresent(WebDriver driver, String testcaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, YELLOW_BAND_CATALOG_ITEM_LINK) && ActionBot.isElementDisplayed(driver, YELLOW_BAND_PUNCHOUTS_LINK);
	}

	@Override
	public void clickCatalogItemLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, YELLOW_BAND_CATALOG_ITEM_LINK);
	}

	@Override
	public boolean isContinueWithoutCategoryPresent(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath("(.//a[contains(@class,'noCategory')])[" + index + "]"));
	}

	@Override
	public boolean isContractNoFieldPresent(WebDriver driver, String testcaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, TEXTBOX_EXISTING_SUGGEST_SUPPLIER_CONTRACT_NO);
	}

	@Override
	public void veiwRecentlyOrderedItems(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, RECENTLY_ORDERED_ITEMS);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickRecentlyOrderedItemsIndexwise(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, By.xpath("(.//*[@id='guidedItemList']//a[contains(@class,'viewGuided')])[" + index + "]"));
		ActionBot.defaultSleep();
	}

	@Override
	public void clickSupplierSubTab(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, SUPPLIER_SUB_TAB);
		ActionBot.defaultLowSleep();
	}

	@Override
	public String getContractNumberFromItemDetailPopup(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		return ActionBot.getTextWithInElement(driver, CONTRACT_NO_IN_ITEM_DETAIL_POPUP);
	}

	@Override
	public void clickCloseItemDetailPopup(WebDriver driver, String testcaseName) throws ActionBotException
	{

	}

	@Override
	public String getItemCurrencyFromItemDetailPopup(WebDriver driver, String testcaseName, String currency) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		return ActionBot.getTextWithInElement(driver, CURRENCY);
	}

	@Override
	public String getItemQuantityFromItemDetailPopup(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'guidedItemDetailsForm')]//div[@name='lblQuantity'])[1]"));
	}

	@Override
	public String getItemPriceFromItemDetailPopup(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'guidedItemDetailsForm')]//div[@name='lblPrice'])[1]"));
	}

	@Override
	public void clickCopyItem(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, COPY_ITEM_BUTTON);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickCategoryUnderEFormIndexwise(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[@id='selectedEform']//a[contains(@class,'categoryEformItem')])[" + index + "]"), 10);
		ActionBot.click(driver, By.xpath("(.//*[@id='selectedEform']//a[contains(@class,'categoryEformItem')])[" + index + "]"));
		ActionBot.defaultLowSleep();
		PageMyFavorites.clickOnConfirmation_YES_NO(driver, testcaseName, IConstantsData.CONFIRMATION_YES);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickCloseItemModalPopup(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_ITEM_MODAL_POPUP);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickShowMoreExtraFields(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.scroll(driver, ActionBot.findElement(driver, SHOW_EXTRA_FIELDS_LINK));
		ActionBot.click(driver, SHOW_EXTRA_FIELDS_LINK);
		ActionBot.defaultSleep();
	}

	@Override
	public boolean isErrorMessageVisible(WebDriver driver, String testcaseName) throws ActionBotException
	{
		List<WebElement> errorList = ActionBot.findElements(driver, By.xpath(".//*[contains(@id,'-error')]"));
		if (errorList.size() == 0)
			return true;
		else
			return false;
	}

	@Override
	public String getExistingSupplierContractNumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		return ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='tblSelectedSuppliers']//td[contains(@class,'selectedSuppContract')]"));
	}

	@Override
	public int countSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, By.xpath("(.//*[@id='tblSelectedSuppliers']//td[contains(@class,'selectedSuppAction')])")).size();
	}

	@Override
	public int countEForms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, By.xpath(".//*[@id='selectCategory']//div[@class='efrmVal']")).size();
	}

	@Override
	public boolean isEFormFieldsVisible(WebDriver driver, String testcaseName, String fieldName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(".//*[contains(@id,'df_')]//label[contains(text(),'" + fieldName + "')]"), 5);
		return ActionBot.isElementDisplayed(driver, By.xpath(".//*[contains(@id,'df_')]//label[contains(text(),'" + fieldName + "')]"));
	}

	@Override
	public boolean isEFormVisible(WebDriver driver, String testcaseName, String displayName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='selectEform']//a[contains(@class,'efrmLnk')]//div[contains(@title,'" + displayName + "')]"));
	}

	@Override
	public boolean isFreeTextItemVisible(WebDriver driver, String testcaseName, String searchName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='guidedItemList']//a[contains(text(),'" + searchName + "')]"));
	}

	@Override
	public boolean isEformFieldVisible(WebDriver driver, String testcaseName, String eFormFieldName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'df_')]//label[@class='df-form-label'])[1]")).contains(eFormFieldName);
	}

	@Override
	public boolean isCatalogItemCountVisible(WebDriver driver, String testcaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='innerWarningMessage']//a[contains(@class,'viewCategoryItems')]"));
	}

	@Override
	public boolean isPunchoutCountLinkVisible(WebDriver driver, String testcaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='innerWarningMessage']//span[contains(@class,'punchoutCount')]"));
	}

	@Override
	public boolean isRequirementDetailsSectionVisible(WebDriver driver, String testcaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, REQUIREMENT_DETAILS_SECTION);
	}

	@Override
	public void clickOnRequisitionAppliesTo_RequirementDetail(WebDriver driver, String testcaseName, String requisitionAppliesTo_RequirementDetail) throws ActionBotException
	{
		if (requisitionAppliesTo_RequirementDetail.equalsIgnoreCase(IConstantsData.SO4834_REQUISITION_APPLIES_TO_CONTRACT_DETAILS))
		{
			ActionBot.click(driver, RADIO_SO4834_REQUISITION_APPLIES_TO_CONTRACT_DETAILS);
		}
		else if (requisitionAppliesTo_RequirementDetail.equalsIgnoreCase(IConstantsData.UNKNOWN_REQUISITION_APPLIES_TO_CONTRACT_DETAILS))
		{
			ActionBot.click(driver, RADIO_UNKNOWN_REQUISITION_APPLIES_TO_CONTRACT_DETAILS);
		}

	}

	@Override
	public void clickOnResponse_RequirementDetail(WebDriver driver, String testcaseName, String response_RequirementDetail) throws ActionBotException
	{
		if (response_RequirementDetail.equalsIgnoreCase(IConstants.YES))
		{
			ActionBot.click(driver, RADIO_YES_RESPONSE_CMS);
		}
		else if (response_RequirementDetail.equalsIgnoreCase(IConstants.NO))
		{
			ActionBot.click(driver, RADIO_NO_RESPONSE_CMS);
		}
		else if (response_RequirementDetail.equalsIgnoreCase(IConstantsData.NA_RESPONSE_CMS))
		{
			ActionBot.click(driver, RADIO_NA_RESPONSE_CMS);
		}

	}

	@Override
	public void clickOnPOSentToSupplier_RequirementDetail(WebDriver driver, String testcaseName, String poSentToSupplier_RequirementDetail) throws ActionBotException
	{
		if (poSentToSupplier_RequirementDetail.equalsIgnoreCase(IConstants.YES))
		{
			ActionBot.click(driver, RADIO_YES_PO_SENT_TO_SUPPLIER_ADDITIONAL_REQUISITION_DETAILS);
		}
		else if (poSentToSupplier_RequirementDetail.equalsIgnoreCase(IConstants.NO))
		{
			ActionBot.click(driver, RADIO_NO_PO_SENT_TO_SUPPLIER_ADDITIONAL_REQUISITION_DETAILS);
		}

	}

	@Override
	public void clickOnQuoteObtain_RequirementDetail(WebDriver driver, String testcaseName, String quoteObtained_RequirementDetail) throws ActionBotException
	{

		ActionBot.scroll(driver, ActionBot.findElement(driver, RADIO_NO_QUOTE_OBTAINED_QUOTE_RECOMMENDATION));
		if (quoteObtained_RequirementDetail.equalsIgnoreCase(IConstants.YES))
		{
			ActionBot.click(driver, RADIO_YES_QUOTE_OBTAINED_QUOTE_RECOMMENDATION);
		}
		else if (quoteObtained_RequirementDetail.equalsIgnoreCase(IConstantsData.YES_VERBAL_QUOTE_QUOTE_OBTAINED_QUOTE_RECOMMENDATION))
		{
			ActionBot.click(driver, RADIO_YES_VERBAL_QUOTE_QUOTE_OBTAINED_QUOTE_RECOMMENDATION);
		}
		else if (quoteObtained_RequirementDetail.equalsIgnoreCase(IConstants.NO))
		{
			ActionBot.click(driver, RADIO_NO_QUOTE_OBTAINED_QUOTE_RECOMMENDATION);
		}
	}

	@Override
	public void clickCancelGuideMePopup(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CANCEL_GUIDE_ME);
	}

	@Override
	public void clickOnLinkViewCart(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, VIEW_ITEMS_IN_CART_LINK);
		ActionBot.defaultSleep();
	}

	@Override
	public boolean clickOnshortDescriptionLinkInRecentlyOrderedFreeTextItemsNameWise(WebDriver driver, String testCaseName, String shortDescription) throws ActionBotException
	{
		if (!ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='guidedItemList']/tbody//td[contains(@class,'name')]/a[text()='" + shortDescription + "']")))
			return false;
		else
		{
			String itemId = ActionBot.findElement(driver, By.xpath(".//*[@id='guidedItemList']/tbody//td[contains(@class,'name')]/a[text()='" + shortDescription + "']"))
				.getAttribute("data-item-id");
			ActionBot.defaultSleep();
			ActionBot.click(driver, By.xpath(".//*[@id='guidedItemList']/tbody//td[contains(@class,'name')]/a[text()='" + shortDescription + "']"));
			ActionBot.defaultSleep();
			boolean checkItemDetailsPopUp = ActionBot.isElementDisplayed(driver, By.id("guidedItemContainer_" + itemId));
			return checkItemDetailsPopUp;
		}
	}
}
