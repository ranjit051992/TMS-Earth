"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const log4jsproperties_1 = require("./log4jsproperties");
const log4js_1 = require("log4js");
const { traceLogConfig } = log4jsproperties_1.appSettings.log4js;
log4js_1.configure(traceLogConfig);
exports.logger = log4js_1.getLogger();
