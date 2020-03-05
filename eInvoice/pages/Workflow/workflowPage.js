const {I} = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iWorkflow = require("./Iworkflow");

module.exports = {

  searchWorkflow(WFname) {
    I.switchToNextTab()
    I.fillField(I.getElement(iWorkflow.searchWorkflow), WFname);
    I.click(I.getElement(iWorkflow.filterbtn));
    logger.info("Searched workflow :"+WFname);   
  },

  activateWorkflow(WFname) {
    I.moveCursorTo(I.getElement(iWorkflow.workflowhover));
    if(I.seeElement(I.getElement(iWorkflow.deactivatebtn))) {
      I.click(I.getElement(iWorkflow.deactivatebtn))
    } else{
    I.click(I.getElement(iWorkflow.activatebtn));
    }
    logger.info("workflow Activated:"+WFname);
    

  },

  deactivateWorkflow(WFname) {
    I.moveCursorTo(I.getElement(iWorkflow.workflowhover));
    if(I.seeElement(I.getElement(iWorkflow.activatebtn))) {
      I.click(I.getElement(iWorkflow.activatebtn));
    }else{
    I.click(I.getElement(iWorkflow.deactivatebtn));
  }
    logger.info("workflow Deactivated:"+WFname);

  },

  deactivatedWorkflow() {
    I.seeTextEquals('Activate',I.getElement(iWorkflow.deactivatebtn));
    logger.info("workflow is Deactivated");   
  },

  ActivatedWorkflow() {
    I.seeTextEquals('Deactivate',I.getElement(iWorkflow.activatebtn));
    logger.info("workflow is activated");   
  },

}