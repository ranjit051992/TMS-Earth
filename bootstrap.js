const databaseOperations = require("./Framework/FrameworkUtilities/DatabaseOperations/databaseOperations");
const lmtVar = require("./Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const logger = require("./Framework/FrameworkUtilities/Logger/logger");
const prop = global.confi_prop;
module.exports = {
        bootstrap: async function () {
                global.testData = await databaseOperations.getTestData();
                global.uiElements = await databaseOperations.getUiElementXpath();
                if(prop.runOnGrid) {
                        global.users = await databaseOperations.getAndUpdateUser();
                }
                else {
                        logger.info(`Using local credentials --> ${prop.USERNAME} / ${prop.PASSWORD}`);
                        let testDataMap = new Map();
                        testDataMap.set("USERNAME", prop.USERNAME);
                        testDataMap.set("PASSWORD", prop.PASSWORD);
                        global.users = testDataMap;
                }
                global.lmt = await databaseOperations.getLMTDetails();
                global.allkeys = await databaseOperations.getLMTKeys();
                logger.info(" for this Chunk USERNAME  : " + global.users.get("USERNAME"));
        },
        teardown: async function ()
        {
                // if(prop.runOnGrid) {
                        await databaseOperations.updateUSER(global.users.get("USERNAME"),"true");
                // }
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