package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.*;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.Helpers;
import pageObjects.Login_Page;

public class Login_Test {
	private WebDriver driver;
	private String baseUrl;
	String msg;
	//private String title="LGE Smart Parking";
	static Logger log = Logger.getLogger(Login_Test.class);
	public WebDriver getDriver() {
        return driver;
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
	BasicConfigurator.configure(); 
		PropertyConfigurator.configure("D:\\log4j.properties");	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Anusha.D\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		baseUrl = "http://172.16.0.113:8080/lge/#/login";
		driver.get(baseUrl);
			}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
	driver.quit();
	}
	

	@Test(groups = {"Regression"})
	public void test() throws InterruptedException {
		//Assert.assertEquals(driver.getTitle(),title);
		System.out.println("in test ");
		Login_Page.loginButtonCheck(driver);
		log.debug("hi");
		Login_Page.loginButtonCheck1(driver,"서초1동");
		Login_Page.password(driver).sendKeys("seop1234");
		Login_Page.clickLoginButton(driver);
		Login_Page.clickLogoutButton(driver);
		WebElement ele=null;
		try{
			ele= driver.findElement(By.linkText("Logout"));
		}
		catch(NoSuchElementException e){
		System.out.println(e.getMessage());		}
		Assert.assertTrue(ele!=null);	}
	
	@Test(groups = {"Negative"})
	public void test1() throws InterruptedException {
		//Assert.assertEquals(driver.getTitle(),title);		
		System.out.println("in test1 ");
		Login_Page.loginButtonCheck(driver);
		log.debug("hi");
		Login_Page.loginButtonCheck1(driver,"서초1동");
		Login_Page.password(driver).sendKeys("seop123");
		Login_Page.clickLoginButton(driver);
		WebElement ele=null;
		try{
			ele= driver.findElement(By.linkText("Logout"));
		}
		catch(NoSuchElementException e){
		System.out.println(e.getMessage());		}
		Assert.assertTrue(ele!=null);	}
	
	//@Test(groups = {"Regression"})
	public void test2() throws InterruptedException {
		//Assert.assertEquals(driver.getTitle(),title);		
		System.out.println("in test2 ");
		Login_Page.loginButtonCheck(driver);
		log.debug("hi");
		Login_Page.loginButtonCheck1(driver,"서초 관리자님");
		Login_Page.password(driver).sendKeys("sema1234");
		Login_Page.clickLoginButton(driver);
		Login_Page.clickLogoutButton(driver);
		WebElement ele=null;
		try{
			ele= driver.findElement(By.linkText("Logout"));
		}
		catch(NoSuchElementException e){
		System.out.println(e.getMessage());		}
		Assert.assertTrue(ele!=null);	}
	
	//@Test
	public void test3() throws InterruptedException {
		System.out.println("in test3 ");
		Login_Page.loginButtonCheck(driver);
		log.debug("hi");
		Login_Page.loginButtonCheck1(driver,"서초 관리자님");
		Login_Page.password(driver).sendKeys("sema123");
		Login_Page.clickLoginButton(driver);
		WebElement ele=null;
		try{
			ele= driver.findElement(By.linkText("Logout"));
		}
		catch(NoSuchElementException e){
		System.out.println(e.getMessage());		}
		Assert.assertTrue(ele!=null);
		driver.quit();
	}
	
	public void takeScreenShot(){	
		try {
		String directory= "D:\\";
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmmss");
		String filename = "Scr_"+sdf.format(new Date())+ ".png";
		System.out.println(filename);
		File screenshoot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
			FileUtils.copyFile(screenshoot, (new File(directory+filename)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
		/* public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		String fileName = getRandomString(10) + ".png";
		String directory = "D:\\";		
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		driver.quit();
	}*/
	}
}



