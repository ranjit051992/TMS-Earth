"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const Startup_1 = require("../FrameworkUtilities/Startup/Startup");
const config_1 = require("../FrameworkUtilities/config");
function parseJson() {
    for (const [key, value] of Object.entries(config_1.prop)) {
        Startup_1.Startup.configmap.set(key, value);
    }
    // for (const [key, value] of Startup.configmap.entries()) {
    //   logger.info(`key --> ${key} || value --> ${value}`);
    // }
}
exports.parseJson = parseJson;
