package com.zycus.automation.eproc.pageobjects.popups.FreeTextSelectCategoryEForm;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPopUpSelectCategoryEForm
{

	final static UI_Elements	CONTINUE_BTN	= UIFactory.getElements("CONTINUE_BTN");
	final static UI_Elements	CANCEL_BTN		= UIFactory.getElements("CANCEL_BTN");

	void toClickContinueBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	void toClickCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException;

}
