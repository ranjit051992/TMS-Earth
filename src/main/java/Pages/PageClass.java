package Pages;

import DriverSelector.DriverSelector;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import  org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

public class PageClass implements ObjectClass {
    public static Logger logger = Logger.getLogger(PageClass.class);

    public static  DataStore specStore = DataStoreFactory.getSpecDataStore();
    // public static WebDriver driver = DriverSelector.getDriver();

    public static WebDriverWait wait = null;

    // @Step("Log in to DDS with driver <driver>")
    public static void loginToDDS(WebDriver driver) throws Exception {
        wait = new WebDriverWait(driver, 2000);
        driver.get("https://login-qcvw.zycus.net/sso/login");
        driver.findElement(By.xpath(GHOST_EMAIL_ADDRESS_TEXTBOX));
        driver.findElement(By.xpath(GHOST_EMAIL_ADDRESS_TEXTBOX)).click();
        driver.findElement(By.xpath(EMAIL_ADDRESS_TEXTBOX)).clear();
        driver.findElement(By.xpath(EMAIL_ADDRESS_TEXTBOX)).sendKeys("katalon.qc2@zycus.com");
        logger.info("Entered email address");
        driver.findElement(By.xpath(GHOST_PASSWORD_TEXTBOX));
        driver.findElement(By.xpath(GHOST_PASSWORD_TEXTBOX)).click();
        driver.findElement(By.xpath(PASSWORD_TEXTBOX)).clear();
        driver.findElement(By.xpath(PASSWORD_TEXTBOX)).sendKeys("Autokat@1234");
        logger.info("Entered email password");
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LOADER_SYMBOL)));
        driver.get("https://dewdrops-eproc-qcvw.zycus.net/#/online-store");
        logger.info("Logged in to DDS ");

    }

    @Step("Search item <itemName> ")
    public static void searchItemAndAddToCart(String itemName) throws Exception {
        WebDriver driver = DriverSelector.getDriver();
        loginToDDS(driver);
        searchItem(driver, itemName);
        clickOnAddToCartButton(driver);
    }

    public static void searchItem(WebDriver driver, String itemName) throws Exception {
        wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_TEXTBOX)));
        driver.findElement(By.xpath(SEARCH_TEXTBOX)).sendKeys(itemName);
        driver.findElement(By.xpath(SEARCH_TEXTBOX)).sendKeys(Keys.ENTER);
        logger.info("Searched item --> " + itemName);
    }

    public static void clickOnAddToCartButton(WebDriver driver) throws Exception {
        wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADD_TO_CART_BUTTON)));
        driver.findElement(By.xpath(ADD_TO_CART_BUTTON)).click();
        logger.info("Clicked on Add To Cart Button.");
    }

    @Step("Add Item <itemName> to favorites")
    public static void addItemToFavorites(String itemName) throws Exception {
        WebDriver driver = DriverSelector.getDriver();
        loginToDDS(driver);
        searchItem(driver, itemName);
        clickOnFavoriteIcon(driver, itemName);
        clickOnHomeLink(driver);
        wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LOADER_SYMBOL)));
        clickOnFavoritesAndPreviouslyUsedTab(driver);
        clickOnFavoritesViewAllBtn(driver);
        wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(FAVORITES_ITEM_LIST)));/**/
        List<String> itemNameList = getFavoritesItemList(driver);
        // boolean flag = itemNameList.contains(itemName);
        Assert.assertTrue(itemNameList.contains(itemName));


    }

    public static void clickOnFavoriteIcon(WebDriver driver, String itemName) {
        String xpath = "//span[contains(text(),'" + itemName + "')]//ancestor::dew-card//dew-icon[contains(@class,'text-lighter pointer')]";
        wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
        logger.info("Clicked on favorite icon");
    }

    public static void clickOnHomeLink(WebDriver driver) {
        driver.findElement(By.xpath(HOME_LINK)).click();
        logger.info("Clicked on Home Link");
    }

    public static void clickOnFavoritesAndPreviouslyUsedTab(WebDriver driver) {
        driver.findElement(By.xpath(FAVORITES_AND_PREVIOUSLY_USED_TAB)).click();
        logger.info("Clicked on Favorites And Previously Used Tab");
    }

    public static List<String> getFavoritesItemList(WebDriver driver) {
        List<String> itemNameList = new ArrayList<String>();
        List<WebElement> elementList = driver.findElements(By.xpath(FAVORITES_ITEM_LIST));
        for (WebElement element : elementList) {
            itemNameList.add(element.getText());

        }
        return itemNameList;

    }

    public static void clickOnFavoritesViewAllBtn(WebDriver driver) {
        wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FAV_VIEW_ALL_BUTTON)));
        WebElement element = driver.findElement(By.xpath(FAV_VIEW_ALL_BUTTON));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
        logger.info("Clicked on Favorites And Previously Used Tab");
    }

    public static void clickOnCartIcon(WebDriver driver) throws Exception {
        driver.findElement(By.xpath(ObjectClass.CART_ICON)).click();
        logger.info("Clicked on Cart Icon.");
    }

    @Step("Search item <item> and Add to basket <basketName>.")
    public static void searchItemAndAddTocart(String item, String basketName) throws Exception {

        WebDriver driver = DriverSelector.getDriver();
        loginToDDS(driver);
        searchItem(driver, item);/**/
        clickOnAddToCartButton(driver);
        clickOnCartIcon(driver);
        clickOnAddToBasketButton(driver);
        selectCreateNewBasketButton(driver);
        enterBasketName(driver, basketName);
        clickOnAddToBasketModalButton(driver);

        Assert.assertTrue("Item not added to basket", checkIfItemAddedToBasket(driver));
    }

    public static void clickOnAddToBasketButton(WebDriver driver) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, ObjectClass.EXPLICIT_WAIT);
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjectClass.ADD_TO_BASKET))) != null) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ObjectClass.ADD_TO_BASKET)));
            driver.findElement(By.xpath(ObjectClass.ADD_TO_BASKET)).click();
        } else
            throw new Exception("Add to basket button not present");
    }

    public static void enterBasketName(WebDriver driver, String name) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, ObjectClass.EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ObjectClass.ENTER_NEW_BASKET_NAME)));
        driver.findElement(By.xpath(ObjectClass.ENTER_NEW_BASKET_NAME)).sendKeys(name);
    }

    public static void selectCreateNewBasketButton(WebDriver driver) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, ObjectClass.EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ObjectClass.CREATE_NEW_BASKET)));
        driver.findElement(By.xpath(ObjectClass.CREATE_NEW_BASKET)).click();
    }

    public static void clickOnAddToBasketModalButton(WebDriver driver) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, ObjectClass.EXPLICIT_WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjectClass.ADD_TO_BASKET_MODAL_BUTTON)));
        driver.findElement(By.xpath(ObjectClass.ADD_TO_BASKET_MODAL_BUTTON)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ObjectClass.ADD_TO_BASKET_SPINNER)));
    }

    public static boolean checkIfItemAddedToBasket(WebDriver driver) {
        boolean flag = false;
        WebDriverWait wait = new WebDriverWait(driver, ObjectClass.EXPLICIT_WAIT);
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjectClass.ADD_TO_CART_SUCCESS_MSG))) != null) {
            flag = true;
        }
        return flag;
    }

    @Step("gthyjujj")
    public void implementation1() {
        System.out.println("Hello");
    }
}
