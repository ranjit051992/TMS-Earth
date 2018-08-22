/**
 * 
 */
package com.zycus.automation.integration.testopia;

import org.openqa.selenium.By;

import com.zycus.framework.framework_version_2_4.framework.Helper;

/**
 * @author ankita.sawant
 *
 */
public interface TestopiaIntegrationObjects
{
	By				loginLink					= By.id("login_link_top");
	By				bugzilla_login				= By.id("Bugzilla_login_top");
	By				bugzilla_Password			= By.id("Bugzilla_password_top");
	By				log_In_Button				= By.id("log_in_top");
	By				logoutLink					= By.xpath(".//*[@id='header']/ul[1]/li[9]/a");
	By				runlist						= By.xpath(".//*[@id='bugzilla-body']/b");
	By				case_Summary_Input			= By.name("case_summary");
	By				filterButton				= By.id("ext-gen54");
	By				testCaseStatus				= By.cssSelector(".x-grid3-cell-inner.x-grid3-col-8>img");
	By				loadingPopUp				= By.cssSelector("#ext-gen567>div");
	By				testCaseTable				= By.xpath(".//*[@id='ext-gen68']/div");
	By				markedPass					= By.id("ext-gen84");
	By				markedFailed				= By.id("ext-gen87");
	By				execution_Percentage		= By.id("ext-gen141");
	By				successfulUpdationMessage	= By.xpath(".//*[@id='ext-gen470']/div/div[2]/div/div");

	// Testopia Integration Data

	public String	PASSED						= "PASSED";
	public String	FAILED						= "FAILED";
	public String	IDLE						= "IDLE";
	public String	PAUSED						= "PAUSED";
	public String	RUNNING						= "RUNNING";
	public String	testopiaUrl					= Helper.returnKeyValuePair("testopiaUrl");
	public String	testopiaRunUrl				= Helper.returnKeyValuePair("testopiaUrl_FF_26");
	public String	testopiaLogin				= Helper.returnKeyValuePair("testopiaLogin");
	public String	testopiaPassword			= Helper.returnKeyValuePair("testopiaPassword");

}
