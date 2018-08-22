/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.bpobuyingscope;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalBPOBuyingScope
{

	public static String fillBU(WebDriver driver, String testCaseName, String BU) throws ActionBotException, FactoryMethodException
	{
		IModalBPOBuyingScope bpoBuyingScope = FactoryPage.getInstanceOf(IModalBPOBuyingScopeImpl.class);
		return bpoBuyingScope.fillBU(driver, testCaseName, BU);
	}

	public static String fillLocation(WebDriver driver, String testCaseName, String location) throws ActionBotException, FactoryMethodException
	{
		IModalBPOBuyingScope bpoBuyingScope = FactoryPage.getInstanceOf(IModalBPOBuyingScopeImpl.class);
		return bpoBuyingScope.fillLocation(driver, testCaseName, location);
	}

	public static String fillCostCenter(WebDriver driver, String testCaseName, String costCenter) throws ActionBotException, FactoryMethodException
	{
		IModalBPOBuyingScope bpoBuyingScope = FactoryPage.getInstanceOf(IModalBPOBuyingScopeImpl.class);
		return bpoBuyingScope.fillCostCenter(driver, testCaseName, costCenter);
	}

	public static void clickOnOKButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalBPOBuyingScope bpoBuyingScope = FactoryPage.getInstanceOf(IModalBPOBuyingScopeImpl.class);
		bpoBuyingScope.clickOnOKButton(driver, testCaseName);
	}

}
