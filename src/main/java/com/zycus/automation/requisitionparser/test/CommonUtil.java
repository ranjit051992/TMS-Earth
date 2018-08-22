package com.zycus.automation.requisitionparser.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.framework.dom_parser.framework.Parser;

public class CommonUtil
{

	public static void parseHTMLContent(String fileName, WebDriver driver, Parser parser) throws Exception
	{
		WebElement element = driver.findElement(By.xpath(".//*"));
		String htmlContent = element.getAttribute("outerHTML");
		parser.parseHtmlContent(fileName, htmlContent);
	}

	public static void parseElementsNotFoundOnPage(String fileName, WebDriver driver, Parser parser) throws Exception
	{
		String htmlContent = driver.getPageSource();
		parser.updateStatusOfElementNotFoundOnSamePage(fileName, htmlContent);
	}

}
