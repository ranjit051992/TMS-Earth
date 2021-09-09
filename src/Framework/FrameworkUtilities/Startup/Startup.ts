export class Startup {
    static confi_prop: Object;
    static configmap: Map<string, string | number | boolean> = new Map();
    static displayName: string;
    static testData: Map<string, string> = new Map();
    static uiElements: Map<string, string> = new Map();
    static users: Map<string, string> = new Map();
    static lmt: Map<string, Map<string, string>> = new Map();
    static allkeys: Map<string, string> = new Map();
    static lang: string;
    static mst_final: any;
    static automationLMT_Pair: any;
    static commonuiElements : Map<string, string> = new Map();
    static defectMap: Map<any, any> = new Map();  
    static finalScenarioLabel_map: Map<any, any> = new Map();
    static email_Test : Map<any, any> = new Map();
}