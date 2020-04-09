const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")
const DD_SearchObject = require("./DD_SearchObject")
const DynamicLocator = require("dd-cc-zycus-automation/components/element")

module.exports = {

    async enterTextInSearch(link){
        I.clearField(DD_SearchObject.TextAreaSearch)
        I.fillField(DD_SearchObject.TextAreaSearch, link);
        I.wait(5)
    },

    async verifyFrequentlyAccessedHomeSearchResults(link) {
        CommonKeyword.clickElement(DD_SearchObject.SwitchToHome); // Switch to Home
        I.waitToProcess();
        if (I.seeElement(await DynamicLocator.getDynamicLocator(DD_SearchObject.FrequentlyAccessLink,"<<link>>",link))) {
            console.log(link + " is present in FREQUENTLY ACCESSED list");
        }
    },


    async verifySupplierSearchOneView(link) {
        I.waitToProcess();
        if (I.seeInCurrentUrl("oneView")) {
            console.log("Navigated to " + link + " :oneView");
        } else {
            console.log("Not Navigated to " + link + " :oneView");
        }
    },

      async verifySearchResultsInBucket(link,type) {
      //  CommonKeyword.enterText(DD_SearchObject.TextAreaSearch, link);
      I.seeElement(await DynamicLocator.getDynamicLocator(DD_SearchObject.VerifyFrequentLink,"<<link>>",link,"<<type>>",type),10);
      }

}