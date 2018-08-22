package com.zycus.framework.dom_parser.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtil
{

	public static boolean parseHTMLContent(UI_Elements ui_Elements, WebDriver driver, Parser parser) throws Exception
	{
		WebElement element = driver.findElement(By.xpath(".//*"));
		String htmlContent = element.getAttribute("outerHTML");
		return parser.parseHtmlContent(ui_Elements, htmlContent);
	}

}
