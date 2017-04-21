package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.host.media.InputDeviceCapabilities;

public class Login_Page {
	public static WebElement element = null;

	public static WebElement dongName(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//input[@placeholder='Dong name'][contains(@uib-typeahead,'loginLotNames')]"));
		return element;
	}

	public static void inputDongId(WebDriver driver,String dongID){
		WebElement dongElement = dongName(driver);
		dongElement.clear();
		dongElement.click();
		dongElement.sendKeys(dongID);
	}

	public static WebElement password(WebDriver driver){
		element = driver.findElement(By.id("inputPassword"));	
		return element;
	}

	public static WebElement loginButton(WebDriver driver){
		element = driver.findElement(By.xpath("//*[contains(text(), 'Login')]"));
		return element;
	}
	public static WebElement logoutButton(WebDriver driver){
		element = driver.findElement(By.linkText("Logout"));
		return element;
	}
	public static WebElement loginButtonDisabled(WebDriver driver){
		element = driver.findElement(By.xpath("//button[@disabled='disabled'][@ng-click='doLogin()']"));
		return element;
	}

	public static WebElement resetPassword(WebDriver driver){
		element = driver.findElement(By.linkText("Do you happen to have forgotten your password?"));
		return element;
	}

	public static WebElement signUp(WebDriver driver){
		element = driver.findElement(By.xpath("//button[@alt='Signup']"));
		return element;
	}

	public static void loginButtonCheck(WebDriver driver){
		if(!Login_Page.loginButtonDisabled(driver).isEnabled()){
			System.out.println("login button is disabled without dong and password");
		}
		else
			System.out.println("login button is disabled without dong and password"+"button is enabled");
	}

	public static void loginButtonCheck1(WebDriver driver,String dongID){
		dongName(driver);	
		inputDongId(driver, dongID);
		if(!Login_Page.loginButtonDisabled(driver).isEnabled()){
			System.out.println("login button is disabled without password");
		}
		else
			System.out.println("login button is disabled without password"+"button is enabled");
	}

	public static void loginButtonCheck2(WebDriver driver){
		dongName(driver).clear();
		password(driver).sendKeys("hi");
		if(!Login_Page.loginButtonDisabled(driver).isEnabled()){
			System.out.println("login button is disabled without dong");
		}
		else
			System.out.println("login button is disabled without dong"+"button is enabled");		
	}

	public static void clickLoginButton(WebDriver driver){
		loginButton(driver).click();
	}
	public static void clickLogoutButton(WebDriver driver){
		logoutButton(driver).click();
	}
}
