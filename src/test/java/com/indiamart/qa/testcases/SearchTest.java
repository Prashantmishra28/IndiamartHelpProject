package com.indiamart.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.indiamart.qa.base.base;
import com.indiamart.qa.pageobjects.homepage;
import com.indiamart.qa.utils.utilities;

public class SearchTest extends base{
	
	public SearchTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	
	public void setup() {
		
		driver = browserSetupandOpenApplication(prop.getProperty("browser"));
	}
	
	
	@Test(priority =1, dataProvider="ValidSearchInputs")
	public void searchwithvalidinputs(String SearchInputs){
		
		homepage hmpage = new homepage(driver);
		hmpage.inputInSearchBox(SearchInputs);
		hmpage.clickonsearchbutton();
		Assert.assertTrue(hmpage.visiblityofbreadcrumb(), "Not on Buyer page");
		driver.quit();
	}
	
	@DataProvider(name="ValidSearchInputs")
	public Object [][] gettestdataforvalidsearch(){
		Object [][] searchdata = utilities.gettestdatafromexcel("SearchKeywords");
		return searchdata;
	}
		
	@Test(priority=2, dataProvider="InValidSearchInputs")
	public void searchwithinvalidinputs(String InvalidSearchInputs) {
		
		
		homepage hmpage = new homepage(driver);
		hmpage.inputInSearchBox(InvalidSearchInputs);
		hmpage.clickonsearchbutton();
		Assert.assertTrue(hmpage.visiblityofactualsearchmessage(),"No Product message is not visible");;
		driver.quit();
	}
	
	@DataProvider(name="InValidSearchInputs")
	public Object [][] gettestdataforinvalidsearch(){
		Object [][] searchdata = utilities.gettestdatafromexcel("InvalidSearchKeyword");
		return searchdata;
	}

	@Test(priority=3, invocationCount = 2)
	public void searchwithnoinputs() {
		
		homepage hmpage = new homepage(driver);
		hmpage.clickonsearchbutton();
		WebDriverWait waitforalert = new WebDriverWait(driver,utilities.Timeout);
		try {
		    Alert alert = waitforalert.until(ExpectedConditions.alertIsPresent());
		    alert.accept();
		} catch (NoAlertPresentException e) {
		    System.out.println("Alert was not present within timeout.");
		}
		driver.quit();	
	}
	
}
