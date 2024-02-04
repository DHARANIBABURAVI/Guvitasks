package com.wv.auto.framework.utils;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeManager {

	private static Timestamp timeAtEvent = null;
	public static Timestamp getCurrententTimeStamp() {
		java.util.Date date1 = new java.util.Date();
		Timestamp timestamp = new Timestamp(date1.getTime());
		return timestamp;
}
	public static String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		return date.toString();
	}
	public static String getTimeDiff(Timestamp timestamp1, Timestamp timestamp2) {
		// get time difference in seconds
		long milliseconds = timestamp2.getTime() - timestamp1.getTime();
		int seconds = (int) milliseconds / 1000;
		// calculate hours minutes and seconds
		int hours = seconds / 3600;
		int minutes = (seconds % 3600) / 60;
		seconds = (seconds % 3600) % 60;
		return hours + " Hours" + minutes + " Minutes " + seconds + " Seconds";
	}
	public static String getTimeDiffInSecs(Timestamp timestamp1, Timestamp timestamp2) {
		// get time difference in seconds
		long milliseconds = timestamp2.getTime() - timestamp1.getTime();
		int centiseconds = (int) milliseconds / 10;
		Short seconds = new Short((short) (centiseconds/100));
		return seconds.toString();
	}
	public static void setTimeAtEvent() {
		timeAtEvent = getCurrententTimeStamp();
	}
	public static String getTimeDiffFromPrevEventInSecs() {
		// get time difference in seconds
		long milliseconds = getCurrententTimeStamp().getTime() - timeAtEvent.getTime();
		int centiseconds = (int) milliseconds / 10;
		Short seconds = new Short((short) (centiseconds/100));
		return seconds.toString();
	}
}