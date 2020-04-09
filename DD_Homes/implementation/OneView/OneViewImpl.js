const { I } = inject();
const Checkbox = require("dd-cc-zycus-automation/components/checkbox");
const Filter  = require("dd-cc-zycus-automation/components/filter");
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword");
const OneViewObject = require("./OneViewObject");
const DewElement = require("dd-cc-zycus-automation/components/element");

module.exports = {
  /**
     * Navigate to One View
     */
  async navigateOneView() {
    I.seeElement(OneViewObject.oneViewLink)
    CommonKeyword.clickElement(OneViewObject.oneViewLink)
    I.wait(7)
  },

  /**
   * To search and select supplier
   * @param {*} supplierName 
   */
  async searchAndSelectSupplier(supplier) {
    I.seeElement(OneViewObject.oneViewSearchBox)
    I.clearField(OneViewObject.oneViewSearchBox)
    I.fillField(OneViewObject.oneViewSearchBox, supplier)
    const supplierCheckBox = await(DewElement.getDynamicLocator(OneViewObject.oneViewSupplierCheckBox,"<<supplier>>",supplier))
    I.waitForVisible(supplierCheckBox, 10)
    CommonKeyword.clickElement(supplierCheckBox)
    CommonKeyword.clickElement(OneViewObject.oneViewSearchDonebutton)
    I.waitToProcess()
  },


  async searchAndSelectSuppliers(...suppliers) {
    I.seeElement(OneViewObject.oneViewSearchBox)
    suppliers.forEach(async (supplier) => {
      I.clearField(OneViewObject.oneViewSearchBox)
      I.fillField(OneViewObject.oneViewSearchBox, supplier)
      const supplierCheckBox = await(DewElement.getDynamicLocator(OneViewObject.oneViewSupplierCheckBox,"<<supplier>>",supplier))
          I.waitForVisible(supplierCheckBox, 10)
      CommonKeyword.clickElement(supplierCheckBox)
    });
    CommonKeyword.clickElement(OneViewObject.oneViewSearchDonebutton)
    I.waitToProcess()
  },

  async verifySupplierCard(supplier) {
    I.waitToProcess()
    CommonKeyword.clickElement(OneViewObject.oneViewSupplierInfoTab)
    const supplierBasicDetails = await(DewElement.getDynamicLocator(OneViewObject.oneViewSupplierBasicDetails,"<<supplier>>",supplier))
    I.waitForElement(supplierBasicDetails,10)
    I.seeElement(supplierBasicDetails)
  },

  async verifySupplierCards(...suppliers) {
    suppliers.forEach(async (supplier) => {
      I.seeElement(supplierBasicDetails)
    });
  },

  async exportFiles() {
  
    I.scrollIntoView(OneViewObject.oneViewLink)
    I.wait(3);
    
    I.click(OneViewObject.oneViewExportLink);
  },

  async filterSupplier(suppliername)
  {
    Filter.clearAllFilters()
    Filter.applyFilter("Suppliers")
    Checkbox.searchSelect("Suppliers",suppliername)
  //  I.click("//div[@class='modal-content']//span[text()='Apply']")
  }



}