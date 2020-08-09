package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase   {
	
	
	public HomePageTest() {
		super();
	}

	

	@BeforeMethod
	public void setUp() throws InterruptedException {
	intialization();
	LoginPage.ValidationPageTitle();
	LoginPage.login();
	
		}
	@Test(priority=1)
	public void HomePage() throws InterruptedException {
		
		String title_homepage=HomePage.verifyhomePage();
		assertEquals("Cogmento CRM", title_homepage);
		HomePage.Validation_element();
	} 
	@Test(priority=2)
	public void verifyUserName() {
		Assert.assertTrue(HomePage.verifyCorrrectUsername());
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
		
	}
	
	
	
	
}
