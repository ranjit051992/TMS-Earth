const databaseOperations = require("./Framework/FrameworkUtilities/DatabaseOperations/databaseOperations");
const lmtVar = require("./Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const logger = require("./Framework/FrameworkUtilities/Logger/logger");
const prop = global.confi_prop;
const {I} = inject();
module.exports = {
        
        bootstrap: async function () {
                 //global.testData = await databaseOperations.getTestData();
                //global.uiElements = await databaseOperations.getUiElementXpath();
                // if(process.env.GRID) {
                //         global.users = await databaseOperations.getAndUpdateUser();
                // }
                // else {
                //          logger.info(`Using local credentials --> ${prop.USERNAME} / ${prop.PASSWORD}`);
                //         let testDataMap = new Map();
                //          testDataMap.set("USERNAME", prop.USERNAME);
                //          testDataMap.set("PASSWORD", prop.PASSWORD);
                //          global.users = testDataMap;
                // }
                //  global.lmt = await databaseOperations.getLMTDetails();
                //  global.allkeys = await databaseOperations.getLMTKeys();
                //  logger.info(" for this Chunk USERNAME  : " + global.users.get("USERNAME"));
        },
        teardown: async function ()
        {

                // I.click("//dew-dropdown[contains(@class,'profile')]")
                // I.click("Logout")
                // I.wait(2)
                // if(prop.runOnGrid) {
                        // await databaseOperations.updateUSER(global.users.get("USERNAME"),"true");
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