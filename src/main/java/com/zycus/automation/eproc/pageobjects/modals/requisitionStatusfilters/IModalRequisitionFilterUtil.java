package com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class IModalRequisitionFilterUtil
{
	protected static boolean isFilterSelected(WebDriver driver, UI_Elements ui_Elements) throws ActionBotException
	{
		WebElement readyForApprovalFilter = ActionBot.findElement(driver, ui_Elements);
		readyForApprovalFilter.click();
		if (readyForApprovalFilter.isSelected())
		{
			return true;
		}
		return false;
	}
}
