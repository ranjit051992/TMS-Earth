package com.zycus.automation.constants;

import java.io.File;

import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public interface IConstants
{
	// CONFIGURATION
	final static String		dist							= "dist";
	final static String		OUTPUT_FILE_PATH				= "output";
	final static String		INPUT_FILE_PATH					= "input";
	final static String		CONFIG_FILE_NAME				= "input/config.properties";
	final static String		REPORTS_PATH					= "output/reports";
	final static String		RESOURCES						= "resources";
	final static String		ATTACHMENT_FILE					= "attachmentFiles";
	final static String		TESTCASE_FILE					= INPUT_FILE_PATH + File.separator + ConfigProperty.getConfig("Test_Case_File");

	final static String		UI_eProc						= RESOURCES + File.separator + "ui" + File.separator + "eproc";
	final static String		UI_eInvoice						= RESOURCES + File.separator + "ui" + File.separator + "einvoice";
	final static String		UI_ZSN							= RESOURCES + File.separator + "ui" + File.separator + "zsn";
	final static String		UI_iConsole						= RESOURCES + File.separator + "ui" + File.separator + "iConsole";
	final static String		UI								= RESOURCES + File.separator + "ui" + File.separator;
	final static String		TEST_DATA						= RESOURCES + File.separator + "testData" + File.separator;
	final static String		PROPERTIES						= RESOURCES + File.separator + "properties" + File.separator;
	final static String		DEFAULT_TEST_DATA				= TEST_DATA + File.separator + "defaultTestData" + File.separator;
	final static String		ATTACHMENT_FILES_PATH			= ConfigProperty.getConfig("attachmentFilePath");
	String					buildHealthStatusReportFilePath	= "reporting" + File.separator + "Automation_Build_Health_Status.xlsx";
	String					productURL						= ConfigProperty.getConfig("Product_URL").trim();
	String					URL								= ConfigProperty.getConfig("URL").trim();
	String					product_name					= ConfigProperty.getConfig("Product_Name").trim();
	String					SUITE_TYPE						= ConfigProperty.getConfig("SUITE_TYPE").trim();

	// REQUISITION STATUS
	final static String		STATUS_RUNNING					= "RUNNING";
	final static String		STATUS_END						= "END";

	//TESTCASE TYPE
	final static String		SANITY							= "Sanity";
	final static String		REGRESSION						= "Regression";
	final static String		MAPPED							= "Mapped";

	// LOG 4j
	final static String		LOG_4J_APPENDDER				= "log4j.properties";

	// RESULTS
	final static String		PASS							= "PASS";
	final static String		FAIL							= "FAIL";
	final static String		SKIPPED							= "SKIPPED";

	final static String		YES								= "Yes";
	final static String		NO								= "No";

	final static boolean	ACTIVE							= true;
	final static boolean	INACTIVE						= false;

	final static String		PRODUCT							= "Product";
	final static String		SSO								= "sso";
	final static String		PRODUCT_URL						= "Product_URL";
	final static String		ZSP_Supplier					= "ZSP_Supplier";
	final static String		ZSN_URL							= "ZSN_URL";

	final static String		reqAttachment					= "reqAttachment";

	final static String		eInvoice						= "eInvoice";
	final static String		eProc							= "eProc";
	final static String		TMS								= "TMS";
	final static String		ZSN								= "ZSN";
	final static String		SIM								= "iSupplier";

	// role of users
	final static String		Global_Role						= "Global_Role";
	final static String		Admin_Role						= "Admin_Role";
	final static String		Requesting_Role					= "Requesting_Role";

	// product name
	String					product_name_iSource			= "iSource";
	String					product_name_iContract			= "iContract";
	String					product_name_eProc				= "eProc";

	// Generic Actions
	String					Action_Edit						= "Edit";
	String					Action_Delete					= "Delete";
	String					Action_Save						= "Save";
	String					Action_Cancel					= "Cancel";
	String					Action_None						= "None";
}
