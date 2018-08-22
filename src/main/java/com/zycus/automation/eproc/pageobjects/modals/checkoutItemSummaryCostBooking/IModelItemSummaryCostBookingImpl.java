package com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCostBooking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCommon.IModelItemSummaryCommon;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

public class IModelItemSummaryCostBookingImpl implements IModelItemSummaryCostBooking
{

	static Logger logger = Logger.getLogger(IModelItemSummaryCostBookingImpl.class);

	@Override
	public void clickCostBookingItemSplitAdd(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{

		ActionBot.click(driver, By.xpath(".//*[@id='costing_item_" + itemID + "_" + index + "']//*[@class='icon add']"));
		ScreenShot.screenshot(driver, testCaseName, "Add New");

	}

	@Override
	public void clickCostBookingItemSplitDelete(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{

		ActionBot.click(driver, By.xpath(".//*[@id='costing_item_" + itemID + "_" + index + "']//*[@class='icon remove']"));
		ScreenShot.screenshot(driver, testCaseName, "Delete New");
	}

	@Override
	public String fillCostBookingItemSplitBudget(WebDriver driver, String testCaseName, String itemSplitBudget, String itemID, int index) throws ActionBotException
	{
		String budget = null;
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='costing_item_budget_" + itemID + "_" + index + "']")))
		{
			WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='costing_item_budget_" + itemID + "_" + index + "']"));
			ActionBot.fillAutoCompleteField(driver, ele, itemSplitBudget);
			budget = ele.getAttribute("value").trim();
		}
		logger.info("Budget : " + budget);
		return budget;
	}

	@Override
	public String fillCostBookingItemSplitProject(WebDriver driver, String testCaseName, String itemSplitProject, String itemID, int index) throws ActionBotException
	{
		String project = null;
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='costing_item_project_" + itemID + "_" + index + "']")))
		{
			WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='costing_item_project_" + itemID + "_" + index + "']"));
			ActionBot.fillAutoCompleteField(driver, ele, itemSplitProject);
			project = ele.getAttribute("value").trim();
		}
		logger.info("Project : " + project);
		return project;
	}

	@Override
	public String fillCostBookingItemSplitCostCenter(WebDriver driver, String testCaseName, String itemSplitCostCenter, String itemID, int index) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='costing_item_costCenter_" + itemID + "_" + index + "']"));

		ActionBot.fillAutoCompleteField(driver, ele, itemSplitCostCenter);
		String costCenter = ele.getAttribute("value").trim();
		logger.info("Cost Center : " + costCenter);
		return costCenter;
	}

	@Override
	public int fillCostBookingItemSplitPercentage(WebDriver driver, String testCaseName, int itemSplitPercentage, String itemID, int index) throws ActionBotException
	{

		String percentage = Integer.toString(itemSplitPercentage);
		int per = 0;
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='costing_item_percentage_" + itemID + "_" + index + "']"));

		if (ele.isDisplayed())
		{
			ele.clear();
			ele.sendKeys(percentage);

			percentage = ele.getAttribute("value").trim();
			logger.info("Percentage : " + percentage);
			ScreenShot.screenshot(driver, testCaseName, "After changing percentage");
			if (percentage != null)
			{
				if (percentage.trim().length() != 0)
				{
					per = Integer.parseInt(percentage);
				}
			}
			ActionBot.click(driver, By.xpath(".//*[@id='costing_item_price_" + itemID + "_" + index + "']"));
		}
		return per;
	}

	@Override
	public int fillCostBookingItemSplitQuantity(WebDriver driver, String testCaseName, int itemSplitQty, String itemID, int index) throws ActionBotException
	{

		String quantity = Integer.toString(itemSplitQty);
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='costing_item_quantity_" + itemID + "_" + index + "']"));
		if (ele.isDisplayed())
		{
			ele.clear();
			ele.sendKeys(quantity);

			quantity = ele.getAttribute("value").trim();
			logger.info("Quantity : " + quantity);
			ScreenShot.screenshot(driver, testCaseName, "After changing quantity");
			ActionBot.click(driver, By.xpath(".//*[@id='costing_item_price_" + itemID + "_" + index + "']"));
		}
		return Integer.parseInt(quantity);
	}

	@Override
	public String getCostBookingItemSplitAmount(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{
		String amt = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='costing_item_price_" + itemID + "_" + index + "']"));
		logger.info("Cost Booking Item Split Amount : " + amt);
		return amt;
	}

	@Override
	public String getCostBookingSingleSplitAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String amt = ActionBot.findElement(driver, COSTBOOKING_HEADER_SPLIT_AMOUNT).getText();
		if (amt != null)
		{
			return amt;
		}
		else
		{
			return null;
		}

	}

	@Override
	public String getCostBookingSingleSplitBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String budget = ActionBot.findElement(driver, COSTBOOKING_HEADER_SPLIT_BUDGET).getText();
		if (budget != null)
		{
			return budget;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getCostBookingSingleSplitCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String cc = ActionBot.findElement(driver, COSTBOOKING_HEADER_SPLIT_COSTCENTER).getText();
		if (cc != null)
		{
			return cc;
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean selectCostBookingOptionItemSplitPercent(WebDriver driver, String testCaseName) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, COSTBOOKING_ITEM_SPLIT_OPTION_PERCENT);
		ele.click();

		if (ele.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean selectCostBookingOptionItemSplitQtyDelivery(WebDriver driver, String testCaseName) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, COSTBOOKING_ITEM_SPLIT_OPTION_QTY_DELIVERY);
		ele.click();

		if (ele.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean selectCostBookingOptionItemSplitQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, COSTBOOKING_ITEM_SPLIT_OPTION_QUANTITY);
		ele.click();

		if (ele.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean selectCostBookingOptionMultiSplit(WebDriver driver, String testCaseName) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, COSTBOOKING_OPTION_ITEM_SPLIT);
		ele.click();

		if (ele.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean selectCostBookingOptionSingleSplit(WebDriver driver, String testCaseName) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, COSTBOOKING_OPTION_HEADER_SPLIT);
		ele.click();

		if (ele.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getCostCenterForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String costCenter = ActionBot.getAttributeOfElement(driver, By.id("costing_item_costCenter_" + itemId + "_" + index), "value");
		logger.info("Cost Center To for CC split proportional to delivery : " + costCenter);
		return costCenter;
	}

	@Override
	public String getDeliverToForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String deliverTo = ActionBot.getTextWithInElement(driver, By.id("costing_item_deliverTo_" + itemId + "_" + index));
		logger.info("Deliver To for CC split proportional to delivery : " + deliverTo);
		return deliverTo;
	}

	@Override
	public String getDeliveryAddressForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String deliveryAddress = ActionBot.getTextWithInElement(driver, By.id("costing_item_location_" + itemId + "_" + index));
		logger.info("Delivery Address for CC split proportional to delivery : " + deliveryAddress);
		return deliveryAddress;
	}

	@Override
	public int getQuantityForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String quantity = ActionBot.getTextWithInElement(driver, By.id("costing_item_lblQuantity_" + itemId + "_" + index));
		logger.info("Quantity for CC split proportional to delivery : " + quantity);
		String[] temp = StringUtils.split(quantity, " ");
		int quant = Integer.parseInt(temp[0].trim());
		return quant;
	}

	@Override
	public String getAmountForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String price = ActionBot.getTextWithInElement(driver, By.id("costing_item_price_" + itemId + "_" + index));
		logger.info("Price for CC split proportional to delivery : " + price);
		return price;
	}

	// changed as per accounting-cost booking merging feature
	@Override
	public String fillAccountingGLAccount(WebDriver driver, String testCaseName, String accountingGLAccountCode, String itemID, int index) throws ActionBotException
	{
		String xpath = ".//*[@id='generalLedger_" + itemID + "_" + index + "']";
		if (ActionBot.isElementDisplayed(driver, By.xpath(xpath)))
		{
			WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='generalLedger_" + itemID + "_" + index + "']"));
			if (ele.isDisplayed())
			{
				if (accountingGLAccountCode != null)
				{
					ActionBot.fillAutoCompleteField(driver, ele, accountingGLAccountCode);
				}
				else
				{
					if (ele.getAttribute("value").equals(""))
					{
						ele.click();
						ele.sendKeys(Keys.ARROW_DOWN);
						ActionBot.defaultSleep();
						ele.sendKeys(Keys.RETURN);
					}
				}

				ActionBot.defaultSleep();
				if (ele.getAttribute("value") != null)
				{
					return ele.getAttribute("value");
				}
				else
				{
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public String getSubTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String subTotalPrice = ActionBot.getTextWithInElement(driver, ITEMSUMMARY_ITEM_TOTALPRICE);
		logger.info("Item Sub Total Price : " + subTotalPrice);
		return subTotalPrice;
	}

	@Override
	public String getMessageOfAccountingInfoFromQtip(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clickOnSaveItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clickOnCancelItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isGLAccountPresent(WebDriver driver, String testCaseName, String id, int index) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='generalLedger_" + id + "_" + index + "']")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<WebElement> getListOfAvailableGLAccounts(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LIST_OF_GL_ACCOUNTS_AVAILABLE_FOR_SELECTION);
	}

	@Override
	public List<String> getListOfNamesAvailableGLAccounts(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> glAccountsNames = new ArrayList<String>();

		for (WebElement element : getListOfAvailableGLAccounts(driver, testCaseName))
		{
			glAccountsNames.add(element.getText().trim());
		}

		return glAccountsNames;
	}

	@Override
	public void clearGLAccounts(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException, TestCaseException
	{
		WebElement element = ActionBot.findElement(driver, By.xpath(".//*[@id='generalLedger_" + itemID + "_" + index + "']"));
		ActionBot.clear(driver, By.xpath(".//*[@id='generalLedger_" + itemID + "_" + index + "']"));
		element.sendKeys(Keys.SPACE);
		element.sendKeys(Keys.SPACE);
		ActionBot.defaultSleep();
	}

	@Override
	public String getGLAccount(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException, TestCaseException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isProjectNonEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clickOnBookCostTOSingleCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SPLITCOSTINGLEVEL_HEADER_LINK);

	}

	@Override
	public String fillAssetCode(WebDriver driver, String testCaseName, String assetCode, String itemID) throws ActionBotException, TestCaseException
	{
		ActionBot.clear(driver, By.xpath(assetCodeXpath1 + itemID + assetCodeXpath2));
		String str = ActionBot.sendKeys(driver, By.xpath(assetCodeXpath1 + itemID + assetCodeXpath2), assetCode);
		return str;
	}

	@Override
	public boolean isAssetCodeTextboxPresent(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, By.xpath(assetCodeXpath1 + itemID + assetCodeXpath2)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getAssetCode(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath(assetCodeXpath1 + itemID + assetCodeXpath2));
	}

	@Override
	public List<WebElement> getListOfCostCenters(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LIST_OF_COST_CENTERS_IN_REQUISITION_ITEM_SUMMARY);
	}

	@Override
	public List<String> getListOfCostCentersNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> listOfCostCenters = getListOfCostCenters(driver, testCaseName);
		List<String> listOfCostCenterNames = new ArrayList<>();
		for (WebElement element : listOfCostCenters)
		{
			listOfCostCenterNames.add(element.getText());
		}
		return listOfCostCenterNames;
	}

	@Override
	public String getCostBookingItemSplitCostCenter(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String costCenter = ActionBot.getAttributeOfElement(driver, By.xpath(".//*[@id='costing_item_costCenter_" + itemId + "_" + index + "']"), "value");
		logger.info("Cost Center : " + costCenter);
		return costCenter;
	}

	@Override
	public void clearCostCenterWithSpace(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, By.xpath(".//*[@id='costing_item_costCenter_" + itemId + "_" + index + "']"));
		element.clear();
		element.sendKeys(Keys.SPACE);
		element.sendKeys(Keys.SPACE);
	}

	@Override
	public List<WebElement> getListOfProjects(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LIST_OF_PROJECT_IN_REQUISITION_ITEM_SUMMARY);
	}

	@Override
	public List<String> getListOfProjectNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> listOfProjects = getListOfProjects(driver, testCaseName);
		List<String> listOfProjectNames = new ArrayList<>();
		for (WebElement element : listOfProjects)
		{
			listOfProjectNames.add(element.getText());
		}
		return listOfProjectNames;
	}

	@Override
	public String getCostBookingItemSplitProject(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		String project = null;
		ActionBot.getAttributeOfElement(driver, By.xpath(".//*[@id='costing_item_project_" + itemId + "_" + index + "']"), "value");

		logger.info("Project : " + project);
		return project;
	}

	@Override
	public void clearProjectWithSpace(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, By.xpath(".//*[@id='costing_item_project_" + itemId + "_" + index + "']"));
		element.clear();
		element.sendKeys(Keys.SPACE);
		element.sendKeys(Keys.SPACE);
	}

	@Override
	public String getGLAccountHeaderAtItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String glAccount = ActionBot.getTextWithInElement(driver, LABEL_GL_ACCOUNT_AT_ITEM_LEVEL);
		logger.info("Gl Account Label at Item Level : " + glAccount);
		return glAccount;
	}

	@Override
	public boolean isGeneralLedgerDetailsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.hover(driver, GL_LEDGER_DETAILS);
		if (ActionBot.isElementPresent(driver, GL_LEDGER_DETAILS))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isGlAccountMandatorySignPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, GL_ACCOUNT_MANDATORY_SIGN))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void waitTillCOAFormLoaderDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, LOADER_COA_FORM);
		ActionBot.waitTillPopUpIsPresent(driver, COA_FORM_POPUP_LOADER);
		ScreenShot.screenshot(driver, testCaseName, "After COA form loader");
	}

	@Override
	public String fillBU_CoaForm(WebDriver driver, String testCaseName, String businessUnit, boolean editForm) throws ActionBotException
	{
		String bu = null;
		try
		{
			if (editForm)
			{
				bu = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_BUSINESS_UNIT_EDIT, businessUnit);
				ScreenShot.screenshot(driver, testCaseName, "After filling BU");
				return bu;
			}
			else
			{
				bu = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_BUSINESS_UNIT, businessUnit);
				ScreenShot.screenshot(driver, testCaseName, "After filling BU");
				return bu;
			}
		}
		catch (StaleElementReferenceException e)
		{
			logger.info("Stale Element Exception received while filling Business Unit field in COA form: " + e);
			try
			{
				bu = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_BUSINESS_UNIT, businessUnit);
				return bu;
			}
			catch (Exception e1)
			{
				logger.info("Error while filling Business Unit field in COA form: " + e1);
			}

		}
		catch (Exception e1)
		{
			logger.info("Error while filling Business Unit field in COA form: " + e1);
		}
		return bu;

	}

	@Override
	public String fillGeneralLedger_CoaForm(WebDriver driver, String testCaseName, String generalLedger, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{
			ActionBot.clear(driver, COA_FORM_TEXT_GENERAL_LEDGER_EDIT);
			String gl = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_GENERAL_LEDGER_EDIT, generalLedger);
			ScreenShot.screenshot(driver, testCaseName, "After filling GL");
			return gl;
		}
		else
		{
			ActionBot.clear(driver, COA_FORM_TEXT_GENERAL_LEDGER);
			String gl = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_GENERAL_LEDGER, generalLedger);
			ScreenShot.screenshot(driver, testCaseName, "After filling GL");
			return gl;
		}

	}

	@Override
	public String fillCostCenter_CoaForm(WebDriver driver, String testCaseName, String costCenter, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{
			ActionBot.clear(driver, COA_FORM_TEXT_COST_CENTER_EDIT);
			String cc = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_COST_CENTER_EDIT, costCenter);
			ScreenShot.screenshot(driver, testCaseName, "After filling CC");
			return cc;
		}
		else
		{
			ActionBot.clear(driver, COA_FORM_TEXT_COST_CENTER);
			String cc = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_COST_CENTER, costCenter);
			ScreenShot.screenshot(driver, testCaseName, "After filling CC");
			return cc;
		}

	}

	@Override
	public String fillProject_CoaForm(WebDriver driver, String testCaseName, String project, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{
			ActionBot.clear(driver, COA_FORM_TEXT_PROJECT_EDIT);
			String pro = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_PROJECT_EDIT, project);
			ScreenShot.screenshot(driver, testCaseName, "After filling Project");
			return pro;
		}
		else
		{
			ActionBot.clear(driver, COA_FORM_TEXT_PROJECT);
			String pro = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_PROJECT, project);
			ScreenShot.screenshot(driver, testCaseName, "After filling Project");
			return pro;
		}

	}

	@Override
	public String clickCostBookingOnRadioButton_CoaForm(WebDriver driver, String testCaseName, String radioButtonName) throws ActionBotException
	{
		if (radioButtonName.equalsIgnoreCase(IConstantsData.PERCENTAGE))
		{
			ActionBot.click(driver, COA_FORM_RADIO_PERCENTAGE);
			ScreenShot.screenshot(driver, testCaseName, "After clicking on Percentage radio button");
			return radioButtonName;
		}
		else if (radioButtonName.equalsIgnoreCase(IConstantsData.Quantity))
		{
			ActionBot.click(driver, COA_FORM_RADIO_QUANTITY);
			ScreenShot.screenshot(driver, testCaseName, "After clicking on Quantity radio button");
			return radioButtonName;
		}
		else if (radioButtonName.equalsIgnoreCase(IConstantsData.AMOUNT))
		{
			ActionBot.click(driver, COA_FORM_RADIO_AMOUNT);
			ScreenShot.screenshot(driver, testCaseName, "After clicking on Amount radio button");
			return radioButtonName;
		}
		else
		{
			logger.info("Invalid Name provided for method clickCostBookingOnRadioButton_CoaForm: " + radioButtonName);
			return radioButtonName;
		}
	}

	@Override
	public String fillSubAccount_CoaForm(WebDriver driver, String testCaseName, String subAccount, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{
			ActionBot.clear(driver, COA_FORM_TEXT_SUB_ACCOUNT_EDIT);
			String subAcc = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_SUB_ACCOUNT_EDIT, subAccount);
			ScreenShot.screenshot(driver, testCaseName, "After filling SubAccount");
			return subAcc;
		}
		else
		{
			ActionBot.clear(driver, COA_FORM_TEXT_SUB_ACCOUNT);
			String subAcc = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_SUB_ACCOUNT, subAccount);
			ScreenShot.screenshot(driver, testCaseName, "After filling SubAccount");
			return subAcc;
		}

	}

	@Override
	public String fillProduct_CoaForm(WebDriver driver, String testCaseName, String product, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{
			ActionBot.clear(driver, COA_FORM_TEXT_PRODUCT_EDIT);
			String prod = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_PRODUCT_EDIT, product);
			ScreenShot.screenshot(driver, testCaseName, "After filling Product");
			return prod;
		}
		else
		{
			ActionBot.clear(driver, COA_FORM_TEXT_PRODUCT);
			String prod = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_PRODUCT, product);
			ScreenShot.screenshot(driver, testCaseName, "After filling Product");
			return prod;
		}

	}

	@Override
	public String fillGeoAccount_CoaForm(WebDriver driver, String testCaseName, String geoAccount, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{
			ActionBot.clear(driver, COA_FORM_TEXT_GEO_ACCOUNT_EDIT);
			String geoAcc = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_GEO_ACCOUNT_EDIT, geoAccount);
			ScreenShot.screenshot(driver, testCaseName, "After filling GEOAccount");
			return geoAcc;
		}
		else
		{
			ActionBot.clear(driver, COA_FORM_TEXT_GEO_ACCOUNT);
			String geoAcc = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_GEO_ACCOUNT, geoAccount);
			ScreenShot.screenshot(driver, testCaseName, "After filling GEOAccount");
			return geoAcc;
		}

	}

	@Override
	public String fillOperationalUnit_CoaForm(WebDriver driver, String testCaseName, String operationalUnit, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{
			ActionBot.clear(driver, COA_FORM_TEXT_OPERATIONAL_UNIT_EDIT);
			String opUnit = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_OPERATIONAL_UNIT_EDIT, operationalUnit);
			ScreenShot.screenshot(driver, testCaseName, "After filling OU");
			return opUnit;
		}
		else
		{
			ActionBot.clear(driver, COA_FORM_TEXT_OPERATIONAL_UNIT);
			String opUnit = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_OPERATIONAL_UNIT, operationalUnit);
			ScreenShot.screenshot(driver, testCaseName, "After filling OU");
			return opUnit;
		}

	}

	@Override
	public String fillPercentage_CoaForm(WebDriver driver, String testCaseName, String percentage, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{
			ActionBot.clear(driver, COA_FORM_TEXT_PERCENTAGE_EDIT);
			String per = ActionBot.sendKeys(driver, COA_FORM_TEXT_PERCENTAGE_EDIT, percentage);
			ScreenShot.screenshot(driver, testCaseName, "After filling Percentage");
			return per;
		}
		else
		{
			ActionBot.clear(driver, COA_FORM_TEXT_PERCENTAGE);
			String per = ActionBot.sendKeys(driver, COA_FORM_TEXT_PERCENTAGE, percentage);
			ScreenShot.screenshot(driver, testCaseName, "After filling Percentage");
			return per;
		}

	}

	@Override
	public String fillQuantity_CoaForm(WebDriver driver, String testCaseName, String quantity, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{
			ActionBot.clear(driver, COA_FORM_TEXT_QUANTITY_EDIT);
			String quant = ActionBot.sendKeys(driver, COA_FORM_TEXT_QUANTITY_EDIT, quantity);
			ScreenShot.screenshot(driver, testCaseName, "After filling Quantity");
			return quant;
		}
		else
		{
			ActionBot.clear(driver, COA_FORM_TEXT_QUANTITY);
			String quant = ActionBot.sendKeys(driver, COA_FORM_TEXT_QUANTITY, quantity);
			ScreenShot.screenshot(driver, testCaseName, "After filling Quantity");
			return quant;
		}

	}

	@Override
	public String fillAmount_CoaForm(WebDriver driver, String testCaseName, String amount, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{
			ActionBot.clear(driver, COA_FORM_TEXT_AMOUNT_EDIT);
			String amt = ActionBot.sendKeys(driver, COA_FORM_TEXT_AMOUNT_EDIT, amount);
			ScreenShot.screenshot(driver, testCaseName, "After filling Amount");
			return amt;
		}
		else
		{
			ActionBot.clear(driver, COA_FORM_TEXT_AMOUNT);
			String amt = ActionBot.sendKeys(driver, COA_FORM_TEXT_AMOUNT, amount);
			ScreenShot.screenshot(driver, testCaseName, "After filling Amount");
			return amt;
		}

	}

	@Override
	public boolean clickAddButton_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, COA_FORM_BUTTON_ADD);
		ActionBot.click(driver, COA_FORM_BUTTON_ADD);
		ActionBot.defaultSleep();

		if (ActionBot.isElementDisplayed(driver, COA_FORM_BUTTON_EDIT_FIRST_ITEM))
		{
			ScreenShot.screenshot(driver, testCaseName, "COA record added successfully");
			WebElement ele = ActionBot.findElement(driver, By.xpath("(.//*[contains(@class,'eformDataTable ')]//*[contains(@class,'FinalAmount')])[1]"));
			ActionBot.scroll(driver, ele);
			ScreenShot.screenshot(driver, testCaseName, "Final Amount Generated");
			return true;
		}
		else
		{
			WebElement ele = ActionBot.findElement(driver, By.xpath("(.//*[contains(@class,'eformDataTable ')]//*[contains(@class,'FinalAmount')])[1]"));
			ActionBot.scroll(driver, ele);

			ScreenShot.screenshot(driver, testCaseName, "Error while adding COA record");
			return false;
		}

	}

	@Override
	public String fillBookCostTo_CoaForm(WebDriver driver, String testCaseName, String bookCostTo, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{
			WebElement ele = ActionBot.findElement(driver, COA_FORM_TEXT_BOOK_COST_TO);
			// ((JavascriptExecutor)
			// driver).executeScript("window.scrollBy(0,1000)");
			ActionBot.scroll(driver, ele);
			ActionBot.click(driver, ICON_BOOK_COST_TO_EDIT_CLOSE);
			ActionBot.clear(driver, COA_FORM_TEXT_BOOK_COST_TO_EDIT);
			String bookCost = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_BOOK_COST_TO_EDIT, bookCostTo);
			ActionBot.defaultLowSleep();
			ScreenShot.screenshot(driver, testCaseName, "After filling BookCostTo");
			return bookCost;
		}
		else
		{
			WebElement ele = ActionBot.findElement(driver, COA_FORM_TEXT_BOOK_COST_TO);
			ActionBot.scroll(driver, ele);
			ActionBot.clear(driver, COA_FORM_TEXT_BOOK_COST_TO);
			String bookCost = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_BOOK_COST_TO, bookCostTo);
			ActionBot.defaultLowSleep();
			ScreenShot.screenshot(driver, testCaseName, "After filling BookCostTo");
			return bookCost;
		}

	}

	@Override
	public String fillClient_CoaForm(WebDriver driver, String testCaseName, String client, boolean editForm) throws ActionBotException
	{
		String Client;
		if (editForm)
		{
			ActionBot.clear(driver, COA_FORM_TEXT_CLIENT_EDIT);
			Client = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_CLIENT_EDIT, client);
			ScreenShot.screenshot(driver, testCaseName, "After filling Client");
			return Client;
		}
		else
		{
			ActionBot.clear(driver, COA_FORM_TEXT_CLIENT);
			Client = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_CLIENT, client);
			ScreenShot.screenshot(driver, testCaseName, "After filling Client");
			return Client;
		}

	}

	@Override
	public String fillEmployeeTimekeeper_CoaForm(WebDriver driver, String testCaseName, String empTimeKeeper, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{
			ActionBot.clear(driver, COA_FORM_TEXT_EMPLOYEE_TIMEKEEPER_EDIT);
			String timeKeeper = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_EMPLOYEE_TIMEKEEPER_EDIT, empTimeKeeper);
			ScreenShot.screenshot(driver, testCaseName, "After filling TImeKeeper");
			return timeKeeper;
		}
		else
		{
			ActionBot.clear(driver, COA_FORM_TEXT_EMPLOYEE_TIMEKEEPER);
			String timeKeeper = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_EMPLOYEE_TIMEKEEPER, empTimeKeeper);
			ScreenShot.screenshot(driver, testCaseName, "After filling TImeKeeper");
			return timeKeeper;
		}

	}

	@Override
	public String fillCostDisbursementCode_CoaForm(WebDriver driver, String testCaseName, String costDisCode, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{
			ActionBot.clear(driver, COA_FORM_TEXT_COST_DISBURSEMENT_CODE_EDIT);
			String disbursementCode = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_COST_DISBURSEMENT_CODE_EDIT, costDisCode);
			ScreenShot.screenshot(driver, testCaseName, "After filling DisbursementCode");
			return disbursementCode;
		}
		else
		{
			ActionBot.clear(driver, COA_FORM_TEXT_COST_DISBURSEMENT_CODE);
			String disbursementCode = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_COST_DISBURSEMENT_CODE, costDisCode);
			ScreenShot.screenshot(driver, testCaseName, "After filling DisbursementCode");
			return disbursementCode;
		}

	}

	@Override
	public String fillDepartment_CoaForm(WebDriver driver, String testCaseName, String department, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{
			ActionBot.clear(driver, COA_FORM_TEXT_DEPARTMENT_EDIT);
			String dept = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_DEPARTMENT_EDIT, department);
			ScreenShot.screenshot(driver, testCaseName, "After filling Department");
			return dept;
		}
		else
		{
			ActionBot.clear(driver, COA_FORM_TEXT_DEPARTMENT);
			String dept = ActionBot.fillAutoCompleteField(driver, COA_FORM_TEXT_DEPARTMENT, department);
			ScreenShot.screenshot(driver, testCaseName, "After filling Department");
			return dept;
		}

	}

	@Override
	public void fillTransactionDate_CoaForm(WebDriver driver, String testCaseName, int day, int month, int year, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{
			// ActionBot.click(driver, COA_FORM_TEXT_TRANSACTION_DATE_EDIT);
		}
		else
		{
			ActionBot.click(driver, COA_FORM_TEXT_TRANSACTION_DATE);
			// year
			Select select = new Select(ActionBot.findElement(driver, By.xpath("(.//*[@data-handler='selectYear'])[2]")));
			select.selectByValue(year + "");

			// month
			select = new Select(ActionBot.findElement(driver, By.xpath("(.//*[@data-handler='selectMonth'])[2]")));
			select.selectByValue(month + "");

			// day
			// ActionBot.click(driver, By.linkText(day));
			WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='zydf-ui-datepicker-div']//*[text()='" + day + "']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", ele);

			ScreenShot.screenshot(driver, testCaseName, "After filling Date");
		}

	}

	@Override
	public String fillDescription_CoaForm(WebDriver driver, String testCaseName, String description, boolean editForm) throws ActionBotException
	{
		if (editForm)
		{

			ActionBot.clear(driver, COA_FORM_TEXT_DESCRIPTION_EDIT);
			String desc = ActionBot.sendKeys(driver, COA_FORM_TEXT_DESCRIPTION_EDIT, description);
			ScreenShot.screenshot(driver, testCaseName, "After filling Description");
			return desc;
		}
		else
		{
			WebElement element = ActionBot.findElement(driver, COA_FORM_TEXT_DESCRIPTION);
			ActionBot.scroll(driver, element);

			ActionBot.clear(driver, COA_FORM_TEXT_DESCRIPTION);
			String desc = ActionBot.sendKeys(driver, COA_FORM_TEXT_DESCRIPTION, description);
			//			try
			//			{
			//				ActionBot.clear(driver, By.xpath(".//*[contains(@class,'clnTblHeaderRow')]//td[contains(@class,'Description')]//textarea[1]"));
			//			}
			//			catch (TestCaseException e)
			//			{
			//				// TODO Auto-generated catch block
			//				e.printStackTrace();
			//			}
			//			String desc = ActionBot.sendKeys(driver, By.xpath(".//*[contains(@class,'clnTblHeaderRow')]//td[contains(@class,'Description')]//textarea[1]"), description);
			ScreenShot.screenshot(driver, testCaseName, "After filling Description");
			return desc;
		}

	}

	@Override
	public int getQuantityFromItemSummary(WebDriver driver, String testCaseName) throws ActionBotException

	{
		WebElement quant = driver.findElement(By.xpath("//input[@id='txtItemQuantity']/following-sibling::span[@id='lblItemQuantity']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		int quantity = Integer.parseInt(jse.executeScript("return arguments[0].innerHTML", quant).toString());
		return quantity;

	}

	@Override
	public double getTotalAmountFromItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String amount = ActionBot.findElement(driver, ITEMSUMMARY_ITEM_TOTALPRICE).getText();
		String getAmount[] = amount.split(" ");
		String Amount = getAmount[1].replaceAll(",", "").trim().replaceAll("\\s{2,}", " ");
		return Double.parseDouble(Amount);
	}

	@Override
	public void updateQuantityFromItemSummary(WebDriver driver, String testCaseName, int quantity) throws ActionBotException
	{
		ActionBot.clear(driver, IModelItemSummaryCommon.ITEMSUMMARY_ITEM_QUANTITY);
		ActionBot.sendKeys(driver, IModelItemSummaryCommon.ITEMSUMMARY_ITEM_QUANTITY, quantity + "");
		logger.info("Item quantity updated to " + quantity);
	}

	@Override
	public void clickOnEditIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, ICON_EDIT_COA_FORM);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", ele);

		ScreenShot.screenshot(driver, testCaseName, "After clicking on Edit Icon");
	}

	@Override
	public void clickOnDeleteIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, ICON_DELETE_COA_FORM);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", ele);
		ActionBot.waitTillPopUpIsPresent(driver, COA_FORM_POPUP_LOADER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Delete Icon");
	}

	@Override
	public void clickOnSaveIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, ICON_EDIT_SAVE_COA_FORM);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", ele);
		ActionBot.waitTillPopUpIsPresent(driver, COA_FORM_POPUP_LOADER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Save Icon");
	}

	@Override
	public void clickOnCancelIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, ICON_EDIT_CANCEL_COA_FORM);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", ele);
		ActionBot.waitTillPopUpIsPresent(driver, COA_FORM_POPUP_LOADER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel Icon");
	}

	@Override
	public String getErrorMessage_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String error = null;
		ActionBot.waitForPageLoad(driver);
		if (ActionBot.isElementDisplayed(driver, ERROR_MESSAGE_COA_FORM))
		{
			error = ActionBot.findElement(driver, ERROR_MESSAGE_COA_FORM).getText();
			ScreenShot.screenshot(driver, testCaseName, "After error message");
			return error;
		}
		else
			return error;
	}

}
