const { I } = inject();
const commonElements = require("../../pages/Common/commonElements");
const invoiceHomePage = require("../../pages/Invoice/invoiceHomePage");
const addInvoicePage = require("../../pages/Invoice/addInvoicePage");
const createInvoicePage = require("../../pages/Invoice/createInvoicePage");
let NON_PO="NON_PO"
let randomNumber=commonElements.getRandomNumber(5);

Given('I add non po invoice details', function () {
  invoiceHomePage.clickOnAddInvoiceBtn();
  addInvoicePage.selectNonPoInvoice();
  commonElements.selectSupplier(I.getData("SUPPLIER"));
  addInvoicePage.enterInvocieNumber(randomNumber);
  addInvoicePage.selectInvoiceDate();
  commonElements.clickOnNextBtn();
});

Given('I add supplier information', function () {
  commonElements.selectAddress();
  commonElements.selectRemitToAddress();
});

Given('I add basic details', function () {
  createInvoicePage.clickOnBasicDetailsTab();
  commonElements.selectRequester(I.getData("REQUESTER"));
  //createInvoicePage.selectPurchaseType('Test Bug');
});

Given('I add items', function () {
  createInvoicePage.clickOnAddItemsTab();
  commonElements.addItem(I.getData("ITEM_NAME"),I.getData("CATEGORY"),I.getData("QTY_OR_AMT"),I.getData("UOM"),I.getData("PRICE"));
});

Given('I add billing and cost booking details', function () {
  createInvoicePage.clickOnBillingAndCostBookingDetailsTab();
  commonElements.addCBL(I.getData("COMPANY"),I.getData("BUSINESS_UNIT"),I.getData("LOCATION"));
  commonElements.addCostBookingDetails(I.getData("BU"),I.getData("COST_CENTER"),I.getData("PERCENTAGE"));
  createInvoicePage.clickOnAddItemsTab();
  commonElements.selectGLAccount(I.getData("GL_ACCOUNT"))
});

When('I submit the invoice', function () {
  commonElements.clickOnSubmitBtn();
  createInvoicePage.clickOnSendForConfirmationBtn();
});

Then('I should be able to see the created invoice on invoice listing', function () {
  I.waitForElement("dew-listing", 30);
  I.see(randomNumber);
});

Given('I create an invoice', function () {
  createInvoicePage.createInvoice(NON_PO,randomNumber)
});

