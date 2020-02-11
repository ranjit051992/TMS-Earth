package eProc.pages.cart;

import com.thoughtworks.gauge.datastore.DataStoreFactory;
import eProc.keywords.OnlineStoreFlow;
import framework.action.ActionBot;
import framework.utilities.driverFactory.DriverSelector;
import framework.utilities.screenshot.Screenshot;
import framework.utilities.webElementWrapper.WebElementWrapper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartImpl implements ICart
{
    public static Logger logger = Logger.getLogger(CartImpl.class);

    public static void clickOnCheckoutButton(WebDriver driver, String testCaseName) throws Exception
    {
        //ActionBot.click(driver, CHECKOUT_BUTTON);
        String checkOutBtnXpath = WebElementWrapper.getXpath(CHECKOUT_BUTTON);
        ActionBot.clickUsingJavaScript(driver, CHECKOUT_BUTTON);
        logger.info("Clicked on Checkout button");
        Screenshot.captureScreenshot(driver, testCaseName, "Clicked on Checkout Button");

    }

    public static List<String> getCartItemsList(String driverKey, String testcase) throws Exception
    {
        List<String> itemNameList = new ArrayList<>();
        WebDriver driver = null;
        try
        {
            driver = DriverSelector.getDriverFromDataStore(driverKey);
            String itemNameXpath = WebElementWrapper.getXpath(FIRST_ITEM_NAME);
            List<WebElement> itemNameElementsList = ActionBot.findElements(driver, itemNameXpath);

            for(int i=0; i<itemNameElementsList.size(); i++)
            {
                //String itemNameXpath = rowXpath+"[@title='"+itemNameList.get(i)+"']";
                String itemName = itemNameElementsList.get(i).getText();
                itemNameList.add(itemName);
            }
        }
        catch(Exception e)
        {
            throw e;
        }
        finally {
            DataStoreFactory.getSuiteDataStore().put(driverKey, driver);
        }
        return itemNameList;

    }

/*    public static boolean verifyCartItems(String) throws Exception {
        boolean status = false;
        try {

        }
        catch (Exception e)
        {
            throw e;
        }
        return status;
    }*/
}
