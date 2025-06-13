package com.indiamart.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.indiamart.qa.base.base;
import com.indiamart.qa.pageobjects.Quicklinks;
import com.indiamart.qa.utils.utilities;

public class QuicklinksTest extends base {
	
	public QuicklinksTest() { super();}
	public WebDriver driver;
	public Quicklinks quicklinks;
	public WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		driver = browserSetupandOpenApplication(prop.getProperty("browser"));
		quicklinks = new Quicklinks(driver);
	}
	
	@AfterMethod
	public void closure() { driver.quit();}
	
	@Test(priority = 1)
	public void verifyquicklink1clickandredirection() {
		quicklinks.clickonquicklink1();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("quicklink1_title")));
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("quicklink1_title")),"Not on the 1st quicklink page redirection failed");
	}
	
	@Test(priority = 2)
	public void verifyquicklink2clickandredirection() {
		quicklinks.clickonquicklink2();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("quicklink2_title")));
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("quicklink2_title")),"Not on the 2nd quicklink page redirection failed");
	}
	
	@Test(priority = 3)
	public void verifyquicklink3clickandredirection() {
		quicklinks.clickonquicklink3();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("quicklink3_title")));
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("quicklink3_title")),"Not on the 3rd quicklink page redirection failed");
	}
	
	@Test(priority = 4)
	public void verifybuyingonindiamartclickandredirection() {
		quicklinks.clickonbuyingonindiamart();
		Assert.assertTrue(quicklinks.visibilitybuyingonindiamart(), "Not on the buying on indiamart page redirection failed");
	}
	@Test(priority = 5)
	public void verifysellingonindiamartclickandredirection() {
		quicklinks.clickonsellingonindiamart();
		Assert.assertTrue(quicklinks.visibilitysellinggonindiamart(), "Not on the selling on indiamart page redirection failed");
	}
	@Test(priority = 6)
	public void verifypaidserviceofindiamartonindiamartclickandredirection() {
		quicklinks.clickonpaidserviceofindiamart();
		Assert.assertTrue(quicklinks.visibilitypaidserviceonindiamart(), "Not on the paid service of indiamart page redirection failed");
	}
	@Test(priority = 7)
	public void verifypaymentrelatedonindiamartclickandredirection() {
		quicklinks.clickonpaymentrelated();
		Assert.assertTrue(quicklinks.visibilitypaymentrelatedonindiamart(), "Not on the payment related page redirection failed");
	}
	@Test(priority = 8)
	public void verifycommunicationandsupportonindiamartclickandredirection() {
		quicklinks.clickoncommunicationandsupport();
		Assert.assertTrue(quicklinks.visibilitycommunicationandsupportonindiamart(), "Not on the communication and support page redirection failed");
	}
	@Test(priority = 9)
	public void verifypoliciesandguidelinesonindiamartclickandredirection() {
		quicklinks.clickonpoliciesandguidelines();
		Assert.assertTrue(quicklinks.visibilitypoliciesandguidelinesonindiamart(), "Not on the policies and guidelines page redirection failed");
	}
	@Test(priority = 10)
	public void verifyaccountandprivacyonindiamartclickandredirection() {
		quicklinks.clickonaccountandprivacy();
		Assert.assertTrue(quicklinks.visibilityaccountandprivacyonindiamart(), "Not on the account and privacy page redirection failed");
	}
	@Test(priority = 11)
	public void verifycomplaintsonindiamartclickandredirection() {
		quicklinks.clickoncomplaints();
		wait = new WebDriverWait(driver, utilities.Timeout);
		wait.until(ExpectedConditions.titleIs(dataprop.getProperty("complaints_title")));
		Assert.assertTrue(driver.getTitle().contains(dataprop.getProperty("complaints_title")),"Not on the complaints page redirection failed");
	}
}
