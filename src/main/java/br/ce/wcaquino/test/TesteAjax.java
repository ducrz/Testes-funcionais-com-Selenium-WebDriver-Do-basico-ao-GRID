package br.ce.wcaquino.test;
import static br.ce.wcaquino.core.DriverFactory.getDriver;
import static br.ce.wcaquino.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.core.DSL;

public class TesteAjax {
	
	private DSL dsl;

	@Before
	public void inicializa(){
		//Firefox
	
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		killDriver();
	}

	@Test
	public void testAjax(){
		dsl.escrever("j_idt303:name", "Eduardo");
		dsl.clicarBotao("j_idt303:j_idt307");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		//	wait.until(ExpectedConditions.textToBe(By.id("j_idt85:display"), "Teste"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt303")));
		Assert.assertEquals("Eduardo", dsl.obterTexto("j_idt303:display"));
	}
}