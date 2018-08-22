/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.selectcompanypcard;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalSelectCompanyForPCard
{
	static Logger logger = Logger.getLogger(ModalSelectCompanyForPCard.class);

	public static void selectAllCompany(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalSelectCompanyForPCard selectCompanyForPCard = FactoryPage.getInstanceOf(IModalSelectCompanyForPCardImpl.class);
		selectCompanyForPCard.selectAllCompany(driver, testCaseName);
	}

	public static String selectCompany(WebDriver driver, String testCaseName, String company) throws ActionBotException, FactoryMethodException
	{
		IModalSelectCompanyForPCard selectCompanyForPCard = FactoryPage.getInstanceOf(IModalSelectCompanyForPCardImpl.class);
		return selectCompanyForPCard.selectCompany(driver, testCaseName, company);
	}

	public static void clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalSelectCompanyForPCard selectCompanyForPCard = FactoryPage.getInstanceOf(IModalSelectCompanyForPCardImpl.class);
		selectCompanyForPCard.clickOnSaveButton(driver, testCaseName);
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalSelectCompanyForPCard selectCompanyForPCard = FactoryPage.getInstanceOf(IModalSelectCompanyForPCardImpl.class);
		selectCompanyForPCard.clickOnCancelButton(driver, testCaseName);
	}

}
