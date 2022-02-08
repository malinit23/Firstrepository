package com.Learnframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPagePF {

	WebDriver driver ;
	
	
	/*creating a constructor to access the locators and methods from this class to every testcases
	here page factory approach of page object model is used */
	
	public LoginPagePF(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Log In')]") WebElement login; 
	@FindBy(name="email") WebElement uname;
	@FindBy(name="password") WebElement pwd;
	@FindBy(xpath="//div[contains(text(),'Login')]") WebElement logbtn;
	
	public void clicklogin(String username,String pass)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
	
		}
		
		login.click();
		uname.sendKeys(username);
		pwd.sendKeys(pass);
		logbtn.click();
	}
	
	
	
}
