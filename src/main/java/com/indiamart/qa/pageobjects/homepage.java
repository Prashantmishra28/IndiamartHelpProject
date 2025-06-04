package com.indiamart.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
	WebDriver driver;
	
	//These are Objects
	@FindBy(xpath="//a[@id='user_sign_in']")
	private WebElement signinbtn;
	
	@FindBy(xpath="//li[@id='lshead']")
	private WebElement hi;
	
	@FindBy(css=".h_clr.bld")
	private WebElement joinnowbtn;
	
	@FindBy(xpath="//input[@class='search-field']")
	private WebElement searchinputbox;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchbtn;
	
	public homepage(WebDriver driver ) {
		
		this.driver =  driver;
		PageFactory.initElements(driver,this);
	}
	
	//These are Actions
	
	public signinpopup clickonsignin() {
		
		signinbtn.click();
		return new signinpopup(driver);
	}
	public Boolean hiTexxtVisiblity() {
			
		Boolean hitext = hi.isDisplayed();
		return hitext;
	}
	
	public void clickingOnJoinnow() {
		
		joinnowbtn.click();
	}
	public void inputInSearchBox(String searchInputs) {
		
		searchinputbox.sendKeys(searchInputs);
	}
	
	public void clickonsearchbutton() {
		
		searchbtn.click();
	}
	
	public void clickonsearchbutton(WebElement element) {
			element = driver.findElement(By.xpath("//li[@id='lshead']"));
			element.click();
	}
	public void clickonsearchbutton(By Locator) {
		driver.findElement(By.xpath("//li[@id='lshead']")).click();
	}
}
