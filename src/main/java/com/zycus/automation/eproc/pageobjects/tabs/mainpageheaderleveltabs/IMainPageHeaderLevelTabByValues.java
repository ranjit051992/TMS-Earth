package com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IMainPageHeaderLevelTabByValues
{

	// REQUISITION TAB
	final static UI_Elements	REQUISITION											= UIFactory.getElements("REQUISITION");
	final static UI_Elements	ONLINE_STORES										= UIFactory.getElements("ONLINE_STORES");
	final static UI_Elements	MY_REQUISITION										= UIFactory.getElements("MY_REQUISITION");
	final static UI_Elements	MY_FAVORITES										= UIFactory.getElements("MY_FAVORITES");
	final static UI_Elements	SHOPPING_BASKET										= UIFactory.getElements("SHOPPING_BASKET");
	final static UI_Elements	ALL_REQUISITION										= UIFactory.getElements("ALL_REQUISITION");

	// APPROVAL TAB
	final static UI_Elements	APPROVAL											= UIFactory.getElements("APPROVAL");
	final static UI_Elements	APPROVAL_SUB										= UIFactory.getElements("APPROVAL_SUB");
	final static UI_Elements	ALL_REQUESTS										= UIFactory.getElements("ALL_REQUESTS");
	final static UI_Elements	My_SETTINGS											= UIFactory.getElements("My_SETTINGS");

	// SETUP TAB
	final static UI_Elements	SETUP												= UIFactory.getElements("SETUP");
	final static UI_Elements	SETUP_SUB											= UIFactory.getElements("SETUP_SUB");
	final static UI_Elements	MASTER_DATA											= UIFactory.getElements("MASTER_DATA");
	final static UI_Elements	CUSTOMIZE											= UIFactory.getElements("CUSTOMIZE");

	// PO TAB
	final static UI_Elements	PO													= UIFactory.getElements("PO");

	// BUYERS DESK TAB
	final static UI_Elements	BUYERS_DESK_TOP										= UIFactory.getElements("BUYERS_DESK_TOP");
	final static UI_Elements	BUYERS_DESK_SUB										= UIFactory.getElements("BUYERS_DESK_SUB");
	static UI_Elements			UPCOMING_REQUISITION_TAB							= UIFactory.getElements("UPCOMING_REQUISITION_TAB");

	final static UI_Elements	DISPLAY_USER_NAME									= UIFactory.getElements("DISPLAY_USER_NAME");

	// invoice
	final static UI_Elements	INVOICE_TOP											= UIFactory.getElements("INVOICE_TOP");
	final static UI_Elements	INVOICE_SUB											= UIFactory.getElements("INVOICE_SUB");
	final static UI_Elements	E_INVOICE_MAILBOX									= UIFactory.getElements("E_INVOICE_MAILBOX");

	// catalog
	final static UI_Elements	CATALOG_SUB_TAB										= UIFactory.getElements("CATALOG_SUB_TAB");
	final static UI_Elements	CATALOG_TOP_TAB										= UIFactory.getElements("CATALOG_TOP_TAB");

	// inventory
	final static UI_Elements	INVENTORY_TOP_TAB									= UIFactory.getElements("INVENTORY_TOP_TAB");

	final static UI_Elements	ITEM_MASTER_INVENTORY_TAB							= UIFactory.getElements("ITEM_MASTER_INVENTORY_TAB");

	// eform
	final static UI_Elements	EFORM_TAB											= UIFactory.getElements("EFORM_TAB");
	final static UI_Elements	PROCESS_EFORM_TAB									= UIFactory.getElements("PROCESS_EFORM_TAB");
	final static UI_Elements	CATEGORY_EFORM_TAB									= UIFactory.getElements("CATEGORY_EFORM_TAB");
	final static UI_Elements	PROFILE_TAB											= UIFactory.getElements("PROFILE_TAB");
	final static UI_Elements	CONFIGURATION_TAB									= UIFactory.getElements("CONFIGURATION_TAB");

	final static UI_Elements	MANAGE_PROFILE_TAB									= UIFactory.getElements("MANAGE_PROFILE_TAB");

	// budget
	final static UI_Elements	BUDGET_TAB											= UIFactory.getElements("BUDGET_TAB");

	// PCARD
	final static UI_Elements	PCARD_TAB											= UIFactory.getElements("PCARD_TAB");
	final static UI_Elements	PCARD_SUB_TAB										= UIFactory.getElements("PCARD_SUB_TAB");

	// REPORT TAB
	final static UI_Elements	REPORT_TAB											= UIFactory.getElements("REPORT_TAB");

	// suppliers tab
	final static UI_Elements	SUPPLIERS_TOP_TAB									= UIFactory.getElements("SUPPLIERS_TOP_TAB");
	final static UI_Elements	SUPPLIERS_SUB_TAB									= UIFactory.getElements("SUPPLIERS_SUB_TAB");
	final static UI_Elements	SUPPLIERS_ONBOARDING_SUB_TAB						= UIFactory.getElements("SUPPLIERS_ONBOARDING_SUB_TAB");

	// product switch tabs
	UI_Elements					BUTTON_OPEN_PRODUCT_SELECTION						= UIFactory.getElements("BUTTON_OPEN_PRODUCT_SELECTION");
	UI_Elements					EINVOICE_PRODUCT_SELECTION_TAB_ON_SWITCH_PRODUCT	= UIFactory.getElements("EINVOICE_PRODUCT_SELECTION_TAB_ON_SWITCH_PRODUCT");
	UI_Elements					EPROC_PRODUCT_SELECTION_TAB_ON_SWITCH_PRODUCT		= UIFactory.getElements("EPROC_PRODUCT_SELECTION_TAB_ON_SWITCH_PRODUCT");

	UI_Elements					TMS_PRODUCT_SELECTION_TAB_ON_SWITCH_PRODUCT			= UIFactory.getElements("TMS_PRODUCT_SELECTION_TAB_ON_SWITCH_PRODUCT");

	UI_Elements					ISOURCE_PRODUCT_SELECTION_TAB_ON_SWITCH_PRODUCT		= UIFactory.getElements("ISOURCE_PRODUCT_SELECTION_TAB_ON_SWITCH_PRODUCT");

	// Master Data Page

	final static UI_Elements	LINK_EXIT_MASTER_DATA								= UIFactory.getElements("LINK_EXIT_MASTER_DATA");

	// USER MANAGEMENT TAB

	final static UI_Elements	USERS_TAB_USER_MANAGEMENT							= UIFactory.getElements("USERS_TAB_USER_MANAGEMENT");
	final static UI_Elements	TEXT_SEARCH_USER_USERMANAGEMENT						= UIFactory.getElements("TEXT_SEARCH_USER_USERMANAGEMENT");
	final static UI_Elements	DROPDOWN_SEARCH_IN_TYPE								= UIFactory.getElements("DROPDOWN_SEARCH_IN_TYPE");
	final static UI_Elements	BUTTON_GO											= UIFactory.getElements("BUTTON_GO");
	final static UI_Elements	LINK_EDIT_USERMANAGEMENT							= UIFactory.getElements("LINK_EDIT_USERMANAGEMENT");

	//RAINBOW MENU
	final static UI_Elements	HEADER_MENU_RAINBOW									= UIFactory.getElements("HEADER_MENU_RAINBOW");
	final static UI_Elements	EPROC_PRODUCT_RAINBOW								= UIFactory.getElements("EPROC_PRODUCT_RAINBOW");

	//RAINBOW MENU --> REQUISITION
	final static UI_Elements	REQUISITION_RAINBOW									= UIFactory.getElements("REQUISITION_RAINBOW");
	final static UI_Elements	ONLINE_STORES_RAINBOW								= UIFactory.getElements("ONLINE_STORES_RAINBOW");
	final static UI_Elements	MY_REQUISITION_RAINBOW								= UIFactory.getElements("MY_REQUISITION_RAINBOW");
	final static UI_Elements	MY_FAVORITES_RAINBOW								= UIFactory.getElements("MY_FAVORITES_RAINBOW");
	final static UI_Elements	SHOPPING_BASKET_RAINBOW								= UIFactory.getElements("SHOPPING_BASKET_RAINBOW");
	final static UI_Elements	ALL_REQUISITION_RAINBOW								= UIFactory.getElements("ALL_REQUISITION_RAINBOW");
	final static UI_Elements	VIEW_ORDER_RAINBOW									= UIFactory.getElements("VIEW_ORDER_RAINBOW");
	final static UI_Elements	REQUISITION_QUICK_SOURCE_EVENT_RAINBOW				= UIFactory.getElements("REQUISITION_QUICK_SOURCE_EVENT_RAINBOW");

	//RAINBOW MENU --> APPROVAL
	final static UI_Elements	APPROVAL_RAINBOW									= UIFactory.getElements("APPROVAL_RAINBOW");
	final static UI_Elements	APPROVAL_SUB_RAINBOW								= UIFactory.getElements("APPROVAL_SUB_RAINBOW");
	final static UI_Elements	ALL_REQUESTS_RAINBOW								= UIFactory.getElements("ALL_REQUESTS_RAINBOW");
	final static UI_Elements	MY_SETTINGS_RAINBOW									= UIFactory.getElements("MY_SETTINGS_RAINBOW");

	//RAINBOW MENU --> BUYER DESK
	final static UI_Elements	BUYER_DESK_RAINBOW									= UIFactory.getElements("BUYER_DESK_RAINBOW");
	final static UI_Elements	BUYERS_DESK_SUB_RAINBOW								= UIFactory.getElements("BUYERS_DESK_SUB_RAINBOW");
	final static UI_Elements	UPCOMING_REQUISITION_TAB_RAINBOW					= UIFactory.getElements("UPCOMING_REQUISITION_TAB_RAINBOW");
	final static UI_Elements	BUYER_QUICK_SOURCE_EVENT_RAINBOW					= UIFactory.getElements("BUYER_QUICK_SOURCE_EVENT_RAINBOW");

	//RAINBOW MENU --> PO
	final static UI_Elements	PO_RAINBOW											= UIFactory.getElements("PO_RAINBOW");

	//RAINBOW MENU --> REPORT
	final static UI_Elements	REPORTS_RAINBOW										= UIFactory.getElements("REPORTS_RAINBOW");

	//RAINBOW MENU --> P-CARD
	final static UI_Elements	PCARD_RAINBOW										= UIFactory.getElements("PCARD_RAINBOW");

	//RAINBOW MENU --> SETUP
	final static UI_Elements	SETUP_RAINBOW										= UIFactory.getElements("SETUP_RAINBOW");
	final static UI_Elements	MASTER_DATA_RAINBOW									= UIFactory.getElements("MASTER_DATA_RAINBOW");
	final static UI_Elements	CUSTOMIZE_RAINBOW									= UIFactory.getElements("CUSTOMIZE_RAINBOW");

	//RAINBOW MENU --> CATALOG
	final static UI_Elements	CATALOG_RAINBOW										= UIFactory.getElements("CATALOG_RAINBOW");
	final static UI_Elements	CATALOG_SUB_TAB_RAINBOW								= UIFactory.getElements("CATALOG_SUB_TAB_RAINBOW");
	final static UI_Elements	PROCUREMENT_CONTRACT_RAINBOW						= UIFactory.getElements("PROCUREMENT_CONTRACT_RAINBOW");
	final static UI_Elements	PUNCHOUT_RAINBOW									= UIFactory.getElements("PUNCHOUT_RAINBOW");
	final static UI_Elements	CATALOG_SETTING_RAINBOW								= UIFactory.getElements("CATALOG_SETTING_RAINBOW");

	//RAINBOW MENU --> INVENTORY
	final static UI_Elements	INVENTORY_RAINBOW									= UIFactory.getElements("INVENTORY_RAINBOW");
	final static UI_Elements	ITEM_MASTER_INVENTORY_TAB_RAINBOW					= UIFactory.getElements("ITEM_MASTER_INVENTORY_TAB_RAINBOW");
	final static UI_Elements	BUSINESS_RULE_INVENTORY_TAB_RAINBOW					= UIFactory.getElements("BUSINESS_RULE_INVENTORY_TAB_RAINBOW");

	//RAINBOW MENU --> WORKFLOW
	final static UI_Elements	WORKFLOW_RAINBOW									= UIFactory.getElements("WORKFLOW_RAINBOW");

	//RAINBOW MENU --> EFORM
	final static UI_Elements	EFORM_RAINBOW										= UIFactory.getElements("EFORM_RAINBOW");
	final static UI_Elements	PROCESS_EFORM_TAB_RAINBOW							= UIFactory.getElements("PROCESS_EFORM_TAB_RAINBOW");
	final static UI_Elements	CATEGORY_EFORM_TAB_RAINBOW							= UIFactory.getElements("CATEGORY_EFORM_TAB_RAINBOW");

	//RAINBOW MENU --> BUDGET
	final static UI_Elements	BUDGET_RAINBOW										= UIFactory.getElements("BUDGET_RAINBOW");

	//RAINBOW MENU --> CONFIGURATION
	final static UI_Elements	CONFIGURATION_RAINBOW								= UIFactory.getElements("CONFIGURATION_RAINBOW");

	//RAINBOW MENU --> EPROC-HELP
	final static UI_Elements	EPROC_HELP_RAINBOW									= UIFactory.getElements("EPROC_HELP_RAINBOW");

	//RAINBOW MENU --> OTHERS
	final static UI_Elements	USER_ICON_HEADER_RAINBOW							= UIFactory.getElements("USER_ICON_HEADER_RAINBOW");
	final static UI_Elements	MY_PROFILE_RAINBOW									= UIFactory.getElements("MY_PROFILE_RAINBOW");
	//TMS
	final static UI_Elements	TAB_MASTER_DATA_TMS									= UIFactory.getElements("TAB_MASTER_DATA_TMS");
	final static UI_Elements	PROCUREMENT_CONTRACTS_SUB_TAB_LINK					= UIFactory.getElements("PROCUREMENT_CONTRACTS_SUB_TAB_LINK");

	final static UI_Elements	TRY_AGAIN_ERROR_MESSAGE								= UIFactory.getElements("TRY_AGAIN_ERROR_MESSAGE");
}
