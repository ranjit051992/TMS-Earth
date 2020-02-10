package eProc.pages.pageNavigation;

import eProc.pages.onlineStore.OnlineStoreImpl;
import eProc.productUtilities.constants.Constants;
import framework.utilities.screenshot.Screenshot;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Navigation
{
    public static Logger logger = Logger.getLogger(Navigation.class);

    public static boolean navigateToProductUrl(WebDriver driver, String testCaseName) throws Exception
    {
        boolean status = false;
        try
        {
            driver.get(Constants.profileConfig.get("URL"));
            Screenshot.captureScreenshot(driver, testCaseName, "Navigate to product url");
            status = true;
            return status;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public static boolean navigateToOnlineStore(WebDriver driver, String testCaseName) throws Exception
    {
        boolean status = false;
        try {
            driver.get(Constants.profileConfig.get("DEW_DROP_URL"));
            if (OnlineStoreImpl.isOnlineStorePage(driver)) {
                status = true;
                Screenshot.captureScreenshot(driver, testCaseName, "Navigate to DDS url");

            }
        }
        catch (Exception e)
        {
            throw e;
        }
        return status;
    }
}
