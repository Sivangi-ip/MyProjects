package com.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.util.ExcelUtil;
import com.util.Locators;
import com.util.Configuration;
import com.util.PageDriver;

public abstract class BaseTest {
	public PageDriver driver;
	public ExcelUtil excelutil;
	public static final Configuration config;
	static{
		config = new Configuration();
	}

  @BeforeSuite
public void beforeSuite(){
	this.driver= new PageDriver(config);
	Locators.readlocators();
	excelutil = new ExcelUtil();
	
}
  @AfterSuite
public void afterSuite(){
	driver.quit();
	
}
}