/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.bpobuyingscope;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalBPOBuyingScope
{
	static UI_Elements	TEXTBOX_BU_FOR_BPO_BUYING_SCOPE			= UIFactory.getElements("TEXTBOX_BU_FOR_BPO_BUYING_SCOPE");
	static UI_Elements	TEXTBOX_LOCATION_FOR_BPO_BUYING_SCOPE	= UIFactory.getElements("TEXTBOX_LOCATION_FOR_BPO_BUYING_SCOPE");
	static UI_Elements	TEXTBOX_COSTCENTER_FOR_BPO_BUYING_SCOPE	= UIFactory.getElements("TEXTBOX_COSTCENTER_FOR_BPO_BUYING_SCOPE");
	static UI_Elements	BUTTON_OK_FOR_BPO_BUYING_SCOPE			= UIFactory.getElements("BUTTON_OK_FOR_BPO_BUYING_SCOPE");

	public String fillBU(WebDriver driver, String testCaseName, String BU) throws ActionBotException;

	public String fillLocation(WebDriver driver, String testCaseName, String location) throws ActionBotException;

	public String fillCostCenter(WebDriver driver, String testCaseName, String costCenter) throws ActionBotException;

	public void clickOnOKButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
