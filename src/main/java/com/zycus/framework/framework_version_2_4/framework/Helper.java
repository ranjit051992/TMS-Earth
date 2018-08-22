package com.zycus.framework.framework_version_2_4.framework;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;

import bsh.StringUtil;

import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.startup.Startup;

/**
 * 
 * Contains all common methods to help the TestCases for every Product.
 * 
 * @author aryasindhu.sahu
 *
 */

public class Helper
{

	static Logger				logger				= Logger.getLogger(Helper.class);
	private static final int	PASS_SCREENSHOT		= 1;
	private static final int	FAIL_SCREENSHOT		= 2;
	private static final int	CUSTOM_SCREENSHOT	= 3;

	/**
	 * Takes screenShot with name <b>pass_<i>testCaseName</i>.png</b>
	 * 
	 * @param driver
	 * @param testCaseName
	 * @throws IOException
	 */
	public static void takeScreenShotOfPassedTC(WebDriver driver, String testCaseName)
	{
		takeScreenShot(driver, testCaseName, PASS_SCREENSHOT);
	}

	/**
	 * Takes screenShot with name <b>fail_<i>testCaseName</i>.png</b>
	 * 
	 * @param driver
	 * @param testCaseName
	 * @throws IOException
	 */
	public static void takeScreenShotOfFailedTC(WebDriver driver, String testCaseName)
	{
		takeScreenShot(driver, testCaseName, FAIL_SCREENSHOT);
	}

	/**
	 * Take screenshot at any custom instance of time. Generated screenshot
	 * shall have name as : <b>custom_screenShotName.png</b>
	 * 
	 * @param driver
	 * @param screenShotName
	 * @throws IOException
	 */
	public static void takeScreenShotOfTC(WebDriver driver, String screenShotName)
	{
		takeScreenShot(driver, screenShotName, CUSTOM_SCREENSHOT);
	}

	private static void takeScreenShot(WebDriver driver, String screenShotName, int type)
	{
		if (driver != null)
		{
			WebDriver tempDriver = driver;
			TestCase testCase = Startup.driverTestCaseMap.get(driver);
			String testCaseDirectory = testCase.getBrowser() + "_" + testCase.getVersion() + "/" + testCase.getTestMethodName() + "/";
			String takeScreenshotString = ConfigProperty.getConfig("Take_Screenshot");
			boolean takeScreenshot = true;
			if (takeScreenshotString != null)
			{
				if (takeScreenshotString.equalsIgnoreCase("false"))
				{
					takeScreenshot = false;
				}
			}
			if (takeScreenshot)
			{
				String screenShotPrefix;
				switch (type)
				{
					case PASS_SCREENSHOT:
						screenShotPrefix = "pass_" + screenShotName;
						break;
					case FAIL_SCREENSHOT:
						screenShotPrefix = "fail_" + screenShotName;
						break;
					case CUSTOM_SCREENSHOT:
						screenShotPrefix = "custom_" + screenShotName;
						break;
					default:
						screenShotPrefix = screenShotName;
				}
				// If driver is not Firefox or IE Driver i.e. not a Local Driver
				if (!(driver instanceof InternetExplorerDriver) && !(driver instanceof FirefoxDriver))
				{
					// RemoteWebDriver Specific Code
					tempDriver = new Augmenter().augment(tempDriver);
				}
				try
				{
					File scrFile = ((TakesScreenshot) tempDriver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(ConfigProperty.getConfig("screenShotsDir") + testCaseDirectory + screenShotPrefix + ".png"));
				}
				catch (IOException e)
				{
					logger.error("Unable to save screenshot, screenShotName=>" + screenShotName + " type=>" + type, e);
				}
				catch (NullPointerException e)
				{
					logger.error("Unable to save screenshot, Driver is NULL :", e);
				}
				catch (Exception e)
				{
					logger.error("Unable to save screenshot :", e);
				}
			}
		}
		else
		{
			logger.info("Can not take screenshot, Driver is NULL");
		}
	}

	public static String getRandomString(int size)
	{
		String randomString = RandomStringUtils.randomAlphabetic(size);
		return randomString;
	}

	public static String getRandomNumber(int size)
	{
		String randomString = RandomStringUtils.randomNumeric(size);
		return randomString;
	}

	/**
	 * 
	 * <b>Author: kunal.ashar </b> <b>Description : changing method to generate
	 * alphanumeric string. Initially it used to generate only alpha string
	 */
	public static String getRandomAlphaNumeric(int size)
	{
		String randomString = RandomStringUtils.randomAlphabetic(size / 2) + RandomStringUtils.randomNumeric(size / 2);
		return randomString;
	}

	public static void selectValueFromDropDown(WebElement dropdown, final String value)
	{
		List<WebElement> options = dropdown.findElements(By.tagName("option"));
		for (WebElement option : options)
		{
			if (value.equals(option.getText()))
			{
				option.click();
				break;
			}
		}
	}

	public static String returnKeyValuePair(String str)
	{
		String keyValuePair = null;
		keyValuePair = ConfigProperty.getConfig(str.trim());
		if (keyValuePair == null)
		{
			logger.info("VALUE CORRESPONDING TO THE KEY " + str + " DOES NOT FOUND");
			return null;
		}
		return keyValuePair;
	}

	public static String appendUnderScore(String string)
	{
		String str = null;
		try
		{
			if (string.contains(" "))
			{
				String[] str1 = StringUtil.split(string, " ");
				for (String str2 : str1)
				{
					if (str == null)
					{
						str = str2;
					}
					else
					{
						if (str == null)
						{
							continue;
						}
						str = str.concat("_").concat(str2);
					}
				}
				if (str == null)
				{
					str = string;
				}
			}
			else
			{
				str = "" + string;
			}
		}
		catch (Exception e)
		{
			str = "" + string;
		}
		return str.toUpperCase();
	}

}
