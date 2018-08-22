package com.zycus.automation.tenanatCreation.businessFlows;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.tenanatCreation.bo.Tenant;
import com.zycus.automation.tenanatCreation.pageObjects.tmsCompanyCreation.FlowTmsCompanyCreation;
import com.zycus.automation.tenanatCreation.pageObjects.tmsCompanyCreation.TmsCompanyCreationPage;
import com.zycus.automation.tenanatCreation.utilities.IConstants.IConstantData;
import com.zycus.automation.tenanatCreation.utilities.excelReader.ExcelReader;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class CreateTenantFlow
{

	public static void createCompany(WebDriver driver, String testCaseName, Tenant tenant) throws ActionBotException
	{
		driver.get(ConfigProperty.getConfig("TMS_URL_COMPANY_LISTING"));
		ActionBot.waitForPageLoad(driver);
		
		FlowTmsCompanyCreation.clickOnCreateNewCompanyButton(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);

		if (tenant.getCompanyName() != null)
		{
			FlowTmsCompanyCreation.fillCompanyName(driver, testCaseName, tenant.getCompanyName());
		}

		if (tenant.isSaasCompany() == true || String.valueOf(tenant.isSaasCompany()).equalsIgnoreCase("TRUE"))
		{
			FlowTmsCompanyCreation.selectCheckBoxSaasCompany(driver, testCaseName);
		}

		if (tenant.isDelegateCompany() == true || String.valueOf(tenant.isDelegateCompany()).equalsIgnoreCase("TRUE"))
		{
			FlowTmsCompanyCreation.selectCheckBoxdelegateCompany(driver, testCaseName);
		}
		if (tenant.getBridgeUrl() != null)
		{
			FlowTmsCompanyCreation.fillBridgeURL(driver, testCaseName, tenant.getBridgeUrl());
		}

		if (tenant.isLoginThroughUniqueId() == true || String.valueOf(tenant.isLoginThroughUniqueId()).equalsIgnoreCase("TRUE"))
		{
			FlowTmsCompanyCreation.selectCheckBoxLoginThroughUniqueId(driver, testCaseName);
		}
		if (tenant.isEnableScope() == true || String.valueOf(tenant.isEnableScope()).equalsIgnoreCase("TRUE"))
		{
			FlowTmsCompanyCreation.selectCheckBoxEnableScope(driver, testCaseName);
		}

		if (tenant.getLocationName() != null)
		{
			FlowTmsCompanyCreation.fillLocationName(driver, testCaseName, tenant.getLocationName());
		}

		if (tenant.getAddress1() != null)
		{
			FlowTmsCompanyCreation.fillAddress1(driver, testCaseName, tenant.getAddress1());
		}
		if (tenant.getAddress2() != null)
		{
			FlowTmsCompanyCreation.fillAddress2(driver, testCaseName, tenant.getAddress2());
		}
		if (tenant.getCity() != null)
		{
			FlowTmsCompanyCreation.fillCity(driver, testCaseName, tenant.getCity());
		}
		if (tenant.getState() != null)
		{
			FlowTmsCompanyCreation.fillState(driver, testCaseName, tenant.getState());
		}
		if (tenant.getZipCode() != (-1))
		{
			FlowTmsCompanyCreation.fillZipCode(driver, testCaseName, tenant.getZipCode());
		}
		if (tenant.getCountry() != null)
		{
			FlowTmsCompanyCreation.fillCountry(driver, testCaseName, tenant.getCountry());
		}

		FlowTmsCompanyCreation.clickOnContinueCompanyFormPage(driver, testCaseName);
		ActionBot.defaultSleep();
		//		ActionBot.waitForElementToBeDisplayed(driver, TmsCompanyCreationPage.TEXTBOX_PRODUCT_CRMS_URL, ActionBot.timeOut);

		if (tenant.isComponentRainbow() != false || String.valueOf(tenant.isComponentRainbow()).equalsIgnoreCase("TRUE"))
		{
			FlowTmsCompanyCreation.selectComponentRainbow(driver, testCaseName);
		}

		if (tenant.isComponentCrms() != false || String.valueOf(tenant.isComponentCrms()).equalsIgnoreCase("TRUE"))
		{
			FlowTmsCompanyCreation.selectComponentCRMS(driver, testCaseName);
		}
		if (tenant.isComponentOneView() != false || String.valueOf(tenant.isComponentOneView()).equalsIgnoreCase("TRUE"))
		{
			FlowTmsCompanyCreation.selectComponentOneView(driver, testCaseName);
		}
		if (tenant.getCivilProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlCivil(driver, testCaseName, tenant.getCivilProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.CIVIL + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getCrmsProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlCRMS(driver, testCaseName, tenant.getCrmsProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.CRMS + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getCentralRmsUrlProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlCentralRms(driver, testCaseName, tenant.getCentralRmsUrlProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.CENTRAL_RMS + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getDahsboardProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlDashBoard(driver, testCaseName, tenant.getDahsboardProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.DASHBOARD + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getFieldLibraryProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlFieldLibrary(driver, testCaseName, tenant.getFieldLibraryProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.FIELDLIBRARY + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}

		if (tenant.getFlexiFormProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlFlexiForm(driver, testCaseName, tenant.getFlexiFormProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.FLEXIFORMSTUDIO + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getMasProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlMAS(driver, testCaseName, tenant.getMasProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.MAS + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getNotificationProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlNotification(driver, testCaseName, tenant.getNotificationProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.NOTIFICATION + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getOneViewProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlOneView(driver, testCaseName, tenant.getOneViewProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.ONEVIEW + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getSimProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlSIM(driver, testCaseName, tenant.getSimProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.SIM + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getSpmProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlSPM(driver, testCaseName, tenant.getSpmProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.SPM + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getSupplierPortalProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlSupplierPortal(driver, testCaseName, tenant.getSupplierPortalProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.SUPPLIERPORTAL + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getTmsProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlTMS(driver, testCaseName, tenant.getTmsProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.TMS + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getWorkflowProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlWorkFlow(driver, testCaseName, tenant.getWorkflowProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.WORKFLOW + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getEinvoiceProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlEInvoice(driver, testCaseName, tenant.getEinvoiceProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.EINVOICE + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getEprocProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlEPROC(driver, testCaseName, tenant.getEprocProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.EPROC + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getIanalyzeProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlIAnalyze(driver, testCaseName, tenant.getIanalyzeProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.IANALYZE + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getIcontractProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlIContract(driver, testCaseName, tenant.getIcontractProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.ICONTRACT + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getIcostProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlICost(driver, testCaseName, tenant.getIcostProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.ICOST + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getImanageProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlIManage(driver, testCaseName, tenant.getImanageProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.IMANAGE + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getIrequestProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlIRequest(driver, testCaseName, tenant.getIrequestProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.IREQUEST + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getIsaveProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlISave(driver, testCaseName, tenant.getIsaveProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.ISAVE + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}
		if (tenant.getIsourceProductUrl() != null)
		{
			FlowTmsCompanyCreation.fillProductUrlISource(driver, testCaseName, tenant.getIsourceProductUrl());
			ActionBot.click(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Activate_Button_productUrl + IConstantData.ISOURCE + TmsCompanyCreationPage.xpath2_Activate_Button_productUrl));
		}

		FlowTmsCompanyCreation.clickOnContinueProductAllocationPage(driver, testCaseName);
		ActionBot.waitForElementToBeDisplayed(driver, TmsCompanyCreationPage.TEXTBOX_COMPANY_ADMIN_FIRST_NAME, ActionBot.timeOut);

		if (tenant.getFirstnameAdmin() != null)
		{
			FlowTmsCompanyCreation.fillAdminFirstName(driver, testCaseName, tenant.getFirstnameAdmin());
		}

		if (tenant.getLastNameAdmin() != null)
		{
			FlowTmsCompanyCreation.fillAdminLastName(driver, testCaseName, tenant.getLastNameAdmin());
		}

		if (tenant.getDisplayNameAdmin() != null)
		{
			FlowTmsCompanyCreation.fillAdminDisplayName(driver, testCaseName, tenant.getDisplayNameAdmin());
		}
		if (tenant.getEmailIdAdmin() != null)
		{
			FlowTmsCompanyCreation.fillAdminEmaidId(driver, testCaseName, tenant.getEmailIdAdmin());
		}

		if (tenant.getUniqueKeyType() != null)
		{
			//adding unique keys:
			if (tenant.getUniqueKeyType().contains(","))
			{
				String[] uniqueType = tenant.getUniqueKeyType().split(",");
				String[] uniqueKey = tenant.getUniqueKeyValue().split(",");
				int lenght = uniqueKey.length;
				for (int i = 0; i < lenght; i++)
				{

					FlowTmsCompanyCreation.selectUniqueKeyType(driver, testCaseName, uniqueType[i].trim());
					FlowTmsCompanyCreation.fillUniqueKeyValue(driver, testCaseName, uniqueKey[i]);
					FlowTmsCompanyCreation.clickOnAddUniqueKeyButton(driver, testCaseName);

				}

			}
		}
		FlowTmsCompanyCreation.clickOnContinueOnCompanyAdminPage(driver, testCaseName);
		ActionBot.waitForElementToBeDisplayed(driver, TmsCompanyCreationPage.TEXTBOX_PORTNUMBER, ActionBot.timeOut);

		if (tenant.getTimezone() != null)
		{
			FlowTmsCompanyCreation.fillTimeZone(driver, testCaseName, tenant.getTimezone());
		}

		if (tenant.getNumberformat() != null)
		{
			FlowTmsCompanyCreation.selectNumberFormat(driver, testCaseName, tenant.getNumberformat());
		}

		if (tenant.getDateFormat() != null)
		{
			FlowTmsCompanyCreation.selectDateFormat(driver, testCaseName, tenant.getDateFormat());
		}

		if (tenant.getTimeFormat() != null)
		{
			FlowTmsCompanyCreation.selectTimeFormat(driver, testCaseName, tenant.getTimeFormat());
		}

		if (tenant.getCurrency() != null)
		{
			FlowTmsCompanyCreation.selectCurrency(driver, testCaseName, tenant.getCurrency());
		}

		if (tenant.getLocale() != null)
		{
			FlowTmsCompanyCreation.selectLocale(driver, testCaseName, tenant.getLocale());
		}

		if (tenant.getSmtpServerId() != null)
		{
			FlowTmsCompanyCreation.fillSMTPServerId(driver, testCaseName, tenant.getSmtpServerId());
		}
		if (tenant.getPortNumber() != null)
		{
			FlowTmsCompanyCreation.fillPortNumber(driver, testCaseName, tenant.getPortNumber());
		}
		if (tenant.getDecimalPrecision() != null)
		{
			FlowTmsCompanyCreation.fillDecimalPrecision(driver, testCaseName, tenant.getDecimalPrecision());
		}
		FlowTmsCompanyCreation.clickOnContinueOnCompanyPreferencePage(driver, testCaseName);
		ActionBot.waitForElementToBeDisplayed(driver, TmsCompanyCreationPage.BUTTON_DEFINE_COMPANY, ActionBot.timeOut);

		ActionBot.click(driver, TmsCompanyCreationPage.BUTTON_DEFINE_COMPANY);
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, TmsCompanyCreationPage.BUTTON_OK))
		{
			ActionBot.click(driver, TmsCompanyCreationPage.BUTTON_OK);
		}
		ActionBot.waitForElementToBeDisplayed(driver, TmsCompanyCreationPage.TEXTBOX_COMPANY_SEARCH_COMPANYLISTINGPAGE, ActionBot.timeOut);
		System.out.println("Company Created!\n\n");
	}

	public static void flowAddAllRegistryValues(WebDriver driver, String testCaseName, Tenant tenant) throws ActionBotException
	{
		//		editCompany(driver, testCaseName, tenant.getCompanyName());
		Map<String, Map<String, String>> registryMap = ExcelReader.readAllRegistryValues(driver, testCaseName);

		Set<String> products = registryMap.keySet();
		WebElement registryLink = null;
		Iterator<String> product = products.iterator();
		while (product.hasNext())
		{
			String currentProduct = product.next();
			if (ActionBot.isElementDisplayed(driver,
				By.xpath(TmsCompanyCreationPage.xpath1_Registry_URL_productwise + currentProduct + TmsCompanyCreationPage.xpath2_Registry_URL_productwise)))
			{
				registryLink = ActionBot.findElement(driver,
					By.xpath(TmsCompanyCreationPage.xpath1_Registry_URL_productwise + currentProduct + TmsCompanyCreationPage.xpath2_Registry_URL_productwise));
				registryLink.click();
				ActionBot.defaultSleep();
				FlowTmsCompanyCreation.addRegistryKeyValue(driver, testCaseName, registryMap.get(currentProduct));
				FlowTmsCompanyCreation.clickOnBackToSummary(driver, testCaseName);
			}
		}

		FlowTmsCompanyCreation.clickOnDefineCompany(driver, testCaseName);
		ActionBot.waitForElementToBeDisplayed(driver, TmsCompanyCreationPage.BUTTON_OK, ActionBot.timeOut);
		ActionBot.click(driver, TmsCompanyCreationPage.BUTTON_OK);
		ActionBot.defaultSleep();
	}

	public static void editCompany(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		{
			//			String companyNameFetched = FlowTmsCompanyCreation.searchCompany(driver, testCaseName, companyName);
			System.out.println("Searching company!!!\n\n");
			WebElement textboxCompanySearch = ActionBot.findElement(driver, TmsCompanyCreationPage.TEXTBOX_COMPANY_SEARCH_COMPANYLISTINGPAGE);
			textboxCompanySearch.sendKeys(companyName);
			textboxCompanySearch.sendKeys(Keys.ENTER);
			ActionBot.defaultSleep();
			ActionBot.defaultSleep();
			int noOfRecords = ActionBot.findElements(driver, By.xpath(TmsCompanyCreationPage.xpath_no_of_companies)).size();
			boolean found = false;
			for (int i = 1; i <= noOfRecords; i++)
			{
				String companyNameFetched = "";
				try
				{
					try
					{
						if (driver.findElement(By.xpath(TmsCompanyCreationPage.LABEL_FIRST_LISTED_USER_COMPANYLISTINGPAGE.getValue())).isDisplayed())
						{
							companyNameFetched = driver.findElement(By.xpath(TmsCompanyCreationPage.LABEL_FIRST_LISTED_USER_COMPANYLISTINGPAGE.getValue())).getText();
						}
					}
					catch (Exception e)
					{
					}
					try
					{
						if (driver.findElement(By.xpath(TmsCompanyCreationPage.TD_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE.getValue() + "[" + i + "]/label")).isDisplayed())
						{
							companyNameFetched = driver.findElement(By.xpath(TmsCompanyCreationPage.TD_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE.getValue() + "[" + i + "]/label"))
								.getText().trim();
							if (companyName.contains("..."))
							{

								companyNameFetched = driver
									.findElement(By.xpath(TmsCompanyCreationPage.TD_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE.getValue() + "[" + i + "]/label")).getAttribute("title")
									.trim();
							}

						}
					}
					catch (Exception e)
					{
						System.out.println();
						if (driver.findElement(By.xpath(TmsCompanyCreationPage.TD_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE.getValue() + "[" + i + "]/label")).isDisplayed())
						{
							companyNameFetched = driver.findElement(By.xpath(TmsCompanyCreationPage.TD_FIRST_LISTED_COMPANY_COMPANYLISTINGPAGE.getValue() + "[" + i + "]"))
								.getText();
						}
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}

				if (companyNameFetched.equalsIgnoreCase(companyName))
				{
					ActionBot.click(driver, TmsCompanyCreationPage.EDIT_COMPANY_ICON);
					found = true;
					break;
				}
			} //end of for loop
			if (found != true)
			{
				Logger.getLogger("No Company found from the name " + companyName);
				throw new ActionBotException("No Company found from the name " + companyName);
			}
		}

	}

	public static void manageUsersAndRolesForCompany(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		{
			String companyNameFetched = FlowTmsCompanyCreation.searchCompany(driver, testCaseName, companyName);
			if (companyNameFetched.contains(companyName))
			{
				ActionBot.click(driver, TmsCompanyCreationPage.MANAGE_USERS_AND_ROLES_COMPANY_ICON);
			}
			else
			{
				Logger.getLogger("No Company found from the name " + companyName);
				throw new ActionBotException("No Company found from the name " + companyName);
			}
		}

	}

	public static void searchUser(WebDriver driver, String testCaseName, String user, String searchBy) throws ActionBotException
	{
		FlowTmsCompanyCreation.selectSearchBy(driver, testCaseName, searchBy);
		FlowTmsCompanyCreation.searchCompany(driver, testCaseName, user);
		ActionBot.defaultSleep();

	}

	public static void selectRoles(WebDriver driver, String testCaseName, String user, String searchBy) throws ActionBotException
	{
		FlowTmsCompanyCreation.selectSearchBy(driver, testCaseName, searchBy);
		FlowTmsCompanyCreation.searchCompany(driver, testCaseName, user);
		ActionBot.defaultSleep();

	}

}