package com.zycus.automation.eproc.pageobjects.modals.UpdateAllLinesPO;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalUpdateAllLinesPO
{
	final static UI_Elements	DROPDOWN_TAX_TYPE_UPDATE_ALL_LINES					= UIFactory.getElements("DROPDOWN_TAX_TYPE_UPDATE_ALL_LINES");
	final static UI_Elements	TEXTBOX_TAX_NAME_UPDATE_ALL_LINES					= UIFactory.getElements("TEXTBOX_TAX_NAME_UPDATE_ALL_LINES");
	final static UI_Elements	RADIO_BUTTON_TAX_NOT_APPLICABLE						= UIFactory.getElements("RADIO_BUTTON_TAX_NOT_APPLICABLE");
	final static UI_Elements	BUTTON_APPLY_TAX									= UIFactory.getElements("BUTTON_APPLY_TAX");

	final static UI_Elements	TEXTBOX_TAX_RATE_UPDATE_ALL_LINES					= UIFactory.getElements("TEXTBOX_TAX_RATE_UPDATE_ALL_LINES");
	final static UI_Elements	RADIO_BUTTON_APPLY_WHERE_APPLICABLE_AND_NOT_DEFINED	= UIFactory.getElements("RADIO_BUTTON_APPLY_WHERE_APPLICABLE_AND_NOT_DEFINED");
	final static UI_Elements	RADIO_BUTTON_OVERRIDE_WHERE_DEFINED					= UIFactory.getElements("RADIO_BUTTON_OVERRIDE_WHERE_DEFINED");
	final static UI_Elements	LINK_REMOVE_ALL_MULTIPLE_TAXES_UPDATE_ALL_LINES		= UIFactory.getElements("LINK_REMOVE_ALL_MULTIPLE_TAXES_UPDATE_ALL_LINES");
	final static UI_Elements	ERROR_UPDATE_ALL_LINES								= UIFactory.getElements("ERROR_UPDATE_ALL_LINES");
	final static UI_Elements	BUTTON_ADD_TAX_UPDATE_ALL_LINES						= UIFactory.getElements("BUTTON_ADD_TAX_UPDATE_ALL_LINES");
	final static UI_Elements	BUTTON_REMOVE_TAX_UPDATE_ALL_LINES					= UIFactory.getElements("BUTTON_REMOVE_TAX_UPDATE_ALL_LINES");
	final static UI_Elements	TOOLTIP_TAXES_UPDATE_ALL_LINES						= UIFactory.getElements("TOOLTIP_TAXES_UPDATE_ALL_LINES");
	final static UI_Elements	UPDATE_ALL_LINE_ITEM_ERROR_TOOLTIP_ICON				= UIFactory.getElements("UPDATE_ALL_LINE_ITEM_ERROR_TOOLTIP_ICON");
	final static UI_Elements	CLOSE_UPDATE_ALL_LINE_MODAL							= UIFactory.getElements("CLOSE_UPDATE_ALL_LINE_MODAL");
	final static UI_Elements	TAX_TYPE_UPDATE_ALL_LINES							= UIFactory.getElements("TAX_TYPE_UPDATE_ALL_LINES");

	public void clickOnDropdownTaxType(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseUpdateAllLines(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectTaxType(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException;

	public String fillTaxName(WebDriver driver, String testCaseName, String taxName, int index) throws ActionBotException;

	public void clickOnRadioButtonTaxNotApplicable(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnApplyTax(WebDriver driver, String testCaseName) throws ActionBotException;

	public float fillTaxRate(WebDriver driver, String testCaseName, float taxRate) throws ActionBotException;

	public void clickOnApplyWhereApplicableAndNotDefined(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOverrrideWhereDefined(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRemoveAllMultipleTaxes(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRemoveAllMultipleTaxesPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void hoverOnErrorIcon(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddTax(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRemoveTax(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAddTaxButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isRemoveTaxButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isTooltipForTaxesPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isErrorTooltipiconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public void hoverOnTooltipTaxes(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillTaxType(WebDriver driver, String testCaseName, String taxType, int index) throws ActionBotException;
}
