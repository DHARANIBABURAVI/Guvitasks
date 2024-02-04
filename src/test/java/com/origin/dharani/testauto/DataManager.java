package com.origin.dharani.testauto;

import org.testng.annotations.DataProvider;

import com.wv.auto.framework.BrowserFactory;

public class DataManager extends BrowserFactory{

@DataProvider
public static Object[][] browers() {
if(getOS().equalsIgnoreCase("win")) {
return new Object[][] {
//new Object[] { "1", "msedge" }, 
new Object[] { "2", "Chrome" },
//new Object[] { "3", "Firefox" }
};
}

if(getOS().equalsIgnoreCase("mac")) {
return new Object[][] {
new Object[] { "1", "safari" }
};
}
return null;
/*return new Object[][] {
// new Object[] { "1", "msedge" }, 
new Object[] { "2", "Chrome" },
// new Object[] { "3", "safari" }
new Object[] { "4", "Firefox" }

};*/
}

}