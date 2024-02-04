package Stepdefinition;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class page {
	static WebDriver driver=null;
	public static void login() throws InterruptedException {

		System.out.print("Divya check");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\eclipse-workspace\\ecomerce\\src\\test\\resources\\Drivers\\chromedriver.exe");
		Thread.sleep(2000);
		ChromeOptions op = new ChromeOptions();
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.bestbuy.ca/en-ca ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
	}
	public static void checkurl() {
		try {
			driver.findElement(By.className("logo")).isDisplayed() ;
			System.out.println("given link is working fine");
		}catch(Exception e) {
			System.out.println("linnk breaks");

		}
	}
	public static void signin() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(" //span[text()='Account']")).click();
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("divya1108@yopmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("DHP@ssw0rd@2023@)@#");
		System.out.print("thepassword is " + driver.findElement(By.xpath("//input[@id=\"password\"]")).getText());
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()=\"Sign In\"])[2]")).click();	
	}
	public static void validation() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.xpath(" //span[text()='Shop']")).click();
		driver.findElement(By.xpath("//h2[text()='Get Inspired']")).isDisplayed();
		driver.findElement(By.xpath("//span[text()='Game Day Sale']")).click();
		driver.findElement(By.xpath("//a[text()='Big Screen TVs on Sale']")).isDisplayed();
		
	    
	}
	public static void spicejeturl() throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\eclipse-workspace\\ecomerce\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();					
		driver.manage().window().maximize();	
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.spicejet.com/");
		Thread.sleep(1000);
		//==================need to activatethe below lines
		//		System.out.println("checkkk forrr dharani");
		//		driver.findElement(By.xpath("//*[contains(text(),'Signup')]")).click();	
		//		System.out.println("sighnup page clicked");
		//==================================
		//		Thread.sleep(1000);
		//		 String mainwindow = driver.getWindowHandle();
		//	        Set<String> s1 = driver.getWindowHandles();
		//	        Iterator<String> i1 = s1.iterator();
		//	        
		//	        while (i1.hasNext()) {
		//	            String ChildWindow = i1.next();
		//	                if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
		//	                driver.switchTo().window(ChildWindow);
		//	                WebElement text = driver.findElement(By.xpath("//*[contains(text(),'Title')]"));
		//	                System.out.println("Heading of child window is " + text.getText());
		//	                driver.close();
		//	                System.out.println("Child window closed");
		//	            }
		//	        }
		//	        driver.switchTo().window(mainwindow);
		//	        System.out.println("again switched back to spicejet parent");


	}
	public static void spicejetlogin() throws InterruptedException {
		System.out.println("Dharanibabu");
		//driver.findElement(By.xpath("//*[contains(text(),'Signup')]")).click();	
		Thread.sleep(1000);
		String mainwindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				WebElement text = driver.findElement(By.xpath("//*[contains(text(),'Title')]"));
				System.out.println("Heading of child window is " + text.getText());
				//aboe command moves till childwindow
				//  driver.close();
				//  System.out.println("Child window closed");
			}
		}
		//			        driver.switchTo().window(mainwindow);
		//			        System.out.println("again switched back to spicejet parent");
		//			
	}
	public static  void mandatoryfields() throws InterruptedException {
		//		Select sel = new Select (driver.findElement(By.linkText("Select an option")));
		//		sel.selectByIndex(0);
		//		System.out.println("MR is selected");
		Select sel = new Select((driver.findElement(By.xpath("//select[@class='form-control form-select ']"))));
		Thread.sleep(500);
		(driver.findElement(By.xpath("//select[@class='form-control form-select ']	"))).click();
		Thread.sleep(500);
		sel.selectByVisibleText("Mr");
		//((Alert) sel).getText();
		System.out.println(sel);
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("dharanibabu");
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("ravi");
		//select[@tabindex='0']
		//(driver.findElement(By.xpath("//select[@tabindex='0']"))).click();
		//		Thread.sleep(1000);
		Select sel1 = new Select((driver.findElement(By.xpath("//select[@tabindex='0']"))));
		(driver.findElement(By.xpath("//select[@tabindex='0']"))).click();
		Thread.sleep(1000);
		sel1.selectByVisibleText("India");
		//(driver.findElement(By.xpath("//option[@value='IN']"))).click();
		//driver.findElement(By.xpath("(//button[text()='Click me'])[1]")).click();
		Thread.sleep(1000);
		System.out.println(sel1); 
		driver.findElement(By.xpath("//input[@id='dobDate']")).sendKeys("02/03/1994");
		Thread.sleep(5000);	
		//input[@type='tel']
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("8148340302");
		// WebDriverWait wait = new WebDriverWait();
		// WebElement element = waitforElementvisiblity(driver, By.id("email_id"), 30);		
		//input[@id='email_id']

		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='email_id']")).sendKeys("dharaniravi0294@gmail.com");
		Thread.sleep(5000);	
		//input[@id='new-password']
		driver.findElement(By.xpath("//input[@id='new-password']")).sendKeys("Dharani@123@)@#1");
		//input[@id='c-password']
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='c-password']")).sendKeys("Dharani@123@)@#1");
		Thread.sleep(10000);	
		driver.findElement(By.id("defaultCheck1")).click();
		//button[text()='Submit']
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(),driver.findElement(By.linkText(\"Submit\"))");
		driver.findElement(By.linkText("Submit")).click();	
		Thread.sleep(5000);

	}
	private static WebElement waitforElementvisiblity(WebDriver driver, By id, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(id));
	}
	public static void bookflights() throws InterruptedException {
		//	BOOK NOW
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(),driver.findElement(By.xpath(\"//button[text()='BOOK NOW']\"))");
		//		driver.findElement(By.xpath("//button[text()='BOOK NOW']")).click();
		//		Set<String> childwindow = driver.getWindowHandles();
		//		//we use for each lhere to s eithch
		//		for(String eachwindows: childwindow) {
		//
		//			driver.switchTo().window(eachwindows);
		//
		//		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please choose an option (onewaay or roundtrip): ");
		String userChoice = scanner.nextLine();
		//ONE WAY
		switch (userChoice) {
		case "oneway":
			driver.findElement(By.xpath("//div[text()='Welcome aboard']"));
			System.out.println("found the text welcome aboard");
			//Assert.assertEquals("Welcome aboard", "//div[text()='Welcome aboard']");
			//div[text()="one way"]
			driver.findElement(By.xpath("//div[text()=\"one way\"]")).click();
			//input[@type='text'])[2]
			driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("DEL");
			Thread.sleep(500);
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("MAA");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@data-testid ='undefined-month-February-2024']/div/div/div[@data-testid='undefined-calendar-day-1']")).click();
			Thread.sleep(4000);
			//actions.contextClick();
			//actions.contextClick();
			Thread.sleep(10000);
			//	scrollToElement("");
			driver.findElement(By.xpath("//div[text()='Search Flight']/..")).click();
			Thread.sleep(5000);
			break;
		case "roundtrip":

			Thread.sleep(500);
			driver.findElement(By.xpath("//div[text()=\"round trip\"]")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("DEL");
			Thread.sleep(500);
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("MAA");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@data-testid ='undefined-month-February-2024']/div/div/div[@data-testid='undefined-calendar-day-1']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@data-testid ='undefined-month-February-2024']/div/div/div[@data-testid='undefined-calendar-day-2']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//div[text()=\"Search Flight\"]/..")).click();
			break;
		default:
			System.out.println("Invalid choice");
		}
	}
	public static WebElement getObj(By objLoc) {
		WebElement we =driver.findElement(objLoc);
		return we;
	}
	private static void scrollToElement( By check) {
		// Javascript executor
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", getObj(check));
	}
	public static void selectglight() throws InterruptedException {

		//		Scanner scanner = new Scanner(System.in);
		//
		//		System.out.println("Select an option:");
		//		System.out.println("SG8193, SG611");
		//		System.out.println("SG8703,SG619");
		//		System.out.println("SG8185,SG444");
		//		System.out.print("Enter the flight of your choice: ");
		//		int userChoice = scanner.nextInt();
		//		switch (userChoice) {
		//		case 1:
		//			driver.findElement(By.xpath("(//div[@data-testid='spicesaver-flight-select-radio-button-0'])[1]")).click();
		//			break;
		//		case 2:
		//			driver.findElement(By.xpath("(//div[@data-testid='spicesaver-flight-select-radio-button-0'])[2]")).click();
		//			break;
		//		case 3:
		//			driver.findElement(By.xpath("(//div[@data-testid='spicesaver-flight-select-radio-button-0'])[3]")).click();
		//			break;
		//		default:
		//			System.out.println("Invalid choice. Please select a valid option.");
		//		}
		//
		//		scanner.close();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//div[text()='Continue'])[1]/..")).click();
		Thread.sleep(10000);


		//		WebElement dropdownElement = driver.findElement(By.linkText("Mr"));
		//		Select dropdown = new Select(dropdownElement);  
		//		dropdown.selectByVisibleText("Mr");

		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("dharanibabu");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Ravi");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("7550030203");
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("Dharani.r94@gmail.com");
		//dropdown.selectByVisibleText("India");
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("city");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, " + 500 + ");");
		// Passenger 1
		String expectedText = "Passenger 1"; 
		WebElement element = driver.findElement(By.xpath("//div[text()='Passenger 1']"));
		String actualText = element.getText();
		System.out.println(("verification passed"));
		driver.findElement(By.xpath("//div[text()='I am flying as the primary passenger']")).click();
		//	dropdown.selectByVisibleText("Mr");
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("dharanibabu");
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("Ravi");
		driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("7550030203");
		Thread.sleep(1000);
		System.out.println("Check for continue button");
		driver.findElement(By.xpath(" (//div[text()='Continue'])[1]/..")).click();
		Thread.sleep(5000);
		System.out.println("Check for continue button aftercllick");
		Thread.sleep(1000);
		System.out.println("Check for continue button lastpage");
		WebElement scroll = driver.findElement(By.xpath("//div[text()='Connect with us']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(scroll);
		actions.perform();
		Thread.sleep(10000);
		if (driver.findElement(By.xpath("//div[@id='at_addon_close_icon']")).isDisplayed() == true) {
			driver.findElement(By.xpath("//div[@id='at_addon_close_icon']")).click();
			System.out.println("Entered inside popup");
		}

		//		if(driver.findElement(By.xpath("//*[@id='skipfrompopup']")).isEnabled()== true);
		//		{
		//			System.out.println("Entered inside skip popup");
		//			driver.findElement(By.xpath("//*[@id='skipfrompopup']")).click();
		//			
		//		}
		//			System.out.println("Entered else");
		driver.findElement(By.xpath("(//div[text()='Continue'])[3]/..")).click();

		if(driver.findElement(By.xpath("//*[@id='skipfrompopup']")).isDisplayed()== true);
		{
			System.out.println("Entered inside skip popup 22");
			driver.findElement(By.xpath("//*[@id='skipfrompopup']")).click();

		}
		Thread.sleep(3000);
		//		if(driver.findElement(By.xpath("//div[@id='at_prepayment_close_icon']")).isDisplayed()==true) {
		//			driver.findElement(By.xpath("//div[@id='at_prepayment_close_icon']")).click();
		//		}
		try {
			driver.findElement(By.xpath("//div[@id='at_prepayment_close_icon']")).click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("The Popup Didnt occur");
		}

		//	driver.findElement(By.xpath("//form[@id='payment_form']/h3[text()='Enter Debit / Credit Card Details']")).isDisplayed();		


		//	Thread.sleep(10000);
		System.out.println("Validated till the Credit card page");
		//	https://www.spicejet.com/booking/prepayment
		//	Thread.sleep(10000);
		//		driver.findElement(By.id("card_number")).sendKeys("4263982640269299");
		//		driver.findElement(By.id("name_on_card")).sendKeys("dharani");
		//		driver.findElement(By.id("card_exp_month")).sendKeys("02");
		//		driver.findElement(By.id("card_exp_year")).sendKeys("26");
		//		driver.findElement(By.id("security_code")).sendKeys("837");
		//		driver.findElement(By.xpath("//div[text()='Proceed to pay']")).click();
		driver.close();
	}

}






