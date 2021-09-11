package br.ce.wcaquino.test;
import static br.ce.wcaquino.core.DriverFactory.getDriver;
import static br.ce.wcaquino.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.wcaquino.core.DSL;

public class TestePrime {

	private DSL dsl;

	@Before
	public void inicializa(){
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		killDriver();
	}

	@Test
	public void interagirComRadioPrime(){
		dsl.clicarRadio(By.xpath("//input[@id='j_idt304:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt304:console:0"));
		dsl.clicarRadio(By.xpath("//label[.='Option 1']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt304:console:1"));
		
	}
	@Test
	public void interagircomSelectPrime(){
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt303:option", "Option1");
		Assert.assertEquals("Option1", dsl.obterTexto("j_idt303:Option1"));
	}
}
