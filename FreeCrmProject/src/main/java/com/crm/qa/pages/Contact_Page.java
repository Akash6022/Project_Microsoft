package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class Contact_Page extends TestBase {

	
	public static boolean verifyContactPage() {
		boolean contactlabel= driver.findElement(By.xpath("//div[@class='ui header item mb5 light-black']")).isDisplayed();
				
		
		return contactlabel;

	}
	
	public static void clickonNewContact(String ftName, String mdlName,String ltName,String email) {
		try {
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]/button[1]")).click();
			
			

			WebDriverWait wait =new WebDriverWait(driver,20);
			WebElement	first_name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("first_name")));
			first_name.sendKeys(ftName);
			//driver.findElement(By.name("first_name")).sendKeys(ftName);
			driver.findElement(By.name("middle_name")).sendKeys(mdlName);
			driver.findElement(By.name("last_name")).sendKeys(ltName);
			
			driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(email);
			driver.findElement(By.xpath("//i[@class='save icon']")).click();
		} catch (Exception e) {
			System.out.println("Element not found");
		}
		
	}
}