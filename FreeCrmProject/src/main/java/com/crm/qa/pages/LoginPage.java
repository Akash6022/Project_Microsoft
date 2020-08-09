package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	


	
	//pagefactory --Or
	
	@FindBy(name="email")
	WebElement username;
	
	
	@FindBy(name="password")
	WebElement password;
	
@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement lgnbtn;
	
	
	//Initialization the Page Objects;
	public LoginPage() {
		PageFactory.initElements(driver, this);}
	
	
	//Action 
	
	public static String ValidationPageTitle() {
		
	String str=	driver.getTitle();
	System.out.println("title of the page is ***** "+str);
		return str;
	}
	
	public  static  HomePage login() throws InterruptedException {
	
		
		try {
			
			
			WebDriverWait wait =new WebDriverWait(driver,20);
			WebElement	emai=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
			//emai.sendKeys(prop.getProperty("username"));
		 emai.click();
		Thread.sleep(2000);
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));
		
			driver.findElement(By.name("password")).click();
			driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.xpath("html/body/div/div/div/form/div/div[3]")).click();
			Thread.sleep(9000);
			
boolean link_visible=driver.findElement(By.linkText("Free account")).isDisplayed();
	
	
Assert.assertEquals(true, link_visible);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		
	/*	
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(2000);
		lgnbtn.click();*/
		
		return new HomePage();
	}

	
/*public void clickLogin(String un, String pwd) {
	try {
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//*[@id='ui']/div/div/form/div/div[3]")).click();
	} catch (Exception e) {
		// TODO Auto-generated catch block
	System.out.println(e.getMessage());
	}	 
	
}

public String titlePage() {
	return driver.getTitle();
}*/


}
