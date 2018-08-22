package com.zycus.automation.eproc.pageobjects.pages.settings.projectsmasterdatasettings;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageProjectsMasterDataSettingsImpl implements IPageProjectsMasterDataSettings
{
	static Logger logger = Logger.getLogger(IPageProjectsMasterDataSettingsImpl.class);

	@Override
	public String getSearch(WebDriver driver, String testCaseName, String search) throws ActionBotException
	{
		ActionBot.click(driver, TEXTBOX_SEARCH_PROJECTS);
		ActionBot.sendKeys(driver, TEXTBOX_SEARCH_PROJECTS, search);
		search = ActionBot.getTextWithInElement(driver, TEXTBOX_SEARCH_PROJECTS);
		ScreenShot.screenshot(driver, testCaseName, "After entering data in search");
		return search;
	}

	@Override
	public void clickOnGo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_GO_PROJECT_PAGE);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on GO");
	}

	@Override
	public String getProjectName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String projectName = ActionBot.getTextWithInElement(driver, PROJECT_NAME);
		logger.info("Searched Project Name : " + projectName);
		return projectName;
	}

	@Override
	public void clickOnActive(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ACTIVE);
	}

	@Override
	public void clickOnDelete(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DELETE);

	}

	@Override
	public boolean isProjectActive(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LINK_ACTIVE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isProjectOutdated(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, OUTDATED_PROJECT))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String fillProjectSearchBox(WebDriver driver, String testCaseName, String SearchItem) throws ActionBotException
	{
		String enteredValue = ActionBot.sendKeys(driver, TEXTBOX_SEARCH_PROJECTS, SearchItem);
		logger.info("Entered Value : " + enteredValue);
		return enteredValue;
	}

	@Override
	public String getProjectCode(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Project Code");
		String Projectcode = ActionBot.getTextWithInElement(driver, PROJECT_CODE);

		return Projectcode;
	}

	@Override
	public void clickOnEdit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on edit link");
	}

	@Override
	public String getProjectManagername(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Project Manager name");
		String ProjectManagername = ActionBot.getTextWithInElement(driver, PROJECTMANAGER_NAME);
		logger.info("Project Manage rname " + ProjectManagername);
		return ProjectManagername;
	}

	@Override
	public String getDurationDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Project Manager name");
		String ProjectManagername = ActionBot.getTextWithInElement(driver, DURATION_DATE);
		logger.info("Project Manage rname " + ProjectManagername);
		return ProjectManagername;
	}

	@Override
	public void clickOnActiveProjectToDeactivateIt(WebDriver driver, String testCaseName, int id) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='projectList']//tr[" + id + "]//a[@class='icon active status scLnk']"));

	}

	@Override
	public void clickOnDeActive(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_DEACTIVE))
			ActionBot.click(driver, LINK_DEACTIVE);

	}

	@Override
	public void clickOnAddProjectLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_PROJECT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add project");

	}

	@Override
	public int fillProjectNumber(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_NUMBER, " " + index);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_NUMBER);
		if (str != null)
		{
			int no = Integer.parseInt(str);
			return no;
		}
		else
		{
			return 0;
		}

	}

	@Override
	public String fillProjectName(WebDriver driver, String testCaseName, String name) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_NAME, name);
		return ActionBot.getTextWithInElement(driver, TEXTBOX_NAME);
	}

	@Override
	public String selectCompany(WebDriver driver, String testCaseName, String company) throws ActionBotException
	{
		// ActionBot.fillAutoCompleteField(driver, SELECT_COMPANY_IN_PROJECT,
		// company);
		ActionBot.selectElement(driver, SELECT_COMPANY_IN_PROJECT, IConstantsData.SELECT_BY_VISIBLE_TEXT, company);
		return ActionBot.getTextWithInElement(driver, SELECT_COMPANY_IN_PROJECT);
	}

	@Override
	public void clickOnSaveAddedProject(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_ADD_PROJECT);
		ScreenShot.screenshot(driver, testCaseName, "After saving created project");

	}

	@Override
	public void clickOnSelectBU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SELECT_BU);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on BU link");
	}

	@Override
	public String fillProjectEndDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{

		ActionBot.defaultSleep();
		ActionBot.click(driver, PROJECT_END_DATE);
		// year
		Select select = new Select(ActionBot.findElement(driver, SELECT_YEAR));
		select.selectByValue(year);

		// month
		select = new Select(ActionBot.findElement(driver, SELECT_MONTH));
		select.selectByValue(month);

		// day
		ActionBot.click(driver, By.linkText(day));

		String requiredByDate = ActionBot.findElement(driver, PROJECT_END_DATE).getAttribute("value").trim();
		logger.info("Selected end Date : " + requiredByDate);
		ScreenShot.screenshot(driver, testCaseName, "After changing end date");
		return requiredByDate;
	}

	@Override
	public void clickOnClearDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CLEAR_END_DATE_IN_PROJECT);

	}

	@Override
	public String selectSearchProjectIn(WebDriver driver, String testCaseName, String searchIn) throws ActionBotException
	{
		String searchProjectIn = ActionBot.selectElement(driver, SELECT_SEARCH_PROJECT_IN, IConstantsData.SELECT_BY_VISIBLE_TEXT, searchIn);
		logger.info("Selected Search Project In : " + searchProjectIn);
		return searchProjectIn;
	}

	@Override
	public boolean isDataTableEmptyPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABEL_DATA_TABLES_EMPTY_FOR_PROJECT_LISTING);
	}

	@Override
	public boolean isProjectDeactive(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LINK_DEACTIVE);
	}

}
