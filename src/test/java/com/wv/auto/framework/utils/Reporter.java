package com.wv.auto.framework.utils;

import java.io.IOException;
import java.sql.Timestamp;

import com.opencsv.CSVWriter;

public class Reporter {
	private static CSVWriter repWriter;
	private static CSVWriter repWriterDetail;
	private static CSVWriter repWriterFailure;
	private static String strBrowserAppOS = "Android";
	private static String strEnv = "Production";

	public static void createReports() {
		createReport();
		createDetailReport();
		createFailureReport();
	}

	public static void createReport() {

		// This will create the report file call this before start of testing
		String reportFile = "target/TestReport.csv";
		if (repWriter == null)
			repWriter = CSVManager.getCSVWriter(reportFile);
		writeHeader();
	}

	public static void createDetailReport() {

		// This will create the report file call this before start of testing
		String reportFile = "target/TestDetailReport.csv";
		if (repWriterDetail == null)
			repWriterDetail = CSVManager.getCSVWriter(reportFile);
		writeDetailHeader();
	}

	public static void createFailureReport() {

		// This will create the report file call this before start of testing
		String reportFile = "target/TestFailureReport.csv";
		if (repWriterFailure == null)
			repWriterFailure = CSVManager.getCSVWriter(reportFile);
		writeFailureHeader();
	}

	private static void writeHeader() {
		// Create record
		String[] record = "Browser/App, Environment, TCID, TEST DESCRIPTION, TEST RESULT ,TIME TAKEN(SEC),TIME STAMP".split(",");
		TimeManager.setTimeAtEvent();
		// Write the record to file
		if (repWriter != null)
			repWriter.writeNext(record);
	}

	private static void writeDetailHeader() {
		// Create record
		String[] record = "TCID, TEST DESCRIPTION, TEST RESULT".split(",");
		// Write the record to file
		if (repWriterDetail != null)
			repWriterDetail.writeNext(record);
	}

	private static void writeFailureHeader() {
		// Create record
		String[] record = "Browser/App, Environment, TCID, TEST DESCRIPTION, TEST RESULT ,TIME TAKEN(SEC),TIME STAMP".split(",");
	
		// Write the record to file
		if (repWriterFailure != null)
			repWriterFailure.writeNext(record);
	}

	public static void writeSummary(String strLine) {

		String strReportWithBrowserEnvDetails = strBrowserAppOS + "," + strEnv + "," + strLine+","+TimeManager.getTimeDiffFromPrevEventInSecs()+","+TimeManager.getCurrentDateTime();
		TimeManager.setTimeAtEvent();
		// This is report test result
		String[] record = strReportWithBrowserEnvDetails.split(",");
		repWriter.writeNext(record);	
		if (strReportWithBrowserEnvDetails.contains("FAILED"))
			writeFailure(strReportWithBrowserEnvDetails);
	}
	
	public static void writeSummary(String strLine,String TimeTaken,String TimeStamp) {
		String strReportWithBrowserEnvDetails = strBrowserAppOS + "," + strEnv + "," + strLine+","+TimeTaken+","+TimeStamp;

		// This is report test result
		String[] record = strReportWithBrowserEnvDetails.split(",");
		repWriter.writeNext(record);		
		if (strLine.endsWith("Failed"))
			writeFailure(strLine);
	}

	public static void writeDetail(String strLine) {
		// This is report test result
		String[] record = strLine.split(",");
		repWriterDetail.writeNext(record);
	}

	public static void writeFailure(String strLine) {
		// This is report test result
		String[] record = strLine.split(",");
		repWriterFailure.writeNext(record);
	}

	public static void closeReport() {
		if (repWriter != null)
			try {
				repWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static void closeReports() {
		closeReport(repWriter);
		closeReport(repWriterDetail);
		closeReport(repWriterFailure);
	}

	public static void closeReport(CSVWriter cSVW) {
		if (cSVW != null)
			try {
				cSVW.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static void setBrowserAppOS(String strBrwAppOS) {
		strBrowserAppOS = strBrwAppOS;
	}

	
}
