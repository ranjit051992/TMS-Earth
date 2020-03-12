const { I } = inject();
const LoginHistoryImpl = require("./LoginHistoryImpl");


Given("I am on Home page", async function(){
    await I.seeElement(`//span[contains(@class,'welcome-message')]`)
});

When("I navigate to Login History", async function(){
   await LoginHistoryImpl.navigateToLoginHistory()
});

Then("I should be able to see user's login time and IP", async function(){
    await LoginHistoryImpl.verifyHistory()
});


Then("I navigate to manage profile", async function(){
	
});

Then("I see date and time preference", async function(){
	
});

When("I Select Login history from user profile", async function(){
	
});

Then("I am able to see login history popup containing date and time as per my preference", async function() {
	
});
