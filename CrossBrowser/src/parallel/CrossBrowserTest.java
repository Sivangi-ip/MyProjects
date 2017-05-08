package parallel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

	WebDriver driver;

	@Parameters("browser") // this annotation is used to insert browser
							// parameter from TestNG xml
	@BeforeMethod // The annotated method will be run before all tests in this
					// suite have run

	public void beforeTest(String browser) {
		// compares the value of parameter name with Firefox, if its firefox
		// then it will launch firefox and run the script.
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/Users/Shivangi/newSpace/CrossBrowser/lib/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:/Users/Shivangi/newSpace/CrossBrowser/lib/chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("--disable-extensions");

			capabilities.setCapability("chrome.binary", "C:/Users/Shivangi/newSpace/CrossBrowser/lib/chromedriver.exe");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(capabilities);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}

		else if (browser.equalsIgnoreCase("ie")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

			capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

			System.setProperty("webdriver.ie.driver", "C:/Users/Shivangi/newSpace/CrossBrowser/lib/IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver = new InternetExplorerDriver();
		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
		driver.get("http://www.google.com");

	}

	@Test
	public void search() throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("lst-ib")).sendKeys("Parallel Testing");

		driver.findElement(By.name("btnK")).click();

	}

	@AfterMethod // this annotation would run once test script execution would
					// complete
	public void afterTest() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.quit();
	}
}
