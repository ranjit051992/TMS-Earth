/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.showallpos;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalShowAllPosImpl implements IModalShowAllPos
{
	static Logger logger = Logger.getLogger(IModalShowAllPosImpl.class);

	@Override
	public String fillPonoShowAllpo(WebDriver driver, String testCaseName, String searchpono) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, MODAL_SHOW_ALL_PO_SEARCH_PO_NO);
		element.clear();
		element.sendKeys(searchpono);
		element.sendKeys(Keys.RETURN);
		String poNo = element.getAttribute("value");
		logger.info("Entered PO No : " + poNo);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultMediumSleep();
		return poNo;
	}

	@Override
	public void clickOnSelectPoBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Select PO Button");
		ActionBot.click(driver, MODAL_SHOW_ALL_POS_SELECT_BTN);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Select PO Button");
	}

	@Override
	public void clickOnHeaderPoNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, MODAL_SHOW_ALL_PO_NO_HEADER);
	}

	@Override
	public void clickOnPoNoRadioBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, MODAL_SHOW_ALL_PO_NO_RADIO_BTN);
	}

	@Override
	public boolean isPoTypeHeaderPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, HEADER_PO_TYPE_SHOW_ALL_POS);
	}

	@Override
	public boolean isPoTypeLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABEL_PO_TYPE_SHOW_ALL_POS);
	}

	@Override
	public boolean isSupplierTextBoxPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, TEXTBOX_SUPPLIER_SHOW_ALL_POS);
	}

	@Override
	public boolean isSupplierLabelPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, LABEL_SUPPLIER_SHOW_ALL_POS);
	}

	@Override
	public String getFirstPOType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String poType = ActionBot.getTextWithInElement(driver, LABEL_PO_TYPE_SHOW_ALL_POS);
		logger.info("PO Type : " + poType);
		return poType;
	}

	@Override
	public String getFirstSupplierName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String supplierName = ActionBot.getTextWithInElement(driver, LABEL_SUPPLIER_SHOW_ALL_POS);
		logger.info("Supplier Name : " + supplierName);
		return supplierName;
	}

	@Override
	public void clickOnCloseShowAllPOs(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CLOSE_SHOW_ALL_POS);
	}

	@Override
	public void clickOnFirstPoNoRadioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, MODAL_SHOW_ALL_PO_NO_FIRST_RADIO_BUTTON);

	}

	@Override
	public String fillSupplierNameShowAllpo(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, TEXTBOX_SUPPLIER_SHOW_ALL_POS);
		element.clear();
		ActionBot.defaultSleep();
		element.sendKeys(supplierName);
		ActionBot.defaultSleep();
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.ENTER);
		String suppliername = element.getAttribute("value");
		logger.info("Entered supplier name : " + suppliername);
		ActionBot.waitForPageLoad(driver);
		return suppliername;
	}

	@Override
	public String getFirstPONumber(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, FIRST_PO_NO_LINK))
		{
			return ActionBot.getTextWithInElement(driver, FIRST_PO_NO_LINK);
		}
		return null;
	}

}
