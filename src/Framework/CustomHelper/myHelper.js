const { Helper } = codeceptjs;
// const client = require("../../Share_data/client");

class MyHelper extends Helper {

  // before/after hooks
  /**
   * @protected
   */
  _before() {
    // remove if not used
  }

  /**
   * @protected
   */
  _after() {
    // remove if not used
  }

  async getCookie(){
    const browser = this.helpers['WebDriver'].browser;
    let SAAS_TOKEN ;
    return new Promise(async function(resolve, reject){
     (await browser.getCookies()).forEach(async function(a)  {
       if(a.name == "SAAS_COMMON_BASE_TOKEN_ID"){
        SAAS_TOKEN = a.value;
        resolve (SAAS_TOKEN);
       }
      });
    })
    
  }
  // add custom methods here
  // If you need to access other helpers
  // use: this.helpers['helperName']
  async clickIfVisible(selector, ...options) {
    const helper = this.helpers['WebDriver'];
    try {
      const numVisible = await helper.grabNumberOfVisibleElements(selector);

      if (numVisible) {
        return helper.click(selector, ...options);
      }
    } catch (err) {
      console.log('Skipping operation as element is not visible');
    }
  }

  async checkIfVisible(selector, ...options) {
    const helper = this.helpers['WebDriver'];
    try {
       if( await helper.grabNumberOfVisibleElements(selector)){
    return true;
       };
        

    } catch (err) {
      console.log(err);
    }
  }
}

module.exports = MyHelper;
