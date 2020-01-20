package DriverSelector;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverSelector {

    public static WebDriver getDriver()
    {
        //System.setProperty("webdriver.chrome.driver", "resources\\drivers\\chrome\\chromedriver.exe");
        WebDriver driver = null;
        try {

            System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

           /* DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver  = new RemoteWebDriver(new URL("http://192.168.7.57:4444/wd/hub"), desiredCapabilities);
            driver.get("https://login-qcvw.zycus.net/sso/login");*/

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return driver;
    }
}
