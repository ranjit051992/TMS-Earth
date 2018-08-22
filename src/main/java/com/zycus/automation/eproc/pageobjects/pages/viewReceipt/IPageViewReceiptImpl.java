package com.zycus.automation.eproc.pageobjects.pages.viewReceipt;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.createreturnnote.IPageCreateReturnNoteImpl;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class IPageViewReceiptImpl implements IPageViewReceipt
{
	static Logger logger = Logger.getLogger(IPageCreateReturnNoteImpl.class);

	@Override
	public String getShippedViaLabel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String str = ActionBot.getTextWithInElement(driver, LABEL_SHIPPED_VIA_TEXT);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After getting shipped via text");
		return str;
	}

	@Override
	public String getItemInfoByHeaderName(WebDriver driver, String testCaseName, UI_Elements ui_Elements, String headerName, int itemSrNo) throws ActionBotException
	{
		int headerIndex = 1;
		List<String> headers = ActionBot.getListOfText(driver, By.xpath(ui_Elements.getValue() + "//th"));
		for (String header : headers)
		{
			if (header.toLowerCase().contains(headerName.toLowerCase()))
			{
				break;
			}
			else
				headerIndex++;

		}
		if (headerIndex <= headers.size())
		{
			String headerValue = ActionBot.getTextWithInElement(driver, By.xpath(ui_Elements.getValue() + "//tr[" + itemSrNo + "]/td[" + headerIndex + "]"));
			logger.info(headerName + " Value for item " + itemSrNo + " is" + headerValue);
			return headerValue;
		}
		return null;
	}

}
