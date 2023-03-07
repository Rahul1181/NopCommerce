package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class LoginPage extends TestBase {
	//WebElement path for Login Page
	By logIn = By.className("ico-login");
	By email = By.id("Email");
	By password = By.id("Password");
	By loginButton = By.xpath("//button[text()='Log in']");
	//Validate if Login is successful or not 
	public boolean validateLogin(String uname, String pwd) {   //Fetching data from ReadFromExcel
		wait(2000);
		driver.findElement(logIn).click();
		wait(1000);
		driver.findElement(email).sendKeys(uname);
		wait(1000);
		driver.findElement(password).sendKeys(pwd);
		wait(1000);
		driver.findElement(loginButton).click();
		//Wait function until condition is executed or not till 10 sec
		WebDriverWait wait=new WebDriverWait(driver,10);
		boolean actResult=true;
		//Check if logout button is visible or not
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ico-logout")));
		}catch(TimeoutException te){
			actResult=false;
			captureScreenshot("Login Failure");
		}
		return actResult;
		
	}

}
