/**
 * 
 */
package com.zycus.automation.eproc.businessflow.searchlistingpageflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.exception.ActionBotException;

/**
 * @author puneet.sharma
 *
 */
public class IFlowSearchListingUtil
{

	static Logger logger = Logger.getLogger(IFlowSearchListingUtil.class);

	protected static String searchItem(WebDriver driver, String testCaseName, String itemName) throws ActionBotException
	{

		itemName = PageOnlineStore.fillSearchText(driver, testCaseName, itemName);
		PageOnlineStore.clickSearchButton(driver, testCaseName);
		PageSearchListing.waitTillSearchListLoaded(driver, testCaseName);

		// ScreenShot.screenshot(driver, testCaseName, "Search_Item");

		if (!PageSearchListing.isDataTableEmptyPresent(driver, testCaseName))
		{
			PageSearchListing.hoverToGridView(driver, testCaseName);
		}
		else
		{
			logger.info("No records found");
			itemName = null;
		}
		return itemName;
	}

}
