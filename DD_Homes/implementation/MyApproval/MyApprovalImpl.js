const { I } = inject()
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")

class ApprovalPage {

    /**
     * 
     * @param {*} tabName 
     */
    selectHeaderTab(tabName) {

        I.scrollIntoView(`//a[dew-default-tab-head[contains(text(),'${tabName}')] and contains(@class,'paginated-nav-link') ]`)
        I.waitForVisible(`//a[dew-default-tab-head[contains(text(),'${tabName}')] and contains(@class,'paginated-nav-link') ]`)
        CommonKeyword.clickElement(`//a[dew-default-tab-head[contains(text(),'${tabName}')] and contains(@class,'paginated-nav-link') ]`)
        // I.scrollIntoView("//a[dew-default-tab-head[contains(text(),'" + tabName + "')] and contains(@class,'paginated-nav-link')]")
        // I.waitForVisible("//a[dew-default-tab-head[contains(text(),'" + tabName + "')] and contains(@class,'paginated-nav-link')]")
        // CommonKeyword.clickElement("//a[dew-default-tab-head[contains(text(),'" + tabName + "')] and contains(@class,'paginated-nav-link')]")
    }


    /**
     * 
     * @param {*} tabName 
     */
    async verifyListingPage(tabName) {
        // I.seeElement("//dew-default-tab-head");
        //I.seeElement('//a[dew-default-tab-head[text()[normalize-space()="'+tabName +'"]] and contains(@class,"active")]');
        I.waitForElement(`//a[dew-default-tab-head[contains(text(),"${tabName}")] and contains(@class,'active') ]`, 20);
        I.seeElement(`//a[dew-default-tab-head[contains(text(),"${tabName}")] and contains(@class,'active') ]`);
        console.log("Navigated to: " + tabName);
        I.waitForElement('dew-listing', 20);
        let num = await I.grabNumberOfVisibleElements('dew-listing');
        console.log(num);

        if (num > 0) {
            console.log("Data is Present");
        }
        else {
            console.log("data is not present")
        }
    }

    /**
     *  Use this method to navigate to all sublisting present in a page
     */
    async navigateToAllSubListing() {
        let pin = await I.grabTextFrom("//dew-default-tab-head");
        console.log(pin.length);
        pin.forEach(async tabName => {

            CommonKeyword.clickElement('//a[dew-default-tab-head[contains(text(),"'+tabName+'")] and contains(@class,"paginated-nav-link")]');
            // CommonKeyword.clickElement('//a[dew-default-tab-head[text()[normalize-space()="' + tabName + '"]] and contains(@class,"paginated-nav-link")]');
            I.wait(10);
            await verifyListingPage(tabName);
        })
    }


    /**
     * 
     * @param {*} listingName 
     */
    async verifyPageSubListing(listingName) {
        //pause()
        //CommonKeyword.clickElement('//a[dew-default-tab-head[contains(text(),"'+tabName+'")] and contains(@class,"paginated-nav-link")]');
        //CommonKeyword.clickElement('//a[dew-default-tab-head[text()[normalize-space()="' + listingName + '"]] and contains(@class,"paginated-nav-link")]');
        I.wait(10);
        let num = await I.grabNumberOfVisibleElements('dew-listing');
        console.log(num);

        if (num > 0) {
            I.seeElement('//a[dew-default-tab-head[contains(text(),"'+listingName+'")] and contains(@class,"active")]');
            // I.seeElement('//a[dew-default-tab-head[text()[normalize-space()="' + listingName + '"]] and contains(@class,"active")]');
            console.log("Data is Present");
            I.waitForElement('dew-listing',20);
        }
        else {
            console.log("data is not present")
        }

    }


}
module.exports = new ApprovalPage()
module.exports.ApprovalPage = ApprovalPage // for inheritance