package pageObjects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassword_Page {
	public static WebElement element = null;

	public static WebElement forgotPasswordDongID(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//input[@placeholder='Dong name'][contains(@uib-typeahead,'lotName for lotName in filteredLotNames')][contains(@ng-model,'forgotPwdData')]"));
		return element;
	}

	public static WebElement forgotPasswordName(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//input[contains(@ng-model,'forgotPwdData')][@placeholder='Name']"));
		return element;
	}

	public static WebElement forgotPasswordPhoneNum(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//input[contains(@ng-model,'forgotPwdData')][@placeholder='Mobile Phone Number']"));
		return element;
	}

	public static WebElement forgotPasswordVerify(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//div[@class='verify-btn']//button[text()='Verify'][contains(@ng-click,'forgotPwdData')]"));
		return element;
	}

	public static WebElement forgotPasswordVerificationNum(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//input[contains(@ng-model,'forgotPwdData')][@placeholder='Verification number']"));
		return element;
	}

	public static WebElement forgotPasswordOK(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//div[@class='verify-btn']//button[text()='OK'][contains(@ng-click,'forgotPwdData')]"));
		return element;
	}

	public static WebElement forgotPasswordSendButton(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-footer']//button[text()='Send a temporary password'][contains(@ng-click,'doForgotPwd')]"));
		return element;
	}

	public static void clickForgotPassword(WebDriver driver){
		driver.findElement(By.linkText("Do you happen to have forgotten your password?")).click();
	}

	public static void isSendButtonEnabled(WebDriver driver){
		if(forgotPasswordSendButton(driver).isEnabled())
			System.out.println("Send a temporary password button is enabled by default");
		else
			System.out.println("Send a temporary password button is disabled by default");
	}

	public static void allFieldsEmpty(WebDriver driver){
		if(!forgotPasswordDongID(driver).getText().isEmpty())
			System.out.println("Dong is not empty by default");
		else
			System.out.println("Dong is empty by default");

		if(!forgotPasswordName(driver).getText().isEmpty())
			System.out.println("Name is not empty by default");
		else
			System.out.println("Name is empty by default");

		if(!forgotPasswordPhoneNum(driver).getText().isEmpty())
			System.out.println("PhoneNumber is not empty by default");
		else
			System.out.println("PhoneNumber is empty by default");

		if(!forgotPasswordVerificationNum(driver).getText().isEmpty())
			System.out.println("VerificationNumber is not empty by default");
		else
			System.out.println("VerificationNumber is empty by default");
	}

	public static void allButtonsEnabled(WebDriver driver){
		if(forgotPasswordVerify(driver).isEnabled())
			System.out.println("Verify button is enabled by default");
		else
			System.out.println("Verify button is disabled by default");

		if(forgotPasswordOK(driver).isEnabled())
			System.out.println("OK button is enabled by default");
		else
			System.out.println("OK button is disabled by default");
	}

	public static void closeXbutton(WebDriver driver) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='forgoepwdModal']//button[@class='close'][text()='×']"))).click();		
	}
}
