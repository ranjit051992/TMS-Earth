/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createceform;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.CEform;
import com.zycus.automation.bo.EformField;
import com.zycus.automation.bo.PEform;
import com.zycus.automation.eproc.pageobjects.pages.ceformlisting.IPageCEformListing;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

/**
 * @author ankita.sawant
 */
public class IPageCreateCEformImpl implements IPageCreateCEform
{
	static Logger logger = Logger.getLogger(IPageCreateCEformImpl.class);

	@Override
	public String fillCFormName(WebDriver driver, String testCaseName, String cformName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_CFORM_NAME, cformName);
		String cform_name = ActionBot.findElement(driver, TEXTBOX_CFORM_NAME).getAttribute("value").trim();
		logger.info("Entered CEform Name : " + cform_name);
		return cform_name;
	}

	@Override
	public String fillCFormDisplayName(WebDriver driver, String testCaseName, String cformDisplayName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_CFORM_DISPLAY_NAME, cformDisplayName);
		String cform_display_name = ActionBot.findElement(driver, TEXTBOX_CFORM_DISPLAY_NAME).getAttribute("value").trim();
		logger.info("Entered CEform Display Name : " + cform_display_name);
		return cform_display_name;
	}

	@Override
	public void clickOnLinkSelectCategoriesForCForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on select categories");
		ActionBot.click(driver, LINK_SELECT_CATEGORIES_FOR_CFORM);
		//ActionBot.waitTillPopUpIsPresent(driver, By.xpath(".//*[@id='status_overlay_loading']"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on select categories");
	}

	@Override
	public void clickOnLinkSelectOUForCForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on select OU CEform");
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, LINK_SELECT_OU_FOR_CFORM);
		//ActionBot.waitForPageLoad(driver);
		//ActionBot.defaultHighSleep();
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on select OU CEform");
	}

	@Override
	public void clickOnSaveAndContinue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Save and Continue");
		if (ActionBot.isElementDisplayed(driver, BUTTON_SAVE_AND_CONTINUE_CFORM_DETAILS))
		{

			ActionBot.click(driver, BUTTON_SAVE_AND_CONTINUE_CFORM_DETAILS);
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After clicking on Save and Continue");
		}
	}

	@Override
	public void clickOnAddSectionLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_SECTION_TO_CFORM);
	}

	@Override
	public void clickOnAddFieldLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_FIELD_CEFORM);
	}

	@Override
	public void clickOnPublishCEformButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Publish Eform");
		ActionBot.click(driver, BUTTON_PUBLISH_CEFORM);
		ActionBot.waitTillPopUpIsPresent(driver, IPageCEformListing.SUCCESS_MSG_FOR_EFORM_CREATION);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Publish Eform");
	}

	@Override
	public void clickOnSaveCEformButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Save Eform");
		ActionBot.focusAndclick(driver, BUTTON_SAVE_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Save Eform");
	}

	@Override
	public void clickOnPreviewCEformButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Preview Eform");
		ActionBot.click(driver, BUTTON_PREVIEW_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Preview Eform");
	}

	@Override
	public void clickOnCancelCEformButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Cancel Eform");
		ActionBot.click(driver, BUTTON_CANCEL_CFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel Eform");
	}

	@Override
	public String getSectionName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String sectionName = ActionBot.getTextWithInElement(driver, LABEL_ADDED_CEFORM_SECTION_NAME);
		logger.info("Section name : " + sectionName);
		return sectionName;
	}

	@Override
	public String getFieldName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String fieldName = ActionBot.getTextWithInElement(driver, LABEL_ADDED_CEFORM_FIELD_NAME);
		logger.info("Field name : " + fieldName);
		return fieldName;
	}

	@Override
	public String getTagNameOfFieldValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String tagName = ActionBot.findElement(driver, LABEL_ADDED_CEFORM_FIELD_VALUE_NAME).getTagName();
		logger.info("Tag name of field value: " + tagName);
		return tagName;
	}

	/*
	 * author : bhakti sawant
	 */
	@Override
	public boolean verifySectionName(WebDriver driver, String testCaseName, String sectionName) throws ActionBotException
	{
		logger.info("section real name__" + sectionName + "__");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element2 = (WebElement) js.executeScript("return document.getElementsByClassName('df-view-title')[0]");
		ActionBot.scroll(driver, element2);
		if (element2.getText().trim().equalsIgnoreCase(sectionName))
			return true;
		else
			return false;
	}

	/*
	 * author : bhakti sawant
	 */
	@Override
	public boolean verifyTextField(WebDriver driver, String testCaseName, String textFieldName, int labelNumber, int textFieldNumber) throws ActionBotException
	{
		logger.info("text field real name__" + textFieldName + "__");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement element2 = (WebElement) js.executeScript("return document.getElementsByClassName('df-form-label')[" + labelNumber + "]");
		if (!(element2.getText().trim().split(":")[0]).equals(textFieldName))
		{
			logger.info("Returning false in verify text field label info ::" + textFieldName);

			return false;
		}
		if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[contains(@id,'df_dfTF_')][" + textFieldNumber + "]")))
		{
			element2 = ActionBot.findElement(driver, By.xpath(".//*[contains(@id,'df_dfTF_')][" + textFieldNumber + "]"));
			element2.sendKeys("text field " + CommonUtilities.getNonZeroRandomNumber(2));
			return true;
		}
		logger.info("returning false in verify text field input info " + textFieldName + " " + textFieldNumber);
		return false;
	}

	/*
	 * author : bhakti sawant
	 */
	@Override
	public boolean verifyTextArea(WebDriver driver, String testCaseName, String textAreaName, int labelNumber, int textAreaNumber) throws ActionBotException
	{
		logger.info("text area real name__" + textAreaName + "__");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement element2 = (WebElement) js.executeScript("return document.getElementsByClassName('df-form-label')[" + labelNumber + "]");
		if (!(element2.getText().trim().split(":")[0]).equals(textAreaName))
		{
			logger.info("returning false in verify text area label info " + textAreaName);
			return false;
		}
		if (ActionBot.isElementDisplayed(driver, By.xpath(".//*[contains(@id,'df_dfTA_')][" + textAreaNumber + "]")))
		{
			element2 = ActionBot.findElement(driver, By.xpath(".//*[contains(@id,'df_dfTA_')][" + textAreaNumber + "]"));
			element2.sendKeys("text area " + CommonUtilities.getNonZeroRandomNumber(2));
			return true;
		}
		logger.info("returning false in verify text area input info " + textAreaName + " " + textAreaNumber);
		return false;
	}

	/*
	 * author : bhakti sawant
	 */
	@Override
	public boolean verifyCheckBoxDetails(WebDriver driver, String testCaseName, String checkBoxName, int labelNumber, List<String> checkBoxChoicesList) throws ActionBotException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement element2 = (WebElement) js.executeScript("return document.getElementsByClassName('df-form-label')[" + labelNumber + "]");
		if (!(element2.getText().trim().split(":")[0]).equals(checkBoxName))
		{
			logger.info("returning false in verify checkbox label info " + checkBoxName);
			return false;
		}
		ActionBot.click(driver, ActionBot.findElement(driver, By.xpath("(.//*[@class='df-form-chk dfCFValue'])[1]")));
		return true;
	}

	/*
	 * author : bhakti.sawant
	 * method to get eform details of file uploaded form : PEForm
	 */
	@Override
	public PEform getFileUploadedPEformDetails(WebDriver driver, String testCaseName, PEform pEform) throws ActionBotException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		//section name
		WebElement element2 = (WebElement) js.executeScript("return document.getElementsByClassName('df-view-title')[0]");
		if (element2 != null)
		{
			ActionBot.scroll(driver, element2);
			ActionBot.waitForPageLoad(driver);
			pEform.setSectionName(element2.getText().trim());
			logger.info("setting section name to text " + element2.getText().trim());

		}
		WebElement element3 = null;
		int labelNumber = 0;
		List<EformField> eformFieldList = new ArrayList<>();
		EformField eformField = null;
		WebElement element4;
		String labelName = null;
		//fields : text field/ text area
		do
		{
			element3 = (WebElement) js.executeScript("return document.getElementsByClassName('df-form-label')[" + labelNumber + "]");
			if (element3 != null)
			{
				eformField = new EformField();
				labelName = element3.getText().trim();
				if (labelName.charAt(labelName.length() - 1) == ':')
				{
					labelName = labelName.substring(0, labelName.length() - 1);
				}
				eformField.setFieldName(labelName);
				logger.info("setting label name to " + labelName);

				//check for text field
				element4 = (WebElement) js.executeScript("return document.getElementsByClassName('df-view-body df-clearfix')[0].getElementsByTagName('li')[" + labelNumber
					+ "].getElementsByTagName('div')[0].getElementsByClassName('df-form-ele dfTFValue')[0]");
				if (element4 != null)
				{
					if (element4.isDisplayed())
					{
						eformField.setFieldType("Text Field");
						logger.info("setting label " + (labelNumber) + "input type to text field");

					}
				}
				else
				{ //check for text area
					element4 = (WebElement) js.executeScript("return document.getElementsByClassName('df-view-body df-clearfix')[0].getElementsByTagName('li')[" + labelNumber
						+ "].getElementsByTagName('div')[0].getElementsByClassName('df-form-ele dfTAValue')[0]");
					if (element4 != null)
					{
						if (element4.isDisplayed())
						{
							eformField.setFieldType("Text Area");
							logger.info("setting label " + labelNumber + "input type to text area");
						}
					}
				}
				eformFieldList.add(eformField);
			}
			++labelNumber;
		} while (element3 != null);
		pEform.setEformFileds(eformFieldList);
		return pEform;
	}

	/*
	 * author : bhakti.sawant
	 * method to get eform details of file uploaded form : CEForm
	 */
	public CEform getFileUploadedCEformDetails(WebDriver driver, String testCaseName, CEform cEform) throws ActionBotException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		//section name
		WebElement element2 = (WebElement) js.executeScript("return document.getElementsByClassName('df-view-title')[0]");
		if (element2 != null)
		{
			ActionBot.scroll(driver, element2);
			ActionBot.waitForPageLoad(driver);
			cEform.setSectionName(element2.getText().trim());
			logger.info("setting section name to text " + element2.getText().trim());

		}
		WebElement element3 = null;
		int labelNumber = 0;
		List<EformField> eformFieldList = new ArrayList<>();
		EformField eformField = null;
		WebElement element4;
		String labelName = null;
		//fields : text field/ text area
		do
		{
			element3 = (WebElement) js.executeScript("return document.getElementsByClassName('df-form-label')[" + labelNumber + "]");
			if (element3 != null)
			{
				eformField = new EformField();
				labelName = element3.getText().trim();
				if (labelName.charAt(labelName.length() - 1) == ':')
				{
					labelName = labelName.substring(0, labelName.length() - 1);
				}
				eformField.setFieldName(labelName);
				logger.info("setting label name to " + labelName);

				//check for text field
				element4 = (WebElement) js.executeScript("return document.getElementsByClassName('df-view-body df-clearfix')[0].getElementsByTagName('li')[" + labelNumber
					+ "].getElementsByTagName('div')[0].getElementsByClassName('df-form-ele dfTFValue')[0]");
				if (element4 != null)
				{
					if (element4.isDisplayed())
					{
						eformField.setFieldType("Text Field");
						logger.info("setting label " + (labelNumber) + "input type to text field");

					}
				}
				else
				{ //check for text area
					element4 = (WebElement) js.executeScript("return document.getElementsByClassName('df-view-body df-clearfix')[0].getElementsByTagName('li')[" + labelNumber
						+ "].getElementsByTagName('div')[0].getElementsByClassName('df-form-ele dfTAValue')[0]");
					if (element4 != null)
						if (element4.isDisplayed())
						{
							{
								eformField.setFieldType("Text Area");
								logger.info("setting label " + labelNumber + "input type to text area");
							}
						}
				}
				eformFieldList.add(eformField);
			}
			++labelNumber;
		} while (element3 != null);
		cEform.setEformFileds(eformFieldList);
		return cEform;
	}

	@Override
	public void clickOnImportCEformButton(WebDriver driver, String testCaseName)
	{
		try
		{
			ActionBot.click(driver, IMPORT_CEFORM_BUTTON);
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After clicking on Import button");
			logger.info("Import button clicked ");
		}
		catch (ActionBotException e)
		{

			e.printStackTrace();
			logger.info("Import button could not be clicked ");
		}

	}

	@Override
	public void selectFileForCeformUpload(WebDriver driver, String testCaseName)
	{
		try
		{
			//	WebElement element = ActionBot.findElement(driver, BUTTON_SELECT_FILE_FOR_CEFORM);
			WebElement element = driver.findElement(By.xpath(".//*[@id='attachmentInput_attachment']"));
			element.sendKeys(ConfigProperty.getConfig("attachmentFilePath") + ConfigProperty.getConfig("upload_ceform_file_1"));

			logger.info("Entered file path::" + ConfigProperty.getConfig("attachmentFilePath") + ConfigProperty.getConfig("upload_ceform_file_1"));

			ScreenShot.screenshot(driver, testCaseName, "After filling file path");

			ActionBot.waitForPageLoad(driver);
		}
		catch (ActionBotException e)
		{

			e.printStackTrace();
			logger.info("Import button could not be clicked ");
		}
	}

	@Override
	public void clickOnLogoUpload(WebDriver driver, String testCaseName)
	{
		try
		{
			//WebElement element = ActionBot.findElement(driver, BUTTON_SELECT_FILE_FOR_CEFORM);
			WebElement element = driver.findElement(By.xpath(".//*[@id='attachmentInput_logoUpload']"));
			element.sendKeys(ConfigProperty.getConfig("attachmentFilePath") + ConfigProperty.getConfig("upload_logo"));
			ActionBot.waitForPageLoad(driver);
		}
		catch (ActionBotException e)
		{

			e.printStackTrace();
		}

	}

	/*
	 author : bhakti.sawant 
	 method to attach specific ceform file
	 */
	@Override
	public void selectFileForCeformUpload(WebDriver driver, String testCaseName,String attachmentFileName)
	{
		try
		{
			//	WebElement element = ActionBot.findElement(driver, BUTTON_SELECT_FILE_FOR_CEFORM);
			WebElement element = driver.findElement(By.xpath(".//*[@id='attachmentInput_attachment']"));
			element.sendKeys(ConfigProperty.getConfig("attachmentFilePath") + attachmentFileName);

			logger.info("Entered file path::" + ConfigProperty.getConfig("attachmentFilePath") + attachmentFileName);

			ScreenShot.screenshot(driver, testCaseName, "After filling file path");

			ActionBot.waitForPageLoad(driver);
		}
		catch (ActionBotException e)
		{

			e.printStackTrace();
			logger.info("Import button could not be clicked ");
		}
	}
}
