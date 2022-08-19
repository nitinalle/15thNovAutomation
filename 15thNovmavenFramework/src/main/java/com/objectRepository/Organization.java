package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganization;
	
	public Organization(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPlusSign() {
		return createOrganization;
	}

	public void setPlusSign(WebElement plusSign) {
		this.createOrganization = plusSign;
	}
 
	//businessLogic
	public void createOrganizationClick()
	{
		createOrganization.click();
	}
	
	
	
}
