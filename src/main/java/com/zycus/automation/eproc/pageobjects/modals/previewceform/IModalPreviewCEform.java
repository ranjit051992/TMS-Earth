/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.previewceform;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalPreviewCEform
{
	static UI_Elements	LABEL_PREVIEW_CEFORM_SECTION_NAME	= UIFactory.getElements("LABEL_PREVIEW_CEFORM_SECTION_NAME");
	static UI_Elements	LABEL_PREVIEW_CEFORM_FIELD_NAME		= UIFactory.getElements("LABEL_PREVIEW_CEFORM_FIELD_NAME");
	static UI_Elements	LABEL_PREVIEW_CEFORM_FIELD_VALUE	= UIFactory.getElements("LABEL_PREVIEW_CEFORM_FIELD_VALUE");
	static UI_Elements	BUTTON_CLOSE_PREVIEW_CEFORM			= UIFactory.getElements("BUTTON_CLOSE_PREVIEW_CEFORM");

	public String getSectionName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFieldName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTagNameOfFieldValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClosePreviewButton(WebDriver driver, String testCaseName) throws ActionBotException;
}
