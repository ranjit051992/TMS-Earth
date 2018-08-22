/**
 * 
 */
package com.zycus.automation.eproc.businessflow.invitesupplierlisting;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.invitesupplierlisting.PageInviteSupplierListing;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class FlowInviteSupplierListing
{
	static Logger logger = Logger.getLogger(FlowInviteSupplierListing.class);

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
		PageInviteSupplierListing.fillSearchSupplier(driver, testCaseName, supplierName);
		PageInviteSupplierListing.clickOnFilterButton(driver, testCaseName);
		return checkIfSupplierIsSearched(driver, testCaseName, supplierName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Check if supplier searched <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param supplierName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean checkIfSupplierIsSearched(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;

		String searchedSupplierName = PageInviteSupplierListing.getSearchedSupplierName(driver, testCaseName);
		flag = searchedSupplierName.equalsIgnoreCase(supplierName);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Search invited supplier <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param supplierName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean searchInvitedSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		PageInviteSupplierListing.clickOnInvitedStatusFilterButton(driver, testCaseName);
		return searchSupplier(driver, testCaseName, supplierName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Search cancelled invitation <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param supplierName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean searchCancelledInvitationSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		PageInviteSupplierListing.clickOnCancelledStatusFilterButton(driver, testCaseName);
		return searchSupplier(driver, testCaseName, supplierName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Remind supplier <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean sendReminderToInvitedSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		PageInviteSupplierListing.clickOnRemindSupplierLink(driver, testCaseName);
		String supplierInfo = PageInviteSupplierListing.getSearchedSupplierInfo(driver, testCaseName);
		String[] temp = StringUtils.split(supplierInfo, "|");
		String[] temp1 = StringUtils.split(temp[2].trim(), ":");
		String invitedDateAsOnListing = temp1[1].trim();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String invitedDate = dateFormat.format(date);

		logger.info("Last Reminded Invited Date : " + invitedDate);
		logger.info("Last Reminded Invited Date As On Invitation Page Listing : " + invitedDateAsOnListing);
		flag = invitedDate.equalsIgnoreCase(invitedDateAsOnListing);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Cancel invitation <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param supplierName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static boolean cancelInvitationOfInvitedSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException, FactoryMethodException
	{
		PageInviteSupplierListing.clickOnCancelInvitationLink(driver, testCaseName);
		return searchCancelledInvitationSupplier(driver, testCaseName, supplierName);
	}
}
