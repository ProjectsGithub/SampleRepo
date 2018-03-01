package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {

	//Page Factory - OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//button[contains(text(),'SignUp')]")
	WebElement SignUp;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement CRMlogo;
	
    //Initializing Page Factory - OR
    public LoginPage(){
    	PageFactory.initElements(driver, this);
    }
    
    public String validateLoginPageTitle(){
    	return driver.getTitle();
    }
    	
    public boolean validateCRMLogo(){
    	return CRMlogo.isDisplayed();
    }
    
    public HomePage login(String un,String pwd){
    	username.sendKeys(un);
    	password.sendKeys(pwd);
    	loginbtn.click();
    	
    	return new HomePage();
    }
    }
    
    
    



