package makeLogReports;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testing {

	public static void main(String[] args) {

		Logger log = Logger.getLogger("Testing");
		PropertyConfigurator.configure("log4j.properties");

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.only-testing-blog.blogspot.in/2014/01/textbox.html");

		// Logger log;
		driver.findElement(By.id("text1")).sendKeys("My First Name");
		log = Logger.getLogger(Testing.class);
		log.info("Type In Text field.");
		Select mydrpdwn = new Select(driver.findElement(By.id("Carlist")));
		mydrpdwn.selectByVisibleText("Audi");
		log = Logger.getLogger(Testing.class);
		log.info("Select value from drop down.");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("text2")));

		driver.quit();
	}

}
