package com.zycus.automation.testnewversion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestScript
{
	public static void main(String str[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.get("https://eproclab.zycus.net/eproc/");
		System.out.println("Hello complete");
	}
}
