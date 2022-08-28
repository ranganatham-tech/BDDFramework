package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
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
import objectRepository.logIn_1;

public class LogIn_1 extends StartBrowser {

	ConfigFileReader configFileReader;

	private static Logger log = Logger.getLogger(LogIn_1.class);
	
	@Given("Open the Website")
	public void open_the_website() {
	configFileReader = new ConfigFileReader();
	System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
	driver = new ChromeDriver();
	
	driver.get(configFileReader.getApplicationUrl());
	 
	log.info("Opening Driver");
	
	driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	log.info("Implicitly Waiting");
	
	driver.manage().window().maximize();
	
	driver.findElement(logIn_1.clickFirstClose).click();
//	driver.findElement(logIn_1.clickClose).click();
	 
	}

	@When("Click on the Register")
	public void click_on_the_register() {
	   driver.findElement(logIn_1.clickRegister).click();
	   log.info("Clicking on Register");
	}

	@Then("Click on the Sign up now")
	public void click_on_the_sign_up_now() {
	    driver.findElement(logIn_1.clickSignUpNow).click();
	    log.info("Clicking on Sign up now");
	}

	@Then("Click on Login")
	public void click_on_login() {
//	   driver.findElement(logIn_1.clickLogIn).click();
		
		String parent = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> I1 = s1.iterator();
		while(I1.hasNext() ) {
			String child_window = I1.next();
			if(!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
			}
		}
		
		driver.get("https://www.pggoodeveryday.com/login/");
		log.info("Clicking on Login");
	}

	@Then("Enter {string} and {string}")
	public void enter_and(String string, String string2) {
	    driver.findElement(logIn_1.enterEmail).sendKeys(string);
	    log.info("Entering Email");
	    
	    driver.findElement(logIn_1.enterPassword).sendKeys(string2);
	    log.info("Entering Password");
	}
	
	@Then("Click on Log In")
	public void click_on_log_in() throws IOException {
	    driver.findElement(logIn_1.clickLogIn2).click();
	    log.info("Clicking on Login");
	    
	    driver.findElement(logIn_1.clickClose2).click();
	    
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
	    this.takeSnapShot(driver, "./Screenshots/1_LogIn.png");
	    log.info("Taking SnapShot of Login Page");
	}
	
	public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws IOException 
	{
		TakesScreenshot scrShot = ((TakesScreenshot)webdriver); //Convert webdriver object to TakesScreenShot
		
		File ScrFile = scrShot.getScreenshotAs(OutputType.FILE); //Call getScreenshotAs method to create image file
		
		File DestFile = new File(fileWithPath); //Move image file to new destination
		
		FileUtils.copyFile(ScrFile, DestFile); //Copy file at destination
	}
}
