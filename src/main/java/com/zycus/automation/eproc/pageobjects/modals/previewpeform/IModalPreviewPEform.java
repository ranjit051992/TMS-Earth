/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.previewpeform;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalPreviewPEform
{
	static UI_Elements	LABEL_SECTION_TITLE_PEFORM_PREVIEW		= UIFactory.getElements("LABEL_SECTION_TITLE_PEFORM_PREVIEW");
	static UI_Elements	LABEL_FIELD_TITLE_PEFORM_PREVIEW		= UIFactory.getElements("LABEL_FIELD_TITLE_PEFORM_PREVIEW");
	static UI_Elements	LABEL_FIELD_VALUE_TITLE_PEFORM_PREVIEW	= UIFactory.getElements("LABEL_FIELD_VALUE_TITLE_PEFORM_PREVIEW");
	static UI_Elements	BUTTON_CLOSE_PEFORM_PREVIEW				= UIFactory.getElements("BUTTON_CLOSE_PEFORM_PREVIEW");

	public String getLabelValueOfSection(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getLabelValueOfField(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTagOfFieldValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClosePreviewButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
