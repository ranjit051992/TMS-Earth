const { I } = inject();
const iRC = require("./IcreateRecurringContract");
const rCHomePage = require("./IrecurringContractHome");
const iCommon = require("../../../eInvoice/pages/Common/Icommon");
const commonElements = require("../Common/commonElements");
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");

module.exports = {

//Scenario:1
verifyModule(){
    I.seeElement(I.getElement(iRC.titleName));
    logger.info("Verified Recurring Contract menu is present");   
},

//Scenario:2
CustomizeOption(option) {
    I.click(I.getElement(iRC.customizeFilterIcon));
    I.click(`//label[contains(text(),"${option}")]`);
    logger.info("Customized option :"+option);   
},
    
cliOnApplyBtn(){
    I.click(I.getElement(iRC.applyBtn));
    logger.info("Clicked on Apply button");   
},  


searchInApprovalContract(contractName){
    I.click(I.getElement(iRC.filterIcon));
    I.fillField(I.getElement(iRC.searchContractName), contractName);
    I.click(I.getElement(iRC.filterApplyBtn));
    logger.info("In approval contract selected");
  },

allRequestsRC(){
    I.click(I.getElement(IactionsRC.allRequestRC));
    
},

searchActContract(contractName){
    I.click(I.getElement(iRC.filterIcon));
    I.fillField(I.getElement(iRC.searchContractName), contractName);
    I.click(I.getElement(iRC.filterApplyBtn));
    logger.info("Activated contract selected");
},

approveRecurringContract(){
    I.click(I.getElement(rCHomePage.approveContract));
    I.fillField(I.getElement(rCHomePage.approvalComments), 'Approving recurring contract');
    I.click(I.getElement(rCHomePage.approveContract2));
    logger.info("Approving Recurring Contract");

},

rejectRecurringContract(){
    I.click(I.getElement(rCHomePage.rejectContract));
    I.fillField(I.getElement(rCHomePage.rejectComments), 'Rejecting recurring contract');
    I.click(I.getElement(rCHomePage.rejectContract2));
    logger.info("Rejecting Recurring Contract");

},

deactContract(){
    I.click(I.getElement(iRC.clickActions));
    I.click(I.getElement(iRC.clickDeact));
    I.fillField(I.getElement(iRC.deactivateContract), 'Deactivate the contract');
    //I.fillField('//textarea[@id="reason1"]','Deactivate the contract');
    I.click(I.getElement(iRC.deactivateBtn));
    logger.info("Contract deactivated successfully");
},

searchDeactContract(contractName){
    I.click(I.getElement(iRC.filterIcon));
    I.fillField(I.getElement(iRC.searchContractName), contractName);
    I.click(I.getElement(iRC.filterApplyBtn));
    logger.info("Deactivated contract selected");
},

activateContract(){
    I.click(I.getElement(iRC.clickActivate));
    I.fillField(I.getElement(iRC.deactivateContract), 'Activate the contract');
    I.click(I.getElement(iRC.clickActivate2));
    logger.info("Contract activated successfully");
},

searchRejectedContract(contractName){
    I.click(I.getElement(iRC.filterIcon));
    I.fillField(I.getElement(iRC.searchContractName), contractName);
    I.click(I.getElement(iRC.filterApplyBtn));
    logger.info("Rejected contract selected");
},

editRejectedContract(){
    I.click(I.getElement(rCHomePage.editOption));
    I.click(I.getElement(rCHomePage.contractChangeComments));
    I.fillField(I.getElement(rCHomePage.enterComments), 'Editing done');

},

  

  



}