/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.selectcompanypcard;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IModalSelectCompanyForPCardImpl implements IModalSelectCompanyForPCard
{
	static Logger logger = Logger.getLogger(IModalSelectCompanyForPCardImpl.class);

	@Override
	public void selectAllCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> listOfOUs = ActionBot.findElements(driver, CHECKBOX_SELECT_COMPANY);
		for (WebElement element : listOfOUs)
		{
			element.click();
		}
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After selecting Companies");
	}

	@Override
	public String selectCompany(WebDriver driver, String testCaseName, String company) throws ActionBotException
	{
		List<WebElement> listOfOUs = ActionBot.findElements(driver, CHECKBOX_SELECT_COMPANY);
		String selectedCompany = null;
		for (WebElement element : listOfOUs)
		{
			selectedCompany = element.findElement(By.xpath("ancestor::label")).getText().trim();
			if (selectedCompany.equalsIgnoreCase(company))
			{
				if (!element.isSelected())
				{
					element.click();
				}
				break;
			}
		}
		logger.info("Selected company : " + selectedCompany);
		return selectedCompany;
	}

	@Override
	public void clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Save Button");
		ActionBot.click(driver, BUTTON_SAVE_SELECTED_COMPANY);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Save Button");
	}

	@Override
	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Save Button");
		ActionBot.click(driver, BUTTON_CANCEL_SELECTED_COMPANY);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Cancel Button");
	}

}
