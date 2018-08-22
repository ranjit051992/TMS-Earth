/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author amitkumar.dash
 *
 */
public class IPagePurchaseOrderStatusFiltersUtil
{
	protected static boolean isFilterSelected(WebDriver driver, UI_Elements ui_Elements) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, ui_Elements);

		if (element.isSelected())
		{
			return true;
		}
		else
		{
			element.click();
			return true;
		}

	}
}
