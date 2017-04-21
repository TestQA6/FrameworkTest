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
import pageObjects.ForgotPassword_Page;
import pageObjects.Login_Page;

public class ForgotPassword_Test {
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
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		ForgotPassword_Page.clickForgotPassword(driver);
		ForgotPassword_Page.isSendButtonEnabled(driver);
		ForgotPassword_Page.allButtonsEnabled(driver);
		ForgotPassword_Page.allButtonsEnabled(driver);
		ForgotPassword_Page.closeXbutton(driver);
		utility.Helpers.quit(driver);
	}

}
