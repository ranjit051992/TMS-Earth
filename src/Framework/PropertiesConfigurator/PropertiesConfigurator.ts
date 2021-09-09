import { Startup } from "../FrameworkUtilities/Startup/Startup";
import { prop } from "../FrameworkUtilities/config";
import { logger } from "../FrameworkUtilities/Logger/logger";

export function parseJson() {
  for (const [key, value] of Object.entries(prop)) {
    Startup.configmap.set(key, value);
    //logger.info(Startup.testData);
  }

  // for (const [key, value] of Startup.configmap.entries()) {
  //   logger.info(`key --> ${key} || value --> ${value}`);
  // }

}


