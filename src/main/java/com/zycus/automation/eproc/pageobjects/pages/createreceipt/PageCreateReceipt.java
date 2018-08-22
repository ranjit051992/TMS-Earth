/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createreceipt;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageCreateReceipt
{
	static Logger logger = Logger.getLogger(PageCreateReceipt.class);

	public static String getReceiptDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.getReceiptDate(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReceiptDate " + e, e);
		}
		return null;
	}

	public static List<WebElement> getItemNamesInReceipt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.getItemNamesInReceipt(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getItemNamesInReceipt " + e, e);
		}
		return null;
	}

	public static String getSupplierNameOfItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.getSupplierNameOfItem(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSupplierNameOfItem " + e, e);
		}
		return null;
	}

	public static String selectRatingForItem(WebDriver driver, String testCaseName, String index, String ratingName) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.selectRatingForItem(driver, testCaseName, index, ratingName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectRatingForItem " + e, e);
		}
		return null;
	}

	public static String getSelectedRatingForItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.getSelectedRatingForItem(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getSelectedRatingForItem " + e, e);
		}
		return null;
	}

	public static String getRequisitionNoForItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.getRequisitionNoForItem(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequisitionNoForItem " + e, e);
		}
		return null;
	}

	public static String getUnitPriceForItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.getUnitPriceForItem(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getUnitPriceForItem " + e, e);
		}
		return null;
	}

	public static String getOrderedItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.getOrderedItem(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getOrderedItem " + e, e);
		}
		return null;
	}

	public static String getPendingItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.getPendingItem(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getPendingItem " + e, e);
		}
		return null;
	}

	public static int fillReceivedQuantityForItem(WebDriver driver, String testCaseName, String index, int recivedQuantity) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.fillReceivedQuantityForItem(driver, testCaseName, index, recivedQuantity);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReceivedQuantityForItem " + e, e);
		}
		return 0;
	}

	public static int getReceivedQuantityForItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.getReceivedQuantityForItem(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getReceivedQuantityForItem " + e, e);
		}
		return 0;
	}

	public static int fillApprovedQuantityForItem(WebDriver driver, String testCaseName, String index, int approvedQuantity) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.fillApprovedQuantityForItem(driver, testCaseName, index, approvedQuantity);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillApprovedQuantityForItem " + e, e);
		}
		return 0;
	}

	public static int getApprovedQuantityForItem(WebDriver driver, String testCaseName, String index) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.getApprovedQuantityForItem(driver, testCaseName, index);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getApprovedQuantityForItem " + e, e);
		}
		return 0;
	}

	public static String fillReceiptComments(WebDriver driver, String testCaseName, String receiptComment) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.fillReceiptComments(driver, testCaseName, receiptComment);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method fillReceiptComments " + e, e);
		}
		return null;
	}

	public static void clickOnSubmitReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			createReceipt.clickOnSubmitReceiptButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSubmitReceiptButton " + e, e);
		}
	}

	public static void clickOnSaveReceiptAsDraftButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			createReceipt.clickOnSaveReceiptAsDraftButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSaveReceiptAsDraftButton " + e, e);
		}
	}

	public static void clickOnCancelReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			createReceipt.clickOnCancelReceiptButton(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnCancelReceiptButton " + e, e);
		}
	}

	public static void clickOnSelectAllReceiptItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			createReceipt.clickOnSelectAllReceiptItems(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnSelectAllReceiptItems " + e, e);
		}
	}

	public static void clickOnIsThisTheLastGoodsReceiptForOrder(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			createReceipt.clickOnIsThisTheLastGoodsReceiptForOrder(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnIsThisTheLastGoodsReceiptForOrder " + e, e);
		}
	}

	public static boolean isAllowCreatingInvoicesForOrderDisabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.isAllowCreatingInvoicesForOrderDisabled(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAllowCreatingInvoicesForOrderDisabled " + e, e);
		}
		return false;
	}

	public static boolean isAllowCreatingInvoicesForOrderEnabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.isAllowCreatingInvoicesForOrderEnabled(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method isAllowCreatingInvoicesForOrderEnabled " + e, e);
		}
		return false;
	}

	public static String enterShippedVia(WebDriver driver, String testCaseName, String shippedVia) throws ActionBotException, FactoryMethodException
	{
		IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
		return createReceipt.enterShippedVia(driver, testCaseName, shippedVia);
	}

	/**
	 * 
	 * @Author: Omkar.Jagdale
	 *          Set reason for return of receipt
	 */

	public static String selectReasonForReturn(WebDriver driver, String testCaseName, String POId, String reasonForReturn) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.selectReasonForReturn(driver, testCaseName, POId, reasonForReturn);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectReasonForReturn " + e, e);
		}
		return null;
	}

	/**
	 * 
	 * @Author: Omkar.Jagdale
	 *          Set return method of receipt
	 */
	public static String selectReturnMethod(WebDriver driver, String testCaseName, String POId, String returnMethod) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.selectReturnMethod(driver, testCaseName, POId, returnMethod);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectReturnMethod " + e, e);
		}
		return null;
	}

	/**
	 * 
	 * @Author: Omkar.Jagdale
	 *          method checks inLineError Icon
	 */
	public static String checkInLineErrorIcon(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.checkInLineErrorIcon(driver, testCaseName, itemId);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkInLineErrorIcon " + e, e);
		}
		return null;
	}

	/**
	 * 
	 * @Author: Sameer.zilpilwar
	 * 
	 */
	public static void selectReasonForReturnUsingWebElement(WebDriver driver, String testCaseName, String reasonForReturn) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			createReceipt.selectReasonForReturnUsingWebElement(driver, testCaseName, reasonForReturn);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectReasonForReturnUsingWebElement " + e, e);
		}
	}

	/**
	 * 
	 * @Author: Sameer.zilpilwar
	 * 
	 */
	public static void selectReturnMethodUsingWebElement(WebDriver driver, String testCaseName, String returnMethod) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			createReceipt.selectReturnMethodUsingWebElement(driver, testCaseName, returnMethod);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method selectReturnMethodUsingWebElement" + e, e);
		}
	}

	/**
	 * 
	 * @Author: Sameer.zilpilwar
	 *          method checks ReturnNoteInformationField
	 */
	public static boolean checkReturnNoteInformationFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.checkReturnNoteInformationFieldPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkReturnNoteInformationFieldPresent " + e, e);
		}
		return false;
	}

	/**
	 * 
	 * @Author: Sameer.zilpilwar
	 *          method checks CommentAndAttachment Field in Return Note Detail part
	 */
	public static boolean checkCommentAndAttachmentInRNFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IPageCreateReceipt createReceipt = FactoryPage.getInstanceOf(IPageCreateReceiptImpl.class);
			return createReceipt.checkCommentAndAttachmentInRNFieldPresent(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method checkReturnNoteInformationFieldPresent " + e, e);
		}
		return false;
	}
}
