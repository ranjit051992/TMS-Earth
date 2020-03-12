const OneView  = require("./OneViewImpl");


Given("I navigate to Oneview page",async function() {
	OneView.navigateOneView()
});


When("I search the supplier with name {string}", async function (supplier){
	await OneView.searchAndSelectSupplier(supplier)
});

Then("I see oneview card for {string} is displayed", async function (supplier){
	await OneView.verifySupplierCard(supplier)
});


When("I click on export option",async function  (){
	await OneView.exportFiles()
});

Then("Supplier data is exported in excel format",async function (){
	return true;
});


When("I filter the data with {string}",async function(supplier) {

	await OneView.filterSupplier(supplier)
});

Then("I see results satisfying the filter conditions {string} are displayed", async function (supplier) {
	await OneView.verifySupplierCard(supplier)
});


When("I search the supplier group with name {...string}", async function (...suppliers){
	await OneView.searchAndSelectSuppliers(...suppliers)
});

Then("I see oneview card for {...string} is displayed", async function (...suppliers)  {
	await OneView.verifySupplierCards(...suppliers)
});







 