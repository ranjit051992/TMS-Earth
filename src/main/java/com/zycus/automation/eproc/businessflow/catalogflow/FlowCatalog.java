/**
 * 
 */
package com.zycus.automation.eproc.businessflow.catalogflow;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.Catalog;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.modals.additemtocatalog.ModalAddItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.cataloglistingactions.ModalCatalogListingActions;
import com.zycus.automation.eproc.pageobjects.modals.recallcatalog.ModalRecallCatalog;
import com.zycus.automation.eproc.pageobjects.modals.selectbuofceform.ModalSelectBUOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.selectcatalogcompaniesandbu.ModalSelectCompaniesAndBU;
import com.zycus.automation.eproc.pageobjects.modals.submitforapproval.ModalSubmitForApproval;
import com.zycus.automation.eproc.pageobjects.modals.uploaditemsincatalog.ModalUploadItemsInCatalog;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.cataloglisting.IPageCatalogListing;
import com.zycus.automation.eproc.pageobjects.pages.cataloglisting.PageCatalogListing;
import com.zycus.automation.eproc.pageobjects.pages.catalogview.PageCatalogView;
import com.zycus.automation.eproc.pageobjects.pages.createcatalog.IPageCreateCatalog;
import com.zycus.automation.eproc.pageobjects.pages.createcatalog.PageCreateCatalog;
import com.zycus.automation.eproc.pageobjects.pages.createceform.PageCreateCEform;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 * 
 */
public class FlowCatalog
{
	static Logger	logger	= Logger.getLogger(FlowCatalog.class);

	public static boolean searchCatalog(WebDriver driver, String testCaseName, String catalogName) throws ActionBotException
	{
		boolean flag = false;
		String status = null;
		// click on catalog tab
		MainPageHeaderLevelTab.clickOnCatalogSubTab(driver, testCaseName);
		// search catalog
		PageCatalogListing.fillSearchCatalogName(driver, testCaseName, catalogName);
		String searchedCatalogName = PageCatalogListing.getFirstCatalogName(driver, testCaseName);
		// check if catalog is searched
		flag = searchedCatalogName.contains(catalogName);
		status = PageCatalogListing.getStatusOfFirstCatalog(driver, testCaseName);

		if (!(status.equalsIgnoreCase(IConstantsData.PUBLISHED_CATALOG_LABEL)))
		{
			ActionBot.defaultMediumSleep();
			ActionBot.refreshPage(driver, testCaseName);
			ActionBot.waitForPageLoad(driver);
			PageCatalogListing.fillSearchCatalogName(driver, testCaseName, catalogName);
		}
		return flag;
	}

	public static Catalog createCatalog(WebDriver driver, String testCaseName, Catalog catalog) throws Exception
	{
		// click on catalog tab
		MainPageHeaderLevelTab.clickOnCatalogSubTab(driver, testCaseName);
		PageCatalogListing.clickOnAddCatalogButton(driver, testCaseName);

		// to fill catalog wizard
		catalog = fillCreateCatalogWizard(driver, testCaseName, catalog);
		if (catalog == null)
		{
			return catalog;
		}
		// submit catalog
		if (catalog.getNextAction().equalsIgnoreCase(IConstantsData.SUBMIT_CATALOG))
		{
			submitCatalog(driver, testCaseName, catalog.isMarkForAddingApprover(), false);
		}
		// discard catalog
		else if (catalog.getNextAction().equalsIgnoreCase(IConstantsData.DISCARD_CATALOG))
		{
			PageCreateCatalog.clickOnDiscardCatalogButton(driver, testCaseName);
		}
		// close catalog
		else if (catalog.getNextAction().equalsIgnoreCase(IConstantsData.CLOSE_CATALOG))
		{
			PageCreateCatalog.clickOnCloseCatalogButton(driver, testCaseName);
		}
		return catalog;
	}

	public static Catalog fillCreateCatalogWizard(WebDriver driver, String testCaseName, Catalog catalog) throws Exception
	{
		UI_Elements DUPLICATE_NAME_ERROR = UIFactory.getElements("DUPLICATE_NAME_ERROR");
		// to fill catalog details
		if (catalog.isFillCatalogDetails())
		{
			catalog = fillCatalogDetails(driver, testCaseName, catalog);
			if (ActionBot.isElementPresent(driver, DUPLICATE_NAME_ERROR))
			{
				String duplicateNameError = ActionBot.findElement(driver, DUPLICATE_NAME_ERROR).getText();
				if (duplicateNameError.equalsIgnoreCase("A catalog with the same name exists within the organization. Please use another name."))
				{
					catalog.setCatalogDetailsNextAction(IConstantsData.CANCEL);
				}
			}
		}
		// to decide next action
		if (catalog.getCatalogDetailsNextAction().equalsIgnoreCase(IConstantsData.NEXT))
		{
			PageCreateCatalog.clickOnNextButton(driver, testCaseName);
		}
		else if (catalog.getCatalogDetailsNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			return null;
		}

		if (catalog.getFileName() != null)
		{
			PageCreateCatalog.clickOnUploadItemsViaFileButton(driver, testCaseName);
			ModalUploadItemsInCatalog.fillFileName(driver, testCaseName, catalog.getFileName());
			ModalUploadItemsInCatalog.clickOnUploadCatalogButton(driver, testCaseName);
			ActionBot.threadSleep(23);
		}
		else
		{
			// to add item
			if (catalog.getCatelogItems() != null)
			{
				catalog = addItemToCatalog(driver, testCaseName, catalog);
			}
		}
		// to decide item details next action
		if (catalog.getItemDetailsNextAction().equalsIgnoreCase(IConstantsData.NEXT))
		{
			PageCreateCatalog.clickOnNextLinkScopeValidityButton(driver, testCaseName);
		}
		else if (catalog.getItemDetailsNextAction().equalsIgnoreCase(IConstantsData.DISCARD_CATALOG))
		{
			PageCreateCatalog.clickOnDiscardCatalogButton(driver, testCaseName);
		}
		else if (catalog.getItemDetailsNextAction().equalsIgnoreCase(IConstantsData.CLOSE_CATALOG))
		{
			PageCreateCatalog.clickOnCloseCatalogButton(driver, testCaseName);
		}

		// For Carlson Specific
		if (catalog.getIsCarlsonOU())
		{
			// to select OU
			PageCreateCEform.clickOnLinkSelectOUForCForm(driver, testCaseName);
			ActionBot.defaultLowSleep();
			// click on Expand box under Regions Tab and select all Regions
			ModalSelectCompaniesAndBU.selectAllOU(driver, testCaseName, catalog.getRegion());
			ActionBot.defaultSleep();
			// click on companies Tab
			ModalSelectCompaniesAndBU.clickOnCompaniesTab(driver, testCaseName);
			ActionBot.defaultSleep();
			// click on OU link Under companies Tab
			ModalSelectBUOfCEform.clickLinkSelectBusinessUnit(driver, testCaseName);
			ActionBot.defaultSleep();
			// Select Checkbox under Companies Tab
			ModalSelectBUOfCEform.SelectCheckBoxOU(driver, testCaseName);
			ActionBot.defaultSleep();
			ModalSelectCompaniesAndBU.clickOnSaveSelectedOUButton(driver, testCaseName);
			ActionBot.defaultSleep();
			// click on Business Tab
			ModalSelectBUOfCEform.clickTabBusinessUnit(driver, testCaseName);
			ActionBot.defaultSleep();
			// click on OU link Under Business Tab
			ModalSelectCompaniesAndBU.clickOnOUUnderBUTab(driver, testCaseName);
			ActionBot.defaultSleep();
			// Select Checkbox under Business Tab
			ModalSelectBUOfCEform.SelectCheckBoxOU(driver, testCaseName);
			ActionBot.defaultSleep();
			ModalSelectCompaniesAndBU.clickOnSaveSelectedOUButton(driver, testCaseName);
			ActionBot.defaultSleep();
			// click on Locations Tab
			ModalSelectCompaniesAndBU.clickOnLcoationsTab(driver, testCaseName);
			ActionBot.defaultSleep();
			// click on OU link Under Locations Tab
			ModalSelectCompaniesAndBU.clickOnOUUnderLocationsTab(driver, testCaseName);
			ActionBot.defaultSleep();
			// Select Checkbox under Locations Tab
			ModalSelectBUOfCEform.SelectCheckBoxOU(driver, testCaseName);
			ActionBot.defaultSleep();
			ModalSelectCompaniesAndBU.clickOnSaveSelectedOUButton(driver, testCaseName);
			ActionBot.defaultSleep();

			ModalSelectBUOfCEform.clickOnSaveORGUnitButton(driver, testCaseName);

		}

		else if (PageCreateCatalog.isSelectCatalogScopeLinkPresent(driver, testCaseName))
		{
			PageCreateCatalog.clickOnSelectCatalogScopeLink(driver, testCaseName);

			if (catalog.getCompany() != null)
			{
				// ModalSelectCompaniesAndBU.selectRegion(driver, testCaseName,
				// catalog.getRegion());
				ModalSelectCompaniesAndBU.clickOnIstCompanyCheckBox(driver, testCaseName);
			}

			ModalSelectCompaniesAndBU.clickOnBusinessUnitsTab(driver, testCaseName);

			// select all bu
			ActionBot.defaultSleep();
			ModalSelectCompaniesAndBU.clickOnLinkSelectAllBu(driver, testCaseName);

			if (catalog.getLocation() != null)
			{
				ModalSelectCompaniesAndBU.clickOnLcoationsTab(driver, testCaseName);
				ActionBot.defaultSleep();
				ModalSelectCompaniesAndBU.clickOnSelectAllLocationsLink(driver, testCaseName);
			}
			ModalSelectCompaniesAndBU.clickOnSaveSelectedScopeButton(driver, testCaseName);
		}
		/*
		 * else //for non carlson tenant { //select OU if
		 * (catalog.getOrganizationUnit() != null) {
		 * PageCreateCatalog.clickOnSelectOrganizationUnitLink(driver,
		 * testCaseName); if (catalog.getOrganizationUnit() !=
		 * IConstantsData.ALL) {
		 * catalog.setOrganizationUnit(ModalSelectCompaniesAndBU.selectOU(
		 * driver, testCaseName, catalog.getOrganizationUnit())); } else {
		 * catalog.setOrganizationUnit(IConstantsData.ALL);
		 * ModalSelectCompaniesAndBU.selectAllOU(driver, testCaseName); }
		 * ModalSelectCompaniesAndBU.clickOnSaveButton(driver, testCaseName); }
		 * }
		 */

		// from scope validity date
		if (catalog.getFromScopeValidityDate() != null)
		{
			catalog.getFromScopeValidityDate().setDate(
				PageCreateCatalog.selectFromValidityDate(driver, testCaseName, catalog.getFromScopeValidityDate().getDay(), catalog.getFromScopeValidityDate().getMonth(), catalog
					.getFromScopeValidityDate().getYear()));
		}
		// to scope validity date
		if (catalog.getToScopeValidityDate() != null)
		{
			catalog.getToScopeValidityDate().setDate(
				PageCreateCatalog.selectToValidityDate(driver, testCaseName, catalog.getToScopeValidityDate().getDay(), catalog.getToScopeValidityDate().getMonth(), catalog
					.getToScopeValidityDate().getYear()));
		}

		return catalog;
	}

	public static Catalog fillCatalogDetails(WebDriver driver, String testCaseName, Catalog catalog) throws ActionBotException
	{
		UI_Elements DROPDOWN_SUPPLIER_NAME = UIFactory.getElements("DROPDOWN_SUPPLIER_NAME");
		UI_Elements SUPPLIER_ERP_ID = UIFactory.getElements("SUPPLIER_ERP_ID");
		if (catalog.getCatalogName() != null)
		{
			catalog.setCatalogName(PageCreateCatalog.fillCatalogName(driver, testCaseName, catalog.getCatalogName()));
		}
		if (catalog.getSupplierERPId() != null)
		{
			ActionBot.click(driver, DROPDOWN_SUPPLIER_NAME);
			ActionBot.click(driver, SUPPLIER_ERP_ID);
			catalog.setSupplierName(PageCreateCatalog.fillSupplierName(driver, testCaseName, catalog.getSupplierERPId()));
		}
		else if (catalog.getSupplierName() != null)
		{
			catalog.setSupplierName(PageCreateCatalog.fillSupplierName(driver, testCaseName, catalog.getSupplierName()));
		}
		catalog.setSupplierAddress(PageCreateCatalog.selectFirstSupplierAddress(driver, testCaseName));
		if (catalog.getContractNumber() != null)
		{
			catalog.setContractNumber(PageCreateCatalog.fillContractNumber(driver, testCaseName, catalog.getContractNumber()));
		}
		return catalog;
	}

	public static Catalog addItemToCatalog(WebDriver driver, String testCaseName, Catalog catalog) throws Exception
	{
		List<CatelogItem> listOfCatalogItems = catalog.getCatelogItems();
		List<CatelogItem> listOfAddedCatalogItems = catalog.getCatelogItems();
		for (CatelogItem catelogItem : listOfCatalogItems)
		{
			PageCreateCatalog.clickOnAddItemButton(driver, testCaseName);

			listOfAddedCatalogItems.add(fillItemDetailsForm(driver, testCaseName, catelogItem));

			if (catelogItem.getNextAction().equalsIgnoreCase(IConstantsData.ADD_ITEM_TO_CATALOG))
			{
				ModalAddItemDetails.clickOnAddItemButton(driver, testCaseName);
			}
			else if (catelogItem.getNextAction().equalsIgnoreCase(IConstantsData.ADD_ITEM_TO_CATALOG_AND_CONTINUE))
			{
				ModalAddItemDetails.clickOnAddAndContinueButton(driver, testCaseName);
			}
			else if (catelogItem.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL_ADD_ITEM_TO_CATALOG))
			{
				ModalAddItemDetails.clickOnCloseAddItemButton(driver, testCaseName);
			}
			else
			{
				logger.info("Invalid Next Option");
			}
			break;
		}
		catalog.setCatelogItems(listOfAddedCatalogItems);
		return catalog;
	}

	public static CatelogItem fillItemDetailsForm(WebDriver driver, String testCaseName, CatelogItem catalogItem) throws Exception
	{
		catalogItem.setSupplier(ModalAddItemDetails.getSupplierName(driver, testCaseName));
		catalogItem.setSupplierPartID(ModalAddItemDetails.fillSupplierPartId(driver, testCaseName, catalogItem.getSupplierPartID()));
		catalogItem.setItemName(ModalAddItemDetails.fillShortDescription(driver, testCaseName, catalogItem.getItemName()));
		catalogItem.setUnitPrice(ModalAddItemDetails.fillPrice(driver, testCaseName, catalogItem.getUnitPrice()));
		catalogItem.setCategory(ModalAddItemDetails.fillProductCategory(driver, testCaseName, catalogItem.getCategory()));
		catalogItem.setUnitCurrency(ModalAddItemDetails.fillItemCurrency(driver, testCaseName, catalogItem.getUnitCurrency()));

		return catalogItem;
	}

	public static Catalog updateCatalog(WebDriver driver, String testCaseName, Catalog catalog) throws Exception
	{
		Catalog updatedCatalog = new Catalog();
		ModalCatalogListingActions.clickOnUpdateCatalog(driver, testCaseName);
		// to fill catalog details
		updatedCatalog = fillCatalogDetails(driver, testCaseName, catalog);
		PageCreateCatalog.clickOnNextButton(driver, testCaseName);

		// to add item
		updatedCatalog = addItemToCatalog(driver, testCaseName, catalog);
		PageCreateCatalog.clickOnNextLinkScopeValidityButton(driver, testCaseName);

		// select OU
		PageCreateCatalog.clickOnSelectOrganizationUnitLink(driver, testCaseName);
		if (catalog.getOrganizationUnit() != null && catalog.getOrganizationUnit() != IConstantsData.ALL)
		{
			updatedCatalog.setOrganizationUnit(ModalSelectCompaniesAndBU.selectOU(driver, testCaseName, catalog.getOrganizationUnit()));
		}
		else
		{
			updatedCatalog.setOrganizationUnit(IConstantsData.ALL);
			ModalSelectCompaniesAndBU.selectAllOU(driver, testCaseName, catalog.getRegion());
		}
		ModalSelectCompaniesAndBU.clickOnSaveButton(driver, testCaseName);

		if (catalog.getNextAction().equalsIgnoreCase(IConstantsData.SUBMIT_CATALOG))
		{
			// submit catalog
			PageCreateCatalog.clickOnSubmitCatalogButton(driver, testCaseName);
		}
		else if (catalog.getNextAction().equalsIgnoreCase(IConstantsData.DISCARD_CATALOG))
		{
			// discard catalog
			PageCreateCatalog.clickOnDiscardCatalogButton(driver, testCaseName);
		}
		else if (catalog.getNextAction().equalsIgnoreCase(IConstantsData.CLOSE_CATALOG))
		{
			// close catalog
			PageCreateCatalog.clickOnCloseCatalogButton(driver, testCaseName);
		}
		return updatedCatalog;

	}

	public static boolean deactivateCatalog(WebDriver driver, String testCaseName, Catalog catalog) throws ActionBotException
	{
		boolean flag = false;
		PageCatalogListing.clickOnCatalogActions(driver, testCaseName);
		ModalCatalogListingActions.clickOnDeactivateCatalog(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		ActionBot.waitTillPopUpIsPresent(driver, IPageCatalogListing.LABEL_SUCCESS_MESSAGE);
		ActionBot.defaultHighSleep();
		flag = PageCatalogListing.getStatusOfFirstCatalog(driver, testCaseName).equalsIgnoreCase(IConstantsData.DEACTIVATED_CATALOG_LABEL);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To view catalog <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void viewCatalog(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// to view the catalog
		PageCatalogListing.clickOnFirstCatalogName(driver, testCaseName);
	}

	public static boolean deleteCatalog(WebDriver driver, String testCaseName, Catalog catalog) throws ActionBotException
	{
		boolean flag = false;
		PageCatalogListing.clickOnCatalogActions(driver, testCaseName);
		ModalCatalogListingActions.clickOnDeletCatalog(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		ActionBot.waitTillPopUpIsPresent(driver, IPageCatalogListing.LABEL_SUCCESS_MESSAGE);
		if (PageAllRequestsApproval.getApprovalEmptyTableSize(driver, testCaseName) <= 1)
		{
			flag = true;
		}
		return flag;
	}

	public static boolean deactivateAndDeleteCatalog(WebDriver driver, String testCaseName, Catalog catalog) throws ActionBotException
	{
		boolean flag = false;
		flag = searchCatalog(driver, testCaseName, catalog.getCatalogName());
		flag = deactivateCatalog(driver, testCaseName, catalog);
		Assert.assertTrue(flag, "Error while deactivating catalog");
		flag = deleteCatalog(driver, testCaseName, catalog);
		Assert.assertTrue(flag, "Error while deleting catalog");
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Submit catalog <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void submitCatalog(WebDriver driver, String testCaseName, boolean markForAddingApprovers, boolean isSubmitForApproval) throws ActionBotException
	{
		PageCreateCatalog.clickOnSubmitCatalogButton(driver, testCaseName);
		if (ModalSubmitForApproval.isSubmitForApprovalButtonPresent(driver, testCaseName))
		{
			if (markForAddingApprovers)
			{
				ModalSubmitForApproval.clickOnModifyWorkflowSettingCheckbox(driver, testCaseName);
			}
			ModalSubmitForApproval.clickOnSubmitForApprovalButton(driver, testCaseName);
			ActionBot.waitTillPopUpIsPresent(driver, IPageCreateCatalog.PROCESSING_DIV_PUBLISH_CATALOG);
		}
		if (isSubmitForApproval)
		{
			if (PageCatalogView.isSubmitForApprovalButtonPresent(driver, testCaseName))
			{
				PageCatalogView.clickOnSubmitForApprovalButton(driver, testCaseName);
			}
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Recall catalog <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param catalogName
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static boolean recallCatalog(WebDriver driver, String testCaseName, String catalogName) throws ActionBotException
	{
		boolean flag = false;
		String status = "";
		PageCatalogListing.clickOnCatalogActions(driver, testCaseName);
		ModalCatalogListingActions.clickOnRecallCatalog(driver, testCaseName);
		ModalRecallCatalog.fillRecallComment(driver, testCaseName, IConstantsData.RECALL_COMMENT);
		ModalRecallCatalog.clickOnRecallCatalogButton(driver, testCaseName);

		flag = searchCatalog(driver, testCaseName, catalogName);
		Assert.assertTrue(flag, "Error while seaching catalog");

		status = PageCatalogListing.getStatusOfFirstCatalog(driver, testCaseName);
		flag = status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Cancel catalog <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param catalogName
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static boolean cancelCatalog(WebDriver driver, String testCaseName, String catalogName) throws ActionBotException
	{
		boolean flag = false;
		String status = "";
		PageCatalogListing.clickOnCatalogActions(driver, testCaseName);
		ModalCatalogListingActions.clickOnCancelCatalog(driver, testCaseName);

		flag = searchCatalog(driver, testCaseName, catalogName);
		Assert.assertTrue(flag, "Error while seaching catalog");

		status = PageCatalogListing.getStatusOfFirstCatalog(driver, testCaseName);
		flag = status.equalsIgnoreCase(IConstantsData.DRAFT_FILTER_LABEL);
		return flag;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Approve catalog <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param catalogName
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static ApprovalAllRequests approveCatalog(WebDriver driver, String testCaseName, ApprovalAllRequests approvalAllRequests) throws ActionBotException
	{
		if (!(approvalAllRequests.getDocumentName() == null))
		{
			FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
		}
		return approvalAllRequests;
	}

	/**
	 * <b>Author: t.amarnath </b> <b><br>
	 * <font color="blue">Method :</b>To download sample template <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param catalog</font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static Catalog downloadSampleCatalogTemplate(WebDriver driver, String testCaseName, Catalog catalog) throws Exception
	{
		// click on catalog tab
		MainPageHeaderLevelTab.clickOnCatalogSubTab(driver, testCaseName);

		// click on add catalog button
		PageCatalogListing.clickOnAddCatalogButton(driver, testCaseName);

		// to fill catalog wizard
		catalog = fillCatalogDetails(driver, testCaseName, catalog);

		// click on next
		PageCreateCatalog.clickOnNextButton(driver, testCaseName);

		// click on upload items via file
		PageCreateCatalog.clickOnUploadItemsViaFileButton(driver, testCaseName);
		ActionBot.click(driver, IPageCreateCatalog.CSV_SAMPLE_TEMPLATE_FILE);
		// close modal
		ModalUploadItemsInCatalog.clickOnUploadCatalogButton(driver, testCaseName);
		// close catalog
		PageCreateCatalog.clickOnCloseCatalogButton(driver, testCaseName);
		return catalog;

	}

}
