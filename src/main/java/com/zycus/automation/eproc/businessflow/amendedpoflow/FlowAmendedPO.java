/**
 * 
 */
package com.zycus.automation.eproc.businessflow.amendedpoflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.porecallapprovalrequest.ModalPORecallApprovalRequest;
import com.zycus.automation.eproc.pageobjects.pages.ammendedPOorders.PageAmmendedPO;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class FlowAmendedPO
{
	static Logger logger = Logger.getLogger(FlowAmendedPO.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To recall amended po <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param poNumber </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static boolean recallAmendedPO(WebDriver driver, String testCaseName, String poNumber, int index) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		PageAmmendedPO.clickOnActions(driver, testCaseName, poNumber);
		PageAmmendedPO.clickOnRecallApprovalRequestOfApprovalPO(driver, testCaseName, index);
		ModalPORecallApprovalRequest.fillRecallComments(driver, testCaseName, IConstantsData.RECALL_APPROVAL_REQUEST_COMMENT);
		ModalPORecallApprovalRequest.clickOnRecallButton(driver, testCaseName);

		String status = PageAmmendedPO.getStatusOfAmendedPO(driver, testCaseName, poNumber);
		flag = status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To view amended po <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param poNumber </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static void viewAmendedPO(WebDriver driver, String testCaseName, String poNumber) throws ActionBotException, FactoryMethodException
	{
		PageAmmendedPO.clickOnAmendedPONumber(driver, testCaseName, poNumber);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To rollback BPO <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static void rollBackBPO(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageAmmendedPO.clickOnRollBack(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmNoButton(driver, testCaseName);
		PageAmmendedPO.waitTillRollBackPopupPresent(driver, testCaseName);
	}
}
