package eProc.pages.onlineStore;

import com.thoughtworks.gauge.Step;
import framework.action.ActionBot;
import framework.utilities.GlobalVariable;
import framework.utilities.screenshot.Screenshot;
import framework.utilities.webElementWrapper.WebElementWrapper;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OnlineStoreImpl implements IOnlineStore
{
    public static Logger logger = Logger.getLogger(OnlineStoreImpl.class);

    public static void searchItem(WebDriver driver, String searchItem, String testCaseName) throws Exception
    {
        try {
            String elementXpath = WebElementWrapper.getXpath(HOME_LINK);
            ActionBot.scrollToElementByXpath(driver, elementXpath);
            ActionBot.defaultSleep(driver, GlobalVariable.DEFAULT_WAIT);
            ActionBot.sendKeys(driver,SEARCH_TEXTBOX, searchItem);
            logger.info("Value entered in the search textbox --> " + searchItem);
            Screenshot.captureScreenshot(driver, testCaseName, "Value entered in the search textbox");
        }
        catch(Exception e) {
            throw e;
        }
    }

    public static void clickSearchIcon(WebDriver driver) throws Exception {
        String searchTextboxXpath = WebElementWrapper.getXpath(SEARCH_TEXTBOX);
        driver.findElement(By.xpath(searchTextboxXpath)).sendKeys(Keys.ENTER);
        logger.info("Clicked on the search icon");
        Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Clicked on the search icon");
    }

    public static void waitForLoadingSymbolNotDisplayed(WebDriver driver) throws Exception {
        ActionBot.waitForElementNotPresent(driver,LOADING_SYMBOL);
        logger.info("Waited for the loading symbol to go off");
        Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Waited for the loading symbol to go off");
    }

    public static boolean waitForResultsToLoad(WebDriver driver) throws Exception {
        boolean flag = false;
        if(ActionBot.waitForElementVisible(driver,RESULTS_TABLE))
        {
                flag = true;
                logger.info("Waited for the results to load.");
                Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Waited for the results to load");
        }
        else {
            flag = false;
            logger.info("Results are not loaded after searching item.");
            Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Results are not loaded after searching item");
        }

        return flag;
    }

    public static void fillQuantity(WebDriver driver,String quantity,String itemName) throws Exception
    {
        String quantityXpath = "//span[text()='"+itemName+"']/ancestor::dew-col[2]//input";
        ActionBot.clearWithDeleteByXpath(driver, MDC.get("TestCaseName").toString(), quantityXpath);
        ActionBot.clearWithBackspaceByXpath(driver, MDC.get("TestCaseName").toString(), quantityXpath);
        ActionBot.sendKeysByXPath(driver, quantityXpath, quantity);
        logger.info("Entered quantity --> " + quantity);
        Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Entered quantity");
    }

    public static void clickOnAddToCartButton(WebDriver driver,String itemName) throws Exception {
        String addToCartButtonXpath = "//span[text()='"+itemName+"']/ancestor::dew-col[2]//button//span[contains(@class,'cart')]";
        if(ActionBot.waitUntilVisibleByXpath(driver, addToCartButtonXpath)!=null) {
            ActionBot.clickByXpath(driver, addToCartButtonXpath);
        }
    }
    public static void clickOnHomeLink(WebDriver driver) throws Exception {


        String elementXpath = WebElementWrapper.getXpath(HOME_LINK);
        ActionBot.scrollToElementByXpath(driver, elementXpath);
        ActionBot.defaultSleep(driver, GlobalVariable.DEFAULT_WAIT);
        ActionBot.click(driver, HOME_LINK);
        ActionBot.defaultSleep(driver, GlobalVariable.DEFAULT_WAIT);
        ActionBot.waitForElementVisible(driver,MY_ORDERS_TABLE);
        logger.info("Clicked on Home icon");
        Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Clicked on Home icon");
    }

    public static void clickOnCartButtonOnOnlineStorePage(WebDriver driver, String testCaseName) throws Exception
    {
        ActionBot.click(driver, CART_BUTTON);
        logger.info("Clicked on cart icon on online store page");
        Screenshot.captureScreenshot(driver, testCaseName, "Clicked on cart icon on online store page");
    }

    /**;
     * @author
     * @throws Exception
     * @Description this will check online store header present or not;
     *;
     * */
    public static boolean isOnlineStorePage(WebDriver driver) throws Exception
    {
        boolean status=false;
        try
        {
            status=ActionBot.isElementPresent(driver, ONLINE_STORE_PAGE_HEADER);
        }
        catch(Exception e)
        {
            throw e;
        }
        return status;
    }

    public static boolean waitForLoadingSymbolNotPresent(WebDriver driver, String testcaseName) throws Exception {
        boolean flag = false;
        String loadingSymbolXpath = WebElementWrapper.getXpath(PAGE_LOAD_SPINNER);

        if(ActionBot.waitUntilNotVisibleByXpath(driver,loadingSymbolXpath)) {
            flag = true;
            logger.info("Loading symbol is not present.");
        }
        else {
           driver.navigate().refresh();
            if(ActionBot.waitUntilNotVisibleByXpath(driver,loadingSymbolXpath)) {
                flag = true;
                logger.info("Loading symbol is not present.");
            }
            else {
                flag = false;
                logger.info("Loading symbol is Still present."+"\n"+"Online Store Page is still not loaded.");
                throw new Exception("Loading symbol is Still present."+"\n"+"Online Store Page is still not loaded.");
            }
        }

        return flag;
    }


    public static void waitForOnlineStorePageToLoad(WebDriver driver) throws Exception {
        String xpath = WebElementWrapper.getXpath(SEARCH_TEXTBOX);
        ActionBot.scrollToElementByXpath(driver, xpath);
        ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);
        if(ActionBot.isElementPresent(driver,SEARCH_TEXTBOX)) {
            logger.info("Page is loaded.");
        }
        else {
            logger.info("Reattempting to load Online Store page...");
            driver.navigate().refresh();
            ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);
            ActionBot.scrollToElementByXpath(driver, xpath);
            ActionBot.defaultSleep(driver,GlobalVariable.DEFAULT_WAIT);
            if(!ActionBot.isElementPresent(driver,SEARCH_TEXTBOX)) {
                throw new Exception("Online store page is not loaded. Search Box is not visible..!");
            }
            else {
                logger.info("Online store page is loaded in 2nd attempt");
            }
        }
    }

    /**;
     * @description: Search catalog item on Online store page, fill quantity & add to cart;
     * @param: driver,testcaseName, item name,quantity;
     * @return: ;
     */
    @Step("Add Catalog Item <itemName> with quantity<quantity> <driver> <testcaseName>to cart")
    public static void addCatalogItemToCart(WebDriver driver, String testcaseName, String itemName, int quantity) throws Exception
    {

        try
        {
            OnlineStoreImpl.waitForLoadingSymbolNotDisplayed(driver);
            OnlineStoreImpl.clickOnHomeLink(driver);
            OnlineStoreImpl.searchItem(driver,itemName,testcaseName);
            OnlineStoreImpl.fillQuantity(driver,Integer.toString(quantity),itemName);
            Screenshot.captureScreenshot(driver, testcaseName, "Before_Clicking_AddToCart");
            OnlineStoreImpl.clickOnAddToCartButton(driver,itemName);
            boolean flag = ActionBot.waitForElementVisible(driver, IOnlineStore.ADD_TO_CART_SUCESS_MESSAGE);
            if(flag)
            {
                logger.info("Add to cart success message displayed");
                Screenshot.captureScreenshot(driver, testcaseName, "Add to cart success message displayed");
            }
            else
            {
                logger.info("Add to cart success message not displayed");
                Screenshot.captureScreenshot(driver, testcaseName, "Add to cart success message not displayed");
                throw new Exception("Add to cart success message not displayed");
            }
        }
        catch(Exception e)
        {
            throw e;
        }
    }

    public static void waitForOnlineStoreToLoad(WebDriver driver,String testcase) throws Exception
    {
        try
        {
            if(OnlineStoreImpl.waitForLoadingSymbolNotPresent(driver,testcase))
            {
                OnlineStoreImpl.waitForOnlineStorePageToLoad(driver);
                Screenshot.captureScreenshot(driver,testcase,"Online_Store_Page");
            }
            else
            {
                throw new Exception("Online Store loading symbol is still present");
            }
        }
        catch(Exception e)
        {
            logger.info("inside waitForOnlineStoreToLoad method catch block ");
            Screenshot.captureScreenshot(driver,testcase,"Online_Store_Page");
            throw e;
        }
    }
}
