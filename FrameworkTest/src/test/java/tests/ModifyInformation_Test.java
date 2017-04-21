package tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import utility.Helpers;
import pageObjects.Login_Page;
import pageObjects.ModifyInformation_Page;
import pageObjects.SignUp_Page;

public class ModifyInformation_Test {
	private WebDriver driver;
	private String baseUrl;
	//private String title="LGE Smart Parking";
	//static Logger log = Logger.getLogger(Login_Test.class);
	
	@Before
	public void setup() throws InterruptedException {
		//BasicConfigurator.configure(); 
		//PropertyConfigurator.configure("D:\\log4j.properties");	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Anusha.D\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://172.16.0.113:8080/lge/#/login";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		Login_Page.inputDongId(driver, "서초1동");
		Login_Page.password(driver).sendKeys("seop123");
		Login_Page.loginButton(driver).click();
		ModifyInformation_Page.clickModifyInfo(driver);
		ModifyInformation_Page.checkErrorMessages(driver);
	}

}
