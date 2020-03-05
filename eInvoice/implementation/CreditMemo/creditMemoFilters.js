const { I } = inject();
const creditMemoHomePage = require("../../pages/CreditMemo/creditMemoHomePage");
const prop = global.confi_prop;

When('I filter credit memo by status', function () {
    creditMemoHomePage.filterByStatus('Returned');
});

Then('I should be able to see the credit memos with the desired status', function () {
    I.waitForElement("dew-listing", prop.DEFAULT_MEDIUM_WAIT);
    I.see('Returned');
});

When('I filter credit memo by credit memo number', function () {
    creditMemoHomePage.filterByCreditMemoNumber('');
});

Then('I should be able to see the credit memo with the desired credit memo number', function () {
    I.waitForElement("dew-listing", prop.DEFAULT_MEDIUM_WAIT);
    I.see('');
});

When('I filter credit memo by supplier', function () {
    creditMemoHomePage.filterBySupplier('ZYCUS INFOTECH');
});

Then('I should be able to see the credit memos with the desired supplier', function () {
    I.waitForElement("dew-listing", prop.DEFAULT_MEDIUM_WAIT);
    I.see('ZYCUS INFOTECH');
});

When('I filter credit memo by reference number', function () {
    creditMemoHomePage.filterByReferenceNumber('SANty_SR');
});

Then('I should be able to see the credit memo with the desired reference number', function () {
    I.waitForElement("dew-listing", prop.DEFAULT_MEDIUM_WAIT);
    I.see('SANty_SR');
});