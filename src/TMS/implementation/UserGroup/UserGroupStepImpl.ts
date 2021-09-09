const { I } = inject();
import { Common } from "../../Common/Common";
import { UserGroupObj } from "../../POM/UserGroup/UserGroupObj";
import { UserGroupImpl } from "../../POM/UserGroup/UserGroupImpl";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";

// var UGName = getRandomforUG(4) + "_automation"
// let desc = getRandomforUG(3) + "UpdatedDescription";

Given("Navigate to UserGroup Page", async function ()  {
    await z.click(await TMSLmt.getElement(UserGroupObj.UserGroupTab));
});

When("I click on Add New UserGroup", async function()  {
    await z.click(await TMSLmt.getElement(UserGroupObj.AddUG));
});

When("I enter all the required data", async function ()  {
    await UserGroupImpl.EnterReqData();
});

When("I click on CreateNewGroup", async function () {
    await z.click(await TMSLmt.getElement(UserGroupObj.CreateBtn));
});

Then("UserGroup should be created", async function() {
    await UserGroupImpl.UGCreation();
});

Then("I should be able to view create new user group option",async function () {
	await z.seeElement(await TMSLmt.getElement(UserGroupObj.AddUG));
});

Then("Check Access of Create User Group",async function () {
    await z.click(await TMSLmt.getElement(UserGroupObj.UserGroupTab));
	await z.seeElement(await TMSLmt.getElement(UserGroupObj.AddUG));
});

When("I click on Actions", async function () {
    await z.click(await TMSLmt.getElement(UserGroupObj.Actions));
});

When("I click on Modify", async function () {
    await z.click(await TMSLmt.getElement(UserGroupObj.Modify));
});

When("I can click on View Selected link", async function() {
    await z.click(await TMSLmt.getElement(UserGroupObj.ViewSelected));
});

Then("I should be able to see users in the UserGroup", async function() {
    await z.seeElement(await TMSLmt.getElement(UserGroupObj.DeleteiconsViewSel));
});

Then("I should see the Usergroup that was created", async function() {
    await UserGroupImpl.SeeUGCreated();
});

When("I change the usergroup description",async function () {
    await UserGroupImpl.ChangeUGdesc();
});

When("I update the usergroup", async function () {
    await z.click(await TMSLmt.getElement(UserGroupObj.SaveNClose));
});

Then("Usergroup should be updated", async function () {
    UserGroupImpl.UGUpdated();
});

When("I select Usergroup updated filter",async function () {
    await z.click(await TMSLmt.getElement(UserGroupObj.AuditUGUpdateFilter));
});

Then("I should see the Usergroup that was updated",async function () {
    await UserGroupImpl.AuditUGUpdated();
});

When("I click on Deactivate", async function () {
   // UserGroupImpl.deactivateUserGroup();
});

When("I select all users on page", async function ()  {
    await z.click(await TMSLmt.getElement(UserGroupObj.SelectAllUsers));
});

Then("Users in usergroup should be updated", async function ()  {
    //await z.seeTitleEquals("List of UserGroups")
    await z.seeTitleEquals(await TMSLmt.getData("List_of_UserGroups"));
});

