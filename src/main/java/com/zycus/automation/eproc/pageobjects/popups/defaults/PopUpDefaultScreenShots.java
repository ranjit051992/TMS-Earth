/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.defaults;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author puneet.sharma
 *
 */
public class PopUpDefaultScreenShots
{
	// BEFORE
	public static void isPopUpPresentScreenShotBefore(WebDriver driver, String testCaseName)
	{
		ScreenShot.screenshot(driver, testCaseName, "isPopUpPresentScreenShotBefore");
	}

	public static void acceptScreenShotBefore(WebDriver driver, String testCaseName)
	{
		ScreenShot.screenshot(driver, testCaseName, "acceptScreenShotBefore");
	}

	public static void rejectScreenShotBefore(WebDriver driver, String testCaseName)
	{
		ScreenShot.screenshot(driver, testCaseName, "rejectScreenShotBefore");
	}

	public static void closePopUpScreenShotBefore(WebDriver driver, String testCaseName)
	{
		ScreenShot.screenshot(driver, testCaseName, "closePopUpScreenShotBefore");
	}

	public static void moveOnPopScreenShotBefore(WebDriver driver, String testCaseName)
	{
		ScreenShot.screenshot(driver, testCaseName, "moveOnPopScreenShotBefore");
	}

	// AFTER
	public static void isPopUpPresentScreenShotAfter(WebDriver driver, String testCaseName)
	{
		ScreenShot.screenshot(driver, testCaseName, "isPopUpPresentScreenShotAfter");
	}

	public static void acceptScreenShotAfter(WebDriver driver, String testCaseName)
	{
		ScreenShot.screenshot(driver, testCaseName, "acceptScreenShotAfter");
	}

	public static void rejectScreenShotAfter(WebDriver driver, String testCaseName)
	{
		ScreenShot.screenshot(driver, testCaseName, "rejectScreenShotAfter");
	}

	public static void closePopUpScreenShotAfter(WebDriver driver, String testCaseName)
	{
		ScreenShot.screenshot(driver, testCaseName, "closePopUpScreenShotAfter");
	}

	public static void moveOnPopScreenShotAfter(WebDriver driver, String testCaseName)
	{
		ScreenShot.screenshot(driver, testCaseName, "moveOnPopScreenShotAfter");
	}

	public static void after(WebDriver driver, String testCaseName, String str)
	{
		ScreenShot.screenshot(driver, testCaseName, str);
	}

	public static void before(WebDriver driver, String testCaseName, String str)
	{
		ScreenShot.screenshot(driver, testCaseName, str);
	}

}
