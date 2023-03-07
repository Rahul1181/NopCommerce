package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class AddressPage extends TestBase {
	By myAccount = By.className("ico-account");
	By address = By.xpath("//a[@href='/customer/addresses']");
	By addNew = By.xpath("//div//button[@class='button-1 add-address-button']");
	By firstName =By.xpath("//input[@id='Address_FirstName']");
	By lastName = By.xpath("//input[@id='Address_LastName']");
	By email = By.xpath("//input[@id='Address_Email']");
	By company = By.xpath("//input[@id='Address_Company']");
	By country = By.xpath("//select[@id='Address_CountryId']//option[@value='133']");
	By city = By.xpath("//input[@id='Address_City']");
	By address1 =By.xpath("//input[@id='Address_Address1']");
	By address2 =By.xpath("//input[@id='Address_Address2']");
	By zipCode = By.xpath("//input[@id='Address_ZipPostalCode']");
	By phoneNumber = By.xpath("//input[@id='Address_PhoneNumber']");
	By saveButton = By.xpath("//button[@class='button-1 save-address-button']");
	By closeButton = By.xpath("//span[@class='close']");
	
	By LogOut =By.className("ico-logout");
	public boolean ValidateAddress(String fName, String lName, String eml, String cName, String citys, String add1, String add2, String zCode, String pNumber) {
		driver.findElement(myAccount).click();
		wait(1000);
		driver.findElement(address).click();
		wait(1000);
		driver.findElement(addNew).click();
		wait(1000);
		driver.findElement(firstName).sendKeys(fName);
		wait(1000);
		driver.findElement(lastName).sendKeys(lName);
		wait(1000);
		driver.findElement(email).sendKeys(eml);
		wait(1000);
		driver.findElement(company).sendKeys(cName);
		wait(1000);
		driver.findElement(country).click();
		wait(1000);
		driver.findElement(city).sendKeys(citys);
		wait(1000);
		driver.findElement(address1).sendKeys(add1);
		wait(1000);
		driver.findElement(address2).sendKeys(add2);
		wait(1000);
		driver.findElement(zipCode).sendKeys(zCode);
		wait(1000);
		driver.findElement(phoneNumber).sendKeys(pNumber);
		wait(1000);
		driver.findElement(saveButton).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='content']")));
		} catch (TimeoutException te) {
			actResult = false;
			captureScreenshot("Registration Unsuccessful");
		}
		driver.findElement(closeButton).click();
		wait(1000);
		driver.findElement(LogOut).click();
		wait(1000);
		return actResult;
	}

}
