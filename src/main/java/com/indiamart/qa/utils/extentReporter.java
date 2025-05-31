package com.indiamart.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReporter {
	public static ExtentReports createextentreport() {
		
		ExtentReports extentRpt =new ExtentReports();
		File extentrptfile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentrpt.html");
		
		ExtentSparkReporter sparkRpt = new ExtentSparkReporter(extentrptfile);
		sparkRpt.config().setTheme(Theme.DARK);
		sparkRpt.config().setReportName("Indiamart Help Automation Results Report");
		sparkRpt.config().setDocumentTitle("Help Automation Report");
		sparkRpt.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentRpt.attachReporter(sparkRpt);
		
		
		Properties configprop = new Properties();
		File configpropfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\indiamart\\qa\\config\\config.properties");
		try {
		FileInputStream fisconfigprop = new FileInputStream(configpropfile); 
		configprop.load(fisconfigprop);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		extentRpt.setSystemInfo("Application URL",configprop.getProperty("url"));
		extentRpt.setSystemInfo("Browser Name",configprop.getProperty("browser"));
		extentRpt.setSystemInfo("Operation System", System.getProperty("os.name"));
		extentRpt.setSystemInfo("User Name", System.getProperty("user.name"));
		extentRpt.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentRpt;
	}

}
