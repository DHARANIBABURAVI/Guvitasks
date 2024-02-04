package Utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basepage {
	public static WebDriver driver=null;
	
	//explicitwait
	
	public void waitForElement(WebElement ele, int timeout)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,timeout);
			wait.until(ExpectedConditions.visibilityOf(ele));
			//Reports.reportStep("PASS","Successfully waited for the element using explicit wait ");

		}
		catch(Exception ex)
		{
			
			ex.printStackTrace();
		}
	}

}
