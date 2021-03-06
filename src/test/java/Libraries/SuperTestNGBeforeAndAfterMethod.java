package Libraries;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SuperTestNGBeforeAndAfterMethod

{

	public WebDriver driver;

	@BeforeMethod
	public void beforeMethod()

	{

		String browserName = "Chrome";
		if (browserName.equalsIgnoreCase("chrome"))

		{

			System.setProperty("webdriver.chrome.driver", ".\\BrowserDrivers\\chromedriver.exe");

			driver = new ChromeDriver();

		}

		else if (browserName.equalsIgnoreCase("ie"))

		{

			System.setProperty("webdriver.ie.driver", ".\\BrowserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.get("https://epc2017-itg-beta.msys.parts/Users/Account/AccessDenied?ReturnUrl=%2Fcommerce%2Forders");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void afterMethod(ITestResult it)

	{

		EventFiringWebDriver captureScreenShot = new EventFiringWebDriver(driver);
		File capturedFile = captureScreenShot.getScreenshotAs(OutputType.FILE);
		String screenShotName = it.getTestClass().getName();
		File destFile = new File(".\\ScreenShots\\" + screenShotName + ".jpg");
		FileUtils.copyFile(capturedFile, destFile);
		driver.quit();

	}

}
