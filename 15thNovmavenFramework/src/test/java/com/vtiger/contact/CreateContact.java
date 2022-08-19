package com.vtiger.contact;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateContact {
	@Test
	public void CreateContactTest()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
		WebDriver driver= new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		//login
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		 WebElement nameTitle = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		
		//for dropdown handle 
		
		Select s = new Select(nameTitle);
		s.selectByIndex(1);
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Pradeep");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys("TCS");
		
		WebElement leadSource = driver.findElement(By.xpath("//select[@name='leadsource']"));
		Select s1 = new Select(leadSource);
		s1.selectByIndex(4);
		
		driver.findElement(By.xpath("//input[@name='emailoptout']")).click();
		driver.findElement(By.xpath("//input[@name='reference']")).click();
		
		//driver.findElement(By.id("//img[@id='jscal_trigger_birthday']")).click();
		
		driver.findElement(By.xpath("//input[@value='T']")).click();
		
		WebElement assignedTo = driver.findElement(By.xpath("//select[@name='assigned_group_id']"));
		Select s3 = new Select(assignedTo);
		s3.selectByIndex(1);
		
		driver.findElement(By.xpath("//input[@onclick='return copyAddressLeft(EditView)']")).click();
		
	    //for file Upload
		
		File f = new File("./src/test/resources/data/oBJECTcLASS.png");
		String absolutepath = f.getAbsolutePath();
		driver.findElement(By.xpath("//input[@name='imagename']")).sendKeys(absolutepath);
		
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		driver.close();
		
		System.out.println("End of java code");
	}
}
