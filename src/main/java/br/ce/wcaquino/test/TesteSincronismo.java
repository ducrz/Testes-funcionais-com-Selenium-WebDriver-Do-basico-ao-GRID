package br.ce.wcaquino.test;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.core.DSL;

public class TesteSincronismo {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa(){
		//Firefox
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		//driver.quit();
	}
	
	@Test
	public void utilizarEsperaFixa() throws InterruptedException{
		dsl.clicarBotao("buttonDelay");
		Thread.sleep(5000);
		
		dsl.escrever("novoCampo", "Deu certo?");
	}
	
	@Test
	public void utilizarEsperaImplicita() throws InterruptedException{
		dsl.clicarBotao("buttonDelay");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dsl.escrever("novoCampo", "Deu certo?");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	@Test
	public void utilizarEsperaExplicita() throws InterruptedException{
		dsl.clicarBotao("buttonDelay");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.escrever("novoCampo", "Deu certo?");
	}
}