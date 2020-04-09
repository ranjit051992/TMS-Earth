const { I } = inject();
const BrandingImpl = require("./BrandingImpl");



Then( "I should see BrandingIcon" , async function () {
   
    I.seeElement(`//span[contains(@class,'icon-wheel ')]`);
});

When("I modify the branding color {string}" ,async function (ff8c00){

    await BrandingImpl.modifyBrandingColor(ff8c00);

});

Then("I should see modified color" , async function (){

    await BrandingImpl.getColorCode ();

});