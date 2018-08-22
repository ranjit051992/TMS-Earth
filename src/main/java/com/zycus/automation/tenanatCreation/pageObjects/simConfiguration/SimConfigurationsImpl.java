package com.zycus.automation.tenanatCreation.pageObjects.simConfiguration;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.tenanatCreation.pageObjects.adminConfiguration.AdminConfiguration;
import com.zycus.automation.tenanatCreation.pageObjects.adminConfiguration.AdminConfigurationImpl;
import com.zycus.automation.tenanatCreation.utilities.IConstants.IConstantData;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class SimConfigurationsImpl implements SimConfigurations
{
	static Logger logger = Logger.getLogger(AdminConfigurationImpl.class);

	@Override
	public void goToSettingTabInSim(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeEnable(driver, AdminConfiguration.HEADER_TAB_SETTING, ActionBot.timeOut);
		ActionBot.click(driver, AdminConfiguration.HEADER_TAB_SETTING);
		ActionBot.waitForElementToBeDisplayed(driver, DROPDOWN_SETTING_SIM, Integer.parseInt(ActionBot.defaultSleep));
		ActionBot.click(driver, DROPDOWN_SETTING_SIM);
		ScreenShot.screenshot(driver, testCaseName, "after clicking Setting Tab");

	}

	@Override
	public void clickonManageRoles(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_MANAGE_ROLES);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on manage role from side header");

	}

	@Override
	public void clickOnEditMDM(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_ROLE_MDM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on edit of MDM");

	}

	@Override
	public void clickOnViewAccesses(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, TAB_VIEW_ACCESSES);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on view accesses header");

	}

	@Override
	public void selectCheckboxesForView_Company(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> inputCheckBox = ActionBot.findElements(driver,
			By.xpath(xpath1_viewAccesses_input + IConstantData.viewAccessesCompany.replace("viewAccesses", "") + xpath2_viewAccesses_input));
		for (WebElement inWebElement : inputCheckBox)
		{
			if (!inWebElement.isSelected())
				ActionBot.click(driver, inWebElement);
		}
		ScreenShot.screenshot(driver, testCaseName, "After selecting views");

	}

	@Override
	public void selectCheckboxesForView_Address(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> inputCheckBox = ActionBot.findElements(driver,
			By.xpath(xpath1_viewAccesses_input + IConstantData.viewAccessesAddress.replace("viewAccesses", "") + xpath2_viewAccesses_input));
		for (WebElement inWebElement : inputCheckBox)
		{
			if (!inWebElement.isSelected())
				ActionBot.click(driver, inWebElement);
		}
		ScreenShot.screenshot(driver, testCaseName, "After selecting views");
	}

	@Override
	public void selectCheckboxesForView_ProductAndServices(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> inputCheckBox = ActionBot.findElements(driver,
			By.xpath(xpath1_viewAccesses_input + IConstantData.viewAccessesProductAndServices.replace("viewAccesses", "") + xpath2_viewAccesses_input));
		for (WebElement inWebElement : inputCheckBox)
		{
			if (!inWebElement.isSelected())
				ActionBot.click(driver, inWebElement);
		}
		ScreenShot.screenshot(driver, testCaseName, "After selecting views");

	}

	@Override
	public void selectCheckboxesForView_SpendInformation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> inputCheckBox = ActionBot.findElements(driver,
			By.xpath(xpath1_viewAccesses_input + IConstantData.viewAccessesSpendInformation.replace("viewAccesses", "") + xpath2_viewAccesses_input));
		for (WebElement inWebElement : inputCheckBox)
		{
			if (!inWebElement.isSelected())
				ActionBot.click(driver, inWebElement);
		}
		ScreenShot.screenshot(driver, testCaseName, "After selecting views");

	}

	@Override
	public void selectCheckboxesForView_Diversity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> inputCheckBox = ActionBot.findElements(driver,
			By.xpath(xpath1_viewAccesses_input + IConstantData.viewAccessesDiversity.replace("viewAccesses", "") + xpath2_viewAccesses_input));
		for (WebElement inWebElement : inputCheckBox)
		{
			if (!inWebElement.isSelected())
				ActionBot.click(driver, inWebElement);
		}
		ScreenShot.screenshot(driver, testCaseName, "After selecting views");

	}

	@Override
	public void selectCheckboxesForView_Financial(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> inputCheckBox = ActionBot.findElements(driver,
			By.xpath(xpath1_viewAccesses_input + IConstantData.viewAccessesFinancial.replace("viewAccesses", "") + xpath2_viewAccesses_input));
		for (WebElement inWebElement : inputCheckBox)
		{
			if (!inWebElement.isSelected())
				ActionBot.click(driver, inWebElement);
		}
		ScreenShot.screenshot(driver, testCaseName, "After selecting views");

	}

	@Override
	public void selectCheckboxesForView_Insurance(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> inputCheckBox = ActionBot.findElements(driver,
			By.xpath(xpath1_viewAccesses_input + IConstantData.viewAccessesInsurance.replace("viewAccesses", "") + xpath2_viewAccesses_input));
		for (WebElement inWebElement : inputCheckBox)
		{
			if (!inWebElement.isSelected())
				ActionBot.click(driver, inWebElement);
		}
		ScreenShot.screenshot(driver, testCaseName, "After selecting views");

	}

	@Override
	public void selectCheckboxesForView_Purchasing(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> inputCheckBox = ActionBot.findElements(driver,
			By.xpath(xpath1_viewAccesses_input + IConstantData.viewAccessesPurchasing.replace("viewAccesses", "") + xpath2_viewAccesses_input));
		for (WebElement inWebElement : inputCheckBox)
		{
			if (!inWebElement.isSelected())
				ActionBot.click(driver, inWebElement);
		}
		ScreenShot.screenshot(driver, testCaseName, "After selecting views");

	}

	@Override
	public void clickOnSave_ViewAccesses(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_VIEW_ACCESSES_PAGE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on SAVE view accesses");

	}

	@Override
	public void clickOnMasterDataConfigHeaderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, HEADER_TAB_MASTERDATA_CONFIG);
		ScreenShot.screenshot(driver, testCaseName, "after clicking Master data config Tab");

	}

	@Override
	public void clickOnManageClientHeaderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, HEADER_TAB_MANAGE_CLIENTS);
		ScreenShot.screenshot(driver, testCaseName, "after clicking Master data config Tab");

	}

	@Override
	public void clickOnCreateNewMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CREATE_NEW_MASTER);
		ScreenShot.screenshot(driver, testCaseName, "after clicking Create New Master");
	}

	@Override
	public void enterTableName(WebDriver driver, String testCaseName, String tableName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_TABLENAME, tableName);
		logger.info("Table name : " + tableName);
		ScreenShot.screenshot(driver, testCaseName, "after enteringtable name");

	}

	@Override
	public void enterDisplayName(WebDriver driver, String testCaseName, String displayName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_DISPLAYNAME, displayName);
		logger.info("Display Name : " + displayName);
		ScreenShot.screenshot(driver, testCaseName, "After entering display Name");

	}

	@Override
	public void enterColumnName(WebDriver driver, String testCaseName, String columnName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_COLUMNNAME, columnName);
		logger.info("Column Name : " + columnName);
		ScreenShot.screenshot(driver, testCaseName, "After entering Column Name");

	}

	@Override
	public void enterDisplayField(WebDriver driver, String testCaseName, String displayField) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_DISPLAY_FIELD, displayField);
		logger.info("Display Field Name : " + displayField);
		ScreenShot.screenshot(driver, testCaseName, "After entering Display Filed Name");
	}

	@Override
	public void selectFieldType(WebDriver driver, String testCaseName, String fieldType) throws ActionBotException
	{
		Select drpDownOption = new Select(ActionBot.findElement(driver, DROPDOWN_FIELD_TYPE));
		if (fieldType.equalsIgnoreCase("text"))
		{
			drpDownOption.selectByVisibleText("Text");
		}
		if (fieldType.equalsIgnoreCase("numeric"))
		{
			drpDownOption.selectByVisibleText("Numeric");
		}
		ScreenShot.screenshot(driver, testCaseName, "selecting field type from dropdown");

	}

	@Override
	public void enterFieldLength(WebDriver driver, String testCaseName, String fieldLength) throws ActionBotException
	{

		ActionBot.sendKeys(driver, TEXTBOX_FIELD_LENGTH, fieldLength);
		logger.info("Field Length : " + fieldLength);
		ScreenShot.screenshot(driver, testCaseName, "After entering Field Length");
	}

	@Override
	public void selectIsRequired(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_IS_REQUIRED);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Is-Required checkbox");
	}

	@Override
	public void selectContraint(WebDriver driver, String testCaseName, String constraint) throws ActionBotException
	{
		Select drpDownOption = new Select(ActionBot.findElement(driver, DROPDOWN_CONTRAINT));
		if(constraint!=null){
		if (constraint.equalsIgnoreCase("unique"))
			drpDownOption.selectByVisibleText("Unique");}
		ScreenShot.screenshot(driver, testCaseName, "selecting contraint");
	}

	@Override
	public void clickOnAddNewField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_NEW_FIELD);
		ScreenShot.screenshot(driver, testCaseName, "After clicking Add New Field");
	}

	@Override
	public void clickOnDone(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_DONE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking Done");

	}

	@Override
	public void selectClient(WebDriver driver, String testCaseName, String clientName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, DROPDOWN_CLIENT_NAME));
		select.selectByVisibleText(clientName);
		logger.info("Selected client name: " + clientName);
	}

	@Override
	public void enterClientIdentifier(WebDriver driver, String testCaseName, String clientIdentifier) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_CLIENT_IDENTIFIER, clientIdentifier);
		logger.info("Entered client identifier: " + clientIdentifier);
	}

	@Override
	public void enterClientDescription(WebDriver driver, String testCaseName, String clientDescription) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_CLIENT_DESCRIPTION, clientDescription);
		logger.info("Entered client Decription: " + clientDescription);
	}

	@Override
	public void clickOnSubmit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on submit for manage clients");
		ActionBot.click(driver, BUTTON_SUBMIT_MANAGE_CLIENTS);
		ActionBot.waitForElementToBeEnable(driver, BUTTON_CONFIGURE_NEW_CLIENT, ActionBot.timeOut);
		ScreenShot.screenshot(driver, testCaseName, "After  clicking on submit for manage clients");
	}

	@Override
	public void clickOnConfigureNewClient(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CONFIGURE_NEW_CLIENT);
		ActionBot.waitForElementToBeEnable(driver, TEXTBOX_CLIENT_IDENTIFIER, ActionBot.timeOut);

	}

	@Override
	public void clickOnUpload(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_UPLOAD);

	}

	@Override
	public void enterFileForUpload(WebDriver driver, String testCaseName, String fileName) throws ActionBotException
	{
		ActionBot.findElement(driver, BUTTON_BROWSE).sendKeys(fileName);
		ActionBot.defaultSleep();
		logger.info("Entered filename : " + fileName);
		ScreenShot.screenshot(driver, testCaseName, "After selecting file for upload");

	}

	@Override
	public void selectFieldsForFacilityMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField), ActionBot.timeOut);
		Select select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.plantName_lowerCase);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "1" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.status);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "2" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.clientCode);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "3" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.plantTypeId);
		ScreenShot.screenshot(driver, testCaseName, "After selecting mapping fields for Facility Master");
		logger.info("Selected mapping fields for Facility Master");

	}

	@Override
	public void selectFieldsForSystemFacilityRelation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField), ActionBot.timeOut);
		Select select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.systemCode);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "1" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.plantCode);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "2" + xpath2_dropdown_MappingField)));
		//doubt
		select.selectByValue(IConstantData.plantId);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "3" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.plantName_upperCase);
		ScreenShot.screenshot(driver, testCaseName, "After selecting mapping fields for System Facility Relation");
		logger.info("Sselected mapping fields for System Facility Relation");
	}

	@Override
	public void selectFieldsForINCOTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField), ActionBot.timeOut);
		Select select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.externalId);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "1" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.incoType);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "2" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.description);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "3" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.displayCode);
		ScreenShot.screenshot(driver, testCaseName, "After selecting mapping fields for INCO terms");
		logger.info("Selected mapping fields for INCO terms");
	}

	@Override
	public void selectFieldsForLegalStructure(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField), ActionBot.timeOut);
		Select select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.externalId);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "1" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.legalStructure);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "2" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.displayCode);
		ScreenShot.screenshot(driver, testCaseName, "After selecting mapping fields for Legal Structure");
		logger.info("Selected mapping fields for Legal Structure");
	}

	@Override
	public void selectFieldsForPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField), ActionBot.timeOut);
		Select select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.externalId);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "1" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.paymentTerms);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "2" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.description);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "3" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.displayCode);
		ScreenShot.screenshot(driver, testCaseName, "After selecting mapping fields for Payment Terms");
		logger.info("Selected mapping fields for Payment Terms");

	}

	@Override
	public void selectFieldsForPoSubmission(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField), ActionBot.timeOut);
		Select select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.externalId);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "1" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.poSubmission);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "2" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.description);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "3" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.displayCode);
		ScreenShot.screenshot(driver, testCaseName, "After selecting mapping fields for Po Submission");
		logger.info("Selected mapping fields for Po Submission");

	}

	@Override
	public void selectFieldsForSupplierType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField), ActionBot.timeOut);
		Select select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.externalId);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "1" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.supplierType);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "2" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.description);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "3" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.displayCode);
		ScreenShot.screenshot(driver, testCaseName, "After selecting mapping fields for Supplier Type");
		logger.info("Selected mapping fields for Supplier Type");

	}

	@Override
	public void selectFieldsForSystemMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField), ActionBot.timeOut);
		Select select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.systemCode);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "1" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.systemName);
		ScreenShot.screenshot(driver, testCaseName, "After selecting mapping fields for System Master");
		logger.info("Selected mapping fields for System Master");

	}

	@Override
	public void selectFieldsForTransactionCount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField), ActionBot.timeOut);
		Select select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.externalId);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "1" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.transactionCount);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "2" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.description);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "3" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.displayValue);
		ScreenShot.screenshot(driver, testCaseName, "After selecting mapping fields for Transaction Count");
		logger.info("Selected mapping fields for Transaction Count");

	}

	@Override
	public void selectFieldsForPaymentType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField), ActionBot.timeOut);
		Select select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "0" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.externalId);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "1" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.paymentType);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "2" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.description);
		select = new Select(ActionBot.findElement(driver, By.xpath(xpath1_dropdown_MappingField + "3" + xpath2_dropdown_MappingField)));
		select.selectByValue(IConstantData.displayCode);
		ScreenShot.screenshot(driver, testCaseName, "After selecting mapping fields for Payment Type");
		logger.info("Selected mapping fields for Payment Type");

	}

	@Override
	public void clickOnFinish(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_FINISH);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on FINISH");

	}

	@Override
	public void clickOnExpandViewPurchasing(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EXPAND_VIEW_PURCHASING);

	}

	@Override
	public void clickManageFieldsPurchasingDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, MANAGE_FIELDS_PURCHASING_DETAILS);
		ActionBot.waitForElementToBeDisplayed(driver, BUTTON_CREATE_NEW_FIELD, ActionBot.timeOut);
	}

	@Override
	public void clickManageFieldsPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, MANAGE_FIELDS_PAYMENT_TERMS);
		ActionBot.waitForElementToBeDisplayed(driver, BUTTON_CREATE_NEW_FIELD, ActionBot.timeOut);

	}

	@Override
	public void clickManageFieldsGlobalPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, MANAGE_FIELDS_GLOBAL_PAYMENT_TERMS);
		ActionBot.waitForElementToBeDisplayed(driver, BUTTON_CREATE_NEW_FIELD, ActionBot.timeOut);

	}

	@Override
	public void clickOnEditContractedSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_FIELD_CONTRACTED_SUPPLIER);
		ActionBot.waitForElementToBeDisplayed(driver, TEXTBOX_DISPLAY_NAME, ActionBot.timeOut);

	}

	@Override
	public void fillDisplayName(WebDriver driver, String testCaseName, String displayValue) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_DISPLAY_NAME, displayValue);

	}

	@Override
	public void fillFieldName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		WebElement textBox = ActionBot.findElement(driver, TEXTBOX_FIELD_NAME);
		if (textBox.getAttribute("readonly") == null && ActionBot.isElementEnabled(driver, TEXTBOX_FIELD_NAME))
		{
			ActionBot.clear(driver, TEXTBOX_FIELD_NAME);

			ActionBot.sendKeys(driver, TEXTBOX_FIELD_NAME, fieldName);
		}
	}

	@Override
	public void selectMandatoryField_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementEnabled(driver, RADIOBUTTON_MANDATORY_YES))
		{
			ActionBot.click(driver, RADIOBUTTON_MANDATORY_YES);

			ScreenShot.screenshot(driver, testCaseName, "After selecting radio button_yes for mandatory");
		}

	}

	@Override
	public void selectMandatoryField_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementEnabled(driver, RADIOBUTTON_MANDATORY_NO))
		{
			ActionBot.click(driver, RADIOBUTTON_MANDATORY_NO);

			ScreenShot.screenshot(driver, testCaseName, "After selecting radio button_no for mandatory");
		}

	}

	@Override
	public void selectValueFormat_Static(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementEnabled(driver, RADIOBUTTON_VALUE_STATIC))
		{
			ActionBot.click(driver, RADIOBUTTON_VALUE_STATIC);

			ScreenShot.screenshot(driver, testCaseName, "After selecting radio Static for format value");
		}

	}

	@Override
	public void fillValueFormat(WebDriver driver, String testCaseName, String valueFormat) throws ActionBotException
	{
		if (ActionBot.isElementEnabled(driver, TEXTBOX_VALUE_FORMAT))
		{
			ActionBot.sendKeys(driver, TEXTBOX_VALUE_FORMAT, valueFormat);

			ScreenShot.screenshot(driver, testCaseName, "After filling value format");
		}

	}

	@Override
	public void clickOnSaveField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before Saving Field ");
		ActionBot.click(driver, BUTTON_SAVE_FIELD);
		ActionBot.waitForElementToBeDisplayed(driver, BUTTON_CREATE_NEW_FIELD, ActionBot.timeOut);
		ScreenShot.screenshot(driver, testCaseName, "Before Saving Field ");

	}

	@Override
	public void clickOnEditPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_FIELD_PAYMENT_TERMS);
		ActionBot.defaultSleep();

	}

	@Override
	public void clickOnEditPurchasingDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_FIELD_PURCHASING_DETAILS);
		ActionBot.waitForElementToBeDisplayed(driver, TEXTBOX_DISPLAY_NAME, ActionBot.timeOut);

	}

	@Override
	public void selectFieldType_manageView(WebDriver driver, String testCaseName, String fieldType) throws ActionBotException
	{
		if (ActionBot.isElementEnabled(driver, DROPDOWN_FIELD_TYPE_MANAGE_VIEW))
		{
			Select select = new Select(ActionBot.findElement(driver, DROPDOWN_FIELD_TYPE_MANAGE_VIEW));
			select.selectByValue(fieldType);
			logger.info("after selecting field type: " + fieldType);
			ScreenShot.screenshot(driver, testCaseName, "after selecting field type " + fieldType);
		}
	}

	@Override
	public void clickOnCreateNewField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CREATE_NEW_FIELD);
		ActionBot.waitForElementToBeDisplayed(driver, TEXTBOX_DISPLAY_NAME, ActionBot.timeOut);

	}

	@Override
	public void fillMaximunColumnLength(WebDriver driver, String testCaseName, String length) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_MAXIMUN_COLUMN_LENGTH);
		ActionBot.sendKeys(driver, TEXTBOX_MAXIMUN_COLUMN_LENGTH, length);

	}

	@Override
	public void selectCharacterType_Text(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementEnabled(driver, RADIOBUTTON_CHARACTER_TYPE_TEXT))
		{
			ActionBot.click(driver, RADIOBUTTON_CHARACTER_TYPE_TEXT);
			logger.info("selecting character type TEXT ");
			ScreenShot.screenshot(driver, testCaseName, "after selecting character type TEXT");
		}

	}

	@Override
	public void clickOnManageViewsHeaderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, HEADER_TAB_MANAGE_VIEWS);
		ScreenShot.screenshot(driver, testCaseName, "after clicking Manage Views Header Tab");

	}

	@Override
	public void clickOnLinkBackToManageViews(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_BACK_TO_MANAGE_VIEWS);
		ScreenShot.screenshot(driver, testCaseName, "after clicking back to Manage Views Header Tab");
		ActionBot.waitForElementToBeDisplayed(driver, BUTTON_CREATE_VIEW, ActionBot.timeOut);

	}

	@Override
	public void clickOnCreateViews(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CREATE_VIEW);
		ScreenShot.screenshot(driver, testCaseName, "after clicking back to Manage Views Header Tab");
		ActionBot.waitForElementToBeDisplayed(driver, TEXTBOX_VIEW_NAME, ActionBot.timeOut);

	}

	@Override
	public void fillViewName(WebDriver driver, String testCaseName, String viewName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_VIEW_NAME, viewName);
		ScreenShot.screenshot(driver, testCaseName, "after filling vew Name");
	}

	@Override
	public void selectView_SubView(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIOBUTTON_SUB_VIEW);
	}

	@Override
	public void selectParentView(WebDriver driver, String testCaseName, String parentView) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, DROPDOWN_PARENT_VIEW));
		select.selectByValue(parentView);
		ScreenShot.screenshot(driver, testCaseName, "After Selected parent view");
		logger.info("Selected parent view " + parentView);

	}

	@Override
	public void selectAddToViewList_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIOBUTTON_ADD_TO_LIST_VIEW_NO);

	}

	@Override
	public void selectViewScope(WebDriver driver, String testCaseName, String scope) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, DROPDOWN_VIEW_SCOPE));
		select.selectByValue(scope);
		ScreenShot.screenshot(driver, testCaseName, "After Selected view scope");
		logger.info("Selected view scope " + scope);

	}

	@Override
	public void selectViewLayout_2Columns(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIOBUTTON_VIEWLAYOUT_2_COLUMN);

	}

	@Override
	public void clickOnSaveView(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before saving view_ Global payment terms");
		ActionBot.click(driver, BUTTON_SAVE_VIEW);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After saving view_ Global payment terms");
		ActionBot.waitForElementToBeDisplayed(driver, BUTTON_CREATE_VIEW, ActionBot.timeOut);

	}

	@Override
	public void fillDisplayRank(WebDriver driver, String testCaseName, String displayRank) throws ActionBotException
	{
		if (ActionBot.isElementEnabled(driver, TEXTBOX_VIEW_DISPLAY_RANK))
			ActionBot.sendKeys(driver, TEXTBOX_VIEW_DISPLAY_RANK, displayRank);

	}

	@Override
	public void fillDisplayName_View(WebDriver driver, String testCaseName, String displayName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_VIEW_DISPLAY_NAME, displayName);

	}

	@Override
	public void selectValue_ReferenceMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIOBUTTON_VALUE_REFERENCE_MASTER);

	}

	@Override
	public void selectReferenceMaster(WebDriver driver, String testCaseName, String refrenceMaster) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, DROPDOWN_REFRENCE_MASTER));
		select.selectByValue(refrenceMaster);
		ScreenShot.screenshot(driver, testCaseName, "After Selecting Refrence Master");
		logger.info("Selected Refrence Master " + refrenceMaster);

	}

	@Override
	public void selectReferenceDisplayCode(WebDriver driver, String testCaseName, String displayCode) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, DROPDOWN_DISPLAY_CODE));
		select.selectByValue(displayCode);
		ScreenShot.screenshot(driver, testCaseName, "After Selecting display code for refrence master");
		logger.info("Selected display code for refrence master " + displayCode);
	}

	@Override
	public void selectReferenceDisplayValue(WebDriver driver, String testCaseName, String displayValue) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, DROPDOWN_DISPLAY_VALUE));
		select.selectByValue(displayValue);
		ScreenShot.screenshot(driver, testCaseName, "After Selecting display value for refrence master");
		logger.info("Selected display value for refrence master " + displayValue);

	}

	@Override
	public void deactivateEdiDeliveryMethod(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, EDI_DELIVERY_METHOD))
		{
			ActionBot.click(driver, EDI_DELIVERY_METHOD);
		}
		ActionBot.defaultSleep();
	}

	@Override
	public void deactivateEdiComment(WebDriver driver, String testCaseName) throws ActionBotException
	{

		if (ActionBot.isElementDisplayed(driver, EDI_COMMENT))
		{
			ActionBot.click(driver, EDI_COMMENT);
		}
		ActionBot.defaultSleep();
	}

	@Override
	public void deactivateSupplierIndicator(WebDriver driver, String testCaseName) throws ActionBotException
	{

		if (ActionBot.isElementDisplayed(driver, SUPPLIER_INDICATOR))
		{
			ActionBot.click(driver, SUPPLIER_INDICATOR);
		}
		ActionBot.defaultSleep();
	}

	@Override
	public void deactivateEdiObjectMode(WebDriver driver, String testCaseName) throws ActionBotException
	{

		if (ActionBot.isElementDisplayed(driver, EDI_OBJECT_MODE))
		{
			ActionBot.click(driver, EDI_OBJECT_MODE);
		}
		ActionBot.defaultSleep();
	}

	@Override
	public void deactivateEdiPartnerId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, EDI_PARTNER_ID))
		{
			ActionBot.click(driver, EDI_PARTNER_ID);
		}
		ActionBot.defaultSleep();
	}

	@Override
	public void deactivateEdiGsQualifier(WebDriver driver, String testCaseName) throws ActionBotException
	{

		if (ActionBot.isElementDisplayed(driver, EDI_GS_QUALIFIER))
		{
			ActionBot.click(driver, EDI_GS_QUALIFIER);
		}
		ActionBot.defaultSleep();
	}

	@Override
	public void deactivateJustificationStatement(WebDriver driver, String testCaseName) throws ActionBotException
	{

		if (ActionBot.isElementDisplayed(driver, JUSTIFICATION_STATEMENT))
		{
			ActionBot.click(driver, JUSTIFICATION_STATEMENT);
		}
		ActionBot.defaultSleep();
	}

	@Override
	public void deactivateEdiGsAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, EDI_GS_ADDRESS))
		{
			ActionBot.click(driver, EDI_GS_ADDRESS);
		}
		ActionBot.defaultSleep();
	}

	@Override
	public void deactivateEdiGoodsReceiptBasesInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, GOODS_RECEIPTS_BASED_INVOICE))
		{
			ActionBot.click(driver, GOODS_RECEIPTS_BASED_INVOICE);
		}
		ActionBot.defaultSleep();
	}

	@Override
	public void deactivateCompetitorFlag(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, COMPETITOR_FLAG))
		{
			ActionBot.click(driver, COMPETITOR_FLAG);
		}
		ActionBot.defaultSleep();
	}

	@Override
	public void deactivateUsedAt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, USED_AT))
		{
			ActionBot.click(driver, USED_AT);
		}
		ActionBot.defaultSleep();

		ScreenShot.screenshot(driver, testCaseName, "After deactivating reqiuired fields");
	}

	@Override
	public void deactivateViewDiversity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, DEACTIVATE_DIVERSITY))
		{
			ActionBot.click(driver, DEACTIVATE_DIVERSITY);
		}
		ActionBot.defaultSleep();

	}

	@Override
	public void deactivateViewFinancial(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, DEACTIVATE_FINANCIAL))
		{
			ActionBot.click(driver, DEACTIVATE_FINANCIAL);
		}
		ActionBot.defaultSleep();
	}

	@Override
	public void deactivateViewInsurance(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, DEACTIVATE_INSURANCE))
		{
			ActionBot.click(driver, DEACTIVATE_INSURANCE);
		}
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnActivateAndDeploy(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before activating and deploying");
		if (ActionBot.isElementDisplayed(driver, BUTTON_ACTIVATE_AND_DEPLOY))
		{
			ActionBot.click(driver, BUTTON_ACTIVATE_AND_DEPLOY);
		}
		ActionBot.defaultSleep();

		WebDriverWait wait = new WebDriverWait(driver, ActionBot.timeOut);
		if (wait.until(ExpectedConditions.alertIsPresent()) != null)
		{
			driver.switchTo().alert().accept();

		}
		ActionBot.waitForElementToBeEnable(driver, BUTTON_CREATE_VIEW, ActionBot.timeOut);
		ScreenShot.screenshot(driver, testCaseName, "After activating and deploying");
	}

	@Override
	public void goToHeaderManageUserTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, HEADER_TAB_MANAGE_USERS);
		ActionBot.waitForElementToBeDisplayed(driver, SIDE_PANNEL_MANAGE_USERS, ActionBot.timeOut);
	}

	@Override
	public void clickOnManageUserSidePanel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, SIDE_PANNEL_MANAGE_USERS);
		ActionBot.defaultLowSleep();

	}

	@Override
	public void clickOnEditUserDetails_ManageUser(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_USER_DETAIL_MANAGE_USERS);

	}

	@Override
	public void clickOnSaveChangeToProfile(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_CHANGES_TO_PROFILE);
	}

	@Override
	public void selectAllFacilities(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, By.xpath(xpath_dropdown_facilites_user_profile)));
		int size = select.getOptions().size();
		for (int i = 0; i < size; i++)
		{
			select.selectByIndex(i);
		}
		ActionBot.click(driver, BUTTON_ADD_FACILITY_USER_PROFILE);
		ScreenShot.screenshot(driver, testCaseName, "After adding all and Facilities");
	}

	@Override
	public void selectMainRole(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, DROPDOWN_MAIN_ROLE));
		select.selectByVisibleText("MDM");
	}

}
