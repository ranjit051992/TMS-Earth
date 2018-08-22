/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.searchlisting;

import com.zycus.automation.bo.Price;

/**
 * @author puneet.sharma
 *
 */
public class PageSearchListingUtil extends GenerateByValuesForSearchListingPage
{

	protected static Price getDefaultPrice()
	{
		Price price = new Price();
		price.setPriceType("N/A");
		price.setPriceValue(0.0);
		return price;
	}

}
