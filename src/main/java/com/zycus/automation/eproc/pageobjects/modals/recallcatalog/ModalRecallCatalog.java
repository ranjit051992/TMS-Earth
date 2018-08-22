/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.recallcatalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public class ModalRecallCatalog
{
	public static UI_Elements	TEXTBOX_RECALL_COMMENT				= UIFactory.getElements("TEXTBOX_RECALL_COMMENT");
	public static UI_Elements	BUTTON_RECALL_CATALOG				= UIFactory.getElements("BUTTON_RECALL_CATALOG");
	public static UI_Elements	BUTTON_CANCEL_RECALL_CATALOG		= UIFactory.getElements("BUTTON_CANCEL_RECALL_CATALOG");
	public static UI_Elements	PROGRESSING_DIV_FOR_SAVING_CATALOG	= UIFactory.getElements("PROGRESSING_DIV_FOR_SAVING_CATALOG");

	public static String fillRecallComment(WebDriver driver, String testCaseName, String comment) throws ActionBotException
	{
		String enteredComment = ActionBot.sendKeys(driver, TEXTBOX_RECALL_COMMENT, comment);
		return enteredComment;
	}

	public static void clickOnRecallCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on recall catalog button");
		ActionBot.click(driver, BUTTON_RECALL_CATALOG);
		WebDriverWait wait = new WebDriverWait(driver, ActionBot.timeOut);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PROGRESSING_DIV_FOR_SAVING_CATALOG.getValue())));
		//		ActionBot.waitTillPopUpIsPresent(driver, PROGRESSING_DIV_FOR_SAVING_CATALOG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on recall catalog button");
	}

	public static void clickOnCancelRecallCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancel recall catalog button");
		ActionBot.click(driver, BUTTON_CANCEL_RECALL_CATALOG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel recall catalog button");
	}
}
