package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
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

	public static void clickLoginButton(WebDriver driver){
		loginButton(driver).click();
	}
	
	public static void clickLogoutButton(WebDriver driver){
		logoutButton(driver).click();
	}
}
