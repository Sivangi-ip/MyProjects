package com.util;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class PageDriver implements WebDriver {
	WebDriver driver;
	Configuration config;
	
	public PageDriver(Configuration config){
		this.config=config;
		start();
	}
	public void start(){
		String browser =config.BROWSER;
		switch (browser){
		case "firefox":
			driver=startFirefox();
			break;
		case "chrome":
			driver=startChrome();
			break;
		case "ie":
			driver=startIE();
			break;	
		default:
			driver=startHtml();
			break;			
		}
		driver.get(config.URL);
	}
	public WebDriver startFirefox(){
	 return new FirefoxDriver();
	}
public WebDriver  startChrome(){
	System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

	return  new ChromeDriver();
	}
public WebDriver startIE(){
	System.setProperty("webdriver.ie.driver", "lib/IEServerDriver.exe");

	return new InternetExplorerDriver();
}
public WebDriver startHtml(){
	return new  HtmlUnitDriver();
	
	
}
	public void get(String url){
		driver.get(url);
	}
	public void maximize(){
		driver.manage().window().maximize();
	
	}
	
	public WebElement findElement(String loc){
		return driver.findElement(Locators.get(loc));
	}
	public List<WebElement>findElements(String loc){
		return driver.findElements(Locators.get(loc));
}
	public String getCurrenturl(){
		return driver.getCurrentUrl();
	}
	public void quit(){
	driver.quit();
	}
	public String getTitle() {
		return driver.getTitle();
	}
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public WebElement findElement(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}
	

}