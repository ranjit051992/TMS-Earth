package com.zycus.automation.eproc.pageobjects.pages.BuyersDesk;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

public class IPageBuyersDeskImpl implements IPageBuyersDesk
{

	static Logger logger = Logger.getLogger(IPageBuyersDeskImpl.class);

	@Override
	public String getRequistionNanme(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Req Name");
		String reqName = ActionBot.getTextWithInElement(driver, REQUISITION_NAME);
		logger.info("Requester Name entered is: " + reqName);
		return reqName;
	}

	@Override
	public String getResonForOrdering(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "ReasonForOrdering");
		String ReasonForOrdering = ActionBot.getTextWithInElement(driver, REASON_FOR_ORDERING);
		logger.info("Reson For Ordering : " + ReasonForOrdering);
		return ReasonForOrdering;

	}

	@Override
	public String getCommentsForSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String CommentForSupplier = null;
		ScreenShot.screenshot(driver, testCaseName, "CommentForSupplier");
		if (ActionBot.isElementPresent(driver, COMMENTS_FOR_SUPPLIER))
		{
			CommentForSupplier = ActionBot.getTextWithInElement(driver, COMMENTS_FOR_SUPPLIER);
		}
		else
		{
			CommentForSupplier = ActionBot.findElement(driver, TEXTBOX_COMMENT_FOR_SUPPLIER).getAttribute("value").trim();
		}

		logger.info("Comments For Supplier: " + CommentForSupplier);
		return CommentForSupplier;
	}

	@Override
	public String getAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "AssignedBuyer");
		String AssignedBuyer = ActionBot.getTextWithInElement(driver, ASSIGNED_BUYER);
		logger.info("Assigned Buyer: " + AssignedBuyer);
		return AssignedBuyer;
	}

	@Override
	public String getDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "DeliveryAddress");
		String DeliveryAddress = ActionBot.getTextWithInElement(driver, DELIVERY_ADDRESS);
		logger.info("Delivery Address: " + DeliveryAddress);
		return DeliveryAddress;
	}

	@Override
	public String getBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "BillToAddress");

		String BillToAddress = ActionBot.getTextWithInElement(driver, BILL_TO_ADDRESS);
		logger.info("Bill To Address: " + BillToAddress);
		return BillToAddress;
	}

	@Override
	public void clickOnExpandAllLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.scroll(driver, "500");
		WebElement ele = ActionBot.findElement(driver, REQUISITION_ITEM_EXPAND_ALL);
		ActionBot.defaultLowSleep();
		if (ele.isDisplayed())
		{
			ele.click();
		}
		/*
		 * if(ActionBot.isElementPresent(driver, REQUISITION_ITEM_EXPAND_ALL)){
		 * ActionBot.click(driver, REQUISITION_ITEM_EXPAND_ALL);
		 * ActionBot.waitForPageLoad(driver); }
		 */
	}

	@Override
	public void clickOnItemNoLink(WebDriver driver, String testcaseName) throws ActionBotException
	{

		ActionBot.click(driver, ITEM_NO);
	}

	@Override
	public void clickOnConvertToPo(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CONVERT_TO_PO);
		ActionBot.defaultSleep();
		// ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testcaseName, "After clicking convertToPO");
	}

	@Override
	public void clickOnSave(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, SAVE_REQUISITION);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultHighSleep();
	}

	@Override
	public void clickOnReturn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, RETURN_REQUISITION);

	}

	@Override
	public void clickOnCancel(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_REQUISITION);

	}

	@Override
	public String getUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String UnitPrice = null;
		ScreenShot.screenshot(driver, testCaseName, "UnitPrice");
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, UNIT_PRICE))
		{
			UnitPrice = ActionBot.findElement(driver, UNIT_PRICE).getText();
		}
		//this step is return if style="display: none;
		if (UnitPrice == null || UnitPrice.equals(""))
		{
			UnitPrice = ActionBot.findElement(driver, TEXTBOX_UNIT_PRICE).getAttribute("value");
		}
		logger.info("UnitPrice : " + UnitPrice);
		return UnitPrice;
	}

	@Override
	public String getQty(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Qty");
		ActionBot.defaultSleep();
		String Qty = ActionBot.findElement(driver, UNIT_PRICE).getAttribute("value");
		logger.info("Qty : " + Qty);
		return Qty;
	}

	@Override
	public String fillReqChangeComment(WebDriver driver, String testcaseName, String requeComment) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.sendKeys(driver, REQUISTION_CHANGE_COMMENTS, requeComment);
		ActionBot.defaultSleep();
		String ReqChangeComment = ActionBot.findElement(driver, REQUISTION_CHANGE_COMMENTS).getAttribute("value");
		logger.info("fill Req Change Comment : " + ReqChangeComment);
		ScreenShot.screenshot(driver, testcaseName, "After filling req change comments");
		return ReqChangeComment;

	}

	@Override
	public void clickOnBDCLINK(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BDC_EDITLINK);
	}

	@Override
	public String fillCommentsForSupplier(WebDriver driver, String testCaseName, String commentForSupplier) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_COMMENT_FOR_SUPPLIER, commentForSupplier);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_COMMENT_FOR_SUPPLIER);
		logger.info("Comments for supplier : " + str);
		ScreenShot.screenshot(driver, testCaseName, "After filling comments for supplier");
		return str;
	}

	@Override
	public String fillAssignedBuyer(WebDriver driver, String testCaseName, String assignedBuyerName) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, ASSIGNED_BUYER, assignedBuyerName);
		String str = ActionBot.getTextWithInElement(driver, ASSIGNED_BUYER);
		logger.info("Assigned Buyer : " + str);
		ScreenShot.screenshot(driver, testCaseName, "After filling assigned buyer");
		return str;
	}

	@Override
	public void clickEditItemSummary(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		ActionBot.moveToElementAndClick(driver, By.xpath(".//*[@id='item_" + itemID + "']//a[contains(@class,'edit')]"));
		PageRequisitionCheckOut.waitTillProgressingDivPresent(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "Edit Item Summary Window");
	}

	@Override
	public void waitTillUpdateProcessingDivIsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, UPDATE_REQUISITION_PROCESSING_DIV);
		// ActionBot.defaultMediumSleep();
	}

	@Override
	public void clickOnUpdateAllLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_UPDATE_ALL_LINES_BUYERS_DESK);
	}

	@Override
	public String fillGLAccount(WebDriver driver, String testCaseName, String glaccount) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, GLACCOUNT_TEXT_BOX))
		{
			// ActionBot.click(driver, CONTACT_SUPPLIER);
			WebElement ele = ActionBot.findElement(driver, GLACCOUNT_TEXT_BOX);
			// ActionBot.click(driver, CONTACT_SUPPLIER);
			ele.clear();
			ele.sendKeys(glaccount);
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);

		}
		return glaccount;

	}

	@Override
	public String fetchGLAccount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, GLACCOUNT_TEXT_BOX);
	}

	@Override
	public void clickOnApplyallLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_APPLY_ALL_LINES);
		ActionBot.defaultLowSleep();
	}

	@Override
	public int fillItemPrice(WebDriver driver, String testCaseName, int itemPrice, String itemId) throws ActionBotException, TestCaseException
	{

		ActionBot.clear(driver, By.xpath(".//*[@id='item_price_" + itemId + "']"));
		ActionBot.sendKeys(driver, By.xpath(".//*[@id='item_price_" + itemId + "']"), "" + itemPrice);
		String str = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='item_price_" + itemId + "']"));
		if (str != null)
		{
			int i = Integer.parseInt(str);
			return i;
		}
		else
		{
			return 0;
		}

	}

	@Override
	public boolean isAlertPopupForValidationPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, ALERT_VALIDATION_AND_ERROR))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnOKForAlert(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_OK_FOR_VALIDATION_ALERT_POPUP);

	}

	@Override
	public void clickOnItemName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(xpath1_itemNameLink + itemId + xpath2_itemNameLink));
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on item name");
	}

	@Override
	public void clickOnModifyWorkflowSetting(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_MODIFY_WORKFLOW_SETTING);
		ActionBot.defaultSleep();

	}

	@Override
	public boolean isModifyWorkflowSettingPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CHECKBOX_MODIFY_WORKFLOW_SETTING))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isModifyWorkflowSettingQtipPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, LABEL_MODIFY_WORKFLOW_SETTING);
		if (ActionBot.isElementPresent(driver, QTIP_MODIFY_WORKFLOW_SETTING))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnSendForApproval(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SEND_FOR_APPROVAL);
		ActionBot.waitTillPopUpIsPresent(driver, UPDATE_REQUISITION_PROCESSING_DIV);
		ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testCaseName, "After sending for approval");
	}

	@Override
	public void clickOnReturnToRequester(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Return To Requester");
		ActionBot.click(driver, BUTTON_RETURN_TO_REQUESTER);

		ActionBot.waitTillPopUpIsPresent(driver, UPDATE_REQUISITION_PROCESSING_DIV);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Return To Requester");
	}

	@Override
	public void clickOnRemoveBuyerLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REMOVE_ASSIGNED_BUYER);
		ScreenShot.screenshot(driver, testCaseName, "After removing assigned buyer");
	}

	@Override
	public String getAssignedBuyerName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String assignedBuyer = null;
		if (ActionBot.isElementPresent(driver, LABLE_ASSIGNED_BUYER_AT_BUYERS_DESK))
		{
			assignedBuyer = ActionBot.getTextWithInElement(driver, LABLE_ASSIGNED_BUYER_AT_BUYERS_DESK);
			logger.info("Assigned Buyer Name : " + assignedBuyer);
		}
		return assignedBuyer;
	}

	@Override
	public void clickOnFirstItemEdit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_FIRST_ITEM);

	}

	@Override
	public void clickOnReplaceItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@class='requisitionItems']//*[@class='col-itemno']//a[contains(text(),'" + itemId + "')]//..//..//..//*[@title='Replace Item']"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on replace item icon");
		ActionBot.defaultMediumSleep();

	}

	@Override
	public void clearAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, ASSIGNED_BUYER);
		ScreenShot.screenshot(driver, testCaseName, "After clearing assigned buyer");

	}

	@Override
	public String getItemNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, ITEM_NO);
		return str;
	}

	@Override
	public boolean isUnitPriceExceedingToleranceLevelErrorPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.hover(driver, By.xpath(".//*[@id='item_" + itemId + "']/td[contains(@class,'unitprice')]/span[@class='icon inlineError']"));
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='item_" + itemId + "']/td[contains(@class,'unitprice')]/span[@class='icon inlineError']")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isQuantityExceedingToleranceLevelErrorPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.hover(driver, By.xpath(".//*[@id='item_" + itemId + "']/td[contains(@class,'qty')]/span[@class='icon inlineError']"));
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='item_" + itemId + "']/td[contains(@class,'qty')]/span[@class='icon inlineError']")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int fillQuantity(WebDriver driver, String testCaseName, String itemId, int quantity) throws ActionBotException, TestCaseException
	{
		ActionBot.clear(driver, By.xpath(".//*[@id='item_quantity_" + itemId + "']"));
		ActionBot.sendKeys(driver, By.xpath(".//*[@id='item_quantity_" + itemId + "']"), "" + quantity);
		String str = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='item_quantity_" + itemId + "']"));
		if (str != null)
		{
			int i = Integer.parseInt(str);
			return i;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public String getReqChangeComments(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, REQUISTION_CHANGE_COMMENTS);
	}

	@Override
	public boolean isCostingSplitPresentAtItemLevel(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='item_summary_" + itemId + "']//td[contains(@class,'itemscostsplit')]//td[1]")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getHeaderTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// fetching only price out of entire string with ','
		String price = ActionBot.getTextWithInElement(driver, HEADER_TOTAL_PRICE);
		String splitOnINR[] = price.split("[| \\,]");
		int size = splitOnINR.length;
		String finalPrice = "";
		for (int index = 0; index < size; index++)
		{
			if (splitOnINR[index].equalsIgnoreCase("INR"))
			{

			}
			else
			{
				String local = splitOnINR[index];
				finalPrice = finalPrice + local;
			}
		}

		String Price[] = finalPrice.split("\\.");
		return Price[0];
	}

	@Override
	public String getItemLevelSubTotalPrice(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath(xpath1_itemSubTotalPrice + itemId + xpath2_itemSubTotalPrice));
	}

	@Override
	public String getItemAccountingLevelPrice(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath(xpath1_itemAccountingLevelPrice + itemId + xpath2_itemAccountingLevelPrice));
	}

	@Override
	public void clickOnCollapseAllItemsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_COLLPASE_ALL_ITEMS);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on collapse all link");

	}

	@Override
	public boolean isConvertToPOOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CONVERT_TO_PO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getItemSupplier(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath(xpath1_item_supplier + itemId + xpath2_item_supplier));
	}

	@Override
	public boolean isItemSupplierPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, By.xpath(xpath1_item_supplier + itemId + xpath2_item_supplier)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getNeedAQuoteHelpText(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.hover(driver, HELP_TEXT_FOR_NEED_A_QUOTE_SOURCING_STATUS);
		ActionBot.defaultSleep();
		return ActionBot.getTextWithInElement(driver, By.xpath(xpath1_itemNeedAQuoteIcon + itemId + xpath2_itemNeedAQuoteIcon));
	}

	@Override
	public boolean isExpandAllLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, REQUISITION_ITEM_EXPAND_ALL))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public void clickOnSelectItemToUncheck(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.click(driver, By.id("item_chk_" + itemId));
	}

	@Override
	public boolean isItemNameLinkPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		ActionBot.defaultSleep();
		return ActionBot.isElementPresent(driver, By.xpath(".//*[@id='item_" + itemId + "']//a[contains(@class,'itemName')]"));

	}

	@Override
	public void clickOnCreateSourcingEventButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CREATE_SOURCING_EVENT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Create Sourcing Event Button");
	}

	@Override
	public boolean clickOnCreateFreeTextItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.scroll(driver, "300");
		if (ActionBot.isElementPresent(driver, ACTION_BUTTON_EDIT_REQUISITION))
		{
			ActionBot.hover(driver, ACTION_BUTTON_EDIT_REQUISITION);
			ActionBot.hover(driver, BUTTON_ADD_ITEMS_EDIT_REQUISITION);
			ActionBot.waitForElementToBeDisplayed(driver, LINK_CREATE_FREE_TEXT_ITEM, 10);
			ActionBot.click(driver, LINK_CREATE_FREE_TEXT_ITEM);
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean clickOnPunchoutItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			By actionButton = By.xpath("//span[@class='dIblock vMiddle'][contains(text(),'Actions')]");
			By BUTTON_ADD_ITEMS = By.xpath("//span[@class='p'][contains(text(),'Add Item')]");
			By PUNCHOUT_ITEM = By.xpath("//a[@class='scLnk ']/span[@class='p'][contains(text(),'Punchouts')]");
			if (ActionBot.isElementPresent(driver, actionButton))
			{
				ActionBot.hover(driver, actionButton);
				ActionBot.hover(driver, BUTTON_ADD_ITEMS);
				ActionBot.waitForElementToBeDisplayed(driver, PUNCHOUT_ITEM, 20);
				ActionBot.click(driver, PUNCHOUT_ITEM);
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

	public static boolean clickOnSupplierOnPunchOutPOpUp(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		By supplierNameLink = By.xpath("//a[@href='#'][contains(text(),'" + supplierName + "')]");
		if (ActionBot.isElementPresent(driver, supplierNameLink))
		{

			ActionBot.click(driver, supplierNameLink);
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean hoverOnActionButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.scroll(driver, "250");
		By actionButton = By.xpath("//span[@class='dIblock vMiddle'][contains(text(),'Actions')]");
		if (ActionBot.isElementPresent(driver, actionButton))
		{
			ActionBot.hover(driver, actionButton);
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean clickOnFreeTextItemCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.scroll(driver, "250");
		By actionButton = By.xpath("(//input[@class='itemChk autoCheckItem applyMultipleChk'])[2]");
		if (ActionBot.isElementPresent(driver, actionButton))
		{
			ActionBot.click(driver, actionButton);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String enterItemNumber(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException
	{
		// itemNumber = itemNumber + Helper.getRandomString(5);
		itemNumber = ActionBot.sendKeys(driver, TEXT_ITEM_NUMBER, itemNumber);
		return itemNumber;
	}

	@Override
	public String enterItemShortDescription(WebDriver driver, String testCaseName, String itemShortDescription) throws ActionBotException
	{
		itemShortDescription = ActionBot.sendKeys(driver, TEXT_SHORT_DESCRIPTION, itemShortDescription);
		return itemShortDescription;
	}

	@Override
	public String enterItemLongDescription(WebDriver driver, String testCaseName, String itemLongDescription) throws ActionBotException
	{
		itemLongDescription = ActionBot.sendKeys(driver, TEXT_LONG_DESCRIPTION, itemLongDescription);
		return itemLongDescription;
	}

	@Override
	public String enterProductCategory(WebDriver driver, String testCaseName, String productCategory) throws ActionBotException
	{
		ActionBot.defaultSleep();
		WebElement ele = ActionBot.findElement(driver, TEXT_PRODUCT_CATEGORY);

		Actions act = new Actions(driver);
		act.moveToElement(ele);
		act.build().perform();

		ActionBot.click(driver, TEXT_PRODUCT_CATEGORY);
		ele.clear();
		ele.sendKeys(productCategory);
		ActionBot.defaultMediumSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultLowSleep();
		ActionBot.waitTillPopUpIsPresent(driver, By.xpath(".//*[@id='status_overlay_guided_item_loading']"));
		ActionBot.defaultLowSleep();

		// verifies if multiple forms are present on page then selects first
		// form
		if (isEformDialogPresent(driver, testCaseName))
		{
			clickEformFromList(driver, testCaseName);
			ActionBot.defaultLowSleep();
		}

		return productCategory;
	}

	@Override
	public String enterItemQuantity(WebDriver driver, String testCaseName, String itemQuantity) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, TEXT_QUANTITY);
		itemQuantity = ActionBot.sendKeys(driver, TEXT_QUANTITY, itemQuantity);
		return itemQuantity;
	}

	@Override
	public String enterItemPrice(WebDriver driver, String testCaseName, String itemPrice) throws ActionBotException
	{
		itemPrice = ActionBot.sendKeys(driver, TEXT_PRICE, itemPrice);
		return itemPrice;
	}

	@Override
	public void clickAddItemsButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "add button");
		By BUTTON_ADD_ITEMS_POPUP = By.xpath("//input[@id='addGuidedItem']");
		ActionBot.click(driver, BUTTON_ADD_ITEMS_POPUP);
		ActionBot.waitForOperations(10000);
	}

	@Override
	public void clickSuppliersTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, TAB_SUPPLIERS);

	}

	@Override
	public String enterSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, TEXT_SUPPLIER_NAME))
		{
			WebElement ele = ActionBot.findElement(driver, TEXT_SUPPLIER_NAME);
			ele.clear();
			ele.sendKeys(supplierName);
			ActionBot.waitForElementToBeDisplayed(driver, TEXT_SUPPLIER_NAME, 60);
			ActionBot.defaultHighSleep();
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);
			ActionBot.defaultLowSleep();
			selectSupplierAddress(driver, testCaseName);
		}

		return supplierName;
	}

	@Override
	public boolean isFreeTextItemCreated(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException
	{
		ActionBot.refreshPage(driver, testCaseName);
		ActionBot.defaultMediumSleep();
		ActionBot.scroll(driver, "500");
		ActionBot.defaultLowSleep();
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@class='requisitionItems']//*[@class='col-itemno']//a[contains(text(),'" + itemNumber + "')]")))
		{
			ScreenShot.screenshot(driver, testCaseName, "free text item");
			ActionBot.defaultLowSleep();
			return true;
		}
		return false;
	}

	@Override
	public boolean isDuplicateItemCreated(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException
	{
		ActionBot.scroll(driver, "250");
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@class='requisitionItems']//*[@class='col-itemno']//a[contains(text(),'" + itemNumber + "')]")))
		{
			ScreenShot.screenshot(driver, testCaseName, "duplicate item");
			List<WebElement> ele = ActionBot.findElements(driver, By.xpath(".//*[@class='requisitionItems']//*[@class='col-itemno']//a[contains(text(),'" + itemNumber + "')]"));
			int size = ele.size();
			// to check more than one element with same name
			if (size > 1)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean verifyButtonAddItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.scroll(driver, "250");
		if (ActionBot.isElementPresent(driver, BUTTON_ADD_ITEMS))
		{
			ActionBot.hover(driver, BUTTON_ADD_ITEMS);
			ScreenShot.screenshot(driver, testCaseName, "add button");
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnCancelLinkInAddItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		if (ActionBot.isElementDisplayed(driver, LINK_CANCEL))
		{
			ActionBot.click(driver, LINK_CANCEL);
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public void clickOnCancelAndGoBackButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, BUTTON_CANCEL_AND_GO_BACK_ADD_ITEM))
		{
			ActionBot.click(driver, BUTTON_CANCEL_AND_GO_BACK_ADD_ITEM);
			ActionBot.defaultMediumSleep();
		}
	}

	@Override
	public void clickOnCancelAndGoBackLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_CANCEL_AND_GO_BACK);
		ActionBot.defaultMediumSleep();

	}

	@Override
	public boolean verifyProductCategoryFieldDefaultValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TEXT_PRODUCT_CATEGORY))
		{
			String defaultText = ActionBot.getTextWithInElement(driver, TEXT_PRODUCT_CATEGORY);
			if (defaultText == null)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void clickRequirementDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementPresent(driver, TAB_REQUIREMENT_DETAILS))
		{
			ActionBot.click(driver, TAB_REQUIREMENT_DETAILS);
		}
	}

	@Override
	public boolean isEformPresentInRequirementTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, HEADER_SECTION_NAME_REQUIREMENT_TAB))
		{
			if (ActionBot.isElementPresent(driver, HEADER_FIELD_NAME_REQUIREMENT_TAB))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void clickItemTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, TAB_ITEM);
	}

	@Override
	public boolean isEformDialogPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, DIALOG_EFORM))
		{
			ScreenShot.screenshot(driver, testCaseName, "eform list");
			return true;
		}
		return false;
	}

	@Override
	public int getEformCount(WebDriver driver, String testCaseName, int eformCount) throws ActionBotException
	{
		String count = ActionBot.findElement(driver, EFORM_COUNT).getText();
		eformCount = Integer.parseInt(count);
		return eformCount;
	}

	@Override
	public int getEformListCount(WebDriver driver, String testCaseName, int eformListCount) throws ActionBotException
	{
		List<WebElement> ele = ActionBot.findElements(driver, EFORM_LIST);
		eformListCount = ele.size();
		return eformListCount;
	}

	@Override
	public void clickEformFromList(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> ele = ActionBot.findElements(driver, EFORM_LIST);
		ele.get(0).click();
		ActionBot.defaultSleep();
	}

	@Override
	public boolean isCategoryOnEformDisplayed(WebDriver driver, String testCaseName, String productCategory_1) throws ActionBotException
	{
		String category = ActionBot.findElement(driver, By.xpath(".//*[@id='selectGuidedCategory']//*[text()='" + productCategory_1 + "']")).getText();

		if (category.equalsIgnoreCase(productCategory_1))
		{
			ScreenShot.screenshot(driver, testCaseName, "eform");
			return true;
		}
		return false;
	}

	@Override
	public void clickOnCancelLinkEformDialog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CANCEL_DIALOG_EFORM);

	}

	@Override
	public String enterItemUOM(WebDriver driver, String testCaseName, String uom) throws ActionBotException
	{
		String enteredUOM = null;
		if (uom != null)
		{
			enteredUOM = ActionBot.fillAutoCompleteField(driver, TEXT_UOM, uom);
		}
		else
		{
			enteredUOM = ActionBot.getAttributeOfElement(driver, TEXT_UOM, "value");
		}
		logger.info("Entered UOM : " + enteredUOM);
		return enteredUOM;
		/*
		 * ActionBot.defaultSleep(); WebElement ele =
		 * ActionBot.findElement(driver, TEXT_UOM);
		 * 
		 * Actions act = new Actions(driver); act.moveToElement(ele);
		 * act.build().perform(); ele.click(); ele.clear(); ele.sendKeys(uom);
		 * ActionBot.defaultMediumSleep();
		 * 
		 * List<WebElement> eleList = ActionBot.findElements(driver,
		 * By.xpath(".//*[contains(@id,'ui-id-')]//li"));
		 * 
		 * for (WebElement a : eleList) { String text = a.getText();
		 * 
		 * if (text.equalsIgnoreCase(uom)) { a.click(); } }
		 * ActionBot.defaultLowSleep(); return uom;
		 */
	}

	@Override
	public boolean checkForQuantityError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, ERROR_ITEM_QUANTITY))
		{
			ActionBot.defaultSleep();
			return true;
		}
		return false;
	}

	@Override
	public boolean verifySourcingStatusValue(WebDriver driver, String testCaseName, String sourcingStatus) throws ActionBotException
	{
		String text = ActionBot.findElement(driver, TEXT_SOURCING_STATUS).getText();
		if (text.equalsIgnoreCase(sourcingStatus))
		{
			return true;
		}
		return false;
	}

	@Override
	public String enterItemCurrency(WebDriver driver, String testCaseName, String itemCurrency) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXT_CURRENCY);
		ele.click();
		ele.clear();
		ele.sendKeys(itemCurrency);
		ActionBot.defaultMediumSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultLowSleep();
		return itemCurrency;
	}

	@Override
	public void clickShowExtraFieldsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, LINK_SHOW_EXTRA_FIELDS);
		Actions act = new Actions(driver);
		act.moveToElement(ele);
		act.click().build().perform();
		// ActionBot.click(driver, LINK_SHOW_EXTRA_FIELDS);
	}

	@Override
	public String enterManufacturerName(WebDriver driver, String testCaseName, String manufacturerName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_MANUFACTURER_NAME, manufacturerName);
		return manufacturerName;
	}

	@Override
	public String enterManufacturerPartId(WebDriver driver, String testCaseName, String manufacturerPartId) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_MANUFACTURER_PART_ID, manufacturerPartId);
		return manufacturerPartId;
	}

	@Override
	public String enterSpecificationName(WebDriver driver, String testCaseName, String specificationName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_SPECIFICATION_NAME, specificationName);
		return specificationName;
	}

	@Override
	public String enterSpecificationKey(WebDriver driver, String testCaseName, String specificationKey) throws ActionBotException
	{
		List<WebElement> ele = ActionBot.findElements(driver, TEXT_SPECIFICATION_KEY);
		int size = ele.size();
		String randomKey = null;

		if (size > 1)
		{
			for (WebElement a : ele)
			{
				randomKey = "Key" + CommonUtilities.getRandomInvoiceNo();
				a.sendKeys(randomKey);
			}
			return randomKey;
		}
		else
		{
			ActionBot.sendKeys(driver, TEXT_SPECIFICATION_KEY, specificationKey);
			return specificationKey;
		}
	}

	@Override
	public String enterSpecificationValue(WebDriver driver, String testCaseName, String specificationValue) throws ActionBotException
	{
		List<WebElement> ele = ActionBot.findElements(driver, TEXT_SPECIFICATION_VALUE);
		int size = ele.size();
		String randomValue = null;
		if (size > 1)
		{
			for (WebElement a : ele)
			{
				randomValue = "Value" + CommonUtilities.getRandomInvoiceNo();
				a.sendKeys(randomValue);
			}
			return randomValue;
		}
		else
		{
			ActionBot.sendKeys(driver, TEXT_SPECIFICATION_VALUE, specificationValue);
			return specificationValue;
		}
	}

	@Override
	public void clickAddSpecificationButton(WebDriver driver, String testCaseName, String specificationCount) throws ActionBotException
	{
		int count = Integer.parseInt(specificationCount);

		if (count >= 2)
		{
			do
			{
				ActionBot.click(driver, BUTTON_SPECIFICATION_ADD);
				count--;
			} while (count >= 2);
		}

	}

	@Override
	public String enterImageUrl(WebDriver driver, String testCaseName, String imageUrl) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_IMAGE_URL, imageUrl);
		return imageUrl;
	}

	@Override
	public String enterProductUrl(WebDriver driver, String testCaseName, String productUrl) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_PRODUCT_URL, productUrl);
		return productUrl;
	}

	@Override
	public String enterManufacturerUrl(WebDriver driver, String testCaseName, String manufacturerUrl) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXT_MANUFACTURER_URL, manufacturerUrl);
		return manufacturerUrl;
	}

	@Override
	public boolean checkForSupplierNameError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_SUPPLIER_NAME))
		{
			ScreenShot.screenshot(driver, testCaseName, "Supplier name error");
			return true;
		}
		return false;
	}

	@Override
	// enters Address field value present under Requirement Tab
	public String enterAddressRequirementTab(WebDriver driver, String testCaseName, String addressRequirementTab) throws ActionBotException
	{
		ActionBot.click(driver, TEXT_ADDRESS_REQUIREMENT_DETAILS_TAB);
		ActionBot.clear(driver, TEXT_ADDRESS_REQUIREMENT_DETAILS_TAB);
		ActionBot.sendKeys(driver, TEXT_ADDRESS_REQUIREMENT_DETAILS_TAB, addressRequirementTab);
		ScreenShot.screenshot(driver, testCaseName, "Address in requriement tab");
		return addressRequirementTab;
	}

	@Override
	public boolean verifyErrorInRequirementTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_IN_REQUIREMENT_TAB))
		{
			ScreenShot.screenshot(driver, testCaseName, "Error in requriement tab");
			return true;
		}
		return false;
	}

	@Override
	public void clearAddressRequirementTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TEXT_ADDRESS_REQUIREMENT_DETAILS_TAB);
		ActionBot.clear(driver, TEXT_ADDRESS_REQUIREMENT_DETAILS_TAB);
	}

	@Override
	public boolean clickShowAllButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_SHOW_ALL))
		{
			ActionBot.click(driver, BUTTON_SHOW_ALL);
			ActionBot.defaultMediumSleep();
			return true;
		}
		return false;
	}

	@Override
	public String selectBPONumber(WebDriver driver, String testCaseName, String bpoNumber) throws ActionBotException
	{
		bpoNumber = ActionBot.findElement(driver, By.xpath("(.//*[contains(@class,'purchaseOrderNumber')]//a)[1]")).getText();
		ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testCaseName, "BPO present in list");
		ActionBot.click(driver, RADIOBUTTON_SELECT_PO);
		ActionBot.click(driver, BUTTON_OK_PO);
		ScreenShot.screenshot(driver, testCaseName, "Selected BPO");
		/*
		 * if(ActionBot.isElementDisplayed(driver, TEXT_FILTER_PO_NUMBER)){
		 * WebElement ele = ActionBot.findElement(driver,
		 * TEXT_FILTER_PO_NUMBER); ActionBot.defaultMediumSleep();
		 * ele.sendKeys(bpoNumber); ActionBot.defaultMediumSleep();
		 * ele.sendKeys(Keys.ENTER); ScreenShot.screenshot(driver, testCaseName,
		 * "BPO present in list"); ActionBot.defaultMediumSleep();
		 * ActionBot.click(driver, RADIOBUTTON_SELECT_PO);
		 * ActionBot.click(driver, BUTTON_OK_PO); ActionBot.defaultSleep();
		 * ScreenShot.screenshot(driver, testCaseName, "BPO found"); }
		 */
		return bpoNumber;
	}

	@Override
	public boolean verifyBPOSelected(WebDriver driver, String testCaseName, String bpoNumber) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='dev_existingSupplierBlock']//a[contains(text(),'" + bpoNumber + "')]")))
		{
			ScreenShot.screenshot(driver, testCaseName, "BPO selected");
			return true;
		}
		return false;
	}

	@Override
	public String enterContractNumber(WebDriver driver, String testCaseName, String contractNumber) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		if (ActionBot.isElementDisplayed(driver, TEXT_CONTRACT_NUMBER))
		{
			ActionBot.sendKeys(driver, TEXT_CONTRACT_NUMBER, contractNumber);
		}
		return contractNumber;
	}

	@Override
	public void clickReturnToRequestorButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ScreenShot.screenshot(driver, testCaseName, "Return to Requestor");
		ActionBot.click(driver, BUTTON_RETURN_TO_REQUESTER_EDIT_REQ);
	}

	@Override
	public String enterReqChangeComments(WebDriver driver, String testCaseName, String reqChangeComments) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTAREA_REQ_CHANGE_COMMENTS, reqChangeComments);
		ScreenShot.screenshot(driver, testCaseName, "Req Change Comments");
		return reqChangeComments;
	}

	@Override
	public void clickConfirmReturnToReq_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "Confirm Yes");
		ActionBot.click(driver, BUTTON_CONFIRM_YES);
		ActionBot.defaultMediumSleep();

	}

	@Override
	public boolean clickConfimSave_Save(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Confirm Save");
		ActionBot.defaultLowSleep();
		if (ActionBot.isElementDisplayed(driver, BUTTON_CONFIRM_SAVE))
		{
			ActionBot.click(driver, BUTTON_CONFIRM_SAVE);
			ActionBot.defaultHighSleep();
			ActionBot.defaultHighSleep();
			ActionBot.defaultMediumSleep();
			return true;
		}
		return false;
	}

	@Override
	public void clickAccountingEditLinkForFreeTextItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Edit Accounting");
		List<WebElement> ele = ActionBot.findElements(driver, By.xpath(".//*[@class='requisitionItems']/tr"));
		int size = ele.size();

		if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@class='requisitionItems']/tr[" + size + "]//*[@title='Edit Accounting Info for this item']")))
		{
			ActionBot.click(driver, By.xpath(".//*[@class='requisitionItems']/tr[" + size + "]//*[@title='Edit Accounting Info for this item']"));
		}
	}

	@Override
	public String selectGLAccount(WebDriver driver, String testCaseName, String glAccount) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXT_GL_ACCOUNT);
		ele.click();
		ele.sendKeys(glAccount);
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		ScreenShot.screenshot(driver, testCaseName, "Select Gl Account");
		ActionBot.click(driver, BUTTON_OK_COST_ALLOCATION_TAB);
		ActionBot.defaultSleep();
		return glAccount;
	}

	@Override
	public void clickAddItemsButtonToReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Adding catalog item");
		ActionBot.click(driver, BUTTON_ADD_ITEMS_TO_REQ);

	}

	@Override
	public boolean isCatalogItemAdded(WebDriver driver, String testCaseName, String searchItemName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.scroll(driver, "500");
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@class='requisitionItems']//*[@class='col-itemsupp frmBlck']//a[contains(text(),'" + searchItemName + "')]")))
		{
			ScreenShot.screenshot(driver, testCaseName, "catalog item added");
			return true;
		}
		return false;
	}

	@Override
	public void clickEditLinkForBillingDeliverySummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_BILLING_DELIVERY_SUMMARY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "Edit Summary");
	}

	@Override
	public void clickCostAllocationTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		if (ActionBot.isElementDisplayed(driver, TAB_COST_ALLOCATION))
		{
			ActionBot.click(driver, TAB_COST_ALLOCATION);
		}
	}

	@Override
	public String enterCostCenterSummary(WebDriver driver, String testCaseName, String costCenterSummary) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.fillAutoCompleteField(driver, TEXT_COST_CENTER_SUMMARY, costCenterSummary);

		/*
		 * WebElement ele = ActionBot.findElement(driver,
		 * TEXT_COST_CENTER_SUMMARY); ele.clear();
		 * ele.sendKeys(costCenterSummary); ActionBot.defaultLowSleep();
		 * ele.sendKeys(Keys.ARROW_DOWN); ele.sendKeys(Keys.ENTER);
		 */
		return costCenterSummary;
	}

	@Override
	public String enterProjectSummary(WebDriver driver, String testCaseName, String projectSummary) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIO_ASSIGN_COST_TO_PROJECT_YES))
		{
			if (ActionBot.isElementEnabled(driver, RADIO_ASSIGN_COST_TO_PROJECT_YES))
			{
				ActionBot.click(driver, RADIO_ASSIGN_COST_TO_PROJECT_YES);
			}
		}

		if (ActionBot.isElementSelected(driver, RADIO_ASSIGN_COST_TO_PROJECT_YES))
		{
			ActionBot.defaultLowSleep();
			WebElement ele = ActionBot.findElement(driver, TEXT_PROJECT_SUMMARY);
			ele.clear();
			ele.sendKeys(projectSummary);
			ActionBot.defaultLowSleep();
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);
			ScreenShot.screenshot(driver, testCaseName, "after filling project summary");
		}

		return projectSummary;
	}

	@Override
	public String enterBudgetSummary(WebDriver driver, String testCaseName, String budgetSummary) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, RADIO_BUDGET_UTILIZATION_YES))
		{
			if (ActionBot.isElementEnabled(driver, RADIO_BUDGET_UTILIZATION_YES))
			{
				ActionBot.click(driver, RADIO_BUDGET_UTILIZATION_YES);
			}
		}
		if (ActionBot.isElementSelected(driver, RADIO_BUDGET_UTILIZATION_YES))
		{
			ActionBot.defaultLowSleep();
			WebElement ele = ActionBot.findElement(driver, TEXT_BUDGET_SUMMARY);
			ele.clear();
			ele.sendKeys(budgetSummary);
			ActionBot.defaultLowSleep();
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);
			ScreenShot.screenshot(driver, testCaseName, "after filling budget summary");
		}

		return budgetSummary;
	}

	@Override
	public void clickOkButtonForReqSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testCaseName, "Saving Summary Details");
		ActionBot.click(driver, BUTTON_OK_REQ_SUMMARY);
		ActionBot.defaultMediumSleep();
	}

	@Override
	public boolean verifyCreateFreeTextItemModal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, TITLE_CREATE_FREE_TEXT_ITEM_MODAL))
		{
			ScreenShot.screenshot(driver, testCaseName, "Freetext Modal");
			return true;
		}
		return false;
	}

	@Override
	public boolean verifyCostcenterProjectBudgetUpdatedValues(WebDriver driver, String testCaseName, String costCenterSummary, String projectSummary, String budgetSummary)
		throws ActionBotException
	{
		ActionBot.defaultSleep();
		String ccSummary = ActionBot.findElement(driver, VALUE_COST_CENTER).getText();
		String pSummary = ActionBot.findElement(driver, VALUE_PROJECT).getText();
		String bSummary = ActionBot.findElement(driver, VALUE_BUDGET).getText();

		String[] cc = ccSummary.split(":");
		String[] pro = pSummary.split(":");
		String[] budg = bSummary.split(":");

		if (cc[0].trim().equalsIgnoreCase(costCenterSummary))
		{
			if (pro[1].trim().equalsIgnoreCase(projectSummary))
			{
				if (budg[0].trim().equalsIgnoreCase(budgetSummary))
				{
					ScreenShot.screenshot(driver, testCaseName, "current values");
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean clickConfirmSave_DontSave(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testCaseName, "Don't Save");
		if (ActionBot.isElementDisplayed(driver, BUTTON_CONFIRM_DONT_SAVE))
		{
			ActionBot.click(driver, BUTTON_CONFIRM_DONT_SAVE);
			ActionBot.defaultSleep();
			return true;
		}
		return false;
	}

	@Override
	public boolean verifyReplaceIconEnabledForFreeTextItem(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		ActionBot.scroll(driver, "500");
		if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@class='requisitionItems']//*[@class='col-itemno']//a[contains(text(),'" + itemNumber
			+ "')]//..//..//..//*[@title='Replace Item'][contains(@class,'disableMe')]")))
		{
			ScreenShot.screenshot(driver, testCaseName, "Replace Icon");
			return true;
		}
		return false;
	}

	@Override
	public String getFreeTextItemDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> ele = ActionBot.findElements(driver, By.xpath(".//*[@class='requisitionItems']/tr"));
		int size = ele.size();
		String dAddress = null;
		String deliveryAddress = null;
		if (ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@class='requisitionItems']/tr[" + size + "]//*[@class='location qtipCss hasQtip'])[2]")))
		{
			dAddress = ActionBot.findElement(driver, By.xpath("(.//*[@class='requisitionItems']/tr[" + size + "]//*[@class='location qtipCss hasQtip'])[2]")).getText();
		}
		String add[] = dAddress.split("\\(");
		deliveryAddress = add[0].trim();
		ScreenShot.screenshot(driver, testCaseName, "free text delivery address");
		return deliveryAddress;
	}

	@Override
	public String getReqDeliveryAddressHeaderlevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqDeliveryAddress = null;
		reqDeliveryAddress = ActionBot.findElement(driver, TEXT_DELIVERY_ADDRESS_HEADER).getText();
		ScreenShot.screenshot(driver, testCaseName, "req delivery address");
		return reqDeliveryAddress;
	}

	@Override
	public String getFreeTextItemCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> ele = ActionBot.findElements(driver, By.xpath(".//*[@class='requisitionItems']/tr"));
		int size = ele.size();
		String itemCostCenter = null;
		if (ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@class='requisitionItems']/tr[" + size + "]//*[@class='costing qtipCss hasQtip'])[2]")))
		{
			itemCostCenter = ActionBot.findElement(driver, By.xpath("(.//*[@class='requisitionItems']/tr[" + size + "]//*[@class='costing qtipCss hasQtip'])[2]")).getText();
		}
		ScreenShot.screenshot(driver, testCaseName, "free text cost center");
		return itemCostCenter;
	}

	@Override
	public String getReqCostCenterHeaderLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqCostCenter = null;
		reqCostCenter = ActionBot.findElement(driver, TEXT_COST_CENTER_HEADER).getText();
		ScreenShot.screenshot(driver, testCaseName, "req cost center");
		return reqCostCenter;
	}

	@Override
	public String getReqOUCompany(WebDriver driver, String testCaseName, String ouCompany) throws ActionBotException
	{
		ouCompany = ActionBot.findElement(driver, TEXT_OU_COMPANY).getText();
		return ouCompany;
	}

	@Override
	public String getReqOUBusinessUnit(WebDriver driver, String testCaseName, String ouBusinessUnit) throws ActionBotException
	{
		ouBusinessUnit = ActionBot.findElement(driver, TEXT_OU_BUSINESS_UNIT).getText();
		return ouBusinessUnit;
	}

	@Override
	public String getReqOULocation(WebDriver driver, String testCaseName, String ouLocation) throws ActionBotException
	{
		ouLocation = ActionBot.findElement(driver, TEXT_OU_LOCATION).getText();
		return ouLocation;
	}

	@Override
	public String getCreatedReqNumber(WebDriver driver, String testCaseName, String reqNumber) throws ActionBotException
	{
		String num = ActionBot.findElement(driver, By.xpath(".//*[@id='hedaerSuccessBox']/div[2]/ul/li")).getText();
		String num1[] = num.split("Requisition");
		String num2[] = num1[1].split("has");
		reqNumber = num2[0].trim();
		ScreenShot.screenshot(driver, testCaseName, "req number");
		return reqNumber;
	}

	@Override
	public void clickCostAtLineLevelRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, RADIO_BUTTON_COST_LINE_LEVEL);
		ScreenShot.screenshot(driver, testCaseName, "line level radio button");
		ActionBot.defaultLowSleep();
	}

	@Override
	public void clickEditLinkForCostBookingItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, LINK_EDIT_COST_BOOKING_ITEM_LEVEL);
		ActionBot.defaultLowSleep();
	}

	@Override
	public void enterGLAccountForCostBookingItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		WebElement ele = ActionBot.findElement(driver, TEXT_GL_ACCOUNT_COST_BOOKING_ITEM_LEVEL);
		ActionBot.defaultLowSleep();
		ele.click();
		ActionBot.defaultLowSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		ScreenShot.screenshot(driver, testCaseName, "gl account");
	}

	@Override
	public String enterProjectForCostBookingItemLevel(WebDriver driver, String testCaseName, String project) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		WebElement ele = ActionBot.findElement(driver, TEXT_PROJECT_COST_BOOKING_ITEM_LEVEL);
		ele.clear();
		ele.sendKeys(project);
		ActionBot.defaultLowSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		return project;
	}

	@Override
	public String enterBudgetForCostBookingItemLevel(WebDriver driver, String testCaseName, String budget) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		WebElement ele = ActionBot.findElement(driver, TEXT_BUDGET_COST_BOOKING_ITEM_LEVEL);
		ele.clear();
		ele.sendKeys(budget);
		ActionBot.defaultLowSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		return budget;
	}

	@Override
	public String enterCostCenterForCostBookingItemLevel(WebDriver driver, String testCaseName, String costCenter) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		WebElement ele = ActionBot.findElement(driver, TEXT_COST_CENTER_COST_BOOKING_ITEM_LEVEL);
		ele.clear();
		ele.sendKeys(costCenter);
		ActionBot.defaultLowSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		ScreenShot.screenshot(driver, testCaseName, "cost center");
		return costCenter;
	}

	@Override
	public void clickButtonOkCostAllocationTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_OK_COST_ALLOCATION_TAB);
		ActionBot.defaultSleep();

	}

	@Override
	public void updateFreeTextItemPrice(WebDriver driver, String testCaseName, String itemPrice, String itemNumber) throws ActionBotException
	{
		ActionBot.defaultSleep();
		// WebElement ele = ActionBot.findElement(driver,
		// By.xpath(".//*[@class='requisitionItems']//*[@class='col-itemno']//a[contains(text(),'"
		// + itemNumber + "')]/../../..//.//*[contains(@id,'item_price')]"));

		WebElement ele = ActionBot.findElement(driver, TEXT_PRICE);
		ele.clear();
		ele.sendKeys(itemPrice);
		ScreenShot.screenshot(driver, testCaseName, "updated price");
		ActionBot.defaultSleep();
	}

	@Override
	public void updateFreeTextItemQuantity(WebDriver driver, String testCaseName, String itemQuantity, String itemNumber) throws ActionBotException
	{
		ActionBot.defaultSleep();
		/*
		 * WebElement ele = ActionBot.findElement(driver, By.xpath(
		 * ".//*[@class='requisitionItems']//*[@class='col-itemno']//a[contains(text(),'"
		 * + itemNumber + "')]/../../..//.//*[contains(@id,'item_quantity')]"));
		 */
		WebElement ele = ActionBot.findElement(driver, TEXT_QUANTITY);

		ele.clear();
		ele.sendKeys(itemQuantity);
		ScreenShot.screenshot(driver, testCaseName, "updated quantity");
		ActionBot.defaultSleep();

	}

	@Override
	public boolean isToleranceErrorDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultHighSleep();
		ActionBot.defaultHighSleep();
		ActionBot.scroll(driver, "500");
		ActionBot.defaultLowSleep();
		if (ActionBot.isElementDisplayed(driver, ERROR_TOLERANCE_LEVEL_FOR_ALLOW_PRS))
		{
			ActionBot.defaultLowSleep();
			ScreenShot.screenshot(driver, testCaseName, "tolerance error");
			return true;
		}
		return false;
	}

	@Override
	public void clickEditLinkForFreeTextItem(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException
	{
		List<WebElement> ele = ActionBot.findElements(driver, By.xpath(".//*[@class='requisitionItems']/tr"));
		int size = ele.size();
		if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@class='requisitionItems']/tr[" + size + "]//*[contains(text(),'Cost Booking')]//*[text()='Edit']")))
		{
			ActionBot.findElement(driver, By.xpath(".//*[@class='requisitionItems']/tr[" + size + "]//*[contains(text(),'Cost Booking')]//*[text()='Edit']")).click();
		}

	}

	@Override
	public void selectSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, TEXT_SUPPLIER_ADDRESS);
		ActionBot.click(driver, By.xpath("(.//*[@class='add-loc']/parent::a)[1]"));
	}

	@Override
	public boolean verifyReplaceIconEnabled(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		ActionBot.scroll(driver, "500");
		if (ActionBot.isElementDisplayed(driver,
			By.xpath(".//*[@class='requisitionItems']//*[@class='col-itemno']//a[contains(text(),'" + itemNumber + "')]//..//..//..//*[@title='Replace Item']")))
		{
			ScreenShot.screenshot(driver, testCaseName, "Replace Icon");
			return true;
		}
		return false;
	}

	@Override
	public String getReqDefaultItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String itemName = ActionBot.findElement(driver, By.xpath("(.//*[contains(@class,'itemName')])[2]")).getText();
		return itemName;
	}

	@Override
	public String getItemDescription(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String itemDescription = ActionBot.findElement(driver, TEXT_ITEM_DESCRIPTION).getText();
		return itemDescription;
	}

	@Override
	public void clickCloseOnItemPopUp(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, BUTTON_CLOSE_ITEM_POPUP);
	}

	@Override
	public void clickOnFreeTextItemNumber(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, By.xpath(".//*[@class='requisitionItems']//*[@class='col-itemno']//a[contains(text(),'" + itemNumber + "')]"));
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnItemLinkDiscriptionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'item_')]//a[contains(@class,'scLnk itemnamelnk ')])[" + index + "]"));
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnSupplierTabInFreeText(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FREE_TEXT_SUPPLIER_TAB);
	}

	@Override
	public String getFreeTextSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[@id='dev_singleSupplierInput'])[1]"), 60);
		return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[@id='dev_singleSupplierInput'])[1]"));
	}

	@Override
	public boolean editContractNumber(WebDriver driver, String testCaseName, String newContractNumber) throws ActionBotException
	{
		try
		{
			ActionBot.clear(driver, TEXT_CONTRACT_NUMBER);
			ActionBot.sendKeys(driver, TEXT_CONTRACT_NUMBER, newContractNumber);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public String getReqPurchaseCurrencyType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String currency = ActionBot.findElement(driver, TEXT_PURCHASE_AMOUNT).getText();
		String[] cType = currency.split(" ");
		String reqCurrency = cType[0];
		return reqCurrency;
	}

	@Override
	public boolean verifyButtonConvertToPo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		if (ActionBot.isElementPresent(driver, CONVERT_TO_PO))
		{
			return true;
		}
		return false;
	}

	@Override
	public int clickItemCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int a = 0;

		ActionBot.scroll(driver, "500");
		List<WebElement> ele = ActionBot.findElements(driver, By.xpath(".//*[contains(@id,'item_chk')]"));
		int size = ele.size();
		for (a = 1; a <= size; a++)
		{
			if (driver.findElement(By.xpath("(.//*[contains(@id,'item_chk')])[" + a + "]")).isSelected() == false
				&& driver.findElement(By.xpath("(.//*[contains(@id,'item_chk')])[" + a + "]")).isDisplayed()
				&& driver.findElement(By.xpath("(.//*[contains(@id,'item_chk')])[" + a + "]")).isEnabled())
			{
				ActionBot.click(driver, By.xpath("(.//*[contains(@id,'item_chk')])[" + a + "]"));
				ActionBot.defaultSleep();
			}
		}

		return a - 1;
	}

	@Override
	public void clickItemCheckboxIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'item_chk')])[" + index + "]"), 5);
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'item_chk')])[" + index + "]"));
	}

	@Override
	public void clickEditItemIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath("(.//*[contains(@id,'item_')]//a[contains(@title,'Edit')])[" + index + "]"), 5);
		ActionBot.click(driver, By.xpath("(.//*[contains(@id,'item_')]//a[contains(@title,'Edit')])[" + index + "]"));
	}

	@Override
	public void clickAuditTrailLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.scroll(driver, "2500");
		ActionBot.click(driver, LINK_AUDIT_TRAIL);
		ActionBot.defaultSleep();
	}

	@Override
	public String getAuditTrailMessage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String qtip = ActionBot.getAttributeOfElement(driver, TEXT_AUDIT_TRAIL_COMMENT, "data-qtipmsg");
		String auditMessage = null;
		if (qtip == null)
		{
			auditMessage = ActionBot.findElement(driver, TEXT_AUDIT_TRAIL_COMMENT).getText();
		}
		else
		{
			auditMessage = qtip;
		}
		return auditMessage;
	}

	@Override
	public void clickEditLinkForAssignedBuyerItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, LINK_EDIT_ASSIGNED_BUYER_ITEM_LEVEL);
		ActionBot.defaultLowSleep();

	}

	@Override
	public String getSelectedItemType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String selectedItemTypeRadio = null;
		if (ActionBot.isElementSelected(driver, RADIO_ITEM_TYPE_GOODS))
		{
			selectedItemTypeRadio = ActionBot.findElement(driver, By.xpath("(.//*[@id='itemType_goods'])[1]/..")).getText();
		}
		else if (ActionBot.isElementSelected(driver, RADIO_ITEM_TYPE_SERVICES))
		{
			selectedItemTypeRadio = ActionBot.findElement(driver, By.xpath("(.//*[@id='itemType_services'])[1]/..")).getText();
		}
		return selectedItemTypeRadio;
	}

	@Override
	public String getSelectedReceivedBy(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String selectedReceiveByRadio = null;
		if (ActionBot.isElementSelected(driver, RADIO_RECEIVE_BY_QUANTITY))
		{
			selectedReceiveByRadio = ActionBot.findElement(driver, By.xpath("(.//*[@id='receiptType_quantity'])[1]/..")).getText();
		}
		else if (ActionBot.isElementSelected(driver, RADIO_RECEIVE_BY_AMOUNT))
		{
			selectedReceiveByRadio = ActionBot.findElement(driver, By.xpath("(.//*[@id='receiptType_amount'])[1]/..")).getText();
		}
		else if (ActionBot.isElementSelected(driver, RADIO_RECEIVE_BY_NO_RECEPIT))
		{
			selectedReceiveByRadio = ActionBot.findElement(driver, By.xpath("(.//*[@id='receiptType_noReceipt'])[1]/..")).getText();
		}
		return selectedReceiveByRadio;
	}

	@Override
	public boolean isRadioButtonReceiveByNoReceiptEnabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementEnabled(driver, RADIO_RECEIVE_BY_NO_RECEPIT))
		{
			return true;
		}
		return false;
	}

	@Override
	public String getSelectedIsGreen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String selectedIsGreenRadio = null;

		if (ActionBot.isElementSelected(driver, RADIO_IS_GREEN_YES))
		{
			selectedIsGreenRadio = ActionBot.findElement(driver, By.xpath("(.//*[contains(@id,'dev_isGreen_true')])[1]/..")).getText();
		}
		else if (ActionBot.isElementSelected(driver, RADIO_IS_GREEN_NO))
		{
			selectedIsGreenRadio = ActionBot.findElement(driver, By.xpath("(.//*[contains(@id,'dev_isGreen_false')])[1]/..")).getText();
		}

		return selectedIsGreenRadio;
	}

	@Override
	public String getSelectedIsPreferred(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String selectedIsPreferredRadio = null;

		if (ActionBot.isElementSelected(driver, RADIO_IS_PREFERRED_YES))
		{
			selectedIsPreferredRadio = ActionBot.findElement(driver, By.xpath("(.//*[contains(@id,'dev_isPreferred_true')])[1]/..")).getText();
		}
		else if (ActionBot.isElementSelected(driver, RADIO_IS_PREFERRED_NO))
		{
			selectedIsPreferredRadio = ActionBot.findElement(driver, By.xpath("(.//*[contains(@id,'dev_isPreferred_false')])[1]/..")).getText();
		}
		return selectedIsPreferredRadio;
	}

	@Override
	public void clickDeleteItemIcon(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		ActionBot.scroll(driver, "500");
		if (ActionBot.isElementDisplayed(driver,
			By.xpath(".//*[@class='requisitionItems']//*[@class='col-itemno']//a[contains(text(),'" + itemNumber + "')]//..//..//..//*[contains(@class,'deleteItem')]")))
		{
			ActionBot.click(driver,
				By.xpath(".//*[@class='requisitionItems']//*[@class='col-itemno']//a[contains(text(),'" + itemNumber + "')]//..//..//..//*[contains(@class,'deleteItem')]"));
			ScreenShot.screenshot(driver, testCaseName, "After clicking delete item icon");
		}

	}

	@Override
	public int getAuditTrailVersion(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String version = ActionBot.findElement(driver, TEXT_AUDIT_TRAIL_VERSION).getText();
		int versionNumber = 0;
		if (!(version.equals(null) || version.equals("")))
		{
			String vnumber = version.charAt(1) + "";
			versionNumber = Integer.parseInt(vnumber);
		}
		return versionNumber;
	}

	@Override
	public void clickButtonShowAllPo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SHOW_ALL_PO);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking Show all PO Button");
	}

	@Override
	public String getFirstPoNumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String poNumber = ActionBot.findElement(driver, LINK_FIRST_PO_NUMBER_POMODAL).getText();
		return poNumber;
	}

	@Override
	public void selectFirstPoRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_SELECT_FIRST_PO_POMODAL);
		ScreenShot.screenshot(driver, testCaseName, "After selecting PO radio button");
	}

	@Override
	public void clickButtonSelectOnPoModal(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SELECT_PO_LIST_POMODAL);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking select button on po modal");

	}

	@Override
	public boolean isReqItemDisplayedOnPOPage(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver,
			By.xpath("(.//*[@class='poItems']//*[contains(@class,'itemno')])[3]//*[contains(@class,'suppname itemNo')][text()='" + itemNumber + "']")))
		{
			return true;
		}
		return false;
	}

	@Override
	public void fillPoNumberFilterPomodal(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		ActionBot.click(driver, FILTER_PO_NUMBER_POMODAL);
		ActionBot.defaultMediumSleep();
		ActionBot.sendKeys(driver, FILTER_PO_NUMBER_POMODAL, poNumber);
		WebElement ele = ActionBot.findElement(driver, FILTER_PO_NUMBER_POMODAL);
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After entering value for po");
	}

	@Override
	public void clickReqRowise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, By.xpath("(.//*[@id='buyerlisting']//a[contains(@class,'scLnk')])[" + index + "]"));
	}

	@Override
	public void clickCloseItemDetailPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, By.id("saveGuidedItem"));
	}

	@Override
	public void clickShowMoreExtraFields(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SHOW_EXTRA_FIELDS);
	}

	@Override
	public void fillManufacturerNameInGuidedItemPopup(WebDriver driver, String testCaseName, String name) throws ActionBotException
	{
		ActionBot.sendKeys(driver, IPageBuyersDesk.GUIDED_ITEM_POPUP_BUYER_DESK_MANUFACTURER_NAME, name);

	}

	@Override
	public void fillManufacturerUrlInGuidedItemPopup(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, IPageBuyersDesk.GUIDED_ITEM_POPUP_BUYER_DESK_MANUFACTURER_URL, url);
	}

	@Override
	public void fillManufacturerIdInGuidedItemPopup(WebDriver driver, String testCaseName, String id) throws ActionBotException
	{
		ActionBot.sendKeys(driver, IPageBuyersDesk.GUIDED_ITEM_POPUP_BUYER_DESK_MANUFACTURER_ID, id);
	}

	@Override
	public void fillImageUrlInGuidedItemPopup(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, IPageBuyersDesk.GUIDED_ITEM_POPUP_BUYER_DESK_IMAGE_URL, url);
	}

	@Override
	public void fillProductUrlInGuidedItemPopup(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		ActionBot.sendKeys(driver, IPageBuyersDesk.GUIDED_ITEM_POPUP_BUYER_DESK_PROD_URL, url);
	}

	@Override
	public void fillSpecificationNameInGuidedItemPopup(WebDriver driver, String testCaseName, String name) throws ActionBotException
	{
		ActionBot.sendKeys(driver, IPageBuyersDesk.GUIDED_ITEM_POPUP_BUYER_DESK_SPECIFICATION_NAME, name);
	}

	@Override
	public void fillSpecificationkeyInGuidedItemPopup(WebDriver driver, String testCaseName, String key) throws ActionBotException
	{
		ActionBot.sendKeys(driver, IPageBuyersDesk.GUIDED_ITEM_POPUP_BUYER_DESK_SPECIFICATION_KEY, key);
	}

	@Override
	public void fillSpecificationValueInGuidedItemPopup(WebDriver driver, String testCaseName, String value) throws ActionBotException
	{
		ActionBot.sendKeys(driver, IPageBuyersDesk.GUIDED_ITEM_POPUP_BUYER_DESK_SPECIFICATION_VALUE, value);
	}

	@Override
	public void searchAndFillCategory(WebDriver driver, String testCaseName, String category) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, IPageBuyersDesk.FREE_TEXT_CATEGORY, category);
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public boolean isEFormFieldVisible(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, By.xpath("(.//*[contains(@id,'df_')]//label[contains(text(),'" + fieldName + "')])"));
		//return ActionBot.getTextWithInElement(driver, By.xpath("(.//*[contains(@id,'df_')]//label)[1]")).contains(fieldName);
	}

	@Override
	public void clickReqSelectedSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[@id='reqSelectedSupp']//a[contains(@class,'guided_item_supplier')])[" + index + "]"));
		ActionBot.defaultSleep();
	}

	@Override
	public void selectItemCheckBoxToConvertToPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int i = 0;
		boolean checkVisible = false;
		checkVisible = ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='chk_suggested_po_" + i + "']"));

		do
		{
			ActionBot.defaultLowSleep();
			if (checkVisible)
			{
				WebElement checkBox = ActionBot.findElement(driver, By.xpath(".//*[@id='chk_suggested_po_" + i + "']"));
				checkBox.click();
			}
			else
			{
				break;
			}
			i++;
			checkVisible = ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='chk_suggested_po_" + i + "']"));
		} while (checkVisible);
	}

	@Override
	public void clickReleasePOButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RELEASE_PO_BUTTON);
		ActionBot.defaultSleep();
	}

	@Override
	public void waitForLoadingPurchaseOrders(WebDriver driver, String testCaseName) throws ActionBotException
	{
		while (ActionBot.isElementDisplayed(driver, PROGRESSING_DIV_CONVERT_PO_BUYERS_DESK))
		{
			ActionBot.defaultLowSleep();
		}
		ActionBot.defaultSleep();
	}

	@Override
	public String fetchReqNumberForPORelease(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		return ActionBot.getTextWithInElement(driver, REQ_NUMBER_FOR_PO_RELEASE);
	}

	@Override
	public String fetchPONumberForRelease(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		return ActionBot.getTextWithInElement(driver, PO_NUMBER_FOR_RELEASE);
	}

	@Override
	public List<WebElement> fetchErrorLists(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		return ActionBot.findElements(driver, ERROR_LIST_BUYERS_DESK);
	}

	@Override
	public void clickDeliveryTabInUpdateAllLines(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, DELIVERY_TAB_UPDATE_ALL_LINES);
	}

	@Override
	public void fillMultiDeliveryOnUpdateAllLines(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, MULTIDELIVERY_ON_UPDATE_ALL_LINES);
		ActionBot.selectDate(driver, day, month, year);
	}

	@Override
	public boolean isPurchaseOrderListingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		return ActionBot.isElementDisplayed(driver, LIST_OF_PURCHASE_ORDER_TAB);
	}

	@Override
	public void enterSourcingStatus(WebDriver driver, String testCaseName, String itemSourcingStatus) throws ActionBotException
	{
		if (itemSourcingStatus.equalsIgnoreCase(IConstantsData.BUYER_NEGOTIATED_PRICE))
		{
			if (ActionBot.isElementPresent(driver, RADIO_BUYER_NEGOTIATED_PRICE))
			{
				if (ActionBot.isElementEnabled(driver, RADIO_BUYER_NEGOTIATED_PRICE))
				{
					ActionBot.click(driver, RADIO_BUYER_NEGOTIATED_PRICE);
				}
			}
		}
		else if (itemSourcingStatus.equalsIgnoreCase(IConstantsData.NEED_A_QUOTE))
		{
			ActionBot.click(driver, RADIO_NEED_A_QUOTE);
		}
	}

	@Override
	public boolean clickOnOkLinkInAddItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, SAVE_GUIDED_ITEM_BUTTON))
		{
			ActionBot.click(driver, SAVE_GUIDED_ITEM_BUTTON);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnOkSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, SAVE_REQUISITION_BUTTON))
		{

			ActionBot.click(driver, SAVE_REQUISITION_BUTTON);
			ScreenShot.screenshot(driver, testCaseName, "After clicking on save requisition icon");
			ActionBot.defaultMediumSleep();
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean clickOnCloseIconModalAddFreeTextItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		if (ActionBot.isElementPresent(driver, CLOSE_ICON_MODAL_ADD_FREE_TEXT_ITEM))
		{
			ActionBot.click(driver, CLOSE_ICON_MODAL_ADD_FREE_TEXT_ITEM);
			ScreenShot.screenshot(driver, testCaseName, "After clicking close icon");
			ActionBot.defaultMediumSleep();
			return true;
		}
		return false;
	}

	@Override
	public List<String> getListOfRequisitionItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> items = new ArrayList<>();
		List<WebElement> elements = ActionBot.findElements(driver, REQUISITION_ITEMS);
		for (WebElement element : elements)
		{
			items.add(element.getText());
		}
		return items;
	}

	@Override
	public String getProductCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TEXT_PRODUCT_CATEGORY))
		{
			return ActionBot.getTextWithInElement(driver, TEXT_PRODUCT_CATEGORY);
		}
		return null;
	}

	@Override
	public String getItemUOM(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TEXT_UOM))
		{
			return ActionBot.getAttributeOfElement(driver, TEXT_UOM, "value");
		}
		return null;
	}

	@Override
	public String getItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TEXT_QUANTITY))
		{
			return ActionBot.getTextWithInElement(driver, TEXT_QUANTITY);
		}
		return null;
	}

	@Override
	public String getItemUOMDescription(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, UOM_DESCRIPTION))
		{
			return ActionBot.getTextWithInElement(driver, UOM_DESCRIPTION);
		}
		return null;
	}

	@Override
	public String getItemPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, TEXT_PRICE))
		{
			return ActionBot.getTextWithInElement(driver, TEXT_PRICE);
		}
		return null;
	}

	@Override
	public boolean checkForPriceError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, PRICE_ERROR))
		{
			ActionBot.defaultSleep();
			return true;
		}
		return false;
	}

	@Override
	public String getSourcingStatusLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, SOURCING_STATUS_LABEL))
		{
			return ActionBot.getTextWithInElement(driver, SOURCING_STATUS_LABEL);
		}
		return null;
	}

	@Override
	public String getItemCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, TEXT_CURRENCY))
		{
			return ActionBot.getTextWithInElement(driver, TEXT_CURRENCY);
		}
		return null;
	}

	@Override
	public String getManufacturerName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, TEXT_MANUFACTURER_NAME))
		{
			return ActionBot.getTextWithInElement(driver, TEXT_MANUFACTURER_NAME);
		}
		return null;
	}

	@Override
	public String getManufacturerPartId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, TEXT_MANUFACTURER_PART_ID))
		{
			return ActionBot.getTextWithInElement(driver, TEXT_MANUFACTURER_PART_ID);
		}
		return null;
	}

	@Override
	public String getSpecificationName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, TEXT_SPECIFICATION_NAME))
		{
			return ActionBot.getTextWithInElement(driver, TEXT_SPECIFICATION_NAME);
		}
		return null;
	}

	@Override
	public String getSpecificationKey(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, TEXT_SPECIFICATION_KEY))
		{
			return ActionBot.getTextWithInElement(driver, TEXT_SPECIFICATION_KEY);
		}
		return null;
	}

	@Override
	public String getSpecificationValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, TEXT_SPECIFICATION_VALUE))
		{
			return ActionBot.getTextWithInElement(driver, TEXT_SPECIFICATION_VALUE);
		}
		return null;
	}

	@Override
	public String getImageURL(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, TEXT_IMAGE_URL))
		{
			return ActionBot.getTextWithInElement(driver, TEXT_IMAGE_URL);
		}
		return null;
	}

	@Override
	public String getProductURL(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, TEXT_PRODUCT_URL))
		{
			return ActionBot.getTextWithInElement(driver, TEXT_PRODUCT_URL);
		}
		return null;
	}

	@Override
	public String getManufacturerURL(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, TEXT_MANUFACTURER_URL))
		{
			return ActionBot.getTextWithInElement(driver, TEXT_MANUFACTURER_URL);
		}
		return null;
	}

	@Override
	public boolean isAddSpecificationButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_SPECIFICATION_ADD);
	}

	@Override
	public boolean isSupplierNameMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, MANDATORY_SUPPLIER_NAME);
	}

	@Override
	public boolean isSupplierAddressMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, MANDATORY_SUPPLIER_ADDRESS);
	}

	@Override
	public boolean isContractNumberEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXT_CONTRACT_NUMBER);
	}

	@Override
	public boolean checkForItemNameError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, NAME_ERROR);
	}

	@Override
	public boolean checkForProductCategoryError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, PRODUCT_CATEGORY_ERROR);
	}

	@Override
	public String fillRequirementDetails(WebDriver driver, String testCaseName, String requirementDetails) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, REQUIREMENT_DETAILS_TEXTBOX))
		{
			return ActionBot.sendKeys(driver, REQUIREMENT_DETAILS_TEXTBOX, requirementDetails);
		}
		return null;
	}

	@Override
	public boolean isRequirementDetailsErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, REQUIREMENT_DETAILS_ERROR))
		{
			return (ActionBot.getTextWithInElement(driver, REQUIREMENT_DETAILS_ERROR).contains("should not exceed 40 chars"));
		}
		return false;
	}

	@Override
	public boolean isAddedItemSuccessMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, ADDED_ITEM_SUCCESS_MESSAGE);
	}

	@Override
	public String getRequisitionDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, REQUISITION_DELIVERY_ADDRESS))
		{
			return ActionBot.getTextWithInElement(driver, REQUISITION_DELIVERY_ADDRESS);
		}
		return null;
	}

	@Override
	public String getRequisitionItemDeliveryAddress(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, REQUISITION_ITEM_DELIVERY_ADDRESS))
		{
			return ActionBot.findElements(driver, REQUISITION_ITEM_DELIVERY_ADDRESS).get(index).getText();
		}
		return null;
	}

	@Override
	public String getRequisitionItemCostCenter(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, REQUISITION_ITEM_COST_CENTER))
		{
			return ActionBot.findElements(driver, REQUISITION_ITEM_COST_CENTER).get(index).getText();
		}
		return null;
	}

	@Override
	public void selectEFormForCategoryNamewise(WebDriver driver, String testcaseName, String eformName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[@id='selectGuidedCategory']//div[contains(@title,'" + eformName + "')]")))
			ActionBot.click(driver, By.xpath(".//*[@id='selectGuidedCategory']//div[contains(@title,'" + eformName + "')]"));
		ActionBot.defaultSleep();
	}

}
