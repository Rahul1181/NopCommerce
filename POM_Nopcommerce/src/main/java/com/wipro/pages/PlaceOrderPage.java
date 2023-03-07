package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class PlaceOrderPage extends TestBase{
	//WebElement path for PlaceOrder
	By shopCart=By.className("cart-label");
	By shopProduct = By.className("sku-number");
	By condition=By.xpath("//input[@id='termsofservice']");
	By purchase = By.xpath("//button[@id='checkout']");
	By addressCon = By.xpath("//button[@name='save']");
	By shipping = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
	
	//Validate if place order is successful or not
	public boolean validatePlaceOrder() {
		wait(1000);
		driver.findElement(shopCart).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean actResult=true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(shopProduct));
		}catch(TimeoutException te){
			actResult=false;
			captureScreenshot("Product is not added to cart");
		}
		driver.findElement(condition).click();
		wait(2000);
		driver.findElement(purchase).click();
		wait(2000);
		driver.findElement(addressCon).click();
		wait(2000);
		driver.findElement(shipping).click();
		wait(2000);
		
		return actResult;
	}

}
