package com.zycus.automation.config;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.zycus.automation.bo.User;
import com.zycus.automation.boutilshelper.UserUtilHelper;
import com.zycus.automation.boutilshelper.UserUtilHelper.Enum_UserList;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.loginlogout.ILogin;
import com.zycus.automation.utilities.loginlogout.Logout;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.LoginLogout;
import com.zycus.framework.framework_version_2_4.framework.config.SetupChecker;
import com.zycus.framework.framework_version_2_4.startup.Startup;

public class SetupCheckerImpl implements SetupChecker
{
	static Logger logger = Logger.getLogger(SetupCheckerImpl.class);

	
	public StringBuffer check(String[] setups)
	{
		StringBuffer errors = new StringBuffer();
		WebDriver driver = null;
		User user2 = null;
		String testCaseName = "check";
		TestCase testCase = new TestCase();
		try
		{
			testCase.setBrowser(Startup.browserEnvironments.get(0).getBrowser());
			testCase.setVersion(Startup.browserEnvironments.get(0).getVersion());
			testCase.setTestMethodName(testCaseName);
			// User user = null;
			driver = DriverSelector.getDriver(testCase);
			user2 = UserUtilHelper.getUserWithSpecificAttribute(Enum_UserList.ROLE, "ALL_Products");
			LoginLogout.login(driver, testCase, user2.getUsername(), user2.getPassword(), null, null, null);
			// login
			for (String eachSetup : setups)
			{
				switch (eachSetup)
				{
					case "EINVOICE":
						try
						{
							errors.append(checkEinvoice(driver));
						}
						catch (Exception e)
						{
							// TODO Auto-generated catch block
							errors.append("Could Not Login to eProc");
						}
						break;
					case "EPROC":
						// checkEproc(errors);
						try
						{
							errors.append(checkeProc(driver, testCaseName));
						}
						catch (Exception e)
						{
							errors.append("Could Not Login to eProc");
						}
						break;
					case "SIM":
						try
						{
							errors.append(checkSim(driver, testCaseName));
						}
						catch (Exception e)
						{
							errors.append("Could Not Login to sim");
						}
						break;
					case "ZSN":
						try
						{
							errors.append(checkZsn(driver, testCaseName));
						}
						catch (Exception e)
						{
							errors.append("Could Not Login to zsn");
						}
						break;
					case "ALL":
						try
						{
							errors.append(checkEinvoice(driver));
						}
						catch (Exception e)
						{
							// TODO Auto-generated catch block
							errors.append("Could Not Login to eInvoice");
						}
						try
						{
							errors.append(checkeProc(driver, testCaseName));
						}
						catch (Exception e)
						{
							errors.append("Could Not Login to eProc");
						}
						try
						{
							errors.append(checkSim(driver, testCaseName));
						}
						catch (Exception e)
						{
							errors.append("Could Not Login to sim");
						}
						try
						{
							errors.append(checkZsn(driver, testCaseName));
						}
						catch (Exception e)
						{
							errors.append("Could Not Login to zsn");
						}
						break;
					default:
						System.out.println("Not checking anything");
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			Logout logout = new Logout();
			logout.afterLogout(driver, testCase, user2);

			ActionBot.driverStatus(driver, testCase.getTestMethodName());
			driver.manage().deleteAllCookies();
			driver.quit();
		}
		return errors;
	}

	// check einvoice
	private String checkEinvoice(WebDriver driver) throws Exception
	{
		System.out.println("Checking Einvoice");
		String errorMsg = "";
		try
		{
			// product switch : -eInvoice
			String productTab = IConstants.eInvoice;
			checkProduct(driver, productTab, ILogin.EINVOICE_PRODUCT_SELECTION_TAB);
			ActionBot.defaultSleep();
			// unqiue locator
			boolean flag = ActionBot.isElementDisplayed(driver, ILogin.PRODUCT_HOME_PAGE_UNIQUE_ELEMENT_FOR_EINVOICE);
			if (!flag)
			{
				errorMsg = "Could Not Login to einvoice";
			}
			// product switch url
			goToProductSelectionTab(driver);
		}
		catch (Exception e)
		{
			logger.error("Error While checking einvoice" + e, e);
			throw new Exception("Error While checking eInvoice", e);
		}
		return errorMsg;
	}

	// check eproc
	private String checkeProc(WebDriver driver, String testCaseName) throws Exception
	{
		String errorMsg = "";
		try
		{
			ActionBot.defaultSleep();
			String productTab = IConstants.eProc;
			checkProduct(driver, productTab, ILogin.EPROC_PRODUCT_SELECTION_TAB);
			ActionBot.defaultSleep();
			// unqiue locator
			boolean flag = ActionBot.isElementDisplayed(driver, ILogin.PRODUCT_HOME_PAGE_UNIQUE_ELEMENT_FOR_EPROC);
			if (!flag)
			{
				errorMsg = "Could Not Login to eProc";
			}
			// product switch url
			goToProductSelectionTab(driver);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			logger.error("Error While checking eProc" + e, e);
			throw new Exception("Error While checking eProc", e);
		}
		return errorMsg;
	}

	// checking sim
	private String checkSim(WebDriver driver, String testCaseName) throws Exception
	{
		String errorMsg = "";
		try
		{
			ActionBot.defaultSleep();
			String productTab = IConstants.SIM;
			checkProduct(driver, productTab, ILogin.SIM_PRODUCT_SELECTION_TAB);
			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultMediumSleep();
			boolean flag = ActionBot.isElementDisplayed(driver, ILogin.PRODUCT_HOME_PAGE_UNIQUE_ELEMENT_FOR_SIM);
			if (!flag)
			{
				errorMsg = "Could Not Login to SIM";
			}
			// product switch url
			goToProductSelectionTab(driver);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			logger.error("Error While checking sim" + e, e);
			throw new Exception("Error While checking sim", e);
		}
		return errorMsg;
	}

	// checking sim
	private String checkZsn(WebDriver driver, String testCaseName) throws Exception
	{
		TestCase testCase = new TestCase();
		String errorMsg = "";
		try
		{
			com.zycus.zsn.automation.services.LoginLogoutServices.loginZsn(driver, testCase, IConstants.ZSP_Supplier, IConstants.ZSN_URL);
			// unqiue locator
			boolean flag = ActionBot.isElementDisplayed(driver, ILogin.PRODUCT_HOMEPAGE_UNIQUE_ELEMENT_FOR_ZSN);
			if (!flag)
			{
				errorMsg = "Could Not Login to zsn";
			}
			com.zycus.zsn.automation.services.LoginLogoutServices.logoutZsn(driver, testCase);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			logger.error("Error While checking zsn" + e, e);
			throw new Exception("Error While checking zsn", e);
		}
		return errorMsg;
	}

	private static void checkProduct(WebDriver driver, String productName, UI_Elements productTab)

	{
		try
		{
			ActionBot.defaultSleep();
			if (!ActionBot.isElementDisplayed(driver, ILogin.HEADER_PRODUCT_SELECTION_TAB))
			{
				ActionBot.defaultSleep();
				// ActionBot.click(driver, ILogin.GO_TO_PRODUCT_SELECTION_TAB);
				driver.get(ConfigProperty.getConfig("URL"));
				ActionBot.defaultSleep();
			}
			ActionBot.defaultSleep();
			if (!ActionBot.isElementDisplayed(driver, productTab))
			{
				ActionBot.click(driver, ILogin.ARROW_NEXT_ON_PRODUCT_SELECTION_TAB);
			}
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(ActionBot.findElement(driver, productTab)).build().perform();
			ActionBot.click(driver, By.id("activePan_" + productName));
		}
		catch (Exception e)
		{
			logger.error("Error While Selecting product" + e, e);
		}
	}

	private static void goToProductSelectionTab(WebDriver driver) throws ActionBotException
	{
		// ActionBot.findElements(driver,
		// ILogin.GO_TO_PRODUCT_SELECTION_TAB).get(1).click();
		driver.get(ConfigProperty.getConfig("URL"));
		ActionBot.defaultSleep();
	}
}
