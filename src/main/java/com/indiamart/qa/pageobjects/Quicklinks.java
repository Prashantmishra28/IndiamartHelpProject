package com.indiamart.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.indiamart.qa.utils.utilities;

public class Quicklinks {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//a[text()='How to Register for Paid Services on IndiaMART?']")
	private WebElement quicklink1;
	
	@FindBy(xpath="//a[text()='Does IndiaMART Provide Shipping Services?']")
	private WebElement quicklink2;
	
	@FindBy(xpath="//a[text()='How to Sell Items on IndiaMART?']")
	private WebElement quicklink3;
	
	@FindBy(xpath="//h3[text()='Buying on IndiaMART']")
	private WebElement buyingonindiamart;
	
	@FindBy(xpath="//h3[text()='Selling on IndiaMART']")
	private WebElement sellingonindiamart;
	
	@FindBy(xpath="//h3[text()='Paid Services']")
	private WebElement paidserviceofindiamart;
	
	@FindBy(xpath="//h3[text()='Payment Related']")
	private WebElement paymentrelated;
	
	@FindBy(xpath="//h3[text()='Communication and Support']")
	private WebElement communicationandsupport;
	
	@FindBy(xpath="//h3[text()='Policies and Guidelines']")
	private WebElement policiesandguidelines;
	
	@FindBy(xpath="//h3[text()='Account and Privacy']")
	private WebElement accountandprivacy;
	
	@FindBy(xpath="//h3[text()='Complaints']")
	private WebElement complaints;
	
	private boolean iselementvisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}	
	
	private void iselementclickable(WebElement element_click) {
		wait.until(ExpectedConditions.elementToBeClickable(element_click)).click();
	}
 	
	public Quicklinks(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, utilities.Timeout);
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonquicklink1() { iselementclickable(quicklink1); }
	
	public void clickonquicklink2() { iselementclickable(quicklink2); }
	
	public void clickonquicklink3() { iselementclickable(quicklink3); }
	
	public void clickonbuyingonindiamart() { iselementclickable(buyingonindiamart); }
	
	public Boolean visibilitybuyingonindiamart() { return iselementvisible(buyingonindiamart);}
	
	public void clickonsellingonindiamart() { iselementclickable(sellingonindiamart); }
	
	public Boolean visibilitysellinggonindiamart() { return iselementvisible(sellingonindiamart);}
	
	public void clickonpaidserviceofindiamart() { iselementclickable(paidserviceofindiamart);}
	
	public Boolean visibilitypaidserviceonindiamart() { return iselementvisible(paidserviceofindiamart);}
	
	public void clickonpaymentrelated() { iselementclickable(paymentrelated); }
	
	public Boolean visibilitypaymentrelatedonindiamart() { return iselementvisible(paymentrelated); }
	
	public void clickoncommunicationandsupport() { iselementclickable(communicationandsupport); }
	
	public Boolean visibilitycommunicationandsupportonindiamart() { return iselementvisible(communicationandsupport); }
	
	public void clickonpoliciesandguidelines() { iselementclickable(policiesandguidelines); }
	
	public Boolean visibilitypoliciesandguidelinesonindiamart() { return iselementvisible(policiesandguidelines); }
	
	public void clickonaccountandprivacy() { iselementclickable(accountandprivacy); }
	
	public Boolean visibilityaccountandprivacyonindiamart() { return iselementvisible(accountandprivacy); }
	
	public void clickoncomplaints() { iselementclickable(complaints); }	

}
