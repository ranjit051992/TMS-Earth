/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.defaults;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;

/**
 * @author puneet.sharma
 *
 */
public interface IPopUpDefaultOperations
{

	boolean isPopUpPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	void accept(WebDriver driver, String testCaseName) throws ActionBotException;

	void reject(WebDriver driver, String testCaseName) throws ActionBotException;

	void closePopUp(WebDriver driver, String testCaseName) throws ActionBotException;

	void moveOnPop(WebDriver driver, String testCaseName) throws ActionBotException;
}
