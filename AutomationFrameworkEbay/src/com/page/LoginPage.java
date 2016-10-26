package com.page;

import com.base.BasePage;
import com.util.PageDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage{

	
	public LoginPage(PageDriver driver){
	super(driver);

}
	
	public   boolean performsignin(String email,String passwd){
		driver.findElement("xpath_username").sendKeys(email);
		driver.findElement("xpath_pwd").sendKeys(passwd);
		driver.findElement("id_signbutton").click();
		WebElement element=driver.findElement("xpath_signoutlink");
		Actions act = new Actions((WebDriver) driver);
		Action action = act.moveToElement(element).build();
		action.perform();
WebDriverWait wait = new WebDriverWait((WebDriver) driver, 5); 
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&lgout=1')]")));

		driver.findElement("xpath_signout").click();


		return driver.findElement("xpath_signout").isDisplayed();
	}
	
}