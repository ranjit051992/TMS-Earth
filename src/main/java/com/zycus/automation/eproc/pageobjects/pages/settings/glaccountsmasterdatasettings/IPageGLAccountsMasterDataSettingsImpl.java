package com.zycus.automation.eproc.pageobjects.pages.settings.glaccountsmasterdatasettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageGLAccountsMasterDataSettingsImpl implements IPageGLAccountsMasterDataSettings
{

	@Override
	public String enterGLAccountInSearch(WebDriver driver, String testCaseName, String glaccount) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_SEARCH_GL_ACCOUNTS);
		ActionBot.sendKeys(driver, TEXTBOX_SEARCH_GL_ACCOUNTS, glaccount);
		// ScreenShot.screenshot(driver, testCaseName, "After entering gl
		// account");
		ActionBot.defaultSleep();
		String account = ActionBot.getTextWithInElement(driver, TEXTBOX_SEARCH_GL_ACCOUNTS);
		return account;
	}

	@Override
	public void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_GO_GL_ACCOUNTS);
		// ScreenShot.screenshot(driver, testCaseName, "After clicking on GO");

	}

	@Override
	public void clickOnActiveLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_ACTIVE_GL_ACCOUNTS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on active link");
	}

	@Override
	public void clickOnDeactiveLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_DEACTIVE_GL_ACCOUNTS);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on deactive link");

	}

	@Override
	public int selectGlAccountCode(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, GL_ACCOUNT_SEARCH_OPTION));
		select.selectByIndex(index);
		return index;

	}

	@Override
	public void clickOnAddGLAccount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_NEW_GL_ACCOUNT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add GL account link");

	}

	@Override
	public String enterGLAccountName(WebDriver driver, String testCaseName, String glAccount) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_NAME, glAccount);
		ActionBot.defaultSleep();
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_NAME);
		ScreenShot.screenshot(driver, testCaseName, "After enetring gl account name");
		return str;
	}

	@Override
	public String selectCompany(WebDriver driver, String testCaseName, String company) throws ActionBotException
	{
		return ActionBot.selectElement(driver, SELECT_COMPANY_GL_ACCOUNT, IConstantsData.SELECT_BY_VISIBLE_TEXT, company);
	}

	@Override
	public String selectGLAccountType(WebDriver driver, String testCaseName, String glAccountType) throws ActionBotException
	{
		return ActionBot.selectElement(driver, SELECT_GL_ACCOUNT_TYPE, IConstantsData.SELECT_BY_VISIBLE_TEXT, glAccountType);
	}

	@Override
	public Integer enterGLAccountCode(WebDriver driver, String testCaseName, int code) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_GL_ACCOUNT_CODE, " " + code);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After entering gl account code");
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_GL_ACCOUNT_CODE);
		if (str != null)
		{
			int id = Integer.parseInt(str);
			return id;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public void clickOnApplyAddGLAccount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_GL_ACCOUNT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on apply add gl account");

	}

	@Override
	public void clickOnDeleteGLAccount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DELETE_GL_ACCOUNTS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on delete link");
	}

	@Override
	public String getFirstListedGLAccount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, GL_ACCOUNT_NAME_FIRST_LISTED))
		{

			return ActionBot.findElement(driver, GL_ACCOUNT_NAME_FIRST_LISTED).getText();
		}
		ScreenShot.screenshot(driver, testCaseName, "After clicking on delete link");
		return null;
	}

}
