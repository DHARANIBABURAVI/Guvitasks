package com.origin.dharani.testauto.test.testsuites;

import org.testng.annotations.Test;

import com.origin.dharani.testauto.DataManager;
import com.origin.dharani.testauto.steps.BestbuySteps;
import com.origin.dharani.testauto.test.DharaniBaseWebTest;
import com.wv.auto.framework.BrowserFactory;
import com.wv.auto.framework.utils.Reporter;

public class BestBuy extends DharaniBaseWebTest{
	@Test(dataProviderClass=DataManager.class, dataProvider = "browers", groups= {"pilot"}, enabled= true, 
			description="Sign in and verify menus")
	public void testMyAccountPage(String row, String strBrowserName) {
		driver = BrowserFactory.getBrowser(strBrowserName);
		login(driver);
		BestbuySteps bbstep = new BestbuySteps(driver);
		bbstep.validateMenu();
		Reporter.writeSummary("TC-01, Verify the Menu in the Login Page, " +  bbstep.getResult() );
		bbstep.accountPage();
		Reporter.writeSummary("TCID_061,Verify the sections in the Accounts page, " +  bbstep.getResult() );
		bbstep.addSlideToCart();
		Reporter.writeSummary("TCID_061,Verify by adding an item to the Cart, " +  bbstep.getResult() );
		bbstep.addBrandProdToCart();
		Reporter.writeSummary("TCID_061,Verify by adding a Branded product to the Cart, " +  bbstep.getResult() );
		bbstep.paymentPage();
		Reporter.writeSummary("TCID_061,Verify by checking out the products and proceed till the payment page by providing fake creditcard information, " +  bbstep.getResult() );
		bbstep.bottomLinksVerify();
		Reporter.writeSummary("TCID_061,Verify the bottomLinks redirect to the respective pages, " +  bbstep.getResult() );
	}

}
