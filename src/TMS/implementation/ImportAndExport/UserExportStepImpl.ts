const { I } = inject();
import { Common } from "../../Common/Common";
import { UserExportObj } from "../../POM/ImportAndExport/UserExportObj";
import { UserExportImpl } from "../../POM/ImportAndExport/UserExportImpl";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";

Given("I am on User listing Page", async function () {
});

When("I click on Export User data", async function () {
    await UserExportImpl.ExportUserData();
});

When("I click on User Email Edit Export User data", async function () {
    await UserExportImpl.UserEmailExportUserData();
});

When("I click on Bell icon", async function(){
    await UserExportImpl.BellIconClick();
});

When("I click on Audit Bell icon", async function(){
    await UserExportImpl.BellIconAuditClick();
});


Then("I should see the export user data under bell icon", async function() {
    var statusofexport = await z.grabTextFrom("//*[@id='ExportfileNameList']/li[1]/span/div/p/span");
    if (statusofexport == "Successfully")
    {
    await z.see(await TMSLmt.getData("Status_Success"));
    }
    else
    {
    await z.see(await TMSLmt.getData("Status_Pending"));
    }

});

When("I click on Bulk edit of BulkEditOfUsers", async function() {
    await z.click(await TMSLmt.getElement(UserExportObj.BulkEditUserlink));
});

When("I select all data option",async function () {
    await z.click(await TMSLmt.getElement(UserExportObj.AllDataRadioBtn));
});

When("I click on download excel file for BulkEditOfUsers", async function () {
    await UserExportImpl.ExcelDwnloadBulkEditUsers();
});

When("I select Filtered list option", async function () {
    await z.click(await TMSLmt.getElement(UserExportObj.FilteredDataRadioBtn));
});

When("I select status", async function () {
    await UserExportImpl.SelectStatus();
});

When("I enter Reporting manager", async function () {
    await UserExportImpl.FillReportingMgr();
});

When("I select Assigned products", async function () {
    await UserExportImpl.assignProduct();
});

When("I click on download excel file for Filtered list", async function () {
    await UserExportImpl.DwnloadFilteredList();
});

When("I click on Upload Users link", async function () {
    await z.click(await TMSLmt.getElement(UserExportObj.UploadUsersLink));
});

When("I click on Download Excel Template link for UploadUsers", async function() {
    await z.click(await TMSLmt.getElement(UserExportObj.DownloadExcelForUploadUsers));
    await z.click(await TMSLmt.getElement(UserExportObj.UserExpPopUpOK));
});

//Role Export
When("I click on Assign roles in bulk option link", async function() {
    await z.click(await TMSLmt.getElement(UserExportObj.AssignRolesInBulkLink));
});

When("I click on Download Dynamic Excel Template", async function(){
    await z.click(await TMSLmt.getElement(UserExportObj.DownloadDynamicExcelLink));
});

When("I click on Download Assignment & Edit Role Sheet", async function(){
    await z.click(await TMSLmt.getElement(UserExportObj.DownloadAssignmentRoleSheetLink));
});

When("I select the file to be uploaded", async function() {
    await UserExportImpl.attachFile();
});

When("I click on upload button", async function() {
    await UserExportImpl.uploadFile();
});