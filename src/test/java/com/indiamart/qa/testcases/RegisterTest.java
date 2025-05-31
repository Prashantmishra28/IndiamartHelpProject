package com.indiamart.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.indiamart.qa.base.base;
import com.indiamart.qa.pageobjects.homepage;
import com.indiamart.qa.pageobjects.signinpopup;
import com.indiamart.qa.utils.utilities;

public class RegisterTest extends base{
	
	public RegisterTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	
	public void setup() {
		
		driver = browserSetupandOpenApplication(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void closure() {
		
		driver.quit();
		
	}
	
	@Test(priority = 1) 
	
	public void verifyRegisteringonhelp() {
	
		WebElement signin = driver.findElement(By.xpath("//a[@id='user_sign_in']"));
		WebElement Joinnow = driver.findElement(By.cssSelector(".h_clr.bld"));
		Actions hower = new Actions(driver);
		hower.moveToElement(signin).pause(1000).moveToElement(Joinnow).click().build().perform();
		signinpopup signinpopup= new signinpopup(driver);
		signinpopup.mobileinput(utilities.generateRandomMobileNumber());
		signinpopup.clickonsubmitbtn();
		homepage hmpage = new homepage(driver);
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Buying on IndiaMART']")));
//		WebElement hi = driver.findElement(By.id("wel_name"));
//		WebElement ViewProfile = driver.findElement(By.xpath("//a[text()='View Profile']"));
//		hower.moveToElement(hi).pause(1000).moveToElement(ViewProfile).build().perform();
		Assert.assertTrue(hmpage.hiTexxtVisiblity(), "Webelement not found on the page");
}
	
	@Test(priority = 2)
	public void verifyRegisteringwithinvalidCredentials() {
		

		WebElement signin = driver.findElement(By.id("user_sign_in"));
		WebElement Joinnow = driver.findElement(By.xpath("//p[@class='h_clr bld']"));
		Actions hower = new Actions(driver);
		hower.moveToElement(signin).pause(1000).moveToElement(Joinnow).click().build().perform();
		signinpopup signinpopup= new signinpopup(driver);
		signinpopup.mobileinput(utilities.generateInvalidMobileNumber());
		signinpopup.clickonsubmitbtn();
		String actualerrormsg = signinpopup.getinvalidmobilenumbererrormessagetext();;
		Assert.assertTrue(actualerrormsg.contains(dataprop.getProperty("invalidmobilenumberwarningmsg")), "Error message is not visible");
	}
	
	@Test(priority = 3, dependsOnMethods={"verifyRegisteringwithinvalidCredentials"})
	public void verifyRegisteringwithnoCredentials() {

		WebElement signin = driver.findElement(By.id("user_sign_in"));
		WebElement Joinnow = driver.findElement(By.xpath("//p[@class='h_clr bld']"));
		Actions hower = new Actions(driver);
		hower.moveToElement(signin).pause(1000).moveToElement(Joinnow).click().build().perform();
		signinpopup signinpopup= new signinpopup(driver);
		signinpopup.clickonsubmitbtn();
		String actualerrormsg = signinpopup.EnterMobileNumberErrorMessageText();
		String expectederrormsg = dataprop.getProperty("nomobilenumbermsg");
		Assert.assertTrue(actualerrormsg.contains(expectederrormsg), "Error message is not visible");
	}

}
