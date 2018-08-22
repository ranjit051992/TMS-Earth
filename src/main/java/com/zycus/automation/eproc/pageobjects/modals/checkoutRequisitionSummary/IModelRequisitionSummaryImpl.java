package com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModelRequisitionSummaryImpl implements IModelRequisitionSummary
{

	@Override
	public boolean checkSaveAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		ActionBot.click(driver, DELIVERY_CLEAR_DATE);
		ScreenShot.screenshot(driver, testCaseName, "Cleared Date");
	}

	@Override
	public void clickCancleReqSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, CANCLEREQSUMMARY);
		ScreenShot.screenshot(driver, testCaseName, "Cancle Requisition Summary");

	}

	@Override
	public void clickDeliveryCreateNewAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, DELIVERY_MY_ADDRESS_CREATE_NEW);
		ScreenShot.screenshot(driver, testCaseName, "Create new Delivery My Address");

	}

	@Override
	public void clickMultiAddCostCenter(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, By.xpath(".//*[@id='entity_costing_" + index + "']//*/a[@class='icon add']"));
		ScreenShot.screenshot(driver, testCaseName, "After click to add new cost center to split");
	}

	@Override
	public void clickMultiDeleteCostCenter(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, By.xpath(".//*[@id='entity_costing_" + index + "']//*/a[@class='icon remove']"));
		ScreenShot.screenshot(driver, testCaseName, "After click to delete cost center of split");
	}

	@Override
	public void clickSaveReqSummary(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, SAVEREQSUMMARY);
		ScreenShot.screenshot(driver, testCaseName, "Save Requisition Summary");

	}

	@Override
	public String fillBillingBU(WebDriver driver, String testCaseName, String billingBU) throws ActionBotException
	{
		// TODO Auto-generated method stub
		WebElement ele = ActionBot.findElement(driver, BILLING_BU);
		ele.clear();
		ele.sendKeys(billingBU);
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
	public String fillBillingCompany(WebDriver driver, String testCaseName, String billingCompany) throws ActionBotException
	{
		// TODO Auto-generated method stub
		WebElement ele = ActionBot.findElement(driver, BILLING_COMPANY);
		ele.clear();
		ele.sendKeys(billingCompany);
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
	public String fillBillingCurrency(WebDriver driver, String testCaseName, String billingCurrency) throws ActionBotException
	{
		// TODO Auto-generated method stub
		WebElement ele = ActionBot.findElement(driver, BILLING_CURRENCY);
		ele.clear();
		ele.sendKeys(billingCurrency);
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
	public String fillBillingLocation(WebDriver driver, String testCaseName, String billingLocation) throws ActionBotException
	{
		// TODO Auto-generated method stub
		WebElement ele = ActionBot.findElement(driver, BILLING_LOCATION);
		ele.clear();
		ele.sendKeys(billingLocation);
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
	public String fillCostBookingSingleBudget(WebDriver driver, String testCaseName, String costBookingSingleBudget) throws ActionBotException
	{
		// TODO Auto-generated method stub
		WebElement ele = ActionBot.findElement(driver, COSTBOOKING_SINGLE_BUDGET);
		ele.clear();
		ele.sendKeys(costBookingSingleBudget);
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
	public String fillCostBookingSingleCC(WebDriver driver, String testCaseName, String costBookingSingleCC) throws ActionBotException
	{
		// TODO Auto-generated method stub
		WebElement ele = ActionBot.findElement(driver, COSTBOOKING_SINGLE_CC);
		ele.clear();
		ele.sendKeys(costBookingSingleCC);
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
	public String fillDeliveryDeliverTo(WebDriver driver, String testCaseName, String deliveryDeliverTo) throws ActionBotException
	{
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		WebElement ele = ActionBot.findElement(driver, DELIVERY_MY_ADDRESS);
		ele.clear();
		ele.sendKeys(deliveryMyAddress);
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
		// TODO Auto-generated method stub

		WebElement ele = ActionBot.findElement(driver, DELIVERY_MY_ADDRESS_CITY);
		ele.clear();
		ele.sendKeys(newAddressCity);
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
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
	public String fillDeliveryNewAddressZip(WebDriver driver, String testCaseName, String newAddressZip) throws ActionBotException
	{
		// TODO Auto-generated method stub
		WebElement ele = ActionBot.findElement(driver, DELIVERY_MY_ADDRESS_ZIP);
		ele.clear();
		ele.sendKeys(newAddressZip);
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
	public String fillDeliveryOtherAddress(WebDriver driver, String testCaseName, String deliveryOtherAddress) throws ActionBotException
	{
		// TODO Auto-generated method stub
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
	public String fillMultiCostCenterBudget(WebDriver driver, String testCaseName, String multiCostCenterBudget, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='entity_costing_budget_" + index + "']"));
		ele.clear();
		ele.sendKeys(multiCostCenterBudget);
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
	public String fillMultiCostCenterName(WebDriver driver, String testCaseName, String multiCostCenterName, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='entity_costing_costCenter_" + index + "']"));
		ele.clear();
		ele.sendKeys(multiCostCenterName);
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
	public String fillMultiCostCenterPercent(WebDriver driver, String testCaseName, String multiCostCenterPercent, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='entity_costing_percentage_" + index + "']"));
		ele.clear();
		ele.sendKeys(multiCostCenterPercent);
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
	public String getBillToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		String billToAddress = ActionBot.findElement(driver, BILLING_BILL_TO_ADDRESS).getText();
		if (billToAddress != null)
		{
			return billToAddress;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getCostBookingItemLevelCCAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		String cca = ActionBot.findElement(driver, COSTBOOKING_ITEMLEVEL_CC_AMOUNT).getText();
		if (cca != null)
		{
			return cca;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getCostBookingItemLevelCCBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		String str = ActionBot.findElement(driver, COSTBOOKING_ITEMLEVEL_CC_BUDGET).getText();
		if (str != null)
		{
			return str;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getCostBookingItemLevelCCName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		String cc = ActionBot.findElement(driver, COSTBOOKING_ITEMLEVEL_CC_NAME).getText();
		if (cc != null)
		{
			return cc;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getCostBookingMultiCostCenterAmount(WebDriver driver, String testCaseName, String multiCostCenterAmount, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		WebElement ele = ActionBot.findElement(driver, By.xpath(".//*[@id='entity_costing_price_" + index + "']"));
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
	public String getCostBookingTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		String ccTotalAmt = ActionBot.findElement(driver, COSTBOOKING_TOTAL_AMOUNT).getText();
		if (ccTotalAmt != null)
		{
			return ccTotalAmt;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getdeliveryDeliverTo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
	public String getSendToAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		String sendToAddress = ActionBot.findElement(driver, BILLING_SEND_TO_ADDRESS).getText();
		if (sendToAddress != null)
		{
			return sendToAddress;
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean selectCostBookingOptionLineItemCC(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, COSTBOOKING_OPTION_LINEITEM_CC);
		if (ActionBot.findElement(driver, COSTBOOKING_OPTION_LINEITEM_CC).isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean selectCostBookingOptionMultipleCC(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, COSTBOOKING_OPTION_MULTIPLE_CC);
		if (ActionBot.findElement(driver, COSTBOOKING_OPTION_MULTIPLE_CC).isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean selectCostBookingOptionSingleCC(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, COSTBOOKING_OPTION_SINGLE_CC);
		if (ActionBot.findElement(driver, COSTBOOKING_OPTION_SINGLE_CC).isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean selectDeliveryMyAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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

}
