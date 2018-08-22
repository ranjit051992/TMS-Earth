package com.zycus.automation.eproc.pageobjects.modals.POFreeTextItemSummaryItem;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalPOFreeTextItemSummaryItemImpl implements IModalPOFreeTextItemSummaryItem
{
	Logger logger = Logger.getLogger(IModalPOFreeTextItemSummaryItemImpl.class);

	@Override
	public int getLineNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String tagName, lineNo;
		int no = 0;
		if (ActionBot.isElementPresent(driver, TEXTBOX_LINE_NO))
		{
			tagName = ActionBot.findElement(driver, TEXTBOX_LINE_NO).getTagName();
			if (tagName.equalsIgnoreCase("input"))
			{
				if (ActionBot.getAttributeOfElement(driver, TEXTBOX_LINE_NO, "value") == null)
				{
					ActionBot.sendKeys(driver, TEXTBOX_LINE_NO, Integer.toString(CommonUtilities.getNonZeroRandomNumbers(4)));
				}
				lineNo = ActionBot.findElement(driver, TEXTBOX_LINE_NO).getAttribute("value").trim();
			}
			else
			{
				lineNo = ActionBot.getTextWithInElement(driver, TEXTBOX_LINE_NO).trim();
			}
		}
		else
		{
			lineNo = ActionBot.getTextWithInElement(driver, LABEL_LINE_NO_FREE_TEXT_ITEM).trim();
		}
		logger.info("Line No : " + lineNo);
		no = Integer.parseInt(lineNo);
		return no;

	}

	@Override
	public String fillShortDescription(WebDriver driver, String testCaseName, String shortDesc) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_SHORT_DESCRIPTION, shortDesc);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_SHORT_DESCRIPTION);
		return str;
	}

	@Override
	public String fillProductCategory(WebDriver driver, String testCaseName, String productCategory) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_PRODUCT_CATEGORY);
		String str = null;
		if (productCategory == null)
		{
			str = ele.getAttribute("value").trim();
			if (str.length() == 0)
			{
				ele.sendKeys(Keys.SPACE);
				ele.sendKeys(Keys.SPACE);
				ActionBot.defaultSleep();
				ele.sendKeys(Keys.ARROW_DOWN);
				ele.sendKeys(Keys.RETURN);
			}
			ScreenShot.screenshot(driver, testCaseName, "After filling product Category");
			// str = ActionBot.getTextWithInElement(driver,
			// TEXTBOX_PRODUCT_CATEGORY);
		}
		else
		{
			ActionBot.fillAutoCompleteField(driver, ele, productCategory);
		}
		str = ele.getAttribute("value");
		return str;
	}

	@Override
	public float fillMarketPrice(WebDriver driver, String testCaseName, float marketPrice) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.sendKeys(driver, TEXTBOX_MARKET_PRICE, "" + marketPrice);
		String temp = ActionBot.getTextWithInElement(driver, TEXTBOX_MARKET_PRICE).trim();
		if (temp != null)
		{
			float no = Float.parseFloat(temp);
			return no;
		}
		else
		{
			return 0;
		}

	}

	@Override
	public float fillQuantity(WebDriver driver, String testCaseName, float quantity) throws ActionBotException
	{
		String enteredQuantity = ActionBot.sendKeys(driver, TEXTBOX_QUANTITY, "" + quantity);
		logger.info("Entered Quantity : " + enteredQuantity);
		float entered_Quantity = 0;
		if (enteredQuantity != null)
		{
			entered_Quantity = Float.parseFloat(enteredQuantity);
		}
		return entered_Quantity;
	}

	@Override
	public int fillQuantity(WebDriver driver, String testCaseName, int quantity) throws ActionBotException
	{
		String enteredQuantity = ActionBot.sendKeys(driver, TEXTBOX_QUANTITY, "" + quantity);
		logger.info("Entered Quantity : " + enteredQuantity);
		int entered_Quantity = 0;
		if (enteredQuantity != null)
		{
			entered_Quantity = Integer.parseInt(enteredQuantity);
		}
		return entered_Quantity;
	}

	@Override
	public void clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_SAVE);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnItemTypeGoods(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_GOODS);

	}

	@Override
	public void clickOnItemTypeServices(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_SERVICES);

	}

	@Override
	public void clickOnReceiveBillByQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_QUANTITY);

	}

	@Override
	public void clickOnReceiveBillByAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_AMOUNT);

	}

	@Override
	public void clickOnReceiveBillByNoReceipt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_NO_RECEIPT);

	}

	@Override
	public String getUOM(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String uom = ActionBot.getAttributeOfElement(driver, TEXTBOX_UOM, "value");
		logger.info("UOM : " + uom);
		return uom;
	}

	@Override
	public Integer enterLineNo(WebDriver driver, String testCaseName, int lineNo) throws ActionBotException
	{
		String tagName, line_No;
		int no = 0;
		tagName = ActionBot.findElement(driver, TEXTBOX_LINE_NO).getTagName();
		if (tagName.equalsIgnoreCase("input"))
		{
			ActionBot.sendKeys(driver, TEXTBOX_LINE_NO, Integer.toString(lineNo));
			line_No = ActionBot.findElement(driver, TEXTBOX_LINE_NO).getAttribute("value").trim();
		}
		else
		{
			line_No = ActionBot.getTextWithInElement(driver, TEXTBOX_LINE_NO).trim();
		}
		logger.info("Line No : " + line_No);
		no = Integer.parseInt(line_No);
		return no;

	}

	@Override
	public String enterlongDescription(WebDriver driver, String testCaseName, String longDesc) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_LONG_DESCRIPTION, longDesc);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_LONG_DESCRIPTION);
		return str;
	}

	@Override
	public Integer enterItemNo(WebDriver driver, String testCaseName, int itemNo) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_ITEM_NO, "" + itemNo);
		String temp = ActionBot.getTextWithInElement(driver, TEXTBOX_ITEM_NO);
		if (temp != null)
		{
			Integer no = Integer.parseInt(temp);
			return no;
		}
		else
		{
			return 0;
		}

	}

	@Override
	public boolean isErrorMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, IS_ERROR_MESSAGE_DISPLAYED))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void enterAndHoverOnProductCategory(WebDriver driver, String testCaseName, String productCategory) throws ActionBotException
	{
		/*
		 * WebElement ele = ActionBot.findElement(driver,
		 * TEXTBOX_PRODUCT_CATEGORY); ele.sendKeys(productCategory);
		 * ele.sendKeys(Keys.ARROW_DOWN);
		 */
		ActionBot.fillAutoCompleteField(driver, TEXTBOX_PRODUCT_CATEGORY, productCategory);
		// String str = ActionBot.getTextWithInElement(driver,
		// TEXTBOX_PRODUCT_CATEGORY);
		// return str;
	}

	@Override
	public boolean isItemSummaryModalPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, MODAL_ITEM_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isTabErrorPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='frmItemSummary']//li[" + index + "]//em[@title='Please correct the errors before proceeding']")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isLineNoErrorPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='manTxtFields']//li[" + index + "]//label[@class='error']")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isLineNoErrorMessageCorrect(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='manTxtFields']//li[" + index + "]//label[@class='error']"));
		if (str.equalsIgnoreCase("0 is not allowed in line number"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnShortDescTextBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TEXTBOX_SHORT_DESCRIPTION);

	}

	@Override
	public boolean isLineNoFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXTBOX_LINE_NO);
		String lineNo = ActionBot.getTextWithInElement(driver, TEXTBOX_LINE_NO);
		int no = Integer.parseInt(lineNo);
		if (no != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isShortDescFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXTBOX_SHORT_DESCRIPTION);
		String shortDesc = ActionBot.getTextWithInElement(driver, TEXTBOX_SHORT_DESCRIPTION);
		if (!shortDesc.equals(null))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isProductCategoryFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXTBOX_PRODUCT_CATEGORY);
		String category = ActionBot.getTextWithInElement(driver, TEXTBOX_PRODUCT_CATEGORY);
		if (!category.equals(null))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isMarketPriceFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXTBOX_MARKET_PRICE);
		String marketPrice = ActionBot.getTextWithInElement(driver, TEXTBOX_MARKET_PRICE);
		Double price = Double.parseDouble(marketPrice);
		if (price != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isQuantityFieldFilled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXTBOX_QUANTITY);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_QUANTITY);
		int quantity = Integer.parseInt(str);
		if (quantity != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnProductCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TEXTBOX_PRODUCT_CATEGORY);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on product category");
	}

	@Override
	public void clickOnItemDetail(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, TAB_ITEM_DETAILS_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on item detail");
	}

	@Override
	public String fillFreeTextItemNo(WebDriver driver, String testCaseName, String itemNo) throws ActionBotException
	{
		ActionBot.sendKeys(driver, FREETEXT_ITEM_NO, itemNo);
		String str = ActionBot.getTextWithInElement(driver, FREETEXT_ITEM_NO);
		return str;
	}

	@Override
	public void clickOnIsGreenRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElements(driver, IS_GREEN_RADIO_BUTTON).get(1);
		ele.click();

	}

	@Override
	public void clickOnIsPreferredRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElements(driver, IS_PREFERRED_RADIO_BUTTON).get(1);
		ele.click();
	}

	@Override
	public String fillSpecificationsName(WebDriver driver, String testCaseName, String SpecificationName) throws ActionBotException
	{
		ActionBot.scroll(driver);
		WebElement element = ActionBot.findElements(driver, TEXT_BOX_SPECIFICATIONS_NAME).get(1);
		element.sendKeys(SpecificationName);
		return SpecificationName;

	}

	@Override
	public String fillSpecificationsDataKey(WebDriver driver, String testCaseName, String SpecificationsDataKey) throws ActionBotException
	{
		ActionBot.click(driver, TEXT_BOX_SPECIFICATIONS_DATA_KEY);
		WebElement ele = ActionBot.findElement(driver, TEXT_BOX_SPECIFICATIONS_DATA_KEY);
		ele.sendKeys(SpecificationsDataKey);
		return SpecificationsDataKey;

	}

	@Override
	public String fillSpecificationsDataValue(WebDriver driver, String testCaseName, String SpecificationsDataValue) throws ActionBotException
	{
		ActionBot.click(driver, TEXT_BOX_SPECIFICATIONS_DATA_KEY);
		WebElement ele = ActionBot.findElement(driver, TEXT_BOX_SPECIFICATIONS_DATA_VALUE);
		ele.sendKeys(SpecificationsDataValue);

		return SpecificationsDataValue;
	}

	@Override
	public boolean isNullSpecificationKeyIcondisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ERROR_ICON_SPECIFICATION))
		{
			return true;
		}
		return false;
	}

	@Override
	public String fillModalItemImageUrl(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_IMAGE_URL);
		element.sendKeys(url);
		return url;
	}

	@Override
	public String getSpecificationsName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String spcName = null;
		if (ActionBot.isElementDisplayed(driver, LABEL_SPECIFICATION_NAME))
		{
			spcName = ActionBot.findElement(driver, LABEL_SPECIFICATION_NAME).getText();
		}
		if (ActionBot.isElementPresent(driver, TEXT_BOX_SPECIFICATIONS_NAME))
		{
			spcName = ActionBot.findElements(driver, TEXT_BOX_SPECIFICATIONS_NAME).get(1).getText();
			return spcName;
		}

		return spcName;

	}

	@Override
	public boolean isValidUrlMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ENTER_VALID_URL_MSG))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickOnCancelBtnItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_ITEM_SUMMARY);

	}

	@Override
	public String clearAndfillShortDescription(WebDriver driver, String testCaseName, String shortDesc) throws ActionBotException
	{
		String str = null;
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_SHORT_DESCRIPTION))
		{
			ActionBot.clear(driver, TEXTBOX_SHORT_DESCRIPTION);
			ActionBot.sendKeys(driver, TEXTBOX_SHORT_DESCRIPTION, shortDesc);
			str = ActionBot.getTextWithInElement(driver, TEXTBOX_SHORT_DESCRIPTION);
		}
		return str;
	}

	@Override
	public float clearAndfillMarketPrice(WebDriver driver, String testCaseName, float marketPrice) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_MARKET_PRICE);
		ActionBot.sendKeys(driver, TEXTBOX_MARKET_PRICE, "" + marketPrice);
		String temp = ActionBot.getTextWithInElement(driver, TEXTBOX_MARKET_PRICE).trim();
		if (temp != null)
		{
			float no = Float.parseFloat(temp);
			return no;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public boolean isProductCategoryErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_PRODUCT_CATEGORY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isErrorPresentInProductCategoryValid(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String error = ActionBot.getTextWithInElement(driver, ERROR_PRODUCT_CATEGORY);
		if (error.equalsIgnoreCase("Please enter valid short description so that system can classify it."))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getChangeCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, ITEM_MODAL_CURRENCY_TYPE);
	}

	@Override
	public boolean isItemNameLenghtValidationErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TEXT_ITEM_NAME_LENGHT_VALIDATION_ERROR))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isMarketPriceErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_MARKET_PRICE_ITEM_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_QUANTITY_ITEM_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnAddNewSpecificationBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ADD_NEW_SPECIFICATION_BUTTON);

	}

	@Override
	public void clickOnZeroPriceItemCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, CHECKBOX_ZERO_PRICE_ITEM);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on zero price item");

	}

	@Override
	public void clearMaxTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.clear(driver, TEXTBOX_MAX_TOTAL_PRICE);
		ActionBot.defaultSleep();

	}

	@Override
	public void clearQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_QUANTITY);
	}

	@Override
	public float fillMaxTotalPrice(WebDriver driver, String testCaseName, float maxTotalPrice) throws ActionBotException
	{
		String totalPrice = ActionBot.sendKeys(driver, TEXTBOX_MAX_TOTAL_PRICE, Float.toString(maxTotalPrice));
		logger.info("Entered Max Total Price is : " + totalPrice);
		return Float.parseFloat(totalPrice);
	}

	@Override
	public float fillMaxUnitPrice(WebDriver driver, String testCaseName, float maxUnitPrice) throws ActionBotException
	{
		String unitPrice = ActionBot.sendKeys(driver, TEXTBOX_MAX_UNIT_PRICE, Float.toString(maxUnitPrice));
		logger.info("Entered Max Unit Price is : " + unitPrice);
		return Float.parseFloat(unitPrice);
	}

	@Override
	public String getLabelValueOfCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String labelValueOfCategory = ActionBot.getTextWithInElement(driver, LABEL_PRODUCT_CATEGORY_PO_FREE_TEXT_ITEM);
		logger.info("Category : " + labelValueOfCategory);
		return labelValueOfCategory;
	}

	@Override
	public boolean isCategoryEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_PRODUCT_CATEGORY);
	}

	@Override
	public float getUnitPriceOfItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String unitPrice = ActionBot.getTextWithInElement(driver, LABEL_UNIT_PRICE_ITEM_DETAILS_PO);
		logger.info("Unit Price : " + unitPrice);
		return Float.parseFloat(unitPrice);
	}

	@Override
	public float getMarketPriceOfItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String marketPrice = ActionBot.getAttributeOfElement(driver, TEXTBOX_MARKET_PRICE, "value");
		logger.info("Market Price : " + marketPrice);
		return Float.parseFloat(marketPrice);
	}

	@Override
	public String getCurrencyOfMarketPriceOfItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String currency = ActionBot.getTextWithInElement(driver, LABEL_CURRENCY_ITEM_DETAILS_PO);
		logger.info("Currency : " + currency);
		return currency;
	}

	@Override
	public void clickOnCancel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_CANCEL_GUIDED_ITEM_PO);
		ActionBot.defaultSleep();
	}

	@Override
	public boolean clickOnItemTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, MODAL_ITEM_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getProductCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, TEXT_PRODUCT_CATEGORY_PO);
	}

	@Override
	public String fillContractNumber(WebDriver driver, String testCaseName, String contractNumber) throws ActionBotException
	{
		ActionBot.scroll(driver, ActionBot.findElement(driver, TEXTBOX_CONTRACT_NUMBER_FREE_TEXT_ITEM));
		ActionBot.moveToElement(driver, TEXTBOX_CONTRACT_NUMBER_FREE_TEXT_ITEM);
		/*
		 * WebElement element=ActionBot.findElement(driver, TEXTBOX_CONTRACT_NUMBER_FREE_TEXT_ITEM);
		 * element.sendKeys(contractNumber);
		 */
		return ActionBot.sendKeys(driver, TEXTBOX_CONTRACT_NUMBER_FREE_TEXT_ITEM, contractNumber);
	}

	@Override
	public String fillUOM(WebDriver driver, String testCaseName, String UOM) throws ActionBotException, FactoryMethodException
	{
		String uom = null;
		uom = ActionBot.fillAutoCompleteField(driver, TEXTBOX_UOM, UOM);
		logger.info("UOM is :" + uom);
		return uom;
	}

	@Override
	public String fillLineNo(WebDriver driver, String testCaseName, int lineNo) throws ActionBotException, FactoryMethodException
	{
		String lineNO = null;
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_LINE_NO))
		{
			WebElement element = ActionBot.findElement(driver, TEXTBOX_LINE_NO);
			element.clear();
			ActionBot.defaultSleep();
			element.sendKeys(Integer.toString(lineNo));
			ActionBot.findElement(driver, TEXTBOX_LINE_NO).getAttribute("value");
		}
		return lineNO;
	}

}
