/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.searchlisting;

import org.openqa.selenium.By;

/**
 * @author puneet.sharma
 *
 */
public class GenerateByValuesForSearchListingPage
{

	protected static By itemDescription(String itemId)
	{

		String xpath1 = ".//*[@id='item_list_row_";
		String xpath2 = "']//*[@class='iSDesc highlightTerm description']";
		String xpathExpression = xpath1 + itemId + xpath2;
		return By.xpath(xpathExpression);
	}

	protected static By itemSupplier(String itemId)
	{

		String xpath1 = ".//*[@id='item_list_row_";
		String xpath2 = "']//*[@class='shortSuppName highlightTerm supplierName']";
		String xpathExpression = xpath1 + itemId + xpath2;
		return By.xpath(xpathExpression);
	}

	protected static By itemDelieveryDate(String itemId)
	{

		String xpath1 = ".//*[@id='item_list_row_";
		String xpath2 = "']//*[@class='lbl availability']";
		String xpathExpression = xpath1 + itemId + xpath2;
		return By.xpath(xpathExpression);
	}

	protected static By itemQuantity(String itemId)
	{
		String xpath1 = ".//*[@id='quantity_list_";
		String xpath2 = "']";
		String xpathExpression = xpath1 + itemId + xpath2;
		return By.xpath(xpathExpression);
	}

	protected static By item(String itemId)
	{
		String xpath1 = ".//*[@id='item_list_row_";
		String xpath2 = "']//a[contains(@class,'itemName')]/span";
		String xpathExpression = xpath1 + itemId + xpath2;
		return By.xpath(xpathExpression);
	}

	protected static By itemCart(String itemId)
	{

		String xpath1 = ".//*[@id='addToCart_list_";
		String xpath2 = "']";
		String xpathExpression = xpath1 + itemId + xpath2;
		return By.xpath(xpathExpression);
	}

	protected static By itemUnitPrice(String itemId)
	{
		String xpath1 = ".//*[@id='item_list_row_";
		String xpath2 = "']//*[@class='itmPrce itemPrice']";
		String xpathExpression = xpath1 + itemId + xpath2;
		return By.xpath(xpathExpression);
	}

	protected static By itemPrice(String itemId)
	{
		String xpath1 = ".//*[@id='item_list_row_";
		//String xpath2 = "']//*[@class='appxPrce itemConvertedPrice']";
		String xpath2 = "']//*[@class='itmPrce itemPrice']";

		String xpathExpression = xpath1 + itemId + xpath2;

		return By.xpath(xpathExpression);
	}

	protected static By itemAsfavorite(String itemId)
	{
		String xpath1 = ".//*[@id='favorite_list_";
		String xpath2 = "']";
		String xpathExpression = xpath1 + itemId + xpath2;
		return By.xpath(xpathExpression);
	}

	protected static By itemActions(String itemId)
	{
		String xpath1 = ".//*[@id='chk_item_list_";
		String xpath2 = "']";
		String xpathExpression = xpath1 + itemId + xpath2;
		return By.xpath(xpathExpression);
	}

}
