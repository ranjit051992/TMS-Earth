package com.zycus.automation.eproc.pageobjects.modals.freeTextForm_SuggestNewSupplier;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalSuggestNewSupplier
{

	final static UI_Elements	ENTER_SUPPLIER_NAME_FIELD	= UIFactory.getElements("ENTER_SUPPLIER_NAME_FIELD");
	final static UI_Elements	SUPPLIER_NAME				= UIFactory.getElements("SUPPLIER_NAME");
	final static UI_Elements	LOCATION					= UIFactory.getElements("LOCATION");
	final static UI_Elements	CONTACT_PERSON				= UIFactory.getElements("CONTACT_PERSON");
	final static UI_Elements	EMAIL						= UIFactory.getElements("EMAIL");
	final static UI_Elements	PHONE						= UIFactory.getElements("PHONE");
	final static UI_Elements	OTHER_DETAILS				= UIFactory.getElements("OTHER_DETAILS");
	final static UI_Elements	SUGGEST_BTN					= UIFactory.getElements("SUGGEST_BTN");
	final static UI_Elements	CANCEL_BTN					= UIFactory.getElements("CANCEL_BTN");

	String fillSupplierNameAtHeader(WebDriver driver, String testcaseName, String suppName) throws ActionBotException;

	String fillSupplierName(WebDriver driver, String testcaseName, String supplierName) throws ActionBotException;

	String fillLocation(WebDriver driver, String testcaseName, String location) throws ActionBotException;

	String fillContactPerson(WebDriver driver, String testcaseName, String contactPerson) throws ActionBotException;

	String fillEmail(WebDriver driver, String testcaseName, String emailAddress) throws ActionBotException;

	int fillPhoneNumber(WebDriver driver, String testcaseName, int phoneNumber) throws ActionBotException;

	String fillOtherDetails(WebDriver driver, String testcaseName, String otherDetails) throws ActionBotException;

	void toClickSuggestBtn(WebDriver driver, String testcaseName) throws ActionBotException;

	void toClickCancelBtn(WebDriver driver, String testcaseName) throws ActionBotException;

}
