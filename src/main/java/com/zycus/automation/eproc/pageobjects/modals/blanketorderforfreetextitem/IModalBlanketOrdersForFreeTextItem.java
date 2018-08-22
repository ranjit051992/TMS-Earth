/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.blanketorderforfreetextitem;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalBlanketOrdersForFreeTextItem
{
	UI_Elements	TEXTBOX_BPO_NO						= UIFactory.getElements("TEXTBOX_BPO_NO");
	UI_Elements	TEXTBOX_BPO_NAME					= UIFactory.getElements("TEXTBOX_BPO_NAME");
	UI_Elements	TEXTBOX_BPO_CREATED_BY				= UIFactory.getElements("TEXTBOX_BPO_CREATED_BY");
	UI_Elements	RADIO_BUTTON_SELECT_BPO				= UIFactory.getElements("RADIO_BUTTON_SELECT_BPO");
	UI_Elements	LINK_FIRST_BPO_NO					= UIFactory.getElements("LINK_FIRST_BPO_NO");
	UI_Elements	BUTTON_SELECT_BPO					= UIFactory.getElements("BUTTON_SELECT_BPO");
	UI_Elements	BUTTON_CLOSE_BPO					= UIFactory.getElements("BUTTON_CLOSE_BPO");
	UI_Elements	LABEL_FIRST_BPO_NAME				= UIFactory.getElements("LABEL_FIRST_BPO_NAME");
	UI_Elements	LABEL_FIRST_CREATED_BY				= UIFactory.getElements("LABEL_FIRST_CREATED_BY");
	UI_Elements	TEXTBOX_BPO_PAGINATE				= UIFactory.getElements("TEXTBOX_BPO_PAGINATE");
	UI_Elements	LABEL_FILTER_COUNT_OF_RECORDS		= UIFactory.getElements("LABEL_FILTER_COUNT_OF_RECORDS");
	UI_Elements	ICON_BPO_LISTING_NEXT_PAGINATION	= UIFactory.getElements("ICON_BPO_LISTING_NEXT_PAGINATION");
	UI_Elements	COLUMN_BALANCE_AMOUNT				= UIFactory.getElements("COLUMN_BALANCE_AMOUNT");
	UI_Elements	SORT_VALID_UNTIL					= UIFactory.getElements("SORT_VALID_UNTIL");
	//added on 30th Jan
	UI_Elements	NO_RESULTS_TABLE					= UIFactory.getElements("NO_RESULTS_TABLE");
	UI_Elements	FILTER_VALID_UNTIL					= UIFactory.getElements("FILTER_VALID_UNTIL");
	UI_Elements	FILTER_VALID_UNTIL_FROM_DATE		= UIFactory.getElements("FILTER_VALID_UNTIL_FROM_DATE");
	UI_Elements	FILTER_VALID_UNTIL_TO_DATE			= UIFactory.getElements("FILTER_VALID_UNTIL_TO_DATE");
	UI_Elements	FILTER_UNTIL_POP_BOX				= UIFactory.getElements("FILTER_UNTIL_POP_BOX");
	UI_Elements	LABEL_CONTRACT_NUMBER				= UIFactory.getElements("LABEL_CONTRACT_NUMBER");

	public String fillBPONumber(WebDriver driver, String testCaseName, String BPONumber) throws ActionBotException;

	public String fillBPOName(WebDriver driver, String testCaseName, String BPOName) throws ActionBotException;

	public String fillCreatedByForBPO(WebDriver driver, String testCaseName, String createdBy) throws ActionBotException, Exception;

	public void selectFirstBPO(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstBPOLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectBPOButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseBPOButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstBPONo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstBPOName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstBPOCreatedBy(WebDriver driver, String testCaseName) throws ActionBotException;

	public int fillBPOPaginateValue(WebDriver driver, String testCaseName, int value) throws ActionBotException;

	public int getNoOfRecordsCount(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnNextPageOnBPOListing(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isBalanceAmountColumnPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isTextboxBPONoPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public int getNoOfBPOCount(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isValidUntilSortingPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNoResultsTablePresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isFromDateAndToDateFilterPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getContractNumber(WebDriver driver, String testCaseName) throws ActionBotException;
}
