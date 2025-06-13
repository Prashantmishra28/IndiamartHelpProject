package com.indiamart.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.indiamart.qa.utils.extentReporter;
import com.indiamart.qa.utils.utilities;

public class Listeners implements ITestListener {
	
	ExtentReports extentreport;
	ExtentTest extenttest;
	
	@Override
	public void onStart(ITestContext context) {
		
		extentreport = extentReporter.createextentreport();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		extenttest = extentreport.createTest(result.getName());
		extenttest.log(Status.INFO, result.getName() +" Started Executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.log(Status.PASS,result.getName()+" Test Got Successfully Executed");	
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String screenshotpath = utilities.captureScreenshot(driver, result.getName());
		
		extenttest.addScreenCaptureFromPath(screenshotpath);
		extenttest.log(Status.INFO,result.getThrowable());
		extenttest.log(Status.FAIL,result.getName() + " Test Got Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.SKIP, result.getName() + " Test Got Skipped");
	}
 
	@Override
	public void onFinish(ITestContext context) {
		
		extentreport.flush();
		String pathofextenreport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentrpt.html";
		File extentreport = new File(pathofextenreport);
		try {
			Desktop.getDesktop().browse(extentreport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
