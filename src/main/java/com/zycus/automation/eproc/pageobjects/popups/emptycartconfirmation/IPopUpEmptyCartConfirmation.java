/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.emptycartconfirmation;

import org.openqa.selenium.By;

import com.zycus.automation.eproc.pageobjects.popups.defaults.IPopUpDefaultOperations;

/**
 * @author puneet.sharma
 *
 */
public interface IPopUpEmptyCartConfirmation extends IPopUpDefaultOperations
{
	final static By	YES								= By.xpath("//*[text()='Yes']");
	final static By	NO								= By.xpath("//*[text()='No']");
	final static By	CLOSE							= By.xpath("//span[contains(.,'close')]");
	final static By	CHECKOUT_CONFIRMATION_POP_UP	= By.xpath(".//*[@id='ui-dialog-title-2']");
}
