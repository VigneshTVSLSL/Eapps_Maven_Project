package Eapps_Test_case_Folder1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Libraries.SuperTestNGBeforeAndAfterMethod;

public class CallChromeDriver extends SuperTestNGBeforeAndAfterMethod {
	@Test
	public void ChromeDriver()

	{

		String actualElement = "Register Here1";
		String expectedElement = driver.findElement(By.xpath("//a[contains(text(),'Register Here')]")).getText();

		// assert.assertEquals(actualElement, expectedElement);

		// assert.assertEquals(actualElement, expectedElement);

		// Assert.assertEquals(value7, value8);

		Assert.assertEquals(actualElement, expectedElement);

		/*
		 * if (actualElement == expectedElement)
		 * 
		 * { System.out.println("User is in Home Page");
		 * 
		 * }
		 * 
		 * else {
		 * 
		 * System.out.println("User is not in Home Page");
		 * 
		 * }
		 */

	}

}
