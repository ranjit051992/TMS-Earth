package com.zycus.automation.eproc.businessflow.buyersdeskSettingFlow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.businessflow.buyersdesk.FlowBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.settings.buyersdesksettings.PageBuyersDeskSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class FlowBuyersDeskSetting
{

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>To click on Setup > Customize Tab >
	 * Buyer's Desk <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static void NavigateCustomizedBuyerDesk(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnSetUpTab(driver);
		MainPageHeaderLevelTab.clickOnSetupAndCustomize(driver, testCaseName);
		PageCustomizeSettings.clickOnBuyersDeskLink(driver, testCaseName);

	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> Clicks on Allow buyer radio button YES to
	 * add items in Req. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static void clickOnAllowBuyerToAddItemsInReq_Yes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		//Navigate to buyers desk settings
		FlowBuyersDeskSetting.NavigateCustomizedBuyerDesk(driver, testCaseName);
		PageBuyersDeskSettings.clickOnAllowBuyerToAddItemsInReq_Yes(driver, testCaseName);
		PageBuyersDeskSettings.clickSaveButton(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> Clicks on Allow buyer radio button No to
	 * add items in Req. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static void clickOnAllowBuyerToAddItemsInReq_No(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		FlowBuyersDeskSetting.NavigateCustomizedBuyerDesk(driver, testCaseName);
		PageBuyersDeskSettings.clickOnAllowBuyerToAddItemsInReq_No(driver, testCaseName);
		PageBuyersDeskSettings.clickSaveButton(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> Clicks on AllowPR's radio button smaller
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static boolean clickOnAllowPR_Smaller(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		boolean prSmaller = PageBuyersDeskSettings.clickOnAllowPR_Smaller(driver, testCaseName);
		PageBuyersDeskSettings.clickSaveButton(driver, testCaseName);
		return prSmaller;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> Clicks on AllowPR's radio button larger
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static boolean clickOnAllowPR_Larger(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		boolean prLarger = PageBuyersDeskSettings.clickOnAllowPR_Larger(driver, testCaseName);
		PageBuyersDeskSettings.clickSaveButton(driver, testCaseName);
		return prLarger;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> enters AllowPr's total amount value <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static String enterAllowPr_TotalAmount(WebDriver driver, String testCaseName, String prTotalAmount) throws ActionBotException, FactoryMethodException
	{
		PageBuyersDeskSettings.enterAllowPr_TotalAmount(driver, testCaseName, prTotalAmount);
		PageBuyersDeskSettings.clickSaveButton(driver, testCaseName);
		return prTotalAmount;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> enters AllowPr's currency units value
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static String enterAllowPr_CurrencyUnits(WebDriver driver, String testCaseName, String prCurrencyUnits) throws ActionBotException, FactoryMethodException
	{
		PageBuyersDeskSettings.enterAllowPr_CurrencyUnits(driver, testCaseName, prCurrencyUnits);
		PageBuyersDeskSettings.clickSaveButton(driver, testCaseName);
		return prCurrencyUnits;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> Clicks on Allow buyer radio button Yes to
	 * replace items in Req. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static void clickOnAllowBuyerToReplaceItemsInReq_Yes(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		FlowBuyersDeskSetting.NavigateCustomizedBuyerDesk(driver, testCaseName);
		PageBuyersDeskSettings.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, testCaseName);
		PageBuyersDeskSettings.clickSaveButton(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> Clicks on Allow buyer radio button No to
	 * replace items in Req. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static void clickOnAllowBuyerToReplaceItemsInReq_No(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		FlowBuyersDeskSetting.NavigateCustomizedBuyerDesk(driver, testCaseName);
		PageBuyersDeskSettings.clickOnAllowBuyerToReplaceItemsInReq_No(driver, testCaseName);
		PageBuyersDeskSettings.clickSaveButton(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> clears AllowPr's currency units value
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static void clearAllowPr_CurrencyUnits(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageBuyersDeskSettings.clearAllowPr_CurrencyUnits(driver, testCaseName);
		PageBuyersDeskSettings.clickSaveButton(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> clear AllowPr's total amount value <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param itemId </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static void clearAllowPr_TotalAmount(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageBuyersDeskSettings.clearAllowPr_TotalAmount(driver, testCaseName);
		PageBuyersDeskSettings.clickSaveButton(driver, testCaseName);
	}

}
