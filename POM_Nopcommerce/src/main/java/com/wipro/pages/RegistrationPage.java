package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class RegistrationPage extends TestBase {
	//Webelement path for registration
	By register = By.className("ico-register");
	By genderSelect = By.xpath("//input[@id='gender-male']");
	By firstName = By.xpath("//input[@id='FirstName']");
	By lastName = By.xpath("//input[@id='LastName']");
	By day = By.xpath("//select[@name='DateOfBirthDay']/option[@value='5']");
	By month = By.xpath("//select[@name='DateOfBirthMonth']/option[@value='6']");
	By year = By.xpath("//select[@name='DateOfBirthYear']/option[@value='1995']");
	By email = By.xpath("//input[@id='Email']");
	By company = By.xpath("//input[@id='Company']");
	By password = By.xpath("//input[@id='Password']");
	By confirmPassword = By.xpath("//input[@id='ConfirmPassword']");
	By regButton = By.xpath("//button[@id='register-button']");
	//Validate if registration is successful or not
	public boolean ValidateRegister(String fName, String lName, String eml, String cName, String pass,
			String cPassword) {
		driver.findElement(register).click();
		wait(1000);
		driver.findElement(genderSelect).click();
		wait(1000);
		driver.findElement(firstName).sendKeys(fName);
		wait(1000);
		driver.findElement(lastName).sendKeys(lName);
		wait(1000);
		driver.findElement(day).click();
		wait(1000);
		driver.findElement(month).click();
		wait(1000);
		driver.findElement(year).click();
		wait(1000);
		driver.findElement(email).sendKeys(eml);
		wait(1000);
		driver.findElement(company).sendKeys(cName);
		wait(1000);
		driver.findElement(password).sendKeys(pass);
		wait(1000);
		driver.findElement(confirmPassword).sendKeys(cPassword);
		wait(1000);
		driver.findElement(regButton).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean actResult = true;
		//Check if successful message for registration is visible or not
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='result']")));
		} catch (TimeoutException te) {
			actResult = false;
			captureScreenshot("Registration Unsuccessful");
		}
		return actResult;
	}

}
