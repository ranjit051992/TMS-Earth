package com.zycus.automation.eproc.pageobjects.modals.BuyersRequisitionSummaryDelivery;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryDelivery.IModelRequisitionSummaryDelivery;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModelBuyersDeskRequisitionSummaryDeliveryImpl implements IModelRequisitionSummaryDelivery
{

	static Logger logger = Logger.getLogger(IModelBuyersDeskRequisitionSummaryDeliveryImpl.class);

	@Override
	public boolean checkSaveAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DELIVERY_MY_ADDRESS_SAVE_ADD);
		if (ActionBot.findElement(driver, DELIVERY_MY_ADDRESS_SAVE_ADD).isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clearDeliveryRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, DELIVERY_CLEAR_DATE);
		ScreenShot.screenshot(driver, testCaseName, "Cleared Date");

	}

	@Override
	public void clickDeliveryCreateNewAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, DELIVERY_MY_ADDRESS_CREATE_NEW);
		ScreenShot.screenshot(driver, testCaseName, "Create new Delivery My Address");
	}

	@Override
	public String fillDeliveryDeliverTo(WebDriver driver, String testCaseName, String deliveryDeliverTo) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, DELIVERY_DELIVER_TO);
		ele.clear();
		ele.sendKeys(deliveryDeliverTo);
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);

		if (ele.getAttribute("value") != null)
		{
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillDeliveryMyAddress(WebDriver driver, String testCaseName, String deliveryMyAddress) throws ActionBotException
	{
		ActionBot.defaultSleep();
		WebElement ele = ActionBot.findElement(driver, DELIVERY_MY_ADDRESS);
		ele.clear();
		ele.sendKeys(deliveryMyAddress);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);

		if (ele.getAttribute("value") != null)
		{
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillDeliveryNewAddressCity(WebDriver driver, String testCaseName, String newAddressCity) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, DELIVERY_MY_ADDRESS_CITY);
		ele.clear();
		ele.sendKeys(newAddressCity);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);

		if (ele.getAttribute("value") != null)
		{
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillDeliveryNewAddressCountry(WebDriver driver, String testCaseName, String newAddressCountry) throws ActionBotException
	{
		Select sel = new Select(ActionBot.findElement(driver, DELIVERY_MY_ADDRESS_COUNTRY));
		sel.selectByVisibleText(newAddressCountry);
		String str = sel.getFirstSelectedOption().getAttribute("value").trim();
		if (str != null)
		{
			ScreenShot.screenshot(driver, testCaseName, "Select Country");
			return str;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillDeliveryNewAddressCounty(WebDriver driver, String testCaseName, String newAddressCounty) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, DELIVERY_MY_ADDRESS_COUNTY);
		ele.clear();
		ele.sendKeys(newAddressCounty);
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);

		if (ele.getAttribute("value") != null)
		{
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillDeliveryNewAddressName(WebDriver driver, String testCaseName, String newAddressName) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, DELIVERY_MY_ADDRESS_NAME);
		ele.clear();
		ele.sendKeys(newAddressName);
		if (ele.getAttribute("value") != null)
		{
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillDeliveryNewAddressState(WebDriver driver, String testCaseName, String newAddressState) throws ActionBotException
	{

		Select sel = new Select(ActionBot.findElement(driver, DELIVERY_MY_ADDRESS_STATE));
		sel.selectByVisibleText(newAddressState);
		String str = sel.getFirstSelectedOption().getAttribute("value").trim();
		if (str != null)
		{
			ScreenShot.screenshot(driver, testCaseName, "Select State");
			return str;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillDeliveryNewAddressStreet1(WebDriver driver, String testCaseName, String newAddressStreet1) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, DELIVERY_MY_ADDRESS_STREET1);
		ele.clear();
		ele.sendKeys(newAddressStreet1);
		if (ele.getAttribute("value") != null)
		{
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
	}

	@Override
	public String fillDeliveryNewAddressStreet2(WebDriver driver, String testCaseName, String newAddressStreet2) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, DELIVERY_MY_ADDRESS_STREET2);
		ele.clear();
		ele.sendKeys(newAddressStreet2);
		if (ele.getAttribute("value") != null)
		{
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
	}

	@Override
	public int fillDeliveryNewAddressZip(WebDriver driver, String testCaseName, int newAddressZip) throws ActionBotException
	{
		String zip;
		WebElement ele = ActionBot.findElement(driver, DELIVERY_MY_ADDRESS_ZIP);
		ele.clear();
		ele.sendKeys(Integer.toString(newAddressZip));
		zip = ele.getAttribute("value").trim();
		return Integer.parseInt(zip);
	}

	@Override
	public String fillDeliveryOtherAddress(WebDriver driver, String testCaseName, String deliveryOtherAddress) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, DELIVERY_OTHER_ADDRESS);
		ele.clear();
		ele.sendKeys(deliveryOtherAddress);
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);

		if (ele.getAttribute("value") != null)
		{
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getdeliveryDeliverTo(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String deliveryDeliverTo = ActionBot.findElement(driver, DELIVERY_DELIVER_TO).getAttribute("value");
		if (deliveryDeliverTo != null)
		{
			return deliveryDeliverTo;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getDeliveryOtherAddressesReflectedAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, DELIVERY_REFLECTED_OTHER_ADDRESS);
		if (ele.getText() != null)
		{
			return ele.getText();
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getDeliveryOUAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, DELIVERY_OU_ADDRESS);
		if (ele.getText() != null)
		{
			return ele.getText();
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getDeliveryRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException
	{

		WebElement ele = ActionBot.findElement(driver, DELIVERY_REQUIRED_BY);
		if (ele.getText() != null)
		{
			return ele.getText();
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean selectDeliveryMyAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DELIVERY_OPTION_MY_ADDRESSES);
		if (ActionBot.findElement(driver, DELIVERY_OPTION_MY_ADDRESSES).isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean selectDeliveryOtherAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DELIVERY_OPTION_OTHER_ADDRESSES);
		if (ActionBot.findElement(driver, DELIVERY_OPTION_OTHER_ADDRESSES).isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean selectDeliveryOUAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DELIVERY_OPTION_OU_ADDRESS);
		if (ActionBot.findElement(driver, DELIVERY_OPTION_OU_ADDRESS).isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String selectRequiredByDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{

		ActionBot.click(driver, DELIVERY_REQUIRED_BY_DATE_PICKER);

		// month
		Select select = new Select(ActionBot.findElement(driver, SELECT_DELIVERY_MONTH));
		select.selectByValue(month);

		// year
		select = new Select(ActionBot.findElement(driver, SELECT_DELIVERY_YEAR));
		select.selectByValue(year);

		// day
		ActionBot.click(driver, By.linkText(day));

		String requiredByDate = ActionBot.findElement(driver, DELIVERY_REQUIRED_BY_DATE).getAttribute("value").trim();
		logger.info("Selected Required By Date : " + requiredByDate);
		ScreenShot.screenshot(driver, testCaseName, "After changing required by date");

		return requiredByDate;
	}

	@Override
	public String getRequiredByDate(WebDriver driver, String testCaseName) throws ActionBotException
	{

		String requiredByDate = ActionBot.findElement(driver, DELIVERY_REQUIRED_BY_DATE).getAttribute("value").trim();
		logger.info("Selected Required By Date : " + requiredByDate);
		ScreenShot.screenshot(driver, testCaseName, "Selected required by date");

		return requiredByDate;
	}

	@Override
	public boolean isDeliveryMyAddressTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return false;
	}

}
