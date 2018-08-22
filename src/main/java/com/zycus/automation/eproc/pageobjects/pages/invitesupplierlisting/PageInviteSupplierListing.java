/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.invitesupplierlisting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageInviteSupplierListing
{

	public static void clickOnSendInvitationsButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSupplierListing inviteSupplierListing = FactoryPage.getInstanceOf(IPageInviteSupplierListingImpl.class);
		inviteSupplierListing.clickOnSendInvitationsButton(driver, testCaseName);
	}

	public static String fillSearchSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSupplierListing inviteSupplierListing = FactoryPage.getInstanceOf(IPageInviteSupplierListingImpl.class);
		return inviteSupplierListing.fillSearchSupplier(driver, testCaseName, supplierName);
	}

	public static void clickOnFilterButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSupplierListing inviteSupplierListing = FactoryPage.getInstanceOf(IPageInviteSupplierListingImpl.class);
		inviteSupplierListing.clickOnFilterButton(driver, testCaseName);
	}

	public static void clickOnClearFilterButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSupplierListing inviteSupplierListing = FactoryPage.getInstanceOf(IPageInviteSupplierListingImpl.class);
		inviteSupplierListing.clickOnClearFilterButton(driver, testCaseName);
	}

	public static void clickOnInvitedStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSupplierListing inviteSupplierListing = FactoryPage.getInstanceOf(IPageInviteSupplierListingImpl.class);
		inviteSupplierListing.clickOnInvitedStatusFilterButton(driver, testCaseName);
	}

	public static void clickOnCancelledStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSupplierListing inviteSupplierListing = FactoryPage.getInstanceOf(IPageInviteSupplierListingImpl.class);
		inviteSupplierListing.clickOnCancelledStatusFilterButton(driver, testCaseName);
	}

	public static String getSearchedSupplierName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSupplierListing inviteSupplierListing = FactoryPage.getInstanceOf(IPageInviteSupplierListingImpl.class);
		return inviteSupplierListing.getSearchedSupplierName(driver, testCaseName);
	}

	public static String getSearchedSupplierInfo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSupplierListing inviteSupplierListing = FactoryPage.getInstanceOf(IPageInviteSupplierListingImpl.class);
		return inviteSupplierListing.getSearchedSupplierInfo(driver, testCaseName);
	}

	public static void clickOnRemindSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSupplierListing inviteSupplierListing = FactoryPage.getInstanceOf(IPageInviteSupplierListingImpl.class);
		inviteSupplierListing.clickOnRemindSupplierLink(driver, testCaseName);
	}

	public static void clickOnCancelInvitationLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSupplierListing inviteSupplierListing = FactoryPage.getInstanceOf(IPageInviteSupplierListingImpl.class);
		inviteSupplierListing.clickOnCancelInvitationLink(driver, testCaseName);
	}

	public static String waitTillProgressingDivIsPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSupplierListing inviteSupplierListing = FactoryPage.getInstanceOf(IPageInviteSupplierListingImpl.class);
		return inviteSupplierListing.waitTillProgressingDivIsPresent(driver, testCaseName);
	}

	public static boolean isDataTableEmptyPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSupplierListing inviteSupplierListing = FactoryPage.getInstanceOf(IPageInviteSupplierListingImpl.class);
		return inviteSupplierListing.isDataTableEmptyPresent(driver, testCaseName);
	}

}
