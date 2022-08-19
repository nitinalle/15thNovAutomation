package com.vtiger.organization;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.objectRepository.CreateOrganization;
import com.objectRepository.HomePage;
import com.objectRepository.Organization;
import com.vtiger.utility.BaseClass;

public class TC_41_CretaeOrganization1 extends BaseClass {
	
	
	
	@Test
	public void createOrganizationTest() throws InterruptedException, IOException
	{
		HomePage homepage = new HomePage(driver);
		Organization org = new Organization(driver);
		CreateOrganization createOrg = new CreateOrganization(driver);
		//launch the browser --->beforeclass
		
		//login--->beforemethod
		
		//click on organization
		homepage.organisationClick();
		
		//click on create organization(+ sign)
		org.createOrganizationClick();
		
		//create organization
		createOrg.createOrganization();
		
		
		//logout-->aftermethod
		
		//close browser-->after class
			
	}

}
