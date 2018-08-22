package com.zycus.framework.framework_version_2_4.framework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

/**
 * 
 * @author parminder.singh
 *
 */
public class WaitUtil
{

	static Logger			logger					= Logger.getLogger(WaitUtil.class);

	/** Default wait time for an element. 7 seconds. */
	public static final int	DEFAULT_WAIT_4_ELEMENT	= 60;
	/**
	 * Default wait time for a page to be displayed. 12 seconds. The average
	 * webpage load time is 6 seconds in 2012. Based on your tests, please set
	 * this value. "0" will nullify implicitlyWait and speed up a test.
	 */
	public static final int	DEFAULT_WAIT_4_PAGE		= 60;

	private static int		DEFAULT_WAIT_TIME		= Integer.parseInt(ConfigProperty.getConfig("DEFAULT_WAIT_TIME"));

	/**
	 * Wait for the element to be present in the DOM, and displayed on the page.
	 * And returns the first WebElement using the given method.
	 * 
	 * @param WebDriver
	 *        The driver object to be used
	 * @param By
	 *        selector to find the element
	 * @param int
	 *        The time in seconds to wait until returning a failure
	 *
	 * @return WebElement the first WebElement using the given method, or null
	 *         (if the timeout is reached)
	 */
	public static WebElement waitForElement(WebDriver driver, final By by, int timeOutInSeconds)
	{
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		element = driver.findElement(by);
		return element; // return the element
	}

	/**
	 * Wait for the element to be present in the DOM, regardless of being
	 * displayed or not. And returns the first WebElement using the given
	 * method.
	 *
	 * @param WebDriver
	 *        The driver object to be used
	 * @param By
	 *        selector to find the element
	 * @param int
	 *        The time in seconds to wait until returning a failure
	 * 
	 * @return WebElement the first WebElement using the given method, or null
	 *         (if the timeout is reached)
	 */
	public static WebElement waitForElementPresent(WebDriver driver, final By by, int timeOutInSeconds)
	{
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		element = driver.findElement(by);
		return element; // return the element
	}

	/**
	 * Wait for the List<WebElement> to be present in the DOM, regardless of
	 * being displayed or not. Returns all elements within the current page DOM.
	 * 
	 * @param WebDriver
	 *        The driver object to be used
	 * @param By
	 *        selector to find the element
	 * @param int
	 *        The time in seconds to wait until returning a failure
	 *
	 * @return List<WebElement> all elements within the current page DOM, or
	 *         null (if the timeout is reached)
	 */
	public static List<WebElement> waitForListElementsPresent(WebDriver driver, final By by, int timeOutInSeconds)
	{
		List<WebElement> elements = null;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driverObject)
			{
				try
				{
					return areElementsPresent(driverObject, by);
				}
				catch (TestCaseException e)
				{
					logger.error("By Element :" + by.toString() + "; " + e, e);
				}
				return false;
			}
		});
		elements = driver.findElements(by);
		return elements; // return the element
	}

	/**
	 * Wait for an element to appear on the refreshed web-page. And returns the
	 * first WebElement using the given method.
	 *
	 * This method is to deal with dynamic pages.
	 * 
	 * Some sites I (Mark) have tested have required a page refresh to add
	 * additional elements to the DOM. Generally you (Chon) wouldn't need to do
	 * this in a typical AJAX scenario.
	 * 
	 * @param WebDriver
	 *        The driver object to use to perform this element search
	 * @param locator
	 *        selector to find the element
	 * @param int
	 *        The time in seconds to wait until returning a failure
	 * 
	 * @return WebElement the first WebElement using the given method, or
	 *         null(if the timeout is reached)
	 * 
	 * @author Mark Collin
	 * @throws TestCaseException
	 */
	public static WebElement waitForElementRefresh(WebDriver driver, final By by, int timeOutInSeconds) throws TestCaseException
	{
		WebElement element;
		try
		{
			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driverObject)
				{
					driverObject.navigate().refresh(); // refresh the page
														// ****************
					try
					{
						return isElementPresentAndDisplay(driverObject, by);
					}
					catch (TestCaseException e)
					{
						logger.error("By Element :" + by.toString(), e);
					}
					return false;
				}
			});
			element = driver.findElement(by);
			return element;
		}
		catch (Exception e)
		{
			throw new TestCaseException("Exception in waitForElementRefresh" + " By Element :" + by.toString(), e);
		}
	}

	/**
	 * Wait for the Text to be present in the given element, regardless of being
	 * displayed or not.
	 *
	 * @param WebDriver
	 *        The driver object to be used to wait and find the element
	 * @param locator
	 *        selector of the given element, which should contain the text
	 * @param String
	 *        The text we are looking
	 * @param int
	 *        The time in seconds to wait until returning a failure
	 * 
	 * @return boolean
	 * @throws TestCaseException
	 */
	public static boolean waitForTextPresent(WebDriver driver, final By by, final String text, int timeOutInSeconds) throws TestCaseException
	{
		boolean isPresent = false;
		try
		{
			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driverObject)
				{
					return isTextPresent(driverObject, by, text); // is the Text
																	// in the
																	// DOM
				}
			});
			isPresent = isTextPresent(driver, by, text);
			return isPresent;
		}
		catch (Exception e)
		{
			throw new TestCaseException("Exception in waitForTextPresent" + "By Element :" + by.toString(), e);
		}
	}

	/**
	 * 
	 * @param driver
	 * @param by
	 * @param timeOutInSeconds
	 * @return WebElement
	 */
	public static WebElement waitForElementClickable(WebDriver driver, final By by, int timeOutInSeconds)
	{
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		element = driver.findElement(by);
		return element; // return the element
	}

	/**
	 * 
	 * @param driver
	 * @param by
	 * @param timeOutInSeconds
	 * @return WebElement
	 */
	public static WebElement waitForElementVisible(WebDriver driver, final By by, int timeOutInSeconds)
	{
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element; // return the element
	}

	/**
	 * Waits for the Condition of JavaScript.
	 *
	 *
	 * @param WebDriver
	 *        The driver object to be used to wait and find the element
	 * @param String
	 *        The javaScript condition we are waiting. e.g.
	 *        "return (xmlhttp.readyState >= 2 && xmlhttp.status == 200)"
	 * @param int
	 *        The time in seconds to wait until returning a failure
	 * 
	 * @return boolean true or false(condition fail, or if the timeout is
	 *         reached)
	 * @throws TestCaseException
	 **/
	public static boolean waitForJavaScriptCondition(WebDriver driver, final String javaScript, int timeOutInSeconds) throws TestCaseException
	{
		boolean jscondition = false;
		try
		{
			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driverObject)
				{
					return (Boolean) ((JavascriptExecutor) driverObject).executeScript(javaScript);
				}
			});
			jscondition = (Boolean) ((JavascriptExecutor) driver).executeScript(javaScript);
			return jscondition;
		}
		catch (Exception e)
		{
			throw new TestCaseException("Exception in waitForJavaScriptCondition" + " javascript :" + javaScript, e);
		}
	}

	/**
	 * Waits for the completion of Ajax jQuery processing by checking
	 * "return jQuery.active == 0" condition.
	 *
	 * @param WebDriver
	 *        - The driver object to be used to wait and find the element
	 * @param int
	 *        - The time in seconds to wait until returning a failure
	 * 
	 * @return boolean true or false(condition fail, or if the timeout is
	 *         reached)
	 */
	public static boolean waitForJQueryProcessing(WebDriver driver, int timeOutInSeconds)
	{
		boolean jQcondition = false;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																		// implicitlyWait()
		new WebDriverWait(driver, timeOutInSeconds) {
		}.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driverObject)
			{
				return (Boolean) ((JavascriptExecutor) driverObject).executeScript("return jQuery.active == 0");
			}
		});
		jQcondition = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
		driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																							// implicitlyWait
		return jQcondition;
	}

	/**
	 * Coming to implicit wait, If you have set it once then you would have to
	 * explicitly set it to zero to nullify it -
	 */
	public static void nullifyImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																		// implicitlyWait()
	}

	/**
	 * Set driver implicitlyWait() time.
	 */
	public static void setImplicitWait(WebDriver driver, int waitTime_InSeconds)
	{
		driver.manage().timeouts().implicitlyWait(waitTime_InSeconds, TimeUnit.SECONDS);
	}

	/**
	 * Reset ImplicitWait. To reset ImplicitWait time you would have to
	 * explicitly set it to zero to nullify it before setting it with a new time
	 * value.
	 */
	public static void resetImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																		// implicitlyWait()
		driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																							// implicitlyWait
	}

	/**
	 * Checks if the text is present in the element.
	 * 
	 * @param driver
	 *        - The driver object to use to perform this element search
	 * @param by
	 *        - selector to find the element that should contain text
	 * @param text
	 *        - The Text element you are looking for
	 * @return true or false
	 */
	private static boolean isTextPresent(WebDriver driver, By by, String text)
	{
		try
		{
			return driver.findElement(by).getText().contains(text);
		}
		catch (NullPointerException e)
		{
			return false;
		}
	}

	/**
	 * Checks if the List<WebElement> are in the DOM, regardless of being
	 * displayed or not.
	 * 
	 * @param driver
	 *        - The driver object to use to perform this element search
	 * @param by
	 *        - selector to find the element
	 * @return boolean
	 * @throws TestCaseException
	 */
	private static boolean areElementsPresent(WebDriver driver, By by) throws TestCaseException
	{
		try
		{
			driver.findElements(by);
			return true;
		}
		catch (NoSuchElementException e)
		{
			throw new TestCaseException("Exception in areElementsPresent", e);
		}
	}

	/**
	 * Checks if the elment is in the DOM and displayed.
	 * 
	 * @param driver
	 *        - The driver object to use to perform this element search
	 * @param by
	 *        - selector to find the element
	 * @return boolean
	 * @throws TestCaseException
	 */
	private static boolean isElementPresentAndDisplay(WebDriver driver, By by) throws TestCaseException
	{
		try
		{
			return driver.findElement(by).isDisplayed();
		}
		catch (NoSuchElementException e)
		{
			throw new TestCaseException("Exception in isElementPresentAndDisplay", e);
		}
	}

	@SuppressWarnings("unused")
	private static boolean isAlertPresent(WebDriver driver)
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e)
		{
			// Exception eaten up as it is not needed to log
			// It only checks if alert is present or not.
			return false;
		}
	}

	/**
	 * <pre>
	 * This method does not take any timeout parameters and defaults 
	 * 		fluentWaitTimeout : 150 SECONDS
	 * 		pollingTime       : 500 MILLISECONDS
	 * and returns the element after checking using FluentWait
	 * </pre>
	 * 
	 * @param driver
	 * @param by
	 * @return WebElement
	 * @throws TestCaseException
	 * 
	 * @author puneet.sharma
	 * 
	 */
	public static WebElement getElementUsingFluentWait(final WebDriver driver, final By by) throws TestCaseException
	{
		return getElementUsingFluentWait(driver, by, DEFAULT_WAIT_TIME, 500);
	}

	/**
	 * <pre>
	 * This method does not take any timeout parameters and defaults 
	 * 		javascriptTimeout : 150 SECONDS
	 * 		fluentWaitTimeout : 150 SECONDS
	 * 		pollingTime       : 500 MILLISECONDS
	 * and returns the element after checking using FluentWait
	 * </pre>
	 * 
	 * @param driver
	 * @param by
	 * @return WebElement
	 * @throws TestCaseException
	 * 
	 * @author puneet.sharma
	 * 
	 */
	public static WebElement getElementUsingFluentWaitAndJS(final WebDriver driver, final By by) throws TestCaseException
	{
		return getElementUsingFluentWaitAndJS(driver, by, DEFAULT_WAIT_TIME, DEFAULT_WAIT_TIME, 500);
	}

	/**
	 * This method takes all wait timeout arguments. Please specify the waits in
	 * the order as specified.
	 * 
	 * @param driver
	 * @param by
	 * @param fluentWaitTimeout
	 *        in Seconds
	 * @param pollingTime
	 *        in MilliSeconds
	 * @return
	 * @throws TestCaseException
	 */
	public static WebElement getElementUsingFluentWait(final WebDriver driver, final By by, int fluentWaitTimeout, int pollingTime) throws TestCaseException
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(fluentWaitTimeout, TimeUnit.SECONDS).pollingEvery(pollingTime, TimeUnit.MILLISECONDS)
			.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver WebDriver)
			{
				return driver.findElement(by);
			}
		});
	}

	/**
	 * This method takes all wait timeout arguments. Please specify the waits in
	 * the order as specified.
	 * 
	 * @param driver
	 * @param by
	 * @param javascriptTimeout
	 *        in Seconds
	 * @param fluentWaitTimeout
	 *        in Seconds
	 * @param pollingTime
	 *        in MilliSeconds
	 * @return
	 * @throws TestCaseException
	 */
	public static WebElement getElementUsingFluentWaitAndJS(final WebDriver driver, final By by, int javascriptTimeout, int fluentWaitTimeout, int pollingTime)
		throws TestCaseException
	{
		String isPageLoadComplete = "return (document.readyState === 'complete')";
		waitForJavaScriptCondition(driver, isPageLoadComplete, javascriptTimeout);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(fluentWaitTimeout, TimeUnit.SECONDS).pollingEvery(pollingTime, TimeUnit.MILLISECONDS)
			.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver WebDriver)
			{
				return driver.findElement(by);
			}
		});
	}

	/**
	 * This Method verifies whether the alert is present or not. If present
	 * returns the Alert element.
	 * 
	 * @param driver
	 * @param timeOut
	 * @return Alert
	 */
	public static Alert isAlertPresent(WebDriver driver, long timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

}
