/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.deactivatepcard;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalDeactivatePCard
{

	public static String fillDeactivateComments(WebDriver driver, String testCaseName, String comments) throws ActionBotException, FactoryMethodException
	{
		IModalDeactivatePCard deactivatePCard = FactoryPage.getInstanceOf(IModalDeactivatePCardImpl.class);
		return deactivatePCard.fillDeactivateComments(driver, testCaseName, comments);
	}

	public static String selectDeactivateReasons(WebDriver driver, String testCaseName, String deactivateReasons) throws ActionBotException, FactoryMethodException
	{
		IModalDeactivatePCard deactivatePCard = FactoryPage.getInstanceOf(IModalDeactivatePCardImpl.class);
		return deactivatePCard.selectDeactivateReasons(driver, testCaseName, deactivateReasons);
	}

	public static void clickOnDeactivateButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDeactivatePCard deactivatePCard = FactoryPage.getInstanceOf(IModalDeactivatePCardImpl.class);
		deactivatePCard.clickOnDeactivateButton(driver, testCaseName);
	}

	public static void clickOnCancelDeactivateButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalDeactivatePCard deactivatePCard = FactoryPage.getInstanceOf(IModalDeactivatePCardImpl.class);
		deactivatePCard.clickOnCancelDeactivateButton(driver, testCaseName);
	}

}
