const { I,randomNumber } = inject();
const commonElements = require("../../pages/Common/commonElements");
const invoiceHomePage = require("../../pages/Invoice/invoiceHomePage");
const addInvoicePage = require("../../pages/Invoice/addInvoicePage");
const createInvoicePage = require("../../pages/Invoice/createInvoicePage");

Given('I add non po invoice details', function () {
  invoiceHomePage.clickOnAddInvoiceBtn();
  addInvoicePage.selectNonPoInvoice();
  commonElements.selectSupplier(global.testData.get("SUPPLIER"));
  var randomNumber=commonElements.getRandomNumber(5);
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
  commonElements.selectRequester(global.testData.get("REQUESTER"));
  //createInvoicePage.selectPurchaseType('Test Bug');
});

Given('I add items', function () {
  createInvoicePage.clickOnAddItemsTab();
  commonElements.addItem(global.testData.get("ITEM_NAME"),global.testData.get("CATEGORY"),global.testData.get("QTY_OR_AMT"),global.testData.get("UOM"),global.testData.get("PRICE"));
});

Given('I add billing and cost booking details', function () {
  createInvoicePage.clickOnBillingAndCostBookingDetailsTab();
  commonElements.addCBL(global.testData.get("COMPANY"),global.testData.get("BUSINESS_UNIT"),global.testData.get("LOCATION"));
  commonElements.addCostBookingDetails(global.testData.get("BU"),global.testData.get("COST_CENTER"),global.testData.get("PERCENTAGE"));
  createInvoicePage.clickOnAddItemsTab();
  commonElements.selectGLAccount(global.testData.get("GL_ACCOUNT"))
});

When('I submit the invoice', function () {
  commonElements.clickOnSubmitBtn();
  createInvoicePage.clickOnSendForConfirmationBtn();
});

Then('I should be able to see the created invoice on invoice listing', function () {
  I.waitForElement("dew-listing", 30);
  I.see(randomNumber);
});