/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.createsourcingevent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public class ModalCreateSourcingEvent
{
	static Logger		logger								= Logger.getLogger(ModalCreateSourcingEvent.class);

	static UI_Elements	SELECT_EVENT_TYPE					= UIFactory.getElements("SELECT_EVENT_TYPE");
	static UI_Elements	TEXTBOX_EVENT_NAME					= UIFactory.getElements("TEXTBOX_EVENT_NAME");
	static UI_Elements	TEXTBOX_EVENT_OWNER					= UIFactory.getElements("TEXTBOX_EVENT_OWNER");
	static UI_Elements	TEXTBOX_EVENT_DESCRIPTION			= UIFactory.getElements("TEXTBOX_EVENT_DESCRIPTION");
	static UI_Elements	CHECKBOX_ATTACH_ITEM_LEVEL_GFORM	= UIFactory.getElements("CHECKBOX_ATTACH_ITEM_LEVEL_GFORM");
	static UI_Elements	BUTTON_CREATE_EVENT					= UIFactory.getElements("BUTTON_CREATE_EVENT");
	static UI_Elements	BUTTON_CANCEL_SOURCING_EVENT		= UIFactory.getElements("BUTTON_CANCEL_SOURCING_EVENT");
	static UI_Elements	LABEL_ITEM_NO_SOURCING_EVENT		= UIFactory.getElements("LABEL_ITEM_NO_SOURCING_EVENT");
	static UI_Elements	LABEL_ITEM_NAME_SOURCING_EVENT		= UIFactory.getElements("LABEL_ITEM_NAME_SOURCING_EVENT");
	static UI_Elements	LABEL_UNIT_PRICE_SOURCING_EVENT		= UIFactory.getElements("LABEL_UNIT_PRICE_SOURCING_EVENT");
	static UI_Elements	LABEL_ITEM_QUANTITY_SOURCING_EVENT	= UIFactory.getElements("LABEL_ITEM_QUANTITY_SOURCING_EVENT");
	static UI_Elements	LABEL_TOTAL_PRICE_SOURCING_EVENT	= UIFactory.getElements("LABEL_TOTAL_PRICE_SOURCING_EVENT");
	static UI_Elements	LOADING_DIV_SAVE_SOURCING_EVENT		= UIFactory.getElements("LOADING_DIV_SAVE_SOURCING_EVENT");

	public static String selectEventType(WebDriver driver, String testCaseName, String eventType) throws ActionBotException
	{
		String selectedEventType = ActionBot.selectElement(driver, SELECT_EVENT_TYPE, IConstantsData.SELECT_BY_VALUE, eventType);
		logger.info("Selected Event Type : " + selectedEventType);
		return selectedEventType;
	}

	public static String fillSourcingEventName(WebDriver driver, String testCaseName, String eventName) throws ActionBotException
	{
		String enteredEventName = ActionBot.sendKeys(driver, TEXTBOX_EVENT_NAME, eventName);
		logger.info("Entered Event Name : " + enteredEventName);
		return enteredEventName;
	}

	public static String fillSourcingEventOwner(WebDriver driver, String testCaseName, String eventOwner) throws ActionBotException
	{
		String enteredEventOwner = ActionBot.fillAutoCompleteField(driver, TEXTBOX_EVENT_OWNER, eventOwner);
		logger.info("Entered Event Owner : " + enteredEventOwner);
		return enteredEventOwner;
	}

	public static String fillSourcingEventDescription(WebDriver driver, String testCaseName, String eventDesc) throws ActionBotException
	{
		String enteredEventDesc = ActionBot.sendKeys(driver, TEXTBOX_EVENT_DESCRIPTION, eventDesc);
		logger.info("Entered Event Description : " + enteredEventDesc);
		return enteredEventDesc;
	}

	public static String getSourcingEventName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String eventName = ActionBot.getAttributeOfElement(driver, TEXTBOX_EVENT_NAME, "value");
		logger.info("Event Name : " + eventName);
		return eventName;
	}

	public static String getSourcingEventOwner(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String eventOwner = ActionBot.getAttributeOfElement(driver, TEXTBOX_EVENT_OWNER, "value");
		logger.info("Event Owner : " + eventOwner);
		return eventOwner;
	}

	public static String getSourcingEventDescription(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String eventDesc = ActionBot.getAttributeOfElement(driver, TEXTBOX_EVENT_DESCRIPTION, "value");
		logger.info("Event Description : " + eventDesc);
		return eventDesc;
	}

	public static void clickOnAttachItemLevelGFrom(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_ATTACH_ITEM_LEVEL_GFORM);
	}

	public static void clickOnCreateEventButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Create Event Button");
		ActionBot.click(driver, BUTTON_CREATE_EVENT);
		ActionBot.waitTillPopUpIsPresent(driver, LOADING_DIV_SAVE_SOURCING_EVENT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Create Event Button");
	}

	public static void clickOnCloseEventButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel Event Button");
		ActionBot.click(driver, BUTTON_CANCEL_SOURCING_EVENT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel Event Button");
	}

	public static String getFirstItemNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String itemNo = ActionBot.getTextWithInElement(driver, LABEL_ITEM_NO_SOURCING_EVENT);
		logger.info("First Item No : " + itemNo);
		return itemNo;
	}

	public static String getFirstItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String itemName = ActionBot.getTextWithInElement(driver, LABEL_ITEM_NAME_SOURCING_EVENT);
		logger.info("First Item Name : " + itemName);
		return itemName;
	}

	public static String getFirstUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String unitPrice = ActionBot.getTextWithInElement(driver, LABEL_UNIT_PRICE_SOURCING_EVENT);
		logger.info("First Unit Price : " + unitPrice);
		return unitPrice;
	}

	public static String getFirstItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String quantity = ActionBot.getTextWithInElement(driver, LABEL_ITEM_QUANTITY_SOURCING_EVENT);
		logger.info("First Item quantity : " + quantity);
		return quantity;
	}

	public static String getFirstItemTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String totalPrice = ActionBot.getTextWithInElement(driver, LABEL_TOTAL_PRICE_SOURCING_EVENT);
		logger.info("First Item Total Price : " + totalPrice);
		return totalPrice;
	}

}
