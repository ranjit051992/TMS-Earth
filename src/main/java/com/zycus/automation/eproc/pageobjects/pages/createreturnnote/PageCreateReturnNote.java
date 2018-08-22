/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createreturnnote;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author sameer.zilpilwar
 *
 */
public class PageCreateReturnNote
{
	static Logger logger = Logger.getLogger(PageCreateReturnNote.class);

	public static void clickOnBackReturnNoteLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			createReturnNote.clickOnBackReturnNoteLink(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Click on Back Return Note Link  " + e, e);
		}
	}

	public static void clickOnContinueAutoDeleteCommentPopUp(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			createReturnNote.clickOnContinueAutoDeleteCommentPopUp(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Click On Continue Auto Delete Comment PopUp" + e, e);
		}

	}

	public static boolean checkReturnNoteNumberMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkReturnNoteNumberMandatory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Return Note Number Mandatory field " + e, e);
		}
		return false;
	}

	public static boolean checkReturnNotenumberErrorMessage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkReturnNotenumberErrorMessage(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Return Note Number Error Message" + e, e);
		}
		return false;
	}

	public static void clearReturnNoteNumberField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			createReturnNote.clearReturnNoteNumberField(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Clear Retunr Note Number Field " + e, e);
		}
	}

	public static boolean checkSupplerNameLableFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkSupplerNameLableFieldPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Supplier Name Field Present " + e, e);
		}
		return false;
	}

	public static boolean checkReturnNotenumberFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkReturnNotenumberFieldPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Return Note Number Field Present " + e, e);
		}
		return false;
	}

	public static boolean checkSupplierNameDetailFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkSupplierNameDetailFieldPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Supplier Name Detail Field Present " + e, e);
		}
		return false;
	}

	public static boolean checkReturnNoteDescriptionMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkReturnNoteDescriptionMandatory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Return Note Description Madatory " + e, e);
		}
		return false;
	}

	public static boolean checkSupplierEmailMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkSupplierEmailMandatory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Supplier Email Mandatory " + e, e);
		}
		return false;
	}

	public static boolean checkSupplierConatactMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkSupplierConatactMandatory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Supplier Contact Madatory" + e, e);
		}
		return false;
	}

	public static boolean checkSupplierAddressMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkSupplierAddressMandatory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Supplier Address Mandatory" + e, e);
		}
		return false;
	}

	public static boolean checkReturnMaterialAuthorizationMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkReturnMaterialAuthorizationMandatory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Notify Supplier Field Present " + e, e);
		}
		return false;
	}

	public static boolean checkNotifySupplierFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkNotifySupplierFieldPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Notify Supplier Field Present " + e, e);
		}
		return false;
	}

	public static boolean checkReturnMethodAuthorizationfieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkReturnMethodAuthorizationfieldPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Retunr Method Authorization Field Present " + e, e);
		}
		return false;
	}

	public static boolean checkSupplierEmailFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkSupplierEmailFieldPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Retunr Method Authorization Field Present " + e, e);
		}
		return false;
	}

	public static boolean checkReturnNoteDescriptionFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkReturnNoteDescriptionFieldPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Retunr Method Authorization Field Present " + e, e);
		}
		return false;
	}

	public static boolean checkSupplierAddressFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkSupplierAddressFieldPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Supplier Address  Field Present " + e, e);
		}
		return false;
	}

	public static boolean checkSupplierContactFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkSupplierContactFieldPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Supplier Contact Field Field Present " + e, e);
		}
		return false;
	}

	public static boolean checkReturnQuantityFieldMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkReturnQuantityFieldMandatory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Return Quantity Field Mandatory " + e, e);
		}
		return false;
	}

	public static boolean checkReasonForReturnFieldMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkReasonForReturnFieldMandatory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Reason for Return  Field Mandatory " + e, e);
		}
		return false;
	}

	public static boolean checkReturnMethodFieldMandatory(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkReturnMethodFieldMandatory(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Return Method Field Mandatory " + e, e);
		}
		return false;
	}

	public static boolean checkSelectReturnQuantityErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkSelectReturnQuantityErrorPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Select Return Quantity Error Present " + e, e);
		}
		return false;
	}

	public static boolean checkSelectReasonForReturnErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkSelectReasonForReturnErrorPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Select RReason For Return Error Present " + e, e);
		}
		return false;
	}

	public static boolean checkSelectReturnMehthodErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkSelectReturnMehthodErrorPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Select Return Method Error Present" + e, e);
		}
		return false;
	}

	public static boolean checkItemReceivedSectionPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkItemReceivedSectionPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Check Item Recived Section Present" + e, e);
		}
		return false;
	}

	public static boolean checkHeaderErrorMessagePresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkHeaderErrorMessagePresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Header Error Message Present  " + e, e);
		}
		return false;
	}

	public static boolean checkReturnQuantityGreaterErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkReturnQuantityGreaterErrorPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method Check Return Quantity Greater Error Present" + e, e);
		}
		return false;
	}

	public static String getReturnNoteNumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.getReturnNoteNumber(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReturnNoteDescription " + e, e);
		}
		return null;
	}

	public static List<WebElement> getItemNameInReturnNote(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.getItemNameInReturnNote(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method getItemNameInReturnNote" + e, e);
		}
		return null;
	}

	public static String getNameOfItemInReturnNote(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.getNameOfItemInReturnNote(driver, testCaseName, element);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method getNameOfItemInReturnNote" + e, e);
		}
		return null;
	}

	public static String getOrderQuantityForItem(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.getOrderQuantityForItem(driver, testCaseName, element);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method getOrderQuantityForItem" + e, e);
		}
		return null;
	}

	public static String getUnitPriceForItem(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.getUnitPriceForItem(driver, testCaseName, element);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method getUnitPriceForItem" + e, e);
		}
		return null;
	}

	public static String getApprovedQuantity(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.getApprovedQuantity(driver, testCaseName, element);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method getApprovedQuantity" + e, e);
		}
		return null;
	}

	public static List<WebElement> getWebElementForOrderQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.getWebElementForOrderQuantity(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method getWebElementForOrderQuantity" + e, e);
		}
		return null;
	}

	public static List<WebElement> getWebElementForUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.getWebElementForUnitPrice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method getWebElementForUnitPrice" + e, e);
		}
		return null;
	}

	public static List<WebElement> getwebElementForApprovedQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.getwebElementForApprovedQuantity(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method getWebElementForApprovedQuantity" + e, e);
		}
		return null;
	}

	public static List<WebElement> getWebElementForReturnedQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.getWebElementForReturnedQuantity(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method getWebElementForReturnedQuantity" + e, e);
		}
		return null;
	}

	public static List<WebElement> getWebElementForReasonForReturn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.getWebElementForReasonForReturn(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method getWebElementForReasonForReturn" + e, e);
		}
		return null;
	}

	public static List<WebElement> getWebElementForReturnMethod(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.getWebElementForReturnMethod(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method getWebElementForReturnMethod" + e, e);
		}
		return null;
	}

	public static String fillReturnNoteNumber(WebDriver driver, String testCaseName, String returnNoteNumber) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.fillReturnNoteNumber(driver, testCaseName, returnNoteNumber);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReturnNoteNumber " + e, e);
		}
		return null;
	}

	public static String fillReturnNoteDescription(WebDriver driver, String testCaseName, String returnNoteDescription) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.fillReturnNoteDescription(driver, testCaseName, returnNoteDescription);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReturnNoteDescription " + e, e);
		}
		return null;
	}

	public static String fillNotes(WebDriver driver, String testCaseName, String notes) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.fillNotes(driver, testCaseName, notes);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillNotes " + e, e);
		}
		return null;
	}

	public static void selectNotifySupplierCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			createReturnNote.selectNotifySupplierCheckBox(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectNotifySupplierCheckBox " + e, e);
		}
	}

	public static void selectAllItemInReturnNote(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			createReturnNote.selectAllItemInReturnNote(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method selectAllItemInReturnNote " + e, e);
		}
	}

	public static String fillReturnMaterialAuthorization(WebDriver driver, String testCaseName, String returnMaterialAuthorization) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.fillReturnMaterialAuthorization(driver, testCaseName, returnMaterialAuthorization);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReturnMaterialAuthorization " + e, e);
		}
		return null;
	}

	public static String fillSupplierContact(WebDriver driver, String testCaseName, String supplierContact) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.fillSupplierContact(driver, testCaseName, supplierContact);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSupplierContact " + e, e);
		}
		return null;
	}

	public static String fillSupplierEmail(WebDriver driver, String testCaseName, String supplierEmail) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.fillSupplierEmail(driver, testCaseName, supplierEmail);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSupplierEmail " + e, e);
		}
		return null;
	}

	public static String fillSupplierAddress(WebDriver driver, String testCaseName, String supplierAddress) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.fillSupplierAddress(driver, testCaseName, supplierAddress);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSupplierAddress " + e, e);
		}
		return null;
	}

	public static String fillSupplierComment(WebDriver driver, String testCaseName, String supplierComment) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.fillSupplierComment(driver, testCaseName, supplierComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillSupplierComment " + e, e);
		}
		return null;
	}

	public static boolean checkSupplierCommentFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.checkSupplierCommentFieldPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method CheckSupplierFieldPresent " + e, e);
		}
		return false;
	}

	public static void clickOnSubmitReturnNoteButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			createReturnNote.clickOnSubmitReturnNoteButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSubmitReturnNoteButton " + e, e);
		}
	}

	public static void clickOnSaveReturnNoteAsDraftButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			createReturnNote.clickOnSaveReturnNoteAsDraftButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnReturnNoteAsDraftButton" + e, e);
		}

	}

	public static void clickOnCancelReturnNoteButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			createReturnNote.clickOnCancelReturnNoteButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancleReturnNoteButton" + e, e);
		}
	}

	public static void clickOnCreateReturnNote(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			createReturnNote.clickOnCreateReturnNote(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCreateReturnNoteButton" + e, e);
		}
	}

	public static void HoverOnCreateTabInReceipt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			createReturnNote.HoverOnCreateTabInReceipt(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method HoverOnCreateTabInReceipt" + e, e);
		}
	}

	public static String getApprovedQuantityForItem(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			return createReturnNote.getApprovedQuantityForItem(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method HoverOnCreateTabInReceipt" + e, e);
		}
		return null;
	}

	public static void fillReturnedQuantityforItem(WebDriver driver, String testCaseName, WebElement element, String returnQuantity) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			createReturnNote.fillReturnedQuantityforItem(driver, testCaseName, element, returnQuantity);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method HoverOnCreateTabInReceipt" + e, e);
		}
	}

	public static void fillReasonForReturnforItem(WebDriver driver, String testCaseName, WebElement element, String reasonForReturn) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			createReturnNote.fillReasonForReturnforItem(driver, testCaseName, element, reasonForReturn);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method HoverOnCreateTabInReceipt" + e, e);
		}
	}

	public static void fillReturnMethodforItem(WebDriver driver, String testCaseName, WebElement element, String returnMethod) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			createReturnNote.fillReturnMethodforItem(driver, testCaseName, element, returnMethod);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method HoverOnCreateTabInReceipt" + e, e);
		}
	}

	public static void clickOnAddAttachmentAtHeaderLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReturnNote createReturnNote = FactoryPage.getInstanceOf(IPageCreateReturnNoteImpl.class);
			createReturnNote.clickOnAddAttachmentAtHeaderLevel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in Method clickOnAddAttachmentAtHeaderLevel" + e, e);
		}
	}

}
