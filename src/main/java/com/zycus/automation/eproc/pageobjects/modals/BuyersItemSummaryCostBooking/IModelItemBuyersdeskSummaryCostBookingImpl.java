package com.zycus.automation.eproc.pageobjects.modals.BuyersItemSummaryCostBooking;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCostBooking.IModelItemSummaryCostBooking;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

public class IModelItemBuyersdeskSummaryCostBookingImpl implements IModelItemSummaryCostBooking
{

	static Logger logger = Logger.getLogger(IModelItemBuyersdeskSummaryCostBookingImpl.class);

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
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='costing_item_budget_" + itemID + "_" + index + "']"));
		if (ele.isDisplayed())
		{
			ele.clear();
			ele.sendKeys(itemSplitBudget);
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);

			if (ele.getAttribute("value") != null)
			{
				return ele.getAttribute("value");
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillCostBookingItemSplitCostCenter(WebDriver driver, String testCaseName, String itemSplitCostCenter, String itemID, int index) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='costing_item_costCenter_" + itemID + "_" + index + "']"));
		ele.clear();
		ele.sendKeys(itemSplitCostCenter);
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);

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
	public int fillCostBookingItemSplitPercentage(WebDriver driver, String testCaseName, int itemSplitPercentage, String itemID, int index) throws ActionBotException
	{

		String percentage = Integer.toString(itemSplitPercentage);
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='costing_item_percentage_" + itemID + "_" + index + "']"));

		if (ele.isDisplayed())
		{
			ele.clear();
			ele.sendKeys(percentage);

			percentage = ele.getAttribute("value").trim();
			logger.info("Percentage : " + percentage);
			ScreenShot.screenshot(driver, testCaseName, "After changing percentage");
		}
		return Integer.parseInt(percentage);
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
		}
		return Integer.parseInt(quantity);
	}

	@Override
	public String getCostBookingItemSplitAmount(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException
	{
		String amt = ActionBot.findElement(driver, By.xpath(".//*[@id='costing_item_price_" + itemID + "_" + index + "']")).getText().trim();
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
	public String fillCostBookingItemSplitProject(WebDriver driver, String testCaseName, String itemSplitProject, String itemID, int index) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='costing_item_project_" + itemID + "_" + index + "']"));
		if (ele.isDisplayed())
		{
			ele.clear();
			ele.sendKeys(itemSplitProject);
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);

			if (ele.getAttribute("value") != null)
			{
				return ele.getAttribute("value");
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getCostCenterForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeliverToForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeliveryAddressForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getQuantityForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAmountForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillAccountingGLAccount(WebDriver driver, String testCaseName, String accountingGLAccountCode, String itemID, int index) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='generalLedger_" + itemID + "_" + index + "']"));

		if (accountingGLAccountCode != null)
		{
			ActionBot.fillAutoCompleteField(driver, ele, accountingGLAccountCode);
		}
		else
		{
			ele.click();
			ele.sendKeys(Keys.ARROW_DOWN);
			ActionBot.defaultSleep();
			ele.sendKeys(Keys.ENTER);
		}
		String glAccount = ele.getAttribute("value").trim();
		logger.info("Selected Gl Account : " + glAccount);
		return glAccount;
	}

	@Override
	public String getSubTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessageOfAccountingInfoFromQtip(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, Q_TIP_ACCOUNTING_INFO);
		ActionBot.defaultSleep();
		return ActionBot.getTextWithInElement(driver, MESSAGE_ACCOUNTING_INFO_OF_Q_TIP);
	}

	@Override
	public void clickOnSaveItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultMediumSleep();
		ActionBot.click(driver, BUTTON_SAVE_ITEM_SUMMARY_BUYERS_DESK);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnCancelItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_CANCEL_ITEM_SUMMARY_BUYERS_DESK);

	}

	@Override
	public boolean isGLAccountPresent(WebDriver driver, String testCaseName, String id, int index) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, By.xpath(".//*[@id='generalLedger_" + id + "_" + index + "']")))
		{
			ActionBot.defaultSleep();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getListOfNamesAvailableGLAccounts(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearGLAccounts(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException, TestCaseException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String getGLAccount(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException, TestCaseException
	{
		ActionBot.findElement(driver, By.xpath(".//*[@id='generalLedger_" + itemID + "_" + index + "']"));
		return ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='generalLedger_" + itemID + "_" + index + "']"));
	}

	@Override
	public boolean isProjectNonEditable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, NON_EDITABLE_SPLIT_PROJECT_LABEL_AT_ITEM_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnBookCostTOSingleCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String fillAssetCode(WebDriver driver, String testCaseName, String assetCode, String itemID) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAssetCodeTextboxPresent(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getAssetCode(WebDriver driver, String testCaseName, String itemID) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
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
	public String getCostBookingItemSplitCostCenter(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearCostCenterWithSpace(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<WebElement> getListOfProjects(WebDriver driver, String testCaseName) throws ActionBotException
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
	public String getCostBookingItemSplitProject(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearProjectWithSpace(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String getGLAccountHeaderAtItemLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isGeneralLedgerDetailsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGlAccountMandatorySignPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void waitTillCOAFormLoaderDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String clickCostBookingOnRadioButton_CoaForm(WebDriver driver, String testCaseName, String radioButtonName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean clickAddButton_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getQuantityFromItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalAmountFromItemSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateQuantityFromItemSummary(WebDriver driver, String testCaseName, int quantity) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clickOnEditIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clickOnDeleteIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clickOnSaveIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clickOnCancelIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String fillBU_CoaForm(WebDriver driver, String testCaseName, String businessUnit, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillGeneralLedger_CoaForm(WebDriver driver, String testCaseName, String generalLedger, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillCostCenter_CoaForm(WebDriver driver, String testCaseName, String costCenter, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillProject_CoaForm(WebDriver driver, String testCaseName, String project, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillSubAccount_CoaForm(WebDriver driver, String testCaseName, String subAccount, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillProduct_CoaForm(WebDriver driver, String testCaseName, String product, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillGeoAccount_CoaForm(WebDriver driver, String testCaseName, String geoAccount, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillOperationalUnit_CoaForm(WebDriver driver, String testCaseName, String operationalUnit, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillPercentage_CoaForm(WebDriver driver, String testCaseName, String percentage, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillQuantity_CoaForm(WebDriver driver, String testCaseName, String quantity, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillAmount_CoaForm(WebDriver driver, String testCaseName, String amount, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillBookCostTo_CoaForm(WebDriver driver, String testCaseName, String bookCostTo, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillClient_CoaForm(WebDriver driver, String testCaseName, String client, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillEmployeeTimekeeper_CoaForm(WebDriver driver, String testCaseName, String empTimeKeeper, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillCostDisbursementCode_CoaForm(WebDriver driver, String testCaseName, String costDisCode, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillDepartment_CoaForm(WebDriver driver, String testCaseName, String department, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fillDescription_CoaForm(WebDriver driver, String testCaseName, String description, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillTransactionDate_CoaForm(WebDriver driver, String testCaseName, int day, int month, int year, boolean editForm) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String getErrorMessage_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}
}
