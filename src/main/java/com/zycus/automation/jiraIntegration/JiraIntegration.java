package com.zycus.automation.jiraIntegration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class JiraIntegration implements JiraPageObjects
{

	// WebDriver driver = new FirefoxDriver();

	public static void main(String[] args) throws ActionBotException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\eProcData\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		JiraLogin(driver);

		// JiraProjectSelection(driver);

		JiraPlanTestCycleSelection(driver);

		JiraLogout(driver);
	}

	private static void JiraLogin(WebDriver driver) throws ActionBotException
	{
		// navigates to login page
		driver.get(JIRA_URL);

		// to enter username and password
		ActionBot.sendKeys(driver, Text_Username, JIRA_USERNAME);
		ActionBot.click(driver, Button_Login);
		ActionBot.defaultSleep();
		ActionBot.sendKeys(driver, Text_Password, JIRA_PASSWORD);
		ActionBot.click(driver, Button_Login);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, "Jira", "after clicking on login button");
	}

	private static void JiraLogout(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, Link_Header_Menu);
		ActionBot.click(driver, Link_Logout);
		ScreenShot.screenshot(driver, "Jira", "after clicking on logout link");
		driver.close();
	}

	private static void JiraProjectSelection(WebDriver driver) throws ActionBotException
	{
		// to click on view all project from project selection menu
		ActionBot.click(driver, Header_project);
		ActionBot.click(driver, Link_viewAllProject);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, "Jira", "after navigating to project listing page");

		// to search for specific project
		ActionBot.sendKeys(driver, Text_searchProject, JIRA_PROJECT);
		ActionBot.defaultSleep();
		ActionBot.click(driver, Link_projectName);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, "Jira", "after selecting project from listing page");
	}

	private static void JiraPlanTestCycleSelection(WebDriver driver) throws ActionBotException
	{
		// to navigate to Plan test cycle page
		/*
		 * ActionBot.click(driver, Header_tests); ActionBot.click(driver,
		 * Link_searchTestExecution); ActionBot.waitForPageLoad(driver);
		 * ActionBot.defaultMediumSleep(); //ActionBot.click(driver,
		 * Link_advance);
		 * 
		 * ActionBot.click(driver, By.xpath(
		 * ".//*[@id='search-field-container']//*[@data-id='cycleName']"));
		 * 
		 * //to search for current release if(ActionBot.isElementPresent(driver,
		 * Link_advance)){
		 * 
		 * ActionBot.defaultMediumSleep(); }
		 * 
		 * //search cases using zql query
		 * if(ActionBot.isElementDisplayed(driver, Text_zqlQueryToSearch)){
		 * ActionBot.sendKeys(driver, Text_zqlQueryToSearch, "Test"); }
		 */

	}

}
