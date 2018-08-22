/**
 * 
 */
package com.zycus.automation.eproc.businessflow.ceformflow;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zycus.automation.bo.CEform;
import com.zycus.automation.bo.EformField;
import com.zycus.automation.eproc.pageobjects.modals.createfieldofceform.ModalCreateFieldOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.createsectionofceform.ModalCreateSectionOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.fieldpropertiesofceform.ModalFieldPropertiesOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.previewceform.ModalPreviewCEform;
import com.zycus.automation.eproc.pageobjects.modals.selectbuofceform.ModalSelectBUOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.selectcatalogcompaniesandbu.ModalSelectCompaniesAndBU;
import com.zycus.automation.eproc.pageobjects.modals.selectcategoryofceform.ModalSelectCategoryOfCEform;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.ceformlisting.IPageCEformListing;
import com.zycus.automation.eproc.pageobjects.pages.ceformlisting.PageCEformListing;
import com.zycus.automation.eproc.pageobjects.pages.createceform.PageCreateCEform;
import com.zycus.automation.eproc.pageobjects.pages.createpeform.IPageCreatePEform;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;

/**
 * @author ankita.sawant
 */
public class FlowCEform
{
	static Logger logger = Logger.getLogger(FlowCEform.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To create Category Eform <br>
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
	public static CEform createCEform(WebDriver driver, String testCaseName, CEform cEform) throws ActionBotException
	{
		MainPageHeaderLevelTab.clickOnEformTab(driver, testCaseName);
		MainPageHeaderLevelTab.clickOnCategoryEformTab(driver, testCaseName);

		PageCEformListing.clickOnOnlineEditor(driver, testCaseName);

		cEform = fillCEFormDetails(driver, testCaseName, cEform);

		if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.PUBLISH_EFORM))
		{
			PageCreateCEform.clickOnPublishCEformButton(driver, testCaseName);
		}
		else if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_AS_DRAFT_EFORM))
		{
			PageCreateCEform.clickOnSaveCEformButton(driver, testCaseName);
		}
		else if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.PREVIEW_EFORM))
		{
			PageCreateCEform.clickOnPreviewCEformButton(driver, testCaseName);
		}
		else if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			PageCreateCEform.clickOnCancelCEformButton(driver, testCaseName);
		}
		else if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			//Handling scenarios on test case level
		}
		else
		{
			logger.info("Invalid next action is specified for cEform");
		}
		return cEform;
	}

	/**
	 * 
	 * @author sanchali.saha
	 *         method: to create FileUpload ceform
	 */
	public static CEform createFileUploadCEForm(WebDriver driver, String testCaseName, CEform cEform) throws Exception
	{
		MainPageHeaderLevelTab.clickOnCategoryEformTab(driver, testCaseName);

		PageCEformListing.clickOnFileUpload(driver, testCaseName);

		cEform = fillCEFormDetails(driver, testCaseName, cEform);
		if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.IMPORT_PEFORM))
		{
			PageCreateCEform.clickOnImportCEformButton(driver, testCaseName);
			//driver.findElement(By.xpath(".//*[@id='btnImportEform']")).click();
		}
		cEform.setCeformName(CommonServices.getTestData(IConstantsData.CEFORM_FILE_UPLOAD_NAME));
		ActionBot.waitForPageLoad(driver);
		return cEform;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>to Deactivate Eform <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param eformName
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 * @return
	 */
	public static boolean deactivateCEform(WebDriver driver, String testCaseName, String eformName) throws ActionBotException
	{
		MainPageHeaderLevelTab.clickOnCategoryEformTab(driver, testCaseName);
		searchCEform(driver, testCaseName, eformName);
		// first deactivate
		List<WebElement> element = PageCEformListing.getAllCEforms(driver, testCaseName);
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

		// ActionBot.hover(driver, selectedEform);
		// ActionBot.defaultSleep();
		/*
		 * action.moveToElement( ActionBot.findElement( driver,
		 * By.xpath(".//*[@id='categoryFormGrid']//tr[.//*[contains(text(),'" +
		 * eformName +
		 * "')]]//a[contains(@class,'eDeactive')]"))).click().build().perform();
		 *///
		ActionBot.click(driver, IPageCEformListing.LABEL_STATUS_OF_CEFORM);
		ActionBot.defaultSleep();
		PageCEformListing.clickOnDeactivateCEform(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.stalenessOf(selectedEform));
		//ActionBot.defaultMediumSleep();

		// to check status of PEForm
		String status = PageCEformListing.getStatusOfFirstCEform(driver, testCaseName);
		boolean flag = status.contains(IConstantsData.INACTIVE_STATUS);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To Deactivate and Delete Eform <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param eformName
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void deactivateNdeleteCEform(WebDriver driver, String testCaseName, String eformName) throws ActionBotException
	{
		MainPageHeaderLevelTab.clickOnCategoryEformTab(driver, testCaseName);
		searchCEform(driver, testCaseName, eformName);
		// first deactivate
		List<WebElement> element = PageCEformListing.getAllCEforms(driver, testCaseName);
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
		// ActionBot.hover(driver, selectedEform);
		// ActionBot.defaultSleep();
		ActionBot.click(driver, IPageCEformListing.LABEL_STATUS_OF_CEFORM);
		PageCEformListing.clickOnDeactivateCEform(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		// wait till the element is stale
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.stalenessOf(selectedEform));
		//ActionBot.defaultHighSleep();

		// MainPageHeaderLevelTab.clickOnCategoryEformTab(driver, testCaseName);
		ActionBot.defaultSleep();
		element = PageCEformListing.getAllCEforms(driver, testCaseName);
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
		ActionBot.hover(driver, selectedEform);
		// ActionBot.defaultSleep();
		ActionBot.click(driver, IPageCEformListing.LABEL_STATUS_OF_CEFORM);
		PageCEformListing.clickOnDeleteCEform(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To delete CEfrom <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param cEformName
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static boolean deleteCEform(WebDriver driver, String testCaseName, String cEformName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		List<WebElement> element = PageCEformListing.getAllCEforms(driver, testCaseName);
		WebElement selectedEform = null;
		Actions action = new Actions(driver);
		for (WebElement ele : element)
		{
			if (ele.getText().trim().equalsIgnoreCase(cEformName))
			{
				selectedEform = ele;
				action.moveToElement(selectedEform).build().perform();
				break;
			}
		}
		// delete eform
		ActionBot.hover(driver, selectedEform);
		// ActionBot.defaultSleep();
		/*
		 * action.moveToElement( ActionBot.findElement( driver,
		 * By.xpath(".//*[@id='categoryFormGrid']//tr[.//*[contains(text(),'" +
		 * cEformName +
		 * "')]]//a[contains(@class,'eDelete')]"))).click().build().perform();
		 *///
		ActionBot.click(driver, IPageCEformListing.LABEL_STATUS_OF_CEFORM);
		PageCEformListing.clickOnDeleteCEform(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

		// to search ceform
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		System.out.println("searchCEform result : " + searchCEform(driver, testCaseName, cEformName));
		boolean flag = PageAllRequestsApproval.getApprovalEmptyTableSize(driver, testCaseName) == 1;
		System.out.println("Flag : " + flag);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>fill CEform details <br>
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
	public static CEform fillCEFormDetails(WebDriver driver, String testCaseName, CEform cEform) throws ActionBotException
	{
		if (cEform.getCeformName() != null)
		{
			cEform.setCeformName(PageCreateCEform.fillCFormName(driver, testCaseName, cEform.getCeformName()));
		}
		if (cEform.getCeformDisplayName() != null)
		{
			cEform.setCeformDisplayName(PageCreateCEform.fillCFormDisplayName(driver, testCaseName, cEform.getCeformDisplayName()));
		}

		if (cEform.isChangeCategory())
		{
			// to select categories
			PageCreateCEform.clickOnLinkSelectCategoriesForCForm(driver, testCaseName);

			if (cEform.getCategory() != null)
			{
				cEform.setCategory(ModalSelectCategoryOfCEform.clickOnCategoryCheckbox(driver, testCaseName, cEform.getCategory()));
			}
			else
			{
				ModalSelectCategoryOfCEform.clickOnSelectAllCategories(driver, testCaseName);
			}

			ModalSelectCategoryOfCEform.clickOnSaveCEfromCategoryButton(driver, testCaseName);
		}
		//Selecting Scope for Carlson specific
		if (cEform.isCarlsonOU())
		{
			// to select OU
			PageCreateCEform.clickOnLinkSelectOUForCForm(driver, testCaseName);
			ActionBot.defaultLowSleep();
			//click on Expand box under Regions Tab and select all Regions
			ModalSelectCompaniesAndBU.selectAllOU(driver, testCaseName, cEform.getRegionName());
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
		else if (cEform.isChangeOU())
		{
			// to select OU
			PageCreateCEform.clickOnLinkSelectOUForCForm(driver, testCaseName);
			// need to change code later
			ActionBot.defaultLowSleep();
			ModalSelectBUOfCEform.selectIstOrganisationUnit(driver, testCaseName);
			// select bu
			ActionBot.defaultSleep();
			ModalSelectBUOfCEform.clickTabBusinessUnit(driver, testCaseName);
			ActionBot.defaultSleep();
			ModalSelectBUOfCEform.clickLinkSelectBusinessUnit(driver, testCaseName);
			ActionBot.defaultSleep();
			ModalSelectBUOfCEform.SelectCheckBoxOU(driver, testCaseName);
			// save modal
			ModalSelectBUOfCEform.clickBtnSaveSelectedOu(driver, testCaseName);
			ActionBot.defaultSleep();
			ModalSelectBUOfCEform.clickOnSaveORGUnitButton(driver, testCaseName);
		}
		if (cEform.isFileUpload())
		{
			if (cEform.getAttachmentFileName() != null)
				PageCreateCEform.selectFileForCeformUpload(driver, testCaseName, cEform.getAttachmentFileName());
			else
				PageCreateCEform.selectFileForCeformUpload(driver, testCaseName);
		}
		// to save and continue
		PageCreateCEform.clickOnSaveAndContinue(driver, testCaseName);

		if (cEform.isAddSectionMultipleFields())
		{
			//to add more than one fields
			cEform = createEformFields(driver, testCaseName, cEform);
		}
		if (cEform.isAddSectionAndField())
		{
			// to add section
			PageCreateCEform.clickOnAddSectionLink(driver, testCaseName);
			// to fill section details
			cEform.setSectionName(ModalCreateSectionOfCEform.fillSectionName(driver, testCaseName, cEform.getSectionName()));
			ModalCreateSectionOfCEform.clickOnSaveSectionButton(driver, testCaseName);

			// to add field
			PageCreateCEform.clickOnAddFieldLink(driver, testCaseName);

			// to add text field
			ModalCreateFieldOfCEform.clickOnAddTextField(driver, testCaseName);
			// to fill field properties
			cEform.setFieldName(ModalFieldPropertiesOfCEform.fillFieldName(driver, testCaseName, cEform.getFieldName()));
			cEform.setFieldDefaultValues(ModalFieldPropertiesOfCEform.fillFieldDefaultValue(driver, testCaseName, cEform.getFieldDefaultValues()));
			cEform.setFieldToolTipValue(ModalFieldPropertiesOfCEform.fillFieldToolTip(driver, testCaseName, cEform.getFieldToolTipValue()));
			ModalFieldPropertiesOfCEform.clickOnSaveFieldButton(driver, testCaseName);

			//setting name and type of field in EformField for future verification
			EformField eformField = new EformField(cEform.getFieldName(), "Text Field");
			List<EformField> eformFieldsList = new ArrayList<>();
			eformFieldsList.add(eformField);
			cEform.setEformFileds(eformFieldsList);
		}
		return cEform;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>fill CEform details <br>
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
	public static CEform updateCEFormDetails(WebDriver driver, String testCaseName, CEform cEform) throws ActionBotException
	{
		if (cEform.getCeformName() != null)
		{
			cEform.setCeformName(PageCreateCEform.fillCFormName(driver, testCaseName, cEform.getCeformName()));
		}
		if (cEform.getCeformDisplayName() != null)
		{
			cEform.setCeformDisplayName(PageCreateCEform.fillCFormDisplayName(driver, testCaseName, cEform.getCeformDisplayName()));
		}

		if (cEform.isChangeCategory())
		{
			// to select categories
			PageCreateCEform.clickOnLinkSelectCategoriesForCForm(driver, testCaseName);

			if (cEform.getCategory() != null)
			{
				cEform.setCategory(ModalSelectCategoryOfCEform.clickOnCategoryCheckbox(driver, testCaseName, cEform.getCategory()));
			}
			else
			{
				ModalSelectCategoryOfCEform.clickOnSelectAllCategories(driver, testCaseName);
			}

			ModalSelectCategoryOfCEform.clickOnSaveCEfromCategoryButton(driver, testCaseName);
		}
		/*
		 * if (cEform.isChangeOU()) { //to select OU
		 * PageCreateCEform.clickOnLinkSelectOUForCForm(driver, testCaseName);
		 * if (cEform.getOU() != null) {
		 * cEform.setOU(ModalSelectBUOfCEform.clickOnOU(driver, testCaseName,
		 * cEform.getOU())); } else { ModalSelectBUOfCEform.selectAllOU(driver,
		 * testCaseName); } //need to change code later
		 * ModalSelectBUOfCEform.selectSECOrganisationUnit(driver,
		 * testCaseName); //select bu
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
		PageCreateCEform.clickOnSaveAndContinue(driver, testCaseName);

		if (cEform.isAddSectionAndField())
		{
			// to add section
			PageCreateCEform.clickOnAddSectionLink(driver, testCaseName);
			// to fill section details
			cEform.setSectionName(ModalCreateSectionOfCEform.fillSectionName(driver, testCaseName, cEform.getSectionName()));
			ModalCreateSectionOfCEform.clickOnSaveSectionButton(driver, testCaseName);

			// to add field
			PageCreateCEform.clickOnAddFieldLink(driver, testCaseName);

			// to add text field
			ModalCreateFieldOfCEform.clickOnAddTextField(driver, testCaseName);
			// to fill field properties
			cEform.setFieldName(ModalFieldPropertiesOfCEform.fillFieldName(driver, testCaseName, cEform.getFieldName()));
			ModalFieldPropertiesOfCEform.clickOnSaveFieldButton(driver, testCaseName);
		}
		return cEform;
	}

	public static boolean searchCEform(WebDriver driver, String testCaseName, String cEformName) throws ActionBotException
	{
		boolean flag = false;
		MainPageHeaderLevelTab.clickOnEformTab(driver, testCaseName);
		MainPageHeaderLevelTab.clickOnCategoryEformTab(driver, testCaseName);
		PageCEformListing.selectSearchInOptionForCEform(driver, testCaseName, 1);
		PageCEformListing.fillSearchCEform(driver, testCaseName, cEformName);

		flag = checkIfCEformSearched(driver, testCaseName, cEformName);
		return flag;
	}

	public static boolean checkIfCEformSearched(WebDriver driver, String testCaseName, String cEformName) throws ActionBotException
	{
		boolean flag = false;

		List<WebElement> element = PageCEformListing.getAllCEforms(driver, testCaseName);

		for (WebElement ele : element)
		{
			if (ele.getText().trim().equalsIgnoreCase(cEformName))
			{
				flag = true;
				break;
			}
		}
		return flag;
	}

	public static boolean previewCEForm(WebDriver driver, String testCaseName, CEform cEform) throws ActionBotException
	{
		boolean flag = false;
		String sectionName, fieldName, fieldTag;
		PageCreateCEform.clickOnPreviewCEformButton(driver, testCaseName);

		logger.info("Values as on preview PEform : ");
		sectionName = ModalPreviewCEform.getSectionName(driver, testCaseName);
		fieldName = ModalPreviewCEform.getFieldName(driver, testCaseName);
		fieldTag = ModalPreviewCEform.getTagNameOfFieldValue(driver, testCaseName);

		ModalPreviewCEform.clickOnClosePreviewButton(driver, testCaseName);

		flag = sectionName.equalsIgnoreCase(cEform.getSectionName()) && fieldName.equalsIgnoreCase(cEform.getFieldName()) && fieldTag.equalsIgnoreCase("input");

		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To modify CEForm <br>
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
	public static CEform modifyCEform(WebDriver driver, String testCaseName, CEform cEform) throws ActionBotException
	{
		List<WebElement> element = PageCEformListing.getAllCEforms(driver, testCaseName);
		WebElement selectedEform = null;
		for (WebElement ele : element)
		{
			if (ele.getText().trim().equalsIgnoreCase(cEform.getCeformName()))
			{
				selectedEform = ele;
				Actions action = new Actions(driver);
				action.moveToElement(selectedEform).build().perform();
				break;
			}
		}
		// ActionBot.hover(driver, selectedEform);
		// ActionBot.defaultSleep();
		ActionBot.click(driver, IPageCEformListing.LABEL_STATUS_OF_CEFORM);
		ActionBot.defaultSleep();
		PageCEformListing.clickOnModifyCEform(driver, testCaseName);

		cEform = updateCEFormDetails(driver, testCaseName, cEform);

		if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.PUBLISH_EFORM))
		{
			PageCreateCEform.clickOnPublishCEformButton(driver, testCaseName);
		}
		else if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_AS_DRAFT_EFORM))
		{
			PageCreateCEform.clickOnSaveCEformButton(driver, testCaseName);
		}
		else if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.PREVIEW_EFORM))
		{
			PageCreateCEform.clickOnPreviewCEformButton(driver, testCaseName);
		}
		else if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			PageCreateCEform.clickOnCancelCEformButton(driver, testCaseName);
		}
		else if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			//Handling scenarios on test case level
		}
		else
		{
			logger.info("Invalid next action is specified for cEform");
		}
		return cEform;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Copy CEform <br>
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
	 * @throws Exception
	 *         </b> <br>
	 */
	public static CEform copyCEForm(WebDriver driver, String testCaseName, CEform cEform, String newOUName) throws Exception
	{
		List<WebElement> element = PageCEformListing.getAllCEforms(driver, testCaseName);
		WebElement selectedEform = null;
		String sectionName, fieldName, fieldTag;

		boolean flag = false, ouFlag = false;

		for (WebElement ele : element)
		{
			if (ele.getText().trim().equalsIgnoreCase(cEform.getCeformName()))
			{
				selectedEform = ele;
				Actions actions = new Actions(driver);
				actions.moveToElement(selectedEform).build().perform();
				break;
			}
		}
		ActionBot.hover(driver, selectedEform);
		// ActionBot.defaultSleep();
		ActionBot.click(driver, IPageCEformListing.LABEL_STATUS_OF_CEFORM);
		PageCEformListing.clickOnCopyCEform(driver, testCaseName);

		cEform.setCeformName(PageCreateCEform.fillCFormName(driver, testCaseName, "Copy_" + CommonUtilities.getCEformName()));

		cEform.setCeformDisplayName(PageCreateCEform.fillCFormDisplayName(driver, testCaseName, cEform.getCeformName()));

		if (cEform.isChangeCategory())
		{
			// to select categories
			PageCreateCEform.clickOnLinkSelectCategoriesForCForm(driver, testCaseName);

			if (cEform.getCategory() != null)
			{
				cEform.setCategory(ModalSelectCategoryOfCEform.clickOnCategoryCheckbox(driver, testCaseName, cEform.getCategory()));
			}
			else
			{
				ModalSelectCategoryOfCEform.clickOnSelectAllCategories(driver, testCaseName);
			}

			ModalSelectCategoryOfCEform.clickOnSaveCEfromCategoryButton(driver, testCaseName);
		}

		/*
		 * if (cEform.isChangeOU()) { //to select OU
		 * PageCreateCEform.clickOnLinkSelectOUForCForm(driver, testCaseName);
		 * //to check copied ou name if (cEform.getOU() != null) { ouFlag =
		 * ModalSelectBUOfCEform.isOUSelectedOrNot(driver, testCaseName,
		 * cEform.getOU()); } //to clear all selected ou's
		 * ModalSelectBUOfCEform.clearAllSelectedOUs(driver, testCaseName); //to
		 * change OU if (newOUName != null) { if (newOUName !=
		 * IConstantsData.ALL) {
		 * cEform.setOU(ModalSelectBUOfCEform.clickOnOU(driver, testCaseName,
		 * newOUName)); } else { ModalSelectBUOfCEform.selectAllOU(driver,
		 * testCaseName); } } else { ModalSelectBUOfCEform.selectAllOU(driver,
		 * testCaseName); }
		 * //ModalSelectBUOfCEform.clickOnSaveORGUnitButton(driver,
		 * testCaseName); }
		 */
		// to save and continue
		PageCreateCEform.clickOnSaveAndContinue(driver, testCaseName);

		sectionName = PageCreateCEform.getSectionName(driver, testCaseName);
		fieldName = PageCreateCEform.getFieldName(driver, testCaseName);
		fieldTag = PageCreateCEform.getTagNameOfFieldValue(driver, testCaseName);

		System.out.println("Section Name :->" + sectionName);
		System.out.println("Section Name :==>" + cEform.getSectionName());
		System.out.println("Section name : " + sectionName.contains(cEform.getSectionName()));
		System.out.println("Field Name :->" + fieldName);
		System.out.println("Field Name :==>" + cEform.getFieldName());
		System.out.println("fieldName : " + fieldName.contains(cEform.getFieldName()));
		System.out.println("fieldTag : " + fieldTag.equalsIgnoreCase("input"));
		System.out.println("OU : " + ouFlag);

		flag = sectionName.contains(cEform.getSectionName()) && fieldName.contains(cEform.getFieldName()) && fieldTag.equalsIgnoreCase("input");

		cEform.setResult(flag);

		PageCreateCEform.clickOnPublishCEformButton(driver, testCaseName);

		return cEform;
	}

	/*
	 * @author : bhakti.sawant
	 * method to verify Eform details
	 */
	public static boolean verifyCEFormDetails(WebDriver driver, String testCaseName, CEform cEform) throws Exception
	{
		int noOfTextFields = 0;
		int noOfTextAreas = 0;
		if (!PageCreateCEform.verifySectionName(driver, testCaseName, cEform.getSectionName()))
		{
			logger.info("heder info is not matching");
			//return false;

		}
		if (cEform.getEformFileds() != null)
		{
			for (int i = 0; i < cEform.getEformFileds().size(); i++)
			{
				EformField eformField = cEform.getEformFileds().get(i);
				if (eformField.getFieldType().equalsIgnoreCase(IConstantsData.TEXT_FIELD))
				{
					if (!PageCreateCEform.verifyTextField(driver, testCaseName, eformField.getFieldName(), i, ++noOfTextFields))
					{
						logger.info("text field is not matching");
						return false;

					}
				}
				else if (eformField.getFieldType().equalsIgnoreCase(IConstantsData.TEXT_AREA))
				{
					if (!PageCreateCEform.verifyTextArea(driver, testCaseName, eformField.getFieldName(), i, ++noOfTextAreas))
					{
						logger.info("text area info is not matching");
						return false;

					}
				}
				else if (eformField.getFieldType().equalsIgnoreCase(IConstantsData.CHECK_BOX))
				{
					if (!PageCreateCEform.verifyCheckBoxDetails(driver, testCaseName, eformField.getFieldName(), i, eformField.getCheckBoxChoicesList()))
					{
						logger.info("check box is not matching");
						return false;

					}
				}
			}
		}

		return true;
	}

	/*
	 * @author: bhakti.sawant
	 * method to add more than one field in Eform
	 */
	public static CEform createEformFields(WebDriver driver, String testCaseName, CEform cEform) throws ActionBotException
	{
		//to add more than one fields
		if (cEform.getEformFileds() != null)
		{
			// to add section
			PageCreateCEform.clickOnAddSectionLink(driver, testCaseName);
			// to fill section details
			cEform.setSectionName(ModalCreateSectionOfCEform.fillSectionName(driver, testCaseName, cEform.getSectionName()));
			ModalCreateSectionOfCEform.clickOnSaveSectionButton(driver, testCaseName);

			if (cEform.getEformFileds() != null)
			{
				for (int i = 0; i < cEform.getEformFileds().size(); i++)
				{
					EformField eformField = cEform.getEformFileds().get(i);

					if (eformField.getFieldType().equalsIgnoreCase(IConstantsData.TEXT_FIELD))
					{
						// to add field
						PageCreateCEform.clickOnAddFieldLink(driver, testCaseName);

						// to add text field
						ModalCreateFieldOfCEform.clickOnAddTextField(driver, testCaseName);

						// to fill field name
						cEform.setFieldName(ModalFieldPropertiesOfCEform.fillFieldName(driver, testCaseName, eformField.getFieldName()));

						ModalFieldPropertiesOfCEform.clickOnSaveFieldButton(driver, testCaseName);

					}
					else if (eformField.getFieldType().equalsIgnoreCase(IConstantsData.TEXT_AREA))
					{
						// to add field
						PageCreateCEform.clickOnAddFieldLink(driver, testCaseName);

						// to add text field
						ModalCreateFieldOfCEform.clickOnAddTextArea(driver, testCaseName);

						// to fill field name FOR TEXT AREA
						ActionBot.findElement(driver, IPageCEformListing.TEXT_AREA_FILED_NAME).sendKeys(eformField.getFieldName());

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

						//to add choices of check box
						List<String> checkboxChoicesList = ModalCreateFieldOfCEform.enterChoicesForCheckBox(driver, testCaseName);
						cEform.getEformFileds().get(i).setCheckBoxChoicesList(checkboxChoicesList);

						ModalFieldPropertiesOfCEform.clickOnSaveFieldButton(driver, testCaseName);
					}
				}
			}

		}
		return cEform;
	}

	/*
	 * author : bhakti.sawant : get details of CE form
	 */
	public static CEform getFileUploadedCEFormDetails(WebDriver driver, String testCaseName, CEform cEform) throws Exception
	{
		MainPageHeaderLevelTab.clickOnCategoryEformTab(driver, testCaseName);

		if (!searchCEform(driver, testCaseName, cEform.getCeformName()))
			return cEform;
		ActionBot.click(driver, IPageCreatePEform.EFORM_CLICK_FIRST_EFORM_LINK);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		CEform newcEform = PageCreateCEform.getFileUploadedCEformDetails(driver, testCaseName, cEform);
		ActionBot.defaultSleep();

		cEform.setSectionName(newcEform.getSectionName());
		cEform.setEformFileds(newcEform.getEformFileds());
		return cEform;
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>To Activate Eform <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param eformName
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 * @return
	 */
	public static boolean activateCEform(WebDriver driver, String testCaseName, String eformName) throws ActionBotException
	{
		MainPageHeaderLevelTab.clickOnEformTab(driver, testCaseName);
		MainPageHeaderLevelTab.clickOnCategoryEformTab(driver, testCaseName);
		searchCEform(driver, testCaseName, eformName);
		List<WebElement> element = PageCEformListing.getAllCEforms(driver, testCaseName);
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

		ActionBot.click(driver, IPageCEformListing.LABEL_STATUS_OF_CEFORM);
		ActionBot.defaultSleep();
		PageCEformListing.clickOnActivateCEform(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.stalenessOf(selectedEform));
		// To check status of EForm
		String status = PageCEformListing.getStatusOfFirstCEform(driver, testCaseName);
		boolean flag = status.contains(IConstantsData.ACTIVE_STATUS);
		return flag;
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>To update CEForm <br>
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
	public static CEform updateCEform(WebDriver driver, String testCaseName, CEform cEform) throws ActionBotException
	{
		List<WebElement> element = PageCEformListing.getAllCEforms(driver, testCaseName);
		WebElement selectedEform = null;
		for (WebElement ele : element)
		{
			if (ele.getText().trim().equalsIgnoreCase(cEform.getCeformName()))
			{
				selectedEform = ele;
				Actions action = new Actions(driver);
				action.moveToElement(selectedEform).build().perform();
				break;
			}
		}
		// ActionBot.hover(driver, selectedEform);
		// ActionBot.defaultSleep();
		ActionBot.click(driver, IPageCEformListing.LABEL_STATUS_OF_CEFORM);
		ActionBot.defaultSleep();
		PageCEformListing.clickOnUpdateCEform(driver, testCaseName);

		cEform = updateCEFormDetailsForUpdateCEform(driver, testCaseName, cEform);

		if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.PUBLISH_EFORM))
		{
			PageCreateCEform.clickOnPublishCEformButton(driver, testCaseName);
		}
		else if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_AS_DRAFT_EFORM))
		{
			PageCreateCEform.clickOnSaveCEformButton(driver, testCaseName);
		}
		else if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.PREVIEW_EFORM))
		{
			PageCreateCEform.clickOnPreviewCEformButton(driver, testCaseName);
		}
		else if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			PageCreateCEform.clickOnCancelCEformButton(driver, testCaseName);
		}
		else if (cEform.getNextAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			//Handling scenarios on test case level
		}
		else
		{
			logger.info("Invalid next action is specified for cEform");
		}
		return cEform;
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>fill CEform details <br>
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
	public static CEform updateCEFormDetailsForUpdateCEform(WebDriver driver, String testCaseName, CEform cEform) throws ActionBotException
	{

		if (cEform.getCeformDisplayName() != null)
		{
			cEform.setCeformDisplayName(PageCreateCEform.fillCFormDisplayName(driver, testCaseName, cEform.getCeformDisplayName()));
		}

		if (cEform.isChangeCategory())
		{
			// to select categories
			PageCreateCEform.clickOnLinkSelectCategoriesForCForm(driver, testCaseName);

			if (cEform.getCategory() != null)
			{
				cEform.setCategory(ModalSelectCategoryOfCEform.clickOnCategoryCheckbox(driver, testCaseName, cEform.getCategory()));
			}
			else
			{
				ModalSelectCategoryOfCEform.clickOnSelectAllCategories(driver, testCaseName);
			}

			ModalSelectCategoryOfCEform.clickOnSaveCEfromCategoryButton(driver, testCaseName);
		}
		/*
		 * if (cEform.isChangeOU()) { //to select OU
		 * PageCreateCEform.clickOnLinkSelectOUForCForm(driver, testCaseName);
		 * if (cEform.getOU() != null) {
		 * cEform.setOU(ModalSelectBUOfCEform.clickOnOU(driver, testCaseName,
		 * cEform.getOU())); } else { ModalSelectBUOfCEform.selectAllOU(driver,
		 * testCaseName); } //need to change code later
		 * ModalSelectBUOfCEform.selectSECOrganisationUnit(driver,
		 * testCaseName); //select bu
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
		PageCreateCEform.clickOnSaveAndContinue(driver, testCaseName);

		if (cEform.isAddSectionAndField())
		{
			// to add section
			PageCreateCEform.clickOnAddSectionLink(driver, testCaseName);
			// to fill section details
			cEform.setSectionName(ModalCreateSectionOfCEform.fillSectionName(driver, testCaseName, cEform.getSectionName()));
			ModalCreateSectionOfCEform.clickOnSaveSectionButton(driver, testCaseName);

			// to add field
			PageCreateCEform.clickOnAddFieldLink(driver, testCaseName);

			// to add text field
			ModalCreateFieldOfCEform.clickOnAddTextField(driver, testCaseName);
			// to fill field properties
			cEform.setFieldName(ModalFieldPropertiesOfCEform.fillFieldName(driver, testCaseName, cEform.getFieldName()));
			ModalFieldPropertiesOfCEform.clickOnSaveFieldButton(driver, testCaseName);
		}
		return cEform;
	}

	/**
	 * <b>Author: Rohini Shinge </b> <b><br>
	 * <font color="blue">Method :</b>to Export CEform <br>
	 */
	public static void exportCEform(WebDriver driver, String testCaseName, String eformName) throws ActionBotException
	{
		MainPageHeaderLevelTab.clickOnCategoryEformTab(driver, testCaseName);
		searchCEform(driver, testCaseName, eformName);
		List<WebElement> element = PageCEformListing.getAllCEforms(driver, testCaseName);
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
		ActionBot.click(driver, IPageCEformListing.LABEL_STATUS_OF_CEFORM);
		ActionBot.defaultSleep();
		PageCEformListing.clickOnExportCEform(driver, testCaseName);

	}
}
