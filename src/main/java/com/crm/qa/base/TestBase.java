package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream fip = new FileInputStream("C:\\TechMahindraProject3DS\\FreeCRMTest\\src\\main\\java\\com\\crm" + 
			"\\qa\\config\\config.properties");
			prop.load(fip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {                                                                                                                                                                                                      
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mano\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		if(browserName.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Mano\\Documents\\tamil\\TAMIZH\\STUDY"+
		"\\testing\\Testing-Mano\\Mano\\TestLeaf\\drivers\\geckodriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		if(browserName.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.internetexplorer.driver", "C:\\Users\\Mano\\Documents\\tamil\\TAMIZH\\STUDY"+
		"\\testing\\Testing-Mano\\Mano\\TestLeaf\\drivers\\iedriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}

}
