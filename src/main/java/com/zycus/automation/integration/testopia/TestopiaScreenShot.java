package com.zycus.automation.integration.testopia;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;

import com.zycus.framework.framework_version_2_4.constants.FrameworkConstants;
import com.zycus.framework.framework_version_2_4.framework.Helper;

public class TestopiaScreenShot implements FrameworkConstants
{

	static Logger		logger		= Logger.getLogger(TestopiaScreenShot.class);

	private static int	assertion	= 0;
	private static int	exception	= 1;

	private static void screenShot(WebDriver driver, String screenShotName)
	{
		try
		{
			WebDriver tempDriver = driver;
			String tempdir = testopiaScreenShot;
			long screenShotPrefix = System.currentTimeMillis();
			String screenShotSuffix = "_".concat(screenShotName);
			if (takeScreenShot.equalsIgnoreCase("false") || takeScreenShot.equalsIgnoreCase("no"))
			{
				logger.info("SCREENSHOT IS BEEN SKIPPED");
			}
			else if (takeScreenShot.equalsIgnoreCase("true") || takeScreenShot.equalsIgnoreCase("yes"))
			{

				if ((!(driver instanceof InternetExplorerDriver)) && (!(driver instanceof FirefoxDriver)))
				{
					tempDriver = new Augmenter().augment(tempDriver);
				}
				try
				{
					String name = screenShotPrefix + screenShotSuffix + ".png";
					File scrFile = ((TakesScreenshot) tempDriver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(tempdir + name));
				}
				catch (IOException e)
				{
					logger.error("UNABLE TO SAVE SCREENSHOT WITH NAME ==> " + screenShotName, e);
				}
				catch (Exception e)
				{
					logger.error("UNABLE TO SAVE SCREENSHOT WITH NAME ==>" + screenShotName, e);
				}

			}
			else
			{
				logger.error("DRIVER IS NULL");
			}
		}

		catch (Exception e)
		{
			logger.error("[-- Harmless --] Error While Taking ScreenShot" + e);
		}
	}

	private static void screenShot(WebDriver driver, String screenShotName, int type)
	{

		switch (type)
		{
			case 0: {
				screenShotName = screenShotName.concat("_ASSERTION_!!!!!!!");
				break;
			}
			case 1: {
				screenShotName = screenShotName.concat("_EXCEPTION_!!!!!!!");
				break;
			}
		}
		screenShot(driver, screenShotName);
	}

	private static void assertScreenShot(WebDriver driver, String screenShotName)
	{
		screenShot(driver, screenShotName, assertion);
	}

	private static void exceptionScreenShot(WebDriver driver, String screenShotName)
	{
		screenShot(driver, screenShotName, exception);
	}

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> Takes screenshot for normal execution of
	 * tc after checking the status of driver. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param by </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static void screenshot(WebDriver driver, String str)
	{
		str = Helper.appendUnderScore(str);
		if (driver != null)
		{
			screenShot(driver, str);
		}
		else
		{
			logger.info("Driver is Found To Be Dead Hence Aborting ScreenShot".toString());
		}
	}

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> Takes screenshot on assertion of tc after
	 * checking the status of driver. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param by </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static void assertScreenshot(WebDriver driver, String str)
	{
		if (driver != null)
		{
			assertScreenShot(driver, str);
		}
		else
		{
			logger.info("Driver is Found To Be Dead Hence Aborting ScreenShot");
		}
	}

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> Takes screenshot on exception of tc after
	 * checking the status of driver. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param by </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static void exceptionScreenshot(WebDriver driver, String str)
	{
		if (driver != null)
		{
			exceptionScreenShot(driver, str);
		}
		else
		{
			logger.info("Driver is Found To Be Dead Hence Aborting ScreenShot");
		}
	}
}