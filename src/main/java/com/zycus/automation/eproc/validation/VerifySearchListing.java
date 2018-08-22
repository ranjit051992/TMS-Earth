/**
 * 
 */
package com.zycus.automation.eproc.validation;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.exception.ActionBotException;

/**
 * @author ankita.sawant
 *
 */
public class VerifySearchListing
{

	public static boolean verifyIfCategoryWasSearched(WebDriver driver, String testCaseName, String categoryName) throws ActionBotException
	{
		String searchedCategory = PageSearchListing.getSearchedSelectedCategory(driver, testCaseName);

		return searchedCategory.contains(categoryName);
	}
}
