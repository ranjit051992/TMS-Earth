package com.zycus.automation.jiraIntegration;

import org.openqa.selenium.By;

import com.zycus.framework.framework_version_2_4.framework.Helper;

/**
 * @author kunal.ashar
 *
 */
public interface JiraPageObjects
{

	// login page objects
	By				Text_Username				= By.xpath(".//*[@id='username']");
	By				Text_Password				= By.xpath(".//*[@id='password']");
	By				Button_Login				= By.xpath(".//*[@id='login-submit']");

	// logout page objects
	By				Link_Header_Menu			= By.xpath(".//*[@id='user-options']");
	By				Link_Logout					= By.xpath(".//*[@id='log_out']");

	// Project Selection
	By				Header_project				= By.xpath(".//*[@id='browse_link']");
	By				Link_viewAllProject			= By.xpath(".//*[@id='project_view_all_link_lnk']");
	By				Text_searchProject			= By.xpath(".//*[@id='project-filter-text']");
	By				Link_projectName			= By.xpath("(.//*[@class='projects-list']//a)[2]");

	// Plan Test Cycle
	By				Header_tests				= By.xpath(".//*[@class='aui-header-primary']//*[text()='Tests']");
	By				Link_searchTestExecution	= By.xpath(".//*[@title='Search Test Executions']");
	By				Link_advance				= By.xpath(".//*[@id='search-mode-advanced']");
	By				Text_zqlQueryToSearch		= By.xpath(".//*[@id='zqltext']");

	// jira data from config file
	public String	JIRA_URL					= Helper.returnKeyValuePair("jiraUrl");
	public String	JIRA_USERNAME				= Helper.returnKeyValuePair("jiraUsername");
	public String	JIRA_PASSWORD				= Helper.returnKeyValuePair("jiraPassword");
	public String	JIRA_PROJECT				= Helper.returnKeyValuePair("jiraProjectName");
	public String	JIRA_RELEASEVERSION			= Helper.returnKeyValuePair("jiraReleaseVersion");
	public String	JIRA_RELEASETYPE			= Helper.returnKeyValuePair("jiraReleaseType");
}
