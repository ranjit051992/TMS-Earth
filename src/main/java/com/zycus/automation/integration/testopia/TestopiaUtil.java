package com.zycus.automation.integration.testopia;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.zycus.automation.testresult.GenerateResults;
import com.zycus.framework.framework_version_2_4.constants.FrameworkConstants;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

/*
 * @Puneet.sharma
 */
public class TestopiaUtil implements FrameworkConstants
{

	static Logger logger = Logger.getLogger(GenerateResults.class);

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> returns driver </font><b><br>
	 * @param testCase </font><b><br>
	 * @return </b> <br>
	 * 
	 * @throws Exception
	 */

	public static WebDriver getDriver() throws Exception
	{
		DesiredCapabilities capabilities = null;
		WebDriver driver = null;
		String version = null;
		String hubURL = ConfigProperty.getConfig("Hub_URL");

		try
		{

			/*
			 * if (Startup.browserNames.contains("FF")
			 * ||Startup.browserNames.contains("ff") ||
			 * Startup.browserNames.contains("firefox") ||
			 * Startup.browserNames.contains("Firefox")) { capabilities =
			 * DesiredCapabilities.firefox(); } else { capabilities =
			 * DesiredCapabilities.internetExplorer();
			 * capabilities.setCapability("ignoreZoomSetting", true);
			 * capabilities.setCapability("browserName", "iexplore"); }
			 */
			capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("version", version);
			capabilities.setCapability("platform", Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(hubURL), capabilities);
			driver.manage().window().maximize();

		}
		catch (MalformedURLException e)
		{
			logger.info(e.getMessage());
			throw new RuntimeException(e.getMessage(), e);
		}
		catch (WebDriverException e)
		{
			logger.info(e.getMessage());
			throw new RuntimeException(e.getMessage(), e);
		}
		return driver;
	}

}
