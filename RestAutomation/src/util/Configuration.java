package util;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Configuration {
	
	public static String URI;//static so that I can access it by the name of the class
	
	public Configuration(){
		
		loadProperties();
	}
	
	public void loadProperties()
	{
		Properties prop= new Properties();
		try{
		FileReader reader = new FileReader(new File(String.format("%s/config.properties",System.getProperty("user.dir"))));
				prop.load(reader);
				
				URI=prop.getProperty("uri");
	}
    catch (Exception ex)	{
    	
    }
}
}
