package com.noorteck.qa.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {
	public static Properties getProperties(String filePath) {
		// Create a Properties class object to access the property file.
		Properties prop = new Properties();
		// create file input stream object for the properties file
		FileInputStream file;
		try {
			file = new FileInputStream(filePath);
			// Load properties file
			prop.load(file);

		} catch (Exception e) {
			System.out.println("Exception Occured: " + e);
			e.printStackTrace();
		}
		return prop;
	}
}
