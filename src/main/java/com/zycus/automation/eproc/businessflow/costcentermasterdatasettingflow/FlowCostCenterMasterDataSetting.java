/**
 * 
 */
package com.zycus.automation.eproc.businessflow.costcentermasterdatasettingflow;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.modals.selectbusformasterdata.ModalSelectBUsForMasterData;
import com.zycus.automation.eproc.pageobjects.pages.settings.costcentermasterdatasettings.PageCostCenterSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings.PageMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.usermanagement.PageUserManagement;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

/**
 * @author ankita.sawant
 *
 */
public class FlowCostCenterMasterDataSetting
{
	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Search Cost Center <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param searchTerm </font><b><br>
	 * @param searchIn </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean searchCostCenter(WebDriver driver, String testCaseName, String searchTerm, String searchIn) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnCostCenterLink(driver, testCaseName);
		PageCostCenterSettings.fillSearchCostCenter(driver, testCaseName, searchTerm);
		PageCostCenterSettings.selectSearchCCIn(driver, testCaseName, searchIn);
		PageCostCenterSettings.clickOnGoBtn(driver);
		boolean flag = PageCostCenterSettings.getFirstCostCenterSearched(driver, testCaseName).equalsIgnoreCase(searchTerm);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Remove BU from cost center <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param buName </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static void removeBUFromCostCenter(WebDriver driver, String testCaseName, String buName) throws ActionBotException, FactoryMethodException
	{
		int i = 1;
		PageCostCenterSettings.clickOnAllSelectedBUsLink(driver, testCaseName);
		ModalSelectBUsForMasterData.clickOnEditSelectedBU(driver, testCaseName);
		List<WebElement> listOfBUNames = ModalSelectBUsForMasterData.getListOfAllBUNames(driver, testCaseName);
		for (WebElement element : listOfBUNames)
		{
			if (!element.getText().trim().equalsIgnoreCase(buName))
			{
				ModalSelectBUsForMasterData.clickOnCheckBoxForBU(driver, testCaseName, i);
			}
			i++;
		}
		ModalSelectBUsForMasterData.clickOnSaveButton(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Add BU to cost center <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param buName </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static void addBUToCostCenter(WebDriver driver, String testCaseName, String buName) throws ActionBotException, FactoryMethodException
	{
		int i = 1;
		PageCostCenterSettings.clickOnAllSelectedBUsLink(driver, testCaseName);
		List<WebElement> listOfBUNames = ModalSelectBUsForMasterData.getListOfAllBUNames(driver, testCaseName);
		for (WebElement element : listOfBUNames)
		{
			if (element.getText().trim().equalsIgnoreCase(buName))
			{
				ModalSelectBUsForMasterData.clickOnCheckBoxForBU(driver, testCaseName, i);
				break;
			}
			i++;
		}
		ModalSelectBUsForMasterData.clickOnSaveButton(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Search cost center , edit it and remove
	 * given BU from cost center <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param searchTerm </font><b><br>
	 * @param searchIn </font><b><br>
	 * @param buName </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static void searchAndRemoveBUFromCostCenter(WebDriver driver, String testCaseName, String searchTerm, String searchIn, String buName)
		throws ActionBotException, FactoryMethodException
	{
		// navigates to TMS
		driver.get(ConfigProperty.getConfig("TMS_URL"));

		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
		boolean flag = searchCostCenter(driver, testCaseName, searchTerm, searchIn);
		assertTrue("Error while searching cost center", flag);
		PageCostCenterSettings.clickOnEditCC(driver, testCaseName);
		removeBUFromCostCenter(driver, testCaseName, buName);
		PageCostCenterSettings.clickOnUpdateCostCenter(driver, testCaseName);
		// navigate back to eproc
		driver.get(ConfigProperty.getConfig("Product_URL"));
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After navigating to eProc Page");
		MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Search cost center , edit it and remove
	 * given BU from cost center <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param searchTerm </font><b><br>
	 * @param searchIn </font><b><br>
	 * @param buName </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static void searchAndAddBUToCostCenter(WebDriver driver, String testCaseName, String searchTerm, String searchIn, String buName)
		throws ActionBotException, FactoryMethodException
	{
		boolean flag = searchCostCenter(driver, testCaseName, searchTerm, searchIn);
		assertTrue("Error while searching cost center", flag);
		PageCostCenterSettings.clickOnEditCC(driver, testCaseName);
		addBUToCostCenter(driver, testCaseName, buName);
		PageCostCenterSettings.clickOnUpdateCostCenter(driver, testCaseName);
		PageUserManagement.clickOnReturnToSetUpModule(driver, testCaseName);
		MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Upload cc via file <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param fileName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static String uploadCostCenterViaFile(WebDriver driver, String testCaseName, String fileName) throws ActionBotException, FactoryMethodException
	{
		String addedCCName = null;
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnCostCenterLink(driver, testCaseName);
		PageCostCenterSettings.clickOnImportCCViaFiles(driver, testCaseName);
		PageCostCenterSettings.fillFileName(driver, testCaseName, fileName);
		PageCostCenterSettings.clickOnUploadCCButton(driver, testCaseName);
		addedCCName = PageCostCenterSettings.getFirstCostCenterSearched(driver, testCaseName);

		return addedCCName;
	}

}
