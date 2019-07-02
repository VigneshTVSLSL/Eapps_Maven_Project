package Eapps_Test_case_Folder1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Libraries.BeforeAndAfterMethod;
import Libraries.HandlingExcel;

public class CallieBrowser extends BeforeAndAfterMethod {
	// public WebDriver driver;

	@Test
	public void CallieBrowser() throws EncryptedDocumentException, IOException, InterruptedException

	{
		String filePath = ".\\TestData\\TestData.xlsx";
		String sheetName = "ElementIDandValues";

		HandlingExcel handlingExcel = new HandlingExcel();

		String actualElementValue = "Gmail";
		String expectedTextElement = driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).getText();

		Assert.assertEquals(actualElementValue, expectedTextElement);

		System.out.println("User is in Gmail Home Page");

		driver.findElement(By.xpath(handlingExcel.getDataFromExcel(filePath, sheetName, 1, 2)))
				.sendKeys(handlingExcel.getDataFromExcel(filePath, sheetName, 1, 3));

		Thread.sleep(5000);

		driver.findElement(By.xpath(handlingExcel.getDataFromExcel(filePath, sheetName, 2, 2))).click();

	}
}
