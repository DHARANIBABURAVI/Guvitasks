package com.origin.dharani.testauto;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wv.auto.framework.BasePage;

public abstract class DharaniBasePage extends BasePage {
	protected DharaniVerifier verifier;
	protected DharaniBasePage(WebDriver driver) {
		this.driver = driver;
		verifier = new DharaniVerifier(driver);

	}
	
	
		

}
