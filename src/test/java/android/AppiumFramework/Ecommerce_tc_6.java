package android.AppiumFramework;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import java.io.IOException;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.AddtoCartPage;
import pageObjects.CheckoutPage;
import pageObjects.FormPage;
public class Ecommerce_tc_6 extends base {

	@Test
	public void performWebViewAction() throws InterruptedException, IOException {

		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FormPage formPage = new FormPage(driver);
		Utitlities u = new Utitlities(driver);
		AddtoCartPage addtoCartPage = new AddtoCartPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
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
		driver.findElement(By.className("android.widget.Button")).click();
		Thread.sleep(7000);
		Set<String> contexts = driver.getContextHandles();
		for(String context: contexts) {
			System.out.println(context);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		//webview actions
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("hello");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		service.stop();

	}
	@BeforeTest
	public void killNode() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}

}
