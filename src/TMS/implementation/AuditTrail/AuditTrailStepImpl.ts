const { I } = inject();
import { Common } from "../../Common/Common";
import { AuditTrailObj } from "../../POM/AuditTrail/AuditTrailObj";
import { AuditTrailImpl } from "../../POM/AuditTrail/AuditTrailImpl";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { CompanyImpl } from "../../POM/Company/CompanyImpl";
import { ProductImpl } from "../../POM/Product/ProductImpl";
import { CreateRoleImpl } from "../../POM/Role/CreateRoleImpl";
import { ProductObj } from "../../POM/Product/ProductObj";
import {prop} from "../../../Framework/FrameworkUtilities/config";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";

Given("Navigate to Audit Trail Page", async function () {
	await z.click(await TMSLmt.getElement(AuditTrailObj.AuditTrailTab));
});

Given("Navigate to ZA Audit Trail Page", async function () {
	await z.click(await TMSLmt.getElement(AuditTrailObj.AuditTrailTabZA));
});

Given("Company AuditTrail page should be accessible", async function () {
	await z.click(await TMSLmt.getElement(AuditTrailObj.CompanyAuditTrailZAPage));
});

When("I click on Users", async function () {
	await z.click(await TMSLmt.getElement(AuditTrailObj.AuditTrail_UsersOption));
});

When("Check Access of Audit Management Activity", async function () {
	await z.dontSee(await TMSLmt.getData("Preference"));
    await z.dontSee(await TMSLmt.getData("Reports"));
    await z.see(await TMSLmt.getData("AuditTrail"));
    await z.dontSee(await TMSLmt.getData("MasterData"));
    await z.dontSee(await TMSLmt.getData("Workflow"));
    await z.dontSee(await TMSLmt.getData("UserManagement"));
	await z.dontSee(await TMSLmt.getData("ImpersonateUserRequests"));
});

Given("Check Audit of Company created by ZA", async function () {
	await z.see(await TMSLmt.getData("Audit_Company_Create"));
    await CompanyImpl.Companycreatedname();
});

Given("Create Product should get Audited by ZA", async function () {
	//await z.see("Product Created");
	await z.see(await TMSLmt.getData("Audit_Product_Create"));
    await ProductImpl.Productcreatedname();
});

Then("Check Audit of Upadte Company by ZA", async function () {
	//await z.see("Company Updated");
	await z.see(await TMSLmt.getData("Audit_Company_Updated"));
	await z.see(await TMSLmt.getData("COMPANY_EDIT_NAME"));
});

Given("Check Audit of Activate Company by ZA", async function () {
	//await z.see("Company Activated");
	await z.see(await TMSLmt.getData("Audit_Company_Activated"));
	await z.see(await TMSLmt.getData("COMPANY_ACTIVE_DEACTIVE_DATA"));
});

Given("Check Audit of DeActivate Company by ZA", async function () {
	//await z.see("Company Deactivated");
	await z.see(await TMSLmt.getData("Audit_Company_Deactivated"));
	await z.see(await TMSLmt.getData("COMPANY_ACTIVE_DEACTIVE_DATA"));
});

Given("UpdateProduct should get Audited", async function () {
	//await z.see("Product Updated");
	await z.see(await TMSLmt.getData("Audit_Product_Updated"));
	await ProductImpl.UpdateProductcreatedname();
});

Given("Check audit of ActivityGroup Created", async function () {
	await z.see(await TMSLmt.getData("Audit_Group_Created"));
	//await z.see("Activity Group Created");
	await ProductImpl.ActivityGroupcreatedname();
});

Given("Check audit of ActivityGroup Updated", async function () {
	await z.see(await TMSLmt.getData("Audit_Group_Updated"));
	//await z.see("Activity Group Updated");
	await ProductImpl.ActivityGroupupdatename();
});

Then("Users AuditTrail page should be accessible", async function (){
	await z.click("//select[@id='action']");
	//await z.click(await TMSLmt.getElement(AuditTrailObj.AuditTrail_Page));
	await z.pressKey("ArrowDown");
	//await z.click("//select[@id='action']/option[text()='User Activated']");
	//await z.click(await TMSLmt.getElement(AuditTrailObj.ActionsUserActivatedOption));
});


When("I click on UserGroup", async function () {
	await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
	await z.click(await TMSLmt.getElement(AuditTrailObj.AuditTrail_UserGroupOption));
});

Then("UserGroup AuditTrail page should be accessible",async function (){
	// await z.click(await TMSLmt.getElement(AuditTrailObj.AuditTrail_ActionsUGCreated));
	await z.click("//select[@id='action']");
	await z.pressKey("ArrowDown");
});

Then("UpdateActivity Group Name",async function (){
	//await z.selectOption(AuditTrailObj.ActGroup_Name_Locator,AuditTrailObj.ActGroup_Name_Value);
	//await z.click(await TMSLmt.getElement(AuditTrailObj.ActGroup_Name_Locator));
	//await z.selectOption(CreateUserObj.Salutation_Locator,CreateUserObj.Salutation_Value);
	await z.click(".//button[@title='Show All Items']");
	//await z.click(".//*[@title='9dec2020']");
	await z.click("/html/body/ul/li[3]/a");
	//await z.click(await TMSLmt.getElement(AuditTrailObj.ActGroup_Name_Value));
	//await z.fillField(AuditTrailObj.ActGroup_Name_Locator, await TMSLmt.getData("ActivityGroup Name"));
	//await z.click(".//button[@title='Edit Activity Group']");
	await z.click("a.icon");
	await ProductImpl.ActivityGroupupdatenameenter();
	//await z.fillField(AuditTrailObj.AuditTrail_ActGrpnameeditlocator,ActGroup1);
	//await z.click("//input[@title='Save']");
	await z.click("//span[@id='changePassword']/input[@onclick='saveEditedActivityGroup();']");
	await z.click(await TMSLmt.getElement(ProductObj.DoneBtn));
    await z.click(await TMSLmt.getElement(ProductObj.DoneBtn));
	//await z.click(".//*[@title='13may2020g1']");
});

When("I click on Role Management", async function() {
	await z.click(await TMSLmt.getElement(AuditTrailObj.AuditTrail_RolePage));
});

Then("Role AuditTrail page should be accessible", async function (){
	await z.click("//select[@id='action']");
	await z.pressKey("ArrowDown");
	// await z.click(await TMSLmt.getElement(AuditTrailObj.AuditTrail_ActionsRoleCreated));
});

When("I click on Settings",async function () {
	await z.click(await TMSLmt.getElement(AuditTrailObj.AuditTrail_SettingPageOption));
});

When("Verify Audit of OTP flag change",async function () {
	await z.see(await TMSLmt.getData("SettingUpdated"));
	await z.click("//tr[1]/td[6]");
	await z.see(await TMSLmt.getData("EnableOtpLogin"));
	await z.click("//button[@title='Close']");
});


Then("Settings AuditTrail page should be accessible", async function() {
	await z.click("//select[@id='action']");
	await z.pressKey("ArrowDown");
	// await z.click(await TMSLmt.getElement(AuditTrailObj.AuditTrail_ActionsUserCreated));
});

Then("Activity AuditTrail page should be accessible", async function() {
	await z.click(await TMSLmt.getElement(AuditTrailObj.AuditTrail_ActivityPage));
});

Then("Activity Group Audit trail page should be accessible", async function() {
	await z.click(await TMSLmt.getElement(AuditTrailObj.AuditTrail_ActivityGroupPage));
});

Then("ZA roleaudit page is accessible", async function() {
	await z.click(await TMSLmt.getElement(AuditTrailObj.AuditTrail_ZARoleAuditPage));
});

Then("Product audit page is accessible", async function() {
	await z.click(await TMSLmt.getElement(AuditTrailObj.AuditTrail_ProductPage));
});

When("I search for Admin activity-Users", async function() {
	await z.fillField(await TMSLmt.getElement(AuditTrailObj.AuditTrail_UserPerformedBy),await TMSLmt.getData("SearchforAdminAct"));
	await z.pressKey('Enter');
});

Then("I should see records performed by Zycusadmin for Role", async function () {
	await z.see(await TMSLmt.getData("ZA_Role_Create"));
	//await z.see("Role Created");
	await CreateRoleImpl.Rolecreatedname();

});

Then("I should see records performed by Zycusadmin for Deactivate Role", async function () {
	await z.see(await TMSLmt.getData("ZA_StaticRole"));
	await z.see(await TMSLmt.getData("ZA_Role_Deactive"));
	//await z.see("Role Deactivated");

});

Then("I should see records performed by Zycusadmin for Activate Role", async function () {
	await z.see(await TMSLmt.getData("ZA_StaticRole"));
	await z.see(await TMSLmt.getData("ZA_Role_Deactive"));
	//await z.see("Role Deactivated");

});

When("I search for Admin activity-UserGroup", async function () {
	await z.fillField(await TMSLmt.getElement(AuditTrailObj.AuditTrail_UserPerformedBy),await TMSLmt.getData("SearchforAdminAct"));
	await z.pressKey('Enter');
});

Then("I should see records performed for UG by Zycus admin", async function (){
	//await z.see("Zycus Admin");
	await z.see(await TMSLmt.getData("ZA_Visibale"));
});

When("I search for Admin activity-Role", async function () {
	await z.fillField(await TMSLmt.getElement(AuditTrailObj.AuditTrail_UserPerformedBy),await TMSLmt.getData("SearchforAdminAct"));
	await z.pressKey('Enter');
});

Then("I should see records performed by Zycus admin for Role", async function () {
	await z.see(await TMSLmt.getData("ZA_Visibale"));
});

When("I search for Admin activity-Settings", async function () {
	await z.fillField(await TMSLmt.getElement(AuditTrailObj.AuditTrail_UserPerformedBy),await TMSLmt.getData("SearchforAdminAct"));
	await z.pressKey('Enter');
});

Then("I should see records performed by Zycus admin for Settings", async function () {
	await z.see(await TMSLmt.getData("ZA_Visibale"));
});

When("I select Role updated option", async function () {
	await z.click(await TMSLmt.getElement(AuditTrailObj.ActionsRoleUpdated));
});

When("I select Role Activated option in audit trail", async function () {
	await z.click(await TMSLmt.getElement(AuditTrailObj.ActionsRoleActivated));
});

When("I select Role Deactivated option in audit trail", async function () {
	await z.click(await TMSLmt.getElement(AuditTrailObj.ActionsRoleDeactivated));
});

When("I select Logo updated option in audit trail", async function () {
	await z.click(await TMSLmt.getElement(AuditTrailObj.ActionLogoUpdated));
});

When("I select DeactivateUser option in audit page",async function () {
	await z.click(await TMSLmt.getElement(AuditTrailObj.ActionsUserDeactivatedOption));
});

When("I select ActivateUser option in audit page", async function () {
	await z.click(await TMSLmt.getElement(AuditTrailObj.ActionsUserActivatedOption));
});

When("I select user updated option for audit", async function () {
	await z.click(await TMSLmt.getElement(AuditTrailObj.ActionsUserUpdated));
	await z.click(await TMSLmt.getElement(AuditTrailObj.UserUpdateLink));
});

When("I select logo reset option of audit", async function ()  {
	await z.click(await TMSLmt.getElement(AuditTrailObj.ActionLogoReset));
});

Then("logo reset record should be there in audit", async function ()  {
	await z.see(await TMSLmt.getData("Company_Reset"));
	//await z.see("Company Logo Reset");
});

When("I select ResetUserPassword option in audit page", async function ()  {
	await z.click(await TMSLmt.getElement(AuditTrailObj.ActionsUserPasswordReset));
});

Given("I click on AuditExport", async function () {
    await AuditTrailImpl.ExportAuditData();
});

Given("I click on Audit Export of UserGroup", async function () {
	await AuditTrailImpl.ExportAuditData();
});

Given("I click on Audit Export of Role Management", async function () {
    await AuditTrailImpl.ExportAuditData();
});

Given("I click on Audit Export of Settings", async function () {
    await AuditTrailImpl.ExportAuditData();
});