package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name = "user_name")
	private WebElement untbx;
	
	@FindBys({@FindBy(name = "user_password"), @FindBy(xpath =  "//input[@type = 'password']")})
	private WebElement pwtbx;
	
	@FindAll({@FindBy(id = "submitButton"), @FindBy(xpath =  "//input[@type = 'submit']") })
	private WebElement lgbtn;
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwtbx() {
		return pwtbx;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}
	
	public void setUntbx(WebElement untbx) {
		this.untbx = untbx;
	}

	public void setPwtbx(WebElement pwtbx) {
		this.pwtbx = pwtbx;
	}

	public void setLgbtn(WebElement lgbtn) {
		this.lgbtn = lgbtn;
	}
		
	//business logic
	public void setLogin(String un, String pass)
	{
		untbx.sendKeys(un);
		pwtbx.sendKeys(pass);
		lgbtn.click();
	}	
}
