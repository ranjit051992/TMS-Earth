package com.zycus.automation.eproc.testcase.regression.eForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.zycus.automation.bo.CEform;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.PEform;
import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.MappedTestCaseUtil;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.ceformflow.FlowCEform;
import com.zycus.automation.eproc.businessflow.peformflow.FlowPEform;
import com.zycus.automation.eproc.pageobjects.modals.createsectionofceform.ModalCreateSectionOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.previewceform.ModalPreviewCEform;
import com.zycus.automation.eproc.pageobjects.modals.selectbuofceform.ModalSelectBUOfCEform;
import com.zycus.automation.eproc.pageobjects.modals.selectcategoryofceform.ModalSelectCategoryOfCEform;
import com.zycus.automation.eproc.pageobjects.pages.ceformlisting.IPageCEformListing;
import com.zycus.automation.eproc.pageobjects.pages.ceformlisting.PageCEformListing;
import com.zycus.automation.eproc.pageobjects.pages.createceform.IPageCreateCEform;
import com.zycus.automation.eproc.pageobjects.pages.createceform.PageCreateCEform;
import com.zycus.automation.eproc.pageobjects.pages.createpeform.IPageCreatePEform;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testcase.regression.requistionForking.RequisitionForkingTestCases;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;

public class eFormTestCases extends TestDataProvider
{
	static Logger logger = Logger.getLogger(RequisitionForkingTestCases.class);

	/**
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify user should be able to deactivate category eform successfully</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21397(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		User user = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = null;
		boolean flag_EPROC_21397_create = false;
		boolean flag_EPROC_21397 = false;
		boolean flag_isActivate = false;

		try
		{
			mappedTestCases = new ArrayList<MappedTestCase>();

			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_21367"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_21391"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_21396"));
			}
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get CEform object
			CEform cEform = ObjectCreation.getDefaultCEformObject();

			//Create CEform
			//TC-EPROC-21367
			cEform = FlowCEform.createCEform(driver, testCaseName, cEform);

			//Search created CEform by using CEform name
			//TC-EPROC-21391
			flag_EPROC_21397_create = FlowCEform.searchCEform(driver, testCaseName, cEform.getCeformName());

			Assert.assertTrue("User not able to create  category eform via online editor successfully", flag_EPROC_21397_create);
			Assert.assertTrue("User not able to search category eform by name successfully", flag_EPROC_21397_create);

			mappedTestCases.get(0).setTestResult(flag_EPROC_21397_create);
			
			mappedTestCases.get(1).setTestResult(flag_EPROC_21397_create);
		
			
			//Deactivate created CEform 
			flag_EPROC_21397 = FlowCEform.deactivateCEform(driver, testCaseName, cEform.getCeformName());

			Assert.assertTrue("User not able to deactivate category eform  successfully", flag_EPROC_21397);

			//Activate deactivated CEform
			//TC-EPROC-21396
			flag_isActivate = FlowCEform.activateCEform(driver, testCaseName, cEform.getCeformName());

			Assert.assertTrue("User not able to activate category eform successfully", flag_isActivate);
			mappedTestCases.get(2).setTestResult(flag_isActivate);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify user should be able to copy a category eform and resubmit it successfully</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21393(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flag_created = false;
		boolean flag_EPROC_21393 = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get CEform object
			CEform cEform = ObjectCreation.getDefaultCEformObject();
			cEform.setCategory(CommonServices.getTestData(IConstantsData.eFormCategory1));

			//Create CEform 
			cEform = FlowCEform.createCEform(driver, testCaseName, cEform);

			//Check whether CEform is created or not
			flag_created = FlowCEform.searchCEform(driver, testCaseName, cEform.getCeformName());

			Assert.assertTrue("User not able create new category eform", flag_created);

			//Copy created CEform
			cEform.setCategory(CommonServices.getTestData(IConstantsData.eFormCategory2));
			CEform cEform_copy = FlowCEform.copyCEForm(driver, testCaseName, cEform, CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME));

			//Search whether copy for created CEform is created or not
			flag_EPROC_21393 = FlowCEform.searchCEform(driver, testCaseName, cEform_copy.getCeformName());

			Assert.assertTrue("User not able to copy a category eform and resubmit it successfully", flag_EPROC_21393);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify user should able to search category eform by "category" " successfully</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21392(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flag_EPROC_21392 = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get CEform object
			CEform cEform = ObjectCreation.getDefaultCEformObject();
			cEform.setCategory(CommonServices.getTestData(IConstantsData.eFormCategory3));

			//Create CEform
			cEform = FlowCEform.createCEform(driver, testCaseName, cEform);

			PageCEformListing.selectSearchInOptionForCEform(driver, testCaseName, 0);
			PageCEformListing.fillSearchCEform(driver, testCaseName, cEform.getCategory());

			List<WebElement> element = PageCEformListing.getAllCEforms(driver, testCaseName);

			for (WebElement ele : element)
			{
				if (ele.getText().trim().equalsIgnoreCase(cEform.getCeformName()))
				{
					flag_EPROC_21392 = true;
					break;
				}
			}

			Assert.assertTrue("User not able to search category eform by category successfully", flag_EPROC_21392);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify user should be able to save category eform as " Draft" successfully</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21399(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flag_EPROC_21399 = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Create CEform object
			CEform cEform = ObjectCreation.getDefaultCEformObject();
			cEform.setNextAction(IConstantsData.SAVE_AS_DRAFT_EFORM);

			//Create CEform 
			cEform = FlowCEform.createCEform(driver, testCaseName, cEform);

			//Search for created CEform
			flag_EPROC_21399 = FlowCEform.searchCEform(driver, testCaseName, cEform.getCeformName());

			Assert.assertTrue("User not able to save category eform as Draft successfully", flag_EPROC_21399);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify while creating category eform, if user clicks on "cancel" button, user should redirects to eform listing page</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21410(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flag_EPROC_21410 = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Create CEform object
			CEform cEform = ObjectCreation.getDefaultCEformObject();
			cEform.setNextAction(IConstantsData.CANCEL);

			//Create CEform 
			cEform = FlowCEform.createCEform(driver, testCaseName, cEform);

			//Check whether user redirected to listing page or not by verifying search filter is present or not on listing page 
			flag_EPROC_21410 = PageCEformListing.isFillSearchCEformPresent(driver, testCaseName);

			Assert.assertTrue("While creating category eform, if user clicks on cancel button, user not able to redirects to eform listing page", flag_EPROC_21410);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify user should be able to delete category eform successfully</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21400(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flag_EPROC_21400_create = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get CEform object
			CEform cEform = ObjectCreation.getDefaultCEformObject();

			//Create CEform
			cEform = FlowCEform.createCEform(driver, testCaseName, cEform);

			//Search created CEform

			flag_EPROC_21400_create = FlowCEform.searchCEform(driver, testCaseName, cEform.getCeformName());

			Assert.assertTrue("User not able to create category eform successfully", flag_EPROC_21400_create);

			//Deactivate created CEform 
			FlowCEform.deactivateCEform(driver, testCaseName, cEform.getCeformName());

			//Delete created CForm
			FlowCEform.deleteCEform(driver, testCaseName, cEform.getCeformName());

			//Search created CEform
			boolean flag_EPROC_21400 = FlowCEform.searchCEform(driver, testCaseName, cEform.getCeformName());

			Assert.assertTrue("User not able to delete category eform  successfully", !flag_EPROC_21400);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify User should able to create new process eform via online editor</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21328(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = null;

		User user = null;
		boolean flag_EPROC_21328 = false;
		boolean flag_isdeactivated = false;

		try
		{
			mappedTestCases = new ArrayList<MappedTestCase>();
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_21343"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_21344"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_21338"));
			}
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get PEform object
			PEform pEform = ObjectCreation.getDefaultPEformObject();

			//Set process name as REquisition
			//TC-EPROC-21344
			pEform.setProcessName(IConstantsData.REQUISITION_FORMS);

			//Create PEform and publish
			//TC-EPROC-21343
			pEform = FlowPEform.createPEForm(driver, testCaseName, pEform);

			//Search created PEform
			flag_EPROC_21328 = FlowPEform.searchePEForm(driver, testCaseName, pEform.getPeformName());

			Assert.assertTrue("User not able to create new process eform via online editor", flag_EPROC_21328);
			mappedTestCases.get(0).setTestResult(flag_EPROC_21328);
			mappedTestCases.get(1).setTestResult(flag_EPROC_21328);

			//Deactivate PEform
			flag_isdeactivated = FlowPEform.deactivatePEform(driver, testCaseName, pEform.getPeformName());
			mappedTestCases.get(2).setTestResult(flag_isdeactivated);
			Assert.assertTrue("User not able to deactivate PEform successfully", flag_isdeactivated);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify user should be able to modify a category eform and resubmit it successfully</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21398(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean creationFlag = false;
		boolean flag_EPROC_21398 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get CEform object
			CEform cEform = ObjectCreation.getDefaultCEformObject();

			cEform.setNextAction(IConstantsData.SAVE_AS_DRAFT_EFORM);

			//Create CEform
			cEform = FlowCEform.createCEform(driver, testCaseName, cEform);

			//Search created CEform
			creationFlag = FlowCEform.searchCEform(driver, testCaseName, cEform.getCeformName());

			Assert.assertTrue("User not able to create CEform successfully", creationFlag);

			cEform.setCategory(CommonServices.getTestData(IConstantsData.eFormCategory1));
			cEform.setAddSectionAndField(false);
			cEform.setNextAction(IConstantsData.PUBLISH_EFORM);

			//Modify CEform
			CEform modifiedCEform = FlowCEform.modifyCEform(driver, testCaseName, cEform);

			flag_EPROC_21398 = FlowCEform.searchCEform(driver, testCaseName, modifiedCEform.getCeformName());

			Assert.assertTrue("User not  able to modify a category eform and resubmit it successfully", flag_EPROC_21398);

			FlowCEform.searchCEform(driver, testCaseName, cEform.getCeformName());
			ActionBot.click(driver, IPageCreateCEform.EFORM_CLICK_FIRST_EFORM_LINK);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify user should be able to update a category eform and resubmit it successfully</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21394(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean creationFlag = false;
		boolean flag_EPROC_21394 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get CEform object
			CEform cEform = ObjectCreation.getDefaultCEformObject();

			//Create CEform
			cEform = FlowCEform.createCEform(driver, testCaseName, cEform);

			//Search created CEform
			creationFlag = FlowCEform.searchCEform(driver, testCaseName, cEform.getCeformName());

			Assert.assertTrue("User not able to create CEform successfully", creationFlag);

			cEform.setCategory(CommonServices.getTestData(IConstantsData.eFormCategory1));
			cEform.setAddSectionAndField(false);
			cEform.setNextAction(IConstantsData.PUBLISH_EFORM);

			//Update CEform
			CEform updatedCEform = FlowCEform.updateCEform(driver, testCaseName, cEform);

			flag_EPROC_21394 = FlowCEform.searchCEform(driver, testCaseName, updatedCEform.getCeformName());

			Assert.assertTrue("User not  able to update a category eform and resubmit it successfully", flag_EPROC_21394);

			FlowCEform.searchCEform(driver, testCaseName, cEform.getCeformName());
			ActionBot.click(driver, IPageCreateCEform.EFORM_CLICK_FIRST_EFORM_LINK);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify user should be able to save process eform as " Draft" successfully</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21339(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flag_EPROC_21339 = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get PEform object
			PEform pEform = ObjectCreation.getDefaultPEformObject();
			pEform.setNextAction(IConstantsData.SAVE_AS_DRAFT_EFORM);

			//Create PEform
			pEform = FlowPEform.createPEForm(driver, testCaseName, pEform);

			//Search created PEform
			flag_EPROC_21339 = FlowPEform.searchePEForm(driver, testCaseName, pEform.getPeformName());

			Assert.assertTrue("User not able to save category eform as Draft successfully", flag_EPROC_21339);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify user should be able to copy a process eform and resubmit it successfully</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21335(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flag_created = false;
		boolean flag_EPROC_21335 = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get PEform object
			PEform pEform = ObjectCreation.getDefaultPEformObject();

			//Create PEform 
			pEform = FlowPEform.createPEForm(driver, testCaseName, pEform);

			//Check whether PEform is created or not
			flag_created = FlowPEform.searchePEForm(driver, testCaseName, pEform.getPeformName());

			Assert.assertTrue("User not able create new process eform", flag_created);

			//Copy created PEform
			PEform pEform_copy = FlowPEform.copyPEForm(driver, testCaseName, pEform, IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME);

			//Search whether copy for created PEform is created or not
			flag_EPROC_21335 = FlowPEform.searchePEForm(driver, testCaseName, pEform_copy.getPeformName());

			Assert.assertTrue("User not able to copy a process eform and resubmit it successfully", flag_EPROC_21335);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify user should be able to delete process eform successfully</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21340(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flag_EPROC_21340_create = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get PEform object
			PEform pEform = ObjectCreation.getDefaultPEformObject();

			//Create PEform
			pEform = FlowPEform.createPEForm(driver, testCaseName, pEform);

			//Search created PEform
			flag_EPROC_21340_create = FlowPEform.searchePEForm(driver, testCaseName, pEform.getPeformName());

			Assert.assertTrue("User not able to create process eform successfully", flag_EPROC_21340_create);

			//Deactivate created PEform 
			FlowPEform.deactivatePEform(driver, testCaseName, pEform.getPeformName());

			//Delete created PEForm
			FlowPEform.deletePEform(driver, testCaseName, pEform.getPeformName());

			//Search deleted PEform
			boolean flag_EPROC_21340 = FlowPEform.searchePEForm(driver, testCaseName, pEform.getPeformName());

			Assert.assertTrue("User not able to delete process eform  successfully", !flag_EPROC_21340);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify user is able to preview the category eform before clicking on "publish"</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21409(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flag_section = false;
		boolean flag_field = false;
		boolean flag_EPROC_21409 = false;
		String sectionName = null;
		String fieldName = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Create CEform object
			CEform cEform = ObjectCreation.getDefaultCEformObject();
			cEform.setNextAction(IConstantsData.PREVIEW_EFORM);

			//Create CEform
			cEform = FlowCEform.createCEform(driver, testCaseName, cEform);

			//Check preview
			sectionName = ModalPreviewCEform.getSectionName(driver, testCaseName);
			fieldName = ModalPreviewCEform.getFieldName(driver, testCaseName);

			flag_section = sectionName.equals(cEform.getSectionName());
			flag_field = fieldName.equals(cEform.getFieldName());
			flag_EPROC_21409 = flag_field && flag_section;

			Assert.assertTrue("User not able to preview the category eform before clicking on publish", flag_EPROC_21409);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify user is able to preview the process eform before clicking on "publish"</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21341(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flag_section = false;
		boolean flag_field = false;
		boolean flag_EPROC_21341 = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Create PEform object
			PEform pEform = ObjectCreation.getDefaultPEformObject();
			pEform.setNextAction(IConstantsData.PREVIEW_EFORM);

			//Create PEform
			pEform = FlowPEform.createPEForm(driver, testCaseName, pEform);

			//Check preview
			String sectionName = ModalPreviewCEform.getSectionName(driver, testCaseName);
			String fieldName = ModalPreviewCEform.getFieldName(driver, testCaseName);

			flag_section = sectionName.equals(pEform.getSectionName());
			flag_field = fieldName.equals(pEform.getFieldName());
			flag_EPROC_21341 = flag_field && flag_section;

			Assert.assertTrue("User not able to preview the process eform before clicking on publish", flag_EPROC_21341);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description:Verify when user creating new category eform via online editor,user should not
	 * be able to move to next page untill user does not fill "Form name",
	 * "Display name","categories", Organisational Unit"(mandatory field)</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21368(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flagName = false;
		boolean flagDispalyName = false;
		boolean flagScope = false;
		String nameError = null;
		String dnameError = null;
		String scopeError = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			MainPageHeaderLevelTab.clickOnCategoryEformTab(driver, testCaseName);
			PageCEformListing.clickOnOnlineEditor(driver, testCaseName);

			//Proceed without filling name and display name
			PageCreateCEform.clickOnSaveAndContinue(driver, testCaseName);

			//Check name and display name error
			nameError = ActionBot.findElement(driver, IPageCEformListing.NAME_FIELD_ERROR).getText();
			dnameError = ActionBot.findElement(driver, IPageCEformListing.DISPLAY_NAME_FIELD_ERROR).getText();

			flagName = nameError.contains(IConstantsData.INVALID_EFORM_NAME);
			flagDispalyName = dnameError.contains(IConstantsData.INVALID_EFORM_DISPLAY_NAME);

			Assert.assertTrue("User able to move to next page untill user does not fill mandatory field", flagName && flagDispalyName);

			PageCreateCEform.fillCFormName(driver, testCaseName, "TestName");
			PageCreateCEform.fillCFormDisplayName(driver, testCaseName, "TestDisplayName");

			//Proceed without selecting scope
			PageCreateCEform.clickOnSaveAndContinue(driver, testCaseName);

			//Check Scope error
			scopeError = ActionBot.findElement(driver, IPageCEformListing.SCOPE_ERROR).getText();

			flagScope = scopeError.contains(IConstantsData.BLANK_SCOPE_ERROR);

			Assert.assertTrue("User able to move next page without selecting scope", flagScope);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description:Verify when user creating category eform via online editor,on second page i.e"form field",
	 * while adding section "name" should be mandatory field</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21376(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = null;
		User user = null;
		boolean flagSectionNameError = false;
		boolean secondpageFlag = false;
		String sectionNameError = null;
		try
		{
			mappedTestCases = new ArrayList<MappedTestCase>();
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_21375"));
			}
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get CEform object
			CEform cEform = ObjectCreation.getDefaultCEformObject();

			//Set section name empty
			cEform.setSectionName("");

			MainPageHeaderLevelTab.clickOnCategoryEformTab(driver, testCaseName);

			PageCEformListing.clickOnOnlineEditor(driver, testCaseName);

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
				//To select categories
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

			if (cEform.isChangeOU())
			{
				//To select OU
				PageCreateCEform.clickOnLinkSelectOUForCForm(driver, testCaseName);

				ActionBot.defaultLowSleep();
				ModalSelectBUOfCEform.selectIstOrganisationUnit(driver, testCaseName);
				//Select BU
				ActionBot.defaultSleep();
				ModalSelectBUOfCEform.clickTabBusinessUnit(driver, testCaseName);
				ActionBot.defaultSleep();
				ModalSelectBUOfCEform.clickLinkSelectBusinessUnit(driver, testCaseName);
				ActionBot.defaultSleep();
				ModalSelectBUOfCEform.SelectCheckBoxOU(driver, testCaseName);
				//Save modal
				ModalSelectBUOfCEform.clickBtnSaveSelectedOu(driver, testCaseName);
				ActionBot.defaultSleep();
				ModalSelectBUOfCEform.clickOnSaveORGUnitButton(driver, testCaseName);
			}

			//To save and continue
			PageCreateCEform.clickOnSaveAndContinue(driver, testCaseName);

			//TC-EPROC-21375
			secondpageFlag = ActionBot.isElementPresent(driver, IPageCreateCEform.LINK_ADD_SECTION_TO_CFORM);
			Assert.assertTrue("User not able to add section on second page", secondpageFlag);

			mappedTestCases.get(0).setTestResult(secondpageFlag);

			if (cEform.isAddSectionAndField())
			{
				// To add section
				PageCreateCEform.clickOnAddSectionLink(driver, testCaseName);
				// To fill section details
				cEform.setSectionName(ModalCreateSectionOfCEform.fillSectionName(driver, testCaseName, cEform.getSectionName()));
				ModalCreateSectionOfCEform.clickOnSaveSectionButton(driver, testCaseName);

			}

			//Check Section name error
			sectionNameError = ActionBot.findElement(driver, IPageCEformListing.SECTIONNAME_ERROR).getText();
			flagSectionNameError = sectionNameError.contains(IConstantsData.BLANK_SECTIONNAME_ERROR);

			Assert.assertTrue("Section name not mandatory field", flagSectionNameError);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify user should be able to update a process eform and resubmit it successfully</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21336(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean creationFlag = false;
		boolean flag_EPROC_21336 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get PEform object
			PEform pEform = ObjectCreation.getDefaultPEformObject();

			//Create PEform
			pEform = FlowPEform.createPEForm(driver, testCaseName, pEform);

			//Search created PEform
			creationFlag = FlowPEform.searchePEForm(driver, testCaseName, pEform.getPeformName());

			Assert.assertTrue("User not able to create PEform successfully", creationFlag);

			pEform.setNextAction(IConstantsData.PUBLISH_EFORM);

			//Update PEform
			PEform updatedPEform = FlowPEform.updatePEform(driver, testCaseName, pEform);
			flag_EPROC_21336 = FlowPEform.searchePEForm(driver, testCaseName, updatedPEform.getPeformName());

			Assert.assertTrue("User not able to update a process eform and resubmit it successfully", flag_EPROC_21336);

			//View eForm
			FlowPEform.searchePEForm(driver, testCaseName, pEform.getPeformName());
			ActionBot.click(driver, IPageCreatePEform.EFORM_CLICK_FIRST_EFORM_LINK);
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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify User should able to create new process eform via file upload</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21329(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean creationFlag = false;
		boolean deactivateFlag = false;
		boolean deleteFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get PEform object
			PEform pEform = new PEform();
			pEform.setPurchaseType(CommonServices.getTestData(IConstantsData.PURCHASE_TYPE));
			pEform.setChangeOU(true);
			pEform.setOU(CommonServices.getTestData(IConstantsData.BU_NAME_FOR_CEFORM));
			pEform.setFileUpload(true);
			pEform.setNextAction(IConstantsData.IMPORT_PEFORM);

			//Create PEform
			pEform = FlowPEform.createFileUploadPEForm(driver, testCaseName, pEform);

			//Search created PEform
			creationFlag = FlowPEform.searchePEForm(driver, testCaseName, pEform.getPeformName());

			Assert.assertTrue("User not able to create PEform via file upload successfully", creationFlag);

			//Deactivate created form
			deactivateFlag = FlowPEform.deactivatePEform(driver, testCaseName, pEform.getPeformName());
			Assert.assertTrue("User not able to deactivate process eForm successfully", deactivateFlag);

			//Delete created form
			deleteFlag = FlowPEform.deletePEform(driver, testCaseName, pEform.getPeformName());
			Assert.assertTrue("User not able to delete process eForm successfully", deleteFlag);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify user should able to create new category eform via file upload successfully</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21388(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flag_EPROC_21388 = false;
		boolean deactivateFlag = false;
		boolean deleteFlag = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get CEform object
			CEform cEform = new CEform();
			cEform.setFileUpload(true);
			cEform.setChangeOU(true);
			cEform.setOU(CommonServices.getTestData(IConstantsData.BU_NAME_FOR_CEFORM));
			cEform.setNextAction(IConstantsData.IMPORT_PEFORM);

			//Create CEform via file uplaod
			cEform = FlowCEform.createFileUploadCEForm(driver, testCaseName, cEform);

			//Search for created CEform
			flag_EPROC_21388 = FlowCEform.searchCEform(driver, testCaseName, cEform.getCeformName());

			Assert.assertTrue("User not able create new category eform via file upload successfully", flag_EPROC_21388);

			//Deactivate created form
			deactivateFlag = FlowCEform.deactivateCEform(driver, testCaseName, cEform.getCeformName());
			Assert.assertTrue("User not able to deactivate category eForm successfully", deactivateFlag);

			//Delete created form
			deleteFlag = FlowCEform.deleteCEform(driver, testCaseName, cEform.getCeformName());
			Assert.assertTrue("User not able to delete category eForm successfully", deleteFlag);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify that while creating process eform via file upload, the selected file must be
	 * none other then in " .zip" or ".pform" format</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21330(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = null;

		User user = null;
		boolean EPROC_21330_errorFlag = false;
		String invalidTypeError = null;
		try
		{
			mappedTestCases = new ArrayList<MappedTestCase>();
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_21331"));
			}
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get PEform object
			PEform pEform = new PEform();
			pEform.setPurchaseType(CommonServices.getTestData(IConstantsData.PURCHASE_TYPE));
			pEform.setChangeOU(true);
			pEform.setOU(CommonServices.getTestData(IConstantsData.BU_NAME_FOR_CEFORM));
			pEform.setFileUpload(true);
			pEform.setNextAction(IConstantsData.IMPORT_PEFORM);

			MainPageHeaderLevelTab.clickOnProcessEformTab(driver, testCaseName);

			PageCEformListing.clickOnFileUpload(driver, testCaseName);

			WebElement element = driver.findElement(By.xpath(IPageCEformListing.FILE_UPLOAD_ATTACHMENT));

			//TC:EPROC_21331-Verify when uploading unsupported file in eform via file upload and validation should be provided.

			//upload_invalid_eform_file:validation.jpg file which is unsupported
			element.sendKeys(ConfigProperty.getConfig("attachmentFilePath") + ConfigProperty.getConfig("upload_invalid_eform_file"));
			ActionBot.waitForPageLoad(driver);

			logger.info("Selected file::" + ConfigProperty.getConfig("attachmentFilePath") + ConfigProperty.getConfig("upload_invalid_eform_file"));
			ScreenShot.screenshot(driver, testCaseName, "After filling path");

			invalidTypeError = ActionBot.findElement(driver, IPageCreatePEform.INVALID_FILETYPE_ERROR).getText();

			EPROC_21330_errorFlag = invalidTypeError.contains(IConstantsData.INVALID_FILE_TYPE_ERROR);

			mappedTestCases.get(0).setTestResult(EPROC_21330_errorFlag);
			Assert.assertTrue("Verification not present for selected file", EPROC_21330_errorFlag);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify that while creating category eform via file upload, the selected file must be
	 * none other then in " .zip" or ".pform" format</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21389(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = null;
		boolean EPROC_21389_errorFlag = false;
		User user = null;
		String invalidTypeError = null;
		try
		{
			mappedTestCases = new ArrayList<MappedTestCase>();
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_21390"));
			}
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get CEform object
			CEform cEform = new CEform();
			cEform.setFileUpload(true);
			cEform.setChangeOU(true);
			cEform.setOU(CommonServices.getTestData(IConstantsData.BU_NAME_FOR_CEFORM));
			cEform.setNextAction(IConstantsData.IMPORT_PEFORM);

			MainPageHeaderLevelTab.clickOnCategoryEformTab(driver, testCaseName);
			ActionBot.defaultLowSleep();
			PageCEformListing.clickOnFileUpload(driver, testCaseName);

			WebElement element = driver.findElement(By.xpath(IPageCEformListing.FILE_UPLOAD_ATTACHMENT));

			//TC:EPROC_21390-Verify when uploading unsupported file in eform via file upload and validation should be provided.

			//upload_invalid_eform_file:validation.jpg file which is unsupported
			element.sendKeys(ConfigProperty.getConfig("attachmentFilePath") + ConfigProperty.getConfig("upload_invalid_eform_file"));

			logger.info("Selected file::" + ConfigProperty.getConfig("attachmentFilePath") + ConfigProperty.getConfig("upload_invalid_eform_file"));
			ScreenShot.screenshot(driver, testCaseName, "After filling path");

			ActionBot.waitForPageLoad(driver);

			//Check for error
			invalidTypeError = ActionBot.findElement(driver, IPageCreatePEform.INVALID_FILETYPE_ERROR).getText();

			EPROC_21389_errorFlag = invalidTypeError.contains(IConstantsData.INVALID_FILE_TYPE_ERROR);

			mappedTestCases.get(0).setTestResult(EPROC_21389_errorFlag);
			Assert.assertTrue("Verification not present for selected file", EPROC_21389_errorFlag);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify User should be able to create process eform for type "header level" for "PO" successfully</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21347(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flagCreate = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get PEForm object
			PEform pEform = ObjectCreation.getDefaultPEformObject();
			pEform.setProcessName("PO Forms");

			//Create PEForm (PO)
			pEform = FlowPEform.createPEForm(driver, testCaseName, pEform);

			//Check for created eForm
			flagCreate = FlowPEform.searchePEForm(driver, testCaseName, pEform.getPeformName());
			Assert.assertTrue("User not able to create process eForm for PO successfully", flagCreate);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify User should be able to create process eform for type "header level" for "BPO" successfully</b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21350(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flagCreate = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get PEForm object
			PEform pEform = ObjectCreation.getDefaultPEformObject();
			pEform.setProcessName("BPO Forms");

			//Create PEForm (BPO)
			pEform = FlowPEform.createPEForm(driver, testCaseName, pEform);

			//Check for created eForm
			flagCreate = FlowPEform.searchePEForm(driver, testCaseName, pEform.getPeformName());
			Assert.assertTrue("User not able to create process eForm for BPO successfully", flagCreate);

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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify User should be able to export a process eform </b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21337(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flagCreate = false;
		boolean deactivateFlag = false;
		boolean deleteFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get PEForm object
			PEform pEform = ObjectCreation.getDefaultPEformObject();

			//Create PEForm
			pEform = FlowPEform.createPEForm(driver, testCaseName, pEform);

			//Search created form
			flagCreate = FlowPEform.searchePEForm(driver, testCaseName, pEform.getPeformName());
			Assert.assertTrue("User not able to create PEForm", flagCreate);

			//Export created form
			FlowPEform.exportPEform(driver, testCaseName, pEform.getPeformName());

			//Deactivate created form
			deactivateFlag = FlowPEform.deactivatePEform(driver, testCaseName, pEform.getPeformName());
			Assert.assertTrue("User not able to deactivate process eForm successfully", deactivateFlag);

			//Delete created form
			deleteFlag = FlowPEform.deletePEform(driver, testCaseName, pEform.getPeformName());
			Assert.assertTrue("User not able to delete process eForm successfully", deleteFlag);
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
	 * <b>Author: Rohini Shinge </b>
	 * <b>Description: Verify User should be able to export a category eform </b>
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_21395(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean flagCreate = false;
		boolean deactivateFlag = false;
		boolean deleteFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Get CEForm object
			CEform cEform = ObjectCreation.getDefaultCEformObject();

			//Create CEForm
			cEform = FlowCEform.createCEform(driver, testCaseName, cEform);

			//Search created form
			flagCreate = FlowCEform.searchCEform(driver, testCaseName, cEform.getCeformName());
			Assert.assertTrue("User not able to create CEForm", flagCreate);

			//Export created eForm
			FlowCEform.exportCEform(driver, testCaseName, cEform.getCeformName());

			//Deactivate created form
			deactivateFlag = FlowCEform.deactivateCEform(driver, testCaseName, cEform.getCeformName());
			Assert.assertTrue("User not able to deactivate category eForm successfully", deactivateFlag);

			//Delete created form
			deleteFlag = FlowCEform.deleteCEform(driver, testCaseName, cEform.getCeformName());
			Assert.assertTrue("User not able to delete category eForm successfully", deleteFlag);
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
