package com.wipro.pages;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class LogOutPageMessage extends TestBase{
	//WebElement path for Logout Page
	By logout = By.className("ico-logout");
	By loginBut =By.className("ico-login");
	
	//Method to execute logout and store in text file
	public boolean ValidateLogout() {
		driver.findElement(logout).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean actResult = true;
		//Check if logout message is stored in logoutMessage text file
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(loginBut));
            FileOutputStream outputStream = new FileOutputStream("src\\main\\resources\\output_data\\logoutMessage.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("You have successfully logged out");
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		wait(1000);
		return actResult;
	}

}
