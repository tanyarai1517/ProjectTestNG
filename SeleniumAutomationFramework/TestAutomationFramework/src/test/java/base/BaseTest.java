package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public Properties prop = new Properties();
	public Properties loc = new Properties();
	public FileReader fr;
	public FileReader fr1;
	
	@BeforeMethod
public void setup() throws IOException {
	if(driver==null) {
		FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
		FileReader fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\Locators.properties");
 	prop.load(fr);
 	loc.load(fr1);
 	
	}
	if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("testurl"));
		
	}
	else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get(prop.getProperty("testurl"));
	}
}
	@AfterMethod
public void tearDown() {
	driver.close();
	System.out.println("teardown successfull");
	
}
}
