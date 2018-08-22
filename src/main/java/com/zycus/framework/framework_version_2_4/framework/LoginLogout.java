package com.zycus.framework.framework_version_2_4.framework;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.LoginLogoutException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.loginlogout.ILogin;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

/**
 * 
 * Contains Common Methods required for all Products.<br/>
 * Ex : Login, Logout, etc
 * 
 * @author aryasindhu.sahu
 *
 */
public class LoginLogout
{

	static Logger					logger						= Logger.getLogger(LoginLogout.class);

	// Login page Objects

	public final static UI_Elements	TEXTBOX_LOGIN_EMAIL_TEMP	= UIFactory.getElements("TEXTBOX_LOGIN_EMAIL_TEMP");
	public final static UI_Elements	TEXTBOX_LOGIN_EMAIL			= UIFactory.getElements("TEXTBOX_LOGIN_EMAIL");
	public final static UI_Elements	TEXTBOX_LOGIN_PASSWORD_TEMP	= UIFactory.getElements("TEXTBOX_LOGIN_PASSWORD_TEMP");
	public final static UI_Elements	TEXTBOX_LOGIN_PASSWORD		= UIFactory.getElements("TEXTBOX_LOGIN_PASSWORD");
	public final static UI_Elements	BUTTON_LOGIN				= UIFactory.getElements("BUTTON_LOGIN");
	public final static UI_Elements	ERROR_LOGIN_DIV				= UIFactory.getElements("ERROR_LOGIN_DIV");
	public final static UI_Elements	error_button				= UIFactory.getElements("error_button");

	final static String				USERNAME					= "USERNAME";
	final static String				PASSWORD					= "PASSWORD";
	final static String				URL							= "URL";
	final static String				URL_TYPE					= "URL_TYPE";

	/**
	 * set productTab = null to handle tests without product selection page
	 * 
	 * @param driver
	 * @param username
	 * @param password
	 * @param productTab
	 *        <i>Element specifying the product in the Product Selection
	 *        Page</i>
	 * @param productHomePageUniqueElement
	 *        <i>After logging in this element ensures that this is the
	 *        element in the product home page.</i>
	 * @throws TestCaseException
	 * @throws ActionBotException
	 */
	public static void login(WebDriver driver, TestCase testCase, String username, String password, UI_Elements productTab, By productHomePageUniqueElement, String productName)
		throws TestCaseException, ActionBotException, LoginLogoutException
	{
		String productTabString = (productTab == null) ? "null" : productTab.toString();
		logger.info("\n\n ****************************************** Inside login   ************************************************* \n " + "\t\t with username =>" + username
			+ "\t password =>" + password + "\n\t\t" + " URL =>" + ConfigProperty.getConfig("URL") + "\n\t\t" + " productTab =>" + productTabString
			+ " \t productHomePageUniqueElement =>" + productHomePageUniqueElement);
		logger.info("\n ******************************************************************************************************************************************");
		try
		{
			driver.get(ConfigProperty.getConfig("URL"));
			ActionBot.defaultSleep();
			ScreenShot.screenshot(driver, testCase.getTestMethodName(), "Before login");
			ActionBot.clickOnCertificateError(driver, "Login");

			//to handle secure connection failed error.
			if (!(ActionBot.isElementDisplayed(driver, TEXTBOX_LOGIN_EMAIL_TEMP)))
			{
				driver.get(ConfigProperty.getConfig("Product_URL"));
				ActionBot.waitForPageLoad(driver);
			}

			ActionBot.findElement(driver, TEXTBOX_LOGIN_EMAIL_TEMP).click();
			// ActionBot.findElement(driver, TEXTBOX_LOGIN_EMAIL_TEMP).clear();
			ActionBot.findElement(driver, TEXTBOX_LOGIN_EMAIL).clear();
			ActionBot.findElement(driver, TEXTBOX_LOGIN_EMAIL).sendKeys(username);
			ActionBot.findElement(driver, TEXTBOX_LOGIN_PASSWORD_TEMP).click();
			// ActionBot.findElement(driver,
			// TEXTBOX_LOGIN_PASSWORD_TEMP).clear();
			ActionBot.findElement(driver, TEXTBOX_LOGIN_PASSWORD).clear();
			ActionBot.findElement(driver, TEXTBOX_LOGIN_PASSWORD).sendKeys(password);
			ScreenShot.screenshot(driver, testCase.getTestMethodName(), "After filling login info");
			ActionBot.findElement(driver, BUTTON_LOGIN).click();
			ActionBot.defaultSleep();

			ActionBot.clickOnCertificateError(driver, "Login");
			errorInLogin(driver, username, password);

			if (productTab != null)
			{
				if (productName != null)
				{
					if (!ActionBot.isElementDisplayed(driver, productTab))
					{
						ActionBot.click(driver, ILogin.ARROW_NEXT_ON_PRODUCT_SELECTION_TAB);
					}
					Actions actions1 = new Actions(driver);
					actions1.moveToElement(ActionBot.findElement(driver, productTab)).build().perform();
					ActionBot.click(driver, By.id("activePan_" + productName));
				}
				else
				{
					ActionBot.findElement(driver, productTab);
					Actions actions1 = new Actions(driver);
					actions1.moveToElement(ActionBot.findElement(driver, ILogin.EPROC_PRODUCT_SELECTION_TAB)).click().build().perform();
					if (ActionBot.isElementDisplayed(driver, By.id("activePan_eProc")))
					{
						ActionBot.click(driver, By.id("activePan_eProc"));
					}
					Thread.sleep(1000);
				}
			}

			ActionBot.clickOnCertificateError(driver, "Login");

			// BROWSER COMPITABLE ERROR HANDLING
			if (driver.getCurrentUrl().contains("error"))
			{
				List<WebElement> list = WaitUtil.waitForListElementsPresent(driver, error_button.getBy(), 5);
				if (list.size() != 0)
				{
					list.get(0).click();
				}
			}

			// ActionBot.defaultSleep();
			if (productHomePageUniqueElement != null)
			{
				try
				{
					ActionBot.waitForPageLoad(driver);
					WaitUtil.waitForElement(driver, productHomePageUniqueElement, 60);
				}
				catch (WebDriverException e)
				{
					WebElement search = null;
					search = (WebElement) ((JavascriptExecutor) driver).executeScript("return document.getElementById('searchTerm');", search);
					if (!(search == null))
					{
						WebDriverWait wait = new WebDriverWait(driver, 60);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchTerm")));
						logger.info("Search box visible on Page after login");
					}
					else
					{
						logger.info("Search box not visible on Page after login" + e);
					}

				}

			}
		}
		catch (ActionBotException e)
		{
			throw new ActionBotException("Error while loggin-in with username =>" + username + "password =>" + password + " =>", e);
		}
		catch (Exception e)
		{
			ScreenShot.screenshot(driver, testCase.getTestMethodName(), "Exception in Login");
			throw new LoginLogoutException("Error while loggin-in with username =>" + username + "password =>" + password + " =>", e);
		}
	}

	/**
	 * Common Logout method for all the products.
	 * 
	 * @param driver
	 * @param logoutElement
	 *        <i>The element to be used as logout button.</i>
	 * @throws TestCaseException
	 * @throws ActionBotException
	 * @throws LoginLogoutException
	 */
	public static void logout(WebDriver driver, TestCase testCase, By logoutElement) throws ActionBotException, LoginLogoutException
	{
		logger.info("******** Inside logout *********");
		/*
		 * try {
		 */
		ScreenShot.screenshot(driver, testCase.getTestMethodName(), "Before Logout");
		WebElement logout = ActionBot.findElement(driver, logoutElement);
		logout.click();
		// }
		/*
		 * catch (ActionBotException e) { throw new ActionBotException(
		 * "Error while logout => ", e); }
		 */
		/*
		 * catch (Exception e) { ScreenShot.screenshot(driver,
		 * testCase.getTestMethodName(), "Exception in Login"); throw new
		 * LoginLogoutException("Error while logout => ", e); }
		 */
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> retry when error in login occours <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param username </font><b><br>
	 * @param password </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static boolean errorInLogin(WebDriver driver, String username, String password) throws Exception
	{
		logger.info("Checking For Error Div Block");
		boolean isVisible = false;
		if (ActionBot.isElementDisplayed(driver, ERROR_LOGIN_DIV))
		{
			logger.info("Retrying Logging Again");
			String url = driver.getCurrentUrl();
			driver.navigate().refresh();
			driver.switchTo().alert();
			driver.switchTo().alert().accept();
			Thread.sleep(10);
			String currentUrl = driver.getCurrentUrl();
			if (url.equalsIgnoreCase(currentUrl))
			{
				ActionBot.findElement(driver, TEXTBOX_LOGIN_EMAIL_TEMP).clear();
				ActionBot.findElement(driver, TEXTBOX_LOGIN_EMAIL).clear();
				ActionBot.findElement(driver, TEXTBOX_LOGIN_EMAIL).sendKeys(username);
				ActionBot.findElement(driver, TEXTBOX_LOGIN_PASSWORD_TEMP).clear();
				ActionBot.findElement(driver, TEXTBOX_LOGIN_PASSWORD).clear();
				ActionBot.findElement(driver, TEXTBOX_LOGIN_PASSWORD).sendKeys(password);
				ActionBot.findElement(driver, BUTTON_LOGIN).click();
				ActionBot.defaultSleep();
				isVisible = true;
			}
		}
		if (isVisible)
		{
			Thread.sleep(5);
			if (ActionBot.isElementDisplayed(driver, ERROR_LOGIN_DIV))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			return true;
		}
	}
}
