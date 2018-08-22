package com.zycus.automation.utilities.actionbot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.IPageRequisitionCheckOut;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.WaitUtil;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

import bsh.StringUtil;
import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;

public class ActionBot
{

	final static String		log4jAppender		= ConfigProperty.getConfig("log4jFile");
	public static int		timeOut				= Integer.parseInt(ConfigProperty.getConfig("timeOut"));
	public static String	defaultSleep		= ConfigProperty.getConfig("defaultSleep");
	public static String	defaultMediumSleep	= ConfigProperty.getConfig("defaultMediumSleep");
	public static String	defaultHighSleep	= ConfigProperty.getConfig("defaultHighSleep");
	static Logger			logger				= Logger.getLogger(ActionBot.class);
	static
	{
		PropertyConfigurator.configure(log4jAppender);
	}

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> append underscrore for screenshots
	 */
	public static String appendUnderScore(String string)
	{
		String str = null;
		String[] str1 = StringUtil.split(string, " ");
		for (String str2 : str1)
		{
			if (str == null)
			{
				str = str2;
			}
			else if (str != null)
			{
				str = str.concat("_").concat(str2);
			}
		}
		if (str == null)
		{
			str = string;
		}
		return str.toUpperCase();
	}

	public static boolean assertString(String str)
	{
		boolean assertStatus = false;
		if (str.equalsIgnoreCase("True"))
		{
			assertStatus = true;
		}
		return assertStatus;
	}

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> Used to Clear the text Field <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param by
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 * 
	 * @return
	 * @throws ActionBotException
	 */
	public static void clear(WebDriver driver, UI_Elements uiElements) throws ActionBotException
	{
		String error = getError(uiElements);
		WebElement element = null;
		try
		{
			element = ActionBot.findElement(driver, uiElements);
			element.clear();
		}
		catch (StaleElementReferenceException ex)
		{
			logger.error("Stale Element Reference Exception has occurred... Locating element again.. ");
			try
			{
				element = findElement(driver, uiElements);
				if (element != null)
				{
					element.clear();
				}
				else
				{
					logger.error("Element is Null Hence Unable To Clear ON ELEMENT : ");
				}
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in clear Method While performing clear on " + uiElements.getBy() + " => \n" + exx, exx);
			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Clear Method While performing clear on  " + " =>" + error + " \n" + e, e);
		}

	}

	public static void click(WebDriver driver, By by) throws ActionBotException
	{
		WebElement element;
		try
		{
			element = waitForElementToBeDisplayed(driver, by, timeOut);
			if (element != null)
			{
				try
				{
					element = waitForElementToBeEnable(driver, by, timeOut);
					if (element != null)
					{
						element.click();
					}
					else
					{
						logger.error("Element is Null Hence Unable To Click ON ELEMENT");
					}

				}
				catch (ElementNotInteractableException e)
				{
					logger.error("Element Not Clickable Exception has occurred.. Locating element again ");
					try
					{
						moveToElementAndClick(driver, by);
					}
					catch (Exception exx)
					{
						throw new ActionBotException("\n Exception in Click Method While performing click on " + by.toString() + " => \n" + exx, exx);
					}
				}
				catch (StaleElementReferenceException ex)
				{
					logger.error("Stale Element Reference Exception has occurred.. Locating element again ");
					try
					{
						defaultSleep();
						element = findElement(driver, by);
						if (element != null)
						{
							element.click();
						}
						else
						{
							logger.error("Element is Null Hence Unable To Click ON ELEMENT : ");
						}
					}
					catch (Exception exx)
					{
						throw new ActionBotException("\n Exception in Click Method While performing click on " + by.toString() + " => \n" + exx, exx);
					}
				}
				catch (Exception e)
				{
					throw new ActionBotException("\n Exception in Click Method While performing click on " + by.toString() + " =>\n" + e, e);

				}
			}
			else
			{
				logger.error("Element is not displayed : " + by);
			}
		}
		catch (Exception e)
		{
			logger.error("Element is Not enabled : ");
			throw new ActionBotException("\n Exception in Click Method While performing click on " + by.toString() + " =>\n" + e, e);
		}
	}

	/**
	 * Method that clicks the element after fluently waiting for it
	 * 
	 * @author owais.iqbal
	 * @param driver
	 * @param by
	 * @throws ActionBotException
	 * @throws InterruptedException
	 * @throws Exception
	 */
	public static void click(WebDriver driver, UI_Elements uiElements) throws ActionBotException
	{
		WebElement element;
		String error = getError(uiElements);
		element = waitForElementToBeDisplayed(driver, uiElements, timeOut);
		if (element != null)
		{
			try
			{
				element = waitForElementToBeEnable(driver, uiElements, timeOut);
				if (element != null)
				{
					try
					{
						element.click();

					}
					catch (ElementNotInteractableException e)
					{
						logger.error("Element Not Clickable Exception has occurred.. Locating element again ");
						try
						{
							moveToElementAndClick(driver, uiElements);
						}
						catch (Exception exx)
						{
							throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + error + " \n" + exx, exx);
						}
					}
				}
				else
				{
					logger.error("Element is Null Hence Unable To Click ON ELEMENT : " + error);
				}
			}
			catch (StaleElementReferenceException ex)
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				try
				{
					element = findElement(driver, uiElements);
					if (element != null)
					{
						element.click();
					}
					else
					{
						logger.error("Element is Null Hence Unable To Click ON ELEMENT : " + error);
					}
				}
				catch (Exception exx)
				{
					throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + error + " \n" + exx, exx);
				}
			}
			catch (Exception e)
			{
				throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + error + " \n" + e, e);
			}
		}
		else

		{
			System.out.println("Element is not displayed " + uiElements);
		}
	}

	/**
	 * @author owais.iqbal
	 * @param driver
	 * @param element
	 * @param by
	 * @throws ActionBotException
	 */
	public static void click(WebDriver driver, WebElement element, UI_Elements uiElements) throws ActionBotException
	{
		String error = getError(uiElements);
		try
		{
			WaitUtil.getElementUsingFluentWait(driver, uiElements.getBy());
			WebElement el = element.findElement(uiElements.getBy());
			el.click();

			// to print http request/response
			// HttpClientUtilities.printRequestResponse(driver.getCurrentUrl());

		}
		catch (ElementNotInteractableException e)
		{
			logger.error("Element Not Clickable Exception has occurred.. Locating element again ");
			try
			{
				moveToElementAndClick(driver, uiElements);
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + error + " \n" + exx, exx);
			}
		}
		catch (StaleElementReferenceException ex)
		{
			logger.error("Stale Element Reference Exception has occurred... Locating element again... ");
			try
			{
				WaitUtil.getElementUsingFluentWait(driver, uiElements.getBy());
				WebElement el = element.findElement(uiElements.getBy());
				el.click();
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + error + " \n" + exx, exx);
			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Click Method While performing click on  " + " =>" + error + " \n" + e, e);
		}
	}

	public static void click(WebDriver driver, WebElement element, By by) throws ActionBotException
	{
		String error = "Element is not visible";
		try
		{
			WaitUtil.getElementUsingFluentWait(driver, by);
			WebElement el = element.findElement(by);
			el.click();

			// to print http request/response
			// HttpClientUtilities.printRequestResponse(driver.getCurrentUrl());

		}
		catch (ElementNotInteractableException e)
		{
			logger.error("Element Not Clickable Exception has occurred.. Locating element again ");
			try
			{
				WaitUtil.getElementUsingFluentWait(driver, by);
				WebElement e1 = element.findElement(by);
				if (e1 != null)
				{
					e1.click();
				}
				else
				{
					logger.error("Element is Null Hence Unable To Click ON ELEMENT");
				}
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + error + " \n" + exx, exx);
			}
		}
		catch (StaleElementReferenceException ex)
		{
			logger.error("Stale Element Reference Exception has occurred... Locating element again.. ");
			try
			{
				WaitUtil.getElementUsingFluentWait(driver, by);
				WebElement el = element.findElement(by);
				el.click();
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in Click Method While performing click on " + by.toString() + " =>" + error + " \n" + exx, exx);
			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Click Method While performing click on " + by.toString() + " =>" + error + " \n" + e, e);
		}
	}

	public static void clickUntilDisplay(WebDriver driver, String waitTillInSec, By clicklocator, By waitTillLocator) throws ActionBotException, Exception
	{

		WebElement element;
		try
		{
			Long waittill = System.currentTimeMillis() + Long.parseLong(waitTillInSec) * 1000 * 60;
			while (waittill > System.currentTimeMillis() && !driver.findElement(waitTillLocator).isDisplayed())
			{
				try
				{
					element = driver.findElement(clicklocator);
					element.click();
					continue;
				}
				catch (StaleElementReferenceException ex)
				{
					logger.error("Stale Element Reference Exception has occurred... Locating element again.. ");
					try
					{
						element = driver.findElement(clicklocator);
						element.click();
						continue;
					}
					catch (Exception exx)
					{
						throw new ActionBotException("\n Exception in clickUntilDisplay Method While performing click on " + clicklocator + " => \n" + exx, exx);
					}
				}
			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Click Method While performing click on " + clicklocator + " => \n" + e, e);
		}

		// to print http request/response
		// HttpClientUtilities.printRequestResponse(driver.getCurrentUrl());

	}

	public static void clickUntilDisplay(WebDriver driver, String waitTillInSec, WebElement clicklocator, By waitTillLocator) throws ActionBotException, Exception
	{

		Long waittill = System.currentTimeMillis() + Long.parseLong(waitTillInSec) * 1000 * 60;
		while (waittill > System.currentTimeMillis() && !driver.findElement(waitTillLocator).isDisplayed())
		{
			clicklocator.click();
			continue;

		}

		// to print http request/response
		// HttpClientUtilities.printRequestResponse(driver.getCurrentUrl());

	}

	public static void defaultHighSleep()
	{
		ActionBot.threadSleep(defaultHighSleep);
	}

	public static void defaultLowSleep()
	{
		ActionBot.threadSleep(2);
	}

	public static void defaultMediumSleep()
	{
		ActionBot.threadSleep(defaultMediumSleep);
	}

	public static void defaultSleep()
	{
		threadSleep(defaultSleep);
	}

	// Puneet

	public static void doubleClick(WebDriver driver, UI_Elements uiElements) throws ActionBotException
	{
		WebElement element;
		String error = getError(uiElements);
		try
		{
			element = findElement(driver, uiElements);
			if (element != null)
			{
				element.click();
				defaultSleep();
				element.click();
			}
			else
			{
				logger.error("Element is Null Hence Unable To Click" + error);
			}
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.info("Element is Found To Be Stale Hence Finding it Again");
				defaultSleep();
				element = findElement(driver, uiElements);
				defaultSleep();
				if (element != null)
				{
					element.click();
				}
				else
				{
					logger.error("Element is Null Hence Unable To Click" + error);
				}
			}
			catch (Exception e1)
			{
				throw new ActionBotException("\n Exception in Double Click Method While performing click on " + " =>" + error + " \n" + e, e);

			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Double Click Method While performing click on " + " =>" + error + " \n" + e, e);
		}
	}

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b>returns status of driver if driver is
	 * available screenshot is taken and then status is returned <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param by
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static boolean driverStatus(WebDriver driver, String methodName)
	{
		boolean driverStat = false;
		try
		{
			driver.getTitle();

			if (driver != null)
			{
				driverStat = true;
			}
		}
		catch (SessionNotCreatedException e)
		{
			logger.info("WebDriver is Not Avaliable To Proceed for ".toUpperCase() + methodName);
			driverStat = false;
		}
		catch (Exception a)
		{
			logger.info("WebDriver is Not Avaliable To Proceed for ".toUpperCase() + methodName);
			driverStat = false;
		}
		return driverStat;
	}

	public static WebElement findElement(WebDriver driver, By by) throws ActionBotException
	{
		try
		{
			return waitForElementToBeDisplayed(driver, by, timeOut);
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				return waitForElementToBeDisplayed(driver, by, timeOut);
			}
			catch (Exception e1)
			{
				throw new ActionBotException("\n Exception in findElement Method While finding element " + " =>" + by.toString() + " \n" + e, e);

			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Find Element Method While Finding " + by.toString() + " => \n" + e, e);
		}
	}

	/**
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param by
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 * 
	 * @throws ActionBotException
	 */
	public static WebElement findElement(WebDriver driver, final UI_Elements uiElements) throws ActionBotException // throws
																													// ActionBotException
	{
		String error = getError(uiElements);
		try
		{
			return waitForElementToBeDisplayed(driver, uiElements, timeOut);
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				return waitForElementToBeDisplayed(driver, uiElements, timeOut);
			}
			catch (Exception e1)
			{
				throw new ActionBotException("\n Exception in findElement Method While finding element " + " =>" + error + " \n" + e, e);
			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Find Element Method While Finding " + error + " => \n" + e, e);
		}

	}

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> will return list of elements using by
	 * 
	 * @throws ActionBotException
	 */
	public static List<WebElement> findElements(WebDriver driver, UI_Elements uiElements) throws ActionBotException
	{
		By by = uiElements.getBy();
		String error = getError(uiElements);
		List<WebElement> elements = null;
		try
		{
			elements = driver.findElements(by);
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				elements = driver.findElements(by);
			}
			catch (Exception e1)
			{
				throw new ActionBotException("\n Exception in findElements Method While finding " + " =>" + error + " \n" + e, e);
			}
		}
		return elements;
	}

	public static List<WebElement> findElements(WebDriver driver, By by) throws ActionBotException
	{

		List<WebElement> elements = null;
		try
		{
			elements = driver.findElements(by);
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				elements = driver.findElements(by);
			}
			catch (Exception e1)
			{
				throw new ActionBotException("\n Exception in findElements Method While finding  " + by.toString() + " => \n" + e, e);
			}
		}
		return elements;
	}

	public static WebElement getElement(WebDriver driver, UI_Elements uiElements) throws ActionBotException, Exception
	{
		By by = uiElements.getBy();
		return WaitUtil.getElementUsingFluentWait(driver, by);
	}

	public static WebElement getElement(WebDriver driver, By by) throws ActionBotException, Exception
	{
		return WaitUtil.getElementUsingFluentWait(driver, by);
	}

	public static int getElementListSize(WebDriver driver, UI_Elements uiElements) throws ActionBotException
	{
		String error = getError(uiElements);
		try
		{
			List<WebElement> elements = findElements(driver, uiElements);
			return elements.size();
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				return findElements(driver, uiElements).size();
			}
			catch (Exception e1)
			{
				throw new ActionBotException("\n Exception in getElementListSize Method While finding  " + error + " => \n" + e, e);
			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in getElementListSize Method on  " + " =>" + error + " \n" + e, e);
		}
	}

	/**
	 * Method that waits for the entire list to load once you specify the size
	 * of the list
	 * 
	 * @author owais.iqbal
	 * @param driver
	 * @param by
	 * @param size
	 * @return
	 * @throws ActionBotException
	 */
	public static List<WebElement> getElementListWithSize(WebDriver driver, UI_Elements uiElements, int size)
	{
		List<WebElement> list = new ArrayList<WebElement>();
		StringBuffer buffer = new StringBuffer();
		do
		{
			try
			{
				list = driver.findElements(uiElements.getBy());
			}
			catch (NoSuchElementException e)
			{
				buffer.append(e);
			}
			catch (NullPointerException e)
			{
				buffer.append(e);
			}
			catch (WebDriverException e)
			{
				buffer.append(e);
			}
			if (list == null)
			{
				list = new ArrayList<WebElement>();
			}
		} while (list.size() < size);

		if (!buffer.equals(""))
		{
			logger.debug("Exceptions caught:-" + buffer);
		}
		return list;
	}

	private static String getError(UI_Elements uiElements)
	{
		return "\n \t " + uiElements.getKey() + " : " + uiElements.getBy().toString() + " in File " + uiElements.getFileName() + "  |  ";
	}

	/**
	 * 
	 * <b>created On : </b>26-Jun-2014 : 5:24:28 pm<br>
	 * <font size="2" color="black"><b>author : </b> puneet.sharma<br>
	 * </font> <font size="2" color="black"><b>method Name : </b>
	 * getTextWithInElement<br>
	 * </font> <font size="2" color="red"><b>method Description : </b> </font>
	 * <br>
	 * <font size="2" color="black"><b>return Type : </b>String <br>
	 * <font size="2" color="blue"><b>assertion : </b> </font><br>
	 * 
	 * @param driver
	 *        </font><br>
	 * @param by
	 *        </font><br>
	 * @return
	 * 
	 * @throws ActionBotException
	 */
	public static String getTextWithInElement(WebDriver driver, UI_Elements uiElements) throws ActionBotException
	{
		String error = getError(uiElements);
		String strValue = null;
		try
		{
			WebElement element = ActionBot.findElement(driver, uiElements);
			strValue = element.getText().trim();
			if (strValue == null || strValue.length() <= 0)
			{
				strValue = element.getAttribute("value").trim();
				if (strValue == null || strValue.length() <= 0)
				{
					strValue = null;
				}
			}
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				WebElement element = ActionBot.findElement(driver, uiElements);
				strValue = element.getText().trim();
				if (strValue == null || strValue.length() <= 0)
				{
					strValue = element.getAttribute("value").trim();
					if (strValue == null || strValue.length() <= 0)
					{
						strValue = null;
					}
				}
			}
			catch (Exception e1)
			{
				throw new ActionBotException("\n Exception in getTextWithInElement Method While finding  " + error + " => \n" + e, e);
			}
		}
		catch (Exception e)
		{
			logger.error(error + e, e);
		}
		return strValue;
	}

	public static String getTextWithInElement(WebDriver driver, WebElement element) throws ActionBotException
	{

		String strValue = null;
		try
		{
			if (element.getText() != null && element.getText().length() > 0)
			{
				strValue = element.getText().trim();
				if (strValue == null || strValue.length() <= 0)
				{
					strValue = element.getAttribute("value").trim();
					if (strValue == null || strValue.length() <= 0)
					{
						strValue = null;
					}
				}
			}
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				strValue = element.getText().trim();
				if (strValue == null || strValue.length() <= 0)
				{
					strValue = element.getAttribute("value").trim();
					if (strValue == null || strValue.length() <= 0)
					{
						strValue = null;
					}
				}
			}
			catch (Exception e1)
			{
				throw new ActionBotException("\n Exception in getTextWithInElement Method While finding" + e, e);
			}
		}
		catch (Exception e)
		{
			logger.error(e);
		}
		return strValue;
	}

	/**
	 * 
	 * <b>created On : </b>26-Jun-2014 : 5:24:28 pm<br>
	 * <font size="2" color="black"><b>author : </b> puneet.sharma<br>
	 * </font> <font size="2" color="black"><b>method Name : </b>
	 * getTextWithInElement<br>
	 * </font> <font size="2" color="red"><b>method Description : </b> </font>
	 * <br>
	 * <font size="2" color="black"><b>return Type : </b>String <br>
	 * <font size="2" color="blue"><b>assertion : </b> </font><br>
	 * 
	 * @param driver
	 *        </font><br>
	 * @param by
	 *        </font><br>
	 * @return
	 * 
	 * @throws ActionBotException
	 */
	public static String getTextWithInElement(WebDriver driver, By by) throws ActionBotException
	{
		String strValue = null;
		try
		{
			WebElement element = ActionBot.getElement(driver, by);
			strValue = element.getText().trim();
			if (strValue == null || strValue.length() <= 0)
			{
				if (element.getAttribute("value") != null)
					strValue = element.getAttribute("value").trim();
				if (strValue == null || strValue.length() <= 0)
				{
					strValue = null;
				}
			}
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				WebElement element = ActionBot.getElement(driver, by);
				strValue = element.getText().trim();
				if (strValue == null || strValue.length() <= 0)
				{
					strValue = element.getAttribute("value").trim();
					if (strValue == null || strValue.length() <= 0)
					{
						strValue = null;
					}
				}
			}
			catch (Exception e1)
			{
				throw new ActionBotException("\n Exception in getTextWithInElement Method while retrieving text from element  " + by.toString() + " => \n" + e, e);
			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in getTextWithInElement Method while retrieving text from element  " + by.toString() + " => \n" + e, e);
		}
		return strValue;
	}

	public static void halt()
	{
		try
		{
			TimeUnit.MILLISECONDS.sleep(500);
		}
		catch (Exception e)
		{
			logger.error("Error When Sleep Action is Preform");
		}
	}

	/**
	 * @author owais.iqbal
	 * @param driver
	 * @param by
	 * @throws ActionBotException
	 */
	public static void hover(WebDriver driver, UI_Elements uiElements) throws ActionBotException
	{
		getError(uiElements);
		try
		{
			WebElement element = ActionBot.findElement(driver, uiElements);
			Locatable hoverItem = (Locatable) element;
			Mouse mouse = ((HasInputDevices) driver).getMouse();
			mouse.mouseMove(hoverItem.getCoordinates());
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				WebElement element = ActionBot.findElement(driver, uiElements);
				Locatable hoverItem = (Locatable) element;
				Mouse mouse = ((HasInputDevices) driver).getMouse();
				mouse.mouseMove(hoverItem.getCoordinates());
			}
			catch (Exception e1)
			{
				throw new ActionBotException("\n Exception in Hover Method While performing hover on  " + uiElements.getBy() + " => \n" + e, e);
			}
		}
		catch (Exception e)
		{
			logger.info("Exception in Hover Method While performing hover on " + e, e);
		}
	}

	public static void hover(WebDriver driver, By by)
	{
		try
		{
			WebElement element = ActionBot.findElement(driver, by);
			Locatable hoverItem = (Locatable) element;
			Mouse mouse = ((HasInputDevices) driver).getMouse();
			mouse.mouseMove(hoverItem.getCoordinates());
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				WebElement element = ActionBot.findElement(driver, by);
				Locatable hoverItem = (Locatable) element;
				Mouse mouse = ((HasInputDevices) driver).getMouse();
				mouse.mouseMove(hoverItem.getCoordinates());
			}
			catch (Exception e1)
			{
				logger.error("Exception in Hover Method While performing hover on " + by.toString() + " => \n" + e, e);
			}
		}
		catch (ActionBotException e)
		{
			logger.error("Exception in Hover Method While performing hover on " + by.toString() + " => \n" + e, e);
		}
	}

	/**
	 * @author owais.iqbal
	 * @param driver
	 * @param element
	 * @throws ActionBotException
	 */
	public static void hover(WebDriver driver, WebElement element)
	{
		try
		{
			Locatable hoverItem = (Locatable) element;
			Mouse mouse = ((HasInputDevices) driver).getMouse();
			mouse.mouseMove(hoverItem.getCoordinates());
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				Locatable hoverItem = (Locatable) element;
				Mouse mouse = ((HasInputDevices) driver).getMouse();
				mouse.mouseMove(hoverItem.getCoordinates());
			}
			catch (Exception e1)
			{
				logger.error("Exception in Hover Method While performing hover on " + element.toString() + " => \n" + e, e);
			}
		}
	}

	/**
	 * Method that inputs text into the element found inside the element passed
	 * as a parameter @author Puneet Sharma @param driver @param element @param
	 * by @param text @throws ActionBotException @throws
	 * ActionBotException @throws
	 */
	public static void inputText(WebDriver driver, WebElement element, UI_Elements uiElements, String text) throws ActionBotException
	{
		String error = getError(uiElements);
		try
		{
			WaitUtil.getElementUsingFluentWait(driver, uiElements.getBy());
			WebElement el = element.findElement(uiElements.getBy());
			el.clear();
			el.sendKeys(text);
		}
		catch (TestCaseException e)
		{
			throw new ActionBotException(error + e.toString(), e);
		}
		catch (Exception e)
		{
			throw new ActionBotException(error + e.toString(), e);
		}
	}

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param by
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 * 
	 * @throws ActionBotException
	 */
	public static boolean isAlertPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e)
		{
			logger.error("Alert Not Found");
		}
		return false;

	}

	public static boolean isElementDisplayed(WebDriver driver, By by) throws ActionBotException
	{
		boolean status = false;
		WebElement element;
		String error = by.toString();
		try
		{
			element = driver.findElement(by);
			if (element.isDisplayed())
			{
				status = true;
				logger.info("Element " + error + "  is Visible ");
			}
			else
			{
				logger.info("Element " + error + "  is Invisible ");
			}
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				element = driver.findElement(by);
				if (element.isDisplayed())
				{
					status = true;
					logger.info("Element " + error + "  is Visible ");
				}
				else
				{
					logger.info("Element " + error + "  is Invisible ");
				}
			}
			catch (Exception e1)
			{
				logger.error("Error While Verifying The Visibiliy Of Element " + error + " => \n" + e, e);
			}
		}
		catch (Exception e)
		{
			status = false;
			logger.info("\n Error While Verifying The Visibiliy Of Element   =>" + error + " \n");
		}
		return status;
	}

	public static boolean isElementDisplayed(WebDriver driver, UI_Elements uiElements) throws ActionBotException
	{
		boolean status = false;
		WebElement element;
		By by = uiElements.getBy();
		String error = getError(uiElements);
		try
		{
			element = driver.findElement(by);
			if (element.isDisplayed())
			{
				status = true;
			}
			else
			{
				logger.info("Element " + error + "  is Invisible ");
			}
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				element = driver.findElement(by);
				if (element.isDisplayed())
				{
					status = true;
					logger.info("Element " + error + "  is Visible ");
				}
				else
				{
					logger.info("Element " + error + "  is Invisible ");
				}
			}
			catch (Exception e1)
			{
				logger.error("Error While Verifying The Visibiliy Of Element " + error + " => \n" + e, e);
			}
		}
		catch (Exception e)
		{
			status = false;
			logger.info("\n Error While Verifying The Visibiliy Of Element   =>" + error + " \n");
		}
		return status;
	}

	public static boolean isElementPresent(WebDriver driver, UI_Elements uiElements) throws ActionBotException
	{
		boolean status = false;
		WebElement element;
		By by = uiElements.getBy();
		String error = getError(uiElements);
		try
		{
			element = driver.findElement(by);
			if (element.isDisplayed())
			{
				status = true;
			}
			else
			{
				logger.info("Element " + error + "  is Absent ");
			}
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				element = driver.findElement(by);
				if (element.isDisplayed())
				{
					status = true;
					logger.info("Element " + error + "  is Present ");
				}
				else
				{
					logger.info("Element " + error + "  is Absent ");
				}
			}
			catch (Exception e1)
			{
				logger.error("Error While Verifying The Visibiliy Of Element " + error + " => \n" + e, e);
			}
		}
		catch (Exception e)
		{
			status = false;
			logger.info("\n Error While Verifying The Visibiliy Of Element   =>" + error + " \n");
		}
		return status;
	}

	public static boolean isElementSelected(WebDriver driver, By by) throws ActionBotException
	{
		boolean status = false;
		WebElement element;
		String error = by.toString();
		try
		{
			element = driver.findElement(by);
			if (element.isSelected())
			{
				status = true;
				logger.info("Element " + error + "  is Selected ");
			}
			else
			{
				logger.info("Element " + error + "  is Not Selected ");
			}
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				element = driver.findElement(by);
				if (element.isSelected())
				{
					status = true;
					logger.info("Element " + error + "  is Selected ");
				}
				else
				{
					logger.info("Element " + error + "  is Not Selected ");
				}
			}
			catch (Exception e1)
			{
				logger.error("Error While Verifying whether element is selected " + error + " => \n" + e, e);
			}
		}
		catch (Exception e)
		{
			status = false;
			logger.info("\n Error While Verifying whether element is selected   =>" + error + " \n");
		}
		return status;
	}

	public static boolean isElementSelected(WebDriver driver, UI_Elements uiElements) throws ActionBotException
	{
		boolean status = false;
		WebElement element;
		By by = uiElements.getBy();
		String error = by.toString();
		try
		{
			element = driver.findElement(by);
			if (element.isSelected())
			{
				status = true;
				logger.info("Element " + error + "  is Selected ");
			}
			else
			{
				status = false;
				logger.info("Element " + error + "  is Not Selected ");
			}
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				element = driver.findElement(by);
				if (element.isSelected())
				{
					status = true;
					logger.info("Element " + error + "  is Selected ");
				}
				else
				{
					logger.info("Element " + error + "  is Not Selected ");
				}
			}
			catch (Exception e1)
			{
				logger.error("Error While Verifying whether element is selected " + error + " => \n" + e, e);
			}
		}
		catch (Exception e)
		{
			status = false;
			logger.info("\n Error While Verifying whether element is selected   =>" + error + " \n");
		}
		return status;
	}

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param by
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static String returnKeyValuePair(String str) throws NullPointerException
	{
		String keyValuePair = null;

		keyValuePair = ConfigProperty.getConfig(str.trim());
		if (keyValuePair == null)
		{
			logger.error("VALUE CORRESPONDING TO THE KEY " + str + " DOES NOT FOUND");
			return null;
		}
		return keyValuePair;
	}

	public static void scroll(WebDriver driver)
	{
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300);");
	}

	public static void scroll(WebDriver driver, String value)
	{
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + value + ");");
	}

	public static void scrollUp(WebDriver driver, String value)
	{
		((JavascriptExecutor) driver).executeScript("window.scrollBy(" + value + ",0);");
	}

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param by
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static void scroll(WebDriver driver, WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Pass the jQuery selector as a String and the amount by which you want to
	 * scroll
	 * 
	 * @param driver
	 * @param jQuerySelector
	 * @param scrollAmount
	 *
	 *        <br />
	 *        Example : jQueryScroll(driver, ".eformItemInpt.ui-front", 500)
	 * 
	 *        where <i>.eformItemInpt.ui-front</i> is converted to
	 *        <i>jQuery(".eformItemInpt.ui-front")</i>
	 * 
	 * 
	 * @author amitkumar.dash
	 */
	public static void jQueryScroll(WebDriver driver, String jQuerySelector, int scrollAmount)
	{
		((JavascriptExecutor) driver).executeScript("$(\"" + jQuerySelector + "\").scrollTop(" + scrollAmount + ")");
	}

	/**
	 * Method that inputs text into the element given by the locator
	 * 
	 * @author aparna.kanavaje
	 * @param driver
	 * @param by
	 * @param text
	 * @return
	 * @throws ActionBotException
	 * @throws Exception
	 */
	public static String sendKeys(WebDriver driver, By by, String text) throws ActionBotException
	{
		String value = null;
		WebElement element = null;
		try
		{
			element = findElement(driver, by);
			element.clear();
			element.sendKeys(text);
			value = element.getAttribute("value");
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				element = findElement(driver, by);
				element.clear();
				element.sendKeys(text);
				value = element.getAttribute("value");
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in SENDKEYS while tying on " + " =>" + by.toString() + " \n" + exx, exx);
			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("EXCEPTION IN SENDKEYS " + e, e);
		}
		return value;
	}

	/**
	 * Method that inputs text into the element given by the locator
	 * 
	 * @author owais.iqbal
	 * @param driver
	 * @param by
	 * @param text
	 * @throws ActionBotException
	 * @throws Exception
	 */
	public static String sendKeys(WebDriver driver, UI_Elements uiElements, String text) throws ActionBotException
	{
		String error = getError(uiElements);
		WebElement element = null;
		String value = null;
		try
		{
			element = findElement(driver, uiElements);
			element.clear();
			element.sendKeys(text);
			value = element.getAttribute("value");
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				element = findElement(driver, uiElements);
				element.clear();
				element.sendKeys(text);
				value = element.getAttribute("value");
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in SENDKEYS while tying on " + " =>" + error + " \n" + exx, exx);
			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("EXCEPTION IN SENDKEYS " + error + e, e);
		}
		return value;
	}

	public static void threadSleep(int sleepTimeInSec)
	{
		try
		{
			// Long sleep = (long) (sleepTimeInSec * 1000);
			Thread.sleep(sleepTimeInSec * 1000);
		}
		catch (Exception e)
		{
			logger.error("Error When Sleep Action is Preform");
		}
	}

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> Accept A Parameter in String to and apply
	 * thread.sleep onto it in sec ,2 = 2sec <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param sleepTime
	 *        </font><b><br>
	 * @throws InterruptedException
	 *         </b> <br>
	 * 
	 */
	public static void threadSleep(String sleepTimeInSec)
	{
		try
		{
			Long sleep = (long) (Integer.parseInt(sleepTimeInSec) * 1000);
			// Long sleep = (long) (Integer.parseInt(sleepTimeInSec));
			Thread.sleep(sleep);
		}
		catch (Exception e)
		{
			logger.error("Error When Sleep Action is Preform");
		}
	}

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> will used to make uppercase of statements
	 */
	public static String upperCase(String str) throws Exception
	{
		return str.toUpperCase();
	}

	/**
	 * Method that halts the execution for the desired milliseconds.
	 * 
	 * @param milliseconds
	 */
	public static void waitForOperations(long milliseconds)
	{
		long currentTime, elapsedTime;
		currentTime = System.currentTimeMillis();
		do
		{
			elapsedTime = System.currentTimeMillis() - currentTime;
		} while (elapsedTime < milliseconds);

	}

	public static void waitTillPopUpIsPresent(WebDriver driver, UI_Elements uiElements) throws ActionBotException
	{
		String error = getError(uiElements);
		By by = uiElements.getBy();
		try
		{
			new WebDriverWait(driver, Integer.parseInt(defaultHighSleep)).until(ExpectedConditions.presenceOfElementLocated(uiElements.getBy()));
			long startTime = System.currentTimeMillis();
			long elapsedTime;
			while (isElementPresent(driver, by))
			{
				if (!isElementPresent(driver, by))
				{
					break;
				}
				elapsedTime = System.currentTimeMillis() - startTime;
				if (elapsedTime > Integer.parseInt(defaultHighSleep) * 100)
				{
					break;
				}
				continue;
			}
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				long startTime = System.currentTimeMillis();
				long elapsedTime;
				while (isElementPresent(driver, by))
				{
					if (!isElementPresent(driver, by))
					{
						break;
					}
					elapsedTime = System.currentTimeMillis() - startTime;
					if (elapsedTime > Integer.parseInt(defaultHighSleep) * 100)
					{
						break;
					}
					continue;
				}
			}
			catch (Exception exx)
			{
				logger.info("\n Error While Verifying pop up is present or not   =>" + error + " \n");
			}
		}
		catch (Exception e)
		{
			logger.info("\n Error While Verifying pop up is present or not   =>" + error + " \n");
		}
	}

	public static void waitTillPopUpIsPresent(WebDriver driver, By by) throws ActionBotException
	{
		try
		{
			// changes for decreasing execution time
			// defaultSleep();
			new WebDriverWait(driver, Integer.parseInt(defaultHighSleep)).until(ExpectedConditions.presenceOfElementLocated(by));

			long startTime = System.currentTimeMillis();
			long elapsedTime;
			while (isElementPresent(driver, by))
			{
				if (!isElementPresent(driver, by))
				{
					break;
				}
				elapsedTime = System.currentTimeMillis() - startTime;
				if (elapsedTime > Integer.parseInt(defaultHighSleep) * 100)
				{
					break;
				}
				continue;
			}
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				long startTime = System.currentTimeMillis();
				long elapsedTime;
				while (isElementPresent(driver, by))
				{
					if (!isElementPresent(driver, by))
					{
						break;
					}
					elapsedTime = System.currentTimeMillis() - startTime;
					if (elapsedTime > Integer.parseInt(defaultHighSleep) * 100)
					{
						break;
					}
					continue;
				}
			}
			catch (Exception exx)
			{
				logger.info("\n Error While Verifying pop up is present or not   =>" + by.toString() + " \n");
			}
		}
		catch (Exception e)
		{
			logger.info("\n Error While Verifying pop is present or not   =>" + by.toString() + " \n");
		}
	}

	public static boolean isElementPresent(WebDriver driver, By by) throws ActionBotException
	{
		boolean status = false;

		String ele = by.toString();
		try
		{
			WebElement element = driver.findElement(by);
			if (element.isDisplayed())
			{
				status = true;
			}
			else
			{
				logger.info("Element " + ele + "  is Absent ");
			}
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				WebElement element = driver.findElement(by);
				if (element.isDisplayed())
				{
					status = true;
				}
				else
				{
					logger.info("Element " + ele + "  is Absent ");
				}
			}
			catch (Exception exx)
			{
				status = false;
				logger.info("\n Error While Verifying Visibility of Element   =>" + by.toString() + " \n");
			}
		}
		catch (Exception e)
		{
			status = false;
			logger.info("\n Error While Verifying Visibility of Element   =>" + by.toString() + " \n");
		}
		return status;
	}

	/**
	 * 
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Used to Clear the text Field <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param by
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 * 
	 * @return
	 * @throws TestCaseException
	 * @throws ActionBotException
	 */
	public static void clear(WebDriver driver, By by) throws TestCaseException
	{
		WebElement element = null;
		try
		{
			element = WaitUtil.getElementUsingFluentWait(driver, by);
			element.clear();
		}
		catch (StaleElementReferenceException ex)
		{
			logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
			try
			{
				element = WaitUtil.getElementUsingFluentWait(driver, by);
				element.clear();
			}
			catch (Exception exx)
			{
				throw new TestCaseException("\n Exception in clear Method While performing clear on " + " =>" + by.toString() + " \n" + exx, exx);
			}
		}
		catch (Exception e)
		{
			throw new TestCaseException("\n Exception in clear Method While performing clear on " + " =>" + by.toString() + " \n" + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To get list of text <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param ui_Elements
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	public static List<String> getListOfText(WebDriver driver, UI_Elements ui_Elements) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, ui_Elements);
		List<String> listOfText = new ArrayList<String>();

		for (WebElement ele : elements)
		{
			listOfText.add(ele.getText().trim());
		}

		return listOfText;
	}

	/**
	 * <b>Author: omkar.jagdale </b> <b><br>
	 * <font color="blue">Method :</b> To get list of text <br>
	 */
	public static List<String> getListOfText(WebDriver driver, By by) throws ActionBotException
	{
		List<WebElement> elements = ActionBot.findElements(driver, by);
		List<String> listOfText = new ArrayList<String>();

		for (WebElement ele : elements)
		{
			listOfText.add(ele.getText().trim());
		}

		return listOfText;
	}

	/**
	 * Method that inputs text into the element found inside the element passed
	 * as a parameter @author Puneet Sharma @param driver @param element @param
	 * by @param text @throws ActionBotException @throws
	 * ActionBotException @throws
	 */
	public static void inputText(WebDriver driver, WebElement element, By by, String text) throws ActionBotException
	{
		try
		{
			WaitUtil.getElementUsingFluentWait(driver, by);
			WebElement el = element.findElement(by);
			el.clear();
			el.sendKeys(text);
		}
		catch (TestCaseException e)
		{
			throw new ActionBotException(e.toString(), e);
		}
		catch (Exception e)
		{
			throw new ActionBotException(e.toString(), e);
		}
	}

	public static String selectElement(WebDriver driver, UI_Elements uiElements, String selectBy, String value) throws ActionBotException
	{
		String error = getError(uiElements);
		String selectedOption = null;
		Select select = null;
		try
		{
			select = new Select(ActionBot.findElement(driver, uiElements));
			if (selectBy != null)
			{
				if (selectBy.equalsIgnoreCase(IConstantsData.SELECT_BY_VALUE))
				{
					select.selectByValue(value);
				}
				else if (selectBy.equalsIgnoreCase(IConstantsData.SELECT_BY_INDEX))
				{
					select.selectByIndex(Integer.parseInt(value));
				}
				else if (selectBy.equalsIgnoreCase(IConstantsData.SELECT_BY_VISIBLE_TEXT))
				{
					select.selectByVisibleText(value);
				}
				else if (selectBy.equalsIgnoreCase(IConstantsData.SELECT_BY_PARTIAL_VISIBLE_TEXT))
				{
					for (WebElement options : select.getOptions())
					{
						// System.out.println("Option : " +
						// options.getText().trim());
						if (options.getText().trim().contains(value))
						{
							options.click();
							break;
						}
					}
				}
				else
				{
					logger.info("Invalid Select By option selected");
				}
			}
			selectedOption = select.getFirstSelectedOption().getText().trim();
			logger.info("Selected Option : " + selectedOption);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Select Method While selecting  " + uiElements.getBy().toString() + " =>" + error + " \n" + e, e);
		}
		return selectedOption;
	}

	public static String selectElement(WebDriver driver, WebElement element, String selectBy, String value) throws ActionBotException
	{
		String selectedOption = null;
		Select select = null;
		try
		{
			select = new Select(element);
			if (selectBy != null)
			{
				if (selectBy.equalsIgnoreCase(IConstantsData.SELECT_BY_VALUE))
				{
					select.selectByValue(value);
				}
				else if (selectBy.equalsIgnoreCase(IConstantsData.SELECT_BY_INDEX))
				{
					select.selectByIndex(Integer.parseInt(value));
				}
				else if (selectBy.equalsIgnoreCase(IConstantsData.SELECT_BY_VISIBLE_TEXT))
				{
					select.selectByVisibleText(value);
				}
				else
				{
					logger.info("Invalid Select By option selected");
				}
			}
			selectedOption = select.getFirstSelectedOption().getText().trim();
			logger.info("Selected Option : " + selectedOption);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Select Method While selecting  " + element + " =>" + " \n" + e, e);
		}
		return selectedOption;
	}

	public static String fillAutoCompleteField(WebDriver driver, UI_Elements uiElements, String value) throws ActionBotException
	{
		String error = getError(uiElements), enteredValue = null;
		WebElement element = null;
		try
		{
			element = ActionBot.findElement(driver, uiElements);
			element.clear();
			ActionBot.defaultSleep();
			element.sendKeys(value);
			ScreenShot.screenshot(driver, "", "after sending value to autoComplete Field. Value " + value);
			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultSleep();
			waitForElementToBePresent1(driver, By.xpath(".//*[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content'][contains(@style,'display: block')]/li"));
			// waitForElementToBePresent(driver,
			// By.xpath(".//li[contains(@class,'ui-menu-item')]"));
			waitForPageLoad(driver);
			ActionBot.defaultSleep();
			// ActionBot.defaultMediumSleep();
			// ActionBot.defaultHighSleep();
			element.sendKeys(Keys.ARROW_DOWN);

			ActionBot.defaultSleep();

			// ActionBot.defaultSleep();
			element.sendKeys(Keys.ENTER);
			ActionBot.defaultSleep();

			// Thread.sleep(1000);

			/*
			 * List<WebElement> elements = ActionBot.findElements(driver,
			 * By.xpath(".//li[contains(@class,'ui-menu-item')]")); for
			 * (WebElement element2 : elements) { if
			 * (element2.getText().contains(value)) { element2.click(); break; }
			 * }
			 */enteredValue = element.getAttribute("value");
			logger.info("Entered value is : " + enteredValue);
		}
		catch (StaleElementReferenceException e1)
		{
			logger.info("Exception thrown while entering value: " + e1);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Select Method While selecting  " + " =>" + error + " \n" + e, e);
		}
		return enteredValue;
	}

	public static String fillAutoCompleteField(WebDriver driver, WebElement element, String value) throws ActionBotException
	{
		String enteredValue = null;
		try
		{
			element.clear();
			element.sendKeys(value);
			ScreenShot.screenshot(driver, "testcaseName", "After filling value: " + value);
			waitForPageLoad(driver);
			ActionBot.defaultSleep();
			waitForElementToBePresent1(driver, By.xpath(".//*[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content'][contains(@style,'display: block')]/li"));
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.ENTER);
			ActionBot.defaultSleep();
			ScreenShot.screenshot(driver, "TestCase", "After filling product Category");
			enteredValue = element.getAttribute("value");
			logger.info("Entered value is : " + enteredValue);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Select Method While selecting  " + element + " =>" + " \n" + e, e);
		}
		return enteredValue;
	}

	public static void moveToElement(WebDriver driver, UI_Elements elements) throws ActionBotException
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(ActionBot.findElement(driver, elements)).build().perform();
	}

	public static void moveToElement(WebDriver driver, WebElement element) throws ActionBotException
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public static void moveToElementAndClick(WebDriver driver, UI_Elements elements) throws ActionBotException
	{
		String error = getError(elements);
		Actions actions = new Actions(driver);
		try
		{
			actions.moveToElement(ActionBot.findElement(driver, elements)).click().build().perform();
		}
		catch (StaleElementReferenceException ex)
		{
			logger.error("Stale Element Reference Exception has occurred... Locating element again... ");
			try
			{
				actions.moveToElement(ActionBot.findElement(driver, elements)).click().build().perform();
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + error + " \n" + exx, exx);
			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + error + " \n" + e, e);
		}
	}

	public static void moveToElementAndClick(WebDriver driver, WebElement element) throws ActionBotException
	{
		Actions actions = new Actions(driver);
		try
		{
			actions.moveToElement(element).click().build().perform();
		}
		catch (StaleElementReferenceException ex)
		{
			logger.error("Stale Element Reference Exception has occurred... Locating element again... ");
			try
			{
				actions.moveToElement(element).click().build().perform();
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + element.toString() + " \n" + exx, exx);
			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + element.toString() + " \n" + e, e);
		}
	}

	public static void moveToElementAndClick(WebDriver driver, By by) throws ActionBotException
	{
		Actions actions = new Actions(driver);
		try
		{
			actions.moveToElement(ActionBot.findElement(driver, by)).click().build().perform();
		}
		catch (StaleElementReferenceException ex)
		{
			logger.error("Stale Element Reference Exception has occurred... Locating element again... ");
			try
			{
				defaultSleep();
				actions.moveToElement(ActionBot.findElement(driver, by)).click().build().perform();
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + by + " \n" + exx, exx);
			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + by + " \n" + e, e);
		}
	}

	public static void waitForPageLoad(WebDriver driver) throws ActionBotException
	{
		int i = 0;
		int j = 0;
		String isJqueryPresent = null;

		JavascriptExecutor js = (JavascriptExecutor) driver;

		long loadEventEnd = 0;
		long navigationStart = 0;
		try
		{
			navigationStart = (Long) js.executeScript("return performance.timing.navigationStart");
		}
		catch (JavaScriptException jse)
		{
			logger.info("||:: Java Script Error ::||");
		}
		catch (Exception e)
		{
			logger.info("||:: Java Script Error ::||");
		}

		try
		{
			logger.info("||::waiting for pageload to complete::||");
			//while (loadEventEnd == 0 && j < 3000)
			while (loadEventEnd == 0 && j < Integer.parseInt(defaultHighSleep))
			{
				loadEventEnd = (Long) js.executeScript("return performance.timing.loadEventEnd");

				Thread.sleep(100);
				j = j + 1;
			}
			if (j > 3000)
			{
				logger.info("||::Pageload was not completed in specified timeout of 300 seconds. Kindly refer attached screenshot for more clearification::||");
			}
		}
		catch (Exception e)
		{
			logger.info("||:: Pageload was not completed in specified timeout of 300 seconds ::||");
			// throw new ActionBotException("Pageload was not completed in
			// specified timeout of 300 seconds", e);
		}
		double pageLoadTime = loadEventEnd - navigationStart;

		try
		{
			try
			{
				isJqueryPresent = (String) js.executeScript("jQuery.noConflict;return jQuery.fn.jquery;");
			}
			catch (Exception e)
			{
				logger.info("||::No jQuery available::||");
			}
			if (isJqueryPresent != null)
			{

				logger.info("||::waiting for ajax::||");
				while (!js.executeScript("return window.parent.jQuery.active").toString().equalsIgnoreCase("0") && i < 1000)

				{
					Thread.sleep(100);
					i = i + 1;
				}

				pageLoadTime = pageLoadTime + i * 100;

				if (i > 1000)
				{
					logger.info(
						"||::Asynchronized request (AJAX) was not completed in specified timeout of 100 seconds. Kindly refer attached screenshot for more clearification::||");
				}
			}
			logger.info(
				"||::Time for '" + js.executeScript("return window.parent.document.title").toString() + "' page to be user interactive: " + pageLoadTime / 1000 + " Seconds::||");
		}
		catch (Exception e)
		{
			logger.info("||:: Asynchronized request (AJAX) was not completed in specified timeout of 100 seconds. ::||");
			/*
			 * throw new ActionBotException(
			 * "Asynchronized request (AJAX) was not completed in specified timeout of 100 seconds."
			 * , e);
			 */
		}

	}

	public static void waitForElementToBePresent(WebDriver driver, By by) throws ActionBotException
	{
		try
		{
			// defaultSleep();
			WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(by));
			long startTime = System.currentTimeMillis();
			long elapsedTime;
			while (!element.isDisplayed())
			{
				if (element.isDisplayed())
				{
					break;
				}
				elapsedTime = System.currentTimeMillis() - startTime;
				if (elapsedTime > 120000)
				{
					break;
				}
				continue;
			}

		}
		catch (Exception e)
		{
			logger.info("\n Error While Verifying element is present or not   =>" + by.toString() + " \n");

		}
	}

	public static String getAttributeOfElement(WebDriver driver, By by, String attribute) throws ActionBotException
	{
		WebElement element = null;
		String value = null;
		try
		{
			element = ActionBot.findElement(driver, by);
			value = element.getAttribute(attribute);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in getAttribute Method While retrieveing " + attribute + "attribute of  " + element + " =>" + " \n" + e, e);
		}
		return value;
	}

	public static String getAttributeOfElement(WebDriver driver, UI_Elements ui_Elements, String attribute) throws ActionBotException
	{
		WebElement element = null;
		String value = null, error = getError(ui_Elements);
		try
		{
			element = ActionBot.findElement(driver, ui_Elements);
			value = element.getAttribute(attribute);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in getAttribute Method While retrieveing " + attribute + "attribute of  " + error + " =>" + " \n" + e, e);
		}
		return value;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To select given date <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param day
	 *        </font><b><br>
	 * @param month
	 *        </font><b><br>
	 * @param year
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void selectDate(WebDriver driver, String day, String month, String year) throws ActionBotException
	{
		// year
		Select select = new Select(ActionBot.findElement(driver, IPageRequisitionCheckOut.SELECT_YEAR));
		select.selectByValue(year);

		// month
		select = new Select(ActionBot.findElement(driver, IPageRequisitionCheckOut.SELECT_MONTH));
		select.selectByValue(month);

		// day
		// ActionBot.click(driver, By.linkText(day));
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='ui-datepicker-div']//*[text()='" + day + "']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", ele);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Wait until element is visible <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param timeOutInSeconds
	 *        </font><b><br>
	 * @param ui_Elements
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void waitForElementToBeVisible(WebDriver driver, int timeOutInSeconds, UI_Elements ui_Elements) throws ActionBotException
	{
		String error = getError(ui_Elements);
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(ActionBot.findElement(driver, ui_Elements)));
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in waitForElementToBeVisible Method While waiting for visiblity of element  " + error + " =>" + " \n" + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Wait until element is visible <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param timeOutInSeconds
	 *        </font><b><br>
	 * @param ui_Elements
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void waitForElementToBeVisible(WebDriver driver, int timeOutInSeconds, WebElement element) throws ActionBotException
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in waitForElementToBeVisible Method While waiting for visiblity of element  " + element.toString() + " =>" + " \n" + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Fill autocomplete field <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param ui_Elements
	 *        </font><b><br>
	 * @param listElement
	 *        </font><b><br>
	 * @param value
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static String fillAutoCompleteField(WebDriver driver, UI_Elements ui_Elements, WebElement listElement, String value) throws ActionBotException
	{
		String enteredValue = null, error = getError(ui_Elements);
		WebElement element = null;
		try
		{
			element = ActionBot.findElement(driver, ui_Elements);
			element.clear();
			element.sendKeys(value);
			waitForPageLoad(driver);
			ActionBot.waitForElementToBeVisible(driver, 8, listElement);
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.ENTER);

			enteredValue = element.getAttribute("value");
			logger.info("Entered value is : " + enteredValue);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in fillAutoCompleteField Method While filling autocomplete  " + error + " =>" + " \n" + e, e);
		}
		return enteredValue;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Fill autocomplete field <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param ui_Elements
	 *        </font><b><br>
	 * @param listElement
	 *        </font><b><br>
	 * @param value
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static String fillAutoCompleteField(WebDriver driver, UI_Elements ui_Elements, UI_Elements listElement, String value) throws ActionBotException
	{
		String enteredValue = null, error = getError(ui_Elements);
		WebElement element = null;
		try
		{
			element = ActionBot.findElement(driver, ui_Elements);
			if (value != null)
			{
				element.clear();
				element.sendKeys(value);
				ActionBot.waitForElementToBeVisible(driver, 8, listElement);
				element.sendKeys(Keys.ARROW_DOWN);
				element.sendKeys(Keys.RETURN);
			}
			else
			{
				element.clear();
				element.sendKeys(Keys.SPACE);
				ActionBot.waitForElementToBeVisible(driver, 8, listElement);
				// select from the loaded suggestions
				element.sendKeys(Keys.ARROW_DOWN);
				element.sendKeys(Keys.RETURN);
			}

			ActionBot.defaultSleep();
			enteredValue = element.getAttribute("value");
			logger.info("Entered value is : " + enteredValue);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in fillAutoCompleteField Method While filling autocomplete  " + error + " =>" + " \n" + e, e);
		}
		return enteredValue;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Select value from auto complete list in
	 * which we cant sendkeys values <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param ui_Elements
	 *        </font><b><br>
	 * @param listElement
	 *        </font><b><br>
	 * @param value
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static String selectValueFromAutoCompleteList(WebDriver driver, UI_Elements ui_Elements, WebElement listElement, String value) throws ActionBotException
	{
		String selectedValue = null, error = getError(ui_Elements);
		try
		{
			ActionBot.click(driver, ui_Elements);
			ActionBot.waitForElementToBeVisible(driver, 5, listElement);
			List<WebElement> elements = listElement.findElements(By.tagName("li"));
			if (value != null)
			{
				for (WebElement element : elements)
				{
					if (element.getText().trim().equalsIgnoreCase(value))
					{
						element.click();
						break;
					}
				}
			}
			else
			{
				elements.get(0).click();
			}
			selectedValue = ActionBot.findElement(driver, ui_Elements).getAttribute("value");
			logger.info("Selected value is : " + selectedValue);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in selectValueFromAutoCompleteList Method While selecting autocomplete value " + error + " =>" + " \n" + e, e);
		}
		return selectedValue;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Select value from auto complete list in
	 * which we cant sendkeys values <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param ui_Elements
	 *        </font><b><br>
	 * @param listElement
	 *        </font><b><br>
	 * @param value
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static String selectValueFromAutoCompleteList(WebDriver driver, UI_Elements ui_Elements, UI_Elements listElement, String value) throws ActionBotException
	{
		String selectedValue = null, error = getError(ui_Elements);
		try
		{
			ActionBot.click(driver, ui_Elements);
			ActionBot.click(driver, ui_Elements);
			ActionBot.defaultSleep();
			try
			{
				ActionBot.waitForElementToBeVisible(driver, 11, listElement);
			}
			catch (Exception e)
			{
				logger.info("Element not visible ");
				ActionBot.click(driver, ui_Elements);
				ActionBot.click(driver, ui_Elements);
				ActionBot.defaultSleep();
			}
			List<WebElement> elements = ActionBot.findElements(driver, listElement);
			Actions actions = new Actions(driver);
			if (value != null)
			{
				for (WebElement ele : elements)
				{
					if (ele.getText().trim().equalsIgnoreCase(value))
					{
						actions.moveToElement(ele).click().build().perform();
						break;
					}
				}
			}
			else
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements.get(0));
				// ((JavascriptExecutor)
				// driver).executeScript("arguments[0].click()",
				// elements.get(0));
				actions.moveToElement(elements.get(0)).click().build().perform();

			}
			selectedValue = ActionBot.findElement(driver, ui_Elements).getAttribute("value");
			logger.info("Selected value is : " + selectedValue);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in selectValueFromAutoCompleteList Method While selecting autocomplete value " + error + " =>" + " \n" + e, e);
		}
		return selectedValue;
	}

	/**
	 * Method that first focus on element and then clicks the element
	 * 
	 * @author ankita.sawant
	 * @param driver
	 * @param by
	 * @throws ActionBotException
	 * @throws InterruptedException
	 * @throws Exception
	 */
	public static void focusAndclick(WebDriver driver, UI_Elements uiElements) throws ActionBotException
	{
		WebElement element = null;
		String error = getError(uiElements);
		try
		{
			element = findElement(driver, uiElements);
			// focus on element
			new Actions(driver).moveToElement(element).perform();
			// click on element
			element.click();
		}
		catch (StaleElementReferenceException ex)
		{
			logger.error("Stale Element Reference Exception has occurred... Locating element again... ");
			try
			{
				element = findElement(driver, uiElements);
				if (element != null)
				{
					// focus on element
					new Actions(driver).moveToElement(element).perform();
					// click on element
					element.click();
				}
				else
				{
					logger.error("Element is Null Hence Unable To Click ON ELEMENT : " + error);
				}
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in Click Method While performing click on " + error + " \n" + exx, exx);
			}
		}
		catch (Exception e)
		{
			try
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
			}
			catch (StaleElementReferenceException ex)
			{
				logger.error("Stale Element Reference Exception has occurred... Locating element again... ");
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
			}
			catch (Exception ex)
			{
				logger.error("\n Exception in Click Method While performing click on " + error + " \n" + ex, ex);
			}
		}
	}

	/**
	 * Method that first focus on element and then clicks the element
	 * 
	 * @author ankita.sawant
	 * @param driver
	 * @param by
	 * @throws ActionBotException
	 * @throws InterruptedException
	 * @throws Exception
	 */
	public static void focusAndclick(WebDriver driver, By by) throws ActionBotException
	{
		WebElement element = null;
		try
		{
			element = findElement(driver, by);
			// focus on element
			new Actions(driver).moveToElement(element).perform();
			// click on element
			element.click();
		}
		catch (StaleElementReferenceException ex)
		{
			logger.error("Stale Element Reference Exception has occurred : ");
			try
			{
				element = findElement(driver, by);
				if (element != null)
				{
					// focus on element
					new Actions(driver).moveToElement(element).perform();
					// click on element
					element.click();
				}
				else
				{
					logger.error("Element is Null Hence Unable To Click ON ELEMENT : ");
				}
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in Click Method While performing click on " + by.toString() + " =>" + exx, exx);
			}
		}
		catch (Exception e)
		{
			try
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
			}
			catch (Exception ex)
			{
				logger.error("\n Exception in Click Method While performing click on " + by.toString() + " =>" + " \n" + ex, ex);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To check certificate error present or not
	 * and click on link <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void clickOnCertificateError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (driver.getTitle().contains("Certificate Error"))
		{
			ScreenShot.screenshot(driver, testCaseName, "Certificate Error");
			driver.get("javascript:document.getElementById('overridelink').click();");
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Wait for element to be visible <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param by
	 *        </font><b><br>
	 * @param timeOutPeriod
	 *        </font><b><br>
	 * @return </b> <br>
	 * 
	 * @throws ActionBotException
	 */
	public static WebElement waitForElementToBeDisplayed(WebDriver driver, final By by, int timeOutPeriod) throws ActionBotException
	{
		String error = by.toString();
		try
		{
			WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
			webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
			webDriverWait.ignoring(StaleElementReferenceException.class);
			webDriverWait.ignoring(TimeoutException.class);
			return webDriverWait.until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver driver)
				{
					WebElement element = driver.findElement(by);
					return element.isDisplayed() ? element : null;
				};

			});
		}
		catch (StaleElementReferenceException ex)
		{
			throw new StaleElementReferenceException("\n StaleElementReferenceException in waitForElementToBeDisplayed Method While Finding " + error + " => \n" + ex, ex);
		}
		catch (NoSuchElementException ex)
		{
			throw new ActionBotException("\n NoSuchElementException in waitForElementToBeDisplayed Method While Finding " + error + " => \n" + ex, ex);
		}
		catch (NullPointerException ex)
		{
			throw new ActionBotException("\n NullPointerException in waitForElementToBeDisplayed Method While Finding " + error + " => \n" + ex, ex);
		}
		catch (TimeoutException ex)
		{
			throw new ActionBotException("\n TimeoutException in waitForElementToBeDisplayed Method While Finding " + error + " => \n" + ex, ex);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in waitForElementToBeDisplayed Method While Finding " + error + " => \n" + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Wait for element to be visible <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param by
	 *        </font><b><br>
	 * @param timeOutPeriod
	 *        </font><b><br>
	 * @return </b> <br>
	 * 
	 * @throws ActionBotException
	 */

	/*
	 * public static WebElement waitForElementToBeDisplayed(WebDriver driver,
	 * final UI_Elements ui_Elements, int timeOutPeriod) { WebDriverWait
	 * webDriverWait = new WebDriverWait(driver, timeOutPeriod);
	 * webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS); return
	 * webDriverWait.until(new ExpectedCondition<WebElement>() {
	 * 
	 * @Override public WebElement apply(WebDriver driver) { try { WebElement
	 * element = driver.findElement(ui_Elements.getBy()); return
	 * element.isDisplayed() ? element : null; } catch (NoSuchElementException
	 * ex) { return null; } catch (StaleElementReferenceException ex) { return
	 * null; } catch (NullPointerException ex) { return null; } }; }); }
	 */

	public static WebElement waitForElementToBeDisplayed(WebDriver driver, final UI_Elements ui_Elements, int timeOutPeriod) throws ActionBotException
	{
		String error = getError(ui_Elements);
		try
		{
			WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
			webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
			return webDriverWait.until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver driver)
				{
					WebElement element = driver.findElement(ui_Elements.getBy());
					return element.isDisplayed() ? element : null;
				};

			});
		}
		catch (NoSuchElementException ex)
		{
			throw new ActionBotException("\n NoSuchElementException in waitForElementToBeDisplayed Method While Finding " + error + " => \n" + ex, ex);
		}
		catch (StaleElementReferenceException ex)
		{
			logger.info("StaleElementReferenceException in waitForElementToBeDisplayed Method While Finding " + error + ". Again locating element...");
			try
			{
				return driver.findElement(ui_Elements.getBy());
			}
			catch (StaleElementReferenceException exx)
			{
				throw new StaleElementReferenceException("\n StaleElementReferenceException in waitForElementToBeDisplayed Method While Finding " + error + " => \n" + exx, exx);
			}
		}
		catch (NullPointerException ex)
		{
			throw new ActionBotException("\n NullPointerException in waitForElementToBeDisplayed Method While Finding " + error + " => \n" + ex, ex);
		}
		catch (ElementNotVisibleException e)
		{
			throw new ActionBotException("\n ElementNotVisibleException in waitForElementToBeDisplayed Method While Finding " + error + " => \n" + e, e);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in waitForElementToBeDisplayed Method While Finding " + error + " => \n" + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Wait for element to be visible <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param by
	 *        </font><b><br>
	 * @param timeOutPeriod
	 *        </font><b><br>
	 * @return </b> <br>
	 * 
	 * @throws ActionBotException
	 */
	public static WebElement waitForElementToBeEnable(WebDriver driver, final By by, int timeOutPeriod) throws ActionBotException
	{
		String error = by.toString();
		try
		{
			WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
			webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
			webDriverWait.ignoring(StaleElementReferenceException.class);
			return webDriverWait.until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver driver)
				{
					WebElement element = driver.findElement(by);
					return element.isEnabled() ? element : null;
				};

			});
		}
		catch (NoSuchElementException ex)
		{
			throw new ActionBotException("\n NoSuchElementException in waitForElementToBeEnable Method While Finding " + error + " => \n" + ex, ex);
		}
		catch (StaleElementReferenceException ex)
		{
			throw new StaleElementReferenceException("\n StaleElementReferenceException in waitForElementToBeEnable Method While Finding " + error + " => \n" + ex, ex);
		}
		catch (NullPointerException ex)
		{
			throw new ActionBotException("\n NullPointerException in waitForElementToBeEnable Method While Finding " + error + " => \n" + ex, ex);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in waitForElementToBeEnable Method While Finding " + error + " => \n" + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Wait for element to be visible <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param by
	 *        </font><b><br>
	 * @param timeOutPeriod
	 *        </font><b><br>
	 * @return </b> <br>
	 * 
	 * @throws ActionBotException
	 */
	public static WebElement waitForElementToBeEnable(WebDriver driver, final UI_Elements ui_Elements, int timeOutPeriod) throws ActionBotException
	{
		String error = getError(ui_Elements);
		try
		{
			WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
			webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
			return webDriverWait.until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver driver)
				{
					WebElement element = driver.findElement(ui_Elements.getBy());
					return element.isEnabled() ? element : null;
				};

			});
		}
		catch (NoSuchElementException ex)
		{
			throw new ActionBotException("\n NoSuchElementException in waitForElementToBeEnable Method While Finding " + error + " => \n" + ex, ex);
		}
		catch (StaleElementReferenceException ex)
		{
			logger.info("StaleElementReferenceException in waitForElementToBeEnable Method While Finding " + error + ". Again locating element...");
			try
			{
				return driver.findElement(ui_Elements.getBy());
			}
			catch (StaleElementReferenceException exx)
			{
				throw new StaleElementReferenceException("\n StaleElementReferenceException in waitForElementToBeEnable Method While Finding " + error + " => \n" + ex, ex);
			}
		}
		catch (NullPointerException ex)
		{
			throw new ActionBotException("\n NullPointerException in waitForElementToBeEnable Method While Finding " + error + " => \n" + ex, ex);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in waitForElementToBeEnable Method While Finding " + error + " => \n" + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To clear text field with Space <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param ui_Elements
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void clearTextFieldWithSpace(WebDriver driver, String testCaseName, UI_Elements ui_Elements) throws ActionBotException
	{
		String error = getError(ui_Elements);
		try
		{
			WebElement element = ActionBot.findElement(driver, ui_Elements);
			element.clear();
			element.sendKeys(Keys.SPACE);
			element.sendKeys(Keys.SPACE);
		}
		catch (NoSuchElementException e)
		{
			throw new ActionBotException("\n NoSuchElementException in waitForElementToBeEnable Method While Finding " + error + " => \n" + e, e);
		}
		catch (StaleElementReferenceException ex)
		{
			throw new ActionBotException("\n StaleElementReferenceException in waitForElementToBeEnable Method While Finding " + error + " => \n" + ex, ex);
		}
		catch (NullPointerException ex)
		{
			throw new ActionBotException("\n NullPointerException in waitForElementToBeEnable Method While Finding " + error + " => \n" + ex, ex);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in waitForElementToBeEnable Method While Finding " + error + " => \n" + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To clear text field with Space <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param by
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void clearTextFieldWithSpace(WebDriver driver, String testCaseName, By by) throws ActionBotException
	{
		try
		{
			WebElement element = ActionBot.findElement(driver, by);
			element.clear();
			element.sendKeys(Keys.SPACE);
			element.sendKeys(Keys.SPACE);
		}
		catch (NoSuchElementException e)
		{
			throw new ActionBotException("\n NoSuchElementException in waitForElementToBeEnable Method While Finding " + by.toString() + " => \n" + e, e);
		}
		catch (StaleElementReferenceException ex)
		{
			throw new ActionBotException("\n StaleElementReferenceException in waitForElementToBeEnable Method While Finding " + by.toString() + " => \n" + ex, ex);
		}
		catch (NullPointerException ex)
		{
			throw new ActionBotException("\n NullPointerException in waitForElementToBeEnable Method While Finding " + by.toString() + " => \n" + ex, ex);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in waitForElementToBeEnable Method While Finding " + by.toString() + " => \n" + e, e);
		}
	}

	public static boolean isElementEnabled(WebDriver driver, By by) throws ActionBotException
	{
		boolean status = false;
		WebElement element;
		String error = by.toString();
		try
		{
			element = driver.findElement(by);
			if (element.isEnabled())
			{
				status = true;
				logger.info("Element " + error + "  is Enable");
			}
			else
			{
				logger.info("Element " + error + "  is Disable");
			}
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				element = driver.findElement(by);
				if (element.isEnabled())
				{
					status = true;
					logger.info("Element " + error + "  is Enable");
				}
				else
				{
					logger.info("Element " + error + "  is Disable");
				}
			}
			catch (Exception exx)
			{
				status = false;
				logger.info("\n Error While Verifying whether Element is Enable or Disable   =>" + by.toString() + " \n");
			}
		}
		catch (Exception e)
		{
			status = false;
			logger.info("\n Error While Verifying whether Element is Enable or Disable   =>" + error + " \n");
		}
		return status;
	}

	public static boolean isElementEnabled(WebDriver driver, UI_Elements uiElements) throws ActionBotException
	{
		boolean status = false;
		WebElement element;
		By by = uiElements.getBy();
		String error = getError(uiElements);
		try
		{
			element = driver.findElement(by);
			if (element.isEnabled())
			{
				status = true;
			}
			else
			{
				logger.info("Element " + error + "  is Disable ");
			}
		}
		catch (StaleElementReferenceException e)
		{
			try
			{
				logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
				element = driver.findElement(by);
				if (element.isEnabled())
				{
					status = true;
					logger.info("Element " + error + "  is Enable");
				}
				else
				{
					logger.info("Element " + error + "  is Disable");
				}
			}
			catch (Exception exx)
			{
				status = false;
				logger.info("\n Error While Verifying whether Element is Enable or Disable   =>" + by.toString() + " \n");
			}
		}
		catch (Exception e)
		{
			status = false;
			logger.info("\n Error While Verifying whether Element is Enable or Disable   =>" + error + " \n");
		}
		return status;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To accept alert <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </b> <br>
	 */
	public static void acceptAlert(WebDriver driver, String testCaseName)
	{
		try
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		catch (Exception e)
		{
			logger.info("\n Error While accepting alert   =>" + e, e);
		}
	}

	/**
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param by
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 * 
	 * @throws ActionBotException
	 */
	public static WebElement findElementByWaitingForPresenceOfElement(WebDriver driver, final UI_Elements uiElements) throws ActionBotException // throws
																																				// ActionBotException
	{
		String error = getError(uiElements);
		try
		{
			return waitForElementToBePresent(driver, timeOut, uiElements);
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Find Element Method While Finding " + error + " => \n" + e, e);
		}

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Wait until element is present <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param timeOutInSeconds
	 *        </font><b><br>
	 * @param ui_Elements
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static WebElement waitForElementToBePresent(WebDriver driver, int timeOutInSeconds, UI_Elements ui_Elements) throws ActionBotException
	{
		String error = getError(ui_Elements);
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(ui_Elements.getBy()));
			return driver.findElement(ui_Elements.getBy());
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in waitForElementToBePresent Method While waiting for presence of element  " + error + " =>" + " \n" + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To click on web element <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param element
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void click(WebDriver driver, WebElement element) throws ActionBotException
	{

		try
		{
			if (element != null)
			{
				element.click();
			}
			else
			{
				logger.error("Element is Null Hence Unable To Click ON ELEMENT");
			}
			// to print http request/response
			// HttpClientUtilities.printRequestResponse(driver.getCurrentUrl());
		}
		catch (ElementNotInteractableException e)
		{
			logger.error("Element Not Clickable Exception has occurred.. Locating element again ");
			try
			{
				if (element != null)
				{
					element.click();
				}
				else
				{
					logger.error("Element is Null Hence Unable To Click ON ELEMENT");
				}
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + element.toString() + " \n" + exx, exx);
			}
		}
		catch (StaleElementReferenceException ex)
		{
			logger.error("Stale Element Reference Exception has occurred : ");
			try
			{
				if (element != null)
				{
					element.click();
				}
				else
				{
					logger.error("Element is Null Hence Unable To Click ON ELEMENT : ");
				}
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in Click Method While performing click on " + element.toString() + " => \n" + exx, exx);
			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Click Method While performing click on " + element.toString() + " =>\n" + e, e);

		}
	}

	public static void waitForElementToBePresent1(WebDriver driver, By by) throws ActionBotException
	{
		try
		{
			// logger.info("=========== Before Waiting for Element Present
			// ==========");
			WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(by));

			long startTime = System.currentTimeMillis();
			long elapsedTime;
			while (!element.isDisplayed())
			{
				if (element.isDisplayed())
				{
					break;
				}
				elapsedTime = System.currentTimeMillis() - startTime;
				if (elapsedTime > 12000)
				{
					break;
				}
				continue;
			}
			// logger.info("=========== After Waiting for Element Present
			// ==========");

		}
		catch (Exception e)
		{
			logger.error("\n Error While Verifying element is present or not   =>" + by.toString() + " \n");

		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To drag and drop element <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param src_ui_Elements
	 *        </font><b><br>
	 * @param target_ui_Elements
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void dragAndDrop(WebDriver driver, UI_Elements src_ui_Elements, UI_Elements target_ui_Elements) throws ActionBotException
	{
		String error, error1;
		error = getError(src_ui_Elements);
		error1 = getError(target_ui_Elements);
		try
		{
			Actions actions = new Actions(driver);
			actions.dragAndDrop(ActionBot.findElement(driver, src_ui_Elements), ActionBot.findElement(driver, target_ui_Elements)).build().perform();
		}
		catch (StaleElementReferenceException e)
		{
			logger.info("Stale Element Reference Exception has occurred.. hence locating element again..");
			Actions actions = new Actions(driver);
			actions.dragAndDrop(ActionBot.findElement(driver, src_ui_Elements), ActionBot.findElement(driver, target_ui_Elements)).build().perform();
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in dragAndDrop Method While dragging element " + error + " to target element " + error1 + " =>" + " \n" + e, e);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> click Using JavaScript <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param ui_Elements
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void clickUsingJavaScript(WebDriver driver, UI_Elements ui_Elements) throws ActionBotException
	{
		String error = getError(ui_Elements);
		WebElement element = null;
		try
		{
			element = waitForElementToBeEnable(driver, ui_Elements, timeOut);
			if (element != null)
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
			}
			else
			{
				logger.error("Element is Null Hence Unable To Click ON ELEMENT");
			}
		}
		catch (ElementNotInteractableException e)
		{
			logger.error("Element Not Clickable Exception has occurred.. Locating element again ");
			try
			{
				element = waitForElementToBeEnable(driver, ui_Elements, timeOut);
				if (element != null)
				{
					((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
				}
				else
				{
					logger.error("Element is Null Hence Unable To Click ON ELEMENT");
				}
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + error + " \n" + exx, exx);
			}
		}
		catch (StaleElementReferenceException ex)
		{
			logger.error("Stale Element Reference Exception has occurred.. Locating element again.. ");
			try
			{
				element = findElement(driver, ui_Elements);
				if (element != null)
				{
					((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
				}
				else
				{
					logger.error("Element is Null Hence Unable To Click ON ELEMENT : " + error);
				}
			}
			catch (Exception exx)
			{
				throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + error + " \n" + exx, exx);
			}
		}
		catch (Exception e)
		{
			throw new ActionBotException("\n Exception in Click Method While performing click on " + " =>" + error + " \n" + e, e);
		}

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To refresh page <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void refreshPage(WebDriver driver, String testCaseName)
	{
		try
		{
			driver.navigate().refresh();
			if (isAlertPresent(driver, testCaseName))
			{
				acceptAlert(driver, testCaseName);
			}
		}
		catch (Exception e)
		{
			logger.error("Exception occurred while refreshing page : " + e, e);
		}
	}
}
