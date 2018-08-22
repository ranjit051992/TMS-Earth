package com.zycus.automation.utilities.loginlogout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.User;
import com.zycus.automation.eproc.pageobjects.pages.invoicelisting.IPageInvoiceListing;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.IPageOnlineStore;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.LoginLogoutException;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

public interface ILogin
{
	By					PRODUCT_HOME_PAGE_UNIQUE_ELEMENT_FOR_EPROC		= IPageOnlineStore.TEXTBOX_ENTER_SEARCH_NAME.getBy();
	By					PRODUCT_HOME_PAGE_UNIQUE_ELEMENT_FOR_EINVOICE	= IPageInvoiceListing.BUTTON_ADD_INVOICE.getBy();
	UI_Elements			PRODUCT_HOME_PAGE_UNIQUE_ELEMENT_FOR_SIM		= UIFactory.getElements("PRODUCT_HOME_PAGE_UNIQUE_ELEMENT_FOR_SIM");
	UI_Elements			EPROC_PRODUCT_SELECTION_TAB						= UIFactory.getElements("EPROC_PRODUCT_SELECTION_TAB");
	UI_Elements			EINVOICE_PRODUCT_SELECTION_TAB					= UIFactory.getElements("EINVOICE_PRODUCT_SELECTION_TAB");
	UI_Elements			TMS_PRODUCT_SELECTION_TAB						= UIFactory.getElements("TMS_PRODUCT_SELECTION_TAB");
	UI_Elements			SIM_PRODUCT_SELECTION_TAB						= UIFactory.getElements("SIM_PRODUCT_SELECTION_TAB");
	By					PRODUCT_HOME_PAGE_UNIQUE_ELEMENT_FOR_TMS		= By.xpath(".//*[@id='eventSearchText']");
	UI_Elements			ARROW_NEXT_ON_PRODUCT_SELECTION_TAB				= UIFactory.getElements("ARROW_NEXT_ON_PRODUCT_SELECTION_TAB");
	UI_Elements			ICONTRACT_PRODUCT_SELECTION_TAB					= UIFactory.getElements("ICONTRACT_PRODUCT_SELECTION_TAB");
	UI_Elements			PRODUCT_HOME_PAGE_UNIQUE_ELEMENT_FOR_ICONTRACT	= UIFactory.getElements("PRODUCT_HOME_PAGE_UNIQUE_ELEMENT_FOR_ICONTRACT");
	UI_Elements			PRODUCT_HOMEPAGE_UNIQUE_ELEMENT_FOR_ZSN			= UIFactory.getElements("PRODUCT_HOMEPAGE_UNIQUE_ELEMENT_FOR_ZSN");
	UI_Elements			MODULE_CAROUSAL									= UIFactory.getElements("MODULE_CAROUSAL");
	UI_Elements			LABEL_ZSP_LOGIN_LOGO							= UIFactory.getElements("LABEL_ZSP_LOGIN_LOGO");
	UI_Elements			LINK_FORGOT_PASSWORD_ZSN						= UIFactory.getElements("LINK_FORGOT_PASSWORD_ZSN");
	UI_Elements			ZSN_NOTIFICATION_MESSAGE						= UIFactory.getElements("ZSN_NOTIFICATION_MESSAGE");

	static UI_Elements	GO_TO_PRODUCT_SELECTION_TAB						= UIFactory.getElements("GO_TO_PRODUCT_SELECTION_TAB");
	static UI_Elements	HEADER_PRODUCT_SELECTION_TAB					= UIFactory.getElements("HEADER_PRODUCT_SELECTION_TAB");

	public void login(WebDriver driver, TestCase testCase, User user) throws TestCaseException, ActionBotException, LoginLogoutException;

	public User beforeLogin(WebDriver driver, TestCase testCase);

	public void afterLogin(WebDriver driver, TestCase testCase, User user) throws TestCaseException, ActionBotException;

	void login(WebDriver driver, TestCase testCase, User user, String productName) throws TestCaseException, ActionBotException, LoginLogoutException;

	public void login(WebDriver driver, TestCase testCase, String role) throws TestCaseException, ActionBotException, LoginLogoutException;

}
