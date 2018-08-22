/**
 * 
 */
package com.zycus.automation.eproc.businessflow.viewcatalogflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.catalogview.PageCatalogView;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class FlowViewCatalog
{
	static Logger logger = Logger.getLogger(FlowViewCatalog.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Hide item in catalog <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean hideItem(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		ActionBot.scroll(driver);
		PageCatalogView.clickOnItemActionsLink(driver, testCaseName, itemName);
		PageCatalogView.clickOnHideItemLink(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		PageCatalogView.waitTillSuccessMsgPresent(driver, testCaseName);
		return PageCatalogView.isItemHiddenStatusIconPresent(driver, testCaseName, itemName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Unhide item in catalog <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean unHideItem(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{
		ActionBot.scroll(driver);
		PageCatalogView.clickOnItemActionsLink(driver, testCaseName, itemName);
		PageCatalogView.clickOnUnHideItemLink(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		PageCatalogView.waitTillSuccessMsgPresent(driver, testCaseName);
		return PageCatalogView.isItemUnHideStatusIconPresent(driver, testCaseName, itemName);
	}

}
