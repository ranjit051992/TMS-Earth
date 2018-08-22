package com.zycus.automation.eproc.pageobjects.modals.myrequisitionstatusfilters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class IModalMyRequisitionStatusFiltersUtil
{
	protected static boolean isFilterSelected(WebDriver driver, UI_Elements ui_Elements) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, ui_Elements);
		element.click();
		if (element.isSelected())
		{
			return true;
		}
		return false;
	}
}
