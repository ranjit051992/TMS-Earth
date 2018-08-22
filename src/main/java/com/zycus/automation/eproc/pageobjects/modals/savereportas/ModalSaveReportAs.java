/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.savereportas;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalSaveReportAs
{

	public static String fillReportName(WebDriver driver, String testCaseName, String reportName) throws ActionBotException, FactoryMethodException
	{
		IModalSaveReportAs saveReportAs = FactoryPage.getInstanceOf(IModalSaveReportAsImpl.class);
		return saveReportAs.fillReportName(driver, testCaseName, reportName);
	}

	public static String fillFolderName(WebDriver driver, String testCaseName, String folderName) throws ActionBotException, FactoryMethodException
	{
		IModalSaveReportAs saveReportAs = FactoryPage.getInstanceOf(IModalSaveReportAsImpl.class);
		return saveReportAs.fillFolderName(driver, testCaseName, folderName);
	}

	public static void clickOnCreateNewFolder(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalSaveReportAs saveReportAs = FactoryPage.getInstanceOf(IModalSaveReportAsImpl.class);
		saveReportAs.clickOnCreateNewFolder(driver, testCaseName);
	}

	public static void clickOnScheduleReportCheckbox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalSaveReportAs saveReportAs = FactoryPage.getInstanceOf(IModalSaveReportAsImpl.class);
		saveReportAs.clickOnScheduleReportCheckbox(driver, testCaseName);
	}

	public static void clickOnSaveReportButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalSaveReportAs saveReportAs = FactoryPage.getInstanceOf(IModalSaveReportAsImpl.class);
		saveReportAs.clickOnSaveReportButton(driver, testCaseName);
	}

	public static void clickOnCloseSaveReportAsModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalSaveReportAs saveReportAs = FactoryPage.getInstanceOf(IModalSaveReportAsImpl.class);
		saveReportAs.clickOnCloseSaveReportAsModal(driver, testCaseName);
	}

}
