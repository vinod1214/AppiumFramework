package android.AppiumFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.FormPage;

public class Ecommerce_tc_3 extends base {

	public void verifyItemSelected() throws IOException, InterruptedException {

		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FormPage formPage = new FormPage(driver);
		Utitlities u = new Utitlities(driver);
		formPage.getNameField().sendKeys("hello");
		driver.hideKeyboard();
		formPage.getRadioOption().click();
		formPage.getCountrySelection().click();
		u.scrollToText("Australia");
		formPage.selectCountry.click();
		formPage.getLetsShop().click();
		driver
        .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
        + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
        + "new UiSelector().text(\"Jordan 6 Rings\"));");
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<count;i++) {
			String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(text.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String lastpageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals("Jordan 6 Rings", lastpageText);
		service.stop();
		
	}
	@BeforeTest
	public void killNode() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}

}
