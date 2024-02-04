package com.origin.dharani.testauto.steps;

import org.openqa.selenium.WebDriver;

import com.origin.dharani.testauto.DharaniBaseStep;
import com.origin.dharani.testauto.pages.BestBuyPage;
import com.wv.auto.framework.BaseStep;

public class BestbuySteps extends DharaniBaseStep {
	private BestBuyPage page=null;
	public BestbuySteps(WebDriver driver) {
		page = new BestBuyPage(driver);
	}

	
	public void accountPage() {
		 result ="Passed";
		   try {
				page.accountPage();
		   }
		   catch(Exception e)
		   {
			e.printStackTrace();   
			result="FAILED";
		   }
	}
	public void addSlideToCart() {
		 result ="Passed";
		   try {
				page.addSlideToCart();
		   }
		   catch(Exception e)
		   {
			e.printStackTrace();   
			result="FAILED";
		   }
		
	}
	public void bottomLinksVerify() {
		 result ="Passed";
		   try {
				page.bottomLinksVerify();
		   }
		   catch(Exception e)
		   {
			e.printStackTrace();   
			result="FAILED";
		   }
		
	}
	public void validateMenu() {
		 result ="Passed";
		   try {
				page.validateMenu();
		   }
		   catch(Exception e)
		   {
			e.printStackTrace();   
			result="FAILED";
		   }
		
	}
	public void paymentPage() {
		 result ="Passed";
		   try {
				page.paymentPage();
		   }
		   catch(Exception e)
		   {
			e.printStackTrace();   
			result="FAILED";
		   }
			
	}
	public void addBrandProdToCart() {
		 result ="Passed";
		   try {
				page.addBrandProdToCart();
		   }
		   catch(Exception e)
		   {
			e.printStackTrace();   
			result="FAILED";
		   }
			
	}
	

	public void doLogin() {
		result ="Passed";
		   try {
				page.login();
		   }
		   catch(Exception e)
		   {
			e.printStackTrace();   
			result="FAILED";
		   }
	}

}
