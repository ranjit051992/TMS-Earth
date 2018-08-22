package com.zycus.automation.eproc.pageobjects.modals.PurchaseOrderSummaryDelivery;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalPOSummaryDeliveryImpl implements IModalPOSummaryDelivery
{

	@Override
	public void clickOnOtherAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_OTHER_ADDRESS_PO_SUMMARY);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on other address");

	}

	@Override
	public void clickOnOtherAddressTextBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TEXTBOX_OTHER_ADDRESS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Adress textbox");

	}

	@Override
	public String fillOtherAddress(WebDriver driver, String testCaseName, String address) throws ActionBotException, InterruptedException
	{
		String other_address = null;
		WebElement element = ActionBot.findElement(driver, TEXTBOX_OTHER_ADDRESS);
		element.clear();
		element.sendKeys(address);
		ActionBot.defaultSleep();
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		// String str = ActionBot.getTextWithInElement(driver,
		// TEXTBOX_OTHER_ADDRESS);
		other_address = element.getAttribute("value").trim();
		return other_address;
	}

	@Override
	public boolean isHeaderAddressSameAsAddressSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String changedAddress = ActionBot.findElement(driver, CHANGED_ADDRESS).getText();
		String headerAddress = ActionBot.findElement(driver, DELIVERY_ADDRESS_HEADER).getText();
		if (headerAddress.equalsIgnoreCase(changedAddress))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnClearReqByLink(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, MODAL_CLEAR_DELIVERY_DATE);

	}

	@Override
	public String fillRequiredByDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.click(driver, MODAL_DELIVERY_DATE);

		// month
		Select select = new Select(ActionBot.findElement(driver, SELECT_MONTH));
		select.selectByValue(month);

		// year
		select = new Select(ActionBot.findElement(driver, SELECT_YEAR));
		select.selectByValue(year);

		// day
		ActionBot.click(driver, By.linkText(day));

		String requiredByDate = ActionBot.findElement(driver, REQUIRED_BY_DATE).getAttribute("value").trim();
		ScreenShot.screenshot(driver, testCaseName, "After changing required by date");
		return requiredByDate;
	}

	@Override
	public String isEditableDeliveryField(WebDriver driver, String testCaseName, String DeliverTo) throws ActionBotException
	{
		ActionBot.clear(driver, DELIVER_TO);
		String deliverTo = null;
		if (ActionBot.isElementPresent(driver, DELIVER_TO))
		{
			WebElement ele = ActionBot.findElement(driver, DELIVER_TO);
			ele.clear();
			ele.sendKeys(DeliverTo);
			ActionBot.defaultSleep();
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);

			deliverTo = ActionBot.findElement(driver, DELIVER_TO).getText();
			ScreenShot.screenshot(driver, testCaseName, "After changing name");

		}
		return deliverTo;
	}

	@Override
	public void clickOnMyAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_MY_ADDRESS_PO_SUMMARY);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on my address");

	}

	@Override
	public String enterCityName(WebDriver driver, String testCaseName, String cityName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_CITY_PO_SUMMARY);
		ele.clear();
		ele.sendKeys(cityName);
		/*
		 * ActionBot.defaultSleep(); ele.sendKeys(Keys.ARROW_DOWN);
		 * ele.sendKeys(Keys.ENTER);
		 */
		String city = ele.getAttribute("value").trim();
		ScreenShot.screenshot(driver, testCaseName, "After entering name");

		return city;
	}

	@Override
	public String enterCountyName(WebDriver driver, String testCaseName, String countyName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_COUNTY_PO_SUMMARY);
		ele.clear();
		ele.sendKeys(countyName);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		String county = ele.getAttribute("value").trim();
		ScreenShot.screenshot(driver, testCaseName, "After entering county name");

		return county;
	}

	@Override
	public String enterFreeTextCountyName(WebDriver driver, String testCaseName, String freeTextCountyName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_COUNTY_PO_SUMMARY);
		ele.clear();
		ele.sendKeys(freeTextCountyName);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ENTER);
		String freeTextCounty = ele.getAttribute("value").trim();
		ScreenShot.screenshot(driver, testCaseName, "After changing name");

		return freeTextCounty;
	}

	@Override
	public void clickOnCreateNewAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String address = ActionBot.findElement(driver, LINK_CREATE_NEW_ADDRESS_PO_SUMMARY).getText();
		if (address.equalsIgnoreCase("Create new address"))
		{
			ActionBot.click(driver, LINK_CREATE_NEW_ADDRESS_PO_SUMMARY);

		}
		else
		{
			ActionBot.findElement(driver, TEXTBOX_CITY_PO_SUMMARY);
		}

	}

	@Override
	public String getChangedAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, CHANGED_ADDRESS);
		return str;
	}

	@Override
	public boolean isTaxexChangeConfirmationPopUpDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TAXES_NOT_APPLICABLE_POPUP_CONFIRM))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickONTaxChangeConfirmationYesBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CONFORMATION_YES_POPUP);

	}

	@Override
	public String getOUAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, OU_ADDRESS_DELIVERY_PO_SUMMARY);

	}

	@Override
	public void clickOnOUAdressCheckbox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DELIVERY_OUADDRESS_RADIO_BTM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on OU address checkbox");

	}

	@Override
	public String fillMyAddress(WebDriver driver, String testCaseName, String address) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, PO_MY_ADDRESS);
		ele.clear();
		ActionBot.defaultSleep();
		ele.sendKeys(address);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		String str = ele.getAttribute("value").trim();
		ScreenShot.screenshot(driver, testCaseName, "After filling my address");
		return str;

	}

	@Override
	public int selectCountryName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, NEW_ADDRESS_COUNTRY_NAME);
		Select sel = new Select(element);
		sel.selectByIndex(index);
		String country = ActionBot.findElement(driver, NEW_ADDRESS_COUNTRY_NAME).getAttribute("value");
		return index;

	}

	@Override
	public String fillNewAddressName(WebDriver driver, String testCaseName, String addressName) throws ActionBotException, InterruptedException
	{
		return ActionBot.sendKeys(driver, NEW_ADDRESS_NAME, addressName);

	}

	@Override
	public String fillNewAddressStreetName(WebDriver driver, String testCaseName, String addressStreetName) throws ActionBotException, InterruptedException
	{
		return ActionBot.sendKeys(driver, NEW_ADDRESS_STREET_NAME, addressStreetName);
	}

	@Override
	public int fillNewAddressPostalCode(WebDriver driver, String testCaseName, int zipcode) throws ActionBotException, InterruptedException
	{
		ActionBot.sendKeys(driver, NEW_ADDRESS_ZIP_CODE, "" + zipcode);
		return zipcode;

	}

	@Override
	public void clickOnCreateNewAddressLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CREATE_NEW_ADDRESS_PO_SUMMARY);

	}

	@Override
	public String getDeliverTo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.findElement(driver, DELIVER_TO);
		String str = ActionBot.getTextWithInElement(driver, DELIVER_TO);
		return str;
	}

	@Override
	public String fillDeliverTo(WebDriver driver, String testCaseName, String deliverTo) throws ActionBotException
	{
		return ActionBot.fillAutoCompleteField(driver, DELIVER_TO, deliverTo);
	}

}
