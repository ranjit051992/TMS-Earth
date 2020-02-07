const log4js = require("log4js");

const log4jsConfigs = {
    log4js: {
        traceLogConfig: {
            appenders: {
                fileAppender: {
                    type: 'file',
                    filename: './log4jslogs.log',
                    layout: {
                        type: 'pattern',
                        pattern: '%d - %c:[%p]: %m'
                    }
                },
                consoleAppender: {
                    type: 'console',
                    layout: {
                        type: 'pattern',
                        pattern: '%d - %c:[%p]: %m'
                    }
                }
            },
            categories: {
                default: {
                    appenders: ['fileAppender', 'consoleAppender'],
                    level: 'info'
                }
            }
        }
    }
};

module.exports = log4jsConfigs;