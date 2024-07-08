package com.fanfix.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.fanfix.base.baseClass;
import com.fanfix.pageObject.loginPage;
import com.fanfix.pageObject.newPostPage;
import com.fanfix.utils.utility;

import junit.framework.Assert;

public class LoginPageTest extends baseClass {
	newPostPage np = new newPostPage(driver);
	loginPage lp = new loginPage(driver);
	utility util=new utility();
	
	@Test(enabled=true,priority=1)
	public void verifyLoginPageWithValidCrentials() throws InterruptedException {
		WebElement email= driver.findElement(By.id("email"));
		this.util.explicitWait(driver, email, Duration.ofSeconds(10));
		this.lp.loginTofanfix("testqa@mailinator.com", "123456789");
		this.lp.loginContinue1();
		util.implicitWait(driver, 10);
	}
	
	
	@Test(enabled=true,priority=2)
	public void verifyNewPostTab() {
		np.newpost.click();
		util.implicitWait(driver, 10);
	}
	
	
	@Test(enabled=true,priority=3)
	public void verifyPostCaptionTextField(String text) {
		np.postCaption.sendKeys("This post is done by automation assignment");
	}
	@Test(enabled=true,priority=4)
	public void verifyAddingMedia() {
		np.media.click();
		np.uploadmedia.click();
		np.browse.sendKeys("C:/Users/IM/Desktop");
		np.continueButton();
		np.cancel.click();
	}
	
	@Test(enabled=true,priority=5)
	public void verifyCustomButton() {
		this.np.enterAmountForcustomPriceForNonSubscriber("4");
		Assert.assertFalse(np.isPostToProfileEnabled());
		this.np.enterAmountForcustomPriceForNonSubscriber("5");
		Assert.assertTrue(np.isPostToProfileEnabled());
		this.np.enterAmountForcustomPriceForSubscriber("3");
		Assert.assertFalse(np.isPostToProfileEnabled());
		this.np.enterAmountForcustomPriceForSubscriber("5");
		Assert.assertTrue(np.isPostToProfileEnabled());
	}
	
	@Test(enabled=true,priority=6)
	public void verifyPostCerated() {
		Assert.assertTrue(np.isPostCreatedDisplayed());
	}
}