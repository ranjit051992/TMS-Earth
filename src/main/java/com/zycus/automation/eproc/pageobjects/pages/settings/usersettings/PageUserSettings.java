/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.usersettings;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageUserSettings
{

	static Logger logger = Logger.getLogger(IPageUserSettings.class);

	public static String getUserEmailId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;

		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getUserEmailId(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getUserEmailId " + e, e);
		}
		return result;

	}

	public static String fillUserFirstName(WebDriver driver, String testCaseName, String userFirstName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.fillUserFirstName(driver, testCaseName, userFirstName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillUserFirstName " + e, e);
		}
		return result;
	}

	public static String getUserFirstName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getUserFirstName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getUserFirstName " + e, e);
		}
		return result;
	}

	public static String fillUserDisplayName(WebDriver driver, String testCaseName, String userDisplayName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.fillUserDisplayName(driver, testCaseName, userDisplayName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillUserDisplayName " + e, e);
		}
		return result;
	}

	public static String getUserDisplayName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getUserDisplayName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getUserDisplayName " + e, e);
		}
		return result;
	}

	public static String selectDepartment(WebDriver driver, String testCaseName, String departmentName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectDepartment(driver, testCaseName, departmentName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDepartment " + e, e);
		}
		return result;
	}

	public static String getSelectedDepartment(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedDepartment(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedDepartment " + e, e);
		}
		return result;
	}

	public static String selectCompany(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectCompany(driver, testCaseName, companyName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCompany " + e, e);
		}
		return result;
	}

	public static String getSelectedCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedCompany(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedCompany " + e, e);
		}
		return result;
	}

	public static String selectLoaction(WebDriver driver, String testCaseName, String loactionName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectLoaction(driver, testCaseName, loactionName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectLoaction " + e, e);
		}
		return result;
	}

	public static String getSelectedLocation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedLocation(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedLocation " + e, e);
		}
		return result;
	}

	public static String selectPurchasingScope(WebDriver driver, String testCaseName, String purchasingScopeName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectPurchasingScope(driver, testCaseName, purchasingScopeName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectPurchasingScope " + e, e);
		}
		return result;
	}

	public static String getSelectedPurchasingScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedPurchasingScope(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedPurchasingScope " + e, e);
		}
		return result;
	}

	public static String selectDeliveryScope(WebDriver driver, String testCaseName, String deliveryScopeName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectDeliveryScope(driver, testCaseName, deliveryScopeName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDeliveryScope " + e, e);
		}
		return result;
	}

	public static String getSelectedDeliveryScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedDeliveryScope(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedDeliveryScope " + e, e);
		}
		return result;
	}

	public static Float fillPurhcasingLimit(WebDriver driver, String testCaseName, Float purchasingLimit) throws ActionBotException
	{
		Float result = 0f;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.fillPurhcasingLimit(driver, testCaseName, purchasingLimit);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillPurhcasingLimit " + e, e);
		}
		return result;
	}

	public static Float getPurhcasingLimit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Float result = 0f;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getPurhcasingLimit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPurhcasingLimit " + e, e);
		}
		return result;
	}

	public static String selectLocale(WebDriver driver, String testCaseName, String localeName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectLocale(driver, testCaseName, localeName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectLocale " + e, e);
		}
		return result;
	}

	public static String getSelectedLocale(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedLocale(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedLocale " + e, e);
		}
		return result;
	}

	public static String selectTimezone(WebDriver driver, String testCaseName, String timezone) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectTimezone(driver, testCaseName, timezone);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectTimezone " + e, e);
		}
		return result;
	}

	public static String getSelectedTimezone(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedTimezone(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedTimezone " + e, e);
		}
		return result;
	}

	public static String selectNumberFormat(WebDriver driver, String testCaseName, String numberFormat) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectNumberFormat(driver, testCaseName, numberFormat);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectNumberFormat " + e, e);
		}
		return result;
	}

	public static String getSelectedNumberFormat(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedNumberFormat(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedNumberFormat " + e, e);
		}
		return result;
	}

	public static String selectContolCurrency(WebDriver driver, String testCaseName, String contolCurrency) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectContolCurrency(driver, testCaseName, contolCurrency);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectContolCurrency " + e, e);
		}
		return result;
	}

	public static String getSelectedContolCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedContolCurrency(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedContolCurrency " + e, e);
		}
		return result;
	}

	public static String selectSalutation(WebDriver driver, String testCaseName, String salutation) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectSalutation(driver, testCaseName, salutation);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectSalutation " + e, e);
		}
		return result;
	}

	public static String getSelectedSalutation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedSalutation(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedSalutation " + e, e);
		}
		return result;
	}

	public static String fillUserLastName(WebDriver driver, String testCaseName, String userLastName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.fillUserLastName(driver, testCaseName, userLastName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillUserLastName " + e, e);
		}
		return result;
	}

	public static String getUserLastName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getUserLastName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getUserLastName " + e, e);
		}
		return result;
	}

	public static String fillReportingManager(WebDriver driver, String testCaseName, String reportingManager) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.fillReportingManager(driver, testCaseName, reportingManager);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReportingManager " + e, e);
		}
		return result;
	}

	public static String getReportingManager(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getReportingManager(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReportingManager " + e, e);
		}
		return result;
	}

	public static String selectDesignation(WebDriver driver, String testCaseName, String designation) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectDesignation(driver, testCaseName, designation);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDesignation " + e, e);
		}
		return result;
	}

	public static String getSelectedDesignation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedDesignation(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedDesignation " + e, e);
		}
		return result;
	}

	public static String selectBusinessUnit(WebDriver driver, String testCaseName, String businessUnitName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectBusinessUnit(driver, testCaseName, businessUnitName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectBusinessUnit " + e, e);
		}
		return result;
	}

	public static String getSelectedBusinessUnit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedBusinessUnit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedBusinessUnit " + e, e);
		}
		return result;
	}

	public static String selectCostCenter(WebDriver driver, String testCaseName, String costCenterName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectCostCenter(driver, testCaseName, costCenterName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectCostCenter " + e, e);
		}
		return result;
	}

	public static String getSelectedCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedCostCenter(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedCostCenter " + e, e);
		}
		return result;
	}

	public static String selectBeHalfScope(WebDriver driver, String testCaseName, String beHalfScopeName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectBeHalfScope(driver, testCaseName, beHalfScopeName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectBeHalfScope " + e, e);
		}
		return result;
	}

	public static String getSelectedBeHalfScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedBeHalfScope(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedBeHalfScope " + e, e);
		}
		return result;
	}

	public static Integer fillApprovalLimit(WebDriver driver, String testCaseName, int approvalLimit) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.fillApprovalLimit(driver, testCaseName, approvalLimit);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillApprovalLimit " + e, e);
		}
		return result;
	}

	public static Integer getApprovalLimit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int result = 0;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getApprovalLimit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getApprovalLimit " + e, e);
		}
		return result;
	}

	public static String selectUserCurrency(WebDriver driver, String testCaseName, String userCurrency) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectUserCurrency(driver, testCaseName, userCurrency);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectUserCurrency " + e, e);
		}
		return result;
	}

	public static String getSelectedUserCurrency(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedUserCurrency(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedUserCurrency " + e, e);
		}
		return result;
	}

	public static String selectDateFormat(WebDriver driver, String testCaseName, String dateFormat) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectDateFormat(driver, testCaseName, dateFormat);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDateFormat " + e, e);
		}
		return result;
	}

	public static String getSelectedDateFormat(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedDateFormat(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedDateFormat " + e, e);
		}
		return result;
	}

	public static String selectDecimalPlace(WebDriver driver, String testCaseName, String decimalPlace) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.selectDecimalPlace(driver, testCaseName, decimalPlace);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectDecimalPlace " + e, e);
		}
		return result;
	}

	public static String getSelectedDecimalPlace(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String result = null;
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			result = userSettings.getSelectedDecimalPlace(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedDecimalPlace " + e, e);
		}
		return result;
	}

	public static void clickOnUpdateUserButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			userSettings.clickOnUpdateUserButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnUpdateUserButton " + e, e);
		}

	}

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			userSettings.clickOnUpdateUserButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelButton " + e, e);
		}
	}

	public static void clickOnCloseWizardButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			userSettings.clickOnCloseWizardButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCloseWizardButton " + e, e);
		}
	}

	public static String getRequestingScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			return userSettings.getRequestingScope(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequestingScope " + e, e);
		}
		return null;
	}

	public static String getAdminScope(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageUserSettings userSettings = FactoryPage.getInstanceOfIPageUserSettings();
			return userSettings.getAdminScope(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAdminScope " + e, e);
		}
		return null;
	}

}
