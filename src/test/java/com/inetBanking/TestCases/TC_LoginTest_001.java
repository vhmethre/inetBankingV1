package com.inetBanking.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		
		
		logger.info("URL is entered");
		
		LoginPage lp = new LoginPage(driver);

		lp.SetUserName(username);
		logger.info("UserName is entered");
		
		lp.SetPassword(password);
		logger.info("Password is entered");
		
		lp.clickSubmit();

		if (driver.getTitle().equals("GTPL Bank Manager HomePage")) {

			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		} else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
	}

}
