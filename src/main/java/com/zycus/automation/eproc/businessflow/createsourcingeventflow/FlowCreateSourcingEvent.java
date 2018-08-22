/**
 * 
 */
package com.zycus.automation.eproc.businessflow.createsourcingeventflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.SourcingEvent;
import com.zycus.automation.eproc.pageobjects.modals.createsourcingevent.ModalCreateSourcingEvent;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;

/**
 * @author ankita.sawant
 *
 */
public class FlowCreateSourcingEvent
{
	static Logger logger = Logger.getLogger(FlowCreateSourcingEvent.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create sourcing event <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param sourcingEvent </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static SourcingEvent createSourcingEvent(WebDriver driver, String testCaseName, SourcingEvent sourcingEvent) throws ActionBotException
	{
		// event type
		if (sourcingEvent.getEventType() != null)
		{
			sourcingEvent.setEventType(ModalCreateSourcingEvent.selectEventType(driver, testCaseName, sourcingEvent.getEventType()));
		}
		// event name
		if (sourcingEvent.getEventName() != null)
		{
			sourcingEvent.setEventName(ModalCreateSourcingEvent.fillSourcingEventName(driver, testCaseName, sourcingEvent.getEventName()));
		}
		else
		{
			sourcingEvent.setEventName(ModalCreateSourcingEvent.getSourcingEventName(driver, testCaseName));
		}
		// event owner
		if (sourcingEvent.getEventOwner() != null)
		{
			sourcingEvent.setEventOwner(ModalCreateSourcingEvent.fillSourcingEventOwner(driver, testCaseName, sourcingEvent.getEventOwner()));
		}
		else
		{
			sourcingEvent.setEventOwner(ModalCreateSourcingEvent.getSourcingEventOwner(driver, testCaseName));
		}
		// description
		if (sourcingEvent.getEventDesc() != null)
		{
			sourcingEvent.setEventDesc(ModalCreateSourcingEvent.fillSourcingEventDescription(driver, testCaseName, sourcingEvent.getEventDesc()));
		}
		else
		{
			sourcingEvent.setEventDesc(ModalCreateSourcingEvent.getSourcingEventDescription(driver, testCaseName));
		}
		if (sourcingEvent.isAttachItemLevelGForm())
		{
			ModalCreateSourcingEvent.clickOnAttachItemLevelGFrom(driver, testCaseName);
		}
		/*
		 * //item no
		 * sourcingEvent.setItemNo(ModalCreateSourcingEvent.getFirstItemNo(
		 * driver, testCaseName)); //item name
		 * sourcingEvent.setItemName(ModalCreateSourcingEvent.getFirstItemName(
		 * driver, testCaseName)); //unit price
		 * sourcingEvent.setUnitPrice(ModalCreateSourcingEvent.getFirstUnitPrice
		 * (driver, testCaseName)); //quantity
		 * sourcingEvent.setQuantity(ModalCreateSourcingEvent.
		 * getFirstItemQuantity(driver, testCaseName)); //total price
		 * sourcingEvent.setTotalPrice(ModalCreateSourcingEvent.
		 * getFirstItemTotalPrice(driver, testCaseName));
		 */

		if (sourcingEvent.getNextAction().equalsIgnoreCase(IConstantsData.CreateEvent))
		{
			ModalCreateSourcingEvent.clickOnCreateEventButton(driver, testCaseName);
		}
		else if (sourcingEvent.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModalCreateSourcingEvent.clickOnCloseEventButton(driver, testCaseName);
		}
		else
		{
			logger.info("Invalid Next Action");
		}
		return sourcingEvent;
	}
}
