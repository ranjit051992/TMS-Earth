package com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryMiscellaneous;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class ModelItemSummaryMiscellaneous
{

	static Logger logger = Logger.getLogger(ModelItemSummaryMiscellaneous.class);

	public static void enterFieldValue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			IModelItemSummaryMiscellaneous itemSummary = FactoryModal.getInstanceOfIModelItemSummaryMiscellaneous();
			itemSummary.enterFieldValue(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method enterFieldValue " + e, e);
		}

	}
}
