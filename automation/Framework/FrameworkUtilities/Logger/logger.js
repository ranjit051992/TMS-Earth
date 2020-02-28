const log4js = require('log4js');

const getLogger = () => {
    const { traceLogConfig } = require('../Logger/log4jsproperties').log4js;

    log4js.configure(traceLogConfig);

    const logger = log4js.getLogger();

    return logger;
}

module.exports = getLogger();