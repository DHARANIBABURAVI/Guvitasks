package com.wv.auto.framework.utils;
//import java.io.File;
//import java.io.OutputStream;
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;
//import io.appium.java_client.service.local.flags.AndroidServerFlag;

public class StartAppiumNode {
	public static void main(String args[]) {
//	AppiumDriver<MobileElement> appiumDriver = null;
//	AppiumDriverLocalService appiumNode = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//	        .withIPAddress("localhost")
//	        .usingPort(1234) // change port accordingly
//	        .withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, String.valueOf("port"))
//	        .withLogFile(new File("log")));
//
//	// if you want to remove appium log from console use this code
//		Field streamsField = null;
//		Field streamField = null;
//
//	try {
//	    streamField = AppiumDriverLocalService.class.getDeclaredField("stream");
//	    streamField.setAccessible(true);
//	    streamsField = Class.forName("io.appium.java_client.service.local.ListOutputStream").getDeclaredField("streams");
//	    streamsField.setAccessible(true);
//	} catch (ClassNotFoundException | NoSuchFieldException e) {
//	    e.printStackTrace();
//	}
//	
//	try {
//	    ((ArrayList<OutputStream>) streamsField.get(streamField.get(appiumDriver))).clear(); // remove System.out logging
//	} catch (IllegalAccessException e) {
//	    e.printStackTrace();
//	}
//
//	appiumNode.start();

}}