package com.wv.auto.framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	public String getProperty(String fileName, String property) {
		String propValue = null;
		FileInputStream fIS = null;
		Properties prop = null;

		try {
			// Create a input stream
			fIS = new FileInputStream(fileName);
			// Create a properties object
			prop = new Properties();
			// load the properties object with data from file input stream
			prop.load(fIS);
			// Get the requested property into propValue
			propValue = prop.getProperty(property);
			System.out.println("The requested value is " + propValue);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fIS != null) {
				try {
					fIS.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		// return the propValue
		return propValue;
	}
}
