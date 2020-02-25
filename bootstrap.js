const databaseOperations = require("./Framework/FrameworkUtilities/DatabaseOperations/databaseOperations");
module.exports = async function bootstrapFunction() {
    global.testData = await databaseOperations.getTestData();
    global.uiElements = await databaseOperations.getUiElementXpath();
};