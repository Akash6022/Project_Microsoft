package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
                                     

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	static HomePage homePage;        
	 
	public  LoginPageTest() {
	super();
	}
	
	
	@BeforeMethod
	public void setUp() {
	intialization();
	
		}
		
	@Test()
	public void loginTest() throws InterruptedException {
		
		LoginPage.ValidationPageTitle();
		homePage=	LoginPage.login();
		
		
	
	}
	
	
	
	
	
	

	
	@AfterMethod()
public void tearDown() {
	driver.quit();
	
	
	
}
}
