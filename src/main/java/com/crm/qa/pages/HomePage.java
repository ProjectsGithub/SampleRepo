package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory - OR
	
	@FindBy(xpath="//td[contains(text(),'Naveen K')]")
	WebElement UserName;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement Contacts;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
    WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement Tasks;
	 
   
	//To initialize all the Web elements in this Home Page 
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	

	public String VerifyHomePageTitle(){
		return driver.getTitle();
	}
	

	public boolean VerifyContactsLink(){
		return Contacts.isDisplayed();
	}
	
	public boolean VerifyCorrectUserName(){
		return UserName.isDisplayed();
	}
	

	public ContactsPage ClickContactLink(){
		Contacts.click();
		return new ContactsPage();
	}
	
	public DealsPage DealsLink(){
		DealsLink.click();
		return new DealsPage();
	}
	
	public TaskPage TaskLinkClick(){
		Tasks.click();
		return new TaskPage();
	}
}
