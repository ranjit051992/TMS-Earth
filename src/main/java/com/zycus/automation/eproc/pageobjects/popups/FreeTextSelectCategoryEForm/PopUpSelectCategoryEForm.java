package com.zycus.automation.eproc.pageobjects.popups.FreeTextSelectCategoryEForm;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class PopUpSelectCategoryEForm
{

	static Logger logger = Logger.getLogger(PopUpSelectCategoryEForm.class);

	public static void toClickContinueBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPopUpSelectCategoryEForm eForm = FactoryPage.getInstanceOf(IPopUpSelectCategoryEFormImpl.class);
			eForm.toClickContinueBtn(driver, testcaseName);

		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickContinueBtn " + e, e);
		}

	}

	public static void toClickCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException
	{
		try
		{
			IPopUpSelectCategoryEForm eForm = FactoryPage.getInstanceOf(IPopUpSelectCategoryEFormImpl.class);
			eForm.toClickCancelBtn(driver, testcaseName);

		}

		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method toClickCancelBtn " + e, e);
		}

	}

}
