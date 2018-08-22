/**
 * 
 */
package com.zycus.automation.eproc.businessflow.othernotificationsettingflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.OtherNotificationSetting;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.othernotification.PageOtherNotificationSetting;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class FlowOtherNotificationSetting
{
	static Logger logger = Logger.getLogger(FlowOtherNotificationSetting.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get other notification setting <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param documentInformationSetting </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static OtherNotificationSetting getOtherNotificationSetting(WebDriver driver, String testCaseName, OtherNotificationSetting otherNotificationSetting)
		throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
		PageCustomizeSettings.clickOnOtherNotificationsLink(driver, testCaseName);

		if (otherNotificationSetting.isOnBuyersDesk())
		{
			PageOtherNotificationSetting.clickOnBuyersDeskInfoLink(driver, testCaseName);
			otherNotificationSetting.setBuyersDeskSubject(PageOtherNotificationSetting.getSubjectTemplate(driver, testCaseName));
			otherNotificationSetting.setBuyersDeskBody(PageOtherNotificationSetting.getBodyTemplate(driver, testCaseName));
		}
		if (otherNotificationSetting.isOnPOReleased())
		{
			PageOtherNotificationSetting.clickOnPOReleasedInfoLink(driver, testCaseName);
			otherNotificationSetting.setPoReleasedSubject(PageOtherNotificationSetting.getSubjectTemplate(driver, testCaseName));
			otherNotificationSetting.setPoReleasedBody(PageOtherNotificationSetting.getBodyTemplate(driver, testCaseName));
		}
		return otherNotificationSetting;
	}
}
