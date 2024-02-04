package com.wv.auto.framework;

import org.openqa.selenium.WebDriver;

public class BaseTest {
	
	protected WebDriver driver;
	protected boolean blnResult = true;
	
	public void print(String strToPrint) {
		System.out.println(strToPrint);
	}
	public void wait(int timeInSec){
		try {
			Thread.sleep(timeInSec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
}
