package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class LogoutPage extends TestBase{
	By logout = By.className("ico-logout");
	By loginBut =By.className("ico-login");
	
	public boolean ValidateLogout() {
		driver.findElement(logout).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean actResult=true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(loginBut));
		}catch(TimeoutException te){
			actResult=false;
			captureScreenshot("Unable to Logout");
		}
		return actResult;
	}

}
