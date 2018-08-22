/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.selectbuofceform;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.modals.selectcategoryofceform.IModalSelectCategoryOfCEform;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalSelectBUOfCEformImpl implements IModalSelectBUOfCEform
{
	static Logger logger = Logger.getLogger(IModalSelectBUOfCEformImpl.class);

	@Override
	public List<WebElement> getListOfCompanyNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, CHECKBOX_COMPANIES_NAMES_FOR_CEFORM);
	}

	@Override
	public void clickOnSaveORGUnitButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before Saving ORG Unit");
		ActionBot.click(driver, BUTTON_SAVE_ORG_UNIT_FOR_CFORM);
		ScreenShot.screenshot(driver, testCaseName, "After Saving ORG Unit");
	}

	@Override
	public void clickOnCancelORGUnitButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before Clicking on Cancel ORG Unit");
		ActionBot.click(driver, BUTTON_CANCEL_ORG_UNIT_FOR_CFORM);
		ScreenShot.screenshot(driver, testCaseName, "After Clicking on Cancel ORG Unit");
	}

	@Override
	public String clickOnOU(WebDriver driver, String testCaseName, String OU) throws ActionBotException
	{
		// ActionBot.defaultSleep();
		if (!isOUPresentOrNot(driver, testCaseName))
		{
			ActionBot.defaultSleep();
		}
		List<WebElement> listOfCompanies = getListOfCompanyNames(driver, testCaseName);
		String selectedOU = null;
		for (WebElement element : listOfCompanies)
		{
			WebElement parentLabel = element.findElement(IModalSelectCategoryOfCEform.ANCESTOR_LABEL.getBy());
			selectedOU = parentLabel.getText().trim();
			if (selectedOU.equalsIgnoreCase(OU))
			{
				if (!element.isSelected())
				{
					element.click();
				}
				ActionBot.defaultSleep();
				break;
			}
		}
		logger.info("Selected OU : " + selectedOU);
		return selectedOU;
	}

	@Override
	public void selectAllOU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (!isOUPresentOrNot(driver, testCaseName))
		{
			ActionBot.defaultSleep();
		}
		List<WebElement> listOfCompanies = getListOfCompanyNames(driver, testCaseName);
		for (WebElement element : listOfCompanies)
		{
			if (!element.isSelected())
			{
				element.click();
			}
		}

	}

	@Override
	public List<String> getListSelectedOFOUsForPEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> listOfSelectedOUs = new ArrayList<String>();
		List<WebElement> listOfCompanies = ModalSelectBUOfCEform.getListOfCompanyNames(driver, testCaseName);
		String selectedOU = null, log = "";
		WebElement parentLabel = null;
		for (WebElement element : listOfCompanies)
		{
			if (element.isSelected())
			{
				parentLabel = element.findElement(IModalSelectCategoryOfCEform.ANCESTOR_LABEL.getBy());
				selectedOU = parentLabel.getText().trim();
				log += selectedOU + "\n";
				listOfSelectedOUs.add(selectedOU);
			}
		}
		logger.info("Selected OUs : " + log);
		return listOfSelectedOUs;
	}

	@Override
	public void clearAllSelectedOUs(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> listOfCompanies = getListOfCompanyNames(driver, testCaseName);
		for (WebElement element : listOfCompanies)
		{
			if (element.isSelected())
			{
				element.click();
			}
		}

	}

	@Override
	public boolean isOUSelectedOrNot(WebDriver driver, String testCaseName, String ou) throws ActionBotException
	{
		boolean flag = false;
		List<WebElement> listOfCompanies = ModalSelectBUOfCEform.getListOfCompanyNames(driver, testCaseName);
		String selectedOU = null;
		WebElement parentLabel = null;
		if (ou != IConstantsData.ALL)
		{
			for (WebElement element : listOfCompanies)
			{
				parentLabel = element.findElement(IModalSelectCategoryOfCEform.ANCESTOR_LABEL.getBy());
				selectedOU = parentLabel.getText().trim();
				if (selectedOU.equalsIgnoreCase(ou))
				{
					if (element.isSelected())
					{
						flag = true;
					}
					break;
				}
			}
		}
		else
		{
			for (WebElement element : listOfCompanies)
			{
				if (element.isSelected())
				{
					flag = true;
				}
				else
				{
					flag = false;
				}
			}
		}
		return flag;
	}

	@Override
	public boolean isOUPresentOrNot(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, CHECKBOX_COMPANIES_NAMES_FOR_CEFORM);
	}

	@Override
	public void clickTabBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_BU_SELECT_OU);

	}

	@Override
	public void clickLinkSelectBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		//ActionBot.waitTillPopUpIsPresent(driver, By.xpath(".//*[@id='status_overlay_loading']"));
		ActionBot.click(driver, LINK_SELECT_BU);
		ActionBot.waitTillPopUpIsPresent(driver, By.xpath(".//*[@id='status_overlay_loading']"));
	}

	@Override
	public void SelectCheckBoxOU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_ALL_OU_MODAL);

	}

	@Override
	public void BtnSaveSelectedOU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BTN_SAVE_SELECTED_OUS);

	}

	@Override
	public void selectIstOrganisationUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_IST_COMPANY);

	}

	@Override
	public void selectSecOrganisationUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_SEC_COMPANY);

	}

	@Override
	public void clickLinkSelectAllBU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeVisible(driver, 10, LINK_SELECT_ALL_BU);
		ActionBot.click(driver, LINK_SELECT_ALL_BU);

	}

	/*
	 * author : bhakti.sawant : click 1st checkbox
	 */
	@Override
	public void SelectCheckBoxBusinessUnit(WebDriver driver, String testCaseName, String businessUnit) throws ActionBotException
	{
		//select "Name" in dropdown list
		Select select = new Select(ActionBot.findElement(driver, SELECT_SEARCH_IN));
		select.selectByVisibleText("Name");
		ActionBot.waitForPageLoad(driver);

		//wait for textbox to be visible
		ActionBot.waitForElementToBeVisible(driver, 100, SEARCH_BU_TEXTBOX_EFORM);
		ActionBot.findElement(driver, SEARCH_BU_TEXTBOX_EFORM).sendKeys(businessUnit);
		ActionBot.findElement(driver, SEARCH_BU_TEXTBOX_EFORM).sendKeys(Keys.ENTER);
		ActionBot.waitForPageLoad(driver);

		//click first checkbox
		ActionBot.click(driver, SELECT_SEARCHED_FIRST_BU_EFORM);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickLink1StOU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeVisible(driver, 10, LINK_SELECT_ALL_BU);
		ActionBot.click(driver, LINK_SELECT_ALL_BU);

	}

	/*
	 * author : Rohini Shinge
	 */

	@Override
	public void SelectCheckBoxBusinessUnitByCode(WebDriver driver, String testCaseName, String businessUnit) throws ActionBotException
	{
		//select "Name" in dropdown list
		Select select = new Select(ActionBot.findElement(driver, SELECT_SEARCH_IN));
		select.selectByVisibleText("Code");
		ActionBot.waitForPageLoad(driver);

		//wait for textbox to be visible
		ActionBot.waitForElementToBeVisible(driver, 100, SEARCH_BU_TEXTBOX_EFORM);
		ActionBot.findElement(driver, SEARCH_BU_TEXTBOX_EFORM).sendKeys(businessUnit);
		ActionBot.findElement(driver, SEARCH_BU_TEXTBOX_EFORM).sendKeys(Keys.ENTER);
		ActionBot.waitForPageLoad(driver);

		//click first checkbox
		ActionBot.click(driver, SELECT_SEARCHED_FIRST_BU_EFORM);
		ActionBot.defaultSleep();
	}

	@Override
	public void selectCompanyByName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		//select "Name" in dropdown list
		Select select = new Select(ActionBot.findElement(driver, SELECT_SEARCH_NAME));
		select.selectByVisibleText("Name");
		ActionBot.waitForPageLoad(driver);

		//wait for textbox to be visible
		ActionBot.waitForElementToBeVisible(driver, 100, SEARCH_COMPANY_TEXTBOX_EFORM);
		ActionBot.findElement(driver, SEARCH_COMPANY_TEXTBOX_EFORM).sendKeys(companyName);
		ActionBot.findElement(driver, SEARCH_COMPANY_TEXTBOX_EFORM).sendKeys(Keys.ENTER);
		ActionBot.waitForPageLoad(driver);

		//click first checkbox
		ActionBot.click(driver, SELECT_SEARCHED_FIRST_COMPANY_EFORM);
		ActionBot.defaultSleep();
	}
}
