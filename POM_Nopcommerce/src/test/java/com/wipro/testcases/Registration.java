package com.wipro.testcases;

import org.testng.annotations.Test;

import com.wipro.base.TestBase;
import com.wipro.pages.LogOutPageMessage;
import com.wipro.pages.LoginPage;
import com.wipro.pages.LogoutPage;
import com.wipro.pages.RegistrationPage;
import com.wipro.utilities.ReadFromExcel;
import com.wipro.utilities.RegistrationExcel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Registration extends TestBase {
	@BeforeClass
	public void beforeClass() {
		launchBrowser(); // Picking method from TestBase
		navigateToURL();
	}

	@Test(dataProvider = "dp1", priority = 0)
	public void registrationTest(String firstName, String lastName, String email, String companyName, String password,
			String confirmPassword) {
		RegistrationPage lp = new RegistrationPage(); // Object created for LoginPage
		boolean actResult = lp.ValidateRegister(firstName, lastName, email, companyName, password, confirmPassword);
		Assert.assertTrue(actResult);
	}

	@Test(dataProvider = "dp", priority = 1)
	public void loginTest(String userName, String password) {
		LoginPage lp = new LoginPage(); // Object created for LoginPage
		boolean actResult = lp.validateLogin(userName, password);
		Assert.assertTrue(actResult);
	}

	@Test(priority = 2)
	public void logoutTest() {
		LogOutPageMessage logout = new LogOutPageMessage();
		boolean actResult = logout.ValidateLogout();
		Assert.assertTrue(actResult);
	}

	@DataProvider
	public Object[][] dp1() {
		String[][] data = new String[1][6];
		data = RegistrationExcel.getData();

		return data;
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
