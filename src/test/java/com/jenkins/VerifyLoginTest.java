package com.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyLoginTest {
	@Test
	@Parameters({ "url", "username", "password" })
	public void loginTest(
	    @Optional("https://demo.testfire.net/login.jsp") String url,
	    @Optional("jsmith") String username,
	    @Optional("Demo1234") String password) throws InterruptedException {

	    WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(url);

	    driver.findElement(By.id("uid")).sendKeys(username);
	    driver.findElement(By.id("passw")).sendKeys(password);
	    driver.findElement(By.name("btnSubmit")).click();

	    Thread.sleep(3000);

	    String expectedTitle = "Altoro Mutual";
	    Assert.assertEquals(driver.getTitle(), expectedTitle, "Login failed or incorrect title!");

	    driver.quit();
	}
}
