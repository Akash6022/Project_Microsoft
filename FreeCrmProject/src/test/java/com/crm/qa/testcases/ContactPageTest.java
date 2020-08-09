  package com.crm.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contact_Page;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {

	String sheetName="contacts";
	
	public ContactPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
	intialization();
	LoginPage.ValidationPageTitle();
	LoginPage.login();
	
	}
	
	
	@DataProvider
	public Object[][] getCRmTestData() {
	Object  data[][] =	TestUtil.getTestData(sheetName);
	return data;
	}
	@Test(dataProvider="getCRmTestData")
	public void createContact(String firstname, String middlename, String lastname,String email)
	{
		HomePage.clickonContact();
		Contact_Page.clickonNewContact(firstname, middlename, lastname, email);
	}
	
	
	@AfterTest
	public void teardown() {
		
			
		driver.quit();
			
		}
		
		
	}

