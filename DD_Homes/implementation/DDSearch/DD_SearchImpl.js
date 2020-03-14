const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")

module.exports = {

    async enterTextInSearch(link){
        I.clearField(`//input[@id='input-text-area'][@type='MST_Search']`)
        I.fillField(`//input[@id='input-text-area'][@type='MST_Search']`, link);
        I.wait(5)
    },

    async verifyFrequentlyAccessedHomeSearchResults(link) {
        CommonKeyword.clickElement(`//div[contains(@class,'dew-container')]//a[text()='Home']`); // Switch to Home
        I.waitToProcess();
        if (I.seeElement(`//div[text()='FREQUENTLY ACCESSED']/ancestor::div//span[contains(text(),'${link}')]`)) {
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
      //  CommonKeyword.enterText(`//input[@id='input-text-area'][@type='MST_Search']`, link);
        I.seeElement(`//div[div/span[text()[normalize-space()='${link}']]]//span[text()[normalize-space()='${type}']]`,10);
      }

}