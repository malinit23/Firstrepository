package com.Learnframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	/*creating a constructor to access the locators and methods from this class to every testcases
	here normal approach of page object model is used not pagefactory*/
	 
		
	By Signup = By.xpath("//span[contains(text(),' sign up')]");
	By Loginapp = By.xpath("//span[contains(text(),'Log In')]");
	By uname = By.name("email");
	By pwd   = By.name("password");
	By loginbtn = By.xpath("//div[contains(text(),'Login')]");
	
	public LoginPage(WebDriver ldriver)
	
	{	this.driver=ldriver;
						
	}

	
	public void clicksignup()
	{
		
		driver.findElement(Signup).click();
		
	}
	public void clickLoginapp( )  
	{
		driver.findElement(Loginapp).click();
	}
	
	public void typeusername(String email)
	
	{
	
		driver.findElement(uname).sendKeys(email);
	}
	
	public void typepassword(String pass) 
	{
		
		driver.findElement(pwd).sendKeys(pass);
	}
	
	public void clickloginbtn() 
	{		
		
		driver.findElement(loginbtn).click();
	}
	
	}
	

