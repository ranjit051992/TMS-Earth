package com.zycus.automation.tenanatCreation.pageObjects.userSummary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.zycus.automation.bo.User;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.tenanatCreation.bo.Roles;
import com.zycus.automation.tenanatCreation.pageObjects.tmsCompanyCreation.TmsCompanyCreationPage;
import com.zycus.automation.tenanatCreation.pageObjects.tmsCompanyCreation.TmsCompanyCreationPageImpl;
import com.zycus.automation.tenanatCreation.utilities.excelReader.ExcelReader;
import com.zycus.automation.tenanatCreation.utilities.excelReader.UIElementUtility;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class UserSummaryImpl implements UserSummaryPage
{
	@Override
	public void searchRole(WebDriver driver, String testCaseName, String role) throws ActionBotException
	{
		WebElement textboxCompanySearch = ActionBot.findElement(driver, TmsCompanyCreationPageImpl.TEXTBOX_COMPANY_SEARCH_COMPANYLISTINGPAGE);
		textboxCompanySearch.sendKeys(role);
		textboxCompanySearch.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
	}

	@Override
	public void selectRoles(WebDriver driver, String testCaseName, List<Roles> roles) throws ActionBotException
	{
		for (Roles role : roles)
		{

			searchRole(driver, testCaseName, role.getRoleName());
			ActionBot.defaultSleep();
			//ActionBot.waitForElementToBeDisplayed(driver, By.xpath(xpath_RoleName_label), ActionBot.timeOut);
			if (ActionBot.isElementDisplayed(driver, By.xpath(xpath_RoleName_label)))
			{
				String textPage = ActionBot.getTextWithInElement(driver, TEXT_PAGE_NUMBER_ROLES);
				Integer pageNo = Integer.parseInt(textPage.split("of")[1].trim());
				int i = 1;
				//			labelToBreak: 
				while (i <= pageNo)
				{

					Boolean flagFound = false;
					List<WebElement> roleNameWebElementList = ActionBot.findElements(driver, By.xpath(xpath_RoleName_label));
					List<WebElement> assignedProdWebElementList = ActionBot.findElements(driver, By.xpath(xpath_AssignedToProduct_Label));
					List<WebElement> roleTypeWebElementList = ActionBot.findElements(driver, By.xpath(xpath_RoleType_Label));
					List<WebElement> checkBoxList = ActionBot.findElements(driver, By.xpath(xpath_checkbox_roles));

					int noOfRecordsOnPage = roleNameWebElementList.size();

					for (int j = 0; j < noOfRecordsOnPage; j++)
					{
						boolean flagRoleName = false;
						boolean flagAssignedProduct = false;
						boolean flagRoletype = false;

						String roleName = ActionBot.getTextWithInElement(driver, roleNameWebElementList.get(j));
						String assignedToProduct = ActionBot.getTextWithInElement(driver, assignedProdWebElementList.get(j));
						String roleType = ActionBot.getTextWithInElement(driver, roleTypeWebElementList.get(j));

						if (roleName.equals(role.getRoleName()))
						{
							flagRoleName = true;
							if (role.getAssignedProduct() != null && !(role.getAssignedProduct().equalsIgnoreCase("")))
							{
								if (assignedToProduct.equals(role.getAssignedProduct()))
									flagAssignedProduct = true;

							}
							else
							{
								flagAssignedProduct = true;
							}
							if (role.getRoleType() != null && !(role.getRoleType().equalsIgnoreCase("")))
							{
								if (roleType.equals(role.getRoleType()))
									flagRoletype = true;

							}
							else
							{
								flagRoletype = true;
							}

						}
						if (flagRoleName == true && flagAssignedProduct == true && flagRoletype == true)
						{
							flagFound = true;
							if (!ActionBot.isElementSelected(driver, By.xpath("(" + xpath_checkbox_roles + ")[" + j + 1 + "]")))
								ActionBot.click(driver, checkBoxList.get(j));
							break;
							//break labelToBreak;
							//click on checkbox
						}
						//					else
						//					{
						//						continue;
						//					}
					} //end of records per page for loop
					if (flagFound == false)
					{
						int currentPage = Integer.parseInt(ActionBot.getTextWithInElement(driver, TEXTBOX_PAGE_NUMBER_DISPLAYED_ROLES));
						if (i > 1 && currentPage < pageNo)
							ActionBot.click(driver, BUTTON_NAVIGATE_TO_NEXT_PAGE_ROLES);
						ActionBot.defaultSleep();
						//go to next page
						//					ActionBot.click(driver, BUTTON_NAVIGATE_TO_NEXT_PAGE_ROLES);
					}
					i++;
				}
			}
			ActionBot.clear(driver, TmsCompanyCreationPageImpl.TEXTBOX_COMPANY_SEARCH_COMPANYLISTINGPAGE);
//			ActionBot.defaultLowSleep();

		}
		ActionBot.click(driver, TmsCompanyCreationPage.BUTTON_DEFINE_COMPANY);
		ActionBot.defaultSleep();

	}

	public static void test()
	{
		WebDriver driver = null;
		Map<String, String> map = new HashMap<String, String>();
		User user = null;
		UIElementUtility.loadUiElements();
		TestCase testcase = new TestCase();
		try
		{

			System.setProperty("webdriver.chrome.driver", "D:\\tenant\\tenantCreation\\exec\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			driver.get(ConfigProperty.getConfig("URL"));
			ActionBot.defaultSleep();
			//			LoginLogout.login(driver, testCase, ConfigProperty.getConfig("AdminUsername"), ConfigProperty.getConfig("AdminPassword"));
			String testCaseName = "Tenant Creation";

			CommonServices.startTestCase(driver, testcase);

			driver.get(ConfigProperty.getConfig("TMS_URL"));
			List<Roles> allRoles = ExcelReader.getAllRoles(driver, testCaseName);
			UserSummaryImpl obj = new UserSummaryImpl();
			obj.selectRoles(driver, testCaseName, allRoles);

		}
		catch (Exception e)
		{
			System.out.println("Excepton");
		}
	}

}
