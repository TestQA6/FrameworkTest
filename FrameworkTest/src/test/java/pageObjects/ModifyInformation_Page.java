package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModifyInformation_Page {
	public static WebElement element = null;
	
	public static void clickModifyInfo(WebDriver driver){
		driver.findElement(By.linkText("Modify Information")).click();;
	}
	
	public static WebElement currentPassword(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//input[contains(@ng-model,'changeInfoData')][@placeholder='Password']"));
		return element;
	}
	
	public static WebElement newPassword(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//input[contains(@ng-model,'changeInfoData')][@placeholder='At least 6 digits.']"));
		return element;
	}
	
	public static WebElement confirmPassword(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//input[contains(@ng-model,'changeInfoData')][@placeholder='Confirm password']"));
		return element;
	}
	
	public static void clickModifyButton(WebDriver driver){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@ng-click,'changeInfo')][text()='Modify']"))).click();
	}
	
	public static void checkErrorMessages(WebDriver driver){
		clickModifyButton(driver);		
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[1]/span[1]")).getText());
		currentPassword(driver).sendKeys("seop12");
		clickModifyButton(driver);		
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[2]/span")).getText());
		newPassword(driver).sendKeys("seop123");
		clickModifyButton(driver);		
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[3]/span")).getText());
		confirmPassword(driver).sendKeys("seop123");
		clickModifyButton(driver);		
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div[1]/span[1]")).getText());

	}

}
 