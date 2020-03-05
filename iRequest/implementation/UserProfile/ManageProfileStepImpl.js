const { I } = inject();
const ManageProfileImpl = require("./ManageProfileImpl");

//save
Given("I see the Username", function () {
    ManageProfileImpl.UserLogo();
});
Then("I change data in ManageProfile Section", function () {
    ManageProfileImpl.ManageProfile();

});
Then("I can save the updated data", function () {
    ManageProfileImpl.SaveManageProfile();

});

//cancel
Given("I see the UserLogo", function () {
    ManageProfileImpl.UserLogo();
});
Then("I can able to cancel the updated data", function () {
    ManageProfileImpl.CancelManageProfile();

});

//Logout

Given("I see UserName", function () {
    ManageProfileImpl.UserLogo();
});
Then("I am logging out", function () {
    ManageProfileImpl.Logout();

});
Then("I can able to logout of the application", function () {
    ManageProfileImpl.LogoutValid();

});









