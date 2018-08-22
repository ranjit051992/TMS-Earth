package com.zycus.automation.eproc.pageobjects.modals.freeTextForm_SelectCategory;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.zycus.automation.eproc.businessflow.fillGuidedItemflow.IFlowFillGuidedItem;
import com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm.IPageFreeTextForm;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalSelectCategoryImpl extends IModalSelectCategoryUtil implements IModalSelectCategory
{

	static Logger logger = Logger.getLogger(IModalSelectCategoryImpl.class);

	@Override
	public String fillSelectCategory(WebDriver driver, String testcaseName, String selectCategory) throws ActionBotException
	{
		String selectedProductCategory = "";
		if (selectCategory == null)
		{
			WebElement element = ActionBot.findElement(driver, SELECT_CATEGORY_FIELD);
			element.sendKeys(Keys.SPACE);
			element.sendKeys(Keys.SPACE);
			element.sendKeys(Keys.SPACE);
			ActionBot.defaultSleep();
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.RETURN);
			ActionBot.waitForPageLoad(driver);
			// ActionBot.defaultMediumSleep();
			selectedProductCategory = ActionBot.findElement(driver, SELECT_CATEGORY_FIELD).getAttribute("value");

			return selectedProductCategory;
		}
		else
		{
			selectedProductCategory = ActionBot.fillAutoCompleteField(driver, SELECT_CATEGORY_FIELD, selectCategory);
			ActionBot.waitTillPopUpIsPresent(driver, IPageFreeTextForm.PRODUCT_CATEGORY_LOADER);
			return selectedProductCategory;
		}
	}

	@Override
	public void toClickCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_BTN);

	}

	@Override
	public void toClickCrossBtnAtHeader(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CROSS_BTN);

	}

	@Override
	public void toClickSelectThisCategoryLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_THIS_CATEGORY);
		ScreenShot.screenshot(driver, testcaseName, "After clicking on Select This Category Button");
	}

	@Override
	public void toClickClearSearchResults(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLEAR_SEARCH_RESULTS);

	}

	@Override
	public boolean isCancelButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, CANCEL_BTN);
	}

	@Override
	public boolean isSelectEformIsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, SELECT_EFORM);
	}

	@Override
	public void clickOnSelectEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SELECT_EFORM);
		// ActionBot.defaultSleep();
	}

	@Override

	public void selectCategoryEform(WebDriver driver, String testCaseName, String eformname) throws ActionBotException
	{
		WebElement element=ActionBot.findElement(driver, By.xpath(".//*[@id='selectCategory']//div[@title='" + eformname + "']"));
		ActionBot.scroll(driver, element);
		ActionBot.click(driver, By.xpath(".//*[@id='selectCategory']//div[@title='" + eformname + "']"));
		ActionBot.waitForPageLoad(driver);
	}

	public void clickOnSeeAlleForms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, SEE_ALL_EFORM_LINK))
		{
			ActionBot.click(driver, SEE_ALL_EFORM_LINK);
		}
	}

	@Override
	public String fillSelectEform(WebDriver driver, String testcaseName, String eFormName) throws ActionBotException
	{

		WebElement element = ActionBot.findElement(driver, SEARCH_EFORM);
		element.sendKeys(eFormName);
		return element.getAttribute("value");
	}

	@Override
	public void clickOnCategoryEformItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CATEGORY_EFORM_ITEMS))
		{
			ActionBot.click(driver, CATEGORY_EFORM_ITEMS);
		}
	}

	/*
	 * to click on category eform link
	 */
	@Override
	public void clickOnCategoryEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, CATEGORY_EFORM_LINK))
		{
			ActionBot.click(driver, CATEGORY_EFORM_LINK);
		}
	}

}
