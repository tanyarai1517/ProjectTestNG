package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSData;

public class FirstTest extends BaseTest {

	@Test(dataProviderClass=ReadXLSData.class,dataProvider="bvtdata")

public void LoginTest(String username, String password) throws InterruptedException
{
	Thread.sleep(3000);
driver.findElement(By.linkText(loc.getProperty("SignIn"))).click();
Thread.sleep(1000);
driver.findElement(By.xpath(loc.getProperty("EmailField"))).sendKeys(username);
driver.findElement(By.xpath(loc.getProperty("NextButton"))).click();
Thread.sleep(1000);
driver.findElement(By.xpath(loc.getProperty("PasswordField"))).sendKeys(password);
Thread.sleep(1000);
driver.findElement(By.xpath(loc.getProperty("LoginNextButton"))).click();
Thread.sleep(1000);

}

//@DataProvider(name = "testdata")
//public Object[][] testData() {
// return new Object[][] {
//   { "eee.hmritm2022@gmail.com", "Tanya@151798" },
//   { "eee.hmritm2020@gmail.com", "Tanya@151798" }
// };
//}
}
