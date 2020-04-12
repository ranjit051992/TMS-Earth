const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")

module.exports = {

async verifyBrandingIcon()  {

    I.waitForVisible(`//span[contains(@class,'icon-wheel ')]`);

    I.seeElement(`//span[contains(@class,'icon-wheel ')]`);

},
async modifyBrandingColor (hexcode)   {

CommonKeyword.clickElement(`//span[contains(@class,'icon-wheel ')]`);

CommonKeyword.clickElement(`//div[contains(text(),'Reset to Default')]`);
CommonKeyword.clickElement(`//span[contains(@class,'icon-wheel ')]`);
 CommonKeyword.clickElement(`//div[@class='customizeBox']/dew-row/dew-col[2]/input`);
 I.clearField(`//div[@class='customizeBox']/dew-row/dew-col[2]/input`)
 I.fillField(`//div[@class='customizeBox']/dew-row/dew-col[2]/input`,hexcode);
 I.wait(3);
 I.click(`//div[contains(text(),'Apply')]`);
 I.waitForInvisible(`//div[contains(text(),'Apply')]`);
 
},

async getColorCode () {
    let colorcode = "background-image: linear-gradient(256deg, rgb(255, 140, 0), rgb(255, 140, 0) 20%);";
    console.log(colorcode+"-------------------------->");
I.scrollIntoView(`//dew-spotlight`);
 let rgbcode = await I.grabAttributeFrom(`dew-spotlight`,'style')
console.log(rgbcode);
     let value = rgbcode.includes(colorcode)
     console.log(value+"*************************************************************");
     if(value===true){
        console.log("true  --------------->")
    
         
        
     }else{false}


}



}