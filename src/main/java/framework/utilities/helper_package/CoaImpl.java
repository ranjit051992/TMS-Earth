package framework.utilities.helper_package;

import static framework.utilities.customWebUI.WebUI.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import framework.frameworkUtilies.GlobalVariable;
import framework.utilities.customWebUI.WebUI;
import framework.utilities.screenshot.Screenshot;
import framework.utilities.webElementWrapper.WebElementWrapper;
import product.actionbot.ActionBot;
import product.bo.RequisitionBO;
import product.keywords.bpo.FlowBpo;
import product.constants.iConstants;

public class CoaImpl
{

	private static Logger							logger		= Logger.getLogger(CoaImpl.class);
	public static Map<String, String>				testDataMap	= null;
	public static List<String>						keylist		= new LinkedList<String>();
	private static Map<String, Map<String, String>>	coaDataMap	= new HashMap<String, Map<String, String>>();

	/**
	 * ;
	 * 
	 * @description: getTestDataList reads test data from COAData.xlsx file for
	 *               coa form;
	 * @param: Nil;
	 * @return: returns mMap of Map;
	 */
	public static Map<String, Map<String, String>> getTestDataList()
	{

		try
		{
			String fileName = iConstants.COAfilePath;

			FileInputStream file = new FileInputStream(new File(fileName));

			// Create Workbook instance holding reference to .xlsx file;
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook;
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one;
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext())
			{
				testDataMap = new LinkedHashMap<String, String>();

				Row row = rowIterator.next();
				Row firstRow = sheet.getRow(0);
				// For each row, iterate through all the columns;
				Cell keyCell = row.getCell(0);
				String keyCellString = keyCell.getStringCellValue();

				Iterator<Cell> cellIterator = row.iterator();
				int counter = 1;
				cellIterator.next();
				while (cellIterator.hasNext())
				{
					firstRow.getCell(counter).setCellType(Cell.CELL_TYPE_STRING);
					String cellKey = firstRow.getCell(counter).getStringCellValue();
					Cell valueCell = cellIterator.next();
					valueCell.setCellType(Cell.CELL_TYPE_STRING);
					String cellValue = valueCell.getStringCellValue();
					testDataMap.put(cellKey, cellValue);
					counter++;
				}

				coaDataMap.put(keyCellString, testDataMap);
			}
			file.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return coaDataMap;
	}

	/**
	 * ;
	 * 
	 * @description: fillCoaForm fills Coa form based given split by method ;
	 * @param: &
	 *             splitSize(no of splits) ,splitBy(split by
	 *             amount/percentage/Quantity), webdriver instance;
	 * @return: Nil;
	 * @throws Exception
	 */

	public static void fillCoaForm(String[] dataType, int splitSize, String splitBy, WebDriver driver) throws Exception
	{
		Map<String, Map<String, String>> testDataMap = getTestDataList();
		Set<String> keySet = testDataMap.keySet();
		Map<String, String> currentDataMap = null;
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String quantity = "";
		String amount = "";

		for (String dataType1 : dataType)
		{
			for (String key : keySet)
			{
				if (key.equals(dataType1))
				{
					currentDataMap = testDataMap.get(key);
				}
				else
				{
					continue;
				}

				Set<String> dataKeySet = currentDataMap.keySet();
				Object[] keyArr = dataKeySet.toArray();

				WebUI.waitForElementNotPresent(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/LoadingSymbol"), GlobalVariable.CONDITIONAL_WAIT);

				List<WebElement> labelsList = driver.findElements(By.xpath("//tr[@class='align-items-start']/th"));
				String autocompleteTextboxXpath = WebElementWrapper.getXpath("Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormAutocompleteTextbox");
				List<WebElement> inputBoxList = ActionBot.findElements(driver, autocompleteTextboxXpath);
				int counter = 0;

				try
				{
					// radio button selection;
					if (splitBy.equalsIgnoreCase("Quantity"))
					{
						ActionBot.click(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormQuantityRadioButton");
						WebUI.waitForElementPresent(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/LoadingSymbol"), GlobalVariable.DEFAULT_WAIT);
						WebUI.waitForElementNotPresent(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/LoadingSymbol"), GlobalVariable.CONDITIONAL_WAIT);
						Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Waited for COA loader to go off after selecting Quantity");
						quantity = ActionBot.getTextByXpath(driver, "//div[@class='text-right']/p[contains(text(),'" + iConstants.COA_FORM_HEADING_QUANTITY_LABEL + "')]/following-sibling::p").trim();
					}
					else if (splitBy.equalsIgnoreCase("Amount"))
					{
						Thread.sleep(2000);
						WebElement amountElement = driver.findElement(By.xpath("//label[@class='custom-control-label'][contains(text(),'Amount')]"));
						amountElement.click();

						String amountStr = driver.findElement(By.xpath("//div[@class='text-right']/p[contains(text(),'Unit Price')]/following-sibling::p")).getText();
						if (amountStr.contains("USD"))
						{
							amountStr = amountStr.substring(amountStr.indexOf("USD") + 4);
							amountStr = amountStr.substring(0, amountStr.indexOf("."));
							amount = amountStr;

						}
					}

					for (int i = 0; i < splitSize; i++)
					{

						for (WebElement inputBox : inputBoxList)
						{
							List<WebElement> labelsList1 = ActionBot.findElements(driver, "//tr[@class='align-items-start']/th");
							String label = labelsList1.get(counter).getText().trim();
							String key1 = keyArr[counter].toString();
							String value = currentDataMap.get(key1);
							WebElement inputBoxEle = ActionBot.findElements(driver, autocompleteTextboxXpath).get(counter);

							jse.executeScript("arguments[0].scrollIntoView();", inputBoxEle);

							if (inputBoxEle.isDisplayed())
							{
								if (inputBoxEle.isEnabled())
								{
									fillDropDownValue(driver, value, (counter + 1));
								}
							}
							counter++;

						}

						if (splitBy.equalsIgnoreCase("percentage"))
						{
							Thread.sleep(10000);
							WebElement percentageEle = null;
							if (driver.findElements(By.xpath("(//dew-flexiform[1]//dew-input-container[contains(@class,'dew-input-container')]/input)[1]")).size() > 0)
							{
								percentageEle = driver.findElement(By.xpath("(//dew-flexiform[1]//dew-input-container[contains(@class,'dew-input-container')]/input)[1]"));
								jse.executeScript("arguments[0].scrollIntoView();", percentageEle);
							}
							if (percentageEle.isDisplayed())
							{
								percentageEle = driver.findElement(By.xpath("(//dew-flexiform[1]//dew-input-container[contains(@class,'dew-input-container')]/input)[1]"));
								if (percentageEle.isEnabled())
								{
									Actions navigator = new Actions(driver);
									navigator.click(percentageEle).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys("100").perform();

									/*
									 * percentageEle.click();
									 * percentageEle.clear();
									 * Thread.sleep(5000);
									 * percentageEle.sendKeys("100");
									 */

									WebElement saveButton = driver.findElement(By.xpath("//div[@class='dew-container d-flex justify-content-between align-items-center']//button[@class='btn primary']"));
									saveButton.click();
								}
							}
						}
						else if (splitBy.equalsIgnoreCase("Quantity"))
						{
							Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "After filling COA form");

							String quantityTextboxXpath = WebElementWrapper.getXpath("Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormQuantityTextbox");
							WebElement quantityEle = null;
							if (ActionBot.findElements(driver, quantityTextboxXpath).size() > 0)
							{
								// quantityEle =
								// ActionBot.findElementByXpath(driver,
								// quantityTextboxXpath);
								quantityEle = driver.findElement(By.xpath(quantityTextboxXpath));
								jse.executeScript("arguments[0].scrollIntoView();", quantityEle);

							}
							if (quantityEle.isDisplayed())
							{
								if (quantityEle.isEnabled())
								{
									checkIfQuantityFieldIsNotZero(driver, quantity);

									WebUI.waitForElementNotPresent(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/LoadingSymbol"), GlobalVariable.CONDITIONAL_WAIT);

									Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Before clicking on Save button on COA form");
									ActionBot.click(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormSaveButton");
									logger.info("Clicked on Save button on COA form");
									Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "After clicking on Save button on COA form");
								}
							}
						}
						else if (splitBy.equalsIgnoreCase("amount"))
						{
							WebElement amountEle = null;
							if (driver.findElements(By.xpath("(//dew-flexiform[1]//dew-input-container[contains(@class,'dew-input-container')]/input)[3]")).size() > 0)
							{
								amountEle = driver.findElement(By.xpath("(//dew-flexiform[1]//dew-input-container[contains(@class,'dew-input-container')]/input)[3]"));
								jse.executeScript("arguments[0].scrollIntoView();", amountEle);
							}
							if (amountEle.isDisplayed())
							{
								if (amountEle.isEnabled())
								{

									amountEle.click();
									amountEle.clear();
									amountEle.sendKeys(amount);
									WebElement saveButton = driver.findElement(By.xpath("//div[@class='dew-container d-flex justify-content-between align-items-center']//button[@class='btn primary']"));
									saveButton.click();
								}
							}
						}
					}
				}
				catch (Exception e)
				{
					throw e;
				}
			}
		}
	}

	public static void checkIfQuantityFieldIsNotZero(WebDriver driver, String quantity) throws Exception
	{
		try
		{
			float quantityValue = Float.parseFloat(ActionBot.getTextWithinElement(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormQuantityTextbox"));

			for (int j = 0; j < 2; j++)
			{
				if (quantityValue == 0)
				{
					ActionBot.click(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormQuantityTextbox");
					logger.info("Clicked on Quantity field");
					Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Clicked on Quantity field");
					ActionBot.clearWithBackspace(driver, MDC.get("TestCaseName").toString(), "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormQuantityTextbox");
					logger.info("Cleared Quantity field");
					Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Cleared Quantity field");

					WebUI.delay(GlobalVariable.DEFAULT_WAIT);
					ActionBot.sendKeys(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormQuantityTextbox", quantity);
					logger.info("Entered value in Quantity field");
					Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Entered value in Quantity field");
					WebUI.delay(GlobalVariable.DEFAULT_WAIT);

					ActionBot.click(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormQuantityRadioButton");
					WebUI.waitForElementNotPresent(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/LoadingSymbol"), GlobalVariable.CONDITIONAL_WAIT);
					logger.info("Waited for loader to go off after filling quantity");
					Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Waited for loader to go off after filling quantity");
					quantityValue = Float.parseFloat(ActionBot.getTextWithinElement(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormQuantityTextbox"));
				}
				else
				{
					break;
				}
			}
		}
		catch (Exception e)
		{
			float quantityValue = Float.parseFloat(ActionBot.getTextWithinElement(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormQuantityTextbox"));

			for (int j = 0; j < 5; j++)
			{
				if (quantityValue == 0)
				{
					ActionBot.click(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormQuantityTextbox");
					for (int k = 1; k < 10; k++)
					{
						ActionBot.sendKeys(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormQuantityTextbox", Keys.chord(Keys.BACK_SPACE));
					}
					WebUI.delay(GlobalVariable.DEFAULT_WAIT);
					ActionBot.sendKeys(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormQuantityTextbox", quantity);
					WebUI.delay(GlobalVariable.DEFAULT_WAIT);

					ActionBot.click(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormQuantityRadioButton");
					WebUI.waitForElementNotPresent(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/LoadingSymbol"), GlobalVariable.CONDITIONAL_WAIT);
					quantityValue = Float.parseFloat(ActionBot.getTextWithinElement(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormQuantityTextbox"));
				}
				else
				{
					break;
				}
			}
		}
	}

	public static void fillDropDownValue(WebDriver driver, String value, int counter) throws Exception
	{
		boolean flag = false;
		int count = 1;
		String autocompleteTextboxXpath = WebElementWrapper.getXpath("Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/COAFormAutocompleteTextbox");
		try
		{
			while ((!flag) && (count < 3))
			{
				autocompleteTextboxXpath = "(" + autocompleteTextboxXpath + ")[" + counter + "]";

				ActionBot.clickByXpath(driver, autocompleteTextboxXpath);
				logger.info("Clicked on COA form field");
				Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Clicked on COA form field");

				// WebUI.waitForElementPresent(driver,findTestObject(driver,"Check_Out_Page/Line
				// Item Details Tab/Shipping Asset Tagging/Cost Booking Details
				// Tab/FirstOption"), GlobalVariable.CONDITIONAL_WAIT);
				// WebUI.waitForElementVisible(driver,findTestObject(driver,"Check_Out_Page/Line
				// Item Details Tab/Shipping Asset Tagging/Cost Booking Details
				// Tab/FirstOption"), GlobalVariable.CONDITIONAL_WAIT);
				// WebUI.waitForElementClickable(driver,findTestObject(driver,"Check_Out_Page/Line
				// Item Details Tab/Shipping Asset Tagging/Cost Booking Details
				// Tab/FirstOption"), GlobalVariable.CONDITIONAL_WAIT);

				ActionBot.clearWithXpath(driver, autocompleteTextboxXpath);
				logger.info("Cleared COA form field");
				Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Cleared COA form field");

				ActionBot.sendKeysByXPath(driver, autocompleteTextboxXpath, value);
				logger.info("Entered value in COA form field");
				Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Entered value in COA form field");

				WebUI.waitForElementPresent(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/FirstOption"), GlobalVariable.CONDITIONAL_WAIT);
				WebUI.waitForElementVisible(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/FirstOption"), GlobalVariable.CONDITIONAL_WAIT);
				WebUI.waitForElementClickable(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/FirstOption"), GlobalVariable.CONDITIONAL_WAIT);

				ActionBot.click(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/FirstOption");
				logger.info("Selected first option for COA form field");
				Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Selected first option for CBL form field");

				WebUI.waitForElementPresent(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/LoadingSymbol"), GlobalVariable.DEFAULT_WAIT);
				WebUI.waitForElementNotPresent(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/LoadingSymbol"), GlobalVariable.CONDITIONAL_WAIT);
				logger.info("Waited for loader to go off after filling COA form field");
				Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Waited for loader to go off after filling COA form field");

				String fieldText = ActionBot.getTextWithinElementByXpath(driver, autocompleteTextboxXpath).trim();
				if (!fieldText.toLowerCase().contains(value.toLowerCase()))
				{
					flag = false;
				}
				else
				{
					flag = true;
				}
				count++;
			}
		}
		catch (Exception e)
		{
			logger.info("Reattempting to fill COA form field");
			flag = false;
			count = 1;
			while ((!flag) && (count < 3))
			{
				autocompleteTextboxXpath = "(" + autocompleteTextboxXpath + ")[" + counter + "]";

				ActionBot.clickByXpath(driver, autocompleteTextboxXpath);
				logger.info("Clicked on COA form field");
				Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Clicked on COA form field");

				// WebUI.waitForElementPresent(driver,findTestObject(driver,"Check_Out_Page/Line
				// Item Details Tab/Shipping Asset Tagging/Cost Booking Details
				// Tab/FirstOption"), 120);
				// WebUI.waitForElementVisible(driver,findTestObject(driver,"Check_Out_Page/Line
				// Item Details Tab/Shipping Asset Tagging/Cost Booking Details
				// Tab/FirstOption"), 120);
				// WebUI.waitForElementClickable(driver,findTestObject(driver,"Check_Out_Page/Line
				// Item Details Tab/Shipping Asset Tagging/Cost Booking Details
				// Tab/FirstOption"), 120);

				ActionBot.clearWithXpath(driver, autocompleteTextboxXpath);
				logger.info("Cleared COA form field");
				Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Cleared COA form field");

				ActionBot.sendKeysByXPath(driver, autocompleteTextboxXpath, value);
				logger.info("Entered value in COA form field");
				Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Entered value in COA form field");

				WebUI.waitForElementPresent(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/FirstOption"), GlobalVariable.CONDITIONAL_WAIT);
				WebUI.waitForElementVisible(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/FirstOption"), GlobalVariable.CONDITIONAL_WAIT);
				WebUI.waitForElementClickable(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/FirstOption"), GlobalVariable.CONDITIONAL_WAIT);

				ActionBot.click(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/FirstOption");
				logger.info("Selected first option for COA form field");
				Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Selected first option for CBL form field");

				WebUI.waitForElementPresent(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/LoadingSymbol"), GlobalVariable.DEFAULT_WAIT);
				WebUI.waitForElementNotPresent(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/LoadingSymbol"), GlobalVariable.CONDITIONAL_WAIT);
				logger.info("Waited for loader to go off after filling COA form field");
				Screenshot.captureScreenshot(driver, MDC.get("TestCaseName").toString(), "Waited for loader to go off after filling COA form field");

				String fieldText = ActionBot.getTextWithinElementByXpath(driver, autocompleteTextboxXpath).trim();
				if (!fieldText.toLowerCase().contains(value.toLowerCase()))
				{
					flag = false;
				}
				else
				{
					flag = true;
				}
				count++;
			}
		}
	}

	/**
	 * ;
	 * 
	 * @author: Priyanka;
	 * @description: fillNonCoaForm At Header Level;
	 * @param: driver,
	 *             requisitionBO, testcase;
	 * @return: Nil;
	 */
	public static void fillNonCoaAtHeaderLevel(WebDriver driver, RequisitionBO requisitionBO, String testcase) throws Exception
	{
		try
		{

			if (requisitionBO.getReqAssignedCost() != null)
			{
				if (requisitionBO.getReqAssignedCost().equalsIgnoreCase(iConstants.YES))
				{
					clickOnAssignCostYESButton(driver, testcase);
				}
				else
				{
					clickOnAssignCostNOButton(driver, testcase);
				}
			}

			if (requisitionBO.getAllowBudget() != null)
			{
				if (requisitionBO.getAllowBudget().equalsIgnoreCase(iConstants.YES))
				{
					clickOnAllowBudgetYESButton(driver, testcase);
				}
				else
				{
					clickOnAllowBudgetNOButton(driver, testcase);
				}
			}

			if (requisitionBO.isReqBookCostToSingleCostCenter())
			{
				clickOnBookCostToSingleCostCenter(driver, testcase);
				enterCostCenter(driver, requisitionBO.getCostCenter(), testcase);

				if (requisitionBO.getReqAssignedCost() != null)
				{
					if (requisitionBO.getReqAssignedCost().equalsIgnoreCase(iConstants.YES))
					{
						enterProject(driver, requisitionBO.getProject(), testcase);
					}
				}

				if (requisitionBO.getAllowBudget() != null)
				{
					if (requisitionBO.getAllowBudget().equalsIgnoreCase(iConstants.YES))
					{
						enterBudget(driver, requisitionBO.getBudget(), testcase);
					}
				}

				enterPercentageForNonCoaForm(driver, iConstants.SPLIT_PERCENTAGE, testcase);
			}

			if (requisitionBO.isReqSplitCostAtLineItemLevel())
			{
				clickOnBookCostAtLineItemLevel(driver, testcase);

				clickOnCostBookingConfirmPopUpYesButton(driver, testcase);

			}
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * ;
	 * 
	 * @author: Priyanka;
	 * @description: fillNonCoaForm At Line Item Level;
	 * @param: driver,
	 *             requisitionBO, testcase;
	 * @return: Nil;
	 */
	public static void fillNonCoaAtLineItemLevel(WebDriver driver, RequisitionBO requisitionBO, String testcase) throws Exception
	{
		try
		{
			if (requisitionBO.isSplitCostCenterAtItemLevel_percentage())
			{
				clickOnSplitCostByPercentage(driver, testcase);

				enterCostCenter(driver, requisitionBO.getCostCenter(), testcase);

				enterPercentageForNonCoaForm(driver, iConstants.SPLIT_PERCENTAGE, testcase);
			}

			if (requisitionBO.isSplitCostCenterAtItemLevel_quantity())
			{
				String quantityAmt = ActionBot.getTextByXpath(driver, "//div[@class='text-right']/p[contains(text(),'" + iConstants.COA_FORM_HEADING_QUANTITY_LABEL + "')]/following-sibling::p").trim();

				clickOnSplitCostByQuantity(driver, testcase);

				enterCostCenter(driver, requisitionBO.getCostCenter(), testcase);

				enterQuantityForNonCoaFrom(driver, quantityAmt, testcase);
			}

			// clickOnSaveButton(driver, testcase);

		}

		catch (Exception e)
		{
			throw e;
		}
	}

	public static void clickOnBookCostToSingleCostCenter(WebDriver driver, String testcase) throws Exception
	{
		try
		{
			ActionBot.click(driver, "FlowOR/Requisition/CostAllocation/BookCostAtSingleCostCenter");
			logger.info("Clicked on Book Cost To Single Cost Center");
			Screenshot.captureScreenshot(driver, testcase, "Clicked on Book Cost To Single Cost Center");
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static void clickOnBookCostAtLineItemLevel(WebDriver driver, String testcase) throws Exception
	{
		try
		{
			ActionBot.click(driver, "FlowOR/Requisition/CostAllocation/BookCostAtLineItemLevel");
			logger.info("Clicked on Book Cost At Line Item Level");
			Screenshot.captureScreenshot(driver, testcase, "Clicked on Book Cost At Line Item Level");
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static void clickOnCostBookingConfirmPopUpYesButton(WebDriver driver, String testcase) throws Exception
	{
		try
		{
			ActionBot.click(driver, "FlowOR/Requisition/CostAllocation/YesButton");
			logger.info("Clicked on Cost Booking Confirm PopUp Yes Button");
			Screenshot.captureScreenshot(driver, testcase, "Clicked on Cost Booking Confirm PopUp Yes Button");
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static String enterCostCenter(WebDriver driver, String costCenter, String testcaseName) throws Exception
	{
		try
		{
			String textFieldPath = WebElementWrapper.getXpath("FlowOR/Requisition/CostAllocation/CostCenter");
			// String suggestionPath =
			// WebElementWrapper.getXpath("FlowOR/Requisition/CostAllocation/CostCenterSuggestion");
			String suggestionPath = "//div[contains(text(),'" + costCenter + "')]";
			ActionBot.fillAutoCompleteItem(driver, testcaseName, textFieldPath, suggestionPath, costCenter);
			logger.info("Entered cost center " + costCenter);

			return costCenter;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static String enterProject(WebDriver driver, String project, String testcaseName) throws Exception
	{
		try
		{
			String textFieldXpath = WebElementWrapper.getXpath("FlowOR/Requisition/CostAllocation/Project");
			String suggestionPath = WebElementWrapper.getXpath("FlowOR/Requisition/CostAllocation/ProjectSuggestion");

			ActionBot.fillAutoCompleteItem(driver, testcaseName, textFieldXpath, suggestionPath, project);
			logger.info("Entered project " + project);

			return project;

		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static void clickOnSplitCostByPercentage(WebDriver driver, String testcase) throws Exception
	{
		try
		{
			ActionBot.click(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/SplitCostByPercentage");
			logger.info("Clicked on Split Cost By Percentage");
			Screenshot.captureScreenshot(driver, testcase, "Clicked on Split Cost By Percentage");
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static void clickOnSplitCostByQuantity(WebDriver driver, String testcase) throws Exception
	{
		try
		{
			ActionBot.click(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/SplitCostByQuantity");
			logger.info("Clicked on Split Cost By Quantity");
			Screenshot.captureScreenshot(driver, testcase, "Clicked on Split Cost By Quantity");
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static boolean clickOnSaveButton(WebDriver driver, String testcase) throws Exception
	{
		try
		{

			ActionBot.click(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/SaveButton");
			WebUI.delay(5);
			Screenshot.captureScreenshot(driver, testcase, "Clicked on Save COA form");
			logger.info("Save COA form");
			return FlowBpo.verifySection(driver, testcase, iConstants.BASIC_DETAILS_TAB);
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static String selectGLAccount(WebDriver driver, String glAccount, String testcase) throws Exception
	{
		try
		{
			String textField = WebElementWrapper.getXpath("Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/GLAccount");

			String suggestionPath = "//div[contains(@class,'suggestion') and contains(text(),'" + glAccount + "')]";

			ActionBot.fillAutoCompleteItem(driver, testcase, textField, suggestionPath, glAccount);

			logger.info("Selected GL Account");
			Screenshot.captureScreenshot(driver, testcase, "Selected GL Account");
			return glAccount;
		}
		catch (

		Exception e)
		{
			throw e;
		}
	}

	public static void enterPercentageForNonCoaForm(WebDriver driver, int percentage, String testcase) throws Exception
	{
		try
		{

			int precentageValue = Integer.parseInt(ActionBot.getTextWithinElement(driver, "FlowOR/Requisition/CostAllocation/PercentageInputField"));

			if (precentageValue == 0)
			{
				ActionBot.click(driver, "FlowOR/Requisition/CostAllocation/PercentageInputField");
				logger.info("Clicked on Quantity field");
				ActionBot.clearWithBackspace(driver, testcase, "FlowOR/Requisition/CostAllocation/PercentageInputField");
				logger.info("Cleared percenatge field");
				Screenshot.captureScreenshot(driver, testcase, "Cleared percenatge field");

				ActionBot.sendKeys(driver, "FlowOR/Requisition/CostAllocation/PercentageInputField", String.valueOf(percentage));
				logger.info("Entered value in Percentage field");
				Screenshot.captureScreenshot(driver, testcase, "Entered value in Percentage field");
				WebUI.delay(GlobalVariable.DEFAULT_WAIT);

				WebUI.waitForElementNotPresent(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/LoadingSymbol"), 120);
				logger.info("Waited for loader to go off after filling Percentage");
				Screenshot.captureScreenshot(driver, testcase, "Waited for loader to go off after filling Percentage");
				precentageValue = Integer.parseInt(ActionBot.getTextWithinElement(driver, "FlowOR/Requisition/CostAllocation/PercentageInputField"));
			}

		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static void enterQuantityForNonCoaFrom(WebDriver driver, String quantity, String testcase) throws Exception
	{
		try
		{
			float quantityValue = Float.parseFloat(ActionBot.getTextWithinElement(driver, "FlowOR/Requisition/CostAllocation/QuantityInputField"));

			for (int j = 0; j < 2; j++)
			{
				if (quantityValue == 0)
				{
					ActionBot.click(driver, "FlowOR/Requisition/CostAllocation/QuantityInputField");
					logger.info("Clicked on Quantity field");
					Screenshot.captureScreenshot(driver, testcase, "Clicked on Quantity field");
					ActionBot.clearWithBackspace(driver, testcase, "FlowOR/Requisition/CostAllocation/QuantityInputField");
					logger.info("Cleared Quantity field");
					Screenshot.captureScreenshot(driver, testcase, "Cleared Quantity field");

					WebUI.delay(GlobalVariable.DEFAULT_WAIT);
					ActionBot.sendKeys(driver, "FlowOR/Requisition/CostAllocation/QuantityInputField", quantity);
					logger.info("Entered value in Quantity field");
					Screenshot.captureScreenshot(driver, testcase, "Entered value in Quantity field");
					WebUI.delay(GlobalVariable.DEFAULT_WAIT);

					WebUI.waitForElementNotPresent(driver, findTestObject(driver, "Check_Out_Page/Line Item Details Tab/Shipping Asset Tagging/Cost Booking Details Tab/LoadingSymbol"), 120);
					logger.info("Waited for loader to go off after filling quantity");
					Screenshot.captureScreenshot(driver, testcase, "Waited for loader to go off after filling quantity");
					quantityValue = Float.parseFloat(ActionBot.getTextWithinElement(driver, "FlowOR/Requisition/CostAllocation/QuantityInputField"));
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
	}

	public static String enterBudget(WebDriver driver, String project, String testcaseName) throws Exception
	{
		try
		{
			String textFieldXpath = WebElementWrapper.getXpath("FlowOR/Requisition/CostAllocation/Budget");

			String suggestionPath = WebElementWrapper.getXpath("FlowOR/Requisition/CostAllocation/ProjectSuggestion");

			ActionBot.fillAutoCompleteItem(driver, testcaseName, textFieldXpath, suggestionPath, project);
			logger.info("Entered project " + project);

			return project;

		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static void clickOnAssignCostYESButton(WebDriver driver, String testcase) throws Exception
	{
		ActionBot.click(driver, "FlowOR/Requisition/CostAllocation/AssignCostYESRadioButton");
		logger.info("Clicked on Assign Cost YES Button");
		Screenshot.captureScreenshot(driver, testcase, "Clicked on Assign Cost YES Button");
	}

	public static void clickOnAssignCostNOButton(WebDriver driver, String testcase) throws Exception
	{
		ActionBot.click(driver, "FlowOR/Requisition/CostAllocation/AssignCostNORadioButton");
		logger.info("Clicked on Assign Cost NO Button");
		Screenshot.captureScreenshot(driver, testcase, "Clicked on Assign Cost NO Button");
	}

	public static void clickOnAllowBudgetYESButton(WebDriver driver, String testcase) throws Exception
	{
		ActionBot.click(driver, "FlowOR/Requisition/CostAllocation/AllowBudgetYESRadioButton");
		logger.info("Clicked on Assign Cost YES Button");
		Screenshot.captureScreenshot(driver, testcase, "Clicked on Assign Cost YES Button");
	}

	public static void clickOnAllowBudgetNOButton(WebDriver driver, String testcase) throws Exception
	{
		ActionBot.click(driver, "FlowOR/Requisition/CostAllocation/AllowBudgetNORadioButton");
		logger.info("Clicked on Allow Budget NO Button");
		Screenshot.captureScreenshot(driver, testcase, "Clicked on Allow Budget NO Button");
	}
}
