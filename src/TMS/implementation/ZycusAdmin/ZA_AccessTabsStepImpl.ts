
const { I } = inject();
import { Common } from "../../Common/Common";
import { ZA_AccessTabsImpl } from "../../POM/ZycusAdmin/ZA_AccessTabsImpl";
import { ZA_AccessTabsObj } from "../../POM/ZycusAdmin/ZA_AccessTabsObj";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";

Given("I navigate to Company tab",async function () {
	await z.click(await TMSLmt.getElement(ZA_AccessTabsObj.CompTab));
});

When("I search for Company", async function (){
    z.fillField(ZA_AccessTabsObj.CompSearch,"ZCS");
    // I.click(ZA_AccessTabsObj.GoBtn);
	await z.click(await TMSLmt.getElement(ZA_AccessTabsObj.GoBtn));
});

Then("results should be fetched",async function (){
	await z.seeElement(await TMSLmt.getElement(ZA_AccessTabsObj.SearchRes));
});

Then("CompanyListing page should be accessible", async function ()  {
    await z.seeTitleEquals("Company Listings");
});

Given("I navigate to Products tab",async function () {
	// I.click(ZA_AccessTabsObj.ProdTab);
	await z.click(await TMSLmt.getElement(ZA_AccessTabsObj.ProdTab));
});

Then("ProductListing page should be accessible",async function (){
	await z.seeTitleEquals("Product Listings");
});

Given("I navigate to Administrator tab", async function (){
	// I.click(ZA_AccessTabsObj.AdministratorTab);
	await z.click(await TMSLmt.getElement(ZA_AccessTabsObj.AdministratorTab));
});

When("I click on Live session",async function () {
	await z.click(await TMSLmt.getElement(ZA_AccessTabsObj.LiveSession));
});

Then("Live sessions page should be accessible",async function () {
	await z.seeTitleEquals("Live Session");
});

When("I click on Apply Settings", async function() {
	await z.click(await TMSLmt.getElement(ZA_AccessTabsObj.ApplySettings));
	// I.click(ZA_AccessTabsObj.ApplySettings);
});

Then("Apply Settings page should be accessible",async function () {
	await z.seeTitleEquals("Apply Settings");
});

When("I click on Impersonate User requests",async function (){
	// I.click(ZA_AccessTabsObj.ImpersonateUS);
	await z.click(await TMSLmt.getElement(ZA_AccessTabsObj.ImpersonateUS));
});

Then("Impersonate User requests page should be accessible",async function ()  {
	await z.seeTitleEquals("Zycus Tech Support Impersonate User Request Page");
});

Given("I navigate to Role tab",async function () {
	// I.click(ZA_AccessTabsObj.RoleMgmt);
	await z.click(await TMSLmt.getElement(ZA_AccessTabsObj.RoleMgmt));
});

Then("Role Listing page should be accessible", async function () {
	await z.seeInTitle("Role Listings");
});

Given("I navigate to Master Data tab", async function () {
	await z.click(await TMSLmt.getElement(ZA_AccessTabsObj.MastersTab));
});

When("I click on Masters", async function () {
	await z.click(await TMSLmt.getElement(ZA_AccessTabsObj.Masters));
});

Then("Masters page should be accessible", async function () {
	z.seeTitleEquals("Master Data");
});

