const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iSpoObject = require("./iSpoObject");
// const spoObj = require("../../dataCreation/ObjectCreation")
const prop=require("../../../Framework/PropertiesConfigurator");


//this.World = require("../../features/support/World.js").World;



// var prop=global.confi_prop;
module.exports={
 clickOnCreatePOButton()
{
    I.click(global.uiElements.get(iSpoObject.createPOButton));
    
},
 clickOnStandardPOButton()
{
    I.click(global.uiElements.get(iSpoObject.standardPOButton));
    I.saveScreenshot("CreateSpo.png");
    logger.info("Clicked on create standard po button.");
},
  fillPONumber(poNumber)
{
    I.fillField(global.uiElements.get(iSpoObject.poNumberTextbox),poNumber);
    logger.info("Filled po number :"+poNumber);
},
async  fetchPONumber()
{
    let poNumber = await I.grabTextFrom(global.uiElements.get(iSpoObject.poNumberTextbox));
    logger.info("Filled po number :"+poNumber[0]);
    return poNumber[0];
},
  fillPODescription(poDescription)
{
    I.fillField(global.uiElements.get(iSpoObject.poDescriptionTextbox),poDescription);
    logger.info("Filled po description :"+poDescription);
},
  clickOnPurchaseTypeDropdown()
{
    I.click(global.uiElements.get(iSpoObject.purchaseTypeDropdown));
},
  selectPurchaseType(purchaseType)
{
    I.click("//a[contains(text(),'"+purchaseType+"')]");
    logger.info("Selected purchase type :"+purchaseType);
},
  fillSupplierName(supplierName)
{
    I.fillField(global.uiElements.get(iSpoObject.supplierNameTextbox),supplierName);
},
  selectSupplierName(supplierName)
{
    I.click("//p[@title='"+supplierName+"']");
    logger.info("Selected supplier name :"+supplierName);
},
 fillSupplierAddress(address)
{
    I.fillField(global.uiElements.get(iSpoObject.supplierAddressTextbox),address);
},
 selectSupplierAddress(address)
{
    I.click("//p[contains(text(),'"+address+"')]");
    logger.info("Selected supplier address :"+address);
},
 clickOnPaymentTermDropdown()
{
    I.click(global.uiElements.get(iSpoObject.paymentTermDropdown));
},
 selectPaymentTerm(paymentTerm)
{
    I.click("//div[contains(@title,'"+paymentTerm+"')]");
    logger.info("Selected payment term :"+paymentTerm);
},
 clickOnDeliveryTermDropdown()
{
    I.click(global.uiElements.get(iSpoObject.deliveryTermDropdown));
},
 selectDeliveryTerm(deliveryTerm)
{
    I.click("//div[contains(@title,'"+deliveryTerm+"')]");
    logger.info("Selected delivery term :"+deliveryTerm);
},
 fillCurrency(currency)
{
    I.fillField(global.uiElements.get(iSpoObject.currencyTextbox),currency);
},
 selectCurrency(currency)
{
    I.click("//span[contains(text(),'"+currency+"')]");
    logger.info("Selected currency :"+currency);
},
 fillBuyer(buyer)
{
    I.fillField(global.uiElements.get(iSpoObject.buyerTextbox),buyer);
},
 selectBuyer(buyer)
{
    I.click("//span[contains(text(),'"+buyer+"')]");
    logger.info("Selected buyer :"+buyer);
},

async  clickonTab(tabList, tabName)
{
    // //let browser = this.helpers.WebDriver;
    // //let tabListEle = browser._locateFields(tabList);
    // let tab;
    // let tabListName = await I.grabTextFrom(tabList);
    // for(tab of tabListName)
    // {
    //     if(tab === tabName)
    //     {
    //        logger.info(tab)
    //        I.see(tab);
    //        I.click("//dew-default-tab-head[contains(text(),'"+tab+"')]");
    //     },
    //     //console.log(tabListName);
    // },
    // logger.info(`Clicked on tab ${tabName},`);
    I.scrollIntoView("//div[contains(text(),'"+tabName+"')]");
},
 clickOnCostAllocationTab()
{
    I.seeElement(global.uiElements.get(iSpoObject.COST_ALLOCATION_TAB));
    I.click(global.uiElements.get(iSpoObject.COST_ALLOCATION_TAB));
    logger.info("Clicked on Cost Allocation Tab");
},
 clickOnAssignCostNOButton()
{
    I.seeElement(global.uiElements.get(iSpoObject.ASSIGN_COST_PROJECT_NO_RADIO_BUTTON));
    I.click(global.uiElements.get(iSpoObject.ASSIGN_COST_PROJECT_NO_RADIO_BUTTON));
    logger.info("Clicked on Assign cost Project No Button");
},
 clickOnBookCostToSingle_MultipleCostCenter()
{
    I.seeElement(global.uiElements.get(iSpoObject.BOOK_COST_TO_SINGLE_MULTIPLE_COST_CENTER_RADIO_BUTTON));
    I.click(global.uiElements.get(iSpoObject.BOOK_COST_TO_SINGLE_MULTIPLE_COST_CENTER_RADIO_BUTTON));
    logger.info("Clicked on Book Cost To Single/Multiple Cost center");
},
 enterCostCenter(costCenter)
{
    I.seeElement(global.uiElements.get(iSpoObject.COST_CENTER_INPUT_FIELD));
    I.fillField(global.uiElements.get(iSpoObject.COST_CENTER_INPUT_FIELD), costCenter);
    const xpath = `//div[contains(text(),'${costCenter}')]`;
    I.waitForVisible(xpath, prop.DEFAULT_MEDIUM_WAIT);
    I.click(xpath);
    logger.info(`Enter Cost Center: ${costCenter}`);
},
 clickOnAddLineItemButton()
{
    I.seeElement(global.uiElements.get(iSpoObject.ADD_LINE_ITEM_BUTTON));
    I.click(global.uiElements.get(iSpoObject.ADD_LINE_ITEM_BUTTON));
    logger.info("Clicked on Add Line Item Button");
},
 enterItemName(itemName)
{
    I.seeElement(global.uiElements.get(iSpoObject.ITEM_NAME_INPUT));
    I.fillField(global.uiElements.get(iSpoObject.ITEM_NAME_INPUT), itemName);
    logger.info(`Entered item name: ${itemName}`);
},
 selectItemOption(itemName)
{
    I.seeElement(global.uiElements.get(iSpoObject.FIRST_ITEMNAME_OPTION));
    I.click(global.uiElements.get(iSpoObject.FIRST_ITEMNAME_OPTION));
    logger.info(`Selected first item option: ${itemName}`);
},
 clickOnCostBookingLink(itemName)
{
    let costBookingLink = `(//span[contains(text(),'${itemName}')]//ancestor::dew-row//following-sibling::dew-row//dew-flex-item[3])`;
    I.seeElement(costBookingLink);
    I.click(costBookingLink);
    logger.info("Clicked on Cost booking Link");
},
 fillGlAccount(glAccount)
{
    I.seeElement(global.uiElements.get(iSpoObject.GLACCOUNT));
    I.fillField(global.uiElements.get(iSpoObject.GLACCOUNT), glAccount);
    let glAccountSuggXpath = `//div[contains(text(),'${glAccount}')]`;
    I.waitForVisible(glAccountSuggXpath, prop.DEFAULT_MEDIUM_WAIT);
    I.click(glAccountSuggXpath);

    logger.info(`Selected GlAccount: ${glAccount}`);
},
 clickOnCostBookingSaveButton()
{
    I.seeElement(global.uiElements.get(iSpoObject.COSTBOOKING_SAVE_BUUTON));
    I.click(global.uiElements.get(iSpoObject.COSTBOOKING_SAVE_BUUTON));
    logger.info("Clicked on Save Button");
},
 clickOnRemoveAllTaxesButton()
{
    I.seeElement(global.uiElements.get(iSpoObject.REMOVE_ALL_TAXES_BUTTON));
    I.click(global.uiElements.get(iSpoObject.REMOVE_ALL_TAXES_BUTTON));
    logger.info("Clicked on Remove All Taxes Button");
},
 clickOnSubmitPOButton()
{
    I.seeElement(global.uiElements.get(iSpoObject.SUBMIT_PO_BUTTON));
    I.click(global.uiElements.get(iSpoObject.SUBMIT_PO_BUTTON));
    logger.info("CLicked on Submit PO Button");
},
 clickOnConfirmButton()
{
    I.seeElement(global.uiElements.get(iSpoObject.CONFIRM_BUTTON));
    I.click(global.uiElements.get(iSpoObject.CONFIRM_BUTTON));
    logger.info("Submitted PO");
},

}


