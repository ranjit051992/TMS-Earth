package com.zycus.automation.eproc.businessflow.glMapFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.GLMap;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.glmapsmasterdatasettings.PageGLMapsMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings.PageMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class FlowGLMap
{
	public static GLMap getGLMap(WebDriver driver, String company, String category) throws ActionBotException
	{
		int oddCount = ActionBot.findElements(driver, By.cssSelector(".odd")).size();
		int evenCount = ActionBot.findElements(driver, By.cssSelector(".even")).size();
		int row = oddCount + evenCount;

		for (int i = 1; i <= row; i++)
		{

			String BASE_PATH = ".//*[@id='categoryGeneralLedgerListing']//tr[" + i + "]/";
			String CATEGORY = ActionBot.getTextWithInElement(driver, By.xpath(BASE_PATH + "td[1]"));
			String PURCHASE_TYPE = ActionBot.getTextWithInElement(driver, By.xpath(BASE_PATH + "td[@class='purchase_type']"));
			String COST_CENTER_NAME = ActionBot.getTextWithInElement(driver, By.xpath(BASE_PATH + "td[@class='cost_center_name']"));
			String AMOUNT = ActionBot.getTextWithInElement(driver, By.xpath(BASE_PATH + "" + "td[@class='amount']"));
			String GL_ACCOUNT_TYPE = ActionBot.getTextWithInElement(driver, By.xpath(BASE_PATH + "td[5]"));
			String GL_ACCOUNT = ActionBot.getTextWithInElement(driver, By.xpath(BASE_PATH + "td[@class='general_ledger']"));
			String COMPANY_NAME = ActionBot.getTextWithInElement(driver, By.xpath(BASE_PATH + "td[@class='company_name']"));

			if ((category.trim().equalsIgnoreCase(CATEGORY) == true) && (company.trim().equalsIgnoreCase(COMPANY_NAME) == true))
			{
				GLMap glmap = new GLMap();
				glmap.setGlAccountType(GL_ACCOUNT_TYPE);
				glmap.setGlAccount(GL_ACCOUNT);
				return glmap;
			}
		}
		return null;
	}

	public static GLMap createGLMap(WebDriver driver, String testCaseName, GLMap glMap) throws ActionBotException, FactoryMethodException
	{

		MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);

		// click on cost booking link
		PageCustomizeSettings.clickOnGLRulesMap(driver, testCaseName);

		//		PageMasterDataSettings.clickOnCategoryPurchaseType_GL_Maps_Link(driver, testCaseName);
		PageGLMapsMasterDataSettings.clickOnLinkAddGLRulesMap(driver, testCaseName);
		PageGLMapsMasterDataSettings.enterCategory(driver, testCaseName, glMap.getCategory());
		PageGLMapsMasterDataSettings.selectPurchaseType(driver, testCaseName, glMap.getPurchaseType());
		//		PageGLMapsMasterDataSettings.selectCompany(driver, testCaseName, glMap.getCompany());
		PageGLMapsMasterDataSettings.selectCompanyAndBussinessUnitForGLRuleMap(driver, testCaseName, glMap.getCompany());
		PageGLMapsMasterDataSettings.selectGLAccountType(driver, testCaseName, glMap.getGlAccountType());
		PageGLMapsMasterDataSettings.enterGLAccount(driver, testCaseName, glMap.getGlAccount());
		PageGLMapsMasterDataSettings.clickOnSaveAddGLRulesMap(driver, testCaseName);
		return glMap;

	}

	public static void deleteGLMap(WebDriver driver, String testCaseName, String category) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnSetUpTab(driver);
		MainPageHeaderLevelTab.clickOnSetUpSubTab(driver);
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnCategoryPurchaseType_GL_Maps_Link(driver, testCaseName);
		PageGLMapsMasterDataSettings.fillSearch(driver, testCaseName, category);
		PageGLMapsMasterDataSettings.clickOnGO(driver, testCaseName);
		PageGLMapsMasterDataSettings.clickOnDelete(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		PageMasterDataSettings.clickOnReturnToSetUpModule(driver, testCaseName);

	}
}
