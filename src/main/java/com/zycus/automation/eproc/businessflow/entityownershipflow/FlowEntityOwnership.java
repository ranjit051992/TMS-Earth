/**
 * 
 */
package com.zycus.automation.eproc.businessflow.entityownershipflow;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.EntityOwnership;
import com.zycus.automation.eproc.pageobjects.modals.entityownership.IModalSelectRequisitionEntityOwnershipImpl;
import com.zycus.automation.eproc.pageobjects.modals.entityownership.ModalSelectRequisitionEntityOwnership;
import com.zycus.automation.eproc.pageobjects.pages.settings.entityownership.PageEntityOwnership;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatasettings.PageMasterDataSettings;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class FlowEntityOwnership
{
	static Logger logger = Logger.getLogger(IModalSelectRequisitionEntityOwnershipImpl.class);
	public static EntityOwnership changeOwner(WebDriver driver, String testCaseName, EntityOwnership entityOwnership) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnMasterSubTab(driver);
		PageMasterDataSettings.clickOnEntityOwnershiplink(driver, testCaseName);
		PageEntityOwnership.clickOnChangeOwner(driver, testCaseName);

		// current owner
		if (entityOwnership.getCurrentOwner() != null)
		{
			entityOwnership.setCurrentOwner(PageEntityOwnership.fillCurrentOwnerName(driver, testCaseName, entityOwnership.getCurrentOwner()));
		}

		// new owner
		if (entityOwnership.getNewOwner() != null)
		{
			entityOwnership.setNewOwner(PageEntityOwnership.fillNewOwnerName(driver, testCaseName, entityOwnership.getNewOwner()));
		}

		// select entity
		if (entityOwnership.isRequisitionEntity())
		{
			PageEntityOwnership.clickOnRequisitionCheckbox(driver, testCaseName);
		}

		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		
		//search entity in Requisition Number
		if(entityOwnership.getSearchEntityIn().equalsIgnoreCase(IConstantsData.search_entity_in_req_number))
		{
			//select value 'Requisition Number' in list
			ModalSelectRequisitionEntityOwnership.selectEntitiesIn(driver, testCaseName, entityOwnership.getSearchEntityIn());
			ModalSelectRequisitionEntityOwnership.clickOnSearchGoButton(driver, testCaseName);
			//check whether requisition present in list or not. if present select checkbox for it
			searchAndSelectCheckBoxForRequisitionUnderSelectReqisitionsPopUp(driver, testCaseName, entityOwnership.getSearchEntity());		
		}
		// select entity in
		else
		{
			if (entityOwnership.getSearchEntityIn() != null)
			{
				ModalSelectRequisitionEntityOwnership.selectEntitiesIn(driver, testCaseName, entityOwnership.getSearchEntityIn());
			}

			// status
			if (entityOwnership.getSearchEntityIn().equalsIgnoreCase(IConstantsData.search_entity_in_status))
			{
				entityOwnership.setStatusOfEntity(ModalSelectRequisitionEntityOwnership.selectStatusOfEntities(driver, testCaseName, entityOwnership.getStatusOfEntity()));
			}
			else
			{
				entityOwnership.setSearchEntity(ModalSelectRequisitionEntityOwnership.fillEntitySearchBox(driver, testCaseName, entityOwnership.getSearchEntity()));
			}

			// search go
			ModalSelectRequisitionEntityOwnership.clickOnSearchGoButton(driver, testCaseName);

			// select first entity
			ModalSelectRequisitionEntityOwnership.clickOnFirstRowEntityCheckbox(driver, testCaseName);
		}
		
		ModalSelectRequisitionEntityOwnership.fillComments(driver, testCaseName, IConstantsData.search_entity_comment);

		if (entityOwnership.getSelectEntityNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModalSelectRequisitionEntityOwnership.clickOnSaveSelectedEntitiesButton(driver, testCaseName);
		}
		else
		{
			ModalSelectRequisitionEntityOwnership.clickOnCancelSelectedEntitiesButton(driver, testCaseName);
		}

		// save or reset
		if (entityOwnership.getChangeOwnerNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			PageEntityOwnership.clickOnStartChangeOwnerButton(driver, testCaseName);
		}
		else
		{
			PageEntityOwnership.clickOnResetChangeOwnerButton(driver, testCaseName);
		}

		return entityOwnership;
	}

	
	public static boolean searchAndSelectCheckBoxForRequisitionUnderSelectReqisitionsPopUp(WebDriver driver, String testCaseName, String requisitionNo ) throws ActionBotException, FactoryMethodException
	{
		String enetredPageNo=null;
		int showingPageNumber = 1;
		boolean flagReqPresent=false, flag=false;
		int reqNoFoundAtRowNo=0; //for storing row after getting requisition in list 
		
		do
		{
			enetredPageNo = ModalSelectRequisitionEntityOwnership.fillShowingPageNumberAndEnter(driver, testCaseName, showingPageNumber++);
			List<String> listOfRequisitionNo = ModalSelectRequisitionEntityOwnership.getListOfRequisitionsOnSelectRequisitionsPoUp(driver, testCaseName, showingPageNumber);

			if(listOfRequisitionNo.isEmpty())
			{	
				return false;
			}
			
			for (int i = 0; i < listOfRequisitionNo.size(); i++)
			{
				if (requisitionNo.equalsIgnoreCase(listOfRequisitionNo.get(i).trim()))
				{
					reqNoFoundAtRowNo = i + 1;
					logger.info("\nRequisition found in list......"+requisitionNo);
					flagReqPresent = true;
				}
			}
			
		} while (showingPageNumber != Integer.parseInt(enetredPageNo) && flagReqPresent==false);

		//requisition not found, returning false;
		if (reqNoFoundAtRowNo == 0)
		{
			logger.info("\nRequisition was not found in list , returning false..." + requisitionNo);
			return false;
		}
		
		//requisition found, now trying to click checkbox for that requisition
		flag = ModalSelectRequisitionEntityOwnership.clickOnSpecificRowCheckBoxOnSelectRequisitionsPopUp(driver, testCaseName, String.valueOf(reqNoFoundAtRowNo).trim());

		return flag;
	}
}
