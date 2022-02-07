package com.Learnframework.pages;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.Learnframework.utilities.BrowserFactory;
import com.Learnframework.utilities.ConfigDataProvider;
import com.Learnframework.utilities.ExcelDataProvider;
import com.Learnframework.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Baseclass {
	
	/* creating the before class and after class as common class to be used by evry test cases*/

	
	public WebDriver driver ; /* it is denoted as public to handle across all the inherited classes or subclasses*/
	
	public ExcelDataProvider excel;
	public ConfigDataProvider config; 
	public ExtentReports extent;
	public ExtentTest logger;
	/* begin set up*/
	@BeforeSuite
	public void setupSuite()
	{
	 Reporter.log("Setting up of test begins",true);	
	 excel = new ExcelDataProvider();
	 config= new ConfigDataProvider();
	 
	 //Initialize Extent Reports
	 
	 ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/LoginReport"+Helper.getCurrentDateTime()+".html"));
	 extent = new ExtentReports();
	 extent.attachReporter(htmlreporter);
	
	 Reporter.log("Setting up done",true);	
	}
	
	@BeforeClass
	
	public void setup()
	{
		Reporter.log("Application is going to be launched",true);	
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getURL());
		Reporter.log("Application is launched",true);	
		Helper.capturescreenshot(driver);
	}


	@AfterClass
	public void teardown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result) throws Exception
	{
		
		 Reporter.log("Test results will be assessed ",true);	
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		else if (result.getStatus()==ITestResult.FAILURE)
		{
			
			//to attach screenshot to the html report
			
			logger.fail("Test failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		
		extent.flush();
		 Reporter.log("Test completed >>> ReportGenerated ",true);	
		
	}

	
}
