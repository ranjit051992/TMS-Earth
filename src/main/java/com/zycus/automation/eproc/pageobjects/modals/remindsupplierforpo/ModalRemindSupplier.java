/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.remindsupplierforpo;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalRemindSupplier
{
	public static String fillRemindSupplierTo(WebDriver driver, String testCaseName, String to) throws ActionBotException, FactoryMethodException
	{
		IModalRemindSupplier remindSupplier = FactoryPage.getInstanceOf(IModalRemindSupplierImpl.class);
		return remindSupplier.fillRemindSupplierTo(driver, testCaseName, to);
	}

	public static String getSelectedRemindSupplierTo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRemindSupplier remindSupplier = FactoryPage.getInstanceOf(IModalRemindSupplierImpl.class);
		return remindSupplier.getSelectedRemindSupplierTo(driver, testCaseName);
	}

	public static void clickOnSendCopyCheckbox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRemindSupplier remindSupplier = FactoryPage.getInstanceOf(IModalRemindSupplierImpl.class);
		remindSupplier.clickOnSendCopyCheckbox(driver, testCaseName);
	}

	public static String fillMessageForRemindSupplier(WebDriver driver, String testCaseName, String message) throws ActionBotException, FactoryMethodException
	{
		IModalRemindSupplier remindSupplier = FactoryPage.getInstanceOf(IModalRemindSupplierImpl.class);
		return remindSupplier.fillMessageForRemindSupplier(driver, testCaseName, message);
	}

	public static String getNameOfAttachment(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRemindSupplier remindSupplier = FactoryPage.getInstanceOf(IModalRemindSupplierImpl.class);
		return remindSupplier.getNameOfAttachment(driver, testCaseName);
	}

	public static void clickOnSendButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRemindSupplier remindSupplier = FactoryPage.getInstanceOf(IModalRemindSupplierImpl.class);
		remindSupplier.clickOnSendButton(driver, testCaseName);
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRemindSupplier remindSupplier = FactoryPage.getInstanceOf(IModalRemindSupplierImpl.class);
		remindSupplier.clickOnCancelButton(driver, testCaseName);
	}

	public static boolean isSuccessMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalRemindSupplier remindSupplier = FactoryPage.getInstanceOf(IModalRemindSupplierImpl.class);
		return remindSupplier.isSuccessMessagePresent(driver, testCaseName);
	}

}
