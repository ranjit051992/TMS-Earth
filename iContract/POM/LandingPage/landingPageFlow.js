const {I}=inject();
const landingPageAction = require("./landingPageActions")
const lmt = require("./../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")


class landingPageFlow {

    initiateCreationFlow(buttonLabel, transitionHeaderLabel){
        I.see(lmt.getLabel(buttonLabel));
        I.click(lmt.getLabel(buttonLabel));
        I.see(lmt.getLabel(transitionHeaderLabel));
        
    }
}

module.exports = new landingPageFlow;