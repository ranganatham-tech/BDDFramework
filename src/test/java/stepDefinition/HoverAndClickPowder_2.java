package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import config.ConfigFileReader;
import config.StartBrowser;
import io.cucumber.java.en.*;
import objectRepository.hoverAndClickPowder_2;

public class HoverAndClickPowder_2 extends StartBrowser {

	ConfigFileReader configFileReader;
	
	private static Logger log = Logger.getLogger(LogIn_1.class);
	
	@Given("Open Website")
	public void open_website() {
		configFileReader = new ConfigFileReader();
		
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		driver = new ChromeDriver();
		
		driver.get(configFileReader.getApplicationUrl());
		log.info("Opening Driver");
		 
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.findElement(hoverAndClickPowder_2.clickFirstClose).click();
	}

	@When("Hover on Shop Products")
	public void hover_on_shop_products() {
	   WebElement hoverEle = driver.findElement(hoverAndClickPowder_2.hoverShopProducts);
	   Actions a = new Actions(driver);
	   a.moveToElement(hoverEle).perform();
	   log.info("Hovering on Shop Products");
	}

	@Then("Click on Powder")
	public void click_on_powder() {
		driver.findElement(hoverAndClickPowder_2.clickPowder).click();
		log.info("Clicking on Powder");
		
	}

	@Then("Click on First Result")
	public void click_on_first_result() {
		driver.findElement(hoverAndClickPowder_2.clickFirstResult).click();
		log.info("Clicking on First Result");
	}

	@Then("Click on Find Retailer")
	public void click_on_find_retailer() throws IOException {
		driver.findElement(hoverAndClickPowder_2.clickFindRetailer).click();
	    this.takeSnapShot(driver, "./Screenshots/2_HoverAndClickPowder.png");
	    log.info("Taking SnapShot of Hover and Click Powder Page");
	}
	
	public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws IOException 
	{
		TakesScreenshot scrShot = ((TakesScreenshot)webdriver); //Convert webdriver object to TakesScreenShot
		
		File ScrFile = scrShot.getScreenshotAs(OutputType.FILE); //Call getScreenshotAs method to create image file
		
		File DestFile = new File(fileWithPath); //Move image file to new destination
		
		FileUtils.copyFile(ScrFile, DestFile); //Copy file at destination
	}
}
