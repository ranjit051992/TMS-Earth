/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.invitesuppliers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageInviteSuppliersImpl implements IPageInviteSuppliers
{
	static Logger logger = Logger.getLogger(IPageInviteSuppliersImpl.class);

	@Override
	public void clickOnSendInvitationLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SEND_INVITATIONS);
		ActionBot.findElement(driver, RADIO_BUTTON_SEND_ALL_SUPPLIERS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on send invitation link");
	}

	@Override
	public void clickOnSelectAllSuppliers(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_SEND_ALL_SUPPLIERS);
	}

	@Override
	public void clickOnSelectedSuppliers(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_SELECTED_SUPPLIERS);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
	}

	@Override
	public void selectSearchSuppliersBy(WebDriver driver, String testCaseName, String searchSuppliersBy) throws ActionBotException
	{
		ActionBot.selectElement(driver, SELECT_SEARCH_SUPPLIERS_BY, IConstantsData.SELECT_BY_VALUE, searchSuppliersBy);
	}

	@Override
	public void fillSearchSuppliers(WebDriver driver, String testCaseName, String searchSuppliers) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_SEARCH_SUPPLIER, searchSuppliers);
	}

	@Override
	public void clickOnSearchSuppliersGoButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SEARCH_SUPPLIER_GO);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After searching supplier");
	}

	@Override
	public String getFirstSearchedSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String searchedSupplierName = ActionBot.getTextWithInElement(driver, LINK_FIRST_SEARCHED_SUPPLIER_NAME);
		logger.info("Searched Supplier Name : " + searchedSupplierName);
		return searchedSupplierName;
	}

	@Override
	public String getFirstSupplierOfferedProductsAndServices(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String searchedSupplierProducts = ActionBot.getTextWithInElement(driver, LABEL_OFFERED_PRODUCTS_SERVICES_BY_SUPPLIER);
		logger.info("Supplier offered products and services : " + searchedSupplierProducts);
		return searchedSupplierProducts;
	}

	@Override
	public void selectFirstSearchedSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_SELECT_SUPPLIER);
	}

	@Override
	public void clickOnSaveAndContinue(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on save and continue supplier invitations");
		ActionBot.click(driver, BUTTON_SAVE_AND_CONTINUE_SUPPLIER_INVITATIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save and continue supplier invitations");
	}

	@Override
	public String getInvitationTemplateText(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String invitationTemplateMsg = ActionBot.getTextWithInElement(driver, TEXTBOX_EMAIL_BODY);
		logger.info("Invitation template message : " + invitationTemplateMsg);
		return invitationTemplateMsg;
	}

	@Override
	public void clickOnSaveChangesToInvitationTemplate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBO_SAVE_CHANGES_TO_INVITATION_TEMPLATE);
	}

	@Override
	public void clickOnNextButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on next button");
		ActionBot.click(driver, BUTTON_NEXT_INVITE_SUPPLIER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on next button");
	}

	@Override
	public void clickOnBackButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on back button");
		ActionBot.click(driver, BUTTON_BACK_INVITE_SUPPLIER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on back button");
	}

	@Override
	public void clickOnSendInvitationButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on send invitation button");
		ActionBot.click(driver, BUTTON_SEND_INVITATION);
		waitTillSendInvitationProgressingDivPresent(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on send invitation button");
	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancel invitation button");
		ActionBot.click(driver, BUTTON_CANCEL_SUPPLIER_INVITATIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel invitation button");
	}

	@Override
	public void waitTillSendInvitationProgressingDivPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitTillPopUpIsPresent(driver, PROCESSING_DIV_SENDING_SUPPLIER_INVITATIONS);
	}

}
