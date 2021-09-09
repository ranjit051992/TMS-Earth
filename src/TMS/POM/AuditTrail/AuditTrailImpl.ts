const { I } = inject();
import { Common } from "../../Common/Common";
//const AuditTrailObj = require("./AuditTrailObj");
import { AuditTrailObj } from "./AuditTrailObj";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";

export class AuditTrailImpl
{

    static async ExportAuditData(){
            await z.click(await TMSLmt.getElement(AuditTrailObj.AuditExportButton));
            await z.click("//input[@id='beforeExportDatepicker']");
            await z.click("//*[@title='Prev']");
            await z.click("//tr[1]/td[7]//a");
            await z.click("//input[@id='afterExportDatepicker']");
            await z.click("//*[@title='Prev']");
            await z.click("//tr[4]/td[7]//a"); 
            await z.click("//input[@id='exportAuditDiv']");  
            await z.see(await TMSLmt.getData("Success_pop_up"));
            await z.click("//button[@role='button']/span[text()='Ok']");  
        }

static async selectValueFromDropDown(dropdownElement: string, selectOption: string)
    {
    // await z.waitForVisible(dropdownElement);
    // await z.waitForClickable(dropdownElement);
    await z.click(dropdownElement);
        if (selectOption !== "undefined") 
        {
            let xpath = `//*[contains(text(),'${selectOption}')]`;
            // let xpath = `//option,'${selectOption}')]`;
            // await z.scrollIntoView(xpath);
            await z.click(xpath);
            // logger.info(`Selected Value from Drop Down: ${selectOption}`);
        }
        else 
        {
            // logger.info("Select Option in null....");
        }
    }
}
//module.exports = new AuditTrailImpl();
//module.exports.AuditTrailImpl=AuditTrailImpl; // for inheritance