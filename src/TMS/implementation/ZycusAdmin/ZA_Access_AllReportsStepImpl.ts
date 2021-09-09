
const { I } = inject();
import { Common } from "../../Common/Common";
//const ZA_AccessTabsImpl = require("./ZA_AccessTabsImpl");
import { ZA_Access_AllReportsObj } from "../../POM/ZycusAdmin/ZA_Access_AllReportsObj";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";


When("I select-List of Custom Roles per product across all companies in TMS Report option", async function () {
	// I.click(ZA_Access_AllReportsObj.CustomRolesPerProducts_AllCompanies);
	await z.click(await TMSLmt.getElement(ZA_Access_AllReportsObj.CustomRolesPerProducts_AllCompanies));
});

Then("I should see List of Custom Roles per product across all companies in TMS report", async function ()  {
	await z.see("List of Custom Roles per product across all companies in TMS");
});

When("I select-List of users per product across all companies in TMS Report option", async function ()  {
	// I.click(ZA_Access_AllReportsObj.UsersRolesPerProducts_AllCompanies);
	await z.click(await TMSLmt.getElement(ZA_Access_AllReportsObj.UsersRolesPerProducts_AllCompanies));
});

Then("I should see List of users per product across all companies in TMS report", async function ()  {
	await z.see ("List of users per product across all companies in TMS");
});

When("I select-List of users with role information for all companies in TMS Report option", async function ()  {
	await z.click(await TMSLmt.getElement(ZA_Access_AllReportsObj.UsersListWithRoles));
});

Then("I should see List of users with role information for all companies in TMS TMS report", async function () {
    await z.see("List of users with role information for all companies in TMS");
});

When("I select-No. of Tenants Assigned to a Product Report option", async function()  {
	// I.click(ZA_Access_AllReportsObj.NoOfTenantsToProduct);
	await z.click(await TMSLmt.getElement(ZA_Access_AllReportsObj.NoOfTenantsToProduct));
});

Then("I should see No. of Tenants Assigned to a Product report",async function ()  {
    await z.see("No. of Tenants Assigned to a Product");
});

When("I select-Product Assigned Per Tenant Report option", async function()  {
	// I.click(ZA_Access_AllReportsObj.ProdPerTenant);
	await z.click(await TMSLmt.getElement(ZA_Access_AllReportsObj.ProdPerTenant));
});

Then("I should see Product Assigned Per Tenant report", async function () {
    await z.see("Product Assigned Per Tenant");
});
