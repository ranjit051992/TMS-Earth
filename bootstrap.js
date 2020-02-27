const databaseOperations = require("./Framework/FrameworkUtilities/DatabaseOperations/databaseOperations");
const lmtVar = require("./Framework/FrameworkUtilities/i18nUtil/readI18NProp")
module.exports = async function bootstrapFunction() {
    global.testData = await databaseOperations.getTestData();
    global.uiElements = await databaseOperations.getUiElementXpath();
    global.lmt = await databaseOperations.getLMTDetails();

    global.allkeys = await databaseOperations.getLMTKeys();
    logger.info("getting translated label from LMT table based on the key given \n ******   "+lmtVar.getLabel())
    logger.info("getting translated label from LMT table when any english label is passed to it which is coming from test data table \n ******     "+lmtVar.getLabelFromKey(global.testData.get("NavigateToAuthoringContracts")))
};