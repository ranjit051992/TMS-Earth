package com.zycus.automation.eproc.pageobjects.popups.masterdataprojectsetting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PopupMasterDataProjectSettings
{
	public static void clickOnYesActiveProject(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopupMasterDataProjectSettings iPopupMasterDataProjectSettings = FactoryPage.getInstanceOf(IPopupMasterDataProjectSettingsImpl.class);
		iPopupMasterDataProjectSettings.clickOnYesActiveProject(driver, testCaseName);

	}

	public static void clickOnYesDeleteProject(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPopupMasterDataProjectSettings iPopupMasterDataProjectSettings = FactoryPage.getInstanceOf(IPopupMasterDataProjectSettingsImpl.class);
		iPopupMasterDataProjectSettings.clickOnYesDeleteProject(driver, testCaseName);
	}
}
