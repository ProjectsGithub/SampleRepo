package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory - OR
	@FindBy(xpath="https://www.freecrm.com/skins/flatter/images/search.gif")
	WebElement search;
	
	@FindBy(xpath="//a[contains(text(),'no company loaded')]")
	WebElement NoCompanyLoaded;
	
    public HomePage(){
    	PageFactory.initElements(driver, this);
	
}
    public void validateSearchButton(){
    	search.isDisplayed();
    }
    
    
    
}
