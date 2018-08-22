/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.showallpos;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalShowAllPos
{

	static UI_Elements	MODAL_SHOW_ALL_PO_SEARCH_PO_NO			= UIFactory.getElements("MODAL_SHOW_ALL_PO_SEARCH_PO_NO");
	static UI_Elements	MODAL_SHOW_ALL_PO_NO_HEADER				= UIFactory.getElements("MODAL_SHOW_ALL_PO_NO_HEADER");
	static UI_Elements	MODAL_SHOW_ALL_PO_NO_RADIO_BTN			= UIFactory.getElements("MODAL_SHOW_ALL_PO_NO_RADIO_BTN");
	static UI_Elements	MODAL_SHOW_ALL_POS_SELECT_BTN			= UIFactory.getElements("MODAL_SHOW_ALL_POS_SELECT_BTN");
	static UI_Elements	HEADER_PO_TYPE_SHOW_ALL_POS				= UIFactory.getElements("HEADER_PO_TYPE_SHOW_ALL_POS");
	static UI_Elements	LABEL_PO_TYPE_SHOW_ALL_POS				= UIFactory.getElements("LABEL_PO_TYPE_SHOW_ALL_POS");
	static UI_Elements	LABEL_SUPPLIER_SHOW_ALL_POS				= UIFactory.getElements("LABEL_SUPPLIER_SHOW_ALL_POS");
	static UI_Elements	TEXTBOX_SUPPLIER_SHOW_ALL_POS			= UIFactory.getElements("TEXTBOX_SUPPLIER_SHOW_ALL_POS");
	UI_Elements			BUTTON_CLOSE_SHOW_ALL_POS				= UIFactory.getElements("BUTTON_CLOSE_SHOW_ALL_POS");
	UI_Elements			MODAL_SHOW_ALL_PO_NO_FIRST_RADIO_BUTTON	= UIFactory.getElements("MODAL_SHOW_ALL_PO_NO_FIRST_RADIO_BUTTON");
	static UI_Elements	FIRST_PO_NO_LINK						= UIFactory.getElements("FIRST_PO_NO_LINK");

	public String fillPonoShowAllpo(WebDriver driver, String testCaseName, String searchpono) throws ActionBotException;

	void clickOnHeaderPoNo(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnPoNoRadioBtn(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnSelectPoBtn(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPoTypeHeaderPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isPoTypeLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSupplierLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstPOType(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseShowAllPOs(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstPoNoRadioButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSupplierNameShowAllpo(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public String getFirstPONumber(WebDriver driver, String testCaseName) throws ActionBotException;
}
