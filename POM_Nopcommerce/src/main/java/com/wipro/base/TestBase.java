package com.wipro.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	// Declare the static Web driver
	public static WebDriver driver;
	FileInputStream fis;
	Properties prop;
	// location of config file
	String fileName = "src\\main\\resources\\config\\config.properties";

	// Method to launch the web browser
	public void launchBrowser() {
		try {
			// Fetch the properties file
			fis = new FileInputStream(fileName);
		} catch (FileNotFoundException fnf) {
			System.out.println("File path or name is not correct");
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Open chrome browser
		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driverfiles\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		// Open edge browser
		else if (prop.getProperty("Browser").equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "src\\main\\resources\\driverfiles\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		// To maximize the browser
		driver.manage().window().maximize();
	}

	// Navigate to URL
	public void navigateToURL() {
		driver.get(prop.getProperty("URL"));
	}

	// Wait function
	public void wait(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Scroll function to find webelement if not visible
	public void scroll(WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	// Screenshot method
	public String captureScreenshot(String scrName) {
		System.out.println("Screenshot for " + scrName);
		Date date = new Date();
		// Name of screenshot based on timestamp so screenshot do not overwrite
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy HH_mm_ss");
		String timeStamp = sdf.format(date);

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		String scnShotFileName = "src\\test\\resources\\screenshots\\screenshot_" + timeStamp + ".png";
		File DestFile = new File(scnShotFileName);
		// Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return scnShotFileName;
	}

}
