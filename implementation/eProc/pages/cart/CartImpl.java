package eProc.pages.cart;

import eProc.keywords.OnlineStoreFlow;
import framework.action.ActionBot;
import framework.utilities.screenshot.Screenshot;
import framework.utilities.webElementWrapper.WebElementWrapper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

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
}
