const { setHeadlessWhen } = require('@codeceptjs/configure');

// turn on headless mode when running with HEADLESS=true environment variable
// HEADLESS=true npx codecept run
setHeadlessWhen(process.env.HEADLESS);

exports.config = {
  tests: './*_test.js',
  output: './output',

  helpers: {
    WebDriver: {
      url: 'http://myapp.com',
      browser: 'chrome',
      host: '127.0.0.1',
      port: 4444,
      windowSize: '1920x1680',
    },
    "ChaiWrapper" : {
      "require": "codeceptjs-chai",
    }
   
  },


  include: {
    I: './steps_file.js',
    loginpages:'./pages/loginPage',
    polistingPages:'./pages/poListingPage',
    dbconnects:'./connection/dbConnection'
  },


  bootstrap: null,
  mocha: {},
  name: 'codecepts',


  plugins: {
    retryFailedStep: {
      enabled: true
    },
    screenshotOnFail: {
      enabled: true 
    },
    wdio:{
        enabled:true,
        services:['selenium-standalone']
    }
  }
}