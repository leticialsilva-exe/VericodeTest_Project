package com.tricentis.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
//	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		if(driver == null){
			switch (Propriedades.browser) {
				case FIREFOX: driver = new FirefoxDriver(); break;
				case CHROME:  driver = new ChromeDriver(); break;
			}
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver-mac-arm64/chromedriver");
			driver.manage().window().setPosition(new Point(10, 10));
			driver.manage().window().setSize(new Dimension(1000, 1000));
		}
		return driver;
	}
	
	public static void killDriver() {
		if(driver!=null) {
			driver.quit();
			driver = null;
		}
	}

}
