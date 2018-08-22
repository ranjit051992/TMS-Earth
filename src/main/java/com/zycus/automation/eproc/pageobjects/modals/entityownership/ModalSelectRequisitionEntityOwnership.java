/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.entityownership;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class ModalSelectRequisitionEntityOwnership
{

	public static String selectStatusOfEntities(WebDriver driver, String testCaseName, String status) throws ActionBotException, FactoryMethodException
	{
		IModalSelectRequisitionEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IModalSelectRequisitionEntityOwnershipImpl.class);
		return entityOwnership.selectStatusOfEntities(driver, testCaseName, status);
	}

	public static String selectEntitiesIn(WebDriver driver, String testCaseName, String entitiesIn) throws ActionBotException, FactoryMethodException
	{
		IModalSelectRequisitionEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IModalSelectRequisitionEntityOwnershipImpl.class);
		return entityOwnership.selectEntitiesIn(driver, testCaseName, entitiesIn);
	}

	public static String fillEntitySearchBox(WebDriver driver, String testCaseName, String entity) throws ActionBotException, FactoryMethodException
	{
		IModalSelectRequisitionEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IModalSelectRequisitionEntityOwnershipImpl.class);
		return entityOwnership.fillEntitySearchBox(driver, testCaseName, entity);
	}

	public static void clickOnSearchGoButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalSelectRequisitionEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IModalSelectRequisitionEntityOwnershipImpl.class);
		entityOwnership.clickOnSearchGoButton(driver, testCaseName);
	}

	public static void clickOnFirstRowEntityCheckbox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalSelectRequisitionEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IModalSelectRequisitionEntityOwnershipImpl.class);
		entityOwnership.clickOnFirstRowEntityCheckbox(driver, testCaseName);
	}

	public static String fillComments(WebDriver driver, String testCaseName, String comments) throws ActionBotException, FactoryMethodException
	{
		IModalSelectRequisitionEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IModalSelectRequisitionEntityOwnershipImpl.class);
		return entityOwnership.fillComments(driver, testCaseName, comments);
	}

	public static void clickOnSaveSelectedEntitiesButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalSelectRequisitionEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IModalSelectRequisitionEntityOwnershipImpl.class);
		entityOwnership.clickOnSaveSelectedEntitiesButton(driver, testCaseName);
	}

	public static void clickOnCancelSelectedEntitiesButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IModalSelectRequisitionEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IModalSelectRequisitionEntityOwnershipImpl.class);
		entityOwnership.clickOnCancelSelectedEntitiesButton(driver, testCaseName);
	}
	
	public static List<String> getListOfRequisitionsOnSelectRequisitionsPoUp(WebDriver driver, String testCaseName, int showingPageNumber)
		throws ActionBotException, FactoryMethodException
	{
		IModalSelectRequisitionEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IModalSelectRequisitionEntityOwnershipImpl.class);
		return entityOwnership.getListOfRequisitionsOnSelectRequisitionsPoUp(driver, testCaseName, showingPageNumber);
	}

	public static String fillShowingPageNumberAndEnter(WebDriver driver, String testCaseName, int showingPageNumber) throws ActionBotException, FactoryMethodException
	{
		IModalSelectRequisitionEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IModalSelectRequisitionEntityOwnershipImpl.class);
		return entityOwnership.fillShowingPageNumberAndEnter(driver, testCaseName, showingPageNumber);
	}

	public static boolean clickOnSpecificRowCheckBoxOnSelectRequisitionsPopUp(WebDriver driver, String testCaseName, String rowNo) throws ActionBotException, FactoryMethodException
	{
		IModalSelectRequisitionEntityOwnership entityOwnership = FactoryPage.getInstanceOf(IModalSelectRequisitionEntityOwnershipImpl.class);
		return entityOwnership.clickOnSpecificRowCheckBoxOnSelectRequisitionsPopUp(driver, testCaseName, rowNo);
	}

}
