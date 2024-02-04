package com.origin.dharani.testauto.test;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.wv.auto.framework.BaseTest;
import com.wv.auto.framework.utils.Reporter;

public class DharaniBaseTest extends BaseTest {
	public String browser = "Chrome";
	@BeforeMethod
	public void beforeMethod() {
		print("This is  Base Test beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		print("This is  Base Test afterMethod");
		Assert.assertTrue(blnResult);
	}

	

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
		Reporter.createReports();
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.closeReports();
	}
	

}
