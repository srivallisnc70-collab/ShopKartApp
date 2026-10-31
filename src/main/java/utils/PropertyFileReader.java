package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	Properties property;
	
	public void propertyInit(String filePath)
	{
		property = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public String fetchProperty(String key)
	{
		return property.getProperty(key);
	}

}
