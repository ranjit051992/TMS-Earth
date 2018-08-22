/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.selectbuofceform;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalSelectBUOfCEform
{
	static Logger logger = Logger.getLogger(ModalSelectBUOfCEform.class);

	public static List<WebElement> getListOfCompanyNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectBUOfCEform selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			return selectBUOfCEform.getListOfCompanyNames(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListOfCompanyNames " + e, e);
		}
		return null;
	}

	public static void clickOnSaveORGUnitButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectBUOfCEform selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			selectBUOfCEform.clickOnSaveORGUnitButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveORGUnitButton " + e, e);
		}
	}

	public static void clickOnCancelORGUnitButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectBUOfCEform selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			selectBUOfCEform.clickOnCancelORGUnitButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelORGUnitButton " + e, e);
		}
	}

	public static String clickOnOU(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		try
		{
			IModalSelectBUOfCEform selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			return selectBUOfCEform.clickOnOU(driver, testCaseName, companyName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnOU " + e, e);
		}
		return null;
	}

	public static void selectAllOU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectBUOfCEform selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			selectBUOfCEform.selectAllOU(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAllOU " + e, e);
		}
	}

	public static void selectIstOrganisationUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectBUOfCEform selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			selectBUOfCEform.selectIstOrganisationUnit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAllOrganisationUnit " + e, e);
		}
	}

	public static void selectSECOrganisationUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectBUOfCEform selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			selectBUOfCEform.selectSecOrganisationUnit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectSecOrganisationUnit " + e, e);
		}
	}

	public static void clickTabBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectBUOfCEform selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			selectBUOfCEform.clickTabBusinessUnit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickTabBusinessUnit " + e, e);
		}
	}

	public static void clickLinkSelectBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectBUOfCEform selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			selectBUOfCEform.clickLinkSelectBusinessUnit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickLinkSelectBusinessUnit " + e, e);
		}
	}

	public static void SelectCheckBoxOU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectBUOfCEform selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			selectBUOfCEform.SelectCheckBoxOU(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method SelectCheckBoxOU " + e, e);
		}
	}

	public static void clickBtnSaveSelectedOu(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectBUOfCEform selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			selectBUOfCEform.BtnSaveSelectedOU(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method SelectCheckBoxOU " + e, e);
		}
	}

	public static List<String> getListSelectedOFOUsForPEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectBUOfCEform selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			return selectBUOfCEform.getListSelectedOFOUsForPEform(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getListSelectedOFOUsForPEform " + e, e);
		}
		return null;
	}

	public static void clearAllSelectedOUs(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectBUOfCEform selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			selectBUOfCEform.clearAllSelectedOUs(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clearAllSelectedOUs " + e, e);
		}
	}

	public static boolean isOUSelectedOrNot(WebDriver driver, String testCaseName, String ou) throws ActionBotException
	{
		try
		{
			IModalSelectBUOfCEform selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			return selectBUOfCEform.isOUSelectedOrNot(driver, testCaseName, ou);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isOUSelectedOrNot " + e, e);
		}
		return false;
	}

	public static boolean isOUPresentOrNot(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectBUOfCEform selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			return selectBUOfCEform.isOUPresentOrNot(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isOUPresentOrNot " + e, e);
		}
		return false;
	}

	public static void clickLinkSelectAllBU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalSelectBUOfCEform selectBUOfCEform;
		try
		{
			selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			selectBUOfCEform.clickLinkSelectAllBU(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickLinkSelectAllBU " + e, e);
		}

	}

	public static void click1StLinkSelectOU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalSelectBUOfCEform selectBUOfCEform;
		try
		{
			selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			selectBUOfCEform.clickLink1StOU(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickLinkSelectAllBU " + e, e);
		}

	}

	/*
	 * author : bhakti.sawant : select check box
	 */
	public static void SelectCheckBoxBusinessUnit(WebDriver driver, String testCaseName, String businessUnit) throws ActionBotException
	{
		IModalSelectBUOfCEform selectBUOfCEform;
		try
		{
			selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			selectBUOfCEform.SelectCheckBoxBusinessUnit(driver, testCaseName, businessUnit);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickLinkSelectAllBU " + e, e);
		}
	}

	/*
	 * author : Rohini Shinge
	 */
	public static void SelectCheckBoxBusinessUnitByCode(WebDriver driver, String testCaseName, String businessUnit) throws ActionBotException
	{
		IModalSelectBUOfCEform selectBUOfCEform;
		try
		{
			selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			selectBUOfCEform.SelectCheckBoxBusinessUnitByCode(driver, testCaseName, businessUnit);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method SelectCheckBoxBusinessUnitByCode " + e, e);
		}
	}

	public static void selectCompanyByName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		IModalSelectBUOfCEform selectBUOfCEform;
		try
		{
			selectBUOfCEform = FactoryPage.getInstanceOf(IModalSelectBUOfCEformImpl.class);
			selectBUOfCEform.selectCompanyByName(driver, testCaseName, companyName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCompanyByName " + e, e);
		}
	}
}
