package android.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name="InputData")
	public Object[][] getDataFromEditField() {
		Object[][] obj = new Object[][] {
				{"hello"}, {"@#$%"}
			};
		return obj;
	}
}
