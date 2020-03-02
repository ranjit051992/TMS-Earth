const databaseOperations = require("./Framework/FrameworkUtilities/DatabaseOperations/databaseOperations");
const lmtVar = require("./Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const logger = require("../dd-ui-automation/Framework/FrameworkUtilities/Logger/logger");
module.exports = {
        bootstrap: async function () {
                global.testData = await databaseOperations.getTestData();
                global.uiElements = await databaseOperations.getUiElementXpath();
                global.users = await databaseOperations.getUser();
                global.lmt = await databaseOperations.getLMTDetails();
                global.allkeys = await databaseOperations.getLMTKeys();
                await databaseOperations.updateUSER(global.users.get("USERNAME"),"false");
                logger.info(" for this Chunk USERNAME  : " + global.users.get("USERNAME"));
        },
        teardown: async function ()
        {
                await databaseOperations.updateUSER(global.users.get("USERNAME"),"true");
        },
        bootstrapAll: async function()
        {
                console.log("inside bootstrapAll ");
        },
        teardownAll: async function()
        {
                console.log("inside tearDownAll ");
        }
}