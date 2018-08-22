/**
 * 
 */
package com.zycus.automation.eproc.businessflow.documentInfoSettingFlow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.DocumentInformationSetting;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.documentinformationsettings.PageDocumentInformationSettings;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class FlowDocumentInformationSetting
{
	static Logger logger = Logger.getLogger(FlowDocumentInformationSetting.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get document information setting <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param documentInformationSetting </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </font><b><br>
	 * @throws FactoryMethodException </b> <br>
	 */
	public static DocumentInformationSetting getDocumentInformationSetting(WebDriver driver, String testCaseName, DocumentInformationSetting documentInformationSetting)
		throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
		PageCustomizeSettings.clickOnDocumentInformationLink(driver, testCaseName);

		if (documentInformationSetting.isRequisitionInfo())
		{
			PageDocumentInformationSettings.clickOnRequisitionInfo(driver, testCaseName);
			documentInformationSetting.setReqDetailsTemplate(PageDocumentInformationSettings.getDetailsTemplate(driver, testCaseName));
			documentInformationSetting.setReqItemRowTemplate(PageDocumentInformationSettings.getItemRowTemplate(driver, testCaseName));
		}
		if (documentInformationSetting.isPoInfo())
		{
			PageDocumentInformationSettings.clickOnPOInfo(driver, testCaseName);
			documentInformationSetting.setPoDetailsTemplate(PageDocumentInformationSettings.getDetailsTemplate(driver, testCaseName));
			documentInformationSetting.setPoItemRowTemplate(PageDocumentInformationSettings.getItemRowTemplate(driver, testCaseName));
		}
		return documentInformationSetting;
	}
}
