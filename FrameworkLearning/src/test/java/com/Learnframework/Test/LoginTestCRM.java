package com.Learnframework.Test;



import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.Learnframework.pages.Baseclass;
import com.Learnframework.pages.LoginPagePF;
import com.Learnframework.utilities.Helper;
import com.aventstack.extentreports.Status;


public class LoginTestCRM extends Baseclass {
	


	/*here baseclass is extended to invoke the browser start and quit process by writing it in different class and it has TestNG operations to perform in it
	-- extend means inheritance of the parent class so the methods in parent class can be accessed by sub class*/	
	
	@Test
	
	
	/*	 abstracting concept is implemented here only the essential actions are shown in the below method remaining methods like launching and quitting are hidden under base class*/

	
	public void LoginAPP()
	{
			
/*PageFactory model used to implement the page object model*/
		
		 logger = extent.createTest("LoginTestCRM");
	
		Reporter.log("extracting locators",true);
		LoginPagePF loginpage=PageFactory.initElements(driver, LoginPagePF.class);	
		logger.info("Starting Application");
		Reporter.log("extracted locators",true);
		loginpage.clicklogin(excel.getStringData("Login",0,0),excel.getStringData("Login",0,1));
		Helper.capturescreenshot(driver);
		Reporter.log("loggedinto the applicaiton",true); 
		logger.log(Status.PASS, "Login successful");
	}
	

	
	
}
