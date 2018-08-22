/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.comparecatalogitems;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageCompareCatalogItems
{

	static UI_Elements				LABEL_COMPARED_ITEM_NAMES	= UIFactory.getElements("LABEL_COMPARED_ITEM_NAMES");
	static UI_Elements				LABEL_SPECIFICATION_KEY1	= UIFactory.getElements("LABEL_SPECIFICATION_KEY1");
	static UI_Elements				LABEL_SPECIFICATION_KEY2	= UIFactory.getElements("LABEL_SPECIFICATION_KEY2");
	public static final UI_Elements	ACTION_ADD_TO_FAVOURITE		= UIFactory.getElements("ACTION_ADD_TO_FAVOURITE");
	public static final UI_Elements	ACTION_ADD_TO_BASKET		= UIFactory.getElements("ACTION_ADD_TO_BASKET");
	public static final UI_Elements	ACTION_REMOVE_ITEM			= UIFactory.getElements("ACTION_REMOVE_ITEM");
	static String					xpath1_itemName				= ".//*[@id='compareItemsGrid']//td[";
	static String					xpath2_itemName				= "]//a[contains(@class,'itmName')]";
	static String					xpath1_unitPrice			= ".//*[@id='compareItemsGrid']//tr[3]/td[";
	static String					xpath2_withSpan				= "]/div/span";
	static String					xpath1_availability			= ".//*[@id='compareItemsGrid']//tr[4]/td[";
	static String					xpath2_withDiv				= "]/div";
	static String					xpath1_supplierName			= ".//*[@id='compareItemsGrid']//tr[6]/td[";
	static String					xpath1_supplierPartId		= ".//*[@id='compareItemsGrid']//tr[7]/td[";
	static String					xpath1_marketPrice			= ".//*[@id='compareItemsGrid']//tr[8]/td[";
	static String					xpath1_manufacturerName		= ".//*[@id='compareItemsGrid']//tr[10]/td[";
	static String					xpath1_manufacturerPartId	= ".//*[@id='compareItemsGrid']//tr[11]/td[";
	static String					xpath1_description			= ".//*[@id='compareItemsGrid']//tr[12]/td[";
	static String					xpath1_specValue1			= ".//*[@id='compareItemsGrid']//tr[12]/td[";
	static String					xpath1_specValue2			= ".//*[@id='compareItemsGrid']//tr[13]/td[";
	static String					xpath1_attachment			= ".//*[@id='compareItemsGrid']//tr[.//*[contains(text(),'Attachment')]]/td[";
	static String					xpath2_attachment			= "]//li/a";
	static String					xpath1_inputFieldQuantity	= "(.//*[@id='compareItemsGrid']//input[contains(@class,'qty_";
	static String					xpath2_inputFieldQuantity	= "')])[";
	static String					xpath1_addToCartButton		= ".//*[@id='compareItemsGrid']//td[";
	static String					xpath2_addToCartButton		= "]//div[contains(@class,'cmprAddToCartBxR')]/a";
	public static final String		xpath1_compareParameters	= ".//*[@id='compareItemsGrid']//tr[";
	public static final String		xpath2_compareParameters	= "]/td[1]";
	public static final String		xpath1_hoverToSeeAction		= ".//*[@id='compareItemsGrid']//td[";
	public static final String		xpath2_hoverToSeeAction		= "]/div[@class=\"pad imgC\"] ";
	public static final String		xpath1_compareAction		= ".//*[@id='compareItemsGrid']//tr[1]/td[";
	public static final String		xpath2_compareAction		= "]//div[@class=\"mnuArr\"]";

	List<WebElement> getListOfItemsCompared(WebDriver driver, String testCaseName) throws ActionBotException;

	String getComparedItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getComparedItemUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getComparedItemAvailability(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getComparedItemSupplierName(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getComparedItemSupplierPartId(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getComparedItemMarketPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getComparedItemManufacturerName(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getComparedItemManufacturerPartId(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getComparedItemDescription(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getComparedItemSpecKey(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getComparedItemSpecValue(WebDriver driver, String testCaseName, int columnIndex, int valueIndex) throws ActionBotException;

	String getComparedItemAttachment(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	List<String> getComparedItemAttachments(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	int fillQuantity(WebDriver driver, String testCaseName, String itemId, int quantity, int index) throws ActionBotException;

	int getQuantity(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	public void clickOnAddToCartButton(WebDriver driver, String testCaseName, int index) throws ActionBotException;

}
