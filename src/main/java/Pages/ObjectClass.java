package Pages;

public interface ObjectClass
{
    int EXPLICIT_WAIT = 20000;

    String GHOST_EMAIL_ADDRESS_TEXTBOX = "//input[@id='emailAddressGhost']";
    String EMAIL_ADDRESS_TEXTBOX = "//input[@name='emailAddress']";
    String GHOST_PASSWORD_TEXTBOX = "//input[@name='pass_temp']";
    String PASSWORD_TEXTBOX = "//input[@id='password']";
    String LOGIN_BUTTON = "//input[@id='signIn']";
    String LOADER_SYMBOL = "//dew-spinner[@class='dew-spinner']";
    String ONLINE_STORE_REQ_TABLE_ROW = "//dew-row[@class='purchase-listing row']";
    String SEARCH_TEXTBOX = "//input[contains(@class,'form-control')]";
    String HOME_LINK = "//a[text()='Home']";
    String FAVORITES_AND_PREVIOUSLY_USED_TAB = "//dew-default-tab-head[contains(text(),'Favorites & Previously Used')]";
    String ONLINE_STORE_TABS_SECTION = "//dew-flex-item";
    String ADD_TO_CART_BUTTON = "//button[contains(@class,'btn primary btn-block btn-lg')]";
    String FAVORITES_ITEM_LIST = "//span[@class='text-title pointer dName']";
    String FAV_VIEW_ALL_BUTTON = "//dew-section[@class='pt-0 dew-section']//span[@class='btn-text d-block'][contains(text(),'View All')]";


    String CART_ICON = "//dew-icon[@icon='cart']";
    String ADD_TO_BASKET = "//button[@class='btn view EPROC_BUTTON_ADD_TO_BASKET']";
    String CREATE_NEW_BASKET = "//label[contains(@class,'EPROC_ADD_TO_BASKET_MODAL_OPTION_CREATE_NEW')]";
    String ENTER_NEW_BASKET_NAME = "//input[contains(@class,'EPROC_ADD_TO_BASKET_MODAL_PLACEHOLDER_ENTER_BASKET_NAME')]";
    String ADD_TO_BASKET_MODAL_BUTTON = "//dew-modal-footer//button[contains(@class,'EPROC_BUTTON_ADD_TO_BASKET')]";
    String ADD_TO_BASKET_SPINNER = "//div[@class='spinner']";
    String ADD_TO_CART_SUCCESS_MSG = "//div[contains(@class,'alert-success')]";
}
