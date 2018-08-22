package com.zycus.automation.eproc.pageobjects.pages.procurementcontracts;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.FactoryPage;

public class PageProcurementContracts
{
	public static List<String> getListOfContracts(WebDriver driver, String testCaseName)
	{
		try
		{
			IPageProcurementContracts procurementContracts = FactoryPage.getInstanceOf(IPageProcurementContractsImpl.class);
			return procurementContracts.getListOfContracts(driver, testCaseName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
