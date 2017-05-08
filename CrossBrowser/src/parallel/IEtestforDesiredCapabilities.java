package parallel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEtestforDesiredCapabilities {

	public static void main(String[] args) {

		// it is used to define IE capability
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

		capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		System.setProperty("webdriver.ie.driver", "C:/Users/Shivangi/newSpace/CrossBrowser/lib/IEDriverServer.exe");

		// it is used to initialize the IE driver
		WebDriver driver = new InternetExplorerDriver(capabilities);

		driver.manage().window().maximize();

		driver.get("http://gmail.com");

		System.out.println("Got to the link");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.quit();
	}

}
