package framework.utilities.customWebUI;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
//import java.util.function.Function;

//import org.apache.cxf.jaxrs.ext.search.ConditionType;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.frameworkUtilies.GlobalVariable;
import framework.utilities.commonServices.TestObject;
import framework.utilities.webElementWrapper.WebElementWrapper;

public class WebUI
{

	public static Logger logger = Logger.getLogger(WebUI.class);

	public static WebElement findTestObject(WebDriver driver, String elementPath) throws Exception
	{
		WebElement element = null;

		By by = WebElementWrapper.getElement(elementPath);

		try
		{

			WebDriverWait wait = new WebDriverWait(driver, GlobalVariable.DEFAULT_HIGH_WAIT);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

		}
		catch (Exception e)
		{
			try
			{

				WebDriverWait wait = new WebDriverWait(driver, GlobalVariable.DEFAULT_HIGH_WAIT);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

			}
			catch (Exception e2)
			{
				element = null;
				logger.error("Exception occurred while finding element.");
			}

		}

		return element;
	}

	public static TestObject findObject(String elementPath) throws Exception
	{
		TestObject testObject = new TestObject();
		// By by = WebElementWrapper.getElement(elementPath);
		String xpath = WebElementWrapper.getXpath(elementPath);
//		testObject.addProperty("xpath", ConditionType.EQUALS, xpath);

		return testObject;

	}

	public static void click(WebDriver driver, WebElement element, int timeout) throws Exception
	{

		try
		{

			if (element != null)
			{
				if (waitForElementVisible(driver, element, timeout))
				{
					if (waitForElementClickable(driver, element, timeout))
					{
						element.click();
						logger.info("Clicked on element.");
					}
				}
			}
			else
			{
				throw new Exception("Element is null");
			}

		}
		catch (Exception e)
		{
			try
			{
				if (element != null)
				{
					if (waitForElementVisible(driver, element, timeout))
					{
						if (waitForElementClickable(driver, element, timeout))
						{
							element.click();
							logger.info("Clicked on element.");
						}
					}
				}
				else
				{
					throw new Exception("Element is null");
				}

			}
			catch (Exception e1)
			{
				logger.error("Exception occurred while clicking on element.");
				throw e1;
			}
		}

	}

	public static boolean waitForElementVisible(WebDriver driver, WebElement element, int timeout) throws Exception
	{
		boolean isVisible = false;

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			if (element != null)
			{
				if (wait.until(ExpectedConditions.visibilityOf(element)) != null)
				{
					isVisible = true;

				}
			}

		}
		catch (Exception e)
		{
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, timeout);

				if (element != null)
				{
					if (wait.until(ExpectedConditions.visibilityOf(element)) != null)
					{
						isVisible = true;

					}
					else
					{
						logger.info("Element is not visible." + element);

					}
				}

			}
			catch (Exception e2)
			{
				isVisible = false;
			}
		}
		return isVisible;

	}

	public static boolean waitForElementVisible(WebDriver driver, TestObject testObject, int timeout) throws Exception
	{
		boolean isVisible = false;
		String xpath = testObject.findPropertyValue("xpath");
		WebElement element = driver.findElement(By.xpath(xpath));

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, timeout);

			if (element != null)
			{
				if (wait.until(ExpectedConditions.visibilityOf(element)) != null)
				{
					isVisible = true;

				}
			}

		}
		catch (Exception e)
		{
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, timeout);

				if (element != null)
				{
					if (wait.until(ExpectedConditions.visibilityOf(element)) != null)
					{
						isVisible = true;

					}
					else
					{
						logger.info("Element is not visible.");

					}
				}
			}
			catch (Exception e2)
			{
				isVisible = false;
			}
		}
		return isVisible;

	}

	public static boolean waitForElementClickable(WebDriver driver, WebElement element, int timeout) throws Exception
	{
		boolean isClickable = false;

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, timeout);

			if (element != null)
			{
				if (wait.until(ExpectedConditions.elementToBeClickable(element)) != null)
				{
					isClickable = true;

				}
			}
		}
		catch (Exception e)
		{
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, timeout);

				if (element != null)
				{
					if (wait.until(ExpectedConditions.elementToBeClickable(element)) != null)
					{
						isClickable = true;

					}
					else
					{
						logger.info("Element is not clickable.");

					}
				}
			}
			catch (Exception e2)
			{
				isClickable = false;
			}
		}
		return isClickable;

	}

	public static void clearText(WebDriver driver, WebElement element) throws Exception
	{

		try
		{

			if (element != null)
			{

				if (waitForElementVisible(driver, element, GlobalVariable.DEFAULT_HIGH_WAIT))
				{
					if (waitForElementClickable(driver, element, GlobalVariable.DEFAULT_HIGH_WAIT))
					{
						element.clear();
						logger.info("Clicked on element.");
					}
				}
			}
			else
			{
				throw new Exception("Element is null");
			}

		}
		catch (Exception e)
		{
			try
			{
				if (element != null)
				{

					if (waitForElementVisible(driver, element, GlobalVariable.DEFAULT_HIGH_WAIT))
					{
						if (waitForElementClickable(driver, element, GlobalVariable.DEFAULT_HIGH_WAIT))
						{
							element.clear();
							logger.info("Clicked on element.");
						}
					}
				}
				else
				{
					throw new Exception("Element is null");
				}
			}
			catch (Exception e1)
			{
				logger.error("Exception occurred while clicking on element.");
				throw e1;
			}
		}

	}

	public static void setText(WebDriver driver, WebElement element, String text) throws Exception
	{

		try
		{

			if (element != null)
			{

				if (waitForElementVisible(driver, element, GlobalVariable.DEFAULT_HIGH_WAIT))
				{
					if (waitForElementClickable(driver, element, GlobalVariable.DEFAULT_HIGH_WAIT))
					{
						element.sendKeys(text);
						logger.info("Entered value is : " + text);
					}
				}
			}
			else
			{
				throw new Exception("Element is null");
			}

		}
		catch (Exception e)
		{
			try
			{
				if (element != null)
				{
					if (waitForElementVisible(driver, element, GlobalVariable.DEFAULT_HIGH_WAIT))
					{
						if (waitForElementClickable(driver, element, GlobalVariable.DEFAULT_HIGH_WAIT))
						{
							element.sendKeys(text);
							logger.info("Entered value is : " + text);
						}
					}
				}
				else
				{
					throw new Exception("Element is null");
				}
			}
			catch (Exception e1)
			{
				logger.error("Exception occurred while entering on element.");
				throw e1;
			}
		}

	}

	public static boolean waitForElementNotVisible(WebDriver driver, WebElement element, int timeout) throws Exception
	{
		boolean isInvisible = false;

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			if (element != null)
			{
				if (wait.until(ExpectedConditions.invisibilityOf(element)) != null)
				{
					isInvisible = true;

					logger.info("Element is invisible.");
				}
			}
		}
		catch (Exception e)
		{
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, timeout);
				if (element != null)
				{
					if (wait.until(ExpectedConditions.invisibilityOf(element)) != null)
					{
						isInvisible = true;

						logger.info("Element is invisible.");
					}
					else
					{
						logger.info("Element is not invisible.");

					}
				}
			}
			catch (Exception e2)
			{
				isInvisible = false;
			}
		}
		return isInvisible;

	}

	public static boolean verifyElementClickable(WebElement element, int timeout) throws Exception
	{
		boolean isClickable = false;

		try
		{
			if (element != null)
			{
				if (element.isEnabled())
				{
					isClickable = true;

					logger.info("Element is clickable.");
				}
			}
		}
		catch (Exception e)
		{
			try
			{
				if (element != null)
				{
					if (element.isEnabled())
					{
						isClickable = true;

						logger.info("Element is clickable.");
					}
					else
					{
						logger.info("Element is not clickable.");

					}
				}
			}
			catch (Exception e2)
			{
				isClickable = false;
			}
		}
		return isClickable;

	}

	public static String getText(WebDriver driver, WebElement element) throws Exception
	{
		String text = null;
		try
		{

			if (element != null)
			{
				if (waitForElementVisible(driver, element, 1000))
				{
					text = element.getText();
					logger.info("Text is : " + text);
				}
			}
			else
			{
				throw new Exception("Element is null");
			}
		}
		catch (Exception e)
		{
			try
			{
				if (element != null)
				{
					if (waitForElementVisible(driver, element, 1000))
					{
						text = element.getText();
						logger.info("Text is : " + text);
					}
				}
				else
				{
					throw new Exception("Element is null");
				}
			}
			catch (Exception e1)
			{
				logger.error("Exception occurred while fetching element text.");
				throw e1;
			}
		}
		return text;

	}

	public static String getAttribute(WebDriver driver, WebElement element, String attribute) throws Exception
	{
		String value = null;
		try
		{

			if (element != null)
			{
				if (waitForElementVisible(driver, element, 1000))
				{
					value = element.getAttribute(attribute);
					logger.info("Value for attribute '" + attribute + "' is : " + value);
				}
			}
			else
			{
				throw new Exception("Element is null");
			}
		}
		catch (Exception e)
		{
			try
			{
				if (element != null)
				{
					if (waitForElementVisible(driver, element, 1000))
					{
						value = element.getAttribute(attribute);
						logger.info("Value for attribute '" + attribute + "' is : " + value);
					}
				}
				else
				{
					throw new Exception("Element is null");
				}
			}
			catch (Exception e1)
			{
				logger.error("Exception occurred while fetching element attribute.");
				throw e1;
			}
		}
		return value;

	}

	public static void mouseOver(WebDriver driver, WebElement element) throws Exception
	{

		try
		{
			if (element != null)
			{
				if (waitForElementVisible(driver, element, 1000))
				{
					Actions action = new Actions(driver);

					action.moveToElement(element).build().perform();
				}
			}
			else
			{
				throw new Exception("Element is null");
			}
		}
		catch (Exception e)
		{
			logger.error("Exception occurred while hovering over element.");
			throw e;
		}
	}

	public static List<WebElement> findWebElements(WebDriver driver, By by, int timeout) throws Exception

	{
		List<WebElement> elementList = null;

		try
		{

			elementList = driver.findElements(by);

		}
		catch (Exception e)
		{
			try
			{
				elementList = driver.findElements(by);

			}
			catch (Exception e2)
			{
				logger.error("Exception occurred while finding elements.");
				throw e2;
			}

		}
		return elementList;
	}

	public static boolean waitForElementPresent(WebDriver driver, WebElement element, int timeout) throws Exception
	{
		boolean isVisible = false;

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, timeout);

			if (element != null)
			{
				if (wait.until(ExpectedConditions.visibilityOf(element)) != null)
				{
					isVisible = true;

				}
			}
		}
		catch (Exception e)
		{
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, timeout);

				if (element != null)
				{
					if (wait.until(ExpectedConditions.visibilityOf(element)) != null)
					{
						isVisible = true;

					}
					else
					{
						logger.info("Element is not visible.");

					}
				}
			}
			catch (Exception e2)
			{
				logger.error("Element is not visible.");

				isVisible = false;
			}
		}
		return isVisible;

	}

	public static boolean waitForElementPresent(WebDriver driver, TestObject testObject, int timeout) throws Exception
	{

		boolean isVisible = false;
		String xpath = testObject.findPropertyValue("xpath");
		WebElement element = driver.findElement(By.xpath(xpath));

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			if (element != null)
			{
				if (wait.until(ExpectedConditions.visibilityOf(element)) != null)
				{
					isVisible = true;

				}
			}

		}
		catch (Exception e)
		{
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, timeout);

				if (element != null)
				{
					if (wait.until(ExpectedConditions.visibilityOf(element)) != null)
					{
						isVisible = true;

					}
					else
					{
						logger.info("Element is not visible.");

					}
				}
			}
			catch (Exception e2)
			{
				logger.error("Element is not visible.");

				isVisible = false;
			}
		}
		return isVisible;

	}

	public static boolean waitForElementNotPresent(WebDriver driver, WebElement element, int timeout) throws Exception
	{
		boolean isVisible = false;

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			if (element != null)
			{
				if (wait.until(ExpectedConditions.invisibilityOf(element)))
				{
					isVisible = true;

					logger.info("Element is not visible.");
				}
				else
				{
					isVisible = false;
				}
			}
			else
			{
				isVisible = true;
			}
		}
		catch (Exception e)
		{
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, timeout);
				if (element != null)
				{
					if (wait.until(ExpectedConditions.invisibilityOf(element)))
					{
						isVisible = true;

						logger.info("Element is not visible.");
					}
					else
					{
						isVisible = false;
					}
				}
				else
				{
					isVisible = true;
				}
			}
			catch (Exception e2)
			{
				isVisible = false;
			}
		}
		return isVisible;
	}

	public static boolean verifyAlertPresent(WebDriver driver, int timeout) throws Exception
	{
		boolean isAlertPresent = false;

		try
		{
			driver.switchTo().alert();
			isAlertPresent = true;
		}
		catch (NoAlertPresentException e)
		{
			isAlertPresent = false;
			logger.error("Alert it not present.");
		}
		return isAlertPresent;

	}

	public static void doubleClick(WebDriver driver, WebElement element) throws Exception
	{

		try
		{
			if (element != null)
			{
				if (waitForElementVisible(driver, element, 1000))
				{
					Actions action = new Actions(driver);

					action.moveToElement(element).doubleClick().build().perform();
				}
			}
		}
		catch (Exception e)
		{
			logger.error("Exception occurred while double clicking on element.");
			throw e;
		}
	}

	public static void scrollToPosition(WebDriver driver, int x, int y) throws Exception
	{

		((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ");");
	}

	public static void scrollToElement(WebDriver driver, WebElement element, int str) throws Exception
	{

		if (element != null)
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		}
		else
		{
			throw new Exception("Element is null");
		}
	}

	public static void switchToWindowIndex(WebDriver driver, int index) throws Exception
	{

		try
		{

			((JavascriptExecutor) driver).executeScript("window.open();");
			String parentWindow = driver.getWindowHandle();
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> iterator = windows.iterator();

			while (iterator.hasNext())
			{
				String childWindow = iterator.next();
				if (!parentWindow.equalsIgnoreCase(childWindow))
				{
					driver.switchTo().window(childWindow);
				}
			}

			logger.info("Navigated to : " + driver.getTitle());
		}
		catch (Exception e)
		{
			logger.error("Exception while switching to window.");
			throw e;
		}
	}

	public static int getElementLeftPosition(WebElement element) throws Exception
	{
		int leftPosition = 0;

		try
		{
			if (element != null)
			{
				leftPosition = element.getLocation().getX();
				logger.info("Position of the Element is :" + leftPosition);
			}
			else
			{
				throw new Exception("Element is null");
			}
		}
		catch (Exception e)
		{
			throw e;
		}

		return leftPosition;
	}

	public static void uploadFile(WebDriver driver, WebElement element, String path) throws Exception
	{

		try
		{
			if (element != null)
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value',arguments[1]);", element, path);
			}
			else
			{
				throw new Exception("Element is null");
			}
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static void delay(int timeOut) throws InterruptedException
	{

		Thread.sleep(timeOut * 1000);
	}

	public static void click(WebDriver driver, WebElement element) throws Exception
	{
		try
		{
			if (element != null)
			{
				if (waitForElementVisible(driver, element, GlobalVariable.TIMEOUT))
				{
					if (waitForElementClickable(driver, element, GlobalVariable.TIMEOUT))
					{
						element.click();
						logger.info("Clicked on element.");
					}
				}
			}
			else
			{
				throw new Exception("Element is null");
			}
		}
		catch (Exception e)
		{
			try
			{
				if (element != null)
				{
					if (waitForElementVisible(driver, element, GlobalVariable.TIMEOUT))
					{
						if (waitForElementClickable(driver, element, GlobalVariable.TIMEOUT))
						{
							element.click();
							logger.info("Clicked on element.");
						}
					}
				}
				else
				{
					throw new Exception("Element is null");
				}
			}
			catch (Exception e1)
			{
				logger.error("Exception occurred while clicking on element.");
				throw e1;
			}
		}

	}

	public static void waitForPageLoad(WebDriver driver, int dEFAULT_HIGH_WAIT)
	{
//		Wait<WebDriver> wait = new WebDriverWait(driver, dEFAULT_HIGH_WAIT);
//		wait.until(new Function<WebDriver, Object>() {
//			public Object apply(WebDriver driver1)
//			{
//				return String.valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState")).equals("complete");
//			}
//		});

	}

	public static void sendKeys(WebDriver driver, WebElement element, String text) throws Exception
	{

		try
		{

			if (element != null)
			{

				if (waitForElementVisible(driver, element, GlobalVariable.DEFAULT_HIGH_WAIT))
				{
					if (waitForElementClickable(driver, element, GlobalVariable.DEFAULT_HIGH_WAIT))
					{
						element.sendKeys(text);
						logger.info("Entered value is : " + text);
					}
				}
			}
			else
			{
				throw new Exception("Element is null");
			}

		}
		catch (Exception e)
		{
			try
			{
				if (element != null)
				{

					if (waitForElementVisible(driver, element, GlobalVariable.DEFAULT_HIGH_WAIT))
					{
						if (waitForElementClickable(driver, element, GlobalVariable.DEFAULT_HIGH_WAIT))
						{
							element.sendKeys(text);
							logger.info("Entered value is : " + text);
						}
					}
				}
				else
				{
					throw new Exception("Element is null");
				}
			}
			catch (Exception e1)
			{
				logger.error("Exception occurred while entering on element.");
				throw e1;
			}
		}

	}

	public static void sendKeys(WebDriver driver, WebElement element, Keys key) throws Exception
	{

		try
		{

			if (element != null)
			{
				if (waitForElementVisible(driver, element, GlobalVariable.DEFAULT_MEDIUM_WAIT))
				{
					if (waitForElementClickable(driver, element, GlobalVariable.DEFAULT_MEDIUM_WAIT))
					{
						element.sendKeys(key);
					}
				}
			}
			else
			{
				throw new Exception("Element is null");
			}
		}
		catch (Exception e)
		{
			try
			{
				if (element != null)
				{
					if (waitForElementVisible(driver, element, GlobalVariable.DEFAULT_MEDIUM_WAIT))
					{
						if (waitForElementClickable(driver, element, GlobalVariable.DEFAULT_MEDIUM_WAIT))
						{
							element.sendKeys(key);
						}
					}
				}
				else
				{
					throw new Exception("Element is null");
				}
			}
			catch (Exception e1)
			{
				logger.error("Exception occurred while entering on element.");
				throw e1;
			}
		}

	}

	public static boolean verifyElementVisible(WebElement element) throws Exception
	{
		boolean isVisible = false;
		try
		{
			if (element.isDisplayed())
			{
				isVisible = true;
			}
		}
		catch (Exception e)
		{
			isVisible = false;
		}
		return isVisible;
	}

	public static List<WebElement> findWebElements(WebDriver driver, String elementPath, int timeout) throws Exception
	{
		List<WebElement> elementList = null;
		By by = WebElementWrapper.getElement(elementPath);

		try
		{
			elementList = driver.findElements(by);
		}
		catch (Exception e)
		{
			try
			{
				elementList = driver.findElements(by);
			}
			catch (Exception e2)
			{
				logger.error("Exception occurred while finding elements.");
				throw e2;
			}
		}
		return elementList;
	}

	public static void refresh(WebDriver driver) throws Exception
	{
		try
		{
			driver.navigate().refresh();
		}
		catch (Exception e)
		{
			logger.error("Exception occurred while refreshing page.");
			throw e;
		}

	}

	public static boolean verifyElementPresent(WebElement element, int timeout)
	{
		boolean isElementPresent = false;

		try
		{
			if (element != null)
				if (element.isDisplayed())
				{
					isElementPresent = true;
				}
		}
		catch (Exception e)
		{
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public static boolean verifyElementHasAttribute(WebDriver driver, TestObject testObject, String attribute, int dEFAULT_HIGH_WAIT)
	{
		boolean hasAttribute = false;

		String xpath = testObject.findPropertyValue("xpath");

		try
		{
			WebElement element = driver.findElement(By.xpath(xpath));
			if (waitForElementPresent(driver, element, dEFAULT_HIGH_WAIT))
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

	public static void navigateToUrl(WebDriver driver, String url) throws Exception
	{
		try
		{
			driver.get(url);
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static String getUrl(WebDriver driver) throws Exception
	{
		String url = null;
		try
		{
			url = driver.getCurrentUrl();
		}
		catch (Exception e)
		{
			throw e;
		}
		return url;
	}

	public static int getWindowIndex(WebDriver driver) throws Exception
	{
		int index = 0;

		try
		{
			String currentWindow = driver.getWindowHandle();
			Set<String> allWindow = driver.getWindowHandles();
			Iterator<String> iterator = allWindow.iterator();

			while (iterator.hasNext())
			{
				String nextWindow = iterator.next();
				if (!currentWindow.equalsIgnoreCase(nextWindow))
				{
					index++;
				}
				else
				{
					break;
				}

			}
		}
		catch (Exception e)
		{
			throw e;
		}
		return index;
	}

	public static void switchToDefaultContent(WebDriver driver) throws Exception
	{

		driver.switchTo().defaultContent();
	}

}
