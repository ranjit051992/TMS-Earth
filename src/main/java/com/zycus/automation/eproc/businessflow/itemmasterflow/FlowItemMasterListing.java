/**
 * 
 */
package com.zycus.automation.eproc.businessflow.itemmasterflow;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.itemmasterlistingactions.ModalItemMasterListingActions;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.cataloglisting.IPageCatalogListing;
import com.zycus.automation.eproc.pageobjects.pages.itemmastercataloglisting.PageItemMasterCatalogListing;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class FlowItemMasterListing
{
	static Logger logger = Logger.getLogger(FlowItemMasterListing.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To search item master <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemMasterName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean searchItemMasterCatalog(WebDriver driver, String testCaseName, String itemMasterName) throws ActionBotException
	{
		boolean flag = false;
		// click on item master tab
		MainPageHeaderLevelTab.clickOnItemMasterSubTab(driver, testCaseName);
		// search item master
		PageItemMasterCatalogListing.fillItemMasterName(driver, testCaseName, itemMasterName);
		String searchedItemMasterName = PageItemMasterCatalogListing.getFirstItemMasterName(driver, testCaseName);
		// check if item master is searched
		flag = itemMasterName.equalsIgnoreCase(searchedItemMasterName);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>View Item Master <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static void viewItemMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageItemMasterCatalogListing.clickOnViewFirstItemMasterLink(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Deactivate Item master <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean deactivateItemMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag = false;
		PageItemMasterCatalogListing.clickOnActionsLink(driver, testCaseName);
		ModalItemMasterListingActions.clickOnDeactivateLink(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		ActionBot.waitTillPopUpIsPresent(driver, IPageCatalogListing.LABEL_SUCCESS_MESSAGE);
		flag = PageItemMasterCatalogListing.getStatusOfFirstItemMaster(driver, testCaseName).equalsIgnoreCase(IConstantsData.DEACTIVATED_CATALOG_LABEL);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Delete item master <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean deleteItemMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag = false;
		PageItemMasterCatalogListing.clickOnActionsLink(driver, testCaseName);
		ModalItemMasterListingActions.clickOnDeleteLink(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		ActionBot.waitTillPopUpIsPresent(driver, IPageCatalogListing.LABEL_SUCCESS_MESSAGE);
		if (PageAllRequestsApproval.getApprovalEmptyTableSize(driver, testCaseName) <= 1)
		{
			flag = true;
		}
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Deactivate and delete item master <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemMasterName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean deactivateAndDeleteItemMaster(WebDriver driver, String testCaseName, String itemMasterName) throws ActionBotException
	{
		boolean flag = false;
		flag = searchItemMasterCatalog(driver, testCaseName, itemMasterName);
		flag = deactivateItemMaster(driver, testCaseName);
		Assert.assertTrue("Error while deactivating item master", flag);
		flag = deleteItemMaster(driver, testCaseName);
		Assert.assertTrue("Error while deleting item master", flag);
		return flag;
	}
}
