package com.zycus.automation.requisitionparser.test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zycus.automation.bo.User;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.dom_parser.framework.Parser;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.Helper;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;
import com.zycus.framework.framework_version_2_4.framework.WaitUtil;
import com.zycus.framework.framework_version_2_4.listener.CustomRetryListener;

public class RequisitionParserTest extends TestDataProvider
{
	static Logger	logger	= Logger.getLogger(RequisitionParserTest.class);
	String			configUsername;
	String			configPassword;
	Parser			parser;
	String			pathToExcel;

	@BeforeClass
	public void beforeClass()
	{
		PropertyConfigurator.configure("log4j.properties");
		configUsername = ConfigProperty.getConfig("parserUserName");
		configPassword = ConfigProperty.getConfig("parserPassword");
		parser = new Parser();
		pathToExcel = "resources" + File.separator + "ui" + File.separator;
	}

	/*
	 * ------------------- TEST CASES
	 * ----------------------------------------------
	 */
	/**
	 * Method that adds an item from the catalog to the cart Assertion
	 * Condition: The itemname and its quantity should be present in the cart
	 * 
	 * @author owais.iqbal
	 * @param testCase
	 * @throws Exception
	 * @throws SessionNotFoundException
	 */
	@Test(dataProvider = "dataProvider", retryAnalyzer = CustomRetryListener.class)
	public void requisitionParserTest(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		Map<String, String> map = testCase.getTestData();
		User user = new User();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			String methodName = testCase.getTestMethodName();
			Map<String, String> configParams = testCase.getTestData();
			WebElement element;

			logger.info("AUTOMATING METHOD " + methodName.toUpperCase());
			new HashMap<String, By>();
			Map<String, By> guidedItemMap = null;
			Map<String, By> checkOutMap;
			Map<String, By> requisitionSettingsMap;
			Map<String, By> onlineStoreMap = null;

			String url = ConfigProperty.getConfig("URL");
			String pathToExcel = ConfigProperty.getConfig("pathToExcels");

			if (configParams.get("url") != null)
			{
				url = configParams.get("url");
			}
			user.setUsername(configUsername);
			user.setPassword(configPassword);

			driver.get(url);
			String fileName = pathToExcel + "LoginLogout.xls";
			CommonUtil.parseHTMLContent(fileName, driver, parser);
			// fill login details
			Utility.loginPage(driver, parser, parser.readExcelFile(fileName), configUsername, configPassword);

			fileName = pathToExcel + "MainHeaderleveltabs.xls";
			Utility.clickOnSetupTab(fileName, driver, parser, parser.readExcelFile(fileName));

			fileName = pathToExcel + "MainHeaderleveltabs.xls";
			Utility.openCustomizedSettingsPage(fileName, driver, parser, parser.readExcelFile(fileName));

			fileName = pathToExcel + "CustomizeSettings.xls";
			Utility.openReqSettingLink(fileName, driver, parser, parser.readExcelFile(fileName));

			fileName = pathToExcel + "RequisitionSettingsPage.xls";
			CommonUtil.parseHTMLContent(fileName, driver, parser);
			requisitionSettingsMap = parser.readExcelFile(fileName);

			WaitUtil.waitForElementClickable(driver, parser.getBy(requisitionSettingsMap, "requisition_top"), 30).click();

			WaitUtil.waitForElementClickable(driver, parser.getBy(requisitionSettingsMap, "onlineStore"), 30).click();

			fileName = pathToExcel + "OnlineStorePage.xls";
			Utility.searchCatalogPage(fileName, driver, parser, parser.readExcelFile(fileName));
			onlineStoreMap = parser.readExcelFile(fileName);

			fileName = pathToExcel + "SearchListingPage.xls";
			Utility.searchListingPage(fileName, driver, parser, parser.readExcelFile(fileName));

			fileName = pathToExcel + "FreeTextFormPage.xls";
			Utility.addGuidedItem(fileName, driver, parser, parser.readExcelFile(fileName));

			Thread.sleep(5000);
			fileName = pathToExcel + "Checkout Page.xls";

			checkOutMap = parser.readExcelFile(fileName);

			element = driver.findElement(By.xpath(".//*"));
			String code = element.getAttribute("outerHTML");
			parser.parseHtmlContent(fileName, code);

			WaitUtil.waitForElementClickable(driver, parser.getBy(guidedItemMap, "EDIT_BILLING_DELIVERY_COSTBOOKING_INFO"), 30).click();

			WaitUtil.waitForElementClickable(driver, parser.getBy(checkOutMap, "COSTBOOKING_TAB"), 30).click();

			Thread.sleep(2000);
			ActionBot.click(driver, parser.getBy(guidedItemMap, "DELIVERY_TAB"));
			/*
			 * WaitUtil.waitForElementVisible(driver,
			 * parser.getBy(guidedItemMap, "deliveryDateIcon"), 30);
			 * WaitUtil.waitForElementClickable(driver,
			 * parser.getBy(guidedItemMap, "deliveryDateIcon"), 30);
			 * ActionBot.click(driver, parser.getBy(guidedItemMap,
			 * "deliveryDateIcon")); //year Select select = new
			 * Select(ActionBot.findElement(driver, deliveryYear));
			 * select.selectByValue("2016"); //month select = new
			 * Select(ActionBot.findElement(driver, deliveryMonth));
			 * select.selectByValue("9"); //day ActionBot.click(driver,
			 * By.linkText("10"));
			 */

			ActionBot.click(driver, parser.getBy(checkOutMap, "CANCLEREQSUMMARY"));

			Thread.sleep(2000);
			element = driver.findElement(By.xpath(".//*"));
			String htmlContent = driver.getPageSource();
			parser.updateStatusOfElementNotFoundOnSamePage(fileName, htmlContent);

			// req name
			String reqName = "req" + Helper.getRandomAlphaNumeric(11);
			element = WaitUtil.waitForElementClickable(driver, parser.getBy(checkOutMap, "TEXTBOX_REQUISITION_NAME"), 30);
			ActionBot.inputText(driver, element, parser.getBy(checkOutMap, "TEXTBOX_REQUISITION_NAME"), reqName);
			// enter purchase type
			Select select = new Select(WaitUtil.getElementUsingFluentWait(driver, parser.getBy(checkOutMap, "PURCHASE_TYPE")));
			select.selectByIndex(1);

			List<WebElement> list = WaitUtil.waitForListElementsPresent(driver, parser.getBy(onlineStoreMap, "BUTTON_NO"), 30);

			if (list.size() != 0)
			{
				driver.findElement(parser.getBy(checkOutMap, "yesButton")).click();
			}
			// edit payment method
			select = new Select(WaitUtil.getElementUsingFluentWait(driver, parser.getBy(checkOutMap, "SETTLEMENT_VIA")));
			select.selectByIndex(0);

			String buyer = ConfigProperty.getConfig("Username");
			if (configParams.get("loginUsername") != null)
			{
				buyer = configParams.get("loginUsername");
			}
			// buyer field
			element = WaitUtil.getElementUsingFluentWait(driver, parser.getBy(checkOutMap, "ASSIGNED_BUYER"));
			element.sendKeys(buyer);
			WaitUtil.waitForElementClickable(driver, By.partialLinkText(buyer), 30);
			// WaitUtil.waitForElementClickable(driver, lblAssignedBuyer, 30);
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.RETURN);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.partialLinkText(buyer)));

			/*
			 * //Accounting int i = 0; ActionBot.click(driver,
			 * parser.getBy(checkOutMap, "accountingTab")); //gl type select =
			 * new Select( WaitUtil.getElementUsingFluentWait(driver,
			 * parser.getBy(checkOutMap, "GL_Account_Type"))); List<WebElement>
			 * gl_account_type_list = select.getOptions();
			 * 
			 * select.selectByIndex(i); Thread.sleep(2000);
			 * 
			 * //ActionBot.threadSleep("20"); WebElement glAccount =
			 * WaitUtil.getElementUsingFluentWait(driver,
			 * parser.getBy(checkOutMap, "GL_Account")); glAccount.click();
			 * 
			 * int count = 0; int glAccountNo = 1; while
			 * (glAccount.getAttribute("value").equals("")) { long startTime =
			 * System.currentTimeMillis();
			 * 
			 * glAccount.sendKeys(Keys.ARROW_DOWN);
			 * glAccount.sendKeys(Keys.RETURN);
			 * 
			 * count++; if (count % 3 == 0) {
			 * 
			 * glAccountNo++; select.selectByIndex(glAccountNo);
			 * glAccount.click(); }
			 * 
			 * long elapsedTime = System.currentTimeMillis() - startTime; if
			 * (elapsedTime > 120000) { break; } } ActionBot.click(driver,
			 * parser.getBy(checkOutMap, "saveRequisitionItemSummary"));
			 */

			WaitUtil.waitForElementClickable(driver, parser.getBy(checkOutMap, "I_AM_DONE"), 30).click();

			Helper.takeScreenShotOfPassedTC(driver, methodName);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	public Map<String, By> getBy(Class name, String fileName, WebDriver driver) throws Exception
	{
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath(".//*"));
		String code = element.getAttribute("outerHTML");
		parser.generateExcelFiles(name, code, fileName);
		parser.parseHtmlContent(fileName, code);
		return parser.readExcelFile(fileName);

	}
}
