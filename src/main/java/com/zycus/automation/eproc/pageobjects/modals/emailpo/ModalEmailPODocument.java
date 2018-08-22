/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.emailpo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalEmailPODocument
{

	static Logger logger = Logger.getLogger(ModalEmailPODocument.class);

	public static void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			emailPODocument.clickOnCancelButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelButton " + e, e);
		}
	}

	/**
	 * @author amitkumar.dash
	 *
	 */
	public static String clickOnEmailMessageFieldAndGet(WebDriver driver, String testCaseName, String to) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			return emailPODocument.clickOnEmailMessageFieldAndGet(driver, testCaseName, to);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnEmailMessageFieldAndGet " + e, e);
		}
		return null;
	}

	public static void clickOnSendCopyCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			emailPODocument.clickOnSendCopyCheckBox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSendCopyCheckBox " + e, e);
		}
	}

	public static void clickOnSendEmailButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			emailPODocument.clickOnSendEmailButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSendEmailButton " + e, e);
		}
	}

	public static void clickOnAddExternalEmailLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			emailPODocument.clickOnAddExternalEmailLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAddExternalEmailLink " + e, e);
		}
	}

	public static String fillEmailMessageField(WebDriver driver, String testCaseName, String message) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			return emailPODocument.fillEmailMessageField(driver, testCaseName, message);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillEmailMessageField " + e, e);
		}
		return null;
	}

	public static String fillEmailToField(WebDriver driver, String testCaseName, String to) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			return emailPODocument.fillEmailToField(driver, testCaseName, to);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillEmailToField " + e, e);
		}
		return null;
	}

	public static String fillOtherEmailToField(WebDriver driver, String testCaseName, String to) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			return emailPODocument.fillOtherEmailToField(driver, testCaseName, to);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillOtherEmailToField " + e, e);
		}
		return null;
	}

	public static String getAddedMailid(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			return emailPODocument.getAddedMailid(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAddedMailid " + e, e);
		}
		return null;
	}

	/**
	 * @author amitkumar.dash
	 *
	 */
	public static String getAttachmentLinkText(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			return emailPODocument.getAttachmentLinkText(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getAttachmentLinkText " + e, e);
		}
		return null;
	}

	public static String getModalWindowTitle(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			return emailPODocument.getModalWindowTitle(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getModalWindowTitle " + e, e);
		}
		return null;
	}

	public static boolean isAbleToclickOnAttachmentPo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			return emailPODocument.isAbleToclickOnAttachmentPo(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnAttachmentPo " + e, e);
		}
		return false;
	}

	/**
	 * @author amitkumar.dash
	 *
	 */
	public static boolean isCancelRecipientPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			return emailPODocument.isCancelRecipientPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCancelRecipientPresent " + e, e);
		}
		return false;
	}

	/**
	 * @author amitkumar.dash
	 *
	 */
	public static boolean isCheckboxSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			return emailPODocument.isCheckboxSelected(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCheckboxSelected " + e, e);
		}
		return false;
	}

	public static boolean isErrorMsgAddMsgToSendMailPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			return emailPODocument.isErrorMsgAddMsgToSendMailPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isCheckboxSelected " + e, e);
		}
		return false;
	}

	public static boolean isErrorMsgForMailIdOfOutSideUserdisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			return emailPODocument.isErrorMsgForMailIdOfOutSideUserdisplayed(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isErrorMsgForMailIdOfOutSideUserdisplayed " + e, e);
		}
		return false;
	}

	public static boolean isSendEmailSuccessDivPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModalEmailPODocument emailPODocument = FactoryPage.getInstanceOf(IModalEmailPODocumentImpl.class);
			return emailPODocument.isSendEmailSuccessDivPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isSendEmailSuccessDivPresent " + e, e);
		}
		return false;
	}

}
