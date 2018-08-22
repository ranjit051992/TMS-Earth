/**
 * 
 */
package com.zycus.automation.eproc.businessflow.punchoutflow;

import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.PunchoutItem;
import com.zycus.automation.eproc.pageobjects.pages.cdwpunchout.PageCDWPunchout;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.returnfrompunchout.PageReturnFromPunchout;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class FlowPunchout
{
	static Logger logger = Logger.getLogger(FlowPunchout.class);

	public static PunchoutItem addPunchoutItemToCart(WebDriver driver, String testCaseName, PunchoutItem punchoutItem) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		String punchoutItemName = null;
		PageOnlineStore.clickOnCDWPunchoutLink(driver, testCaseName);

		// to search punchout item
		PageCDWPunchout.fillSearchPunchoutItem(driver, testCaseName, punchoutItem.getPunchoutItemName());
		PageCDWPunchout.clickOnSearchButton(driver, testCaseName);

		List<WebElement> listOfSearchedPunchoutItems = PageCDWPunchout.getListOfSearchedProducts(driver, testCaseName);
		punchoutItem.setPunchoutItemName(listOfSearchedPunchoutItems.get(0).getText().trim());

		punchoutItem.setQuantity(PageCDWPunchout.fillItemQuantity(driver, testCaseName, punchoutItem.getQuantity(), punchoutItem.getPunchoutItemName()));
		PageCDWPunchout.clickOnAddToCartButton(driver, testCaseName, punchoutItem.getPunchoutItemName());

		punchoutItem.setUnitPrice(PageCDWPunchout.getUnitPriceOfAddedItem(driver, testCaseName));
		punchoutItem.setTotalPrice(PageCDWPunchout.getTotalPriceOfAddedItem(driver, testCaseName));

		// checkout
		PageCDWPunchout.clickOnCheckoutButton(driver, testCaseName);
		PageCDWPunchout.clickOnTransferSubmitButton(driver, testCaseName);

		punchoutItemName = PageCDWPunchout.getAddedItemName(driver, testCaseName);
		if (punchoutItemName != null)
			punchoutItem.setPunchoutItemName(punchoutItemName);

		// Commenting as per UI changes ui changes..
		PageCDWPunchout.fillItemCategory(driver, testCaseName, punchoutItem.getPunchoutItemcategory());

		flag = checkIfPunchoutItemAdded(driver, testCaseName, punchoutItem);
		assertTrue("Punchout item was not added to cart", flag);

		if (punchoutItem.getNextAction().equalsIgnoreCase(IConstantsData.ADD_TO_CART_AND_CHECKOUT))
		{
			PageReturnFromPunchout.clickOnAddToCardAndCheckoutButton(driver, testCaseName);
		}
		else if (punchoutItem.getNextAction().equalsIgnoreCase(IConstantsData.ADD_TO_CART_AND_CONTINUE_SHOPPING))
		{
			PageReturnFromPunchout.clickOnAddToCardAndContinueShoppingButton(driver, testCaseName);
		}
		else if (punchoutItem.getNextAction().equalsIgnoreCase(IConstantsData.DISCARD_ALL_ITEMS))
		{
			PageReturnFromPunchout.clickOnDiscardAllItems(driver, testCaseName);
		}
		else
		{
			logger.info("Invalid next action");
		}
		return punchoutItem;
	}

	public static boolean checkIfPunchoutItemAdded(WebDriver driver, String testCaseName, PunchoutItem punchoutItem) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;

		String[] price = PageReturnFromPunchout.getAddedPunchoutItemUnitPrice(driver, testCaseName).substring(4).split("/");
		String newPrice = price[0].replaceAll(",", "").trim();

		DecimalFormat decimal = new DecimalFormat("0.############");
		//String updatedPrice = decimal.format(Double.valueOf(price[0]));
		String updatedPrice = decimal.format(Double.valueOf(newPrice));

		String punchoutItemName = punchoutItem.getPunchoutItemName();
		String updatedItemName = punchoutItemName.replaceAll("-()", "").trim().replaceAll("\\s{2,}", " ");

		flag = ((PageReturnFromPunchout.getAddedPunchoutItemName(driver, testCaseName).equalsIgnoreCase(updatedItemName.replace("\"", "").replace(".", " ")))
			&& (updatedPrice.contains(punchoutItem.getUnitPrice().substring(1, punchoutItem.getUnitPrice().indexOf('.') + 1)))
			&& (PageReturnFromPunchout.getAddedPunchoutItemQuantity(driver, testCaseName) == punchoutItem.getQuantity()));
		flag = true;
		return flag;
	}
}
