const { I } = inject();
const DD_SearchImpl = require("./DD_SearchImpl");
const FooterLinkImpl = require("./../footerLinks/DD_FooterLinksImpl");
const DewHomeSearchField = require("dd-cc-zycus-automation/components/dewHomeSearchField");
const DD_SearchObject = require("./DD_SearchObject")


/**
 * To verify whether on Home Page load, frequently accessed list is displayed and user is able to navigate to the product
 */
Given("I am on home page", async function () {
    await I.seeElement(DD_SearchObject.Welcome_Message)
});

When("I see Frequently accessed list", async function () {
    await I.seeElement(DD_SearchObject.FrequentlyAccessHeader)
});

When("I click on link {string}", async function (link) {
    FooterLinkImpl.clickHomeDirectLink(link)
});

Then("I should able to navigate to {string}", async function (link) {
    FooterLinkImpl.verifyIfNavigatedToHomeLinkPage(link)
});


/**
 * To verify whether user is able to search supplier and land in OneView Page , if he has access to OneView
 */

// When("I have access to Onew View", async function () {
//     await I.seeElement(DD_SearchObject.FrequentlyAccessHeader)
// });


When("I search {string} in home search box", async function (supplier) {
    DewHomeSearchField.searchFieldHome(supplier)
});


Then("I should able to land to One View page", async function () {
    await I.seeElement(DD_SearchObject.OneViewHeader)
});


Then("I should be able to search {string}", async function (supplier) {
    await DD_SearchImpl.verifySupplierSearchOneView(supplier)
});

//To verify whether frequently accessed list is updated based on user search

When("I search {string} in home search box", async function (link) {
    DewHomeSearchField.searchFieldHome(link)
});



Then("I should be able to see {string} in Frequently accessed list", async function (link) {
    DD_SearchImpl.verifyFrequentlyAccessedHomeSearchResults(link)
});


//To verify whether On search respective results to be displayed in different buckets. a. View All b. Create c. Configured d. Supplier in One View
When("I search {string} of type VIEW ALL in home search box", async function (link) {
    DD_SearchImpl.enterTextInSearch(link)
});


Then("I should be able to see {string} search results in View All bucket", async function (link) {
    DD_SearchImpl.verifySearchResultsInBucket(link, "VIEW ALL")
});

When("I search {string} of type CONFIGURE in home search box", async function (link) {
    DD_SearchImpl.enterTextInSearch(link)
});


Then("I should be able to see {string} search results in CONFIGURE bucket", async function (link) {
    DD_SearchImpl.verifySearchResultsInBucket(link, "Configure")
});


When("I search {string} of type SUPPLIERS IN ONE VIEW in home search box", async function (link) {
    DD_SearchImpl.enterTextInSearch(link)
});


Then("I should be able to see {string} search results in SUPPLIERS IN ONE VIEW bucket", async function (link) {
    DD_SearchImpl.verifySearchResultsInBucket(link, "Suppliers in One View")
});


When("I search {string} of type CREATE in home search box", async function (link) {
    DD_SearchImpl.enterTextInSearch(link)
});


Then("I should be able to see {string} search results in CREATE bucket", async function (link) {
    DD_SearchImpl.verifySearchResultsInBucket(link, "Create")
    });  
         
    
