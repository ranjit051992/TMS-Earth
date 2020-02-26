const { I } = inject();
const lmt = require("./../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const transitionScreenFlow = require("../../POM/TansitionScreen/transitionScreenFlow")

When("User enter default details on the transition page of clause creation", () =>{
    transitionScreenFlow.enterClauseTitle();
    this.categoryValue = transitionScreenFlow.enterClauseCategory();
    console.log(this.categoryValue);
})