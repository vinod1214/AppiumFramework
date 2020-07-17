package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	public FormPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	@AndroidFindBy(xpath="//*[@text='Australia']")
	public WebElement selectCountry;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement letsShop;
	
	public WebElement getNameField() {
		return nameField;
	}
	
	public WebElement getRadioOption() {
		return femaleOption;
	}
	
	public WebElement getCountrySelection() {
		return countrySelection;
	}
	
	public WebElement getSelectCountry() {
		return selectCountry;
	}
	
	public WebElement getLetsShop() {
		return letsShop;
	}
	
}
