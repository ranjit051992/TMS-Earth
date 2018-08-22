/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.pcardstatusfilter;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author Sanjay.kundu
 * 
 */
public class ModalPCardListingStatusFilter
{
	public static void clickOnDraftCheckBox(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IModalPCardListingStatusFilter pCardListingStatusFilter = FactoryPage.getInstanceOf(IModalPCardListingStatusFilterImpl.class);
		pCardListingStatusFilter.clickOnDraftCheckBox(driver, testCaseName);
	}

	public static void clickOnInUseCheckBox(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IModalPCardListingStatusFilter pCardListingStatusFilter = FactoryPage.getInstanceOf(IModalPCardListingStatusFilterImpl.class);
		pCardListingStatusFilter.clickOnInUseCheckBox(driver, testCaseName);
	}

	public static void clickOnDeactivatedCheckBox(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IModalPCardListingStatusFilter pCardListingStatusFilter = FactoryPage.getInstanceOf(IModalPCardListingStatusFilterImpl.class);
		pCardListingStatusFilter.clickOnDeactivatedCheckBox(driver, testCaseName);
	}

	public static void clickOnArchivedCheckBox(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IModalPCardListingStatusFilter pCardListingStatusFilter = FactoryPage.getInstanceOf(IModalPCardListingStatusFilterImpl.class);
		pCardListingStatusFilter.clickOnArchivedCheckBox(driver, testCaseName);
	}

	public static void clickOnFilterLink(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IModalPCardListingStatusFilter pCardListingStatusFilter = FactoryPage.getInstanceOf(IModalPCardListingStatusFilterImpl.class);
		pCardListingStatusFilter.clickOnFilterLink(driver, testCaseName);
	}

	public static void clickOnFilterCancelLink(WebDriver driver, String testCaseName) throws FactoryMethodException, ActionBotException
	{
		IModalPCardListingStatusFilter pCardListingStatusFilter = FactoryPage.getInstanceOf(IModalPCardListingStatusFilterImpl.class);
		pCardListingStatusFilter.clickOnFilterCancelLink(driver, testCaseName);
	}

}
