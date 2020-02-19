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
