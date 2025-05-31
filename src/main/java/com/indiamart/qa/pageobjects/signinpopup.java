package com.indiamart.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signinpopup {
	
	WebDriver driver;
	
	@FindBy(id="mobile")
	private WebElement mobinputbox;
	
	@FindBy(xpath="//button[@id='logintoidentify']")
	private WebElement submitbtn;
	
	@FindBy(xpath="//span[@id='mobile_err']")
	private WebElement invalidmobilenumbermessage;
	
	@FindBy(xpath="//span[@id='mobile_err']")
	private WebElement entermobilenumbererrormessage;
	
	public signinpopup(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void mobileinput(String mobnumber) {
		
		mobinputbox.sendKeys(mobnumber);
		
	}
	
	public void clickonsubmitbtn() {
		
		submitbtn.click();	
	}
	
	public String getinvalidmobilenumbererrormessagetext() {
		
		String err_msg = invalidmobilenumbermessage.getText();
		return err_msg;	
	}
	
	public String EnterMobileNumberErrorMessageText() {
			
		String enter_mob_num_err_msg = entermobilenumbererrormessage.getText();
		return enter_mob_num_err_msg;
	}

}
