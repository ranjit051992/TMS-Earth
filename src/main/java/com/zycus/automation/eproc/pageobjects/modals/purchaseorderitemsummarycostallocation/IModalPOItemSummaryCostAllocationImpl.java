/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.purchaseorderitemsummarycostallocation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.GLMap;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalPOItemSummaryCostAllocationImpl implements IModalPOItemSummaryCostAllocation
{

	static Logger logger = Logger.getLogger(IModalPOItemSummaryCostAllocationImpl.class);

	@Override
	public void clickOnCostBookingTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, TAB_STANDARD_PO_ITEM_SUMMARY_COST_BOOKING);
		ActionBot.defaultSleep();
	}

	@Override
	public String fillAmount(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		String enteredAmount = null;
		if (ActionBot.isElementPresent(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_AMOUNT))
		{
			ActionBot.sendKeys(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_AMOUNT, amount);
			enteredAmount = ActionBot.findElement(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_AMOUNT).getAttribute("value");
			logger.info("Entered Amount : " + enteredAmount);
		}
		return enteredAmount;
	}

	@Override
	public String fillBudget(WebDriver driver, String testCaseName, String budget) throws ActionBotException
	{
		String selectedBudget = null;
		if (ActionBot.isElementPresent(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_BUDGET))
		{
			selectedBudget = ActionBot.fillAutoCompleteField(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_BUDGET, budget);
			//			WebElement element = ActionBot.findElement(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_BUDGET);
			//			element.clear();
			//			ActionBot.defaultSleep();
			//			element.sendKeys(budget);
			//			ActionBot.defaultMediumSleep();
			//			element.sendKeys(Keys.ARROW_DOWN);
			//			element.sendKeys(Keys.ENTER);
			//
			//			selectedBudget = element.getAttribute("value");
			logger.info("Selected Budget : " + selectedBudget);
		}
		return selectedBudget;
	}

	@Override
	public String fillCostCenter(WebDriver driver, String testCaseName, String costCenter) throws ActionBotException
	{
		String cc = null;
		if (ActionBot.isElementPresent(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_CC))
		{

			cc = ActionBot.fillAutoCompleteField(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_CC, costCenter);
			//			WebElement element = ActionBot.findElement(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_CC);
			//			element.clear();
			//			element.sendKeys(costCenter);
			//			ActionBot.defaultMediumSleep();
			//			element.sendKeys(Keys.ARROW_DOWN);
			//			element.sendKeys(Keys.ENTER);
			//
			//			cc = element.getAttribute("value");
			logger.info("Selected Cost Center : " + cc);
		}
		return cc;
	}

	@Override
	public String fillProject(WebDriver driver, String testCaseName, String project) throws ActionBotException
	{
		String enteredProject = null;
		if (ActionBot.isElementPresent(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_PROJECT))
		{

			enteredProject = ActionBot.fillAutoCompleteField(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_PROJECT, project);
			//			WebElement element = ActionBot.findElement(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_PROJECT);
			//			element.clear();
			//			element.sendKeys(project);
			//			ActionBot.defaultMediumSleep();
			//			element.sendKeys(Keys.ARROW_DOWN);
			//			element.sendKeys(Keys.ENTER);
			//
			//			enteredProject = element.getAttribute("value");
			logger.info("Selected Project : " + enteredProject);
		}
		return enteredProject;
	}

	@Override
	public String getAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String amount = ActionBot.getTextWithInElement(driver, LABEL_STANDARD_PO_ITEM_SUMMARY_AMOUNT_ASSIGNED);
		logger.info("Amount : " + amount);
		ScreenShot.screenshot(driver, testCaseName, "Item summary Cost Booking");
		return amount;
	}

	@Override
	public boolean isEditableAmendItemDescription(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.findElements(driver, TEXTBOX_AMEND_ITEM_DESCRIPTION).get(0) != null)
		{
			boolean enabled = ActionBot.findElements(driver, TEXTBOX_AMEND_ITEM_DESCRIPTION).get(0).isEnabled();
			return enabled;
		}
		return false;
	}

	@Override
	public boolean isEditableAmendModelItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.findElements(driver, TEXTBOX_AMEND_ITEM_QUANTITY).get(0) != null)
		{
			boolean enabled = ActionBot.findElements(driver, TEXTBOX_AMEND_ITEM_QUANTITY).get(0).isEnabled();
			return enabled;
		}
		return false;
	}

	@Override
	public boolean isEditableMarketPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.findElements(driver, TEXTBOX_AMEND_ITEM_MARKET_PRICE).get(0) != null)
		{
			boolean enabled = ActionBot.findElements(driver, TEXTBOX_AMEND_ITEM_MARKET_PRICE).get(0).isEnabled();
			return enabled;
		}
		return false;
	}

	@Override
	public String clearAndfillAmount(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		// ActionBot.clear(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_AMOUNT);
		ActionBot.sendKeys(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_AMOUNT, amount);
		String enteredAmount = ActionBot.findElement(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_AMOUNT).getAttribute("value");
		logger.info("Entered Amount : " + enteredAmount);
		return enteredAmount;
	}

	@Override
	public String getCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String costCenter = ActionBot.getAttributeOfElement(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_CC, "value");
		logger.info("Cost Center : " + costCenter);
		return costCenter;
	}

	@Override
	public String fillGLAccount(WebDriver driver, String glAccount) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY);
		if (glAccount != null)
		{
			ActionBot.fillAutoCompleteField(driver, ele, glAccount);
		}
		else
		{
			if (ele.getAttribute("value").equals(""))
			{
				ele.click();
				ActionBot.defaultSleep();
				ele.sendKeys(Keys.ARROW_DOWN);
				ele.sendKeys(Keys.ENTER);
			}
		}

		ActionBot.defaultSleep();
		return ele.getAttribute("value");
	}

	@Override
	public boolean isGLAccountFieldFilled(WebDriver driver) throws ActionBotException
	{

		String str = null;
		if (ActionBot.isElementDisplayed(driver, TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY))
		{
			str = ActionBot.findElement(driver, TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY).getText();
			if (str.equals("1: Expense"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		if (ActionBot.isElementDisplayed(driver, LABEL_GL_ACCOUNT_ITEM_SUMMARY))
		{
			str = ActionBot.findElement(driver, LABEL_GL_ACCOUNT_ITEM_SUMMARY).getText();

			if (str != null)
			{
				return true;
			}
		}
		return false;

		//		String str = ActionBot.findElement(driver, TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY).getText();
		//		if (str.equals("1: Expense"))
		//		{
		//			return true;
		//		}
		//		else
		//		{
		//			return false;
		//		}
	}

	@Override
	public void clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on save button");
		ActionBot.click(driver, BUTTON_SAVE_ITEM_SUMMARY);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save button");
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnCancel(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_ITEM_SUMMARY);

	}

	@Override
	public boolean isGLAccountSameAsGLMap(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String glAccount = ActionBot.getTextWithInElement(driver, TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY);
		String temp[] = StringUtils.split(glAccount, ":");
		String gl_Account = temp[1].trim();
		GLMap glMap = new GLMap();
		if (gl_Account.equalsIgnoreCase(glMap.getGlAccount()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getGLAccount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String glAccount = null;
		glAccount = ActionBot.findElement(driver, TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY).getAttribute("value").trim();
		logger.info("GL Account : " + glAccount);
		return glAccount;
	}

	@Override
	public String getTagNameOfProjectFieldLabel(WebDriver driver) throws ActionBotException
	{
		WebElement element;
		element = ActionBot.findElement(driver, LABEL_PROJECT_ITEM_SUMMARY);
		return element.getTagName();
	}

	@Override
	public String getItemlevelCostingdetails(WebDriver driver) throws ActionBotException
	{
		String itemcostingDetails = ActionBot.getTextWithInElement(driver, ITEM_LEVEL_COSTING_DETAILS);
		return itemcostingDetails;
	}

	@Override
	public String getItemlevelProjectdetails(WebDriver driver) throws ActionBotException
	{
		String itemProjectDetails = ActionBot.getTextWithInElement(driver, ITEM_LEVEL_PROJECT_DETAILS);
		return itemProjectDetails;
	}

	@Override
	public boolean isProjectFieldALabel(WebDriver driver) throws Exception
	{
		WebElement element = ActionBot.getElement(driver, IModalPOItemSummaryCostAllocation.LABEL_PROJECT_ITEM_SUMMARY);
		String ui_attri = element.getAttribute("class");
		boolean bl = ui_attri.contains("lbl") || ui_attri.contains("Lbl") ? true : false;
		return bl;
	}

	@Override
	public boolean isProjectOrTaskIconPresent(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PROJECT_OR_TASK_ICON_ITEM_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isProjectInfoIconPresent(WebDriver driver) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, PROJECT_INFO_ICON_ITEM_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getaccuntTypeErrorMsg(WebDriver driver, String accountTypeErrorMsg) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ACCOUNTING_ERROR_MSG))
		{
			String Errormsg = ActionBot.findElement(driver, ACCOUNTING_ERROR_MSG).getText();
			return Errormsg;
		}
		return null;
	}

	@Override
	public boolean isGLAccountNotEmpty(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String account = ActionBot.findElement(driver, TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY).getText();
		if (account != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clearGLAccount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY);
	}

	@Override
	public List<String> getListOfGLAccountsNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> listOfGLAccounts = ActionBot.findElements(driver, LIST_LABEL_GL_ACCOUNTS);
		List<String> listOfGlAccountsNames = new ArrayList<>();
		for (WebElement element : listOfGLAccounts)
		{
			listOfGlAccountsNames.add(element.getText().trim());
		}
		return listOfGlAccountsNames;
	}

	@Override
	public String getProject(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String project = ActionBot.getAttributeOfElement(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_PROJECT, "value");
		logger.info("Project : " + project);
		return project;
	}

	@Override
	public String getBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String budget = ActionBot.getAttributeOfElement(driver, TEXTBOX_STANDARD_PO_ITEM_SUMMARY_BUDGET, "value");
		logger.info("Budget : " + budget);
		return budget;
	}

	@Override
	public void clickOnDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, DELIVERY_TAB_MODAL_PO_ITEM_SUMMARY))
		{
			ActionBot.click(driver, DELIVERY_TAB_MODAL_PO_ITEM_SUMMARY);
		}
	}

	@Override
	public void clickOnOtherAddressOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, OTHER_ADDRESS_MODAL_PO_ITEM_SUMMARY);
	}

	@Override
	public String fillOtherDeliveryAddress(WebDriver driver, String testCaseName, String address) throws ActionBotException
	{
		ActionBot.clear(driver, OTHER_ADDRESS_TEXTBOX_MODAL_ITEM_SUMMARY);
		return ActionBot.fillAutoCompleteField(driver, OTHER_ADDRESS_TEXTBOX_MODAL_ITEM_SUMMARY, address);
	}
}
