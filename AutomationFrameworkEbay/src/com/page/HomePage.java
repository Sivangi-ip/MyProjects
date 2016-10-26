package com.page;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BasePage;

import com.util.PageDriver;

public class HomePage extends BasePage{
	
	public HomePage(PageDriver driver){
		super(driver);
	}
	public void open(){
		driver.get("http://www.ebay.com/");
	}
	public int getSocialLinks(){
		int count=0;
		List<WebElement>sociallinks = driver.findElements("xpath_Social-Link");
		if(sociallinks!=null)
			count=sociallinks.size();
		return count;
	
	}
	public String ClickLogin(){
		driver.findElement("xpath_loGIN-lINK").click();
		return driver.getCurrenturl();
		}
	public  int navbar(){
		
	List<WebElement> elements = driver.findElements("xpath_navlink");
	return elements.size();}

public String  navelement(){
	WebElement element = driver.findElement("linkText_navbar");
	 return (element.getAttribute("href")+element.getCssValue("color")+driver.getCurrenturl()+driver.getTitle());
	}
public boolean actions1(){
	WebElement  searchtext = driver.findElement("id_searchtext");

	Actions act = new Actions(driver);
	Action action = act.moveToElement(searchtext)
			.click().keyDown(searchtext, Keys.SHIFT)
			.sendKeys("ipad")
			.keyUp(searchtext, Keys.SHIFT)
			.contextClick(searchtext)
			.contextClick().build();
            action.perform();
 WebDriverWait wait = new WebDriverWait(driver, 10); 
	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Copy")));
	driver.findElement("linkText_right").click();
	return driver.findElement("Copy").isDisplayed();
}
	


public String  Screenshot(){
	File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	return (screen.getAbsolutePath()+"*******"+screen.getName());

}	
public String windowHandleEx()
		{
			driver.get("https://mbuy.ebay.com/xo?action=view&sessionid=493903772016&redirect=mobile");
			driver.findElement("xpath_username").sendKeys("Shivangi");
			driver.findElement("xpath_pwd").sendKeys("******");
			driver.findElement("sgnBt").click();
			WebElement element=driver.findElement("confirm_id");
	      element.click();
			driver.findElement("xpath_creditbutton").click();;
			String child  = driver.getWindowHandle();
			 return (driver.switchTo().window(child).getCurrentUrl());
}}