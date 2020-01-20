package eProc.keywords;

import Pages.IPageCartImpl;
import Pages.IPageCheckout;
import actionBot.ActionBot;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CartFlow
{
    public static Logger logger = Logger.getLogger(CartFlow.class);

    public static void navigateToCheckout(WebDriver driver) throws Exception
    {
        boolean flag = false;
        int counter = 1;
        try {
            IPageCartImpl.clickOnCheckoutButton(driver);
            //ActionBot.defaultSleep(driver, GlobalVariable.DEFAULT_MEDIUM_WAIT);

            flag = ActionBot.isElementPresent(driver, IPageCheckout.REQUISITION_NAME);

            while((!flag) && (counter<4))
            {
                logger.info("Reattempting to click on Checkout button");
                //WebUI.refresh(driver);
                ActionBot.defaultSleep(driver, 10);
                flag = ActionBot.isElementPresent(driver,IPageCheckout.REQUISITION_NAME);
               // Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Navigated to Checkout Page");

                if(!flag) {

                    IPageCartImpl.clickOnCheckoutButton(driver);
                    flag = ActionBot.isElementPresent(driver,IPageCheckout.REQUISITION_NAME);
                }
                counter++;
            }

            if(counter>4)
            {
                throw new Exception("Failed to click on checkout button");
            }
            ActionBot.defaultSleep(driver, 10);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
}
