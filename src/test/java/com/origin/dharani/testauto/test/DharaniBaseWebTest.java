package com.origin.dharani.testauto.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.origin.dharani.testauto.steps.BestbuySteps;


public class DharaniBaseWebTest extends DharaniBaseTest {
	
	protected void login(WebDriver driver) {
		print("Inside testLogin");
		BestbuySteps bbsteps = new BestbuySteps(driver);
		bbsteps.doLogin();
		wait(5);
		
	}
	
	@BeforeMethod
	public 
	void beforeMethod() {
		// do nothing
	}

	@AfterMethod
	public void afterMethod() {
		print("This is afterMethod");

		if(driver!=null)
			driver.quit();
	}
}
