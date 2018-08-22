/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.selectcategoryofceform;

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
 */
public class IModalSelectCategoryOfCEformImpl implements IModalSelectCategoryOfCEform
{
	static Logger logger = Logger.getLogger(IModalSelectCategoryOfCEformImpl.class);

	@Override
	public void clickOnSelectAllCategories(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SELECT_ALL_CFORM_CATEGORIES);
	}

	@Override
	public List<WebElement> getAllCategories(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, CHECKBOX_CFORM_CATEGORIES);
	}

	@Override
	public void clickOnSaveCEfromCategoryButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before Saving CEfrom Category");
		ActionBot.click(driver, BUTTON_SAVE_CFORM_CATEGORY);
		ScreenShot.screenshot(driver, testCaseName, "After Saving CEfrom Category");
	}

	@Override
	public void clickOnCancelCEfromCategoryButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before Cancelling CEfrom Category");
		ActionBot.click(driver, BUTTON_CANCEL_CFORM_CATEGORY);
		ScreenShot.screenshot(driver, testCaseName, "Before Cancelling CEfrom Category");
	}

	@Override
	public String fillSearchCategory(WebDriver driver, String testCaseName, String categoryToBeSearched) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_SEARCH_CFORM_CATEGORY, categoryToBeSearched);
		String enteredCategory = ActionBot.findElement(driver, TEXTBOX_SEARCH_CFORM_CATEGORY).getAttribute("value").trim();
		logger.info("Entered Searched Category : " + enteredCategory);
		return enteredCategory;
	}

	@Override
	public void clickOnGoSearchCategoryButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before Searching Category");
		ActionBot.click(driver, BUTTON_GO_SEARCH_CFORM_CATEGORY);
		ScreenShot.screenshot(driver, testCaseName, "Before Searching CEfrom Category");
	}

	@Override
	public String clickOnCategoryCheckbox(WebDriver driver, String testCaseName, String category) throws ActionBotException
	{
		if (!isCategoryPresent(driver, testCaseName))
		{
			ActionBot.defaultSleep();
		}
		List<WebElement> listOfCategories = getAllCategories(driver, testCaseName);
		String selectedCategory = null;
		int i=1;
		for (WebElement element : listOfCategories)
		{
			//WebElement parentLabel = element.findElement(ANCESTOR_LABEL.getBy());
			WebElement parentLabel = driver.findElement(By.xpath("("+CHECKBOX_CFORM_CATEGORIES.getValue()+")["+i+"]"+ANCESTOR_LABEL.getValue()));
			selectedCategory = parentLabel.getText().trim();
			if (selectedCategory.equalsIgnoreCase(category))
			{
				element.click();
				break;
			}
			i++;
		}
		return selectedCategory;
	}

	@Override
	public boolean isCategoryPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, CHECKBOX_CFORM_CATEGORIES);
	}
}
