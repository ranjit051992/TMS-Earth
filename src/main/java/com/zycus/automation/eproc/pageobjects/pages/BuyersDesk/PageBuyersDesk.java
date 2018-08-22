package com.zycus.automation.eproc.pageobjects.pages.BuyersDesk;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm.IPageFreeTextForm;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

public class PageBuyersDesk
{

	static Logger logger = Logger.getLogger(PageBuyersDesk.class);

	/*
	 * public void get() { IPageBuyersDesk buyersDesk = new
	 * IPageBuyersDeskImpl(); buyersDesk.getRequistionNanme(driver,
	 * testCaseName); }
	 */

	public static String getRequistionName(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String reqName = null;
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			reqName = buyersDesk.getRequistionNanme(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequistionNanme " + e, e);
		}
		return reqName;

	}

	public static String getResonForOrdering(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String ResonForOrdering = null;
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			ResonForOrdering = buyersDesk.getResonForOrdering(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getResonForOrdering " + e, e);
		}
		return ResonForOrdering;

	}

	public static String getCommentsForSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String CommentsForSupplier = null;
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			CommentsForSupplier = buyersDesk.getCommentsForSupplier(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getCommentsForSupplier " + e, e);
		}
		return CommentsForSupplier;

	}

	public static String getAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String AssignedBuyer = null;
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			AssignedBuyer = buyersDesk.getAssignedBuyer(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAssignedBuyer " + e, e);
		}
		return AssignedBuyer;

	}

	public static String getDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String DeliveryAddress = null;
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			DeliveryAddress = buyersDesk.getDeliveryAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getDeliveryAddress " + e, e);
		}
		return DeliveryAddress;

	}

	public static String getBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String BillToAddress = null;
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			BillToAddress = buyersDesk.getBillToAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getBillToAddress " + e, e);
		}
		return BillToAddress;

	}

	public static void clickOnExpandAllLink(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickOnExpandAllLink(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnExpandAllLink " + e, e);
		}

	}

	public static void clickOnItemNoLink(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickOnItemNoLink(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnItemNoLink " + e, e);
		}

	}

	public static void clickOnApplyallLink(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickOnApplyallLink(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnApplyallLink " + e, e);
		}

	}

	public static void clickOnUpdateAllLink(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickOnUpdateAllLink(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnUpdateAllLink " + e, e);
		}

	}

	public static void clickOnConvertToPo(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickOnConvertToPo(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnConvertToPo " + e, e);
		}

	}

	public static void selectItemCheckBoxsToConvertToPO(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.selectItemCheckBoxToConvertToPO(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectItemCheckBoxToConvertToPO " + e, e);
		}

	}

	public static void clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickOnSave(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnSave " + e, e);
		}

	}

	public static void clickOnReturn(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickOnReturn(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnReturn " + e, e);
		}

	}

	public static void clickOnCancel(WebDriver driver, String testCaseName) throws ActionBotException
	{

		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickOnCancel(driver, testCaseName);

		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnCancel " + e, e);
		}

	}

	public static String getUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String UnitPrice = null;
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			UnitPrice = buyersDesk.getUnitPrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getUnitPrice " + e, e);
		}
		return UnitPrice;

	}

	public static String getQty(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String Qty = null;
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			Qty = buyersDesk.getQty(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequistionNanme " + e, e);
		}
		return Qty;

	}

	public static String fillReqChangeComment(WebDriver driver, String testCaseName, String requeComment) throws ActionBotException
	{

		String ReqChangeComment = null;
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			ReqChangeComment = buyersDesk.fillReqChangeComment(driver, testCaseName, requeComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequistionNanme " + e, e);
		}
		return ReqChangeComment;

	}

	public static int fillItemPrice(WebDriver driver, String testCaseName, int itemPrice, String itemId) throws ActionBotException, TestCaseException
	{

		int itemPrice1 = 0;
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			itemPrice1 = buyersDesk.fillItemPrice(driver, testCaseName, itemPrice, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillItemPrice " + e, e);
		}
		return itemPrice1;

	}

	public static String fillGLAccount(WebDriver driver, String testCaseName, String glaccount) throws ActionBotException
	{

		String glaccount1 = null;
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			glaccount1 = buyersDesk.fillGLAccount(driver, testCaseName, glaccount1);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillGLAccount " + e, e);
		}
		return glaccount1;

	}

	public static String fetchGLAccount(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String glaccount1 = null;
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			glaccount1 = buyersDesk.fetchGLAccount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchGLAccount " + e, e);
		}
		return glaccount1;

	}

	public static String fillCommentsForSupplier(WebDriver driver, String testCaseName, String commentForSupplier) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.fillCommentsForSupplier(driver, testCaseName, commentForSupplier);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCommentsForSupplier " + e, e);
		}
		return null;
	}

	public static String fillAssignedBuyer(WebDriver driver, String testCaseName, String assignedBuyerName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.fillAssignedBuyer(driver, testCaseName, assignedBuyerName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillAssignedBuyer " + e, e);
		}
		return null;
	}

	public static void clickOnBDCLINK(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickOnBDCLINK(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnBDCLINK " + e, e);
		}
	}

	public static void clickEditItemSummary(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickEditItemSummary(driver, testCaseName, itemID);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickEditItemSummary " + e, e);
		}
	}

	public static void waitTillUpdateProcessingDivIsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.waitTillUpdateProcessingDivIsPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitTillUpdateProcessingDivIsPresent " + e, e);
		}
	}

	public static boolean isAlertPopupForValidationPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isAlertPopupForValidationPresent(driver, testCaseName);
	}

	public static void clickOnOKForAlert(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOnOKForAlert(driver, testCaseName);
	}

	public static void clickOnItemName(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOnItemName(driver, testCaseName, itemId);
	}

	public static void clickOnModifyWorkflowSetting(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOnModifyWorkflowSetting(driver, testCaseName);
	}

	public static boolean isModifyWorkflowSettingPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isModifyWorkflowSettingPresent(driver, testCaseName);
	}

	public static boolean isModifyWorkflowSettingQtipPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isModifyWorkflowSettingQtipPresent(driver, testCaseName);
	}

	public static void clickOnSendForApproval(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOnSendForApproval(driver, testCaseName);
	}

	public static void clickOnReturnToRequester(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOnReturnToRequester(driver, testCaseName);
	}

	public static void clickOnRemoveBuyerLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOnRemoveBuyerLink(driver, testCaseName);
	}

	public static String getAssignedBuyerName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getAssignedBuyerName(driver, testCaseName);
	}

	public static void clickOnFirstItemEdit(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOnFirstItemEdit(driver, testCaseName);
	}

	public static void clickOnReplaceItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOnReplaceItem(driver, testCaseName, itemId);
	}

	public static void clearAssignedBuyer(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clearAssignedBuyer(driver, testCaseName);
	}

	public static String getItemNo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getItemNo(driver, testCaseName);
	}

	public static boolean isUnitPriceExceedingToleranceLevelErrorPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isUnitPriceExceedingToleranceLevelErrorPresent(driver, testCaseName, itemId);
	}

	public static boolean isQuantityExceedingToleranceLevelErrorPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isQuantityExceedingToleranceLevelErrorPresent(driver, testCaseName, itemId);
	}

	public static int fillQuantity(WebDriver driver, String testCaseName, String itemId, int quantity) throws ActionBotException, TestCaseException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.fillQuantity(driver, testCaseName, itemId, quantity);
	}

	public static String getReqChangeComments(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getReqChangeComments(driver, testCaseName);
	}

	public static boolean isCostingSplitPresentAtItemLevel(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isCostingSplitPresentAtItemLevel(driver, testCaseName, itemId);
	}

	public static String getHeaderTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getHeaderTotalPrice(driver, testCaseName);
	}

	public static String getItemLevelSubTotalPrice(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getItemLevelSubTotalPrice(driver, testCaseName, itemId);
	}

	public static String getItemAccountingLevelPrice(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getItemAccountingLevelPrice(driver, testCaseName, itemId);
	}

	public static void clickOnCollapseAllItemsLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOnCollapseAllItemsLink(driver, testCaseName);
	}

	public static boolean isConvertToPOOptionPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isConvertToPOOptionPresent(driver, testCaseName);
	}

	public static String getItemSupplier(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getItemSupplier(driver, testCaseName, itemId);
	}

	public static boolean isItemSupplierPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isItemSupplierPresent(driver, testCaseName, itemId);
	}

	public static String getNeedAQuoteHelpText(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getNeedAQuoteHelpText(driver, testCaseName, itemId);
	}

	public static boolean isExpandAllLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isExpandAllLinkPresent(driver, testCaseName);
	}

	public static void clickOnSelectItemToUncheck(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOnSelectItemToUncheck(driver, testCaseName, itemId);
	}

	public static boolean isItemNameLinkPresent(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isItemNameLinkPresent(driver, testCaseName, itemId);
	}

	public static void clickOnCreateSourcingEventButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOnCreateSourcingEventButton(driver, testCaseName);
	}

	public static boolean clickOnCreateFreeTextItem(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		//call
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.clickOnCreateFreeTextItem(driver, testCaseName);
	}

	public static boolean hoverOnActionButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return IPageBuyersDeskImpl.hoverOnActionButton(driver, testCaseName);
	}

	public static String enterItemNumber(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterItemNumber(driver, testCaseName, itemNumber);
	}

	public static String enterItemShortDescription(WebDriver driver, String testCaseName, String itemShortDescription) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterItemShortDescription(driver, testCaseName, itemShortDescription);
	}

	public static String enterItemLongDescription(WebDriver driver, String testCaseName, String itemLongDescription) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterItemLongDescription(driver, testCaseName, itemLongDescription);
	}

	public static String enterProductCategory(WebDriver driver, String testCaseName, String productCategory) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterProductCategory(driver, testCaseName, productCategory);
	}

	public static String enterItemQuantity(WebDriver driver, String testCaseName, String itemQuantity) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterItemQuantity(driver, testCaseName, itemQuantity);
	}

	public static String enterItemPrice(WebDriver driver, String testCaseName, String itemPrice) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterItemPrice(driver, testCaseName, itemPrice);
	}

	public static String enterItemCurrency(WebDriver driver, String testCaseName, String itemCurrency) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterItemCurrency(driver, testCaseName, itemCurrency);
	}

	public static String enterItemUOM(WebDriver driver, String testCaseName, String uom) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterItemUOM(driver, testCaseName, uom);
	}

	public static String enterSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterSupplierName(driver, testCaseName, supplierName);
	}

	public static void selectSupplierAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.selectSupplierAddress(driver, testCaseName);
	}

	public static void clickAddItemsButton(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickAddItemsButton(driver, testCaseName);
	}

	public static void clickSuppliersTab(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickSuppliersTab(driver, testCaseName);
	}

	public static boolean isFreeTextItemCreated(WebDriver driver, String testCaseName, String itemNumber) throws FactoryMethodException, ActionBotException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isFreeTextItemCreated(driver, testCaseName, itemNumber);
	}

	public static boolean verifyButtonAddItems(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.verifyButtonAddItems(driver, testCaseName);
	}

	public static boolean clickOnCancelLinkInAddItems(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.clickOnCancelLinkInAddItems(driver, testCaseName);
	}

	public static void clickOnCancelAndGoBackButton(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOnCancelAndGoBackButton(driver, testCaseName);
	}

	public static void clickOnCancelAndGoBackLink(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOnCancelAndGoBackLink(driver, testCaseName);
	}

	public static boolean isDuplicateItemCreated(WebDriver driver, String testCaseName, String itemNumber) throws FactoryMethodException, ActionBotException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isDuplicateItemCreated(driver, testCaseName, itemNumber);
	}

	public static boolean verifyProductCategoryFieldDefaultValue(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.verifyProductCategoryFieldDefaultValue(driver, testCaseName);
	}

	public static void clickRequirementDetailsTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickRequirementDetailsTab(driver, testCaseName);
	}

	public static boolean isEformPresentInRequirementTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isEformPresentInRequirementTab(driver, testCaseName);
	}

	public static void clickItemTab(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickItemTab(driver, testCaseName);
	}

	public static boolean isEformDialogPresent(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isEformDialogPresent(driver, testCaseName);
	}

	public static boolean isCategoryOnEformDisplayed(WebDriver driver, String testCaseName, String productCategory_1) throws FactoryMethodException, ActionBotException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isCategoryOnEformDisplayed(driver, testCaseName, productCategory_1);
	}

	public static int getEformCount(WebDriver driver, String testCaseName, int eformCount) throws FactoryMethodException, ActionBotException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getEformCount(driver, testCaseName, eformCount);
	}

	public static int getEformListCount(WebDriver driver, String testCaseName, int eformListCount) throws FactoryMethodException, ActionBotException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getEformListCount(driver, testCaseName, eformListCount);
	}

	public static void clickEformFromList(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickEformFromList(driver, testCaseName);
	}

	public static void clickOnCancelLinkEformDialog(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOnCancelLinkEformDialog(driver, testCaseName);
	}

	public static boolean checkForQuantityError(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.checkForQuantityError(driver, testCaseName);
	}

	public static boolean verifySourcingStatusValue(WebDriver driver, String testCaseName, String sourcingStatus) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.verifySourcingStatusValue(driver, testCaseName, sourcingStatus);
	}

	public static void clickShowExtraFieldsLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickShowExtraFieldsLink(driver, testCaseName);
	}

	public static String enterManufacturerName(WebDriver driver, String testCaseName, String manufacturerName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterManufacturerName(driver, testCaseName, manufacturerName);
	}

	public static String enterManufacturerPartId(WebDriver driver, String testCaseName, String manufacturerPartId) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterManufacturerPartId(driver, testCaseName, manufacturerPartId);
	}

	public static String enterSpecificationName(WebDriver driver, String testCaseName, String specificationName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterSpecificationName(driver, testCaseName, specificationName);
	}

	public static String enterSpecificationKey(WebDriver driver, String testCaseName, String specificationKey) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterSpecificationKey(driver, testCaseName, specificationKey);
	}

	public static String enterSpecificationValue(WebDriver driver, String testCaseName, String specificationValue) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterSpecificationValue(driver, testCaseName, specificationValue);
	}

	public static void clickAddSpecificationButton(WebDriver driver, String testCaseName, String specificationCount) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickAddSpecificationButton(driver, testCaseName, specificationCount);
	}

	public static String enterImageUrl(WebDriver driver, String testCaseName, String imageUrl) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterImageUrl(driver, testCaseName, imageUrl);
	}

	public static String enterProductUrl(WebDriver driver, String testCaseName, String productUrl) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterProductUrl(driver, testCaseName, productUrl);
	}

	public static String enterManufacturerUrl(WebDriver driver, String testCaseName, String manufacturerUrl) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterManufacturerUrl(driver, testCaseName, manufacturerUrl);
	}

	public static boolean checkForSupplierNameError(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.checkForSupplierNameError(driver, testCaseName);
	}

	public static String enterAddressRequirementTab(WebDriver driver, String testCaseName, String addressRequirementTab) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterAddressRequirementTab(driver, testCaseName, addressRequirementTab);
	}

	public static boolean verifyErrorInRequirementTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.verifyErrorInRequirementTab(driver, testCaseName);
	}

	public static void clearAddressRequirementTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clearAddressRequirementTab(driver, testCaseName);
	}

	public static boolean clickShowAllButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.clickShowAllButton(driver, testCaseName);
	}

	public static String selectBPONumber(WebDriver driver, String testCaseName, String bpoNumber) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.selectBPONumber(driver, testCaseName, bpoNumber);
	}

	public static boolean verifyBPOSelected(WebDriver driver, String testCaseName, String bpoNumber) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.verifyBPOSelected(driver, testCaseName, bpoNumber);
	}

	public static String enterContractNumber(WebDriver driver, String testCaseName, String contractNumber) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterContractNumber(driver, testCaseName, contractNumber);
	}

	public static String enterReqChangeComments(WebDriver driver, String testCaseName, String reqChangeComments) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterReqChangeComments(driver, testCaseName, reqChangeComments);
	}

	public static void clickReturnToRequestorButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickReturnToRequestorButton(driver, testCaseName);
	}

	public static void clickConfirmReturnToReq_Yes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickConfirmReturnToReq_Yes(driver, testCaseName);
	}

	public static boolean clickConfimSave_Save(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.clickConfimSave_Save(driver, testCaseName);
	}

	public static void clickAccountingEditLinkForFreeTextItem(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickAccountingEditLinkForFreeTextItem(driver, testCaseName);
	}

	public static String selectGLAccount(WebDriver driver, String testCaseName, String glAccount) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.selectGLAccount(driver, testCaseName, glAccount);
	}

	public static void clickAddItemsButtonToReq(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickAddItemsButtonToReq(driver, testCaseName);
	}

	public static boolean isCatalogItemAdded(WebDriver driver, String testCaseName, String searchItemName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isCatalogItemAdded(driver, testCaseName, searchItemName);
	}

	public static void clickEditLinkForBillingDeliverySummary(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickEditLinkForBillingDeliverySummary(driver, testCaseName);
	}

	public static void clickCostAllocationTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickCostAllocationTab(driver, testCaseName);
	}

	public static String enterCostCenterSummary(WebDriver driver, String testCaseName, String costCenterSummary) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterCostCenterSummary(driver, testCaseName, costCenterSummary);
	}

	public static String enterProjectSummary(WebDriver driver, String testCaseName, String projectSummary) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterProjectSummary(driver, testCaseName, projectSummary);
	}

	public static String enterBudgetSummary(WebDriver driver, String testCaseName, String budgetSummary) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterBudgetSummary(driver, testCaseName, budgetSummary);
	}

	public static void clickOkButtonForReqSummary(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOkButtonForReqSummary(driver, testCaseName);
	}

	public static boolean verifyCreateFreeTextItemModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.verifyCreateFreeTextItemModal(driver, testCaseName);
	}

	public static boolean verifyCostcenterProjectBudgetUpdatedValues(WebDriver driver, String testCaseName, String costCenterSummary, String projectSummary, String budgetSummary)
		throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.verifyCostcenterProjectBudgetUpdatedValues(driver, testCaseName, costCenterSummary, projectSummary, budgetSummary);
	}

	public static boolean clickConfimSave_DontSave(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.clickConfirmSave_DontSave(driver, testCaseName);
	}

	public static boolean verifyReplaceIconEnabledForFreeTextItem(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.verifyReplaceIconEnabledForFreeTextItem(driver, testCaseName, itemNumber);
	}

	public static String getFreeTextItemDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getFreeTextItemDeliveryAddress(driver, testCaseName);
	}

	public static String getReqDeliveryAddressHeaderlevel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getReqDeliveryAddressHeaderlevel(driver, testCaseName);
	}

	public static String getFreeTextItemCostCenter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getFreeTextItemCostCenter(driver, testCaseName);
	}

	public static String getReqCostCenterHeaderLevel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getReqCostCenterHeaderLevel(driver, testCaseName);
	}

	public static String getReqOUCompany(WebDriver driver, String testCaseName, String ouCompany) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getReqOUCompany(driver, testCaseName, ouCompany);
	}

	public static String getReqOUBusinessUnit(WebDriver driver, String testCaseName, String ouBusinessUnit) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getReqOUBusinessUnit(driver, testCaseName, ouBusinessUnit);
	}

	public static String getReqOULocation(WebDriver driver, String testCaseName, String ouLocation) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getReqOULocation(driver, testCaseName, ouLocation);
	}

	public static String getCreatedReqNumber(WebDriver driver, String testCaseName, String reqNumber) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getCreatedReqNumber(driver, testCaseName, reqNumber);
	}

	public static void clickCostAtLineLevelRadioButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickCostAtLineLevelRadioButton(driver, testCaseName);
	}

	public static void clickEditLinkForCostBookingItemLevel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickEditLinkForCostBookingItemLevel(driver, testCaseName);
	}

	public static void enterGLAccountForCostBookingItemLevel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.enterGLAccountForCostBookingItemLevel(driver, testCaseName);
	}

	public static String enterCostCenterForCostBookingItemLevel(WebDriver driver, String testCaseName, String costCenter) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterCostCenterForCostBookingItemLevel(driver, testCaseName, costCenter);
	}

	public static String enterProjectForCostBookingItemLevel(WebDriver driver, String testCaseName, String project) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterProjectForCostBookingItemLevel(driver, testCaseName, project);
	}

	public static String enterBudgetForCostBookingItemLevel(WebDriver driver, String testCaseName, String budget) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.enterBudgetForCostBookingItemLevel(driver, testCaseName, budget);
	}

	public static void clickButtonOkCostAllocationTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickButtonOkCostAllocationTab(driver, testCaseName);
	}

	public static void updateFreeTextItemPrice(WebDriver driver, String testCaseName, String itemPrice, String itemNumber) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.updateFreeTextItemPrice(driver, testCaseName, itemPrice, itemNumber);
	}

	public static void updateFreeTextItemQuantity(WebDriver driver, String testCaseName, String itemQuantity, String itemNumber) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.updateFreeTextItemQuantity(driver, testCaseName, itemQuantity, itemNumber);
	}

	public static boolean isToleranceErrorDisplayed(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isToleranceErrorDisplayed(driver, testCaseName);
	}

	public static void clickEditLinkForFreeTextItem(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickEditLinkForFreeTextItem(driver, testCaseName, itemNumber);
	}

	public static boolean verifyReplaceIconEnabled(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.verifyReplaceIconEnabled(driver, testCaseName, itemNumber);
	}

	public static String getReqDefaultItemName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getReqDefaultItemName(driver, testCaseName);
	}

	public static String getItemDescription(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getItemDescription(driver, testCaseName);
	}

	public static void clickCloseOnItemPopUp(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickCloseOnItemPopUp(driver, testCaseName);
	}

	public static void clickOnFreeTextItemNumber(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickOnFreeTextItemNumber(driver, testCaseName, itemNumber);
	}

	public static void clickOnItemLinkDiscriptionIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickOnItemLinkDiscriptionIndexwise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnItemLinkDiscriptionIndexwise " + e, e);
		}
	}

	public static void clickOnSupplierTabInFreeText(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickOnSupplierTabInFreeText(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSupplierTabInFreeText " + e, e);
		}
	}

	public static String getFreeTextSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getFreeTextSupplier(driver, testCaseName);
	}

	public static boolean editContractNumber(WebDriver driver, String testCaseName, String newContractNumber) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.editContractNumber(driver, testCaseName, newContractNumber);
	}

	public static String getReqPurchaseCurrencyType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getReqPurchaseCurrencyType(driver, testCaseName);
	}

	public static boolean verifyButtonConvertToPo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.verifyButtonConvertToPo(driver, testCaseName);
	}

	public static int clickItemCheckbox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.clickItemCheckbox(driver, testCaseName);
	}

	public static void clickItemCheckboxIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickItemCheckboxIndexwise(driver, testCaseName, index);
	}	

	public static void clickAuditTrailLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickAuditTrailLink(driver, testCaseName);
	}

	public static String getAuditTrailMessage(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getAuditTrailMessage(driver, testCaseName);
	}

	public static void clickEditLinkForAssignedBuyerItemLevel(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		ActionBot.defaultSleep();
		buyersDesk.clickEditLinkForAssignedBuyerItemLevel(driver, testCaseName);
	}

	public static String getSelectedItemType(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getSelectedItemType(driver, testCaseName);
	}

	public static String getSelectedReceivedBy(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getSelectedReceivedBy(driver, testCaseName);
	}

	public static boolean isRadioButtonReceiveByNoReceiptEnabled(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isRadioButtonReceiveByNoReceiptEnabled(driver, testCaseName);
	}

	public static String getSelectedIsGreen(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getSelectedIsGreen(driver, testCaseName);
	}

	public static String getSelectedIsPreferred(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getSelectedIsPreferred(driver, testCaseName);
	}

	public static void clickDeleteItemIcon(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickDeleteItemIcon(driver, testCaseName, itemNumber);
	}

	public static int getAuditTrailVersion(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getAuditTrailVersion(driver, testCaseName);
	}

	public static void clickButtonShowAllPo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickButtonShowAllPo(driver, testCaseName);
	}

	public static String getFirstPoNumber(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.getFirstPoNumber(driver, testCaseName);
	}

	public static void selectFirstPoRadioButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.selectFirstPoRadioButton(driver, testCaseName);
	}

	public static void clickButtonSelectOnPoModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.clickButtonSelectOnPoModal(driver, testCaseName);
	}

	public static boolean isReqItemDisplayedOnPOPage(WebDriver driver, String testCaseName, String itemNumber) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		return buyersDesk.isReqItemDisplayedOnPOPage(driver, testCaseName, itemNumber);
	}

	public static void fillPoNumberFilterPomodal(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException, FactoryMethodException
	{
		IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
		buyersDesk.fillPoNumberFilterPomodal(driver, testCaseName, poNumber);
	}

	public static void clickReqRowise(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickReqRowise(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickReqRowise " + e, e);
		}
	}

	public static void clickCloseItemDetailPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickCloseItemDetailPopup(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickCloseItemDetailPopup " + e, e);
		}
	}

	public static void clickShowMoreExtraFields(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickShowMoreExtraFields(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickShowMoreExtraFields " + e, e);
		}
	}

	public static void fillManufacturerNameInGuidedItemPopup(WebDriver driver, String testCaseName, String name) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.fillManufacturerNameInGuidedItemPopup(driver, testCaseName, name);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillManufacturerNameInGuidedItemPopup " + e, e);
		}
	}

	public static void fillManufacturerUrlInGuidedItemPopup(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.fillManufacturerUrlInGuidedItemPopup(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillManufacturerUrlInGuidedItemPopup " + e, e);
		}
	}

	public static void fillManufacturerIdInGuidedItemPopup(WebDriver driver, String testCaseName, String id) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.fillManufacturerIdInGuidedItemPopup(driver, testCaseName, id);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillManufacturerIdInGuidedItemPopup " + e, e);
		}
	}

	public static void fillImageUrlInGuidedItemPopup(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.fillImageUrlInGuidedItemPopup(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillImageUrlInGuidedItemPopup " + e, e);
		}
	}

	public static void fillProductUrlInGuidedItemPopup(WebDriver driver, String testCaseName, String url) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.fillProductUrlInGuidedItemPopup(driver, testCaseName, url);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillProductUrlInGuidedItemPopup " + e, e);
		}
	}

	public static void fillSpecificationNameInGuidedItemPopup(WebDriver driver, String testCaseName, String name) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.fillSpecificationNameInGuidedItemPopup(driver, testCaseName, name);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSpecificationNameInGuidedItemPopup " + e, e);
		}
	}

	public static void fillSpecificationkeyInGuidedItemPopup(WebDriver driver, String testCaseName, String key) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.fillSpecificationkeyInGuidedItemPopup(driver, testCaseName, key);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSpecificationkeyInGuidedItemPopup " + e, e);
		}
	}

	public static void fillSpecificationValueInGuidedItemPopup(WebDriver driver, String testCaseName, String value) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.fillSpecificationValueInGuidedItemPopup(driver, testCaseName, value);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSpecificationValueInGuidedItemPopup " + e, e);
		}
	}

	public static void searchAndFillCategory(WebDriver driver, String testCaseName, String category) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.searchAndFillCategory(driver, testCaseName, category);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method searchAndFillCategory " + e, e);
		}
	}

	public static boolean isEFormFieldVisible(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.isEFormFieldVisible(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isEFormFieldVisible " + e, e);
		}
		return false;
	}

	public static void clickReqSelectedSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickReqSelectedSupplier(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickReqSelectedSupplier " + e, e);
		}
	}

	public static void clickReleasePOButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickReleasePOButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickReleasePOButton " + e, e);
		}
	}

	public static void waitForLoadingPurchaseOrders(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.waitForLoadingPurchaseOrders(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitForLoadingPurchaseOrders " + e, e);
		}
	}

	public static String fetchReqNumberForPORelease(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.fetchReqNumberForPORelease(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchReqNumberForPORelease " + e, e);
		}
		return null;
	}

	public static String fetchPONumberForRelease(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.fetchPONumberForRelease(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchPONumberForRelease " + e, e);
		}
		return null;
	}

	public static List<WebElement> fetchErrorLists(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.fetchErrorLists(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fetchPONumberForRelease " + e, e);
		}
		return null;
	}

	public static void clickDeliveryTabInUpdateAllLines(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickDeliveryTabInUpdateAllLines(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method waitForLoadingPurchaseOrders " + e, e);
		}
	}

	public static void fillMultiDeliveryOnUpdateAllLines(WebDriver driver, String testCaseName, String Date, String Month, String Year) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.fillMultiDeliveryOnUpdateAllLines(driver, testCaseName, Date, Month, Year);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMultiDeliveryOnUpdateAllLines " + e, e);
		}
	}

	public static boolean isPurchaseOrderListingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.isPurchaseOrderListingTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isPurchaseOrderListingTab " + e, e);
		}
		return false;
	}

	public static boolean clickOnOKButtonOnReturnToReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			By okButton = By.xpath("//button[@role='button']/span[@class='ui-button-text'][contains(text(),'Yes')]");
			ActionBot.click(driver, okButton);
			return true;
		}
		catch (Exception e)
		{
			logger.error("Factory Method Exception in method isPurchaseOrderListingTab " + e, e);
			return false;
		}
	}

	public static void enterSourcingStatus(WebDriver driver, String testCaseName, String itemSourcingStatus) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.enterSourcingStatus(driver, testCaseName, itemSourcingStatus);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMultiDeliveryOnUpdateAllLines " + e, e);
		}

	}

	public static void clickOnOkLinkInAddItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.clickOnOkLinkInAddItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMultiDeliveryOnUpdateAllLines " + e, e);
		}

	}

	public static boolean clickOnOkSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageBuyersDesk buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.clickOnOkSaveButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillMultiDeliveryOnUpdateAllLines " + e, e);
		}
		return false;
	}

	public static boolean clickOnCloseIconModalAddFreeTextItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.clickOnCloseIconModalAddFreeTextItem(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseIconModalAddFreeTextItem " + e, e);
		}
		return false;
	}

	public static List<String> getListOfRequisitionItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getListOfRequisitionItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfRequisitionItems " + e, e);

		}
		return null;
	}

	public static String getProductCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getProductCategory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getProductCategory " + e, e);

		}
		return null;
	}

	public static String getItemUOM(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getItemUOM(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemUOM " + e, e);
		}
		return null;
	}

	public static String getItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getItemQuantity(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemQuantity " + e, e);
		}
		return null;
	}

	public static String getItemUOMDescription(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getItemUOMDescription(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemUOMDescription " + e, e);
		}
		return null;
	}

	public static String getItemPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getItemPrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemPrice " + e, e);
		}
		return null;
	}

	public static boolean checkForPriceError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.checkForPriceError(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkForPriceError " + e, e);
		}
		return false;
	}

	public static String getSourcingStatusLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getSourcingStatusLabel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSourcingStatusLabel " + e, e);
		}
		return null;
	}

	public static String getManufacturerName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getManufacturerName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getManufacturerName " + e, e);
		}
		return null;
	}

	public static String getManufacturerPartId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getManufacturerPartId(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getManufacturerPartId " + e, e);
		}
		return null;
	}

	public static String getSpecificationName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getSpecificationName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSpecificationName " + e, e);
		}
		return null;
	}

	public static String getItemCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getItemCurrency(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemCurrency " + e, e);
		}
		return null;
	}

	public static String getSpecificationKey(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getSpecificationKey(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSpecificationKey " + e, e);
		}
		return null;
	}

	public static String getSpecificationValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getSpecificationValue(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSpecificationValue " + e, e);
		}
		return null;
	}

	public static String getImageURL(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getImageURL(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getImageURL " + e, e);
		}
		return null;
	}

	public static String getProductURL(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getProductURL(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getProductURL " + e, e);
		}
		return null;
	}

	public static String getManufacturerURL(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getManufacturerURL(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getManufacturerURL " + e, e);
		}
		return null;
	}

	public static boolean isAddSpecificationButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.isAddSpecificationButtonPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAddSpecificationButtonPresent " + e, e);
		}
		return false;
	}

	public static boolean isSupplierNameMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.isSupplierNameMandatory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSupplierNameMandatory " + e, e);
		}
		return false;
	}

	public static boolean isSupplierAddressMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.isSupplierAddressMandatory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSupplierAddressMandatory " + e, e);
		}
		return false;
	}

	public static boolean isContractNumberEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.isContractNumberEditable(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isContractNumberEditable " + e, e);
		}
		return false;
	}

	public static boolean checkForItemNameError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.checkForItemNameError(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkForItemNameError " + e, e);
		}
		return false;
	}

	public static boolean checkForProductCategoryError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.checkForProductCategoryError(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkForProductCategoryError " + e, e);
		}
		return false;
	}

	public static String fillRequirementDetails(WebDriver driver, String testCaseName, String requirementDetails) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.fillRequirementDetails(driver, testCaseName, requirementDetails);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillRequirementDetails " + e, e);
		}
		return null;
	}

	public static boolean isRequirementDetailsErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.isRequirementDetailsErrorPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isRequirementDetailsErrorPresent " + e, e);
		}
		return false;
	}

	public static boolean isAddedItemSuccessMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.isAddedItemSuccessMessagePresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAddedItemSuccessMessagePresent " + e, e);
		}
		return false;
	}

	public static String getRequisitionDeliveryAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getRequisitionDeliveryAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequisitionDeliveryAddress " + e, e);
		}
		return null;
	}

	public static String getRequisitionItemDeliveryAddress(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getRequisitionItemDeliveryAddress(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequisitionItemDeliveryAddress " + e, e);
		}
		return null;
	}

	public static String getRequisitionItemCostCenter(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			return buyersDesk.getRequisitionItemCostCenter(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequisitionItemCostCenter " + e, e);
		}
		return null;
	}
	
	public static void selectEFormForCategoryNamewise(WebDriver driver, String testCaseName, String eformName) throws ActionBotException
	{
		IPageBuyersDesk buyersDesk;
		try
		{
			buyersDesk = FactoryPage.getInstanceOf(IPageBuyersDeskImpl.class);
			buyersDesk.selectEFormForCategoryNamewise(driver, testCaseName, eformName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectEFormForCategory " + e, e);
		}
	}
}
