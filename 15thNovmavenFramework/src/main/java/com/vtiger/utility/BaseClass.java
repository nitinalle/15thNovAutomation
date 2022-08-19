package com.vtiger.utility;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.objectRepository.HomePage;
import com.objectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	FileUtility futil = new FileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	
	
	
	@BeforeClass
	public void launchBrowser() throws Exception
	{	
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
	   String browserName = futil.getPropertyData("browser");
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@BeforeMethod
	public void login() throws Exception
	{
		LoginPage login = new LoginPage(driver);
		String url = futil.getPropertyData("url");
		String userName = futil.getPropertyData("username");
		String password = futil.getPropertyData("password");
			
		//login vtiger
         driver.get(url);
         
         login.setLogin(userName, password);   
           /*  driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userName);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@type='submit']")).click();*/
	}
	
	@AfterMethod
	public void logout()
	{
		HomePage homePage = new HomePage(driver);
		
		//WebElement logoutDropdown = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//WebElement logoutDropdown = homePage.getLogoutBox();
		//wUtil.mousehover(driver, logoutDropdown);
		//homePage.getLogout().click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
	}
}
