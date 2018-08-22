package com.zycus.automation.eproc.pageobjects.pages.adminMonitoringActivity;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.bo.AdminMonitoring;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class PageAdminMonitoringActivity
{
	static Logger				logger						= Logger.getLogger(PageAdminMonitoringActivity.class);

	final static UI_Elements	LINK_CLEAR_CACHE			= UIFactory.getElements("LINK_CLEAR_CACHE");
	final static UI_Elements	LINK_MONITOR_ACTIVEMQ		= UIFactory.getElements("LINK_MONITOR_ACTIVEMQ");
	final static UI_Elements	LINK_CURRENT_SESSION		= UIFactory.getElements("LINK_CURRENT_SESSION");
	final static UI_Elements	LINK_PHP_CONFIG_INFO		= UIFactory.getElements("LINK_PHP_CONFIG_INFO");
	final static UI_Elements	LINK_APPROVALS				= UIFactory.getElements("LINK_APPROVALS");
	final static UI_Elements	LINK_EVENTS					= UIFactory.getElements("LINK_EVENTS");
	final static UI_Elements	LINK_UNDER_MAINTAINANCE		= UIFactory.getElements("LINK_UNDER_MAINTAINANCE");
	final static UI_Elements	LINK_UTILITY				= UIFactory.getElements("LINK_UTILITY");
	final static UI_Elements	LINK_PRODUCTS_STATUS		= UIFactory.getElements("LINK_PRODUCTS_STATUS");
	final static UI_Elements	LINK_IMPORT_EXPORT_DATA		= UIFactory.getElements("LINK_IMPORT_EXPORT_DATA");
	final static UI_Elements	LINK_EVENTS_SEARCH			= UIFactory.getElements("LINK_EVENTS_SEARCH");
	final static UI_Elements	DROPDOWN_TENANT				= UIFactory.getElements("DROPDOWN_TENANT");
	final static UI_Elements	DROPDOWN_ENTITY_TYPE		= UIFactory.getElements("DROPDOWN_ENTITY_TYPE");
	final static UI_Elements	DROPDOWN_DESTINATION_SYSTEM	= UIFactory.getElements("DROPDOWN_DESTINATION_SYSTEM");
	final static UI_Elements	DROPDOWN_STATUS				= UIFactory.getElements("DROPDOWN_STATUS");
	final static UI_Elements	BUTTON_SEARCH_EVENTS		= UIFactory.getElements("BUTTON_SEARCH_EVENTS");
	final static UI_Elements	LINK_RESET					= UIFactory.getElements("LINK_RESET");
	final static UI_Elements	BUTTON_ACTIONS_ADMIN_PAGE	= UIFactory.getElements("BUTTON_ACTIONS_ADMIN_PAGE");
	final static UI_Elements	LINK_RETRIGGER_ADMIN_PAGE	= UIFactory.getElements("LINK_RETRIGGER_ADMIN_PAGE");
	final static UI_Elements	BUTTON_LAST_PAGE_ADMIN_PAGE	= UIFactory.getElements("BUTTON_LAST_PAGE_ADMIN_PAGE");
	final static UI_Elements	CHECKBOX_ADMIN_PAGE			= UIFactory.getElements("CHECKBOX_ADMIN_PAGE");
	final static UI_Elements	DIV_PROCESSING_ADMIN_PAGE	= UIFactory.getElements("DIV_PROCESSING_ADMIN_PAGE");
	final static UI_Elements	DIV_RETRIGGER_ADMIN_PAGE	= UIFactory.getElements("DIV_RETRIGGER_ADMIN_PAGE");
	final static UI_Elements	TEXT_DOCUMENT_NUMBER		= UIFactory.getElements("TEXT_DOCUMENT_NUMBER");
	final static UI_Elements	TEXT_EVENT_TYPE				= UIFactory.getElements("TEXT_EVENT_TYPE");
	final static UI_Elements	TEXT_FAILURE_REASONS		= UIFactory.getElements("TEXT_FAILURE_REASONS");
	final static UI_Elements	TEXT_TOTAL_PAGES			= UIFactory.getElements("TEXT_TOTAL_PAGES");
	final static UI_Elements	TEXTBOX_PAGE_NUMBER			= UIFactory.getElements("TEXTBOX_PAGE_NUMBER");

	public static String selectActivityToPerform(WebDriver driver, String testCaseName, String activity) throws ActionBotException
	{
		if (activity.equalsIgnoreCase(IConstantsData.CLEAR_CACHE))
		{
			ActionBot.click(driver, LINK_CLEAR_CACHE);
			logger.info("After clicking on activity " + activity);
		}
		else if (activity.equalsIgnoreCase(IConstantsData.MONITOR_ACTIVEMQ))
		{
			ActionBot.click(driver, LINK_MONITOR_ACTIVEMQ);
			logger.info("After clicking on activity " + activity);
		}
		else if (activity.equalsIgnoreCase(IConstantsData.CURRENT_SESSION))
		{
			ActionBot.click(driver, LINK_CURRENT_SESSION);
			logger.info("After clicking on activity " + activity);
		}
		else if (activity.equalsIgnoreCase(IConstantsData.PHP_CONFIG_INFO))
		{
			ActionBot.click(driver, LINK_PHP_CONFIG_INFO);
			logger.info("After clicking on activity " + activity);
		}
		else if (activity.equalsIgnoreCase(IConstantsData.APPROVALS))
		{
			ActionBot.click(driver, LINK_APPROVALS);
			logger.info("After clicking on activity " + activity);
		}
		else if (activity.equalsIgnoreCase(IConstantsData.EVENTS))
		{
			ActionBot.click(driver, LINK_EVENTS);
			ActionBot.defaultSleep();
			logger.info("After clicking on activity " + activity);
		}
		else if (activity.equalsIgnoreCase(IConstantsData.UNDER_MAINTAINANCE))
		{
			ActionBot.click(driver, LINK_UNDER_MAINTAINANCE);
			logger.info("After clicking on activity " + activity);
		}
		else if (activity.equalsIgnoreCase(IConstantsData.UTILITY))
		{
			ActionBot.click(driver, LINK_UTILITY);
			logger.info("After clicking on activity " + activity);
		}
		else if (activity.equalsIgnoreCase(IConstantsData.PRODUCT_STATUS))
		{
			ActionBot.click(driver, LINK_PRODUCTS_STATUS);
			logger.info("After clicking on activity " + activity);
		}
		else if (activity.equalsIgnoreCase(IConstantsData.IMPORT_EXPORT_DATA))
		{
			ActionBot.click(driver, LINK_IMPORT_EXPORT_DATA);
			logger.info("After clicking on activity " + activity);
		}
		else
		{
			logger.info("Incorrect activity provided: " + activity + " Please provide valid activity");
		}
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Activity " + activity);
		return activity;
	}

	public static AdminMonitoring searchEventsAndPerformAction(WebDriver driver, String testCaseName, AdminMonitoring adminMonitoring) throws ActionBotException
	{
		// to open search box
		ActionBot.click(driver, LINK_EVENTS_SEARCH);
		ActionBot.defaultMediumSleep();

		// fill search data
		if (!(adminMonitoring.getTenant() == null))
		{
			WebElement ele = ActionBot.findElement(driver, DROPDOWN_TENANT);
			Select select = new Select(ele);
			select.selectByVisibleText(adminMonitoring.getTenant());
		}

		if (!(adminMonitoring.getEntityType() == null))
		{
			WebElement ele = ActionBot.findElement(driver, DROPDOWN_ENTITY_TYPE);
			Select select = new Select(ele);
			select.selectByVisibleText(adminMonitoring.getEntityType());
		}

		if (!(adminMonitoring.getDestinationSystem() == null))
		{
			WebElement ele = ActionBot.findElement(driver, DROPDOWN_DESTINATION_SYSTEM);
			Select select = new Select(ele);
			select.selectByVisibleText(adminMonitoring.getDestinationSystem());
		}

		if (!(adminMonitoring.getStatus() == null))
		{
			WebElement ele = ActionBot.findElement(driver, DROPDOWN_STATUS);
			Select select = new Select(ele);
			select.selectByVisibleText(adminMonitoring.getStatus());
		}

		ScreenShot.screenshot(driver, testCaseName, "After filling search details");

		// to perform action
		if (adminMonitoring.getNextAction().equalsIgnoreCase(IConstantsData.SEARCH_EVENT))
		{
			logger.info("before clicking on button Search");
			ActionBot.click(driver, BUTTON_SEARCH_EVENTS);
			ActionBot.waitTillPopUpIsPresent(driver, DIV_PROCESSING_ADMIN_PAGE);
			ActionBot.defaultSleep();
			logger.info("After clicking on button Search");
		}
		else if (adminMonitoring.getNextAction().equalsIgnoreCase(IConstantsData.RESET_EVENT))
		{
			ActionBot.click(driver, LINK_RESET);
			logger.info("After clicking on link reset");
		}
		else
		{
			logger.info("Incorrect request provided");
		}

		return adminMonitoring;
	}

	public static AdminMonitoring retriggerEvent(WebDriver driver, String testCaseName, AdminMonitoring adminMonitoring) throws ActionBotException
	{
		int totalFail = 0;
		int totalPass = 0;

		// Navigates to last page to start activity in reverse order
		if (ActionBot.isElementEnabled(driver, BUTTON_LAST_PAGE_ADMIN_PAGE))
		{
			ActionBot.click(driver, BUTTON_LAST_PAGE_ADMIN_PAGE);
			ActionBot.waitTillPopUpIsPresent(driver, DIV_PROCESSING_ADMIN_PAGE);
			logger.info("After navigating to last page");
		}

		// to fetch count of total number of pages
		int page_count = returnTotalPages(driver, testCaseName);

		// to iterate over all pages
		for (int a = page_count; a >= 1; a--)
		{
			logger.info("\nRetriggering activities on Page: " + a);

			// to find total number of rows present on page
			List<WebElement> elements_Checkbox = ActionBot.findElements(driver, CHECKBOX_ADMIN_PAGE);
			int count_Checkbox = elements_Checkbox.size();

			List<WebElement> elements_Action_Button = ActionBot.findElements(driver, BUTTON_ACTIONS_ADMIN_PAGE);
			int count_Button = elements_Action_Button.size();

			// to verify each row has it's own checkbox and action button else
			// close execution
			if (count_Checkbox != count_Button)
			{
				logger.info("\n====== Checkbox or Action Button not displayed on page for some records ======");
				ScreenShot.screenshot(driver, testCaseName, "Checkbox/ Action Button count mismatch on Admin Page");
				driver.quit();
			}
			else
			{
				logger.info("\n CheckBox Count: " + count_Checkbox + " Button Count: " + count_Button);
			}

			// to iterate over all elements
			for (int i = count_Checkbox - 1; i >= 0; i--)
			{
				try
				{
					// recalling to avoid Stale element exception
					elements_Checkbox = ActionBot.findElements(driver, CHECKBOX_ADMIN_PAGE);
					elements_Action_Button = ActionBot.findElements(driver, BUTTON_ACTIONS_ADMIN_PAGE);

					String entityId_UI_Old = elements_Checkbox.get(i).getAttribute("itemid");
					adminMonitoring.setEntityID(entityId_UI_Old);

					// to fetch list of UI values
					List<WebElement> documentNumber = ActionBot.findElements(driver, TEXT_DOCUMENT_NUMBER);
					List<WebElement> eventType = ActionBot.findElements(driver, TEXT_EVENT_TYPE);
					List<WebElement> failrueReason = ActionBot.findElements(driver, TEXT_FAILURE_REASONS);

					// storing values as per current index
					String doc_Number = documentNumber.get(i).getText();
					String event_Type = eventType.get(i).getText();
					String failrue_Reason = failrueReason.get(i).getText();

					String eventTye = ActionBot.findElement(driver, By.xpath("(.//*[@id='eventErrorListing']//tbody//*[contains(@class,'eventType')])[" + (i + 1) + "]"))
						.toString();

					// to ignore all events with type RELEASED
					if (event_Type.equalsIgnoreCase("RELEASED"))
					{
						logger.info("\nEvent Type is Release hence ignoring Document: " + doc_Number);
					}
					else
					{
						// to retrigger event
						ActionBot.defaultSleep();
						ActionBot.click(driver, elements_Checkbox.get(i));
						ActionBot.click(driver, elements_Action_Button.get(i));
						ActionBot.click(driver, LINK_RETRIGGER_ADMIN_PAGE);
						ActionBot.waitTillPopUpIsPresent(driver, DIV_RETRIGGER_ADMIN_PAGE);
						ScreenShot.screenshot(driver, testCaseName, "After clicking on retrigger activity");

						// find current entityId on same index
						elements_Checkbox = ActionBot.findElements(driver, CHECKBOX_ADMIN_PAGE);
						String entityId_UI_New = "";
						try
						{
							entityId_UI_New = elements_Checkbox.get(i).getAttribute("itemid");
						}
						catch (IndexOutOfBoundsException e)
						{
							try
							{
								entityId_UI_New = elements_Checkbox.get(i - 1).getAttribute("itemid");
							}
							catch (ArrayIndexOutOfBoundsException e1)
							{
								entityId_UI_New = "0";
							}
						}

						// to verify if retrigger activity was successful
						if (entityId_UI_New.equalsIgnoreCase(entityId_UI_Old))
						{
							logger.info("\n======================== Retrigger activity Failed ====================" + "\n \tEntity ID: " + entityId_UI_Old
								+ "\n \tDocument Number: " + doc_Number + "\n \tEvent Type: " + event_Type + "\n \tFailure Reason: " + failrue_Reason
								+ "\n=======================================================================");
							totalFail++;
						}
						else
						{
							logger.info("\n======================== Retrigger activity Passed ====================" + "\n \tEntity ID: " + entityId_UI_Old
								+ "\n \tDocument Number: " + doc_Number + "\n \tEvent Type: " + event_Type + "\n \tFailure Reason: " + failrue_Reason
								+ "\n=======================================================================");
							totalPass++;
						}
					}
					ActionBot.defaultSleep();
				}
				catch (StaleElementReferenceException e)
				{
					elements_Checkbox = ActionBot.findElements(driver, CHECKBOX_ADMIN_PAGE);
					elements_Action_Button = ActionBot.findElements(driver, BUTTON_ACTIONS_ADMIN_PAGE);
					logger.info("Exception caught while retrigger activity " + e);
				}
			}
			// to navigate to previous page
			navigateToPreviousPage(driver, testCaseName, a);
		}

		logger.info("\nTotal Events Successfully: " + totalPass);
		logger.info("\nTotal Events Failed: " + totalFail);

		return adminMonitoring;
	}

	public static int returnTotalPages(WebDriver driver, String testCaseName) throws ActionBotException
	{
		int pages = 0;

		String pages_String = ActionBot.findElement(driver, TEXT_TOTAL_PAGES).getText();
		String[] split = pages_String.split(" ");
		pages = Integer.parseInt(split[1]);
		return pages;
	}

	public static void navigateToPreviousPage(WebDriver driver, String testCaseName, int pageNumber) throws ActionBotException
	{
		// to navigate within pages
		ActionBot.defaultSleep();
		ActionBot.scroll(driver, "500");
		ActionBot.defaultSleep();

		ActionBot.clear(driver, TEXTBOX_PAGE_NUMBER);
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_PAGE_NUMBER);
		ele.sendKeys("" + (pageNumber - 1) + "" + Keys.ENTER);

		// ActionBot.sendKeys(driver, TEXTBOX_PAGE_NUMBER,""+Keys.ENTER);
		ActionBot.waitTillPopUpIsPresent(driver, DIV_PROCESSING_ADMIN_PAGE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After navigating to another page");
	}

}
