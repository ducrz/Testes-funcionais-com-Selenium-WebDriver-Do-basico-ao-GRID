import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestePrime {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa(){
		//Firefox
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza(){
		driver.quit();
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
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt303:option", "Option1");
		Assert.assertEquals("Option1", dsl.obterTexto("j_idt303:Option1"));
	}
}
