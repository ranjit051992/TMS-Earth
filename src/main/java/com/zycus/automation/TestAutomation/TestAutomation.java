package com.zycus.automation.TestAutomation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;

public class TestAutomation
{

	public static void main(String str[]) throws IOException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\Ghecko-19.0\\geckodriver.exe");
		/*
		 * ProfilesIni prof = new ProfilesIni(); FirefoxProfile ffProfile =
		 * prof.getProfile("myProfile"); WebDriver driver = new FirefoxDriver();
		 */

		DesiredCapabilities firefoxCapability = DesiredCapabilities.firefox();
		firefoxCapability.setCapability("acceptInsecureCerts",true);
		WebDriver driver = new FirefoxDriver(firefoxCapability);
		driver.get("https://eproclab.zycus.net/eproc/");
		
		/*FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setAcceptUntrustedCertificates(true);
		firefoxProfile.setAssumeUntrustedCertificateIssuer(false);
		//JavaScriptError.addExtension(firefoxProfile);
		WebDriver driver = new FirefoxDriver(firefoxProfile);
		driver.get("https://eproclab.zycus.net/eproc/");*/

	}
}
