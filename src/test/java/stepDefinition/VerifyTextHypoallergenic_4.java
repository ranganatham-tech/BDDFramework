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
import objectRepository.verifyTextHypoallergenic_4;

public class VerifyTextHypoallergenic_4 extends StartBrowser {

	ConfigFileReader configFileReader;
	
	private static Logger log = Logger.getLogger(VerifyTextHypoallergenic_4.class);
	
	@Given("Open Browser for fourth test case")
	public void open_browser_for_fourth_test_case() {
		configFileReader = new ConfigFileReader();
		
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		driver = new ChromeDriver();
		
		driver.get(configFileReader.getApplicationUrl());
		 log.info("Opening Driver");
		 
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.findElement(verifyTextHypoallergenic_4.clickFirstClose).click();
	}

	@When("Hover on Shop Products for fourth test case")
	public void hover_on_shop_products_for_fourth_test_case() {
	    WebElement hoverEle = driver.findElement(verifyTextHypoallergenic_4.hoverShopProducts);
	    Actions a = new Actions(driver);
	    a.moveToElement(hoverEle).perform();
	    log.info("Hovering on Shop Products");
	}

	@Then("Click on Tide Free and Gentle")
	public void click_on_tide_free_and_gentle() {
		driver.findElement(verifyTextHypoallergenic_4.clickTideFreeAndGentle).click();
		log.info("Clicking on Tide Free & Gentle");
	}

	@Then("Verify the Text {string}")
	public void verify_the_text(String string) throws IOException {
		
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0, 500)");
		log.info("Scrolling Down");
		
	    if(driver.getPageSource().contains("hypoallergenic")) {
	    	System.out.println("Text : '" + string + "' is Verified");
	    } else {
	    	System.out.println("Text : '" + string + "' is not Verified");
	    } log.info("Verifying Text");
	    
	    this.takeSnapShot(driver, "./Screenshots/4_VerifyTextHypoallergenic.png");
	    log.info("Taking SnapShot of Verify Text Hypoallergenic Page");
	}
	
	public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws IOException 
	{
		TakesScreenshot scrShot = ((TakesScreenshot)webdriver); //Convert webdriver object to TakesScreenShot
		
		File ScrFile = scrShot.getScreenshotAs(OutputType.FILE); //Call getScreenshotAs method to create image file
		
		File DestFile = new File(fileWithPath); //Move image file to new destination
		
		FileUtils.copyFile(ScrFile, DestFile); //Copy file at destination
	}
}
