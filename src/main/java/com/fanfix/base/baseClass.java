package com.fanfix.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fanfix.utils.utility;

import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass{
	public static WebDriver driver;
	utility util=new utility();

	@BeforeClass
	public static void launchBrowser() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
//		ChromeOptions options = new ChromeOptions();  //ForHeadless
//		options.addArguments("--headless");
//		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://client-auth-dev.fanfix.dev/login");
		driver.manage().deleteAllCookies();
	}

	@AfterClass(enabled=false)
	public void tearDown() {
		driver.quit();
	}
}
