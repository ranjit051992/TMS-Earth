const I = actor();
module.exports = {
    menuBtn: ".menu-btn",
    listing: "dew-listing",
    selectModule(moduleName) {
        I.click(this.menuBtn);
        I.wait(2);
        I.click({ css: `[title="eInvoice"]` }, "dew-side-menu");
        I.click(locate("span").withText(moduleName));
        I.waitForElement(this.listing, 30);
    }

}