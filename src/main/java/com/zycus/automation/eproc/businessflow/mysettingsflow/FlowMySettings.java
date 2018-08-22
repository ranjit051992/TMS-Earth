/**
 * 
 */
package com.zycus.automation.eproc.businessflow.mysettingsflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.CustomDate;
import com.zycus.automation.bo.MySettings;
import com.zycus.automation.eproc.pageobjects.pages.mysettings.PageMySettings;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class FlowMySettings
{
	static Logger logger = Logger.getLogger(FlowMySettings.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Perform Actions <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param mySettings </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static MySettings performActions(WebDriver driver, String testCaseName, MySettings mySettings) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnMySettingsTab(driver, testCaseName);
		if (mySettings.getAction().equalsIgnoreCase(IConstantsData.DELEGATE))
		{
			mySettings = delegateApproval(driver, testCaseName, mySettings);
		}
		else if (mySettings.getAction().equalsIgnoreCase(IConstantsData.REVOKE))
		{
			mySettings = revokeApproval(driver, testCaseName, mySettings);
		}
		else
		{
			logger.info("Wrong action specified");
		}
		return mySettings;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To delegate approval <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param mySettings </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static MySettings delegateApproval(WebDriver driver, String testCaseName, MySettings mySettings) throws ActionBotException, FactoryMethodException
	{
		if (mySettings.getDelegateUserFrom() != null)
		{
			mySettings.setDelegateUserFrom(PageMySettings.fillDelegateApprovalFrom(driver, testCaseName, mySettings.getDelegateUserFrom()));
		}
		if (mySettings.getDelegateDateTo() != null)
		{
			mySettings.setDelegateUserTo(PageMySettings.fillDelegateApprovalTo(driver, testCaseName, mySettings.getDelegateUserTo()));
		}
		CustomDate customDate = new CustomDate();
		customDate.setDate(PageMySettings.getFromDelegateDate(driver, testCaseName));
		mySettings.setDelegateDateFrom(customDate);

		customDate.setDate(PageMySettings.getToDelegateDate(driver, testCaseName));
		mySettings.setDelegateDateTo(customDate);

		if (mySettings.getNextAction().equalsIgnoreCase(IConstantsData.DELEGATE))
		{
			PageMySettings.clickOnEnableButton(driver, testCaseName);
		}

		return mySettings;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To revoke delegation approval <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param mySettings </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static MySettings revokeApproval(WebDriver driver, String testCaseName, MySettings mySettings) throws ActionBotException, FactoryMethodException
	{
		if (mySettings.getRevokeFrom() != null)
		{
			mySettings.setRevokeFrom(PageMySettings.fillRevokeDelegateApprovalFrom(driver, testCaseName, mySettings.getRevokeFrom()));
		}

		if (mySettings.getNextAction().equalsIgnoreCase(IConstantsData.REVOKE))
		{
			PageMySettings.clickOnRevokeButton(driver, testCaseName);
		}
		return mySettings;
	}
}
