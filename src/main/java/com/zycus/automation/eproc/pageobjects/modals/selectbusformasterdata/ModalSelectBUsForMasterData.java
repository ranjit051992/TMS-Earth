/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.selectbusformasterdata;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public class ModalSelectBUsForMasterData
{
	public static UI_Elements	LINK_EDIT_SELECTED_BU_FOR_CC		= UIFactory.getElements("LINK_EDIT_SELECTED_BU_FOR_CC");
	public static UI_Elements	CHECKBOX_FOR_BU_SELECTION_IN_CC		= UIFactory.getElements("CHECKBOX_FOR_BU_SELECTION_IN_CC");
	static UI_Elements			BUTTON_SAVE_SELECTED_BU_IN_CC		= UIFactory.getElements("BUTTON_SAVE_SELECTED_BU_IN_CC");
	static UI_Elements			LIST_LABEL_BU_NAMES_IN_COST_CENTER	= UIFactory.getElements("LIST_LABEL_BU_NAMES_IN_COST_CENTER");
	static UI_Elements			CHECKBOX_SELECT_ALL_BU_IN_CC		= UIFactory.getElements("CHECKBOX_SELECT_ALL_BU_IN_CC");

	public static boolean isEditSelectedBUPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LINK_EDIT_SELECTED_BU_FOR_CC);
	}

	public static void clickOnEditSelectedBU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_SELECTED_BU_FOR_CC);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Edit Selected BU");
	}

	public static List<WebElement> getListOfAllCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, CHECKBOX_FOR_BU_SELECTION_IN_CC);
	}

	public static void clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Save Selected BU");
		ActionBot.click(driver, BUTTON_SAVE_SELECTED_BU_IN_CC);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Save Selected BU");
	}

	public static List<WebElement> getListOfAllBUNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LIST_LABEL_BU_NAMES_IN_COST_CENTER);
	}

	public static void clickOnCheckBoxForBU(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='buListTable']//tr[" + rowNo + "]//input[contains(@class,'bulist_chkboxCode')]"));
	}

	public static boolean isSelectAllBUCheckboxSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementSelected(driver, CHECKBOX_SELECT_ALL_BU_IN_CC);
	}

	public static void clickOnSelectAllBUCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_ALL_BU_IN_CC);
		ActionBot.waitForPageLoad(driver);
	}

	public static void clickOnCheckBoxForBU(WebDriver driver, String testCaseName, String buName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='buListTable']//tr[.//*[text()='" + buName + "']]//input[contains(@class,'bulist_chkboxCode')]"));
	}

}
