/**
 * 
 *//*
package com.zycus.automation.eproc.businessflow.icontractflow;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Icontract.DataBin.ContractDetails;
import com.Icontract.DataBin.ContractingParty;
import com.Icontract.Page.ContractSummaryPage;
import com.zycus.Commons.Pages.Page;
import com.zycus.Framework.WebDriverWrapper;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

*//**
 * @author ankita.sawant
 *
 *//*
public class FlowIContract extends Page
{
	static Logger logger = Logger.getLogger(FlowIContract.class);

	public FlowIContract(WebDriver driver, String pageName, Logger logger)
	{
		super(driver, pageName, logger);
	}

	public void clickOnContractType(WebDriver driver, String testCaseName, String contractType) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("//*[@id='subTypeSelector']//a[contains(text(),'" + contractType + "')]"));
	}

	public void clickOnContinueButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("//input[@value='Continue']"));
	}

	public void selectContractType(WebDriver driver, String testCaseName, ContractDetails contractDetails) throws ActionBotException
	{
		clickOnContractType(driver, testCaseName, contractDetails.getContractType());
		clickOnContinueButton(driver, testCaseName);
	}

	*//**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Add contracting party <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param contractDetails </font><b><br>
	 * @throws ActionBotException </b> <br>
	 *//*
	public void addContractingParty(WebDriver driver, String testCaseName, ContractDetails contractDetails) throws ActionBotException
	{
		boolean bool = contractDetails.isRepo();

		WebDriverWrapper.explicitWait(1);
		List<ContractingParty> contractingParties = contractDetails.getContractingPartyList();
		new ContractSummaryPage(driver);

		for (ContractingParty contractingParty : contractingParties)
		{
			selectContractingParty(driver, testCaseName);

			if (bool)
			{
				// this.loaderComponent.waitForLoadersToDisappear(addcontractingParty());
				ActionBot.waitForPageLoad(driver);
				ActionBot.defaultSleep();
				ActionBot.click(driver, By.xpath("//label[text()='+ ADD']"));
			}
			else
			{
				// this.loaderComponent.waitForLoadersToDisappear(addcontractingPartyForAuthour());
				ActionBot.click(driver, By.xpath("//label[text()='+ Add']"));
			}
			ActionBot.waitForPageLoad(driver);
			ActionBot.waitTillPopUpIsPresent(driver, By.xpath(".//*[@id='vendor-grid-div']/div[4]/div"));
			ScreenShot.screenshot(driver, testCaseName, "After clicking on Add button");
			addContractingPartyAndContactName(driver, testCaseName, contractingParty.getContractingPartyName(), bool);
		}

		driver.navigate().refresh();
		WebDriverWrapper.explicitWait(2);
	}

	*//**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Select contracting party <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 *//*
	private void selectContractingParty(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebDriverWrapper.explicitWait(1);
		// this.loaderComponent.waitForLoadersToDisappear();
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ActionBot.click(driver, By.xpath("//li[@id='contractingParty']"));
		ActionBot.waitForElementToBePresent(driver, By.xpath("//li[@id='contractingParty' and contains(@class,'selected')]"));
		ScreenShot.screenshot(driver, testCaseName, "After selecting contracting party");
	}

	*//**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Add contracting party and contact name
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param string </font><b><br>
	 * @param bool </font><b><br>
	 * @throws ActionBotException </b> <br>
	 *//*
	private void addContractingPartyAndContactName(WebDriver driver, String testCaseName, String string, boolean bool) throws ActionBotException
	{
		ActionBot.sendKeys(driver, By.id("vendorSearchValue"), string);
		// this.loaderComponent.waitForLoadersToDisappear();
		ActionBot.waitForPageLoad(driver);
		ActionBot.waitTillPopUpIsPresent(driver, By.xpath(".//*[@id='vendor-grid-div']/div[4]/div"));
		WebDriverWrapper.explicitWait(1);
		ActionBot.click(driver, By.id("goButton"));
		WebDriverWrapper.explicitWait(3);
		ActionBot.waitForPageLoad(driver);
		ActionBot.waitTillPopUpIsPresent(driver, By.xpath(".//*[@id='vendor-grid-div']/div[4]/div"));
		// this.loaderComponent.waitForLoadersToDisappear(selectVendorByVendorName(string));
		WebDriverWrapper.explicitWait(3);

		WebDriverWrapper.explicitWait(2);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ActionBot.waitTillPopUpIsPresent(driver, By.xpath(".//*[@id='vendor-grid-div']/div[4]/div"));
		// this.loaderComponent.waitForLoadersToDisappear();
		ScreenShot.screenshot(driver, testCaseName, "After selecting contracting party");
		WebElement element;
		if (bool)
		{
			element = doneButton(driver);
		}
		else
		{
			element = doneButtonForExternal(driver);
		}
		ActionBot.click(driver, element);
		// pageElement.setWaitType(WaitType.WAITFORELEMENTTODISAPPEAR);
		// waitForPageElement(pageElement);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ActionBot.waitTillPopUpIsPresent(driver, By.xpath(".//*[@id='vendor-grid-div']/div[4]/div"));
		ScreenShot.screenshot(driver, testCaseName, "After adding contracting party");
	}

	private WebElement doneButton(WebDriver driver) throws ActionBotException
	{
		return ActionBot.findElement(driver, By.id("contractingPartySaveButton"));
	}

	private WebElement doneButtonForExternal(WebDriver driver) throws ActionBotException
	{
		return ActionBot.findElement(driver, By.xpath("//div[@id='contractingPartyButtons']/input[@value='Save']"));
	}
}
*/