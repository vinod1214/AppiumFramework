package android.AppiumFramework;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.AddtoCartPage;
import pageObjects.FormPage;


public class Ecommerce_tc_5 extends base {

	@Test
	public void validateMobileGestures() throws InterruptedException, IOException {

		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FormPage formPage = new FormPage(driver);
		Utitlities u = new Utitlities(driver);
		AddtoCartPage addtoCartPage = new AddtoCartPage(driver);
		formPage.getNameField().sendKeys("hello");
		driver.hideKeyboard();
		formPage.getRadioOption().click();
		formPage.getCountrySelection().click();
		u.scrollToText("Australia");
		formPage.selectCountry.click();
		formPage.getLetsShop().click();
		addtoCartPage.getAddtoCart().get(0).click();
		addtoCartPage.getAddtoCart().get(0).click();
		addtoCartPage.getAddCartBtn().click();
		Thread.sleep(4000);
		//mobile gestures
		WebElement checkbox = driver.findElement(By.xpath("//*[@text='Send me e-mails on discounts related to selected products in future']"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		WebElement tc = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.className("android.widget.Button")).click();
		service.stop();
		
	}
	@BeforeTest
	public void killNode() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
}
