module.exports={

    createPOButton: "//dew-listing-create//button[@class='btn primary']",
    standardPOButton : "(//dew-modal[@class='show modal fade']//dew-modal-body//button[@class='btn primary'])[1]",
    spinner : "//dew-spinner[@class='dew-spinner']",
    poNumberTextbox : "#purchaseOrderNumber-field",
    poDescriptionTextbox : "#purchaseOrderDescription-field",
    purchaseTypeDropdown : "//dew-select[@id='headerPurchaseType-field']//dew-dropdown-trigger[contains(@class,'select-dropdown')]",
    purchaseTypeValue : "//div[@class='dropdown-item text-truncate text-14']",
    supplierNameTextbox :  "//dew-autocomplete-supplier[@id='supplierId-field']//input",
    supplierAddressTextbox : "//dew-autocomplete-supplier-address//input[@formcontrolname='supplierAddressObj']",
    paymentTermDropdown : "//dew-input-container[@id='paymentTermId-field']//dew-dropdown-trigger[contains(@class,'select')]",
    deliveryTermDropdown : "//dew-input-container[@id='deliveryTermCode-field']//dew-dropdown-trigger[contains(@class,'select')]",
    currencyTextbox : "//dew-input-container[@id='suppCurrency-field']//dew-typeahead//input[@aria-label='Supplier Currency']",
    buyerTextbox : "//div[@formgroupname='buyerInformationForm']//input[@aria-label='Buyer Name']",


}