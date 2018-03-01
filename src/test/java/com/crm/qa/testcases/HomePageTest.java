package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactpage;
	public HomePageTest(){
		super();
	}

	//TestCases should be independent and should not be any dependency
	//Before each Testcase launch the browser and login
	//After eaxh Testcase close the browser
	//Because if u use all the Test case in one login the application will get crash or the browser will get exhausted
	
	@BeforeMethod
	public void SetUp(){
		initialization();
		 testutil = new TestUtil();
		 loginpage = new LoginPage();
		 
		 homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void VerifyHomePageTitleTest(){
		String HomePageTitle = homepage.VerifyHomePageTitle();
        Assert.assertEquals(HomePageTitle, "CRMPRO","HomePage Title not matched");
	
	}
	
	@Test(priority=2)
	public void VerifyCorrectUserNameTest(){
		testutil.SwitchToFrame();
		boolean CorrectUserName= homepage.VerifyCorrectUserName();
		Assert.assertTrue(CorrectUserName);
	}
	
	@Test
	public void VerifyContactLinkTest(){
		testutil.SwitchToFrame();
		ContactsPage contact =homepage.ClickContactLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
