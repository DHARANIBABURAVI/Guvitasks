package com.wv.auto.framework.utils;

public class Timer {
	public static void wait(int sec) {
		try {
			int msec = sec * 1000;
			Thread.sleep(msec);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
