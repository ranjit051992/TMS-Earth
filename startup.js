const { container: Container, codecept: Codecept } = require("codeceptjs");
const logger = require("./automation/Framework/FrameworkUtilities/Logger/logger");

const LOGIN_URL = 'http://login-rp.zycus.com/';
const REST_API_URL = "https://dewdrops-rp.zycus.com";
const BROWSER = 'chrome';

async function runCodecept() {

    const config = {
        tests: './*_test.js',
        output: './output',
        helpers: {
            WebDriver: {
                url: LOGIN_URL,
                browser: BROWSER,
                host: '127.0.0.1',
                port: 4444,
                restart: false,
                windowSize: 'maximize',
                waitForTimeout: 30000,
            },
            "ChaiWrapper":
            {
                "require": "codeceptjs-chai"
            }
        },

        include: {
            I: './steps_file',
            ...require('./automation/Framework/Include')
        },

        gherkin: {
            features: './automation/eproc/features/**/**/**.feature',
            steps: './automation/eproc/implementation/**/**/**.js'
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
            }
        }
    }

    const opts = {
        // steps: true,
        grep: "@tag3",
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

    // codecept.runBootstrap(async (err) => {
        // load tests
        // codecept.loadTests("*_test.js");
        codecept.loadTests("./automation/eproc/features/**/**/**.feature");

        logger.info("****************************** before codecept run**********************************")

        // run tests
        codecept.run();
    // });
}

runCodecept();

module.exports = { runCodecept };