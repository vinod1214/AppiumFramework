package android.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.omg.SendingContext.RunTime;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.AddtoCartPage;
import pageObjects.CheckoutPage;
import pageObjects.FormPage;


public class Ecommerce_tc_4 extends base {

	@Test
	public void totalValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
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
		int count = checkoutPage.getProductPrice().size();
		double sumAmount = 0;
		for(int i=0;i<count;i++) {
			String amount1 = checkoutPage.getProductPrice().get(i).getText();
			double amount=getAmount(amount1);
			sumAmount=sumAmount+amount;
		}
		System.out.println(sumAmount);
		
		String totalAmount = checkoutPage.getTotalAmount().getText();
		totalAmount = totalAmount.substring(1);
		double total = Double.parseDouble(totalAmount);
		System.out.println(total);
		Assert.assertEquals(sumAmount, total );
		service.stop();

	}
	public static double getAmount(String value) {
		value = value.substring(1);
		double double2amount = Double.parseDouble(value);
		return double2amount;
	}
	
	@BeforeTest
	public void killNode() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}

}
