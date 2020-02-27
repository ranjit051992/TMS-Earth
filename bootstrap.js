const databaseOperations = require("./Framework/FrameworkUtilities/DatabaseOperations/databaseOperations");
const lmtVar = require("./Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const logger = require("../dd-ui-automation/Framework/FrameworkUtilities/Logger/logger");


module.exports = async function bootstrapFunction() {
    global.testData = await databaseOperations.getTestData();
    global.uiElements = await databaseOperations.getUiElementXpath();
    global.lmt = await databaseOperations.getLMTDetails();
    global.allkeys = await databaseOperations.getLMTKeys();
    
    // logger.info("getting translated label from LMT table based on the key given \n ******   "+lmtVar.getLabel("SPO_BILLING_INFORMATION_SECTION"))
    // logger.info("getting translated label from LMT table when any english label is passed to it which is coming from test data table \n ******     "+lmtVar.getLabelFromKey(I.getData("Basic details")))
};