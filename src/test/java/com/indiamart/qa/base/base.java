package com.indiamart.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.indiamart.qa.utils.utilities;

public class base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	public base() {
		
		prop = new Properties();
		dataprop = new Properties();
		File datapropfile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\indiamart\\qa\\testdata\\testdata.properties");
		try {
		FileInputStream datafis = new FileInputStream(datapropfile);
		dataprop.load(datafis);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		File propertiesfile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\indiamart\\qa\\config\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(propertiesfile);
		prop.load(fis);
		}
		catch(Throwable e ){
			e.printStackTrace();	
		}
		
		
	}
	public WebDriver browserSetupandOpenApplication(String browsername) {
		
		
		if (browsername.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			
		}else if (browsername.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
		}else if (browsername.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			
		}else if (browsername.equalsIgnoreCase("safari")) {
			
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.Implicit_Wait_Time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.Page_Load_Time));
		driver.get(prop.getProperty("url"));
		
		
		return driver;
		
		
	}

}
