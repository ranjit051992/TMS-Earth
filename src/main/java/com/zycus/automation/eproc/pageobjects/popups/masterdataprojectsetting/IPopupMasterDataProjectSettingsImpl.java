package com.zycus.automation.eproc.pageobjects.popups.masterdataprojectsetting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IPopupMasterDataProjectSettingsImpl implements IPopupMasterDataProjectSettings
{

	@Override
	public void clickOnYesActiveProject(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_YES_ACTIVE_PROJECT);

	}

	@Override
	public void clickOnYesDeleteProject(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_YES_DELETE_PROJECT);

	}

}
