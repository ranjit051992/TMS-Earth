const {I} = inject();
const lmt = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const landingPage = require("../../POM/LandingPage/landingPageFlow")
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger")
When("user initiates create clause flow", function () {
    landingPage.initiateCreationFlow("createClause","clauseCreationHeader")
    // logger.info("In Landing page "+  this.stepvar)
})