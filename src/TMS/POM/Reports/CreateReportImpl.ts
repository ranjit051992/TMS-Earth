const { I } = inject();
import { Common } from "../../Common/Common";
import { logger } from "../../../Framework/FrameworkUtilities/Logger/logger";
import { CreateReportObj } from "../../POM/Reports/CreateReportObj";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";

export class CreateReportImpl{

    static async FillReportDetailsStep3(){
    // I.click(CreateReportObj.S3Prod);
    // I.click(CreateReportObj.S3Company);
    // I.click(CreateReportObj.S3DomainUrl);
    // I.click(CreateReportObj.S3Manager);
    // I.click(CreateReportObj.S3UEmailId);
    // I.click(CreateReportObj.S3UserUniqueId);
    await z.click(await TMSLmt.getElement(CreateReportObj.S3Prod));
    await z.click(await TMSLmt.getElement(CreateReportObj.S3Company));
    await z.click(await TMSLmt.getElement(CreateReportObj.S3DomainUrl));
    await z.click(await TMSLmt.getElement(CreateReportObj.S3Manager));
    await z.click(await TMSLmt.getElement(CreateReportObj.S3UEmailId));
    await z.click(await TMSLmt.getElement(CreateReportObj.S3UserUniqueId));
    }

    static async FillReportDetailsStep6(){
        await z.fillField(await TMSLmt.getElement(CreateReportObj.S6StartDate), await TMSLmt.getData("StartDate"));
        await z.fillField(await TMSLmt.getElement(CreateReportObj.S6EndDate), await TMSLmt.getData("EndDate"));

    }

}

// module.exports = new verify();
// module.exports.verify=verify; // for inheritance