const { I } = inject();
import { DisplayObj } from "../../POM/Settings/DisplayObj";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";

Given ("Navigate to Display Settings", async function() {  
    await z.click(await TMSLmt.getElement(DisplayObj.PreferenceTab));
    await z.click(await TMSLmt.getElement(DisplayObj.DisplaySettingsTab));
    //await z.see("You are here: Company Preferences > Display Settings");
    await z.see(await TMSLmt.getData("Company_Preferences_Display"));
});

When ("Changes Company Preferences",async function(){
    await z.selectOption(await TMSLmt.getElement(DisplayObj.defaultDateFormat_Locator),await TMSLmt.getData("DateFormat_value"));
    await z.selectOption(await TMSLmt.getElement(DisplayObj.defaultLocale_Locator),await TMSLmt.getData("Locale_value"));
    await z.selectOption(await TMSLmt.getElement(DisplayObj.timeFormat_Locator),await TMSLmt.getData("TimeFormat_value"));
});

When ("Upload New logo",async function(){
    await z.attachFile("//input[@id='importFile']",'newlogo.png');
    await z.click("//input[@id='uploadBtn']");
    //await z.see("Logo Uploaded Successfully");
    await z.see(await TMSLmt.getData("Logo_Uploaded_Successfully"));
});

When("Reset Zycus logo", async function () {
    await z.click("//input[@id='chkResetZycusLogo']");
    await z.click("//span[text()='Ok']")
    //await z.see("Reset to Zycus Logo Successful !");
    await z.see(await TMSLmt.getData("Logo_Reset_Successfully"));
});

Then ("Display Settings should get updated", async function() {
    await z.click(await TMSLmt.getElement(DisplayObj.Save_btn));
    //await z.see("Display Settings has been updated");
    await z.see(await TMSLmt.getData("Display_Settings_updated"));
});


Then("Settings should be reflected in AuditTrail page", async function () {
    //await z.see("Company Logo Updated");
    await z.see(await TMSLmt.getData("LogoCompany_Uploaded_Successfully"));
});

When("I click on Reset Logo button",  async function (){
	await z.click(await TMSLmt.getElement(DisplayObj.ResetZycusLogo));
});


When("I confirm for resetting the logo",  async function () {
	await z.click(await TMSLmt.getElement(DisplayObj.ResetZycusLogoConfirmation));
});

Then("zycus logo should be reset",  async function () {
    //await z.see("Reset to Zycus Logo Successful !");
    await z.see(await TMSLmt.getData("Logo_Reset_Successfully"));
});
