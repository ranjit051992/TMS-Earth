/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.pcardactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalPCardListingActions
{
	public static void clickOnActivatePCardActionsLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPCardListingActions pCardListingActions = FactoryPage.getInstanceOf(IModalPCardListingActionsImpl.class);
		pCardListingActions.clickOnActivatePCardActionsLink(driver, testCaseName);
	}

	public static void clickOnEditPCardActionsLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPCardListingActions pCardListingActions = FactoryPage.getInstanceOf(IModalPCardListingActionsImpl.class);
		pCardListingActions.clickOnEditPCardActionsLink(driver, testCaseName);
	}

	public static void clickOnArchivePCardActionsLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPCardListingActions pCardListingActions = FactoryPage.getInstanceOf(IModalPCardListingActionsImpl.class);
		pCardListingActions.clickOnArchivePCardActionsLink(driver, testCaseName);
	}

	public static void clickOnDeactivatePCardActionsLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalPCardListingActions pCardListingActions = FactoryPage.getInstanceOf(IModalPCardListingActionsImpl.class);
		pCardListingActions.clickOnDeactivatePCardActionsLink(driver, testCaseName);
	}
}
