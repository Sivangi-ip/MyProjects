package parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEExample {

	public static void main(String[] args) {

		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("http://gmail.com");

		driver.quit();
	}

}
