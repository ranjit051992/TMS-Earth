package com.zycus.automation.eproc.pageobjects.modals.BuyersRequisitionSummaryCostBooking;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCostBooking.IModelRequisitionSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.IPageBuyersDeskImpl;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModelBuyersdeskionSummaryCostBookingImpl implements IModelRequisitionSummaryCostBooking
{

	static Logger logger = Logger.getLogger(IModelBuyersdeskionSummaryCostBookingImpl.class);

	@Override
	public void clickMultiAddCostCenter(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ActionBot.click(driver, By.xpath(".//*[@id='entity_costing_" + index + "']//*/a[@class='icon add']"));
		ScreenShot.screenshot(driver, testCaseName, "After click to add new cost center to split");
	}

	@Override
	public void clickMultiDeleteCostCenter(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ActionBot.click(driver, By.xpath(".//*[@id='entity_costing_" + index + "']//*/a[@class='icon remove']"));
		ScreenShot.screenshot(driver, testCaseName, "After click to delete cost center of split");
	}

	@Override
	public String fillCostBookingSingleBudget(WebDriver driver, String testCaseName, String costBookingSingleBudget) throws ActionBotException
	{
		String budget = null;

		if (ActionBot.isElementPresent(driver, IPageBuyersDeskImpl.RADIO_BUDGET_UTILIZATION_YES))
		{
			ActionBot.click(driver, IPageBuyersDeskImpl.RADIO_BUDGET_UTILIZATION_YES);
		}

		if (ActionBot.isElementPresent(driver, COSTBOOKING_SINGLE_BUDGET))
		{
			WebElement ele = ActionBot.findElement(driver, COSTBOOKING_SINGLE_BUDGET);
			ele.clear();
			/*
			 * ele.sendKeys(costBookingSingleBudget);
			 * ele.sendKeys(Keys.ARROW_DOWN); ele.sendKeys(Keys.ENTER);
			 */
			ActionBot.fillAutoCompleteField(driver, COSTBOOKING_SINGLE_BUDGET, costBookingSingleBudget);
			budget = ele.getAttribute("value").trim();
			ScreenShot.screenshot(driver, testCaseName, "After changing budget name");
			logger.info("Changed Budget Name : " + budget);
		}
		return budget;
	}

	@Override
	public String fillCostBookingSingleCC(WebDriver driver, String testCaseName, String costBookingSingleCC) throws ActionBotException
	{
		String costCenter = null;
		WebElement ele = ActionBot.findElement(driver, COSTBOOKING_SINGLE_CC);
		ele.clear();
		/*
		 * ele.sendKeys(costBookingSingleCC); ele.sendKeys(Keys.ARROW_DOWN);
		 * ele.sendKeys(Keys.ENTER);
		 */
		ActionBot.fillAutoCompleteField(driver, COSTBOOKING_SINGLE_CC, costBookingSingleCC);

		costCenter = ele.getAttribute("value").trim();
		ScreenShot.screenshot(driver, testCaseName, "After changing cost center name");
		logger.info("Changed Cost Center : " + costCenter);
		return costCenter;
	}

	@Override
	public String fillMultiCostCenterBudget(WebDriver driver, String testCaseName, String multiCostCenterBudget, int index) throws ActionBotException
	{
		String budget = null;
		if (ActionBot.isElementSelected(driver, By.xpath(".//*[@id='entity_costing_budget_" + index + "']")))
		{
			WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='entity_costing_budget_" + index + "']"));
			ele.clear();
			ele.sendKeys(multiCostCenterBudget);
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);

			budget = ele.getAttribute("value").trim();
			ScreenShot.screenshot(driver, testCaseName, "After changing budget");
			logger.info("Budget : " + budget);
		}
		return budget;
	}

	@Override
	public String fillMultiCostCenterName(WebDriver driver, String testCaseName, String multiCostCenterName, int index) throws ActionBotException
	{
		String costCenter = null;
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='entity_costing_costCenter_" + index + "']"));
		ele.clear();
		ele.sendKeys(multiCostCenterName);
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);

		costCenter = ele.getAttribute("value").trim();
		ScreenShot.screenshot(driver, testCaseName, "After changing cost center");
		logger.info("Cost Center : " + costCenter);

		return costCenter;
	}

	@Override
	public int fillMultiCostCenterPercent(WebDriver driver, String testCaseName, int multiCostCenterPercent, int index) throws ActionBotException
	{

		String percentage = Integer.toString(multiCostCenterPercent);
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='entity_costing_percentage_" + index + "']"));
		ele.clear();
		ele.sendKeys(percentage);

		percentage = ele.getAttribute("value").trim();
		ScreenShot.screenshot(driver, testCaseName, "After changing percentage");
		logger.info("Percentage : " + percentage);

		return Integer.parseInt(percentage);
	}

	@Override
	public String getCostBookingItemLevelCCAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String cca = ActionBot.findElement(driver, COSTBOOKING_ITEMLEVEL_CC_AMOUNT).getText();
		if (cca != null)
		{
			return cca;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getCostBookingItemLevelCCBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String str = ActionBot.findElement(driver, COSTBOOKING_ITEMLEVEL_CC_BUDGET).getText();
		if (str != null)
		{
			return str;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getCostBookingItemLevelCCName(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String cc = ActionBot.findElement(driver, COSTBOOKING_ITEMLEVEL_CC_NAME).getText();
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
	public String getCostBookingMultiCostCenterAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='entity_costing_price_" + index + "']"));
		if (ele.getAttribute("value") != null)
		{
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getCostBookingTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String ccTotalAmt = ActionBot.findElement(driver, COSTBOOKING_TOTAL_AMOUNT).getText();
		if (ccTotalAmt != null)
		{
			return ccTotalAmt;
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean selectCostBookingOptionLineItemCC(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, COSTBOOKING_OPTION_LINEITEM_CC);
		if (ActionBot.findElement(driver, COSTBOOKING_OPTION_LINEITEM_CC).isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean selectCostBookingOptionMultipleCC(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, COSTBOOKING_OPTION_MULTIPLE_CC);
		if (ActionBot.findElement(driver, COSTBOOKING_OPTION_MULTIPLE_CC).isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean selectCostBookingOptionSingleCC(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, COSTBOOKING_OPTION_SINGLE_CC);
		if (ActionBot.findElement(driver, COSTBOOKING_OPTION_SINGLE_CC).isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String fillCostBookingSingleProject(WebDriver driver, String testCaseName, String costBookingSingleProject) throws ActionBotException
	{
		String project = null;

		if (ActionBot.isElementPresent(driver, MODAL_CHECKOUT_COSTBOOKING_YES_RADIO_BUTTON))
		{
			ActionBot.click(driver, MODAL_CHECKOUT_COSTBOOKING_YES_RADIO_BUTTON);
		}

		if (ActionBot.isElementPresent(driver, COSTBOOKING_SINGLE_PROJECT))
		{
			WebElement ele = ActionBot.findElement(driver, COSTBOOKING_SINGLE_PROJECT);
			ele.clear();
			/*
			 * ele.sendKeys(costBookingSingleProject); ActionBot.defaultSleep();
			 * ele.sendKeys(Keys.ARROW_DOWN); ele.sendKeys(Keys.ENTER);
			 */

			ActionBot.fillAutoCompleteField(driver, COSTBOOKING_SINGLE_PROJECT, costBookingSingleProject);
			project = ele.getAttribute("value").trim();
			logger.info("Changed Project Name : " + project);
			ScreenShot.screenshot(driver, testCaseName, "After changing project name");
		}
		return project;
	}

	@Override
	public String fillMultiCostCenterProject(WebDriver driver, String testCaseName, String multiCostCenterProject, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAssingToPurchasOrderRedioBtnYesSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAssingToPurchasOrderRedioDisabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCostbookingSingleCCRadioBtnSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReqSummaryProjectToolTipContainsProjectDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clickYesAssignToPurchaseCost(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clickNoAssignToPurchaseCost(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCCSplitAtItemLevelContentPresentAtHeader(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, COSTING_SPLIT_ITEM_LEVEL_CONTENT_COSTBOOKING_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isAssingToPurchasOrderRedioBtnNOSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isselectCostBookingOptionMultipleCCDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WebElement> getListOfCostCenters(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getListOfCostCentersNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCostCenterName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> getListOfPrjects(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getListOfProjectNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProjectName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearCostCenterWithSpace(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clearProjectWithSpace(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String getCostCenterLabelAtHeaderLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clickOnSinglePoject(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clickNoAllowBudgetUtilization(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clickYesAllowBudgetUtilization(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isYesAllowBudgetUtilization(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNoAllowBudgetUtilization(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

}