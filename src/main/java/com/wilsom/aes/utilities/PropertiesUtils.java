package com.wilsom.aes.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	
	private Properties prop = new Properties();
	private String path = "src/test/resources/config/qa2pb.properties";
	
	public void loadProperties() {
		InputStream inStream = null;
		
		try {
			inStream = new FileInputStream(path);
			prop.load(inStream);
		} catch (FileNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		} finally {
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void setProperty(String key, String value) {
		prop.setProperty(key, value);
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}

}
