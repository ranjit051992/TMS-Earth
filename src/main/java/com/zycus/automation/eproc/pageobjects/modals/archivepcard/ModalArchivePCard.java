/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.archivepcard;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalArchivePCard
{

	public static String fillArchivingComments(WebDriver driver, String testCaseName, String comments) throws ActionBotException, FactoryMethodException
	{
		IModalArchivePCard archivePCard = FactoryPage.getInstanceOf(IModalArchivePCardImpl.class);
		return archivePCard.fillArchivingComments(driver, testCaseName, comments);
	}

	public static String selectArchiveReasons(WebDriver driver, String testCaseName, String archiveReasons) throws ActionBotException, FactoryMethodException
	{
		IModalArchivePCard archivePCard = FactoryPage.getInstanceOf(IModalArchivePCardImpl.class);
		return archivePCard.selectArchiveReasons(driver, testCaseName, archiveReasons);
	}

	public static void clickOnArchiveButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalArchivePCard archivePCard = FactoryPage.getInstanceOf(IModalArchivePCardImpl.class);
		archivePCard.clickOnArchiveButton(driver, testCaseName);
	}

	public static void clickOnCancelArchiveButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalArchivePCard archivePCard = FactoryPage.getInstanceOf(IModalArchivePCardImpl.class);
		archivePCard.clickOnCancelArchiveButton(driver, testCaseName);
	}

}
