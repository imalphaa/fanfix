package com.fanfix.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class utility{

	public void explicitWait(WebDriver driver, WebElement element, Duration ofSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, ofSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	@SuppressWarnings("deprecation")
	public void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
