package android.AppiumFramework;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.FormPage;


public class Ecommerce_tc_2 extends base {

	@Test
	public void toastMsgValidation() throws IOException, InterruptedException {

		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FormPage formPage = new FormPage(driver);
		Utitlities u = new Utitlities(driver);
		formPage.getRadioOption().click();
		formPage.getCountrySelection().click();
		u.scrollToText("Australia");
		formPage.selectCountry.click();
		formPage.getLetsShop().click();
		String toastMsg = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		Assert.assertEquals("Please enter your name", toastMsg);
		service.stop();

	}
	
	@BeforeTest
	public void killNode() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}

}
