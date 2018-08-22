/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.bpobuyingscope;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalBPOBuyingScopeImpl implements IModalBPOBuyingScope
{
	static Logger logger = Logger.getLogger(IModalBPOBuyingScopeImpl.class);

	@Override
	public String fillBU(WebDriver driver, String testCaseName, String BU) throws ActionBotException
	{
		String selectedBU = ActionBot.fillAutoCompleteField(driver, TEXTBOX_BU_FOR_BPO_BUYING_SCOPE, BU);
		logger.info("Selected BU : " + selectedBU);
		return selectedBU;
	}

	@Override
	public String fillLocation(WebDriver driver, String testCaseName, String location) throws ActionBotException
	{
		String selectedLocation = ActionBot.fillAutoCompleteField(driver, TEXTBOX_LOCATION_FOR_BPO_BUYING_SCOPE, location);
		logger.info("Selected Location : " + selectedLocation);
		return selectedLocation;
	}

	@Override
	public String fillCostCenter(WebDriver driver, String testCaseName, String costCenter) throws ActionBotException
	{
		String selectedCC = ActionBot.fillAutoCompleteField(driver, TEXTBOX_COSTCENTER_FOR_BPO_BUYING_SCOPE, costCenter);
		logger.info("Selected Cost Center : " + selectedCC);
		return selectedCC;
	}

	@Override
	public void clickOnOKButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on OK button");
		ActionBot.click(driver, BUTTON_OK_FOR_BPO_BUYING_SCOPE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on OK button");
	}

}
