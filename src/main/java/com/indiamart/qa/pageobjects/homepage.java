package com.indiamart.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.indiamart.qa.utils.utilities;

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
	
	@FindBy(xpath="//div[@class='site-header-primary-section-right site-header-section ast-flex ast-grid-right-section']//div[@class='ast-custom-button'][contains(text(),'Get Best Price')]")
	private WebElement get_price_cta;
	
	@FindBy(id="menu-item-39855")
	private WebElement shopping_cta;
	
	@FindBy(id="menu-item-39856")
	private WebElement sell_cta;
	
	@FindBy(id="menu-item-39857")
	private WebElement videos_cta;
	
	@FindBy(id="menu-item-39858")
	private WebElement messages_cta;
	
	@FindBy(xpath="//div[@class='one_s']")
	private WebElement messages_cta_signin_pop_up;
	
	@FindBy(id="close_s")
	private WebElement messages_cta_sigin_popup_close;
	
	
	@FindBy(id="menu-item-39859")
	private WebElement feedback_cta;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement home;
	
	@FindBy(xpath="//a[text()='Post Your Requirement ']")
	private WebElement postyourrequirement;
	
	@FindBy(id="bus_buy")
	private WebElement verifiedbusinessbuyer;
	
	@FindBy(xpath="//a[@class='h_ic34']")
	private WebElement productservicedirectory;
	
	@FindBy(css=".recely")
	private WebElement recentactivity;
	
	@FindBy(css=".h_ic21")
	private WebElement managerequirement;
	
	@FindBy(xpath="//a[@href='//my.indiamart.com/settings/mysettings/']")
	private WebElement setting;
	
	@FindBy(xpath="//ul[@class='trail-items']")
	private WebElement breadcrumb;
	
	@FindBy(xpath="//p[contains(text(),'Sorry, but nothing matched your search terms. Plea')]")
	private WebElement actualsearchmessage;
	
	@FindBy(xpath="//div[@class='nb-pr nb-fHd nb-f16 nb-clFf']")
	private WebElement buyertoolpage;
	
	
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
	
	public void howerfromsigintojoinow() {
		Actions hower = new Actions(driver);
		hower.moveToElement(signinbtn).pause(1000).moveToElement(joinnowbtn).click().build().perform();	
	}
	
	public void clickongetpricecta() {
		get_price_cta.click();	
	}
	
	public void clickonshoppingcta() {
		shopping_cta.click();
	}
	
	public void clickonsellcta() {
		sell_cta.click();
	}
	
	public void clickonvideocta() {
		videos_cta.click();
	}
	
	public void clickonmessagecta() {
		messages_cta.click();
	}
	
	public void closesiginpopup() {
		Actions actions= new Actions(driver);
		actions.moveToElement(messages_cta_signin_pop_up).pause(1000).moveToElement(messages_cta_sigin_popup_close).click().build().perform();
	}
	
	public void clickonfeedbackcta() {
		feedback_cta.click();
	}
	
	public Boolean visiblityofbreadcrumb() {
		WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
		return wait.until(ExpectedConditions.visibilityOf(breadcrumb)).isDisplayed();
	}
	
	public Boolean visiblityofactualsearchmessage() {
		return actualsearchmessage.isDisplayed();
	}
	
	public void moveandclickhome() {
		Actions actions = new Actions(driver);
		actions.moveToElement(signinbtn).pause(1000).moveToElement(home).click().build().perform();
	}
	
	public void moveandclickpostyourrequirement() {
		Actions actions = new Actions(driver);
		actions.moveToElement(signinbtn).pause(1000).moveToElement(postyourrequirement).click().build().perform();
	}
	
	public void moveandclickverifiedbusinessbuyer() {
		Actions actions = new Actions(driver);
		actions.moveToElement(signinbtn).pause(1000).moveToElement(verifiedbusinessbuyer).click().build().perform();
	}
	
	public void moveandclickproductservicedirectory() {
		Actions actions = new Actions(driver);
		actions.moveToElement(signinbtn).pause(1000).moveToElement(productservicedirectory).click().build().perform();
	}
	
	public void moveandclickrecentactivity() {
		Actions actions = new Actions(driver);
		actions.moveToElement(signinbtn).pause(1000).moveToElement(recentactivity).click().build().perform();
	}
	
	public void moveandclickmanagerequirement() {
		Actions actions = new Actions(driver);
		actions.moveToElement(signinbtn).pause(1000).moveToElement(managerequirement).click().build().perform();
	}
	
	public void moveandclicksetting() {
		Actions actions = new Actions(driver);
		actions.moveToElement(signinbtn).pause(1000).moveToElement(setting).click().build().perform();
	}
	public Boolean visibilitybuyertoolpage() {
		WebDriverWait wait = new WebDriverWait(driver, utilities.Timeout);
		return wait.until(ExpectedConditions.visibilityOf(buyertoolpage)).isDisplayed();
	}
	
}
