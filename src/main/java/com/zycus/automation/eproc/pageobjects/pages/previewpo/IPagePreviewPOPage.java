/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.previewpo;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPagePreviewPOPage
{
	static UI_Elements	LABEL_PREVIEW_PO_NO					= UIFactory.getElements("LABEL_PREVIEW_PO_NO");
	static UI_Elements	LABEL_GROSS_TOTAL_PREVIEW_PO		= UIFactory.getElements("LABEL_GROSS_TOTAL_PREVIEW_PO");
	static UI_Elements	LABEL_SUPPLIER_NAME_PREVIEW_PO		= UIFactory.getElements("LABEL_SUPPLIER_NAME_PREVIEW_PO");
	static UI_Elements	LABEL_BILL_TO_ADDRESS_PREVIEW_PO	= UIFactory.getElements("LABEL_BILL_TO_ADDRESS_PREVIEW_PO");
	static UI_Elements	LABEL_SHIP_TO_ADDRESS_PREVIEW_PO	= UIFactory.getElements("LABEL_SHIP_TO_ADDRESS_PREVIEW_PO");
	static UI_Elements	LABEL_BUYER_PREVIEW_PO				= UIFactory.getElements("LABEL_BUYER_PREVIEW_PO");
	static UI_Elements	LABEL_CBL_DETAILS_PREVIEW_PO		= UIFactory.getElements("LABEL_CBL_DETAILS_PREVIEW_PO");
	static UI_Elements	LABEL_ITEM_NAME_PREVIEW_PO			= UIFactory.getElements("LABEL_ITEM_NAME_PREVIEW_PO");
	static UI_Elements	LABEL_QUANTITY_PREVIEW_PO			= UIFactory.getElements("LABEL_QUANTITY_PREVIEW_PO");
	static UI_Elements	LABEL_UNIT_PRICE_PREVIEW_PO			= UIFactory.getElements("LABEL_UNIT_PRICE_PREVIEW_PO");
	static UI_Elements	LABEL_TAXES_TOTAL_PREVIEW_PO		= UIFactory.getElements("LABEL_TAXES_TOTAL_PREVIEW_PO");

	public String getPreviewGrossTotal(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPreviewPoNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPreviewPoSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPreviewPoBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPreviewPoShipToAddress(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPreviewPoBuyerName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPreviewPoCBLDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPreviewPoItemName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPreviewPoQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPreviewPoUnitPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPreviewPoTaxesTotal(WebDriver driver, String testCaseName) throws ActionBotException;

}
