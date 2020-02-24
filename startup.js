const { container: Container, codecept: Codecept } = require("codeceptjs");
const logger = require("./Framework/FrameworkUtilities/Logger/logger");
const databaseOperations = require("./Framework/FrameworkUtilities/DatabaseOperations/databaseOperations");

const prop = require('./Framework/PropertiesConfigurator');
global.confi_prop = prop;

const LOGIN_URL = 'http://login-rp.zycus.com/';
const REST_API_URL = "https://dewdrops-rp.zycus.com";
const BROWSER = 'chrome';

async function runCodecept() {

    const config = {
        tests: './*_test.js',
        output: './output',
        helpers: {
            WebDriver: {
                url:prop.url,
                browser: prop.browser,
                host:prop.host,
                port: prop.port.number,
                restart: prop.restart,
                windowSize: prop.windowSize,
                waitForTimeout: 30000,
                default_low_wait: prop.DEFAULT_LOW_WAIT,
                default_medium_wait: prop.DEFAULT_MEDIUM_WAIT,
                default_high_wait: prop.DEFAULT_HIGH_WAIT,
              },
            "ChaiWrapper":
            {
                "require": "codeceptjs-chai"
            }
        },

        include: {
            I: './steps_file',
            ...require('./Framework/Include'),
            ...require("./eProc/bo/Spo")
        },

        gherkin: {
            features: './eproc/features/**/**/**.feature',
            steps: './eproc/implementation/**/**/**.js'
        },

        name: 'BDD_UI_Automation',
        plugins: {
            retryFailedStep: {
                enabled: true
            },
            screenshotOnFail: {
                enabled: true
            },
            wdio: {
                enabled: true,
                services: ['selenium-standalone']
            },autoDelay: {
                enabled: true,
                delayBefore: 500,
                delayAfter: 500,
                methods: ['click', 'fillField', 'checkOption']
            }
        }
    }

    const opts = {
        // steps: true,
        grep: "@tag4",
        verbose: true
    }

    const codecept = new Codecept(config, opts);

    // initialize codeceptjs in current dir
    codecept.initGlobals(__dirname);

    // create helpers, support files, mocha
    Container.create(config, opts);

    // initialize listenept.runHooks();ers
    codecept.runHooks();

    logger.info("before bootstrap");

    global.testData = await databaseOperations.getTestData();
    
    global.uiElements = await databaseOperations.getUiElementXpath();

    // codecept.runBootstrap(async (err) => {
        // load tests
        // codecept.loadTests("*_test.js");
        codecept.loadTests("./eproc/features/**/**/**.feature");

        logger.info("****************************** before codecept run**********************************")

        // run tests
        codecept.run();
    // });
}

runCodecept();

module.exports = { runCodecept };