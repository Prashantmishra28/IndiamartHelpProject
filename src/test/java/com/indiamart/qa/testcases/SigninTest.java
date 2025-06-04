package com.indiamart.qa.testcases;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.indiamart.qa.base.base;
import com.indiamart.qa.pageobjects.homepage;
import com.indiamart.qa.pageobjects.signinpopup;
import com.indiamart.qa.utils.utilities;

public class SigninTest extends base{
	
	
	public SigninTest() {
		super();
	}
	
	public WebDriver driver;
	signinpopup signinpopup;
	homepage hmpage;
	
	
	@BeforeMethod
	public void setup() {
		
		driver = browserSetupandOpenApplication(prop.getProperty("browser"));
		hmpage = new homepage(driver);
		signinpopup = hmpage.clickonsignin();	
	}
	
	@AfterMethod
	public void closure() {
		
		driver.quit();
		
	}
	
	@Test(priority= 1, dataProvider ="validmobilenumbers")
	public void VerifySigninWithValidCredentials(String mobilenumber) {
		
		signinpopup.mobileinput(mobilenumber);
		signinpopup.clickonsubmitbtn();
		Assert.assertTrue(hmpage.hiTexxtVisiblity(),"Webelement not found on the page");
	
	}
	
	@DataProvider(name="validmobilenumbers")
	public Object [][] gettestdata() {
		Object [][] data = utilities.gettestdatafromexcel("Signin");
		System.out.println(Arrays.deepToString(data));
		return data;
		
	}

	@Test(priority= 2)
	public void VerifySigninWithInValidCredentials() {
		
		signinpopup.mobileinput(utilities.generateInvalidMobileNumber());
		signinpopup.clickonsubmitbtn();
		String actualerrormsg = signinpopup.getinvalidmobilenumbererrormessagetext();
		Assert.assertTrue(actualerrormsg.contains(dataprop.getProperty("invalidmobilenumberwarningmsg")), "Error message is not visible");
	}
	
	@Test(priority=3)
	public void VerifySigninWithNoCredentials() {
		
		signinpopup.clickonsubmitbtn();
		String actualerrormsg = signinpopup.EnterMobileNumberErrorMessageText();
		Assert.assertTrue(actualerrormsg.contains(dataprop.getProperty("nomobilenumbermsg")), "Error message is not visible");
	}
}
