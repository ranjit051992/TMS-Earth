const { I } = inject();
import { Common } from "../../Common/Common";
import { ManageEmailPreferenceObj } from "../../POM/ManageEmailPreference/ManageEmailPreferenceObj";
import { ManageEmailPreferenceImpl } from "../../POM/ManageEmailPreference/ManageEmailPreferenceImpl";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
var CMDSetting;

/*
Given("I navigate to Master tab", async function () {
	I.click(ManageEmailPreferenceObj.MasterTab);
});

When("I select Customize", async function() {
	I.click(ManageEmailPreferenceObj.CustomizeTab);
});

When("I select Email Notification", async function () {
	I.click(ManageEmailPreferenceObj.EmailNotificationTab);
});

When("I select Delivery Notification", async function () {
	I.click(ManageEmailPreferenceObj.DeliveryNotification);
});

When("I make necessary sschanges", async function() {
	var X = (await I.grabValueFrom(ManageEmailPreferenceObj.NewReqAtBuyerDeskYes));

	if (X.toString() == ManageEmailPreferenceObj.Value)
	{	
		I.click(ManageEmailPreferenceObj.NewReqAtBuyerDeskNo);
		I.wait(5);
		CMDSetting = "No";
	}
	else
	{	
		I.click(ManageEmailPreferenceObj.NewReqAtBuyerDeskYes);
		I.wait(5);
		CMDSetting = "Yes";
	}
});

When("I click on Save Button", async function () {
	I.wait(10);
	I.click(ManageEmailPreferenceObj.SaveBtn);
});
*/

//LocalUser or Local Admin steps for checking user level preference

When("I navigate to TMS after Logging", async function() {
	await ManageEmailPreferenceImpl.NavigateToTMS();
});

When("I click on Userlevel MEP", async function () {
	await z.click(await TMSLmt.getElement(ManageEmailPreferenceObj.SettingsIcon));
	await z.click(await TMSLmt.getElement(ManageEmailPreferenceObj.UMPTab));
});

When("I navigate to eProc Settings and make necessary changes", async function () {
	await ManageEmailPreferenceImpl.ChangeSetting();
});

/*When("Check user level settings reflected", async function(){
	await ManageEmailPreferenceImpl.ChangeSettingreflected();
});

When("I check whether setting is reflected", async function(){
	z.click(ManageEmailPreferenceObj.SetToBeChanged);
	if (CMDSetting == true)
	{
		I.grabNumberOfVisibleElements(ManageEmailPreferenceObj.SetToBeChanged)
		(ManageEmailPreferenceObj.SetToBeChanged).isSelected()
		console.log("MEP Changes reflected");
	}
	else
	{
		console.log("MEP Failed");
	}
	
});

When(/^Dewdrop Logout$/, () => {
	return true;
});*/



When("I click on Save", async function() {
	await z.click(await TMSLmt.getElement(ManageEmailPreferenceObj.UserSaveBtn));
});

Then("changes should be saved", async function()  {
	await ManageEmailPreferenceImpl.verificationResult();
});


