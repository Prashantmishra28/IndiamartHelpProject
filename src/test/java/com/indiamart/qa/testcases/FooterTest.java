package com.indiamart.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.indiamart.qa.base.base;
import com.indiamart.qa.pageobjects.Footer;
import com.indiamart.qa.utils.utilities;

public class FooterTest extends base{
	
	public FooterTest() { super(); }
	public WebDriver driver;
	public Footer footer;
	public WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		driver = browserSetupandOpenApplication(prop.getProperty("browser"));
		footer = new Footer(driver); 
	}
	
	@AfterMethod
	public void closure() { driver.quit(); }
	
	@Test(priority=1)
	public void verifyhelpclickandredirection() {
		footer.clickonhelp();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("helptitle")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("helptitle")),"Not on the help page redirection failed");
	}
	
	@Test(priority=2)
	public void verifyfeedbackclickandredirectiononfootersection() {
		footer.clickonfeedback();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("feedbacktitle")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("feedbacktitle")),"Not on the feedback page redirection failed");
	}
	
	@Test(priority=3)
	public void verifycomplaintsclickandredirectiononfootersection() {
		footer.clickoncomplaints();
		Assert.assertTrue(footer.visiblityofcomplaints(),"Not on the complaints page redirection failed");
	}
	
	@Test(priority=4)
	public void verifycustomercareclickandredirectiononfootersection() {
		footer.clickoncustomercare();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("customer_care_title")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("customer_care_title")),"Not on the feedback page redirection failed");
	}
	@Test(priority=5)
	public void verifycontactuscareclickandredirectiononfootersection() {
		footer.clickoncontactus();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("contact_us_title")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("contact_us_title")),"Not on the feedback page redirection failed");
	}
	@Test(priority=6)
	public void verifysuppliertoolkitclickandredirectiononfootersection() {
		footer.clickonsuppliertoolkit();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("sellertitle")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("sellertitle")),"Not on the feedback page redirection failed");
	}	
	@Test(priority=7)
	public void verifysellertoolsclickandredirectiononfootersection() {
		footer.clickonsellertools();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("sellertitle")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("sellertitle")),"Not on the feedback page redirection failed");
	}
	@Test(priority=8)
	public void verifylatestbuyleadclickandredirectiononfootersection() {
		footer.clickonlatestbuylead();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("sellertitle")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("sellertitle")),"Not on the feedback page redirection failed");
	}
	@Test(priority=9)
	public void verifylearningcenterclickandredirectiononfootersection() {
		footer.clickonlearningcentre();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("Learning_center_title")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("Learning_center_title")),"Not on the feedback page redirection failed");
	}
	@Test(priority=10)
	public void verifyshipwithindiamartclickandredirectiononfootersection() {
		footer.clickonshipwithindiamart();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("ship_with_indiamart_title")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("ship_with_indiamart_title")),"Not on the feedback page redirection failed");
	}
	@Test(priority=11)
	public void verifysecuritytipsforsellersclickandredirectiononfootersection() {
		footer.clickonsecuritytipsforsellers();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("security_tips_for_seller_Buyer_title")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("security_tips_for_seller_Buyer_title")),"Not on the feedback page redirection failed");
	}
	@Test(priority=12)
	public void verifybuyertoolkitclickandredirectiononfootersection() {
		footer.clickonbuyertoolkit();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("buyer_tool_kit_title")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("buyer_tool_kit_title")),"Not on the feedback page redirection failed");
	}
	@Test(priority=13)
	public void verifypostyourrequirementclickandredirectiononfootersection() {
		footer.clickonpostyourrequirement();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("buyerctatitle")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("buyerctatitle")),"Not on the feedback page redirection failed");
	}
	@Test(priority=14)
	public void verifyproductyoubuyclickandredirectiononfootersection() {
		footer.clickonproductyoubuy();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("buyerctatitle")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("buyerctatitle")),"Not on the feedback page redirection failed");
	}
	@Test(priority=15)
	public void verifysearchproductsandsuppliersclickandredirectiononfootersection() {
		footer.clickonsearchproductsandsuppliers();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("search_products_suppliers_title")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("search_products_suppliers_title")),"Not on the feedback page redirection failed");
	}
	@Test(priority=16)
	public void verifysecuritytipsforbuyerclickandredirectiononfootersection() {
		footer.clickonsecuritytipsforbuyers();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("security_tips_for_seller_Buyer_title")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("security_tips_for_seller_Buyer_title")),"Not on the feedback page redirection failed");
	}
	@Test(priority=17)
	public void verifytermofuseclickandredirectiononfootersection() {
		footer.clickontermofuse();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("term_of_use_title")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("term_of_use_title")),"Not on the feedback page redirection failed");
	}
	@Test(priority=18)
	public void verifyprivacypolicyclickandredirectiononfootersection() {
		footer.clickonprivacypolicy();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("privacy_policy_title")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("privacy_policy_title")),"Not on the feedback page redirection failed");
	}
	@Test(priority=19)
	public void verifylinktousclickandredirectiononfootersection() {
		footer.clickonlinktous();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("homeclick_title")));
		Assert.assertTrue(driver.getTitle().equals(dataprop.getProperty("homeclick_title")),"Not on the feedback page redirection failed");
	}
	@Test(priority=20)
	public void verifyappleiconclickandredirectiononfootersection() {
		String parentwindown = driver.getWindowHandle();
		try{
			footer.clickonappleicon();
			WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
//			wait.until(ExpectedConditions.visibilityOf();
		} catch (Exception e) { System.out.println("Element not visible " + e);}
		
		String newwindow = null;
		for (String childwindow : driver.getWindowHandles()) {
			if (!childwindow.equals(parentwindown)) {newwindow = childwindow; break;}
		}
		
		if (newwindow == null) {
			System.out.println("New window not found");
		}
		
		driver.switchTo().window(newwindow);
		
		String expectedtitle = dataprop.getProperty("apple_title");
		
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
	
}
