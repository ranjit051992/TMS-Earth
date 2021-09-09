const { I } = inject();
import { Common } from "../../Common/Common";
import { ProductImpl } from "../../POM/Product/ProductImpl";
import { ProductObj } from "../../POM/Product/ProductObj";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";
import {prop} from "../../../Framework/FrameworkUtilities/config";

var ActGroup = getRandomforProd(3)+ "ActGrp";
var ActName = getRandomforProd(3) + "_act";
var ActName1 = getRandomforProd(3) + "_actnew";

When("Navigate to Product Tab", async function () {
	// Common.clicked(ProductObj.ProdTab);
	await z.click(await TMSLmt.getElement(ProductObj.ProdTab));
});

When("I click on Add new Product",async function () {
	// Common.clicked(ProductObj.AddNewProd);
	await z.click(await TMSLmt.getElement(ProductObj.AddNewProd));
});

When("I fill all Product Information", async function () {
	await ProductImpl.fillProdInfo();
});

When("I click on Save", async function () {
	// Common.clicked(ProductObj.SaveNContinue);
	await z.click(await TMSLmt.getElement(ProductObj.SaveNContinue));
});

When("I add new Activity group", async function () {
	await ProductImpl.addActivityGroup();
});

When("I add newActivitygroup", async function () {
	await ProductImpl.addforproductActivityGroup();
});

When("I add Activity", async function () {
	await ProductImpl.addActivity();
});

When("I click on Done", async function () {
	await z.click(await TMSLmt.getElement(ProductObj.DoneBtn));
});

When("I click on Done at the summary page", async function (){
	await z.click(await TMSLmt.getElement(ProductObj.DoneBtn));
});

Then("product should be able to be assigned to company",async function (){
	z.refreshPage();
	ProductImpl.verifyProdAdded((ProductObj.ComptoEdit).toString());
});

When("I edit the product Created", async function() {
	await ProductImpl.EditProduct();
});

When("I make the required changes", async function() {
	// Common.fillfields(ProductObj.BlackListedBrowser,"Chrome");
	await z.fillField(await TMSLmt.getElement(ProductObj.BlackListedBrowser), "Chrome");
});

When("I click on Done button after editing",async function () {
	await ProductImpl.doneEditing();
});

Then("changes should be reflected",async function () {
	await ProductImpl.VerifyChangesReflected();
});

Then("Navigate to Create Activity page",async function () {
	await z.see(await TMSLmt.getData("ProductNameEdit"));
	await z.click(`//td[text()='0Ru_auto']/following-sibling::td/label`);
	await z.click(`//*[@id="wrapper"]/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/h4/label`);
	//await z.click(`//td[text()='Add Activities']/following-sibling::td/label`);	
});

Then("Create Activity",async function () {
	await z.click(await TMSLmt.getElement(ProductObj.AddNewActivities));
	await z.fillField(await TMSLmt.getElement(ProductObj.ActName),ActName);
	await z.fillField(await TMSLmt.getElement(ProductObj.ActURL),ProductObj.ActURLVal);
	await z.waitForClickable(await TMSLmt.getElement(ProductObj.SaveActBtn));
	await z.click(await TMSLmt.getElement(ProductObj.SaveActBtn));
	await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
	await z.click(await TMSLmt.getElement(ProductObj.PopUpCancel_Act));
	await z.click(await TMSLmt.getElement(ProductObj.DoneBtn));
	await z.click(await TMSLmt.getElement(ProductObj.DoneBtn));
});

	Then("Update Activity",async function () {
	await z.click(`//*[@id="activityGroup-grid"]/tbody/tr[1]/td[6]/label[1]`);
	await z.fillField(await TMSLmt.getElement(ProductObj.EditActName),ActName1);
	await z.fillField(await TMSLmt.getElement(ProductObj.EditActURL),ProductObj.ActURLVal);
	await z.waitForClickable(await TMSLmt.getElement(ProductObj.EditSaveActBtn));
	await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
	await z.click(await TMSLmt.getElement(ProductObj.EditSaveActBtn));
	//await z.click(await TMSLmt.getElement(ProductObj.EditPopUpCancel_Act));
	await z.click(await TMSLmt.getElement(ProductObj.DoneBtn));
});

Then("Check Audit of Activity created by ZA", async function() {
	await z.see(await TMSLmt.getData("Activity_Created"));
	//await z.see("Activity Created");
	await z.see(ActName);
});

Then("Check Audit of update Activity by ZA", async function() {
	await z.see(await TMSLmt.getData("Activity_Updated"));
	//await z.see("Activity Updated");
	await z.see(ActName1);
});

function getRandomforProd(length:number) {
    var result           = '';
    var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    var charactersLength = characters.length;
    for ( var i = 0; i < length; i++ ) {
       result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result+"_auto";
 }