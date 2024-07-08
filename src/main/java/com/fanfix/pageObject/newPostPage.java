package com.fanfix.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fanfix.base.baseClass;

public class newPostPage extends baseClass{
	@FindBy(xpath = "//button[contains(text(),'New Post')]")
	public WebElement newpost;
	
	@FindBy(xpath = "//p[contains(text(),'Custom')]")
	public List<WebElement> custom;
	
	@FindBy(xpath = "//textarea[contains(@id,'post-caption')]")
	public WebElement postCaption;
	
	@FindBy(xpath = "//div[contains(@data-testid,'media-stack-upload')]")
	public WebElement media;
	
	@FindBy(xpath = "//button[contains(text(),'Upload Media')]/span")
	public WebElement uploadmedia;
	
	@FindBy(xpath = "//span[contains(text(),'Browse')]")
	public WebElement browse;
	
	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement continueButton;
	
	@FindBy(css = "[data-testid='modal-close-ds']")
	public WebElement cancel;
	
	@FindBy(id = "#custom-sub")
	public List<WebElement> customText;
	
	@FindBy(xpath = "//button[contains(text(),'Post to Profile')]")
	public  WebElement PostToProfile;
	
	@FindBy(xpath = "//div[contains(text(),'Post Created')]")
	public  WebElement PostCreated;
	
	WebDriver ldriver;
	public newPostPage(WebDriver ldriver) {
		this.ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void customButtonForSubscriberPrice() {
		this.custom.getFirst().click();
	}
	
	public void customButtonForNonSubscriberPrice() {
		this.custom.getLast().click();
	}
	
	public void postCaptionTextField(String text) {
		this.postCaption.sendKeys(text);
	}
	
	public void UploadFile() {
		this.browse.click();
	}

	public void continueButton() {
		continueButton.click();
		
	}

	public void enterAmountForcustomPriceForNonSubscriber(String amount) {
		this.custom.getLast().clear();
		this.custom.getLast().sendKeys(amount);
	}

	public void enterAmountForcustomPriceForSubscriber(String amount) {
		this.custom.getFirst().clear();
		this.custom.getFirst().sendKeys(amount);	
	}
	
	public boolean isPostToProfileEnabled() {
		return this.PostToProfile.isEnabled();
	}

	public boolean isPostCreatedDisplayed() {
		return this.PostCreated.isDisplayed();
	}
}


