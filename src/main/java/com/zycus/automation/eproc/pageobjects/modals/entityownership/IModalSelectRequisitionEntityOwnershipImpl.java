/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.entityownership;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalSelectRequisitionEntityOwnershipImpl implements IModalSelectRequisitionEntityOwnership
{
	static Logger logger = Logger.getLogger(IModalSelectRequisitionEntityOwnershipImpl.class);

	@Override
	public String selectStatusOfEntities(WebDriver driver, String testCaseName, String status) throws ActionBotException
	{
		String selectedStatus = ActionBot.selectElement(driver, SELECT_STATUS_OF_ENTITIES, IConstantsData.SELECT_BY_VISIBLE_TEXT, status);
		logger.info("Selected Status : " + selectedStatus);
		return selectedStatus;
	}

	@Override
	public String selectEntitiesIn(WebDriver driver, String testCaseName, String entitiesIn) throws ActionBotException
	{
		String selectedEntities = ActionBot.selectElement(driver, SELECT_ENTITIES_IN, IConstantsData.SELECT_BY_VISIBLE_TEXT, entitiesIn);
		ActionBot.defaultSleep();
		logger.info("Selected Entities In : " + selectedEntities);
		return selectedEntities;
	}

	@Override
	public String fillEntitySearchBox(WebDriver driver, String testCaseName, String entity) throws ActionBotException
	{
		String entered_entity = ActionBot.sendKeys(driver, TEXTBOX_ENTITY_SEARCH_BOX, entity);
		logger.info("Entered Entity : " + entered_entity);
		return entered_entity;
	}

	@Override
	public void clickOnSearchGoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Search Button");
		ActionBot.click(driver, BUTTON_ENTITIES_SEARCH_GO);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Search Button");
	}

	@Override
	public void clickOnFirstRowEntityCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_FIRST_ROW_ENTITY);
	}

	@Override
	public String fillComments(WebDriver driver, String testCaseName, String comments) throws ActionBotException
	{
		String enteredComments = ActionBot.sendKeys(driver, TEXTBOX_COMMENTS_FOR_ENTITY, comments);
		ActionBot.defaultSleep();
		logger.info("Entered Comments : " + enteredComments);
		return enteredComments;
	}

	@Override
	public void clickOnSaveSelectedEntitiesButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Save Selected Entities Button");
		ActionBot.click(driver, BUTTON_SAVE_SELECTED_ENTITES);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Save Selected Entities Button");
	}

	@Override
	public void clickOnCancelSelectedEntitiesButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel Selected Entities Button");
		ActionBot.click(driver, BUTTON_CANCEL_SELECTED_ENTITES);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel Selected Entities Button");
	}

	@Override
	public List<String> getListOfRequisitionsOnSelectRequisitionsPoUp(WebDriver driver, String testCaseName, int showingPageNumber)
		throws ActionBotException, FactoryMethodException
	{
		List<String> listOfRequitionNo = new ArrayList<>();
		boolean flag= ActionBot.isElementPresent(driver, LIST_OF_REQUISITIONS_ON_SELECT_REQUISITIONS_POPUP);
		logger.info("\nActionBot.isElementPresent(driver, LIST_OF_REQUISITIONS_ON_SELECT_REQUISITIONS_POPUP) :"+flag);
		ActionBot.waitForElementToBeDisplayed(driver, LIST_OF_REQUISITIONS_ON_SELECT_REQUISITIONS_POPUP, 30);
		List<WebElement> elements = ActionBot.findElements(driver, LIST_OF_REQUISITIONS_ON_SELECT_REQUISITIONS_POPUP);
		ActionBot.defaultSleep();
		for (int i = 0; i < elements.size(); i++)
		{
			listOfRequitionNo.add(ActionBot.getTextWithInElement(driver, elements.get(i)));
			logger.info("\n req no at row " + i + " " + listOfRequitionNo.get(i));
		}
		//List<String> listOfRequitionNo = ActionBot.getListOfText(driver, LIST_OF_REQUISITIONS_ON_SELECT_REQUISITIONS_POPUP);
		if (listOfRequitionNo.isEmpty())
			logger.info("\n getListOfRequisitionsOnSelectRequisitionsPoUp() is empty");
		return listOfRequitionNo;
	}

	@Override
	public String fillShowingPageNumberAndEnter(WebDriver driver, String testCaseName, int showingPageNumber) throws ActionBotException, FactoryMethodException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_SHOWING_PAGE_NUMBER);
		ActionBot.sendKeys(driver, TEXTBOX_SHOWING_PAGE_NUMBER, String.valueOf(showingPageNumber));
		ActionBot.defaultSleep();
		element.sendKeys(Keys.ENTER);
		//ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ActionBot.defaultSleep();
		ActionBot.defaultSleep();
		logger.info("\npage number entered (showingPageNumber) :" + showingPageNumber);
		logger.info("\npage number on browser :" + ActionBot.getTextWithInElement(driver, element));
		return ActionBot.getTextWithInElement(driver, TEXTBOX_SHOWING_PAGE_NUMBER);
	}

	@Override
	public boolean clickOnSpecificRowCheckBoxOnSelectRequisitionsPopUp(WebDriver driver, String testCaseName, String rowNo) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		By by = By.xpath(".//*[@id='reqListTable']/tbody/tr[" + rowNo + "]//input[@class='reqlist_chkboxCode']");
		ActionBot.click(driver, by);
		ActionBot.defaultSleep();
		flag = ActionBot.isElementSelected(driver, by);
		if (flag == false)
			logger.info("\n checkbox is not selected....failed");
		else
			logger.info("\n checkbox is selected...success");
		return flag;
	}

}
