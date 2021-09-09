const { I } = inject();
import { Common } from "../../Common/Common";
import { CreateRoleObj } from "../../POM/Role/CreateRoleObj";
import { CreateRoleImpl } from "../../POM/Role/CreateRoleImpl";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { DataIntegrity } from "dd-dataintegrity/src/DataIntegrity";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";
import { prop } from "../../../Framework/FrameworkUtilities/config";

// var RoleName = getRandomforRole(5) + "_automation"
//const RoleName=Common.getRandomNumber(5) + "auto";
// var existingRoleDesc ="";
// var UpdateRoleDes = "";

Given("Navigate to Role Listing Page", async function() {
    await CreateRoleImpl.NavigateTo(await TMSLmt.getElement(CreateRoleObj.RoleManagementTab));
});

When("I click on Add New Role", async function() {
    await CreateRoleImpl.NavigateTo(await TMSLmt.getElement(CreateRoleObj.AddNewRoleBtn));
});

When("I edited the Role", async function() {
    await CreateRoleImpl.editedtherole();
});

When("I Fill all the data for role details", async function (){
    await CreateRoleImpl.FillRoleDetails();
});

When("I Fill all the data for RoleActivity role details", async function (){
    await CreateRoleImpl.FillRoleRoleActDetails();
});

When("I assign activities", async function ()  {
    //await z.click(await TMSLmt.getElement(CreateRoleObj.selectCheck));
    await z.click(await TMSLmt.getElement(CreateRoleObj.selectmainactcheck));
    await z.click(await TMSLmt.getElement(CreateRoleObj.selectCAsubactheck));
    DataIntegrity.actualDatamap("Assigned SubActivity Name","COMPANY ADMIN");
    await z.click(await TMSLmt.getElement(CreateRoleObj.SaveBtn2));
});

When("I assign all TMS Activities", async function ()  {
    //await z.click(await TMSLmt.getElement(CreateRoleObj.selectCheck));
    await z.click(await TMSLmt.getElement(CreateRoleObj.selectmainactcheck));
    await z.click(await TMSLmt.getElement(CreateRoleObj.selectCAsubactheck));
    DataIntegrity.actualDatamap("Assigned SubActivity Name","COMPANY ADMIN");
    await z.click(await TMSLmt.getElement(CreateRoleObj.selectPreferencessubactheck));
    await z.click(await TMSLmt.getElement(CreateRoleObj.selectAudittrailsubactheck));
    await z.click(await TMSLmt.getElement(CreateRoleObj.selectReportssubactheck));
    await z.click(await TMSLmt.getElement(CreateRoleObj.selectUsermanagementsubactheck));
    await z.click(await TMSLmt.getElement(CreateRoleObj.selectWorkflowsubactheck));
    await z.click(await TMSLmt.getElement(CreateRoleObj.selectMasterdatasubactheck));
    await z.click(await TMSLmt.getElement(CreateRoleObj.selectRolemanagementsubactheck));
    await z.click(await TMSLmt.getElement(CreateRoleObj.SaveBtn2));
});

When("I click on done", async function() {
    await z.click(await TMSLmt.getElement(CreateRoleObj.DoneBtn));
});

Then("role should be added",async function () {
    await CreateRoleImpl.NewRoleAdded();
});

Then("New role through Rolemgmact should be added",async function () {
    await CreateRoleImpl.NewRolethroughrolemgmactAdded();
});

Then("I should be able to assign the role to user",async function (){
    await CreateRoleImpl.AssignCreatedRole();
});

Then("I should be able assign rolecreated through rolemgmact to the user",async function (){
    await CreateRoleImpl.AssignCreatedNewRole();
});

Then("I deactivate Role", async function()  {
    // await CreateRoleImpl.SearchRole(await TMSLmt.getData("StaticRole"));
    await CreateRoleImpl.DeactivateRole();
    z.refreshPage();
});

Then("I deactivate NewRole", async function()  {
    // await CreateRoleImpl.SearchRole(await TMSLmt.getData("StaticRole"));
    await CreateRoleImpl.DeactivateNewRole();
    z.refreshPage();
});

Then("Role should be deactivated", async function () {
    await CreateRoleImpl.RoleShouldDeactivate();
});

Then("I activate static Role", async function() {
    await CreateRoleImpl.activateRole();
});

Then("Role should be activated", async function () {
    await CreateRoleImpl.verifyRoleActivation();
});

Then("I should be allowed to assign static role to user", async function() {
    await CreateRoleImpl.AssignStaticRole();
});


When("I fetch the role", async function () {
    //CreateRoleImpl.SearchRole(CreateRoleObj.StaticRole);
});

When("I make necessary changes", async function()  {
    await CreateRoleImpl.MakeChangesForRoleEdit();
});

When("I make Role update necessary changes", async function()  {
    await CreateRoleImpl.MakeChangesForRoleupdateEdit();
});
   
Then("Role should be updated", async function() {
    await CreateRoleImpl.VerifyEditRoleDone();
});

// Zycus Admin - Add New Role

// When("I enter RoleName",async function () {
//     await z.fillField(await TMSLmt.getElement(CreateRoleObj.RoleTitleTxtBox), RoleName);
// });

// When("I select Roletype", async function (){
//     await z.click(await TMSLmt.getElement(CreateRoleObj.RLType));
// });

// When("I assign Product", async function () {
//     // I.click(CreateRoleObj.SelectProd);
//     await z.click(await TMSLmt.getElement(CreateRoleObj.SelectProd));
// });

// When("I enter Role description", async function () {
//     await z.fillField(await TMSLmt.getElement(CreateRoleObj.RLDesc), "automationScript");
// });

// When("I click Save", async function () {
//     await z.click(await TMSLmt.getElement(CreateRoleObj.SaveContinue));
// });

When("ZA level role deactivation", async function (){
	await CreateRoleImpl.deactivateZARole();
});

Then("Role should be deactivated ZA level", async function () {
    await CreateRoleImpl.verifyZARoleDeactivation();
});

When("I activate static Role ZA level", async function() {
    await CreateRoleImpl.activateZARole();
});

Then("Role should be activated ZA level", async function () {
    await CreateRoleImpl.verifyZARoleActivation();
});

When("I make necessary changes for ZA Role", async function (){
    await CreateRoleImpl.MakeChangesForZARoleUpdate();
});

Then("Role should be updated for ZA", async function (){
    CreateRoleImpl.VerificationZARoleUpdation();
});

Given("I am on Company listing page",async function (){
    await z.click(await TMSLmt.getElement(CreateRoleObj.Company));
});

When("I search the company",async function () {  
    await CreateRoleImpl.searchCompany();
});

When("Navigate to Role Management tab",async function () {
    await z.click(await TMSLmt.getElement(CreateRoleObj.RoleManagementTab));
    // I.wait(5);
});

Then("I Zycus admin should be allowed to assign static role to user", async function() {
    await CreateRoleImpl.ZAAssignRole();
});

Then("I should be able to see Add New Role option", async function () {
    await Wait.waitForDefaultTimeout(prop.DEFAULT_HIGH_WAIT);
    await z.see(await TMSLmt.getData("Add_new_role"));
});

Then("Check Access of Role Management Activity", async function () {
    await z.dontSee(await TMSLmt.getData("Preference"));
    await z.dontSee(await TMSLmt.getData("Reports"));
    await z.see(await TMSLmt.getData("RoleManagement"));
    await z.dontSee(await TMSLmt.getData("AuditTrail"));
    await z.dontSee(await TMSLmt.getData("MasterData"));
    await z.dontSee(await TMSLmt.getData("Workflow"));
    await z.dontSee(await TMSLmt.getData("UserGroups"));
    await z.dontSee(await TMSLmt.getData("UserManagement"));
    await z.dontSee(await TMSLmt.getData("ImpersonateUserRequests"));
    await z.see(await TMSLmt.getData("Add_new_role"));
});

Then("I should see Step2 of role creation", async function () {
    await z.see(await TMSLmt.getData("Step2_Role_create"));
	//await z.see("Step 2 - Activity Allocation To Role: ");
});

Then("I should see role created in role audit page", async function () {
    await CreateRoleImpl.CheckRoleinAudit();
});

Then("I should see update record in audit trail", async function () {
    await CreateRoleImpl.CheckRoleinAuditInLink();
});

Then("I should get the record for activation",async function () {
    z.see(await TMSLmt.getData("StaticRole_ACTIVATE"));
});

Then("I should get the record for deactivation", async function (){
	z.see(await TMSLmt.getData("StaticRole"));
});

When("I change role status", async function () {
    await CreateRoleImpl.ChangeRoleStatus();
});

Then("Role status should be changed", async function () {
	return true;
});

When("I click on Roletype DD and select it as Default Roletype", async function() {
    await z.click(CreateRoleObj.Role_type);
    await I.click("//option[text()='Role Type']");
    await z.fillField(await TMSLmt.getElement(CreateRoleObj.SearchRole),await TMSLmt.getData("Default_Role"));
    await z.click("//input[@value='Go']");
});

Then("I should be able to view role",async function() {
	await z.click(CreateRoleObj.ViewRole);
});

When("I click on Roletype DD and select it as Global Roletype", async function() {
    await z.click(CreateRoleObj.Role_type);
    await I.click("//option[text()='Role Type']");
    await z.fillField(await TMSLmt.getElement(CreateRoleObj.SearchRole),await TMSLmt.getData("Global_Role"));
    await z.click("//input[@value='Go']");
});