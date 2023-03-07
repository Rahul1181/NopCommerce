package com.wipro.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.wipro.base.TestBase;
import com.wipro.pages.AddressPage;
import com.wipro.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddAddress extends TestBase {
	//public static WebDriver driver;
	@Given("user is on login page")
	public void user_is_on_login_page() {
		launchBrowser();
		navigateToURL();
	}

	@When("user enter {string} and {string} and click login button")
	public void user_enter_and_and_click_login_button(String userName, String password) {
		LoginPage lp = new LoginPage(); // Object created for LoginPage
		boolean actResult = lp.validateLogin(userName, password);
		Assert.assertTrue(actResult);

	}

	@Then("users clicks on My account and user add new address {string} {string} {string} {string} {string} {string} {string} {string} {string} and click save button")
	public void users_clicks_on_my_account_and_user_add_new_address_and_click_save_button(String firstName,
			String lastName, String email, String companyName, String city, String address1, String address2,
			String zipCode, String phoneNumber) {
		AddressPage lp = new AddressPage(); // Object created for LoginPage
		boolean actResult = lp.ValidateAddress(firstName, lastName, email, companyName, city, address1, address2,
				zipCode, phoneNumber);
		Assert.assertTrue(actResult);
		driver.close();
	}
}
