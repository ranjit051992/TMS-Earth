import { DatabaseOperations } from "../DatabaseOperations/databaseOperations";
import { Startup } from "../Startup/Startup";
import { logger } from "../Logger/logger";
import { prop } from "../config";
import { eventListener } from "../../CustomHelper/eventListeners";
//import {InfraDetails} from "./InfraDetails";
import { coeBootstrap } from "../../../COE_AUTOMATION/src/Framework/FrameworkUtilities/Bootstrap/custom";

export async function bootstrap() {
        eventListener.init();
        Startup.testData = await DatabaseOperations.getTestData();
        Startup.uiElements = await DatabaseOperations.getUiElementXpath();
        if (process.env.GRID) {
                Startup.users = await DatabaseOperations.getAndUpdateUser(prop.username);
        }
        else {
                logger.info(`Using local credentials --> ${prop.username} / ${prop.password}`);
                let testDataMap: Map<string, string> = new Map();
                testDataMap.set("USERNAME", prop.username);
                testDataMap.set("PASSWORD", prop.password);
                Startup.users = testDataMap;
        }
        Startup.lmt = await DatabaseOperations.getLMTDetails();
        Startup.allkeys = await DatabaseOperations.getLMTKeys();

        await coeBootstrap.boot_COE();

        logger.info("for this Chunk USERNAME  : " + Startup.users.get("USERNAME"));
}

export async function teardown() {
        if (process.env.GRID) {
                await DatabaseOperations.updateUSER(Startup.users.get("USERNAME") as string, "true");
                logger.info(" for this Chunk USERNAME  : " + Startup.users.get("USERNAME"));
        }
}

export async function bootstrapAll() {
        await coeBootstrap.bootAll_COE();
        //await InfraDetails.clearFile();
            logger.info("inside bootstrapAll");
            //let now = new Date();
            //now = new Date(now.toLocaleString('en-US',{timeZone:'Asia/Kolkata'}));
            //prop.executionStartTime=`${String(now.getFullYear())}-${String(now.getMonth()+1)}-${String(now.getDate())} ${String(now.getHours())}:${String(now.getMinutes())}:${String(now.getSeconds())}`
            //console.log("Execution start time "+prop.executionStartTime)   
            let now = new Date();
            now = new Date(now.toLocaleString('en-US',{timeZone:'Asia/Kolkata'}));
            prop.executionStartTime=`${String(now.getFullYear())}-${String(now.getMonth()+1)}-${String(now.getDate())} ${String(now.getHours())}:${String(now.getMinutes())}:${String(now.getSeconds())}`
            console.log("Execution start time "+prop.executionStartTime)
}

export async function teardownAll() {
        logger.info("inside tearDownAll");
} 
 



// import { DatabaseOperations } from "../DatabaseOperations/databaseOperations";
// import { Startup } from "../Startup/startup";
// import { logger } from "../Logger/logger";
// import { prop } from "../config";

// export async function bootstrap() {
//         Startup.testData = await DatabaseOperations.getTestData();
//            console.log("Printing from Bootstrap..."+Startup.testData.size);
//         for( const data in Startup.testData)
//         {
//                 
//                 console.log(data+"-----"+Startup.testData.get(data));

//         } 
//         Startup.uiElements = await DatabaseOperations.getUiElementXpath();
//         if (process.env.GRID) {
//                 Startup.users = await DatabaseOperations.getAndUpdateUser();
//         }
//         else {
//                 logger.info(`Using local credentials --> ${prop.USERNAME} / ${prop.PASSWORD}`);
//                 let testDataMap: Map<string, string> = new Map();
//                 testDataMap.set("USERNAME", prop.USERNAME);
//                 testDataMap.set("PASSWORD", prop.PASSWORD);
//                 Startup.users = testDataMap;
//         }
//         Startup.lmt = await DatabaseOperations.getLMTDetails();
//         Startup.allkeys = await DatabaseOperations.getLMTKeys();
//         logger.info("for this Chunk USERNAME  : " + Startup.users.get("USERNAME"));
// }

// export async function teardown() {
//         if (process.env.GRID) {
//                 await DatabaseOperations.updateUSER(Startup.users.get("USERNAME") as string, "true");
//                 logger.info(" for this Chunk USERNAME  : " + Startup.users.get("USERNAME"));
//         }
// }

// export async function bootstrapAll() {
//         logger.info("inside bootstrapAll");
// }

// export async function teardownAll() {
//         logger.info("inside tearDownAll");
// }