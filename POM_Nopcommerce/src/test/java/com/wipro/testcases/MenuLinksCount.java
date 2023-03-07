package com.wipro.testcases;

import org.testng.annotations.Test;

import com.wipro.base.TestBase;
import com.wipro.pages.LinkCountPage;
import com.wipro.pages.LogOutPageMessage;
import com.wipro.pages.LoginPage;
import com.wipro.utilities.ReadFromExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class MenuLinksCount extends TestBase{
	@BeforeClass
	public void beforeClass() {
		launchBrowser(); // Picking method from TestBase
		navigateToURL();
	}

	@Test(dataProvider = "dp", priority = 0)
	public void loginTest(String userName, String password) {
		LoginPage lp = new LoginPage(); // Object created for LoginPage
		boolean actResult = lp.validateLogin(userName, password);
		Assert.assertTrue(actResult);
	}
	@Test(priority = 1)
	public void linkCountTest() {
		LinkCountPage count = new LinkCountPage();
		boolean actResult = count.ValidateLinkCount();
		Assert.assertTrue(actResult);
	}
	@Test(priority = 2)
	public void logoutTest() {
		LogOutPageMessage logout = new LogOutPageMessage();
		boolean actResult = logout.ValidateLogout();
		Assert.assertTrue(actResult);
	}

	@DataProvider
	public Object[][] dp() {
		String[][] data = new String[1][2];
		data = ReadFromExcel.getData();

		return data;
	}

	@AfterClass
	public void afterClass() {
		wait(1000);
		driver.close();
	}

}
