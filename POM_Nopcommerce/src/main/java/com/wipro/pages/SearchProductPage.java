package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class SearchProductPage extends TestBase {
	//WEbElement path for Search a product
	By product = By.xpath("//div[6]/div[2]/ul[1]/li[1]/a[@href='/computers']");
	By productDesktop = By.xpath("//a[@title='Show products in category Desktops']//img[@alt='Picture for category Desktops']");

	//Validate if product is available for purchase
	public boolean validateSearchProduct() {
		wait(1000);
		driver.findElement(product).click();
		wait(1000);
		driver.findElement(productDesktop).click();
		wait(1000);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h2//a[@href='/digital-storm-vanquish-3-custom-performance-pc']")));
		} catch (TimeoutException te) {
			actResult = false;
			captureScreenshot("Product visiblity Failure");
		}
		return actResult;
	}

}
