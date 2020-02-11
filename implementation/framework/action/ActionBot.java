package framework.action;

import framework.utilities.webElementWrapper.WebElementWrapper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import eProc.productUtilities.constants.Constants;

public class ActionBot
{

    public static Logger logger = Logger.getLogger(ActionBot.class);
    public static WebDriverWait wait ;
    public static void clickElementByXpath(String path, WebDriver driver) throws Exception
    {

        WebElement element = null;

        try
        {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            element = driver.findElement(By.xpath(path));
            if (element.isDisplayed())
            {
                if (element.isEnabled())
                {
                    element.click();
                }
            }
        }
        catch (Exception e)
        {
            try
            {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                if (element.isDisplayed())
                {
                    if (element.isEnabled())
                    {
                        element.click();
                    }
                }
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    /**
     * ; @author;
     *
     * @description : Click on element by specifying Object repository path;
     * @param :
     *            driver, Object repo path; ;
     */

    public static void click(WebDriver driver, String elementPath) throws Exception
    {
        By by = WebElementWrapper.getElement(elementPath);
        try
        {
            wait = new WebDriverWait(driver, 10);
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(by))!=null)
            {
                if (wait.until(ExpectedConditions.elementToBeClickable(by))!=null)
                {
                    driver.findElement(by).click();
                   // driver.findElement(By.xpath(elementPath)).click();
                }
                else
                {
                    throw new Exception(elementPath + " Element not Clickable in first attempt");
                }

            }
            else
            {
                throw new Exception(elementPath + " Element not Visible in first attempt");
            }
        }
        catch (Exception e)
        {
            try
            {
                wait = new WebDriverWait(driver, 10);
                if (wait.until(ExpectedConditions.visibilityOfElementLocated(by))!=null)
                {
                    if (wait.until(ExpectedConditions.elementToBeClickable(by))!=null)
                    {
                        driver.findElement(by).click();
                       //driver.findElement(By.xpath(elementPath)).click();
                    }
                    else
                    {
                        throw new Exception(elementPath + " Element not Clickable in first attempt");
                    }

                }
                else
                {
                    throw new Exception(elementPath + " Element not Visible in first attempt");
                }
            }

            catch (Exception e1)
            {

               // logger.error("Exception Occurred while clicking on '" + WebElementWrapper.getXpath(elementPath) + "'.");
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    /**
     * ; @author;
     *
     * @description : Click on element by specifying xPath;
     * @param :
     *            driver,xPath;
     * @return text;
     */

    public static void clickByXpath(WebDriver driver, String xPath) throws Exception
    {

        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try
        {
            element = findElementByXpath(driver, xPath);

            if (element != null)
            {
                if (waitUntilClickable(driver, element))
                {
                    element.click();
                }
                else
                {
                    throw new Exception("Unable to click on element in 1st Attempt");
                }
            }
            else
            {
                throw new ElementNotVisibleException("Unable to find element in 1st Attempt");
            }
        }
        catch (Exception e)
        {
            try
            {

                element = findElement(driver, xPath);
                wait.until(ExpectedConditions.visibilityOf(element));
                if (wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed())
                {
                    if (waitUntilClickable(driver, element))
                    {
                        element.click();
                    }
                    else
                    {
                        throw new ElementNotSelectableException("Unable to click on element in 2nd Attempt");
                    }
                }
                else
                {
                    throw new ElementNotVisibleException("Unable to find element in Last Attempt");
                }
            }
            catch (Exception e1)
            {
                logger.error("Exception Occurred while clicking on '" + xPath + "'.");
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static boolean waitUntilClickable(WebDriver driver, WebElement element) throws Exception
    {
        boolean status = false;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try
        {
            if (wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled())
            {
                status = true;
            }
        }
        catch (Exception e)
        {
            try
            {
                if (wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled())
                {
                    status = true;
                }
            }
            catch (Exception e1)
            {
                logger.error("Exeption occurred while waiting for element to be clickable.");
                throw new Exception(e1);
            }
        }

        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return status;
    }

    /**
     * ;
     *
     * @author snehal.yadav;
     * @description : Waiting for element to be visible by specifying Object
     *              repository path;
     * @param :
     *            driver, Object repo path;
     * @return WebElement;
     */

    public static WebElement waitUntilVisible(WebDriver driver, String elementPath) throws Exception
    {
        WebElement element = null;

        try
        {
           wait = new WebDriverWait(driver, 10);
           By by = WebElementWrapper.getElement(elementPath);
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(by))!=null)
            {
                element = driver.findElement(by);
                if (element != null)
                {
                    logger.info("Element " + elementPath + " is Visible.");
                }
            }
            else
            {
                throw new ElementNotVisibleException("Unable to find element in 1st attempt.");
            }
        }
        catch (Exception e)
        {
            try
            {
                By by = WebElementWrapper.getElement(elementPath);
                if (wait.until(ExpectedConditions.visibilityOfElementLocated(by))!=null)
                {
                    element = driver.findElement(by);
                   // element = driver.findElement(By.xpath(elementPath));
                    if (element != null)
                    {
                        logger.info("Element " + elementPath + " is Visible.");
                    }
                }
                else
                {
                    throw new ElementNotVisibleException("Unable to find element in 2nd attempt.");
                }
            }
            catch (Exception e3)
            {
               // logger.error("Exception Occurred while waiting for element " + WebElementWrapper.getXpath(elementPath) + " to be visible.");
                throw e3;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return element;
    }

    /**
     * ;
     *
     * @author snehal.yadav;
     * @description : Waiting for element to be visible by specifying element
     *              xPath;
     * @param :
     *            driver, xPath;
     * @return WebElement;
     */

    public static WebElement waitUntilVisibleByXpath(WebDriver driver, String xPath) throws Exception
    {
        WebElement element = null;

        try
        {
            wait = new WebDriverWait(driver, 10);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
            if (element != null)
            {
                logger.info("Element " + xPath + " is Visible.");
            }
            else
            {
                throw new ElementNotVisibleException("Unable to find element in 1st attempt.");
            }
        }
        catch (Exception e)
        {
            try
            {
                wait = new WebDriverWait(driver, 10);
                element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
                if (element != null)
                {
                    logger.info("Element " + xPath + " is Visible.");
                }
                else
                {
                    throw new ElementNotVisibleException("Unable to find element in 2nd attempt.");
                }
            }
            catch (Exception e3)
            {
                logger.error("Exception Occurred while waiting for element " + xPath + " to be visible.");
                throw e3;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return element;
    }

    public static void doubleClick(WebDriver driver, String elementPath) throws Exception
    {
        WebElement element =null;
        By by = WebElementWrapper.getElement(elementPath);
        try
        {
             wait = new WebDriverWait(driver, 10);
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(by))!=null)
            {
                if (wait.until(ExpectedConditions.elementToBeClickable(by))!=null)
                {
                    element = driver.findElement(by);
                    Actions action = new Actions(driver);

                    action.moveToElement(element).doubleClick().build().perform();
                }
                else
                {
                    throw new ElementNotSelectableException("Unable to click on element in 1st Attempt");
                }
            }
            else
            {
                throw new ElementNotVisibleException("Unable to find element in 1st Attempt");
            }
        }
        catch (Exception e)
        {

            try
            {

                if (wait.until(ExpectedConditions.visibilityOfElementLocated(by))!=null)
                {
                    if (wait.until(ExpectedConditions.elementToBeClickable(by))!=null)
                    {

                        //element = driver.findElement(By.xpath(elementPath));
                        element = driver.findElement(by);
                        Actions action = new Actions(driver);

                        action.moveToElement(element).doubleClick().build().perform();
                    }
                    else
                    {
                        throw new ElementNotSelectableException("Unable to click on element in 1st Attempt");
                    }
                }
                else
                {
                    throw new ElementNotVisibleException("Unable to find element in 2nd Attempt");
                }
            }
            catch (Exception e1)
            {
               // logger.error("Exception Occurred while double clicking on '" + WebElementWrapper.getXpath(elementPath) + "'.");
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    /**
     * ;
     *
     * @author snehal.yadav;
     * @description : Perform sendkeys on element by specifying Object
     *              repository path;
     * @param :
     *            driver, Object repo path; ;
     */

    public static void sendKeys(WebDriver driver, String elementPath, String text) throws Exception
    {
        wait = new WebDriverWait(driver, 10);
        By by = WebElementWrapper.getElement(elementPath);
        try
        {

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(by))!=null)
            {
                if (wait.until(ExpectedConditions.elementToBeClickable(by))!=null)
                {
                    clear(driver,elementPath);

                    WebElement webElement = ActionBot.findElement(driver, elementPath);
                    for (int i = 0; i < text.length(); i++)
                    {
                        webElement.sendKeys(text.charAt(i) + "");
                    }
                }
                else
                {
                    throw new ElementNotSelectableException("Unable to click on element in 1st Attempt");
                }
            }
            else
            {
                throw new ElementNotVisibleException("Unable to find element in 1st Attempt");
            }
        }
        catch (Exception e)
        {
            try
            {

                if (wait.until(ExpectedConditions.visibilityOfElementLocated(by))!=null)
                {
                    if (wait.until(ExpectedConditions.elementToBeClickable(by))!=null)
                    {
                        clear(driver,elementPath);
                        WebElement webElement = ActionBot.findElement(driver, elementPath);
                        for (int i = 0; i < text.length(); i++)
                        {
                            webElement.sendKeys(text.charAt(i) + "");
                        }
                    }
                    else
                    {
                        throw new ElementNotSelectableException("Unable to click on element in 1st Attempt");
                    }
                }
                else
                {
                    throw new ElementNotVisibleException("Unable to find element in 2nd attempt");
                }
            }
            catch (Exception e1)
            {
               // logger.error("Exception Occurred while performing sendKeys on '" + WebElementWrapper.getXpath(elementPath) + "'.");
                throw new Exception(e1);
            }
        }

        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    /**
     * ;
     *
     * @author snehal.yadav;
     * @description : Perform Sendkeys on element by specifying xPath;
     * @param :
     *            driver,xPath; ;
     */

    public static void sendKeysByXPath(WebDriver driver, String xPath, String text) throws Exception
    {
        WebElement element = null;
        try
        {
            element = findElementByXpath(driver, xPath);
            if (element != null)
            {
                if (waitUntilClickable(driver, element))
                {
                    element.clear();
                    element.click();
                    for (int i = 0; i < text.length(); i++)
                    {
                        element.sendKeys(text.charAt(i) + "");
                    }
                }
                else
                {
                    throw new ElementNotSelectableException("Unable to click on element in 2nd Attempt");
                }
            }

            else
            {
                throw new Exception("Unable to find element in 1st Attempt");
            }
        }
        catch (Exception e)
        {
            try
            {
                element = findElementByXpath(driver, xPath);
                if (element != null)
                {
                    if (waitUntilClickable(driver, element))
                    {
                        element.clear();
                        element.click();
                        for (int i = 0; i < text.length(); i++)
                        {
                            element.sendKeys(text.charAt(i) + "");
                        }
                    }
                    else
                    {
                        throw new ElementNotSelectableException("Unable to click on element in 1st Attempt");
                    }
                }
                else
                {
                    throw new ElementNotVisibleException("Unable to find element in 2nd attempt");
                }
            }
            catch (Exception e1)
            {
                logger.error("Exception Occurred while performing sendkeys on '" + xPath + "'.");
                throw new Exception(e1);
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static void clear(WebDriver driver, String elementPath) throws Exception
    {
        wait = new WebDriverWait(driver, 10);
        By by = WebElementWrapper.getElement(elementPath);
        try
        {
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(by))!=null)
            {
                if (wait.until(ExpectedConditions.elementToBeClickable(by))!=null)
                {
                   driver.findElement(by).clear();
                }
                else
                {
                    throw new ElementNotSelectableException("Unable to clear on element in 1st Attempt");
                }
            }
            else
            {
                throw new ElementNotVisibleException("Unable to find element in 1st Attempt");
            }
        }
        catch (Exception e)
        {
            try
            {
                if (wait.until(ExpectedConditions.visibilityOfElementLocated(by))!=null)
                {
                    if (wait.until(ExpectedConditions.elementToBeClickable(by))!=null)
                    {
                        ///driver.findElement(By.xpath(elementPath));
                        driver.findElement(by).clear();
                    }
                    else
                    {
                        throw new ElementNotSelectableException("Unable to clear on element in 1st Attempt. Invalid element State.");
                    }
                }
                else
                {
                    throw new ElementNotVisibleException("Unable to find element in 2nd attempt");
                }
            }
            catch (Exception e1)
            {
               // logger.error("Exception Occurred while clearing '" + WebElementWrapper.getXpath(elementPath) + "'.");
                throw new Exception(e1);
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    /**
     * ;
     *
     * @author snehal.yadav;
     * @description : Fetching element text by specifying Object Repository
     *              Path;
     * @param :
     *            driver, Object Repo path;
     * @return text;
     */

    public static String getText(WebDriver driver, String elementPath) throws Exception
    {
        String value = "";
        WebElement element = null;
        By by = WebElementWrapper.getElement(elementPath);
        try
        {
            element = waitUntilVisible(driver, elementPath);
            if (element != null)
            {
                value =driver.findElement(by).getText();
                logger.info("Text is :" + value);
            }
            else
            {
                logger.error(elementPath + " is not visible");
                throw new NoSuchElementException("Unable to find element in 1st attempt");
            }
        }

        catch (Exception e2)
        {

            try
            {
                element = waitUntilVisible(driver, elementPath);
                if (element != null)
                {
                    value =driver.findElement(by).getText();
                    logger.info("Text is :" + value);
                }
                else
                {
                    throw new NoSuchElementException("Unable to find element in 1st attempt");
                }
            }
            catch (Exception e1)
            {
            //    logger.error("Exception Occurred while fetching text within '" + WebElementWrapper.getXpath(elementPath) + "'.");
                throw new Exception(e1);
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }

        return value;
    }

    /**
     * ;
     *
     * @author snehal.yadav;
     * @description : Fetching element text by specifying Object Repository
     *              Path;
     * @param :
     *            driver, Object Repo path;
     * @return text;
     */

    public static String getTextWithinElement(WebDriver driver, String elementPath) throws Exception
    {

        String value = null;
        WebElement element = null;
        try
        {
            element = waitUntilVisible(driver, elementPath);
            if (element != null)
            {
                value = element.getAttribute("value");
                logger.info("Text is :" + value);
            }
            else
            {
                throw new Exception("Unable to find element in 1st attempt");
            }
        }
        catch (Exception e)
        {
            try
            {
                element = waitUntilVisible(driver, elementPath);
                if (element != null)
                {

                    value = element.getAttribute("value");
                    logger.info("Text is :" + value);
                }
                else
                {
                    throw new Exception("Unable to find element in 2nd attempt");
                }
            }
            catch (Exception e1)
            {
                //logger.error("Exception occurred while fetching text within '." + WebElementWrapper.getXpath(elementPath) + "'.");
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return value;
    }

    /**
     * ;
     *
     * @author snehal.yadav;
     * @description : Fetching element text by specifying element xPath;
     * @param :
     *            driver, xPath;
     * @return text;
     */

    public static String getTextByXpath(WebDriver driver, String xPath) throws Exception
    {

        logger.info("Fetching text within " + xPath);
        String value = null;
        WebElement element = null;
        try
        {
            element = findElementByXpath(driver, xPath);
            if (element != null)
            {

                value = element.getText();
                logger.info("Text is :" + value);
            }
            else
            {
                throw new Exception("Unable to find element in 1st attempt");
            }
        }
        catch (Exception e2)
        {
            try
            {
                element = findElementByXpath(driver, xPath);

                if (element != null)
                {
                    value = element.getText();

                    logger.info("Text is :" + value);
                }
                else
                {
                    throw new Exception("Unable to click on element");
                }
            }
            catch (Exception e3)
            {
                logger.error("Exception occurred while fetching text from '." + xPath + "'.");
                throw new Exception(e3);
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return value;
    }

    public static boolean isElementPresent(WebDriver driver, String elementPath) throws Exception
    {
        boolean status = false;
        try
        {
            WebElement element = findElement(driver, elementPath);
            if (element.isDisplayed())
            {
                status = true;
            }
            else
            {
                status = false;
            }
        }
        catch (Exception e)
        {
            status = false;
            //logger.error("Element " + WebElementWrapper.getXpath(elementPath) + " is not present");
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return status;
    }

    /*public static boolean isAlertPresent(WebDriver driver) throws Exception
    {
        boolean status = false;

        try
        {
            if (WebUI.verifyAlertPresent(driver, GlobalVariable.DEFAULT_MEDIUM_WAIT) == true)
            {
                driver.switchTo().alert();
                status = true;
            }
        }
        catch (Exception e)
        {
            status = false;
            logger.error("Exception while verifying presence of alert.");
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return status;
    }*/

    /*public static void acceptAlert(WebDriver driver) throws Exception
    {

        try
        {
            if (isAlertPresent(driver))
            {
                Alert alert = driver.switchTo().alert();
                alert.accept();
            }
        }
        catch (Exception e)
        {

            logger.error("Exception while accepting alert.");
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }*/

    public static String getTitle(WebDriver driver) throws Exception
    {
        String actualTitle = null;
        try
        {

            ActionBot.defaultSleep();
            actualTitle = driver.getTitle();
            if (actualTitle == null)
            {
                logger.error("Title is blank.");
                throw new Exception("Navigation Failed. Title is blank.");
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return actualTitle;
    }

    public static void defaultSleep() throws Exception
    {
        try
        {
            //WebUI.delay(5);
            Thread.sleep(2000);
        }
        catch (Exception e)
        {
            logger.error("Error while performing Thread Sleep.");
        }
    }

    public static void defaultSleep(WebDriver driver, int time) throws Exception
    {
        try
        {
            Thread.sleep(2000);
        }
        catch (Exception e)
        {
            logger.error("Error while performing Thread Sleep.");
        }
    }

    public static void selectDropdownValue(WebDriver driver, String elementPath, String selectBy, String value) throws Exception
    {

        Select select = null;
        WebElement element = ActionBot.findElement(driver, elementPath);
        try
        {
            select = new Select(element);
            if (selectBy != null)
            {
                if (selectBy.equalsIgnoreCase(Constants.SELECT_BY_VALUE))
                {
                    select.selectByValue(value);
                }
                else if (selectBy.equalsIgnoreCase(Constants.SELECT_BY_INDEX))
                {
                    select.selectByIndex(Integer.parseInt(value));
                }
                else if (selectBy.equalsIgnoreCase(Constants.SELECT_BY_VISIBLE_TEXT))
                {
                    select.selectByVisibleText(value);
                }
                else if (selectBy.equalsIgnoreCase(Constants.SELECT_BY_PARTIAL_VISIBLE_TEXT))
                {
                    for (WebElement options : select.getOptions())
                    {
                        if (options.getText().trim().contains(value))
                        {
                            options.click();
                            break;
                        }
                    }
                }
            }
            else
            {
                logger.error("Invalid Select By option selected");
            }

            String selectedOption = select.getFirstSelectedOption().getText();
            logger.info("Selected Option is : " + selectedOption);
        }
        catch (Exception e)
        {
            logger.error("Exception occurred while selecting dropdown value.");
            throw e;
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    /**
     * ; @author;
     *
     * @description : Finding element by Object Repository Path;
     * @param :
     *            driver, Object Repo path;
     * @return webElement;
     */

    public static WebElement findElement(WebDriver driver, String elementPath) throws Exception
    {
        try
        {
            return waitUntilVisible(driver, elementPath);
        }
        catch (Exception e2)
        {
            try
            {
                logger.error(" Relocating element..!");
                return waitUntilVisible(driver, elementPath);
            }
            catch (Exception e3)
            {
                throw e3;
            }
        }

        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    /**
     * ; @author;
     *
     * @description : Finding element by specifying element xpath;
     * @param :
     *            driver, xpath;
     * @return webElement;
     */

    public static WebElement findElementByXpath(WebDriver driver, String xPath) throws Exception
    {
        try
        {
            logger.info("Locating element by Xpath.");
            return waitUntilVisibleByXpath(driver, xPath);
        }
        catch (Exception e2)
        {
            try
            {
                logger.error("Relocating element..!");
                return waitUntilVisibleByXpath(driver, xPath);
            }
            catch (Exception e3)
            {
                throw e3;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    /**
     * ; @author;
     *
     * @description : Finding elements by specifying element xpath within parent
     *              element;
     * @param :
     *            driver, xpath, parent element;
     * @return webElement;
     */

    public static List<WebElement> findElements(WebDriver driver, WebElement element, String elementXpath) throws Exception
    {
        List<WebElement> elements = null;
        try
        {
            if (element != null)
            {
                elements = element.findElements(By.xpath(elementXpath));

                if (elements.isEmpty() == true)
                {

                    logger.error("Elements searched by " + elementXpath + " not found..!!" + "\n Finding elements again..!");
                    elements = element.findElements(By.xpath(elementXpath));

                }
            }

        }
        catch (Exception e)
        {
            try
            {
                if (element != null)
                {
                    elements = element.findElements(By.xpath(elementXpath));
                    if (elements.isEmpty() == true)
                    {

                        logger.error("Elements searched by " + elementXpath + " not found..!!" + "\n Finding elements again..!");
                        elements = element.findElements(By.xpath(elementXpath));

                    }

                }
            }
            catch (Exception e1)
            {
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return elements;
    }

    /**
     * ; @author;
     *
     * @description : Finding elements by specifying element xpath;
     * @param :
     *            driver, xpath;
     * @return webElement;
     */

    public static List<WebElement> findElements(WebDriver driver, String elementXpath) throws Exception
    {
        List<WebElement> elements = null;
        try
        {

            elements = driver.findElements(By.xpath(elementXpath));
            if (elements.isEmpty())
            {

                logger.error("Elements searched by " + elementXpath + " not found..!!" + "\n Finding elements again..!");
                elements = driver.findElements(By.xpath(elementXpath));
            }

        }
        catch (Exception e)
        {
            try
            {
                logger.info("Exception " + e.getMessage() + " occurred while finding elements in 1st attempt. Searching elements again.");
                elements = driver.findElements(By.xpath(elementXpath));
                if (elements.isEmpty())
                {

                    logger.error("Elements searched by " + elementXpath + " not found..!!" + "\n Finding elements again..!");
                    elements = driver.findElements(By.xpath(elementXpath));
                }

            }
            catch (Exception e1)
            {
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return elements;
    }

    public static void deselectElementCheckBox(WebDriver driver, String elementPath) throws Exception
    {

        try
        {
            if (isSelected(driver, elementPath))
            {
                ActionBot.click(driver, elementPath);
                logger.info("Element is deselected.");
            }
            else
            {
                logger.info("Element is already deselected.");
            }
        }
        catch (Exception e)
        {
            logger.error("Error while selecting element.");
            throw e;
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static boolean isSelected(WebDriver driver, String elementPath) throws Exception
    {
        boolean status = false;
        WebElement element = null;
        By by = WebElementWrapper.getElement(elementPath);
        try
        {
            // xpath =
            // findTestObject(driver,elementPath).findPropertyValue("xpath");

            if (driver.findElement(by).isSelected())
            {
                status = true;
            }
            else
            {
                status = false;
            }
        }
        catch (Exception e)
        {
            try
            {

                element = driver.findElement(by);

                if (element.isSelected())
                {
                    status = true;
                }
                else
                {
                    status = false;
                }
            }
            catch (Exception e1)
            {
                status = false;
                logger.error("Exception while verifying whether element is Selected.");
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }

        return status;
    }

    public static boolean isEnabled(WebDriver driver, String elementPath) throws Exception
    {
        boolean status = false;
        WebElement element = null;
        By by = WebElementWrapper.getElement(elementPath);
        try
        {
            element = ActionBot.findElement(driver, elementPath);
            if (element.isEnabled())
            {
                status = true;
            }

        }
        catch (Exception e)
        {
            try
            {
                logger.info("Locating element again...!");
                element = ActionBot.findElement(driver, elementPath);
                if (element.isEnabled())
                {
                    status = true;
                }

            }
            catch (Exception e1)
            {
                //logger.error("Error while verifying whether '" + WebElementWrapper.getXpath(elementPath) + "' is Enabled.");
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return status;
    }

    /**
     * ; @author;
     *
     * @description : Enter file path using robot class;
     * @param :
     *            driver, file webElement;
     */

    public static void PasteFilePath(WebDriver driver, String filepath) throws Exception
    {
        try
        {
            StringSelection string = new StringSelection(filepath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);

            Robot robot = new Robot();
            ActionBot.defaultSleep();

            robot.keyPress(KeyEvent.VK_ENTER);

            robot.keyRelease(KeyEvent.VK_ENTER);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            ActionBot.defaultSleep();

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            logger.info("File Path is entered.");
        }
        catch (Exception e)
        {
            logger.error("Unable to enter file path.");
            throw e;
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    /**
     * ; @author;
     *
     * @description : Enter filepath using katalon keywords;
     * @param :
     *            driver, file path, object repo path of fileupload field;
     */

   /* public static boolean enterFilePath(WebDriver driver, String filepath, String elementPath) throws Exception
    {
        boolean status = false;
        try
        {
            if (waitUntilVisible(driver, elementPath).isDisplayed())
            {
                WebUI.scrollToElement(driver, findTestObject(driver, elementPath), 10);

                defaultSleep();
                String enteredFilePath = WebUI.getAttribute(driver, findTestObject(driver, "Upload File"), "value");

                if (enteredFilePath.equalsIgnoreCase(filepath))
                {
                    status = true;
                }
            }
        }
        catch (Exception e)
        {
            logger.error("Unable to enter file path.");
            throw e;
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return status;
    }*/

    /**
     * ; @author;
     *
     * @description : Fill auto complete field by selecting specific option from
     *              populated list after filling value;
     * @param :
     *            driver, textbox WebElement to enter value,xpath of suggestion
     *            menu , value to enter;
     * @return Selected value;
     */

    public static String fillAutoCompleteByValue(WebDriver driver, String testcaseName, WebElement element, String suggestionMenuXpath, String value) throws Exception
    {
        String selectedValue = null;
        WebElement suggestionMenu = null;
        List<WebElement> suggestedOptions = null;

        try
        {
            element.clear();
            element.sendKeys(value);
          //  Screenshot.captureScreenshot(driver, testcaseName, "After_Sending_value_to_autocompleteField");
            defaultSleep();

            suggestionMenu = waitUntilVisibleByXpath(driver, suggestionMenuXpath);

            // find options present in suggested list;
            suggestedOptions = findElements(driver, suggestionMenu, suggestionMenuXpath);
            logger.info("Auto Populated Options :" + suggestedOptions.size());

            for (WebElement ele : suggestedOptions)
            {
                if (ele.getText().toLowerCase().contains(value.toLowerCase()))
                {
                    ele.click();
                  //  Screenshot.captureScreenshot(driver, testcaseName, "After_Selecting_Value_From_dropdown");
                }
            }
            defaultSleep();
            selectedValue = element.getAttribute("value");

            if (selectedValue == null || selectedValue == "")
            {
                throw new Exception("Could not select value in Auto Complete field in 1st attempt.");
            }
        }
        catch (Exception e)
        {
            try
            {
                logger.info("Unable to Select value in Auto Complete field in 1st attempt. Trying again..!");
                element.clear();
                element.sendKeys(value);
                defaultSleep();
                suggestionMenu = waitUntilVisibleByXpath(driver, suggestionMenuXpath);
                suggestedOptions = findElements(driver, suggestionMenu, suggestionMenuXpath);

                for (WebElement ele : suggestedOptions)
                {
                    if (ele.getText().toLowerCase().contains(value.toLowerCase()))
                    {
                        ele.click();
                       // Screenshot.captureScreenshot(driver, testcaseName, "After_Selecting_Value_From_dropdown");
                    }
                }
                defaultSleep();
                selectedValue = element.getAttribute("value");
                if (selectedValue == null || selectedValue == "")
                {
                    throw new Exception("Could not select value in Auto Complete field in last attempt.");
                }
            }
            catch (Exception e1)
            {
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return selectedValue;
    }

    /**
     * ; @author;
     *
     * @description : Fill auto complete field by selecting 1st option from
     *              populated list after filling value;
     * @param :
     *            driver, textbox xpath to enter value, xpath of specific
     *            suggestion menu option , value to enter, item type;
     * @return Selected value;
     */

    public static void fillAutoCompleteItem(WebDriver driver, String testCaseName, String textfieldXpath, String SuggestedValueXpath, String value) throws Exception
    {
        WebElement suggestion = null;

        try
        {
            sendKeysByXPath(driver, textfieldXpath, value);

            clickByXpath(driver, textfieldXpath);

           defaultSleep();

           // Screenshot.captureScreenshot(driver, testCaseName, "After_Sending_value_to_autocompleteField");

            suggestion = waitUntilVisibleByXpath(driver, SuggestedValueXpath);

            if (suggestion != null)
            {
                suggestion.click();
            }

            defaultSleep();

            //Screenshot.captureScreenshot(driver, testCaseName, "After_Selecting_value_in_autocompleteField");

        }
        catch (Exception e)
        {
            try
            {
                logger.info("Reattempting to select value in autocomplete field");

                sendKeysByXPath(driver, textfieldXpath, value);

                defaultSleep();
                //Screenshot.captureScreenshot(driver, testCaseName, "After_Sending_value_to_autocompleteField");

                suggestion = waitUntilVisibleByXpath(driver, SuggestedValueXpath);

                if (suggestion != null)
                {
                    suggestion.click();
                }

                defaultSleep();

               // Screenshot.captureScreenshot(driver, testCaseName, "After_Selecting_value_in_autocompleteField");
            }
            catch (Exception e1)
            {
                logger.error("Exception occurred while selecting value in 2nd attempt in autocomplete field...!");
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static void jsScrollDown(WebDriver driver, String value) throws Exception
    {
        try
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0," + value + ")");
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

//    public static void scrollDownToPosition(WebDriver driver, int x, int y) throws Exception
//    {
//        try
//        {
//            defaultSleep();
//            WebUI.scrollToPosition(driver, x, y);
//            WebUI.delay(GlobalVariable.DEFAULT_MEDIUM_WAIT);
//
//        }
//        catch (Exception e)
//        {
//            throw e;
//        }
//        finally
//        {
//           // CommonServices.analyzeLog(driver);
//        }
//    }

    /*public static void scrollDownToElement(WebDriver driver, String elementPath) throws Exception
    {
        try
        {

            if (WebUI.waitForElementPresent(driver, findTestObject(driver, elementPath), 10))
            {
                WebUI.scrollToElement(driver, findTestObject(driver, elementPath), 5);
                // WebUI.delay(GlobalVariable.DEFAULT_MEDIUM_WAIT);
            }

        }
        catch (Exception e)
        {
            try
            {
                logger.info("Trying to scroll again..!");
                WebUI.delay(5);
                if (WebUI.waitForElementPresent(driver, findTestObject(driver, elementPath), 10))
                {
                    WebUI.scrollToElement(driver, findTestObject(driver, elementPath), 5);
                    // WebUI.delay(GlobalVariable.DEFAULT_MEDIUM_WAIT);
                }

            }
            catch (Exception e1)
            {
                logger.error("Exception occurred while scrolling to element.");
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }*/

    public static void moveToElement(WebDriver driver, WebElement element) throws Exception
    {
        Actions actions = new Actions(driver);
        try
        {
            if (element != null)
            {
                actions.moveToElement(element).build().perform();
            }
            else
            {
                logger.error("Element is empty...!");
            }
        }
        catch (Exception e)
        {
            logger.error("Exception while moving focus on element..!");
            throw e;
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static void moveToElementAndClick(WebDriver driver, WebElement element) throws Exception
    {
        Actions actions = new Actions(driver);
        try
        {
            if (element != null)
            {
                actions.moveToElement(element).click().build().perform();
            }
            else
            {
                logger.error("Element is empty...!");
            }
        }
        catch (Exception e)
        {
            logger.error("Exception has occurred...Searching element again..!");
            try
            {
                if (element != null)
                {
                    actions.moveToElement(element).click().build().perform();
                }
                else
                {
                    logger.error("Element is empty...!");
                }
            }
            catch (Exception e1)
            {
                logger.error("Exception while performing click on element..!");
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }

    }

    public static String fillAutoCompleteAndCheckIfValueMatches(WebDriver driver, WebElement element, String suggestionMenuXpath, String value) throws Exception
    {
        String selectedValue = null;
        List<WebElement> suggestedOptions = null;

        try
        {
            element.clear();
            element.sendKeys(value);
            waitUntilVisibleByXpath(driver, suggestionMenuXpath);

            // find options present in suggested list;
            suggestedOptions = ActionBot.findElements(driver, suggestionMenuXpath);
            logger.info("Auto Populated Options :" + suggestedOptions.size());

            for (WebElement ele : suggestedOptions)
            {
                if (ele.getText().toLowerCase().contains(value.toLowerCase()))
                {
                    ele.click();
                    break;
                }
            }
            selectedValue = element.getAttribute("value");

            if (selectedValue == null || selectedValue == "")
            {
                throw new Exception("Could not select value in Auto Complete field in 1st attempt.");
            }
            else if (selectedValue.contains(value))
            {
                logger.info("Selected value does not match. Value --> " + selectedValue);
            }
            logger.info("Value selected --> " + selectedValue);
        }
        catch (Exception e)
        {
            try
            {
                logger.info("Auto Complete failed in 1st attempt. Trying again..!");
                element.clear();
                element.sendKeys(value);
                // Screenshot.captureScreenshot( driver,
                // testcaseName,"After_Sending_value_to_autocompleteField");
                defaultSleep();
                waitUntilVisibleByXpath(driver, suggestionMenuXpath);

                // find options present in suggested list;
                suggestedOptions = ActionBot.findElements(driver, suggestionMenuXpath);
                logger.info("Auto Populated Options :" + suggestedOptions.size());

                for (WebElement ele : suggestedOptions)
                {
                    if (ele.getText().toLowerCase().contains(value.toLowerCase()))
                    {
                        defaultSleep();
                        ele.click();
                        // Screenshot.captureScreenshot( driver, testcaseName,
                        // "After_Selecting_Value_From_dropdown");
                        break;
                    }
                }
                defaultSleep();
                selectedValue = element.getAttribute("value");

                if (selectedValue == null || selectedValue == "")
                {
                    throw new Exception("Could not select value in Auto Complete field in 1st attempt.");
                }
                else if (selectedValue.contains(value))
                {
                    logger.info("Selected value does not match. Value --> " + selectedValue);
                }
                logger.info("Value selected --> " + selectedValue);
            }
            catch (Exception e1)
            {
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return selectedValue;
    }

    public static String fillAutoCompleteBuyerField(WebDriver driver, WebElement element, String suggestionMenuXpath, String value) throws Exception
    {
        String selectedValue = null;
        List<WebElement> suggestedOptions = null;

        try
        {
            element.clear();
            element.sendKeys(value);
            defaultSleep();
            waitUntilVisibleByXpath(driver, suggestionMenuXpath);

            // find options present in suggested list;
            suggestedOptions = ActionBot.findElements(driver, suggestionMenuXpath);
            logger.info("Auto Populated Options :" + suggestedOptions.size());

            for (WebElement ele : suggestedOptions)
            {
                if (ele.getText().toLowerCase().contains(value.toLowerCase()))
                {
                    defaultSleep();
                    ele.click();
                    break;
                }
            }
            defaultSleep();
            logger.info("Value selected --> " + selectedValue);
        }
        catch (Exception e)
        {
            try
            {
                logger.info("Auto Complete failed in 1st attempt. Trying again..!");
                element.clear();
                element.sendKeys(value);
                defaultSleep();
                waitUntilVisibleByXpath(driver, suggestionMenuXpath);

                // find options present in suggested list;
                suggestedOptions = ActionBot.findElements(driver, suggestionMenuXpath);
                logger.info("Auto Populated Options :" + suggestedOptions.size());

                for (WebElement ele : suggestedOptions)
                {
                    if (ele.getText().toLowerCase().contains(value.toLowerCase()))
                    {
                        defaultSleep();
                        ele.click();
                        break;
                    }
                }
                defaultSleep();
                logger.info("Value selected --> " + selectedValue);
            }
            catch (Exception e1)
            {
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return selectedValue;
    }

    public static void moveToElementAndDoubleClick(WebDriver driver, WebElement element) throws Exception
    {
        Actions actions = new Actions(driver);
        try
        {
            if (element != null)
            {
                actions.moveToElement(element).doubleClick().build().perform();
            }
            else
            {
                logger.error("Element is empty...!");
            }
        }
        catch (Exception e)
        {
            logger.error("Exception has occurred...Searching element again..!");
            try
            {
                if (element != null)
                {
                    actions.moveToElement(element).doubleClick().build().perform();
                }
                else
                {
                    logger.error("Element is empty...!");
                }
            }
            catch (Exception e1)
            {
                logger.error("Exception while performing click on element..!");
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static void clearTextThroughKeyboard(WebDriver driver, String elementPath) throws Exception
    {
        try
        {
            defaultSleep();

            ActionBot.click(driver, elementPath);

           clear(driver, elementPath);

            logger.info("Clearing the text from " + elementPath);

            driver.findElement(By.xpath(elementPath)).sendKeys(Keys.ALT);
            driver.findElement(By.xpath(elementPath)).sendKeys(Keys.NUMPAD1);
            driver.findElement(By.xpath(elementPath)).sendKeys(Keys.BACK_SPACE);
            driver.findElement(By.xpath(elementPath)).sendKeys(Keys.BACK_SPACE);

            defaultSleep();
        }
        catch (Exception e)
        {
            try
            {
                defaultSleep();

                ActionBot.click(driver, elementPath);

                clear(driver, elementPath);

                logger.info("Clearing the text from " + elementPath);

                driver.findElement(By.xpath(elementPath)).sendKeys(Keys.ALT);
                driver.findElement(By.xpath(elementPath)).sendKeys(Keys.NUMPAD1);
                driver.findElement(By.xpath(elementPath)).sendKeys(Keys.BACK_SPACE);
                driver.findElement(By.xpath(elementPath)).sendKeys(Keys.BACK_SPACE);

                defaultSleep();

            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

   /* public static int getPosition(WebDriver driver, String elementPath) throws Exception
    {
        int position = 0;
        try
        {
            if (ActionBot.isElementPresent(driver, elementPath))
            {
                position = WebUI.getElementLeftPosition(findTestObject(driver, elementPath));
                logger.info("Position of the Element is :" + position);

            }
        }
        catch (Exception e)
        {
            try
            {
                if (ActionBot.isElementPresent(driver, elementPath))
                {
                    position = WebUI.getElementLeftPosition(findTestObject(driver, elementPath));
                    logger.info("Position of the Element is :" + position);

                }
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return position;
    }*/

    public static boolean waitUntilNotVisibleByXpath(WebDriver driver, String xPath) throws Exception
    {
        boolean flag = false;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try
        {
            flag = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xPath)));
            if (flag)
            {
                logger.info("Element " + xPath + " is not Visible.");
            }
            else
            {
                logger.info("Element " + xPath + " is Visible.");
            }
        }
        catch (Exception e)
        {
            logger.info("Checking element invisibility again..!");
            try
            {
                flag = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xPath)));
                if (flag)
                {
                    logger.info("Element " + xPath + " is not Visible.");
                }
                else
                {
                    logger.info("Element " + xPath + " is Visible.");
                }
            }
            catch (NoSuchElementException e1)
            {
                flag = true;
                logger.info("Element " + xPath + " is not visible.");
            }
            catch (TimeoutException e2)
            {
                flag = false;
                logger.info("Time out exception occurred...! \n Element " + xPath + " is still visible.");
            }
            catch (Exception e3)
            {
                logger.error("Exception Occurred while checking element invisibility...!");
                throw e3;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return flag;
    }

    public static boolean isSelectedByXpath(WebDriver driver, String xPath) throws Exception
    {
        boolean status = false;
        WebElement element = null;

        try
        {
            element = driver.findElement(By.xpath(xPath));
            if (element.isSelected())
            {
                status = true;
                logger.info("Element is Selected.");
            }
            else
            {
                logger.info("Element is not Selected.");
            }
        }
        catch (Exception e)
        {
            try
            {
                logger.info("Locating element again...!");
                element = ActionBot.findElement(driver, xPath);
                if (element.isSelected())
                {
                    status = true;
                    logger.info("Element is Selected.");
                }
                else
                {
                    logger.info("Element is not Selected.");
                }
            }
            catch (Exception e1)
            {
                logger.error("Error while verifying whether element is Selected.");
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }

        return status;
    }

    /**
     * ;
     *
     * @author om.pawar;
     * @description : Fetching element text by specifying element xPath;
     * @param :
     *            driver, element xpath;
     * @return text;
     */

    public static String getTextWithinElementByXpath(WebDriver driver, String elementXpath) throws Exception
    {

        String value = null;
        WebElement element = null;
        try
        {
            element = waitUntilVisibleByXpath(driver, elementXpath);
            if (element != null)
            {
                logger.info(elementXpath + " is visible.");
                // if(waitUntilClickable(driver, element) != null) {
                // logger.info(elementXpath + " is clickable.");
                value = element.getAttribute("value");
                logger.info("Text is :" + value);
                // }
                // else {
                // logger.error("Element is not clickable");
                // throw new ElementNotSelectableException("Unable to click on
                // element");
                // }
            }
            else
            {
                logger.error(elementXpath + " is not visible");
                throw new NoSuchElementException("Unable to find element in 1st attempt");
            }
        }
        catch (Exception e)
        {
            try
            {
                element = waitUntilVisibleByXpath(driver, elementXpath);
                if (element != null)
                {
                    logger.info(elementXpath + " is visible.");
                    // if(waitUntilClickable(driver,element) != null);
                    // {
                    // logger.info(elementXpath + " is clickable.");
                    value = element.getAttribute("value");
                    logger.info("Text is :" + value);
                    // }
                }
            }
            catch (Exception ex)
            {
                throw ex;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return value;
    }

/*    public static int openNewTabInBrowser(WebDriver driver) throws Exception
    {
        int currentTabIndex = 0;
        try
        {
            currentTabIndex = WebUI.getWindowIndex(driver);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.open();");

            WebUI.switchToWindowIndex(driver, currentTabIndex + 1);
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return currentTabIndex;

    }*/

    /**
     * ;
     *
     * @author : nitin.chourey;
     * @description : scrolls till element;
     * @param :
     *            driver,element path of objectrepo;
     * @return nil;
     * @throws Exception
     */
    public static void scrollHorizontal(WebDriver driver, String elementPath) throws Exception
    {
        try
        {
            WebElement element = driver.findElement(By.xpath(elementPath));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();", element);
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    /**
     * ;
     *
     * @author : nitin.chourey;
     * @description : it will return list of webelements;
     * @param :
     *            driver,element path of objectrepo;
     * @return List of WebElements;
     * @throws Exception
     */
    public static List<WebElement> getListOfWebelements(WebDriver driver, String elementPath) throws Exception
    {
        try
        {
            String xpath = WebElementWrapper.getXpath(elementPath);
            return driver.findElements(By.xpath(xpath));
        }
        catch (Exception e)
        {
            try
            {
                String xpath = WebElementWrapper.getXpath(elementPath);
                return driver.findElements(By.xpath(elementPath));
            }
            catch (Exception ex)
            {
                throw ex;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static String getAttribute(WebDriver driver, String elementPath, String attribute) throws Exception
    {
        logger.info("Fetching attribute of element " + elementPath);
        String value = "";
        WebElement element = null;

        try
        {
            // element = waitUntilVisible(driver, elementPath);
            String xpath = WebElementWrapper.getXpath(elementPath);
            element = driver.findElement(By.xpath(xpath));
            if (element != null)
            {
                value = element.getAttribute(attribute);
                logger.info("Attribute is :" + value);

            }
            else
            {
                throw new NoSuchElementException("Unable to find element in 1st attempt");
            }
        }

        catch (Exception e2)
        {

            try
            {
                // element = waitUntilVisible(driver, elementPath);
                String xpath = WebElementWrapper.getXpath(elementPath);
                element = driver.findElement(By.xpath(xpath));
                if (element != null)
                {
                    logger.info(elementPath + " is visible.");
                    value = element.getAttribute(attribute);
                    logger.info("Attribute is :" + value);

                }
                else
                {
                    logger.error(elementPath + " is not visible");
                    throw new NoSuchElementException("Unable to find element in 1st attempt");
                }
            }
            catch (Exception e1)
            {
                logger.error("Exception Occured");
                throw new Exception(e1);
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return value;
    }

    public static boolean waitForElementNotPresent(WebDriver driver, String elementPath) throws Exception
    {
        boolean status = false;
        wait =  new WebDriverWait(driver, 10);
        By by = WebElementWrapper.getElement(elementPath);
        try
        {

            status = wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            if (status)
            {
                logger.info("Element " + elementPath + " is not present");
            }
            else
            {
                //logger.info("Element " + elementPath + " is still present after waiting for " + 10 + "seconds");
            }
        }
        catch (Exception e)
        {
            try
            {
                logger.info("Reattempting to wait for element not present...");
                status = wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
                if (status)
                {
                    logger.info("Element " + elementPath + " is not present");
                }
                else
                {
                   // logger.info("Element " + elementPath + " is still present after waiting for " + 10 + "seconds");
                }
            }
            catch (Exception e2)
            {
                logger.error("Element " + elementPath + " still present after 2nd attempt");
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return status;
    }

    public static void clearWithBackspace(WebDriver driver, String testCaseName, String objectRepositoryPath) throws Exception
    {
        try
        {
            WebElement inputFieldElement = ActionBot.findElement(driver, objectRepositoryPath);
            String inputFieldText = inputFieldElement.getAttribute("value");
            if (!inputFieldText.isEmpty())
            {
                for (int i = 0; i < inputFieldText.length(); i++)
                {
                    inputFieldElement.sendKeys(Keys.BACK_SPACE);
                }
                logger.info("Input field cleared");
            }
            logger.info("Input field already empty");
        //    Screenshot.captureScreenshot(driver, testCaseName, "Input field cleared");
        }
        catch (Exception e)
        {
            logger.info("Reattempting to clear the input field");
            defaultSleep(driver,10);
            WebElement inputFieldElement = ActionBot.findElement(driver, objectRepositoryPath);
            String inputFieldText = inputFieldElement.getAttribute("value");
            if (!inputFieldText.isEmpty())
            {
                for (int i = 0; i < inputFieldText.length(); i++)
                {
                    inputFieldElement.sendKeys(Keys.BACK_SPACE);
                }
                logger.info("Input field cleared in 2nd attempt");
            }
            logger.info("Input field already empty");
           //Screenshot.captureScreenshot(driver, testCaseName, "Input field cleared");
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static void clearWithBackspaceByXpath(WebDriver driver, String testCaseName, String inputFieldXpath) throws Exception
    {
        try
        {
            WebElement inputFieldElement = ActionBot.findElementByXpath(driver, inputFieldXpath);
            String inputFieldText = inputFieldElement.getAttribute("value");
            if (!inputFieldText.isEmpty())
            {
                for (int i = 0; i < inputFieldText.length(); i++)
                {
                    inputFieldElement.sendKeys(Keys.BACK_SPACE);
                }
                logger.info("Input field cleared");
            }
            logger.info("Input field already empty");
          //  Screenshot.captureScreenshot(driver, testCaseName, "Input field cleared");
        }
        catch (Exception e)
        {
            logger.info("Reattempting to clear the input field");
           defaultSleep();
            WebElement inputFieldElement = ActionBot.findElementByXpath(driver, inputFieldXpath);
            String inputFieldText = inputFieldElement.getAttribute("value");
            if (!inputFieldText.isEmpty())
            {
                for (int i = 0; i < inputFieldText.length(); i++)
                {
                    inputFieldElement.sendKeys(Keys.BACK_SPACE);
                }
                logger.info("Input field cleared in 2nd attempt");
            }
            logger.info("Input field already empty");
            //Screenshot.captureScreenshot(driver, testCaseName, "Input field cleared");
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static void clearWithDelete(WebDriver driver, String testCaseName, String objectRepositoryPath) throws Exception
    {
        try
        {
            WebElement inputFieldElement = ActionBot.findElement(driver, objectRepositoryPath);
            String inputFieldText = inputFieldElement.getAttribute("value");
            if (!inputFieldText.isEmpty())
            {
                for (int i = 0; i < inputFieldText.length(); i++)
                {
                    inputFieldElement.sendKeys(Keys.DELETE);
                }
                logger.info("Input field cleared");
            }
            logger.info("Input field already empty");
           // Screenshot.captureScreenshot(driver, testCaseName, "Input field cleared");
        }
        catch (Exception e)
        {
            logger.info("Reattempting to clear the input field");
            defaultSleep();
            WebElement inputFieldElement = ActionBot.findElement(driver, objectRepositoryPath);
            String inputFieldText = inputFieldElement.getAttribute("value");
            if (!inputFieldText.isEmpty())
            {
                for (int i = 0; i < inputFieldText.length(); i++)
                {
                    inputFieldElement.sendKeys(Keys.DELETE);
                }
                logger.info("Input field cleared in 2nd attempt");
            }
            logger.info("Input field already empty");
            //Screenshot.captureScreenshot(driver, testCaseName, "Input field cleared");
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static void clearWithDeleteByXpath(WebDriver driver, String testCaseName, String inputFieldXpath) throws Exception
    {
        try
        {
            WebElement inputFieldElement = ActionBot.findElementByXpath(driver, inputFieldXpath);
            String inputFieldText = inputFieldElement.getAttribute("value");
            if (!inputFieldText.isEmpty())
            {
                for (int i = 0; i < inputFieldText.length(); i++)
                {
                    inputFieldElement.sendKeys(Keys.DELETE);
                }
                logger.info("Input field cleared");
            }
            logger.info("Input field already empty");
            //Screenshot.captureScreenshot(driver, testCaseName, "Input field cleared");
        }
        catch (Exception e)
        {
            logger.info("Reattempting to clear the input field");
           // WebUI.delay(10);
            WebElement inputFieldElement = ActionBot.findElementByXpath(driver, inputFieldXpath);
            String inputFieldText = inputFieldElement.getAttribute("value");
            if (!inputFieldText.isEmpty())
            {
                for (int i = 0; i < inputFieldText.length(); i++)
                {
                    inputFieldElement.sendKeys(Keys.DELETE);
                }
                logger.info("Input field cleared in 2nd attempt");
            }
            logger.info("Input field already empty");
            //Screenshot.captureScreenshot(driver, testCaseName, "Input field cleared");
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static void clickOnElement(WebDriver driver, String path) throws Exception
    {
        try
        {
           click(driver, path);
        }
        catch (Exception e)
        {
            try
            {
                click(driver, path);
            }
            catch (Exception ex)
            {
                throw ex;
            }

        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static void clickUsingJavaScript(WebDriver driver, String path) throws Exception
    {
        try
        {
            // TestObject to = findObject(path);
            // String xpath = to.findProperty("xpath").getValue();
           // String xpath = WebElementWrapper.UiElementsXpath.get(path);
            By by = WebElementWrapper.getElement(path);
            WebElement element = driver.findElement(by);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static boolean waitUntilNotVisible(WebDriver driver, String elementPath) throws Exception
    {
        boolean flag = false;
        wait = new WebDriverWait(driver, 10);
        By by = WebElementWrapper.getElement(elementPath);
        try
        {

            if (wait.until(ExpectedConditions.invisibilityOfElementLocated(by)))
            {
                flag = true;
                logger.info("Element " + elementPath + " is not Visible.");
            }
            else
            {
                logger.info("Element " + elementPath + " is Visible.");
            }
        }
        catch (Exception e)
        {
            logger.info("Checking element invisibility again..!");
            try
            {
                if (wait.until(ExpectedConditions.invisibilityOfElementLocated(by)))
                {
                    flag = true;
                    logger.info("Element " + elementPath + " is not Visible.");
                }
                else
                {
                    logger.info("Element " + elementPath + " is Visible.");
                }
            }
            catch (NoSuchElementException e1)
            {
                flag = true;
                logger.info("Element " + elementPath + " is not visible.");
            }
            catch (TimeoutException e2)
            {
                flag = false;
                logger.info("TimeoutException occurred...! \n Element " + elementPath + " is still visible.");
            }
            catch (Exception e3)
            {
                flag = false;
                logger.error("Exception Occurred ");
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return flag;

    }

    public static boolean isEnabledByXpath(WebDriver driver, String elementXpath) throws Exception
    {
        boolean status = false;
        WebElement element = null;

        try
        {
            element = driver.findElement(By.xpath(elementXpath));
            if (element.isEnabled())
            {
                status = true;
                logger.info("Element is Enabled.");
            }
            else
            {
                logger.info("Element is not Enabled.");
            }
        }
        catch (Exception e)
        {
            try
            {
                logger.info("Locating element again...!");
                element = driver.findElement(By.xpath(elementXpath));
                if (element.isEnabled())
                {
                    status = true;
                    logger.info("Element is Enabled.");
                }
                else
                {
                    logger.info("Element is not Enabled.");
                }
            }
            catch (Exception e1)
            {
                logger.error("Error while verifying whether element is Enabled.");
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return status;
    }

    public static boolean isElementPresentByXpath(WebDriver driver, String elementXpath) throws Exception
    {
        boolean status = false;
        try
        {
          //  TestObject testObject = new TestObject();
         //   testObject.addProperty("xpath", ConditionType.EQUALS, elementXpath);

            if (waitForElementVisible(driver,elementXpath))
            {
                status = true;
                logger.info("Element " + elementXpath + " is present");
            }
            else
            {
                status = false;
                logger.error("Element " + elementXpath + " is not present");
            }
        }
        catch (Exception e)
        {
            status = false;
            logger.error("Element " + elementXpath + " is not present");
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return status;
    }

    public static void clickByJS(WebDriver driver, String xpath) throws Exception
    {
        WebElement element = null;
        try
        {

            element = driver.findElement(By.xpath(xpath));
            /*
             * if(element.isDisplayed()); {
             */
            if (element.isEnabled())
            {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
            // }
        }
        catch (Exception e)
        {
            try
            {
                /*
                 * if(element.isDisplayed()); {
                 */
                if (element.isEnabled())
                {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                }
                // }
            }
            catch (Exception e1)
            {

            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static boolean waitForLoadingSymbolNotDisplayed(WebDriver driver, String testCaseName, String elementPath, int timeOut) throws Exception
    {
        boolean flag = false;
        By by = WebElementWrapper.getElement(elementPath);
        try
        {
            // flag =
            // WebUI.waitForElementNotPresent(driver,findTestObject(driver,elementPath),
            // timeOut);
            flag = new WebDriverWait(driver,60).until(ExpectedConditions.invisibilityOfElementLocated(by));

            if (flag)
            {
                logger.info("Waited for loading symbol to go off");
            }
            else
            {
                logger.info("Loading symbol still displayed");
            }
        }
        catch (Exception e)
        {
            logger.info("Reattempting to wait for loading symbol to go off");
            // flag =
            // WebUI.waitForElementNotPresent(driver,findTestObject(driver,elementPath),
            // timeOut);
            flag = new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOfElementLocated(by));

            if (flag)
            {
                logger.info("Waited for loading symbol to go off");
            }
            else
            {
                logger.info("Loading symbol still displayed");
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return flag;
    }

    public static boolean invisibilityOfElementWithText(WebDriver driver, String testCaseName, String elementPath, String textToBeNotPresent) throws Exception
    {
        boolean flag = true;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String elementXpath = WebElementWrapper.getXpath(elementPath);
        try
        {
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(elementXpath), textToBeNotPresent));
            logger.info("Text --> " + textToBeNotPresent + ", of element --> " + elementXpath + " is removed");
        }
        catch (Exception e)
        {
            try
            {
                logger.info("Reattempting to wait for element text to be removed");
                wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(elementXpath), textToBeNotPresent));
                logger.info("Text --> " + textToBeNotPresent + ", of element --> " + elementXpath + " is removed in 2nd attempt");
            }
            catch (Exception e1)
            {
                flag = false;
                logger.info("Wait for element text to be removed failed");
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return flag;
    }

    public static void clearWithXpath(WebDriver driver, String elementXpath) throws Exception
    {


        // TestObject testObject = new TestObject();
        // testObject.addProperty("xpath", ConditionType.EQUALS, elementXpath);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        try
        {

            WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
            if (webElement != null)
            {
                webElement = wait.until(ExpectedConditions.elementToBeClickable(webElement));
                if (webElement != null)
                {
                    webElement.clear();
                    logger.info("Cleared element --> " + elementXpath);
                }
                else
                {
                    throw new Exception("Element not clickable in 1st attempt");
                }
            }
            else
            {
                throw new Exception("Element not visible in 1st attempt");
            }

            // flag = WebUI.waitForElementVisible(driver,testObject,
            // 10);
            // if (flag) {
            // logger.info("Element is visible --> " + elementXpath);
            //
            // flag = WebUI.waitForElementClickable(driver,testObject,
            // 10);
            // if (flag) {
            // logger.info("Element is clickable --> " + elementXpath);
            //
            // WebUI.clearText(driver,testObject);
            // logger.info("Cleared element --> " + elementXpath);
            // } else {
            // logger.error("Element not clickable in 1st attempt --> " +
            // elementXpath);
            // throw new Exception("Element not clickable in 1st attempt!");
            // }
            // } else {
            // logger.error("Element not visible in 1st attempt --> " +
            // elementXpath);
            // throw new Exception("Element not visible in 1st attempt!");
            // }
        }
        catch (Exception e)
        {
            logger.error("REATTEMPTING to clear the element --> " + elementXpath);
            try
            {
                // flag = WebUI.waitForElementVisible(driver,testObject,
                // 10);
                // if (flag) {
                // logger.info("Element is visible --> " + elementXpath);
                //
                // flag = WebUI.waitForElementClickable(driver,testObject,
                // 10);
                // if (flag) {
                // logger.info("Element is clickable --> " + elementXpath);
                //
                // WebUI.clearText(driver,testObject);
                // logger.info("Cleared element --> " + elementXpath);
                // } else {
                // logger.error("Element not clickable in 2nd attempt --> " +
                // elementXpath);
                // throw new Exception("Element not clickable in 2nd attempt!");
                // }
                // } else {
                // logger.error("Element not visible in 2nd attempt --> " +
                // elementXpath);
                // throw new Exception("Element not visible in 2nd attempt!");
                // }
                WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
                if (webElement != null)
                {
                    webElement = wait.until(ExpectedConditions.elementToBeClickable(webElement));
                    if (webElement != null)
                    {
                        webElement.clear();
                        logger.info("Cleared element --> " + elementXpath);
                    }
                    else
                    {
                        throw new Exception("Element not clickable in 2nd attempt");
                    }
                }
                else
                {
                    throw new Exception("Element not visible in 2nd attempt");
                }
            }
            catch (Exception e1)
            {
                logger.error("Exception occurred while clearing element in 2nd attempt --> " + elementXpath);
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static void scrollToElementByXpath(WebDriver driver, String elementXpath) throws Exception
    {
        try
        {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(elementXpath)));
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    /**
     * ;
     *
     * @author :shubham.upadhyay;
     * @description : it will return list of String;
     * @param :
     *            driver,element path of objectrepo;
     * @return List of WebElements;
     * @throws Exception
     */
    public static List<String> getListOfText(WebDriver driver, String testCaseName, String elementPath) throws Exception
    {
        List<String> listOfText = null;
        try
        {
            String getText = null;
            listOfText = new ArrayList<String>();
            List<WebElement> listElement = driver.findElements(By.xpath(elementPath));

            if (listElement.size() > 0)
            {
                for (WebElement element : listElement)
                {
                    getText = element.getText().trim();
                    listOfText.add(getText);
                    logger.info("Text from list is " + getText);
                }
            }
            else
            {
                logger.error("List of element is null for given xpath " + elementPath);
            }

        }
        catch (Exception e)
        {
            try
            {
                logger.error("Trying to get text of element in 2nd attemp.");
                String getText = null;
                listOfText = new ArrayList<String>();
                List<WebElement> listElement = driver.findElements(By.xpath(elementPath));
                if (listElement.size() > 0)
                {
                    for (WebElement element : listElement)
                    {
                        getText = element.getText().trim();
                        listOfText.add(getText);
                        logger.info("Text of element is  " + getText);
                    }
                }
                else
                {
                    logger.error("List of element is null for given xpath " + elementPath);
                }
            }
            catch (Exception ex)
            {
                throw ex;
            }
        }
        return listOfText;
    }

    /**
     * ;
     *
     * @author :shubham.upadhyay;
     * @description : upload attachment using java script executor;
     * @param :
     *            driver, element path of object repo ,file path;
     * @return nill;
     */

    public static void uploadAttachment(WebDriver driver, String testcaseName, String elementPath, String filePath) throws Exception
    {
        try
        {
            logger.info("Uploading attachment.");
            ActionBot.defaultSleep();
            if (ActionBot.isElementPresent(driver, elementPath))
            {
               // String xpath = WebElementWrapper.getXpath(elementPath);
                WebElement element = ActionBot.findElementByXpath(driver, elementPath);
                JavascriptExecutor jsexec = (JavascriptExecutor) driver;
                jsexec.executeScript("arguments[0].setAttribute('type','file');", element);
               // WebUI.scrollToElement(driver, findElement(driver,elementPath), 10);
            }

        }
        catch (Exception e)
        {
            logger.error("Exception occurred while uploading attachment.");
            throw e;
        }
    }

    /**
     * ;
     *
     * @author :shubham.upadhyay;
     * @description : verify element is dispalyed on ui;
     * @param :
     *            driver,element path of objectrepo;
     * @return boolean;
     */

    public static boolean isDisplayed(WebDriver driver, String elementPath)
    {
        boolean status = false;
        WebElement element = null;

        try
        {

            System.out.println("--------------------------------------------------");
            element = findElement(driver, elementPath);
            if (element.isDisplayed())
            {
                status = true;
                logger.info("Element is displayed.");
            }
            else
            {
                logger.info("Element is not displayed.");
            }
        }
        catch (Exception e)
        {
            System.out.println("--------------------------------------------------");
            try
            {
                logger.info("Locating element again...!");
                element = findElement(driver, elementPath);
                if (element.isDisplayed())
                {
                    status = true;
                    logger.info("Element is displayed.");
                }
                else
                {
                    logger.info("Element is not displayed.");
                }
            }
            catch (Exception e1)
            {
                logger.error("Error while verifying whether element is displayed." + e1.getMessage());
                status = false;

            }
        }

        System.out.println("--------------------------------------------------");
        return status;
    }

    /**
     * ;
     *
     * @author :shubham.upadhyay;
     * @description : verify element is dispalyed on ui by xpath;
     * @param :
     *            driver,element path of objectrepo;
     * @return boolean;
     */

    public static boolean isDisplayedByXpath(WebDriver driver, String elementPath) throws Exception
    {
        boolean status = false;
        WebElement element = null;

        try
        {
            element = ActionBot.findElementByXpath(driver, elementPath);
            if (element.isDisplayed())
            {
                status = true;
                logger.info("Element is displayed.");
            }
            else
            {
                logger.info("Element is not displayed.");
            }
        }
        catch (Exception e)
        {
            try
            {
                logger.info("Locating element again...!");
                element = ActionBot.findElement(driver, elementPath);
                if (element.isSelected())
                {
                    status = true;
                    logger.info("Element is displayed.");
                }
                else
                {
                    logger.info("Element is not displayed.");
                }
            }
            catch (Exception e1)
            {
                logger.error("Error while verifying whether element is displayed.");
                throw e1;
            }
        }
        return status;
    }

    public static boolean verifyElementVisible(WebDriver driver, String elementPath) throws Exception
    {
        boolean flag = false;
        wait = new WebDriverWait(driver,10);
        By by = WebElementWrapper.getElement(elementPath);
        try
        {
           WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated((by)));

            if (element!=null)
            {
                flag = true;
                logger.info("Element " + elementPath + " is visible");
            }
            else
            {
                flag = false;
                logger.info("Element " + elementPath + " is not visible");
            }
        }
        catch (Exception e)
        {
            flag = false;
            logger.info("Element " + elementPath + " is not visible");
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return flag;
    }

    public static boolean verifyElementVisibleByXpath(WebDriver driver, String elementXpath) throws Exception
    {
        boolean flag = false;
        // TestObject testObject = new TestObject();
        // testObject.addProperty("xpath", ConditionType.EQUALS, elementXpath);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try
        {
            // flag = WebUI.verifyElementVisible(testObject);
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
            if (webElement != null)
            {
                flag = true;
                logger.info("Element " + elementXpath + " is visible");
            }
            else
            {
                flag = false;
                logger.info("Element " + elementXpath + " is not visible");
            }
        }
        catch (Exception e)
        {
            flag = false;
            logger.info("Element " + elementXpath + " is not visible");
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
        return flag;
    }

    public static void moveToElement(WebDriver driver, String elementpath) throws Exception
    {
        By by = WebElementWrapper.getElement(elementpath);
        try
        {
            WebElement element = driver.findElement(by);
           moveToElement(driver, element);

          //  WebUI.mouseOver(driver, findTestObject(driver, objectRepoPath));
            logger.info("Hovered over the element successfully in 1st attempt");
        }
        catch (Exception e)
        {
            logger.info("Exception while hovering over the element in 1st attempt.\nReattempting to hover over the element.");
            //WebUI.mouseOver(driver, findTestObject(driver, objectRepoPath));
            logger.info("Hovered over the element successfully in 2nd attempt");
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    /**
     * ;
     *
     * @author: Priyanka;
     * @description : Click on tab;
     * @param :
     *            driver, Object Repository tabListPath, tabName; ;
     */

    public static void clickOnTab(WebDriver driver, String tabListPath, String tabName) throws Exception
    {
        try
        {
            List<WebElement> tabList = ActionBot.getListOfWebelements(driver, tabListPath);
            for (int i = 0; i < tabList.size(); i++)
            {
                if (tabList.get(i).getText().trim().equalsIgnoreCase(tabName))
                {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabList.get(i));
                    logger.info("Clicked on tab " + tabName);
                   defaultSleep(driver,10);
                }

                else if (i == (tabList.size() - 1))
                {
                    logger.info("Tab '" + tabName + "' not present");
                    throw new Exception("Tab '" + tabName + "' not present");
                }
            }

        }
        catch (Exception e)
        {
            try
            {
                logger.info("Trying to click on Tab");
                List<WebElement> tabList = ActionBot.getListOfWebelements(driver, tabListPath);
                for (int i = 0; i < tabList.size(); i++)
                {
                    if (tabList.get(i).getText().trim().equalsIgnoreCase(tabName))
                    {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabList.get(i));
                        logger.info("Clicked on tab " + tabName);
                        defaultSleep(driver,10);
                        break;
                    }

                    else if (i == (tabList.size() - 1))
                    {
                        logger.info("Tab '" + tabName + "' not present");
                        throw new Exception("Tab '" + tabName + "' not present");
                    }
                }
            }
            catch (Exception e1)
            {
                throw e1;
            }
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }
    }

    public static boolean waitForElementVisible(WebDriver driver, String elementPath) throws Exception
    {
        boolean flag = false;
        wait = new WebDriverWait(driver,10);
        By by = WebElementWrapper.getElement(elementPath);
        try
        {
            if (wait.until(ExpectedConditions.presenceOfElementLocated(by))!=null)
            {
                flag = true;
                logger.info("Element '" + elementPath + "' is visible.");
            }
            else
            {
                logger.info("Element '" + elementPath + "' is not visible.");

            }
        }
        catch (Exception e1)
        {
            throw e1;
        }
        finally
        {
           // CommonServices.analyzeLog(driver);
        }

        return flag;
    }

    public static boolean verifyElementHasAttribute(WebDriver driver, String elementXpath, String attribute, int timeout)
    {
        boolean hasAttribute = false;

       // String xpath = WebElementWrapper.getXpath(elementXpath);
        try
        {
            WebElement element = driver.findElement(By.xpath(elementXpath));

            if (isElementPresentByXpath(driver,elementXpath))
            {
                String att = element.getAttribute(attribute);
                if (att.equals(null))
                {
                    hasAttribute = false;
                }
                else
                {
                    hasAttribute = true;
                }
            }

        }
        catch (Exception e)
        {
            hasAttribute = false;
        }

        return hasAttribute;
    }
}
