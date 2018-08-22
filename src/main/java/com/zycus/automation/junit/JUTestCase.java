package com.zycus.automation.junit;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.zycus.automation.bo.Price;
import com.zycus.automation.utilities.SupportingFunctions;

public class JUTestCase
{

	@Test
	public void jsonTest()
	{
		/*
		 * JSONObject jsonObject = new JSONObject(); jsonObject.put("itemType",
		 * "freeText"); jsonObject.put("itemName", "laptop");
		 * jsonObject.put("currency1", 90); jsonObject.put("itemType1",
		 * "freeText"); jsonObject.put("itemName1", "laptop");
		 * jsonObject.put("currency1", 90); StringWriter out = new
		 * StringWriter(); jsonObject.write(out); String jsonText =
		 * out.toString(); System.out.print(jsonText);
		 */
	}

	@Test
	public void fileNameTest()
	{
		String path = "resources" + File.separator + "ui";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		int counter = 0;
		for (int i = 0; i < listOfFiles.length; i++)
		{
			if (listOfFiles[i].isFile())
			{
				System.out.println("File " + listOfFiles[i].getName());
				counter++;
			}
			else if (listOfFiles[i].isDirectory())
			{
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
		System.out.println(counter);
	}

	@Test
	public void testDeliveryByDate()
	{

		String days = "day(s)";
		String del = "Delivery in";
		String avail = "Availability:";
		String testData1 = "Delivery in 12 day(s)";
		// String testData2 = "Availability: N/A";
		String delievery = testData1;
		if (delievery.contains(avail))
		{
			System.out.println(0);
		}
		else
		{
			System.out.println(delievery.length());
			System.out.println(del.length());
			System.out.println(days.length());
			;
			System.out.println(((delievery.substring(del.length(), delievery.length() - days.length()).toString().trim())));
		}
	}

	@Test
	public void testItemPrice()
	{

		// String itemPrice = "~ INR 7,323";
		String itemPrice = "INR 7,323,12.00";
		String unwanted = "~";
		if (itemPrice.contains(unwanted))
		{
			itemPrice = itemPrice.substring(unwanted.length()).trim();
		}
		System.out.println(itemPrice);
		String space = " ";
		Price price = new Price();
		String[] itemPriceObj = StringUtils.split(itemPrice, space);
		price.setPriceType(itemPriceObj[0].toString().trim());
		String param = SupportingFunctions.removeUnderScore(itemPriceObj[1].toString().trim());
		System.out.println(param);

		// price.setPriceValue(Double.parseDouble(itemPriceObj[1].toString().trim()));
		System.out.println(price);
	}
}
