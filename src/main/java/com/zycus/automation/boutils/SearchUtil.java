package com.zycus.automation.boutils;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.Search;
import com.zycus.automation.constants.IConstants;

public class SearchUtil
{

	static Logger logger = Logger.getLogger(SearchUtil.class);

	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public Search getDefaultSearchForCatelogItem()
	{
		CatelogItem catelogItem = CatelogItemUtil.getDefaultCatelogItem();
		Item item = new Item();
		Search search = new Search();
		List<CatelogItem> catelogItems = new ArrayList<CatelogItem>();
		catelogItems.add(catelogItem);
		item.setCatelogItems(catelogItems);
		// search.setItem(item);
		search.setSearchQuantity(catelogItem.getQuantity());
		return search;
	}

	public Search createSearchCriteria(WebDriver driver, String searchItem, int searchQuantity)
	{

		Search search = new Search();
		// search.setSearchItem(searchItem);
		search.setSearchQuantity(searchQuantity);
		return search;
	}

	/**************************************************************************************************************************************************/
	/**************************************************************************************************************************************************/
	/**************************************************************************************************************************************************/
	/**************************************************************************************************************************************************/
	/**************************************************************************************************************************************************/
	/**************************************************************************************************************************************************/
	/**************************************************************
	 * JUNIT TESTCASE FOR METHODS
	 **********************************************************/

	@Test
	public void testGetDefaultSearchForCatelogItem()
	{
		Search search = getDefaultSearchForCatelogItem();
		logger.info(search);
	}

}
