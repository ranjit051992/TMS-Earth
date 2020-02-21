const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iSpoObject = require("./iSpoObject");
const spoObj = require("../../dataCreation/ObjectCreation")
const prop=require("../../../Framework/PropertiesConfigurator");


function clickOnCreatePOButton()
{
    I.click(global.uiElements.get(iSpoObject.createPOButton));
}
function clickOnStandardPOButton()
{
    I.click(global.uiElements.get(iSpoObject.standardPOButton));
    I.saveScreenshot("CreateSpo.png");
    logger.info("Clicked on create standard po button.");
}
function  fillPONumber(poNumber)
{
    I.fillField(global.uiElements.get(iSpoObject.poNumberTextbox),poNumber);
    logger.info("Filled po number :"+poNumber);
}
async function fetchPONumber()
{
    let poNumber = await I.grabTextFrom(global.uiElements.get(iSpoObject.poNumberTextbox));
    logger.info("Filled po number :"+poNumber[0]);
    return poNumber[0];
}
function  fillPODescription(poDescription)
{
    I.fillField(global.uiElements.get(iSpoObject.poDescriptionTextbox),poDescription);
    logger.info("Filled po description :"+poDescription);
}
function  clickOnPurchaseTypeDropdown()
{
    I.click(global.uiElements.get(iSpoObject.purchaseTypeDropdown));
}
function  selectPurchaseType(purchaseType)
{
    I.click("//a[contains(text(),'"+purchaseType+"')]");
    logger.info("Selected purchase type :"+purchaseType);
}
function  fillSupplierName(supplierName)
{
    I.fillField(global.uiElements.get(iSpoObject.supplierNameTextbox),supplierName);
}
function  selectSupplierName(supplierName)
{
    I.click("//p[@title='"+supplierName+"']");
    logger.info("Selected supplier name :"+supplierName);
}
function fillSupplierAddress(address)
{
    I.fillField(global.uiElements.get(iSpoObject.supplierAddressTextbox),address);
}
function selectSupplierAddress(address)
{
    I.click("//p[contains(text(),'"+address+"')]");
    logger.info("Selected supplier address :"+address);
}
function clickOnPaymentTermDropdown()
{
    I.click(global.uiElements.get(iSpoObject.paymentTermDropdown));
}
function selectPaymentTerm(paymentTerm)
{
    I.click("//div[contains(@title,'"+paymentTerm+"')]");
    logger.info("Selected payment term :"+paymentTerm);
}
function clickOnDeliveryTermDropdown()
{
    I.click(global.uiElements.get(iSpoObject.deliveryTermDropdown));
}
function selectDeliveryTerm(deliveryTerm)
{
    I.click("//div[contains(@title,'"+deliveryTerm+"')]");
    logger.info("Selected delivery term :"+deliveryTerm);
}
function fillCurrency(currency)
{
    I.fillField(global.uiElements.get(iSpoObject.currencyTextbox),currency);
}
function selectCurrency(currency)
{
    I.click("//span[contains(text(),'"+currency+"')]");
    logger.info("Selected currency :"+currency);
}
function fillBuyer(buyer)
{
    I.fillField(global.uiElements.get(iSpoObject.buyerTextbox),buyer);
}
function selectBuyer(buyer)
{
    I.click("//span[contains(text(),'"+buyer+"')]");
    logger.info("Selected buyer :"+buyer);
}
Given("i am on purchase order listing Page",() => {
    //clickonTab();
    I.amOnPage(prop.poListingUrl)
   I.waitForInvisible(global.uiElements.get(iSpoObject.spinner),prop.DEFAULT_MEDIUM_WAIT);
});
When("I Create Standard po",() => {
    const spo = spoObj.getObjectOfStandardPO(1,"catalog");
   clickOnCreatePOButton();
   clickOnStandardPOButton();
   I.waitForInvisible(global.uiElements.get(iSpoObject.spinner),prop.DEFAULT_MEDIUM_WAIT);
   I.waitForVisible(global.uiElements.get(iSpoObject.poNumberTextbox),prop.DEFAULT_MEDIUM_WAIT);
   //fillPONumber(spoObj.getPoNumber);
   let poNumber = fetchPONumber();
   spo.setPoNumber(poNumber);
   fillPODescription(spo.getPoDescription());
   clickOnPurchaseTypeDropdown();
   selectPurchaseType(spo.getPurchaseType());
   clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST),"Supplier Details");
   fillSupplierName(spo.getSupplierName());
   selectSupplierName(spo.getSupplierName());
   fillSupplierAddress(spo.getSupplierAddress());
   selectSupplierAddress(spo.getSupplierAddress());
   clickOnPaymentTermDropdown();
   selectPaymentTerm(spo.getPaymentTerm());
   clickOnDeliveryTermDropdown();
   selectDeliveryTerm(spo.getDeliveryTerm());
   fillCurrency(spo.getCurrency());
   selectCurrency(spo.getCurrency());
   clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST),"MST_Buyerandotherinformation");
   fillBuyer(spo.getBuyer());
   selectBuyer(spo.getBuyer());
   
   
    //click on cost Allocation tab
    clickOnCostAllocationTab();
    clickOnAssignCostNOButton();
   clickOnBookCostToSingle_MultipleCostCenter();
   enterCostCenter(spo.getCostCenter());
  // fillNonCoaAtHeaderLevel(spo);
    clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST),"Line Items")
    clickOnAddLineItemButton()
    enterItemName(spo.getItemName());
    selectItemOption(spo.getItemName());
    clickOnCostBookingLink(spo.getItemName());
    fillGlAccount(spo.getGlAccount());
    clickOnCostBookingSaveButton();
    clickonTab(global.uiElements.get(iSpoObject.TAB_NAME_LIST),"Taxes");
    clickOnRemoveAllTaxesButton();
    clickOnSubmitPOButton();
    clickOnConfirmButton();
    I.waitForInvisible(global.uiElements.get(iSpoObject.spinner),prop.DEFAULT_HIGH_WAIT);
    
});
async function clickonTab(tabList, tabName)
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
    //     }
    //     //console.log(tabListName);
    // }
    // logger.info(`Clicked on tab ${tabName}`);
    I.scrollIntoView("//div[contains(text(),'"+tabName+"')]");
}
function clickOnCostAllocationTab()
{
    I.seeElement(global.uiElements.get(iSpoObject.COST_ALLOCATION_TAB));
    I.click(global.uiElements.get(iSpoObject.COST_ALLOCATION_TAB));
    logger.info("Clicked on Cost Allocation Tab");
}
function clickOnAssignCostNOButton()
{
    I.seeElement(global.uiElements.get(iSpoObject.ASSIGN_COST_PROJECT_NO_RADIO_BUTTON));
    I.click(global.uiElements.get(iSpoObject.ASSIGN_COST_PROJECT_NO_RADIO_BUTTON));
    logger.info("Clicked on Assign cost Project No Button");
}
function clickOnBookCostToSingle_MultipleCostCenter()
{
    I.seeElement(global.uiElements.get(iSpoObject.BOOK_COST_TO_SINGLE_MULTIPLE_COST_CENTER_RADIO_BUTTON));
    I.click(global.uiElements.get(iSpoObject.BOOK_COST_TO_SINGLE_MULTIPLE_COST_CENTER_RADIO_BUTTON));
    logger.info("Clicked on Book Cost To Single/Multiple Cost center");
}
function enterCostCenter(costCenter)
{
    I.seeElement(global.uiElements.get(iSpoObject.COST_CENTER_INPUT_FIELD));
    I.fillField(global.uiElements.get(iSpoObject.COST_CENTER_INPUT_FIELD), costCenter);
    const xpath = `//div[contains(text(),'${costCenter}')]`;
    I.waitForVisible(xpath, prop.DEFAULT_MEDIUM_WAIT);
    I.click(xpath);
    logger.info(`Enter Cost Center: ${costCenter}`);
}
function clickOnAddLineItemButton()
{
    I.seeElement(global.uiElements.get(iSpoObject.ADD_LINE_ITEM_BUTTON));
    I.click(global.uiElements.get(iSpoObject.ADD_LINE_ITEM_BUTTON));
    logger.info("Clicked on Add Line Item Button");
}
function enterItemName(itemName)
{
    I.seeElement(global.uiElements.get(iSpoObject.ITEM_NAME_INPUT));
    I.fillField(global.uiElements.get(iSpoObject.ITEM_NAME_INPUT), itemName);
    logger.info(`Entered item name: ${itemName}`);
}
function selectItemOption(itemName)
{
    I.seeElement(global.uiElements.get(iSpoObject.FIRST_ITEMNAME_OPTION));
    I.click(global.uiElements.get(iSpoObject.FIRST_ITEMNAME_OPTION));
    logger.info(`Selected first item option: ${itemName}`);
}
function clickOnCostBookingLink(itemName)
{
    let costBookingLink = `(//span[contains(text(),'${itemName}')]//ancestor::dew-row//following-sibling::dew-row//dew-flex-item[3])`;
    I.seeElement(costBookingLink);
    I.click(costBookingLink);
    logger.info("Clicked on Cost booking Link");
}
function fillGlAccount(glAccount)
{
    I.seeElement(global.uiElements.get(iSpoObject.GLACCOUNT));
    I.fillField(global.uiElements.get(iSpoObject.GLACCOUNT), glAccount);
    let glAccountSuggXpath = `//div[contains(text(),'${glAccount}')]`;
    I.waitForVisible(glAccountSuggXpath, prop.DEFAULT_MEDIUM_WAIT);
    I.click(glAccountSuggXpath);
    logger.info(`Selected GlAccount: ${glAccount}`);
}
function clickOnCostBookingSaveButton()
{
    I.seeElement(global.uiElements.get(iSpoObject.COSTBOOKING_SAVE_BUUTON));
    I.click(global.uiElements.get(iSpoObject.COSTBOOKING_SAVE_BUUTON));
    logger.info("Clicked on Save Button");
}
function clickOnRemoveAllTaxesButton()
{
    I.seeElement(global.uiElements.get(iSpoObject.REMOVE_ALL_TAXES_BUTTON));
    I.click(global.uiElements.get(iSpoObject.REMOVE_ALL_TAXES_BUTTON));
    logger.info("Clicked on Remove All Taxes Button");
}
function clickOnSubmitPOButton()
{
    I.seeElement(global.uiElements.get(iSpoObject.SUBMIT_PO_BUTTON));
    I.click(global.uiElements.get(iSpoObject.SUBMIT_PO_BUTTON));
    logger.info("CLicked on Submit PO Button");
}
function clickOnConfirmButton()
{
    I.seeElement(global.uiElements.get(iSpoObject.CONFIRM_BUTTON));
    I.click(global.uiElements.get(iSpoObject.CONFIRM_BUTTON));
    logger.info("Submitted PO");
}
// function fillNonCoaAtHeaderLevel(spoBO)
// {
//     if(spoBO.getAssignCostProject()!=null)
//     {
//         if(spoBO.getAssignCostProject() === 'Yes')
//         {
//         }
//         else
//         {
//             clickOnAssignCostNOButton();
//         }
//     }
//     if(spoBO.getBookCostAtLineItemLevel()=="Yes")
//     {
//         clickOnBookCostToSingle_MultipleCostCenter();
//         enterCostCenter(spoBO.getCostCenter());
//     }
// }
// Then("spo should be created",() => {
//     I.scrollIntoView(global.uiElements.get(iSpoObject.VIEW_BASIC_DETAILS_SECTION));
//     I.wait(2);
//     I.seeElement(global.uiElements.get(iSpoObject.VIEW_BASIC_DETAILS_SECTION));
//     I.assertEqual(true, 1);
//     pause();
// }