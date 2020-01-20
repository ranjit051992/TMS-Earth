package Pages;

import actionBot.ActionBot;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class IPageCartImpl implements IPageCart
{
    public  static Logger logger = Logger.getLogger(IPageCartImpl.class);

    public static void clickOnCheckoutButton(WebDriver driver) throws Exception
    {
        //ActionBot.click(driver, CHECKOUT_BUTTON)
        ActionBot.clickUsingJavaScript(driver, CHECKOUT_BUTTON);
        logger.info("Clicked on Checkout button");
        //Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Clicked on Checkout Button");

    }
}
