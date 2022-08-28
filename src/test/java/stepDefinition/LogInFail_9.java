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
import objectRepository.logInFail_9;
import objectRepository.logIn_1;

public class LogInFail_9 extends StartBrowser {

	ConfigFileReader configFileReader;
	
	private static Logger log = Logger.getLogger(LogInFail_9.class);
	
	@Given("Open the Website for ninth test case")
	public void open_the_website_for_ninth_test_case() {
	configFileReader = new ConfigFileReader();
	System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
	driver = new ChromeDriver();
	
	driver.get(configFileReader.getApplicationUrl());
	log.info("Opening Driver");
	
	driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	
	driver.manage().window().maximize();
	
	driver.findElement(logInFail_9.clickFirstClose).click();
//	driver.findElement(logIn_1.clickClose).click();
	 
	}

	@When("Click on Register")
	public void click_on_register() {
	   driver.findElement(logIn_1.clickRegister).click();
	   log.info("Clicking on Register");
	}

	@Then("Click on Sign up now")
	public void click_on_sign_up_now() {
	    driver.findElement(logInFail_9.clickSignUpNow).click();
	    log.info("Clicking on Sign Up Now");
	}

	@Then("Click on Login link")
	public void click_on_login_link() {
//	   driver.findElement(logInFail_9.clickLogIn).click();
		
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
	}

	@Then("Enter the {string} and {string}")
	public void enter_the_and(String string, String string2) {
	    driver.findElement(logInFail_9.enterEmail).sendKeys(string);
	    log.info("Entering Invalid Email");
	    
	    driver.findElement(logInFail_9.enterPassword).sendKeys(string2);
	    log.info("Entering Invalid Password");
	}
	
	@Then("Click on Log In button")
	public void click_on_log_in_button() throws IOException {
	    driver.findElement(logInFail_9.clickLogIn2).click();
	    log.info("Clicking on Log In button");
	    
	    log.info("LogIn is Failing");
	    
	    this.takeSnapShot(driver, "./Screenshots/9_LogInFail.png");
	    log.info("Taking SnapShot of LogIn Fail Page");
	}
	
	public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws IOException 
	{
		TakesScreenshot scrShot = ((TakesScreenshot)webdriver); //Convert webdriver object to TakesScreenShot
		
		File ScrFile = scrShot.getScreenshotAs(OutputType.FILE); //Call getScreenshotAs method to create image file
		
		File DestFile = new File(fileWithPath); //Move image file to new destination
		
		FileUtils.copyFile(ScrFile, DestFile); //Copy file at destination
	}
}
