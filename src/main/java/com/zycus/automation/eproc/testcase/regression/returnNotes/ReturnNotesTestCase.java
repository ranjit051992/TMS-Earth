package com.zycus.automation.eproc.testcase.regression.returnNotes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.Receipt;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.ReturnNote;
import com.zycus.automation.bo.StandardPO;
import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.MappedTestCaseUtil;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.combineflow.CombineFlowImpl;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.businessflow.receiptflow.FlowReceipt;
import com.zycus.automation.eproc.businessflow.returnnoteflow.FlowReturnNote;
import com.zycus.automation.eproc.businessflow.standardpoflow.FlowStandardPo;
import com.zycus.automation.eproc.pageobjects.modals.polistingactions.ModalPOListingActions;
import com.zycus.automation.eproc.pageobjects.modals.returnNoteItemAttachment.ModelReturnNoteItemAttachment;
import com.zycus.automation.eproc.pageobjects.pages.createreceipt.PageCreateReceipt;
import com.zycus.automation.eproc.pageobjects.pages.createreturnnote.PageCreateReturnNote;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.receiptlisting.PageReceiptListing;
import com.zycus.automation.eproc.pageobjects.popups.defaultalert.PopUpDefalutAlert;
import com.zycus.automation.eproc.testcase.regression.requistionForking.RequisitionForkingTestCases;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;

public class ReturnNotesTestCase extends TestDataProvider
{

	static Logger logger = Logger.getLogger(RequisitionForkingTestCases.class);

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : 31-Oct-2017 </b>
	 * <b>Method : EPROC_9433</b>
	 * <b>Description: ]Released PO>>Validation should be thrown on create return note incase no receipt has been created against the PO</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_9433(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();

		User user = null;
		StandardPO standardPO = null;
		ReturnNote returnNote = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//generating Standard PO and Release it
			standardPO = ObjectCreation.getStandardPoCreation(IConstantsData.CATALOG_ITEM);
			standardPO = FlowStandardPo.createAndReleasedPo(driver, testCaseName, standardPO);

			//validating weather return note can be created or not
			returnNote = ObjectCreation.getDefaultReturnNoteObject();
			returnNote.setStandardPO(standardPO);
			returnNote = FlowReturnNote.createReturnNote(driver, testCaseName, returnNote);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : 31-Oct-2017 </b>
	 * <b>Method :EPROC_9434 </b>
	 * <b>Description: Create return note>>On submit;and if there are no errors in the document, system will show a confirmation message: System will finalize the return note and send it to the supplier. Do you want to continue?</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_9434(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();

		User user = null;
		Receipt receipt = null;
		ReturnNote returnNote = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Creating Recipt for PO
			receipt = ObjectCreation.getDefaultReceiptObject();
			receipt = FlowReceipt.createReceiptFromStandardPO(driver, testCaseName, receipt);

			//Creating Return Note
			returnNote = ObjectCreation.getDefaultReturnNoteObject();
			returnNote.setStandardPO(receipt.getStandardPO());
			returnNote = FlowReturnNote.createReturnNote(driver, testCaseName, returnNote);

			boolean flag = PageReceiptListing.checkSuccessfulCreationOfReturnNote(driver, testCaseName, returnNote.getReturnNoteNo());
			Assert.assertTrue("Fail to Create Return Note" + returnNote.getReturnNoteNo(), flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : 31-Oct-2017 </b>
	 * <b>Method : EPROC_9432</b>
	 * <b>Description: Create return note>>Validation should be thrown on save return note on save a return note without selecting an item, system will alert the user to select an item: 'Select an item to create return note'</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_9432(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();

		User user = null;
		Receipt receipt = null;
		ReturnNote returnNote = null;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Creating Recipt for PO
			receipt = ObjectCreation.getDefaultReceiptObject();
			receipt = FlowReceipt.createReceiptFromStandardPO(driver, testCaseName, receipt);

			//Creating Return Note
			returnNote = ObjectCreation.getDefaultReturnNoteObject();
			returnNote.setStandardPO(receipt.getStandardPO());

			//Will Open The Form Of Return Note
			FlowReturnNote.openReturnNoteFrom(driver, testCaseName, returnNote);

			//Fill the return note details
			returnNote = FlowReturnNote.fillReturnNoteForm(driver, testCaseName, returnNote);

			//try To submit the return note without filling the item Details
			returnNote = FlowReturnNote.submitReturnNote(driver, testCaseName, returnNote);

			//Cancle the Retunr Note
			returnNote = FlowReturnNote.cancleReturnNote(driver, testCaseName, returnNote);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : 31-Oct-2017 </b>
	 * <b>Method : EPROC_9458 </b>
	 * <b>Description: Buyer should be able to create a return note from a PO using the create return note option under the receipt tab</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_9458(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();

		User user = null;
		Receipt receipt = null;
		ReturnNote returnNote = null;
		try
		{
			{
				// : testcase to be mapped
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9445")); //RMA field and non mandatory field check
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9446")); //Supplier Email Field and Default PO supplier(Default PO not Done)
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9447")); //Supplier Email Field and Non Mandatory field Check
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9448")); //Supplier Contact Field and Default PO Supplier (Default check not Done)
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9449")); //Supplier Contact Field and Non Mandatory
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9450")); //Supplier Address Dropdown and Availble Address( Available Address not done)
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9455")); //Return Note Description Field Should be Present
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10090"));//Notify Supplier Field Present
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9437")); //Return Method Mandatory Field With Error Check Message
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9439")); //Check Field Reason For Return
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9441")); //Return Quantity Mandatory Field
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9456")); //Return note number Mandatory Check With Error Message
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9452")); //Supplier Name Fiels And Autopopulated As Lable
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10076")); //Notify Supplier and Comment fill with Popup Alert
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10077")); //Notify Supplier Check And Uncheck With Validation 
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9444")); //Check Item Received Section Present

			}

			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Creating Recipt for PO
			receipt = ObjectCreation.getDefaultReceiptObject();
			receipt = FlowReceipt.createReceiptFromStandardPO(driver, testCaseName, receipt);

			//Creating Return Note
			returnNote = ObjectCreation.getDefaultReturnNoteObject();
			returnNote.setStandardPO(receipt.getStandardPO());
			returnNote.setNextAction(IConstantsData.NONE);

			//Open Return Note Form
			FlowReturnNote.openReturnNoteFrom(driver, testCaseName, returnNote);

			//Check RMA Field Present On Form (EPROC_9445)
			boolean rmaField = PageCreateReturnNote.checkReturnMethodAuthorizationfieldPresent(driver, testCaseName);
			if (rmaField)
			{
				rmaField = PageCreateReturnNote.checkReturnMaterialAuthorizationMandatory(driver, testCaseName);
				Assert.assertTrue("Return Material Authorization Filed Present Mandatory", rmaField);
				mappedTestCases.get(0).setTestResult(rmaField);
			}
			else
			{
				Assert.assertTrue("Return Material Authorization Filed Not Present", rmaField);
				mappedTestCases.get(0).setTestResult(rmaField);
			}

			//Check Supplier Email Field Present On Form and Default PO Details (EPROC_9446)
			boolean supplierEmail = PageCreateReturnNote.checkSupplierEmailFieldPresent(driver, testCaseName);
			Assert.assertTrue("Supplier Email Filed Not Present", supplierEmail);
			mappedTestCases.get(1).setTestResult(supplierEmail);

			//Check Supplier Email Field Present On Form and Mandatory Check(EPROC_9447)
			boolean supplierEmail1 = PageCreateReturnNote.checkSupplierEmailFieldPresent(driver, testCaseName);
			if (supplierEmail1)
			{
				supplierEmail1 = PageCreateReturnNote.checkSupplierEmailMandatory(driver, testCaseName);
				Assert.assertTrue("Supplier Email Filed Present and  Mandatory", supplierEmail1);
				mappedTestCases.get(2).setTestResult(supplierEmail1);
			}
			else
			{
				Assert.assertTrue("Supplier Email Filed Not Present", supplierEmail1);
				mappedTestCases.get(2).setTestResult(supplierEmail1);
			}

			//Check Supplier Conatct Field Present On Form and Default(EPROC_9448)
			boolean supplierConatct = PageCreateReturnNote.checkSupplierContactFieldPresent(driver, testCaseName);
			Assert.assertTrue("Supplier Email Filed Not Present", supplierConatct);
			mappedTestCases.get(3).setTestResult(supplierConatct);

			//Check Supplier Contact Field Present On Form and Non Mandatory(EPROC_9449)
			boolean supplierContact1 = PageCreateReturnNote.checkSupplierContactFieldPresent(driver, testCaseName);
			if (supplierContact1)
			{
				supplierContact1 = PageCreateReturnNote.checkSupplierConatactMandatory(driver, testCaseName);
				Assert.assertTrue("Supplier Email Filed Present and Mandatory", supplierContact1);
				mappedTestCases.get(4).setTestResult(supplierContact1);
			}
			else
			{
				Assert.assertTrue("Supplier Email Filed Not Present", supplierContact1);
				mappedTestCases.get(4).setTestResult(supplierContact1);
			}

			//Check Supplier Address Dropdown Present On Form and Default Address(EPROC_9450)
			boolean supplierAddress = PageCreateReturnNote.checkSupplierAddressFieldPresent(driver, testCaseName);
			Assert.assertTrue("Supplier Email Filed Not Present", supplierAddress);
			mappedTestCases.get(5).setTestResult(supplierAddress);

			//Check Return Note Description Field Present (EPROC_9455) 
			boolean returnNoteDescription = PageCreateReturnNote.checkReturnNoteDescriptionFieldPresent(driver, testCaseName);
			Assert.assertTrue("Return Note Description Filed Not Present", returnNoteDescription);
			mappedTestCases.get(6).setTestResult(returnNoteDescription);

			//Check Notify Supplier Field present on Form (EPROC_10090)
			boolean notifySupplier = PageCreateReturnNote.checkNotifySupplierFieldPresent(driver, testCaseName);
			Assert.assertTrue("Notify Supplier Field Not Present", notifySupplier);
			mappedTestCases.get(7).setTestResult(notifySupplier);

			//Check Return Method Mandatory Field and Error message also(EPROC_9437)
			boolean returnMethod = PageCreateReturnNote.checkReturnMethodFieldMandatory(driver, testCaseName);
			Assert.assertTrue("Return Method is Not Mandatory Field", returnMethod);
			mappedTestCases.get(8).setTestResult(returnMethod);

			//Check Reason For Return Field Present of Not(EPROC_9439)
			boolean reasonForReturn = PageCreateReturnNote.checkReasonForReturnFieldMandatory(driver, testCaseName);
			Assert.assertTrue("Reason For Return is Not Mandatory Field", reasonForReturn);
			mappedTestCases.get(9).setTestResult(reasonForReturn);

			//Check Return Quantity Mandatroy Field Check(EPROC_3941)
			boolean returnQuantity = PageCreateReturnNote.checkReasonForReturnFieldMandatory(driver, testCaseName);
			Assert.assertTrue("Return Quantity is Not Mandatory Field", returnQuantity);
			mappedTestCases.get(10).setTestResult(returnQuantity);

			//checkReturn Note Number Mandatory Field(EPROC_9456)
			{
				boolean returnNotenumber = PageCreateReturnNote.checkReturnNoteNumberMandatory(driver, testCaseName);
				if (returnNotenumber)
				{
					PageCreateReturnNote.selectAllItemInReturnNote(driver, testCaseName);
					returnNote.setReturnNoteNo(PageCreateReturnNote.getReturnNoteNumber(driver, testCaseName));
					PageCreateReturnNote.clearReturnNoteNumberField(driver, testCaseName);
					PageCreateReturnNote.clickOnSubmitReturnNoteButton(driver, testCaseName);
					boolean errorMessage = PageCreateReturnNote.checkReturnNotenumberErrorMessage(driver, testCaseName);
					Assert.assertTrue("Return Note Number Mandatory With Error Message check", errorMessage);
					mappedTestCases.get(11).setTestResult(errorMessage);
				}
				else
				{
					Assert.assertTrue("Return note Number not MAndatory Field", returnNotenumber);
					mappedTestCases.get(11).setTestResult(returnNotenumber);
				}
				//deselect All the items
				PageCreateReturnNote.selectAllItemInReturnNote(driver, testCaseName);
				//ReFill the Return Note number
				PageCreateReturnNote.fillReturnNoteNumber(driver, testCaseName, returnNote.getReturnNoteNo());

			}

			//Supplier Name Fiels And Autopopulated As Lable(EPROC_9452)
			boolean suppliername = PageCreateReturnNote.checkSupplerNameLableFieldPresent(driver, testCaseName);
			if (suppliername)
			{
				suppliername = PageCreateReturnNote.checkSupplierNameDetailFieldPresent(driver, testCaseName);
				Assert.assertTrue("Return Note Suplier Name Field With Details is Present", suppliername);
				mappedTestCases.get(12).setTestResult(suppliername);
			}
			else
			{
				Assert.assertTrue("Return Note Suplier Name Field Note Present", suppliername);
				mappedTestCases.get(12).setTestResult(suppliername);
			}

			//Notify Supplier and Comment fill with Popup Alert(EPROC_10076)
			{
				PageCreateReturnNote.selectNotifySupplierCheckBox(driver, testCaseName);
				PageCreateReturnNote.fillSupplierComment(driver, testCaseName, returnNote.getReturnNoteComments());
				PageCreateReturnNote.selectNotifySupplierCheckBox(driver, testCaseName);
				//Check Popup is Present
				boolean popUpCheck = PopUpDefalutAlert.isAlertAndErrorPopUpPresent(driver, testCaseName);
				if (popUpCheck)
				{
					String alertMessage = PopUpDefalutAlert.getAlertMsg(driver, testCaseName);
					if (alertMessage.equalsIgnoreCase("Any comments provided for supplier reference will be auto deleted. Do you still want to continue?"))
					{
						PageCreateReturnNote.clickOnContinueAutoDeleteCommentPopUp(driver, testCaseName);
						mappedTestCases.get(13).setTestResult(popUpCheck);
					}
				}
				else
				{
					Assert.assertTrue("Comment Auto Delete Pop Up not Present", popUpCheck);
					mappedTestCases.get(13).setTestResult(popUpCheck);
				}

			}

			//Notify Supplier Check And Uncheck With Validation(EPROC_10077)
			{
				PageCreateReturnNote.selectNotifySupplierCheckBox(driver, testCaseName);
				PageCreateReturnNote.selectNotifySupplierCheckBox(driver, testCaseName);
				//Check Popup is Present
				boolean popUpCheck = PopUpDefalutAlert.isAlertAndErrorPopUpPresent(driver, testCaseName);
				if (popUpCheck)
				{
					PageCreateReturnNote.clickOnContinueAutoDeleteCommentPopUp(driver, testCaseName);
					mappedTestCases.get(14).setTestResult(popUpCheck);
				}
				else
				{
					Assert.assertTrue("Comment Auto Delete Pop Up not Present", popUpCheck);
					mappedTestCases.get(14).setTestResult(popUpCheck);
				}

			}

			//Check Item received Section Present in Return Note (EPROC_9444)
			boolean itemRecivedSection = PageCreateReturnNote.checkItemReceivedSectionPresent(driver, testCaseName);
			Assert.assertTrue("Item Recived Section Not Present in Return Note", itemRecivedSection);
			mappedTestCases.get(15).setTestResult(itemRecivedSection);

			//Fill the Return Note Form
			returnNote = FlowReturnNote.fillReturnNoteForm(driver, testCaseName, returnNote);
			returnNote = FlowReturnNote.fillItemDetails(driver, testCaseName, returnNote);

			//Submit the Return Note 
			returnNote = FlowReturnNote.submitReturnNote(driver, testCaseName, returnNote);

			//Check for successful creation of Return Note
			boolean flag = PageReceiptListing.checkSuccessfulCreationOfReturnNote(driver, testCaseName, returnNote.getReturnNoteNo());
			Assert.assertTrue("Fail to Create Return Note" + returnNote.getReturnNoteNo(), flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : 31-Oct-2017 </b>
	 * <b>Method : EPROC_9435 </b>
	 * <b>Description: Create return note>>Verify all mandatory field validations on returnnote save as draft</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_9435(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();

		User user = null;
		Receipt receipt = null;
		ReturnNote returnNote = null;
		try
		{
			{
				// : testcase to be mapped
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9997")); // Cancel Return note Save In Draft
			}

			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Creating Receipt for PO
			receipt = ObjectCreation.getDefaultReceiptObject();
			receipt = FlowReceipt.createReceiptFromStandardPO(driver, testCaseName, receipt);

			//Creating Return Note
			returnNote = ObjectCreation.getDefaultReturnNoteObject();
			returnNote.setStandardPO(receipt.getStandardPO());

			//Open Return Note Form
			FlowReturnNote.openReturnNoteFrom(driver, testCaseName, returnNote);

			//Select all the Item in Item Recived Part in return Note Form
			PageCreateReturnNote.selectAllItemInReturnNote(driver, testCaseName);

			//Try to submit Return Note
			PageCreateReturnNote.clickOnSubmitReturnNoteButton(driver, testCaseName);

			//Check Header Error Message Present of Not
			boolean headerError = PageCreateReturnNote.checkHeaderErrorMessagePresent(driver, testCaseName);
			Assert.assertTrue("Header Error Message not Present", headerError);

			PageCreateReturnNote.selectAllItemInReturnNote(driver, testCaseName);

			FlowReturnNote.fillReturnNoteForm(driver, testCaseName, returnNote);
			FlowReturnNote.fillItemDetails(driver, testCaseName, returnNote);

			//Submit Retunr Note As Draft
			PageCreateReturnNote.clickOnSaveReturnNoteAsDraftButton(driver, testCaseName);

			//Check for successful creation of Return Note
			boolean flag = PageReceiptListing.checkSuccessfulCreationOfReturnNote(driver, testCaseName, returnNote.getReturnNoteNo());
			Assert.assertTrue("Fail to Draft The Return Note" + returnNote.getReturnNoteNo(), flag);

			PageReceiptListing.clickOnClearFilterStatusButton(driver, testCaseName);

			//Cancel Return Note Save In Draft(EPROC_9997)
			boolean deleteDraftRN = FlowReturnNote.deleteDraftedReturnNote(driver, testCaseName);
			deleteDraftRN = PageReceiptListing.checkSuccessfulCreationOfReturnNote(driver, testCaseName, returnNote.getReturnNoteNo());
			Assert.assertTrue("Delete Drafted Return Note Fail", !deleteDraftRN);
			mappedTestCases.get(0).setTestResult(!deleteDraftRN);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : 31-Oct-2017 </b>
	 * <b>Method : EPROC_9436 </b>
	 * <b>Description:Create Return Note Incase all mandatory fields are not filled system should throw an error message on return note Save As Draft</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_9436(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();

		User user = null;
		Receipt receipt = null;
		ReturnNote returnNote = null;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9440"));//Create return note>>Item received>>Return quantity>>It should be <= Net accepted quantity
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9443"));//Create return note>>Items received>>Following details of items should be displayed in this section:Item name;Order quantity;Unit price;Net accepted quantity

			}
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Creating Recipt for PO and Creating Standard PO
			receipt = ObjectCreation.getDefaultReceiptObject();
			receipt = FlowReceipt.createReceiptFromStandardPO(driver, testCaseName, receipt);

			//Creating Return Note
			returnNote = ObjectCreation.getDefaultReturnNoteObject();
			returnNote.setStandardPO(receipt.getStandardPO());

			//Open Return Note Form
			FlowReturnNote.openReturnNoteFrom(driver, testCaseName, returnNote);

			//Select all the Item in Item Recived Part in retunr Note Form
			PageCreateReturnNote.selectAllItemInReturnNote(driver, testCaseName);
			//Create return note>>Item received>>Return quantity>>It should be <= Net accepted quantity(ERPOC_9440)
			//get Web Elements of Return Quantity and Net Approved Quantity for first Elemen
			List<WebElement> returnedQuantityWebElements = PageCreateReturnNote.getWebElementForReturnedQuantity(driver, testCaseName);
			String approvedQuan = PageCreateReturnNote.getApprovedQuantityForItem(driver, testCaseName, 1);
			String approvQuantity[] = approvedQuan.split(" ");
			int approvedQuantity = Integer.parseInt(approvQuantity[0]) + 2;
			approvedQuan = "" + approvedQuantity;
			PageCreateReturnNote.fillReturnedQuantityforItem(driver, testCaseName, returnedQuantityWebElements.get(0), approvedQuan);
			PageCreateReturnNote.fillSupplierEmail(driver, testCaseName, null);
			boolean returnQuantityError = PageCreateReturnNote.checkReturnQuantityGreaterErrorPresent(driver, testCaseName);
			if (returnQuantityError)
			{
				PageCreateReturnNote.fillReturnedQuantityforItem(driver, testCaseName, returnedQuantityWebElements.get(0), approvQuantity[0]);
				PageCreateReturnNote.fillSupplierEmail(driver, testCaseName, "");
				returnQuantityError = PageCreateReturnNote.checkReturnQuantityGreaterErrorPresent(driver, testCaseName);
				if (!returnQuantityError)
				{
					//Validation Done Successfully
					mappedTestCases.get(0).setTestResult(!returnQuantityError);
				}
			}
			else
			{
				//Validation Fail
				mappedTestCases.get(0).setTestResult(returnQuantityError);
			}

			//Create return note>>Items received>>Following details of :Item name;Order quantity;Unit price;Net accepted quantity(EPROC_9443)
			boolean checkfields = FlowReturnNote.checkTotalDetailOfItemPresentInReturnNote(driver, testCaseName);
			Assert.assertTrue("All the details of item is not present in Item Recived Section", checkfields);
			mappedTestCases.get(1).setTestResult(checkfields);

			//Try to submit Return Note
			PageCreateReturnNote.clickOnSubmitReturnNoteButton(driver, testCaseName);

			//Check Header Error Message Present of Not
			boolean headerError = PageCreateReturnNote.checkHeaderErrorMessagePresent(driver, testCaseName);
			Assert.assertTrue("Header Error Message not Present", headerError);
			PageCreateReturnNote.selectAllItemInReturnNote(driver, testCaseName);

			FlowReturnNote.fillReturnNoteForm(driver, testCaseName, returnNote);
			FlowReturnNote.fillItemDetails(driver, testCaseName, returnNote);

			PageCreateReturnNote.clickOnSubmitReturnNoteButton(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : 31-Oct-2017 </b>
	 * <b>Method : EPROC_9996 </b>
	 * <b>Description:Released PO>>Validation should be thrown on create return note incase no receipt has been created against the PO of the requisition</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_9996(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{

		}
		User user = null;
		Requisition requisition = null;
		ReturnNote returnNote = null;
		PurchaseOrder purchaseOrder = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			//Requisition to PO
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);
			List<PurchaseOrder> listPurchaseOrder = requisition.getPurchaseOrdersList();
			purchaseOrder = listPurchaseOrder.get(0);

			// search po
			boolean flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue("Error while searching PO", flag);

			//validating weather return note can be created or not
			returnNote = ObjectCreation.getDefaultReturnNoteObject();
			returnNote.setPurchaseOrder(purchaseOrder);
			returnNote = FlowReturnNote.createReturnNote(driver, testCaseName, returnNote);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : 31-Oct-2017 </b>
	 * <b>Method : EPROC_9995 </b>
	 * <b>Description:Create return note>>Validation should be thrown on save return note on save a return note without selecting an item, system will alert the user to select an item: 'Select an item to create return note'</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_9995(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{

		}
		User user = null;
		Receipt receipt = null;
		Requisition requisition = null;
		ReturnNote returnNote = null;
		PurchaseOrder purchaseOrder = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			//Requisition to PO
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);
			List<PurchaseOrder> listPurchaseOrder = requisition.getPurchaseOrdersList();
			purchaseOrder = listPurchaseOrder.get(0);

			// search po
			boolean flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue("Error while searching PO", flag);

			//to create receipt
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOListingActions.clickOnCreateReceiptLink(driver, testCaseName);

			receipt = ObjectCreation.getDefaultReceiptObject();
			receipt.setPurchaseOrder(purchaseOrder);
			receipt = FlowReceipt.createReceipt(driver, testCaseName, receipt);

			//Creating Return Note
			returnNote = ObjectCreation.getDefaultReturnNoteObject();
			returnNote.setPurchaseOrder(purchaseOrder);

			//Will Open The Form Of Return Note
			FlowReturnNote.openReturnNoteFrom(driver, testCaseName, returnNote);

			//Fill the return note details
			returnNote = FlowReturnNote.fillReturnNoteForm(driver, testCaseName, returnNote);

			//try To submit the return note without filling the item Details
			returnNote = FlowReturnNote.submitReturnNote(driver, testCaseName, returnNote);

			//Cancle the Retunr Note
			returnNote = FlowReturnNote.cancleReturnNote(driver, testCaseName, returnNote);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : 31-Oct-2017 </b>
	 * <b>Method : EPROC_10001 </b>
	 * <b>Description:Create return note>>Incase all mandatory fields are not filled system should throw an error message on return note submission</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_10001(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{

		}
		User user = null;
		Receipt receipt = null;
		Requisition requisition = null;
		ReturnNote returnNote = null;
		PurchaseOrder purchaseOrder = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			//Requisition to PO
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);
			List<PurchaseOrder> listPurchaseOrder = requisition.getPurchaseOrdersList();
			purchaseOrder = listPurchaseOrder.get(0);

			// search po
			boolean flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue("Error while searching PO", flag);

			//to create receipt
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOListingActions.clickOnCreateReceiptLink(driver, testCaseName);

			receipt = ObjectCreation.getDefaultReceiptObject();
			receipt.setPurchaseOrder(purchaseOrder);
			receipt = FlowReceipt.createReceipt(driver, testCaseName, receipt);

			//Creating Return Note
			returnNote = ObjectCreation.getDefaultReturnNoteObject();
			returnNote.setPurchaseOrder(purchaseOrder);

			//Open Return Note Form
			FlowReturnNote.openReturnNoteFrom(driver, testCaseName, returnNote);

			//Select all the Item in Item Recived Part in retunr Note Form
			PageCreateReturnNote.selectAllItemInReturnNote(driver, testCaseName);

			//Try to submit Return Note
			PageCreateReturnNote.clickOnSubmitReturnNoteButton(driver, testCaseName);

			//Check Header Error Message Present of Not
			boolean headerError = PageCreateReturnNote.checkHeaderErrorMessagePresent(driver, testCaseName);
			Assert.assertTrue("Header Error Message not Present", headerError);
			//Select all the Item in Item Recived Part in return Note Form
			PageCreateReturnNote.selectAllItemInReturnNote(driver, testCaseName);

			FlowReturnNote.fillReturnNoteForm(driver, testCaseName, returnNote);
			FlowReturnNote.fillItemDetails(driver, testCaseName, returnNote);

			PageCreateReturnNote.clickOnSubmitReturnNoteButton(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : 31-Oct-2017 </b>
	 * <b>Method : EPROC_10000 </b>
	 * <b>Description:Create return note>>Requestor should be able to navigate to the requisition listing page using the back button on the return note page.</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_10000(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{

		}
		User user = null;
		Receipt receipt = null;
		Requisition requisition = null;
		ReturnNote returnNote = null;
		PurchaseOrder purchaseOrder = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			//Requisition to PO
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);
			List<PurchaseOrder> listPurchaseOrder = requisition.getPurchaseOrdersList();
			purchaseOrder = listPurchaseOrder.get(0);

			// search po
			boolean flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue("Error while searching PO", flag);

			//to create receipt
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOListingActions.clickOnCreateReceiptLink(driver, testCaseName);

			receipt = ObjectCreation.getDefaultReceiptObject();
			receipt.setPurchaseOrder(purchaseOrder);
			receipt = FlowReceipt.createReceipt(driver, testCaseName, receipt);

			//Creating Return Note
			returnNote = ObjectCreation.getDefaultReturnNoteObject();
			returnNote.setPurchaseOrder(purchaseOrder);

			//Will Open The Form Of Return Note
			FlowReturnNote.openReturnNoteFrom(driver, testCaseName, returnNote);

			//Click on Back Link of Return Note
			PageCreateReturnNote.clickOnBackReturnNoteLink(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : 31-Oct-2017 </b>
	 * <b>Method : EPROC_9998 </b>
	 * <b>Description:On finalising the return note;If yes, system will change the status of the Return Note document to 'Returned' and will redirect me to the receipt listing page and show the newly created return note document in the receipt listing page</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_9998(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();

		User user = null;
		Receipt receipt = null;
		Requisition requisition = null;
		ReturnNote returnNote = null;
		PurchaseOrder purchaseOrder = null;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10036")); //Requisition>>Return Note Description Field Should be Present
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10037")); //Requisition>>Return note number Mandatory Check With Error Message
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10038")); //Requisition>>Requestor should be allowed to edit the return note number
			}

			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			//Requisition to PO
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);
			List<PurchaseOrder> listPurchaseOrder = requisition.getPurchaseOrdersList();
			purchaseOrder = listPurchaseOrder.get(0);

			// search po
			boolean flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue("Error while searching PO", flag);

			//to create receipt
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOListingActions.clickOnCreateReceiptLink(driver, testCaseName);

			receipt = ObjectCreation.getDefaultReceiptObject();
			receipt.setPurchaseOrder(purchaseOrder);
			receipt = FlowReceipt.createReceipt(driver, testCaseName, receipt);

			//Create Return Note
			returnNote = ObjectCreation.getDefaultReturnNoteObject();
			returnNote.setPurchaseOrder(purchaseOrder);
			returnNote.setNextAction(IConstantsData.NONE);

			//Open Return Note Form
			FlowReturnNote.openReturnNoteFrom(driver, testCaseName, returnNote);

			//Check Return Note Description Field Present (EPROC_10036) 
			boolean returnNoteDescription = PageCreateReturnNote.checkReturnNoteDescriptionFieldPresent(driver, testCaseName);
			Assert.assertTrue("Return Note Description Filed Not Present", returnNoteDescription);
			mappedTestCases.get(0).setTestResult(returnNoteDescription);

			//checkReturn Note Number Mandatory Field(EPROC_10037) and Requisition>>Requestor should be allowed to edit the return note number(EPROC_10038)
			{
				boolean returnNotenumber = PageCreateReturnNote.checkReturnNoteNumberMandatory(driver, testCaseName);
				if (returnNotenumber)
				{
					PageCreateReturnNote.selectAllItemInReturnNote(driver, testCaseName);
					returnNote.setReturnNoteNo(PageCreateReturnNote.getReturnNoteNumber(driver, testCaseName));
					PageCreateReturnNote.clearReturnNoteNumberField(driver, testCaseName);
					PageCreateReturnNote.clickOnSubmitReturnNoteButton(driver, testCaseName);
					boolean errorMessage = PageCreateReturnNote.checkReturnNotenumberErrorMessage(driver, testCaseName);
					Assert.assertTrue("Return Note Number Mandatory With Error Message check", errorMessage);
					mappedTestCases.get(1).setTestResult(errorMessage);
				}
				else
				{
					Assert.assertTrue("Return note Number not MAndatory Field", returnNotenumber);
					mappedTestCases.get(1).setTestResult(returnNotenumber);
				}
				//deselect All the items
				PageCreateReturnNote.selectAllItemInReturnNote(driver, testCaseName);
				//ReFill the Return Note number
				PageCreateReturnNote.fillReturnNoteNumber(driver, testCaseName, returnNote.getReturnNoteNo());
				//Requisition>>Requestor should be allowed to edit the return note number(EPROC-10038)
				mappedTestCases.get(2).setTestResult(returnNotenumber);

			}

			//Fill Return Note and Item Details
			FlowReturnNote.fillReturnNoteForm(driver, testCaseName, returnNote);
			FlowReturnNote.fillItemDetails(driver, testCaseName, returnNote);
			//Submit Return Note 
			returnNote = FlowReturnNote.submitReturnNote(driver, testCaseName, returnNote);

			//Check for successful creation of Return Note
			flag = PageReceiptListing.checkSuccessfulCreationOfReturnNote(driver, testCaseName, returnNote.getReturnNoteNo());
			Assert.assertTrue("Fail to Create Return Note" + returnNote.getReturnNoteNo(), flag);

			PageReceiptListing.selectReturnNoteStatusFilter(driver, testCaseName);
			String status = PageReceiptListing.getFirstReceiptStatus(driver, testCaseName);
			if (status.equals("Returned"))
			{
				CommonServices.successfulExecutionOfTestCase(driver, testCase);
			}
			else
			{
				Assert.assertTrue("Status of Return Note is note Returned", false);
			}
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : 31-Oct-2017 </b>
	 * <b>Method : EPROC_9999 </b>
	 * <b>Description:Create return note>>On submit;and if there are no errors in the document, system will show a confirmation message: System will finalize the return note and send it to the supplier. Do you want to continue?</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_9999(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();

		User user = null;
		Receipt receipt = null;
		Requisition requisition = null;
		ReturnNote returnNote = null;
		PurchaseOrder purchaseOrder = null;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10002"));//Requisition>>CRN>>Item received>>Return method>>This should be a mandatory field
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10004"));//Requisition>>CRN>>Item received>>There should be field "Return method "
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10008"));//Requisition>>CRN>>Item received>>There should be field "Reason of Return"
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10010"));//Requisition>>CRN>>Item received>>Return quantity>>This should be a mandatory text field
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10011"));//Requisition>>CRN>>Item received>>There should be field "Return quantity"
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10017"));//Requisition>>CRN>>Supplier details>>Return Material Authorization # field should be present under supplier details section.It should be non mandatory field
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10018"));//Requisition>>CRN>>Supplier details>>Return Material Authorization # field should be present under supplier details section
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10020"));//Requisition>>CRN>>Supplier details>>Supplier email field should be present under supplier details section.It should be non mandatory field
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10021"));//Requisition>>CRN>>Supplier details>>Supplier email field should be present under supplier details section
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10023"));//Requisition>>CRN>>Supplier details>>Supplier contact field should be present under supplier details section.It should be non mandatory field
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10025"));//Requisition>>CRN>>Supplier details>>Supplier address>>It should be a mandatory field
			}

			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			//Requisition to PO
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);
			List<PurchaseOrder> listPurchaseOrder = requisition.getPurchaseOrdersList();
			purchaseOrder = listPurchaseOrder.get(0);

			// search po
			boolean flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue("Error while searching PO", flag);

			//to create receipt
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOListingActions.clickOnCreateReceiptLink(driver, testCaseName);

			receipt = ObjectCreation.getDefaultReceiptObject();
			receipt.setPurchaseOrder(purchaseOrder);
			receipt = FlowReceipt.createReceipt(driver, testCaseName, receipt);

			//Create Return Note
			returnNote = ObjectCreation.getDefaultReturnNoteObject();
			returnNote.setPurchaseOrder(purchaseOrder);
			returnNote.setNextAction(IConstantsData.NONE);

			//Open Return Note Form
			FlowReturnNote.openReturnNoteFrom(driver, testCaseName, returnNote);

			//Requisition>>CRN>>Item received>>Return method>>This should be a mandatory field("EPROC_10002")
			boolean returnMethod = PageCreateReturnNote.checkReturnMethodFieldMandatory(driver, testCaseName);
			Assert.assertTrue("Return Method is Not Mandatory Field", returnMethod);
			mappedTestCases.get(0).setTestResult(returnMethod);

			//Requisition>>CRN>>Item received>>There should be field "Return method "("EPROC_10004"))
			List<WebElement> returnMethodField = PageCreateReturnNote.getWebElementForReturnMethod(driver, testCaseName);
			if (returnMethodField.isEmpty())
			{
				returnMethod = false;
			}
			else
			{
				returnMethod = true;
			}
			Assert.assertTrue("Return Method Field Note Present", returnMethod);
			mappedTestCases.get(1).setTestResult(returnMethod);

			//Requisition>>CRN>>Item received>>There should be field "Reason of Return"("EPROC_10008")
			boolean reasonOfReturn;
			List<WebElement> reasonOfReturnList = PageCreateReturnNote.getWebElementForReasonForReturn(driver, testCaseName);
			if (reasonOfReturnList.isEmpty())
			{
				reasonOfReturn = false;
			}
			else
			{
				reasonOfReturn = true;
			}
			Assert.assertTrue("Reason of Return Field Note Present", reasonOfReturn);
			mappedTestCases.get(2).setTestResult(reasonOfReturn);

			//Requisition>>CRN>>Item received>>Return quantity>>This should be a mandatory text field("EPROC_10010")
			boolean returnQuantity = PageCreateReturnNote.checkReturnQuantityFieldMandatory(driver, testCaseName);
			Assert.assertTrue("Return Quantity Not mandatory Field", returnQuantity);
			mappedTestCases.get(3).setTestResult(returnQuantity);

			//Requisition>>CRN>>Item received>>There should be field "Return quantity"("EPROC_10011")
			List<WebElement> returnQuantityList = PageCreateReturnNote.getWebElementForReturnedQuantity(driver, testCaseName);
			if (returnQuantityList.isEmpty())
			{
				returnQuantity = false;
			}
			else
			{
				returnQuantity = true;
			}
			Assert.assertTrue("Return Quantity Field Note Present", returnQuantity);
			mappedTestCases.get(4).setTestResult(returnQuantity);

			//Requisition>>CRN>>Supplier details>>Return Material Authorization and It should be non mandatory field("EPROC_10017")
			boolean rmaField = PageCreateReturnNote.checkReturnMethodAuthorizationfieldPresent(driver, testCaseName);
			if (rmaField)
			{
				rmaField = PageCreateReturnNote.checkReturnMaterialAuthorizationMandatory(driver, testCaseName);
				Assert.assertTrue("Return Material Authorization Filed Present Mandatory", rmaField);
			}
			else
			{
				Assert.assertTrue("Return Material Authorization Filed Not Present", rmaField);
			}
			mappedTestCases.get(5).setTestResult(rmaField);

			//Requisition>>CRN>>Supplier details>>Return Material Authorization # field should be present under supplier details section("EPROC_10018")
			PageCreateReturnNote.selectNotifySupplierCheckBox(driver, testCaseName);
			rmaField = PageCreateReturnNote.checkReturnMethodAuthorizationfieldPresent(driver, testCaseName);
			Assert.assertTrue("Return Material Authorization Text Box Filed Not Present", rmaField);
			mappedTestCases.get(6).setTestResult(rmaField);
			PageCreateReturnNote.selectNotifySupplierCheckBox(driver, testCaseName);
			PageCreateReturnNote.clickOnContinueAutoDeleteCommentPopUp(driver, testCaseName);

			//Requisition>>CRN>>Supplier details>>Supplier email field And non mandatory field("EPROC_10020")
			boolean supplierEmail = PageCreateReturnNote.checkSupplierEmailFieldPresent(driver, testCaseName);
			if (supplierEmail)
			{
				supplierEmail = PageCreateReturnNote.checkSupplierEmailMandatory(driver, testCaseName);
				Assert.assertTrue("Supplier Email Filed Present and  Mandatory", supplierEmail);
			}
			else
			{
				Assert.assertTrue("Supplier Email Filed Not Present", supplierEmail);
			}
			mappedTestCases.get(7).setTestResult(supplierEmail);

			//Requisition>>CRN>>Supplier details>>Supplier email field should be present under supplier details section("EPROC_10021")
			supplierEmail = PageCreateReturnNote.checkSupplierEmailFieldPresent(driver, testCaseName);
			Assert.assertTrue("Supplier Email Filed Not Present", supplierEmail);
			mappedTestCases.get(8).setTestResult(supplierEmail);

			//Requisition>>CRN>>Supplier details>>Supplier contact field And non mandatory field("EPROC_10023")
			boolean supplierContact = PageCreateReturnNote.checkSupplierContactFieldPresent(driver, testCaseName);
			if (supplierContact)
			{
				supplierContact = PageCreateReturnNote.checkSupplierConatactMandatory(driver, testCaseName);
				Assert.assertTrue("Supplier Email Filed Present and Mandatory", supplierContact);
			}
			else
			{
				Assert.assertTrue("Supplier Email Filed Not Present", supplierContact);
			}
			mappedTestCases.get(9).setTestResult(supplierContact);

			//Requisition>>CRN>>Supplier details>>Supplier address>>It should be a mandatory field("EPROC_10025")
			Boolean supplierAddress = PageCreateReturnNote.checkSupplierAddressMandatory(driver, testCaseName);
			Assert.assertTrue("Supplier Address is Non Mandatory", supplierAddress);
			mappedTestCases.get(10).setTestResult(supplierContact);

			//Fill the Return Note Form
			returnNote = FlowReturnNote.fillReturnNoteForm(driver, testCaseName, returnNote);
			returnNote = FlowReturnNote.fillItemDetails(driver, testCaseName, returnNote);

			//Submit the Return Note 
			returnNote = FlowReturnNote.submitReturnNote(driver, testCaseName, returnNote);

			//Check for successful creation of Return Note
			flag = PageReceiptListing.checkSuccessfulCreationOfReturnNote(driver, testCaseName, returnNote.getReturnNoteNo());
			Assert.assertTrue("Fail to Create Return Note" + returnNote.getReturnNoteNo(), flag);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : 31-Oct-2017 </b>
	 * <b>Method : EPROC_10091 </b>
	 * <b>Description:Create return note>>There should be a field "Notify supplier" under basic details section</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_10091(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();

		User user = null;
		Receipt receipt = null;
		Requisition requisition = null;
		ReturnNote returnNote = null;
		PurchaseOrder purchaseOrder = null;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10030"));//Requisition>>CRN>>Supplier name field should be present under supplier details section
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10031"));//Requisition>>CRN>>Return note description>>This should be a mandatory text area field
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10042"));//Requisition>>CRN>>>>Return note number field should be present
			}

			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			//Requisition to PO
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);
			List<PurchaseOrder> listPurchaseOrder = requisition.getPurchaseOrdersList();
			purchaseOrder = listPurchaseOrder.get(0);

			// search po
			boolean flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue("Error while searching PO", flag);

			//to create receipt
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOListingActions.clickOnCreateReceiptLink(driver, testCaseName);

			receipt = ObjectCreation.getDefaultReceiptObject();
			receipt.setPurchaseOrder(purchaseOrder);
			receipt = FlowReceipt.createReceipt(driver, testCaseName, receipt);

			//Create Return Note
			returnNote = ObjectCreation.getDefaultReturnNoteObject();
			returnNote.setPurchaseOrder(purchaseOrder);
			returnNote.setNextAction(IConstantsData.NONE);

			//Open Return Note Form
			FlowReturnNote.openReturnNoteFrom(driver, testCaseName, returnNote);

			//Requisition>>CRN>>Supplier name field should be present under supplier details section("EPROC_10030")
			boolean supplierName = PageCreateReturnNote.checkSupplerNameLableFieldPresent(driver, testCaseName);
			Assert.assertTrue("Supplier Name Field Not Present", supplierName);
			mappedTestCases.get(0).setTestResult(supplierName);

			//Requisition>>CRN>>Return note description>>This should be a mandatory text area field("EPROC_10031")
			boolean returnNoteDescription = PageCreateReturnNote.checkReturnNoteDescriptionMandatory(driver, testCaseName);
			Assert.assertTrue("Return Note Description Field is non Mandatory", returnNoteDescription);
			mappedTestCases.get(1).setTestResult(returnNoteDescription);

			//Requisition>>CRN>>Return note number field should be present("EPROC_10042")
			boolean returnnoteNumber = PageCreateReturnNote.checkReturnNotenumberFieldPresent(driver, testCaseName);
			Assert.assertTrue("Return Note Number Field Not Present", returnnoteNumber);
			mappedTestCases.get(2).setTestResult(returnnoteNumber);

			//Select Item in Return Note
			PageCreateReturnNote.selectAllItemInReturnNote(driver, testCaseName);

			//check notify Supplier Field Present
			boolean supplierField = PageCreateReturnNote.checkNotifySupplierFieldPresent(driver, testCaseName);
			Assert.assertTrue("Notify Supplier Filed Not Present", supplierField);

			//Save As Draft Return Note
			returnNote = FlowReturnNote.submitSaveAsDraft(driver, testCaseName, returnNote);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : 31-Oct-2017 </b>
	 * <b>Method : EPROC_10073</b>
	 * <b>Description: Create return note>>Notify supplier>>If the user checks this field and again unchecks it, visibility of attachments incase added should be set to "Internal" at item level</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_10073(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();

		User user = null;
		Receipt receipt = null;
		ReturnNote returnNote = null;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10074"));//CRN>>NS>>again unchecks, visibility of attachment should be set to "Internal" at header level
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10075"));//CRN>>NS>>again unchecks, comments incase added should be autodeleted at item level
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10078"));//CRN>>NS>>If this value is checked, system should show visibility as "supplier" option in attachments modal at item level
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10079"));//CRN>>NS>>If this value is checked, system should show visibility as "supplier" option in attachments modal at header level
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10080"));//CRN>>NS>>If this value is checked,system should display the comments for supplier option in the comments section at line level
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_10081"));//CRN>>NS>>If this value is checked,system should display the comments for supplier option in the comments section at header level
			}

			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Creating Recipt for PO
			receipt = ObjectCreation.getDefaultReceiptObject();
			receipt = FlowReceipt.createReceiptFromStandardPO(driver, testCaseName, receipt);

			//Creating Return Note
			returnNote = ObjectCreation.getDefaultReturnNoteObject();
			returnNote.setStandardPO(receipt.getStandardPO());

			//Open Return Note Form For given PO
			FlowReturnNote.openReturnNoteFrom(driver, testCaseName, returnNote);

			//CRN>>NS>>again unchecks, visibility of attachment should be set to "Internal" at header level("EPROC_10074")
			{
				//select notify Supplier
				PageCreateReturnNote.selectNotifySupplierCheckBox(driver, testCaseName);

				//CRN>>NS>>If this value is checked,system should display the comments for supplier option in the comments section at header level("EPROC_10081")
				boolean supplierCommentLinelevel = PageCreateReturnNote.checkSupplierCommentFieldPresent(driver, testCaseName);
				Assert.assertTrue("Supplier Comment Line Level field Not present", supplierCommentLinelevel);
				mappedTestCases.get(5).setTestResult(supplierCommentLinelevel);

				//Click on Add attachment at header level
				PageCreateReturnNote.clickOnAddAttachmentAtHeaderLevel(driver, testCaseName);

				//Select File For Attachment
				ModelReturnNoteItemAttachment.selectFileForAttachmentHeaderLevel(driver, testCaseName);

				//CRE>>NS>>If this value is checked, system should show visibility as "supplier" option in attachments modal at item level("EPROC_10079")
				boolean supplierVisibility = ModelReturnNoteItemAttachment.checkSupplierFieldInAttachmentVisibility(driver, testCaseName);
				Assert.assertTrue("Supplier in visibility Pop Up not Present", supplierVisibility);
				mappedTestCases.get(3).setTestResult(supplierVisibility);

				ModelReturnNoteItemAttachment.selectSupplierInAttachmentVisibility(driver, testCaseName);
				ModelReturnNoteItemAttachment.clickOnSaveAttachmentButton(driver, testCaseName);

				//De Select notify Supplier
				PageCreateReturnNote.selectNotifySupplierCheckBox(driver, testCaseName);
				PageCreateReturnNote.clickOnContinueAutoDeleteCommentPopUp(driver, testCaseName);

				//Open Attachment
				PageCreateReturnNote.clickOnAddAttachmentAtHeaderLevel(driver, testCaseName);
				String visibility = ModelReturnNoteItemAttachment.getAttachmentVisibilityWhenNotifySupplierUncheck(driver, testCaseName);
				if (visibility.equalsIgnoreCase("Internal"))
				{
					Assert.assertTrue("Visibility is not Internal", true);
					mappedTestCases.get(0).setTestResult(true);
				}
				else
				{
					mappedTestCases.get(0).setTestResult(false);
				}

				ModelReturnNoteItemAttachment.clickOnSaveAttachmentButton(driver, testCaseName);
			}

			//CRN>>NS>>again unchecks, comments incase added should be autodeleted at item level("EPROC_10075")
			{
				//select notify Supplier
				PageCreateReturnNote.selectNotifySupplierCheckBox(driver, testCaseName);
				PageCreateReturnNote.selectAllItemInReturnNote(driver, testCaseName);
				List<WebElement> commentAndAttachment = ModelReturnNoteItemAttachment.getWebElementCommentsAndAttachment(driver, testCaseName);
				WebElement element = commentAndAttachment.get(0);
				//click on Comment and Attachment for first item in list
				ModelReturnNoteItemAttachment.clickOnCommentAndAttachment(driver, testCaseName, element);

				ModelReturnNoteItemAttachment.selectFileForAttachmentInItem(driver, testCaseName);

				//CRE>>NS>>If this value is checked, system should show visibility as "supplier" option in attachments modal at item level("EPROC_10078")
				boolean supplierVisibility = ModelReturnNoteItemAttachment.checkSupplierFieldInAttachmentVisibilityItemLevel(driver, testCaseName);
				Assert.assertTrue("Supplier in visibility Pop Up not Present", supplierVisibility);
				mappedTestCases.get(2).setTestResult(supplierVisibility);

				//CRN>>NS>>If this value is checked,system should display the comments for supplier option in the comments section at line level("EPROC_10080")
				boolean supplierCommentItemLevel = ModelReturnNoteItemAttachment.checkSupplierCommentTextFieldPresent(driver, testCaseName);
				Assert.assertTrue("Supplier Comment Header Level field Not present", supplierCommentItemLevel);
				mappedTestCases.get(4).setTestResult(supplierCommentItemLevel);

				ModelReturnNoteItemAttachment.fillTextItemInternalComment(driver, testCaseName, null);
				ModelReturnNoteItemAttachment.fillTextItemSupplierComment(driver, testCaseName, null);
				ModelReturnNoteItemAttachment.clickOnSaveAttachmentOkButtonItemLevel(driver, testCaseName);

				PageCreateReturnNote.selectNotifySupplierCheckBox(driver, testCaseName);
				PageCreateReturnNote.clickOnContinueAutoDeleteCommentPopUp(driver, testCaseName);

				ModelReturnNoteItemAttachment.clickOnCommentAndAttachment(driver, testCaseName, element);
				boolean supplierComment = ModelReturnNoteItemAttachment.checkSupplierCommentTextFieldPresent(driver, testCaseName);
				Assert.assertTrue("Supplier Comment Still Presentpresent", !supplierComment);
				mappedTestCases.get(1).setTestResult(!supplierComment);

				//Check visibility of attachment is changed to Internal(EPROC_10073)
				String visibility = ModelReturnNoteItemAttachment.getAttachmentVisibilityWhenNotifySupplierUncheckItemLevel(driver, testCaseName);
				if (visibility.equalsIgnoreCase("Internal"))
				{
					Assert.assertTrue("Visibility is not Internal", true);
				}

				//Close Add Comment and Attachment Model
				ModelReturnNoteItemAttachment.clickOnCloseAttachmentbutton(driver, testCaseName);
			}

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : </b>
	 * <b>Method : EPROC_9897</b>
	 * <b>Description:[Auto Return notes creation ]Requisition>>For return items>>User should be allowed to save the receipt as draft with the return details provided in it</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_9897(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		{

		}
		User user = null;
		Receipt receipt = null;
		Requisition requisition = null;
		PurchaseOrder purchaseOrder = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			//Requisition to PO
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);
			List<PurchaseOrder> listPurchaseOrder = requisition.getPurchaseOrdersList();
			purchaseOrder = listPurchaseOrder.get(0);

			// search po
			boolean flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue("Error while searching PO", flag);

			//to create receipt
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOListingActions.clickOnCreateReceiptLink(driver, testCaseName);

			receipt = ObjectCreation.getDefaultReceiptObject();
			receipt.setPurchaseOrder(purchaseOrder);
			receipt.setNextAction(IConstantsData.NONE);
			receipt = FlowReceipt.createReceipt(driver, testCaseName, receipt);

			String pendingItem = PageCreateReceipt.getPendingItem(driver, testCaseName, "1");
			float pend = Float.parseFloat(pendingItem);
			int pending = (int) pend;
			PageCreateReceipt.fillReceiptComments(driver, testCaseName, null);
			PageCreateReceipt.fillReceivedQuantityForItem(driver, testCaseName, "1", pending);
			PageCreateReceipt.fillApprovedQuantityForItem(driver, testCaseName, "1", pending - 1);
			PageCreateReceipt.fillReceiptComments(driver, testCaseName, null);
			PageCreateReceipt.selectReasonForReturnUsingWebElement(driver, testCaseName, "Damaged Item");
			PageCreateReceipt.selectReturnMethodUsingWebElement(driver, testCaseName, "Replacement");

			PageCreateReceipt.clickOnSaveReceiptAsDraftButton(driver, testCaseName);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * 
	 * <b>Author: sameer.zilpilwar </b>
	 * <b>Created On : </b>
	 * <b>Method : EPROC_9899</b>
	 * <b>Description:[Auto Return notes creation ]Requisition>>For return items>>Return notes of the rejected items should get created on receipt submission</b>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_9899(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();

		User user = null;
		Receipt receipt = null;
		Requisition requisition = null;
		PurchaseOrder purchaseOrder = null;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9900"));//Auto Return notes creation>>Requisition>>For return items>>RMA number on the receipt incase there are any returned goods
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9901"));//For return items>>Receipt should have new section "Return notes Information">>RMA number of the goods returned will be captured.This section should be displayed only incase there is any returned qty present in the order
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9902"));//Return Note Information Present
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_9903"));//Comments and Attachment filed Present in Return note Part 
			}

			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.GUIDED_ITEM);

			//Requisition to PO
			requisition = CombineFlowImpl.reqToPO(driver, testCaseName, requisition);
			List<PurchaseOrder> listPurchaseOrder = requisition.getPurchaseOrdersList();
			purchaseOrder = listPurchaseOrder.get(0);

			// search po
			boolean flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			Assert.assertTrue("Error while searching PO", flag);

			//to create receipt
			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			ModalPOListingActions.clickOnCreateReceiptLink(driver, testCaseName);

			receipt = ObjectCreation.getDefaultReceiptObject();
			receipt.setPurchaseOrder(purchaseOrder);
			receipt.setNextAction(IConstantsData.NONE);
			receipt = FlowReceipt.createReceipt(driver, testCaseName, receipt);

			String pendingItem = PageCreateReceipt.getPendingItem(driver, testCaseName, "1");
			float pend = Float.parseFloat(pendingItem);
			int pending = (int) pend;
			PageCreateReceipt.fillReceiptComments(driver, testCaseName, null);
			PageCreateReceipt.fillReceivedQuantityForItem(driver, testCaseName, "1", pending);
			PageCreateReceipt.fillApprovedQuantityForItem(driver, testCaseName, "1", pending - 1);
			PageCreateReceipt.fillReceiptComments(driver, testCaseName, null);
			PageCreateReceipt.selectReasonForReturnUsingWebElement(driver, testCaseName, "Damaged Item");
			PageCreateReceipt.selectReturnMethodUsingWebElement(driver, testCaseName, "Replacement");
			{
				//Auto Return notes creation>>RMA number on the receipt incase there are any returned goods("EPROC_9900")
				boolean returnNoteInfo = PageCreateReceipt.checkReturnNoteInformationFieldPresent(driver, testCaseName);
				//Return Note Information Present("EPROC_9902")
				Assert.assertTrue("Return Note Information Field Presnt", returnNoteInfo);
				mappedTestCases.get(2).setTestResult(returnNoteInfo);

				if (returnNoteInfo)
				{
					//For return items>>Receipt should have new section "Return notes Information">>RMA number of the goods returned will be captured.This section should be displayed only incase there is any returned qty present in the order("EPROC_9901")
					returnNoteInfo = PageCreateReturnNote.checkReturnMethodAuthorizationfieldPresent(driver, testCaseName);
					Assert.assertTrue("RMA Filled is present", returnNoteInfo);
					mappedTestCases.get(1).setTestResult(returnNoteInfo);
					//Fill Return Material Autorization 
					PageCreateReturnNote.fillReturnMaterialAuthorization(driver, testCaseName, null);
					logger.info("Return Material Authorization Field Present and Filled");
				}
				else
				{
					logger.info("Return Note Information Field Present");
				}
				Assert.assertTrue("Return Note Information Field Presnt And RMA field present ", returnNoteInfo);
				mappedTestCases.get(0).setTestResult(returnNoteInfo);
			}
			//Comments and Attachment filed Present in Return note Part("EPROC_9903")
			boolean commentAndAttachment = PageCreateReceipt.checkCommentAndAttachmentInRNFieldPresent(driver, testCaseName);
			Assert.assertTrue("Comment and Attachement part not present", commentAndAttachment);
			mappedTestCases.get(3).setTestResult(commentAndAttachment);

			//Submit Return Note
			FlowReceipt.submitReceipt(driver, testCaseName);

			receipt.setReceiptNo(PageReceiptListing.getFirstReceiptNo(driver, testCaseName));
			if (receipt.getReceiptNo() != null)
			{
				logger.info("Receipt Created Successfully Receipt number" + receipt.getReceiptNo());
				String returnNoteNumber = PageReceiptListing.getFirstReturnNoteNumber(driver, testCaseName);
				if (returnNoteNumber != null)
				{
					logger.info("Retunr Note Created successfully Return Note Number" + returnNoteNumber);
				}
			}
			else
			{
				Assert.assertTrue("Unable to create Receipt and Return note", false);
			}

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

}
