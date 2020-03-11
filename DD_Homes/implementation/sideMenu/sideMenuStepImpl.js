const ProductNavigator = require("../../../node_modules/dd-cc-zycus-automation/components/dewSideMenu");
const { I } = inject();
const DewNavBar = require("../../../node_modules/dd-cc-zycus-automation/components/dewNavBar");

Given("I am logged in as: {string} {string}", async function (userName, password) {
    I.login(userName, password)
});

When("I click on Hamburgermenu", async function () {
    DewNavBar.clickHamburger();
});

When("I click on {string}", async function (product) {
    ProductNavigator.navigate(product)
});

When("I click on {string} of {string}", async function (adminmenu, product) {

});

Then("I should see {string} {string} {string}", async function (home, mydesk, myapproval) {
   await ProductNavigator.checkIfModulePresent(home);
   await ProductNavigator.checkIfModulePresent(mydesk);
   await ProductNavigator.checkIfModulePresent(myapproval);

});

Then("I should be redirected to selected {string}", async function (product) {
    await ProductNavigator.checkIfNavigatedToSpecifiedProduct(product);
});

Then("I should be redirected to selected {string} in new tab", async function (adminproduct) {
    await ProductNavigator.checkIfModuleOpenedInNewtab(adminproduct);
});


When("I Navigate to {string} {string}",async function(product,module){
    await ProductNavigator.navigate(product,module);
});


When("I Navigate to {string} {string} {string}",async function(product,module,submodule){
    await ProductNavigator.navigate(product,module,submodule);
});

Given("{string} product assigned to Me", async function (product) {

});

When("Click on {string}", async function (product) {
    ProductNavigator.navigate(product)
});

Given("{string} assigned to Me", async function (adminproduct) {

});

Given("Roles to access {string} assigned to Me", async function (adminmenu) {

});
