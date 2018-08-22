/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createceform;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.CEform;
import com.zycus.automation.bo.EformField;
import com.zycus.automation.bo.PEform;
import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageCreateCEform
{
	static Logger logger = Logger.getLogger(PageCreateCEform.class);

	public static String fillCFormName(WebDriver driver, String testCaseName, String cformName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			return createCEform.fillCFormName(driver, testCaseName, cformName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCFormName " + e, e);
		}
		return null;
	}

	public static void clickOnLogoUpload(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			createCEform.clickOnLogoUpload(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCFormName " + e, e);
		}

	}

	public static String fillCFormDisplayName(WebDriver driver, String testCaseName, String cformDisplayName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			return createCEform.fillCFormDisplayName(driver, testCaseName, cformDisplayName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillCFormDisplayName " + e, e);
		}
		return null;
	}

	public static void clickOnLinkSelectCategoriesForCForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			createCEform.clickOnLinkSelectCategoriesForCForm(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnLinkSelectCategoriesForCForm " + e, e);
		}
	}

	public static void clickOnLinkSelectOUForCForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			createCEform.clickOnLinkSelectOUForCForm(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnLinkSelectOUForCForm " + e, e);
		}
	}

	public static void clickOnSaveAndContinue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			createCEform.clickOnSaveAndContinue(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveAndContinue " + e, e);
		}
	}

	public static void clickOnAddSectionLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			createCEform.clickOnAddSectionLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddSectionLink " + e, e);
		}
	}

	public static void clickOnAddFieldLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			createCEform.clickOnAddFieldLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddFieldLink " + e, e);
		}
	}

	public static void clickOnPublishCEformButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			createCEform.clickOnPublishCEformButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPublishCEformButton " + e, e);
		}
	}

	public static void clickOnSaveCEformButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			createCEform.clickOnSaveCEformButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveCEformButton " + e, e);
		}
	}

	public static void clickOnPreviewCEformButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			createCEform.clickOnPreviewCEformButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnPreviewCEformButton " + e, e);
		}
	}

	public static void clickOnCancelCEformButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			createCEform.clickOnCancelCEformButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelCEformButton " + e, e);
		}
	}

	public static String getSectionName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			return createCEform.getSectionName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSectionName " + e, e);
		}
		return null;
	}

	public static String getFieldName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			return createCEform.getFieldName(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getFieldName " + e, e);
		}
		return null;
	}

	public static String getTagNameOfFieldValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			return createCEform.getTagNameOfFieldValue(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTagNameOfFieldValue " + e, e);
		}
		return null;
	}

	/*
	 * author : bhakti.sawant : verify eform section name
	 */
	public static boolean verifySectionName(WebDriver driver, String testCaseName, String sectionName) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			return createCEform.verifySectionName(driver, testCaseName, sectionName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method verifySectionName " + e, e);
		}
		return false;
	}

	/*
	 * author : bhakti.sawant
	 */
	public static boolean verifyTextField(WebDriver driver, String testCaseName, String textFieldName, int labelNumber, int noOfTextFields) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			return createCEform.verifyTextField(driver, testCaseName, textFieldName, labelNumber, noOfTextFields);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method verifyTextField " + e, e);
		}
		return false;

	}

	/*
	 * author : bhakti.sawant
	 */
	public static boolean verifyTextArea(WebDriver driver, String testCaseName, String textAreaName, int labelNumber, int textAreaNumber) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			return createCEform.verifyTextArea(driver, testCaseName, textAreaName, labelNumber, textAreaNumber);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method verifyTextArea " + e, e);
		}
		return false;
	}

	/*
	 * author : bhakti.sawant
	 */
	public static boolean verifyCheckBoxDetails(WebDriver driver, String testCaseName, String fieldName, int labelNumber, List<String> checkBoxChoiceslist)
		throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			return createCEform.verifyCheckBoxDetails(driver, testCaseName, fieldName, labelNumber, checkBoxChoiceslist);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method verifyCheckBoxDetails " + e, e);
		}
		return false;
	}

	/*
	 * author : bhakti.sawant
	 */
	public static PEform getFileUploadedPEformDetails(WebDriver driver, String testCaseName, PEform peform) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			return createCEform.getFileUploadedPEformDetails(driver, testCaseName, peform);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method verifyCheckBoxDetails " + e, e);
		}
		return null;
	}

	/*
	 * author : bhakti.sawant
	 */
	public static CEform getFileUploadedCEformDetails(WebDriver driver, String testCaseName, CEform ceFrom) throws ActionBotException
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			return createCEform.getFileUploadedCEformDetails(driver, testCaseName, ceFrom);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method verifyCheckBoxDetails " + e, e);
		}
		return null;
	}

	public static void clickOnImportCEformButton(WebDriver driver, String testCaseName)
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			createCEform.clickOnImportCEformButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTagNameOfFieldValue " + e, e);
		}

	}

	public static void selectFileForCeformUpload(WebDriver driver, String testCaseName)
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			createCEform.selectFileForCeformUpload(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTagNameOfFieldValue " + e, e);
		}

	}
	
	public static void selectFileForCeformUpload(WebDriver driver, String testCaseName,String attachmentFileName)
	{
		try
		{
			IPageCreateCEform createCEform = FactoryPage.getInstanceOf(IPageCreateCEformImpl.class);
			createCEform.selectFileForCeformUpload(driver, testCaseName, attachmentFileName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getTagNameOfFieldValue " + e, e);
		}

	}
}
