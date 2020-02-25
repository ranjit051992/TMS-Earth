const {I} = inject();
const commonPageFlow = require("./../../POM/CommonLandingPage/commonLandingFlow")
const lmt = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger")

When("User is on the clauses tab", function (){
    commonPageFlow.navigateToTab("appName_iContract", "clauses")
    commonPageFlow.navigateToTab("appName_iContract", this.stepVar)
    I.see(lmt.getLabel("ClauseHeader"))
    // this.stepvar = "qwerty"
    // logger.info("In commonNavigation  "+ this.stepvar)
})