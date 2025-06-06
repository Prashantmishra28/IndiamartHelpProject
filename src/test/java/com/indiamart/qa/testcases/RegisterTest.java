package com.indiamart.qa.testcases;

import org.openqa.selenium.WebDriver;
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
	public homepage hmpage;
	public signinpopup signinpopup;
	
	@BeforeMethod
	
	public void setup() {
		
		driver = browserSetupandOpenApplication(prop.getProperty("browser"));
		hmpage =new homepage(driver);
		signinpopup = new signinpopup(driver);
	}
	
	@AfterMethod
	public void closure() {
		
		driver.quit();
		
	}
	
	@Test(priority = 1) 
	
	public void verifyRegisteringonhelp() {
	
//		WebElement signin = driver.findElement(By.xpath("//a[@id='user_sign_in']"));
//		WebElement Joinnow = driver.findElement(By.cssSelector(".h_clr.bld"));
//		Actions hower = new Actions(driver);
//		hower.moveToElement(signin).pause(1000).moveToElement(Joinnow).click().build().perform();
		
		hmpage.howerfromsigintojoinow();
		signinpopup.mobileinput(utilities.generateRandomMobileNumber());
		signinpopup.clickonsubmitbtn();
		Assert.assertTrue(hmpage.hiTexxtVisiblity(), "Webelement not found on the page");
}
	
	@Test(priority = 2)
	public void verifyRegisteringwithinvalidCredentials() {
		

		hmpage.howerfromsigintojoinow();
		signinpopup.mobileinput(utilities.generateInvalidMobileNumber());
		signinpopup.clickonsubmitbtn();
		String actualerrormsg = signinpopup.getinvalidmobilenumbererrormessagetext();;
		Assert.assertTrue(actualerrormsg.contains(dataprop.getProperty("invalidmobilenumberwarningmsg")), "Error message is not visible");
	}
	
	@Test(priority = 3, dependsOnMethods={"verifyRegisteringwithinvalidCredentials"})
	public void verifyRegisteringwithnoCredentials() {

		hmpage.howerfromsigintojoinow();
		signinpopup.clickonsubmitbtn();
		String actualerrormsg = signinpopup.EnterMobileNumberErrorMessageText();
		Assert.assertTrue(actualerrormsg.contains(dataprop.getProperty("nomobilenumbermsg")), "Error message is not visible");
	}

}
