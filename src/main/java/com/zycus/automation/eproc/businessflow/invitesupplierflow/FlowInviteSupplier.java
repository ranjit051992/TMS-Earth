/**
 * 
 */
package com.zycus.automation.eproc.businessflow.invitesupplierflow;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.InviteSupplier;
import com.zycus.automation.eproc.pageobjects.pages.invitesuppliers.PageInviteSuppliers;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class FlowInviteSupplier
{
	static Logger logger = Logger.getLogger(FlowInviteSupplier.class);

	public static InviteSupplier inviteSupplier(WebDriver driver, String testCaseName, InviteSupplier inviteSupplier) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnSuppliersSubTab(driver, testCaseName);

		PageInviteSuppliers.clickOnSendInvitationLink(driver, testCaseName);
		// selected suppliers
		if (inviteSupplier.isInviteSelectedSuppliers())
		{
			PageInviteSuppliers.clickOnSelectedSuppliers(driver, testCaseName);
		}
		else if (inviteSupplier.isInviteAllSuppliers())
		{
			PageInviteSuppliers.clickOnSelectAllSuppliers(driver, testCaseName);
		}

		// search supplier
		boolean flag = searchSupplier(driver, testCaseName, inviteSupplier.getSupplierName());
		Assert.assertTrue("Supplier was not searched", flag);

		PageInviteSuppliers.selectFirstSearchedSupplier(driver, testCaseName);
		PageInviteSuppliers.clickOnSaveAndContinue(driver, testCaseName);

		PageInviteSuppliers.getInvitationTemplateText(driver, testCaseName);

		PageInviteSuppliers.clickOnNextButton(driver, testCaseName);

		if (inviteSupplier.getNextAction().equalsIgnoreCase(IConstantsData.SEND_INVITATION))
		{
			PageInviteSuppliers.clickOnSendInvitationButton(driver, testCaseName);
		}
		else if (inviteSupplier.getNextAction().equalsIgnoreCase(IConstantsData.BACK_SUPPLIER_INVITE))
		{
			PageInviteSuppliers.clickOnBackButton(driver, testCaseName);
		}
		else if (inviteSupplier.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL_SUPPLIER_INVITE))
		{
			PageInviteSuppliers.clickOnCancelButton(driver, testCaseName);
		}
		return inviteSupplier;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Search supplier <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param supplierName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean searchSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		PageInviteSuppliers.selectSearchSuppliersBy(driver, testCaseName, IConstantsData.SUPPLIER_SEARCH_BY_NAME);
		PageInviteSuppliers.fillSearchSuppliers(driver, testCaseName, supplierName);
		PageInviteSuppliers.clickOnSearchSuppliersGoButton(driver, testCaseName);

		return supplierName.equalsIgnoreCase(PageInviteSuppliers.getFirstSearchedSupplierName(driver, testCaseName));
	}
}
