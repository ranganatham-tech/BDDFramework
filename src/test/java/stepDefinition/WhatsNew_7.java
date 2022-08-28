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
import objectRepository.whatsNew_7;

public class WhatsNew_7 extends StartBrowser {

	ConfigFileReader configFileReader;
	
	private static Logger log = Logger.getLogger(WhatsNew_7.class);
	
	@Given("Open the Browser for seventh test case")
	public void open_the_browser_for_seventh_test_case() {
		configFileReader = new ConfigFileReader();
		
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		driver = new ChromeDriver();
		
		driver.get(configFileReader.getApplicationUrl());
		 log.info("Opening Driver");
		 
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.findElement(whatsNew_7.clickFirstClose).click();
	}

	@When("Click on Whats New")
	public void click_on_whats_new() throws IOException {
	    
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.findElement(whatsNew_7.clickWhatsnew).click();;
		log.info("Clicking on What's New ");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		this.takeSnapShot(driver, "./Screenshots/7_WhatsNew.png");
		    log.info("Taking SnapShot of What's New Page");
		}
		
		public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws IOException 
		{
			TakesScreenshot scrShot = ((TakesScreenshot)webdriver); //Convert webdriver object to TakesScreenShot
			
			File ScrFile = scrShot.getScreenshotAs(OutputType.FILE); //Call getScreenshotAs method to create image file
			
			File DestFile = new File(fileWithPath); //Move image file to new destination
			
			FileUtils.copyFile(ScrFile, DestFile); //Copy file at destination
		}
}
