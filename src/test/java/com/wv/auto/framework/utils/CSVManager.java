package com.wv.auto.framework.utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVManager {

	
    public static void main(String[] args) {


    }
    
    public static void CSVReader() {
    	
        String csvFile = "";

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] row;
            while ((row = reader.readNext()) != null) {
               
            	
            	
            	
            	
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    public static CSVWriter getCSVWriter(String filePath) {
        	
    	String csv = "data.csv";
        CSVWriter writer=null;
		try {
			writer = new CSVWriter(new FileWriter(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return writer;
   
    }
    
   
    
	
	
}
