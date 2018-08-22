/**
 * 
 */
package com.zycus.automation.eproc.businessflow.peformflow;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.zycus.automation.bo.EformField;
import com.zycus.automation.bo.PEform;
import com.zycus.automation.eproc.pageobjects.modals.createfieldofceform.ModalCreateFieldOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.createsectionofceform.ModalCreateSectionOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.fieldpropertiesofceform.ModalFieldPropertiesOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.previewpeform.ModalPreviewPEform;
import com.zycus.automation.eproc.pageobjects.modals.selectbuofceform.ModalSelectBUOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.selectcatalogcompaniesandbu.ModalSelectCompaniesAndBU;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.ceformlisting.IPageCEformListing;
import com.zycus.automation.eproc.pageobjects.pages.ceformlisting.PageCEformListing;
import com.zycus.automation.eproc.pageobjects.pages.createceform.PageCreateCEform;
import com.zycus.automation.eproc.pageobjects.pages.createpeform.IPageCreatePEform;
import com.zycus.automation.eproc.pageobjects.pages.createpeform.PageCreatePEform;
import com.zycus.automation.eproc.pageobjects.pages.peformlisting.IPagePEformListing;
import com.zycus.automation.eproc.pageobjects.pages.peformlisting.PagePEformListing;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;

/**
 * @author ankita.sawant
 *
 */
public class FlowPEform
{
	static Logger logger = Logger.getLogger(FlowPEform.class);

	public static PEform createPEForm(WebDriver driver, String testCaseName, PEform pEform) throws Exception
	{
		MainPageHeaderLevelTab.clickOnEformTab(driver, testCaseName);
		MainPageHeaderLevelTab.clickOnProcessEformTab(driver, testCaseName);

		PageCEformListing.clickOnOnlineEditor(driver, testCaseName);

		pEform = fillPEFormDetails(driver, testCaseName, pEform);

		if (pEform.getNextAction().equalsIgnoreCase(IConstantsData.PUBLISH_EFORM))
		{
			PageCreateCEform.clickOnPublishCEformButton(driver, testCaseName);
		}
		else if (pEform.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_AS_DRAFT_EFORM))
		{
			PageCreatePEform.clickOnSaveAsDraftButton(driver, testCaseName);
		}
		else if (pEform.getNextAction().equalsIgnoreCase(IConstantsData.PREVIEW_EFORM))
		{
			PageCreatePEform.clickOnPreviewButton(driver, testCaseName);
		}
		else
		{

		}
		return pEform;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To fill PEForm details <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param pEform </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 */
	public static PEform fillPEFormDetails(WebDriver driver, String testCaseName, PEform pEform) throws Exception
	{
		if (pEform.isFileUpload())
		{
			if (pEform.getAttachmentFileName() != null)
				PageCreatePEform.selectFile(driver, testCaseName, pEform.getAttachmentFileName());
			else
				PageCreatePEform.selectFile(driver, testCaseName);
		}

		if (pEform.getPeformName() != null)
		{
			pEform.setPeformName(PageCreatePEform.fillPEformName(driver, testCaseName, pEform.getPeformName()));
		}
		if (pEform.getProcessName() != null)
		{
			pEform.setProcessName(PageCreatePEform.selectProcessForPEform(driver, testCaseName, pEform.getProcessName()));
		}
		//Selecting Scope for Carlson specific
		if (pEform.isCarlsonOU())
		{
			// to select OU
			PageCreateCEform.clickOnLinkSelectOUForCForm(driver, testCaseName);
			ActionBot.defaultLowSleep();
			//click on Expand box under Regions Tab and select all Regions
			ModalSelectCompaniesAndBU.selectAllOU(driver, testCaseName, pEform.getRegionName());
			ActionBot.defaultSleep();
			ModalSelectCompaniesAndBU.clickOnCompaniesTab(driver, testCaseName);
			ActionBot.defaultSleep();
			//click on OU link Under companies Tab
			ModalSelectBUOfCEform.clickLinkSelectBusinessUnit(driver, testCaseName);
			ActionBot.defaultSleep();
			ModalSelectBUOfCEform.SelectCheckBoxOU(driver, testCaseName);
			ActionBot.defaultSleep();
			ModalSelectCompaniesAndBU.clickOnSaveSelectedOUButton(driver, testCaseName);
			ActionBot.defaultSleep();
			ModalSelectBUOfCEform.clickTabBusinessUnit(driver, testCaseName);
			ActionBot.defaultSleep();
			ModalSelectCompaniesAndBU.clickOnOUUnderBUTab(driver, testCaseName);
			ActionBot.defaultSleep();
			ModalSelectBUOfCEform.SelectCheckBoxOU(driver, testCaseName);
			ActionBot.defaultSleep();
			ModalSelectCompaniesAndBU.clickOnSaveSelectedOUButton(driver, testCaseName);
			ActionBot.defaultSleep();
			ModalSelectBUOfCEform.clickOnSaveORGUnitButton(driver, testCaseName);
		}
		else

		if (pEform.isChangeOU())
		{
			// to select OU
			PageCreateCEform.clickOnLinkSelectOUForCForm(driver, testCaseName);

			// need to change code later
			//ModalSelectBUOfCEform.selectIstOrganisationUnit(driver, testCaseName);

			//ModalSelectBUOfCEform.selectAllOU(driver, testCaseName);

			//Select Company by name
			ModalSelectBUOfCEform.selectCompanyByName(driver, testCaseName, pEform.getOU());

			// select bu
			ActionBot.defaultSleep();
			ModalSelectBUOfCEform.clickTabBusinessUnit(driver, testCaseName);
			ActionBot.defaultSleep();

			// ModalSelectBUOfCEform.clickLinkSelectBusinessUnit(driver,
			// testCaseName);
			if (pEform.getBusinessUnit() != null)
			{
				ActionBot.defaultSleep();
				ModalSelectBUOfCEform.clickLinkSelectBusinessUnit(driver, testCaseName);
				ActionBot.defaultSleep();

				//search business unit and click check box of that business unit
				ModalSelectBUOfCEform.SelectCheckBoxBusinessUnit(driver, testCaseName, pEform.getBusinessUnit());

				// save modal
				ModalSelectBUOfCEform.clickBtnSaveSelectedOu(driver, testCaseName);
				ActionBot.defaultSleep();
			}
			else
			{
				ModalSelectBUOfCEform.clickLinkSelectAllBU(driver, testCaseName);
			}

			//ModalSelectBUOfCEform.clickLinkSelectAllBU(driver, testCaseName);

			ActionBot.defaultSleep();

			ActionBot.defaultSleep();
			ModalSelectBUOfCEform.clickOnSaveORGUnitButton(driver, testCaseName);

			//			ActionBot.click(driver, IPageGLMapsMasterDataSettingsImpl.SELECT_OU_AGAINST_COMPANY);
			//			ActionBot.defaultSleep();
			//
			//			ActionBot.click(driver, IModalSelectBUOfCEformImpl.CHECKBOX_SELECT_ALL_OU_MODAL);
			//			ActionBot.defaultSleep();
			//
			//			ActionBot.click(driver, IPageGLMapsMasterDataSettingsImpl.SAVE_OU);
			//
			//			ActionBot.click(driver, IPageGLMapsMasterDataSettingsImpl.SAVE_COMPANY);

		}
		if (pEform.getPurchaseType() != null)
		{
			pEform.setPurchaseType(PageCreatePEform.selectPurhcaseTypeForPEform(driver, testCaseName, pEform.getPurchaseType()));
		}

		// to save and continue
		if (!pEform.isFileUpload())
			PageCreatePEform.clickOnSavePEformButton(driver, testCaseName);

		if (pEform.isAddSectionAndMultipleFields())
		{
			//to add more than one fields
			pEform = createEformFields(driver, testCaseName, pEform);
		}
		else if (pEform.isAddSectionAndField())
		{
			// to add section
			PageCreateCEform.clickOnAddSectionLink(driver, testCaseName);
			// to fill section details
			pEform.setSectionName(ModalCreateSectionOfCEform.fillSectionName(driver, testCaseName, pEform.getSectionName()));
			ModalCreateSectionOfCEform.clickOnSaveSectionButton(driver, testCaseName);

			// to add field
			PageCreateCEform.clickOnAddFieldLink(driver, testCaseName);

			// to add text field
			ModalCreateFieldOfCEform.clickOnAddTextField(driver, testCaseName);
			// to fill field properties
			pEform.setFieldName(ModalFieldPropertiesOfCEform.fillFieldName(driver, testCaseName, pEform.getFieldName()));
			ModalFieldPropertiesOfCEform.clickOnSaveFieldButton(driver, testCaseName);

			//setting name and type of field in EformField for future verification
			EformField eformField = new EformField(pEform.getFieldName(), "Text Field");
			List<EformField> eformFieldsList = new ArrayList<EformField>();
			eformFieldsList.add(eformField);
			pEform.setEformFileds(eformFieldsList);

		}
		return pEform;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To fill PEForm details <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param pEform </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static PEform updatePEFormDetails(WebDriver driver, String testCaseName, PEform pEform) throws ActionBotException
	{
		if (pEform.getPeformName() != null)
		{
			pEform.setPeformName(PageCreatePEform.fillPEformName(driver, testCaseName, pEform.getPeformName()));
		}
		if (pEform.getProcessName() != null)
		{
			pEform.setProcessName(PageCreatePEform.selectProcessForPEform(driver, testCaseName, pEform.getProcessName()));
		}

		/*
		 * if (pEform.isChangeOU()) { //to select OU
		 * PageCreateCEform.clickOnLinkSelectOUForCForm(driver, testCaseName);
		 * if (cEform.getOU() != null) {
		 * cEform.setOU(ModalSelectBUOfCEform.clickOnOU(driver, testCaseName,
		 * cEform.getOU())); } else { ModalSelectBUOfCEform.selectAllOU(driver,
		 * testCaseName); } //need to change code later
		 * ModalSelectBUOfCEform.selectIstOrganisationUnit(driver,
		 * testCaseName); //select bu ActionBot.defaultSleep();
		 * ModalSelectBUOfCEform.clickTabBusinessUnit(driver, testCaseName);
		 * ActionBot.defaultSleep();
		 * ModalSelectBUOfCEform.clickLinkSelectBusinessUnit(driver,
		 * testCaseName); ActionBot.defaultSleep();
		 * ModalSelectBUOfCEform.SelectCheckBoxOU(driver, testCaseName); //save
		 * modal ModalSelectBUOfCEform.clickBtnSaveSelectedOu(driver,
		 * testCaseName); ActionBot.defaultSleep();
		 * ModalSelectBUOfCEform.clickOnSaveORGUnitButton(driver, testCaseName);
		 * }
		 */

		// to save and continue
		PageCreatePEform.clickOnSavePEformButton(driver, testCaseName);

		if (pEform.isAddSectionAndField())
		{
			// to add section
			PageCreateCEform.clickOnAddSectionLink(driver, testCaseName);
			// to fill section details
			pEform.setSectionName(ModalCreateSectionOfCEform.fillSectionName(driver, testCaseName, pEform.getSectionName()));
			ModalCreateSectionOfCEform.clickOnSaveSectionButton(driver, testCaseName);

			// to add field
			PageCreateCEform.clickOnAddFieldLink(driver, testCaseName);

			// to add text field
			ModalCreateFieldOfCEform.clickOnAddTextField(driver, testCaseName);
			// to fill field properties
			pEform.setFieldName(ModalFieldPropertiesOfCEform.fillFieldName(driver, testCaseName, pEform.getFieldName()));
			ModalFieldPropertiesOfCEform.clickOnSaveFieldButton(driver, testCaseName);
		}
		return pEform;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>to Deactivate Eform <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param eformName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean deactivatePEform(WebDriver driver, String testCaseName, String eformName) throws ActionBotException
	{
		boolean flag = false;
		// first deactivate
		List<WebElement> element = PagePEformListing.getListOfPEformNames(driver, testCaseName);
		WebElement selectedEform = null;
		for (WebElement ele : element)
		{
			if (ele.getText().trim().equalsIgnoreCase(eformName))
			{
				selectedEform = ele;
				Actions action = new Actions(driver);
				action.moveToElement(selectedEform).build().perform();
				break;
			}
		}
		ActionBot.click(driver, IPagePEformListing.LABEL_STATUS_OF_PEFORM);
		PagePEformListing.clickOnDeactivatePEformLink(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		ActionBot.refreshPage(driver, testCaseName);
		ActionBot.defaultSleep();
		flag = FlowPEform.searchePEForm(driver, testCaseName,eformName);
		assertTrue("PForm was not searched", flag);
		
		// to check status of PEForm
		String status = PagePEformListing.getStatusOFFirstPEForm(driver, testCaseName);
		flag = status.contains(IConstantsData.INACTIVE_STATUS);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To Deactivate and Delete Eform <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param eformName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static void deactivateNdeleteCEform(WebDriver driver, String testCaseName, String eformName) throws ActionBotException
	{
		MainPageHeaderLevelTab.clickOnProcessEformTab(driver, testCaseName);
		// first deactivate
		List<WebElement> element = PagePEformListing.getListOfPEformNames(driver, testCaseName);
		WebElement selectedEform = null;
		Actions action = new Actions(driver);
		for (WebElement ele : element)
		{
			if (ele.getText().trim().equalsIgnoreCase(eformName))
			{
				selectedEform = ele;
				action.moveToElement(selectedEform).build().perform();
				break;
			}
		}
		ActionBot.hover(driver, IPagePEformListing.LABEL_STATUS_OF_PEFORM);
		// ActionBot.click(driver, IPagePEformListing.LABEL_STATUS_OF_PEFORM);
		PagePEformListing.clickOnDeactivatePEformLink(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		ActionBot.defaultMediumSleep();

		element = PagePEformListing.getListOfPEformNames(driver, testCaseName);
		selectedEform = null;
		for (WebElement ele : element)
		{
			if (ele.getText().trim().equalsIgnoreCase(eformName))
			{
				selectedEform = ele;
				action.moveToElement(selectedEform).build().perform();
				break;
			}
		}
		// delete eform
		// action.moveToElement(selectedEform).build().perform();
		ActionBot.hover(driver, IPagePEformListing.LABEL_STATUS_OF_PEFORM);
		// ActionBot.click(driver, IPagePEformListing.LABEL_STATUS_OF_PEFORM);
		PagePEformListing.clickOnDeletePEformLink(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
	}

	public static boolean deletePEform(WebDriver driver, String testCaseName, String eformName) throws ActionBotException
	{
		boolean flag = false;
		List<WebElement> element = PagePEformListing.getListOfPEformNames(driver, testCaseName);
		WebElement selectedEform = null;
		for (WebElement ele : element)
		{
			if (ele.getText().trim().equalsIgnoreCase(eformName))
			{
				selectedEform = ele;
				Actions action = new Actions(driver);
				action.moveToElement(selectedEform).build().perform();
				break;
			}
		}
		// delete eform
		ActionBot.click(driver, IPagePEformListing.LABEL_STATUS_OF_PEFORM);
		PagePEformListing.clickOnDeletePEformLink(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

		// to search peform
		searchePEForm(driver, testCaseName, eformName);
		flag = PageAllRequestsApproval.getApprovalEmptyTableSize(driver, testCaseName) == 1;
		return flag;
	}

	public static boolean checkIfPEformSearched(WebDriver driver, String testCaseName, String peformName) throws ActionBotException
	{
		boolean flag = false;
		List<WebElement> element = PagePEformListing.getListOfPEformNames(driver, testCaseName);
		if (element.size() >= 1)
		{
			for (WebElement ele : element)
			{
				if (ele.getText().trim().equalsIgnoreCase(peformName))
				{
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To search PEForm <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param peformName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean searchePEForm(WebDriver driver, String testCaseName, String peformName) throws ActionBotException
	{
		boolean flag = false;

		MainPageHeaderLevelTab.clickOnEformTab(driver, testCaseName);
		MainPageHeaderLevelTab.clickOnProcessEformTab(driver, testCaseName);
		PagePEformListing.fillSearchPEform(driver, testCaseName, peformName);

		flag = checkIfPEformSearched(driver, testCaseName, peformName);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To modify PEForm <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param pEform </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static PEform modifyPEform(WebDriver driver, String testCaseName, PEform pEform) throws ActionBotException
	{
		List<WebElement> element = PagePEformListing.getListOfPEformNames(driver, testCaseName);
		WebElement selectedEform = null;
		for (WebElement ele : element)
		{
			if (ele.getText().trim().equalsIgnoreCase(pEform.getPeformName()))
			{
				selectedEform = ele;
				Actions action = new Actions(driver);
				action.moveToElement(selectedEform).build().perform();
				break;
			}
		}
		// ActionBot.hover(driver, selectedEform);
		// ActionBot.defaultSleep();
		ActionBot.click(driver, IPagePEformListing.LABEL_STATUS_OF_PEFORM);
		PagePEformListing.clickOnModifyPEformLink(driver, testCaseName);

		pEform = updatePEFormDetails(driver, testCaseName, pEform);
		return pEform;
	}

	public static boolean previewPEForm(WebDriver driver, String testCaseName, PEform pEform) throws ActionBotException
	{
		boolean flag = false;
		String sectionName, fieldName, fieldTag;
		PageCreatePEform.clickOnPreviewButton(driver, testCaseName);

		logger.info("Values as on preview PEform : ");
		sectionName = ModalPreviewPEform.getLabelValueOfSection(driver, testCaseName);
		fieldName = ModalPreviewPEform.getLabelValueOfField(driver, testCaseName);
		fieldTag = ModalPreviewPEform.getTagOfFieldValue(driver, testCaseName);

		String[] temp = StringUtils.split(fieldName, ":");
		fieldName = "";
		fieldName = temp[0].trim();
		ModalPreviewPEform.clickOnClosePreviewButton(driver, testCaseName);

		flag = sectionName.equalsIgnoreCase(pEform.getSectionName()) && fieldName.equalsIgnoreCase(pEform.getFieldName()) && fieldTag.equalsIgnoreCase("input");

		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Copy PEform <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param pEform </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static PEform copyPEForm(WebDriver driver, String testCaseName, PEform pEform, String newOUName) throws Exception
	{
		List<WebElement> element = PagePEformListing.getListOfPEformNames(driver, testCaseName);
		WebElement selectedEform = null;
		String processName, sectionName, fieldName, fieldTag;

		boolean flag = false, ouFlag = false;

		for (WebElement ele : element)
		{
			if (ele.getText().trim().equalsIgnoreCase(pEform.getPeformName()))
			{
				selectedEform = ele;
				Actions action = new Actions(driver);
				action.moveToElement(selectedEform).build().perform();
				break;
			}
		}
		ActionBot.click(driver, IPagePEformListing.LABEL_STATUS_OF_PEFORM);
		PagePEformListing.clickOnCopyPEformLink(driver, testCaseName);

		pEform.setPeformName(PageCreatePEform.fillPEformName(driver, testCaseName, "Copy_" + CommonUtilities.getPEformName()));
		// processName = PageCreatePEform.getSelectedProcessFoePEform(driver,
		// testCaseName);
		processName = PageCreatePEform.selectProcessForPEform(driver, testCaseName, pEform.getProcessName());
		// purchaseType =
		// PageCreatePEform.getSelectedPurchaseTypeForPEform(driver,
		// testCaseName);

		/*
		 * //to change OU PageCreatePEform.clickOnSelectOU(driver,
		 * testCaseName);
		 * 
		 * //to check copied ou name if (pEform.getOU() != null) { ouFlag =
		 * ModalSelectBUOfCEform.isOUSelectedOrNot(driver, testCaseName,
		 * pEform.getOU()); }
		 * 
		 * //to clear all selected ou's
		 * ModalSelectBUOfCEform.clearAllSelectedOUs(driver, testCaseName);
		 * 
		 * //to change OU if (newOUName != null) { if (newOUName !=
		 * IConstantsData.ALL) {
		 * pEform.setOU(ModalSelectBUOfCEform.clickOnOU(driver, testCaseName,
		 * newOUName)); } else { ModalSelectBUOfCEform.selectAllOU(driver,
		 * testCaseName); } } else { ModalSelectBUOfCEform.selectAllOU(driver,
		 * testCaseName); }
		 * ModalSelectBUOfCEform.clickOnSaveORGUnitButton(driver, testCaseName);
		 */

		// to save and continue
		PageCreatePEform.clickOnSavePEformButton(driver, testCaseName);

		sectionName = PageCreatePEform.getAddedSectionName(driver, testCaseName);
		fieldName = PageCreatePEform.getAddedFieldName(driver, testCaseName);
		fieldTag = PageCreatePEform.getTagOFAddedFieldValue(driver, testCaseName);

		System.out.println("Section Name :->" + sectionName);
		System.out.println("Section Name :==>" + pEform.getSectionName());
		System.out.println("Process : " + processName.equalsIgnoreCase(pEform.getProcessName()));
		System.out.println("sectionName : " + pEform.getSectionName().contains(sectionName));
		System.out.println("fieldName : " + fieldName.contains(pEform.getFieldName()));
		System.out.println("fieldTag : " + fieldTag.equalsIgnoreCase("input"));
		System.out.println("OU : " + ouFlag);

		flag = sectionName.contains(pEform.getSectionName()) && fieldName.contains(pEform.getFieldName()) && fieldTag.equalsIgnoreCase("input");

		pEform.setResult(flag);

		PageCreateCEform.clickOnPublishCEformButton(driver, testCaseName);

		return pEform;
	}

	public static PEform createFileUploadPEForm(WebDriver driver, String testCaseName, PEform pEform) throws Exception
	{
		MainPageHeaderLevelTab.clickOnProcessEformTab(driver, testCaseName);

		PageCEformListing.clickOnFileUpload(driver, testCaseName);

		pEform = fillPEFormDetails(driver, testCaseName, pEform);

		if (pEform.getNextAction().equalsIgnoreCase(IConstantsData.IMPORT_PEFORM))
		{
			PageCreatePEform.clickOnImportButton(driver, testCaseName);
			//driver.findElement(By.xpath(".//*[@id='btnImportEform']")).click();
		}
		pEform.setPeformName(CommonServices.getTestData(IConstantsData.PEFORM_FILE_UPLOAD_NAME));
		ActionBot.waitForPageLoad(driver);
		return pEform;
	}

	/*
	 * @author : bhakti.sawant
	 * method to verify Eform details
	 */
	public static boolean verifyPEFormDetails(WebDriver driver, String testCaseName, PEform pEform) throws Exception
	{
		int noOfTextFields = 0;
		int noOfTextAreas = 0;
		if (!PageCreateCEform.verifySectionName(driver, testCaseName, pEform.getSectionName()))
			return false;
		if (pEform.getEformFileds() != null)
		{
			for (int i = 0; i < pEform.getEformFileds().size(); i++)
			{
				EformField eformField = pEform.getEformFileds().get(i);
				if (eformField.getFieldType().equalsIgnoreCase(IConstantsData.TEXT_FIELD))
				{
					if (!PageCreateCEform.verifyTextField(driver, testCaseName, eformField.getFieldName(), i, ++noOfTextFields))
						return false;
				}
				else if (eformField.getFieldType().equalsIgnoreCase(IConstantsData.TEXT_AREA))
				{
					if (!PageCreateCEform.verifyTextArea(driver, testCaseName, eformField.getFieldName(), i, ++noOfTextAreas))
						return false;
				}
				else if (eformField.getFieldType().equalsIgnoreCase(IConstantsData.CHECK_BOX))
				{
					if (!PageCreateCEform.verifyCheckBoxDetails(driver, testCaseName, eformField.getFieldName(), i, eformField.getCheckBoxChoicesList()))
						return false;
				}
			}
		}

		return true;
	}

	/*
	 * @author: bhakti.sawant
	 * method to add more than one field in Eform
	 */
	public static PEform createEformFields(WebDriver driver, String testCaseName, PEform pEform) throws ActionBotException
	{
		//to add more than one fields
		if (pEform.getEformFileds() != null)
		{
			// to add section
			PageCreateCEform.clickOnAddSectionLink(driver, testCaseName);
			// to fill section details
			pEform.setSectionName(ModalCreateSectionOfCEform.fillSectionName(driver, testCaseName, pEform.getSectionName()));
			ModalCreateSectionOfCEform.clickOnSaveSectionButton(driver, testCaseName);

			if (pEform.getEformFileds() != null)
			{
				for (int i = 0; i < pEform.getEformFileds().size(); i++)
				{
					EformField eformField = pEform.getEformFileds().get(i);

					if (eformField.getFieldType().equalsIgnoreCase(IConstantsData.TEXT_FIELD))
					{
						// to add field
						PageCreateCEform.clickOnAddFieldLink(driver, testCaseName);

						// to add text field
						ModalCreateFieldOfCEform.clickOnAddTextField(driver, testCaseName);

						// to fill field name
						pEform.setFieldName(ModalFieldPropertiesOfCEform.fillFieldName(driver, testCaseName, eformField.getFieldName()));

						ModalFieldPropertiesOfCEform.clickOnSaveFieldButton(driver, testCaseName);

					}
					else if (eformField.getFieldType().equalsIgnoreCase(IConstantsData.TEXT_AREA))
					{
						// to add field
						PageCreateCEform.clickOnAddFieldLink(driver, testCaseName);

						// to add text field
						ModalCreateFieldOfCEform.clickOnAddTextArea(driver, testCaseName);

						ActionBot.findElement(driver, IPageCEformListing.TEXT_AREA_FILED_NAME).sendKeys(eformField.getFieldName());

						//pEform.setFieldName(ModalFieldPropertiesOfCEform.fillFieldName(driver, testCaseName, eformField.getFieldName()));

						ModalFieldPropertiesOfCEform.clickOnSaveFieldButton(driver, testCaseName);
					}
					else if (eformField.getFieldType().equalsIgnoreCase(IConstantsData.CHECK_BOX))
					{
						// to add field
						PageCreateCEform.clickOnAddFieldLink(driver, testCaseName);

						// to add text field
						ModalCreateFieldOfCEform.clickOnAddCheckBox(driver, testCaseName);

						// to fill field name
						ActionBot.findElement(driver, IPageCEformListing.TEXT_AREA_FILED_NAME).sendKeys(eformField.getFieldName());

						//pEform.setFieldName(ModalFieldPropertiesOfCEform.fillFieldName(driver, testCaseName, eformField.getFieldName()));

						//to add choices of check box
						List<String> checkboxChoicesList = ModalCreateFieldOfCEform.enterChoicesForCheckBox(driver, testCaseName);
						pEform.getEformFileds().get(i).setCheckBoxChoicesList(checkboxChoicesList);

						ModalFieldPropertiesOfCEform.clickOnSaveFieldButton(driver, testCaseName);
					}
				}
			}

		}
		return pEform;
	}

	/*
	 * author : bhakti.sawant
	 * method to get eform details of file uploaded form (process form)
	 */
	public static PEform getFileUploadedPEFormDetails(WebDriver driver, String testCaseName, PEform pEform) throws Exception
	{
		if (!searchePEForm(driver, testCaseName, pEform.getPeformName()))
			return pEform;
		ActionBot.click(driver, IPageCreatePEform.EFORM_CLICK_FIRST_EFORM_LINK);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		PEform newpEform = PageCreateCEform.getFileUploadedPEformDetails(driver, testCaseName, pEform);

		pEform.setSectionName(newpEform.getSectionName());
		pEform.setEformFileds(newpEform.getEformFileds());
		return pEform;
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>To update PEForm <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param pEform
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static PEform updatePEform(WebDriver driver, String testCaseName, PEform pEform) throws ActionBotException
	{
		List<WebElement> element = PagePEformListing.getListOfPEformNames(driver, testCaseName);
		WebElement selectedEform = null;
		for (WebElement ele : element)
		{
			if (ele.getText().trim().equalsIgnoreCase(pEform.getPeformName()))
			{
				selectedEform = ele;
				Actions action = new Actions(driver);
				action.moveToElement(selectedEform).build().perform();
				break;
			}
		}

		ActionBot.click(driver, IPagePEformListing.LABEL_STATUS_OF_PEFORM);
		ActionBot.defaultSleep();
		PagePEformListing.clickOnUpdatePEformLink(driver, testCaseName);

		pEform = updatePEFormDetailsForUpdatePEform(driver, testCaseName, pEform);

		if (pEform.getNextAction().equalsIgnoreCase(IConstantsData.PUBLISH_EFORM))
		{
			PageCreateCEform.clickOnPublishCEformButton(driver, testCaseName);
		}
		else if (pEform.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_AS_DRAFT_EFORM))
		{
			PageCreateCEform.clickOnSaveCEformButton(driver, testCaseName);
		}
		else if (pEform.getNextAction().equalsIgnoreCase(IConstantsData.PREVIEW_EFORM))
		{
			PageCreateCEform.clickOnPreviewCEformButton(driver, testCaseName);
		}
		else if (pEform.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			PageCreateCEform.clickOnCancelCEformButton(driver, testCaseName);
		}
		else if (pEform.getNextAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			//Handling scenarios on test case level
		}
		else
		{
			logger.info("Invalid next action is specified for cEform");
		}
		return pEform;
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>Update PEform details <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param cEform
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static PEform updatePEFormDetailsForUpdatePEform(WebDriver driver, String testCaseName, PEform pEform) throws ActionBotException
	{
		// To save and continue
		PageCreatePEform.clickOnSavePEformButton(driver, testCaseName);

		if (pEform.isAddSectionAndField())
		{
			// To add field
			PageCreateCEform.clickOnAddFieldLink(driver, testCaseName);
			// To add text field
			ModalCreateFieldOfCEform.clickOnAddTextField(driver, testCaseName);
			// To fill field properties
			pEform.setFieldName(ModalFieldPropertiesOfCEform.fillFieldName(driver, testCaseName, pEform.getFieldName() + "modified"));
			ModalFieldPropertiesOfCEform.clickOnSaveFieldButton(driver, testCaseName);
		}
		return pEform;
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>to Export PEform <br>
	 */
	public static void exportPEform(WebDriver driver, String testCaseName, String eformName) throws ActionBotException
	{
		List<WebElement> element = PagePEformListing.getListOfPEformNames(driver, testCaseName);
		WebElement selectedEform = null;
		for (WebElement ele : element)
		{
			if (ele.getText().trim().equalsIgnoreCase(eformName))
			{
				selectedEform = ele;
				Actions action = new Actions(driver);
				action.moveToElement(selectedEform).build().perform();
				break;
			}
		}
		ActionBot.click(driver, IPagePEformListing.LABEL_STATUS_OF_PEFORM);
		PagePEformListing.clickOnExportPEformLink(driver, testCaseName);
	}

}
