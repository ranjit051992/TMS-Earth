/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.selectcatalogcompaniesandbu;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 * 
 */
public class ModalSelectCompaniesAndBU
{
	static Logger logger = Logger.getLogger(ModalSelectCompaniesAndBU.class);

	public static void selectAllOU(WebDriver driver, String testCaseName, String regionName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.selectAllOU(driver, testCaseName, regionName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectAllOU " + e, e);
		}
	}

	public static String selectOU(WebDriver driver, String testCaseName, String ou) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			return selectCompaniesAndBU.selectOU(driver, testCaseName, ou);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectOU " + e, e);
		}
		return null;
	}

	public static void clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnSaveButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveButton " + e, e);
		}
	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnCancelButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelButton " + e, e);
		}
	}

	public static boolean isRegionsTabPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			return selectCompaniesAndBU.isRegionsTabPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isRegionsTabPresent " + e, e);
		}
		return false;
	}

	public static void clickOnRegionsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnRegionsTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnRegionsTab " + e, e);
		}
	}

	// select company
	public static void clickOnIstCompanyCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.selectIstCompanies(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCompanycheckbox " + e, e);
		}
	}

	// select company
	public static void clickOnSecSelectCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.selectSecCompanies(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCompanycheckbox " + e, e);
		}
	}

	public static void clickOnLinkSelectAllBu(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnLinkSelecteAllBusinessUnit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnlinkSelectBu " + e, e);
		}
	}

	public static void clickOnLinkClickHereToEditBu(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnLinkOnLinkHereToEditAllBusinessUnit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnlinkEditSelectBu " + e, e);
		}
	}

	public static void clickOnCompaniesTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnCompaniesTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCompaniesTab " + e, e);
		}
	}

	public static void clickOnBusinessUnitsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnBusinessUnitsTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnBusinessUnitsTab " + e, e);
		}
	}

	public static void clickOnLcoationsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnLcoationsTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnLcoationsTab " + e, e);
		}
	}

	public static boolean selectRegion(WebDriver driver, String testCaseName, String region) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			return selectCompaniesAndBU.selectRegion(driver, testCaseName, region);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectRegion " + e, e);
		}
		return false;
	}

	public static void clickOnSelectOULink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnSelectOULink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectOULink " + e, e);
		}
	}

	public static void clickOnSelectAllOUCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnSelectAllOUCheckbox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectAllOUCheckbox " + e, e);
		}
	}

	public static void clickOnSaveSelectedOUButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnSaveSelectedOUButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveSelectedOUButton " + e, e);
		}
	}

	public static void clickOnCancelSelectedOUButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnCancelSelectedOUButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelSelectedOUButton " + e, e);
		}
	}

	public static void clickOnSelectAllBUsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnSelectAllBUsLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectAllBUsLink " + e, e);
		}
	}

	public static void clickOnSelectAllLocationsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnSelectAllLocationsLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectAllLocationsLink " + e, e);
		}
	}

	public static void clickOnSaveSelectedScopeButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnSaveSelectedScopeButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveSelectedScopeButton " + e, e);
		}
	}

	public static void clickOnCancelSelectedScopeButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnCancelSelectedScopeButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelSelectedScopeButton " + e, e);
		}
	}

	public static boolean isOUPresentOrNot(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			return selectCompaniesAndBU.isOUPresentOrNot(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isOUPresentOrNot " + e, e);
		}
		return false;
	}

	public static void clickOnOUUnderBUTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnOUUnderBUTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnOUUnderBUTab " + e, e);
		}
	}

	public static void clickOnOUUnderLocationsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnOUUnderLocationsTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnOUUnderLocationsTab " + e, e);
		}
	}

	// select company
	public static void clickOnThirdSelectCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.selectThirdCompanies(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCompanycheckbox " + e, e);
		}
	}

	public static List<String> getAllCompanies(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			return selectCompaniesAndBU.getAllCompanies(driver, testCaseName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static List<String> getAllBUs(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			return selectCompaniesAndBU.getAllBUs(driver, testCaseName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static List<String> getAllLocations(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			return selectCompaniesAndBU.getAllLocations(driver, testCaseName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static void clickOnSelectOUInBUTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnSelectOUInBUTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCompanycheckbox " + e, e);
		}
	}

	public static void clickOnSaveSelectedOU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnSaveSelectedOU(driver, testCaseName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void clickOnFirstBUCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnFirstBUCheckbox(driver, testCaseName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void clickOnselectOUInLocationsTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			selectCompaniesAndBU.clickOnselectOUInLocationsTab(driver, testCaseName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static boolean isSaveSelectedOUButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			return selectCompaniesAndBU.isSaveSelectedOUButtonPresent(driver, testCaseName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isCompaniesTabPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			return selectCompaniesAndBU.isCompaniesTabPresent(driver, testCaseName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isBusinessUnitsTabPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			return selectCompaniesAndBU.isBusinessUnitsTabPresent(driver, testCaseName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isLocationsTabPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			return selectCompaniesAndBU.isLocationsTabPresent(driver, testCaseName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isSelectAllBUsLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			return selectCompaniesAndBU.isSelectAllBUsLinkPresent(driver, testCaseName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isSelectAllLocationsLinkPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalSelectCompaniesAndBU selectCompaniesAndBU = FactoryPage.getInstanceOf(IModalSelectCompaniesAndBUImpl.class);
			return selectCompaniesAndBU.isSelectAllLocationsLinkPresent(driver, testCaseName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
