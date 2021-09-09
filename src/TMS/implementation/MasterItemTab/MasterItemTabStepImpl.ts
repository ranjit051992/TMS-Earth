const { I } = inject();
import { Common } from "../../Common/Common";
import {  MasterItemTabObj } from "../../POM/MasterItemTab/MasterItemTabObj";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";
import {prop} from "../../../Framework/FrameworkUtilities/config";

When("Navigate to Master Data Tab", async function () {
	await z.click(await TMSLmt.getElement(MasterItemTabObj.MasterDataTab));
});

Then("Master Data page should be accessible", async function () {
    await z.see(await TMSLmt.getData("Master_data_maintitle"));
    await z.see(await TMSLmt.getData("Master_data_subtitle"));
    //await z.seeTitleEquals("Master Data");
    //await z.see("Generic Masters");
});

When("Navigate to Items Data Tab", async function () {
    await z.click(await TMSLmt.getElement(MasterItemTabObj.ItemsTab));
});

Then("Items Data page should be accessible", async function () {
    //I.seeTitleEquals("Zycus Procure-to-Pay");
});

When("Navigate to Workflow Tab", async function () {
    //I.click(MasterItemTabObj.WorkflowTab);
    await z.see(await TMSLmt.getData("Workflow_visible"));
    //await z.see("WorkFlow");
});

When("Check Access of Workflow Activity", async function () {
    //await z.see(await TMSLmt.getData("Reports"));
    await Wait.waitForDefaultTimeout(prop.DEFAULT_HIGH_WAIT);
    await z.see(await TMSLmt.getData("Workflow"));
});

When("Check Access of Master Data Activity", async function () {
    await z.dontSee(await TMSLmt.getData("Preference"));
    await z.dontSee(await TMSLmt.getData("Security_Policy_page"));
    await z.dontSee(await TMSLmt.getData("Reports"));
    await z.dontSee(await TMSLmt.getData("RoleManagement"));
    await z.see(await TMSLmt.getData("MasterData"));
    await z.see(await TMSLmt.getData("Masters"));
    // await z.dontSee(await TMSLmt.getData("Customize"));
    // await z.dontSee(await TMSLmt.getData("AuditTrail"));
    await z.dontSee(await TMSLmt.getData("Workflow"));
    await z.dontSee(await TMSLmt.getData("UserGroups"));
    await z.dontSee(await TMSLmt.getData("UserManagement"));
    await z.dontSee(await TMSLmt.getData("ImpersonateUserRequests"));
    await z.dontSee(await TMSLmt.getData("Company_Preferences_Display"));
});


Then("Workflow page should be accessible", async function () {
    //I.seeTitleEquals("Workflow Management");
});