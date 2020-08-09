package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	public static String verifyhomePage() {
		return driver.getTitle();
		
	}
	
	public static boolean verifyCorrrectUsername() {
		return driver.findElement(By.xpath("//span[contains(text(),'akash gaurav')]")).isDisplayed();
	}
	
	public static void Validation_element() {
		try {
			
			
			boolean username_akash=driver.findElement(By.xpath("//*[@id='top-header-menu']/div[3]/span[1]")).isDisplayed();
			   Assert.assertEquals(true, username_akash);//
			
			List<WebElement> no_Elements=driver.findElements(By.xpath("//div[@id='main-nav']/a"));
			int type=no_Elements.size();{
			
				
			
			for (int i = 0; i <type; i++) {
				String tr=no_Elements.get(i).getText();
				
				System.out.println("No of elements name  "+tr);
				if (tr.equalsIgnoreCase("Contacts")) {
					driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/a[3]/span[1]")).click();
					break;
					
				}
			}
			}}
			
		 catch (Exception e) {
			// TODO: handle exception
		}
	}
		public static Contact_Page clickonContact() {
			driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
			return new Contact_Page();
		}
		
		public static Deals_Page clickOnDeal() {
			driver.findElement(By.xpath("//span[contains(text(),'Deals')]")).click();
			return new Deals_Page();
		}
		public static Task_Page clickOnTaskPage() {
			driver.findElement(By.xpath("//span[contains(text(),'Tasks')]")).click();
			return new Task_Page();
		}
		
	}
	
	
	
	
	


	
