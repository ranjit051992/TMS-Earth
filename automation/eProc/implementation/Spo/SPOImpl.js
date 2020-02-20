const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iSpoObject = require("./ISPOobject");

function clickOnCreatePOButton()
{
    I.click(iSpoObject.createPOButton);
}

function clickOnStandardPOButton()
{
    I.click(iSpoObject.standardPOButton);
    I.saveScreenshot("CreateSpo.png");
    logger.info("Clicked on create standard po button.");
}

function  fillPONumber(poNumber)
{
    I.fillField(iSpoObject.poNumberTextbox,poNumber);
    logger.info("Filled po number :"+poNumber);

}

function  fillPODescription(poDescription)
{
    I.fillField(iSpoObject.poDescriptionTextbox,poDescription);
    logger.info("Filled po description :"+poDescription);
}

function  clickOnPurchaseTypeDropdown()
{
    I.click(iSpoObject.purchaseTypeDropdown);
}

function  selectPurchaseType(purchaseType)
{
    I.click("//a[contains(text(),'"+purchaseType+"')]");
    logger.info("Selected purchase type :"+purchaseType);
}

function  fillSupplierName(supplierName)
{
    I.fillField(iSpoObject.supplierNameTextbox,supplierName);
}

function  selectSupplierName(supplierName)
{
    I.click("//p[@title='"+supplierName+"']");
    logger.info("Selected supplier name :"+supplierName);
}

function fillSupplierAddress(address)
{
    I.fillField(iSpoObject.supplierAddressTextbox,address);
}

function selectSupplierAddress(address)
{
    I.click("//p[contains(text(),'"+address+"')]");
    logger.info("Selected supplier address :"+address);
}

function clickOnPaymentTermDropdown()
{
    I.click(iSpoObject.paymentTermDropdown);
}

function selectPaymentTerm(paymentTerm)
{
    I.click("//div[contains(@title,'"+paymentTerm+"')]");
    logger.info("Selected payment term :"+paymentTerm);
}

function clickOnDeliveryTermDropdown()
{
    I.click(iSpoObject.deliveryTermDropdown);
}

function selectDeliveryTerm(deliveryTerm)
{
    I.click("//div[contains(@title,'"+deliveryTerm+"')]");
    logger.info("Selected delivery term :"+deliveryTerm);
}

function fillCurrency(currency)
{
    I.fillField(iSpoObject.currencyTextbox,currency);
}

function selectCurrency(currency)
{
    I.click("//span[contains(text(),'"+currency+"')]");
    logger.info("Selected currency :"+currency);
}

function fillBuyer(buyer)
{
    I.fillField(iSpoObject.buyerTextbox,buyer);
}

function selectBuyer(buyer)
{
    I.click("//span[contains(text(),'"+buyer+"')]");
    logger.info("Selected buyer :"+buyer);
}

Given("i am on purchase order listing Page",() => {
   I.amOnPage("https://dewdrops-partner.zycus.com/eproc/#/purchaseorder/default/listing");
});

Given("I Create Standard po",() => {

   clickOnCreatePOButton();
   clickOnStandardPOButton();
   I.waitForInvisible(iSpoObject.spinner,20);
   I.waitForVisible(iSpoObject.poNumberTextbox,20);
   fillPONumber("");
   fillPODescription("");
   clickOnPurchaseTypeDropdown();
   selectPurchaseType("");

   //click on supplier tab

   //I.wait(5);
   fillSupplierName("");
   selectSupplierName("");
   fillSupplierAddress("");
   selectSupplierAddress("");
   clickOnPaymentTermDropdown();
   selectPaymentTerm("");
   clickOnDeliveryTermDropdown();
   selectDeliveryTerm("");
   fillCurrency("");
   selectCurrency("");

   //I.wait(5);

   //click on buyer tab
   fillBuyer("");
   selectBuyer("");
   
   //I.wait(5);

});

async function clickonTab(tabList, tabName)
{
    let tabListName = await I.grabTextFrom(iSPOobject.TAB_NAME_LIST);

    console.log(tabListName);
}

function clickOnCostAllocationTab()
{
    I.seeElement(iSPOobject.COST_ALLOCATION_TAB);
    I.click(iSPOobject.COST_ALLOCATION_TAB);
    logger.info("Clicked on Cost Allocation Tab");
}

function clickOnAssignCostNOButton()
{
    I.seeElement(iSPOobject.ASSIGN_COST_PROJECT_NO_RADIO_BUTTON);
    I.click(iSPOobject.ASSIGN_COST_PROJECT_NO_RADIO_BUTTON);
    logger.info("Clicked on Assign cost Project No Button");
}

function clickOnBookCostToSingle_MultipleCostCenter()
{
    I.seeElement(iSPOobject.BOOK_COST_TO_SINGLE_MULTIPLE_COST_CENTER_RADIO_BUTTON);
    I.click(iSPOobject.BOOK_COST_TO_SINGLE_MULTIPLE_COST_CENTER_RADIO_BUTTON);
    logger.info("Clicked on Book Cost To Single/Multiple Cost center");
}

function enterCostCenter(costCenter)
{
    I.seeElement(iSPOobject.COST_CENTER_INPUT_FIELD);
    I.fillField(iSPOobject.COST_CENTER_INPUT_FIELD, costCenter);
    const xpath = `//div[contains(text(),'${costCenter}')]`;
    I.waitForVisible(xpath, 5);
    I.click(xpath);
    logger.info(`Enter Cost Center: ${costCenter}`);
}

function clickOnAddLineItemButton()
{
    I.seeElement(iSPOobject.ADD_LINE_ITEM_BUTTON);
    I.click(iSPOobject.ADD_LINE_ITEM_BUTTON);
    logger.info("Clicked on Add Line Item Button");
}
function enterItemName(itemName)
{
    I.seeElement(iSPOobject.ITEM_NAME_INPUT);
    I.fillField(iSPOobject.ITEM_NAME_INPUT, itemName);
    logger.info(`Entered item name: ${itemName}`);
}

function selectItemOption(itemName)
{
    I.seeElement(iSPOobject.FIRST_ITEMNAME_OPTION);
    I.click(iSPOobject.FIRST_ITEMNAME_OPTION);
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
    I.seeElement(iSPOobject.GLACCOUNT);
    I.fillField(iSPOobject.GLACCOUNT, glAccount);
    let glAccountSuggXpath = `//div[contains(text(),'${glAccount}')]`;
    I.waitForVisible(glAccountSuggXpath, 5);
    I.click(glAccountSuggXpath);
    logger.info(`Selected GlAccount: ${glAccount}`);
}

function clickOnCostBookingSaveButton()
{
    I.seeElement(iSPOobject.COSTBOOKING_SAVE_BUUTON);
    I.click(iSPOobject.COSTBOOKING_SAVE_BUUTON);
    logger.info("Clicked on Save Button");
}

function clickOnRemoveAllTaxesButton()
{
    I.seeElement(iSPOobject.REMOVE_ALL_TAXES_BUTTON);
    I.click(iSPOobject.REMOVE_ALL_TAXES_BUTTON);
    logger.info("Clicked on Remove All Taxes Button");
}

function clickOnSubmitPOButton()
{
    I.seeElement(iSPOobject.SUBMIT_PO_BUTTON);
    I.click(iSPOobject.SUBMIT_PO_BUTTON);
    logger.info("CLicked on Submit PO Button");
}

function fillNonCoaAtHeaderLevel(spoBO)
{
    if(spoBO.getReqAssignedCost()!=null)
    {
        if(spoBO.getReqAssignedCost() === 'Yes')
        {

        }
        else
        {
            clickOnAssignCostNOButton();
        }
    }

    if(spoBO.isReqBookCostToSingleCostCenter())
    {
        clickOnBookCostToSingle_MultipleCostCenter();
        enterCostCenter(spoBO.getCostCenter());
    }
}
