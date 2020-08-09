package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;

import WebEventListener.WebEventListener;

public class TestBase {

public static WebDriver driver;
public static Properties prop;
public  static EventFiringWebDriver e_driver;
public static WebEventListener eventListener;
	
public 	TestBase() {
	
	try {
		prop= new Properties();             //D:\New folder\FreeCrmProject\src\main\java\com\crm\qa\config\config.properties
		
		FileInputStream ip= new FileInputStream("E:\\workspace\\FreeCrmProject\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");  //
				prop.load(ip);
	} catch (FileNotFoundException e) {   
		
		e.printStackTrace();
	}
       catch (IOException e) {
		
		e.printStackTrace();
	} 
		
	}
	
	public static void intialization() {
		
	String browserName=	prop.getProperty("browser");
	if (browserName.equals("chrome")) {
		

	System.setProperty("webdriver.chrome.driver","E:\\Library\\chromedriver.exe");  
	 driver = new ChromeDriver();
		
		
	}
	else if (browserName.equals("FF")) {
		System.setProperty("webdriver.chrome.driver","E:\\Library\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	
	
	
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
   eventListener =new WebEventListener();
   e_driver.register(eventListener);
   driver=e_driver;
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeOut, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
	
	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeOut, TimeUnit.SECONDS);
	
	
	
	}}
	
	/*public void takeScreenshotAtEndofTest() {
		
		// Take screenshot and store as a file format
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// now copy the screenshot to desired location using copyFile //method
				String currentDir = System.getProperty("user.dir");
	}*/	