package br.ce.wcaquino.core;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.ce.wcaquino.core.Propriedades.TipoExecucao;

public class DriverFactory {
	
	//private static WebDriver driver;
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
		@Override
		protected synchronized WebDriver initialValue(){
			return initDriver();
		}
	};
	
	private DriverFactory() {}
	
	public static WebDriver getDriver(){
		return threadDriver.get();
	}
	
	public static WebDriver initDriver(){
		WebDriver driver = null;
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
			switch (Propriedades.BROWSER) {
				case FIREFOX:
					System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
					driver = new FirefoxDriver();				
				break;
				case CHROME:
					System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
					driver = new ChromeDriver();
				break;
				case EDGE:
					System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
					driver = new ChromeDriver();
				break;

			}
		}
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
			DesiredCapabilities cap = null;
			switch (Propriedades.BROWSER) {
				case FIREFOX: cap = DesiredCapabilities.firefox(); break;
				case CHROME: cap = DesiredCapabilities.chrome(); break;
				case EDGE: cap = DesiredCapabilities.edge(); break;

			}
			try {
				driver = new RemoteWebDriver(new URL("http://locahost:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				System.err.println("Falha na conexão com o GRID");
				e.printStackTrace();
			}
		}
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.NUVEM) {
			DesiredCapabilities cap = null;
			switch (Propriedades.BROWSER) {
				case FIREFOX: cap = DesiredCapabilities.firefox(); break;
				case CHROME: cap = DesiredCapabilities.chrome(); break;
				case EDGE:
					cap = DesiredCapabilities.edge();
					cap.setCapability("platform", "Windows 10");
					cap.setCapability("version", "latest");
					
					break;
			}
			try {
				driver = new RemoteWebDriver(new URL("https://USUARIO:ACESSKEY@ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap);
			} catch (MalformedURLException e) {
				System.err.println("Falha na conexão com a Saucelabs");
				e.printStackTrace();
			}
		}
		driver.manage().window().setSize(new Dimension(1200, 765));			
		return driver;
	}

	public static void killDriver(){
		WebDriver driver = getDriver();
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}
}