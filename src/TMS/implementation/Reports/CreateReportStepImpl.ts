const { I } = inject();
import { Common } from "../../Common/Common";
import { CreateReportObj } from "../../POM/Reports/CreateReportObj";
import {CreateReportImpl} from "../../POM/Reports/CreateReportImpl"
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";
import {prop} from "../../../Framework/FrameworkUtilities/config";


Given("I navigate to Reports tab",async function ()  {
    await z.click(await TMSLmt.getElement(CreateReportObj.CreateReportTab));
});

Given("Check Access of Reports Activity",async function ()  {
    await z.dontSee(await TMSLmt.getData("Preference"));
    await z.dontSee(await TMSLmt.getData("Security_Policy_page"));
    await z.see(await TMSLmt.getData("Reports"));
    await z.dontSee(await TMSLmt.getData("RoleManagement"));
    await z.dontSee(await TMSLmt.getData("AuditTrail"));
    await z.dontSee(await TMSLmt.getData("MasterData"));
    await z.dontSee(await TMSLmt.getData("Workflow"));
    await z.dontSee(await TMSLmt.getData("UserGroups"));
    await z.dontSee(await TMSLmt.getData("UserManagement"));
    await z.dontSee(await TMSLmt.getData("ImpersonateUserRequests"));
    await z.dontSee(await TMSLmt.getData("Company_Preferences_Display"));
});

When("I select Create New Report option",async function ()  {
    await z.click(await TMSLmt.getElement(CreateReportObj.CreateRepBtn));
});

When("I click on Next button for Step1", async function() {
    await z.click(await TMSLmt.getElement(CreateReportObj.NextBtn));
});

When("I click on Next button for Step2", async function () {
    await z.click(await TMSLmt.getElement(CreateReportObj.NextBtn));
});

When("I fill all the data at Step3", async function() {
    await CreateReportImpl.FillReportDetailsStep3(); 
});

When("I click on Next button for Step3",async function () {
    await z.click(await TMSLmt.getElement(CreateReportObj.NextBtn));
});

When("I click on Next button for Step5", async function() {
    await z.click(await TMSLmt.getElement(CreateReportObj.NextBtn));
});

When("I fill all the data at Step6", async function () {
    await CreateReportImpl.FillReportDetailsStep6();
});

When("I click on Run Report", async function (){
    await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
    await z.click(await TMSLmt.getElement(CreateReportObj.RunReport));
    await Wait.waitForDefaultTimeout(prop.DEFAULT_HIGH_WAIT);
});

Then("I should see the report", async function()  {
    //await z.seeTitleEquals("Reports");
    await z.seeTitleEquals(await TMSLmt.getData("Report_title_tab"));
	//I.seeElement("//title='Reports'");
});

//Access Default Reports
When("I select-List of users per product in TMS Report option", async function () {
    await z.click(await TMSLmt.getElement(CreateReportObj.UsersListperProduct));
});

Then("I should see List of users per product report",async function () {
    //await z.see("List of users per product");
    await z.see(await TMSLmt.getData("List_of_users_per_product"));
});

When("I select-List of users grouped by role name and role type per product",async function () {
    await Wait.waitForDefaultTimeout(prop.DEFAULT_HIGH_WAIT);
    await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
    await z.click(await TMSLmt.getElement(CreateReportObj.UsersByRole));
    await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
});

Then("I should see List of users grouped by role name and role type per product in TMS report",async function () {
    //await z.see("List of users grouped by role name and role type per product");
    await z.see(await TMSLmt.getData("List_of_users_grouped"));
});

When("I select-Matrix report detailing number of users in a role per product in TMS Report option",async function () {
    await z.click(await TMSLmt.getElement(CreateReportObj.MatrixRep));
});

Then("I should see Matrix report detailing number of users in a role per product report",async function (){
    //await z.see("Matrix report detailing number of users in a role per product");
    await z.see(await TMSLmt.getData("List_of_users_matrixreport"));
});

Then("I Able to export Report in Excel",async function (){
    //await z.see("Export");
    await z.see(await TMSLmt.getData("Audit_user_export"));
    await z.click("//a[contains(text(),'Export')]");
    //await z.see("Export as Summary");
    await z.see(await TMSLmt.getData("Audit_user_export_title"));
    await z.click("//a[contains(text(),'In Excel')]");
});

Then("I Able to export Report in PDF",async function (){
	await z.see(await TMSLmt.getData("Audit_user_export"));
    await z.click("//a[contains(text(),'Export')]");
    await z.see(await TMSLmt.getData("Audit_user_export_title"));
    await z.click("//a[contains(text(),'In PDF')]");
});

When("I close report", async function () {;
    await z.click(await TMSLmt.getElement(CreateReportObj.CloseReport));
    //webDriver.switchTo().alert().dismiss()
});

Then("I close popup", async function () {
    //await I.acceptPopup("Report is not saved. Click CANCEL to stay on page for saving the report or OK to close the report without saving.");
    //await I.acceptPopup(await TMSLmt.getData("pop_up_message"));
    await z.acceptPopup();
});