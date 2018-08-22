package com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSPageWarehouseMasterDataSettings;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.bo.TMS.Warehouse;
import com.zycus.automation.eproc.pageobjects.modals.selectouaddwarehouse.ModalSelectOUAddWarehouse;
import com.zycus.automation.eproc.pageobjects.popups.confirmationPopUp.PopUpConfirmation;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * 
 * @author t.amarnath
 * 
 */
public class TMSPageWarehouseMasterDataSettings
{
	static UI_Elements	ADD_WAREHOUSE_BUTTON					= UIFactory.getElements("ADD_WAREHOUSE_BUTTON");
	static UI_Elements	TEXTBOX_SEARCH_WAREHOUSE				= UIFactory.getElements("TEXTBOX_SEARCH_WAREHOUSE");
	static UI_Elements	SELECT_IN_SEARCHTYPE_WAREHOUSE_LISTING	= UIFactory.getElements("SELECT_IN_SEARCHTYPE_WAREHOUSE_LISTING");
	static UI_Elements	BUTTON_GO_WAREHOUSE_LISTING				= UIFactory.getElements("BUTTON_GO_WAREHOUSE_LISTING");
	static UI_Elements	WAREHOUSE_LIST_PROCESSING				= UIFactory.getElements("WAREHOUSE_LIST_PROCESSING");
	static UI_Elements	WAREHOUSE_LIST_CLEAR_RESULTS			= UIFactory.getElements("WAREHOUSE_LIST_CLEAR_RESULTS");
	static UI_Elements	FIRST_WAREHOUSE_STATUS					= UIFactory.getElements("FIRST_WAREHOUSE_STATUS");
	static UI_Elements	WAREHOUSE_EDIT_LINK						= UIFactory.getElements("WAREHOUSE_EDIT_LINK");
	static UI_Elements	WAREHOUSE_DELETE_LINK					= UIFactory.getElements("WAREHOUSE_DELETE_LINK");
	static UI_Elements	WAREHOUSE_LISTING_FIRST_WAREHOUSE_NAME	= UIFactory.getElements("WAREHOUSE_LISTING_FIRST_WAREHOUSE_NAME");
	static UI_Elements	WAREHOUSE_NAME_IN_WAREHOUSE_LISTING		= UIFactory.getElements("WAREHOUSE_NAME_IN_WAREHOUSE_LISTING");
	static UI_Elements	FIRST_WAREHOUSE_CODE					= UIFactory.getElements("FIRST_WAREHOUSE_CODE");
	static UI_Elements	FIRST_WAREHOUSE_ADDRESS					= UIFactory.getElements("FIRST_WAREHOUSE_ADDRESS");
	static UI_Elements	FIRST_WAREHOUSE_LOCATION				= UIFactory.getElements("FIRST_WAREHOUSE_LOCATION");
	static UI_Elements	TEXTBOX_WAREHOUSE_NAME					= UIFactory.getElements("TEXTBOX_WAREHOUSE_NAME");
	static UI_Elements	WAREHOUSE_OU_SCOPE						= UIFactory.getElements("WAREHOUSE_OU_SCOPE");
	static UI_Elements	TEXTBOX_WAREHOUSE_ADDRESS				= UIFactory.getElements("TEXTBOX_WAREHOUSE_ADDRESS");
	static UI_Elements	TEXTBOX_WAREHOUSE_LOCATION				= UIFactory.getElements("TEXTBOX_WAREHOUSE_LOCATION");
	static UI_Elements	ADD_WAREHOUSE_BUTTOM_SUBMIT				= UIFactory.getElements("ADD_WAREHOUSE_BUTTOM_SUBMIT");
	static UI_Elements	SELECT_ACTIVE_INACTIVE_IN_SEARCH		= UIFactory.getElements("SELECT_ACTIVE_INACTIVE_IN_SEARCH");
	static UI_Elements	BUTTON_RESET							= UIFactory.getElements("BUTTON_RESET");

	/**
	 * 
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName
	 *        {@link String}
	 * @return {@link Boolean}
	 * @throws ActionBotException
	 *         {@link ActionBotException} Clicks on the add warehouse
	 *         button.
	 */
	public static boolean clickOnAddWarehouseButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ADD_WAREHOUSE_BUTTON))
		{
			ScreenShot.screenshot(driver, testCaseName, "Before clicking Add Warehouse Button");
			ActionBot.click(driver, ADD_WAREHOUSE_BUTTON);
			ScreenShot.screenshot(driver, testCaseName, "After clicking Add Warehouse Button");
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName
	 *        {@link String}
	 * @param warehouseName
	 *        {@link String}
	 * @return {@link String}
	 * @throws ActionBotException
	 *         {@link ActionBotException} Fills the search box with the
	 *         warehouse name
	 */
	public static String fillSearchBox(WebDriver driver, String testCaseName, String warehouseName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_SEARCH_WAREHOUSE, warehouseName);
		return warehouseName;
	}

	/**
	 * 
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName
	 *        {@link String}
	 * @param searchType
	 *        {@link String}
	 * @return {@link String}
	 * @throws ActionBotException
	 *         {@link ActionBotException} Select the type/column to search
	 *         the warehouse
	 */
	public static String searchInWarehouse(WebDriver driver, String testCaseName, String searchType) throws ActionBotException
	{
		WebElement dropdownElement = ActionBot.findElement(driver, SELECT_IN_SEARCHTYPE_WAREHOUSE_LISTING);
		Select select = new Select(dropdownElement);
		if (!(searchType == null))
		{
			select.selectByVisibleText(searchType);
		}
		else
		{
			select.selectByIndex(1);
		}
		return searchType;
	}

	/**
	 * 
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName
	 *        {@link String}
	 * @return {@link Boolean}
	 * @throws ActionBotException
	 *         {@link ActionBotException} Clicks on the GO button and waits
	 *         for the page to be loaded
	 */
	public static boolean clickButtonGo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking button Go");
		if (ActionBot.isElementDisplayed(driver, BUTTON_GO_WAREHOUSE_LISTING))
		{
			ActionBot.click(driver, BUTTON_GO_WAREHOUSE_LISTING);
			ScreenShot.screenshot(driver, testCaseName, "After clicking button Go");
			ActionBot.waitTillPopUpIsPresent(driver, WAREHOUSE_LIST_PROCESSING);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName
	 *        {@link String}
	 * @return {@link Boolean}
	 * @throws ActionBotException
	 *         {@link ActionBotException} Click on the clear result link
	 */
	public static boolean clickOnClearResultsButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, WAREHOUSE_LIST_CLEAR_RESULTS))
		{
			ActionBot.click(driver, WAREHOUSE_LIST_CLEAR_RESULTS);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName
	 *        {@link String}
	 * @return {@link Boolean}
	 * @throws ActionBotException
	 *         {@link ActionBotException} Clicks on the activate warehouse
	 *         link of the first warehouse
	 */
	public static boolean activateWarehouse(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			if (getStatusOfFirstWarehouse(driver, testCaseName).equalsIgnoreCase("Inactive"))
			{
				ActionBot.click(driver, FIRST_WAREHOUSE_STATUS);
				// click on yes button
				return true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName
	 *        {@link String}
	 * @return {@link Boolean}
	 * @throws ActionBotException
	 *         {@link ActionBotException} Clicks on the deactivate warehouse
	 *         link of the first warehouse
	 */
	public static boolean deactivateWarehouse(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			if (getStatusOfFirstWarehouse(driver, testCaseName).equalsIgnoreCase("Active"))
			{
				ActionBot.click(driver, FIRST_WAREHOUSE_STATUS);
				// click on yes button
				return true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName
	 *        {@link String}
	 * @return {@link Boolean}
	 * @throws ActionBotException
	 *         {@link ActionBotException} Clicks on the edit warehouse link
	 *         of the first warehouse
	 */
	public static boolean clickOnEditWarehouseLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, WAREHOUSE_EDIT_LINK))
		{
			ActionBot.click(driver, WAREHOUSE_EDIT_LINK);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName
	 *        {@link String}
	 * @return {@link Boolean}
	 * @throws ActionBotException
	 *         {@link ActionBotException} Clicks on the delete warehouse
	 *         link of the first warehosue
	 * @throws FactoryMethodException
	 */
	public static boolean deleteWarehouse(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		if (ActionBot.isElementDisplayed(driver, WAREHOUSE_DELETE_LINK))
		{
			ActionBot.click(driver, WAREHOUSE_DELETE_LINK);
			ActionBot.defaultLowSleep();
			PopUpConfirmation.clickOnConfirmationYes(driver, testCaseName);
			ActionBot.defaultLowSleep();
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName
	 *        {@link String}
	 * @return {@link String}
	 * @throws ActionBotException
	 *         {@link ActionBotException} Returns the name of the first
	 *         warehouse
	 */

	public static String getFirstWarehouseName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String firstWarehouseName = null;
		if (ActionBot.isElementDisplayed(driver, WAREHOUSE_LISTING_FIRST_WAREHOUSE_NAME))
		{
			try
			{
				firstWarehouseName = ActionBot.getElement(driver, WAREHOUSE_LISTING_FIRST_WAREHOUSE_NAME).getText();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return firstWarehouseName;
	}

	/**
	 * 
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName{@link
	 * 		String}
	 * @return {@link List<String>}
	 * @throws ActionBotException
	 *         {@link ActionBotException} Returns the list of all warehouse
	 *         names
	 */
	public static List<String> getListOfWarehouses(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> elements = new ArrayList<>();
		List<String> listOfWarehouses = new ArrayList<>();
		elements = ActionBot.findElements(driver, WAREHOUSE_NAME_IN_WAREHOUSE_LISTING);
		for (WebElement element : elements)
		{
			listOfWarehouses.add(element.getText());
		}
		return listOfWarehouses;
	}

	/**
	 * 
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName
	 *        {@link String}
	 * @return {@link String}
	 * @throws ActionBotException
	 *         {@link ActionBotException} Returns the status of the first
	 *         warehouse displayed(Active/Inactive)
	 */
	public static String getStatusOfFirstWarehouse(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, FIRST_WAREHOUSE_STATUS))
		{
			try
			{
				return ActionBot.getElement(driver, FIRST_WAREHOUSE_STATUS).getText();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName{@link
	 * 		String}
	 * @return {@link String}
	 * @throws ActionBotException
	 *         {@link ActionBotException} Returns the code of the first
	 *         warehouse displayed
	 */
	public static String getCodeOfFirstWarehouse(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, FIRST_WAREHOUSE_CODE))
		{
			try
			{
				return ActionBot.getElement(driver, FIRST_WAREHOUSE_CODE).getText();
			}
			catch (Exception exception)
			{
				exception.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName
	 *        {@link String}
	 * @return {@link String}
	 * @throws ActionBotException
	 *         {@link ActionBotException} Returns the address of the first
	 *         warehouse displayed
	 */
	public static String getAddressOfFirstWarehouse(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, FIRST_WAREHOUSE_ADDRESS))
		{
			try
			{
				return ActionBot.getElement(driver, FIRST_WAREHOUSE_ADDRESS).getText();
			}
			catch (Exception exception)
			{
				exception.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName
	 *        {@link String}
	 * @return {@link String}
	 * @throws ActionBotException
	 *         {@link ActionBotException} Returns the location of the first
	 *         warehouse displayed
	 */
	public static String getLocationOfFirstWarehouse(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, FIRST_WAREHOUSE_LOCATION))
		{
			try
			{
				return ActionBot.getElement(driver, FIRST_WAREHOUSE_LOCATION).getText();
			}
			catch (Exception exception)
			{
				exception.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * @param driver
	 *        {@link WebDriver}
	 * @param testCaseName
	 *        {@link String}
	 * @param warehouseName
	 *        ({@link String}
	 * @return {@link Warehouse}
	 * @throws ActionBotException
	 *         {@link ActionBotException}
	 */
	public static Warehouse getWarehouseByName(WebDriver driver, String testCaseName, String warehouseName) throws ActionBotException
	{
		Warehouse warehouse = new Warehouse();
		try
		{
			fillSearchBox(driver, testCaseName, warehouseName);
			searchInWarehouse(driver, testCaseName, "Name");
			clickButtonGo(driver, testCaseName);
			if (getCodeOfFirstWarehouse(driver, testCaseName) != null)
			{
				warehouse.setWarehouseName(getFirstWarehouseName(driver, testCaseName));
				warehouse.setWarehouseCode(getCodeOfFirstWarehouse(driver, testCaseName));
				warehouse.setWarehouseStatus(getStatusOfFirstWarehouse(driver, testCaseName));
				warehouse.setWarehouseAddress(getAddressOfFirstWarehouse(driver, testCaseName));
				warehouse.setWarehouseLocation(getAddressOfFirstWarehouse(driver, testCaseName));
				return warehouse;
			}
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		return warehouse;
	}

	public static Warehouse addWarehouse(WebDriver driver, String testCaseName, Warehouse warehouse) throws ActionBotException
	{
		Warehouse createdWarehouse = new Warehouse();
		ScreenShot.screenshot(driver, testCaseName, "Before clicking add warehouse button");
		clickOnAddWarehouseButton(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking add warehouse button");
		if (warehouse.getWarehouseName() != null)
		{
			createdWarehouse.setWarehouseName(ActionBot.sendKeys(driver, TEXTBOX_WAREHOUSE_NAME, warehouse.getWarehouseName()));
		}
		if (warehouse.isIsfillWarehouseScope())
		{
			ActionBot.click(driver, WAREHOUSE_OU_SCOPE);
			ModalSelectOUAddWarehouse.clickOnFirstCompanyRadioButton(driver, testCaseName);
			ModalSelectOUAddWarehouse.clickOnBusinessUnitsTab(driver, testCaseName);
			ModalSelectOUAddWarehouse.clickOnSelectOUInBusinessUnitsTab(driver, testCaseName);
			ModalSelectOUAddWarehouse.clickOnFirstBURadioButton(driver, testCaseName);
			ModalSelectOUAddWarehouse.clickOnSaveSelectedUnitsButton(driver, testCaseName);
			ModalSelectOUAddWarehouse.clickOnSaveSelectedScopeButton(driver, testCaseName);
		}
		if (warehouse.getWarehouseAddress() != null)
		{
			createdWarehouse.setWarehouseAddress(ActionBot.fillAutoCompleteField(driver, TEXTBOX_WAREHOUSE_ADDRESS, warehouse.getWarehouseAddress()));
		}
		if (warehouse.getWarehouseLocation() != null)
		{
			createdWarehouse.setWarehouseLocation(ActionBot.fillAutoCompleteField(driver, TEXTBOX_WAREHOUSE_LOCATION, warehouse.getWarehouseLocation()));
		}
		if (warehouse.getNextActionFillWarehouseDetails().equalsIgnoreCase(IConstantsData.Add_Warehouse))
		{
			ActionBot.click(driver, ADD_WAREHOUSE_BUTTOM_SUBMIT);
		}
		else if (warehouse.getNextActionFillWarehouseDetails().equalsIgnoreCase(IConstantsData.Reset_Warehouse_Fields))
		{
			clickButtonReset(driver, testCaseName);
		}
		ActionBot.waitForPageLoad(driver);
		createdWarehouse.setWarehouseCode(getCodeOfFirstWarehouse(driver, testCaseName));
		return createdWarehouse;
	}

	public static boolean searchWarehouse(WebDriver driver, String testCaseName, String warehouseName, String searchType)
	{
		try
		{
			fillSearchBox(driver, testCaseName, warehouseName);
			searchInWarehouse(driver, testCaseName, searchType);
			clickButtonGo(driver, testCaseName);
			return getFirstWarehouseName(driver, testCaseName).equalsIgnoreCase(warehouseName);
		}
		catch (ActionBotException e)
		{
			e.printStackTrace();
		}
		return false;

	}

	public static String getFirstInactiveWarehouseName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		searchInWarehouse(driver, testCaseName, "Status");
		clickButtonGo(driver, testCaseName);
		ActionBot.waitTillPopUpIsPresent(driver, WAREHOUSE_LIST_PROCESSING);
		return getFirstWarehouseName(driver, testCaseName);
	}

	public static String selectActiveInactive(WebDriver driver, String testCaseName, String status) throws ActionBotException
	{
		WebElement dropdownElement = ActionBot.findElement(driver, SELECT_ACTIVE_INACTIVE_IN_SEARCH);
		Select select = new Select(dropdownElement);
		if (!(status == null))
		{
			select.selectByVisibleText(status);
		}
		else
		{
			select.selectByIndex(1);
		}
		return status;
	}

	public static void clickButtonReset(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking Reset Button");
		ActionBot.click(driver, BUTTON_RESET);
		ScreenShot.screenshot(driver, testCaseName, "After clicking Reset Button");
	}
}
