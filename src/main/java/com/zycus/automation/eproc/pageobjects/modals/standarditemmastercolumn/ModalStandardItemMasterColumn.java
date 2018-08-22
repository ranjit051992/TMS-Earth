/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.standarditemmastercolumn;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public class ModalStandardItemMasterColumn
{
	static Logger				logger									= Logger.getLogger(ModalStandardItemMasterColumn.class);

	public static UI_Elements	DRAG_COLUMN_PRODUCT_CATEGORY			= UIFactory.getElements("DRAG_COLUMN_PRODUCT_CATEGORY");
	public static UI_Elements	DRAG_COLUMN_SUPPLIER_AUX_PART_ID		= UIFactory.getElements("DRAG_COLUMN_SUPPLIER_AUX_PART_ID");
	public static UI_Elements	DRAG_COLUMN_DELIVERY_LEAD_TIME			= UIFactory.getElements("DRAG_COLUMN_DELIVERY_LEAD_TIME");
	public static UI_Elements	DRAG_COLUMN_IS_GREEN					= UIFactory.getElements("DRAG_COLUMN_IS_GREEN");
	public static UI_Elements	DRAG_COLUMN_IS_PREFERRED				= UIFactory.getElements("DRAG_COLUMN_IS_PREFERRED");
	public static UI_Elements	DRAG_COLUMN_SPECIFICATION				= UIFactory.getElements("DRAG_COLUMN_SPECIFICATION");
	public static UI_Elements	DRAG_COLUMN_SPECIFICATION_NAME			= UIFactory.getElements("DRAG_COLUMN_SPECIFICATION_NAME");
	public static UI_Elements	MAP_HOLDER_SPSC_CODE					= UIFactory.getElements("MAP_HOLDER_SPSC_CODE");
	public static UI_Elements	MAP_HOLDER_LEAD_TIME					= UIFactory.getElements("MAP_HOLDER_LEAD_TIME");
	public static UI_Elements	MAP_HOLDER_PRAMETRIC_NAME				= UIFactory.getElements("MAP_HOLDER_PRAMETRIC_NAME");
	public static UI_Elements	MAP_HOLDER_PRAMETRIC_DATA				= UIFactory.getElements("MAP_HOLDER_PRAMETRIC_DATA");
	public static UI_Elements	MAP_HOLDER_IS_GREEN						= UIFactory.getElements("MAP_HOLDER_IS_GREEN");
	public static UI_Elements	MAP_HOLDER_IS_PREFERRED					= UIFactory.getElements("MAP_HOLDER_IS_PREFERRED");
	public static UI_Elements	BUTTON_OK_MAP_COLUMNS					= UIFactory.getElements("BUTTON_OK_MAP_COLUMNS");
	public static UI_Elements	BUTTON_CANCEL_MAP_COLUMNS				= UIFactory.getElements("BUTTON_CANCEL_MAP_COLUMNS");
	public static UI_Elements	PROGRESSING_DIV_ITEM_MASTER_UPLOADING	= UIFactory.getElements("PROGRESSING_DIV_ITEM_MASTER_UPLOADING");

	public static void dragAndDropProductCategory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.dragAndDrop(driver, DRAG_COLUMN_PRODUCT_CATEGORY, MAP_HOLDER_SPSC_CODE);
	}

	public static void dragAndDropDeliveryLeadTime(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.dragAndDrop(driver, DRAG_COLUMN_DELIVERY_LEAD_TIME, MAP_HOLDER_LEAD_TIME);
	}

	public static void dragAndDropIsGreen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.dragAndDrop(driver, DRAG_COLUMN_IS_GREEN, MAP_HOLDER_IS_GREEN);
	}

	public static void dragAndDropIsPreferred(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.dragAndDrop(driver, DRAG_COLUMN_IS_PREFERRED, MAP_HOLDER_IS_PREFERRED);
	}

	public static void dragAndDropSpecifications(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.dragAndDrop(driver, DRAG_COLUMN_SPECIFICATION, MAP_HOLDER_PRAMETRIC_NAME);
	}

	public static void dragAndDropSpecificationsName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.dragAndDrop(driver, DRAG_COLUMN_SPECIFICATION_NAME, MAP_HOLDER_PRAMETRIC_DATA);
	}

	public static void clickOnOkButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on OK Button");
		ActionBot.click(driver, BUTTON_OK_MAP_COLUMNS);
		ActionBot.waitTillPopUpIsPresent(driver, PROGRESSING_DIV_ITEM_MASTER_UPLOADING);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on OK Button");
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel Button");
		ActionBot.click(driver, BUTTON_CANCEL_MAP_COLUMNS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel Button");
	}

}
