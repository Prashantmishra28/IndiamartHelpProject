package com.indiamart.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://my.indiamart.com/enquiry/messagecentre/");
		System.out.println(driver.getTitle());

	}

}
