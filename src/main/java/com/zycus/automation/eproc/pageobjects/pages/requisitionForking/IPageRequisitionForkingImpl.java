package com.zycus.automation.eproc.pageobjects.pages.requisitionForking;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageRequisitionForkingImpl implements IPageRequisitionForking
{
	static Logger logger = Logger.getLogger(IPageRequisitionForkingImpl.class);

	@Override
	public void clickBackReq(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, REQUISITION_BACK);
		ScreenShot.screenshot(driver, testCaseName, "Back from Forking Req");
	}

	@Override
	public void clickCancleReq(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, REQUISITION_CANCLE);
		ScreenShot.screenshot(driver, testCaseName, "Cancle from Forking Req");
	}

	@Override
	public void clickCommentsForSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ActionBot.click(driver, By.xpath(".//*[@id='" + index + "_suggestedReq']//*[@class='icon comments dev_supplierCommentIcon']"));
		ScreenShot.screenshot(driver, testCaseName, "Comments for supplier");
	}

	@Override
	public void clickConfirmReq(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, REQUISITION_CONFIRM);
		ScreenShot.screenshot(driver, testCaseName, "Confirm Forking Req");
	}

	@Override
	public void clickDraft(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ActionBot.click(driver, By.xpath(".//*[@id='" + index + "_suggestedReq']//*[contains(@class,'dev_draft')]"));
		ScreenShot.screenshot(driver, testCaseName, "click draft");
	}

	@Override
	public void clickForkedItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ActionBot.click(driver, By.xpath(".//*[@id='dev_forkedRequisitionsTable']//*[@data-index='" + index + "']//*[@class='scLnk dev_itemName']"));
		ScreenShot.screenshot(driver, testCaseName, "clicked forked item name");
	}

	@Override
	public void clickforkingLearn(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, FORKING_LEARN);
		ScreenShot.screenshot(driver, testCaseName, "Learn Forking");
	}

	@Override
	public void clickOkWorkflow(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, FORKING_SAVE_WORKFLOW_OK);
		ScreenShot.screenshot(driver, testCaseName, "Ok Req Workflow");
	}

	@Override
	public void clickReasonForOrdering(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ActionBot.click(driver, By.xpath(".//*[@id='" + index + "_suggestedReq']//*[@class='icon buyerJustification dev_buyerJustificationIcon']"));
		ScreenShot.screenshot(driver, testCaseName, "click Reason for Ordering");
	}

	@Override
	public void clickSubmit(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ActionBot.click(driver, By.xpath(".//*[@id='" + index + "_suggestedReq']//*[@class='b-toggle']//*[@class='b-toggle-btn b-toggle-right dev_submit b-toggle-inactive']"));
		ScreenShot.screenshot(driver, testCaseName, "click submit");

	}

	@Override
	public void clickViewWorkflow(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, By.xpath(xpath1_Link_View_Workflow + index + xpath2_Link_View_Workflow));
		ScreenShot.screenshot(driver, testCaseName, "click view workflow");
	}

	@Override
	public String getForkedItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='dev_forkedRequisitionsTable']//*[@data-index='" + index + "']//*[@class='scLnk dev_itemName']"));
		if (ele.getText() != null)
		{
			return ele.getText();
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getForkedItemSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='dev_forkedRequisitionsTable']//*[@data-index='" + index + "']//*[@class='iSuppName']"));
		if (ele.getText() != null)
		{
			return ele.getText();
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getForkedReqName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='" + index + "_suggestedReq']//*[@class='iDesc']"));
		if (ele.getText() != null)
		{
			return ele.getText();
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getForkedReqNumber(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='" + index + "_suggestedReq']//*[@class='itmNo poNumCell']"));
		if (ele.getText() != null)
		{
			return ele.getText();
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getForkedReqTotalPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='dev_forkedRequisitionsTable']//*[@id='" + index + "_suggestedReq']//*[@class='iNum tPrice']"));
		if (ele.getText() != null)
		{
			return ele.getText();
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getForkedItemUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String itemUnitPrice = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='dev_forkedRequisitionsTable']//tr[" + index + "]//tr[1]/td[3]"));
		logger.info("Item Unit Price as on checkout page : " + itemUnitPrice);
		return itemUnitPrice;
	}

	@Override
	public String getForkedItemQuantity(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String itemQuantity = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='dev_forkedRequisitionsTable']//tr[" + index + "]//tr[1]/td[contains(@class,'itmQty')]"));
		logger.info("Item Quantity as on checkout page : " + itemQuantity);
		return itemQuantity;
	}

	@Override
	public List<WebElement> getListOfItemNamesOnForkingScreen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, LINK_LIST_OF_ITEM_NAMES_ON_FORKING_SCREEN);
	}

	@Override
	public List<String> getListOfPRNumbersOnForkingScreen(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> prNames = new ArrayList<String>();
		List<WebElement> elements = ActionBot.findElements(driver, LINK_LIST_OF_PR_NUMBERS_ON_FORKING_SCREEN);
		for (WebElement element : elements)
		{
			prNames.add(element.getText().trim());
		}
		return prNames;
	}

	@Override
	public String getAlertMessageForSubmittingForkedReqs(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		return ActionBot.getTextWithInElement(driver, ALERT_MESSAGE_FOR_SUBMITTING_FORKED_REQS);
	}

	@Override
	public boolean isModifyWorkflowSettingsPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementSelected(driver, LABEL_MODIFY_WORKFLOW_SETTINGS))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnSaveApprovalWorflow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_REQ_APPROVAL_WORKFLOW);

	}

	@Override
	public void clickOnCheckboxModifyWorkflowSettings(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_MODIFY_WORKFLOW_SETTINGS);

	}

	@Override
	public void clickOnCancelApprovalWorkflow(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_REQ_APPROVAL_WORKFLOW);

	}

	@Override
	public List<String> getListOfItemNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<String> itemNames = new ArrayList<>();
		List<WebElement> itemNamesElements = getListOfItemNamesOnForkingScreen(driver, testCaseName);
		for (WebElement ele : itemNamesElements)
		{
			itemNames.add(ele.getText().trim());
		}
		return itemNames;
	}
}
