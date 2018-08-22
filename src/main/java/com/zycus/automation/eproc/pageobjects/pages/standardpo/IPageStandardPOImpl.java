package com.zycus.automation.eproc.pageobjects.pages.standardpo;

import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.modals.POFreeTextItemSummaryItem.IModalPOFreeTextItemSummaryItem;
import com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm.IPageFreeTextForm;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.IPageViewPurchaseOrder;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

public class IPageStandardPOImpl implements IPageStandardPO

{
	static Logger logger = Logger.getLogger(IPageStandardPOImpl.class);

	@Override
	public void clickOnEdit(WebDriver driver) throws ActionBotException
	{
		// ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_EDIT);
		// ActionBot.defaultSleep();
		PageRequisitionCheckOut.waitTillProgressingDivPresent(driver, "Standard PO");
	}

	@Override
	public void clickOnAddItem(WebDriver driver) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_ADD_ITEM);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnSearchItem(WebDriver driver) throws ActionBotException
	{
		ActionBot.hover(driver, BUTTON_ADD_ITEM);
		/*
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(ActionBot.findElement(driver,
		 * BUTTON_ADD_ITEM)).build().perform(); ActionBot.defaultHighSleep();
		 */
		if (!ActionBot.isElementPresent(driver, BUTTON_SEARCH_ITEM))
		{
			ActionBot.hover(driver, BUTTON_ADD_ITEM);
		}
		ActionBot.click(driver, BUTTON_SEARCH_ITEM);
		ActionBot.defaultSleep();
		ActionBot.findElement(driver, TEXTBOX_ADD_ITEMS_TO_PO);
	}

	@Override
	public String fillAddItemsToPOField(WebDriver driver, String addItemsToPOfield) throws ActionBotException
	{
		// ActionBot.clear(driver, TEXTBOX_ADD_ITEMS_TO_PO);
		ActionBot.sendKeys(driver, TEXTBOX_ADD_ITEMS_TO_PO, addItemsToPOfield);
		addItemsToPOfield = ActionBot.getTextWithInElement(driver, TEXTBOX_ADD_ITEMS_TO_PO).trim();
		return addItemsToPOfield;

	}

	@Override
	public void clickOnSearch(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SEARCH);
		// ActionBot.defaultSleep();
		ActionBot.defaultMediumSleep();
	}

	@Override
	public int enterInQuantity(WebDriver driver, int index) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='itemList_addCollpsBxPad']//tr[";
		String xpathPart2 = "]//input[@class='inptTxt itemQuantity txtItmQty txtItmQtyWithAdd addItemQuantity']";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		ActionBot.sendKeys(driver, xpath, "" + index);
		String temp = ActionBot.getTextWithInElement(driver, xpath).trim();
		if (temp != null)
		{
			int no = Integer.parseInt(temp);
			return no;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public String clickOnAdd(WebDriver driver, int index) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='itemList_addCollpsBxPad']//tr[";
		String xpathPart2 = "]//a[@class='b-button b-primary addItemButton']";
		String xpathPart3 = "]//a[@class='scLnk itmLnk itemNameHtml catalogItemName']";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		ActionBot.click(driver, xpath);
		ActionBot.waitTillPopUpIsPresent(driver, POPUP_WAIT_AFTER_ADD);
		ActionBot.defaultSleep();
		xpath = By.xpath(xpathPart1 + index + xpathPart3);

		String itemName = null;
		itemName = ActionBot.getTextWithInElement(driver, xpath).trim();
		return itemName;
	}

	@Override
	public void clickOnItemSummaryEdit(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		ActionBot.focusAndclick(driver, By.xpath(".//*[@id='item_tmp_" + itemID + "']//a[contains(@class,'edit')]"));
		PageRequisitionCheckOut.waitTillProgressingDivPresent(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "Edit Item Summary Window");
	}

	@Override
	public void clickOnExpandAll(WebDriver driver) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_EXPAND_ALL);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public List<WebElement> getListOfItemNames(WebDriver driver) throws ActionBotException
	{
		return ActionBot.findElements(driver, LABEL_ITEM_NAMES);
	}

	@Override
	public String getCostCenterInItem(WebDriver driver, String id) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='item_summary_tmp_";
		String xpathPart2 = "']//tr[@class='']//div[@class='costing']";
		By xpath = By.xpath(xpathPart1 + id + xpathPart2);
		return ActionBot.getTextWithInElement(driver, xpath);
	}

	@Override
	public String getProjectInItem(WebDriver driver, String id) throws ActionBotException
	{

		String xpathPart1 = ".//*[@id='item_summary_tmp_";
		String xpathPart2 = "']//tr[@class='']//div[@class='project']";
		By xpath = By.xpath(xpathPart1 + id + xpathPart2);
		return ActionBot.getTextWithInElement(driver, xpath);
	}

	@Override
	public String getBudgetInItem(WebDriver driver, String id) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='item_summary_tmp_";
		String xpathPart2 = "']//tr[@class='']//div[@class='budget']";
		By xpath = By.xpath(xpathPart1 + id + xpathPart2);
		return ActionBot.getTextWithInElement(driver, xpath);
	}

	@Override
	public String enterSupplierName(WebDriver driver, String supplierName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_SUPPLIER_NAME);
		supplierName = ActionBot.fillAutoCompleteField(driver, element, supplierName);
		logger.info("Entered Supplier Name : " + supplierName);
		ScreenShot.screenshot(driver, driver.getClass().getName(), "After filling supplier Name");
		return supplierName;
	}

	@Override
	public String enterSupplierAddress(WebDriver driver, String supplierAddress) throws ActionBotException
	{

		ActionBot.sendKeys(driver, TEXTBOX_SUPPLIER_ADDRESS, supplierAddress);
		supplierAddress = ActionBot.getTextWithInElement(driver, TEXTBOX_SUPPLIER_ADDRESS);
		return supplierAddress;
	}

	@Override
	public String enterPaymentTerms(WebDriver driver, String paymentTerms) throws ActionBotException
	{
		String paymentTerm = null;
		/*
		 * ActionBot.sendKeys(driver, TEXTBOX_PAYMENT_TERMS, paymentTerms);
		 * paymentTerms = ActionBot.getTextWithInElement(driver,
		 * TEXTBOX_PAYMENT_TERMS); return paymentTerms;
		 */
		/*
		 * if (ActionBot.isElementPresent(driver, TEXTBOX_PAYMENT_TERMS)) {
		 * Select select = new Select(ActionBot.findElement(driver,
		 * TEXTBOX_PAYMENT_TERMS)); if (paymentTerms != null) {
		 * select.selectByValue(paymentTerms); } else { select.selectByIndex(1);
		 * } paymentTerms = select.getFirstSelectedOption().getText().trim();
		 * logger.info("Delivery Terms : " + paymentTerms); }
		 */
		paymentTerm = ActionBot.selectElement(driver, TEXTBOX_PAYMENT_TERMS, IConstantsData.SELECT_BY_VALUE, paymentTerms);
		return paymentTerm;
	}

	@Override
	public String enterCurrencyType(WebDriver driver, String currencyType) throws ActionBotException
	{
		// ActionBot.sendKeys(driver, TEXTBOX_CURRENCY_TYPE, currencyType);
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_CURRENCY_TYPE))
		{
			currencyType = ActionBot.fillAutoCompleteField(driver, TEXTBOX_CURRENCY_TYPE, currencyType);
			logger.info("Entered Currency Type : " + currencyType);

			if (ActionBot.isElementDisplayed(driver, TEXTBOX_CURRENCY_VALUE))
			{
				enterCurrencyValue(driver, 1.0);
			}
		}
		return currencyType;
	}

	@Override
	public Double enterCurrencyValue(WebDriver driver, Double CurrencyValue) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_CURRENCY_VALUE, "" + CurrencyValue);
		String temp = ActionBot.getTextWithInElement(driver, TEXTBOX_CURRENCY_VALUE);
		if (temp != null)
		{
			Double no = Double.parseDouble(temp);
			return no;
		}
		else
		{
			return 0.0;
		}
	}

	@Override
	public String selectDeliveryTerms(WebDriver driver, String deliveryTerms) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, SELECT_DELIVERY_TERMS))
		{
			Select select = new Select(ActionBot.findElement(driver, SELECT_DELIVERY_TERMS));
			if (deliveryTerms != null)
			{
				select.selectByValue(deliveryTerms);
			}
			else
			{
				select.selectByIndex(1);
			}
			deliveryTerms = select.getFirstSelectedOption().getText().trim();
			logger.info("Delivery Terms : " + deliveryTerms);
		}
		return deliveryTerms;
	}

	@Override
	public boolean isCurrencyTypeFieldBlank(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TEXTBOX_CURRENCY_TYPE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isCurrencyValueFieldBlank(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TEXTBOX_CURRENCY_VALUE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isResultOfItemDisplayed(WebDriver driver) throws ActionBotException
	{

		String item = ActionBot.getTextWithInElement(driver, TEXTBOX_ADD_ITEMS_TO_PO);
		if (item.contains("epens"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnSubmitPOForProcessing(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on submit po for processing");
		ActionBot.click(driver, BUTTON_SUBMIT_PO_STD_PO);
		ActionBot.waitTillPopUpIsPresent(driver, SUBMIT_PO_PROCESSING_DIV);
		ActionBot.waitForPageLoad(driver);
		// ActionBot.defaultSleep();
		// ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on submit po for processing");
	}

	@Override
	public void clickOnSubmitPOForApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		//ActionBot.defaultMediumSleep();
		ActionBot.waitTillPopUpIsPresent(driver, POPUP_SUBMIT_FOR_APPROVAL);
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, BUTTON_SAVE_SUBMIT_FOR_APPROVAL))
		{
			ActionBot.click(driver, BUTTON_SAVE_SUBMIT_FOR_APPROVAL);
			// ActionBot.defaultLowSleep();
			ActionBot.waitForPageLoad(driver);
			ActionBot.waitTillPopUpIsPresent(driver, IPageStandardPO.PURCHASE_ORDER_CREATED_SUCCESS_MESSAGE);
			ActionBot.defaultMediumSleep();
		}
		// ActionBot.findElement(driver, IPageViewPurchaseOrder.VIEW_PO_NO);
		ScreenShot.screenshot(driver, testCaseName, "After submitting PO for approval");
	}

	@Override
	public String fillRequiredByDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, REQUIRED_BY_DATE_PICKER);

		// year
		Select select = new Select(ActionBot.findElement(driver, SELECT_YEAR));
		select.selectByValue(year);

		// month
		select = new Select(ActionBot.findElement(driver, SELECT_MONTH));
		select.selectByValue(month);

		// day
		ActionBot.click(driver, By.linkText(day));

		String requiredByDate = ActionBot.findElement(driver, REQUIRED_BY_DATE_PO_PAGE).getAttribute("value").trim();
		logger.info("Selected Required By Date : " + requiredByDate);
		ScreenShot.screenshot(driver, testCaseName, "After changing required by date");
		return requiredByDate;
	}

	@Override
	public String enterPurchaseType(WebDriver driver, String purchaseType) throws ActionBotException
	{

		int i = 0;
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_PURCHASE_TYPE);
		Select sel = new Select(ele);

		List<WebElement> purchase_type_list = sel.getOptions();
		for (WebElement element : purchase_type_list)
		{
			if (element.getText().trim().contains(purchaseType))
			{
				break;
			}
			i++;
		}
		if (i == purchase_type_list.size())
			sel.selectByIndex(0);
		else
			sel.selectByIndex(i);

		return sel.getFirstSelectedOption().getText().trim();
	}

	@Override
	public int enterContractNo(WebDriver driver, int contractNo) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_CONTRACT_NO))
		{
			int no = contractNo;
			ActionBot.sendKeys(driver, TEXTBOX_CONTRACT_NO, "" + contractNo);
			String temp = ActionBot.getTextWithInElement(driver, TEXTBOX_CONTRACT_NO);
			if (temp != null && Integer.parseInt(temp) == no)
			{
				no = Integer.parseInt(temp);
				//return no;
			}
			return no;

		}
		else
		{
			return 0;
		}

	}

	@Override
	public String enterOrderDescription(WebDriver driver, String orderDescription) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_ORDER_DESCRIPTION, orderDescription);
		orderDescription = ActionBot.getTextWithInElement(driver, TEXTBOX_ORDER_DESCRIPTION);
		logger.info("Entered order description : " + orderDescription);
		return orderDescription;
	}

	@Override
	public String enterBuyer(WebDriver driver, String buyer) throws ActionBotException
	{
		ActionBot.defaultSleep();
		buyer = ActionBot.fillAutoCompleteField(driver, TEXTBOX_BUYER, buyer);
		logger.info("Selected buyer : " + buyer);
		return buyer;
	}

	@Override
	public boolean isContractNoCopied(WebDriver driver) throws ActionBotException
	{
		String str = ActionBot.findElement(driver, TEXTBOX_CONTRACT_NO).getText();
		if (str.equals("12345"))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public void clickOnCatalogItem(WebDriver driver, int index) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='itemList_addCollpsBxPad']//tr[";
		String xpathPart2 = "]//a[@class='scLnk itmLnk itemNameHtml catalogItemName']";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		ActionBot.click(driver, xpath);

	}

	@Override
	public List<WebElement> getListOFSearchedItemNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> searchTexts = ActionBot.findElements(driver, SEARCH_TEXT);
		return searchTexts;
	}

	@Override
	public List<WebElement> fillQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> quantityInputs = ActionBot.findElements(driver, QUANTITY_INPUTS);
		return quantityInputs;
	}

	@Override
	public List<WebElement> getAddItemButtons(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> addButtons = ActionBot.findElements(driver, ADD_BOTTONS);
		return addButtons;
	}

	@Override
	public List<WebElement> getItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElements(driver, ITEM_NAMES_PO);
		ActionBot.defaultMediumSleep();
		return ActionBot.findElements(driver, ITEM_NAMES_PO);
	}

	@Override
	public void clickOnSaveAsDraftPo(WebDriver driver) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, SAVE_AS_DRAFT_PO);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnCancelPo(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_PO);

	}

	@Override
	public String getPONo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String poNo = null;
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_STANDARD_PO_NO))
		{
			poNo = ActionBot.getTextWithInElement(driver, TEXTBOX_STANDARD_PO_NO);
		}
		else if (ActionBot.isElementDisplayed(driver, LABEL_STANDARD_PO_NO))
		{
			poNo = ActionBot.getTextWithInElement(driver, LABEL_STANDARD_PO_NO);
		}
		logger.info("Standard PO NO : " + poNo);
		ScreenShot.screenshot(driver, testCaseName, "Standard PO No");
		return poNo;
	}

	@Override
	public void clickOnFreeTextItem(WebDriver driver) throws ActionBotException
	{
		ActionBot.hover(driver, BUTTON_ADD_ITEM);
		// ActionBot.defaultSleep();
		if (!ActionBot.isElementPresent(driver, BUTTON_FREE_TEXT_ITEM))
		{
			ActionBot.hover(driver, BUTTON_ADD_ITEM);
		}
		ActionBot.focusAndclick(driver, BUTTON_FREE_TEXT_ITEM);
		ActionBot.defaultSleep();

		if (!ActionBot.isElementPresent(driver, IModalPOFreeTextItemSummaryItem.TEXTBOX_SHORT_DESCRIPTION))
		{
			if (!ActionBot.isElementPresent(driver, BUTTON_FREE_TEXT_ITEM))
			{
				ActionBot.hover(driver, BUTTON_ADD_ITEM);
			}
			ActionBot.focusAndclick(driver, BUTTON_FREE_TEXT_ITEM);
			ActionBot.defaultSleep();
		}
	}

	@Override
	public String getCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String company = ActionBot.getTextWithInElement(driver, COMPANY_PO);
		ScreenShot.screenshot(driver, testCaseName, "Company name");
		return company;

	}

	@Override
	public String getBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String businessUnit = ActionBot.getTextWithInElement(driver, BUSINESS_UNIT_PO);
		ScreenShot.screenshot(driver, testCaseName, "Business unit name");
		return businessUnit;
	}

	@Override
	public String getLocation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String location = ActionBot.getTextWithInElement(driver, LOCATION_PO);
		ScreenShot.screenshot(driver, testCaseName, "Location name");
		return location;
	}

	@Override
	public void clickOnModify(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultHighSleep();
		ActionBot.click(driver, LINK_MODIFY_DISCOUNT);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on modify link");

	}

	@Override
	public boolean isNoTaxOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CHECKBOX_NO_TAX_APPLICABLE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isPreloadedTaxTypePresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='taxDetailCompleteBlock']//tr[";
		String xpathPart2 = "]//label[@class='dev_label dev_lblTaxType']";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		if (ActionBot.isElementPresent(driver, xpath))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isPreloadedTaxTypeNonEditable(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='taxDetailCompleteBlock']//tr[";
		String xpathPart2 = "]";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		String taxType = ActionBot.findElement(driver, xpath).getAttribute("class");
		logger.info("preloaded tax type not editable:" + taxType);
		if (taxType.equalsIgnoreCase("dev_taxTr dev_simpleTaxTr dev_renderedRow dev_notEditable"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isPreloadedTaxNamePresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		String xpathPart1 = ".//*[@id='taxDetailCompleteBlock']//tr[";
		String xpathPart2 = "]//label[@class='dev_label dev_lblTaxName']";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		if (ActionBot.isElementPresent(driver, xpath))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isPreloadedTaxNameNonEditable(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='taxDetailCompleteBlock']//tr[";
		String xpathPart2 = "]";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		String taxName = ActionBot.findElement(driver, xpath).getAttribute("class");
		if (taxName.equalsIgnoreCase("dev_taxTr dev_simpleTaxTr dev_renderedRow dev_notEditable"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isPreloadedTaxRatePresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='taxDetailCompleteBlock']//tr[";
		String xpathPart2 = "]//label[@class='dev_lblTaxRate']";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		if (ActionBot.isElementPresent(driver, xpath))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isPreloadedTaxRateNonEditable(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='taxDetailCompleteBlock']//tr[";
		String xpathPart2 = "]";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		String taxName = ActionBot.findElement(driver, xpath).getAttribute("class");
		if (taxName.equalsIgnoreCase("dev_taxTr dev_simpleTaxTr dev_renderedRow dev_notEditable"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnTaxNotApplicable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_NO_TAX_APPLICABLE);

	}

	@Override
	public void clickOnCheckBoxOfItem(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='lineItemId_chk_tmp_" + itemID + "']")))
		{
			WebElement element = ActionBot.findElement(driver, By.xpath(".//*[@id='lineItemId_chk_tmp_" + itemID + "']"));
			ActionBot.scroll(driver, element);
			ActionBot.moveToElementAndClick(driver, By.xpath(".//*[@id='lineItemId_chk_tmp_" + itemID + "']"));
		}
		else
		{
			WebElement element = ActionBot.findElement(driver, By.id("lineItemId_chk_" + itemID));
			ActionBot.scroll(driver, element);
			ActionBot.moveToElementAndClick(driver, By.id("lineItemId_chk_" + itemID));
		}
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "click on checkboxes");
	}

	@Override
	public void clickOnUpdateAllLinesLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_UPDATE_ALL_LINES);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on change multiple link");
	}

	@Override
	public boolean isTotalTaxNull(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.findElement(driver, LABEL_TOTAL_TAX).getText();
		if (str.equals("0.00000"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isItemSummaryEditPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_ITEM_SUMMARY_EDIT))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getSupplierContact(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String poContact = null;
		if (ActionBot.isElementPresent(driver, CONTACT_SUPPLIER))
		{
			// for standard po page
			poContact = ActionBot.findElement(driver, CONTACT_SUPPLIER).getAttribute("value").trim();
		}
		else
		{
			// for create invoice page
			poContact = ActionBot.findElement(driver, TEXTBOX_SUPPLIER_CONTACT).getAttribute("value").trim();
		}
		ScreenShot.screenshot(driver, testCaseName, "After getting PO contact");
		logger.info("Supplier contact :" + poContact);
		return poContact;
	}

	@Override
	public String enterRequester(WebDriver driver, String testCaseName, String requester) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_REQUESTER_PO, requester);
		ScreenShot.screenshot(driver, testCaseName, "After entering requester name");
		requester = ActionBot.getTextWithInElement(driver, TEXTBOX_REQUESTER_PO);
		return requester;
	}

	@Override
	public String getTermsAndConditions(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String termsAndCondition = ActionBot.getTextWithInElement(driver, TEXTBOX_TERMS_AND_CONDITIONS);
		ScreenShot.screenshot(driver, testCaseName, "After getting default terms and conditions");
		return termsAndCondition;
	}
	
	@Override
	public String fillTermsAndConditions(WebDriver driver, String testCaseName,String termsAndCondition) throws ActionBotException
	{
		termsAndCondition=ActionBot.sendKeys(driver, TEXTBOX_TERMS_AND_CONDITIONS, termsAndCondition);
		ScreenShot.screenshot(driver, testCaseName, "After getting default terms and conditions");
		return termsAndCondition;
	}

	@Override
	public boolean isRequireReceiptOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, RADIO_REQUIRE_RECEIPT))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String enterNotes(WebDriver driver, String testCaseName, String notes) throws ActionBotException
	{
		String str = null;
		if (notes != null)
		{
			str = ActionBot.sendKeys(driver, TEXTBOX_NOTES, notes);
		}
		else
		{
			str = ActionBot.sendKeys(driver, TEXTBOX_NOTES, "Auto Generated Notes");
		}
		return str;
	}

	@Override
	public boolean isErrorMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ERROR_PURCHASE_ORDER))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String changeCurrencyOfSupplier(WebDriver driver, String testCaseName, String changedCurrency) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_CURRENCY_TYPE);
		String previousCurrency = ActionBot.getTextWithInElement(driver, TEXTBOX_CURRENCY_TYPE);
		if (previousCurrency.equalsIgnoreCase("USD") || previousCurrency.equalsIgnoreCase("EUR"))
		{
			ScreenShot.screenshot(driver, testCaseName, "Before clearing currency");
			element.clear();
			element.sendKeys(changedCurrency);
			ActionBot.defaultSleep();
			ScreenShot.screenshot(driver, testCaseName, "After entering currency");
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.ENTER);
			ScreenShot.screenshot(driver, testCaseName, "After selecting currency");

		}
		else
		{
			element.clear();
			element.sendKeys("USD");

		}
		return changedCurrency;
	}

	@Override
	public String getCurrencyAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='taxDetailCompleteBlock']//tr[";
		String xpathPart2 = "]//label[@class='dev_label dev_lblTaxAmount']";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		ActionBot.findElement(driver, xpath);

		String str = ActionBot.getTextWithInElement(driver, xpath);
		String temp[] = StringUtils.split(str.trim(), " ");
		String currency = temp[0].trim();
		ScreenShot.screenshot(driver, testCaseName, "after receivng currency value");
		return currency;
	}

	@Override
	public void clickOnYes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_YES_PO);

	}

	@Override
	public String getDeliveryAddressOfHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String deliveryAddress = ActionBot.getTextWithInElement(driver, DELIVERY_ADDRESS_HEADER);
		ScreenShot.screenshot(driver, testCaseName, "After receivng delivery address of header");
		return deliveryAddress;
	}

	@Override
	public void clickOnCompoundTax(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, CHECKBOX_COMPOUND_TAX))
			ActionBot.click(driver, CHECKBOX_COMPOUND_TAX);
		else
			ActionBot.click(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//input[@class='inptChk dev_compoundTaxChkbx']"));
		ScreenShot.screenshot(driver, testCaseName, "After clickong on compound tax");

	}

	@Override
	public String selectTaxType(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException
	{

		/*
		 * ActionBot.click( driver,
		 * By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index +
		 * "]//select[@class='inptSlct dev_input dev_selectTaxType']"));
		 */
		/*
		 * Select select = new Select(ActionBot.findElement( driver, By.xpath(
		 * ".//*[@id='taxDetailCompleteBlock']//*[contains(@class,'dev_compoundTr')]//*[contains(@class,'dev_inputTaxType')]"
		 * )));
		 * 
		 * select.selectByVisibleText(taxType);
		 */
		// ActionBot.sendKeys(driver,
		// By.xpath(".//*[@id='taxDetailCompleteBlock']//*[contains(@class,'dev_compoundTr')]//*[contains(@class,'dev_inputTaxType')]"),
		// taxType);
		String tax_type = null;
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//*[contains(@class,'dev_inputTaxType')]"));
		ActionBot.fillAutoCompleteField(driver, ele, taxType);
		tax_type = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//*[contains(@class,'dev_inputTaxType')]"));
		ScreenShot.screenshot(driver, testCaseName, "After selecting tax type");
		logger.info("Selected compound tax type : " + tax_type);
		return tax_type;
	}

	@Override
	public String enterTaxName(WebDriver driver, String testCaseName, String taxName, int index) throws ActionBotException
	{
		String tax = null;
		WebElement ele = ActionBot.findElement(driver, By.xpath("(.//*[@id='taxDetailCompleteBlock']//*[contains(@class,'dev_txtTaxName')])[" + index + "]"));
		ele.clear();
		ActionBot.defaultSleep();
		//ele.click();
		ele.sendKeys(taxName);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		tax = ele.getAttribute("value").trim();
		ActionBot.defaultSleep();
		return tax;
	}

	@Override
	public String enterFreeTextTaxName(WebDriver driver, String testCaseName, String freeTextTaxName, int index) throws ActionBotException
	{
		ActionBot.sendKeys(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//input[contains(@class,'dev_txtTaxName')]"), freeTextTaxName);
		String str = ActionBot.findElement(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//input[contains(@class,'dev_txtTaxName')]"))
			.getAttribute("value");
		ScreenShot.screenshot(driver, testCaseName, "After entering free text tax name");
		return str;

	}

	@Override
	public Integer enterTaxRate(WebDriver driver, String testCaseName, int taxRate, int index) throws ActionBotException
	{

		ActionBot.sendKeys(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//*[contains(@class,'inptTxt taxRate dev_input dev_txtTaxRate')]"), "" + taxRate);
		ActionBot.defaultSleep();
		String temp = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//*[contains(@class,'inptTxt taxRate dev_input dev_txtTaxRate')]"));
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
	public void clickOnTaxAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//*[contains(@class,'dev_txtTaxAmount')]"));
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on compound tax amount");

	}

	@Override
	public Integer getTaxAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver,
			By.xpath(".//*[@id='taxDetailCompleteBlock']//*[contains(@class,'dev_compoundTr')]//*[contains(@class,'dev_txtTaxAmount')]"));
		String str = ActionBot.findElement(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//*[contains(@class,'dev_compoundTr')]//*[contains(@class,'dev_txtTaxAmount')]"))
			.getAttribute("value");
		if (str != null)
		{
			int no = Integer.parseInt(str);
			return no;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public void clickOnAddSimpleTax(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//a[@class='icon add actButtons dev_addTax']"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add simple tax");

	}

	@Override
	public void clickOnRemoveSimpleTax(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//*[contains(@class,'dev_removeTax')]"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on remove simple tax");

	}

	@Override
	public void clickOnAddCompoundTax(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//*[contains(@class,'dev_addTax')]"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add compound tax");

	}

	@Override
	public void clickOnRemoveCompoundTax(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//a[@class='icon remove actButtons dev_compoundAction dev_removeTax']"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on remove compound tax");

	}

	@Override
	public String getItemPriceOfItem(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='itemList_addCollpsBxPad']//tr[" + index + "]//label[@class='itmPrce']"));
		String temp[] = StringUtils.split(str.trim(), " ");
		String currencyType = temp[0].trim();
		return currencyType;

	}

	@Override
	public void compareCurrencyType(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='itemList_addCollpsBxPad']//tr[" + index + "]//label[@class='itmPrce']"));
		String temp[] = StringUtils.split(str.trim(), " ");
		String currencyType = temp[0].trim();
		String headerCurrencyType = ActionBot.getTextWithInElement(driver, TEXTBOX_CURRENCY_TYPE);
		if (!currencyType.equalsIgnoreCase(headerCurrencyType))
		{
			ActionBot.click(driver, By.xpath(".//*[@id='itemList_addCollpsBxPad']//tr[" + index + "]//a[@class='b-button b-primary addItemButton']"));

		}
		else
		{
			System.out.println("Both currency value are same");
		}

	}

	@Override
	public boolean checkForZeroTaxRateValidation(WebDriver driver, String testCaseName, int index, int taxRate) throws ActionBotException, TestCaseException
	{
		ActionBot.clear(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//input[@class='inptTxt taxRate dev_input dev_txtTaxRate']"));

		ActionBot.sendKeys(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//input[@class='inptTxt taxRate dev_input dev_txtTaxRate']"), "" + taxRate);

		ActionBot.click(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//input[@class='inptTxt qtyTxtbx dev_input dev_txtTaxAmount']"));

		if (ActionBot.isElementPresent(driver, By.xpath("(.//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//span[@class='icon inlineError qtipCss hasQtip'])[1]")))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public void hoverOnErrorIcon(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.hover(driver, By.xpath("(.//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//span[@class='icon inlineError qtipCss hasQtip'])[1]"));
		/*
		 * String str = ActionBot.findElement(driver,
		 * COMPOUND_TAX_ERROR_MESSAGE).getText(); if (str.equalsIgnoreCase(
		 * "Please enter valid non zero tax rate")) { return true; } else {
		 * return false; }
		 */
	}

	@Override
	public boolean checkForMaximumTaxRate(WebDriver driver, String testCaseName, int index, long taxRate) throws ActionBotException, TestCaseException
	{
		ActionBot.clear(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//input[@class='inptTxt taxRate dev_input dev_txtTaxRate']"));
		ActionBot.sendKeys(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//input[@class='inptTxt taxRate dev_input dev_txtTaxRate']"), "" + taxRate);

		int temp = ActionBot
			.getTextWithInElement(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//input[@class='inptTxt taxRate dev_input dev_txtTaxRate']")).length();
		if (temp == 14)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean arePredefinedTaxFieldsNonEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String taxFields = ActionBot.findElement(driver, TAX_NON_EDITABLE_FIELDS).getAttribute("class");
		if (taxFields.equalsIgnoreCase("dev_taxTr dev_simpleTaxTr dev_renderedRow dev_notEditable"))
		{
			return true;
		}
		else
		{

			return false;
		}
	}

	@Override
	public String getTotalTax(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String amount = ActionBot.getTextWithInElement(driver, LABEL_TOTAL_TAX);
		// CommonUtilities.getDecimalPriceAlongWithCurrency(amount);
		return amount;

		/*
		 * int i = 0; String str = ActionBot.getTextWithInElement(driver,
		 * LABEL_TOTAL_TAX); String temp[] = StringUtils.split(str.trim(), " ");
		 * String tax_Value = temp[1].trim();
		 * 
		 * String tax[] = StringUtils.split(tax_Value, ",");
		 * 
		 * for (i = 0; i < tax.length; i++) { String totalTax = tax_Value +
		 * tax[i]; } String totalTax = " ";
		 * 
		 * String abc[] = StringUtils.split(totalTax.trim(), "."); String xyz =
		 * abc[0].trim();
		 * 
		 * if (xyz != null) { int taxValue = Integer.parseInt(xyz); return
		 * taxValue; } else { return 0; }
		 */
	}

	@Override
	public void clickOnEditItemCopyPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_EDIT_COPY_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on edit item");

	}

	@Override
	public int getHeaderLineNo(WebDriver driver, String testCaseName, int no) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'item_tmp_')]//span[@class='lineNo'])[" + no + "]"));
		if (str != null)
		{
			int temp = Integer.parseInt(str);
			return temp;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public String enterSimpleTaxName(WebDriver driver, String testCaseName, String simpleTaxName, int index) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//*[contains(@class,'dev_txtTaxName')]"));
		ele.clear();
		ele.sendKeys(simpleTaxName);
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		String str = ele.getAttribute("value");
		ScreenShot.screenshot(driver, testCaseName, "After entering simple tax name");
		return str;
	}

	@Override
	public Double getTotalAmountWithoutSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, LABEL_TOTAL_TAX);
		if (str != null)
		{
			str = str.substring(4).replace(",", "");
			Double total = Double.parseDouble(str);
			return total;
		}
		else
		{
			return (double) 0;
		}
	}

	@Override
	public void clickOnAmendItemSummaryEdit(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, BUTTOM_AMEND_ITEM_SUMMARY_EDIT);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnCopedItemSummaryEdit(WebDriver driver, int index) throws ActionBotException
	{
		ActionBot.click(driver, BUTTOM_AMEND_ITEM_SUMMARY_EDIT);
	}

	@Override
	public void clickOnDiscountModalSaveBtm(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, DISCOUNT_MODAL_SAVE_BOTTOM);
	}

	@Override
	public void clickOnErrorMsgPopupYesButton(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_PO_NO_ERROR_MSG_POPUP);
	}

	@Override
	public void clickOnItemCopyLink(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, AMEND_ITEM_COPY_LINK);
	}

	@Override
	public void clickOnItemDeleteLink(WebDriver driver) throws ActionBotException
	{
		ActionBot.findElements(driver, DELETE_ITEM_ICON).get(0).click();
	}

	@Override
	public void clickOnItemDeleteYesPopup(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, ITEM_POPUP_DELETE_YES_BUTTON);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnModifyLink(WebDriver driver) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_MODIFY);
	}

	@Override
	public void clickOnMyDeliveryAddressRadioBtm(WebDriver driver) throws ActionBotException
	{

		ActionBot.click(driver, DELIVERY_MYADDRESS_RADIO_BTM);

	}

	@Override
	public void clickOnRequireReceiptChkbox(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementEnabled(driver, REQUIRE_RECEIPT_CHECKBOX))
		{
			ActionBot.click(driver, REQUIRE_RECEIPT_CHECKBOX);
			ActionBot.defaultSleep();
		}
		else
		{
			if (ActionBot.isElementEnabled(driver, CHECKBOX_RECEIPT_CREATION_AT_HEADER_LEVEL))
			{
				ActionBot.click(driver, CHECKBOX_RECEIPT_CREATION_AT_HEADER_LEVEL);
				{
					if (ActionBot.isElementEnabled(driver, REQUIRE_RECEIPT_CHECKBOX))
					{
						ActionBot.click(driver, REQUIRE_RECEIPT_CHECKBOX);
						ActionBot.defaultSleep();
					}
				}
			}
		}
	}

	@Override
	public void clickOnReViewPoLink(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REVIEW_PO);

	}

	@Override
	public String enterDeliveryTerms(WebDriver driver, String deliveryTerms) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_DELIVERY_TERMS, deliveryTerms);
		deliveryTerms = ActionBot.getTextWithInElement(driver, TEXTBOX_DELIVERY_TERMS);
		return deliveryTerms;
	}

	@Override
	public String fillAmendPoItemQuantity(WebDriver driver, String testCaseName, int quantity) throws ActionBotException
	{
		ActionBot.findElements(driver, AMEND_MODAL_ITEM_QUANTITY).get(0).sendKeys("" + quantity);
		String itemQuantity = ActionBot.getTextWithInElement(driver, AMEND_MODAL_ITEM_QUANTITY);
		return itemQuantity;
	}

	@Override
	public String fillAmendPoNotes(WebDriver driver, String testCaseName, String Notes) throws ActionBotException
	{
		// ActionBot.clear(driver, PO_NOTES);
		ActionBot.sendKeys(driver, PO_NOTES, Notes);
		String poNote = ActionBot.getTextWithInElement(driver, PO_NOTES);
		return poNote;
	}

	@Override
	public String fillDiscountField(WebDriver driver, String testCaseName, int rates) throws ActionBotException
	{
		ActionBot.findElement(driver, TOTAL_DISCOUNT).sendKeys("" + rates);
		String discountRates = ActionBot.getTextWithInElement(driver, TOTAL_DISCOUNT);
		return discountRates;
	}

	@Override
	public String fillPoNoWithDuplicatepoNo(WebDriver driver, String duplicatePonNo) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_STANDARD_PO_NO);
		ActionBot.sendKeys(driver, TEXTBOX_STANDARD_PO_NO, duplicatePonNo);
		String duplicate = ActionBot.getTextWithInElement(driver, TEXTBOX_STANDARD_PO_NO);
		return duplicate;
	}

	@Override
	public String fillTaxTypeRATE(WebDriver driver, String taxrate) throws ActionBotException
	{
		WebElement tax = ActionBot.findElement(driver, TAX_RATE);
		tax.sendKeys("" + taxrate);
		String taxrates = ActionBot.getTextWithInElement(driver, TAX_RATE);
		return taxrates;
	}

	@Override
	public String getAutogeneratedPoNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String generatedpoNo = ActionBot.findElement(driver, AUTO_GENERATED_DEFAULT_PO_NO).getText();
		return generatedpoNo;
	}

	@Override
	public String getDeleteConformationMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String conformationMsg = ActionBot.findElement(driver, ITEM_POPUP_DELETE_YES_BUTTON).getText();
		return conformationMsg;
	}

	@Override
	public String getDuplicatePoNoErrorMsg(WebDriver driver, String errorMsg) throws ActionBotException
	{
		String errorMsgs = ActionBot.findElement(driver, DUPLICATE_PO_NO_ERROR_MSG).getText();
		return errorMsgs;
	}

	@Override
	public List<WebElement> getListOfItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LIST_ITEM_NAMES_PO);
	}

	@Override
	public boolean isCancelLinkPresent(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CANCEL_PO))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isDeliveryDateBlank(WebDriver driver) throws ActionBotException
	{
		String getDateValue = ActionBot.findElement(driver, SET_REQUIREDBY_DATE).getText();
		if (getDateValue.isEmpty())
		{
			return true;
		}
		return false;
	}

	@Override
	public String isDeliveryDateEditable(WebDriver driver) throws ActionBotException
	{
		WebElement some_element = ActionBot.findElement(driver, SET_REQUIREDBY_DATE);
		String readonly = some_element.getAttribute("readonly");
		return readonly;
	}

	@Override
	public String fillPOChangeField(WebDriver driver, String Comments) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, PO_LEVEL_COMMENTS);
		ele.sendKeys(Comments);
		String str = ele.getAttribute("value");
		return str;

	}

	@Override
	public boolean isEditableDeliveryAddress(WebDriver driver, String address) throws ActionBotException
	{
		if (ActionBot.isElementSelected(driver, DELIVERY_OUADDRESS_RADIO_BTM))
		{

			ActionBot.click(driver, DELIVERY_MYADDRESS_RADIO_BTM);
			WebElement ele = ActionBot.findElement(driver, PO_MY_ADDRESS);
			ActionBot.click(driver, PO_MY_ADDRESS);
			ele.sendKeys(address);
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);

			return true;

		}
		return false;
	}

	@Override
	public boolean isEditableDiscountField(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TOTAL_DISCOUNT))
		{
			boolean enabled = ActionBot.findElement(driver, TOTAL_DISCOUNT).isEnabled();
			return enabled;
		}
		return false;
	}

	@Override
	public boolean isEditableDraftpoNoField(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TEXTBOX_STANDARD_PO_NO))
		{
			boolean enabled = ActionBot.findElement(driver, TEXTBOX_STANDARD_PO_NO).isEnabled();
			return enabled;
		}
		return false;
	}

	@Override
	public boolean isEditableOtherDeliveryAddress(WebDriver driver, String otheraddress) throws ActionBotException
	{
		if (!ActionBot.isElementSelected(driver, DELIVERY_OTHERADDRESS_RADIO_BTM))
		{
			ActionBot.click(driver, DELIVERY_OTHERADDRESS_RADIO_BTM);
			WebElement ele = ActionBot.findElement(driver, PO_OTHER_ADDRESSES);
			ele.sendKeys(otheraddress);
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);

			return true;

		}
		return false;
	}

	@Override
	public boolean isEditablePoNotesField(WebDriver driver, String poNotes) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PO_NOTES))
		{
			WebElement ele = ActionBot.findElement(driver, PO_NOTES);
			ele.clear();
			ele.sendKeys(poNotes);
			boolean enabled = ActionBot.findElement(driver, PO_NOTES).isEnabled();
			return enabled;
		}
		return false;
	}

	@Override
	public boolean isEditableReference(WebDriver driver, String reference) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, REFERENCE_TEXT_BOX))
		{
			ActionBot.sendKeys(driver, REFERENCE_TEXT_BOX, reference);
			boolean enabled = ActionBot.findElement(driver, REFERENCE_TEXT_BOX).isEnabled();
			return enabled;
		}
		return false;
	}

	@Override
	public boolean isEditableRequireReceiptCheckBox(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, REQUIRE_RECEIPT_CHECKBOX))
		{
			boolean enabled = ActionBot.findElement(driver, REQUIRE_RECEIPT_CHECKBOX).isEnabled();
			return enabled;
		}
		return false;
	}

	@Override
	public boolean isEditableSupplierContact(WebDriver driver, String contact) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CONTACT_SUPPLIER))
		{
			// ActionBot.click(driver, CONTACT_SUPPLIER);
			WebElement ele = ActionBot.findElement(driver, CONTACT_SUPPLIER);
			// ActionBot.click(driver, CONTACT_SUPPLIER);
			ele.clear();
			ele.sendKeys(contact);
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);
			boolean enabled = ActionBot.findElement(driver, CONTACT_SUPPLIER).isEnabled();
			return enabled;
		}
		return false;
	}

	@Override
	public boolean isEditableSupplierPaymentTerms(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_PAYMENT_TERMS))
		{
			WebElement ele = ActionBot.findElement(driver, TEXTBOX_PAYMENT_TERMS);
			Select sel = new Select(ele);
			sel.selectByIndex(2);
			boolean enabled = ActionBot.findElement(driver, TEXTBOX_PAYMENT_TERMS).isEnabled();
			return enabled;
		}
		return false;
	}

	@Override
	public boolean isEditableTaxType(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TAX_TYPE))
		{
			WebElement ele = ActionBot.findElement(driver, TAX_TYPE);
			/*
			 * Select sel = new Select(ele); sel.selectByIndex(1);
			 */
			ele.sendKeys("Sales Tax");
			ele.sendKeys(Keys.DOWN);
			ele.sendKeys(Keys.ENTER);
			boolean enabled = ActionBot.findElement(driver, TAX_TYPE).isEnabled();
			return enabled;
		}
		return false;
	}

	@Override
	public boolean isEditableTearmsAndConditonSFiled(WebDriver driver, String termsAndConditions) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PO_TERMSANDCONDITON_FIELD))
		{
			WebElement ele = ActionBot.findElement(driver, PO_TERMSANDCONDITON_FIELD);
			ele.clear();
			ele.sendKeys(termsAndConditions);
			boolean enabled = ActionBot.findElement(driver, PO_TERMSANDCONDITON_FIELD).isEnabled();
			return enabled;
		}
		return false;
	}

	@Override
	public boolean isEnabledAddTax(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, NEW_TAX_TYPE))
		{
			boolean enabled = ActionBot.findElement(driver, NEW_TAX_TYPE).isEnabled();
			return enabled;
		}
		return false;
	}

	@Override
	public boolean isQuantityErrorMessagedisplayed(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, AMEND_MODAL_QUANTITY_ERRORMSG_LABEL))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isReviewPoLinkPresent(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_REVIEW_PO))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isSaveAsDraftlinkpresent(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, SAVE_AS_DRAFT_PO))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isSubmitPoForProcessingButtomPresent(WebDriver driver) throws ActionBotException
	{
		//if (ActionBot.isElementPresent(driver, SUBMIT_PO_PROCESSING_DIV))
		if (ActionBot.isElementPresent(driver, IPageViewPurchaseOrder.BUTTON_SUBMIT_PO_FOR_PROCESSING_VIEW_PO))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isSupplierCurrencydisplayedAslabel(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, SUPPLIER_CURRENCY_LABEL))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isSupplierDeliveryTermsdisplayedAslabel(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, SUPPLIER_DELIVERY_TERMS_LABEL))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isSupplierPaymentTermsdisplayedAslabel(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, SUPPLIER_PAYMENT_TERMS_LABEL))
		{
			return true;
		}
		return false;
	}

	@Override
	public String isUOMfieldItemDetailsEditable(WebDriver driver, String UOM) throws ActionBotException
	{
		String uom = null;
		if (ActionBot.isElementPresent(driver, UOM_ITEM_DETAILS_FIELD))

		{
			WebElement ele = ActionBot.findElement(driver, UOM_ITEM_DETAILS_FIELD);
			ele.clear();
			ele.sendKeys(UOM);
			ActionBot.defaultSleep();
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);

			uom = ele.getAttribute("value").trim();

		}
		return uom;
	}

	@Override
	public void clickOnSubmitPOForProcessing(WebDriver driver) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_SUBMIT_PO_STD_PO);
		ActionBot.waitTillPopUpIsPresent(driver, SUBMIT_PO_PROCESSING_DIV);
	}

	@Override
	public String getSimpleTaxAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.findElement(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//*[@class='inptTxt qtyTxtbx dev_input dev_txtTaxAmount']")).getText();

	}

	@Override
	public String getTotalItemPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.findElement(driver, ITEM_TOTAL_PRICE_PO).getText();
		return str;
	}

	@Override
	public String getTotalDiscountAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.findElement(driver, DISCOUNTED_PRICE).getText();
		return str;
	}

	@Override
	public String getTotalAmountBeforeAddingCompoundTax(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String str = ActionBot.findElement(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//span[@class='dev_lblTaxableAmount dev_hideTaxAmount']"))
			.getText();
		return str;
	}

	@Override
	public String selectFirstSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TEXTBOX_SUPPLIER_ADDRESS);
		ActionBot.defaultSleep();

		/*
		 * Actions action = new Actions(driver);
		 * action.moveToElement(ActionBot.findElement(driver,
		 * IPageCreateCatalog.SUPPLIER_ADDRESS_SUGGESTION_LIST))
		 * .build().perform();
		 */
		ActionBot.click(driver, IPageFreeTextForm.FIRST_SUPPLIER__ADDRESS);

		String selectedSupplierAddress = ActionBot.findElement(driver, TEXTBOX_SUPPLIER_ADDRESS).getAttribute("value").trim();
		logger.info("Selected Supplier Address : " + selectedSupplierAddress);
		return selectedSupplierAddress;

	}

	@Override
	public boolean isNoItemAvailableMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, NO_ITEMS_AVAILABLE_MSG))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickOnResetlineCrossButton(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, RESET_LINE_ITEM_LEVEL_BUTTON);

	}

	@Override
	public boolean isInlineSectionpresentUnderItemGrid(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_SEARCH_ITEM))
		{
			return true;
		}
		return false;
	}

	@Override
	public String getAddedItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String Quantity = ActionBot.findElements(driver, ITEM_QUANTITY_LEVEL).get(0).getText();
		return Quantity;
	}

	@Override
	public String fillItemName(WebDriver driver, String testCaseName, String searchText) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, SEARCH_ITEM_NAME);
		ele.sendKeys(searchText);
		ActionBot.defaultMediumSleep();
		// ActionBot.findElement(driver,
		// SEARCH_ITEM_NAME).sendKeys(Keys.RETURN);
		String item_Name = ActionBot.findElement(driver, SEARCH_ITEM_NAME).getAttribute("value");
		logger.info("Entered PO No : " + item_Name);
		return item_Name;
	}

	@Override
	public String fillSupplierName(WebDriver driver, String testCaseName, String searchText) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, SEARCH_SUPPLIER_NAME);
		ele.sendKeys(searchText);
		ActionBot.defaultMediumSleep();
		ele.sendKeys(Keys.DOWN);
		ele.sendKeys(Keys.ENTER);
		// ActionBot.findElement(driver,
		// SEARCH_SUPPLIER_NAME).sendKeys(Keys.RETURN);
		String supplier_Name = ActionBot.findElement(driver, SEARCH_SUPPLIER_NAME).getAttribute("value");
		logger.info("Entered Supplier name: : " + supplier_Name);
		return supplier_Name;
	}

	@Override
	public String getFirstItemName(WebDriver driver) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, FIRST_ITEM_NAME);
	}

	@Override
	public String getFirstSupplierName(WebDriver driver) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, FIRST_SUPPLIER_NAME);
	}

	@Override
	public boolean isconvertedpricedisplayed(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_CURRENCY_VALUE))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickOnItemSubTotalShouldNotBeZeroPopUp(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, POP_UP_ITEM_SUBTOTAL_OK_BUTTON);
	}

	@Override
	public boolean getItemSubTotalShouldNotBeZeroMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, POP_UP_ITEM_SUBTOTAL_MSG))
		{
			return true;
		}
		return false;

	}

	@Override
	public boolean isPopUpForItemDiffSupplierPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, POP_UP_ITEM_DIFF_SUPPLIERS))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickOnPopItemDiffSupplierCancelLink(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, POP_UP_ITEM_DIFF_SUPPLIERS_CANCEL_LINK);

	}

	@Override
	public boolean isItemNotAddedAsFreeTextItemMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ITEM_NOT_ADDED_AS_FREE_TEXT_ITEM_MSG))
		{
			return true;
		}
		return false;

	}

	@Override
	public int getCatelogItemNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String itemNo = ActionBot.getTextWithInElement(driver, CATELOG_ITEM_NO);
		int num = Integer.parseInt(itemNo);
		return num;
	}

	@Override
	public boolean isNewFreeTextItemCreated(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.findElements(driver, CATELOG_ITEM_NO).get(1) != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<WebElement> getSupplierNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> getSupplier = ActionBot.findElements(driver, LIST_ITEM_SUPPLIER_NAME);
		return getSupplier;
	}

	@Override
	public boolean isAddItemViaFileLinkPresent(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ADD_ITEM_VIA_FILES_LINK))
		{
			return true;
		}
		return false;
	}

	@Override
	public String getTaxRate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String taxRate = ActionBot.findElement(driver, TAX_RATE).getAttribute("value");
		return taxRate;

	}

	@Override
	public void clickOnAddNewTaxType(WebDriver driver) throws ActionBotException
	{
		ActionBot.findElements(driver, NEW_TAX_TYPE).get(0).click();

	}

	@Override
	public String fillPoEformTextField(WebDriver driver, String testCaseName, String searchText) throws ActionBotException
	{
		ActionBot.sendKeys(driver, PO_EFORM_FIELD, searchText);
		return searchText;
	}

	@Override
	public String clearAndfillPoEformTextField(WebDriver driver, String testCaseName, String text) throws ActionBotException
	{
		ActionBot.clear(driver, PO_EFORM_FIELD);
		ActionBot.defaultLowSleep();
		ActionBot.sendKeys(driver, PO_EFORM_FIELD, text);
		return text;
	}

	@Override
	public String fillSupplierContractNo(WebDriver driver, String contractNo) throws ActionBotException
	{

		if (ActionBot.isElementPresent(driver, CONTACT_SUPPLIER))

		{
			WebElement ele = ActionBot.findElement(driver, CONTACT_SUPPLIER);
			ele.clear();
			ele.sendKeys(contractNo);
			ActionBot.defaultSleep();
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);

			contractNo = ele.getAttribute("value").trim();

		}
		return contractNo;
	}

	@Override
	public String getItemNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, ITEM_NO_PO);
		String itemNo = ActionBot.getTextWithInElement(driver, ITEM_NO_PO);
		logger.info("Item no is :" + itemNo);
		return itemNo;
	}

	@Override
	public Integer enterQuantityOfItem(WebDriver driver, String testCaseName, int quantity) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXTBOX_QUANTITY_COPY_PO);
		ActionBot.sendKeys(driver, TEXTBOX_QUANTITY_COPY_PO, "" + quantity);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_QUANTITY_COPY_PO);
		if (str != null)
		{
			int no = Integer.parseInt(str);
			return no;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public void clickOnAddItemInPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_ITEM_COPY_PO);
	}

	@Override
	public Integer getOrderedQuantityTotal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, By.xpath(".//*[contains(@id,'orderedQty_')]"));
		ActionBot.defaultSleep();
		String str = ActionBot.getTextWithInElement(driver, By.xpath(".//*[contains(@id,'orderedQty_')]"));
		if (str != null)
		{
			int no = Integer.parseInt(str);
			return no;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public String getPONumberAfterAmmendingPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, AUTO_GENERATED_DEFAULT_PO_NO);
		String poNo = ActionBot.getTextWithInElement(driver, AUTO_GENERATED_DEFAULT_PO_NO);
		logger.info("PO No : " + poNo);
		ActionBot.defaultSleep();
		return poNo;
	}

	@Override
	public boolean isAddCompoundTaxOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.scroll(driver, "1000");
		/*
		 * if (ActionBot.isElementPresent(driver, CHECKBOX_COMPOUND_TAX)) {
		 * return true; } else
		 */if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//input[@class='inptChk dev_compoundTaxChkbx']")))
		{

			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TEXTBOX_BUYER);

	}

	@Override
	public Double enterDecimalFormatTaxRate(WebDriver driver, String testCaseName, int index, double taxRate) throws ActionBotException
	{

		ActionBot.sendKeys(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//input[@class='inptTxt taxRate dev_input dev_txtTaxRate']"), "" + taxRate);
		String temp = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//input[@class='inptTxt taxRate dev_input dev_txtTaxRate']"));
		if (temp != null)
		{
			double no = Double.parseDouble(temp);
			return no;
		}
		else
		{
			return 0.0;
		}
	}

	@Override
	public void clickOnPOAddAttachmentLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PO_ATTACHMENTS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add PO Attachment");

	}

	@Override
	public String getLabelValueOfPOAddAttachmentLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String value = ActionBot.getTextWithInElement(driver, LINK_PO_ATTACHMENTS);
		logger.info("Label value of Add PO attachment Link : " + value);
		return value;
	}

	@Override
	public String getItemLevelTotalTax(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, TOTAL_ITEM_LEVEL_SUB_TAX);
		logger.info("Item level total tax :" + str);
		return str;
	}

	@Override
	public boolean isTaxTypeFieldHeadingPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, By.xpath("(.//*[@id='taxDetailCompleteBlock']//tr[" + index + "]/td[@class='bld'])[1]")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isTaxNameFieldHeadingPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, By.xpath("(.//*[@id='taxDetailCompleteBlock']//tr[" + index + "]/td[@class='bld'])[2]")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isTaxRateFieldHeadingPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, By.xpath("(.//*[@id='taxDetailCompleteBlock']//tr[" + index + "]/td[@class='bld'])[3]")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isTaxAmountFieldHeadingPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]/td[@class='iNum bld dev_hideTaxAmount']")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<WebElement> getItemPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Item Price");
		return ActionBot.findElements(driver, ITEM_PRICE);
	}

	@Override
	public boolean isRemoveAllTaxesOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_REMOVE_ALL_TAXES_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnRemoveAllTaxesOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.scroll(driver, "250");
		ActionBot.defaultMediumSleep();
		ActionBot.click(driver, LINK_REMOVE_ALL_TAXES_PO);
		ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testCaseName, "After removing all taxes");
	}

	@Override
	public boolean isPlusSpecificTaxesOnXLineItemsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LABEL_PLUS_SPECIFIC_TAXES_ON_X_LINE_ITEMS_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isPlusSpecificTaxesOnXLineItemsALabel(WebDriver driver, String testCaseName) throws Exception
	{
		WebElement element = ActionBot.getElement(driver, LABEL_PLUS_SPECIFIC_TAXES_ON_X_LINE_ITEMS_PO);
		String ui_attri = element.getAttribute("class");
		boolean bl = ui_attri.contains("lbl") || ui_attri.contains("LBL") ? true : false;
		return bl;
	}

	@Override
	public String getItemNetPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, NET_ITEM_PRICE_PO);
		String str = ActionBot.getTextWithInElement(driver, NET_ITEM_PRICE_PO);
		return str;
	}

	@Override
	public boolean isLabelTotalDiscountOnItemSubTotalPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LABEL_TOTAL_DISCOUNT_ON_ITEM_SUB_TOTAL))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnTaxRate(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		if (ActionBot.isElementEnabled(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//input[@class='inptTxt taxRate dev_input dev_txtTaxRate']")))
		{
			ActionBot.click(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//input[@class='inptTxt taxRate dev_input dev_txtTaxRate']"));
			ActionBot.defaultSleep();
		}

	}

	@Override
	public int enterTaxAmount(WebDriver driver, String testCaseName, int index, int taxAmount) throws ActionBotException
	{
		ActionBot.sendKeys(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//input[@class='inptTxt qtyTxtbx dev_input dev_txtTaxAmount']"), "" + taxAmount);
		ActionBot.defaultSleep();
		String str = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//input[@class='inptTxt qtyTxtbx dev_input dev_txtTaxAmount']"));
		int amount = Integer.parseInt(str);
		return amount;
	}

	@Override
	public String clearAndfillPoNo(WebDriver driver, String poNo) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_STANDARD_PO_NO);
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_STANDARD_PO_NO);
		ele.sendKeys(poNo);
		return poNo;
	}

	@Override
	public void clickOnAllItemLineCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_ALL_ITEMS_LINES_CHECKBOX);

	}

	@Override
	public boolean isDuplicateTaxesErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, DUPLICATE_TAXES_ERROR_MSG))
		{
			return true;
		}
		return false;
	}

	@Override
	public String fillSupplierContactByFirstName(WebDriver driver, String testCaseName, String firstName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, CONTACT_SUPPLIER);
		ActionBot.defaultSleep();
		ele.clear();
		ele.sendKeys(firstName);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		String contactName = ActionBot.getTextWithInElement(driver, CONTACT_SUPPLIER);
		return contactName;
	}

	@Override
	public String fillSupplierContactByLastName(WebDriver driver, String testCaseName, String lastName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, CONTACT_SUPPLIER);
		ActionBot.defaultSleep();
		ele.clear();
		ele.sendKeys(lastName);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		String contactName = ActionBot.getTextWithInElement(driver, CONTACT_SUPPLIER);
		return contactName;
	}

	@Override
	public String getCostBookingSectionDetailsAfterExpandingInfoAtHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, LABEL_COSTBOOKING_EXPAND_ALL);
		String str = ActionBot.getTextWithInElement(driver, LABEL_COSTBOOKING_EXPAND_ALL);
		return str;
	}

	@Override
	public void clickOnCollapseAll(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_COLLAPSE_ALL);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on collapse all");

	}

	@Override
	public String fillFreightCharges(WebDriver driver, String testCaseName, String freight) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.clear(driver, FREIGHT_CHARGES);
		ActionBot.sendKeys(driver, FREIGHT_CHARGES, "" + freight);
		String str = ActionBot.getTextWithInElement(driver, FREIGHT_CHARGES);
		ActionBot.defaultSleep();
		return str;
	}

	@Override
	public boolean isItemBlockPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ITEM_BLOCK))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getCurrencyValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXTBOX_CURRENCY_VALUE);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_CURRENCY_VALUE);
		return str;
	}

	@Override
	public boolean isUnitPriceExceedingToleranceErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_UNIT_PRICE_EXCEEDING_TOLERANCE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isErrorToEnterAccountingInformationPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_ENTER_ACCOUNTING_INFORMATION))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getCurrencyType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getAttributeOfElement(driver, TEXTBOX_CURRENCY_TYPE, "value");
		logger.info("Currency Type : " + str);
		ScreenShot.screenshot(driver, testCaseName, "After getting currency value");
		return str;

	}

	@Override
	public String getPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_PAYMENT_TERMS);
		Select sel = new Select(ele);
		String str = sel.getFirstSelectedOption().getText();
		// String str = ActionBot.getTextWithInElement(driver,
		// TEXTBOX_PAYMENT_TERMS);
		ScreenShot.screenshot(driver, testCaseName, "After getting payment terms");
		return str;
	}

	@Override
	public void clearCurrencyValueField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.clear(driver, TEXTBOX_CURRENCY_VALUE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clearing currency value");

	}

	@Override
	public boolean isBaseExchangrRateErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_TEXT_BASE_EXCHANGE_RATE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isEnterValidQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_VALID_QUANTITY))
		{
			return true;
		}
		else
		{

			return false;
		}
	}

	@Override
	public String fillPreviousdate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, REQUIRED_BY_DATE_PICKER);
		// year
		Select select = new Select(ActionBot.findElement(driver, SELECT_YEAR));
		select.selectByValue(year);

		// month
		select = new Select(ActionBot.findElement(driver, SELECT_MONTH));
		select.selectByValue(month);

		// day
		//
		// if (ActionBot.findElement(driver, By.linkText(day)) != null)
		// {
		try
		{
			ActionBot.click(driver, By.linkText(day));
		}
		catch (Exception e)
		{

		}

		String requiredByDate = ActionBot.findElement(driver, REQUIRED_BY_DATE_PO_PAGE).getAttribute("value").trim();
		logger.info("Selected Required By Date : " + requiredByDate);
		ScreenShot.screenshot(driver, testCaseName, "After changing required by date");
		return requiredByDate;
		// }
		// else
		// {
		// return null;
		// }
	}

	@Override
	public int clearAndfillFreightTax(WebDriver driver, String testCaseName, int Freight) throws ActionBotException
	{
		ActionBot.clear(driver, HEADER_FREIGHT_TAX);
		ActionBot.sendKeys(driver, HEADER_FREIGHT_TAX, "" + Freight);
		return Freight;
	}

	@Override
	public void clickOnItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LIST_ITEM_NAMES_PO);

	}

	@Override
	public boolean isCurrencyErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, CURRENCY_ERROR_MSG))
		{
			return true;
		}
		return false;
	}

	@Override
	public String getSupplierPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select sel = new Select(ActionBot.findElement(driver, TEXTBOX_PAYMENT_TERMS));
		String selectedPaymentTerms = sel.getFirstSelectedOption().getAttribute("value").trim();
		if (selectedPaymentTerms.trim().length() == 0)
		{
			selectedPaymentTerms = sel.getFirstSelectedOption().getAttribute("title").trim();
		}
		logger.info("Selected Payment Term : " + selectedPaymentTerms);
		return selectedPaymentTerms;
		//return ActionBot.findElement(driver, TEXTBOX_PAYMENT_TERMS).getAttribute("title");
	}

	@Override
	public void clickOnRemoveTaxBtn(WebDriver driver, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//a[@class='icon remove actButtons dev_removeTax']"));

	}

	@Override
	public boolean isRemovalTaxBtnPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='taxDetailCompleteBlock']//tr[" + index + "]//a[@class='icon remove actButtons dev_removeTax']")))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isRemovalTaxLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_REMOVE_ALL_TAXES_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String fillSearchByManufacturerName(WebDriver driver, String manufacturerName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, SEARCH_BY_MANUFACTURER_NAME_TEXT_BOX, manufacturerName);
		return manufacturerName;
	}

	@Override
	public String getIstRowManufacturerName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String manfname = ActionBot.findElement(driver, FIRST_ROW_MANUFACTURER_NAME).getText();
		return manfname;
	}

	@Override
	public void clickOnIstRowManufacturer(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, FIRST_ROW_MANUFACTURER_NAME);

	}

	@Override
	public void clickOnDeleteButton(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='item_tmp_" + itemId + "']//a[contains(@class,'deleteItem')]")))
		{
			ActionBot.click(driver, By.xpath(".//*[@id='item_tmp_" + itemId + "']//a[contains(@class,'deleteItem')]"));
		}
		else if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='item_" + itemId + "']//a[contains(@class,'deleteItem')]")))
		{
			ActionBot.click(driver, By.xpath(".//*[@id='item_" + itemId + "']//a[contains(@class,'deleteItem')]"));
		}
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Delete Button");
	}

	@Override
	public void clickOnCopyButton(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		if (itemId != null)
		{
			ActionBot.click(driver, By.xpath(".//*[@id='item_tmp_" + itemId + "']//a[contains(@class,'copyItem')]"));
		}
		else
		{
			ActionBot.click(driver, BUTTON_COPY_ITEM_PO_PAGE);
		}
	}

	@Override
	public boolean arePredefinedTaxesPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TAX_NON_EDITABLE_FIELDS))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnItemNetTotal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, NET_ITEM_PRICE_PO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on net total price of item");

	}

	@Override
	public void clearSupplierContact(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_SUPPLIER_CONTACT);
		ActionBot.defaultSleep();

	}

	@Override
	public String getSupplierContactValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_SUPPLIER_CONTACT);
		return str;
	}

	@Override
	public void clearSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.clear(driver, TEXTBOX_SUPPLIER_NAME);

	}

	@Override
	public String selectSupplierAddress(WebDriver driver, String testCaseName, String address) throws ActionBotException
	{
		ActionBot.click(driver, DROPDOWN_SUPPLIER_ADDRESS);
		ActionBot.defaultSleep();

		/*
		 * Actions action = new Actions(driver);
		 * action.moveToElement(ActionBot.findElement(driver,
		 * IPageCreateCatalog.SUPPLIER_ADDRESS_SUGGESTION_LIST))
		 * .build().perform();
		 */
		ActionBot.click(driver, SELECT_OTHER_SUPPLIER_ADDRESS);
		ActionBot.defaultSleep();

		String selectedSupplierAddress = ActionBot.findElement(driver, TEXTBOX_SUPPLIER_ADDRESS).getAttribute("value").trim();
		logger.info("Selected Supplier Address : " + selectedSupplierAddress);
		return selectedSupplierAddress;
	}

	@Override
	public void clickOnDropdownSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DROPDOWN_SUPPLIER_ADDRESS);
		ScreenShot.screenshot(driver, testCaseName, "Aftert clicking on supplier address");

	}

	@Override
	public boolean isPOContactEmailIDPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PO_CONTACT_EMAIL_ID))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnCopyItem(WebDriver driver, String testCaseName, String id) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='item_" + id + "']//a[@class='icon eCopy copyItem']"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on copy item");

	}

	@Override
	public void clickOnItemName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		if (itemId != null)
		{
			ActionBot.click(driver, By.xpath(".//a[contains(@id,'" + itemId + "')]"));
		}
		else
		{
			ActionBot.click(driver, By.xpath(".//*[contains(@id,'itemName_tmp_')]"));
		}
	}

	@Override
	public String getMarketPriceOfAddedItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.findElement(driver, By.xpath(".//*[@id='price_" + itemId + "']"));
		String marketPrice = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='price_" + itemId + "']"));
		logger.info("Market Price of Addded Item : " + marketPrice);
		return marketPrice;
	}

	@Override
	public String getChangeCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, BUDGET_HEADER_FIELD);
		ActionBot.defaultSleep();
		String currency = ActionBot.getTextWithInElement(driver, CURRENCY_FIELD_BUDGET_TOOLTIP);
		return currency;
	}

	@Override
	public boolean isAccountingDetailsPresentAftersItemExpand(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, EXPAN_ACCOUNTING_DETAILS))
		{
			return true;
		}
		return false;
	}

	@Override
	public String fillSearchSupplierForItem(WebDriver driver, String testCaseName, String supplier) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_SEARCH_SUPPLIER_FOR_ITEM);
		ele.clear();
		ActionBot.defaultSleep();
		ele.sendKeys(supplier);
		ActionBot.defaultMediumSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		String str = ele.getAttribute("value").trim();
		return str;

	}

	@Override
	public void clickOnClickHereErrorMessage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, ERROR_FOR_PURCHASE_TYPE_INACTIVE_ENTITY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on click here link");

	}

	@Override
	public void clickOnOKForClickHereError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_OK_FOR_CLICK_HERE_ERROR);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on OK");

	}

	@Override
	public boolean isValidationMapCheckErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_MESSAGE_FOR_VALIDATION_MAP_CHECK))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public String getBuyer(WebDriver driver) throws ActionBotException
	{
		String buyer = ActionBot.getAttributeOfElement(driver, TEXTBOX_BUYER, "value");
		logger.info("Buyer : " + buyer);
		return buyer;
	}

	@Override
	public boolean isDuplicateTaxErrorIconPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.hover(driver, DUPLICATE_TAXES_ERROR_ICON);
		ActionBot.defaultLowSleep();
		if (ActionBot.isElementPresent(driver, DUPLICATE_TAXES_ERROR_ICON))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getOrderDescription(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String orderDesc = ActionBot.getAttributeOfElement(driver, TEXTBOX_ORDER_DESCRIPTION, "value");
		logger.info("Order Description : " + orderDesc);
		return orderDesc;
	}

	@Override
	public String getSelectedSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String selectedSupplierName = ActionBot.getAttributeOfElement(driver, TEXTBOX_SUPPLIER_NAME, "value");
		logger.info("Selected Supplier Name : " + selectedSupplierName);
		return selectedSupplierName;
	}

	@Override
	public String getSelectedPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String selectedPurchaseType = null;
		Select select = new Select(ActionBot.findElement(driver, TEXTBOX_PURCHASE_TYPE));
		selectedPurchaseType = select.getFirstSelectedOption().getText().trim();
		return selectedPurchaseType;
	}

	@Override
	public String fillPONumber(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException
	{
		String enteredPONo = ActionBot.sendKeys(driver, TEXTBOX_STANDARD_PO_NO, poNumber);
		logger.info("Entered PO Number : " + enteredPONo);
		return enteredPONo;
	}

	@Override
	public String getAutoUpdatedTaxNameName(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.getTextWithInElement(driver, AUTO_UPDATED_TAX_NAME);
	}

	@Override
	public String getFreightCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, FREIGHT_CURRENCY);
	}

	@Override
	public int getContractNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String Cno = ActionBot.findElement(driver, TEXTBOX_CONTRACT_NO).getText();
		int cNo = Integer.parseInt(Cno);
		return cNo;

	}

	@Override
	public List<WebElement> getListOfItemLevelEditButtons(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LIST_OF_BUTTONS_ITEM_LEVEL_EDIT);
	}

	@Override
	public boolean isSubmitForApprovalWorkflowPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, POPUP_SUBMIT_FOR_APPROVAL))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnCancelOnSubmitForApprovalPopUp(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_SUBMIT_FOR_APPROVAL_WORKFLOW);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnAddItemViaFileLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, BUTTON_ADD_ITEM);
		ActionBot.defaultSleep();
		ActionBot.click(driver, ADD_ITEM_VIA_FILES_LINK);

	}

	@Override
	public boolean isInvalidFileFormatErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, INVALID_FILE_FORMAT_ERROR_MSG))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isAlertAddItemToContinuePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ALERT_MESSAGE_TO_ADD_ITEM_TO_SUBMIT))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getAlertMessageOfAddItemToContinue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, ALERT_MESSAGE_TO_ADD_ITEM_TO_SUBMIT);
		ScreenShot.screenshot(driver, testCaseName, "After the alert popup is displayed");
		return str;
	}

	@Override
	public boolean isEditableCommentsFields(WebDriver driver, String Comments) throws ActionBotException
	{

		if (ActionBot.isElementPresent(driver, PO_LEVEL_COMMENTS))
		{
			ActionBot.scroll(driver, "250");
			WebElement ele = ActionBot.findElement(driver, PO_LEVEL_COMMENTS);
			ActionBot.defaultSleep();
			ele.clear();
			ele.sendKeys(Comments);
			boolean enabled = ActionBot.findElement(driver, PO_LEVEL_COMMENTS).isEnabled();
			return enabled;
		}
		return false;

	}

	@Override
	public boolean isPOChangeCommentFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PO_LEVEL_COMMENTS))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isInvalidFileFormatPop_upDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, INVALID_FILE_FORMAT_ERROR_POP_UP))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isItemNameMissingMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ITEM_NAME_MISSING_MSG_DISPLAYED))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isProductCatagoryMissingMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ITEM_PRODUCT_CATAGORY_MISSING))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isUnitPriceMissingMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, UNIT_PRICE_MISSING_MSG_DISPLAYED))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isUoMMissingMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, UOM_MISSING_MSG_DISPLAYED))
		{
			return true;
		}
		return false;
	}

	@Override
	public String getItemSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, LABEL_ITEM_SUPPLIER_NAME);
		return ActionBot.getTextWithInElement(driver, LABEL_ITEM_SUPPLIER_NAME);
	}

	@Override
	public String getInvalidCheckoutBuyerText(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, POPUP_INVALID_CHECKOUT_BUYER);
		ActionBot.defaultSleep();
		return str;
	}

	@Override
	public boolean isInvalidCheckoutBuyerPopupPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, POPUP_INVALID_CHECKOUT_BUYER))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isItempopUpDuplicateLineErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ITEM_UPLOAD_DULICATE_LINE_NO_MSG))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isPurchaseTypeErroMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, PURCHASE_TYPE_ERROR_MSG))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isDeleteItemDisabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String value = ActionBot.findElement(driver, DELETE_ITEM_ICON).getAttribute("class");
		return value.toLowerCase().contains(IConstantsData.disableMe.toLowerCase());
	}

	@Override
	public boolean isDiffDeliveryDateErroMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, DIFF_DELIVERY_DATE_ERROR_MSG))
		{

			return true;
		}
		return false;
	}

	@Override
	public void clickOnItemExpandCostbookingEdit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ITEM_EXPAND_COSTBOOKING_EDIT);

	}

	@Override
	public boolean isTaxDisplayedAsLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LABEL_AUTOMATICALLY_APPLY_TAX))
		{
			return true;
		}
		return false;
	}

	@Override
	public String getHeaderPoTotal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String poTotal = null;
		poTotal = ActionBot.getTextWithInElement(driver, HEADER_PO_TOTAL);
		logger.info("Header level po total :" + poTotal);
		return poTotal;
	}

	@Override
	public String getHeaderCcPoTotal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, HEADER_COST_CENTER);
		ActionBot.defaultLowSleep();
		return ActionBot.getTextWithInElement(driver, HEADER_CC_QTIP);
	}

	@Override
	public String getItemlevelTax(WebDriver driver) throws ActionBotException
	{
		String tax = null;
		tax = ActionBot.getTextWithInElement(driver, TAX_ITEM_GRID);
		logger.info("Item level tax :" + tax);
		return tax;
	}

	@Override
	public boolean isMaxNoItemErrorMasgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, MORE_THAN_25_ITEM_ERROR_MSG))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickOnOkMoreItemAlertPopUp(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, MAX_ITEM_ALERT_OK_BTN);

	}

	@Override
	public void clickOnErrorModalCloseBtn(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CLOSE_ERROR_DETAILS_ON_UPLOAD_DATA_VIA_FILE);

	}

	@Override
	public void clickOnDefineBuyingScopeLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DEFINE_BUYING_SCOPE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on define buying scope");
	}

	@Override
	public boolean isQuantityExceedingMaxValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> ele = ActionBot.findElements(driver, ERROR_QUANTITY_EXCEEDING_MAX_VALUE);
		boolean flag = false;
		for (WebElement e : ele)
		{
			if (e.isDisplayed())
			{
				flag = true;
			}

		}
		return flag;
	}

	@Override
	public String getReleaseNoError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String error = ActionBot.getTextWithInElement(driver, LABEL_RELEASE_NO_ERROR);
		logger.info("Release No Error : " + error);
		return error;
	}

	@Override
	public void clickOnItemUsingItemName(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, By.xpath(".//a[text()='" + itemName + "']"));
		ActionBot.scroll(driver, element);
		ActionBot.moveToElementAndClick(driver, By.xpath(".//a[text()='" + itemName + "']"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on items");
		ActionBot.defaultSleep();
	}

	@Override
	public String fillReleaseNo(WebDriver driver, String testCaseName, String releaseNo) throws ActionBotException
	{
		String enteredReleaseNo = ActionBot.sendKeys(driver, TEXTBOX_RELEASE_NO, releaseNo);
		logger.info("Entered Release No : " + enteredReleaseNo);
		return enteredReleaseNo;
	}

	@Override
	public String getValueOfLabelReleaseNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String releaseNo = ActionBot.getTextWithInElement(driver, LABEL_RELEASE_NO);
		logger.info("Release No : " + releaseNo);
		return releaseNo;
	}

	@Override
	public boolean isLabelReleaseNoPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABEL_RELEASE_NO);
	}

	@Override
	public String fillOrderDescription(WebDriver driver, String testCaseName, String orderDescription) throws ActionBotException
	{
		String orderDesc = ActionBot.sendKeys(driver, TEXTBOX_ORDER_DESCRIPTION, orderDescription);
		logger.info("Entered Order Description : " + orderDesc);
		ScreenShot.screenshot(driver, testCaseName, "After filling Order Desc");
		return orderDesc;
	}

	@Override
	public void clickOnAddItemFromRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, BUTTON_ADD_ITEM);
		if (!ActionBot.isElementPresent(driver, LINK_ADD_ITEMS_FROM_REQUISITION))
		{
			ActionBot.hover(driver, BUTTON_ADD_ITEM);
		}
		ActionBot.click(driver, LINK_ADD_ITEMS_FROM_REQUISITION);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnCopyButtonUsingItemName(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		if (itemName != null)
		{
			ActionBot.click(driver, By.xpath(".//*[.//*[contains(text(),'" + itemName + "')]]//a[contains(@class,'copyItem')]"));
		}
		else
		{
			ActionBot.click(driver, BUTTON_COPY_ITEM_PO_PAGE);
		}
	}

	@Override
	public void clickOnEditItemSummaryButtonUsingItemName(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(xpath1_editItemSummary + itemName + xpath2_editItemSummary));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on edit item summary");
	}

	@Override
	public void clickOnMarkForAddingApprovers(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, CHECKBOX_MARK_FOR_ADDING_APPROVERS_IN_PO);

	}

	@Override
	public String getPOTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String poTotal = ActionBot.getTextWithInElement(driver, NET_ITEM_PRICE_PO);
		logger.info("PO Total Price : " + poTotal);
		return poTotal;
	}

	@Override
	public String getBudgetExhaustedError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String error = ActionBot.getTextWithInElement(driver, ERROR_MSG_BUDGET_EXHAUSTED_ON_PO);
		logger.info("Budget Exhausted Message : " + error);
		return error;
	}

	@Override
	public String getBudgetLineForBudgetExhaustedError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String budgetLine = ActionBot.getTextWithInElement(driver, LABEL_BUDGET_LINE_FOR_BUDGET_EXHAUSTED_ON_PO);
		logger.info("Budget Line Name for Exhausted Budget : " + budgetLine);
		return budgetLine;
	}

	@Override
	public boolean isBudgetExhaustedErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, ERROR_MSG_BUDGET_EXHAUSTED_ON_PO);
	}

	@Override
	public boolean isErrorMsgPresentForPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, ERROR_MSG_ON_PO);
	}

	@Override
	public String getErrorMsgOnAlertBoxPresentForPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Alert Message");
		String errorMsg = ActionBot.getTextWithInElement(driver, ERROR_MSG_ON_ALERT_POP_UP_FOR_PO);
		logger.info("Error msg on alert po up : " + errorMsg);
		return errorMsg;
	}

	@Override
	public String getItemUnitPrice(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		String unitPrice = ActionBot.getTextWithInElement(driver, By.xpath(".//tr[.//*[text()='" + itemName + "']]//*[@class='price']"));
		logger.info("Unit Price : " + unitPrice);
		return unitPrice;
	}

	@Override
	public String getItemUOM(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		String uom = ActionBot.getTextWithInElement(driver, By.xpath(".//tr[.//*[text()='" + itemName + "']]//*[contains(@class,'unitOfMeasure')]"));
		logger.info("UOM : " + uom);
		return uom;
	}

	@Override
	public boolean isItemPresentUsingItemName(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, By.xpath(".//a[text()='" + itemName + "']"));
	}

	@Override
	public String getSelectedDeliveryTerm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_DELIVERY_TERMS));
		String selectedDeliveryTerm = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Delivery Term : " + selectedDeliveryTerm);
		return selectedDeliveryTerm;
	}

	@Override
	public String getSupplierCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String currency = null;
		if (ActionBot.isElementPresent(driver, LABEL_SUPPLIER_CURRENCY))
		{
			currency = ActionBot.getTextWithInElement(driver, LABEL_SUPPLIER_CURRENCY);
			logger.info("Supplier Currency : " + currency);
		}
		return currency;
	}

	@Override
	public boolean isSupplierCurrencyEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_CURRENCY_TYPE);
	}

	@Override
	public String getSupplierDeliveryTermFromLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String deliveryTerm = ActionBot.getTextWithInElement(driver, SUPPLIER_DELIVERY_TERMS_LABEL);
		logger.info("Delivery Term : " + deliveryTerm);
		return deliveryTerm;
	}

	@Override
	public boolean isSelectSupplierDeliveryTermPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, SELECT_DELIVERY_TERMS);
	}

	@Override
	public boolean isNextPaginationPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, PAGINATION_NEXT_ITEM_SEARCH_PO);
	}

	@Override
	public void clickOnNextPagination(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PAGINATION_NEXT_ITEM_SEARCH_PO);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public String getCurrencyOfItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		String marketPrice = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='price_tmp_" + itemId + "']"));
		logger.info("Market Price of Addded Item : " + marketPrice);
		String[] temp = StringUtils.split(marketPrice, " ");
		logger.info("Item Currency : " + temp[0].trim());
		return temp[0].trim();
	}

	@Override
	public boolean isPurchaseTypePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag = ActionBot.isElementPresent(driver, TEXTBOX_PURCHASE_TYPE) ? true : false;
		ScreenShot.screenshot(driver, testCaseName, "After checking visibility of purchase type");
		return flag;
	}

	@Override
	public void clickLinkCreateNewAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CREATE_NEW_ADDRESS_PO_SUMMARY);

	}

	@Override
	public String fillCustomAddressName(WebDriver driver, String testCaseName, String newAddress) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.sendKeys(driver, NEW_ADDRESS_NAME, newAddress);
		return newAddress;
	}

	@Override
	public String fillCustomAddressStreet1(WebDriver driver, String testCaseName, String newStreet1) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.sendKeys(driver, NEW_ADDRESS_STREET_NAME, newStreet1);
		return newStreet1;
	}

	@Override
	public void fillCustomAddressCountry(WebDriver driver, String testCaseName, String newCountry) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.selectElement(driver, NEW_ADDRESS_COUNTRY_NAME, IConstantsData.SELECT_BY_INDEX, newCountry);
	}

	@Override
	public String fillCustomAddressCity(WebDriver driver, String testCaseName, String newCity) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.sendKeys(driver, TEXTBOX_CITY_PO_SUMMARY, newCity);
		return newCity;
	}

	@Override
	public boolean clickAddressChangeButtonYes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "before clicking Yes");
		if (ActionBot.isElementPresent(driver, BUTTON_POPUP_ADDRESS_CHANGED_YES))
		{
			ActionBot.click(driver, BUTTON_POPUP_ADDRESS_CHANGED_YES);
			ScreenShot.screenshot(driver, testCaseName, "After clicking Yes for change Address");
			return true;
		}
		else
			return false;
	}

	@Override
	public void selectOtherAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DELIVERY_OTHERADDRESS_RADIO_BTM);
		WebElement ele = ActionBot.findElement(driver, PO_OTHER_ADDRESSES);
		ele.sendKeys("");
		ActionBot.waitForElementToBeDisplayed(driver, PO_OTHER_ADDRESSES, Integer.parseInt(ConfigProperty.getConfig("defaultHighSleep")));
		ScreenShot.screenshot(driver, testCaseName, "After other addresses are displayed");
		//ActionBot.defaultSleep();
		/*
		 * ele.sendKeys(Keys.ARROW_DOWN); ele.sendKeys(Keys.ENTER);
		 */
		Actions act = new Actions(driver);
		act.moveToElement(ele).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		ScreenShot.screenshot(driver, testCaseName, "After selecting other address");
	}

	@Override
	public String fillSupplieremailId(WebDriver driver, String testCaseName, String testData) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, EMAIL_SUPPLIER);
		ActionBot.defaultSleep();
		ele.clear();
		ele.sendKeys(testData);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		String contactName = ActionBot.getTextWithInElement(driver, EMAIL_SUPPLIER);
		return contactName;
	}

	@Override
	public void clickOnSubmitPOForProcessingStandardPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on submit po for processing");
		ActionBot.click(driver, BUTTON_SUBMIT_PO_STD_PO);
		ActionBot.waitTillPopUpIsPresent(driver, SUBMIT_PO_PROCESSING_DIV);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on submit po for processing");
	}

	@Override
	public void clickOnPopItemDiffSupplierOkLink(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, POP_UP_ITEM_DIFF_SUPPLIERS_OK_LINK);

	}

	@Override
	public String getItemSubTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXT_ITEM_SUB_TOTAL))
			return ActionBot.getTextWithInElement(driver, TEXT_ITEM_SUB_TOTAL);
		return null;
	}

	@Override
	public String getItemSubTotalPriceIndexWise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		int count = 1;
		List<String> headers = ActionBot.getListOfText(driver, By.xpath(ITEM_TABLE_HEADER_PO_VIEW.getValue() + "//th"));
		for (String header : headers)
		{
			if (header.equalsIgnoreCase(IConstantsData.Item_Sub_Total_Price))
				break;
			count++;
		}
		return ActionBot.getTextWithInElement(driver, By.xpath(ITEM_TABLE_HEADER_PO_VIEW.getValue() + "//tr[" + index + "]//td[" + count + "]"));

	}

	@Override
	public String getCompanyDefaultCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TEXT_COMPANY_CURRENCY))
			return ActionBot.getTextWithInElement(driver, TEXT_COMPANY_CURRENCY);
		return null;
	}

	@Override
	public String getSupplierEmailId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierEmailId = null;
		if (ActionBot.isElementPresent(driver, EMAIL_SUPPLIER))
		{
			// for standard po page
			supplierEmailId = ActionBot.findElement(driver, EMAIL_SUPPLIER).getAttribute("value").trim();
		}
		logger.info("Supplier email id is " + supplierEmailId);
		ScreenShot.screenshot(driver, testCaseName, "After getting supplier EmailId");
		return supplierEmailId;
	}

	@Override
	public String fillTaxType(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException
	{
		String TaxType = null;
		WebElement element = ActionBot.findElement(driver, By.xpath(TAX_TYPE.getValue() + "[" + index + "]"));
		TaxType = ActionBot.fillAutoCompleteField(driver, element, taxType);
		logger.info("Tax type is : " + TaxType);
		return TaxType;
	}

	@Override
	public String getAmountAtCostBookingAfterExpanAll(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String amount = null;
		amount = ActionBot.getTextWithInElement(driver, AMOUNT_AT_COST_BOOKING_AFTER_EXPAND_ALL);
		logger.info("Amount at cost booking after expand all : " + amount);
		return amount;
	}

	@Override
	public String getAmountAtAccountingAfterExpanAll(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String amount = null;
		amount = ActionBot.getTextWithInElement(driver, AMOUNT_AT_ACCOUNTING_AFTER_EXPAND_ALL);
		logger.info("Amount at accounting after expand all : " + amount);
		return amount;
	}

	@Override
	public boolean isBlankAccountingErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, ACCOUNTING_ERROR_BLANK);
		return ActionBot.isElementPresent(driver, ACCOUNTING_ERROR_BLANK);
	}

	@Override
	public String getFirstAddedItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, PO_FIRST_ADDED_ITEM);
	}

	@Override
	public String fillCurrencyExchangeRate(WebDriver driver, String testCaseName, int exchangeRate) throws ActionBotException, FactoryMethodException
	{
		String currencyrate = null;
		ActionBot.findElement(driver, CURRENCY_EXCHANGE_RATE).sendKeys(Integer.toString(exchangeRate));
		currencyrate = ActionBot.findElement(driver, CURRENCY_EXCHANGE_RATE).getAttribute("value");

		return currencyrate;
	}

	@Override
	public void deleteItemByItemId(WebDriver driver, String testCaseName, String itemId) throws FactoryMethodException, ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='item_" + itemId + "']//*[contains(@class,'deleteItem')]")))
		{
			ActionBot.findElement(driver, By.xpath(".//*[@id='item_" + itemId + "']//*[contains(@class,'deleteItem')]")).click();
		}
	}

	@Override
	public boolean isDeliveryMyAddressRadioButtonEnabled(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		return ActionBot.isElementEnabled(driver, DELIVERY_MYADDRESS_RADIO_BTM);
	}

	@Override
	public String getSubTotalTax(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, TAX_SUB_TOTAL);
	}

	@Override
	public String getTaxRateIndexWise(WebDriver driver, String testCaseName, int index) throws FactoryMethodException, ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, TAX_RATE);
		return elements.get(index - 1).getAttribute("value");
	}

	@Override
	public boolean isSupplierAddressEditable(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		return ActionBot.findElement(driver, TEXTBOX_SUPPLIER_ADDRESS).isEnabled();
	}

	@Override
	public String getItemContractNumber(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, ITEM_CONTRACT_NUMBER_PAGE_PO);
	}

	@Override
	public boolean checkInvalidAmountError(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, INVALID_AMOUNT_ERROR);
	}

}
