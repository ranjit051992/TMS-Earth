const I = actor();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iRC = require("./IcreateRecurringContract");

module.exports = {
    
  //Scenario:4
  contractCreation(){
    I.click(I.getElement(iRC.createRecurringContractBtn));
    logger.info("Opens up contract creation page");
  },

  selectSupplier(supplierName){
    I.fillField(I.getElement(iRC.searchSupplier), supplierName);
    I.click(`//dew-col[text()="${supplierName}"]`);
  },

  selectContract(contractName){
    I.fillField(I.getElement(iRC.searchContract), contractName);
  },

  selectContractOwner(contractOwner){
    I.fillField(I.getElement(iRC.searchContractOwner), contractOwner);
    I.click(`//div[contains(text(),"${contractOwner}")]`);
    I.click(I.getElement(iRC.nextBtn));
  },

  contractDetails(autoInvoiceNumber){
    I.click(I.getElement(iRC.contractDetails));
    I.fillField(I.getElement(iRC.searchAutoInvoiceNumber), autoInvoiceNumber);
  },

  releaseSchedule(enter){
    I.fillField(I.getElement(iRC.searchFrequency), enter);
    I.click(I.getElement(iRC.dateSelector));
    I.click(I.getElement(iRC.currentDate));
    I.click(I.getElement(iRC.neverExpires));
  },

  
  //Scenario:11
  viewContract(){
    I.click(I.getElement(iRC.viewRecurringContract));
    I.wait(2);
    I.click(I.getElement(iRC.viewActivity));
    logger.info("View contract details");

      
},

}
  