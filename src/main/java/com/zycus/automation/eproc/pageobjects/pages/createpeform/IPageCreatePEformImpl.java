/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createpeform;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

/**
 * @author ankita.sawant
 *
 */
public class IPageCreatePEformImpl implements IPageCreatePEform
{
	static Logger logger = Logger.getLogger(IPageCreatePEformImpl.class);

	@Override
	public String fillPEformName(WebDriver driver, String testCaseName, String peformName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_PROCESS_EFORM_NAME, peformName);
		String peform = ActionBot.findElement(driver, TEXTBOX_PROCESS_EFORM_NAME).getAttribute("value").trim();
		logger.info("Entered Process Eform Name : " + peform);
		return peform;
	}

	@Override
	public String selectProcessForPEform(WebDriver driver, String testCaseName, String processName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_PROCESS_FOR_PEFORM));
		select.selectByVisibleText(processName);
		String selectedProcess = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Process : " + selectedProcess);
		return selectedProcess;
	}

	@Override
	public void clickOnSelectOU(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Select OU");
		ActionBot.click(driver, LINK_SELECT_OU_FOR_PEFORM);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultHighSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Select OU");
	}

	@Override
	public String selectPurhcaseTypeForPEform(WebDriver driver, String testCaseName, String purchaseType) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_PURCHASE_TYPE_FOR_PEFORM));
		select.selectByVisibleText(purchaseType);
		String selectedPurchaseType = select.getFirstSelectedOption().getText().trim();
		logger.info("Selected Purchase Type : " + selectedPurchaseType);
		return selectedPurchaseType;
	}

	@Override
	public void clickOnSavePEformButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Save");
		if (ActionBot.isElementDisplayed(driver, BUTTON_SAVE_PEFORM_DETAILS))
		{
			ActionBot.click(driver, BUTTON_SAVE_PEFORM_DETAILS);
			ScreenShot.screenshot(driver, testCaseName, "After clicking on Save");
		}
	}

	@Override
	public void clickOnCancelPEformButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel");
		ActionBot.click(driver, BUTTON_CANCEL_PEFORM_DETAILS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel");

	}

	@Override
	public void clickOnSaveAsDraftButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on save peform");
		ActionBot.focusAndclick(driver, BUTTON_SAVE_PEFORM_AS_DRAFT);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save peform");
	}

	@Override
	public void clickOnPreviewButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on preview peform");
		ActionBot.click(driver, BUTTON_PREVIEW_PEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on preview peform");
	}

	@Override
	public String getPEformName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String pEformName = ActionBot.getAttributeOfElement(driver, TEXTBOX_PROCESS_EFORM_NAME, "value");
		logger.info("PEForm Name : " + pEformName);
		return pEformName;
	}

	@Override
	public String getSelectedProcessFoePEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_PROCESS_FOR_PEFORM));
		String processName = select.getFirstSelectedOption().getText().trim();
		logger.info("Process Name : " + processName);
		return processName;
	}

	@Override
	public String getSelectedPurchaseTypeForPEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		Select select = new Select(ActionBot.findElement(driver, SELECT_PURCHASE_TYPE_FOR_PEFORM));
		String purchaseType = select.getFirstSelectedOption().getText().trim();
		logger.info("Purchase Type : " + purchaseType);
		return purchaseType;
	}

	@Override
	public String getAddedSectionName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String sectionName = ActionBot.getTextWithInElement(driver, LABEL_ADDED_SECTION_NAME_ON_FORM_FIELDS);
		logger.info("Added Section Name : " + sectionName);
		return sectionName;
	}

	@Override
	public String getAddedFieldName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String fieldName = ActionBot.getTextWithInElement(driver, LABEL_ADDED_FIELD_NAME_ON_FORM_FIELDS);
		logger.info("Added Field Name : " + fieldName);
		return fieldName;
	}

	@Override
	public String getTagOFAddedFieldValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String tagName = ActionBot.findElement(driver, INPUT_ADDED_FIELD_VALUE_ON_FORM_FIELDS).getTagName().trim();
		logger.info("Tag name of Field Value : " + tagName);
		return tagName;
	}

	@Override
	public String getFileUploadedPEformName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String peform = ActionBot.findElement(driver, UPLOAD_EFORM_NAME).getText();
		logger.info("Entered Process Eform Name : " + peform);
		return peform;
	}

	@Override
	public void selectFile(WebDriver driver, String testCaseName) throws Exception
	{
		WebElement element = driver.findElement(By.xpath(".//*[@id='attachmentInput_attachment']"));
		element.sendKeys(ConfigProperty.getConfig("attachmentFilePath") + ConfigProperty.getConfig("upload_pform_file_1"));

		logger.info("Entered file path::" + ConfigProperty.getConfig("attachmentFilePath") + ConfigProperty.getConfig("upload_pform_file_1"));
		ScreenShot.screenshot(driver, testCaseName, "After filling file path");

		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void clickOnImportButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, IMPORT_PEFORM_BUTTON);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Import button");
		ActionBot.waitForPageLoad(driver);
	}
	
	@Override
	public void selectFile(WebDriver driver, String testCaseName,String attachmentFileName) throws Exception
	{
		WebElement element = driver.findElement(By.xpath(".//*[@id='attachmentInput_attachment']"));
		element.sendKeys(ConfigProperty.getConfig("attachmentFilePath") + attachmentFileName);

		logger.info("Entered file path::" + ConfigProperty.getConfig("attachmentFilePath") + attachmentFileName);
		ScreenShot.screenshot(driver, testCaseName, "After filling file path");

		ActionBot.waitForPageLoad(driver);
	}
}
