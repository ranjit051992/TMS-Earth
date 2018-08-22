package com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarycostbooking;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.IPageBuyersDesk;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalPOSummaryCostBookingImpl implements IModalPOSummaryCostBooking
{
	static Logger logger = Logger.getLogger(IModalPOSummaryCostBookingImpl.class);

	@Override
	public void clearAndclickOnProject(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.clear(driver, FIELD_PROJECT_PO_SUMMARY);
		ActionBot.click(driver, PROJECT_TEXT);
	}

	@Override
	public String clearandfillInProjectField(WebDriver driver, String testCaseName, String projectField) throws ActionBotException
	{
		ActionBot.clear(driver, FIELD_PROJECT_PO_SUMMARY);

		String project = null;
		if (ActionBot.isElementPresent(driver, FIELD_PROJECT_PO_SUMMARY))
		{
			project = ActionBot.fillAutoCompleteField(driver, FIELD_PROJECT_PO_SUMMARY, projectField);
			// ScreenShot.screenshot(driver, testCaseName, "After changing
			// budget name");
		}
		return project;
	}

	@Override
	public String clearProjectField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, FIELD_PROJECT_PO_SUMMARY);
		ActionBot.defaultSleep();
		return null;
	}

	@Override
	public void clickOnCancel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_CANCEL_PO_SUMMARY);

	}

	@Override
	public void clickOnNoRadioBttn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_NO_PO_SUMMARY);

	}

	@Override
	public void clickOnProjectField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FIELD_PROJECT_PO_SUMMARY);
	}

	@Override
	public String fillInBudgetField(WebDriver driver, String testCaseName, String budgetField) throws ActionBotException
	{
		String budget = null;
		ActionBot.defaultSleep();

		if (ActionBot.isElementPresent(driver, IPageBuyersDesk.RADIO_BUDGET_UTILIZATION_YES))
		{

			if (ActionBot.isElementEnabled(driver, IPageBuyersDesk.RADIO_BUDGET_UTILIZATION_YES))
			{

				ActionBot.click(driver, IPageBuyersDesk.RADIO_BUDGET_UTILIZATION_YES);
			}
		}

		if (ActionBot.isElementPresent(driver, FIELD_BUDGET_PO_SUMMARY))
		{
			budget = ActionBot.fillAutoCompleteField(driver, FIELD_BUDGET_PO_SUMMARY, budgetField);
			logger.info("Budget : " + budget);
		}
		ScreenShot.screenshot(driver, testCaseName, "After changing budget name");
		return budget;
	}

	@Override
	public void clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Save PO Summary button");
		ActionBot.waitForPageLoad(driver);
		ActionBot.clickUsingJavaScript(driver, BUTTON_SAVE_PO_SUMMARY);
		// ActionBot.click(driver, BUTTON_SAVE_PO_SUMMARY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Save PO Summary button");
	}

	@Override
	public String fillInCostCenterField(WebDriver driver, String testCaseName, String costCenterField) throws ActionBotException
	{
		String costCenter = null;
		ActionBot.defaultSleep();
		costCenter = ActionBot.fillAutoCompleteField(driver, FIELD_COST_CENTER_PO_SUMMARY, costCenterField);

		logger.info("Cost Center : " + costCenter);
		// ScreenShot.screenshot(driver, testCaseName, "After changing cost
		// center name");
		return costCenter;
	}

	@Override
	public String fillInProjectField(WebDriver driver, String testCaseName, String projectField) throws ActionBotException

	{
		String project = null;
		ActionBot.defaultSleep();

		if (ActionBot.isElementPresent(driver, RADIO_ASSIGN_COST_TO_PROJECT_YES_PO_PAGE))
		{

			if (ActionBot.isElementEnabled(driver, RADIO_ASSIGN_COST_TO_PROJECT_YES_PO_PAGE))
			{

				ActionBot.click(driver, RADIO_ASSIGN_COST_TO_PROJECT_YES_PO_PAGE);
			}
		}

		if (ActionBot.isElementDisplayed(driver, FIELD_PROJECT_PO_SUMMARY))
		{
			project = ActionBot.fillAutoCompleteField(driver, FIELD_PROJECT_PO_SUMMARY, projectField);
			logger.info("Project : " + project);
		}

		ScreenShot.screenshot(driver, testCaseName, "After changing project name");
		return project;
	}

	@Override
	public String getAssignProjectToPurchaseCost(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, ASSIGN_PROJECT_TO_PURCHASE_COST_PO_SUMMARY);
	}

	@Override
	public String getProjecduration(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, INFO_PROJECTDURATION_INFO).getText();
	}

	@Override
	public String getProjecmanagerInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, INFO_PROJECTMANAGER_INFO).getText();

	}

	@Override
	public String getProjecmanagerInfoField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, INFO_TOOLTIP_ICON);
		ActionBot.defaultHighSleep();
		return ActionBot.findElement(driver, INFO_PROJECTMANAGER_INFO).getText();

	}

	@Override
	public String getProjectCodeAndProjectName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String project = ActionBot.getTextWithInElement(driver, FIELD_PROJECT_PO_SUMMARY);
		String projectName = StringUtils.split(project, ":")[1].toString().trim();
		return projectName;

	}

	@Override
	public String getProjectCodeInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, FIELD_PROJECT_INFO);
		ActionBot.defaultSleep();
		return ActionBot.findElement(driver, INFO_PROJECTCODE_INFO).getText();

	}

	@Override
	public String getProjectFieldname(WebDriver driver, String testCaseName) throws ActionBotException
	{

		return ActionBot.getTextWithInElement(driver, FIELD_PROJECT_PO_SUMMARY);
	}

	@Override
	public String getProjectNameInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.findElement(driver, INFO_PROJECTNAME_INFO).getText();
		return testCaseName;
	}

	@Override
	public void hoverOnInfoIcon(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.hover(driver, INFO_ICON);
		ActionBot.defaultSleep();

	}

	@Override
	public boolean isAutocompleteFieldOfProjectDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, FIELD_AUTOCOMPLETE_PROJECT_PO_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean isAutocompleteFieldProjectNotDisplayed(WebDriver driver, String testCaseName)
	{
		return false;
	}

	@Override
	public boolean isDurationFieldPresentInInfoIcon(WebDriver driver, String testCaseName, int index1) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='ui-tooltip-88-content']//li[";
		String xpathPart2 = "]/label[@class='frmLbl']";
		By xpath = By.xpath(xpathPart1 + index1 + xpathPart2);
		if (ActionBot.isElementPresent(driver, xpath))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isElementAssignProjectToPurchaseCostDisabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.findElement(driver, ASSIGN_PROJECT_TO_PURCHASE_COST_PO_SUMMARY).getAttribute("class");

		System.out.println(str);

		if (str.contains("disableMe"))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean isElementNoSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementSelected(driver, RADIO_BUTTON_NO_PO_SUMMARY);

	}

	@Override
	public boolean isElementYesSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementSelected(driver, RADIO_BUTTON_YES_PO_SUMMARY);

	}

	@Override
	public boolean isFieldProjectDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, FIELD_PROJECT_PO_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean isFieldReset(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, FIELD_PROJECT_INFO).getText().length() == 0;
	}

	@Override
	public boolean isInfoIconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, FIELD_PROJECT_INFO))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isInfoIconPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, INFO_ICON))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean isProjectCodeAndProjectNameFieldPresentInInfoIcon(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, INFO_ICON);
		ActionBot.defaultMediumSleep();
		ActionBot.defaultSleep();
		ActionBot.defaultHighSleep();
		if (ActionBot.isElementPresent(driver, PROJECT_CODE_AND_NAME_INFO_ICON))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isProjectFieldEmpty(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement element;
		element = ActionBot.findElement(driver, FIELD_PROJECT_PO_SUMMARY);
		if (element.getAttribute("value").length() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isProjectInAutocompleteFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException

	{
		if (ActionBot.isElementPresent(driver, FIELD_AUTOCOMPLETE_PROJECT_PO_SUMMARY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isProjectInfoIconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String S1 = ActionBot.findElement(driver, PROJECT_INFOICON).getAttribute("style");

		if (S1.equals("display: inline-block;"))
		{
			return true;
		}
		else if (S1.equals("display: none;"))
		{
			return false;
		}
		return false;

	}

	@Override
	public boolean isProjectManagerFieldPresentInInfoIcon(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String xpathPart1 = ".//*[@id='ui-tooltip-88-content']//li[";
		String xpathPart2 = "]/label[@class='frmLbl']";
		By xpath = By.xpath(xpathPart1 + index + xpathPart2);
		if (ActionBot.isElementPresent(driver, xpath))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean isProjectOrTaskIconPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, PROJECT_ICON))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isRadioBottomSingleCostCenterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, BUTTON_RADIO_SINGLE_COSTCENTER))
		{
			ActionBot.click(driver, BUTTON_RADIO_SINGLE_COSTCENTER);
			ActionBot.click(driver, CONFIRM_ITEM_LEVEL_SUBMIT_BOTTOM);
		}
		return false;

	}

	@Override
	public boolean isTaskInfoIconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String S1 = ActionBot.findElement(driver, TASK_INFOICON).getAttribute("style");
		if (S1.equals("display: inline-block;"))
		{
			return true;
		}
		else if (S1.equals("display: none;"))
		{
			return false;
		}
		return false;
	}

	@Override
	public String getNonEditableCCFromReqToPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, NON_EDITABLE_CC_PO_SUMMARY);
		return str;
	}

	@Override
	public String getHeaderLevelCostingDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String costingDetails = ActionBot.getTextWithInElement(driver, HEADER_LEVEL_COSTING_DETAILS);
		return costingDetails;
	}

	@Override
	public String getHeaderLevelProjectDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String prjectDetails = ActionBot.getTextWithInElement(driver, HEADER_LEVEL_PREOJECT_DETAILS);
		return prjectDetails;
	}

	@Override
	public void clickOnYESradioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_YES_PO_SUMMARY);

	}

	@Override
	public String getCostCenterName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String costCenter = ActionBot.getAttributeOfElement(driver, FIELD_COST_CENTER_PO_SUMMARY, "value");
		logger.info("Cost Center : " + costCenter);
		return costCenter;
	}

	@Override
	public String getBudgetName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String budget = null;
		if (ActionBot.isElementPresent(driver, FIELD_BUDGET_PO_SUMMARY))
		{
			budget = ActionBot.getAttributeOfElement(driver, FIELD_BUDGET_PO_SUMMARY, "value");
			logger.info("Budget : " + budget);
		}
		return budget;
	}

	@Override
	public String getProjectName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String project = null;
		if (ActionBot.isElementPresent(driver, FIELD_PROJECT_PO_SUMMARY))
		{
			project = ActionBot.getAttributeOfElement(driver, FIELD_PROJECT_PO_SUMMARY, "value");
			logger.info("Project : " + project);
		}
		return project;
	}

	@Override
	public void clearCostCenterField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, FIELD_COST_CENTER_PO_SUMMARY);
		ActionBot.defaultSleep();

	}

	@Override
	public String getLabelValueOfProjectField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String labelValue = ActionBot.getTextWithInElement(driver, LABEL_PROJECT_AT_HEADER_LEVEL_PO);
		logger.info("Label Value of Project : " + labelValue);
		return labelValue;
	}

	@Override
	public boolean isProjectErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, ERROR_PROJECT_SUMMARY);
	}

	@Override
	public boolean isRadioBottonSingleCostCenterEnable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, BUTTON_RADIO_SINGLE_COSTCENTER).isEnabled();
	}

	@Override
	public String getHeaderLevelBudgetDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String budget = null;
		budget = ActionBot.getTextWithInElement(driver, HEADER_LEVEL_BUDGET_DETAILS);
		return budget;
	}
}