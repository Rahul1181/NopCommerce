package com.wipro.pages;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wipro.base.TestBase;

public class LinkCountPage extends TestBase {
	//WebElement path for clicking the menu
	List<WebElement> menuLinks = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']//a"));
	By computer = By.xpath("//ul[@class='top-menu notmobile']//a[@href='/computers']");
	By electronics = By.xpath("//ul[@class='top-menu notmobile']//a[@href='/electronics']");
	By apparel = By.xpath("//ul[@class='top-menu notmobile']//a[@href='/apparel']");
	By digital_downloads = By.xpath("//ul[@class='top-menu notmobile']//a[@href='/digital-downloads']");
	By books = By.xpath("//ul[@class='top-menu notmobile']//a[@href='/books']");
	By jewelry = By.xpath("//ul[@class='top-menu notmobile']//a[@href='/jewelry']");
	By giftcards = By.xpath("//ul[@class='top-menu notmobile']//a[@href='/gift-cards']");
	
	//Validate if link Count is passed or not 
	public boolean ValidateLinkCount() {
		wait(1000);
		int noOfLinks=menuLinks.size();
		wait(1000);
		driver.findElement(computer).click();
		wait(1000);
		driver.findElement(electronics).click();
		wait(1000);
		driver.findElement(apparel).click();
		wait(1000);
		driver.findElement(digital_downloads).click();
		wait(1000);
		driver.findElement(books).click();
		wait(1000);
		driver.findElement(jewelry).click();
		wait(1000);
		driver.findElement(giftcards).click();
		wait(1000);
		
//		for(int i=0;i<menuLinks.size();i++) {
//			menuLinks.get(i).getAttribute("value");
//			wait(3000);
//		}
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean actResult = true;
		//Function to check if the no of links is stored in linksCount.txt or not 
		try {
			FileOutputStream outputStream = new FileOutputStream("src\\main\\resources\\output_data\\LinksCount.txt");
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
			bufferedWriter.write(Integer.toString(noOfLinks));
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			actResult = false;
			e.printStackTrace();
		}
		return actResult;
	}

}
