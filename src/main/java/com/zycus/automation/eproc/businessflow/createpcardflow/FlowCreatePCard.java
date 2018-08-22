/**
 * 
 */
package com.zycus.automation.eproc.businessflow.createpcardflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.PCard;
import com.zycus.automation.eproc.pageobjects.modals.selectcompanypcard.ModalSelectCompanyForPCard;
import com.zycus.automation.eproc.pageobjects.pages.createpcard.PageCreatePCard;
import com.zycus.automation.eproc.pageobjects.pages.pcardlisting.PagePCardListing;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class FlowCreatePCard
{
	static Logger logger = Logger.getLogger(FlowCreatePCard.class);

	public static PCard createPCard(WebDriver driver, String testCaseName, PCard pCard) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnPcardSubTab(driver, testCaseName);
		PagePCardListing.clickOnAddPCardButtton(driver, testCaseName);

		// fill pCard details
		fillPCardForm(driver, testCaseName, pCard);

		// activate pcard
		if (pCard.getNextAction().equalsIgnoreCase(IConstantsData.ACTIVATE_PCARD))
		{
			PageCreatePCard.clickOnActivatePCardButton(driver, testCaseName);
		}
		// save pcard
		else if (pCard.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			PageCreatePCard.clickOnSavePCardButton(driver, testCaseName);
		}
		// cancel pcard
		else if (pCard.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			PageCreatePCard.clickOnCancelPCardButton(driver, testCaseName);
		}
		else
		{
			logger.info("Invalid next action");
		}

		return pCard;
	}

	public static PCard fillPCardForm(WebDriver driver, String testCaseName, PCard pCard) throws ActionBotException, FactoryMethodException
	{
		// PCard Type
		if (pCard.getpCardType() != null)
		{
			pCard.setpCardType(PageCreatePCard.selectPCardType(driver, testCaseName, pCard.getpCardType()));
		}

		// pcard no
		if (pCard.getpCardNo() != null)
		{
			pCard.setpCardNo(PageCreatePCard.fillPCardNo(driver, testCaseName, pCard.getpCardNo()));
		}
		else
			pCard.setpCardNo(PageCreatePCard.getPCardNumber(driver, testCaseName));

		// issuing bank
		if (pCard.getIssuingBank() != null)
		{
			pCard.setIssuingBank(PageCreatePCard.fillIssuingBank(driver, testCaseName, pCard.getIssuingBank()));
		}

		// parent account no
		if (pCard.getParentAccNo() != null)
		{
			pCard.setParentAccNo(PageCreatePCard.fillParentAccountNo(driver, testCaseName, pCard.getParentAccNo()));
		}

		// issued to
		if (pCard.isIssuedToUser())
		{
			PageCreatePCard.clickOnIssuedToUser(driver, testCaseName);
			pCard.setIssuedTo(PageCreatePCard.fillIssuedToUser(driver, testCaseName, pCard.getIssuedTo()));
		}
		else if (pCard.isIssuedToSupplier())
		{
			PageCreatePCard.clickOnIssuedToSupplier(driver, testCaseName);
			pCard.setIssuedTo(PageCreatePCard.fillIssuedToSupplier(driver, testCaseName, pCard.getIssuedTo()));
		}

		// name on the card
		if (pCard.getNameOnCard() != null)
		{
			pCard.setNameOnCard(PageCreatePCard.fillNameOnCard(driver, testCaseName, pCard.getNameOnCard()));
		}

		// expiry date
		if (pCard.getExpiryDate() != null)
		{
			pCard.getExpiryDate().setDate(PageCreatePCard.selectExpiryMonthAndYear(driver, testCaseName, pCard.getExpiryDate().getMonth(), pCard.getExpiryDate().getYear()));
		}

		// security key
		if (pCard.getSecurityKey() != null)
		{
			pCard.setSecurityKey(PageCreatePCard.fillSecurityKey(driver, testCaseName, pCard.getSecurityKey()));
		}

		// billing currency
		if (pCard.getBillingCurrency() != null)
		{
			pCard.setBillingCurrency(PageCreatePCard.fillBillingCurrency(driver, testCaseName, pCard.getBillingCurrency()));
		}

		// last billed on
		if (pCard.getLastBilledOnDate() != null)
		{
			pCard.getLastBilledOnDate().setDate(PageCreatePCard.selectLastBilledOnDate(driver, testCaseName, pCard.getLastBilledOnDate().getDay(),
				pCard.getLastBilledOnDate().getMonth(), pCard.getLastBilledOnDate().getYear()));
		}

		// statement frequency
		if (pCard.getStatementFrequency() != null)
		{
			pCard.setStatementFrequency(PageCreatePCard.selectStatementFrequency(driver, testCaseName, pCard.getStatementFrequency()));
		}

		// credit days
		if (pCard.getCreditDays() != 0)
		{
			pCard.setCreditDays(PageCreatePCard.fillCreditDays(driver, testCaseName, pCard.getCreditDays()));
		}

		// if issued to user
		if (pCard.isIssuedToUser())
		{
			// allowed OUs
			if (pCard.getAllowedOUs() != null)
			{
				pCard.setAllowedOUs(PageCreatePCard.selectAllowedOUs(driver, testCaseName, pCard.getAllowedOUs()));
			}
		}
		// spend per transaction
		if (pCard.getSpendPerTransaction() != 0)
		{
			pCard.setSpendPerTransaction(PageCreatePCard.fillSpendPerTransaction(driver, testCaseName, pCard.getSpendPerTransaction()));
		}

		// transaction per day
		if (pCard.getTransactionsPerDay() != 0)
		{
			pCard.setTransactionsPerDay(PageCreatePCard.fillTransactionsPerDay(driver, testCaseName, pCard.getTransactionsPerDay()));
		}

		// spend per day
		if (pCard.getSpendPerDay() != 0)
		{
			pCard.setSpendPerDay(PageCreatePCard.fillSpendPerDay(driver, testCaseName, pCard.getSpendPerDay()));
		}

		// transaction per cycle
		if (pCard.getTransactionsPerCycle() != 0)
		{
			pCard.setTransactionsPerCycle(PageCreatePCard.fillTransactionsPerCycle(driver, testCaseName, pCard.getTransactionsPerCycle()));
		}

		// spend per cycle
		if (pCard.getSpendPerCycle() != 0)
		{
			pCard.setSpendPerCycle(PageCreatePCard.fillSpendPerCycle(driver, testCaseName, pCard.getSpendPerCycle()));
		}

		// if issued to supplier
		if (pCard.isIssuedToSupplier())
		{
			if (pCard.getAllowedOUs() != null)
			{
				PageCreatePCard.clickOnSelectCompany(driver, testCaseName);
				if (pCard.getAllowedOUs().equalsIgnoreCase(IConstantsData.ALL))
				{
					ModalSelectCompanyForPCard.selectAllCompany(driver, testCaseName);
				}
				else
				{
					ModalSelectCompanyForPCard.selectCompany(driver, testCaseName, pCard.getAllowedOUs());
				}
				ModalSelectCompanyForPCard.clickOnSaveButton(driver, testCaseName);
			}
			// match supplier invoice
			if (pCard.isMatchSupplierInvoice())
			{
				PageCreatePCard.clickOnMatchSupplierInvoiceCheckBox(driver, testCaseName);
			}
		}
		return pCard;
	}

	/**
	 * <b>Author: sanjay.kundu </b> <b><br>
	 * <font color="blue">Method :</b> To activate a pcard with errors <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 */

	public static boolean createPCardWithError(WebDriver driver, String testCaseName, PCard pCard) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnPcardSubTab(driver, testCaseName);

		//clicing on addpcard button
		PagePCardListing.clickOnAddPCardButtton(driver, testCaseName);

		// fill pCard details
		FlowCreatePCard.fillPCardForm(driver, testCaseName, pCard);

		PageCreatePCard.clickOnActivatePCardButton(driver, testCaseName);

		boolean flag = PageCreatePCard.isAddPCardButtonPresent(driver, testCaseName);

		return !flag;
	}

}