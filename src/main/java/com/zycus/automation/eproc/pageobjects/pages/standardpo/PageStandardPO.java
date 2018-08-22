package com.zycus.automation.eproc.pageobjects.pages.standardpo;

import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.exception.ItemException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

public class PageStandardPO
{
	static Logger logger = Logger.getLogger(IPageStandardPO.class);

	public static List<WebElement> Additem(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getAddItemButtons(driver, testCaseName);
	}

	public static List<WebElement> getSupplierNames(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getSupplierNames(driver, testCaseName);
	}

	public static String clickOnAdd(WebDriver driver, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.clickOnAdd(driver, index);
	}

	public static void clickOnAddItem(WebDriver driver) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnAddItem(driver);
	}

	public static void clickOnItemSubTotalShouldNotBeZeroPopUp(WebDriver driver) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnItemSubTotalShouldNotBeZeroPopUp(driver);
	}

	public static void clickOnOkMoreItemAlertPopUp(WebDriver driver) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnOkMoreItemAlertPopUp(driver);
	}

	public static void clickOnAmendItemSummaryEdit(WebDriver driver) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnAmendItemSummaryEdit(driver);
	}

	public static void clickOnItemExpandCostbookingEdit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnItemExpandCostbookingEdit(driver, testCaseName);
	}

	public static void clickOnCancelPo(WebDriver driver) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnCancelPo(driver);
	}

	public static void clickOnPopItemDiffSupplierCancelLink(WebDriver driver) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnPopItemDiffSupplierCancelLink(driver);
	}

	public static void clickOnPopItemDiffSupplierOkLink(WebDriver driver) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnPopItemDiffSupplierOkLink(driver);
	}

	public static void clickOnCatalogItem(WebDriver driver, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnCatalogItem(driver, index);
	}

	public static void clickOnCopedItemSummaryEdit(WebDriver driver, int index) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnCopedItemSummaryEdit(driver, index);
	}

	public static void clickOnDiscountModalSaveBtm(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnDiscountModalSaveBtm(driver);
	}

	public static void clickOnEdit(WebDriver driver) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnEdit(driver);
	}

	public static void clickOnErrorMsgPopupYesButton(WebDriver driver) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnErrorMsgPopupYesButton(driver);
	}

	public static void clickOnExpandAll(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnExpandAll(driver);
	}

	public static void clickOnFreeTextItem(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnFreeTextItem(driver);
	}

	public static void clickOnItemCopyLink(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnItemCopyLink(driver);
	}

	public static void clickOnResetlineCrossButton(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnResetlineCrossButton(driver);
	}

	public static void clickOnItemDeleteLink(WebDriver driver) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnItemDeleteLink(driver);
	}

	public static void clickOnItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnItemName(driver, testCaseName);
	}

	public static void clickOnItemDeleteYesPopup(WebDriver driver) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnItemDeleteYesPopup(driver);
	}

	public static void clickOnItemSummaryEdit(WebDriver driver, String testCaseName, String itemID) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnItemSummaryEdit(driver, testCaseName, itemID);
	}

	public static void clickOnModifyLink(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnModifyLink(driver);
	}

	public static void clickOnMyDeliveryAddressRadioBtm(WebDriver driver) throws ActionBotException

	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnMyDeliveryAddressRadioBtm(driver);
	}

	public static void clickOnRequireReceiptChkbox(WebDriver driver) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnRequireReceiptChkbox(driver);
	}

	public static void clickOnReViewPoLink(WebDriver driver) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnReViewPoLink(driver);

	}

	public static void clickOnSaveAsDraftPo(WebDriver driver) throws ActionBotException

	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnSaveAsDraftPo(driver);
	}

	public static void clickOnSearch(WebDriver driver) throws ActionBotException

	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnSearch(driver);
	}

	public static void clickOnSearchItem(WebDriver driver) throws ActionBotException
	{

		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		iPageStandardPOImpl.clickOnSearchItem(driver);
	}

	public static void clickOnSubmitPOForProcessing(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{

		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnSubmitPOForProcessing(driver, testCaseName);

	}

	public static void clickOnSubmitPOForApproval(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnSubmitPOForApproval(driver, testCaseName);
	}

	public static void clickOnSubmitPOForProcessing(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnSubmitPOForProcessing(driver);
	}

	public static String enterBuyer(WebDriver driver, String buyer) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterBuyer(driver, buyer);
	}

	public static String getBuyer(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getBuyer(driver);
	}

	public static int enterContractNo(WebDriver driver, int contractNo) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterContractNo(driver, contractNo);
	}

	public static String enterCurrencyType(WebDriver driver, String currencyType) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterCurrencyType(driver, currencyType);
	}

	public static String fillSearchByManufacturerName(WebDriver driver, String manufacturerName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillSearchByManufacturerName(driver, manufacturerName);
	}

	public static Double enterCurrencyValue(WebDriver driver, Double currencyValue) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterCurrencyValue(driver, currencyValue);
	}

	public static String selectDeliveryTerms(WebDriver driver, String deliveryTerms) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.selectDeliveryTerms(driver, deliveryTerms);
	}

	public static int enterInQuantity(WebDriver driver, int index) throws ActionBotException, FactoryMethodException

	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterInQuantity(driver, index);
	}

	public static String enterOrderDescription(WebDriver driver, String orderDescription) throws ActionBotException, FactoryMethodException

	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterOrderDescription(driver, orderDescription);
	}

	public static String enterPaymentTerms(WebDriver driver, String paymentTerms) throws ActionBotException, FactoryMethodException

	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterPaymentTerms(driver, paymentTerms);
	}

	public static String enterPurchaseType(WebDriver driver, String purchaseType) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterPurchaseType(driver, purchaseType);
	}

	public static String enterSupplierAddress(WebDriver driver, String supplierAddress) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterSupplierAddress(driver, supplierAddress);
	}

	public static String enterSupplierName(WebDriver driver, String supplierName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterSupplierName(driver, supplierName);
	}

	public static String fillAddItemsToPOField(WebDriver driver, String addItemsToPOfield) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		return iPageStandardPOImpl.fillAddItemsToPOField(driver, addItemsToPOfield);
	}

	public static String fillSupplierName(WebDriver driver, String testCaseName, String searchText) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		return iPageStandardPOImpl.fillSupplierName(driver, testCaseName, searchText);
	}

	public static String fillItemName(WebDriver driver, String testCaseName, String searchText) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		return iPageStandardPOImpl.fillItemName(driver, testCaseName, searchText);
	}

	public static String getFirstSupplierName(WebDriver driver) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		return iPageStandardPOImpl.getFirstSupplierName(driver);
	}

	public static int getCatelogItemNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		return iPageStandardPOImpl.getCatelogItemNo(driver, testCaseName);
	}

	public static String fillAmendPoItemQuantity(WebDriver driver, String testCaseName, int quantity) throws ActionBotException

	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		return iPageStandardPOImpl.fillAmendPoItemQuantity(driver, testCaseName, quantity);

	}

	public static String fillAmendPoNotes(WebDriver driver, String testCaseName, String Notes) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillAmendPoNotes(driver, testCaseName, Notes);
	}

	public static String getFirstItemName(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getFirstItemName(driver);
	}

	public static String fillDiscountField(WebDriver driver, String testCaseName, int rates) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillDiscountField(driver, testCaseName, rates);
	}

	public static String fillPoNoWithDuplicatepoNo(WebDriver driver, String duplicatePonNo) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		return iPageStandardPOImpl.fillPoNoWithDuplicatepoNo(driver, duplicatePonNo);
	}

	public static List<WebElement> fillQuantity(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillQuantity(driver, testCaseName);
	}

	public static String fillRequiredByDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		String reqDate = null;
		try
		{
			IPageStandardPO checkout = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
			reqDate = checkout.fillRequiredByDate(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectRequiredByDate " + e, e);
		}
		return reqDate;
	}

	public static String fillPreviousdate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException
	{
		String reqDate = null;
		try
		{
			IPageStandardPO checkout = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
			reqDate = checkout.fillPreviousdate(driver, testCaseName, "" + day, "" + month, "" + year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPreviousdate " + e, e);
		}
		return reqDate;
	}

	public static String fillTaxTypeRATE(WebDriver driver, String taxrate) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillTaxTypeRATE(driver, taxrate);
	}

	public static String clearAndfillPoNo(WebDriver driver, String poNo) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.clearAndfillPoNo(driver, poNo);
	}

	public static String getAutogeneratedPoNo(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getAutogeneratedPoNo(driver, testCaseName);
	}

	public static String getBudgetInItem(WebDriver driver, String id) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getBudgetInItem(driver, id);
	}

	public static String getConformationMsg(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		return iPageStandardPOImpl.getDeleteConformationMsg(driver, testCaseName);
	}

	public static String getTaxRate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		return iPageStandardPOImpl.getTaxRate(driver, testCaseName);
	}

	public static String getCostCenterInItem(WebDriver driver, String id) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getCostCenterInItem(driver, id);
	}

	public static String getDuplicatePoNoErrorMsg(WebDriver driver, String duplicatePonNo) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		return iPageStandardPOImpl.getDuplicatePoNoErrorMsg(driver, duplicatePonNo);
	}

	public static String getItemId(WebDriver driver, String itemName) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		String tempId = null;
		for (WebElement element : iPageStandardPO.getListOfItemNames(driver))
		{
			String itemNameFromUI = element.getText().trim();
			if (itemNameFromUI.equalsIgnoreCase(itemName))
			{
				tempId = element.getAttribute("id").trim();
				break;
			}
		}
		if (tempId == null)
		{
			for (WebElement element : ActionBot.findElements(driver, By.xpath(".//*[contains(@class,'poItemLink')]")))
			{
				String itemNameFromUI = element.getText().trim();
				if (itemNameFromUI.equalsIgnoreCase(itemName))
				{
					tempId = element.getAttribute("data-line-item-id").trim();
					break;
				}
			}
		}
		String[] st = null;
		String itemId = null;
		if (tempId.contains("tmp_"))
		{
			st = StringUtils.split(tempId, "itemName_tmp_");
			//itemId = st[1].trim();
			itemId = st[0].trim();
		}
		else
		{
			if (tempId.indexOf("_") != -1)
			{
				st = StringUtils.split(tempId, "_");
				itemId = st[1].trim();
				//itemId = st[0].trim();
			}
			else
				itemId = tempId;
		}
		return itemId;

	}

	public static String getItemId(WebDriver driver, String testCaseName, String searchText) throws ActionBotException, ItemException
	{
		String itemId = null;
		try
		{
			IPageStandardPO iPageStandardPo = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
			ActionBot.defaultSleep();
			List<WebElement> itemNameElement = iPageStandardPo.getItemName(driver, testCaseName);
			logger.info("@@@@@@@@@@@@ List Size : " + itemNameElement.size());
			for (WebElement item : itemNameElement)
			{
				String itemName = item.getText().trim();
				if (itemName.equalsIgnoreCase(searchText.trim()))
				{
					itemId = item.getAttribute("id");
					String temp[] = itemId.split("_");
					itemId = "";
					if (temp.length > 2)
					{
						itemId = temp[2].trim();
					}
					else if (temp.length <= 2)
					{
						itemId = temp[1].trim();
					}
				}

			}
			logger.info("Item Id : " + itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemId " + e, e);
		}
		return itemId;
	}

	public static List<WebElement> getItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> itemNames = null;
		try
		{
			IPageStandardPO iPageStandardPo = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
			itemNames = iPageStandardPo.getItemName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemName " + e, e);
		}
		return itemNames;

	}

	public static List<WebElement> getListOfItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		return iPageStandardPOImpl.getListOfItems(driver, testCaseName);
	}

	public static String getPONo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		return iPageStandardPOImpl.getPONo(driver, testCaseName);
	}

	public static String getProjectInItem(WebDriver driver, String id) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getProjectInItem(driver, id);
	}

	public static boolean isCancelLinkPresent(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isCancelLinkPresent(driver);
	}

	public static boolean isContractNoCopied(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isContractNoCopied(driver);
	}

	public static boolean isCurrencyTypeFieldBlank(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isCurrencyTypeFieldBlank(driver);
	}

	public static boolean isCurrencyValueFieldBlank(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isCurrencyValueFieldBlank(driver);
	}

	public static boolean isDeliveryDateBlank(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isDeliveryDateBlank(driver);
	}

	public static boolean isInvalidFileFormatErrorMsgDisplayed(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isInvalidFileFormatErrorMsgDisplayed(driver, testCaseName);
	}

	public static boolean isAccountingDetailsPresentAftersItemExpand(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isAccountingDetailsPresentAftersItemExpand(driver);
	}

	public static String isDeliveryDateEditable(WebDriver driver) throws ActionBotException
	{
		IPageStandardPOImpl iPageStandardPOImpl = FactoryPage.getInstanceOfStandardPO();
		return iPageStandardPOImpl.isDeliveryDateEditable(driver);
	}

	public static String fillPOChangeField(WebDriver driver, String Comments) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillPOChangeField(driver, Comments);
	}

	public static boolean isEditableDeliveryAddress(WebDriver driver, String address) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isEditableDeliveryAddress(driver, address);
	}

	public static boolean isPopUpForItemDiffSupplierPresent(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isPopUpForItemDiffSupplierPresent(driver, testCaseName);
	}

	public static boolean getItemSubTotalShouldNotBeZeroMsg(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getItemSubTotalShouldNotBeZeroMsg(driver, testCaseName);
	}

	public static boolean isEditableDiscountField(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isEditableDiscountField(driver);
	}

	public static boolean isEditableDraftpoNoField(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isEditableDraftpoNoField(driver);
	}

	public static boolean isInvalidFileFormatPop_upDisplayed(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isInvalidFileFormatPop_upDisplayed(driver, testCaseName);
	}

	public static boolean isEditableOtherDeliveryAddress(WebDriver driver, String otheraddress) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isEditableOtherDeliveryAddress(driver, otheraddress);
	}

	public static boolean isInlineSectionpresentUnderItemGrid(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isInlineSectionpresentUnderItemGrid(driver, testCaseName);
	}

	public static boolean isEditablePoNotesField(WebDriver driver, String poNotes) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isEditablePoNotesField(driver, poNotes);
	}

	public static boolean isEditableReference(WebDriver driver, String reference) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isEditableReference(driver, reference);
	}

	public static boolean isEditableRequireReceiptCheckBox(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isEditableRequireReceiptCheckBox(driver);
	}

	public static boolean isEditableSupplierContact(WebDriver driver, String contact) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isEditableSupplierContact(driver, contact);
	}

	public static boolean isEditableSupplierPaymentTerms(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isEditableSupplierPaymentTerms(driver);
	}

	public static boolean isEditableTaxType(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isEditableTaxType(driver);
	}

	public static boolean isEditableTearmsAndConditonSFiled(WebDriver driver, String termsAndConditions) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isEditableTearmsAndConditonSFiled(driver, termsAndConditions);
	}

	public static boolean isEnabledAddTax(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isEnabledAddTax(driver);
	}

	public static boolean isQuantityErrorMessagedisplayed(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isQuantityErrorMessagedisplayed(driver);
	}

	public static boolean isResultOfItemDisplayed(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isResultOfItemDisplayed(driver);
	}

	public static boolean isReviewPoLinkPresent(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isReviewPoLinkPresent(driver);
	}

	public static boolean isSaveAsDraftlinkpresent(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isSaveAsDraftlinkpresent(driver);
	}

	public static boolean isSubmitPoForProcessingButtomPresent(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isSubmitPoForProcessingButtomPresent(driver);
	}

	public static boolean isSupplierCurrencydisplayedAslabel(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isSupplierCurrencydisplayedAslabel(driver);
	}

	public static boolean isSupplierDeliveryTermsdisplayedAslabel(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isSupplierDeliveryTermsdisplayedAslabel(driver);
	}

	public static boolean isSupplierPaymentTermsdisplayedAslabel(WebDriver driver) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isSupplierPaymentTermsdisplayedAslabel(driver);
	}

	public static String isUOMfieldItemDetailsEditable(WebDriver driver, String UOM) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isUOMfieldItemDetailsEditable(driver, UOM);
	}

	public static String getCompany(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getCompany(driver, testCaseName);
	}

	public static String getBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getBusinessUnit(driver, testCaseName);
	}

	public static String getLocation(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getLocation(driver, testCaseName);
	}

	public static String getHeaderPoTotal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getHeaderPoTotal(driver, testCaseName);
	}

	public static void clickOnModify(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnModify(driver, testCaseName);
	}

	public static boolean isNoTaxOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isNoTaxOptionPresent(driver, testCaseName);
	}

	public static boolean isPreloadedTaxTypePresent(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isPreloadedTaxTypePresent(driver, testCaseName, index);
	}

	public static boolean isPreloadedTaxTypeNonEditable(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isPreloadedTaxTypeNonEditable(driver, testCaseName, index);
	}

	public static boolean isItemNotAddedAsFreeTextItemMsg(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isItemNotAddedAsFreeTextItemMsg(driver, testCaseName);
	}

	public static boolean isPreloadedTaxNamePresent(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isPreloadedTaxNamePresent(driver, testCaseName, index);
	}

	public static boolean isPreloadedTaxNameNonEditable(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isPreloadedTaxNameNonEditable(driver, testCaseName, index);
	}

	public static boolean isPreloadedTaxRatePresent(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isPreloadedTaxRatePresent(driver, testCaseName, index);
	}

	public static boolean isPreloadedTaxRateNonEditable(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isPreloadedTaxRateNonEditable(driver, testCaseName, index);
	}

	public static void clickOnTaxNotApplicable(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnTaxNotApplicable(driver, testCaseName);
	}

	public static void clickOnCheckBoxOfItem(WebDriver driver, String testCaseName, String itemID) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnCheckBoxOfItem(driver, testCaseName, itemID);
	}

	public static void clickOnUpdateAllLinesLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnUpdateAllLinesLink(driver, testCaseName);
	}

	public static boolean isTotalTaxNull(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isTotalTaxNull(driver, testCaseName);
	}

	public static boolean isItemSummaryEditPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isItemSummaryEditPresent(driver, testCaseName);
	}

	public static String getSupplierContact(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getSupplierContact(driver, testCaseName);
	}

	public static String enterRequester(WebDriver driver, String testCaseName, String requester) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterRequester(driver, testCaseName, requester);
	}

	public static String getTermsAndConditions(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getTermsAndConditions(driver, testCaseName);
	}
	
	public static String fillTermsAndConditions(WebDriver driver, String testCaseName,String termsAndCondtions) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillTermsAndConditions(driver, testCaseName,termsAndCondtions);
	}

	public static boolean isRequireReceiptOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isRequireReceiptOptionPresent(driver, testCaseName);
	}

	public static boolean isconvertedpricedisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isconvertedpricedisplayed(driver);
	}

	public static String enterNotes(WebDriver driver, String testCaseName, String notes) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterNotes(driver, testCaseName, notes);
	}

	public static boolean isErrorMessageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isErrorMessageDisplayed(driver, testCaseName);
	}

	public static boolean isNoItemAvailableMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isNoItemAvailableMsgDisplayed(driver, testCaseName);
	}

	public static String changeCurrencyOfSupplier(WebDriver driver, String testCaseName, String changedCurrency) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.changeCurrencyOfSupplier(driver, testCaseName, changedCurrency);
	}

	public static String getCurrencyAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getCurrencyAmount(driver, testCaseName, index);
	}

	public static void clickOnYes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnYes(driver, testCaseName);
	}

	public static String getDeliveryAddressOfHeader(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getDeliveryAddressOfHeader(driver, testCaseName);
	}

	public static String getChangeCurrency(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getChangeCurrency(driver, testCaseName);
	}

	public static void clickOnCompoundTax(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnCompoundTax(driver, testCaseName);
	}

	public static void clickOnAllItemLineCheckBox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnAllItemLineCheckBox(driver, testCaseName);
	}

	public static String selectTaxType(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.selectTaxType(driver, testCaseName, taxType, index);
	}

	public static String enterTaxName(WebDriver driver, String testCaseName, String taxName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterTaxName(driver, testCaseName, taxName, index);
	}

	public static String enterFreeTextTaxName(WebDriver driver, String testCaseName, String freeTextTaxName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterFreeTextTaxName(driver, testCaseName, freeTextTaxName, index);
	}

	public static Integer enterTaxRate(WebDriver driver, String testCaseName, int taxRate, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterTaxRate(driver, testCaseName, taxRate, index);
	}

	public static void clickOnTaxAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException

	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnTaxAmount(driver, testCaseName, index);
	}

	public static Integer getTaxAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getTaxAmount(driver, testCaseName, index);
	}

	public static String getAddedItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getAddedItemQuantity(driver, testCaseName);
	}

	public static String fillPoEformTextField(WebDriver driver, String testCaseName, String searchText) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillPoEformTextField(driver, testCaseName, searchText);
	}

	public static String clearAndfillPoEformTextField(WebDriver driver, String testCaseName, String text) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.clearAndfillPoEformTextField(driver, testCaseName, text);
	}

	public static String fillSupplierContractNo(WebDriver driver, String testCaseName, String contractNo) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillSupplierContractNo(driver, contractNo);
	}

	public static int clearAndfillFreightTax(WebDriver driver, String testCaseName, int Freight) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.clearAndfillFreightTax(driver, testCaseName, Freight);
	}

	public static void clickOnAddSimpleTax(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnAddSimpleTax(driver, testCaseName, index);
	}

	public static void clickOnRemoveTaxBtn(WebDriver driver, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnRemoveTaxBtn(driver, index);
	}

	public static void clickOnRemoveSimpleTax(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnRemoveSimpleTax(driver, testCaseName, index);
	}

	public static void clickOnAddCompoundTax(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnAddCompoundTax(driver, testCaseName, index);
	}

	public static void clickOnAddNewTaxType(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnAddNewTaxType(driver);
	}

	public static void clickOnRemoveCompoundTax(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnRemoveCompoundTax(driver, testCaseName, index);
	}

	public static void compareCurrencyType(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnRemoveCompoundTax(driver, testCaseName, index);
	}

	public static boolean checkForZeroTaxRateValidation(WebDriver driver, String testCaseName, int index, int taxRate)
		throws ActionBotException, TestCaseException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.checkForZeroTaxRateValidation(driver, testCaseName, index, taxRate);
	}

	public static void hoverOnErrorIcon(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.hoverOnErrorIcon(driver, testCaseName, index);
	}

	public static boolean isNewFreeTextItemCreated(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isNewFreeTextItemCreated(driver, testCaseName);
	}

	public static boolean checkForMaximumTaxRate(WebDriver driver, String testCaseName, int index, long taxRate)
		throws ActionBotException, TestCaseException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.checkForMaximumTaxRate(driver, testCaseName, index, taxRate);
	}

	public static boolean isRemovalTaxBtnPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException, TestCaseException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isRemovalTaxBtnPresent(driver, testCaseName, index);
	}

	public static boolean arePredefinedTaxFieldsNonEditable(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.arePredefinedTaxFieldsNonEditable(driver, testCaseName);
	}

	public static String getTotalTax(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getTotalTax(driver, testCaseName);
	}

	public static void clickOnEditItemCopyPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnEditItemCopyPO(driver, testCaseName);
	}

	public static int getHeaderLineNo(WebDriver driver, String testCaseName, int no) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getHeaderLineNo(driver, testCaseName, no);
	}

	public static String enterSimpleTaxName(WebDriver driver, String testCaseName, String simpleTaxName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterSimpleTaxName(driver, testCaseName, simpleTaxName, index);
	}

	public static Double getTotalAmountWithoutSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getTotalAmountWithoutSupplier(driver, testCaseName);
	}

	public static String getSimpleTaxAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getSimpleTaxAmount(driver, testCaseName, index);
	}

	public static String getFreightCurrency(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getFreightCurrency(driver, testCaseName);
	}

	public static String getTotalItemPrice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getTotalItemPrice(driver, testCaseName);
	}

	public static String getTotalDiscountAmount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getTotalDiscountAmount(driver, testCaseName);
	}

	public static String getTotalAmountBeforeAddingCompoundTax(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getTotalAmountBeforeAddingCompoundTax(driver, testCaseName, index);
	}

	public static String selectFirstSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.selectFirstSupplierAddress(driver, testCaseName);
	}

	public static boolean isAddItemViaFileLinkPresent(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isAddItemViaFileLinkPresent(driver);
	}

	public static String getItemNo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getItemNo(driver, testCaseName);
	}

	public static Integer enterQuantityOfItem(WebDriver driver, String testCaseName, int quantity) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterQuantityOfItem(driver, testCaseName, quantity);
	}

	public static void clickOnAddItemInPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnAddItemInPO(driver, testCaseName);
	}

	public static Integer getOrderedQuantityTotal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getOrderedQuantityTotal(driver, testCaseName);
	}

	public static String getPONumberAfterAmmendingPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getPONumberAfterAmmendingPO(driver, testCaseName);
	}

	public static boolean isAddCompoundTaxOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isAddCompoundTaxOptionPresent(driver, testCaseName);
	}

	public static void clickOnBuyer(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnBuyer(driver, testCaseName);
	}

	public static Double enterDecimalFormatTaxRate(WebDriver driver, String testCaseName, int index, double taxRate) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterDecimalFormatTaxRate(driver, testCaseName, index, taxRate);
	}

	public static void clickOnPOAddAttachmentLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnPOAddAttachmentLink(driver, testCaseName);
	}

	public static String getLabelValueOfPOAddAttachmentLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getLabelValueOfPOAddAttachmentLink(driver, testCaseName);
	}

	public static String getItemLevelTotalTax(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getItemLevelTotalTax(driver, testCaseName);
	}

	public static boolean isTaxTypeFieldHeadingPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isTaxTypeFieldHeadingPresent(driver, testCaseName, index);
	}

	public static boolean isTaxNameFieldHeadingPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isTaxNameFieldHeadingPresent(driver, testCaseName, index);
	}

	public static boolean isTaxRateFieldHeadingPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isTaxRateFieldHeadingPresent(driver, testCaseName, index);
	}

	public static boolean isTaxAmountFieldHeadingPresent(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isTaxAmountFieldHeadingPresent(driver, testCaseName, index);
	}

	public static boolean isDuplicateTaxesErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isDuplicateTaxesErrorMsgDisplayed(driver, testCaseName);
	}

	public static List<WebElement> getItemPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
			return iPageStandardPO.getItemPrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemPrice " + e, e);
		}
		return null;
	}

	public static boolean isRemoveAllTaxesOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isRemoveAllTaxesOptionPresent(driver, testCaseName);
	}

	public static void clickOnRemoveAllTaxesOption(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnRemoveAllTaxesOption(driver, testCaseName);
	}

	public static boolean isPlusSpecificTaxesOnXLineItemsPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isPlusSpecificTaxesOnXLineItemsPresent(driver, testCaseName);
	}

	public static boolean isPlusSpecificTaxesOnXLineItemsALabel(WebDriver driver, String testCaseName) throws Exception
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isPlusSpecificTaxesOnXLineItemsALabel(driver, testCaseName);
	}

	public static boolean isCurrencyErrorMsgDisplayed(WebDriver driver, String testCaseName) throws Exception
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isCurrencyErrorMsgDisplayed(driver, testCaseName);
	}

	public static String getItemNetPrice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getItemNetPrice(driver, testCaseName);
	}

	public static String getSupplierPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getSupplierPaymentTerms(driver, testCaseName);
	}

	public static String getIstRowManufacturerName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getIstRowManufacturerName(driver, testCaseName);
	}

	public static boolean isLabelTotalDiscountOnItemSubTotalPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isLabelTotalDiscountOnItemSubTotalPresent(driver, testCaseName);
	}

	public static boolean isRemovalTaxLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isRemovalTaxLinkPresent(driver, testCaseName);
	}

	public static void clickOnTaxRate(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnTaxRate(driver, testCaseName, index);
	}

	public static void clickOnIstRowManufacturer(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnIstRowManufacturer(driver);
	}

	public static int enterTaxAmount(WebDriver driver, String testCaseName, int index, int taxAmount) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.enterTaxAmount(driver, testCaseName, index, taxAmount);
	}

	public static String fillSupplierContactByFirstName(WebDriver driver, String testCaseName, String firstName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillSupplierContactByFirstName(driver, testCaseName, firstName);
	}

	public static String fillSupplierContactByLastName(WebDriver driver, String testCaseName, String lastName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillSupplierContactByLastName(driver, testCaseName, lastName);
	}

	public static String getCostBookingSectionDetailsAfterExpandingInfoAtHeader(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getCostBookingSectionDetailsAfterExpandingInfoAtHeader(driver, testCaseName);
	}

	public static void clickOnCollapseAll(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnCollapseAll(driver, testCaseName);
	}

	public static String fillFreightCharges(WebDriver driver, String testCaseName, String freight) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillFreightCharges(driver, testCaseName, freight);
	}

	public static boolean isItemBlockPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isItemBlockPresent(driver, testCaseName);
	}

	public static String getCurrencyValue(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getCurrencyValue(driver, testCaseName);
	}

	public static boolean isUnitPriceExceedingToleranceErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isUnitPriceExceedingToleranceErrorPresent(driver, testCaseName);
	}

	public static boolean isErrorToEnterAccountingInformationPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isErrorToEnterAccountingInformationPresent(driver, testCaseName);
	}

	public static String getCurrencyType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getCurrencyType(driver, testCaseName);
	}

	public static String getPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getPaymentTerms(driver, testCaseName);
	}

	public static void clearCurrencyValueField(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clearCurrencyValueField(driver, testCaseName);
	}

	public static boolean isBaseExchangrRateErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isBaseExchangrRateErrorPresent(driver, testCaseName);
	}

	public static boolean isEnterValidQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isEnterValidQuantityErrorPresent(driver, testCaseName);
	}

	public static void clickOnDeleteButton(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnDeleteButton(driver, testCaseName, itemId);
	}

	public static void clickOnCopyButton(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnCopyButton(driver, testCaseName, itemId);
	}

	public static List<WebElement> getListOFSearchedItemNames(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getListOFSearchedItemNames(driver, testCaseName);
	}

	public static boolean arePredefinedTaxesPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.arePredefinedTaxesPresent(driver, testCaseName);
	}

	public static void clickOnItemNetTotal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnItemNetTotal(driver, testCaseName);
	}

	public static void clearSupplierContact(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clearSupplierContact(driver, testCaseName);
	}

	public static String getSupplierContactValue(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getSupplierContactValue(driver, testCaseName);
	}

	public static void clearSupplierName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clearSupplierName(driver, testCaseName);
	}

	public static String selectSupplierAddress(WebDriver driver, String testCaseName, String address) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.selectSupplierAddress(driver, testCaseName, address);
	}

	public static void clickOnDropdownSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnDropdownSupplierAddress(driver, testCaseName);
	}

	public static boolean isPOContactEmailIDPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isPOContactEmailIDPresent(driver, testCaseName);
	}

	public static void clickOnCopyItem(WebDriver driver, String testCaseName, String id) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnCopyItem(driver, testCaseName, id);
	}

	public static void clickOnItemName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnItemName(driver, testCaseName, itemId);
	}

	public static String getMarketPriceOfAddedItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getMarketPriceOfAddedItem(driver, testCaseName, itemId);
	}

	public static String fillSearchSupplierForItem(WebDriver driver, String testCaseName, String supplier) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillSearchSupplierForItem(driver, testCaseName, supplier);
	}

	public static void clickOnClickHereErrorMessage(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnClickHereErrorMessage(driver, testCaseName);
	}

	public static void clickOnOKForClickHereError(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnOKForClickHereError(driver, testCaseName);
	}

	public static boolean isValidationMapCheckErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isValidationMapCheckErrorPresent(driver, testCaseName);
	}

	public static boolean isDuplicateTaxErrorIconPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isDuplicateTaxErrorIconPresent(driver, testCaseName);
	}

	public static String getOrderDescription(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getOrderDescription(driver, testCaseName);
	}

	public static String getSelectedSupplierName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getSelectedSupplierName(driver, testCaseName);
	}

	public static String getAutoUpdatedTaxNameName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getAutoUpdatedTaxNameName(driver, testCaseName);
	}

	public static int getContractNo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getContractNo(driver, testCaseName);
	}

	public static String getSelectedPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getSelectedPurchaseType(driver, testCaseName);
	}

	public static String fillPONumber(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillPONumber(driver, testCaseName, poNumber);
	}

	public static List<WebElement> getListOfItemLevelEditButtons(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getListOfItemLevelEditButtons(driver, testCaseName);
	}

	public static boolean isSubmitForApprovalWorkflowPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isSubmitForApprovalWorkflowPresent(driver, testCaseName);
	}

	public static void clickOnCancelOnSubmitForApprovalPopUp(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnCancelOnSubmitForApprovalPopUp(driver, testCaseName);
	}

	public static void clickOnAddItemViaFileLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnAddItemViaFileLink(driver, testCaseName);
	}

	public static void clickOnErrorModalCloseBtn(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnErrorModalCloseBtn(driver);
	}

	public static boolean isAlertAddItemToContinuePresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isAlertAddItemToContinuePresent(driver, testCaseName);
	}

	public static boolean isDeleteItemDisabled(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isDeleteItemDisabled(driver, testCaseName);
	}

	public static String getAlertMessageOfAddItemToContinue(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getAlertMessageOfAddItemToContinue(driver, testCaseName);
	}

	public static String getHeaderCcPoTotal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getHeaderCcPoTotal(driver, testCaseName);
	}

	public static String getItemlevelTax(WebDriver driver) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getItemlevelTax(driver);
	}

	public static boolean isEditableCommentsFields(WebDriver driver, String Comments) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isEditableCommentsFields(driver, Comments);
	}

	public static boolean isPOChangeCommentFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isPOChangeCommentFieldPresent(driver, testCaseName);
	}

	public static boolean isItemNameMissingMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isItemNameMissingMsgDisplayed(driver, testCaseName);
	}

	public static boolean isProductCatagoryMissingMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isProductCatagoryMissingMsgDisplayed(driver, testCaseName);
	}

	public static boolean isUnitPriceMissingMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isUnitPriceMissingMsgDisplayed(driver, testCaseName);
	}

	public static boolean isUoMMissingMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isUoMMissingMsgDisplayed(driver, testCaseName);
	}

	public static String getItemSupplierName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getItemSupplierName(driver, testCaseName);
	}

	public static String getInvalidCheckoutBuyerText(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getInvalidCheckoutBuyerText(driver, testCaseName);
	}

	public static boolean isInvalidCheckoutBuyerPopupPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isInvalidCheckoutBuyerPopupPresent(driver, testCaseName);
	}

	public static boolean isItempopUpDuplicateLineErrorMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isItempopUpDuplicateLineErrorMsgDisplayed(driver, testCaseName);
	}

	public static boolean isPurchaseTypeErroMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isPurchaseTypeErroMsgDisplayed(driver, testCaseName);
	}

	public static boolean isDiffDeliveryDateErroMsgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isDiffDeliveryDateErroMsgDisplayed(driver, testCaseName);
	}

	public static boolean isTaxDisplayedAsLabel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isTaxDisplayedAsLabel(driver, testCaseName);
	}

	public static boolean isMaxNoItemErrorMasgDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isMaxNoItemErrorMasgDisplayed(driver, testCaseName);
	}

	public static void clickOnDefineBuyingScopeLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnDefineBuyingScopeLink(driver, testCaseName);
	}

	public static boolean isQuantityExceedingMaxValue(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isQuantityExceedingMaxValue(driver, testCaseName);
	}

	public static String getReleaseNoError(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getReleaseNoError(driver, testCaseName);
	}

	public static void clickOnItemUsingItemName(WebDriver driver, String testCaseName, String itemName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnItemUsingItemName(driver, testCaseName, itemName);
	}

	public static String fillReleaseNo(WebDriver driver, String testCaseName, String releaseNo) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillReleaseNo(driver, testCaseName, releaseNo);
	}

	public static String getValueOfLabelReleaseNo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getValueOfLabelReleaseNo(driver, testCaseName);
	}

	public static boolean isLabelReleaseNoPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isLabelReleaseNoPresent(driver, testCaseName);
	}

	public static String fillOrderDescription(WebDriver driver, String testCaseName, String orderDescription) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillOrderDescription(driver, testCaseName, orderDescription);
	}

	public static void clickOnAddItemFromRequisition(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnAddItemFromRequisition(driver, testCaseName);
	}

	public static void clickOnCopyButtonUsingItemName(WebDriver driver, String testCaseName, String itemName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnCopyButtonUsingItemName(driver, testCaseName, itemName);
	}

	public static void clickOnEditItemSummaryButtonUsingItemName(WebDriver driver, String testCaseName, String itemName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnEditItemSummaryButtonUsingItemName(driver, testCaseName, itemName);
	}

	public static void clickOnMarkForAddingApprovers(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnMarkForAddingApprovers(driver, testCaseName);
	}

	public static String getPOTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getPOTotalPrice(driver, testCaseName);
	}

	public static String getBudgetExhaustedError(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getBudgetExhaustedError(driver, testCaseName);
	}

	public static String getBudgetLineForBudgetExhaustedError(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getBudgetLineForBudgetExhaustedError(driver, testCaseName);
	}

	public static boolean isBudgetExhaustedErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isBudgetExhaustedErrorPresent(driver, testCaseName);
	}

	public static boolean isErrorMsgPresentForPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isErrorMsgPresentForPO(driver, testCaseName);
	}

	public static String getErrorMsgOnAlertBoxPresentForPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getErrorMsgOnAlertBoxPresentForPO(driver, testCaseName);
	}

	public static String getItemUnitPrice(WebDriver driver, String testCaseName, String itemName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getItemUnitPrice(driver, testCaseName, itemName);
	}

	public static String getItemUOM(WebDriver driver, String testCaseName, String itemName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getItemUOM(driver, testCaseName, itemName);
	}

	public static boolean isItemPresentUsingItemName(WebDriver driver, String testCaseName, String itemName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isItemPresentUsingItemName(driver, testCaseName, itemName);
	}

	public static String getSelectedDeliveryTerm(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getSelectedDeliveryTerm(driver, testCaseName);
	}

	public static String getSupplierCurrency(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getSupplierCurrency(driver, testCaseName);
	}

	public static boolean isSupplierCurrencyEditable(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isSupplierCurrencyEditable(driver, testCaseName);
	}

	public static String getSupplierDeliveryTermFromLabel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getSupplierDeliveryTermFromLabel(driver, testCaseName);
	}

	public static boolean isSelectSupplierDeliveryTermPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isSelectSupplierDeliveryTermPresent(driver, testCaseName);
	}

	public static boolean isNextPaginationPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isNextPaginationPresent(driver, testCaseName);
	}

	public static void clickOnNextPagination(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnNextPagination(driver, testCaseName);
	}

	public static String getCurrencyOfItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getCurrencyOfItem(driver, testCaseName, itemId);
	}

	public static boolean isPurchaseTypePresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isPurchaseTypePresent(driver, testCaseName);
	}

	public static void clickLinkCreateNewAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickLinkCreateNewAddress(driver, testCaseName);
	}

	public static String fillCustomAddressName(WebDriver driver, String testCaseName, String newAddress) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillCustomAddressName(driver, testCaseName, newAddress);
	}

	public static String fillCustomAddressStreet1(WebDriver driver, String testCaseName, String newStreet1) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillCustomAddressStreet1(driver, testCaseName, newStreet1);
	}

	public static void fillCustomAddressCountry(WebDriver driver, String testCaseName, String newCountry) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.fillCustomAddressCountry(driver, testCaseName, newCountry);
	}

	public static String fillCustomAddressCity(WebDriver driver, String testCaseName, String newCity) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillCustomAddressCity(driver, testCaseName, newCity);
	}

	public static boolean clickAddressChangeButtonYes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.clickAddressChangeButtonYes(driver, testCaseName);
	}

	public static void selectOtherAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.selectOtherAddress(driver, testCaseName);
	}

	public static String fillSupplieremailId(WebDriver driver, String testCaseName, String testData) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillSupplieremailId(driver, testCaseName, testData);
	}

	/**
	 * @author omkar.jagdale
	 *         method for submitting the standard po
	 * 
	 */
	public static void clickOnSubmitPOForProcessingStandardPO(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{

		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.clickOnSubmitPOForProcessingStandardPO(driver, testCaseName);

	}

	/**
	 * @author omkar.jagdale
	 *         method for get item sub total
	 * 
	 */
	public static String getItemSubTotal(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{

		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getItemSubTotalPrice(driver, testCaseName);

	}

	/**
	 * @author omkar.jagdale
	 *         method for get item sub total price indexwise
	 */
	public static String getItemSubTotalPriceIndexWise(WebDriver driver, String testCaseName, int index) throws FactoryMethodException, ActionBotException
	{

		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getItemSubTotalPriceIndexWise(driver, testCaseName, index);

	}

	/**
	 * @author omkar.jagdale
	 *         method to get company default currency.
	 */
	public static String getCompanyDefaultCurrency(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{

		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getCompanyDefaultCurrency(driver, testCaseName);

	}

	/**
	 * @author omkar.jagdale
	 *         method to get supplier email id
	 */
	public static String getSupplierEmailId(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getSupplierEmailId(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to fill tax type
	 */
	public static String fillTaxType(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillTaxType(driver, testCaseName, taxType, index);
	}

	/**
	 * @author omkar.jagdale
	 *         method to get cost booking amount after expand all
	 */
	public static String getAmountAtCostBookingAfterExpanAll(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getAmountAtCostBookingAfterExpanAll(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to get cost booking amount after expand all
	 */
	public static String getAmountAtAccountingAfterExpanAll(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getAmountAtAccountingAfterExpanAll(driver, testCaseName);
	}

	public static boolean isBlankAccountingErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isBlankAccountingErrorPresent(driver, testCaseName);
	}

	public static String getFirstAddedItemName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getFirstAddedItemName(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         fill currency exchange rate
	 */
	public static String fillCurrencyExchangeRate(WebDriver driver, String testCaseName, int exchangeRate) throws ActionBotException, FactoryMethodException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.fillCurrencyExchangeRate(driver, testCaseName, exchangeRate);
	}

	/**
	 * @author omkar.jagdale
	 *         method delete item by itemId
	 * 
	 */
	public static void deleteItemByItemId(WebDriver driver, String testCaseName, String itemId) throws FactoryMethodException, ActionBotException
	{

		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		iPageStandardPO.deleteItemByItemId(driver, testCaseName, itemId);

	}

	/**
	 * @author omkar.jagdale
	 *         method to check whether delivery My address is enabled or not
	 * 
	 */
	public static boolean isDeliveryMyAddressRadioButtonEnabled(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{

		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isDeliveryMyAddressRadioButtonEnabled(driver, testCaseName);

	}

	public static String getSubTotalTax(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getSubTotalTax(driver, testCaseName);
	}

	public static String getTaxRateIndexWise(WebDriver driver, String testCaseName, int index) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getTaxRateIndexWise(driver, testCaseName, index);
	}

	public static boolean isSupplierAddressEditable(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.isSupplierAddressEditable(driver, testCaseName);
	}

	public static String getItemContractNumber(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.getItemContractNumber(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to check invalid amount error
	 */
	public static boolean checkInvalidAmountError(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageStandardPO iPageStandardPO = FactoryPage.getInstanceOf(IPageStandardPOImpl.class);
		return iPageStandardPO.checkInvalidAmountError(driver, testCaseName);
	}
}
