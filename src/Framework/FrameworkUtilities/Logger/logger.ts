import { appSettings } from "./log4jsproperties";

import { configure, getLogger } from "log4js";

const { traceLogConfig } = appSettings.log4js;

configure(traceLogConfig);

export let logger = getLogger();
