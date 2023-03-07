package com.wipro.listeners;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.wipro.base.TestBase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerFile extends TestBase implements ITestListener {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;

	public void onStart(ITestContext context) {
		System.out.println("Test is started");
		htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test is completed");
		extent.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Execution started for Test Method: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is Successful for Test Method: " + result.getName());

		test = extent.createTest(result.getName());
		test.pass(result.getName() + " is Passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test is Failure for Test Method: " + result.getName());
		String fileName = captureScreenshot(result.getName());

		test = extent.createTest(result.getName());
		try {
			test.fail(result.getName() + " is Failed",
			MediaEntityBuilder.createScreenCaptureFromPath(fileName).build());
			test.addScreenCaptureFromPath(".\\Screenshots\\" + fileName);
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is Skipped for Test Method: " + result.getName());
		test = extent.createTest(result.getName());
		test.skip(result.getName() + " is Skipped");
	}

}