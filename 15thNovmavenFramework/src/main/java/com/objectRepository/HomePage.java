package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utility.WebDriverUtility;

public class HomePage {

	WebDriverUtility webUtility = new WebDriverUtility();
	
	
	@FindBy(xpath= "//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organisation;
	
	@FindBy(xpath="//a[@href='index.php?module=Leads&action=index']")
	private WebElement leads;
	
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contacts;
	
	@FindBy(xpath="//a[@href='index.php?module=Products&action=index']")
	private WebElement products;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutBox;
	
	@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")
	private WebElement logout;
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebDriverUtility getWebUtility() {
		return webUtility;
	}


	public void setWebUtility(WebDriverUtility webUtility) {
		this.webUtility = webUtility;
	}


	public WebElement getOrganisation() {
		return organisation;
	}


	public void setOrganisation(WebElement organisation) {
		this.organisation = organisation;
	}


	public WebElement getLeads() {
		return leads;
	}


	public void setLeads(WebElement leads) {
		this.leads = leads;
	}


	public WebElement getContacts() {
		return contacts;
	}


	public void setContacts(WebElement contacts) {
		this.contacts = contacts;
	}


	public WebElement getProducts() {
		return products;
	}


	public void setProducts(WebElement products) {
		this.products = products;
	}


	public WebElement getLogoutBox() {
		return logoutBox;
	}


	public void setLogoutBox(WebElement logoutBox) {
		this.logoutBox = logoutBox;
	}


	public WebElement getLogout() {
		return logout;
	}


	public void setLogout(WebElement logout) {
		this.logout = logout;
	}
	

	//BusinessLogic
	public void organisationClick()
	{
	organisation.click();
	}
	
	public void leadsClick()
	{
		leads.click();
	}
	
	public void contactsClick()
	{
	    contacts.click();
	}
	
	public void productsClick()
	{
	    products.click();
	}
	
	
}
