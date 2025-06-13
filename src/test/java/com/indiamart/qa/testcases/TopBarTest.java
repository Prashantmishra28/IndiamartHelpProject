package com.indiamart.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.indiamart.qa.base.base;
import com.indiamart.qa.pageobjects.homepage;
import com.indiamart.qa.utils.utilities;

public class TopBarTest extends base {
	
	public TopBarTest(){ super(); }
	
	public WebDriver driver;
	public homepage hmpage;
	
	@BeforeMethod
	public void setup() {
		driver = browserSetupandOpenApplication(prop.getProperty("browser"));
		hmpage = new homepage(driver);
	}
	
	@AfterMethod
	public void closure() {driver.quit();}

	@Test(priority = 1)
	public void VerifyGetbestPriceCtaClickandRedirection() {
		
		String parentwindown = driver.getWindowHandle();
		try{
			hmpage.clickongetpricecta();
			WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
			wait.until(ExpectedConditions.titleIs(dataprop.getProperty("buyerctatitle")));
		} catch (Exception e) { System.out.println("Element not visible " + e);}
		
		String newwindow = null;
		for (String childwindow : driver.getWindowHandles()) {
			if (!childwindow.equals(parentwindown)) {newwindow = childwindow; break;}
		}
		
		if (newwindow == null) {
			System.out.println("New window not found");
		}
		
		driver.switchTo().window(newwindow);
		
		String expectedtitle = dataprop.getProperty("buyerctatitle");
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
			wait.until(ExpectedConditions.titleIs(expectedtitle));
			Assert.assertTrue(driver.getTitle().equals(expectedtitle));
			
		} catch(Exception e) {
			System.out.println("New Window title fail" + e);
		}
		
		driver.close();
		driver.switchTo().window(parentwindown);
		
		String expectedhometitle = dataprop.getProperty("helptitle");
		try {
			WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
			wait.until(ExpectedConditions.titleIs(expectedhometitle));
			Assert.assertTrue(driver.getTitle().equals(expectedhometitle));
			
		} catch(Exception e) {
			System.out.println("New Window title fail" + e);
		}
		
		driver.quit();
	}
	
	@Test(priority = 2)
	public void VerifyShoppingclickandRedirection() {
		
		hmpage.clickonshoppingcta();
		WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("shoppingtitle")));
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("shoppingtitle")),"Not on the shopping page redirection failed");
	}
	
	@Test(priority = 3)
	public void VerifySellclickandRedirection() {
			
		hmpage.clickonsellcta();
		WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("sellertitle")));
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("sellertitle")),"Not on the seller page redirection failed");
	}
	
	@Test(priority = 4)
	public void VerifyvideosclickandRedirection() {
		
		hmpage.clickonvideocta();
		WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("helpvideotitle")));
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("helpvideotitle")),"Not on the video page redirection failed");
	}
	@Test(priority = 5)
	public void VerifymessageclickandRedirection() {
			
		hmpage.clickonmessagecta();
		WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("messagecentertitle")));
		hmpage.closesiginpopup();
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("messagecentertitle")),"Not on the message center page redirection failed");
	}
	@Test(priority = 6)
	public void VerifyfeedbackclickandRedirection() {
			
		hmpage.clickonfeedbackcta();
		WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("feedbacktitle")));
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("feedbacktitle")),"Not on the feedback page redirection failed");
	}
	@Test(priority = 7)
	public void verifyhomeclickandredirection() {
		
		hmpage.moveandclickhome();
		WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("homeclick_title")));
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("homeclick_title")),"Not on the homepage od indiamart redirection failed");
	}
	@Test(priority = 8)
	public void verifypostyourrequirementclickandredirection() {
			
		hmpage.moveandclickpostyourrequirement();
		WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("buyerctatitle")));
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("buyerctatitle")),"Not on the homepage od indiamart redirection failed");
	}
	@Test(priority = 9)
	public void verifyverifiedbusinessbuyerclickandredirection() {
			
		hmpage.moveandclickverifiedbusinessbuyer();
		WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("verifiedbusinessbuyer_title")));
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("verifiedbusinessbuyer_title")),"Not on the homepage od indiamart redirection failed");
	}
	@Test(priority = 10)
	public void verifyproductsservicedirectoryclickandredirection() {
			
		hmpage.moveandclickproductservicedirectory();
		WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("product_service_directory_title")));
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("product_service_directory_title")),"Not on the homepage od indiamart redirection failed");
	}
	@Test(priority = 11)
	public void verifyrecentactivityclickandredirection() {
			
		hmpage.moveandclickrecentactivity();
		WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("messagecentertitle")));
		hmpage.closesiginpopup();
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("messagecentertitle")),"Not on the homepage od indiamart redirection failed");
	}
	
	@Test(priority = 12)
	public void verifymanagerequirmentclickandredirection() {
			
		hmpage.moveandclickmanagerequirement();
		WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("sellertitle")));
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("sellertitle")),"Not on the homepage od indiamart redirection failed");
	}
	
	@Test(priority = 13)
	public void verifysettingclickandredirection() {
			
		hmpage.moveandclicksetting();
		WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("messagecentertitle")));
		hmpage.closesiginpopup();
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("messagecentertitle")),"Not on the homepage od indiamart redirection failed");
	}
}
