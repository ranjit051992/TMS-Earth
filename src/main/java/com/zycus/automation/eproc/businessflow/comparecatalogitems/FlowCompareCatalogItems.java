/**
 * 
 */
package com.zycus.automation.eproc.businessflow.comparecatalogitems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.eproc.pageobjects.pages.comparecatalogitems.PageCompareCatalogItems;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;

/**
 * @author ankita.sawant
 *
 */
public class FlowCompareCatalogItems
{
	static Logger logger = Logger.getLogger(FlowCompareCatalogItems.class);

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

	public static boolean verifyIfItemsAreCompared(CatelogItem catelogItemDetailsFromCompareScreen, CatelogItem catelogItemDetailsFromPropertyFile) throws ActionBotException
	{
		boolean flag = true;
		String error = "";

		// item name
		if (!catelogItemDetailsFromCompareScreen.getItemName().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getItemName()))
		{
			error += "\n Item on compare screen was wrong";
			flag = false;
		}
		
		if (catelogItemDetailsFromCompareScreen.getUnit_Price() != null && catelogItemDetailsFromPropertyFile.getUnit_Price() != null)
		{
			String[] priceComapreScreen = catelogItemDetailsFromCompareScreen.getUnit_Price().split("\\s+");
			String USDFromCompareScreen = priceComapreScreen[0];
			logger.info("\nUSDFromCompareScreen :" + USDFromCompareScreen);
			String unitPriceFromCompareScreen = priceComapreScreen[1];
			logger.info("\nunitPriceFromCompareScreen :" + unitPriceFromCompareScreen);

			String[] pricePropertyFile = catelogItemDetailsFromPropertyFile.getUnit_Price().split("\\s+");
			String USDPropertyFile = pricePropertyFile[0];
			logger.info("\nUSDPropertyFile :" + USDPropertyFile);
			String unitPropertyFile = pricePropertyFile[1];
			logger.info("\nunitPropertyFile :" + unitPropertyFile);
			
			if (!USDFromCompareScreen.equalsIgnoreCase(USDPropertyFile) && !unitPriceFromCompareScreen.equalsIgnoreCase(unitPropertyFile))
			{
				error += "\n Item unit price on compare screen was wrong";
				flag = false;
			}
//			if (!catelogItemDetailsFromCompareScreen.getUnit_Price().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getUnit_Price()))
//			{
//				error += "\n Item unit price on compare screen was wrong";
//				flag = false;
//			}
		}

		// availability
		if (!catelogItemDetailsFromCompareScreen.getAvailability().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getAvailability()))
		{
			error += "\n Availability on compare screen was wrong";
			flag = false;
		}

		// supplier
		if (!catelogItemDetailsFromCompareScreen.getSupplier().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getSupplier()))
		{
			error += "\n Supplier Name on compare screen was wrong";
			flag = false;
		}

//		// supplier part id
//		if (!catelogItemDetailsFromCompareScreen.getSupplierPartID().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getSupplierPartID()))
//		{
//			error += "\n Supplier Part Id on compare screen was wrong";
//			flag = false;
//		}

		// market price
		if (catelogItemDetailsFromPropertyFile.getMarketPrice() != null)
		{
			if (!catelogItemDetailsFromCompareScreen.getMarketPrice().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getMarketPrice()))
			{
				error += "\n Market price on compare screen was wrong";
				flag = false;
			}
		}
		else
		{
			if (!catelogItemDetailsFromCompareScreen.getMarketPrice().equalsIgnoreCase("-"))
			{
				error += "\n Market unit price on compare screen was wrong";
				flag = false;
			}
		}

		// manufacturer name
		if (catelogItemDetailsFromPropertyFile.getManufacturerName() != null)
		{
			if (catelogItemDetailsFromPropertyFile.getManufacturerName().equals("-"))
			{
				if (!catelogItemDetailsFromCompareScreen.getManufacturerName().equalsIgnoreCase(IConstantsData.NA))
				{
					error += "\n Manufacturer Name on compare screen was wrong";
					flag = false;
				}
			}
			else
			{
				if (!catelogItemDetailsFromCompareScreen.getManufacturerName().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getManufacturerName()))
				{
					error += "\n Manufacturer Name on compare screen was wrong";
					flag = false;
				}
			}
		}
		else
		{
			if (!catelogItemDetailsFromCompareScreen.getManufacturerName().equalsIgnoreCase(IConstantsData.NA))
			{
				error += "\n Manufacturer Name on compare screen was wrong";
				flag = false;
			}
		}

		// manufacturer part id
		if (catelogItemDetailsFromPropertyFile.getManufacturerPartId() != null)
		{
			if (catelogItemDetailsFromPropertyFile.getManufacturerPartId().equals("-"))
			{
				if (!catelogItemDetailsFromCompareScreen.getManufacturerPartId().equalsIgnoreCase(IConstantsData.NA))
				{
					error += "\n Manufacturer Part Id on compare screen was wrong";
					flag = false;
				}
			}
			else
			{
				if (!catelogItemDetailsFromCompareScreen.getManufacturerPartId().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getManufacturerPartId()))
				{
					error += "\n Manufacturer Part Id on compare screen was wrong";
					flag = false;
				}
			}
		}
		else
		{
			if (!catelogItemDetailsFromCompareScreen.getManufacturerPartId().equalsIgnoreCase(IConstantsData.NA))
			{
				error += "\n Manufacturer Part Id on compare screen was wrong";
				flag = false;
			}
		}

		// description
		if (catelogItemDetailsFromPropertyFile.getDescription() != null)
		{
			if (catelogItemDetailsFromPropertyFile.getDescription().equals("-"))
			{
				if (!catelogItemDetailsFromCompareScreen.getDescription().equalsIgnoreCase(IConstantsData.NA))
				{
					error += "\n Description on compare screen was wrong";
					flag = false;
				}
			}
			else
			{
				if (!catelogItemDetailsFromCompareScreen.getDescription().equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getDescription()))
				{
					error += "\n Description on compare screen was wrong";
					flag = false;
				}
			}
		}
		else
		{
			if (!catelogItemDetailsFromCompareScreen.getDescription().equalsIgnoreCase(IConstantsData.NA))
			{
				error += "\n Description on compare screen was wrong";
				flag = false;
			}
		}

		// specification
		if (catelogItemDetailsFromPropertyFile.getSpeckey_valueMap() != null)
		{
			for (Map.Entry<String, String> specKeyValueFromPropertyFile : catelogItemDetailsFromPropertyFile.getSpeckey_valueMap().entrySet())
			{
				String key = specKeyValueFromPropertyFile.getKey();

				if(catelogItemDetailsFromCompareScreen.getSpeckey_valueMap().get(key)!=null)
				if (!catelogItemDetailsFromCompareScreen.getSpeckey_valueMap().get(key)
					.equalsIgnoreCase(catelogItemDetailsFromPropertyFile.getSpeckey_valueMap().get(key)))

				{
					error += "\n Specification " + key + " on compare screen was wrong";
					flag = false;
				}
			}
		}

		// attachment
		if (catelogItemDetailsFromPropertyFile.getAttachments() != null)
		{
			if (catelogItemDetailsFromPropertyFile.getAttachments().equals("-"))
			{
				if (!catelogItemDetailsFromCompareScreen.getAttachments().get(0).equalsIgnoreCase(IConstantsData.NA))
				{
					error += "\n Attachment on compare screen was wrong";
					flag = false;
				}
			}
			else
			{
				for (String attachmentOnCompareScreen : catelogItemDetailsFromCompareScreen.getAttachments())
				{
					for (String attachmentOnPropertyFile : catelogItemDetailsFromPropertyFile.getAttachments())
					{
						if (attachmentOnCompareScreen.equalsIgnoreCase(attachmentOnPropertyFile))
						{
							flag = true;
							break;
						}
					}
					if (!flag)
					{
						error += "\n Attachment " + attachmentOnCompareScreen + " on compare screen was wrong";
					}
				}
			}
		}
		else
		{
			if (!catelogItemDetailsFromCompareScreen.getAttachments().get(0).equalsIgnoreCase(IConstantsData.NA))
			{
				error += "\n Attachment on compare screen was wrong";
				flag = false;
			}
		}

		logger.info(error);
		return flag;

	}

	public static List<CatelogItem> getDetailsOfComparedItems(WebDriver driver, String testCaseName, int comparedItems) throws ActionBotException
	{
		List<CatelogItem> catelogItems = new ArrayList<CatelogItem>();
		int i = 0, index = 0;
		CatelogItem catelogItem = null;

		for (i = 1; i <= comparedItems; i++)
		{
			index = i + 1;
			catelogItem = getDetailsOfComparedItem(driver, testCaseName, index);
			catelogItems.add(catelogItem);
		}
		return catelogItems;
	}

	public static CatelogItem getDetailsOfComparedItem(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		CatelogItem catelogItem = new CatelogItem();
		logger.info("=================================================");
		logger.info("Item details on compare item screen : ");
		catelogItem.setItemName(PageCompareCatalogItems.getComparedItemName(driver, testCaseName, index));
		catelogItem.setUnit_Price(PageCompareCatalogItems.getComparedItemUnitPrice(driver, testCaseName, index));
		catelogItem.setAvailability(PageCompareCatalogItems.getComparedItemAvailability(driver, testCaseName, index));
		catelogItem.setSupplier(PageCompareCatalogItems.getComparedItemSupplierName(driver, testCaseName, index));
		catelogItem.setSupplierPartID(PageCompareCatalogItems.getComparedItemSupplierPartId(driver, testCaseName, index));
		catelogItem.setMarketPrice(PageCompareCatalogItems.getComparedItemMarketPrice(driver, testCaseName, index));
		catelogItem.setManufacturerName(PageCompareCatalogItems.getComparedItemManufacturerName(driver, testCaseName, index));
		catelogItem.setManufacturerPartId(PageCompareCatalogItems.getComparedItemManufacturerPartId(driver, testCaseName, index));
		catelogItem.setDescription(PageCompareCatalogItems.getComparedItemDescription(driver, testCaseName, index));
		catelogItem.setAttachments(PageCompareCatalogItems.getComparedItemAttachments(driver, testCaseName, index));

		Map<String, String> specKeyValueMap = new HashedMap();
		//description
		if (PageCompareCatalogItems.getComparedItemSpecKey(driver, testCaseName, 1) != null)
		{
			specKeyValueMap.put(PageCompareCatalogItems.getComparedItemSpecKey(driver, testCaseName, 1),
				PageCompareCatalogItems.getComparedItemSpecValue(driver, testCaseName, index, 1));
		}
		
		//specification
		if (PageCompareCatalogItems.getComparedItemSpecKey(driver, testCaseName, 2) != null)
		{
			specKeyValueMap.put(PageCompareCatalogItems.getComparedItemSpecKey(driver, testCaseName, 2),
				PageCompareCatalogItems.getComparedItemSpecValue(driver, testCaseName, index, 2));
		}
		logger.info("=================================================");
		catelogItem.setSpeckey_valueMap(specKeyValueMap);

		return catelogItem;
	}

}
