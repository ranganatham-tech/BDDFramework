package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import config.ConfigFileReader;
import config.StartBrowser;
import io.cucumber.java.en.*;
import objectRepository.howToDoLaundry_6;

public class HowToDoLaundry_6 extends StartBrowser {

	ConfigFileReader configFileReader;
	
	private static Logger log = Logger.getLogger(HowToDoLaundry_6.class);
	
	@Given("Open the Browser for sixth test case")
	public void open_the_browser_for_sixth_test_case() {
		configFileReader = new ConfigFileReader();
		
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		driver = new ChromeDriver();
		
		driver.get(configFileReader.getApplicationUrl());
		 log.info("Opening Driver");
		 
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.findElement(howToDoLaundry_6.clickFirstClose).click();
	}

	@When("Hover on How to wash clothes")
	public void hover_on_how_to_wash_clothes() {
		
		WebElement hoverEle = driver.findElement(howToDoLaundry_6.hoverHowToWashClothes);
		Actions a = new Actions(driver);
		a.moveToElement(hoverEle).perform();
		log.info("Hovering on How to Wash Clothes");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	}

	@Then("Click on How To Do Laundry")
	public void click_on_how_to_do_laundry() throws IOException {
		
		driver.findElement(howToDoLaundry_6.clickHowToDoLaundry).click();
		log.info("Clicking on How To Do Laundry");
		
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0, 200)");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		  this.takeSnapShot(driver, "./Screenshots/6_HowToDoLaundry.png");
		    log.info("Taking SnapShot of How To Do Laundry Page");
		}
		
		public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws IOException 
		{
			TakesScreenshot scrShot = ((TakesScreenshot)webdriver); //Convert webdriver object to TakesScreenShot
			
			File ScrFile = scrShot.getScreenshotAs(OutputType.FILE); //Call getScreenshotAs method to create image file
			
			File DestFile = new File(fileWithPath); //Move image file to new destination
			
			FileUtils.copyFile(ScrFile, DestFile); //Copy file at destination
		}
}
