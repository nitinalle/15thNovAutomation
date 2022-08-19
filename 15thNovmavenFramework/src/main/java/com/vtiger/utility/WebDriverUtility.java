package com.vtiger.utility;

import java.awt.AWTException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * this method is for implicit wait
	 * @author RAJ MAHI
	 */
	public void waitforElement(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * this method is used for explicitwait
	 * @author RAJ MAHI
	 */
	public void waitforElementPresent(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));	
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	/**
	 * This method is for custom wait -->element is displayed or not
	 * @author RAJ MAHI
	 */
	public void customWait(WebElement element)
	{
		int i = 0;
		while(i<100)
		{
			try
			{	
				element.isDisplayed();
				break;
			}
			catch(Exception e)
			{
				i++;
			}
		}
	}
	
	/**
	 * This method is used to select the value from dropdown using index
	 * @author RAJ MAHI
	 * @param element 
	 * @param index 
	 */
	public void select(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);	
	}
	
	/**
	 * This method is used to select the value from dropdown using visibletext
	 * @author RAJ MAHI
	 * @param element 
	 * @param text 
	 * @param value 
	 * @param index 
	 */
	public void select(WebElement element, String text)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * this method is used to handle the alertpopup-->accept
	 * @author Annapurna
	 */
	public void alertPopUpAccept(WebDriver driver)
	{
		Alert s= driver.switchTo().alert();
		s.accept();
	}
	
	/**
	 * this method is used to handle the alertpopup-->dismiss
	 * @author Annapurna
	 */
		public void alertPopUpDismiss(WebDriver driver)
		{
			Alert a=driver.switchTo().alert();
			a.dismiss();
		}
	
	/**
	 * this method is used to switch into particular window/childpopup and get the title
	 * @author Annapurna
	 */
		public void childPopUp(WebDriver driver)
		{
			Set<String> whs = driver.getWindowHandles();
			System.out.println("Size=" + whs.size());
			for(String add:whs)
			{
				driver.switchTo().window(add);
				System.out.println("title=" + driver.getTitle());
			}
		}
			
	/**
	 * this method is used to perform mousehoveraction
	 * @author Annapurna
	 */
	   public void mousehover(WebDriver driver,	WebElement element)
	   {
		Actions p = new Actions(driver);
		p.moveToElement(element).perform();
		
	   }
	/**
	 * this method is used to perform contextClick/rightclick
	 * @throws AWTException 
	 * @author Annapurna
	 */
	   public void contextClick(WebDriver driver,WebElement element) throws AWTException
	   {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	   }
	
	/**
	 * this method is used to perform drag and drop
	 * @author Annapurna
	 */
	   public void dragAndDrop(WebDriver driver,WebElement source,WebElement destination)
	   {
		Actions ab=new Actions(driver);
		ab.dragAndDrop(source, destination).perform();
	   }
	
	/**
	 * this method is used to perform doubleclick
	 * @author Annapurna
	 */
	   public void doubleclick(WebDriver driver,WebElement element)
	   {
		Actions as=new Actions(driver);
		as.doubleClick(element).perform();
	   }
	
	/**
	 * this method is used to switch into particularframe by uing index 
	 * @author Annapurna
	 */
	   public void perticularframeByindex(WebDriver driver,int index)
	   {
		driver.switchTo().frame(index);
	   }
	
	/**
	 * this method is used to switch into particularframe by uing id
	 * @author Annapurna
	 */
	   public void frameById(WebDriver driver,String nameOrid)
	   {
		driver.switchTo().frame(nameOrid);
	   }
	
	/**
	 * this method is used to switch into particularframe by uing element
	 * @author Annapurna
	 */
	   
	   public void frameByElement(WebDriver driver,WebElement element)
	   {
		driver.switchTo().frame(element);
	   }
		   
	
	/**
	 * this method is used to write something in disabletextbox
	 * @author Annapurna
	 */
	   public void writeInDisable(WebDriver driver,String idName,String entryName)
	   {
		 
		JavascriptExecutor type=(JavascriptExecutor) driver;
		type.executeScript("document.getElementById('" + idName + "').value=' " + entryName +" ' ");
	   }
	
	   
	/**
	 * this method is used to click on disabled element
	 * @author Annapurna
	 */
	   
	   public void clickInDisableElement(WebDriver driver,String idName)
	   {
		JavascriptExecutor type=(JavascriptExecutor) driver;
			type.executeScript("document.getElementById(' "+idName+" ').click() ");
	   }
}
