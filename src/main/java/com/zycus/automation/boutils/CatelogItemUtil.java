package com.zycus.automation.boutils;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.testdata.DefaultTestData;

public class CatelogItemUtil extends DefaultTestData
{

	static Logger logger = Logger.getLogger(CatelogItemUtil.class);

	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static CatelogItem getDefaultCatelogItem()
	{
		String name = "name";
		String description = "description";
		String quantity = "quantity";
		CatelogItem catelogItem = new CatelogItem();
		Map<String, Object> defaultCatelogMap = readDefaultDataFor(DefaultData.CATALOG_ITEM);
		catelogItem.setItemName(defaultCatelogMap.get(name).toString());
		catelogItem.setDescription(defaultCatelogMap.get(description).toString());
		catelogItem.setQuantity((int) Float.parseFloat(defaultCatelogMap.get(quantity).toString()));
		return catelogItem;
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
	public void testGetDefaultCatelogItem()
	{
		CatelogItem catelogItem = getDefaultCatelogItem();
		logger.info(catelogItem);
	}
}
