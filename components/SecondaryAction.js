"use strict";
const { I } = inject();

class SecondaryAction
{
     async clickSecondaryActions(createdEntity,action) {
        I.waitForVisible("//dew-col//dew-row//a[contains(@class,'text-body')]",60);
        let  elementCount= await I.grabNumberOfVisibleElements("//dew-col//dew-row//a[contains(@class,'text-body')]");
        console.log(elementCount);

        
       let rowPosition ;
        for(let num=1; num<=elementCount;num++) {
            let entityname = await I.grabTextFrom("(//dew-col//dew-row//a[contains(@class,'text-body')]/span)["+num+"] | (//dew-col//dew-row//a[contains(@class,'text-body')])["+num+"]");
        if(entityname == createdEntity) {
            rowPosition = num;
            break;

        }
        console.log(entityname);
        }
          I.click("//dew-row[" + rowPosition + "]//dew-col//div//a//dew-btn//button[contains(@class,'btn clear is-fab')]");
          I.wait(10);
          I.click("//div[contains(@class,'d-block actions-menu')]/div/div/a[@title='"+action+"']");
          
    }

    async clickPrimaryActions(createdEntity) {
        I.waitForVisible("//dew-col//dew-row//a[contains(@class,'text-body')]",60);
        let  elementCount= await I.grabNumberOfVisibleElements("//dew-col//dew-row//a[contains(@class,'text-body')]");
        console.log(elementCount);

        
       let rowPosition ;
        for(let num=1; num<=elementCount;num++) {
            let entityname = await I.grabTextFrom("(//dew-col//dew-row//a[contains(@class,'text-body')]/span)["+num+"] | (//dew-col//dew-row//a[contains(@class,'text-body')])["+num+"]");
        if(entityname == createdEntity) {
            rowPosition = num + 1;
            break;

        }
        console.log(entityname);
        }
        I.click("//dew-row["+ rowPosition + "]//div//div//a[contains(@class,'font-weight-medium')]");
        actionname =I.grabTextFrom("//dew-row["+ rowPosition + "]//div//div//a[contains(@class,'font-weight-medium')]");
        console.log(actionname);
    }
}
module.exports = new SecondaryAction();
module.exports.SecondaryAction = SecondaryAction; // for inheritance