package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helpers {
	
	public static void setup() throws InterruptedException {
		//BasicConfigurator.configure(); 
		//PropertyConfigurator.configure("D:\\log4j.properties");
		WebDriver driver;
		String baseUrl;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Anusha.D\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://172.16.0.113:8080/lge/#/login";
		driver.get(baseUrl);
	}
	
	public static void quit(WebDriver driver){
		driver.quit();
	}


}
