package com.inetBanking.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	
	public void addNewCustomer() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		LoginPage lp= new LoginPage(driver);
		lp.SetUserName(username);
		lp.SetPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		addcust.custName("Vaijinath");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1985");
		
		Thread.sleep(3000);
		
		addcust.custaddress("Airoli India");
		addcust.custcity("Mumbai");
		addcust.custstate("Maharastra");
		addcust.custpinno("400708");
		addcust.custtelephoneno("9885988510");
		
		String email =randomestring()+"@gmail.com";
		//System.out.println(email);
		addcust.custemailid(email);
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true) {
			Assert.assertTrue(true);
		}
		else {
			
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
		
	}
	
	

}
