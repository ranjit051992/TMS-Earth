/**
 * 
 */
package com.zycus.automation.eproc.businessflow.usermanagementflow;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.User;
import com.zycus.automation.bo.UserSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings.PageMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.usermanagement.PageUserManagement;
import com.zycus.automation.eproc.pageobjects.pages.settings.usersettings.PageUserSettings;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class IFlowUserManagementImpl implements IFlowUserManagement
{

	@Override
	public User searchUser(WebDriver driver, String testCaseName, User user) throws ActionBotException, FactoryMethodException
	{
		String user_name = null;
		// to click on master data link
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);

		PageMasterDataSettings.clickOnProceedWithWizardButton(driver, testCaseName);

		PageMasterDataSettings.clickOnUserManagementTab(driver, testCaseName);

		PageMasterDataSettings.clickOnUsersLinkInUserManagementTab(driver, testCaseName);

		// click on users link
		PageMasterDataSettings.clickOnUsersLink(driver, testCaseName);

		// select search by option
		PageUserManagement.selectSearchedUserByType(driver, testCaseName, user.getSearchUserByOption());

		// search user
		if (user.getSearchUserByOption().equalsIgnoreCase(IConstantsData.SEARCH_USER_BY_EMAIL_ID))
		{
			PageUserManagement.fillSearchData(driver, testCaseName, user.getUsername());
		}
		else
		{
			PageUserManagement.fillSearchData(driver, testCaseName, user.getDisplayName());
		}
		PageUserManagement.clickOnSearchGoButton(driver, testCaseName);

		// verify the searched user
		user_name = PageUserManagement.getSearchedUserNameFirstRow(driver, testCaseName);
		user.setResult(user.getDisplayName().equalsIgnoreCase(user_name));
		return user;
	}

	@Override
	public UserSettings changeUserSettings(WebDriver driver, String testCaseName, User user, UserSettings userSettings) throws ActionBotException, FactoryMethodException
	{
		user = searchUser(driver, testCaseName, user);
		assertTrue("Wrong user is searched", user.isResult());
		String url = driver.getCurrentUrl();
		PageUserManagement.clickOnEditSearchedUserButton(driver, testCaseName);

		if (userSettings.getFirstName() != null)
		{
			userSettings.setFirstName(PageUserSettings.fillUserFirstName(driver, testCaseName, userSettings.getFirstName()));
		}
		if (userSettings.getDisplayName() != null)
		{
			userSettings.setDisplayName(PageUserSettings.fillUserDisplayName(driver, testCaseName, userSettings.getDisplayName()));
		}
		if (userSettings.getDepartmentName() != null)
		{
			userSettings.setDepartmentName(PageUserSettings.selectDepartment(driver, testCaseName, userSettings.getDepartmentName()));
		}
		if (userSettings.getCompanyName() != null)
		{
			userSettings.setCompanyName(PageUserSettings.selectCompany(driver, testCaseName, userSettings.getCompanyName()));
		}
		if (userSettings.getLocationName() != null)
		{
			userSettings.setLocationName(PageUserSettings.selectLoaction(driver, testCaseName, userSettings.getLocationName()));
		}
		if (userSettings.getPurchasingScopeName() != null)
		{
			userSettings.setPurchasingScopeName(PageUserSettings.selectPurchasingScope(driver, testCaseName, userSettings.getPurchasingScopeName()));
		}
		if (userSettings.getDeliveryScopeName() != null)
		{
			userSettings.setDeliveryScopeName(PageUserSettings.selectDeliveryScope(driver, testCaseName, userSettings.getDeliveryScopeName()));
		}
		if (userSettings.getPurchasingLimit() != 0)
		{
			userSettings.setPurchasingLimit(PageUserSettings.fillPurhcasingLimit(driver, testCaseName, userSettings.getPurchasingLimit()));
		}
		if (userSettings.getLocale() != null)
		{
			userSettings.setLocale(PageUserSettings.selectLocale(driver, testCaseName, userSettings.getLocale()));
		}
		if (userSettings.getTimezone() != null)
		{
			userSettings.setTimezone(PageUserSettings.selectTimezone(driver, testCaseName, userSettings.getTimezone()));
		}
		if (userSettings.getNumberFormat() != null)
		{
			userSettings.setNumberFormat(PageUserSettings.selectNumberFormat(driver, testCaseName, userSettings.getNumberFormat()));
		}
		if (userSettings.getControlCurrency() != null)
		{
			userSettings.setControlCurrency(PageUserSettings.selectContolCurrency(driver, testCaseName, userSettings.getControlCurrency()));
		}
		if (userSettings.getSalutation() != null)
		{
			userSettings.setSalutation(PageUserSettings.selectSalutation(driver, testCaseName, userSettings.getSalutation()));
		}
		if (userSettings.getLastName() != null)
		{
			userSettings.setLastName(PageUserSettings.fillUserLastName(driver, testCaseName, userSettings.getLastName()));
		}
		if (userSettings.getReportingManager() != null)
		{
			userSettings.setReportingManager(PageUserSettings.fillReportingManager(driver, testCaseName, userSettings.getReportingManager()));
		}
		if (userSettings.getDesignation() != null)
		{
			userSettings.setDesignation(PageUserSettings.selectDesignation(driver, testCaseName, userSettings.getDesignation()));
		}
		if (userSettings.getBusinessUnit() != null)
		{
			userSettings.setBusinessUnit(PageUserSettings.selectBusinessUnit(driver, testCaseName, userSettings.getBusinessUnit()));
		}
		if (userSettings.getCostCenter() != null)
		{
			userSettings.setCostCenter(PageUserSettings.selectCostCenter(driver, testCaseName, userSettings.getCostCenter()));
		}
		if (userSettings.getBehalfScope() != null)
		{
			userSettings.setBehalfScope(PageUserSettings.selectBeHalfScope(driver, testCaseName, userSettings.getBehalfScope()));
		}
		if (userSettings.getApprovalLimit() != 0)
		{
			userSettings.setApprovalLimit(PageUserSettings.fillApprovalLimit(driver, testCaseName, userSettings.getApprovalLimit()));
		}
		if (userSettings.getUserCurrency() != null)
		{
			userSettings.setUserCurrency(PageUserSettings.selectUserCurrency(driver, testCaseName, userSettings.getUserCurrency()));
		}
		if (userSettings.getDateFormat() != null)
		{
			userSettings.setDateFormat(PageUserSettings.selectDateFormat(driver, testCaseName, userSettings.getDateFormat()));
		}
		if (userSettings.getDecimalPlace() != null)
		{
			userSettings.setDecimalPlace(PageUserSettings.selectDecimalPlace(driver, testCaseName, userSettings.getDecimalPlace()));
		}

		PageUserSettings.clickOnUpdateUserButton(driver, testCaseName);
		driver.get(url);
		ActionBot.defaultSleep();
		PageUserManagement.clickOnReturnToSetUpModule(driver, testCaseName);
		MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

		return userSettings;
	}

	@Override
	public UserSettings getUserSettings(WebDriver driver, String testCaseName, User user) throws ActionBotException, FactoryMethodException
	{
		UserSettings userSettings = new UserSettings();
		user = searchUser(driver, testCaseName, user);
		assertTrue("Wrong user is searched", user.isResult());
		driver.getCurrentUrl();
		PageUserManagement.clickOnEditSearchedUserButton(driver, testCaseName);

		userSettings.setFirstName(PageUserSettings.getUserFirstName(driver, testCaseName));

		userSettings.setDisplayName(PageUserSettings.getUserDisplayName(driver, testCaseName));

		userSettings.setDepartmentName(PageUserSettings.getSelectedDepartment(driver, testCaseName));

		userSettings.setCompanyName(PageUserSettings.getSelectedCompany(driver, testCaseName));

		userSettings.setLocationName(PageUserSettings.getSelectedLocation(driver, testCaseName));

		userSettings.setPurchasingScopeName(PageUserSettings.getSelectedPurchasingScope(driver, testCaseName));

		userSettings.setRequestingScope(PageUserSettings.getRequestingScope(driver, testCaseName));
		if (userSettings.getRequestingScope() != null)
		{
			userSettings.setPurchasingScopeName(userSettings.getRequestingScope());
		}

		userSettings.setAdminScope(PageUserSettings.getAdminScope(driver, testCaseName));

		userSettings.setDeliveryScopeName(PageUserSettings.getSelectedDeliveryScope(driver, testCaseName));

		userSettings.setPurchasingLimit(PageUserSettings.getPurhcasingLimit(driver, testCaseName));

		userSettings.setLocale(PageUserSettings.getSelectedLocale(driver, testCaseName));

		userSettings.setTimezone(PageUserSettings.getSelectedTimezone(driver, testCaseName));

		userSettings.setNumberFormat(PageUserSettings.getSelectedNumberFormat(driver, testCaseName));

		userSettings.setControlCurrency(PageUserSettings.getSelectedContolCurrency(driver, testCaseName));

		userSettings.setSalutation(PageUserSettings.getSelectedSalutation(driver, testCaseName));

		userSettings.setLastName(PageUserSettings.getUserLastName(driver, testCaseName));

		userSettings.setReportingManager(PageUserSettings.getReportingManager(driver, testCaseName));

		userSettings.setDesignation(PageUserSettings.getSelectedDesignation(driver, testCaseName));

		userSettings.setBusinessUnit(PageUserSettings.getSelectedBusinessUnit(driver, testCaseName));

		userSettings.setCostCenter(PageUserSettings.getSelectedCostCenter(driver, testCaseName));

		userSettings.setBehalfScope(PageUserSettings.getSelectedBeHalfScope(driver, testCaseName));

		userSettings.setApprovalLimit(PageUserSettings.getApprovalLimit(driver, testCaseName));

		userSettings.setUserCurrency(PageUserSettings.getSelectedUserCurrency(driver, testCaseName));

		userSettings.setDateFormat(PageUserSettings.getSelectedDateFormat(driver, testCaseName));

		userSettings.setDecimalPlace(PageUserSettings.getSelectedDecimalPlace(driver, testCaseName));

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300);");
		PageUserSettings.clickOnCloseWizardButton(driver, testCaseName);
		MainPageHeaderLevelTab.clickOnRequisitionTab(driver);
		return userSettings;
	}

	@Override
	public User addUser(WebDriver driver, String testCaseName, User user) throws ActionBotException
	{
		UserSettings userSettings = user.getUserSettings();
		String url = driver.getCurrentUrl();
		PageUserManagement.clickOnAddUserLink(driver, testCaseName);

		if (userSettings.getFirstName() != null)
		{
			userSettings.setFirstName(PageUserSettings.fillUserFirstName(driver, testCaseName, userSettings.getFirstName()));
		}
		if (userSettings.getDisplayName() != null)
		{
			userSettings.setDisplayName(PageUserSettings.fillUserDisplayName(driver, testCaseName, userSettings.getDisplayName()));
		}
		if (userSettings.getDepartmentName() != null)
		{
			userSettings.setDepartmentName(PageUserSettings.selectDepartment(driver, testCaseName, userSettings.getDepartmentName()));
		}
		if (userSettings.getCompanyName() != null)
		{
			userSettings.setCompanyName(PageUserSettings.selectCompany(driver, testCaseName, userSettings.getCompanyName()));
		}
		if (userSettings.getLocationName() != null)
		{
			userSettings.setLocationName(PageUserSettings.selectLoaction(driver, testCaseName, userSettings.getLocationName()));
		}
		if (userSettings.getPurchasingScopeName() != null)
		{
			userSettings.setPurchasingScopeName(PageUserSettings.selectPurchasingScope(driver, testCaseName, userSettings.getPurchasingScopeName()));
		}
		if (userSettings.getDeliveryScopeName() != null)
		{
			userSettings.setDeliveryScopeName(PageUserSettings.selectDeliveryScope(driver, testCaseName, userSettings.getDeliveryScopeName()));
		}
		if (userSettings.getPurchasingLimit() != 0)
		{
			userSettings.setPurchasingLimit(PageUserSettings.fillPurhcasingLimit(driver, testCaseName, userSettings.getPurchasingLimit()));
		}
		if (userSettings.getLocale() != null)
		{
			userSettings.setLocale(PageUserSettings.selectLocale(driver, testCaseName, userSettings.getLocale()));
		}
		if (userSettings.getTimezone() != null)
		{
			userSettings.setTimezone(PageUserSettings.selectTimezone(driver, testCaseName, userSettings.getTimezone()));
		}
		if (userSettings.getNumberFormat() != null)
		{
			userSettings.setNumberFormat(PageUserSettings.selectNumberFormat(driver, testCaseName, userSettings.getNumberFormat()));
		}
		if (userSettings.getControlCurrency() != null)
		{
			userSettings.setControlCurrency(PageUserSettings.selectContolCurrency(driver, testCaseName, userSettings.getControlCurrency()));
		}
		if (userSettings.getSalutation() != null)
		{
			userSettings.setSalutation(PageUserSettings.selectSalutation(driver, testCaseName, userSettings.getSalutation()));
		}
		if (userSettings.getLastName() != null)
		{
			userSettings.setLastName(PageUserSettings.fillUserLastName(driver, testCaseName, userSettings.getLastName()));
		}
		if (userSettings.getReportingManager() != null)
		{
			userSettings.setReportingManager(PageUserSettings.fillReportingManager(driver, testCaseName, userSettings.getReportingManager()));
		}
		if (userSettings.getDesignation() != null)
		{
			userSettings.setDesignation(PageUserSettings.selectDesignation(driver, testCaseName, userSettings.getDesignation()));
		}
		if (userSettings.getBusinessUnit() != null)
		{
			userSettings.setBusinessUnit(PageUserSettings.selectBusinessUnit(driver, testCaseName, userSettings.getBusinessUnit()));
		}
		if (userSettings.getCostCenter() != null)
		{
			userSettings.setCostCenter(PageUserSettings.selectCostCenter(driver, testCaseName, userSettings.getCostCenter()));
		}
		if (userSettings.getBehalfScope() != null)
		{
			userSettings.setBehalfScope(PageUserSettings.selectBeHalfScope(driver, testCaseName, userSettings.getBehalfScope()));
		}
		if (userSettings.getApprovalLimit() != 0)
		{
			userSettings.setApprovalLimit(PageUserSettings.fillApprovalLimit(driver, testCaseName, userSettings.getApprovalLimit()));
		}
		if (userSettings.getUserCurrency() != null)
		{
			userSettings.setUserCurrency(PageUserSettings.selectUserCurrency(driver, testCaseName, userSettings.getUserCurrency()));
		}
		if (userSettings.getDateFormat() != null)
		{
			userSettings.setDateFormat(PageUserSettings.selectDateFormat(driver, testCaseName, userSettings.getDateFormat()));
		}
		if (userSettings.getDecimalPlace() != null)
		{
			userSettings.setDecimalPlace(PageUserSettings.selectDecimalPlace(driver, testCaseName, userSettings.getDecimalPlace()));
		}

		if (userSettings.getNextAction().equalsIgnoreCase(IConstantsData.ADD))
		{
			PageUserSettings.clickOnUpdateUserButton(driver, testCaseName);
			driver.get(url);
			ActionBot.defaultSleep();
			PageUserManagement.clickOnReturnToSetUpModule(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
		}
		user.setUserSettings(userSettings);
		return user;
	}

	@Override
	public String getUserCostCenter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		String str = ActionBot.findElement(driver, By.xpath(".//*[@id='userInfoList']//tr//td[6]")).getText();
		String array[] = str.split("\\|");
		String costCenter = array[2].trim();
		return costCenter;
	}
}
