package com.objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utility.FileUtility;
import com.vtiger.utility.WebDriverUtility;

public class CreateOrganization {
	FileUtility fUtil = new FileUtility();
	WebDriverUtility webUtility = new WebDriverUtility();


	@FindBy(xpath = "//input[@name = 'accountname']")
	private WebElement organizationName;
	
	@FindBy(xpath = "//select[@name = 'industry']")
	private WebElement industryDropdown;
	
	@FindBy(xpath = "//input[@title = 'Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	
	public CreateOrganization(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(WebElement organizationName) {
		this.organizationName = organizationName;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public void setIndustryDropdown(WebElement industryDropdown) {
		this.industryDropdown = industryDropdown;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(WebElement saveBtn) {
		this.saveBtn = saveBtn;
	}
	

	//business logic
	
	

	//1. create organization 2,0
	public void createOrganization() throws IOException
	{
		//fetch the organization name from excel
		//String orgName = fUtil.getExceldata("Organizations", 2, 0);
		
		//enterorganization name
		organizationName.sendKeys("rajmahi1225");
		
		//select industry from dropdown
		webUtility.select(industryDropdown, 5);
		
		//click on save
		saveBtn.click();	
	}
	
}
