package Hallyal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import HallyalAbstractComponents.AbstractClass;

public class LoginPage extends AbstractClass{

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void openPage(String url) {

		driver.get(url);
	}

	public void enterUserName(String userName) {
		driver.findElement(By.id("userEmail")).sendKeys(userName);
	}

	public void enterPassword(String password) {
		driver.findElement(By.id("userPassword")).sendKeys(password);
	}

	public void clickSubmit() {
		driver.findElement(By.id("login")).click();
	}

}
