const { I } = inject();
const Checkbox = require("../../../node_modules/dd-cc-zycus-automation/components/checkbox");
const Filter  = require("../../../node_modules/dd-cc-zycus-automation/components/filter");
module.exports = {
  /**
     * Navigate to One View
     */
  async navigateOneView() {
    I.seeElement(`//span[contains(@class,'nav-link')]//div[text()[normalize-space()='OneView']]`)
    I.click(`//span[contains(@class,'nav-link')]//div[text()[normalize-space()='OneView']]`)
    I.wait(7)
  },

  /**
   * To search and select supplier
   * @param {*} supplierName 
   */
  async searchAndSelectSupplier(supplier) {
    I.seeElement(`//input[@placeholder='Search and select suppliers']`)
    I.clearField(`//input[@placeholder='Search and select suppliers']`)
    I.fillField(`//input[@placeholder='Search and select suppliers']`, supplier)
    I.waitForVisible(`//div[contains(@class,'flex-column')]//label[text()='${supplier}']`, 10)
    I.click(`//div[contains(@class,'flex-column')]//label[text()='${supplier}']`)
    I.click(`//div[contains(@class,'flex-column')]//div[text()='Done']`)
    I.waitToProcess()
  },


  async searchAndSelectSuppliers(...suppliers) {
    I.seeElement(`//input[@placeholder='Search and select suppliers']`)
    suppliers.forEach(async (supplier) => {
      I.clearField(`//input[@placeholder='Search and select suppliers']`)
      I.fillField(`//input[@placeholder='Search and select suppliers']`, supplier)
      I.waitForVisible(`//div[contains(@class,'flex-column')]//label[text()='${supplier}']`, 10)
      I.click(`//div[contains(@class,'flex-column')]//label[text()='${supplier}']`)
    });
    I.click(`//div[contains(@class,'flex-column')]//div[text()='Done']`)
    I.waitToProcess()
  },

  async verifySupplierCard(supplier) {
    I.waitToProcess()
    I.seeElement(`//div[@class='tab-links-wrapper main dew-container']//dew-default-tab-head[text()[normalize-space()='${supplier}']]`)
  },

  async verifySupplierCards(...suppliers) {
    suppliers.forEach(async (supplier) => {
      I.seeElement(`//div[@class='tab-links-wrapper main dew-container']//dew-default-tab-head[text()[normalize-space()='${supplier}']]`)
    });
  },

  async exportFiles() {
    I.click(`//button[@type='button']/span[contains(@class,'import')]`)

  },

  async filterSupplier(suppliername)
  {
    Filter.clearAllFilters()
    Filter.applyFilter("Suppliers")
    Checkbox.searchSelect("Suppliers",suppliername)
    I.click("//div[@class='modal-content']//span[text()='Apply']")
  }



}