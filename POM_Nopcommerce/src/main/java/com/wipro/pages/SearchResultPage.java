package com.wipro.pages;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class SearchResultPage extends TestBase {
	//WebElement path for product detail page
	By productName = By.xpath("//h2//a[text()='Digital Storm VANQUISH 3 Custom Performance PC']");
	By productPrice =By.xpath("//*[text()='$1,259.00']");
	
	//Validate the product detail page
	public boolean validateSelectProduct() {
		String getNameOfProduct = driver.findElement(productName).getText();
		String getProductPrice = driver.findElement(productPrice).getText();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean actResult = true;
		try {
			//Store the product name and price in text file
            FileOutputStream outputStream = new FileOutputStream("src\\main\\resources\\output_data\\Prize.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(getNameOfProduct);
            //bufferedWriter.write("Digital Storm VANQUISH 3 Custom Performance PC");
            bufferedWriter.newLine();
            bufferedWriter.write(getProductPrice);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
        	actResult=false;
            e.printStackTrace();
        }
		driver.findElement(productName).click();
		wait(1000);
		return actResult;
	}
}
