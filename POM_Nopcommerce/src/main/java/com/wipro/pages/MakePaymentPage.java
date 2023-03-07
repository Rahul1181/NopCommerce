package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class MakePaymentPage extends TestBase{
	//WebElement path for MakePayment
	By moneyOrder =By.xpath("//button[@class='button-1 payment-method-next-step-button']");
	By checkMoney =By.xpath("//li[@id='opc-confirm_order']//h2[@class='title']");
	By continueNext = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
	By confirm = By.xpath("//button[@class='button-1 confirm-order-next-step-button']");
	By thankYou = By.xpath("//button[@class='button-1 order-completed-continue-button']");
	
	//Method to execute if payment is successful or not 
	public boolean ValidateMakePayment() {
		wait(1000);
		driver.findElement(moneyOrder).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean actResult=true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(checkMoney));
		}catch(TimeoutException te){
			actResult=false;
			captureScreenshot("Money order execute");
		}
		wait(1000);
		driver.findElement(continueNext).click();
		wait(1000);
		driver.findElement(confirm).click();
		wait(2000);
		driver.findElement(thankYou).click();
		wait(1000);
		
		return actResult;
	}

}
