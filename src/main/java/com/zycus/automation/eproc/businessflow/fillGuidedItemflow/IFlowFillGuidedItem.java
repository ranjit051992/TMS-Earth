package com.zycus.automation.eproc.businessflow.fillGuidedItemflow;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.GuidedItemSuggestSupplier;
import com.zycus.automation.exception.ActionBotException;

public interface IFlowFillGuidedItem
{

	public GuidedItem fillGuidedItem(WebDriver driver, String testcaseName, GuidedItem guidedItem) throws Exception;

	public GuidedItem fillGuidedItemNAddToCart(WebDriver driver, String testcaseName, GuidedItem guidedItem) throws Exception;

	public void addGuidedItem(WebDriver driver, String testCaseName) throws ActionBotException;

	public GuidedItemSuggestSupplier fillSuggestedSupplier(WebDriver driver, String testCaseName, GuidedItemSuggestSupplier suggestSupp, String supplierType)
		throws ActionBotException;

	public boolean fillExtraFields(WebDriver driver, String testCaseName, GuidedItem guidedItem);

	public boolean fillExtraFieldsWithScriptedInput(WebDriver driver, String testCaseName, GuidedItem guidedItem);

}
