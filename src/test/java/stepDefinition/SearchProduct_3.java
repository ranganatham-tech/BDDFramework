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
import objectRepository.searchProduct_3;

public class SearchProduct_3 extends StartBrowser {

	ConfigFileReader configFileReader;
	
	private static Logger log = Logger.getLogger(SearchProduct_3.class);
	
	@Given("First Open Browser")
	public void first_open_browser() {
		configFileReader = new ConfigFileReader();
		
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		driver = new ChromeDriver();
		
		driver.get(configFileReader.getApplicationUrl());
		 log.info("Opening Driver");
		 
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.findElement(searchProduct_3.clickFirstClose).click();
	}

	@When("Search the product {string}")
	public void search_the_product(String string) {
	    driver.findElement(searchProduct_3.searchProduct).sendKeys(string);	
	    log.info("Sending keys to Search Bar");
	    
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	}

	@Then("Click on Search button")
	public void click_on_search_button() {
	    driver.findElement(searchProduct_3.clickSearch).click();
	    log.info("Clicking on Search button");
	    
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	}

	@Then("Click on Second Result")
	public void click_on_second_result() throws IOException {
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.findElement(searchProduct_3.clickSecondResult).click();
		log.info("Clicking on Second Result");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		  this.takeSnapShot(driver, "./Screenshots/3_SearchProduct.png");
		    log.info("Taking SnapShot of Search Product Page");
		}
		
		public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws IOException 
		{
			TakesScreenshot scrShot = ((TakesScreenshot)webdriver); //Convert webdriver object to TakesScreenShot
			
			File ScrFile = scrShot.getScreenshotAs(OutputType.FILE); //Call getScreenshotAs method to create image file
			
			File DestFile = new File(fileWithPath); //Move image file to new destination
			
			FileUtils.copyFile(ScrFile, DestFile); //Copy file at destination
		}
}
