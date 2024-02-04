package com.origin.dharani.testauto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class DharaniUtils {
	private final static String propertyGFile = "properties/fractalautoglobal.properties";
	private final static String propertyLFile = "target/test-classes/properties/fractalpagelabels.properties";

	private static Properties fractalGlobalProperties = new Properties();
	private static Properties fractalPageLabelsProperties = new Properties();
	
	
	private static String OS = System.getProperty("os.name").toLowerCase();

	private static void loadGlobalProperties() {
		try {
			fractalGlobalProperties.load(new FileInputStream(new File(propertyGFile).getAbsoluteFile()));	
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		assert !fractalGlobalProperties.isEmpty();
	
	}

	private static void loadPageLabelProperties() {
		try {

//			fractalPageLabelsProperties.load(new FileInputStream(new File(propertyLFile).getAbsoluteFile()));
			fractalPageLabelsProperties.load(new FileInputStream(new File(propertyLFile)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		assert !fractalPageLabelsProperties.isEmpty();
	}

	public static String getProperty(final String key) {
		if (fractalGlobalProperties.isEmpty())
			loadGlobalProperties();
		String property = fractalGlobalProperties.getProperty(key);
		return property != null ? property.trim() : property;
	}
	

	public static String getPageLabel(final String key) {
		if (fractalGlobalProperties.isEmpty())
			loadPageLabelProperties();
		String property = fractalPageLabelsProperties.getProperty(key);
		return property != null ? property.trim() : property;
	}
	
	
	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}


	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}
	
	public static String getCurrentDateTime() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		
		
		return date.toString();
	}
}
