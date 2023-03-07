
package com.wipro.testcases;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src\\main\\resources\\features\\address.feature",
		glue = "com\\wipro\\stepdefinations",
		monochrome = true)
public class Address extends AbstractTestNGCucumberTests{
	
}

/*package com.wipro.testcases;

import org.testng.annotations.Test;

import com.wipro.base.TestBase;
import com.wipro.pages.AddressPage;

import com.wipro.pages.LoginPage;
import com.wipro.pages.LogoutPage;
import com.wipro.utilities.AddressExcel;
import com.wipro.utilities.ReadFromExcel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Address extends TestBase {
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

	@Test(dataProvider = "dp1", priority = 1)
	public void AddressTest(String firstName, String lastName, String email, String companyName, String city,
			String address1, String address2, String zipCode, String phoneNumber ) {
		AddressPage lp = new AddressPage(); // Object created for LoginPage
		boolean actResult = lp.ValidateAddress(firstName, lastName, email, companyName, city, address1, address2, zipCode, phoneNumber);
		Assert.assertTrue(actResult);
	}

	

	@Test(priority = 2)
	public void logoutTest() {
		LogoutPage logout = new LogoutPage();
		boolean actResult = logout.ValidateLogout();
		Assert.assertTrue(actResult);
	}

	@DataProvider
	public Object[][] dp() {
		String[][] data = new String[1][2];
		data = ReadFromExcel.getData();

		return data;
	}

	@DataProvider
	public Object[][] dp1() {
		String[][] data = new String[1][9];
		data = AddressExcel.getData();

		return data;
	}

	@AfterClass
	public void afterClass() {
		wait(1000);
		driver.close();
	}


}*/


