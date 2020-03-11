const { I } = inject();
const ManageProfile = require("./ManageProfileImpl");
//const ManageProfile = require("../../../components/manageProfile");

Given("I login to the application with user {string} and password {string}", async function (username,password) {
	await I.amOnPage("https://login-partner.zycus.com/sso");	
	I.click("#emailAddressGhost");
    I.fillField("input#emailAddress", username);
    I.click("[name='pass_temp']");
    I.fillField("input#password", password);
    I.click("Login");
    I.wait(5)
    I.refreshPage()
	I.waitForElement("dew-navbar", 30);
	await I.seeElement("dew-navbar");
});

// When("I submit username and password", async function () {
//     I.click("#emailAddressGhost");
//     I.fillField("input#emailAddress", username);
//     I.click("[name='pass_temp']");
//     I.fillField("input#password", password);
//     I.click("Login");
//     I.wait(5)
//     I.refreshPage()
//     I.waitForElement("dew-navbar", 30);
// });

// Then("I should be logged in", async function (link) {
//    await I.seeElement("dew-navbar");
// });

Given("I am on home page", async function(){
	await I.seeElement(`//span[contains(@class,'welcome-message')]`)
});

When("I navigate to Manage Profile",async function()  {
	await ManageProfile.navigateToManageProfile()
});

When("I reset profile picture", async function() {
	await ManageProfile.resetProfilePicture()
});

When("I upload photo",async function() {
	await ManageProfile.uploadProfilePicture()
});

Then("photo should be set as profile picture", async function(){
	await ManageProfile.verifyUploadedProfilePicture()
});

When("I change password", async function(){
	await ManageProfile.changePassword()
});

Then("I should be able to see Password updated success message", async function(){
	await ManageProfile.verifyIfPasswordUpdated()
});

When("I Change Pin", async function(){
	await ManageProfile.changePin()
});


Then("I should be able to see Pin updated success message", async function(){
	await ManageProfile.verifyIfPinUpdated()
});


When("I update location details", async function(){
	return true;
});

Then("updated location details should be saved successfully", async function(){
	return true;
});
