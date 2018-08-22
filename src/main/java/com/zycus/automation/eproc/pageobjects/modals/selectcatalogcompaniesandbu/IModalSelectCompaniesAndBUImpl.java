/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.selectcatalogcompaniesandbu;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 * 
 * 
 */
public class IModalSelectCompaniesAndBUImpl implements IModalSelectCompaniesAndBU
{

	static Logger logger = Logger.getLogger(IModalSelectCompaniesAndBUImpl.class);

	@Override
	public void selectAllOU(WebDriver driver, String testCaseName, String regionName) throws ActionBotException
	{
		if (!isOUPresentOrNot(driver, testCaseName))
		{
			ActionBot.defaultSleep();
		}
		ActionBot.click(driver, BUTTON_EXPAND_TREE);
		ActionBot.defaultSleep();
		List<WebElement> listOfOUs = ActionBot.findElements(driver, CHECK_BOX_SELECT_OU);
		ActionBot.defaultSleep();
		int i = 1;
		for (WebElement element : listOfOUs)
		{
			ActionBot.defaultSleep();
			if (element.isEnabled() && (!element.isSelected()))
			{

				if (regionName != null)
				{
					// locating parent to fetch checkbox text value
					WebElement parent = driver.findElement(By.xpath("(" + CHECK_BOX_SELECT_OU.getValue() + "/..)[" + i + "]"));

					if (parent.getText().equalsIgnoreCase(regionName))
					{
						parent.click();
						break;
					}
				}
				else
				{
					element.click();
				}
			}
			i++;
		}
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After selecting OU");
	}

	@Override
	public String selectOU(WebDriver driver, String testCaseName, String ou) throws ActionBotException
	{
		if (!isOUPresentOrNot(driver, testCaseName))
		{
			ActionBot.defaultSleep();
		}
		List<WebElement> listOfOUs = ActionBot.findElements(driver, CHECK_BOX_SELECT_OU);
		String selectedOU = null;
		for (WebElement element : listOfOUs)
		{
			selectedOU = element.findElement(By.xpath("ancestor::label")).getText().trim();
			if (selectedOU.equalsIgnoreCase(ou))
			{
				if (!element.isSelected())
				{
					element.click();
				}
				break;
			}
		}
		logger.info("Selected OU : " + selectedOU);
		return selectedOU;
	}

	@Override
	public void clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Save Button");
		ActionBot.click(driver, BUTTON_SAVE_OU);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Save Button");
	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Save Button");
		ActionBot.click(driver, BUTTON_CANCEL_OU);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel Button");
	}

	@Override
	public boolean isRegionsTabPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TAB_CATALOG_SCOPE_REGIONS);
	}

	@Override
	public void clickOnRegionsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_CATALOG_SCOPE_REGIONS);
		ActionBot.waitTillPopUpIsPresent(driver, LOADING_DIV);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Regions Tab");
	}

	@Override
	public void clickOnCompaniesTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_CATALOG_SCOPE_COMPANIES);
		ActionBot.waitTillPopUpIsPresent(driver, LOADING_DIV);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Companies Tab");
	}

	@Override
	public void clickOnBusinessUnitsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_BUSINESS_UNIT);
		ActionBot.waitTillPopUpIsPresent(driver, LOADING_DIV);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on BU Tab");
	}

	@Override
	public void clickOnLcoationsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_OU_LOCATION);
		ActionBot.waitTillPopUpIsPresent(driver, LOADING_DIV);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Locations Tab");
	}

	@Override
	public boolean selectRegion(WebDriver driver, String testCaseName, String region) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, By.xpath(".//ul[@id='zytree_scope_regions_tree']//label[contains(text(),'" + region + "')]/input"));
		System.out.println(element.toString());
		if (!element.isSelected())
		{
			element.click();
		}
		return element.isSelected();
	}

	@Override
	public void clickOnSelectOULink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SELECT_ORGANIZATION_UNIT_IN_COMPANIES_TAB);
		ActionBot.waitTillPopUpIsPresent(driver, PROCESSING_DIV_OU_LISTING_TABLE);
	}

	@Override
	public void clickOnSelectAllOUCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECK_BOX_SELECT_ALL_OUS_IN_COMPANIES_TAB);
	}

	@Override
	public void clickOnSaveSelectedOUButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_SELECTED_OUS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save selected OUs button");
	}

	@Override
	public void clickOnCancelSelectedOUButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_SELECTED_OUS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel selected OUs button");
	}

	@Override
	public void clickOnSelectAllBUsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LINK_SELECT_ALL_BUS);
		ActionBot.click(driver, LINK_SELECT_ALL_BUS);

	}

	@Override
	public void clickOnSelectAllLocationsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SELECT_ALL_LOCATIONS);
	}

	@Override
	public void clickOnSaveSelectedScopeButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Save Selected Scope");
		ActionBot.click(driver, BUTTON_SAVE_SELECTED_SCOPE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Save Selected Scope");
	}

	@Override
	public void clickOnCancelSelectedScopeButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel Selected Scope");
		ActionBot.click(driver, BUTTON_CANCEL_SELECTED_SCOPE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel Selected Scope");
	}

	@Override
	public boolean isOUPresentOrNot(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, CHECK_BOX_SELECT_OU);
	}

	@Override
	public void selectIstCompanies(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_OU_IST_COMPANY);

	}

	@Override
	public void selectSecCompanies(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_OU_SEC_COMPANY);

	}

	@Override
	public void clickOnLinkSelecteAllBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementEnabled(driver, LINK_SELECT_ALL_BUSINESS_UNIT))
		{
			ActionBot.click(driver, LINK_SELECT_ALL_BUSINESS_UNIT);
		}
		else
		{
			ActionBot.click(driver, LINK_CLICK_HERE_TO_EDIT);
			ActionBot.click(driver, LINK_SELECT_ALL_BUSINESS_UNIT);
		}

	}

	@Override
	public void clickOnLinkOnLinkHereToEditAllBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CLICK_HERE_TO_EDIT);

	}

	@Override
	public void clickOnOUUnderBUTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SELECT_OU_UNDER_BU_TAB);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnOUUnderLocationsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SELECT_OU_UNDER_LOCATIONS_TAB);
		ActionBot.defaultSleep();
	}

	@Override
	public void selectThirdCompanies(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_OU_THIRD_COMPANY);
		ActionBot.defaultSleep();
	}

	@Override
	public List<String> getAllCompanies(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, LIST_OF_ALL_COMPANIES);
		List<String> companies = new ArrayList<>();
		for (WebElement element : elements)
		{
			companies.add(element.getText());
		}
		return companies;
	}

	@Override
	public List<String> getAllBUs(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, LIST_OF_ALL_BUS);
		List<String> bus = new ArrayList<>();
		for (WebElement element : elements)
		{
			bus.add(element.getText());
		}
		return bus;
	}

	@Override
	public List<String> getAllLocations(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, LIST_OF_ALL_LOCATIONS);
		List<String> locations = new ArrayList<>();
		for (WebElement element : elements)
		{
			locations.add(element.getText());
		}
		return locations;
	}

	@Override
	public void clickOnSelectOUInBUTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SELECT_OU_BU_TAB);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnSaveSelectedOU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_SELECTED_OUS);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnFirstBUCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FIRST_BU_CHECKBOX);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnselectOUInLocationsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, LINK_SELECT_OU_LOCATIONS_TAB);
		ActionBot.defaultSleep();
	}

	@Override
	public boolean isSaveSelectedOUButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, BTN_SAVE_SELECTED_OUS);
		return ActionBot.isElementPresent(driver, BTN_SAVE_SELECTED_OUS);

	}

	@Override
	public boolean isCompaniesTabPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TAB_CATALOG_SCOPE_COMPANIES);
		return ActionBot.isElementEnabled(driver, TAB_CATALOG_SCOPE_COMPANIES);
	}

	@Override
	public boolean isBusinessUnitsTabPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TAB_CATALOG_SCOPE_BUSINESS_UNITS);
		return ActionBot.isElementEnabled(driver, TAB_CATALOG_SCOPE_BUSINESS_UNITS);
	}

	@Override
	public boolean isLocationsTabPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, TAB_CATALOG_SCOPE_LOCATIONS);
		return ActionBot.isElementEnabled(driver, TAB_CATALOG_SCOPE_LOCATIONS);
	}

	@Override
	public boolean isSelectAllBUsLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LINK_SELECT_ALL_BUSINESS_UNIT);
	}

	@Override
	public boolean isSelectAllLocationsLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LINK_SELECT_ALL_LOCATIONS);
	}

}
