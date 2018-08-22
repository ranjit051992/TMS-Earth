package com.zycus.automation.eproc.pageobjects.modals.freeTextForm_Actions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalActionsBtn
{

	final static UI_Elements	VIEW	= UIFactory.getElements("VIEW");
	final static UI_Elements	COPY	= UIFactory.getElements("COPY");

	void toClickViewLink(WebDriver driver, String testcaseName) throws ActionBotException;

	void toClickCopyLink(WebDriver driver, String testcaseName) throws ActionBotException;
}
