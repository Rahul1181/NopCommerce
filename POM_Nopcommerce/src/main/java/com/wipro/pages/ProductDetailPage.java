package com.wipro.pages;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class ProductDetailPage extends TestBase {
	//WebElement path for product details page
	By sendCart = By.xpath("//button[@id='add-to-cart-button-2']");
	WebElement element = driver.findElement(sendCart);
	By shoppingCart = By.xpath("//div[@id='bar-notification']");
	By crossButton = By.xpath("//span[@class='close']");
	
	//Validate the Add to cart functionality
	public boolean validateAddToCart() {
		scroll(element); // sendCart
		//driver.findElement(sendCart).click(); //sendCart
		element.click();
		wait(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCart));
		}catch(TimeoutException te){
			actResult=false;
			captureScreenshot("Product is not available for purchase");
		}
		driver.findElement(crossButton).click();
		return actResult;
	}

}
