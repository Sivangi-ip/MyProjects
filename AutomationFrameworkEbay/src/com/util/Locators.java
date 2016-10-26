package com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import org.openqa.selenium.By;

public class Locators {
	static HashMap<String,String>locators;
	public static void readlocators(){
		locators= new HashMap<String,String>();

		Properties prop = new Properties();
		FileReader fr;
		
		try {
			fr= new FileReader(new File("locators.properties"));
		prop.load(fr);
	    
			  Enumeration<?> en = prop.propertyNames();
			  while(en.hasMoreElements())
			  {
				  String key = (String)en.nextElement();
				  String value = prop.getProperty(key);
				  locators.put(key, value);}}
			  
			  //		for(Map.Entry val: prop.entrySet()){
//			String key= (String)val.getKey();
//			String value=(String)val.getValue();
//		.put(key,value);}}
		catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (IOException  e){
		}
	}
	public static By get(String Key){
		if(Key.contains("_")){
			String[]val=Key.split("_");
			if(val[0].equals("css")){
				return By.cssSelector(locators.get(Key));
			}
			else if(val[0].equals("xpath")){
				return By.xpath(locators.get(Key));}
			else if(val[0].equals("id")){
				return By.id(locators.get(Key));}
			else if(val[0].equals("name")){
				return By.name(locators.get(Key));}
			else if(val[0].equals("link")){
				return By.linkText(locators.get(Key));}
			else if(val[0].equals("plink")){
				return By.partialLinkText(locators.get(Key));}
			else if(val[0].equals("class")){
				return By.className(locators.get(Key));}
			else if(val[0].equals("tag")){
				return By.tagName(locators.get(Key));
		}}
		return By.cssSelector(locators.get(Key));
	}}
	
	
