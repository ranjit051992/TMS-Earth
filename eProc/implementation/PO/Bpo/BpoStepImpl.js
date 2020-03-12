const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const iSpoObject = require("../Spo/SpoObject");
const objectCreation = require("../../../dataCreation/ObjectCreation")
const prop = global.confi_prop;
const spoImpl = require("../Spo/SpoImpl");
const catalogItem = require("../../../dataCreation/bo/CatalogItem");
const commonKeywordImpl = require("../../../commonKeywords/CommonComponent");
const poListingImpl = require("../PoListing/PoListingImpl");
const poListingObject = require("../PoListing/PoListingObject");
const coaImpl = require("../../Coa/CoaImpl");
const iBpoObject = require("./BpoObject");
const bpoImpl =require("./BpoImpl");

Given("I am on PO listing page", async function () {
    await poListingImpl.navigateToPoListing();
 });
 
 Given("I Create Blanket po with {int} {string} item", async function (noOfItems, itemType) {
    this.bpo = await objectCreation.getObjectOfBlanketPO(noOfItems, itemType);
    //this.spo.poNumber = "Automation_Spo_1583163241883";
    this.bpo = await bpoImpl.createBpoFlow(this.bpo);
 });

 When("I add attachment at header level", async function(){
      await bpoImpl.addAttachment(this.bpo.attachmentPath);
 });

 Then("I should be able to see the BPO in Cancelled status", async function(){

 });