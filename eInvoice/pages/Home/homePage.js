// const I = actor();
const {I} = inject();
module.exports = {
    menuBtn: ".menu-btn",
    //listing: "dew-listing",
    selectModule(productName,moduleName) {
        I.click(this.menuBtn);
        I.wait(2);
        I.click({ css: `[title="${productName}"]` }, "dew-side-menu");
        I.click(locate("span").withText(moduleName));
        I.waitForElement(this.listing, 30);
    }
}
