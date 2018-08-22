package com.zycus.framework.framework_version_2_4.framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;
import com.zycus.framework.framework_version_2_4.startup.Startup;

/**
 * 
 * @author aryasindhu.sahu
 *
 */
public class DriverSelector
{

	static Logger logger = Logger.getLogger(DriverSelector.class);

	/**
	 * 
	 * @return WebDriver
	 * @throws Exception
	 * @throws TestCaseException
	 * @throws MalformedURLException
	 */
	public static WebDriver getDriver(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		try
		{
			MDC.put("TestCaseName", testCase.getTestMethodName());
			DesiredCapabilities capabilities = null;
			Map<String, String> configMap = ConfigProperty.getConfigMap();
			String browser = testCase.getBrowser();
			String version = testCase.getVersion();
			String runOn = configMap.get("Run_On");
			String hubURL = configMap.get("Hub_URL");
			String IEDriverLocation = configMap.get("IE_Driver_Location");
			String inputFileLocation = configMap.get("Input_Files_Location");
			String CHROME_DRIVER_Location = configMap.get("CHROME_DRIVER_Location");
			String CHROME_DRIVER_32_FileName = configMap.get("CHROME_DRIVER_32_FileName");
			String EdgeDriverFileName = configMap.get("EDGE_DRIVER_FILENAME");

			if (runOn.equalsIgnoreCase("Grid"))
			{
				try
				{
					if (browser.equalsIgnoreCase("Firefox"))
					{
						capabilities = DesiredCapabilities.firefox();
						// to find java script error
						FirefoxProfile firefoxProfile = new FirefoxProfile();
						firefoxProfile.setPreference("xpinstall.signatures.required", false);

						// FOR TESTING PURPOSE FOR AUTO DOWNLAOD PDF
						firefoxProfile.setPreference("browser.download.folderList", 2);
						firefoxProfile.setPreference("browser.download.dir", "C:\\Windows\\temp");
						firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
						firefoxProfile.setPreference("pdfjs.disabled", true); // disable
																				// the
																				// built-in
																				// PDF
																				// viewer

						// to resolve secured connection failed issue.
						firefoxProfile.setPreference("security.tls.insecure_fallback_hosts",
								ConfigProperty.getConfig("URL"));

						// JavaScriptError.addExtension(firefoxProfile);
						capabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
					}
					else if (browser.equalsIgnoreCase("Internet Explorer"))
					{
						capabilities = DesiredCapabilities.internetExplorer();
						capabilities.setCapability("ignoreZoomSetting", true);
						capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
					}
					else if (browser.equalsIgnoreCase("Chrome"))
					{
						capabilities = DesiredCapabilities.chrome();
						// TODO: Extra
						ChromeOptions options = new ChromeOptions();
						options.addArguments("test-type");
						options.addArguments("start-maximized");
						options.addArguments("--no-sandbox");
						capabilities.setCapability(ChromeOptions.CAPABILITY, options);
						// to find java script error
						/*
						 * LoggingPreferences loggingPreferences = new
						 * LoggingPreferences();
						 * loggingPreferences.enable(LogType.BROWSER,
						 * Level.ALL);
						 * capabilities.setCapability(CapabilityType.
						 * LOGGING_PREFS, loggingPreferences);
						 */
						/********************* Extra *************/
					}
					else if (browser.equalsIgnoreCase("Edge"))
					{
						capabilities = DesiredCapabilities.edge();
						EdgeOptions options = new EdgeOptions();
						capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
						capabilities.setCapability(EdgeOptions.CAPABILITY, options);
					}
					capabilities.setCapability("version", version);
					capabilities.setCapability("platform", Platform.WINDOWS);
					driver = new RemoteWebDriver(new URL(hubURL), capabilities);
					// TODO: Extra
					try
					{
						Thread.sleep(4000);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					if (!browser.equalsIgnoreCase("chrome"))
					{
						driver.manage().window().maximize();
					}

					/**
					 * If Running On HUB configuration, get the NODE URL(i.e.
					 * IP:PORT) Add Node URL to TestCase Object
					 */
					String[] nodeIpAndPort = GridUtil
							.getNodeIPAndPort(((RemoteWebDriver) driver).getSessionId().toString());
					if (nodeIpAndPort[0] != null && nodeIpAndPort[1] != null)
					{
						testCase.setNodeAddress(nodeIpAndPort[0] + ":" + nodeIpAndPort[1]);
					}
					logger.info("TestCase :" + testCase.getTestMethodName() + " On : " + testCase.getNodeAddress());

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
			}
			else if (runOn.equalsIgnoreCase("Local"))
			{
				if (browser.equalsIgnoreCase("Firefox"))
				{
					System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\Ghecko-19.0\\geckodriver.exe");
					DesiredCapabilities firefoxCapability = DesiredCapabilities.firefox();
					firefoxCapability.setCapability("acceptInsecureCerts", true);
					driver = new FirefoxDriver(firefoxCapability);

					// Old Code
					/*
					 * // to find java script error FirefoxProfile
					 * firefoxProfile = new FirefoxProfile();
					 * firefoxProfile.setPreference(
					 * "xpinstall.signatures.required", false);
					 * JavaScriptError.addExtension(firefoxProfile); driver =
					 * new FirefoxDriver(firefoxProfile);
					 */
				}
				else if (browser.equalsIgnoreCase("Internet Explorer"))
				{
					boolean is64bit = false;
					if (System.getProperty("os.name").contains("Windows"))
					{
						is64bit = (System.getenv("ProgramFiles(x86)") != null);
					}
					else
					{
						is64bit = (System.getProperty("os.arch").indexOf("64") != -1);
					}
					if (is64bit)
					{
						System.setProperty("webdriver.ie.driver",
								inputFileLocation + IEDriverLocation + configMap.get("IE_Driver_64_FileName"));
					}
					else
					{
						System.setProperty("webdriver.ie.driver",
								inputFileLocation + IEDriverLocation + configMap.get("IE_Driver_32_FileName"));
					}
					DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
					ieCapabilities.setCapability("ignoreZoomSetting", true);
					driver = new InternetExplorerDriver(ieCapabilities);
				}
				else if (browser.equalsIgnoreCase("Chrome"))
				{
					System.setProperty("webdriver.chrome.driver",
							inputFileLocation + CHROME_DRIVER_Location + CHROME_DRIVER_32_FileName);
					DesiredCapabilities cr_capabilities = DesiredCapabilities.chrome();
					cr_capabilities.setCapability("ignoreZoomSetting", true);

					// to find java script error
					LoggingPreferences loggingPreferences = new LoggingPreferences();
					loggingPreferences.enable(LogType.BROWSER, Level.ALL);
					cr_capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
					driver = new ChromeDriver(cr_capabilities);
				}
				else if (browser.equalsIgnoreCase("Edge"))
				{
					System.setProperty("webdriver.edge.driver",
							inputFileLocation + IEDriverLocation + EdgeDriverFileName);
					DesiredCapabilities edge_capabilities = DesiredCapabilities.edge();
					edge_capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					driver = new EdgeDriver(edge_capabilities);
				}
				driver.manage().window().maximize();
			}
			else
			{
				logger.error("One or more parameters are invalid: runOn=>" + runOn + " browser=>" + browser
						+ " version=>" + version + " platform=>" + Platform.WINDOWS);
			}

			// Add this driver hashcode and its testcase name to
			// testCaseDriverMap.
			Startup.driverTestCaseMap.put(driver, testCase);
		}
		catch (WebDriverException e)
		{
			logger.info(e.getMessage());
			throw new RuntimeException(e.getMessage(), e);
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
			throw new Exception(e.getMessage(), e);
		}
		return driver;
	}
}
