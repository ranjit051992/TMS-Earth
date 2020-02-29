const { Helper } = codeceptjs;

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

  // add custom methods here
  // If you need to access other helpers
  // use: this.helpers['helperName']
  async clickIfVisible(selector, ...options) {
    const helper = this.helpers["WebDriver"];
    try {
      const numVisible = await helper.grabNumberOfVisibleElements(selector);

      if (numVisible) {
        return helper.click(selector, ...options);
      }
    } catch (err) {
      console.log("Skipping operation as element is not visible");
    }
  }
}

module.exports = MyHelper;
