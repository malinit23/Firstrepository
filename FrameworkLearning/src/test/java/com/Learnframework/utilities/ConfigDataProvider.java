/**
 * 
 */
package com.Learnframework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author MD
 *
 */
public class ConfigDataProvider {

	Properties pro;
	
	public ConfigDataProvider()
	{
		File src = new File("./Config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
		System.out.println("Unable to load config files "+e.getMessage());
	
	}
				
		
	}
	public String getDatafromConfig(String keytoSearch)
	{
		return pro.getProperty(keytoSearch);
	}
	public String getBrowser()
	{
		return pro.getProperty("Browser");
		
	}
	public String getURL()
	{
		return pro.getProperty("qaURL");
	}
	
	
	
}