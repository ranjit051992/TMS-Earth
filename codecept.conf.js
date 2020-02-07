const { setHeadlessWhen } = require('@codeceptjs/configure');

// turn on headless mode when running with HEADLESS=true environment variable
// HEADLESS=true npx codecept run
setHeadlessWhen(process.env.HEADLESS);

exports.config = {
  tests: './*_test.js',
  output: './output',
  helpers: {
    REST: {
      endpoint: "http://login-rp.zycus.com/",
      defaultHeaders: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
      },
    },
    WebDriver: {
      url: 'http://localhost',
      browser: 'chrome',
      keepCookies: false,
      desiredCapabilities: {
        chromeOptions: {
          args: ["start-maximized"]
        }
      },
      windowSize: "maximize",
      basicAuth: {username: "auto.zcs2@zycus.com", password: "eProc@123"}
    },
    "ChaiWrapper" : 
    {
      "require": "codeceptjs-chai"
    },
    "MyHelper" :
    {
      require: "./helperPackage/MyHelper.js"
    }  
  },
  include: {
    I: './steps_file.js',
    LoginPage: './pages/LoginPage',
    LoginBO: './bo/LoginBO',
    SqlConnection: './sqlConnection/SqlCode',
    ObjectCreation: './objectCreation/ObjectCreation'
  },
  bootstrap: "./helperPackage/presettings.js",
  bootstrapAll: "./helperPackage/presettings.js",
  teardown: "./helperPackage/presettings.js",
  teardownAll: "./helperPackage/presettings.js",
  mocha: {},
  name: 'CodeceptJsPractice',
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
    },
    customLocator: {
      enabled: true,
      attribute: 'id'
    }
  },
  multiple: {
    parallel: {
      // Splits tests into 2 chunks
      chunks: 2
    }
  }
}