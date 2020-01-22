package framework.utilities.driverFactory;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import framework.utilities.GlobalVariable;
import framework.reporting.TestReportingBO;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;

public class DriverSelector
{

	public static Logger logger = Logger.getLogger(DriverSelector.class);

	/**
	 * @author nitin.chourey
	 * @description: getDriver will initiate driver instance for given browser
	 *               profile
	 * @param: TestCase
	 *             object
	 * @return: driver
	 * @throws Exception
	 */
	public static WebDriver getDriver(TestReportingBO testCase) throws Exception
	{
		String testcaseName = testCase.getTestCaseName();
		WebDriver driver = null;
		MDC.put("TestCaseName", testcaseName);
		try
		{

			if ("Grid".equalsIgnoreCase(GlobalVariable.RUN_ON))
			{
				logger.info("running on grid");
				if ("Chrome".equalsIgnoreCase(GlobalVariable.BROWSER))
				{
					logger.info("Launching Chrome browser");
					DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("start-maximized");
					driver = new RemoteWebDriver(new URL(GlobalVariable.HUB_URL), desiredCapabilities);
					driver.manage().window().maximize();
				}
				else if ("FireFox".equalsIgnoreCase(GlobalVariable.BROWSER))
				{
					logger.info("Launching FireFox browser");
					DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
					driver = new RemoteWebDriver(new URL(GlobalVariable.HUB_URL), desiredCapabilities);
				}
				else if ("IE".equalsIgnoreCase(GlobalVariable.BROWSER))
				{
					logger.info("Launching IE browser");
					DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
					desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
					driver = new RemoteWebDriver(new URL(GlobalVariable.HUB_URL), desiredCapabilities);
				}
				else if ("Edge".equalsIgnoreCase(GlobalVariable.BROWSER))
				{
					logger.info("Launching Edge browser");
					DesiredCapabilities desiredCapabilities = DesiredCapabilities.edge();
					driver = new RemoteWebDriver(new URL(GlobalVariable.HUB_URL), desiredCapabilities);
				}
				else
				{
					logger.error("Please select valid Browser (Chrome|FireFox|IE|Edge)");
					throw new Exception(GlobalVariable.BROWSER + " is a invalid Browser, Valid values are (Chrome|FireFox|IE|Edge)");
				}
			}
			else if ("Local".equalsIgnoreCase(GlobalVariable.RUN_ON))
			{
				logger.info("running on local");
				if ("Chrome".equalsIgnoreCase(GlobalVariable.BROWSER))
				{
					System.setProperty("webdriver.chrome.driver", "./Resources/Drivers/chrome/chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("start-maximized");
					driver = new ChromeDriver(options);
					driver.manage().window().maximize();
				}
				else if ("FireFox".equalsIgnoreCase(GlobalVariable.BROWSER))
				{
					logger.info("Launching FireFox browser");
					System.setProperty("webdriver.gecko.driver", "./Resources/Drivers/firefox/geckodriver.exe");
					File pathBinary = new File("D:\\eProcData\\firefox57\\firefox.exe");
					FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
					DesiredCapabilities desired = DesiredCapabilities.firefox();
					FirefoxOptions options = new FirefoxOptions();
					desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
					driver = new FirefoxDriver(options);
				}
				else if ("IE".equalsIgnoreCase(GlobalVariable.BROWSER))
				{
					logger.info("Launching IE browser");
					System.setProperty("webdriver.ie.driver", "./Resources/Drivers/ie/IEDriverServer.exe");
					DesiredCapabilities ds = DesiredCapabilities.internetExplorer();
					ds.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
					driver = new InternetExplorerDriver(ds);
				}
				else if ("Edge".equalsIgnoreCase(GlobalVariable.BROWSER))
				{
					logger.info("Launching Edge browser");
					System.setProperty("webdriver.edge.driver", "./Resources/Drivers/edge/MicrosoftWebDriver.exe");
					driver = new EdgeDriver();
				}
				else
				{
					logger.error("Please select valid Browser (Chrome|FireFox|IE|Edge)");
					throw new Exception(GlobalVariable.BROWSER + " is a invalid Browser, Valid values are (Chrome|FireFox|IE|Edge)");
				}
			}
		}
		catch (Exception e)
		{

			throw e;
		}
		return driver;
	}

	public  static WebDriver getDriver() throws Exception {
		WebDriver driver = null;
		try {
			if ("Local".equalsIgnoreCase(GlobalVariable.RUN_ON))
			{
				logger.info("running on local");
				if ("Chrome".equalsIgnoreCase(GlobalVariable.BROWSER))
				{
					System.setProperty("webdriver.chrome.driver", "./Resources/Drivers/chrome/chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("start-maximized");
					driver = new ChromeDriver(options);
					driver.manage().window().maximize();
				}
				else if ("FireFox".equalsIgnoreCase(GlobalVariable.BROWSER))
				{
					logger.info("Launching FireFox browser");
					System.setProperty("webdriver.gecko.driver", "./Resources/Drivers/firefox/geckodriver.exe");
					File pathBinary = new File("D:\\eProcData\\firefox57\\firefox.exe");
					FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
					DesiredCapabilities desired = DesiredCapabilities.firefox();
					FirefoxOptions options = new FirefoxOptions();
					desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
					driver = new FirefoxDriver(options);
				}
				else if ("IE".equalsIgnoreCase(GlobalVariable.BROWSER))
				{
					logger.info("Launching IE browser");
					System.setProperty("webdriver.ie.driver", "./Resources/Drivers/ie/IEDriverServer.exe");
					DesiredCapabilities ds = DesiredCapabilities.internetExplorer();
					ds.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
					driver = new InternetExplorerDriver(ds);
				}
				else if ("Edge".equalsIgnoreCase(GlobalVariable.BROWSER))
				{
					logger.info("Launching Edge browser");
					System.setProperty("webdriver.edge.driver", "./Resources/Drivers/edge/MicrosoftWebDriver.exe");
					driver = new EdgeDriver();
				}
				else
				{
					logger.error("Please select valid Browser (Chrome|FireFox|IE|Edge)");
					throw new Exception(GlobalVariable.BROWSER + " is a invalid Browser, Valid values are (Chrome|FireFox|IE|Edge)");
				}
			}


		}
		catch (Exception e)
		{
			throw e;
		}
		return driver;
	}

	@Step("Get Driver form Data Store <driverKey>")
	public static WebDriver getDriverFromDataStore(String driverKey)
	{
		WebDriver driver = (WebDriver)DataStoreFactory.getSuiteDataStore().get(driverKey);
		return driver;
	}
}
