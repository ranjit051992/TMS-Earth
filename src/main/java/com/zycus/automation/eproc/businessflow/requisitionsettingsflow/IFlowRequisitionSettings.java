/**
 * 
 */
package com.zycus.automation.eproc.businessflow.requisitionsettingsflow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.RequisitionSettings;
import com.zycus.automation.exception.ActionBotException;

/**
 * @author ankita.sawant
 *
 */
public interface IFlowRequisitionSettings
{

	public RequisitionSettings changeRequisitionSettings(WebDriver driver, String testCaseName, RequisitionSettings requisitionSettings) throws ActionBotException;

	public RequisitionSettings getRequisitionSettings(WebDriver driver, String testCaseName) throws ActionBotException;
}
