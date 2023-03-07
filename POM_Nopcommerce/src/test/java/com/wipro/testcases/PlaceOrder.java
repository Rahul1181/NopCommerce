package com.wipro.testcases;

import org.testng.annotations.Test;

import com.wipro.base.TestBase;
import com.wipro.pages.LoginPage;
import com.wipro.pages.LogoutPage;
import com.wipro.pages.MakePaymentPage;
import com.wipro.pages.PlaceOrderPage;
import com.wipro.pages.ProductDetailPage;
import com.wipro.pages.SearchProductPage;
import com.wipro.pages.SearchResultPage;
import com.wipro.utilities.ReadFromExcel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class PlaceOrder extends TestBase{
	
	@BeforeClass
	public void beforeClass() {
		launchBrowser();      //Picking method from TestBase
		navigateToURL();
	}
	
	
	@Test(dataProvider = "dp", priority = 0)
	public void loginTest(String userName, String password) {
		LoginPage lp = new LoginPage();       //Object created for LoginPage
		boolean actResult= lp.validateLogin(userName, password);
		Assert.assertTrue(actResult);
	}
	
	@Test(priority = 1)
	public void searchProductTest() {
		SearchProductPage srch = new SearchProductPage();
		boolean actResult= srch.validateSearchProduct();
		Assert.assertTrue(actResult);
	}
	//To solve from here
	@Test(priority = 2)
	public void selectProductTest() {
		SearchResultPage srp = new SearchResultPage();
		boolean actResult= srp.validateSelectProduct();
		Assert.assertTrue(actResult);
	}
	
	@Test(priority = 3)
	public void addToCartTest() {
		ProductDetailPage adtoCart = new ProductDetailPage();
		boolean actResult= adtoCart.validateAddToCart();
		Assert.assertTrue(actResult);
	}
	
	@Test(priority = 4)
	public void placeOrderTest() {
		PlaceOrderPage plOrder = new PlaceOrderPage();
		boolean actResult= plOrder.validatePlaceOrder();
		Assert.assertTrue(actResult);
	}
	
	@Test(priority = 5)
	public void makePayment() {
		MakePaymentPage mkPay = new MakePaymentPage();
		boolean actResult= mkPay.ValidateMakePayment();
		Assert.assertTrue(actResult);
	}
	
	@Test(priority = 6)
	public void logoutTest() {
		LogoutPage logout = new LogoutPage();
		boolean actResult= logout.ValidateLogout();
		Assert.assertTrue(actResult);
	}
	
	
	@DataProvider
	public Object[][] dp() {
		String [][] data=new String[1][2];
		data = ReadFromExcel.getData();
		
		return data;
	}

	@AfterClass
	public void afterClass() {
		wait(1000);
		driver.close();
	}

}
