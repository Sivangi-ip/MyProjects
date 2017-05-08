package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstExample {

	WebDriver driver;
	String baseURL, nodeURL;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		baseURL = "http://www.google.com";
		nodeURL = "http://192.168.216.1:5566/wd/hub";
		new DesiredCapabilities();
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		System.setProperty("webdriver.gecko.driver", "C:/Users/Shivangi/newSpace/GRID/geckodriver.exe");
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.XP);
		driver = new RemoteWebDriver(new URL(nodeURL), cap);

	}

	@Test
	public void simpleTest() {

		driver.get(baseURL);
		Assert.assertEquals("Google", driver.getTitle());
	}

	@AfterTest
	public void afterTest() {

		driver.quit();

	}

}
