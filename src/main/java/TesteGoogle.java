import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
	@Test
	public void teste() {
		//Firefox
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		//Chrome
		//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		//WebDriver driver = new ChromeDriver();
		
		//Microsoft Edge
		//System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();
		
		driver.manage().window().setSize(new Dimension(1200, 765));
		//driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		
		//Fecha o Browser e Instância
		driver.quit();
	}

}