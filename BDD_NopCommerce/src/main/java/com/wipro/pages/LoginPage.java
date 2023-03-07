package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class LoginPage extends TestBase {
	By logIn = By.className("ico-login");
	By email = By.id("Email");
	By password = By.id("Password");
	By loginButton = By.xpath("//button[text()='Log in']");
	
	public boolean validateLogin(String uname, String pwd) {   //Fetching data from ReadFromExcel
		wait(2000);
		driver.findElement(logIn).click();
		wait(1000);
		driver.findElement(email).sendKeys(uname);
		wait(1000);
		driver.findElement(password).sendKeys(pwd);
		wait(1000);
		driver.findElement(loginButton).click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		boolean actResult=true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ico-logout")));
		}catch(TimeoutException te){
			actResult=false;
			captureScreenshot("Login Failure");
		}
		return actResult;
		
	}

}
