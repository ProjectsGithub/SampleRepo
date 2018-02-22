package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	public HomePageTest(){
		super();
	}

	@BeforeMethod
	public void SetUp(){
		initialization();
		 homepage = new HomePage();
		 loginpage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void navigateToHomepage(){
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//homepage.validateSearchButton();
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
