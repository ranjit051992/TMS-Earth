package com.zycus.automation.eproc.pageobjects.pages.procurementcontracts;

import java.util.List;

import org.openqa.selenium.WebDriver;

public interface IPageProcurementContracts
{
	public List<String> getListOfContracts(WebDriver driver, String testCaseName);
}
