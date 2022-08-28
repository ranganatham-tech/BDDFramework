package config;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartBrowser {

	public static WebDriver driver;
	
	ConfigFileReader configFileReader;
	
	@BeforeClass
	public void beforeClass() {
		configFileReader = new ConfigFileReader();
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void afterClass() {
		//driver.close();
	}
}
