package com.wv.auto.framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.wv.auto.framework.utils.Timer;

public abstract class  BasePage {
	protected WebDriver driver;
	protected LinkedHashMap<String, By> objRep = new LinkedHashMap<String, By>();
	protected WebDriverWait wdWait=null;
	protected String pageName=null;
	
	
	public WebElement getObj(By objLoc) {
		WebElement we = driver.findElement(objLoc);
		return we;
	}


		public void goTo(String Url) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(Url);
	}

	public void print(String strToPrint) {
		System.out.println(strToPrint);
	}
	
	public void wait(int timeInSec){
	
		Timer.wait(timeInSec);
		
	}

	public void enterData(String dataToEnter, By objLoc) {
		enterData(dataToEnter, getObj(objLoc));

	}

	public void enterData(String dataToEnter, WebElement inpElement) {
		WebElement we = inpElement;
		we.clear();
		we.sendKeys(dataToEnter);
		print("ENTERED DATA : The data " + dataToEnter
				+ " is entered in input Element" + inpElement.toString());

	}
	public boolean compareStrings(String expValue, String actualValue) {
		if (expValue.equals(actualValue)) {
			print("PASSED : The expected string is " + expValue
					+ " , the actual string is " + actualValue);
			return true;
		} else {
			print("FAILED : The expected string is " + expValue
					+ " , the actual string is " + actualValue);
//			Assert.assertTrue(false);
			return false;

		}
	}
	


	
	public boolean verifyText(String expText, By objLoc) {
		WebElement we = getObj(objLoc);
		return verifyText(expText, we);

	}
	public String getText(By objLoc) {
		WebElement we = getObj(objLoc);
		return we.getText();

	}
	public boolean verifyText(String expText, WebElement obj) {
		String actText = obj.getText();
		return compareStrings(expText, actText);

	}

	public boolean verifyValue(String expValue, By objLoc) {
		return verifyValue(expValue, getObj(objLoc));
	}

	public boolean verifyValue(String expValue, WebElement obj) {
		return compareStrings(expValue, obj.getAttribute("value"));
	}

	public void printSelectionState(By objLoc) {
		printSelectionState(getObj(objLoc));
		print("The selected status for" + objLoc.toString() + " : "
				+ getObj(objLoc).isSelected());
	}
	public boolean verifyAttrValue(String expValue, By objLoc, String attributeName) {
		
		return verifyAttrValue(expValue, getObj(objLoc), attributeName );
	}	
	
	public boolean verifyAttrValue(String expValue, WebElement obj, String attributeName) {
		return compareStrings(expValue, obj.getAttribute(attributeName));
	}

	public void printSelectionState(WebElement obj) {
		print("The selected status is : " + obj.isSelected());
	}

	public void scrollToElement(By  obj) {
		
	      // Javascript executor
	      ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", getObj(obj));
	      wait(2);
	}
	public void click(By objLoc) {
		click(getObj(objLoc));
	}
	public void click(WebElement obj) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", obj);
		//obj.click();
		print("iosclickcheck : " + obj.toString());
	}
	
	
	
	public void selectByVisibleText(String textToBeSelected, By objLoc) {
		selectByVisibleText(textToBeSelected, getObj(objLoc));
	}

	public void selectByVisibleText(String textToBeSelected, WebElement dropDown) {
		Select select = new Select(dropDown);
		select.selectByVisibleText(textToBeSelected);
		print("SELECTED : " + textToBeSelected);
	}

	public void selectByValue(String valueToBeSelected, By objLoc) {
		selectByValue(valueToBeSelected, getObj(objLoc));
	}
	
	public void selectByValue(String valueToBeSelected, WebElement dropDown) {
		Select select = new Select(dropDown);
		select.selectByValue(valueToBeSelected);
		print("SELECTED BY VALUE: " + valueToBeSelected);
	}


	public WebElement getObj(String objName) {
		By objLoc = objRep.get(objName);
		if (objLoc == null) {
			print(" The object "
					+ objName
					+ " is not found, returning null, please investigate page class");
		}

		WebElement we = getObj(objLoc);

		return we;

	}

	public void addObj(String objName, By objLoc) {
		objRep.put(objName, objLoc);
	}

	public void selectByVisibleText(String textToBeSelected, String objName) {
		selectByVisibleText(textToBeSelected, getObj(objName));
	}
	


	public boolean verifyPartialText(String expText, By objLoc) {
		WebElement we = getObj(objLoc);
		return verifyPartialText(expText, we);

	}
	
	public boolean verifyPartialText(String expText, WebElement obj) {
		String actText = obj.getText();
		return containsString(expText, actText);
	}

	public boolean elementExist(By objLoc) {
		WebElement obj = null;
		try {
			 obj = getObj(objLoc);
			print("PASSED : ELEMENT" + obj.toString() +" The element exist");
			return true;
		}catch(NoSuchElementException ex) {
			print("FAILED : ELEMENT" + objLoc.toString() +" The element doesn't exist");
//			Assert.assertTrue(false);
			return false;
		}
	}
	
	public boolean verifyNonExistense(By objLoc) {
		WebElement obj = null;
		try {
			 obj = getObj(objLoc);
			print("FAILED : ELEMENT" + obj.toString() +" The element exist");
//			Assert.assertTrue(false);
			return false;
		}catch(NoSuchElementException ex) {
			print("PASSED :  ELEMENT" + objLoc.toString() +" The element doesn't exist");
			return true;
		}
	}
	
	
	//This method will get the count of repeating tags/elements
	public int getItemsCount(By objLoc) {
		List<WebElement> tags = driver.findElements(objLoc); 
	    int noOftags = tags.size(); 
	    return noOftags;
	}

	//This function will remove the array item of given index
	public String[] popArray(String[] arrayObj, int index) {
		List<String> initialList = new ArrayList<String>(Arrays.asList(arrayObj));
		initialList.remove(index);
		String[] popedArray = initialList.toArray(new String[initialList.size()]); 
				
		return popedArray;
	}
	
	//This function returns all the text in a repeating tag(tag should contain only the text)
	public String[] getFilterLinks(String objpath) {
		int length = getItemsCount(By.xpath(objpath));
		String[] filterArray= new String[length];
		for(int i=1;i<=length;i++) {
			filterArray[i-1] = getText(By.xpath(objpath+"["+i+"]"));
		}
		print("------>"+length);
		return filterArray;
	}
	
	//This function will get the particular text from the repeating tag(i.e.,The particular text in repeating div) and returns an array
	public String[] getCatalogTypes(String objpath, String objpathType) {
		int length = getItemsCount(By.xpath(objpath));
		String wholeObjPath = "";
		String actualCatalogType="";
		String[] catlogType = new String[length-1];
		for(int i=0;i<length-1;i++) {
			wholeObjPath = objpath+"["+(i+1)+objpathType;
			actualCatalogType=getText(By.xpath(wholeObjPath));
			catlogType[i]=(actualCatalogType).toLowerCase();
		}
		return catlogType;
	}
	
	//This function will remove the last letter from each array item 
	public static String[] removeLastInArrayItems(String[] array) {
		String[] outArray = new String[array.length];
		for(int i=0;i<array.length;i++) {
			outArray[i]=array[i].substring(0, (array[i].length()-1));
		}
		return outArray;
	}
	
	//This function will return distinct array
	public String[] getUniqueArray(String[] arrayObj) {
		List<String> initialList = Arrays.asList(arrayObj);
		Set<String> hashsetList = new HashSet<String>(initialList);
		String[] uniqueArray = hashsetList.toArray(new String[0]);
		return uniqueArray;
	}
	
	
	public boolean containsString(String expValue, String actualValue) {
		if (actualValue.contains(expValue)) {
			print("PASSED : The expected string is " + expValue
					+ " , the actual string is " + actualValue);
			return true;
		} else {
			print("FAILED : The expected string is " + expValue
					+ " , the actual string is " + actualValue);
//			Assert.assertTrue(false);
			return false;
		}
	}
	
	//To get all the catalog item names in Grid
	public String[] getGridViewNames(String objBox, String objName) {
		//int count = getItemsCount(By.xpath(objBox));
		String[] listitems = getCatalogTypes(objBox, objName);
		return listitems;
	}
	
	//To get all the catalog item names in List view 
	public String[] getListViewNames(String objBox, String objName) {
		int length = getItemsCount(By.xpath(objBox));
		String wholeObjPath = "";
		String actualCatalogType="";
		String[] catlogNames = new String[length];
		for(int i=0;i<length;i++) {
			wholeObjPath = objBox+"["+(i+1)+objName;
			actualCatalogType=getText(By.xpath(wholeObjPath));
			catlogNames[i]=(actualCatalogType).toLowerCase();
		}
		return catlogNames;
	}
	
	public boolean compareArray(String[] actArray, String[] expArray) {
		boolean status=false;
		if(actArray.length==expArray.length) {
			for(int i=0;i<actArray.length;i++) {
				for(int j=0;j<expArray.length;j++) {
					if(actArray[i].equalsIgnoreCase(expArray[j])){
						status=true;
					}else {
						status=false;
					}
				}
			}
		}else {
			status=false;
		}
		return status;
	}
	

	
	public Set<String> popElement(Set<String> arrayObj, String item) {
		HashSet<String> items = (HashSet<String>) arrayObj;
		arrayObj.remove(item);				
		return items;
	}
	public boolean compareSet(Set<String> actSet, Set<String> expSet) {
		String[] actArray = actSet.toArray(new String[0]);
		String[] expArray= expSet.toArray(new String[0]);
		boolean status=false;
		if(actArray.length==expArray.length) {
			for(int i=0;i<actArray.length;i++) {
				for(int j=0;j<expArray.length;j++) {
					if(actArray[i].contains(expArray[j])) {
						status=true;
					}else {
						status=false;
					}
				}
			}
		}else {
			status=false;
		}
		return status;
	}

	
	public String getLastWord(String text, String condition) {
		String[] data=text.split(condition);
		return data[data.length-1];
		
	}
	
	public String getSubString(String text, int start, int end) {
		String data=text.substring(start, end);
		return data;
	}
	
	public void switchToNewWindow() {
		// Store and Print the name of all the windows open	
         Set<String> handles = driver.getWindowHandles();
         System.out.println(handles);
         // Pass a window handle to the other window
         for (String handle1 : handles) {
        	 System.out.println(handle1);
          	driver.switchTo().window(handle1);
          }
	}
	
	public void closeNewWindow() {
		// Closing Pop Up window
         driver.close();
	}
	
	public void switchToParentWindow(String strFirstWindowHandle) {
		//Switch back to the parent browser window
		driver.switchTo().window(strFirstWindowHandle);
	}

	public void addToSet(Set<String> setItems, String item) {
		if(!item.isEmpty()) {
			setItems.add(item);
		}			
	}
	
	public void clear(By objLoc) {
		WebElement we = getObj(objLoc);
		we.clear();
		print("CLEARED DATA : The data " + " is cleared in input Element" + we.toString());
	}
	public boolean compareSet(String[] actArray, Set<String> expSet) {
		//String[] actArray = actSet.toArray(new String[0]);
		String[] expArray= expSet.toArray(new String[0]);
		boolean status=false;
		if(actArray.length==expArray.length) {
			for(int i=0;i<actArray.length;i++) {
				for(int j=0;j<expArray.length;j++) {
					status = containsString(actArray[i], expArray[j]);
				}
			}
			
		}else {
			status=false;
		}
		return status;
	}
	
	public int getNumber(String data){
		int number = Integer.parseInt(data);
		return number;
	}
	public String getFirstWord(String str) {
		String[] outArray = str.split(" ");
		return outArray[0];
	}
	
	public String getAttributeValue(By objLoc) {
		String value = driver.findElement(objLoc).getAttribute("text");
		return value;
	}
	public boolean verifyText(String expText, String actText) {
		return compareStrings(expText, actText);
	}
	public List<WebElement> getObjs(By objLoc) {
		List<WebElement> we = driver.findElements(objLoc);
		return we;
	}
	public List<WebElement> getAllElements(By objLoc) {
		List<WebElement> items = getObjs(objLoc);
		return items;
	}
	public String getAttributeValueIos(By objLoc) {
		String value = driver.findElement(objLoc).getAttribute("value");
		return value;
	}
	public String getAttributeValuePassword(By objLoc) {
		String value = driver.findElement(objLoc).getAttribute("value");
		return value;
		} 
}
