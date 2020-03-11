Given("I am Logged into application", () => {
	return true;
});

When("I click on Hamburgermenu", () => {
	return true;
});

Then("I should see {string} {string} {string}", async function(Home, MyDesk, MyApproval) {
	console.log(Home, MyDesk, MyApproval);
	return true;
});

Given("I am Logged into application", () => {
	return true;
});

Then("{string} product assigned to Me", async function(Product) {
	console.log(Product);
	return true;
});

When("I click on Hamburgermenu", () => {
	return true;
});

When("Click on {string}", (Product) =>{
	console.log(Product);
	return true;
});

Then("I should be redirected to selected {string}", (Product) => {
	console.log(Product);
	return true;
});


Given("I am Logged into application", () => {
	return true;
});

Then("{string} assigned to Me", async function (AdminProduct) {
	return true;
});

When("I click on {string}", async function (AdminProduct) {
	return true;
});

Then("I should be redirected to selected {string} in new tab", async function(AdminProduct) {
	return true;
});


Given("I am Logged into application", () => {
	return true;
});

Then("Roles to access {string} assigned to Me", async function (AdminMenu) {
	return true;
});

When("I click on {string} of {string}", async function(AdminMenu, Product) {
	console.log(AdminMenu);
	return true;
});

Then("I should be redirected to selected {string} in new tab", async function(AdminMenu) {
	return true;
});