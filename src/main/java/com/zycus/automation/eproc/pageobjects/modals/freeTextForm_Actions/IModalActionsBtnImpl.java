package com.zycus.automation.eproc.pageobjects.modals.freeTextForm_Actions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IModalActionsBtnImpl extends IModalActionsBtnUtil implements IModalActionsBtn
{

	@Override
	public void toClickViewLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, VIEW);

	}

	@Override
	public void toClickCopyLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, COPY);

	}

}
