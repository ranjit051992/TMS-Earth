package eProc.keywords;

import eProc.pages.cart.CartImpl;
import eProc.pages.checkout.ICheckout;
import framework.action.ActionBot;
import framework.utilities.GlobalVariable;
import framework.utilities.screenshot.Screenshot;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CartFlow
{
    public static Logger logger = Logger.getLogger(CartFlow.class);

    /**;
     * @description: Click on checkout button;
     * @param: driver;
     * @return:;
     * @throws Exception
     */
    public static void navigateToCheckout(WebDriver driver, String testCaseName) throws Exception
    {
        boolean flag = false;
        int counter = 1;
        try {
            CartImpl.clickOnCheckoutButton(driver,testCaseName);
            ActionBot.defaultSleep(driver, GlobalVariable.DEFAULT_MEDIUM_WAIT);

            flag = ActionBot.isElementPresent(driver, ICheckout.REQUISITION_NAME);

            while((!flag) && (counter<4))
            {
                logger.info("Reattempting to click on Checkout button");
                driver.navigate().refresh();
                ActionBot.defaultSleep(driver, GlobalVariable.DEFAULT_WAIT);
                flag = ActionBot.isElementPresent(driver,ICheckout.REQUISITION_NAME);
                Screenshot.captureScreenshot(driver, testCaseName, "Navigated to Checkout Page");

                if(!flag) {

                    CartImpl.clickOnCheckoutButton(driver,testCaseName);
                    flag = ActionBot.isElementPresent(driver,ICheckout.REQUISITION_NAME);
                }
                counter++;
            }

            if(counter>4)
            {
                throw new Exception("Failed to click on checkout button");
            }
            ActionBot.defaultSleep(driver, GlobalVariable.DEFAULT_MEDIUM_WAIT);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
}
