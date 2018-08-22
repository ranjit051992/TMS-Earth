package com.zycus.automation.tenanatCreation.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test
{

	public static void main(String[] args)
	{
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\tenant\\tenantCreation\\exec\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

}
