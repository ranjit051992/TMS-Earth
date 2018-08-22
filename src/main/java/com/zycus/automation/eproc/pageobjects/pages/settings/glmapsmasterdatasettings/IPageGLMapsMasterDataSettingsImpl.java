package com.zycus.automation.eproc.pageobjects.pages.settings.glmapsmasterdatasettings;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageGLMapsMasterDataSettingsImpl implements IPageGLMapsMasterDataSettings
{

	@Override
	public String fillSearch(WebDriver driver, String testCaseName, String glmap) throws ActionBotException

	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_SEARCH_GL_MAPS);
		ele.clear();
		ActionBot.defaultSleep();
		ele.sendKeys(glmap);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		String str = ele.getAttribute("value");
		return str;
	}

	@Override
	public String selectOption(WebDriver driver, String testCaseName, String option) throws ActionBotException

	{
		String gl_map_option;
		Select select = new Select(ActionBot.findElement(driver, SELECT_FROM_OPTIONS_GL_MAPS));
		select.selectByVisibleText(option);
		ScreenShot.screenshot(driver, testCaseName, "After selecting the required option");
		gl_map_option = select.getFirstSelectedOption().getText().trim();
		return gl_map_option;

	}

	@Override
	public void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_GO_GL_MAPS);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnDelete(WebDriver driver, String testCaseName) throws ActionBotException

	{
		ActionBot.click(driver, LINK_DELETE_GL_MAPS);

	}

	@Override
	public void clickOnLinkAddGLRulesMap(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_GL_RULES_MAP);

	}

	@Override
	public String enterCategory(WebDriver driver, String testCaseName, String category) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, TEXTBOX_FILL_CATEGORY_IN_GL_MAP, category);
		ActionBot.defaultSleep();
		return category;
	}

	@Override
	public String selectCompany(WebDriver driver, String testCaseName, String company) throws ActionBotException
	{
		ActionBot.selectElement(driver, SELECT_COMPANY_IN_GL_MAP, IConstantsData.SELECT_BY_VISIBLE_TEXT, company);
		ActionBot.defaultSleep();
		return company;
	}

	@Override
	public String selectPurchaseType(WebDriver driver, String testCaseName, String purchaseType) throws ActionBotException
	{
		ActionBot.selectElement(driver, SELECT_PURCHASE_TYPE_IN_GL_MAP, IConstantsData.SELECT_BY_VISIBLE_TEXT, purchaseType);
		ActionBot.defaultSleep();
		return purchaseType;
	}

	@Override
	public void clickOnAnyPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_ANY_PURCHASE_TYPE_IN_GL_MAP);

	}

	@Override
	public String selectGLAccountType(WebDriver driver, String testCaseName, String glAccountType) throws ActionBotException
	{
		ActionBot.selectElement(driver, SELECT_GL_ACCOUNT_TYPE_IN_GL_MAP, IConstantsData.SELECT_BY_VISIBLE_TEXT, glAccountType);
		ActionBot.defaultSleep();
		return glAccountType;
	}

	@Override
	public String enterGLAccount(WebDriver driver, String testCaseName, String glAccount) throws ActionBotException
	{
		ActionBot.fillAutoCompleteField(driver, TEXTBOX_FILL_GL_ACCOUNT_IN_GL_MAP, glAccount);
		ActionBot.defaultSleep();
		return glAccount;
	}

	@Override
	public void clickOnSaveAddGLRulesMap(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_ADD_GL_CATEGORY_GENERAL_LEDGER_IN_GL_MAP);

	}

	@Override
	public void selectCompanyAndBussinessUnitForGLRuleMap(WebDriver driver, String testCaseName, String company) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SELECT_ORGANIZATION_UNIT_GL_RULEMAP);
		ActionBot.defaultSleep();
		WebElement dropdownWebElementCompanySearchType = ActionBot.findElement(driver, DROPDOWN_COMPANY_SEARCH_BY);
		Select companySearchType = new Select(dropdownWebElementCompanySearchType);
		companySearchType.selectByVisibleText("Name");
		ActionBot.sendKeys(driver, TEXTBOX_SEARCH_COMPANY_OU_PAGE, company);
		ActionBot.click(driver, BUTTON_GO_SELECT_COMPANY);
		ActionBot.defaultSleep();
		ActionBot.click(driver, SELECT_COMPANY_FIRST_RADIO_BUTTON);
		ActionBot.click(driver, TAB_BUSINESS_UNIT_OU_PAGE);
		ActionBot.defaultSleep();

		ActionBot.click(driver, SELECT_OU_AGAINST_COMPANY);
		ActionBot.defaultSleep();

		ActionBot.click(driver, LINK_SELECT_ALL_OU);
		ActionBot.defaultSleep();

		ActionBot.click(driver, SAVE_OU);

		ActionBot.click(driver, SAVE_COMPANY);

	}

}
