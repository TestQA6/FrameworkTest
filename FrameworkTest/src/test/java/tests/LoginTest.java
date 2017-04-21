package tests;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginTest {
	private WebDriver driver;
	private String baseUrl;
	//private String title="LGE Smart Parking";
	final static Logger logger = Logger.getLogger(LoginTest.class);

	@BeforeClass
	public void setup() throws InterruptedException {
		BasicConfigurator.configure(); 
		PropertyConfigurator.configure("C:\\Users\\Anusha.D\\workspace\\FrameworkTest\\src\\test\\java\\property\\log4j.properties");	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Anusha.D\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://172.16.0.113:8080/lge/#/login";
		driver.get(baseUrl);
		logger.info("setup is done");
	}

	@Test
	public void test() throws InterruptedException {
		//Assert.assertEquals(driver.getTitle(),title);			
		LoginPage.dongName(driver).sendKeys("서초1동");
		logger.info("entered dong name");
		LoginPage.password(driver).sendKeys("seop1234");
		logger.info("entered password");
		LoginPage.clickLoginButton(driver);
		logger.info("clicked login button");
		driver.quit();
	}
	
	
}
