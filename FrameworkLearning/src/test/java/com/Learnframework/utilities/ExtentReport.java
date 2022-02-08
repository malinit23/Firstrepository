package com.Learnframework.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
	public ExtentReport() {
	
		//start reporter
	ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("./Reports/FreeCRM.html");
		// create reports and attach reporter
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(htmlreporter);
		//ExtentTest class used to call createTest method and pass Testname
	ExtentTest logger = extent.createTest("LoginTest");
	logger.log(Status.INFO, "Login Application");
	logger.log(Status.PASS, "Title Verified");
	
	
	}

}
