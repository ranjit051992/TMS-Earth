
const { I } = inject();
import { Common } from "../../Common/Common";
import { ZA_AccessTabsObj } from "./ZA_AccessTabsObj";
import { z } from "actionbot-wrapper/z";

export class ZA_AccessTabsImpl{

    static async SearchCompany(comp) 
        {
            z.fillField(ZA_AccessTabsObj.CompSearch,comp);
            z.click(ZA_AccessTabsObj.GoBtn); 
        }
    
}

// module.exports = new SearchComp();
// module.exports.SearchComp=SearchComp; // for inheritance

