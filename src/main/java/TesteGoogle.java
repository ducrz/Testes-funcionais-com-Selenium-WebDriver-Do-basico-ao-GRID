import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/home/eduardo/Documentos/CursoTestesFuncionaiscomSeleniumWebDriverDobásicoaoGRID/Testes-funcionais-com-Selenium-WebDriver-Do-basico-ao-GRID/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver", "/home/eduardo/Documentos/CursoTestesFuncionaiscomSeleniumWebDriverDobásicoaoGRID/Testes-funcionais-com-Selenium-WebDriver-Do-basico-ao-GRID/drivers/geckodriver");
		//WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
	}

}