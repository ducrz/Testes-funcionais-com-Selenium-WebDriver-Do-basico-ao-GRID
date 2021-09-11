package br.ce.wcaquino.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver(){
		if(driver == null) {
			switch (Propriedades.browser) {
				case FIREFOX: 
					System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
					driver = new FirefoxDriver();					
					break;
				case CHROME: 					
					System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
					driver = new ChromeDriver();
					break;
			}
			driver.manage().window().setSize(new Dimension(1200, 765));			
		}
		return driver;
	}

	public static void killDriver(){
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}