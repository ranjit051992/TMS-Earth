package com.zycus.automation.eproc.businessflow.replaceItemFlow;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.BuyersDesk;
import com.zycus.automation.bo.ReplaceItem;
import com.zycus.automation.eproc.businessflow.buyersdesk.FlowBuyersDesk;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.PageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.replaceItem.PageReplaceItem;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.services.CommonServices;

public class FlowReplaceItem
{

	static Logger logger = Logger.getLogger(FlowBuyersDeskListing.class);

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> Replaces Req item to new item from list
	 * <br>
	 * </font><b><font color="green"> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws Exception
	 */
	public static ReplaceItem replaceReqItem(WebDriver driver, String testCaseName, String itemNumber, ReplaceItem replaceitem) throws Exception
	{
		PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);
		// If save changes pop-up is displayed on page.
		PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);
		String pageHeader = PageReplaceItem.getReplaceItemPageHeaderText(driver, testCaseName);
		replaceitem.setPageHeader(pageHeader);

		// sort by Price: Low to High
		PageSearchListing.clickSortByPriceLowToHigh(driver, testCaseName);

		String category = PageOnlineStore.getSelectedCategory(driver, testCaseName);
		replaceitem.setDisplayedCategory(category);
		boolean buttonReplace = PageReplaceItem.verifyReplaceButtonDisplayed(driver, testCaseName);
		replaceitem.setButtonReplaceDisplayed(buttonReplace);
		boolean buttonCancelAndGoBack = PageReplaceItem.verifyCancelAndGoBackButtonDisplayed(driver, testCaseName);
		replaceitem.setButtonCancelAndGoBack(buttonCancelAndGoBack);
		PageReplaceItem.clickOnRadioItem(driver, testCaseName);
		PageReplaceItem.fillReplaceItemQuantity(driver, testCaseName);
		PageReplaceItem.clickOnReplaceItemButton(driver, testCaseName);
		boolean buttonConfirm = PageReplaceItem.verifyButtonConfirmDisplayed(driver, testCaseName);
		replaceitem.setButtonConfirmDisplayed(buttonConfirm);
		boolean linkCancel = PageReplaceItem.verifyLinkCancelDisplayed(driver, testCaseName);
		replaceitem.setLinkCancelDisplayed(linkCancel);
		PageReplaceItem.fillChangeComment(driver, testCaseName, IConstantsData.COMMENT_FOR_REPLACE_ITEM);
		PageReplaceItem.clickOnConfirm(driver, testCaseName);
		return replaceitem;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> Verifies item displayed on Replace Item
	 * page <br>
	 * </font><b><font color="green"> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws Exception
	 */
	public static ReplaceItem verifyReplaceItemPageDetails(WebDriver driver, String testCaseName, ReplaceItem replaceitem) throws Exception
	{
		boolean itemImage = PageReplaceItem.isItemImageDisplayed(driver, testCaseName);
		replaceitem.setItemImage(itemImage);
		boolean itemName = PageReplaceItem.isItemNameDisplayed(driver, testCaseName);
		replaceitem.setItemName(itemName);
		boolean itemDescription = PageReplaceItem.isItemDescriptionDisplayed(driver, testCaseName);
		replaceitem.setItemDescription(itemDescription);
		boolean itemSupplierName = PageReplaceItem.isSupplierNameDisplayed(driver, testCaseName);
		replaceitem.setItemSupplierName(itemSupplierName);
		boolean itemLeadTime = PageReplaceItem.isItemLeadTimeDisplayed(driver, testCaseName);
		replaceitem.setItemLeadTime(itemLeadTime);
		boolean iconIsGreen = PageReplaceItem.isIconIsGreenDisplayed(driver, testCaseName);
		replaceitem.setIconIsGreen(iconIsGreen);
		boolean iconIsPreferred = PageReplaceItem.isIconIsPreferredDisplayed(driver, testCaseName);
		replaceitem.setIconIsPreferred(iconIsPreferred);
		boolean itemPrice = PageReplaceItem.isItemPriceDisplayed(driver, testCaseName);
		replaceitem.setItemPrice(itemPrice);
		return replaceitem;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> Verifies item displayed in Item Details
	 * Popup on Replace Item page <br>
	 * </font><b><font color="green"> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws Exception
	 */
	public static ReplaceItem verifyItemDetailsPopupFileds(WebDriver driver, String testCaseName, ReplaceItem replaceitem) throws Exception
	{
		boolean itemDetailsPopup = PageReplaceItem.isItemDetailsPopupDisplayed(driver, testCaseName);
		replaceitem.setItemDetailsPopupDisplayed(itemDetailsPopup);
		boolean itemNamePopupItemDetails = PageReplaceItem.isItemNameInItemDetailsPopupDisplayed(driver, testCaseName);
		replaceitem.setItemNamePopupItemDetails(itemNamePopupItemDetails);
		boolean itemPartIdPopupItemDetails = PageReplaceItem.isItemPartIdInItemDetailsPopupDisplayed(driver, testCaseName);
		replaceitem.setItemPartIdPopupItemDetails(itemPartIdPopupItemDetails);
		boolean itemPricePopupItemDetails = PageReplaceItem.isItemPriceInItemDetailsPopupDisplayed(driver, testCaseName);
		replaceitem.setItemPricePopupItemDetails(itemPricePopupItemDetails);
		boolean tabDetailsPopupItemDetails = PageReplaceItem.isTabDetailsInItemDetailsPopupDisplayed(driver, testCaseName);
		replaceitem.setTabDetailsPopupItemDetails(tabDetailsPopupItemDetails);
		boolean tabSpecificationPopupItemDetails = PageReplaceItem.isTabSpecificationInItemDetailsPopupDisplayed(driver, testCaseName);
		replaceitem.setTabSpecificationPopupItemDetails(tabSpecificationPopupItemDetails);
		boolean tabAttachmentPopupItemDetails = PageReplaceItem.isTabAttachmentInItemDetailsPopupDisplayed(driver, testCaseName);
		replaceitem.setTabAttachmentPopupItemDetails(tabAttachmentPopupItemDetails);
		boolean iconIsGreenPopupItemDetails = PageReplaceItem.isIconIsGreenInItemDetailsPopupDisplayed(driver, testCaseName);
		replaceitem.setIconIsGreenPopupItemDetails(iconIsGreenPopupItemDetails);
		boolean iconIsPreferredPopupItemDetails = PageReplaceItem.isIconIsPreferredInItemDetailsPopupDisplayed(driver, testCaseName);
		replaceitem.setIconIsPreferredPopupItemDetails(iconIsPreferredPopupItemDetails);
		return replaceitem;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> Searches for item, clicks on item and
	 * closed item popup <br>
	 * </font><b><font color="green"> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws Exception
	 */
	public static void searchItemAndVerifyPopup(WebDriver driver, String testCaseName, String searchItem, String xpath) throws Exception
	{
		PageOnlineStore.fillSearchText(driver, testCaseName, searchItem);
		PageOnlineStore.clickSearchButton(driver, testCaseName);
		PageReplaceItem.clickItemName(driver, testCaseName);
		PageReplaceItem.clickCloseOnItemPopUpByXpath(driver, testCaseName, xpath);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> Replace req item with free text item <br>
	 * </font><b><font color="green"> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws Exception
	 */
	public static BuyersDesk replaceWithFreeTextItem(WebDriver driver, String testCaseName, BuyersDesk buyersdesk) throws Exception
	{
		String reqItemNumber = null;

		// fetching item values for verification
		reqItemNumber = PageBuyersDesk.getItemNo(driver, testCaseName);

		// selects item displayed on Page
		PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

		// Navigate to replace item page
		PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, reqItemNumber);

		// If save changes pop-up is displayed on page.
		PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

		if (PageBuyersDesk.verifyCreateFreeTextItemModal(driver, testCaseName) == false)
		{
			// expands box on replace item page and clicks on Guided Procurement
			// button
			PageSearchListing.clickOnGuideMeExpand(driver, testCaseName);
			PageSearchListing.clickOnButtonGuidedProcurement(driver, testCaseName);
		}

		// fill free text item details
		FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
		FlowBuyersDesk.fillExtraItemDetails(driver, testCaseName, buyersdesk);
		PageReplaceItem.clickReplaceFreeTextItemButton(driver, testCaseName);
		PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
		PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
		PageBuyersDesk.selectSupplierAddress(driver, testCaseName);
		PageBuyersDesk.enterContractNumber(driver, testCaseName, buyersdesk.getContractNumber());

		if (buyersdesk.getActionToPerform().equalsIgnoreCase(IConstantsData.Action_Click_Link_Cancel))
		{
			// clicks on Cancel Link.
			buyersdesk.setActionStatus(PageBuyersDesk.clickOnCancelLinkInAddItems(driver, testCaseName));
			PageBuyersDesk.clickOnCancelAndGoBackLink(driver, testCaseName);
		}
		else if (buyersdesk.getActionToPerform().equalsIgnoreCase(IConstantsData.Action_Click_Button_CancelAndGoBack))
		{
			// click button cancel and go back
			PageBuyersDesk.clickOnCancelAndGoBackButton(driver, testCaseName);
		}
		else if (buyersdesk.getActionToPerform().equalsIgnoreCase(IConstantsData.Action_Create_Guided_Item))
		{
			// replace item
			PageReplaceItem.clickReplaceFreeTextItemButton(driver, testCaseName);
			PageReplaceItem.fillChangeComment(driver, testCaseName, CommonServices.getTestData(IConstantsData.ALL_CHARACTERS));
			PageReplaceItem.clickOnConfirm(driver, testCaseName);
		}
		else if (buyersdesk.getActionToPerform().equalsIgnoreCase(IConstantsData.NONE))
		{
			logger.info("No action to be performed for Guided item Replacement.");
		}
		else
		{
			logger.info("Invalid action to be performed for Guided Item Replacement");
		}

		return buyersdesk;
	}

}
