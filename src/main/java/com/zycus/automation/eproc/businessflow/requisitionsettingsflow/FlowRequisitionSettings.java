/**
 * 
 */
package com.zycus.automation.eproc.businessflow.requisitionsettingsflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.RequisitionSettings;
import com.zycus.automation.eproc.businessflow.FactoryBusinessFlow;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class FlowRequisitionSettings
{

	static Logger logger = Logger.getLogger(FlowRequisitionSettings.class);

	public static RequisitionSettings changeRequisitionSettings(WebDriver driver, String testCaseName, RequisitionSettings requisitionSettings) throws ActionBotException
	{
		RequisitionSettings settings = null;
		try
		{
			IFlowRequisitionSettingsImpl flowRequisitionSettingsImpl = FactoryBusinessFlow.getInstanceOfIFlowRequisitionSettings();
			settings = flowRequisitionSettingsImpl.changeRequisitionSettings(driver, testCaseName, requisitionSettings);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method changeRequisitionSettings " + e, e);
		}
		return settings;
	}

	public static RequisitionSettings getRequisitionSettings(WebDriver driver, String testCaseName) throws ActionBotException
	{
		RequisitionSettings settings = null;
		try
		{
			IFlowRequisitionSettingsImpl flowRequisitionSettingsImpl = FactoryBusinessFlow.getInstanceOfIFlowRequisitionSettings();
			settings = flowRequisitionSettingsImpl.getRequisitionSettings(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method getRequisitionSettings " + e, e);
		}
		return settings;
	}
}
