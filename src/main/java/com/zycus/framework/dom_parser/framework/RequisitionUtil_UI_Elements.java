package com.zycus.framework.dom_parser.framework;

import org.openqa.selenium.By;

public interface RequisitionUtil_UI_Elements
{

	/********************************************************************************************************************/
	// @ANKITA

	// PreRequisite
	String	mapping													= "Mapping";
	String	pass													= "pass";
	String	fail													= "fail";
	String	reg														= "Regression TC";
	String	getBasketResult											= "getBasketResult";
	String	getBasketName											= "getBasketName";
	String	getCFormName											= "getCFormName";
	String	getSectionName											= "getSectionName";
	String	getFieldLabelName										= "getFieldLabelName";

	By		userName												= By.xpath(".//*[@id='newMainNav']/li[2]");
	By		userNameField											= By.xpath(".//*[@id='userInfoList']/tbody/tr/td[1]");

	// Sanity TesTCase
	By		requisition_top											= By.id("requisition_top");
	By		requisition_sub											= By.id("requisition_sub");
	By		my_requisition_sub										= By.id("my_requisition_sub");
	By		my_favourites_sub										= By.id("my_favourites_sub");
	By		baskets_sub												= By.id("baskets_sub");
	By		workflow_approval_top									= By.id("workflow_approval_top");
	By		workflow_approval_sub									= By.id("workflow_approval_sub");
	By		all_requests_sub										= By.id("all_requests_sub");
	By		my_settings_sub											= By.id("my_settings_sub");
	By		buyer_desk_top											= By.id("buyer_desk_top");
	By		buyer_desk_sub											= By.id("buyer_desk_sub");
	By		upcoming_requisition_sub								= By.id("upcoming_requisition_sub");
	By		po_top													= By.id("po_top");
	By		invoice_top												= By.id("invoice_top");
	By		invoices_sub											= By.id("invoices_sub");
	By		received_sub											= By.id("received_sub");
	By		payment_top												= By.id("payment_top");
	By		batches_sub												= By.id("batches_sub");
	By		reports_top												= By.id("reports_top");
	By		pcard_top												= By.id("pcard_top");
	By		setup_sub												= By.id("setup_sub");
	By		master_data_sub											= By.id("master_data_sub");
	By		returnToSetup											= By.id("returnToSetup");
	By		setup_top												= By.id("setup_top");
	By		customize_sub											= By.id("customize_sub");
	By		suppliers_top											= By.id("suppliers_top");
	By		supplier_onboarding_sub									= By.id("supplier_onboarding_sub");
	By		catalog_top												= By.id("catalog_top");
	By		catalog_sub												= By.id("catalog_sub");
	By		punchout_sub											= By.id("punchout_sub");
	By		workflow_top											= By.id("workflow_top");
	By		budget_top												= By.id("budget_top");
	By		saveCartAsBasket_link									= By.cssSelector(".scLnk.saveCartAsBasket.cart_save_basket");
	// By duplicateBasketError = By.cssSelector(".frmMsg.vError");
	By		duplicateBasketError									= By.xpath(".//*[@id='frmAddItemToBasket']/div[1]/div[1]/fieldset/ol/li[2]/div[2]");
	By		moreLinksTab											= By.xpath(".//*[@id='tab-more-blck']/a");

	By		customizeButton											= By.xpath(".//a[contains(@href, 'customize')][contains(@class,'b-button')]");
	By		costBookingLink											= By.xpath(".//*[@id='wrapper']/div[2]/div/div[2]/div/div[1]/div/div/a[11]");

	// Customize DATA
	By		setupLogout												= By.cssSelector("a[title='Logout']");
	By		reqSettingLink											= By.xpath(".//a[contains(@href,'getReqConfig')]");
	By		forkedReqSettingYes										= By.id("dev_forking_yes");
	By		poLink													= By.xpath(".//a[contains(@href,'getTenantPOConfig')]");

	/* numbering */
	By		reqNo_format											= By.id("EPROC_REQUISITION_FORMAT");
	By		reqSequenceNo_startsAt									= By.id("EPROC_REQUISITION_SEQUENCE_NO");
	By		reqSequenceNo_endsAt									= By.id("EPROC_REQUISITION_MAX_SEQUENCE_NO");
	By		reqName_format											= By.id("EPROC_REQUISITION_NAME");

	/* Display */
	By		frequntlySearchedItem									= By.id("EPROC_REQUISITION_SEARCH_TERMS");

	/* control */
	By		reqItemQuantityThreshold								= By.id("EPROC_REQUISITION_ITEM_QUANTITY_THRESHOLD");
	By		freeTextItems_Always									= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_ALLOW_REQUESTERS_TO_ORDER_FREE_TEXT_ITEMS'][@value='ALWAYS']");
	By		freeTextItems_Never										= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_ALLOW_REQUESTERS_TO_ORDER_FREE_TEXT_ITEMS'][@value='NEVER']");
	By		freeTextItems_PermissionBased							= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_ALLOW_REQUESTERS_TO_ORDER_FREE_TEXT_ITEMS'][@value='PERMISSION']");

	By		freeTextItem_withoutCategory_Yes						= By.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_GUIDED_WITHOUT_CATEGORY'][@value='true']");
	By		freeTextItem_withoutCategory_No							= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_GUIDED_WITHOUT_CATEGORY'][@value='false']");

	By		withoutRequiredByDate_Yes								= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_ALLOW_WITHOUT_REQUIRED_BY'][@value='true']");
	By		withoutRequiredByDate_No								= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_ALLOW_WITHOUT_REQUIRED_BY'][@value='false']");

	By		allowBuyerToModifyRequiredByDate_Yes					= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_ALLOW_BUYER_TO_MODIFY_REQUIRED_BY'][@value='true']");
	By		allowBuyerToModifyRequiredByDate_No						= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_ALLOW_BUYER_TO_MODIFY_REQUIRED_BY'][@value='false']");

	By		costCenterInfo_Yes										= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_CHECKOUT_REQUIRED_COSTING'][@value='false']");
	By		costCenterInfo_No										= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_CHECKOUT_REQUIRED_COSTING'][@value='true']");

	By		displayAccountingInfo_Yes								= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_CHECKOUT_SHOW_ACCOUNTING'][@value='true']");
	By		displayAccountingInfo_No								= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_CHECKOUT_SHOW_ACCOUNTING'][@value='false']");

	By		requiredAccountingInfo_Yes								= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_CHECKOUT_REQUIRED_ACCOUNTING'][@value='true']");
	By		requiredAccountingInfo_No								= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_CHECKOUT_REQUIRED_ACCOUNTING'][@value='false']");

	By		req_punchout_item_category_warning						= By.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_PUNCHOUT_ITEM_CATEGORY'][@value='false']");
	By		req_punchout_item_category_block						= By.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_PUNCHOUT_ITEM_CATEGORY'][@value='true']");

	By		req_punchout_copyPrevention_warning						= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_PUNCHOUT_COPY_PREVENTION'][@value='false']");
	By		req_punchout_copyPrevention_block						= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_PUNCHOUT_COPY_PREVENTION'][@value='true']");

	By		allow_override_GLAccount_Yes							= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_ALLOW_OVERRIDE_GL_ACCOUNT'][@value='true']");
	By		allow_override_GLAccount_No								= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_ALLOW_OVERRIDE_GL_ACCOUNT'][@value='false']");

	/* Auto fork req */
	By		categoryBasedWorkflow_Yes								= By.id("dev_catWorkflow_yes");
	By		categoryBasedWorkflow_No								= By.id("dev_catWorkflow_no");

	By		reqForking_Yes											= By.id("dev_forking_yes");
	By		reqForking_No											= By.id("dev_forking_no");

	By		forkingCriteria_priceType								= By
		.xpath(".//*[@id='frmEmailTemplate']//*[@name='EPROC_REQUISITION_FORKING_CRITERIA[]'][@value='BY_PRICE_TYPE']");

	// Cost booking
	By		allowBudgetUtilization_Yes								= By.xpath(".//*[@id='frmEmailTemplate']//ol/li[1]/div[1]/label[1]/input");
	By		allowBudgetUtilization_No								= By.xpath(".//*[@id='frmEmailTemplate']//li[1]/div[1]/label[2]/input");
	By		dispProcessing											= By.className("dispProcessing");

	// User management

	By		users													= By.xpath(".//*[@id='Users']/a");
	By		searchText												= By.cssSelector(".srchTxt");
	By		searchBy												= By.cssSelector(".dev_dataTableFilter");
	By		searchGo												= By.cssSelector(".btn");
	By		userInfoList_processing									= By.id("userInfoList_processing");

	By		editButton												= By.cssSelector(".icon.edit.scLnk.genForm");

	By		emailId													= By.id("txtUserEmailSpn");
	By		firstName												= By.id("firstName");
	By		displayName												= By.id("txtUserName");
	By		selectDepartment										= By.id("selectDepartment");
	By		selectCompany											= By.id("selectCompany");
	By		selectLocation											= By.id("selectLocation");
	By		purchasingScope											= By.id("purchasingScope");
	By		deliveryScope											= By.id("selectDeliveryScope");
	By		purchasingLimit											= By.id("txtSpendLimit");
	By		locale													= By.id("txtLocale");
	By		timeZone												= By.id("txtTimeZone");
	By		numberFormat											= By.id("txtNumberFormat");
	By		contolCurrency											= By.id("txtControlCurrency");
	By		salutation												= By.id("salutation");
	By		lastName												= By.id("lastName");
	By		reportingManager										= By.id("txtReportingManager");
	By		designation												= By.id("selectDesignation");
	By		businessUnit											= By.id("selectBusinessUnit");
	By		costCenter												= By.id("selectCostCenter");
	By		behalfScope												= By.id("selectBehalfScope");
	By		approvalLimit											= By.id("txtApprovalLimit");
	By		userCurrency											= By.id("txtUserCurrency");
	By		dateFormat												= By.id("txtDateFormat");
	By		decimalPlace											= By.id("txtDecimalPlace");

	By		addressesLink_MasterData								= By.xpath(".//*[@id='Addresses']/a");
	By		addressHeader_MasterData								= By.xpath(".//*[@id='addressListing']/tbody/tr/td[2]");
	By		deactivateAddressLink									= By.xpath(".//*[@id='addressListing']/tbody/tr/td[7]/a");
	/*
	 * //Constant Data String mapping = "Mapping"; String pass = "pass"; String
	 * fail = "fail"; String reg = "Regression TC";
	 */
	By		ok_button												= By.xpath(".//div[contains(@class,'ui-dialog-buttonpane ui-widget-content ui-helper-clearfix')]/div/button");
	// By userName = By.xpath(".//*[@id='newMainNav']/li[2]");
	By		deliverToHeader											= By.id("deliverTo_header");
	By		alert_Message											= By.className("tblcellmsg");

	By		searchBox												= By.id("searchTerm");
	By		searchButton											= By.id("btnBigSearch");
	By		itemNames												= By.cssSelector("a.itmName.itemName.scLnk.highlightTerm");
	By		secondItem												= By.xpath("(.//a[@class='itmName itemName scLnk highlightTerm'])[2]");
	// By gridView = By.cssSelector("a.swtch.swtchGrid");
	By		gridView												= By.xpath(".//*[@id='cntSearchItemToolbar']/a[1]");
	By		itemSearchProcessing									= By.id("tblSearchItemList_processing");
	By		totalItemsFound											= By.id("totalItemsFound");
	By		totalPunchouts											= By.cssSelector(".totalPunchouts");
	By		ancestorTr												= By.xpath("ancestor::tr");
	By		inputQuantity											= By.cssSelector("input.inptTxt.itemQuantity.txtItmQty.quantity");
	By		addToCartButton											= By.cssSelector("a.b-button.b-primary.aTCrtLnk.aToCart.addToCart");
	By		cartView												= By.cssSelector("span.cart-items.scLnk.cart_view");
	By		totalNoOfPages											= By.cssSelector(".text.nOf>label");
	By		nextPageButton											= By.id("tblSearchItemList_next");
	By		lastPageButton											= By.id("tblSearchItemList_last");
	By		previousPageButton										= By.id("tblSearchItemList_previous");
	By		firstPageButton											= By.id("tblSearchItemList_first");
	By		currentPageNo_button									= By.cssSelector(".textBox>input");
	By		dataTablesEmpty											= By.cssSelector(".dataTables_empty");
	By		totalItemsInCart										= By.cssSelector("span.bld.cart_items");
	By		deleteYes												= By.cssSelector("button.pri.ui-button.ui-widget.ui-state-default.ui-corner-all.ui-button-text-only");
	By		continueShopping										= By.xpath(".//div[@class='primaryButton doContinueShopping cart_continue']/input");
	By		emptyCart												= By.cssSelector("a.scLnk.icon.delete.cart_clear");
	By		addedItemNames											= By.cssSelector("a.showItemDetails");
	By		addedItemQuantity										= By.cssSelector("input.txtQty.itemQuantity.inptTxt");
	By		continueShoppingNonEmptyCart							= By.xpath(".//*[@id='cart_itemsContainer']/div[3]/div/a");
	By		checkOutNonEmptyCart									= By.cssSelector(".primaryButton.doCheckout.cart_checkout>input");
	By		addToFavoriteLink										= By.id("lnkAddMultipleToFavorite");

	By		sucessMessage											= By.id("hedaerSuccessBox");
	By		totatlItems_inCart										= By.cssSelector(".bld.cart_items");
	By		itemCheckBox											= By.xpath(".//input[contains(@id,'chk_item_list_')]");
	By		addToBasketLink											= By.id("lnkAddMultipleToBasket");
	By		itemQuantity											= By.xpath(".//input[contains(@id,'quantity_list_')]");
	By		compareItems											= By.xpath(".//*[@id='lnkCompareItems']/span");
	By		availabilityLabel										= By.cssSelector(".lbl.availability");
	By		sortByLink												= By.id("lnkSortBy");
	By		sortLeadTimeLowToHigh									= By.xpath(".//*[@id='cntSortBy']/div/div/a[5]");
	By		sortLeadTimeHighToLow									= By.xpath(".//*[@id='cntSortBy']/div/div/a[6]");

	// product comparison page
	By		productComparisonHeader									= By.xpath(".//*[@id='compareItems']/div[1]/h2");
	By		specificationRow										= By.xpath(".//*[@id='compareItemsGrid']/tbody/tr[6]/td[1]");
	By		comparedItemNameFirst									= By.xpath(".//*[@id='compareItemsGrid']/tbody/tr[2]/td[2]/div/a");
	By		comparedItemNameSecond									= By.xpath(".//*[@id='compareItemsGrid']/tbody/tr[2]/td[3]/div/a");
	By		specValueFirst											= By.xpath(".//*[@id='compareItemsGrid']/tbody/tr[7]/td[2]/div");
	By		specValueSecond											= By.xpath(".//*[@id='compareItemsGrid']/tbody/tr[7]/td[3]/div");

	// item listing page
	By		itemDetails												= By.xpath(".//tr[contains(@id,'item_list_row_')]/td[3]/div[1]");
	// Item Title
	By		availableItemTitle										= By.xpath(".//*[contains(@id,'item_list_row_')]/td[3]/a");
	// item Availability Date
	By		itemAvailablityDate										= By.xpath(".//*[contains(@id,'item_list_row_')]/td[3]/div[2]/span[3]");
	// By itemDetails = By.cssSelector(".iSDesc.highlightTerm.description");
	By		supplierDetails											= By.cssSelector(".iSuppName");
	By		addToFavorite											= By.xpath(".//*[@id='status_overlay_addItemsToFavourite']/div");

	// Product Price
	By		productPrice											= By.xpath(".//*[contains(@id,'item_list_row_')]/td[4]/label[2]");
	// product Supplier
	By		productSupplier											= By.xpath(".//*[contains(@id,'item_list_row_')]/td[3]/div[2]/span[2]");
	By		productConvertedPrice									= By.xpath(".//*[contains(@id,'item_list_row_')]/td[4]/div[1]");
	// for applying filters on item searching page
	By		selectAllCurrencies										= By.id("lnkAllCurrencies");
	By		inputCheck												= By.cssSelector(".inptChk");
	By		itemPrice												= By.cssSelector(".itmPrce.itemPrice");
	By		minPrice												= By.cssSelector(".inptTxt.minVal");
	By		maxPrice												= By.cssSelector(".inptTxt.maxVal");
	By		clearFilter												= By.id("lnkFacetClear");
	By		processingDiv											= By.id("tblSearchItemList_processing");
	By		otherSearchFilter										= By.xpath(".//*[@id='cntFactes']/div/div[8]/label");
	By		chkFacetGreen											= By.id("chkFacetGreen");
	By		chkFacetPreferred										= By.id("chkFacetPreferred");
	By		tblSearchItemList_processing							= By.id("tblSearchItemList_processing");
	By		greenIcon												= By.cssSelector(".icon.green-item.isGreen");
	By		preferredIcon											= By.cssSelector(".icon.preferred-item.isPreferred");
	By		amountFilter											= By.xpath(".//*[@id='reqList']/thead/tr[2]/th[6]/div/div/b");
	By		inputCurrencies											= By.cssSelector(".inptChk.inputCurrencies");
	By		filterButton											= By.xpath(".//*[contains(@id,'ui-tooltip-')]/div/div[2]/a[3]");
	By		totalAmount												= By.cssSelector(".totalAmountReq");

	// view product details
	By		itemNo													= By.cssSelector(".itemNo");

	// view shopping cart page
	By		editQuantity											= By.xpath(".//input[contains(@id,'cart_item_quantity_')]");
	By		updateQuantityButton									= By.xpath(".//a[contains(@id,'cart_item_update_')]");
	By		updateSucessfulMsg										= By.className("icon.tickActive");
	By		removeItem												= By.xpath(".//a[contains(@id,'cart_item_delete_')]");
	By		yes_button												= By.xpath(".//div[contains(@class,'ui-dialog-buttonset')]/button[1]");
	By		emptyCartMessage										= By.cssSelector(".noCartItemsContent.errorBx");
	By		closeViewCart											= By.cssSelector(".ui-icon.ui-icon-closethick");
	By		alert_msg												= By.xpath(".//table[contains(@class,'tblmsg')]/tbody/tr/td[2]");
	By		showDetails												= By.cssSelector(".showItemDetails");
	By		itemTitle												= By.xpath(".//span[contains(@id,'ui-dialog-title-item_detail_popup_')]");
	By		unitPrice												= By.cssSelector(".iNum.priceFormatted");
	// By saveCartAsBasket_link =
	// By.cssSelector(".scLnk.saveCartAsBasket.cart_save_basket");

	// Check out page
	By		checkOutHead											= By.cssSelector(".pgHead");
	By		requisitionName											= By.id("txtRequisitionName");
	By		purchaseType											= By.id("selPurchaseType");
	By		settlementVia											= By.id("selPaymentMethod");
	By		userPCard												= By.id("selPCard");
	By		editBillingInfo											= By.id("changeDelBillingSumm");
	By		expandAll												= By.id("lnkExpandItems");
	By		editAccounting											= By
		.cssSelector(".icon.scLnk.splitItemToMultipleIconPos.splitToMultiple.itemaccountsplitchange.itemsplitchange");
	By		editDelivery											= By
		.cssSelector(".icon.scLnk.splitItemToMultipleIconPos.splitToMultiple.itemdeliverysplitchange.itemsplitchange");
	By		errorMessage											= By.cssSelector(".errorBox.globalMessage");
	By		ImDone_button											= By.id("submitRequisition");
	By		GL_Account_Type											= By.xpath(".//select[contains(@id, 'accountType_')]");
	By		GL_Account												= By.xpath(".//input[contains(@id, 'generalLedger_')]");
	By		saveRequisitionItemSummary								= By.id("saveRequisitionItemSummary");
	By		accounting_pad											= By.cssSelector(".tab3.ui-state-default.ui-corner-top.ui-tabs-selected.ui-state-active.ui-state-hover>a");
	By		costBookingTab											= By.cssSelector(".tab2.ui-state-default.ui-corner-top.ui-state-hover>a");
	// By accountingTab =
	// By.cssSelector(".tab3.ui-state-default.ui-corner-top.ui-state-hover>a");
	By		accountingTab											= By.xpath(".//*[@id='frmItemSummary']/div/div[2]/ul/li[3]/a");
	By		saveAsDraft_button										= By.id("draftRequisition");
	By		continue_Button											= By.xpath(".//*[@id='cart_noItemsContainer']/div[2]/div/div/input");
	By		selectRequiredByDate									= By.cssSelector(".ui-datepicker-trigger");
	String	custom_Date_xpath1										= ".//*[@id='ui-datepicker-div']/table/tbody/tr[";
	String	custom_Date_xpath2										= "]/td[";
	String	custom_Date_xpath3										= "]/a";
	By		costBooking												= By.xpath(".//*[@id='changeReqSummaryTabs']/ul/li[3]/a");
	By		deliveryTab												= By.xpath(".//*[@id='changeReqSummaryTabs']/ul/li[2]/a");
	By		billingTab												= By.xpath(".//*[@id='changeReqSummaryTabs']/ul/li[1]/a");
	By		deliveryTo												= By.id("deliverTo_summary");
	By		delivery_Address										= By.xpath(".//*[@id='customAddress_headerCustomAddress']/div[2]/div/div");
	By		delivery_Scope											= By.id("selectDeliveryScope");
	By		budgetSummary											= By.id("budget_summary");
	By		costCenterSummary										= By.id("costCenter_summary");
	By		activeMenuItem											= By.id("ui-active-menuitem");
	By		otherAddresses											= By.xpath(".//*[@id='customAddress_headerCustomAddress']/div[1]/label[2]/input");
	By		otherAddresses_headerCustomAddress						= By.id("otherAddresses_headerCustomAddress");
	By		customAddressHeader										= By.xpath(".//*[@id='customAddress_headerCustomAddress']/div[3]/div");
	By		closeRequisitionItemSummary								= By.id("closeRequisitionItemSummary");
	By		lblDeliveryOn_summary									= By.id("lblDeliveryOn_summary");

	By		reqCurrency												= By.id("txtCurrency");
	By		checkoutTotalPrice										= By.cssSelector(".checkout-itemprice.totalPrice");
	By		costBookingCurrency										= By.xpath(".//table[contains(@class,'tblSplitData itemSummaryCostings')]/tbody/tr[2]/td[3]");
	By		accountingCurrency										= By.xpath(".//table[contains(@class,'tblSplitData itemSummaryAccountings')]/tbody/tr[2]/td[2]");

	By		cancelReq												= By.id("cancelRequisition");
	By		keepAllItemsButton										= By.xpath(".//div[contains(@class,'ui-dialog-buttonset')]/button[1]");
	By		deleteAllItemsButton									= By.xpath(".//*[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/div/button[2]");
	By		confirmationMessage										= By.cssSelector(".tblcellmsg");
	By		deleteItem												= By.cssSelector(".icon.delete.deleteItem");
	By		validationMsgAtCheckoutPage								= By.xpath("//div[17]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td");

	By		saveReqButton											= By.xpath(".//*[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/div/button[1]");

	By		splitCostAt_LineItemLevel								= By.id("rad_costing_split_level_item");
	By		editSplitItemConfigure									= By.cssSelector(".icon.edit.splitItem.configure");
	By		addNewDeliveryLoc										= By.xpath(".//table[contains(@id,'splitDeliveries')]/tbody/tr[2]/td[6]/a[1]");
	By		removeDeliveryLoc										= By.xpath(".//table[contains(@id,'splitDeliveries')]/tbody/tr[2]/td[6]/a[2]");
	By		editDeliveryQuantity									= By.xpath(".//table[contains(@id,'splitDeliveries')]/tbody/tr[2]/td[4]/span[1]/input");
	By		editDeliverToFirstRow									= By.xpath(".//table[contains(@id,'splitDeliveries')]/tbody/tr[2]/td[1]/span/input");
	By		editDeliverAddFirstRow									= By.xpath(".//table[contains(@id,'splitDeliveries')]/tbody/tr[2]/td[2]/div/span[1]/span[1]/input");
	By		editRequiredByFirstRow									= By.xpath(".//table[contains(@id,'splitDeliveries')]/tbody/tr[2]/td[3]/span[1]/input");
	By		editQuantityFirstRow									= By.xpath(".//table[contains(@id,'splitDeliveries')]/tbody/tr[2]/td[4]/span[1]/input");
	By		amountfirstRow											= By.xpath("//table[contains(@id,'splitDeliveries')]/tbody/tr[2]/td[5]");
	By		editDeliverToSecondRow									= By.xpath(".//table[contains(@id,'splitDeliveries')]/tbody/tr[3]/td[1]/span/input");
	By		editDeliverAddSecondRow									= By.xpath(".//table[contains(@id,'splitDeliveries')]/tbody/tr[3]/td[2]/div/span[1]/span[1]/input");
	By		editQuantitySecondRow									= By.xpath(".//table[contains(@id,'splitDeliveries')]/tbody/tr[3]/td[4]/span[1]/input");
	By		splitbudget1											= By.xpath(".//table[contains(@id,'splitItemCostings')]/tbody/tr[2]/td[2]/div/span[1]/span[1]/input");
	By		splitbudget2											= By.xpath(".//table[contains(@id,'splitItemCostings')]/tbody/tr[3]/td[2]/div/span[1]/span[1]/input");
	By		costCenterSplit1										= By.xpath(".//table[contains(@id,'splitItemCostings')]/tbody/tr[2]/td[1]/div/span[1]/span[1]/input");
	By		costCenterSplit2										= By.xpath(".//table[contains(@id,'splitItemCostings')]/tbody/tr[3]/td[1]/div/span[1]/span[1]/input");
	By		splitPercentage1										= By.xpath(".//table[contains(@id,'splitItemCostings')]/tbody/tr[2]/td[4]/span[1]/input");
	By		splitPercentage2										= By.xpath(".//table[contains(@id,'splitItemCostings')]/tbody/tr[3]/td[4]/span[1]/input");
	By		addNewCostCenter										= By.xpath(".//table[contains(@id,'splitItemCostings')]/tbody/tr[2]/td[10]/a[1]");

	By		copyReqDeliverToDefault									= By.xpath(".//table[contains(@class,'tblSplitData itemSummaryDeliveries')]/tbody/tr[2]/td[1]");
	By		copyReqDeliverTo										= By.xpath(".//table[contains(@class,'tblSplitData itemSummaryDeliveries')]/tbody/tr[3]/td[1]");
	By		copyReqDeliverAdd										= By.xpath(".//table[contains(@class,'tblSplitData itemSummaryDeliveries')]/tbody/tr[3]/td[2]/span");
	By		copyReqCostCenter										= By.xpath(".//table[contains(@class,'tblSplitData itemSummaryCostings')]/tbody/tr[3]/td[1]");

	// By userCurrency = By.id("txtCurrency");
	By		companyName												= By.cssSelector(".frmEle.dev_ouInput.dev_companyAutoComplete.ui-autocomplete-input");
	By		businessUnitName										= By.cssSelector(".frmEle.dev_ouInput.dev_buAutoComplete.ui-autocomplete-input");
	By		locationName											= By.cssSelector(".frmEle.dev_ouInput.dev_locationAutoComplete.ui-autocomplete-input");
	By		costBooking_Tab											= By.xpath(".//*[@id='frmItemSummary']/div/div[2]/ul/li[2]/a");
	By		addComments												= By.cssSelector(".icon.comments.itemComments");

	By		splitCostCenterAtHeaderLevel							= By.id("rad_costing_split_level_entity_multi");
	By		entity_costing_costCenter_0								= By.id("entity_costing_costCenter_0");
	By		entity_costing_budget_0									= By.id("entity_costing_budget_0");
	By		entity_costing_percentage_0								= By.id("entity_costing_percentage_0");
	By		addCostCenter											= By.xpath(".//*[@id='entity_costing_0']/td[6]/a[1]");
	By		entity_costing_costCenter_2								= By.id("entity_costing_costCenter_2");
	By		entity_costing_budget_2									= By.id("entity_costing_budget_2");
	By		entity_costing_percentage_2								= By.id("entity_costing_percentage_2");
	By		entity_costing_costCenter_1								= By.id("entity_costing_costCenter_1");
	By		entity_costing_budget_1									= By.id("entity_costing_budget_1");
	By		entity_costing_percentage_1								= By.id("entity_costing_percentage_1");
	By		entity_costing_price_0									= By.id("entity_costing_price_0");
	By		entity_costing_price_1									= By.id("entity_costing_price_1");

	By		totalPrice_inDeliverySection							= By.id("lblItemSubTotalPrice");
	By		reqTotalPrice											= By.cssSelector(".val.totalPrice");
	By		currencyWiseTotal										= By.id("lnkCurrencyWiseTotal");

	By		addAttachmentOption										= By.id("lnkRequisitionAttachments");
	By		addAttachmentDoneButton									= By.cssSelector(".secondaryButton.close>input");
	By		toAddMoreItemToCart										= By.cssSelector(".mnBtn.addMoreItemsBtn.addMoreItems>b");

	By		company_Name											= By.cssSelector(".frmEle.noScroll.noBlur.dev_ouInput.dev_companyAutoComplete.ui-autocomplete-input");
	By		business_Unit_Name										= By.cssSelector(".frmEle.noScroll.dev_ouInput.dev_buAutoComplete.ui-autocomplete-input");
	By		location_Name											= By.cssSelector(".frmEle.noScroll.noBlur.dev_ouInput.dev_locationAutoComplete.ui-autocomplete-input");
	By		customAddressDetails_DeliveryTab						= By.xpath(".//*[@id='customAddress_headerCustomAddress']/div[4]/div/div[2]");

	By		deliveryDateIcon										= By.xpath(".//div[@id='deliverySumm']/div/fieldset/ol/li[2]/div/img");
	By		deliveryYear											= By.className("ui-datepicker-year");
	By		deliveryMonth											= By.className("ui-datepicker-month");

	By		accountingInfoIcon										= By.id("accountingInfo");
	By		accountingInfoToolTip									= By.xpath(".//div[contains(@id,'ui-tooltip-')]/ul/li");

	// requisition header level summary
	By		billToAddressHeader										= By.xpath(".//*[@id='billToAddress_header']/div");
	By		shipToAddressHeader										= By.xpath(".//*[@id='shipToAddress_header']/div");
	By		shipToAddressAtHeader									= By.id("shipToAddress_header");
	By		comapnyNameHeader										= By.id("orgUnit_company");
	By		businessUnitHeader										= By.id("orgUnit_businessUnit");
	By		locationHeader											= By.id("orgUnit_location");
	By		costCenterNameHeader									= By.id("costCenter_header");

	// free text item on checkout page
	By		showDetailsForGuidedItem								= By.cssSelector(".scLnk.itemnamelnk.itemName.guidedItem");
	By		totalPriceOfGuidedItem									= By.cssSelector(".col-totalprice.iNum.subTotalPrice");

	By		totalPriceOfItems										= By.cssSelector(".val.totalPrice");
	By		requisitionSummaryTitle									= By.id("ui-dialog-title-changeRequisitionSummary");
	By		requiredByDateMandatoryAstrik							= By.xpath(".//*[@id='frmRequisition']/div[9]/div[1]/table/tbody/tr/td[1]/div[2]/label/em");
	By		closeRequisitionSummary									= By.id("closeRequisitionSummary");

	By		splitByPercentageHeaderAtItemLevel						= By.cssSelector(".col-qty.costingPercentage");
	By		splitByQuantityHeaderAtItemLevel						= By.xpath(".//*[@id='splitItemCostings']/thead/tr/th[6]");
	By		copyCostCenterInfoFromHeaderButton						= By.id("rad_item_costing_split_level_entity");
	By		copyCostCenterInfoFromHeaderLabel						= By.xpath(".//*[@id='itemCostbooking']/div/div[1]/div[2]/div/div[2]/label");
	By		bookCostAtItemLevelbutton								= By.id("rad_item_costing_split_level_item");
	By		bookCostAtItemLevelLabel								= By.xpath(".//*[@id='itemCostbooking']/div/div[2]/div[1]/div/div[2]/label");
	By		bookCostAtItemLevel_type_percentagebutton				= By.id("rad_item_costing_split_type_percentage");
	By		bookCostAtItemLevel_type_percentageLabel				= By.xpath(".//*[@id='item_costing_split_level_item_content']/fieldset/ol/li/div/label[1]");
	By		bookCostAtItemLevel_type_quantitybutton					= By.id("rad_item_costing_split_type_quantity");
	By		bookCostAtItemLevel_type_quantityLabel					= By.xpath(".//*[@id='item_costing_split_level_item_content']/fieldset/ol/li/div/label[2]");
	By		bookCostAtItemLevel_type_deliverybutton					= By.id("rad_item_costing_split_type_delivery");
	By		bookCostAtItemLevel_type_deliveryLabel					= By.xpath(".//*[@id='item_costing_split_level_item_content']/fieldset/ol/li/div/label[3]");

	By		costCenterName_SplitatLineItemLevel						= By.xpath(".//*[@id='splitSummaryItemCostings']/tbody/tr[2]/td[1]");
	By		costCenterMultipleHeaderLabel							= By.xpath(".//*[@id='costCenter_header']/i");
	By		costCenterSplit_DeliverTo								= By.xpath(".//*[@id='splitItemCostings']/thead/tr/th[4]");
	By		costCenterSplit_Address									= By.xpath(".//*[@id='splitItemCostings']/thead/tr/th[5]");
	By		costCenterSplit_Qty										= By.xpath(".//*[@id='splitItemCostings']/thead/tr/th[7]");
	By		costCenterSplit_Amount									= By.xpath(".//*[@id='splitItemCostings']/thead/tr/th[8]");

	By		costCenterFirst_SplitAtItemLevel						= By.xpath(".//table[@class='tblSplitData itemSummaryCostings']/tbody/tr[2]/td[1]");
	By		costCenterSecond_SplitAtItemLevel						= By.xpath(".//table[@class='tblSplitData itemSummaryCostings']/tbody/tr[3]/td[1]");

	By		cancelRequisitionItemSummary							= By.id("cancelRequisitionItemSummary");

	/*** delivery tab ***/
	By		splitDelivery											= By.id("optMultiSplit");
	By		itemDeliverySummary										= By.xpath(".//*[@id='itemDeliverySumm']/div");
	By		splitDeliveryLabel										= By.xpath(".//*[@id='itemDeliverySumm']/div/div[3]/div[1]/div/div[2]/label");
	By		deliveryInformationFromReqSummaryOption					= By.id("optSingleSplit");
	By		deliveryInformationFromReqSummaryOptionLabel			= By.xpath(".//*[@id='itemDeliverySumm']/div/div[2]/div[1]/div/div[2]/label");
	By		deliverTo_fieldValue									= By.id("deliverTo_item_summary");
	By		deliveryAddress_fieldValue								= By.xpath(".//*[@id='shipToAddress_summary']/div");
	By		requiredBy_fieldValue									= By.id("deliveryOn_item_summary");
	By		deliveryAddHeader										= By.xpath(".//*[@id='customAddress_headerCustomAddress']/div[2]/div/div");
	By		deliveryOn_summary										= By.id("deliveryOn_summary");

	// buyers desk page
	By		buyersCommentField										= By.id("txtChangeComments");
	By		assignedBuyerFilterAtBuyersDesk							= By.xpath(".//*[@id='buyerlisting']/thead/tr[2]/th[7]/div/div/span[2]");
	By		amountFilterAtBuyersDesk								= By.xpath(".//*[@id='buyerlisting']/thead/tr[2]/th[8]/div/div/b");
	By		convertToPO												= By.id("btnConvertToPo");
	By		totalAmountAtBuyersDesk									= By.cssSelector(".totAmount.iNum");
	By		assignedBuyerFilterAtUpComingReqPage					= By.xpath(".//*[@id='upcomingRequisitions']/thead/tr[2]/th[5]/div/div/span[2]");
	By		amountFilterAtUpComingReqPage							= By.xpath(".//*[@id='upcomingRequisitions']/thead/tr[2]/th[6]/div/div/b");
	// currencywise total page
	By		btnCloseCurrencyWiseTotal								= By.id("btnCloseCurrencyWiseTotal");
	By		amountField												= By.xpath(".//*[@id='tblCurrencyWiseTotal']/thead/tr/th[1]");
	By		itemsField												= By.xpath(".//*[@id='tblCurrencyWiseTotal']/thead/tr/th[2]");
	By		subTotalField											= By.xpath(".//*[@id='tblCurrencyWiseTotal']/thead/tr/th[3]");
	By		grandTotalField											= By.xpath(".//*[@id='tblCurrencyWiseTotal']/tfoot/tr/td/label");

	// item listing grid on checkout page
	By		item_No													= By.cssSelector(".scLnk.itemNo.catalogItem");
	By		item_Name												= By.cssSelector(".scLnk.itemnamelnk.itemName.catalogItem");
	By		supplier_name											= By.className("supplierName");

	By		draftRequisition										= By.id("draftRequisition");

	// add other address
	By		otherAddressRadionButton								= By.xpath(".//*[@id='customAddress_headerCustomAddress']/div[1]/label[2]/input");
	By		otherDeliveryAddressess									= By.id("otherAddresses_headerCustomAddress");

	// to add custom address
	By		myAddressess											= By.xpath(".//*[@id='customAddress_headerCustomAddress']/div[1]/label[3]/input");
	By		createNewAddress										= By.cssSelector(".scLnk.createNewMyAddress");
	By		addressName												= By.id("custom_name_headerCustomAddress");
	By		street1Name												= By.id("custom_street1_headerCustomAddress");
	By		selectCountry											= By.id("custom_country_headerCustomAddress");
	By		cityName												= By.id("custom_city_headerCustomAddress");
	By		zipField												= By.id("custom_zip_headerCustomAddress");
	By		selectState												= By.id("custom_state_headerCustomAddress");

	By		updateUserInfo											= By.id("btnAddUserInfo");

	// req listing page
	// By my_requisition_sub = By.id("my_requisition_sub");
	By		clearFilter_ReqStatus									= By.xpath(".//*[@id='reqList']/thead/tr[2]/th[1]/div/div/span[2]");
	By		reqActions												= By.cssSelector(".icon.actLnk");
	By		reqEdit													= By.cssSelector(".icon.scLnk.edit");
	By		reqDelete												= By.cssSelector(".icon.scLnk.delete");
	By		recallApprovalRequest									= By.cssSelector(".icon.scLnk.terminate.downArrow");
	By		reqCancel												= By.cssSelector(".icon.scLnk.cancel");
	By		reqCreateReceipt										= By.cssSelector(".icon.scLnk.createreceipt");
	By		reqRemindApprover										= By.cssSelector(".icon.scLnk.remind.reminder");
	By		reqView													= By.cssSelector(".icon.scLnk.view");
	By		reviewAndSubmit											= By.xpath(".//*[@id='reqList']/tbody/tr[1]/td[7]/div/div/ul/li/a");
	By		recallApprovalButton									= By.cssSelector(".icon.scLnk.terminate.downArrow");
	By		remindApproverSuccessMessage							= By.id("status_overlay_sendingReminder");
	By		recallCommentButton										= By.cssSelector(".primaryButton.saveComment>input");
	By		savingRecallCommentPopup								= By.id("status_overlay_savingComment");
	By		errorMsgForComment										= By.xpath(".//*[@class='frmMsg vError']/label");
	By		recallComment											= By.id("txtComment");
	By		cancelComment											= By.id("txtCancelComment");
	By		cancelReqCommentButton									= By.cssSelector(".primaryButton.cancelComment>input");
	By		copyReq													= By.cssSelector(".icon.scLnk.eCopy");
	By		proceedWithReqNExistingCartItems						= By.xpath(".//*[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/div/button[1]");
	By		proceedWithOnlyReqItems									= By.xpath(".//*[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/div/button[2]");
	By		toolTipForReq											= By.cssSelector(".gridDetTipPad");
	By		totalPriceOnToolTip										= By.xpath(".//*[contains(@id,'ui-tooltip-')]/div/div/div[1]/div[contains(@class,'prce')]");
	By		expiredCatalogItem_AtCheckoutPage						= By.cssSelector("a.scLnk.itemnamelnk.itemName.catalogItem.expiredTxt");
	By		expireCatalogItem_InCart								= By.cssSelector(".description.iDesc.breakWord.expiredTxt");
	By		reqList_processing										= By.id("reqList_processing");
	By		upcomingRequisitionsProcessing							= By.id("upcomingRequisitions_processing");

	// req view page
	By		reqViewProcessing										= By.cssSelector(".dispProcessing");
	By		reqForm													= By.cssSelector("#frmRequisition");
	By		updateDraft												= By.cssSelector("#draftRequisition");
	By		viewMode												= By.cssSelector(".sdPnlCnt");
	By		reqTab													= By.cssSelector(".tbBxC");
	By		itemTable												= By.xpath(".//*[@id='collapsibleGrid']/thead/tr");
	// By viewReqName =
	// By.xpath(".//*[@id='wrapper']/div[2]/div/div[2]/div[5]/div/div/div/div/div[11]/div/fieldset/ol[1]/li[2]/div[1]/div");
	By		viewReqName												= By.xpath(".//*[@id='wrapper']/div[2]/div/div[2]/h1/span[3]");
	By		closedAuditTrail										= By.className("cHead.auditTrail");
	By		openAuditTrail											= By.xpath(".//*[@id='reqauditTrailHead']/span");
	By		auditTrailVersionLink									= By.cssSelector(".scLnk.auditLink");
	By		reqauditTrailHead										= By.id("reqauditTrailHead");
	By		deliveryExpand											= By.xpath(".//*[@id='wrapper']/div[2]/div/div[2]/div[5]/div/div/div/div/h2[4]/span");
	By		businessUnitName_ViewPage								= By.xpath(".//*[@id='deliveryInfoTable']/tbody/tr/td[2]");
	By		locationName_ViewPage									= By.xpath(".//*[@id='deliveryInfoTable']/tbody/tr/td[3]");
	By		costBookingExpand										= By.xpath(".//*[@id='wrapper']/div[2]/div/div[2]/div[5]/div/div/div/div/h2[5]/span");
	By		costCenter1												= By.xpath(".//*[@id='costingInfoTable']/tbody/tr[1]/td[2]");
	By		costCenter2												= By.xpath(".//*[@id='costingInfoTable']/tbody/tr[2]/td[2]");
	By		viewReqNameAndNo										= By.cssSelector(".val");
	By		auditTrailAction_firstRow								= By.xpath(".//table[contains(@id,'auditTrailList_REQUISITION')]/tbody/tr[1]/td[1]");
	By		auditTrailUser_firstRow									= By.xpath(".//table[contains(@id,'auditTrailList_REQUISITION')]/tbody/tr[1]/td[2]");
	By		auditTrailSharedWith_firstRow							= By.xpath(".//table[contains(@id,'auditTrailList_REQUISITION')]/tbody/tr[1]/td[3]");
	By		auditTrailConversationMsg_firstRow						= By.xpath(".//table[contains(@id,'auditTrailList_REQUISITION')]/tbody/tr[1]/td[7]/div/div[1]/div/span[2]");
	By		auditTrailConversationReplyedMsg_firstRow				= By.xpath(".//table[contains(@id,'auditTrailList_REQUISITION')]/tbody/tr[1]/td[7]/div/div[2]/div/div/span[2]");
	By		auditTrailRole_firstRow									= By.xpath(".//table[contains(@id,'auditTrailList_REQUISITION')]/tbody/tr[1]/td[4]");
	By		auditTrailVersion_firstRow								= By.xpath(".//table[contains(@id,'auditTrailList_REQUISITION')]/tbody/tr[1]/td[6]");
	By		auditTrailComment_firstRow								= By.xpath(".//table[contains(@id,'auditTrailList_REQUISITION')]/tbody/tr[1]/td[7]");
	By		auditTrailVersion_fourthRow								= By.xpath(".//table[contains(@id,'auditTrailList_REQUISITION')]/tbody/tr[4]/td[6]/a");
	By		reqChangeComment										= By.cssSelector(".frmValWrap.nrmlColor");
	By		reqTab_viewMode											= By.xpath(".//div[contains(@id,'guidedItemContainer_')]/div[5]/ul/li[1]/a");
	By		requirementDetailsTab_viewMode							= By.xpath(".//div[contains(@id,'guidedItemContainer_')]/div[5]/ul/li[2]/a");

	// view free text item details from req view page
	By		viewFreeTextItemName									= By.cssSelector(".val.itemname.lblGuidedItemName>b");
	By		closeButtonLink											= By.xpath(".//*[@id='viewGuidedItemGlobalDOM']/div/div[2]/div/a");
	By		suggestSupplierTable									= By.xpath(".//table[contains(@class,'zytbl tblGuidedItemSuppliers')]/tbody/tr");
	By		suggestedSupplierName									= By.xpath(".//table[contains(@class,'zytbl tblGuidedItemSuppliers')]/tbody/tr[2]/td[1]");
	By		suggestedSupplierType									= By.xpath(".//table[contains(@class,'zytbl tblGuidedItemSuppliers')]/tbody/tr[2]/td[2]");
	By		suggestedSupplierContactDetails							= By.xpath(".//table[contains(@class,'zytbl tblGuidedItemSuppliers')]/tbody/tr[2]/td[3]");
	By		suggestedSupplierOtherDetails							= By.xpath(".//table[contains(@class,'zytbl tblGuidedItemSuppliers')]/tbody/tr[2]/td[4]");

	// view version page
	By		version_reqName											= By.xpath(".//*[@class='cContent approvalItems']/div/fieldset/ol[1]/li[2]/div[1]/div");
	By		version_settlementVia									= By.xpath(".//div[contains(@class,'cContent approvalItems')]/div/fieldset/ol[1]/li[6]/div[1]/div");
	By		version_supplierComment									= By.xpath(".//*[@class='cContent approvalItems']/div/fieldset/ol[2]/li[2]/div[1]/div");
	By		version_purchaseType									= By.xpath(".//*[@class='cContent approvalItems']/div/fieldset/ol[2]/li[4]/div[1]/div");
	By		version_closeButton										= By.xpath(".//*[@id='wrapper']/div[1]/div/a");

	// favorite page
	By		myFavoritesTab											= By.id("my_favourites_sub");

	By		searchFavorites											= By.cssSelector("input.srchTxt");
	By		searchFavoritesType										= By.xpath(".//*[@id='favList_wrapper']/div[1]/div[1]/select");
	By		searchFavoritesGo										= By.cssSelector("input.btn");
	By		favoritesProcessing										= By.id("favList_processing");

	By		removeFromFavorites										= By.cssSelector("a.icon.delete.scLnk.delFav");
	By		searchedItemName										= By.className("itemName");
	By		searchedItemNo											= By.xpath(".//*[@id='favList']/tbody/tr/td[3]");
	By		searchedSupplierName									= By.cssSelector(".iSuppName");
	By		checkAll												= By.className("autoCheckAll");
	By		addFavoriteToCart_button								= By.cssSelector(".icon.aToCart.addItemToCart.scLnk");
	By		input_Quantity											= By.className("itemQuantity.inptTxt");
	By		addedMessage											= By.cssSelector(".icon.tickActive");
	By		favoriteListingTable									= By.xpath(".//*[@id='favList']/tbody/tr");
	By		sortBy													= By.id("sortBy");
	By		addToFav												= By.cssSelector(".icon.aToCart.addItemToCart.scLnk");
	By		totalRecords											= By.cssSelector("#favList_info>b");
	By		favBar													= By.cssSelector(".favBar");
	By		totalFavoriteItems										= By.cssSelector("#favList_info>b");
	By		favoriteItemNames										= By.cssSelector(".itemName");
	By		favList_info											= By.id("favList_info");

	// Add to basket page
	By		selectNewBasket											= By.id("selNewBasket");
	By		basketName												= By.id("txtBasket");
	By		addToBasket_button										= By.id("btnAddToBasket");
	By		selectBasket											= By.id("selBasket");
	By		alertMessage											= By.cssSelector(".red.smll.nrml.fR");
	By		addToBasketTiltle										= By.id("ui-dialog-title-addToBasketBlck");
	By		basketName_errorMessage									= By.xpath(".//*[@id='frmAddItemToBasket']/div[1]/div[1]/fieldset/ol/li[2]/div[2]/label");

	// shopping basket page
	By		shoppingBasketTab										= By.id("baskets_sub");
	By		viewBasket												= By.xpath(".//table[contains(@id,'basList')]/tbody/tr/td[2]/a");
	By		itemNameInBasket										= By.cssSelector(".iDesc>a");
	By		searchedBasketName										= By.xpath(".//*[@id='basList']/tbody/tr/td[2]/a");
	By		actions													= By.cssSelector(".scLnk.icon.actLnk");
	By		deleteBasket											= By.cssSelector(".icon.delete.scLnk");
	By		searchTable												= By.xpath(".//*[@id='basList']/tbody/tr");
	By		duplicate_basket_error									= By.xpath(".//*[@id='frmAddItemToBasket']/div[1]/div[1]/fieldset/ol/li[2]/div[2]");
	By		successfullyAddedToCartMsg								= By.xpath(".//*[@id='status_overlay_addingToCart']/div");
	By		shoppingBasketNameHeader								= By.cssSelector(".basket-name.sorting");
	By		basketNameSortInAsc										= By.cssSelector(".basket-name.sorting_asc");
	By		nameSort												= By.cssSelector(".basket-name.sorting_1");
	By		basketTotalPriceSort									= By.cssSelector(".iNum.sorting");
	By		basketTotalPriceSortAsc									= By.cssSelector(".iNum.sorting_asc");
	By		basketTotalPriceSortDesc								= By.cssSelector(".iNum.sorting_desc");
	By		basketListingProcessing									= By.id("basList_processing");
	By		deliveryLeadTime										= By.xpath(".//*[@id='basList']/tbody/tr/td[5]/span");
	By		basketListingList										= By.cssSelector(".afterFilter");
	By		totalBasketNames										= By.cssSelector(".bld.allCount");

	// view shopping baskte page
	By		unitPrice_inBasket										= By.xpath(".//*[@id='basItemList']/tbody/tr/td[6]");
	By		totalPrice_inBasket										= By.xpath(".//*[@id='basItemList']/tbody/tr/td[8]");
	By		editShoppingBasketName									= By.id("edt-basket-name");
	By		basketNameInput											= By.id("basket-name");
	By		saveBasketName											= By.id("save-basket-name");
	By		addMultipleItemsToCart									= By.id("addMultipleItemsToCart");
	By		basketListingTable										= By.xpath(".//*[@id='basItemList']/tbody/tr");
	By		availability											= By.cssSelector(".avail");
	By		deleteFromBasket										= By.id("deleteItems");
	By		itemtitle												= By.xpath(".//*[contains(@id,'ui-dialog-title-item_detail_popup_')]");

	// submit req
	By		submitReq												= By.id("submitRequisition");
	// By submitReqYes = By.xpath(".//div[@class='ui-dialog ui-widget
	// ui-widget-content ui-corner-all promptbx iConfirmBox']/button");
	By		submitReqYes											= By
		.xpath(".//div[contains(@class,'ui-dialog-buttonpane ui-widget-content ui-helper-clearfix')]/div/button[1]");
	By		confirmReqForking										= By.id("dev_confirm");
	By		addReqButton											= By.xpath(".//*[@id='lnkAddRequisition']/b");
	By		disableCheckOut_button									= By.cssSelector(".b-checkout.checkoutCart.cart_checkout.disableMe>span");

	// eform creation
	By		eforms_top												= By.id("eforms_top");
	By		process_eforms_sub										= By.id("process_eforms_sub");
	By		category_eforms_sub										= By.id("category_eforms_sub");
	By		newEformButton											= By.cssSelector(".mnBtnTxt");
	By		newEformOnline											= By.cssSelector("span.p");
	By		eformNameField											= By.id("txtFName");
	By		eformDisplayNameField									= By.id("txtFDName");
	By		selectCategoryLinkForEform								= By.id("lnkCategories");
	By		selectAllCategories										= By.cssSelector(".clrSrch.selAll");
	By		btnSaveCategory											= By.xpath("(//input[@value='Save'])[4]");
	By		selectOrganisationUnitLink								= By.id("lnkBUs");
	By		saveOrgUnitButton										= By.xpath("(//input[@value='Save'])[3]");
	By		saveEformButton											= By.id("save");
	By		eformFieldSection										= By.cssSelector(".df-wrapper.dfSections.ui-sortable");
	By		addNewSection											= By.cssSelector(".df-addlink.addSection");
	By		sectionName												= By.id("dfSectionName");
	By		saveSectionButton										= By.id("dfSectionName");
	By		sectionHead												= By.cssSelector(".df-section-head.dfSectionHead");
	By		addFieldLink											= By.cssSelector(".df-addlink.dfAddField");
	By		textField												= By.xpath(".//*[@id='dfFieldSelect']/div/ul/li[1]/a");
	By		textFieldLabelName										= By.cssSelector(".df-form-ele.dfTFName");
	By		saveButton_fieldProperties								= By.cssSelector(".df-prop-btn.df-prop-btnpri.dfSaveProperties");
	By		eformLabel												= By.cssSelector(".df-form-label");
	By		publishEformButton										= By.id("publishEform");
	By		allBUs													= By.xpath(".//ul[@id='zytree_scope_tree']/li/label/input");
	By		allCategories											= By.xpath(".//ul[@id='zytree_category_tree']/li/label/input");
	By		saveBU													= By.cssSelector("input.btnSaveOrgUnit");
	By		eformDuplicateScopeMessage								= By.cssSelector("div.message");

	By		cforms													= By.xpath(".//table[@id='categoryFormGrid']/tbody/tr/td/div/a[@class='scLnk']");

	By		eformCancelButton										= By.id("close");
	By		updateCformLink											= By.cssSelector(".icon.scLnk.updateCatalog.updateEform");
	By		deactivateCformLink										= By.cssSelector("a.icon.eDeactive.scLnk.eFormStatus");
	By		deleteCformLink											= By.cssSelector("a.icon.eDelete.scLnk.eFormStatus");
	By		confirmDeactivateDeleteYes								= By.xpath(".//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all promptbx iConfirmBox']//button");	// By.xpath("html/body/div[9]/div[3]/div/button[1]");

	// ADD FREE TEXT ITEM
	By		guideMeExpand											= By.cssSelector("a.closebtn");
	By		cantFindHeader											= By.className("cnt-head");
	By		guideMe													= By.cssSelector(".b-button.b-guidedBtn.lnkGuideMe");
	By		guidedProcurement										= By.xpath(".//*[@id='tblSearchItemList']/tbody/tr/td/div/div/div/ul/li[3]/a");

	By		freeTextItemDetailForm									= By.xpath(".//*[@id='wrapper']/div[3]/div[2]");
	By		freeTextName											= By.id("name");
	By		itemType												= By.id("itemType_goods");
	By		itemTypeGoods											= By.id("itemType_goods");
	By		itemTypeServices										= By.id("itemType_services");

	By		receivedBy												= By.id("receivedBy_amount");
	By		receivedByQuantity										= By.id("receivedBy_quantity");
	By		receivedByAmount										= By.id("receivedBy_amount");

	By		freeTextQuantity										= By.id("quantity");
	By		freeTextUOM												= By.id("uom");
	By		Supplier_Name											= By.id("dev_existingSupplierInput");
	By		supplier_Address										= By.id("slctSupplierAddress");

	By		sourcingStatus											= By.id("sourcingStatus_budgetary");
	By		sourcingStatusRequesterNegotiated						= By.id("sourcingStatus_requester");
	By		sourcingStatusBudgetary									= By.id("sourcingStatus_budgetary");
	By		sourcingStatusNeedAQuote								= By.id("sourcingStatus_quote");

	By		freeTextItemPrice										= By.id("price");
	By		placeOrderWithExistingSupplier							= By.id("dev_existingSupplierRadio");
	By		placeOrderWithExistingSupplierLabel						= By.cssSelector(".pad0.single-collapse-opts-txt>label>span");

	By		closeCategoryLink										= By.xpath(".//a[@class='closedialog scLnk']");
	By		selectCategoryLink										= By.id("selectProdCategory");
	By		changeCategory											= By.id("changeCategory");
	By		searchCategory											= By.id("txtSearchCategory");
	By		categorySuggestions										= By.className("ui-menu-item");
	By		categoryEformDiv_categoryPopUp							= By.xpath(".//*[@id='selectCategory']/div[2]/div[1]");
	By		categoryEform											= By.xpath(".//*[@id='selectCategory']/div[2]/div[1]/ol/li/a/div");
	By		continueButton											= By
		.xpath(".//div[contains(@class,'ui-dialog-buttonpane ui-widget-content ui-helper-clearfix')]/div/button[1]");

	By		selectCategory											= By.id("selectThisCategory");

	By		changeCategoryYes										= By.cssSelector("button.pri.ui-button.ui-widget.ui-state-default.ui-corner-all.ui-button-text-only");
	By		eformData												= By.xpath(".//*[contains(@id,'df_df')]");
	By		viewEformLabel											= By.cssSelector(".df-form-label");
	By		categoryEformField										= By.id("categoryEform");
	// By closeButton_CategoryPopUP =
	// By.xpath(".//div[contains(@class,'ui-dialog ui-widget ui-widget-content
	// ui-corner-all ui-draggable')]/div[1]/a");
	// By closeButton_CategoryPopUP = By.xpath(".//div[10]/div[1]/a/span");
	By		closeButton_CategoryPopUP								= By.cssSelector(".ui-icon.ui-icon-closethick");

	By		itemDetailsFormHead										= By.xpath(".//*[@id='collapsibleItems']/h1[1]");
	By		itemDetailsForm											= By.xpath(".//*[@id='collapsibleItems']/div[1]");
	By		requirementDetailsformHead								= By.xpath(".//*[@id='collapsibleItems']/h1[2]");
	By		requirementsDetailsForm									= By.xpath(".//*[@id='collapsibleItems']/div[3]");
	By		supplierDetailsFormHead									= By.xpath(".//*[@id='collapsibleItems']/h1[3]");
	By		supplierDetailsForm										= By.xpath(".//*[@id='collapsibleItems']/div[4]");

	By		shortDescLabel											= By.xpath(".//*[@id='frmItemDetails']/fieldset/ol[1]/li[1]/label");
	By		productCategoryLabel									= By.xpath(".//*[@id='frmItemDetails']/fieldset/ol[2]/li[1]/label");
	By		quantityLabel											= By.xpath(".//*[@id='frmItemDetails']/fieldset/ol[2]/li[2]/label");
	By		UOMLabel												= By.xpath(".//*[@id='frmItemDetails']/fieldset/ol[2]/li[3]/label");
	By		priceLabel												= By.xpath(".//*[@id='frmItemDetails']/fieldset/ol[2]/li[4]/label");
	By		currencyLabel											= By.xpath(".//*[@id='frmItemDetails']/fieldset/ol[2]/li[6]/label");

	By		itemDetailsHead											= By.id("ui-dialog-title-checkoutDiag");
	By		itemDetailsBox											= By.id("checkoutDiag");
	By		freeTextAddToCart										= By.id("btnAddToCart");
	By		freeTextAddAnotherItem									= By.cssSelector("a.b-button.b-secondary.addAnotherItem");
	By		freeTextCheckout										= By.cssSelector("a.b-button.b-final.checkout");
	By		freeTextViewCart										= By.cssSelector(".b-button.b-secondary.viewItemsInCart");

	By		addedFreeTextTitle										= By.id("ui-dialog-title-checkoutDiag");

	By		freeTextCategoryExists									= By.cssSelector("div.message");

	By		freeTextItem_productCategory							= By.id("lblProductCategory");
	By		freeTextPartNo											= By.id("supplierPartId");
	By		freeTextLongDesc										= By.id("description");
	By		freeTextItemCurrency									= By.id("currency");

	By		showExtraFieldsLink										= By.xpath(".//*[@id='frmItemDetails']/div[1]/a");
	By		expandedArea											= By.xpath(".//*[@id='frmItemDetails']/div[2]/fieldset/ol[1]");
	By		freeText_itemDetails									= By.xpath(".//*[@id='collapsibleItems']/h1[1]");
	By		freeText_requirementDetails								= By.xpath(".//*[@id='collapsibleItems']/h1[2]");

	By		dev_suggestedSupplierRadio								= By.id("dev_suggestedSupplierRadio");
	By		supplierNameHeader										= By.xpath(".//*[@id='tblSuppliers']/thead/tr/th[1]");
	By		supplierAddressHeader									= By.xpath(".//*[@id='tblSuppliers']/thead/tr/th[2]");
	By		supplierTypeHeader										= By.xpath(".//*[@id='tblSuppliers']/thead/tr/th[3]");
	By		supplierActionsHeader									= By.xpath(".//*[@id='tblSuppliers']/thead/tr/th[4]");
	By		anotherNewExistingSupplier								= By.cssSelector(".fL.scLnk.icon.add.marLft5.suggestSupplierLnk");

	By		txtSrchSuppName											= By.id("txtSrchSuppName");
	By		txtSuppName												= By.id("txtSuppName");
	By		txtLocation												= By.id("txtLocation");
	By		txtContactPerson										= By.id("txtContactPerson");
	By		txtEmail												= By.id("txtEmail");
	By		txtPhone												= By.id("txtPhone");
	By		txtOtherDetails											= By.id("txtOtherDetails");

	By		searchSuppNameLabel										= By.xpath(".//*[@id='suggestSupplierDiag']/div[1]/div[2]/label");
	By		supplierNameLabel										= By.xpath(".//*[@id='frmSuggestedSupplier']/fieldset/ol/li[1]/label");
	By		locationLabel											= By.xpath(".//*[@id='frmSuggestedSupplier']/fieldset/ol/li[2]/label");
	By		contactPersonLabel										= By.xpath(".//*[@id='frmSuggestedSupplier']/fieldset/ol/li[3]/label");
	By		emailLabel												= By.xpath(".//*[@id='frmSuggestedSupplier']/fieldset/ol/li[4]/label");
	By		phoneLabel												= By.xpath(".//*[@id='frmSuggestedSupplier']/fieldset/ol/li[5]/label");
	By		otherDeatils											= By.xpath(".//*[@id='frmSuggestedSupplier']/fieldset/ol/li[6]/label");

	By		supplierName_mandatory									= By.xpath(".//*[@id='frmSuggestedSupplier']/fieldset/ol/li[1]/label/em");
	By		errorMsg												= By.className("error");
	By		btnSuggest												= By.id("btnSuggest");
	By		supplierNameFirstValue									= By.xpath(".//*[@id='tblSuppliers']/tbody/tr/td[1]");
	By		supplierAddressFirstValue								= By.xpath(".//*[@id='tblSuppliers']/tbody/tr/td[2]");
	By		supplierTypeFirstValue									= By.xpath(".//*[@id='tblSuppliers']/tbody/tr/td[3]");
	By		typeValue												= By.xpath(".//*[@id='tblSuppliers']/tbody/tr[1]/td[3]");
	By		removeButton											= By.cssSelector(".scLnk.icon.remove");
	By		supplierfilter											= By.id("supplierfilter");

	By		UOMAutoCompleteList										= By.cssSelector(".ui-autocomplete.ui-menu.ui-widget.ui-widget-content.ui-corner-all");
	By		UOMDescription											= By.cssSelector(".uomDescription");
	By		supplierInfoAtPopUP										= By.cssSelector(".bLst.recommendedSuppliers>li");
	By		suggestSupplierList										= By.xpath(".//*[@id='tblSuppliers']/tbody/tr");
	By		selectSupplierLink										= By.xpath(".//*[@id='tblSuppliers']/tbody/tr[1]/td[4]/a");
	By		cancelButton_newSupplier								= By.id("btnCancel");
	By		freeTextCategoryItemLabel								= By.xpath(".//*[@id='wrapper']/div[3]/div[2]/div[1]/h1/div/span[1]");
	By		freeTextItemLabel										= By.xpath(".//*[@id='wrapper']/div[3]/div[2]/div[1]/h1/div/span[2]");
	By		categoryNameLabel										= By.xpath(".//*[@id='wrapper']/div[3]/div[2]/div[1]/h1/div/span[3]");
	By		editAccountingInfoButton								= By.cssSelector(".icon.splitItem.configure.edit");
	By		recentlyOrderedFreeTextItems							= By.xpath(".//*[@id='collapsibleItems']/h1[4]/span");
	By		viewRecentlyOrderedGuidedItems							= By.cssSelector(".scLnk.viewGuided");

	By		freeTextImageURL										= By.id("imageUrl");
	By		freeTextSupplierProductURL								= By.id("supplierProductURL");
	By		freeTextManufactureURL									= By.id("manufacturerProductURL");
	By		freeTextManufacturerPartId								= By.id("manufacturerPartId");
	By		freeTextManufacturerName								= By.id("manufacturerName");
	By		freeTextIsGreenYes										= By.id("dev_isGreen_yes");
	By		freeTextIsGreenNo										= By.id("dev_isGreen_no");
	By		freeTextIsPreferredYes									= By.id("dev_isPreferred_yes");
	By		freeTextIsPreferredNo									= By.id("dev_isPreferred_no");
	By		freeTextSpecificationsName								= By.id("guidedParametricName");
	By		freeTextSpecificationsKey1								= By.id("watermark_txt_unique_id_2");
	By		freeTextSpecificationsValue1							= By.id("watermark_txt_unique_id_3");
	By		freeTextSpecificationsKey2								= By.id("watermark_txt_unique_id_4");
	By		freeTextSpecificationsValue2							= By.id("watermark_txt_unique_id_5");
	By		freeTextAddMoreSpecifications							= By.xpath(".//*[@id='dev_guidedParametricDataContainer']/div[1]/a[1]");
	By		freeTextRemoveSpecifications							= By.xpath(".//*[@id='dev_guidedParametricDataContainer']/div[1]/a[2]");
	By		freeTextSpecificationsErrorSign							= By.cssSelector(".icon.inlineError.vMiddle.qtipCss.hasQtip");
	By		freeTextToolTipContent									= By.className("ui-tooltip-content");
	By		freeTextItemAddAttachment								= By.xpath(".//*[@id='uploadifyAttachment_guideMeItemAttachments']/div[1]/div[2]/div[3]/input");

	By		validationMessage										= By.cssSelector(".error");

	By		freeTextContractNo										= By.id("dev_contractNo");
	By		mandatoryAsterik										= By.cssSelector(".astk");
	By		ancestorLabel											= By.xpath("ancestor::label");

	By		eformVersionChangedMessage								= By.xpath(".//*[@id='eformWarningMessage']/div/div[2]/span");
	By		existingSupplierBlock									= By.id("dev_existingSupplierBlock");

	By		firstSupplierAddress									= By
		.xpath(".//body/ul[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']/li[@class='ui-menu-item']/a");

	/**** category selection popup *****/
	By		cancelButton											= By.cssSelector(".closedialog.scLnk");
	By		eformDiv												= By.cssSelector(".scrCnt.fL1.categoryEfromsDiv");
	By		selectEform												= By.cssSelector(".scLnk.efrmLnk.categoryEformItem");
	By		continueWithoutSelectingCategoryLink_CategoryPopup		= By.xpath(".//*[@id='selectCategory']/div[1]/div[2]/div/div/a[1]");
	By		continueWithoutSelectingCategoryLink_EformPopup			= By.xpath(".//*[@id='selectEform']/div[1]/div[2]/div/div/a[1]");
	By		continueWithoutSelectingCategoryLink_selected			= By.xpath(".//*[@id='selectedEform']/div[1]/div[2]/div/div/a[1]");
	By		selectAllEform											= By.id("selectEformLnk");
	By		allEformDiv												= By.cssSelector(".scrCnt.clearfix");
	By		allEforms												= By.cssSelector(".scLnk.eformitem.efrmLnk");
	By		selectCategoryLnk										= By.id("selectCategoryLnk");
	By		selectCategorySearchLabel								= By.xpath(".//*[@id='selectCategory']/div[1]/div[1]/div[1]/div/div[1]/span/label");
	By		selectEformSearchLabel									= By.xpath(".//*[@id='selectEform']/div[1]/div[1]/div[1]/div/div[1]/span/label");
	By		selectCategoryEformPopup								= By.xpath(".//*[@id='selectedEform']/div[2]/div/ol/li/a");
	By		categoryDiv												= By.cssSelector(".resInf.orgTtl.clearfix.showingEforms");
	By		searchEformBox											= By.id("txtSearchEform");
	By		searchedEform											= By.xpath(".//*[@id='selectEform']/div[2]/div/ol/li/a/div");
	By		listOfCategoryDiv										= By.xpath(".//*[@id='selectedEform']/div[2]/div");
	By		selectCategoryLnkSel									= By.id("selectCategoryLnkSel");
	By		selectAnotherEform										= By.id("selectAnotherEform");
	By		cancelButton_CategoryPopup								= By.xpath(".//*[@id='guideDiag']/div[2]/div/a");
	By		firstSelectCategory										= By.xpath(".//*[@id='selectedEform']/div[2]/div/ol/li[1]/a");
	By		zeroPunchOutItems_OnMainPage							= By.xpath(".//*[@id='cntRelatedPunchoutsDrop']/a/span");
	By		warningMessage_CategoryAlreadyExists_OnPopup			= By.xpath(".//*[@id='innerWarningMessage']/div/div[2]/span");
	By		warningMessage_CategoryAlreadyExists_OnMainPage			= By.xpath(".//*[@id='warningMessageContainer']/div/div[2]/span");
	By		categoryAlreadyExists_CatalogItemsHyperLink_OnPopUp		= By.xpath(".//*[@id='innerWarningMessage']/div/div[2]/span/a[1]");
	By		categoryAlreadyExists_PunchOutItemsHyperLink_OnPopUp	= By.xpath(".//*[@id='innerWarningMessage']/div/div[2]/span/a[2]");
	By		categoryAlreadyExists_ZeroPunchOutItems_OnPopUp			= By.xpath(".//*[@id='innerWarningMessage']/div/div[2]/span/label");
	By		categoryAlreadyExists_CatalogItemsHyperLink_OnMainPage	= By.xpath(".//*[@id='warningMessageContainer']/div/div[2]/span/a[1]");
	By		categoryAlreadyExists_PunchOutItemsHyperLink_OnMainPage	= By.xpath(".//*[@id='warningMessageContainer']/div/div[2]/span/a[2]");
	By		categoryAlreadyExists_ZeroPunchOutItems_OnMainPage		= By.xpath(".//*[@id='warningMessageContainer']/div/div[2]/span/label");
	By		sameScopeEform_CancelButton								= By.xpath(".//div[contains(@class,'ui-dialog-buttonpane ui-widget-content ui-helper-clearfix')]/div/button");

	/** Add to cart free text item pop up **/
	By		successMsg_AddToCart									= By.xpath(".//*[@id='checkoutDiag']/div[1]/div[1]/div[2]");
	By		itemName												= By.cssSelector(".itemName.itemTitle");
	By		item_Quantity											= By.cssSelector(".info.fnt11px");
	By		item_price												= By.cssSelector(".prce");
	By		item_Category											= By.cssSelector(".val.itemCategory");

	/** Eform fields **/
	By		sectionTitleOnFreeTextForm								= By.cssSelector(".df-view-title");
	By		eformFieldLabel											= By.cssSelector(".df-form-label");

	// view free text item details page
	By		item_title												= By.id("ui-dialog-title-editGuidedItemDOM'");
	By		item_Tab												= By.xpath(".//*[contains(@id,'guidedItemContainer_')]/div[5]/ul/li[1]/a");
	By		requirementTab											= By.xpath(".//*[contains(@id,'guidedItemContainer_')]/div[5]/ul/li[2]/a");
	By		supplierTab												= By.xpath(".//*[contains(@id,'guidedItemContainer_')]/div[5]/ul/li[3]/a");
	By		itemDetailsHeader										= By.cssSelector(".ui-dialog-titlebar.ui-widget-header.ui-corner-all.ui-helper-clearfix");
	By		shortDescItemName										= By.xpath(".//*[contains(@id,'guidedItemDetailsForm_')]/ol[1]/li[2]/div[1]/div");
	By		itemTypeName											= By.cssSelector(".lblItemType.frmValWrap");
	By		receivedByName											= By.cssSelector(".lblReceivedBy.frmValWrap");
	By		quantityValue											= By.xpath(".//*[contains(@id,'guidedItemDetailsForm_')]/ol[2]/li[2]/div[1]/div");
	By		priceValue												= By.xpath(".//*[contains(@id,'guidedItemDetailsForm_')]/ol[2]/li[4]/div[1]/div");
	By		sourcingStatusValue										= By.cssSelector(".lblSourcingStatus.frmValWrap");
	By		supplierNameValue										= By.xpath(".//*[contains(@id,'frmSupplier_')]/div[2]/div[1]/div/div/fieldset/ol[1]/li[1]/div[1]/div/label");

	By		editPriceValue											= By.xpath(".//*[contains(@id,'guidedItemDetailsForm_')]/ol[2]/li[4]/div[1]/input");
	By		editFreeTextShotDesc									= By.cssSelector(".frmEle.name.dev_validEle");
	By		editFreeTextLongDesc									= By.cssSelector(".frmEle.frmTxtarea.description.norm.dev_validEle");
	By		editProductCategory										= By.cssSelector(".frmEle.productCategory.dev_validEle.ui-autocomplete-input");
	By		editFreeTextQuantity									= By.xpath(".//*[contains(@id,'guidedItemDetailsForm_')]/ol[2]/li[2]/div[1]/input");
	By		editFreeTextUOM											= By.cssSelector(".frmEle.uomTxtbx.frmEle-uom.txtUom.dev_validEle.ui-autocomplete-input");
	By		editFreeTextPrice										= By.xpath(".//*[contains(@id,'guidedItemDetailsForm_')]/ol[2]/li[4]/div[1]/input");
	By		editFreeTextCurrency									= By.cssSelector(".frmEle.frmEle-itemcurr.currency.dev_validEle.ui-autocomplete-input");
	By		editEformField											= By.cssSelector(".df-form-ele.dfTFValue");
	By		editEformFieldInItemDetails								= By.xpath(".//*[contains(@id,'df_df')]");
	By		editFreeTextSupplier									= By.cssSelector(".frmEle.dev_existingSupplierInput.ui-autocomplete-input");
	By		editSaveButton											= By.cssSelector(".primaryButton.save>input");
	By		editCancelButton										= By.xpath(".//*[@id='editGuidedItemDOM']/div/div[2]/div/a");
	By		editReceivedByQuantity									= By.id("receiptType_quantity");
	By		editReceivedByAmount									= By.id("receiptType_amount");
	By		editReceivedByNoReceipt									= By.id("receiptType_noReceipt");
	By		editFreeTextItemPriceAtBuyersDesk						= By.xpath(".//*[contains(@id,'guidedItemDetailsForm_')]/ol[2]/li[4]/a");
	By		itemCurrencyAtBuyersDesk								= By.xpath(".//*[contains(@id,'guidedItemDetailsForm_')]/ol[2]/li[6]/div[1]/div");
	By		editContractNo											= By.cssSelector(".frmEle.dev_contractNo");
	By		copyFreeTextItem										= By.cssSelector(".primaryButton.copy>input");
	By		sourcingStatus_buyer									= By.id("sourcingStatus_buyer");

	// Catalog data
	By		addCatalogButton										= By.cssSelector("a.mnBtn > b");
	By		catalogNameField										= By.id("txtCatalogName");
	By		supplierNameField										= By.id("txtSupplierName");
	By		nextButton												= By.id("btnLnkNext");
	By		addItemToCatalogButton									= By.cssSelector("#addOnlineItem > b");
	By		itemNumberField											= By.id("txtItemNumber");
	By		itemNameField											= By.id("txtItemname");
	By		categoryNameField										= By.id("txtCatName");
	By		categoryPriceField										= By.id("txtPrice");
	By		addItemButton											= By.id("addItem");
	By		checkAllButton											= By.cssSelector("input.autoCheckAll");
	By		lnkScopeValidity										= By.id("lnkScopeValidity");
	By		lnkOrgUnit												= By.id("lnkOrgUnit");
	By		catalogSaveButton										= By.xpath("(//input[@value='Save'])[3]");
	By		catalogSubmitButton										= By.id("lnkSubmit");
	By		txtFltrCatalogName										= By.id("txtFltrCatalogName");
	By		firstCatalogName_CatalogListing							= By.xpath(".//table[contains(@id,'catalogListing')]/tbody/tr/td[3]/a");
	By		deatcivateCatalogLink									= By.xpath(".//*[@id='catalogListing']/tbody/tr/td[8]/div/div/ul/li[3]/a");
	By		deleteCatalogLink										= By.xpath(".//*[@id='catalogListing']/tbody/tr/td[8]/div/div/ul/li[3]/a");
	By		updateCatalogLink										= By.xpath(".//*[@id='catalogListing']/tbody/tr/td[8]/div/div/ul/li[2]/a");
	By		catalogNameField_UpdateCatalog							= By.xpath(".//*[@id='frmCreateCatalog']/fieldset/ol/li[1]/div[1]/div");
	By		catalogSupplierNameFiled_UpdateCatalog					= By.xpath(".//*[@id='frmCreateCatalog']/fieldset/ol/li[2]/div[1]/div[1]");
	By		specName												= By.id("parametricName");
	By		specKeyField											= By.xpath(".//div[contains(@id,'dev_parametricDataContainer')]/div/span[1]/input");
	By		specValueField											= By.xpath(".//div[contains(@id,'dev_parametricDataContainer')]/div/span[2]/input");
	By		catalog_ItemDesc										= By.id("txtItemdesc");

	// Settings DATA
	By		setupTab												= By.xpath("//a[@id='setup_top']");
	By		masterDataTab											= By.id("master_data_sub");
	By		customizeDataTab										= By.id("customize_sub");
	By		companiesLink											= By.xpath(".//*[@id='Companies']/a");
	By		costCentersLink											= By.xpath(".//*[@id='Cost Centers']/a");
	By		locationsLink											= By.xpath(".//*[@id='Locations']/a");
	By		selectLocationBy										= By.xpath(".//*[@id='locationListing_wrapper']/div[3]/div/select");
	By		shipToAddress											= By.xpath(".//*[@id='locationListing']/tbody/tr/td[5]");
	By		ship_To_Address											= By.xpath(".//*[@id='locationListing']/tbody/tr/td[6]");
	By		billToAddress											= By.xpath(".//*[@id='locationListing']/tbody/tr/td[4]");
	By		exchangeRates											= By.xpath(".//*[@id='Exchange Rates']/a");
	By		exchangeRateFirstRow									= By.xpath(".//*[@id='exchangeRateList']/tbody/tr/td[3]");
	By		inverseExchangeRateFirstRow								= By.xpath(".//*[@id='exchangeRateList']/tbody/tr/td[4]");
	By		fromCurrencyValue										= By.xpath(".//*[@id='exchangeRateList']/tbody/tr/td[1]");
	By		toCurrencyValue											= By.xpath(".//*[@id='exchangeRateList']/tbody/tr/td[2]");
	By		purchaseScopeLink										= By.xpath(".//*[@id='Purchasing Scopes']/a");
	By		PurchasingScopes										= By.xpath(".//*[@id='Purchasing Scopes']");
	By		addPurchasingScope										= By.xpath(".//*[@id='addTab']/ul/li[1]/a");
	By		purchasingScopeName										= By.id("txtName");
	By		purchasingScope_companyName								= By.cssSelector(".chk>span");
	By		ancestorInput											= By.xpath("ancestor::input");
	By		addPurchasingScopeButton								= By.id("btnAddRegion");
	By		companyNameField										= By.xpath(".//*[@id='companyList']/tbody/tr/td[2]");
	By		deactivateCompany										= By.xpath(".//*[@id='companyList']/tbody/tr/td[5]/a");
	By		costCenterNameField										= By.xpath(".//*[@id='costCenterList']/tbody/tr/td[2]");
	By		deactivateCostCenter									= By.xpath(".//*[@id='costCenterList']/tbody/tr/td[5]/a");
	By		purchasingScopeNameField								= By.xpath(".//*[@id='purchasingScopeList']/tbody/tr[1]/td[2]");

	// user data
	By		txtUserCurrency											= By.id("txtUserCurrency");
	By		updateUserProcessing									= By.xpath(".//*[@id='status_overlay_addUser']/div");
	By		userUpdatedSuccessfullyMsg								= By.xpath(".//*[@id='formMessageContainer']/div/div[2]");

	/*** customize : master data ***/
	By		masterDataLink											= By.xpath(".//*[@id='wrapper']/div[2]/div/div[2]/div/div[1]/div/div/a[9]");
	By		eProcEntityPurchaseType									= By.id("EPROC_ENTITY_PURCHASE_TYPE");
	By		saveButton												= By.id("btnSave");
	By		successMsg												= By.xpath(".//*[@id='hedaerSuccessBox']/div[2]/ul/li");

	// buyer's desk page
	By		buyerDeskTopTab											= By.id("buyer_desk_top");
	By		buyerDeskSubTab											= By.id("buyer_desk_sub");
	By		reqNoAtBuyerDesk										= By.id("txtFltrReqNum");
	By		reqNameAtBuyerDesk										= By.id("txtFltrReqName");
	By		requesterAtBuyerDesk									= By.id("txtFltrRequster");
	By		firstReqNo												= By.xpath(".//*[@id='buyerlisting']/tbody/tr/td[3]/a");
	By		firstReqName											= By.xpath(".//*[@id='buyerlisting']/tbody/tr/td[4]");
	By		firstRequester											= By.xpath(".//*[@id='buyerlisting']/tbody/tr/td[5]");
	By		buyerListingProcessing									= By.id("buyerlisting_processing");
	By		buyerListFirstRow										= By.xpath(".//*[@id='buyerlisting']/tbody/tr");
	By		returnRequisitionFromBuyerDesk							= By.cssSelector(".icon.scLnk.reject");
	By		buyerComment											= By.id("returnComments");
	By		resubmitFlag											= By.id("chkCanResubmit");
	By		returnReqButton											= By.id("returnRequisition");
	By		noButton												= By.xpath("html/body/div[14]/div[3]/div/button[2]");
	By		saveRequisitionAtBuyersDesk								= By.id("saveRequisition");
	By		statusAtBuyersDesk										= By.xpath(".//*[@id='buyerlisting']/tbody/tr/td[2]/div");
	By		totalPriceAtBuyersDesk									= By.xpath(".//*[@id='buyerlisting']/tbody/tr/td[7]");
	By		yesButton												= By
		.xpath(".//div[contains(@class,'ui-dialog-buttonpane ui-widget-content ui-helper-clearfix')]/div/button[1]");
	By		cancel_Button											= By
		.xpath(".//div[contains(@class,'ui-dialog-buttonpane ui-widget-content ui-helper-clearfix')]/div/button[2]");
	By		versionNoField											= By.xpath(".//*[contains(@id,'audit_40288262')]/td[6]");
	By		viewSuggestSupplierLink									= By.cssSelector(".add_guided_item_supplier");
	By		returnToRequester										= By.id("returnWithQuote");
	By		buyersDeskStatus										= By.cssSelector(".clearfix.statusTxt.nowrap");
	By		buyerDesk_Status										= By.xpath(".//*[@id='buyerlisting']/tbody/tr/td[2]/div");

	/*** to view guided items at buyer's desk ***/
	By		showExtraFieldLink										= By.xpath(".//*[@id='guidedItemDetails']/div/div/div[1]/a");
	By		specKey1_BuyersDesk										= By.id("watermark_txt_unique_id_1");
	By		specValue1_BuyersDesk									= By.id("watermark_txt_unique_id_2");
	By		specKey2_BuyersDesk										= By.id("watermark_txt_unique_id_3");
	By		specValue2_BuyersDesk									= By.id("watermark_txt_unique_id_4");

	// APPROVALS
	By		approval_Tab											= By.id("workflow_approval_top");
	By		approvalSubTab											= By.id("workflow_approval_sub");
	By		allRequestsTab											= By.id("all_requests_sub");

	By		allApprovalDocNoField									= By.id("watermark_txt_unique_id_1");
	By		allApprovalDocNameField									= By.id("watermark_txt_unique_id_2");
	By		allApprovalDocInitiatorField							= By.id("txtFltrRequster");

	By		firstApprovalDocNo										= By.xpath(".//*[@id='workflowApproval']/tbody/tr[1]/td[3]/a");
	By		firstApprovalDocName									= By.xpath(".//*[@id='workflowApproval']/tbody/tr[1]/td[5]");
	By		firstApprovalDocInitiator								= By.xpath(".//*[@id='workflowApproval']/tbody/tr[1]/td[6]");
	By		allApprovalFirstStatus									= By.xpath(".//*[@id='workflowApproval']/tbody/tr/td[2]/div");

	/* Delegate approval */
	By		allApprovalDelegateApprovalToField						= By.id("txtDelegateName");
	By		allApprovalDelegateComments								= By.id("delegateComments");
	By		allApprovalFinalDelegate								= By.id("btnDelegateSave");
	By		errorMegForDelegateToInitiator							= By.xpath(".//*[@class='frmMsg vError nameerrorMsg']/label");

	By		firstApprovalFilter										= By.xpath(".//*[@id='workflowApproval']/thead/tr[2]/th[2]/div/div");
	By		pendingApprovalFilter									= By.xpath(".//*[@id='pending']/span/label/input");

	By		secondApprovalFilter									= By.xpath(".//*[@id='workflowApproval']/thead/tr[2]/th[4]/div/div");
	By		approvedApprovalStatus									= By.xpath(".//*[@id='approved']/span/label/input");
	By		rejectedApprovalStatus									= By.xpath(".//*[@id='rejected']/span/label/input");

	By		approvalRequisition										= By.xpath(".//*[@id='requisition']/span/label/input");

	By		approvalProcessing										= By.id("workflowApproval_processing");
	By		firstApprovalDocType									= By.xpath(".//*[@id='workflowApproval']/tbody/tr[1]/td[4]");

	By		approveRequisitionButton								= By.cssSelector("a.icon.scLnk.app-approved");
	By		rejectRequisitionButton									= By.cssSelector("a.icon.scLnk.rejectedApproval");
	By		approveRequisitionComment								= By.id("approvalComments");
	By		rejectRequisitionComment								= By.id("rejectComments");
	By		saveApproveReq											= By.xpath(".//*[@id='frmApprove']/div[2]/div/div/input");
	By		saveRejectReq											= By.xpath(".//*[@id='frmReject']/div[2]/div/div/input");
	By		approvalSuccess											= By.cssSelector("div.message");

	By		approvalSettingsTab										= By.id("my_settings_sub");
	By		delegateToField											= By.id("delegateTo");
	By		delegateToLink											= By.xpath(".//li[@class='ui-menu-item']/a");
	By		enableDelegation										= By.id("btnSave");
	By		revokeDelegation										= By.id("btnRevoke");

	By		allApprovalFirstLink									= By.xpath("(.//table[@id='workflowApproval']//a[@class='scLnk'])[1]");
	By		allApprovalProcessing									= By.id("workflowApproval_processing");

	By		allApprovalFirstActions									= By.xpath("(.//a[@class='icon actLnk'])[1]");
	By		allApprovalFirstApproveLink								= By.cssSelector("a.icon.scLnk.app-approved");
	By		allApprovalApproveComments								= By.id("approvalComments");
	By		allApprovalFinalApprove									= By.cssSelector("input.dev_approve");
	By		allApprovalFirstRejectLink								= By.cssSelector("a.icon.scLnk.rejectedApproval");
	By		allApprovalRejectComments								= By.id("rejectComments");
	By		allApprovalFinalReject									= By.cssSelector("input.dev_reject");
	By		allApprovalFirstDelegateLink							= By.cssSelector("a.icon.scLnk.delegate");

	By		allApprovalSuccess										= By.cssSelector("div.message");
	By		allApprovalPurchaseOrderCheckbox						= By.xpath(".//input[@value='PURCHASE_ORDER']");
	By		allApprovalInvoiceCheckbox								= By.xpath(".//input[@value='INVOICE']");

	By		approvalTableEmpty										= By.cssSelector("td.dataTables_empty");
	By		reqListTable											= By.xpath(".//*[@id='reqList']/tbody/tr");
	By		reqName_Link											= By.xpath(".//*[@id='reqList']/tbody/tr[1]/td[2]/a");
	By		cancleButton											= By.cssSelector(".scLnk.cancelFltr");

	By		topBandArrow											= By.xpath(".//*[@id='newMainNav']/li[3]/span[1]");
	By		manageProfile											= By.xpath(".//*[@id='manageProfile']/a");
	By		displayName_UserProfile									= By.id("displayName");
	By		saveAndCloseButton										= By.xpath(".//*[@id='UserProfileForm']/div[3]/div[1]/input");
	By		saveAndClosePopUp										= By.xpath(".//*[@id='loadingAnim']/span/img");

	/*
	 * #------------------------------------------------------------------------
	 * ---------------------------------------------------#
	 * #------------------------------------------------------------------------
	 * ---------------------------------------------------#
	 * #------------------------------------------------------------------------
	 * ---------------------------------------------------#
	 * #------------------------------------------------------------------------
	 * ---------------------------------------------------#
	 * #------------------------------------------------------------------------
	 * ---------------------------------------------------#
	 * #------------------------------------------------------------------------
	 * ---------------------------------------------------# #
	 * -------------------------------------------------------------------------
	 * -------------------------------------------------#
	 * #------------------------------------------------------------------------
	 * ---------------------------------------------------#
	 * #------------------------------------------------------------------------
	 * ---------------------------------------------------#
	 * #------------------------------------------------------------------------
	 * ---------------------------------------------------#
	 * #------------------------------------------------------------------------
	 * ---------------------------------------------------#
	 * #------------------------------------------------------------------------
	 * ---------------------------------------------------#
	 * #------------------------------------------------------------------------
	 * ---------------------------------------------------# #
	 * -------------------------------------------------------------------------
	 * -------------------------------------------------#
	 */
	// @PUNEET

	By		addCart													= By.cssSelector(".aTCrtL");
	By		reqKeywordTab											= By.cssSelector(".egBx");
	By		reqkeywordElement										= By.cssSelector(".scLnk.recent");
	By		achorTag												= By.tagName("a");
	By		maxValueConfirmationPopUp								= By.cssSelector(".tblcellmsg");
	By		checkList												= By.xpath("//input[contains(@id,'chk_item_list_')]");
	// By checkOutButton =
	// By.cssSelector(".b-checkout.checkoutCart.cart_checkout>span");
	By		checkOutButton											= By.xpath(".//*[@id='cart']/div[1]/a/span");
	By		checkListPopUp											= By.cssSelector("#lnkCompareItems");
	By		itemCount												= By.className("itemCount");
	By		compare													= By.className("ppI");
	By		compareAlert											= By.className("tblimgWrap");
	By		compareAlertMsg											= By.className("tblcellmsg");
	By		comparisionPage											= By.className("clearfix");
	By		itemsOnComparePage										= By.cssSelector(".itmName.scLnk");
	String	itemId													= "item_list_row_";
	By		checkOut												= By.cssSelector(".b-checkout.checkoutCart.cart_checkout>span");
	By		progressStatus											= By.cssSelector(".status.process");
	By		progressCompleteStatus									= By.cssSelector(".aNew.ui-state-error");
	By		checkOutPage											= By.cssSelector(".chkoutlbl");

	/**********************************************************************************/

	By		reqNo													= By.xpath(".//*[@id='reqList']/tbody/tr/td[2]/a");

	By		reqHeader												= By.xpath(".//*[@id='lnkRequisition']/span");
	By		viewcomment												= By.xpath(".//*[@id='dev_itemGrid']/tbody/tr/td[7]/a[2]");
	By		internalComment											= By.id("intComment");
	By		supplierComment											= By.id("supComment");
	By		closeButton												= By.xpath(".//*[@id='itemCommentsDOM']/div/div[2]/div/div/input");

	By		reqStatus												= By.cssSelector(".clearfix.statusTxt.postatusTxt");
	By		confirmForkReq											= By.cssSelector("#dev_confirm");
	By		generalInformationOnRequisitionViewPage					= By.xpath(".//*[@id='wrapper']/div[2]/div/div[2]/div[5]/div/div/div/div/h2[1]");
	By		itemsOnRequisitionViewPage								= By.xpath(".//*[@id='wrapper']/div[2]/div/div[2]/div[5]/div/div/div/div/h2[2]");
	By		deliveryOnRequisitionViewPage							= By.xpath(".//*[@id='wrapper']/div[2]/div/div[2]/div[5]/div/div/div/div/h2[3]");
	By		accountingOnRequisitionViewPage							= By.cssSelector(".cHead");
	By		workFlowOnRequisitionViewPage							= By.xpath(".//*[@id='workflowTrailSection']/h2");
	By		auditTrailOnRequisitionViewPage							= By.id("reqauditTrailHead");
	By		tabsOnRequisitionViewPage								= By.cssSelector(".tbBxC");
	By		customFieldsOnRequisitionViewPage						= By.xpath("//h2[@id='eformHead']");
	By		auditTrailOpen											= By.className("cHead.auditTrail.cHead-open");
	By		auditTrailExpand										= By.xpath(".//*[@id='reqauditTrailHead']/span");
	By		auditTrail_Action										= By.xpath(".//*[contains(@id,'auditTrailList_REQUISITION')]/tbody/tr[1]/td[1]");
	By		auditTrail_Role											= By.xpath(".//*[contains(@id,'auditTrailList_REQUISITION')]/tbody/tr[1]/td[4]");
	By		auditTrail_Version										= By.xpath(".//*[contains(@id,'auditTrailList_REQUISITION')]/tbody/tr[1]/td[6]/a");
	By		auditTrail_Message										= By.xpath(".//*[contains(@id,'auditTrailList_REQUISITION')]/tbody/tr[1]/td[7]");

	// Approval Tab
	By		seachByNameOnApprovalPage								= By.cssSelector("#watermark_txt_unique_id_2");
	By		approvalNo												= By.xpath(".//*[@id='workflowApproval']/tbody/tr/td[3]/a");
	By		approvalName											= By.xpath(".//*[@id='workflowApproval']/tbody/tr/td[5]");
	// By msgBox = By.cssSelector(".message");
	// By selectApproverList =
	// By.cssSelector(".scLnk.icon.selectApprover.dev_selectApproverLnk");
	By		msgBox													= By.xpath("//span[contains(@class,'msg')]");
	By		selectApproverList										= By.xpath("//a[@class='scLnk icon selectApprover dev_selectApproverLnk']");
	By		onlineStore												= By.id("requisition_sub");

	// ************************************ Aparna
	// ******************************************//
	By		supplierCompleteAddress									= By.xpath(".//*[@id='divSupplierAddress']");

	// *************************************Himanshu.Singh*****************************/
	By		SearchTextInUsersPage									= By.xpath(".//*[@id='userInfoList_wrapper']/div[3]/div/input[1]");
	By		EmailIdDropDown											= By.xpath(".//*[@id='userInfoList_wrapper']/div[3]/div/select");
	By		GoBtnOnUsersPage										= By.xpath(".//*[@id='userInfoList_wrapper']/div[3]/div/input[2]");
	By		AllRequisitionSub										= By.id("all_requisition_sub");
	By		ReqNumberSearchBox										= By.id("txtFltrReqNum");
	By		StatusOfFirstReq										= By.xpath(".//*[@id='reqList']/tbody/tr/td[1]/div");
	By		UserUpdateBtn											= By.xpath(".//*[@id='btnAddUserInfo']");
	By		UserNameInUsersSetting									= By.id("txtUserName");
	By		ReleasePOImmediatelyNO									= By.xpath(".//*[@id='frmEmailTemplate']/div[2]/div[5]/div/fieldset/ol/li[6]/div[1]/label[2]/input");
	By		ReleasePOImmediatelyYes									= By.xpath(".//*[@id='frmEmailTemplate']/div[2]/div[5]/div/fieldset/ol/li[6]/div[1]/label[1]/input");
	By		ReleasePoAfterDays										= By.id("EPROC_PURCHASE_ORDER_AUTOMATIC_PARK_VALUE_control_DAYS");
	By		AutoGeneratePO											= By.xpath(".//*[@id='frmEmailTemplate']/div[2]/div[6]/div/fieldset/ol/li[1]/div[1]/label[1]/input");
	By		AutogeneratePONo										= By.xpath(".//*[@id='frmEmailTemplate']/div[2]/div[6]/div/fieldset/ol/li[1]/div[1]/label[2]/input");
	By		AutoGeneratePONo										= By.xpath(".//*[@id='frmEmailTemplate']/div[2]/div[6]/div/fieldset/ol/li[1]/div[1]/label[2]/input");
	By		ReqNameOnMyReq											= By.xpath(".//*[@id='txtFltrName']");
	By		FirstReqNoOnMyReq										= By.xpath(".//*[@id='reqList']/tbody/tr/td[2]/a");
	By		DocumentNoOnAllRequset									= By.xpath(".//*[@id='watermark_txt_unique_id_1']");
	By		AllLinksFromActionOnAllRequest							= By.xpath(".//*[@id='workflowApproval']/tbody/tr/td[9]/div/div/ul/li/a");
	By		ApproveTextBoxonAllRequest								= By.xpath(".//*[@id='approvalComments']");
	By		CancelBtnOnPOSettings									= By.xpath(".//*[@id='frmEmailTemplate']/div[3]/div/a");
	By		SequenceNOStartsAtPOSettings							= By.id("EPROC_PURCHASE_ORDER_SEQUENCE_NO");
	By		SequenceNOEndsAtPOSettings								= By.id("EPROC_PURCHASE_ORDER_MAX_SEQUENCE_NO");
	By		ExpandBtnListOfBULocation								= By.cssSelector(".hitarea.highlightTerm-hitarea.hasChildren-hitarea.expandable-hitarea");
	By		BusinessUnitsListOnConfigurePurScope					= By.cssSelector(".trChk");
	By		CancelBtnOnConfigurePurScope							= By.cssSelector(".scLnk.cancel");
	By		cancelBtnOnPurScope										= By.id("cancel");
	By		PurchasingScopeOnUsersSetting							= By.xpath(".//*[@id='purchasingScope']");
	By		SearchFieldOnPurScope									= By.xpath(".//*[@id='purchasingScopeList_wrapper']/div[3]/div/input[1]");
	By		EditBtnOnPurScope										= By.xpath(".//*[@id='purchasingScopeList']/tbody/tr/td[6]/a[1]");
	By		companyNameOnUsersSettings								= By.xpath(".//*[@id='selectCompany']");
	By		LocationOnUsersSettings									= By.xpath(".//*[@id='selectLocation']");
	By		BusinessUnitOnUsersSettings								= By.xpath(".//*[@id='selectBusinessUnit']");
	By		ActiveBtnOnCompanySettings								= By.xpath(".//*[@id='companyList']/tbody/tr[1]/td[5]/a");
	By		ActiveBtnOnLocationSettings								= By.xpath(".//*[@id='locationListing']/tbody/tr[1]/td[7]/a");
	By		ActiveBtnOnBusinessUnitSettings							= By.xpath(".//*[@id='businessUnitList']/tbody/tr[1]/td[5]/a");
	By		BusinessUnitLink										= By.xpath(".//*[@id='Business Units']");
	By		UnitPriceTolerancePercentage							= By.id("EPROC_PURCHASE_ORDER_ITEM_PRICE_TOLERANCE_val");
	By		POSearchFieldOnPOTab									= By.xpath(".//*[@id='polisting']/thead/tr[2]/th[2]/div/div/span[1]/label");
	By		POLinkOnPOTab											= By.xpath(".//*[@id='polisting']/tbody/tr[1]/td[2]/a");
	By		ActionDropdownOnPO										= By.xpath(".//*[@id='actDrop']/span");
	By		CancelLinkOnActionDropDownOnPO							= By.xpath(".//*[@id='cancelPOLink']/span");
	By		CancelCommentBoxOnCancelLink							= By.xpath(".//*[@id='txtCancelComments']");
	By		cancelPOBtn												= By.xpath(".//*[@id='cancelPOAction']");
	By		CostCentreDetailsAtBillingNDeliverySection				= By.xpath(".//*[@id='costCenter_summary']");
	By		CostCentreDetailsAtDraftReq								= By.xpath(".//*[@id='costCenter_header']");
	By		QTipOfCostCentreAtDraftReq								= By.xpath("html/body/div/div[2]/table/tbody/tr/td[2]");
	By		ActionBtnOnMyReq										= By.xpath(".//*[@id='reqList']/tbody/tr/td[7]/div/div/a");
	By		ActionBtnListOnMyReq									= By.xpath(".//*[@id='reqList']/tbody/tr/td[7]/div/div/ul/li/a");
	By		CloseWizardOnUsersSettings								= By.xpath(".//*[@id='closeWizard']");
	By		UpdatePurchasingScope									= By.xpath(".//*[@id='btnAddRegion']");
	By		CostCentreOnUsers										= By.xpath(".//*[@id='selectCostCenter']");
	By		CostCentreOnPUOnMasters									= By.xpath(".//*[@id='diagTree']/div[1]/div/ul/li[2]/a");
	By		SaveBtnOnBULocOnPU										= By.xpath(".//*[@id='selectedParent']");
	By		SearchFieldOnPU											= By.xpath(".//*[@id='purchasingScopeList_wrapper']/div[3]/div/input[1]");
	By		GoBtnOnPurchasingScope									= By.xpath(".//*[@id='purchasingScopeList_wrapper']/div[3]/div/input[2]");
	By		EditBtnOnPUOnMasters									= By.xpath(".//*[@id='purchasingScopeList']/tbody/tr/td[6]/a[1]");
	By		PurchasingScopeOnUsers									= By.xpath(".//*[@id='purchasingScope']");
	By		CompanySearchFieldOnMasters								= By.xpath(".//*[@id='companyList_wrapper']/div[3]/div/input[1]");
	By		ExpandBtnOnOrderTab										= By.xpath(".//*[@id='wrapper']/div[2]/div/div[2]/div[5]/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/a");
	By		RequiredReceiptIcon										= By
		.xpath(".//*[@id='wrapper']/div[2]/div/div[2]/div[5]/div/div/div/div/div/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td[2]/a/span");
	By		ProductSelectionAfterLogin								= By
		.xpath("html/body/div/div[2]/div[1]/div/div[2]/div/div/div[2]/div/ul/li[1]/div[1]/div[2]/div/div[2]/div[1]/img");
	By		CompanyChkBoxListOnPS									= By.xpath("html/body/div[1]/div[3]/div[2]/div[2]/div/div[1]/div[1]/fieldset/form/ol/li[3]/div/p/label/input");
	By		CompanyListOnPS											= By.xpath("html/body/div[1]/div[3]/div[2]/div[2]/div/div[1]/div[1]/fieldset/form/ol/li[3]/div/p/label/span");
	By		categoryPurchaseTypeGLMap								= By.xpath(".//*[@id='Category-Purchase Type GL Maps']/a");
	By		AddBtnOnCategoryPurTypeGLMap							= By.xpath(".//*[@id='addTab']/ul/li[1]/a");
	By		CategoryTextField										= By.xpath(".//*[@id='txtCategoryCode']");
	By		PurchaseTypeCheckBox									= By.xpath(".//*[@id='anyPurchaseTypeCheckbox']");
	By		CompanyOnCategoryPurTypeGlMap							= By.xpath(".//*[@id='selCompany']");
	By		GLAccntType												= By.xpath(".//*[@id='selAccountType']");
	By		GLAccnt													= By.xpath(".//*[@id='txtGLAccount']");
	By		AddBtnCategoryPurchase									= By.xpath(".//*[@id='btnAddCategoryGeneralLedger']");
	By		CategoryGLTypeMapSearch									= By.xpath(".//*[@id='categoryGeneralLedgerListing_wrapper']/div[3]/div/input[1]");
	By		DeleteBtnListOnGLTypePurchasingMap						= By.xpath(".//*[@id='categoryGeneralLedgerListing']/tbody/tr/td[6]/a");
	By		WorkFlowApproversNameList								= By.xpath(".//*[@id='workFlowTrails']/div/div[2]/ul/li/div/div[2]/div[1]");
	By		BackBtnOnMyRequisition									= By.xpath(".//*[@id='wrapper']/div[2]/div/div[2]/div[3]/a");
	By		LocSearchfieldOnLocations								= By.xpath(".//*[@id='locationListing_wrapper']/div[3]/div/input[1]");
	By		ActivateDeactivateToggle								= By.xpath(".//*[@id='locationListing']/tbody/tr/td[7]/a");
	By		BusinessUnitSearchField									= By.xpath(".//*[@id='businessUnitList_wrapper']/div[3]/div/input[1]");
	By		ContinueShoppingInNonEmptyCart							= By.xpath(".//*[@id='cart_noItemsContainer']/div[2]/div/div/input");
	By		CopyLinkOnMyReq											= By.xpath(".//*[@id='reqList']/tbody/tr/td[7]/div/div/ul/li[3]/a");
	By		ReqNameOnCheckOut										= By.xpath(".//*[@id='txtRequisitionName']");
	By		ApprovalTab_Top											= By.xpath(".//*[@id='workflow_approval_top']");
	By		Approval_Sub											= By.xpath(".//*[@id='all_requests_sub']");
	By		ReqNoListOnApprovalTab									= By.xpath(".//*[@id='workflowApproval']/tbody/tr/td[3]/a");
	By		CheckBoxListOnApprovalTab								= By.xpath(".//*[@id='workflowApproval']/tbody/tr/td[1]/input");
	By		ActionBtnOnAllRequisition								= By.xpath(".//*[@id='reqList']/tbody/tr[1]/td[7]/div/div/a");
	By		CopyLinkOnActionBtnOnAllReq								= By.xpath(".//*[@id='reqList']/tbody/tr/td[7]/div/div/ul/li[1]/a");
	By		EditLinkOnActionBtnOnAllReq								= By.xpath(".//*[@id='reqList']/tbody/tr[5]/td[7]/div/div/ul/li[1]/a");

	// Filter type
	By		RequisitionTabFilter1									= By.xpath(".//*[@id='reqList']/thead/tr[2]/th[1]/div/div/span[1]");
	By		RequisitionTabFilter2									= By.xpath(".//*[@id='reqList']/thead/tr[2]/th[5]/div/div/span[1]");
	By		RequsisitionTabFilter3									= By.xpath(".//*[@id='reqList']/thead/tr[2]/th[5]/div/div/span[1]");
	By		RequsisitionTabFilter4									= By.xpath(".//*[@id='reqList']/thead/tr[2]/th[6]/div/div/span[1]");
	By		ApprovalTabFilter1										= By.xpath(".//*[@id='workflowApproval']/thead/tr[2]/th[2]/div/div/b");
	By		BuyersDeskTabFilter1									= By.xpath(".//*[@id='buyerlisting']/thead/tr[2]/th[2]/div/div/span[1]");
	By		POTabFilter1											= By.xpath(".//*[@id='polisting']/thead/tr[2]/th[1]/div/div/b");

	// Requisition Status

	By		expand_Released_Complete_Filter							= By.cssSelector("div.hitarea");
	By		filterNameByValues										= By.cssSelector(".chkLbl");
	By		draft_ByValue											= By.cssSelector("input.inptChk.statusFilterNode");
	By		ready_For_Apporval_ByValue								= By.cssSelector("#readyForApproval > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		in_Approval_ByValue										= By.cssSelector("#inApproval > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		with_Buyer_ByValue										= By.cssSelector("#withBuyer > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		returned_For_amendment_ByValue							= By.cssSelector("#returnedForAmendment > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		scheduled_ByValue										= By.cssSelector("#scheduled > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		released_Complete_ByValue								= By.xpath("(//input[@value=''])[2]");
	By		released_Partially_Order_ByValue						= By.cssSelector("#partiallyOrdered > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		released_Not_Received_ByValue							= By.cssSelector("#notReceived > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		released_Partially_Received_ByValue						= By.cssSelector("#partiallyReceived > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		released_Fully_Received_ByValue							= By.cssSelector("#fullyReceived > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		rejected_ByValue										= By.cssSelector("#rejected > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		closed_ByValue											= By.cssSelector("#closed > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		cancelled_ByValue										= By.cssSelector("#cancelled > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		returned_With_Quote_ByValue								= By.cssSelector("#returnedWithQuote > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		sent_For_Quote_ByValue									= By.cssSelector("#sentForQuote > span > label.chkLbl > input.inptChk.statusFilterNode");

	// filter Name label by Value
	By		draft_Label_ByValue										= By.xpath(".//*[@id='draft']/span/label");
	By		ready_For_Apporval_Label_ByValue						= By.cssSelector("#readyForApproval > span > label.chkLbl   ");
	By		in_Approval_Label_ByValue								= By.cssSelector("#inApproval > span > label.chkLbl  ");
	By		with_Buyer_Label_ByValue								= By.cssSelector("#withBuyer > span > label.chkLbl  ");
	By		returned_For_amendment_Label_ByValue					= By.cssSelector("#returnedForAmendment > span > label.chkLbl  ");
	By		scheduled_Label_ByValue									= By.cssSelector("#scheduled > span > label.chkLbl  ");
	By		released_Complete_label_ByValue							= By.xpath(".//*[@id='released']/span/label");
	By		released_Partially_Order_Label_ByValue					= By.cssSelector("#partiallyOrdered > span > label.chkLbl  ");
	By		released_Not_Received_Label_ByValue						= By.cssSelector("#notReceived > span > label.chkLbl  ");
	By		released_Partially_Received_Label_ByValue				= By.cssSelector("#partiallyReceived > span > label.chkLbl  ");
	By		released_Fully_Received_Label_ByValue					= By.cssSelector("#fullyReceived > span > label.chkLbl  ");
	By		rejected_Label_ByValue									= By.cssSelector("#rejected > span > label.chkLbl  ");
	By		closed_Label_ByValue									= By.cssSelector("#closed > span > label.chkLbl  ");
	By		cancelled_Label_ByValue									= By.cssSelector("#cancelled > span > label.chkLbl  ");
	By		returned_With_Quote_Label_ByValue						= By.cssSelector("#returnedWithQuote > span > label.chkLbl  ");
	By		sent_For_Quote_Label_ByValue							= By.cssSelector("#sentForQuote > span > label.chkLbl  ");

	// Approval Tab

	By		approval_Pending_ByValue								= By.cssSelector("#pending > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		approval_Approved_ByValue								= By.cssSelector("#approved > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		approval_Rejected_ByValue								= By.cssSelector("#rejected > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		approval_Delegated_ByValue								= By.cssSelector("#delegated > span > label.chkLbl > input.inptChk.statusFilterNode");
	By		approval_Urgent_Request_Only_ByValue					= By.cssSelector("input.inptChk.dev_urgentChkBx");
	By		approval_Pending_Since_ByValue							= By.cssSelector("input.inptChk.dev_pendingSinceChkBx");

	// filter Name label by Value

	By		approval_Pending_Label_ByValue							= By.cssSelector("#pending > span > label.chkLbl  ");
	By		approval_Approved_Label_ByValue							= By.cssSelector("#approved > span > label.chkLbl  ");
	By		approval_Rejected_Label_ByValue							= By.cssSelector("#rejected > span > label.chkLbl  ");
	By		approval_Delegated_Label_ByValue						= By.cssSelector("#delegated > span > label.chkLbl  ");
	By		approval_Urgent_Request_Only_Label_ByValue				= By.cssSelector(".urg");

	// buyers desk filters
	By		clearFirstFilter_BuyersDesk								= By.xpath(".//*[@id='buyerlisting']/thead/tr[2]/th[2]/div/div/span[2]");
	By		awaiting_Quote_Filter									= By.xpath(".//*[@id='awaitingQuote']/span/label/input");
	By		pending_Order_Filter									= By.xpath(".//*[@id='pendingOrder']/span/label/input");
	By		unordered_Filter										= By.xpath(".//*[@id='unordered']/span/label/input");
	By		partially_Ordered_Filter								= By.xpath(".//*[@id='partiallyOrdered']/span/label/input");
	By		processed_Filter										= By.xpath(".//*[@id='processed']/span/label/input");
	By		returnedWithQuote_Filter								= By.xpath(".//*[@id='returnedWithQuote']/span/label/input");
	By		returned_For_Modification_Filter						= By.xpath(".//*[@id='returnedForModification']/span/label/input");
	By		scheduledFilter											= By.xpath(".//*[@id='scheduled']/span/label/input");
	By		released_Filter											= By.xpath(".//*[@id='released']/span/label/input");
	By		sourcing_Status_Filter									= By.xpath(".//*[@id='sourcingStatus']/span/label/input");
	By		buyer_Negotiated_Price_Filter							= By.xpath(".//*[@id='buyerNegotiatedPrice']/span/label/input");
	By		quoted_By_Supplier_Filter								= By.xpath(".//*[@id='quotedBySupplier']/span/label/input");
	By		estimated_Price_Filter									= By.xpath(".//*[@id='estimatedPrice']/span/label/input");
	By		needAQuote_Filter										= By.xpath(".//*[@id='needAQuote']/span/label/input");
	By		cancelledFilter											= By.xpath(".//*[@id='cancelled']/span/label/input");
	By		pendingOrderFilter_Expand								= By.xpath(".//*[@id='pendingOrder']/div");
	By		processedOrderFilter_Expand								= By.xpath(".//*[@id='processed']/div");
	By		sourcingFilter_Expand									= By.xpath(".//*[@id='sourcingStatus']/div");

	// filter Name label by Value
	By		awaiting_Quote_Label_ByValue							= By.xpath(".//*[@id='awaitingQuote']/span/label");
	By		pending_Order_Label_ByValue								= By.xpath(".//*[@id='pendingOrder']/span/label");
	By		unordered_Label_ByValue									= By.xpath(".//*[@id='unordered']/span/label");
	By		partially_Ordered_Label_ByValue							= By.xpath(".//*[@id='partiallyOrdered']/span/label");
	By		processed_Label_ByValue									= By.xpath(".//*[@id='processed']/span/label/input");
	By		returnedWithQuote_Label_ByValue							= By.xpath(".//*[@id='returnedWithQuote']/span/label");
	By		returned_For_Modification_Label_ByValue					= By.xpath(".//*[@id='returnedForModification']/span/label");
	By		scheduledLabel_ByValue									= By.xpath(".//*[@id='scheduled']/span/label");
	By		releasedLabel_ByValue									= By.xpath(".//*[@id='released']/span/label");
	By		sourcing_Status_Label_ByValue							= By.xpath(".//*[@id='sourcingStatus']/span/label");
	By		buyerNegotiatedPrice_Label_ByValue						= By.xpath(".//*[@id='buyerNegotiatedPrice']/span/label");
	By		quotedBySupplier_Label_ByValue							= By.xpath(".//*[@id='quotedBySupplier']/span/label");
	By		estimatedPrice_Label_ByValue							= By.xpath(".//*[@id='estimatedPrice']/span/label");
	By		needAQuote_Label_ByValue								= By.xpath(".//*[@id='needAQuote']/span/label");
	By		cancelledLabel_ByValue									= By.xpath(".//*[@id='cancelled']/span/label");

	// PO Filter
	By		draft_PO_Filter											= By.xpath(".//*[@id='draft']/span/label/input");

	// Requisition Checkout Page
	By		reqName													= By.id("txtRequisitionName");
	By		isUrgent												= By.id("radUrgentYes");
	By		reasonForOrdering										= By.id("txtBuyingJustification");
	By		commentForSupplier										= By.id("txtSupplierComment");

	By		searchReqByName											= By.id("txtFltrName");
	By		reqNameFound											= By.cssSelector(".name");
	By		itemsInCart												= By.cssSelector(".bld.cart_items");
	By		viewCartPage											= By.cssSelector("#ui-dialog-title-cart_itemsContainer");
	By		confirmItemAdd											= By.cssSelector(".icon.tickActive");
	By		itemAddedToCart											= By.cssSelector(".item-incart.itemInCart");
	By		addCartViaID											= By.xpath("//*[contains(@id, 'addToCart_list_')]");
	By		continueShopping1										= By.cssSelector(".scLnk.cart_continue");

	// requisition listing page
	By		getReqNos												= By.cssSelector(".requisitionNo.qtipFltrHdr.preWraptxt");
	By		getReqNames												= By.cssSelector(".name");
	By		getReqRequesters										= By.cssSelector(".behalfUserId");
	By		getReqSubmittedOnDates									= By.cssSelector(".submittedOn");
	By		getReqAmounts											= By.cssSelector(".totalAmountReq");
	By		getReqActions											= By.cssSelector(".icon.actLnk");
	By		copyLink												= By.xpath(".//*[@id='reqList']/tbody/tr[1]/td[7]/div/div/ul/li/a");

	By		searchReqByNo											= By.id("txtFltrReqNum");
	By		searchReqByRequester									= By.id("txtFltrRequesterName");
	By		req_Name												= By.xpath(".//*[@id='reqList']/tbody/tr/td[3]");
	By		reqNameXpath											= By.xpath(".//*[@id='reqList']/tbody/tr/td[3]");
	By		requester												= By.xpath(".//*[@id='reqList']/tbody/tr/td[4]");
	By		req_status												= By.xpath(".//*[@id='reqList']/tbody/tr/td[1]/div");
	By		reqNameLink												= By.xpath(".//*[@id='reqList']/tbody/tr/td[2]/a");

	// Submitted on date
	By		dateFrom												= By.id("dp1395911239793");
	By		dateTo													= By.id("dp1395911239794");
	By		submitOnDate											= By.cssSelector(".ui-datepicker-trigger");
	By		minAmount												= By.xpath("//input[@class='inptTxt minAmount']");
	By		maxAmount												= By.xpath("//input[@class='inptTxt maxAmount']");
	By		listOfCurrency											= By.xpath("//input[@class='inptChk inputCurrencies']");

	// ******************************** Himanhsu
	// *************************************************//
	// get Requisition Name after copy the Req
	By		reqNameAfterCopy										= By.xpath(".//*[@id='txtRequisitionName']");
	By		cancelButtonReqPage										= By.xpath(".//*[@id='cancelRequisition']");
	By		UpdateDraft												= By.xpath(".//*[@id='draftRequisition']");
	By		IAmDoneBtnOnMyReq										= By.xpath(".//*[@id='submitRequisition']/span");

	By		onBehalfOf												= By.id("txtBehalfUser");
	By		iAmDone													= By.cssSelector(".inptbtn");
	By		confirmReq												= By.xpath("//button[@type='button']");
	By		confirmSave												= By.xpath("//button[@type='button']");
	By		searchResultNameField									= By.cssSelector("#lblSelectedCategory");
	By		organizationUnit										= By.cssSelector(".bigLblBox");
	By		billingInfo												= By.xpath("//a[@href='#billingSumm']");
	By		billingInforCompanyName									= By.xpath("//input[@name='companyAutoComplete']");
	By		billingInfoBusinessUnit									= By.xpath("//input[@name='buAutoComplete']");
	By		billingInfoLocation										= By.xpath("//input[@name='locationAutoComplete']");
	By		checkoutPageCompany										= By.xpath("//span[@id='orgUnit_company']");
	By		checkoutPageLocation									= By.xpath("//span[@id='orgUnit_location']");
	By		checkoutPageBU											= By.xpath("//span[@id='orgUnit_businessUnit']");
	By		saveReqSummary											= By.id("saveRequisitionSummary");
	By		billTo_Address											= By.cssSelector("#billToAddress_header");
	By		shipTo_Address											= By.cssSelector("#shipToAddress_header");
	By		deliveryAddress											= By.xpath("//a[@href='#deliverySumm']");
	By		RequiredBy												= By.cssSelector("#deliveryOn_header_summary");
	By		RequiredBy_ErrorMsg										= By.cssSelector(".icon.inlineWarning.inlineWarning-small");

	// Delivery Address Custom Field
	By		checkOutPage_deliverTo									= By.cssSelector("#deliverTo_header");
	By		deliveryAddress_MyCustomAddress							= By.xpath("//input[@container='myAddressOption']");
	By		deliveryAddress_CustomAddress_Name						= By.xpath("//input[@id='custom_name_headerCustomAddress']");

	// By deliveryAddress_CustomAddress = By.xpath("//a[@class='scLnk
	// createNewMyAddress']");

	By		deliveryAddress_CustomAddress							= By.xpath(".//*[@id='customAddress_headerCustomAddress']/div[1]/label[3]/input");
	By		deliveryAddress_CustomAddress_Streelt1					= By.xpath("//input[@id='custom_street1_headerCustomAddress']");
	By		deliveryAddress_CustomAddress_Streelt2					= By.xpath("//input[@id='custom_street2_headerCustomAddress']");
	By		deliveryAddress_CustomAddress_City						= By.xpath("//input[@id='custom_city_headerCustomAddress']");
	By		deliveryAddress_CustomAddress_County					= By.xpath("//input[@id='custom_county_headerCustomAddress']");
	By		deliveryAddress_CustomAddress_Country					= By.xpath("//select[@id='custom_country_headerCustomAddress']");
	By		deliveryAddress_CustomAddress_State						= By.xpath("//select[@id='custom_state_headerCustomAddress']");
	By		deliveryAddress_CustomAddress_Zip						= By.xpath("//input[@id='custom_zip_headerCustomAddress']");
	By		deliveryAddress_CustomAddress_SaveForNext				= By.xpath("//input[@id='custom_save_address_headerCustomAddress']");
	By		deliveryAddress_Header									= By.xpath(".//*[@id='shipToAddress_header']/div");
	By		deliveryAddress_DelieveredTo							= By.xpath("//input[@id='deliverTo_summary']");
	By		deliveryAddress_searchExistingAddress					= By.xpath("//input[contains(@name,'customAddresses_headerCustomAddress')]");
	// Cost Center Details
	By		checkOutPage_costCenter									= By.cssSelector("#costCenter_header");
	By		billingInfo_CoskBooking									= By.xpath("//a[@href='#reqCostbooking']");
	By		coskBooking_EnterCostCenter								= By.xpath("//input[@id='costCenter_summary']");

	By		availabilityForItem										= By.cssSelector(".availability");
	By		clearDate												= By.cssSelector("#clearDeliveryOn_header_summary");
	By		addNewItem												= By.cssSelector(".mnBtn.addMoreItemsBtn.addMoreItems>b");
	By		splitDilvery											= By.xpath(".//*[@id='optMultiSplit']");
	By		saveItemSummary											= By.xpath("//input[@id='saveRequisitionItemSummary']");
	By		deliveredOnDate											= By.xpath(".//input[contains(@id,'deliveryOn_')]");

	By		clearDeliveryDate										= By.id("clearDeliveryOn_header_summary");
	By		requiredByDateField										= By.id("deliveryOn_header_summary");
	By		errorMessage_forMandatory								= By.xpath(".//*[@id='messageContainer']/div/div[2]/span");
	By		costCenterHeader										= By.id("costCenter_header");
	By		businessUnit_BU											= By.id("orgUnit_businessUnit");
	By		deliveryAddressHeader									= By.xpath(".//*[@id='shipToAddress_header']/div");
	By		billingToAddressHeader									= By.xpath(".//*[@id='billToAddress_header']/div");
	By		itemInternalComment										= By.id("txtItemInternalComment");
	By		itemSupplierComment										= By.id("txtItemSupplierComment");

	// ********************************************
	// Himanshu.Singh****************************************
	By		TotalQuantityOnItemSummary								= By.xpath(".//*[@id='txtItemQuantity']");
	By		OnBehalfOf												= By.xpath(".//*[@id='txtBehalfUser']");
}
