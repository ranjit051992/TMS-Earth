package com.zycus.automation.eproc.businessflow.projectFlow;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.Project;
import com.zycus.automation.eproc.pageobjects.modals.masterdataSettingsProjectSelectBU.ModalSelectBUProjectSettings;
import com.zycus.automation.eproc.pageobjects.modals.selectbusformasterdata.ModalSelectBUsForMasterData;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings.PageMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.projectsmasterdatasettings.IPageProjectsMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.projectsmasterdatasettings.PageProjectsMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.usermanagement.PageUserManagement;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class FlowProject
{
	public static Project createProject(WebDriver driver, String testCaseName, Project project, int index) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
		PageProjectsMasterDataSettings.clickOnAddProjectLink(driver, testCaseName);
		PageProjectsMasterDataSettings.fillProjectNumber(driver, testCaseName, project.getProjectNumber());
		PageProjectsMasterDataSettings.fillProjectName(driver, testCaseName, project.getProjectName());
		PageProjectsMasterDataSettings.selectCompany(driver, testCaseName, project.getCompany());
		PageProjectsMasterDataSettings.clickOnSelectBU(driver, testCaseName);
		ModalSelectBUProjectSettings.clickOnBUCheckbox(driver, testCaseName, index);
		ModalSelectBUProjectSettings.clickOnSaveSelectedBU(driver, testCaseName);
		PageProjectsMasterDataSettings.clickOnSaveAddedProject(driver, testCaseName);
		PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
		return project;
	}

	public static Project createProject(WebDriver driver, String testCaseName, Project project) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
		PageProjectsMasterDataSettings.clickOnAddProjectLink(driver, testCaseName);
		PageProjectsMasterDataSettings.fillProjectNumber(driver, testCaseName, project.getProjectNumber());
		PageProjectsMasterDataSettings.fillProjectName(driver, testCaseName, project.getProjectName());
		PageProjectsMasterDataSettings.selectCompany(driver, testCaseName, project.getCompany());
		PageProjectsMasterDataSettings.clickOnSelectBU(driver, testCaseName);
		if (project.getBUName() != null)
		{
			ModalSelectBUProjectSettings.clickOnBUCheckbox(driver, testCaseName, project.getBUName());
		}
		else
		{
			ModalSelectBUProjectSettings.clickOnBUCheckbox(driver, testCaseName, 1);
		}
		ModalSelectBUProjectSettings.clickOnSaveSelectedBU(driver, testCaseName);
		PageProjectsMasterDataSettings.clickOnSaveAddedProject(driver, testCaseName);
		PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
		return project;
	}

	public static void deleteProject(WebDriver driver, String testCaseName, String name, Project project) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
		PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, name);
		PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
		PageProjectsMasterDataSettings.clickOnDelete(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);

	}

	public static boolean deleteProject(WebDriver driver, String testCaseName, String projectName, String searchProjectIn) throws ActionBotException, FactoryMethodException
	{
		boolean flag = searchProject(driver, testCaseName, projectName, searchProjectIn);
		assertTrue("Error while searching project", flag);
		PageProjectsMasterDataSettings.clickOnDelete(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		flag = PageProjectsMasterDataSettings.isDataTableEmptyPresent(driver, testCaseName);
		PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
		return flag;
	}

	public static Project changeStatusOfProject(WebDriver driver, String testCaseName, String name, Project project) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
		PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, name);
		PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
		if (project.getChangStatus().equalsIgnoreCase(IPageProjectsMasterDataSettings.ACTIVE))
		{
			PageProjectsMasterDataSettings.clickOnActive(driver, testCaseName);
		}
		if (project.getChangStatus().equalsIgnoreCase(IPageProjectsMasterDataSettings.INACTIVE))
		{
			PageProjectsMasterDataSettings.clickOnDeActive(driver, testCaseName);
		}
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
		return project;
	}

	public static void outdateProject(WebDriver driver, String testCaseName, String name, Project project, int day, int month, int year, boolean applySetting)
		throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
		PageProjectsMasterDataSettings.fillProjectName(driver, testCaseName, name);
		PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
		PageProjectsMasterDataSettings.clickOnEdit(driver, testCaseName);
		if (applySetting == true)
		{
			PageProjectsMasterDataSettings.fillProjectEndDate(driver, testCaseName, day, month, year);
		}
		else
		{
			PageProjectsMasterDataSettings.clickOnClearDate(driver, testCaseName);
		}
		PageProjectsMasterDataSettings.clickOnSaveAddedProject(driver, testCaseName);
		PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
	}

	/**
	 *
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Search Project <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param projectName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean searchProject(WebDriver driver, String testCaseName, String projectName, String searchProjectIn) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnProjectsLink(driver, testCaseName);
		PageProjectsMasterDataSettings.fillProjectSearchBox(driver, testCaseName, projectName);
		PageProjectsMasterDataSettings.selectSearchProjectIn(driver, testCaseName, searchProjectIn);
		PageProjectsMasterDataSettings.clickOnGo(driver, testCaseName);
		boolean flag = PageProjectsMasterDataSettings.getProjectName(driver, testCaseName).equalsIgnoreCase(projectName);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Remove BU from Project <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param buName </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static void removeBUFromProject(WebDriver driver, String testCaseName, String buName) throws ActionBotException, FactoryMethodException
	{
		PageProjectsMasterDataSettings.clickOnSelectBU(driver, testCaseName);
		if (ModalSelectBUsForMasterData.isEditSelectedBUPresent(driver, testCaseName))
		{
			ModalSelectBUsForMasterData.clickOnEditSelectedBU(driver, testCaseName);
		}
		if (!ModalSelectBUsForMasterData.isSelectAllBUCheckboxSelected(driver, testCaseName))
		{
			ModalSelectBUsForMasterData.clickOnSelectAllBUCheckbox(driver, testCaseName);
		}
		ModalSelectBUsForMasterData.clickOnCheckBoxForBU(driver, testCaseName, buName);
		/*
		 * List<WebElement> listOfCheckbox =
		 * ModalSelectBUsForMasterData.getListOfAllCheckbox(driver,
		 * testCaseName); for (WebElement element : listOfCheckbox) { if
		 * (element != null) { String bu_Name = element .findElement(By.xpath(
		 * "/parent::td/following-sibling::td[contains(@class,'name')]")).
		 * getText() .trim(); if (!bu_Name.equalsIgnoreCase(buName)) {
		 * element.click(); } } }
		 */
		ModalSelectBUsForMasterData.clickOnSaveButton(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Search Project , edit it and remove given
	 * BU from it <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param searchTerm </font><b><br>
	 * @param searchIn </font><b><br>
	 * @param buName </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static void searchAndRemoveBUFromProject(WebDriver driver, String testCaseName, String projectName, String searchProjectIn, String buName)
		throws ActionBotException, FactoryMethodException
	{
		boolean flag = searchProject(driver, testCaseName, projectName, searchProjectIn);
		assertTrue("Error while searching project", flag);
		PageProjectsMasterDataSettings.clickOnEdit(driver, testCaseName);
		removeBUFromProject(driver, testCaseName, buName);
		PageProjectsMasterDataSettings.clickOnSaveAddedProject(driver, testCaseName);
		PageUserManagement.clickOnReturnToSetUpModule(driver, testCaseName);
		MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Add BU to Project <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param buName </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static void addBUToProject(WebDriver driver, String testCaseName, String buName) throws ActionBotException, FactoryMethodException
	{
		PageProjectsMasterDataSettings.clickOnSelectBU(driver, testCaseName);
		// ModalSelectBUsForMasterData.clickOnEditSelectedBU(driver,
		// testCaseName);
		ModalSelectBUsForMasterData.clickOnCheckBoxForBU(driver, testCaseName, buName);
		/*
		 * List<WebElement> listOfCheckbox =
		 * ModalSelectBUsForMasterData.getListOfAllCheckbox(driver,
		 * testCaseName); for (WebElement element : listOfCheckbox) { String
		 * bu_Name = element .findElement(By.xpath(
		 * "/parent::td/following-sibling::td[contains(@class,'name')]")).
		 * getText() .trim(); if (bu_Name.equalsIgnoreCase(buName)) {
		 * element.click(); break; } }
		 */
		ModalSelectBUsForMasterData.clickOnSaveButton(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Search Project , edit it and add given BU
	 * to it <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param searchTerm </font><b><br>
	 * @param searchIn </font><b><br>
	 * @param buName </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static void searchAndAddBUToProject(WebDriver driver, String testCaseName, String projectName, String searchProjectIn, String buName)
		throws ActionBotException, FactoryMethodException
	{
		boolean flag = searchProject(driver, testCaseName, projectName, searchProjectIn);
		assertTrue("Error while searching project", flag);
		PageProjectsMasterDataSettings.clickOnEdit(driver, testCaseName);
		addBUToProject(driver, testCaseName, buName);
		PageProjectsMasterDataSettings.clickOnSaveAddedProject(driver, testCaseName);
		PageUserManagement.clickOnReturnToSetUpModule(driver, testCaseName);
		MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>to deactivate project <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param projectName </font><b><br>
	 * @param searchProjectIn </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean deactivateProject(WebDriver driver, String testCaseName, String projectName, String searchProjectIn) throws ActionBotException, FactoryMethodException
	{
		boolean flag = searchProject(driver, testCaseName, projectName, searchProjectIn);
		assertTrue("Error while searching project", flag);
		// to deactivate project
		if (PageProjectsMasterDataSettings.isProjectActive(driver, testCaseName))
		{
			PageProjectsMasterDataSettings.clickOnActive(driver, testCaseName);
		}
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		flag = !PageProjectsMasterDataSettings.isProjectActive(driver, testCaseName);
		PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>to activate project <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param projectName </font><b><br>
	 * @param searchProjectIn </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean activateProject(WebDriver driver, String testCaseName, String projectName, String searchProjectIn) throws ActionBotException, FactoryMethodException
	{
		boolean flag = searchProject(driver, testCaseName, projectName, searchProjectIn);
		assertTrue("Error while searching project", flag);
		// to activate project
		if (PageProjectsMasterDataSettings.isProjectDeactive(driver, testCaseName))
		{
			PageProjectsMasterDataSettings.clickOnDeActive(driver, testCaseName);
		}
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		flag = PageProjectsMasterDataSettings.isProjectActive(driver, testCaseName);
		System.out.println("@@@@@@@@@@@ Flag : " + flag);
		PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);
		return flag;
	}
}
