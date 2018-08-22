/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.selectcategoryofceform;

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
public interface IModalSelectCategoryOfCEform
{
	static UI_Elements	LINK_SELECT_ALL_CFORM_CATEGORIES	= UIFactory.getElements("LINK_SELECT_ALL_CFORM_CATEGORIES");
	static UI_Elements	CHECKBOX_CFORM_CATEGORIES			= UIFactory.getElements("CHECKBOX_CFORM_CATEGORIES");
	static UI_Elements	BUTTON_SAVE_CFORM_CATEGORY			= UIFactory.getElements("BUTTON_SAVE_CFORM_CATEGORY");
	static UI_Elements	BUTTON_CANCEL_CFORM_CATEGORY		= UIFactory.getElements("BUTTON_CANCEL_CFORM_CATEGORY");
	static UI_Elements	TEXTBOX_SEARCH_CFORM_CATEGORY		= UIFactory.getElements("TEXTBOX_SEARCH_CFORM_CATEGORY");
	static UI_Elements	BUTTON_GO_SEARCH_CFORM_CATEGORY		= UIFactory.getElements("BUTTON_GO_SEARCH_CFORM_CATEGORY");
	static UI_Elements	ANCESTOR_LABEL						= UIFactory.getElements("ANCESTOR_LABEL");

	public void clickOnSelectAllCategories(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getAllCategories(WebDriver driver, String testCaseName) throws ActionBotException;

	public String clickOnCategoryCheckbox(WebDriver driver, String testCaseName, String category) throws ActionBotException;

	public void clickOnSaveCEfromCategoryButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelCEfromCategoryButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSearchCategory(WebDriver driver, String testCaseName, String categoryToBeSearched) throws ActionBotException;

	public void clickOnGoSearchCategoryButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isCategoryPresent(WebDriver driver, String testCaseName) throws ActionBotException;
}
