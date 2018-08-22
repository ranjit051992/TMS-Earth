/**
 * 
 */
package com.zycus.automation.eproc.validation;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.comparecatalogitems.PageCompareCatalogItems;
import com.zycus.automation.exception.ActionBotException;

/**
 * @author ankita.sawant
 *
 */
public class VerifyComparedCatalogItems
{

	public static boolean verifyIfItemsAreCompared(WebDriver driver, String testCaseName, List<String> dataItemIds) throws ActionBotException
	{

		List<WebElement> list = PageCompareCatalogItems.getListOfItemsCompared(driver, testCaseName);

		int count = 0;
		for (WebElement element : list)
		{
			if (count < dataItemIds.size())
			{
				if (!dataItemIds.get(count).equals(element.getAttribute("data-item-id")))
				{
					return false;
				}
			}
			count++;
		}

		return true;

	}

	public static boolean verifyIfItemsAreCompared(WebDriver driver, String testCaseName, List<String> itemsToBeCompare, List<String> dataItemIds) throws ActionBotException
	{

		List<WebElement> list = PageCompareCatalogItems.getListOfItemsCompared(driver, testCaseName);

		int count = 0;
		for (WebElement element : list)
		{
			if (count < dataItemIds.size())
			{
				if (!dataItemIds.get(count).equals(element.getAttribute("data-item-id")))
				{
					return false;
				}
			}
			count++;
		}

		return true;

	}
}
