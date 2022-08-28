package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.ConfigFileReader;
import config.StartBrowser;
import io.cucumber.java.en.*;
import objectRepository.changeLocation_8;

public class ChangeLocation_8 extends StartBrowser {

	ConfigFileReader configFileReader;
	
	private static Logger log = Logger.getLogger(ChangeLocation_8.class);
	
	@Given("Open Browser for eighth test case")
	public void open_browser_for_eighth_test_case() {
		configFileReader = new ConfigFileReader();
		
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		driver = new ChromeDriver();
		
		driver.get(configFileReader.getApplicationUrl());
		 log.info("Opening Driver");
		 
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.findElement(changeLocation_8.clickFirstClose).click();
	}

	@When("Click US English")
	public void click_us_english() {
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.findElement(changeLocation_8.clickUS_English).click();
		log.info("Clicking on US - English");
	}

	@Then("Click Canada English")
	public void click_canada_english() throws IOException {
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.findElement(changeLocation_8.clickCanada_English).click();
		log.info("Clicking on Canada - English ");
		
		  this.takeSnapShot(driver, "./Screenshots/8_ChangeLocation.png");
		    log.info("Taking SnapShot of Change Location Page");
		}
		
		public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws IOException 
		{
			TakesScreenshot scrShot = ((TakesScreenshot)webdriver); //Convert webdriver object to TakesScreenShot
			
			File ScrFile = scrShot.getScreenshotAs(OutputType.FILE); //Call getScreenshotAs method to create image file
			
			File DestFile = new File(fileWithPath); //Move image file to new destination
			
			FileUtils.copyFile(ScrFile, DestFile); //Copy file at destination
		}
}
