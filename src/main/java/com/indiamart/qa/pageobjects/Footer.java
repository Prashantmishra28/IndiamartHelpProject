package com.indiamart.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.indiamart.qa.utils.utilities;

public class Footer {
	
	WebDriver driver;
	WebDriverWait wait;
//Elements which needs to clicked on the homepage
	@FindBy(xpath="//div[@id='footer-free']//a[normalize-space()='Help']")
	private WebElement help;
	
	@FindBy(xpath="//div[@id='footer-free']//a[normalize-space()='Feedback']")
	private WebElement feedback;
	
	@FindBy(xpath="//div[@id='footer-free']//a[normalize-space()='Complaints']")
	private WebElement complaints;
	
	@FindBy(xpath="//div[@id='footer-free']//a[normalize-space()='Customer Care']")
	private WebElement customercare;
	
	@FindBy(xpath="//div[@id='footer-free']//a[normalize-space()='Contact Us']")
	private WebElement contactus;
	
	@FindBy(xpath="//div[@id='footer-free']//a[normalize-space()='Suppliers Tool Kit']")
	private WebElement supplierstoolkit;
	
	@FindBy(xpath="//div[@id='footer-free']//a[normalize-space()='Seller Tools']")
	private WebElement sellertools;
	
	@FindBy(xpath="//div[@id='footer-free']//a[normalize-space()='Latest BuyLead']")
	private WebElement latestbuylead;
	
	@FindBy(xpath="//div[@id='footer-free']//a[normalize-space()='Learning Centre']")
	private WebElement learningcentre;
	
	@FindBy(xpath="//div[@id='footer-free']//a[normalize-space()='Ship With IndiaMART']")
	private WebElement shipwithindiamart;
	
	@FindBy(xpath="(//a[contains(text(),'Security')])[1]")
	private WebElement securitytipsforsellers;
	
	@FindBy(xpath="//div[@id='footer-free']//a[normalize-space()='Buyers Tool Kit']")
	private WebElement buyertoolkit;
	
	@FindBy(xpath="//div[@id='footer-free']//a[normalize-space()='Post Your Requirement']")
	private WebElement postyourrequirement;
	
	@FindBy(xpath="//div[@id='footer-free']//a[normalize-space()='Products You Buy']")
	private WebElement productsyoubuy;
	
	@FindBy(xpath="//div[@id='footer-free']//a[normalize-space()='Search Products & Suppliers']")
	private WebElement searchproductsandsuppliers;
	
	@FindBy(xpath="(//a[contains(text(),'Security Tips')])[1]")
	private WebElement securitytipsforbuyers;
	
	@FindBy(xpath="//a[text()='Terms of Use']")
	private WebElement termofuse;
	
	@FindBy(xpath="//a[text()='Privacy Policy']")
	private WebElement privacypolicy;
	
	@FindBy(xpath="//a[text()='Link to Us']")
	private WebElement linktous;
	
	@FindBy(xpath="//a[text()='iOS App']")
	private WebElement iosapp_icon;
	
	@FindBy(xpath="//a[text()='Android App']")
	private WebElement andriodapp_icon;
	
	@FindBy(xpath="//a[text()='https://m.indiamart.com']")
	private WebElement msiteapp_icon;
	
	@FindBy(xpath="//a[text()='Facebook']")
	private WebElement facebook_icon;
	
	@FindBy(xpath="//a[text()='Twitter']")
	private WebElement twitter_icon;
	
	@FindBy(xpath="//a[text()='linkedin']")
	private WebElement linked_icon;
	
//Elements which needs to be validated after clicking the elements 
	
	@FindBy(xpath="//h1[normalize-space()='IndiaMART Feedback']")
	private WebElement feedback_page;
	
	@FindBy(xpath="//h1[normalize-space()='IndiaMART Complaint']")
	private WebElement complaint_page;
	
//	@FindBy(xpath="//a[@aria-label='Apple']\r\n"
//			+ "")
	
	public Footer(WebDriver driver) {
		this.driver = driver;
		this.wait= new WebDriverWait(driver,utilities.Timeout);
		PageFactory.initElements(driver, this);
	}
	
	private boolean iselementvisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}	
	
	private void iselementclickable(WebElement element_click) {
		wait.until(ExpectedConditions.elementToBeClickable(element_click)).click();
	}
	
	public void clickonhelp() { iselementclickable(help);}
	public void clickonfeedback() { iselementclickable(feedback);}
	public void clickoncomplaints() { iselementclickable(complaints);}
	public void clickoncustomercare() { iselementclickable(customercare);}
	public void clickoncontactus() { iselementclickable(contactus);}
	public void clickonsuppliertoolkit() { iselementclickable(supplierstoolkit);}
	public void clickonsellertools() { iselementclickable(sellertools);}
	public void clickonlatestbuylead() { iselementclickable(latestbuylead);}
	public void clickonlearningcentre() { iselementclickable(learningcentre);}
	public void clickonshipwithindiamart() { iselementclickable(shipwithindiamart);}
	public void clickonsecuritytipsforsellers() { iselementclickable(securitytipsforsellers);}
	public void clickonbuyertoolkit() { iselementclickable(buyertoolkit);}
	public void clickonpostyourrequirement() { iselementclickable(postyourrequirement);}
	public void clickonproductyoubuy() { iselementclickable(productsyoubuy);}
	public void clickonsearchproductsandsuppliers() { iselementclickable(searchproductsandsuppliers);}
	public void clickonsecuritytipsforbuyers() { iselementclickable(securitytipsforbuyers);}
	public void clickontermofuse() { iselementclickable(termofuse);}
	public void clickonprivacypolicy() { iselementclickable(privacypolicy);}
	public void clickonlinktous() { iselementclickable(linktous);}
	public void clickonappleicon() { iselementclickable(iosapp_icon);}
	public void clickonandrioidicon() { iselementclickable(andriodapp_icon);}
	public void clickonmobileicon() { iselementclickable(msiteapp_icon);}
	public void clickonfacebook() { iselementclickable(facebook_icon);}
	public void clickontwitter() { iselementclickable(twitter_icon);}
	public void clickonlinkedin() { iselementclickable(linked_icon);}
	
	public boolean visiblityofcomplaints() { return iselementvisible(complaint_page); }
	

}
