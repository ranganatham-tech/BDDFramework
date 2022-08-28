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

import config.ConfigFileReader;
import config.StartBrowser;
import io.cucumber.java.en.*;
import objectRepository.highlightText_5;

public class HighlightText_5 extends StartBrowser {
	
	ConfigFileReader configFileReader;
	
	private static Logger log = Logger.getLogger(HighlightText_5.class);
	
	@Given("Open Browser for fifth test case")
	public void open_browser_for_fifth_test_case() {
		configFileReader = new ConfigFileReader();
		
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		driver = new ChromeDriver();
		
		driver.get(configFileReader.getApplicationUrl());
		 log.info("Opening Driver");
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.findElement(highlightText_5.clickFirstClose).click();
	}

	@When("Click on Our Commitment")
	public void click_on_our_commitment() {
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.findElement(highlightText_5.clickOurCommitment).click();
		log.info("Clicking on Our Commitment");
	}

	@Then("Highlight the {string}")
	public void highlight_the(String string) throws IOException {
		
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0, 600)");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		WebElement verifyEle = driver.findElement(highlightText_5.highlightText);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", verifyEle);
		log.info("Highlighting the Text");
		
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		System.out.println("Text : '" + string + "' Highlighted");
		  this.takeSnapShot(driver, "./Screenshots/5_HighlightText.png");
		    log.info("Taking SnapShot of Highlight Text Page");
		}
		
		public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws IOException 
		{
			TakesScreenshot scrShot = ((TakesScreenshot)webdriver); //Convert webdriver object to TakesScreenShot
			
			File ScrFile = scrShot.getScreenshotAs(OutputType.FILE); //Call getScreenshotAs method to create image file
			
			File DestFile = new File(fileWithPath); //Move image file to new destination
			
			FileUtils.copyFile(ScrFile, DestFile); //Copy file at destination
		}
}
