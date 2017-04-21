package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Helpers;

import com.gargoylesoftware.htmlunit.javascript.host.media.InputDeviceCapabilities;

public class SignUp_Page {
	public static WebElement element = null;

	public static WebElement signUPDongID(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//input[@placeholder='Dong name'][contains(@uib-typeahead,'lotName for lotName in filteredLotNames')][contains(@ng-model,'signupData')]"));
		return element;
	}
	
	public static WebElement signUPName(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//input[contains(@ng-model,'signupData')][@placeholder='Name']"));
		return element;
	}
	
	public static WebElement signUPInputpassword(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//input[contains(@ng-model,'signupData')][@placeholder='At least 6 digits.']"));
		return element;
	}
	
	public static WebElement signUPConfirmpassword(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//input[contains(@ng-model,'signupData')][@placeholder='Confirm password']"));
		return element;
	}
	
	public static WebElement signUPVerify(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//div[@class='verify-btn']//button[text()='Verify'][contains(@ng-click,'phoneNumber.phoneNumber')]"));
		return element;
	}

	public static WebElement signUPOK(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//div[@class='verify-btn']//button[text()='OK'][contains(@ng-click,'verifyOtp(phoneNumber)')]"));
		return element;
	}
	
	public static void clickSignUp(WebDriver driver) {
		driver.findElement(By.xpath("//button[text()='Application for sign-up']")).click();
	}
	
	public static void clickApply(WebDriver driver){
		//WebElement element = driver.findElement(By.xpath("//button[text()='Apply']"));
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='doSignup()']"))).click();
		//driver.findElement(By.xpath("//button[@ng-click='doSignup()']")).click();
	}
	public static void closeXbutton(WebDriver driver) {
		driver.findElement(By.xpath("//div[@id='signupModal']//button[@class='close'][text()='×']")).click();		
	}
	
	public static void checkErrorMessages(WebDriver driver){
		clickApply(driver);	
		System.out.println(driver.findElement(By.xpath("//input[@placeholder='Dong name'][contains(@uib-typeahead,'lotName for lotName in filteredLotNames')][contains(@ng-model,'signupData')]/following-sibling::span")).getText());
		signUPDongID(driver).sendKeys("서초1동");
		clickApply(driver);	
		System.out.println(driver.findElement(By.xpath("//input[contains(@ng-model,'signupData')][@placeholder='Name']/following-sibling::span")).getText());
		signUPName(driver).sendKeys("Anusha");
		clickApply(driver);	
		System.out.println(driver.findElement(By.xpath("//input[contains(@ng-model,'signupData')][@placeholder='At least 6 digits.']/following-sibling::span")).getText()+"InputPassword");
		signUPInputpassword(driver).sendKeys("password1");
		clickApply(driver);	
		System.out.println(driver.findElement(By.xpath("//input[contains(@ng-model,'signupData')][@placeholder='Confirm password']/following-sibling::span")).getText()+"ConfirmPassword");
		signUPConfirmpassword(driver).sendKeys("password1s");
		clickApply(driver);	
		System.out.println(driver.findElement(By.xpath("//input[contains(@ng-model,'signupData')][@placeholder='Confirm password']/following-sibling::span")).getText());
		signUPConfirmpassword(driver).clear();
		signUPConfirmpassword(driver).sendKeys("password1");
	}
	
	
	
	
}
