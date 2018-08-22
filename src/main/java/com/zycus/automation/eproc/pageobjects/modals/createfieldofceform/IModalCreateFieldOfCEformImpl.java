/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.createfieldofceform;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

/**
 * @author ankita.sawant
 *
 */
public class IModalCreateFieldOfCEformImpl implements IModalCreateFieldOfCEform
{

	@Override
	public void clickOnAddTextField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before adding text field");
		ActionBot.click(driver, BUTTON_TEXT_FIELD_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After adding text field");
	}

	@Override
	public void clickOnAddTextArea(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before adding text field");
		ActionBot.click(driver, BUTTON_TEXT_AREA_CEFORM);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After adding text field");
	}

	@Override
	public void clickOnAddCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CHECK_BOX_CEFORM);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After adding check box field");
	}

	@Override
	public List<String> enterChoicesForCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_ENTER_CHECKBOX_CHOICES);
		String choice1 = "Choice_1" + System.currentTimeMillis();
		String choice2 = "Choice_2" + System.currentTimeMillis();
		element.sendKeys(choice1 + "\n" + choice2);
		List<String> choicesList = new ArrayList<>();
		choicesList.add(choice1);
		choicesList.add(choice2);
		ActionBot.waitForPageLoad(driver);
		return choicesList;

	}

	@Override
	public void clickOnAddDescriptiveField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before adding text field");
		ActionBot.click(driver, BUTTON_DESCRIPTIVE_FIELD_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After adding text field");

	}

	@Override
	public void clickOnAddNumeric(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before adding text field");
		ActionBot.click(driver, BUTTON_NUMERIC_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After adding text field");

	}

	@Override
	public void clickOnAddDateAndTime(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before adding text field");
		ActionBot.click(driver, BUTTON_DATE_AND_TIME_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After adding text field");

	}

	@Override
	public void clickOnAddRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before adding text field");
		ActionBot.click(driver, BUTTON_RADIO_BUTTON_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After adding text field");

	}

	@Override
	public void clickOnAddCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before adding text field");
		ActionBot.click(driver, BUTTON_CHECK_BOX_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After adding text field");

	}

	@Override
	public void clickOnAddDropDown(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before adding text field");
		ActionBot.click(driver, BUTTON_DROP_DOWN_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After adding text field");

	}

	@Override
	public void clickOnAddMultiSelect(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before adding text field");
		ActionBot.click(driver, BUTTON_MULTI_SELECT_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After adding text field");
	}

}
