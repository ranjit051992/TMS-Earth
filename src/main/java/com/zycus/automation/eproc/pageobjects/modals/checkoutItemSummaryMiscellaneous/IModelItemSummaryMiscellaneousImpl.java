package com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryMiscellaneous;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModelItemSummaryMiscellaneousImpl implements IModelItemSummaryMiscellaneous
{

	@Override
	public String getFieldType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String fieldType = ActionBot.findElement(driver, TEXT_FIELD_MISCELLANEOUS_TAB).getAttribute("class");

		if (fieldType.toLowerCase().contains("fldAutocomplete".toLowerCase()))
		{
			String field = "Autocomplete";
			return field;
		}
		return null;
	}

	@Override
	public void enterFieldValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String fieldType = getFieldType(driver, testCaseName);

		if (fieldType.equalsIgnoreCase("Autocomplete"))
		{
			ActionBot.fillAutoCompleteField(driver, TEXT_FIELD_MISCELLANEOUS_TAB, "    ");
			ScreenShot.screenshot(driver, testCaseName, "after filling value for Miscellaneous Tab");
		}
	}

}
