package com.selenium.page.chain.pattern.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {
	
	public static String getObject(String fileName, String key) {
		String value = null;
		Properties  properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("src/test/resources/ObjectRepositories/"+fileName+".properties")));
			value = properties.getProperty(key);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return value;
	}

}