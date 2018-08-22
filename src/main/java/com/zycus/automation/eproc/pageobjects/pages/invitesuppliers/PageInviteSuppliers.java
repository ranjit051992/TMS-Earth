/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.invitesuppliers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageInviteSuppliers
{
	static Logger logger = Logger.getLogger(PageInviteSuppliers.class);

	public static void clickOnSendInvitationLink(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		inviteSuppliers.clickOnSendInvitationLink(driver, testCaseName);
	}

	public static void clickOnSelectAllSuppliers(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		inviteSuppliers.clickOnSelectAllSuppliers(driver, testCaseName);
	}

	public static void clickOnSelectedSuppliers(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		inviteSuppliers.clickOnSelectedSuppliers(driver, testCaseName);
	}

	public static void selectSearchSuppliersBy(WebDriver driver, String testCaseName, String searchSuppliersBy) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		inviteSuppliers.selectSearchSuppliersBy(driver, testCaseName, searchSuppliersBy);
	}

	public static void fillSearchSuppliers(WebDriver driver, String testCaseName, String searchSuppliers) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		inviteSuppliers.fillSearchSuppliers(driver, testCaseName, searchSuppliers);
	}

	public static void clickOnSearchSuppliersGoButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		inviteSuppliers.clickOnSearchSuppliersGoButton(driver, testCaseName);
	}

	public static String getFirstSearchedSupplierName(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		return inviteSuppliers.getFirstSearchedSupplierName(driver, testCaseName);
	}

	public static String getFirstSupplierOfferedProductsAndServices(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		return inviteSuppliers.getFirstSupplierOfferedProductsAndServices(driver, testCaseName);
	}

	public static void selectFirstSearchedSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		inviteSuppliers.selectFirstSearchedSupplier(driver, testCaseName);
	}

	public static void clickOnSaveAndContinue(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		inviteSuppliers.clickOnSaveAndContinue(driver, testCaseName);
	}

	public static String getInvitationTemplateText(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		return inviteSuppliers.getInvitationTemplateText(driver, testCaseName);
	}

	public static void clickOnSaveChangesToInvitationTemplate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		inviteSuppliers.clickOnSaveChangesToInvitationTemplate(driver, testCaseName);
	}

	public static void clickOnNextButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		inviteSuppliers.clickOnNextButton(driver, testCaseName);
	}

	public static void clickOnBackButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		inviteSuppliers.clickOnBackButton(driver, testCaseName);
	}

	public static void clickOnSendInvitationButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		inviteSuppliers.clickOnSendInvitationButton(driver, testCaseName);
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		inviteSuppliers.clickOnCancelButton(driver, testCaseName);
	}

	public static void waitTillSendInvitationProgressingDivPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageInviteSuppliers inviteSuppliers = FactoryPage.getInstanceOf(IPageInviteSuppliersImpl.class);
		inviteSuppliers.waitTillSendInvitationProgressingDivPresent(driver, testCaseName);
	}

}
