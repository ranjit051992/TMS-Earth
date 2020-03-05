const I = actor();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const customize = require("./iCustomizeHome");

module.exports = {

customizeMatching() {
        I.click(global.uiElements.get(customize.customizebtn));
        I.click(global.uiElements.get(customize.matchingsetting));
        logger.info("change the invoice setting");   
      },
}