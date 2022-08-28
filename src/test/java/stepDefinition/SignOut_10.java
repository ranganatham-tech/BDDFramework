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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.signOut_10;

public class SignOut_10 extends StartBrowser {

	ConfigFileReader configFileReader;
	
	private static Logger log = Logger.getLogger(SignOut_10.class);
	
	@Given("Open the Website for tenth test case")
	public void open_the_website_for_tenth_test_case() {
	configFileReader = new ConfigFileReader();
	System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
	driver = new ChromeDriver();
	
	driver.get(configFileReader.getApplicationUrl());
	log.info("Opening Driver");
	
	driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	
	driver.manage().window().maximize();
	
	driver.findElement(signOut_10.clickFirstClose).click();
//	driver.findElement(signOut_101.clickClose).click();
	 
	}

	@When("Click Register")
	public void click_register() {
	   driver.findElement(signOut_10.clickRegister).click();
	   log.info("Clicking on Register");
	}

	@Then("Click Sign up now")
	public void click_sign_up_now() {
	    driver.findElement(signOut_10.clickSignUpNow).click();
	    log.info("Clicking on Sign Up Now");
	}

	@Then("Click Login")
	public void click_login() {
//	   driver.findElement(signOut_10.clickLogIn).click();
		
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
		log.info("Clicking on Log In");
	}

	@Then("Enter {string} {string}")
	public void enter(String string, String string2) {
	    driver.findElement(signOut_10.enterEmail).sendKeys(string);
	    log.info("Entering Email");
	    
	    driver.findElement(signOut_10.enterPassword).sendKeys(string2);
	    log.info("Entering Password");
	}
	
	@Then("Click Log In")
	public void click_log_in() {
	    driver.findElement(signOut_10.clickLogIn2).click();
	    log.info("Clicking on Log In");
	    
	    driver.findElement(signOut_10.clickClose2).click();
	}
	
	@Then("Click User name")
	public void click_user_name() {
		driver.findElement(signOut_10.clickUserName).click();
		log.info("Clicking on User Name");
	}

	@Then("Click Sign Out")
	public void click_sign_out() throws IOException {
		driver.findElement(signOut_10.clickSignOut).click();
		log.info("Clicking on Sign Out");
		
		  this.takeSnapShot(driver, "./Screenshots/SignOut_10.png");
		    log.info("Taking SnapShot of Sign Out Page");
		}
		
		public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws IOException 
		{
			TakesScreenshot scrShot = ((TakesScreenshot)webdriver); //Convert webdriver object to TakesScreenShot
			
			File ScrFile = scrShot.getScreenshotAs(OutputType.FILE); //Call getScreenshotAs method to create image file
			
			File DestFile = new File(fileWithPath); //Move image file to new destination
			
			FileUtils.copyFile(ScrFile, DestFile); //Copy file at destination
		}
}

