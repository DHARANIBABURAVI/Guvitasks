package com.origin.dharani.testauto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.origin.dharani.testauto.DharaniBasePage;

public class BestBuyPage extends DharaniBasePage{
private By dealsBtn = By.xpath("//button/*[text()='Deals']"); 
private By topDealsBtn = By.xpath("//a[@title='Top Deals']");
private By outletBtn = By.xpath("//button/*[text()='Outlet']");
private By openBoxProductsLink = By.xpath("//a[@title='Open Box Products']");
private By servicesBtn = By.xpath("//button/*[text()='Services']");
private By supportLink = By.xpath("//h2[text()='Support and Benefits']");
private By dharaniText = By.xpath("//span[text()='Hi, Dharani!']");
private By orderHistory = By.xpath("//h3[text()='Order History']");
private By paymentMethods = By.xpath("//h3[text()='Payment Methods']"); 
private By addresses = By.xpath("//h3[text()='Addresses']"); 
private By personalDetails = By.xpath("//h3[text()='Personal Details']");
private By membership = By.xpath("//h3[text()='Membership']");
private By monthlySubs = By.xpath("//h3[text()='Monthly Subscription']");
private By preference = By.xpath("//h3[text()='Preference Centre']");
private By searchInput = By.xpath("//input[@type='search']");
private By searchIcon = By.xpath("//button[@type='submit']");
private By slideProduct = By.xpath("//div[text()='KidKraft Hop & Slide Frog Climber - Green']");
private By productText = By.xpath("//h1[text()='KidKraft Hop & Slide Frog Climber - Green']");
private By addToCartBtn = By.xpath("//button/*/*/span[text()='Add to Cart']");	
private By viewCartPopup = By.xpath("//span[text()='View Cart']/..");
private By prodInCart = By.xpath("//a[text()='KidKraft Hop & Slide Frog Climber - Green']/..");
private By shopBtn = By.xpath("//span[text()='Shop']");
private By brandsBtn = By.xpath("//a[text()='Brands']");
private By abBrandBtn = By.xpath("//a[text()='A B']");
private By acerBrandBtn = By.xpath("//a[text()='Acer']");
private By acerBrandPage = By.xpath("//h1[text()='Acer']");
private By audioLabel = By.xpath("//label[text()='Audio']");
private By speakerText = By.xpath("//ul[@class='list_3khgt']/*/div[1]/*/*/*/div/div[2]/div[1]");
private By checkoutBtn = By.xpath("//span[text()='Continue to Checkout']");
//private By continueBtn = By.xpath("//span[text()='Continue']");
private By firstNameLbl = By.xpath("//input[@id='firstName']");
private By lastNameLbl = By.xpath("//input[@id='lastName']");
private By phoneLbl= By.xpath("//input[@id='phoneNumber']");
private By addressLbl = By.xpath("//input[@id='addressLine1']");
private By cityLbl = By.xpath("//input[@id='city']");
private By provinceLbl = By.xpath("//select[@id='regionCode']");
private By postalCodeLbl = By.xpath("//input[@id='postalCode']");
private By continueBtn = By.xpath("//span[text()='Continue']/..");
private By cardNumberLbl = By.xpath("//input[@id='shownCardNumber']"); //expirationMonth
private By expiryMonthLbl = By.xpath("//input[@id='expirationMonth']"); 
private By expiryYearLbl = By.xpath("//input[@id='expirationYear']"); 
private By cvvLbl = By.xpath("//input[@id='cvv']"); 
private By reviewPage = By.xpath("//h2[text()='Review your order']");
private By placeOrderBtn = By.xpath("//span[text()='Place Order']/..");
private By errorMsg = By.xpath("//p[text()='We are unable to process your credit card at this time. It is possible that you have entered an invalid card number; the card type does not match the card number format; your card is not an accepted method of payment; your bank has a hold on your card; or the card number associated with this account has been closed, Please contact your financial institution or try another card. (0095)']");
private By bbLogo = By.xpath("//*[@id=\"root\"]/div[5]/header/div/nav/a");
private By termsLink = By.xpath("//a[text()='Terms & Conditions']");
private By conditionsLink = By.xpath("//a[text()='Conditions of Use']");
private By onlinePolicyLink = By.xpath("//a[text()='Online Policies']");
private By interestBasedLink = By.xpath("//a[text()='Interest-Based Ads']");
private By ppLink = By.xpath("//a[text()='Privacy Policy']");
private By cookieLink = By.xpath("//a[text()='Cookie Policy']");
private By accessLink = By.xpath("//a[text()='Accessibility Policy']");
private By geekLink = By.xpath("//a[text()='Geek Squad Terms & Conditions']");
private By productLink = By.xpath("//a[text()='Product Recalls']");
private By termsPage = By.xpath("//h1[text()='Terms and Conditions']");
private By conditionsPage = By.xpath("//h1[text()='Conditions of Use']"); 
private By onlinePage = By.xpath("//h1[text()='Online Policies']"); 
private By interestPage = By.xpath("//h1[text()='Interest-Based Ads']"); 
private By privacyPage = By.xpath("//h1[text()='Privacy Policy']"); 
private By cookiePage = By.xpath("//h1[text()='Cookie Policy']"); 
private By accessPage = By.xpath("//h1[text()='Accessibility Policy']"); 
private By geekPage = By.xpath("//h1[text()='Geek Squad Terms & Conditions']"); 
private By prodPage = By.xpath("//h1[text()='Product Recalls']"); 
private By accountBtn = By.xpath("//span[text()='account']");
private By signInBtn = By.xpath("//span[text()='Sign In']");
private By userName = By.xpath("//input[@id='username']");
private By password = By.xpath("//input[@id='password']");
public BestBuyPage(WebDriver driver) {
		super(driver);
		String url = "https://www.bestbuy.ca/en-ca";
		goTo(url);
	}

	public void validateMenu() {
	click(dealsBtn);
	verifyText("Top Deals",dealsBtn);
	wait(5);
	click(outletBtn);
	wait(5);
	verifyText("Open Box Products",openBoxProductsLink);
	click(servicesBtn);
	verifyText("Support and Benefits",supportLink);
	verifyText("Hi, Dharani!",dharaniText);
	}
	public void accountPage() {
		verifyText("Order History",orderHistory);
		verifyText("Payment Methods",paymentMethods);
		verifyText("Addresses",addresses);
		scrollToElement(personalDetails);
		wait(2);
		verifyText("Personal Details",personalDetails);
		verifyText("Membership",membership);
		verifyText("Monthly Subscription",monthlySubs);
		scrollToElement(preference);
		wait(5);
		verifyText("Top Deals",preference);		
	}
public void addSlideToCart() {
	scrollToElement(searchInput);
	wait(5);
	enterData("children slide" , searchInput);
	click(searchIcon);
	wait(5);
	click(slideProduct);
	wait(5);
	verifyText("KidKraft Hop & Slide Frog Climber - Green",productText);
	click(addToCartBtn);
	click(viewCartPopup);
	wait(3);
	//Verifying whether the added product is present in the cart or not
	verifyText("KidKraft Hop & Slide Frog Climber - Green",prodInCart);
	//click(bestBuyIcon);
}
public void addBrandProdToCart() {
	scrollToElement(shopBtn);
	wait(2);
	click(shopBtn);
	click(brandsBtn);
	click(abBrandBtn);
	click(acerBrandBtn);
	//verifying whether the Brand is the selected one or not
	verifyText("Acer",acerBrandPage);
	click(audioLabel);
	click(speakerText);
	wait(5);
	click(addToCartBtn);
	click(viewCartPopup);
	wait(3);
	//Verifying whether the added product is present in the cart or not
	verifyText("6.5” Ceiling Wall Mount Speakers - Pair of 2-Way Midbass Woofer Speaker 1/2'' Polymer Dome Tweeter Flush Design w/ 70Hz-20kHz Frequency Response & 200 Watts Peak Easy Installation",prodInCart);
	

	
}
public void paymentPage() {
	click(checkoutBtn);
	wait(5);
	//entering the valid credentials for checking out
	enterData("Dharani" ,firstNameLbl);
	enterData("check" ,lastNameLbl);
	enterData("1234567890" ,phoneLbl);
	enterData("615 Abshire Common, Johnstonton, Northwest Territories , Canada" ,addressLbl);
	enterData("Arnprior" ,cityLbl);
	//dropdown with select - Hence using select method
	selectByVisibleText("Ontario",provinceLbl);
	enterData("K6V 0X1" ,postalCodeLbl);
	click(continueBtn);
	//Entering the fake credit card details generated online
	enterData("4716623228136731 ",cardNumberLbl);
	selectByVisibleText("07",expiryMonthLbl);
	selectByVisibleText("2024",expiryYearLbl);
	enterData("468",cvvLbl);
	click(continueBtn);
	wait(5);
	//checking for the review page is present or not
	verifyText("Review your Order",reviewPage);
	wait(5);
	//making the final payment confirmation
	click(placeOrderBtn);
	wait(5);
	//The transation is not successsfull as I've provided fake credit card details
	verifyText("We are unable to process your credit card at this time. It is possible that you have entered an invalid card number; the card type does not match the card number format; your card is not an accepted method of payment; your bank has a hold on your card; or the card number associated with this account has been closed, Please contact your financial institution or try another card. (0095)",errorMsg);
}

public void bottomLinksVerify() {
	click(bbLogo);
	wait(5);
	//checking the link redirects in the bottom
	scrollToElement(termsLink);
	click(termsLink);
	wait(5);
	verifyText("Terms and Conditions", termsPage);
	//conditons page
	scrollToElement(termsLink);
	click(conditionsLink);
	wait(5);
	verifyText("Conditions Of Use", conditionsPage);
	//
	scrollToElement(termsLink);
	click(onlinePolicyLink);
	wait(5);
	verifyText("Online Policies", onlinePage);
	//
	scrollToElement(termsLink);
	click(interestBasedLink);
	wait(5);
	verifyText("Interest-Based Ads", interestPage);
	//
	scrollToElement(termsLink);
	click(ppLink);
	wait(5);
	verifyText("Privacy Policies", privacyPage);
	scrollToElement(termsLink);
	click(cookieLink);
	wait(5);
	verifyText("Cookies", cookiePage);
	scrollToElement(termsLink);
	click(accessLink);
	wait(5);
	verifyText("Accessiblity Policy", accessPage);
	scrollToElement(termsLink);
	click(geekLink);
	wait(5);
	verifyText("Geek Squad Terms & Conditions", geekPage);
	//
	scrollToElement(termsLink);
	click(productLink);
	wait(5);
	verifyText("Product Recalls", prodPage);
	
}
public void login() {
	click(accountBtn);
	click(signInBtn);
	wait(2);
	enterData("divya1108@yopmail.com",userName);
	enterData("DHP@ssw0rd@2023@)@#", password);
	click(signInBtn);
	wait(5);
}
}
