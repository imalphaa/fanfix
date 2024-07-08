package com.fanfix.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fanfix.base.baseClass;

public class loginPage extends baseClass{

	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "password")
	public WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public WebElement continueButton;
	
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setEmail(String mail) {
		this.email.sendKeys(mail);
	}
	
	public void setPassword(String pass) {
		this.password.sendKeys(pass);
	}

//	public void continueButtonClick() {
//		this.continueButton.click();
//	}
	
	public void loginTofanfix(String mail, String pass) {
		this.setEmail(mail);
		this.setPassword(pass);
	}

	public void loginContinue1() {
		this.continueButton.click();
		
	}
}
