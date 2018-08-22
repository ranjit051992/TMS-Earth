/**
 * 
 */
package com.zycus.automation.eproc.businessflow.pcardlistingflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.PCard;
import com.zycus.automation.eproc.businessflow.createpcardflow.FlowCreatePCard;
import com.zycus.automation.eproc.pageobjects.modals.archivepcard.ModalArchivePCard;
import com.zycus.automation.eproc.pageobjects.modals.deactivatepcard.ModalDeactivatePCard;
import com.zycus.automation.eproc.pageobjects.modals.pcardactions.ModalPCardListingActions;
import com.zycus.automation.eproc.pageobjects.modals.pcardstatusfilter.ModalPCardListingStatusFilter;
import com.zycus.automation.eproc.pageobjects.pages.createpcard.PageCreatePCard;
import com.zycus.automation.eproc.pageobjects.pages.pcardlisting.PagePCardListing;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class FlowPCardListing
{
	static Logger logger = Logger.getLogger(FlowPCardListing.class);

	public static boolean searchPCard(WebDriver driver, String testCaseName, String pCardType, String pCardNo) throws ActionBotException, FactoryMethodException
	{
		String searchedPCard = null;
		boolean flag = false;
		MainPageHeaderLevelTab.clickOnPcardSubTab(driver, testCaseName);
		if (pCardType != null)
		{
			PagePCardListing.fillPCardType(driver, testCaseName, pCardType);
			if (PageSearchListing.isDataTableEmptyPresent(driver, testCaseName))
			{
				flag = false;
			}
			else
			{
				searchedPCard = PagePCardListing.getPCardTypeOfFirstRow(driver, testCaseName);
				flag = searchedPCard.equalsIgnoreCase(pCardType);
			}
		}
		else if (pCardNo != null)
		{
			PagePCardListing.fillPCardNo(driver, testCaseName, pCardNo);
			if (PageSearchListing.isDataTableEmptyPresent(driver, testCaseName))
			{
				flag = false;
			}
			else
			{
				searchedPCard = PagePCardListing.getPCardNoOfFirstRow(driver, testCaseName);
				flag = searchedPCard.equalsIgnoreCase(pCardNo);
			}
		}
		else
		{
			logger.info("Wrong parameters are send");
		}

		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Deactivate pcard <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param pCardNo </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean deactivatePCard(WebDriver driver, String testCaseName, String pCardNo) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		PagePCardListing.clickOnPCardActionsOfFirstRow(driver, testCaseName);
		ModalPCardListingActions.clickOnDeactivatePCardActionsLink(driver, testCaseName);

		// fill deactivation details
		ModalDeactivatePCard.fillDeactivateComments(driver, testCaseName, IConstantsData.DEACTIVATE_COMMENT_FOR_PCARD);
		ModalDeactivatePCard.selectDeactivateReasons(driver, testCaseName, IConstantsData.TEMPORARY_BLOCKED);
		ModalDeactivatePCard.clickOnDeactivateButton(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

		ActionBot.defaultSleep();
		// verifying deactiation of pcard
		// search PCard
		flag = searchPCard(driver, testCaseName, null, pCardNo);
		String status = PagePCardListing.getStatusOfPCard(driver, testCaseName);
		logger.info("Status of PCard after deactivating it : " + status);
		flag = status.equalsIgnoreCase(IConstantsData.DEACTIVATED);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Activate PCard <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param pCardNo </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean activatePCard(WebDriver driver, String testCaseName, String pCardNo) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		PagePCardListing.clickOnPCardActionsOfFirstRow(driver, testCaseName);
		ModalPCardListingActions.clickOnActivatePCardActionsLink(driver, testCaseName);

		// activate pcard
		PageCreatePCard.clickOnActivatePCardButton(driver, testCaseName);

		// verifying actiation of pcard
		// search PCard
		flag = searchPCard(driver, testCaseName, null, pCardNo);
		String status = PagePCardListing.getStatusOfPCard(driver, testCaseName);
		logger.info("Status of PCard after activating it : " + status);
		flag = status.equalsIgnoreCase(IConstantsData.IN_USE);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To archiving PCard <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param pCardNo </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean archivePCard(WebDriver driver, String testCaseName, String pCardNo) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		PagePCardListing.clickOnPCardActionsOfFirstRow(driver, testCaseName);
		ModalPCardListingActions.clickOnArchivePCardActionsLink(driver, testCaseName);

		// fill archiving details
		ModalArchivePCard.fillArchivingComments(driver, testCaseName, IConstantsData.ARCHIVE_COMMENT_FOR_PCARD);
		ModalArchivePCard.selectArchiveReasons(driver, testCaseName, IConstantsData.TEMPORARY_BLOCKED);
		ModalArchivePCard.clickOnArchiveButton(driver, testCaseName);

		// verifying archiving of pcard
		// search PCard
		flag = searchPCard(driver, testCaseName, null, pCardNo);
		return !flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To edit PCard <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param pCard </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean editPcard(WebDriver driver, String testCaseName, PCard pCard) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		PagePCardListing.clickOnPCardActionsOfFirstRow(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on action of Pcard");
		ActionBot.defaultSleep();
		ModalPCardListingActions.clickOnEditPCardActionsLink(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on edit Pcard");
		// fill pcard deatils
		pCard = FlowCreatePCard.fillPCardForm(driver, testCaseName, pCard);
		ScreenShot.screenshot(driver, testCaseName, "After filling Pcard");
		// activate pcard
		PageCreatePCard.clickOnActivatePCardButton(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After activating Pcard");
		// verifying actiation of pcard
		// search PCard
		flag = searchPCard(driver, testCaseName, null, pCard.getpCardNo());
		String status = PagePCardListing.getStatusOfPCard(driver, testCaseName);
		logger.info("Status of PCard after editing it : " + status);
		flag = status.equalsIgnoreCase(IConstantsData.IN_USE);
		return flag;
	}

	/**
	 * <b>Author: sanjay.kundu </b> <b><br>
	 * <font color="blue">Method :</b> To Search archived PCard <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 */

	public static boolean searchArchivedPCard(WebDriver driver, String testCaseName, String pCardType, String pCardNo) throws ActionBotException, FactoryMethodException
	{
		String searchedPCard = null;
		boolean flag = false;
		MainPageHeaderLevelTab.clickOnPcardSubTab(driver, testCaseName);
		if (pCardType != null)
		{
			PagePCardListing.fillPCardType(driver, testCaseName, pCardType);
			if (PageSearchListing.isDataTableEmptyPresent(driver, testCaseName))
			{
				flag = false;
			}
			else
			{
				searchedPCard = PagePCardListing.getPCardTypeOfFirstRow(driver, testCaseName);
				flag = searchedPCard.equalsIgnoreCase(pCardType);
			}
		}
		else if (pCardNo != null)
		{

			filterArchivedPCards(driver, testCaseName);
			PagePCardListing.fillPCardNo(driver, testCaseName, pCardNo);
			if (PageSearchListing.isDataTableEmptyPresent(driver, testCaseName))
			{
				flag = false;
			}
			else
			{
				searchedPCard = PagePCardListing.getPCardNoOfFirstRow(driver, testCaseName);
				flag = searchedPCard.equalsIgnoreCase(pCardNo);
			}
		}
		else
		{
			logger.info("Wrong parameters are send");
		}

		return flag;
	}

	/**
	 * <b>Author: sanjay.kundu </b> <b><br>
	 * <font color="blue">Method :</b> To Filter all the archived PCards <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 */

	public static void filterArchivedPCards(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PagePCardListing.clickOnClearStatusFilterLink(driver, testCaseName);
		PagePCardListing.clickOnStatusFilterLink(driver, testCaseName);
		ModalPCardListingStatusFilter.clickOnArchivedCheckBox(driver, testCaseName);
		ModalPCardListingStatusFilter.clickOnFilterLink(driver, testCaseName);
	}

}
