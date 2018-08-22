package com.zycus.automation.eproc.pageobjects.modals.forkingCommentsForSupplier;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModelCommentsForSupplier
{
	final static UI_Elements	FORKING_SAVE_SUPPLIER_COMMENT	= UIFactory.getElements("FORKING_SAVE_SUPPLIER_COMMENT");
	final static UI_Elements	FORKING_CANCLE_SUPPLIER_COMMENT	= UIFactory.getElements("FORKING_CANCLE_SUPPLIER_COMMENT");
	final static UI_Elements	FORKINH_SUPPLIER_COMMENT_TEXT	= UIFactory.getElements("FORKINH_SUPPLIER_COMMENT_TEXT");

	void clickCancleCommentsForSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickSaveCommentsForSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	String provideCommentsForSupplier(WebDriver driver, String testCaseName, String supplierComment) throws ActionBotException;
}
