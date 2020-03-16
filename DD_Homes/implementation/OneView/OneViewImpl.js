const { I } = inject();
const Checkbox = require("dd-cc-zycus-automation/components/checkbox");
const Filter  = require("dd-cc-zycus-automation/components/filter");
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")

module.exports = {
  /**
     * Navigate to One View
     */
  async navigateOneView() {
    I.seeElement(`//span[contains(@class,'nav-link')]//div[text()[normalize-space()='OneView']]`)
    CommonKeyword.clickElement(`//span[contains(@class,'nav-link')]//div[text()[normalize-space()='OneView']]`)
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
    CommonKeyword.clickElement(`//div[contains(@class,'flex-column')]//label[text()='${supplier}']`)
    CommonKeyword.clickElement(`//div[contains(@class,'flex-column')]//div[text()='Done']`)
    I.waitToProcess()
  },


  async searchAndSelectSuppliers(...suppliers) {
    I.seeElement(`//input[@placeholder='Search and select suppliers']`)
    suppliers.forEach(async (supplier) => {
      I.clearField(`//input[@placeholder='Search and select suppliers']`)
      I.fillField(`//input[@placeholder='Search and select suppliers']`, supplier)
      I.waitForVisible(`//div[contains(@class,'flex-column')]//label[text()='${supplier}']`, 10)
      CommonKeyword.clickElement(`//div[contains(@class,'flex-column')]//label[text()='${supplier}']`)
    });
    CommonKeyword.clickElement(`//div[contains(@class,'flex-column')]//div[text()='Done']`)
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
    CommonKeyword.clickElement(`//button[@type='button']/span[contains(@class,'import')]`)

  },

  async filterSupplier(suppliername)
  {
    Filter.clearAllFilters()
    Filter.applyFilter("Suppliers")
    Checkbox.searchSelect("Suppliers",suppliername)
    CommonKeyword.clickElement("//div[@class='modal-content']//span[text()='Apply']")
  }



}